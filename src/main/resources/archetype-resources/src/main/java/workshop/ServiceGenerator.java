#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.workshop;

import java.io.IOException;

import javax.lang.model.element.Modifier;

import org.springframework.stereotype.Service;

import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.CodeBlock;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.ParameterizedTypeName;
import com.squareup.javapoet.TypeSpec;

import ${package}.service.generic.PrivateService;
import ${package}.service.generic.ProtectedService;
import ${package}.service.generic.PublicService;
import ${package}.workshop.utils.GeneratorUtils;
import ${package}.workshop.utils.ServiceTypeEnum;

/**
 * @author Vittorio Valent
 * @since 1.0
 *
 */
public class ServiceGenerator {

	protected static void generateServiceClass(String entityName, ServiceTypeEnum serviceType) throws IOException {
		TypeSpec serviceClass = null;
		switch (serviceType) {
			case PUBLIC :
				serviceClass = TypeSpec.classBuilder(entityName + "Service")
						.addModifiers(Modifier.PUBLIC)
						.addAnnotation(Service.class)
						.superclass(ParameterizedTypeName.get(ClassName.get(PublicService.class),
								ClassName.get(GeneratorUtils.ENTITY_PACKAGE, entityName),
								ClassName.get(GeneratorUtils.DTO_PACKAGE, entityName + "DTO")))
						.addJavadoc(CodeBlock
								.builder()
								.add("@author Automatic Code Generator")
								.build())
						.build();
				break;
			case PROTECTED :
				serviceClass = TypeSpec.classBuilder(entityName + "Service")
						.addModifiers(Modifier.PUBLIC)
						.addAnnotation(Service.class)
						.superclass(ParameterizedTypeName.get(ClassName.get(ProtectedService.class),
								ClassName.get(GeneratorUtils.ENTITY_PACKAGE, entityName),
								ClassName.get(GeneratorUtils.DTO_PACKAGE, entityName + "DTO")))
						.addJavadoc(CodeBlock
								.builder()
								.add("@author Automatic Code Generator")
								.build())
						.build();
				break;
			case PRIVATE :
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
				break;

		}

		JavaFile javaFile = JavaFile.builder(GeneratorUtils.SERVICE_PACKAGE, serviceClass)
				.indent("	")
				.build();

		GeneratorUtils.save(javaFile);
	}
}
