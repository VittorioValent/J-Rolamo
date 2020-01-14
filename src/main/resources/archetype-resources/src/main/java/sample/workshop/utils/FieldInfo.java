#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.sample.workshop.utils;

import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**
 * @author Vittorio Valent
 *
 */
@Data()
public class FieldInfo {

    private String name;

    private String type;

    private Class<?> mappedEntity;

    public Class<?> getType(String location, String modelType) {
        switch (this.type.trim().toLowerCase()) {
            case "string":
                return String.class;
            case "integer":
            case "int":
                return Integer.class;
            case "long":
                return Long.class;
            case "boolean":
                return Boolean.class;
            case "float":
                return Float.class;
            case "double":
                return Double.class;
            case "date":
                return Date.class;
            case "bigdecimal":
                return BigDecimal.class;
            default:
                break;
        }
        Class<?> clazz = String.class;

        try {
            clazz = Class.forName(location + "." + this.type + modelType);
            this.mappedEntity = clazz;
        } catch (ClassNotFoundException e) {
            System.out.println("Impossible to retrieve class from " + type + ", setting string as type");
        }
        return clazz;
    }

}
