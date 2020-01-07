#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.service.generic;

import ${package}.annotations.IsOwnerPreAuth;

/**
 *
 * @author vittorio
 */
public class ReadOnlyService<Entity, DTO> extends AbstractService<Entity, DTO> {

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

}
