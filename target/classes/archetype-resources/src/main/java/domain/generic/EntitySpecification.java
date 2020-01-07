#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.domain.generic;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import lombok.Getter;
import lombok.Setter;

/**
 * All Entity Specifications must extend this class. It has a default filter
 * (the given entity).
 * 
 * 
 * @author Vittorio Valent
 *
 * @param <Entity>
 * 
 * @see Specification
 */
@Getter
@Setter
public abstract class EntitySpecification<Entity> implements Specification<Entity> {

	private static final long serialVersionUID = -9100466270355479968L;

	protected Entity filter;

	@Override
	public abstract Predicate toPredicate(Root<Entity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder);

}
