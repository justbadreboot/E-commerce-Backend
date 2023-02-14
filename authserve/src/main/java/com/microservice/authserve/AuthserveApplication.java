package com.microservice.authserve;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMethod;

@SpringBootApplication
@EnableDiscoveryClient
@CrossOrigin(origins = "**", methods= {RequestMethod.GET, RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT})
public class AuthserveApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthserveApplication.class, args);
	}

}
