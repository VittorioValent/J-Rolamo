#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.service.utils;

import java.lang.reflect.Field;

import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

/**
 * Component for enable partial update DTO
 *
 * @author Vittorio Andreoni
 * @param <DTO>
 * @since 1.0
 */
@Component
public class PatchUtils<DTO> {

	/**
	 * Use reflection for update source DTO with data not null from patched DTO
	 *
	 * @param dtoSource
	 * @param dtoPatch
	 * @return updated DTO
	 */
	public DTO applyPatch(DTO dtoSource, DTO dtoPatch) {
		Class<? extends Object> clazz = dtoSource.getClass();

		for (Field field : clazz.getDeclaredFields()) {

			// use reflection to get field k on object and set it to value v
			field.setAccessible(true);

			// get value
			Object value = ReflectionUtils.getField(field, dtoPatch);
			if (value != null) {
				// set value if not null
				ReflectionUtils.setField(field, dtoSource, value);
			}
		}
		return dtoSource;
	}

}
