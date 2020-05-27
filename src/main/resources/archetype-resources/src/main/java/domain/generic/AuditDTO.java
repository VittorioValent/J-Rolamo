#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.domain.generic;

import java.util.Date;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Provides Auditing fields and method-level security access for DTOs
 * 
 * @author JRolamo
 *
 * @see AuditModel
 * @since 1.0
 */
@Data
@EqualsAndHashCode(callSuper = false)
public abstract class AuditDTO extends AbstractDTO {

	private static final long serialVersionUID = 1L;

	/**
	 * Indicates when the object was created first
	 */
	protected Date createdOn;

	/**
	 * Indicates the creator/owner of the given object
	 */
	protected String owner;

	/**
	 * Indicates when the object was last
	 */
	protected Date lastModifiedOn;

	/**
	 * Indicates last user updating the object
	 */
	protected String lastModifiedBy;
}
