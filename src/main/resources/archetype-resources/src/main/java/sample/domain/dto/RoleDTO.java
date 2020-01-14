#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.sample.domain.dto;

import lombok.Data;

/**
 * @author Vittorio Valent
 *
 */
@Data
public class RoleDTO {

	private Long id;

	private String name;
}
