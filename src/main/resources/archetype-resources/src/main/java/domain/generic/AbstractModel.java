#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.domain.generic;

import java.io.Serializable;

/**
 *
 * @author JRolamo
 */
public abstract class AbstractModel implements Serializable {

    public abstract Long getId();
}
