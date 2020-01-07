#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.domain.dto;

import javax.validation.constraints.NotEmpty;

import lombok.Data;

/**
 * @author Vittorio Valent
 *
 */
@Data
public class UserDTO {

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

	private String nome;

	private String cognome;

}
