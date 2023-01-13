package com.pradip.employeeservice;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
@EnableEurekaClient 
@EnableFeignClients
@SpringBootApplication
public class EmployeeServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeServiceApplication.class, args);
	}
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
		
	}
	@Bean
	public WebClient webClient() {
		return  WebClient.builder().build();
	}
	
	//Api calling by Rest template 
//	@Bean
//	public RestTemplate restTemplate() {
//		return new RestTemplate();
//
//	}
	
	
	
	
	

}