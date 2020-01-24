#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.domain.generic;

import java.io.Serializable;

/**
 * @author Vittorio Valent
 *
 */
public abstract class AbstractDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	public abstract Long getId();
}
