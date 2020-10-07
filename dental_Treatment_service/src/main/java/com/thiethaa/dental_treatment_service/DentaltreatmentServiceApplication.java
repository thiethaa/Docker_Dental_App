package com.thiethaa.dental_treatment_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
//@EnableEurekaClient
public class DentaltreatmentServiceApplication {

	@Bean
	public RestTemplate getResttemplate(){
		return  new RestTemplate();
	}


	public static void main(String[] args) {
		SpringApplication.run(DentaltreatmentServiceApplication.class, args);
	}

}
