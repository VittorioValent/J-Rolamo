#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.config;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.collect.Lists;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Configuration settings for Swagger UI
 * 
 * @author Vittorio Valent
 *
 * @since 1.0
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

	/**
	 * Main configuration Bean
	 */
	@Bean
	public Docket apiApp() {
		Docket docket = new Docket(DocumentationType.SWAGGER_2)
				.groupName("Application Endpoint").select()
				.paths(PathSelectors.ant("/api/**"))
				.build()
				.pathMapping("/")
				.apiInfo(ApiInfo.DEFAULT).forCodeGeneration(true)
				.securityContexts(Lists.newArrayList(securityContext()))
				.securitySchemes(Lists.newArrayList(apiKey()))
				.useDefaultResponseMessages(false);
		return docket;
	}

	/**
	 * Authentication configuration Bean
	 */
	@Bean
	public Docket apiAuth() {
		Docket docket = new Docket(DocumentationType.SWAGGER_2)
				.groupName("Authentication Endpoint").select()
				.paths(PathSelectors.ant("/authentication/**"))
				.build()
				.pathMapping("/")
				.apiInfo(ApiInfo.DEFAULT).forCodeGeneration(true)
				.securityContexts(Lists.newArrayList(securityContext()))
				.securitySchemes(Lists.newArrayList(apiKey()))
				.useDefaultResponseMessages(false);
		return docket;
	}

	/**
	 * Workshop configuration Bean
	 */
	@Bean
	public Docket apiWorkshop() {
		Docket docket = new Docket(DocumentationType.SWAGGER_2)
				.groupName("Workshop Endpoint").select()
				.paths(PathSelectors.ant("/workshop/**")).build()
				.pathMapping("/")
				.securityContexts(Lists.newArrayList(securityContext()))
				.securitySchemes(Lists.newArrayList(apiKey()))
				.useDefaultResponseMessages(false);
		return docket;
	}

	/**
	 * Actuator configuration Bean
	 */
	@Bean
	public Docket apiActuator() {
		Docket docket = new Docket(DocumentationType.SWAGGER_2)
				.groupName("Actuators Endpoint").select()
				.paths(PathSelectors.ant("/actuator/**")).build()
				.pathMapping("/")
				.securityContexts(Lists.newArrayList(securityContext()))
				.securitySchemes(Lists.newArrayList(apiKey()))
				.useDefaultResponseMessages(false);
		return docket;
	}

	/**
	 * Defines which type of authorization is to be used
	 */
	private SecurityReference defaultAuth() {
		final AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
		final AuthorizationScope[] authorizationScopes = new AuthorizationScope[]{authorizationScope};
		return new SecurityReference("Bearer", authorizationScopes);
	}

	/**
	 * Indicates which APIs are decorated by the lock symbol
	 */
	private SecurityContext securityContext() {
		return SecurityContext.builder().securityReferences(Arrays.asList(defaultAuth()))
				.forPaths(PathSelectors.regex("^(?!.*/public/).*${symbol_dollar}")).build();
	}

	/**
	 * Labels for login dialog
	 */
	private ApiKey apiKey() {
		return new ApiKey("Bearer", "Authorization", "header");
	}
}
