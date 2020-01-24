#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.workshop.repository;

import java.util.List;

import ${package}.repository.generic.IRepository;
import ${package}.workshop.domain.EntityInfo;
import ${package}.workshop.domain.FieldInfo;

/**
 * @author Vittorio Valent
 * @since 1.1
 *
 */
public interface FieldInfoRepository extends IRepository<FieldInfo> {

	public List<FieldInfo> findByEntityInfoAndToDisplay(EntityInfo entityInfo, Boolean toDisplay);

	public List<FieldInfo> findByEntityInfoAndToFilter(EntityInfo entityInfo, Boolean toFilter);
}
