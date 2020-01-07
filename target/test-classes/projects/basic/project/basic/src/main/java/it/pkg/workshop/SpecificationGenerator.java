package it.pkg.workshop;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.lang.model.element.Modifier;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.CodeBlock;
import com.squareup.javapoet.FieldSpec;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.ParameterizedTypeName;
import com.squareup.javapoet.TypeName;
import com.squareup.javapoet.TypeSpec;
import com.squareup.javapoet.WildcardTypeName;

import it.pkg.domain.generic.EntitySpecification;
import it.pkg.workshop.utils.FieldInfo;
import it.pkg.workshop.utils.GeneratorUtils;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Vittorio Valent
 *
 */
public class SpecificationGenerator {

	protected static void generateSpecificationClass(String entityName, List<FieldInfo> fields) throws IOException {
		FieldSpec serialVersionUID = FieldSpec.builder(long.class, "serialVersionUID")
				.addModifiers(Modifier.PRIVATE, Modifier.STATIC, Modifier.FINAL)
				.initializer("$L", 1L)
				.build();

		ClassName predicate = ClassName.get(Predicate.class);
		ClassName list = ClassName.get(List.class);
		ClassName arrayList = ClassName.get(ArrayList.class);
		TypeName listOfPredicates = ParameterizedTypeName.get(list, predicate);

		TypeName wildcard = WildcardTypeName.subtypeOf(Object.class);
		TypeName cq = ParameterizedTypeName.get(
				ClassName.get(CriteriaQuery.class), wildcard);
		List<CodeBlock> filterList = new ArrayList<>();

		for (FieldInfo fieldInfo : fields) {
			CodeBlock additionalFilter = CodeBlock.builder()
					.beginControlFlow(
							"if (filter.get" + GeneratorUtils.capitalize(fieldInfo.getName()) + "() != null) ")
					.addStatement("p.add(cb.equal(r.get(\"" + fieldInfo.getName() + "\"), filter.get"
							+ GeneratorUtils.capitalize(fieldInfo.getName()) + "()))")
					.endControlFlow()
					.build();
			filterList.add(additionalFilter);
		}
		CodeBlock additionalFilters = CodeBlock.join(filterList, "\n");

		MethodSpec toPredicate = MethodSpec.methodBuilder("toPredicate")
				.addModifiers(Modifier.PUBLIC)
				.addAnnotation(Override.class)
				.returns(Predicate.class)
				.addParameter(ParameterizedTypeName.get(ClassName.get(Root.class),
						ClassName.get(GeneratorUtils.ENTITY_PACKAGE, entityName)), "r")
				.addParameter(cq, "q")
				.addParameter(CriteriaBuilder.class, "cb")
				.addStatement("$T p = new $T<>()", listOfPredicates, arrayList)
				.beginControlFlow("if (filter.getId() != null) ")
				.addStatement("p.add(cb.equal(r.get(\"id\"), filter.getId()))")
				.endControlFlow()
				.addCode(additionalFilters)
				.addStatement("return q.where(cb.and(p.toArray(new Predicate[0]))).distinct(true).getRestriction()")
				.build();

		TypeSpec specificationClass = TypeSpec.classBuilder(entityName + "Specification")
				.addModifiers(Modifier.PUBLIC)
				.addAnnotation(Setter.class)
				.addAnnotation(Getter.class)
				.addAnnotation(AllArgsConstructor.class)
				.superclass(ParameterizedTypeName.get(ClassName.get(EntitySpecification.class),
						ClassName.get(GeneratorUtils.ENTITY_PACKAGE, entityName)))
				.addField(serialVersionUID)
				.addMethod(toPredicate)
				.addJavadoc(CodeBlock
						.builder()
						.add("@author Automatic Code Generator")
						.build())
				.build();

		JavaFile javaFile = JavaFile.builder(GeneratorUtils.FILTER_PACKAGE, specificationClass)
				.indent("	")
				.build();

		GeneratorUtils.save(javaFile);
	}
}
