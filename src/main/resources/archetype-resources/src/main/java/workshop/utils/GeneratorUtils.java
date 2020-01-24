#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.workshop.utils;

import java.io.File;
import java.io.IOException;

import org.springframework.util.StringUtils;

import com.squareup.javapoet.JavaFile;

/**
 * @author Vittorio Valent
 * @since 1.0
 *
 */
public abstract class GeneratorUtils {

	private static final String PROJECT_PATH = "src/main/java";

	private static final String BASE_PACKAGE = StringUtils.split(GeneratorUtils.class.getPackage().getName(),
			".workshop")[0];

	public static final String ENTITY_PACKAGE = BASE_PACKAGE + ".domain";

	public static final String DTO_PACKAGE = ENTITY_PACKAGE + ".dto";

	public static final String FILTER_PACKAGE = ENTITY_PACKAGE + ".filter";

	public static final String REPOSITORY_PACKAGE = BASE_PACKAGE + ".repository";

	public static final String SERVICE_PACKAGE = BASE_PACKAGE + ".service";

	public static final String MAPPER_PACKAGE = SERVICE_PACKAGE + ".mapper";

	public static final String CONTROLLER_PACKAGE = BASE_PACKAGE + ".controller";

	public static void save(JavaFile javaFile) throws IOException {
		File file = new File(PROJECT_PATH);
		javaFile.writeTo(file);
	}

	public static String capitalize(String string) {
		if (string == null || string.isEmpty()) {
			return string;
		}
		return string.substring(0, 1).toUpperCase() + string.substring(1);
	}
}
