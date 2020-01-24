#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.workshop.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import ${package}.repository.generic.IRepository;
import ${package}.workshop.domain.EntityInfo;

/**
 * @author Vittorio Valent
 * @since 1.1
 */
@Repository
public interface EntityInfoRepository extends IRepository<EntityInfo> {

	List<EntityInfo> findByEntityName(String entityName);
}
