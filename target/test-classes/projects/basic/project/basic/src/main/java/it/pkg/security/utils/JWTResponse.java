package it.pkg.security.utils;

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
