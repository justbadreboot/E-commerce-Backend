package com.microservice.authserve;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class AuthserveApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthserveApplication.class, args);
	}

}
