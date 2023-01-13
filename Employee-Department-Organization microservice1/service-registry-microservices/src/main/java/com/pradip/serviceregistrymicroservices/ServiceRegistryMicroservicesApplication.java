package com.pradip.serviceregistrymicroservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class ServiceRegistryMicroservicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceRegistryMicroservicesApplication.class, args);
	}

}
