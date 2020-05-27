 #set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package};

import it.contrader.jrolamo.codegenerator.workshop.CodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Starter class for application
 *
 * @author JRolamo
 *
 */
@SpringBootApplication
@ComponentScan(basePackageClasses = {JRolamoApplication.class, CodeGenerator.class})
public class JRolamoApplication {

    public static void main(String[] args) {
        SpringApplication.run(JRolamoApplication.class, args);
    }

}
