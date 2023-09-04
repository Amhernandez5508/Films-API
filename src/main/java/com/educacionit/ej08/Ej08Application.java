package com.educacionit.ej08;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@SpringBootApplication
public class Ej08Application {

	public static void main(String[] args) {
		SpringApplication.run(Ej08Application.class, args);
	}
	
	@Bean
	public OpenAPI customOpenAPI(@Value("V1") String appVersion) {
		return new OpenAPI().info(new Info().title("Java Web API - Ej08")
				.version(appVersion)
				.description("JWA-08 Crud de Películas")
				.termsOfService("http://google.com")
				.license(new License().name("Apache 2.0").url("http://google.com.ar")));
		
	}

}
