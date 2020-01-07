#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.workshop;

import java.io.IOException;

import ${package}.workshop.utils.EntityInfo;

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
			EntityGenerator.generateEntityClass(entityInfo.getEntityName(),
					entityInfo.getFields(),
					entityInfo.getAuditable());
			DTOGenerator.generateDTOClass(entityInfo.getEntityName(),
					entityInfo.getFields(), entityInfo.getAuditable());
			SpecificationGenerator.generateSpecificationClass(entityInfo.getEntityName(),
					entityInfo.getFields());
			RepositoryGenerator.generateRepositoryInterface(entityInfo.getEntityName(),
					entityInfo.getAuditable());
			MapperGenerator.generateMapperInterface(entityInfo.getEntityName());
			ServiceGenerator.generateServiceClass(entityInfo.getEntityName(),
					entityInfo.getAuditable());
			ControllerGenerator.generateControllerClass(entityInfo.getEntityName(),
					entityInfo.getAuditable());
		} catch (IOException e) {
			System.out.println("Impossible to generate required code ${symbol_escape}n");
			e.printStackTrace();
		}
	}
}
