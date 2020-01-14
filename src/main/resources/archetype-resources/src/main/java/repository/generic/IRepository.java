#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.repository.generic;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.data.querydsl.binding.SingleValueBinding;
import org.springframework.data.repository.NoRepositoryBean;

import com.querydsl.core.types.EntityPath;
import com.querydsl.core.types.dsl.StringExpression;
import com.querydsl.core.types.dsl.StringPath;

import ${package}.domain.generic.EntitySpecification;

/**
 * This Repository groups other repositores we need:
 * <ul>
 * <li>{@link JpaRepository} for all Crud and Pageable methods,
 * <li>{@link QuerydslBinderCustomizer} for QueryDsl bindings,
 * <li>{@link QuerydslPredicateExecutor} to use URL predicates,
 * <li>{@link JpaSpecificationExecutor} to apply spec filters,
 * </ul>
 * 
 * @author Vittorio Valent
 *
 * @param <Entity>
 * @see EntitySpecification
 */
@NoRepositoryBean
public interface IRepository<Entity>
		extends
			JpaRepository<Entity, Long>,
			QuerydslBinderCustomizer<EntityPath<Entity>>,
			QuerydslPredicateExecutor<Entity>,
			JpaSpecificationExecutor<Entity> {

	@Override
	default void customize(QuerydslBindings bindings, EntityPath<Entity> qEntity) {
		// Removes case-sentive from SQL LIKE
		bindings.bind(String.class).first((SingleValueBinding<StringPath, String>) StringExpression::containsIgnoreCase);
		// Expression of startWith Strings
		// bindings.bind(QEntity.entityname.field).first((SingleValueBinding<StringPath,
		// String>) StringExpression::startsWith);
	}
}
