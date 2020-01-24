#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.service.generic;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.querydsl.core.types.Predicate;

import ${package}.controller.generic.PrivateCrudController;

/**
 * All CRUD methods service
 *
 * @author Vittorio Valent
 *
 * @param <DTO>
 * @see PrivateCrudController
 * 
 * @since 1.0
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
