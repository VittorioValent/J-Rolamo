#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.workshop;

import com.squareup.javapoet.AnnotationSpec;
import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.CodeBlock;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.ParameterSpec;
import com.squareup.javapoet.ParameterizedTypeName;
import com.squareup.javapoet.TypeSpec;
import ${package}.controller.generic.CrudController;
import ${package}.workshop.utils.GeneratorUtils;
import java.io.IOException;
import javax.lang.model.element.Modifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Vittorio Valent
 *
 */
public class ControllerGenerator {

    protected static void generateControllerClass(String entityName, Boolean auditable) throws IOException {
        ParameterSpec predicate = ParameterSpec.builder(com.querydsl.core.types.Predicate.class, "predicate")
                .addAnnotation(AnnotationSpec.builder(QuerydslPredicate.class)
                        .addMember("root", "${symbol_dollar}T.class", ClassName.get(GeneratorUtils.ENTITY_PACKAGE, entityName))
                        .addMember("bindings", "${symbol_dollar}T.class",
                                ClassName.get(GeneratorUtils.REPOSITORY_PACKAGE, entityName + "Repository"))
                        .build())
                .build();
        ParameterSpec pageSize = ParameterSpec.builder(Integer.class, "pageNumber")
                .addAnnotation(AnnotationSpec.builder(RequestParam.class)
                        .addMember("defaultValue", "${symbol_dollar}S", "0")
                        .build())
                .build();
        ParameterSpec pageNumber = ParameterSpec.builder(Integer.class, "pageSize")
                .addAnnotation(AnnotationSpec.builder(RequestParam.class)
                        .addMember("defaultValue", "${symbol_dollar}S", "20")
                        .build())
                .build();
        ParameterSpec direction = ParameterSpec.builder(Direction.class, "direction")
                .addAnnotation(AnnotationSpec.builder(RequestParam.class)
                        .addMember("defaultValue", "${symbol_dollar}S", "ASC")
                        .build())
                .build();
        ParameterSpec sortField = ParameterSpec.builder(String.class, "sortField")
                .addAnnotation(AnnotationSpec.builder(RequestParam.class)
                        .addMember("defaultValue", "${symbol_dollar}S", "id")
                        .build())
                .build();

        MethodSpec getAll = MethodSpec.methodBuilder("getAll")
                .addModifiers(Modifier.PUBLIC)
                .addAnnotation(Override.class)
                .returns(ParameterizedTypeName.get(ClassName.get(Page.class),
                        ClassName.get(GeneratorUtils.DTO_PACKAGE, entityName + "DTO")))
                .addParameter(predicate)
                .addParameter(pageNumber)
                .addParameter(pageSize)
                .addParameter(direction)
                .addParameter(sortField)
                .addStatement(
                        "return service.getAll(predicate, ${symbol_dollar}T.of(pageNumber, pageSize, direction, sortField))",
                        PageRequest.class)
                .build();

        TypeSpec controllerClass = TypeSpec.classBuilder(entityName + "Controller")
                .addModifiers(Modifier.PUBLIC)
                .addAnnotation(RestController.class)
                .addAnnotation(CrossOrigin.class)
                .addAnnotation(AnnotationSpec.builder(RequestMapping.class)
                        .addMember("value", "${symbol_dollar}S", "/api/public/" + entityName.toLowerCase())
                        .build())
                .superclass(ParameterizedTypeName.get(ClassName.get(CrudController.class),
                        ClassName.get(GeneratorUtils.DTO_PACKAGE, entityName + "DTO")))
                .addMethod(getAll)
                .addJavadoc(CodeBlock
                        .builder()
                        .add("@author Automatic Code Generator")
                        .build())
                .build();

        if (auditable) {
            controllerClass = TypeSpec.classBuilder(entityName + "Controller")
                    .addModifiers(Modifier.PUBLIC)
                    .addAnnotation(RestController.class)
                    .addAnnotation(CrossOrigin.class)
                    .addAnnotation(AnnotationSpec.builder(RequestMapping.class)
                            .addMember("value", "${symbol_dollar}S", "/api/" + entityName.toLowerCase())
                            .build())
                    .superclass(ParameterizedTypeName.get(ClassName.get(CrudController.class),
                            ClassName.get(GeneratorUtils.DTO_PACKAGE, entityName + "DTO")))
                    .addMethod(getAll)
                    .addJavadoc(CodeBlock
                            .builder()
                            .add("@author Automatic Code Generator")
                            .build())
                    .build();
        }

        JavaFile javaFile = JavaFile.builder(GeneratorUtils.CONTROLLER_PACKAGE, controllerClass)
                .indent("	")
                .build();

        GeneratorUtils.save(javaFile);
    }
}
