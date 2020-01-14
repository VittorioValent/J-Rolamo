#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.sample.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import ${package}.sample.domain.generic.AuditModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author Vittorio Valent
 *
 */
@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class User extends AuditModel implements Serializable {

	private static final long serialVersionUID = -1622280662634740376L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(unique = true)
	private String username;

	private String password;

	@Column(columnDefinition = "boolean default true")
	private Boolean accountNonExpired;

	@Column(columnDefinition = "boolean default true")
	private Boolean credentialsNonExpired;

	@Column(columnDefinition = "boolean default true")
	private Boolean accountNonLocked;

	@Column(columnDefinition = "boolean default true")

	private Boolean enabled;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn
	private Role role;

	private String nome;

	private String cognome;

}
