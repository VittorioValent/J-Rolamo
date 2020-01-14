#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.sample.repository.generic;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.NoRepositoryBean;

import com.querydsl.core.types.Predicate;

import ${package}.sample.annotations.IsOwnerListPostAuth;

/**
 * Repository to fetch private objects based on logged user in order to keep
 * pagination
 * 
 * @author Vittorio Valent
 *
 * @see IsOwnerListPostAuth
 */
@NoRepositoryBean
public interface IPrivateRepository<Entity> extends IRepository<Entity> {

	@Override
	@IsOwnerListPostAuth
	public Page<Entity> findAll(Pageable pageable);

	@Override
	@IsOwnerListPostAuth
	public Page<Entity> findAll(Predicate predicate, Pageable pageable);

}
