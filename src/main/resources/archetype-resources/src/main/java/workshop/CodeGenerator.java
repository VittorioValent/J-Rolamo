#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.workshop;

import java.io.IOException;

import ${package}.workshop.domain.EntityInfo;
import ${package}.workshop.utils.ServiceTypeEnum;

/**
 * @author Vittorio Valent
 * @since 1.0
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
			if (!entityInfo.getServiceType().equals(ServiceTypeEnum.PUBLIC)) {
				auditable = true;
			}
			EntityGenerator.generateEntityClass(entityInfo.getEntityName(), entityInfo.getFields(), auditable);
			DTOGenerator.generateDTOClass(entityInfo.getEntityName(), entityInfo.getFields(), auditable);
			SpecificationGenerator.generateSpecificationClass(entityInfo.getEntityName(), entityInfo.getFields());
			RepositoryGenerator.generateRepositoryInterface(entityInfo.getEntityName(), entityInfo.getServiceType());
			MapperGenerator.generateMapperInterface(entityInfo.getEntityName());
			ServiceGenerator.generateServiceClass(entityInfo.getEntityName(), entityInfo.getServiceType());
			ControllerGenerator.generateControllerClass(entityInfo.getEntityName(), entityInfo.getControllerType(),
					entityInfo.getServiceType());
		} catch (IOException e) {
			System.out.println("Impossible to generate required code ${symbol_escape}n");
			e.printStackTrace();
		}
	}
}
