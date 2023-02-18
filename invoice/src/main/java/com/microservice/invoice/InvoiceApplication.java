package com.microservice.invoice;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableDiscoveryClient
@EnableJpaAuditing
public class InvoiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InvoiceApplication.class, args);
	}

	@Bean
	public OpenAPI springDocument(){
		return new OpenAPI()
				.addServersItem(new Server().url("/"))
				.info(new Info().title("Invoice Microservice")
						.description("Microservice development by: JustBADReboot")
						.version("v0.01")
						.license(new License().name("Apache 2.0").url("http://springdoc.org")))
				.externalDocs(new ExternalDocumentation()
						.description("Repositorios").url("github.com")
				);
	}

}
