package com.hotel_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hotel_service.entity.Hotel;
@Repository
public interface HotelRepositry extends JpaRepository<Hotel, String>{
	
	

}
