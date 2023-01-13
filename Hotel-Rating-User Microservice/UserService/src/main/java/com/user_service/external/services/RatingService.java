package com.user_service.external.services;

import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

import com.user_service.entity.Rating;

@FeignClient(name = "RATING-SERVICE")
public interface RatingService {
	
	
	@PostMapping("/ratings")
	public Rating createRating(Rating values);
	
	

}
