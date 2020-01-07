package it.pkg.workshop;

import java.io.IOException;

import javax.lang.model.element.Modifier;

import org.springframework.stereotype.Service;

import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.CodeBlock;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.ParameterizedTypeName;
import com.squareup.javapoet.TypeSpec;

import it.pkg.service.generic.AbstractService;
import it.pkg.service.generic.PrivateService;
import it.pkg.workshop.utils.GeneratorUtils;

/**
 * @author Vittorio Valent
 *
 */
public class ServiceGenerator {

	protected static void generateServiceClass(String entityName, Boolean auditable) throws IOException {
		TypeSpec serviceClass = TypeSpec.classBuilder(entityName + "Service")
				.addModifiers(Modifier.PUBLIC)
				.addAnnotation(Service.class)
				.superclass(ParameterizedTypeName.get(ClassName.get(AbstractService.class),
						ClassName.get(GeneratorUtils.ENTITY_PACKAGE, entityName),
						ClassName.get(GeneratorUtils.DTO_PACKAGE, entityName + "DTO")))
				.addJavadoc(CodeBlock
						.builder()
						.add("@author Automatic Code Generator")
						.build())
				.build();

		if (auditable) {
			serviceClass = TypeSpec.classBuilder(entityName + "Service")
					.addModifiers(Modifier.PUBLIC)
					.addAnnotation(Service.class)
					.superclass(ParameterizedTypeName.get(ClassName.get(PrivateService.class),
							ClassName.get(GeneratorUtils.ENTITY_PACKAGE, entityName),
							ClassName.get(GeneratorUtils.DTO_PACKAGE, entityName + "DTO")))
					.addJavadoc(CodeBlock
							.builder()
							.add("@author Automatic Code Generator")
							.build())
					.build();
		}

		JavaFile javaFile = JavaFile.builder(GeneratorUtils.SERVICE_PACKAGE, serviceClass)
				.indent("	")
				.build();

		GeneratorUtils.save(javaFile);
	}
}
