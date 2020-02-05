#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.workshop.utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import org.springframework.util.StringUtils;

import com.squareup.javapoet.JavaFile;

import it.foo.bar.prova.workshop.domain.EntityInfo;
import it.foo.bar.prova.workshop.domain.FieldInfo;

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
	
	public static void insertFields(List<FieldInfo> fields) throws IOException {
		String lineToAppend = "\nINSERT INTO FIELD_INFO (NAME, TYPE, TO_DISPLAY, TO_FILTER, ENTITY_INFO_ID) VALUES \n"
				+ "('id', 'Long', TRUE, TRUE,  " + fields.get(0).getEntityInfo().getId() + ")";
		for (FieldInfo field : fields) {
			lineToAppend = lineToAppend + ",\n('" + field.getName() + "', '" + field.getType() + "',"
					+ field.getToDisplay().toString().toUpperCase() + ", " + field.getToFilter().toString().toUpperCase()
					+ ", " + field.getEntityInfo().getId() + ")";
		}
		lineToAppend = lineToAppend + ";";

		appendToDataSQL(lineToAppend);
	}

	public static void insertEntity(EntityInfo entityInfo) throws IOException {
		String lineToAppend = "\nINSERT INTO ENTITY_INFO ( AUDITABLE, CONTROLLER_TYPE, ENTITY_NAME, SERVICE_TYPE) VALUES \n"
				+ "(" + (entityInfo.getAuditable() != null
						? entityInfo.getAuditable().toString().toUpperCase()
						: Boolean.FALSE.toString().toUpperCase())
				+ ", " + entityInfo.getControllerType().getId()
				+ ", '" + entityInfo.getEntityName().toLowerCase() + "', " + entityInfo.getServiceType().getId() + ");";
		appendToDataSQL(lineToAppend);
	}

	public static void appendToDataSQL(String lineToAppend) throws IOException {
		FileWriter fileWriter = new FileWriter("src/main/resources/data.sql", true);
		PrintWriter printWriter = new PrintWriter(fileWriter);
		printWriter.println(lineToAppend);
		printWriter.close();
	}
}
