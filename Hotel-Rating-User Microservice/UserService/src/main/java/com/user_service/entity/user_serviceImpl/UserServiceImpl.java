package com.user_service.entity.user_serviceImpl;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.user_service.Exception.ResourceNotFoundException;
import com.user_service.entity.Hotel;
import com.user_service.entity.Rating;
import com.user_service.entity.User;
import com.user_service.external.services.HotelService;
import com.user_service.repository.UserRepository;
import com.user_service.service.UserService;
@Service
public class UserServiceImpl implements UserService {
	
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private HotelService hotelService;
	
	private Logger logger=LoggerFactory.getLogger(UserServiceImpl.class);

	@Override
	public User saveUser(User user) {
		String randomUserId = UUID.randomUUID().toString();
		user.setUserId(randomUserId);
		return this.userRepository.save(user);
	}

	@Override
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		return this.userRepository.findAll();
	}

	@Override
	public User getUser(String userId) {
		// TODO Auto-generated method stub
		//http://localhost:8989/ratings/users/af0d5a0a-5736-4912-8b8f-44f5f16f555f
		User user=this.userRepository.findById(userId)
				.orElseThrow(()->new ResourceNotFoundException("User "
						+ "with given id is not found on server!! :"+userId));
		Rating[] ratingOfUser = restTemplate.getForObject("http://RATING-SERVICE/ratings/users/"+user.getUserId(), Rating[].class);
		
		logger.info("{}",ratingOfUser);
		List<Rating> ratings = Arrays.stream(ratingOfUser).toList();
		
		List<Rating> ratingList = ratings.stream().map(rating-> {
		//	ResponseEntity<Hotel> forEntity = restTemplate.getForEntity("http://HOTEL-SERVICE/hotels/"+rating.getHotelId(), Hotel.class);
			Hotel hotel = hotelService.getHotel(rating.getHotelId());
			//logger.info("Response Statuse Code : {}" ,forEntity.getStatusCode());
			rating.setHotel(hotel);
			return rating;
		}).collect(Collectors.toList());
		
		
		
			//api call to hotel service to get hotel
			//set hotel to rating
			//forEntity=restTemplate.getForEntity("http://localhost:8888/hotels/2228ada6-79e2-4307-82b4-e7e98ab1d193", Hotel.class);
		
		user.setRatings(ratingList);
		return user;
	
	
	
	}

}
