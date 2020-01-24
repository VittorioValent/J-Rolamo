#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.workshop.utils;

/**
 *
 * @author Vittorio Andreoni
 * @since 1.0
 */
public enum ServiceTypeEnum {

	PUBLIC("PUBLIC"), PROTECTED("PUBLIC"), PRIVATE("PUBLIC");

	private String serviceType;

	ServiceTypeEnum(String serviceType) {
		this.serviceType = serviceType;
	}

	public String getServiceType() {
		return serviceType;
	}
}
