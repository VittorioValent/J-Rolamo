package it.pkg.domain.utils;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Utility class: instead of passsing two dates argument in a mathod (ex
 * start-date, end-date), you can use this object.
 * 
 * @author Vittorio Valent
 *
 */
@Data
@AllArgsConstructor
public class DateRange {

	private Date startDate;

	private Date endDate;

}
