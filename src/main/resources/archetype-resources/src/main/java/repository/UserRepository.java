#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.repository;

import org.springframework.stereotype.Repository;

import ${package}.domain.User;
import ${package}.repository.generic.IRepository;

/**
 * @author Vittorio Valent
 *
 * @since 1.0
 */
@Repository
public interface UserRepository extends IRepository<User> {

	public User findByUsername(String username);

}
