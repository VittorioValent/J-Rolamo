#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package};

import it.contrader.jrolamo.codegenerator.workshop.JRolamoCodeGenerator;
import it.contrader.jrolamo.generics.JRolamoGenerics;
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
@ComponentScan(basePackageClasses = {JRolamoApplication.class, JRolamoCodeGenerator.class, JRolamoGenerics.class})
public class JRolamoApplication {

    public static void main(String[] args) {
        SpringApplication.run(JRolamoApplication.class, args);
    }

}
