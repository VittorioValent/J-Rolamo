#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.service.mapper.generic;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.GenericTypeResolver;
import org.springframework.stereotype.Component;

/**
 * This service is used to access to specific instances of {@link IMapper}
 * 
 * @author Vittorio Valent
 * @author sinan.yumak
 */
@Component
@SuppressWarnings({"rawtypes", "unchecked"})
public class IMapperService {

	private Map<String, IMapper> mapperInfos = new HashMap<>();

	@Autowired
	private ApplicationContext appContext;

	@PostConstruct
	private void init() {

		Collection<IMapper> foundMappers = findGenericMappers();

		for (IMapper foundMapper : foundMappers) {

			// source type of the mapper..
			String sourceType = getMapperSourceType(foundMapper);

			// target type of the mapper..
			String targetType = getMapperTargetType(foundMapper);

			// initialize mapper info
			mapperInfos.put(sourceType + "-" + targetType, foundMapper);
			mapperInfos.put(targetType + "-" + sourceType, foundMapper);

		}

	}

	/**
	 * Searches for the mappers in Spring context that is inherited from
	 * {@link IMapper} interface.
	 */
	private Collection<IMapper> findGenericMappers() {
		return appContext.getBeansOfType(IMapper.class).values();
	}

	/**
	 * Returns the source type of {@link IMapper}.
	 */
	private String getMapperSourceType(IMapper mapper) {

		Class<?>[] mapperTypeInfos = GenericTypeResolver.resolveTypeArguments(
				mapper.getClass(),
				IMapper.class);

		return mapperTypeInfos[0].getSimpleName();
	}

	/**
	 * Returns the target type of {@link IMapper}.
	 */
	private String getMapperTargetType(IMapper mapper) {

		Class<?>[] mapperTypeInfos = GenericTypeResolver.resolveTypeArguments(
				mapper.getClass(),
				IMapper.class);

		return mapperTypeInfos[1].getSimpleName();
	}

	/**
	 * Returns the {@link IMapper} for the given source and the target type.
	 */
	public <Entity, DTO> IMapper<Entity, DTO> getMapper(Class<Entity> sourceType, Class<DTO> targetType) {

		String mapperKey = sourceType.getSimpleName() + "-" + targetType.getSimpleName();

		return mapperInfos.get(mapperKey);
	}
}
