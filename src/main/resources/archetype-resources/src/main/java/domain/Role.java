#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import ${package}.domain.generic.AbstractDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Vittorio Valent
 *
 * @since 1.0
 */
@Entity
@Data
@EqualsAndHashCode(callSuper = false)
public class Role {

	private static final long serialVersionUID = -6940557549482951379L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

}
