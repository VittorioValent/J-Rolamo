package it.pkg.service.generic;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.querydsl.core.types.Predicate;

import it.pkg.controller.generic.CrudController;

/**
 * All CRUD methods service
 * 
 * @author Vittorio Valent
 *
 * @param <DTO>
 * @see CrudController
 */
@Service
public interface ICrudService<DTO> {

	public DTO create(DTO entity);

	public void delete(DTO entity);

	public DTO update(DTO entity);

	public Page<DTO> getAll(Predicate predicate, Pageable pageable);

	public DTO read(Long id);
}
