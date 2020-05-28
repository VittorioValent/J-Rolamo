#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.security;

import ${package}.domain.Role;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Container Class for JWT String
 * 
 * @author JRolamo
 *
 * @see JWTUtils
 * @see JWTRequest
 * @since 1.0
 */
@Data
@AllArgsConstructor
public class JWTResponse {

	private String token;

	private String username;

	private Role role;
}
