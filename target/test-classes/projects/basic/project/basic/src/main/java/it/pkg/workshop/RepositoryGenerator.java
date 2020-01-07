package it.pkg.workshop;

import java.io.IOException;

import javax.lang.model.element.Modifier;

import org.springframework.stereotype.Repository;

import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.CodeBlock;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.ParameterizedTypeName;
import com.squareup.javapoet.TypeSpec;

import it.pkg.repository.generic.IPrivateRepository;
import it.pkg.repository.generic.IRepository;
import it.pkg.workshop.utils.GeneratorUtils;

/**
 * @author Vittorio Valent
 *
 */
public class RepositoryGenerator {

	protected static void generateRepositoryInterface(String entityName, Boolean auditable) throws IOException {
		TypeSpec repositoryInterface = TypeSpec.interfaceBuilder(entityName + "Repository")
				.addModifiers(Modifier.PUBLIC)
				.addAnnotation(Repository.class)
				.addSuperinterface(ParameterizedTypeName.get(ClassName.get(IRepository.class),
						ClassName.get(GeneratorUtils.ENTITY_PACKAGE, entityName)))
				.addJavadoc(CodeBlock
						.builder()
						.add("@author Automatic Code Generator")
						.build())
				.build();
		if (auditable) {
			repositoryInterface = TypeSpec.interfaceBuilder(entityName + "Repository")
					.addModifiers(Modifier.PUBLIC)
					.addAnnotation(Repository.class)
					.addSuperinterface(ParameterizedTypeName.get(ClassName.get(IPrivateRepository.class),
							ClassName.get(GeneratorUtils.ENTITY_PACKAGE, entityName)))
					.addJavadoc(CodeBlock
							.builder()
							.add("@author Automatic Code Generator")
							.build())
					.build();
		}

		JavaFile javaFile = JavaFile.builder(GeneratorUtils.REPOSITORY_PACKAGE, repositoryInterface)
				.indent("	")
				.build();

		GeneratorUtils.save(javaFile);
	}
}
