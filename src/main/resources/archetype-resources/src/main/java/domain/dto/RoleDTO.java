#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.domain.dto;

import ${package}.domain.generic.AbstractDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author JRolamo
 *
 * @since 1.0
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class RoleDTO extends AbstractDTO {

	private static final long serialVersionUID = -1774919811088884074L;

	private Long id;

	private String name;
}
