#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.service.generic;

import com.querydsl.core.types.Predicate;
import ${package}.controller.generic.PrivateCrudController;
import ${package}.domain.generic.AbstractDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * All CRUD methods service
 *
 * @author JRolamo
 *
 * @param <DTO>
 * @see PrivateCrudController
 *
 * @since 1.0
 */
@Service
public interface ICrudService<DTO extends AbstractDTO> {

    public DTO create(DTO entity);

    public void delete(Long id);

    public DTO update(DTO entity);

    public DTO merge(Long id, DTO entity);

    public Page<DTO> getAll(Predicate predicate, Pageable pageable);

    public DTO read(Long id);
}
