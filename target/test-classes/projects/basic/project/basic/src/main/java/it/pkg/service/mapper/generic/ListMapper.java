package it.pkg.service.mapper.generic;

import java.util.List;

import org.mapstruct.Named;

/**
 * @author Vittorio Valent
 *
 */
public interface ListMapper {

	@Named(value = "listToSize")
	public static Integer listToSize(List<?> list) {
		if (list == null) {
			return 0;
		} else {
			return list.size();
		}
	}
}
