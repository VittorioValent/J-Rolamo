#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.repository.generic;

import com.querydsl.core.types.Predicate;
import ${package}.annotations.IsOwnerListPostAuth;
import ${package}.domain.generic.AuditModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * Repository to fetch private objects based on logged user in order to keep
 * pagination
 *
 * @author JRolamo
 *
 * @see IsOwnerListPostAuth
 * @since 1.0
 */
@NoRepositoryBean
public interface IPrivateRepository<Entity extends AuditModel> extends IRepository<Entity> {

    @Override
    @IsOwnerListPostAuth
    public Page<Entity> findAll(Pageable pageable);

    @Override
    @IsOwnerListPostAuth
    public Page<Entity> findAll(Predicate predicate, Pageable pageable);

}
