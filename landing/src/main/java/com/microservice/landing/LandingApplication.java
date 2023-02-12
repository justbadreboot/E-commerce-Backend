package com.microservice.landing;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

@EnableDiscoveryClient
@SpringBootApplication
public class LandingApplication {

	public static void main(String[] args) {
		SpringApplication.run(LandingApplication.class, args);
	}

	@Bean
	public OpenAPI springDocument(){
		return new OpenAPI()
				.info(new Info().title("Microservice Landing")
						.description("Microservicio desarrollado por: JustBADReboot")
						.version("v0.01")
						.license(new License().name("Apache 2.0").url("http://springdoc.org")))
						.externalDocs(new ExternalDocumentation()
						.description("Repositorios").url("github.com")
				);
	}

}
