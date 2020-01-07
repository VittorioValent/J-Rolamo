#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.service.generic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import com.querydsl.core.types.Predicate;

import ${package}.repository.generic.IRepository;
import ${package}.service.mapper.generic.IMapper;

/**
 * This class implements all CRUD and common buisness methods from
 * {@link IService} except those which need authentication to be invoked.
 *
 * @author Vittorio Valent
 *
 * @param <Entity>
 * @param <DTO>
 *
 * @see PrivateService
 */
public abstract class AbstractService<Entity, DTO> implements IService<Entity, DTO> {

	@Autowired
	protected IMapper<Entity, DTO> mapper;

	@Autowired
	protected IRepository<Entity> repository;

	@Override
	public DTO create(DTO dto) {
		return mapper.toDTO(repository.save(mapper.toEntity(dto)));
	}

	@Override
	public List<DTO> find(Specification<Entity> spec) {
		return mapper.toDTO(repository.findAll(spec));
	}

	@Override
	public void delete(DTO dto) {
		repository.delete(mapper.toEntity(dto));
	}

	@Override
	public DTO read(Long id) {
		return mapper.toDTO(repository.findById(id).get());
	}

	@Override
	public DTO update(DTO dto) {
		return mapper.toDTO(repository.save(mapper.toEntity(dto)));
	}

	@Override
	public Page<DTO> getAll(Predicate predicate, Pageable pageable) {
		if (predicate == null) {
			return mapper.toDTO(repository.findAll(pageable));
		} else {
			return mapper.toDTO(repository.findAll(predicate, pageable));
		}
	}
}
