package com.microservice.product;

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
public class ProductApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductApplication.class, args);
    }

    @Bean
    public OpenAPI springDocument(){
        return new OpenAPI()
                .addServersItem(new Server().url("/"))
                .info(new Info().title("Product Microservice")
                        .description("Microservicio desarrollado por: JustBADReboot")
                        .version("v0.01")
                        .license(new License().name("Apache 2.0").url("https://krugermed.vercel.app/")))
                .externalDocs(new ExternalDocumentation()
                        .description("Repositorios").url("https://github.com")
                );
    }

}
