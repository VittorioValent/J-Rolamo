#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.sample.actuator;

import java.io.IOException;

import org.springframework.stereotype.Service;

/**
 * @author Vittorio Valent
 *
 */
@Service
@SuppressWarnings("unused")
public class ApplicationService {

	public void restart() {
		try {
			System.out.println("Restarting application due to new Entity creation");
			Process process = Runtime.getRuntime().exec("mvn clean install");
		} catch (IOException e) {
			System.out.println("Impossible to restart application");
		}
	}
}