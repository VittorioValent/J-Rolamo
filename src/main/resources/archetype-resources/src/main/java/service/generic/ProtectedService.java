#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.service.generic;

import ${package}.annotations.IsOwnerPreAuth;

/**
 * Read all, Write only owner
 *
 * @author Vittorio Andreoni
 * @since 1.0
 */
public abstract class ProtectedService<Entity, DTO> extends PublicService<Entity, DTO> {

	@Override
	@IsOwnerPreAuth
	public void delete(DTO dto) {
		repository.delete(mapper.toEntity(dto));
	}

	@Override
	@IsOwnerPreAuth
	public DTO update(DTO dto) {
		return mapper.toDTO(repository.save(mapper.toEntity(dto)));
	}

	@Override
	@IsOwnerPreAuth
	public DTO merge(Long id, DTO dto) {
		dto = (DTO) patchUtils.applyPatch(read(id), dto);
		return mapper.toDTO(repository.save(mapper.toEntity(dto)));
	}
}
