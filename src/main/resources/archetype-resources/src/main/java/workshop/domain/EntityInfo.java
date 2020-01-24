#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.workshop.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import ${package}.workshop.utils.ControllerTypeEnum;
import ${package}.workshop.utils.GeneratorUtils;
import ${package}.workshop.utils.ServiceTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Vittorio Valent
 * @since 1.1
 *
 */
@Data
@AllArgsConstructor
@Entity
@Builder
@NoArgsConstructor
public class EntityInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String entityName;

	private Boolean auditable;

	@Transient
	private List<FieldInfo> fields;

	private ServiceTypeEnum serviceType;

	private ControllerTypeEnum controllerType;

	public String getEntityName() {
		return GeneratorUtils.capitalize(this.entityName);
	}
}
