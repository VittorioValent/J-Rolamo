#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.dto;

import it.contrader.jrolamo.generics.domain.AbstractDTO;
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

	private Long id;

	private String name;
}
