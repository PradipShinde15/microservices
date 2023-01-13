package com.rating_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rating_service.entities.Rating;
import com.rating_service.service.RatingService;

@RestController
@RequestMapping("/ratings")
public class RatingController {
	
	@Autowired
	private RatingService ratingService; 
	
	@PostMapping
	public ResponseEntity<Rating> create(@RequestBody Rating rating){
		Rating rating1 = ratingService.createService(rating);
		return ResponseEntity.status(HttpStatus.CREATED).body(rating1);
		
	}
	
	@GetMapping
	public ResponseEntity<List<Rating>> getAllRatings(){
		  List<Rating> rating1 = ratingService.getAllRating();
		return ResponseEntity.status(HttpStatus.OK).body(rating1);
		
	}
	
	@GetMapping("/users/{userId}")
	public ResponseEntity<List<Rating>> getAllRatingsByUserId(@PathVariable String userId){
		  List<Rating> rating1 = ratingService.getRatingByUserId(userId);
		return ResponseEntity.status(HttpStatus.OK).body(rating1);
		
	}
	
	@GetMapping("/hotels/{hotelId}")
	public ResponseEntity<List<Rating>> getAllRatingsByHotelId(@PathVariable String hotelId){
		  List<Rating> rating1 = ratingService.getRatingByHotelId(hotelId);
		return ResponseEntity.status(HttpStatus.OK).body(rating1);
		
	}
	
	

}
