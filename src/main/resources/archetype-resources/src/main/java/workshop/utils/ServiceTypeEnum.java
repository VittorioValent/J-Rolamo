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
public enum ServiceTypeEnum {

	PUBLIC("PUBLIC", 0), PROTECTED("PUBLIC", 1), PRIVATE("PUBLIC", 2);

	private String serviceType;

	private Integer id;
}
