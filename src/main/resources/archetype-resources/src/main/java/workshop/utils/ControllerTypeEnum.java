#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.workshop.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 *
 * @author Vittorio Andreoni
 * @since 1.0
 */
@Getter
@AllArgsConstructor
public enum ControllerTypeEnum {

	READ("READ", 0), CRUD("CRUD", 1);

	private String controllerType;

	private Integer id;

}
