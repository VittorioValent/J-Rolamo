#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.sample.domain.dto;

import ${package}.sample.domain.generic.AuditDTO;
import java.lang.Long;
import java.lang.String;
import java.util.Date;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Automatic Code Generator */
@Data
@EqualsAndHashCode(
		callSuper = false
)
public class MessageDTO extends AuditDTO {
	private Long id;

	private String nome;

	private String testo;

	private Date data;
}
