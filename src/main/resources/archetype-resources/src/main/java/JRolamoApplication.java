#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package};

import it.contrader.jrolamo.codegenerator.workshop.EnableCodeGenerator;
import it.contrader.jrolamo.generics.EnableGenerics;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Starter class for application
 *
 * @author JRolamo
 *
 */
@EnableGenerics
@EnableCodeGenerator
@SpringBootApplication
public class JRolamoApplication {

    public static void main(String[] args) {
        SpringApplication.run(JRolamoApplication.class, args);
    }

}
