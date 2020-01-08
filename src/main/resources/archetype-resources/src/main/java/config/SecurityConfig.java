#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.SessionManagementConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.header.Header;

import ${package}.security.JWTAuthenticationEntryPoint;
import ${package}.security.RequestFilter;

/**
 * Spring Security Configuration Class
 *
 * @author Vittorio Andreoni
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private JWTAuthenticationEntryPoint jwtAuthenticationEntryPoint;

	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	private RequestFilter requestFilter;

	@Autowired
	/**
	 * Configure AuthenticationManager so that it knows from where to load user.
	 * For matching credentials Use BCryptPasswordEncoder
	 * 
	 * @param auth
	 * @throws Exception
	 */
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	/**
	 * Configures {@link HttpSecurity} params like
	 * <ul>
	 * <li>CSRF and CORS,
	 * <li>Auth path whitelist,
	 * <li>{@link Header}
	 * <li>{@link JWTAuthenticationEntryPoint},
	 * <li>{@link SessionManagementConfigurer}.
	 * </ul>
	 */
	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.csrf().disable()
				.authorizeRequests()
				.antMatchers(AUTH_WHITELIST).permitAll()
				.anyRequest().authenticated()
				.and().csrf().ignoringAntMatchers("/**")
				.and().headers().frameOptions().sameOrigin()
				.and().exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint)
				.and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

		httpSecurity.addFilterBefore(requestFilter, UsernamePasswordAuthenticationFilter.class);
	}

	/**
	 * All these path segments are auth-free
	 */
	private static final String[] AUTH_WHITELIST = {
			"/v2/api-docs/**",
			"/swagger-**",
			"/h2-console/**",
			"/api/public/**",
			"/authentication/public/**",
			"/swagger-resources/**",
			"/webjars/**"

	};
}
