package com.rating_service.serviceImpl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rating_service.entities.Rating;
import com.rating_service.repository.RatingRepo;
import com.rating_service.service.RatingService;
@Service
public class RatingServiceImpl implements RatingService{
	@Autowired
	private RatingRepo ratingRepo;
	
	

	@Override
	public Rating createService(Rating rating) {
		
		String rating1 = UUID.randomUUID().toString();
		rating.setRatingId(rating1);
		return ratingRepo.save(rating);
	}

	@Override
	public List<Rating> getAllRating() {
		// TODO Auto-generated method stub
		return ratingRepo.findAll();
	}

	@Override
	public List<Rating> getRatingByUserId(String userId) {
		// TODO Auto-generated method stub
		return ratingRepo.findByUserId(userId);
	}

	@Override
	public List<Rating> getRatingByHotelId(String hotelId) {
		// TODO Auto-generated method stub
		return ratingRepo.findByHotelId(hotelId);
	}

}
