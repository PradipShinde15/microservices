package com.user_service.entity.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user_service.entity.User;
import com.user_service.entity.user_serviceImpl.UserServiceImpl;
import com.user_service.service.UserService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RequestMapping("/users")
@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	private Logger logger=LoggerFactory.getLogger(UserController.class);

	@PostMapping
	public ResponseEntity<User> createUser(@RequestBody User user) {
		User user1 = userService.saveUser(user);

		return ResponseEntity.status(HttpStatus.CREATED).body(user1);

	}
	
	@CircuitBreaker(name = "ratingHotelBreaker",fallbackMethod = "ratingHotelFallback")
	@GetMapping("/{userId}")
	public ResponseEntity<User> getUserById(@PathVariable String userId){
		
		logger.info("get single user Handler : UserController");
		User user= userService.getUser(userId);
		return ResponseEntity.ok(user);
		
	}
	//creating fallback method for circuit breaker
	public ResponseEntity<User> ratingHotelFallback(String userId,Exception ex){
		logger.info("Fallback is executed because service is down :{}",ex.getMessage());
		User user=User.builder()
		.email("dummy@gmail.com")
		.name("Dummy")
		.about("This user is created because some service is down")
		.userId("141234")
		.build();
		return ResponseEntity.ok(user);
		
	}
	
	
	@GetMapping
	public ResponseEntity<List<User>> getAllUsers(){
		List<User> userList = userService.getAllUser();
		return ResponseEntity.ok(userList);
		
	}

}
