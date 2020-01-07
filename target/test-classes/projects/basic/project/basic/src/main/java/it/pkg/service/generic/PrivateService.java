package it.pkg.service.generic;

import javax.annotation.Resource;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.querydsl.core.types.Predicate;

import it.pkg.annotations.IsOwnerPostAuth;
import it.pkg.annotations.IsOwnerPreAuth;
import it.pkg.domain.generic.AuditDTO;

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
 */
public abstract class PrivateService<Entity, DTO extends AuditDTO> extends ReadOnlyService<Entity, DTO> {

	@Resource
	PrivateService<Entity, DTO> service;

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
