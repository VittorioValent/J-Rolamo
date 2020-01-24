#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.service.generic;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.querydsl.core.types.Predicate;

import ${package}.annotations.IsOwnerPostAuth;
import ${package}.annotations.IsOwnerPreAuth;
import ${package}.domain.generic.AuditDTO;

/**
 * generic implementation for those CRUD methods which need some sort of
 * authentication to be invoked. It should be extended by services related to
 * private entities.
 *
 * @author Vittorio Valent
 *
 * @param <Entity>
 * @param <DTO>
 *
 * @see IsOwnerPostAuth
 * @see IsOwnerPreAuth
 * @see AuditDTO
 * @since 1.0
 */
public abstract class PrivateService<Entity, DTO extends AuditDTO> extends ProtectedService<Entity, DTO> {

	@Override
	@IsOwnerPostAuth
	public DTO read(Long id) {
		return mapper.toDTO(repository.findById(id).get());
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
