#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.sample.workshop;

import com.squareup.javapoet.AnnotationSpec;
import com.squareup.javapoet.CodeBlock;
import com.squareup.javapoet.FieldSpec;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.TypeSpec;
import ${package}.sample.domain.generic.AuditDTO;
import ${package}.sample.workshop.utils.FieldInfo;
import ${package}.sample.workshop.utils.GeneratorUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.lang.model.element.Modifier;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Vittorio Valent
 *
 */
public class DTOGenerator {

    protected static void generateDTOClass(String entityName, List<FieldInfo> fields, Boolean auditable) throws IOException {
        FieldSpec id = FieldSpec.builder(Long.class, "id")
                .addModifiers(Modifier.PRIVATE)
                .build();

        List<FieldSpec> fieldSpecs = new ArrayList<>();

        for (FieldInfo fieldInfo : fields) {
            FieldSpec fieldSpec = FieldSpec
                    .builder(fieldInfo.getType(GeneratorUtils.DTO_PACKAGE, "DTO"), fieldInfo.getName())
                    .addModifiers(Modifier.PRIVATE)
                    .build();
            fieldSpecs.add(fieldSpec);
        }

        TypeSpec dtoClass = TypeSpec.classBuilder(entityName + "DTO")
                .addModifiers(Modifier.PUBLIC)
                .addField(id)
                .addFields(fieldSpecs)
                .addAnnotation(Data.class)
                .addAnnotation(AnnotationSpec.builder(EqualsAndHashCode.class)
                        .addMember("callSuper", "${symbol_dollar}L", false)
                        .build())
                .addJavadoc(CodeBlock
                        .builder()
                        .add("@author Automatic Code Generator")
                        .build())
                .build();

        if (auditable) {
            dtoClass = TypeSpec.classBuilder(entityName + "DTO")
                    .addModifiers(Modifier.PUBLIC)
                    .addField(id)
                    .addFields(fieldSpecs)
                    .addAnnotation(Data.class)
                    .addAnnotation(AnnotationSpec.builder(EqualsAndHashCode.class)
                            .addMember("callSuper", "${symbol_dollar}L", false)
                            .build())
                    .superclass(AuditDTO.class)
                    .addJavadoc(CodeBlock
                            .builder()
                            .add("@author Automatic Code Generator")
                            .build())
                    .build();
        }

        JavaFile javaFile = JavaFile.builder(GeneratorUtils.DTO_PACKAGE, dtoClass)
                .indent("	")
                .build();

        GeneratorUtils.save(javaFile);
    }
}
