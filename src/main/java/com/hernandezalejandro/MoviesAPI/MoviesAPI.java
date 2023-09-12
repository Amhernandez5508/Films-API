package com.hernandezalejandro.MoviesAPI;

import io.swagger.v3.oas.models.info.Contact;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@SpringBootApplication
public class MoviesAPI {

	public static void main(String[] args) {
		SpringApplication.run(MoviesAPI.class, args);
	}
	
	@Bean
	public OpenAPI customOpenAPI(@Value("V1.10") String appVersion) {
		return new OpenAPI().info(new Info()
				.title("Movies API")
				.version(appVersion)
				.description("Service for managing movies repository")
				.termsOfService("https://www.linkedin.com/in/alejandro-martin-hernandez/")
				.license(new License()
					.name("AlejandroHernandez 1.0")
					.url("https://www.linkedin.com/in/alejandro-martin-hernandez/"))
				.contact(new Contact()
					.name("Alejandro Hernández")
					.url("https://www.linkedin.com/in/alejandro-martin-hernandez/")
					.email("ahernande5508@gmail.com")));
	}

}
