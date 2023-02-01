package com.microservice.landing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class LandingApplication {

	public static void main(String[] args) {
		SpringApplication.run(LandingApplication.class, args);
	}

}
