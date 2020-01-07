#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.domain.generic;

import java.util.Date;

import lombok.Data;

/**
 * Provides Auditing fields and method-level security access for DTOs
 * 
 * @author Vittorio Valent
 *
 * @see AuditModel
 */
@Data
public abstract class AuditDTO {

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
