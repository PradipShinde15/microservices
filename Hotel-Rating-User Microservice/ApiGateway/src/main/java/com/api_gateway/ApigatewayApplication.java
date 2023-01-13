package com.api_gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
public class ApigatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApigatewayApplication.class, args);
	}
	@Bean
    public RouteLocator configureRoute(RouteLocatorBuilder builder) {
       return builder.routes()
      .route("userId", r->r.path("/users/**").uri("lb://USER-SERVICE")) //static routing
      .route("hotelId", r->r.path("/hotels/**").uri("lb://HOTEL-SERVICE"))
      .route("ratingId", r->r.path("/ratings/**","/ratings/users/**","/ratings/hotels/**").uri("lb://RATING-SERVICE"))//dynamic routing
      .build();
    }
	
	
	

}
