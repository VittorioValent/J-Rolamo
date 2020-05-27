#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.service.generic;

import ${package}.domain.generic.AbstractDTO;
import ${package}.domain.generic.AbstractModel;
import java.util.List;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

/**
 * All CRUD methods and buisness helpers can be found in this interface.
 *
 * @author JRolamo
 *
 * @param <Entity>
 * @param <DTO>
 *
 * @see ICrudService
 * @since 1.0
 */
@Service
public interface IService<Entity extends AbstractModel, DTO extends AbstractDTO> extends ICrudService<DTO> {

    /**
     * Buisness-only method: supports filtering by specification instead of
     * QDSDL Predicate
     *
     * @param spec
     * @return List<DTO>
     */
    public List<DTO> find(Specification<Entity> spec);
}
