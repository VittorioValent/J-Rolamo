#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.controller.errorhandling;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 *
 * @author Vittorio Valent
 */
@Data
@AllArgsConstructor
public class ApiError {

	private HttpStatus status;

	private String message;

	private List<String> errors;

	public ApiError(final HttpStatus status, final String message, final String error) {
		super();
		this.status = status;
		this.message = message;
		errors = Arrays.asList(error);
	}

	public void setError(final String error) {
		errors = Arrays.asList(error);
	}
}
