#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.dto;

import it.jrolamo.generics.domain.AuditDTO;
import javax.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author JRolamo
 *
 * @since 1.0
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class UserDTO extends AuditDTO {

	private Long id;

	@NotEmpty(message = "{UserDTO.username.NotEmpty}")
	private String username;

	@NotEmpty(message = "{UserDTO.password.NotEmpty}")
	private String password;

	private RoleDTO role;

	private Boolean accountNonExpired = Boolean.TRUE;

	private Boolean credentialsNonExpired = Boolean.TRUE;

	private Boolean accountNonLocked = Boolean.TRUE;

	private Boolean enabled = Boolean.TRUE;

	private String name;

	private String surname;

}
