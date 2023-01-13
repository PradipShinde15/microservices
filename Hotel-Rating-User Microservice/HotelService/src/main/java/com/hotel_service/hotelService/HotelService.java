package com.hotel_service.hotelService;

import java.util.List;

import com.hotel_service.entity.Hotel;

public interface HotelService {
	
	Hotel createHotel(Hotel hotel);
	
	List<Hotel> getAllHotels();
	
	Hotel getHotelByid(String id);

}
