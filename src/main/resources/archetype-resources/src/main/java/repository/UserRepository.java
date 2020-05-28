#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.repository;

import it.contrader.jrolamo.generics.repositoy.IRepository;
import ${package}.domain.User;
import org.springframework.stereotype.Repository;

/**
 * @author JRolamo
 *
 * @since 1.0
 */
@Repository
public interface UserRepository extends IRepository<User> {

	public User findByUsername(String username);

}
