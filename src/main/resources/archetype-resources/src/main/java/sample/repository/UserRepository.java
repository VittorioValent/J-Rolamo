#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.sample.repository;

import org.springframework.stereotype.Repository;

import ${package}.sample.domain.User;
import ${package}.sample.repository.generic.IRepository;

/**
 * @author Vittorio Valent
 *
 */
@Repository
public interface UserRepository extends IRepository<User> {

	public User findByUsername(String username);

}
