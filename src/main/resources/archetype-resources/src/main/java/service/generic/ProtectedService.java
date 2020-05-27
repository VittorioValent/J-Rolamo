#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.service.generic;

import ${package}.annotations.IsOwnerPreAuth;
import ${package}.domain.generic.AbstractDTO;
import ${package}.domain.generic.AbstractModel;

/**
 * Read all, Write only owner
 *
 * @author JRolamo
 * @since 1.0
 */
public abstract class ProtectedService<Entity extends AbstractModel, DTO extends AbstractDTO> extends PublicService<Entity, DTO> {

    @Override
    @IsOwnerPreAuth
    public void delete(Long id) {
        repository.deleteById(id);
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
