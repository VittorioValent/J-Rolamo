#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.repository;

import it.jrolamo.generics.repositoy.IRepository;
import ${package}.domain.Role;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 * @author JRolamo
 * @since 1.0
 *
 */
@Repository
public interface RoleRepository extends IRepository<Role> {

	public List<Role> findByName(String name);
}
