package com.diatoz.college.confiig;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@EnableWebMvc
public class SwaggerConfiguration {

	@Bean
	Docket docket() {
	return new Docket(DocumentationType.SWAGGER_2)
			//.securityContexts(Arrays.asList(securityContext()))
		    //.securitySchemes(Arrays.asList(apiKey()))
			.pathMapping("/admin")
			.select()
			.paths(PathSelectors.any())
			.apis(RequestHandlerSelectors.basePackage("com.diatoz.college.controller"))
			.build()
			.apiInfo(getApiInfo());
	}

	private ApiInfo getApiInfo() {
		return new ApiInfo("Diatoz College Data Management Service", 
				"Application for management of Teacher and Student Data", null, null, "Deepak", null, "https://");
	}
	
//	private ApiKey apiKey() { 
//	    return new ApiKey("JWT", "Authorization", "header"); 
//	}
//	private SecurityContext securityContext() { 
//	    return SecurityContext.builder().securityReferences(defaultAuth()).build(); 
//	}
//	private List<SecurityReference> defaultAuth() { 
//	    AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything"); 
//	    AuthorizationScope[] authorizationScopes = new AuthorizationScope[1]; 
//	    authorizationScopes[0] = authorizationScope; 
//	    return Arrays.asList(new SecurityReference("JWT", authorizationScopes)); 
//	}
	
	
}