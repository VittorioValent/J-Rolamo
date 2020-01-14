#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.sample.service.generic;

import com.querydsl.core.types.Predicate;
import ${package}.sample.controller.generic.PrivateCrudController;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * All CRUD methods service
 *
 * @author Vittorio
 *
 * @param <DTO>
 * @see PrivateCrudController
 */
@Service
public interface ICrudService<DTO> {

    public DTO create(DTO entity);

    public void delete(DTO entity);

    public DTO update(DTO entity);

    public DTO merge(Long id, DTO entity);

    public Page<DTO> getAll(Predicate predicate, Pageable pageable);

    public DTO read(Long id);
}
