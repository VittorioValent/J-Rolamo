#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.workshop;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.lang.model.element.Modifier;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.squareup.javapoet.AnnotationSpec;
import com.squareup.javapoet.CodeBlock;
import com.squareup.javapoet.FieldSpec;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.TypeSpec;

import ${package}.domain.generic.AuditModel;
import ${package}.workshop.domain.FieldInfo;
import ${package}.workshop.utils.GeneratorUtils;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author Vittorio Valent
 * @since 1.0
 *
 */
public class EntityGenerator {

	protected static void generateEntityClass(String entityName, List<FieldInfo> fields, Boolean auditable)
			throws IOException {

		FieldSpec id = FieldSpec.builder(Long.class, "id")
				.addModifiers(Modifier.PRIVATE)
				.addAnnotation(Id.class)
				.addAnnotation(AnnotationSpec.builder(GeneratedValue.class)
						.addMember("strategy", "${symbol_dollar}T.IDENTITY", GenerationType.class)
						.build())
				.build();

		FieldSpec serialVersionUID = FieldSpec.builder(long.class, "serialVersionUID")
				.addModifiers(Modifier.PRIVATE, Modifier.STATIC, Modifier.FINAL)
				.initializer("${symbol_dollar}L", 1L)
				.build();
		List<FieldSpec> fieldSpecs = new ArrayList<>();

		for (FieldInfo fieldInfo : fields) {
			FieldSpec fieldSpec = FieldSpec
					.builder(fieldInfo.getType(GeneratorUtils.ENTITY_PACKAGE, ""), fieldInfo.getName())
					.addModifiers(Modifier.PRIVATE)
					.build();
			if (fieldInfo.getMappedEntity() != null) {
				fieldSpec = FieldSpec
						.builder(fieldInfo.getType(GeneratorUtils.ENTITY_PACKAGE, ""), fieldInfo.getName())
						.addModifiers(Modifier.PRIVATE)
						.addAnnotation(ManyToOne.class)
						.addAnnotation(JoinColumn.class)
						.build();;
			}
			fieldSpecs.add(fieldSpec);
		}
		TypeSpec entityClass = TypeSpec.classBuilder(entityName)
				.addModifiers(Modifier.PUBLIC)
				.addAnnotation(Entity.class)
				.addAnnotation(Data.class)
				.addAnnotation(Builder.class)
				.addAnnotation(AllArgsConstructor.class)
				.addAnnotation(NoArgsConstructor.class)
				.addAnnotation(AnnotationSpec.builder(EqualsAndHashCode.class)
						.addMember("callSuper", "${symbol_dollar}L", false)
						.build())
				.addField(id)
				.addField(serialVersionUID)
				.addFields(fieldSpecs)
				.addSuperinterface(Serializable.class)
				.addJavadoc(CodeBlock
						.builder()
						.add("@author Automatic Code Generator")
						.build())
				.build();
		if (auditable) {
			entityClass = TypeSpec.classBuilder(entityName)
					.addModifiers(Modifier.PUBLIC)
					.addAnnotation(Entity.class)
					.addAnnotation(Data.class)
					.addAnnotation(Builder.class)
					.addAnnotation(AllArgsConstructor.class)
					.addAnnotation(NoArgsConstructor.class)
					.addAnnotation(AnnotationSpec.builder(EqualsAndHashCode.class)
							.addMember("callSuper", "${symbol_dollar}L", false)
							.build())
					.addField(id)
					.addField(serialVersionUID)
					.addFields(fieldSpecs)
					.superclass(AuditModel.class)
					.addJavadoc(CodeBlock
							.builder()
							.add("@author Automatic Code Generator")
							.build())
					.build();
		}
		JavaFile javaFile = JavaFile.builder(GeneratorUtils.ENTITY_PACKAGE, entityClass)
				.indent("	")
				.build();

		GeneratorUtils.save(javaFile);
	}
}
