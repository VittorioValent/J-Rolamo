#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.security.utils;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Container and validation Class for username and password
 * 
 * @author Vittorio Valent
 *
 * @see JWTUtils
 * @see JWTResponse
 */
@Data
@AllArgsConstructor
public class JWTRequest implements Serializable {

	private static final long serialVersionUID = 1L;

	@NotNull(message = "{username.notnull}")
	@NotEmpty(message = "{username.notnull}")
	private String username;

	@NotNull(message = "{password.notnull}")
	@NotEmpty(message = "{password.notnull}")
	private String password;
}
