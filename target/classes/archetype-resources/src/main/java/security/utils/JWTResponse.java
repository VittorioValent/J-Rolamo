#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.security.utils;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Container Class for JWT String
 * 
 * @author Vittorio Valent
 *
 * @see JWTUtils
 * @see JWTRequest
 */
@Data
@AllArgsConstructor
public class JWTResponse {

	private String token;
}
