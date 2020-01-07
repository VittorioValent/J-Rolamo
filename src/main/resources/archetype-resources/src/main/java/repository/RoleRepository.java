#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import ${package}.domain.Role;
import ${package}.repository.generic.IRepository;

/**
 * @author Vittorio Valent
 *
 */
@Repository
public interface RoleRepository extends IRepository<Role> {

	public List<Role> findByName(String name);
}
