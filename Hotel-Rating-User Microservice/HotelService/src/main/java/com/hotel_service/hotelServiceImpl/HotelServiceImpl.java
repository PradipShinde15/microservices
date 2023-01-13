package com.hotel_service.hotelServiceImpl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel_service.entity.Hotel;
import com.hotel_service.exception.ResourceNotFounfException;
import com.hotel_service.hotelService.HotelService;
import com.hotel_service.repository.HotelRepositry;
@Service
public class HotelServiceImpl implements HotelService {
	@Autowired
	private HotelRepositry hotelRepositry;

	@Override
	public Hotel createHotel(Hotel hotel) {
		// TODO Auto-generated method stub
		String id = UUID.randomUUID().toString();
		hotel.setId(id);
		return hotelRepositry.save(hotel);
	}

	@Override
	public List<Hotel> getAllHotels() {
		
		return hotelRepositry.findAll();
	}

	@Override
	public Hotel getHotelByid(String id) {
		
		return hotelRepositry.findById(id).orElseThrow(()->new ResourceNotFounfException("Hotel with given id not found :"+id));
	}

}
