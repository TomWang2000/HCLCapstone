package com.hcl.ecommcapstone.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.ecommcapstone.dto.UserDto;
import com.hcl.ecommcapstone.entity.User;
import com.hcl.ecommcapstone.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;
	
	@Override
	public User registerUser(UserDto userDto) {
		User user = new User();
		BeanUtils.copyProperties(userDto, user);
		return userRepository.save(user);
	}

	@Override
	public User getUser(Long userId) {
		Optional<User> user = userRepository.findById(userId);
		if (user.isPresent()) {
			return user.get();
		}
		return null;
	}

	@Override
	public void deleteUser(Long userId) {
		userRepository.deleteById(userId);
		
	}

	@Override
	public List<User> getAllUsers(int pageNumber, int pageSize) {
		return userRepository.findAll();
	}

	@Override
	public User getUserByName(String username, String password) {
		return userRepository.findByUsernameAndPassword(username, password);
	}

	
}
