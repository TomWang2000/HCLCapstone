package com.hcl.ecommcapstone.service;

import java.util.List;

import com.hcl.ecommcapstone.dto.UserDto;
import com.hcl.ecommcapstone.entity.User;

public interface UserService {

	User registerUser(UserDto userDto);

	User getUser(Long userId);

	void deleteUser(Long userId);

	List<User> getAllUsers(int pageNumber, int pageSize);

	User getUserByName(String username, String password);

	User getLogin(String username, String password);

	User updateUser(Long userId, UserDto userDto);

	
	
}
