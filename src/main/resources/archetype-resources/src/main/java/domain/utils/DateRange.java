#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.domain.utils;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Utility class: instead of passsing two dates argument in a mathod (ex
 * start-date, end-date), you can use this object.
 * 
 * @author JRolamo
 *
 */
@Data
@AllArgsConstructor
public class DateRange {

	private Date startDate;

	private Date endDate;

}
