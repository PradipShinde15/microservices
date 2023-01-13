package com.hotel_service.controller;

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

import com.hotel_service.entity.Hotel;
import com.hotel_service.hotelService.HotelService;

import lombok.Getter;

@RestController
@RequestMapping("/hotels")
public class HotelController  {
	@Autowired
	private HotelService hotelService; 
	@PostMapping
	public  ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel){
		Hotel hotel1 = this.hotelService.createHotel(hotel);
		return ResponseEntity.status(HttpStatus.CREATED).body(hotel1);
		
	}
	
	@GetMapping("/{hotelId}")
	public  ResponseEntity<Hotel> getHotel(@PathVariable String hotelId){
		Hotel hotel1 = this.hotelService.getHotelByid(hotelId);
		return ResponseEntity.status(HttpStatus.OK).body(hotel1);
		
	}
	
	@GetMapping
	public ResponseEntity<List<Hotel>> getAllHotels(){
		
		List<Hotel> hotelList = this.hotelService.getAllHotels();
		return ResponseEntity.ok(hotelList);
		
	}
	
	
	

}
