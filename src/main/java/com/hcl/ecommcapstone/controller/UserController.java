package com.hcl.ecommcapstone.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.ecommcapstone.dto.UserDto;
import com.hcl.ecommcapstone.entity.User;
import com.hcl.ecommcapstone.service.UserService;

@RestController
public class UserController {

	@Autowired
	UserService userService;

	@PostMapping("/register")
	public User registerUser(@RequestBody UserDto userDto) {
		return userService.registerUser(userDto);
	}

	@GetMapping("/{userId}")
	public User getUser(@PathVariable Long userId) {
		return userService.getUser(userId);
	}

	@DeleteMapping("/delete/{userId}")
	public String deleteUser(@PathVariable Long userId) {
		userService.deleteUser(userId);
		return "User " + userId + " has been deleted";
	}

	@GetMapping("/allUsers")
	public List<User> getAllUsers(int pageNumber, int pageSize) {
		return userService.getAllUsers(pageNumber, pageSize);
	}

	@GetMapping("/login")
	public User getUsers(@RequestParam String username, @RequestParam String password) {
		return userService.getUserByName(username, password);
	}
}
