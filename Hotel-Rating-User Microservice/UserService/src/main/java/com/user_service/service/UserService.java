package com.user_service.service;

import java.util.List;

import com.user_service.entity.User;

public interface UserService {
	
	public User saveUser(User user);
	public List<User> getAllUser();
	public User getUser(String userId);
	
	

}
