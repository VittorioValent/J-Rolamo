#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.sample.workshop;

import ${package}.sample.workshop.utils.EntityInfo;
import ${package}.sample.workshop.utils.ServiceTypeEnum;
import java.io.IOException;

/**
 * @author Vittorio Valent
 *
 */
public class CodeGenerator {

    /**
     *
     * @param entityInfo
     */
    public static void generateEntityFlow(EntityInfo entityInfo) {
        try {
            Boolean auditable = entityInfo.getAuditable();
            if (!entityInfo.getSerivceType().equals(ServiceTypeEnum.PUBLIC)) {
                auditable = true;
            }
            EntityGenerator.generateEntityClass(entityInfo.getEntityName(), entityInfo.getFields(), auditable);
            DTOGenerator.generateDTOClass(entityInfo.getEntityName(), entityInfo.getFields(), auditable);
            SpecificationGenerator.generateSpecificationClass(entityInfo.getEntityName(), entityInfo.getFields());
            RepositoryGenerator.generateRepositoryInterface(entityInfo.getEntityName(), entityInfo.getSerivceType());
            MapperGenerator.generateMapperInterface(entityInfo.getEntityName());
            ServiceGenerator.generateServiceClass(entityInfo.getEntityName(), entityInfo.getSerivceType());
            ControllerGenerator.generateControllerClass(entityInfo.getEntityName(), entityInfo.getControllerType(), entityInfo.getSerivceType());
        } catch (IOException e) {
            System.out.println("Impossible to generate required code ${symbol_escape}n");
            e.printStackTrace();
        }
    }
}
