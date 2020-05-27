#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.data.jpa.repository.Query;

/**
 * Sets as a quary param the logged user's name in order to filter resultset and
 * keep pagination as well. If the logged user has Admin Role then the filter
 * will not be set on.
 * 
 * @author JRolamo
 * @since 1.0
 *
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Query("select entity from ${symbol_pound}{${symbol_pound}entityName} entity where entity.owner = ?${symbol_pound}{principal.username} or 1=?${symbol_pound}{hasRole('ROLE_ADMIN') ? 1 : 0}")
public @interface IsOwnerListPostAuth {

}
