#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.workshop.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.stereotype.Component;

import ${package}.workshop.domain.FieldInfo;
import ${package}.workshop.domain.EntityInfo;

/**
 * 
 * 
 * @author Vittorio Valent
 * @since 1.1
 */
@Component
public class ScriptExecutor {

	public void createFrontendClasses(EntityInfo entity, List<FieldInfo> fields) throws IOException {

		ProcessBuilder pb = new ProcessBuilder("src/main/resources/scripts/view-ttorio-generate.sh",
				entity.getEntityName(),
				formatFields(fields),
				getPublicSegment(entity).toString().toLowerCase(),
				getProtectedSegment(entity).toString().toLowerCase());
		Process p = pb.start();

		BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
		String line = null;

		while ((line = reader.readLine()) != null) {
			System.out.println(line);
		}
	}

	private String formatFields(List<FieldInfo> fields) {
		String fieldString = "";
		String idField = "id:number";
		for (FieldInfo field : fields) {
			String fieldName = field.getName();
			String fieldType = getFrontendFormatFieldType(field.getType());
			String formattedField = fieldName + ":" + fieldType + ";";
			fieldString = fieldString + formattedField;
		}
		return fieldString + idField;
	}

	private String getFrontendFormatFieldType(String fieldType) {
		if (fieldType.equals("Integer") || fieldType.equals("Long") || fieldType.equals("Double")
				|| fieldType.equals("Float")) {
			return "number";
		} else if (fieldType.equals("String")) {
			return "string";
		} else if (fieldType.equals("Boolean")) {
			return "boolean";
		} else {
			return fieldType + "DTO";
		}
	}
	
	private Boolean getPublicSegment(EntityInfo entity) {
		switch (entity.getServiceType()) {
			case PUBLIC :
			case PROTECTED :
				return true;

			case PRIVATE :
				return false;

			default :
				return false;
		}
	}

	private Boolean getProtectedSegment(EntityInfo entity) {
		switch (entity.getServiceType()) {
			case PUBLIC :
				return true;

			case PROTECTED :
			case PRIVATE :
				return false;

			default :
				return false;
		}
	}
	
}
