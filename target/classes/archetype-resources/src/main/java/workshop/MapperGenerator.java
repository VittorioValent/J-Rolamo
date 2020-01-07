#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.workshop;

import java.io.IOException;

import javax.lang.model.element.Modifier;

import org.mapstruct.Mapper;

import com.squareup.javapoet.AnnotationSpec;
import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.CodeBlock;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.ParameterizedTypeName;
import com.squareup.javapoet.TypeSpec;

import ${package}.service.mapper.generic.IMapper;
import ${package}.workshop.utils.GeneratorUtils;

/**
 * @author Vittorio Valent
 *
 */
public class MapperGenerator {

	protected static void generateMapperInterface(String entityName) throws IOException {
		TypeSpec mapperInterface = TypeSpec.interfaceBuilder(entityName + "Mapper")
				.addModifiers(Modifier.PUBLIC)
				.addAnnotation(AnnotationSpec.builder(Mapper.class)
						.addMember("componentModel", "${symbol_dollar}S", "spring")
						.build())
				.addSuperinterface(ParameterizedTypeName.get(ClassName.get(IMapper.class),
						ClassName.get(GeneratorUtils.ENTITY_PACKAGE, entityName),
						ClassName.get(GeneratorUtils.DTO_PACKAGE, entityName + "DTO")))
				.addJavadoc(CodeBlock
						.builder()
						.add("@author Automatic Code Generator")
						.build())
				.build();

		JavaFile javaFile = JavaFile.builder(GeneratorUtils.MAPPER_PACKAGE, mapperInterface)
				.indent("	")
				.build();

		GeneratorUtils.save(javaFile);
	}
}
