package com.microservicio.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ActualizarMsApplication {
	
	@Bean
	public RestTemplate getWebClient(){
		return new RestTemplate();
	}

	public static void main(String[] args) {
		SpringApplication.run(ActualizarMsApplication.class, args);
	}

}
