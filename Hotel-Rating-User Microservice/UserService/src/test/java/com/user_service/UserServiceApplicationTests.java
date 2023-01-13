package com.user_service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.user_service.entity.Rating;
import com.user_service.external.services.RatingService;

@SpringBootTest
class UserServiceApplicationTests {

	@Test
	void contextLoads() {
	}
	
	@Autowired
	private RatingService ratingService;
	
	@Test
    void createRating() {
    	Rating rating=Rating.builder().rating(10).userId("").hotelId("").feedBack("this is created using feign client").build();
    	Rating newRating = ratingService.createRating(rating);
        System.out.println("new rating created");
    
    }
}
