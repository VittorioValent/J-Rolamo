#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.config;

import it.jrolamo.generics.domain.AuditorAwareImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.data.repository.query.SecurityEvaluationContextExtension;

/**
 *
 * @author JRolamo
 * @since 1.0
 */
@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
public class PersistenceConfig {

	@Bean
	AuditorAware<String> auditorAware() {
		return new AuditorAwareImpl();
	}

	@Bean
	public SecurityEvaluationContextExtension securityEvaluationContextExtension() {
		return new SecurityEvaluationContextExtension();
	}
}
