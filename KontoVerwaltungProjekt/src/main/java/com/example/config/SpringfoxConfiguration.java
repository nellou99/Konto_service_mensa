package com.example.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration

@EnableSwagger2
public class SpringfoxConfiguration {
	
	@Bean
	public Docket restApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				//.groupName("Rest Api (V1)")
				.select()
				//.paths(PathSelectors.ant("/apis/**"))
				.build();
				//.apiInfo(apiInfo());
	}
	
	private ApiInfo apiInfo() {
		return new ApiInfo(
				"Patientenverwaltung", 
				"beschreibung", 
				"version 01", 
				"www....", 
				new Contact("wilfried nono", "url", "wilfried.nono90@gmail.com"), 
				"licence", 
				"licenceurl",
				Collections.emptyList()
				);
	}

}
