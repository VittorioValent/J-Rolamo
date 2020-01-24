#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.workshop.utils;

/**
 *
 * @author Vittorio Andreoni
 * @since 1.0
 */
public enum ControllerTypeEnum {

	READ("READ"), CRUD("CRUD");

	private String controllerType;

	ControllerTypeEnum(String controllerType) {
		this.controllerType = controllerType;
	}

	public String getControllerType() {
		return controllerType;
	}

}
