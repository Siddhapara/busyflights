package com.travix.medusa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Primary;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@ComponentScan(value = "com.travix.medusa")
public class BusyFlightsApplication {

	public static void main(String[] args) {
		SpringApplication.run(BusyFlightsApplication.class, args);
	}

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.travix.medusa.busyflights.controller")).paths(PathSelectors.any())
				.build();
	}
	
	@Bean
	@Primary
	public ObjectMapper geObjMapper(){
	    return new ObjectMapper()
	            .registerModule(new ParameterNamesModule())
	            .registerModule(new Jdk8Module())
	            .registerModule(new JavaTimeModule());
	}

}
