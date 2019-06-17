package com.employee.configuration;

import org.springframework.context.annotation.Configuration;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import springfox.documentation.builders.ApiInfoBuilder;
import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
public class UserConfig {

	public Docket postsApi() {

		return new Docket(DocumentationType.SWAGGER_2).groupName("Bank Application").apiInfo(ApiInfo()).select()
				.paths(regex("/users*.")).build();
	}

	private ApiInfo ApiInfo() {
		// TODO Auto-generated method stub
		return new ApiInfoBuilder().title("User Details Controller")
				.description("Sample Documentation Generateed Using SWAGGER2 for our User Rest API").build();
	}

}
