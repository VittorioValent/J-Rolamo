package it.pkg.workshop.utils;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author Vittorio Valent
 *
 */
@Data
@AllArgsConstructor
public class EntityInfo {

	private String entityName;

	private List<FieldInfo> fields;

	private Boolean auditable;

	public String getEntityName() {
		return GeneratorUtils.capitalize(this.entityName);
	}
}
