#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.service.mapper.generic;

import ${package}.domain.generic.AbstractDTO;
import ${package}.domain.generic.AbstractModel;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Component;

/**
 * Interface for all mapper methods implemented by Mapstruct
 *
 * @author JRolamo
 *
 * @param <Entity>
 * @param <DTO>
 * @since 1.0
 */
@Component
public interface IMapper<Entity extends AbstractModel, DTO extends AbstractDTO> extends ListMapper {

    public Entity toEntity(DTO dto);

    public DTO toDTO(Entity entity);

    public List<DTO> toDTO(Iterable<Entity> iterEntity);

    public List<Entity> toEntity(Iterable<DTO> iterDTO);

    default Page<Entity> toEntity(Page<DTO> dtoPage) {
        return new PageImpl<>(toEntity(dtoPage.getContent()), dtoPage.getPageable(),
                dtoPage.getTotalElements());
    }

    default Page<DTO> toDTO(Page<Entity> entityPage) {
        return new PageImpl<>(toDTO(entityPage.getContent()), entityPage.getPageable(),
                entityPage.getTotalElements());
    }
}
