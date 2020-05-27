#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.domain.generic;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.Specification;

/**
 * All Entity Specifications must extend this class. It has a default filter
 * (the given entity).
 *
 *
 * @author JRolamo
 *
 * @param <Entity>
 *
 * @see Specification
 * @since 1.0
 */
@Getter
@Setter
public abstract class EntitySpecification<Entity extends AbstractModel> implements Specification<Entity> {

    protected Entity filter;

    @Override
    public abstract Predicate toPredicate(Root<Entity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder);

}
