#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.domain.generic;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Data;

/**
 * Superclass for entity, provides auditing implementation.
 *
 * @author Vittorio Andreoni
 * @see AuditDTO
 * @since 1.0
 */
@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class AuditModel implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * Indicates when the object was created first
	 */
	@CreatedDate
	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false, updatable = false)
	protected Date createdOn;

	/**
	 * Indicates the creator/owner of the given object
	 */
	@CreatedBy
	protected String owner;

	/**
	 * Indicates when the object was last
	 */
	@LastModifiedDate
	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false)
	protected Date lastModifiedOn;

	/**
	 * Indicates last user updating the object
	 */
	@LastModifiedBy
	protected String lastModifiedBy;
}
