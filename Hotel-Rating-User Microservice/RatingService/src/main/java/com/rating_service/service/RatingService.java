package com.rating_service.service;

import java.util.List;

import com.rating_service.entities.Rating;

public interface RatingService {
	
	public Rating createService(Rating rating);
	
	List<Rating> getAllRating();
	
	List<Rating> getRatingByUserId(String userId);
	
	List<Rating> getRatingByHotelId(String hotelId);
	

}
