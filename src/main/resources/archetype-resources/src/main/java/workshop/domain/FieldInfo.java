#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.workshop.domain;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import lombok.Data;

/**
 * @author Vittorio Valent
 * @since 1.1
 *
 */
@Data
@Entity
public class FieldInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	private String type;

	private Boolean toDisplay;

	private Boolean toFilter;

	@JoinColumn
	@ManyToOne
	private EntityInfo entityInfo;

	@Transient
	private Class<?> mappedEntity;

	public Class<?> getType(String location, String modelType) {
		switch (this.type.trim().toLowerCase()) {
			case "string" :
				return String.class;
			case "integer" :
			case "int" :
				return Integer.class;
			case "long" :
				return Long.class;
			case "boolean" :
				return Boolean.class;
			case "float" :
				return Float.class;
			case "double" :
				return Double.class;
			case "date" :
				return Date.class;
			case "bigdecimal" :
				return BigDecimal.class;
			default :
				break;
		}
		Class<?> clazz = String.class;

		try {
			clazz = Class.forName(location + "." + this.type + modelType);
			this.mappedEntity = clazz;
		} catch (ClassNotFoundException e) {
			System.out.println("Impossible to retrieve class from " + type + ", setting string as type");
		}
		return clazz;
	}

}
