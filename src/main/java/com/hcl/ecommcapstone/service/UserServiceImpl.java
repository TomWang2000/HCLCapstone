package com.hcl.ecommcapstone.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.hcl.ecommcapstone.dto.UserDto;
import com.hcl.ecommcapstone.entity.User;
import com.hcl.ecommcapstone.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	JavaMailSender javaMailSender;
	
	@Override
	public User registerUser(UserDto userDto) {
		User user = new User();
		BeanUtils.copyProperties(userDto, user);
		emailUser(user.getEmail());
		return userRepository.save(user);
	}
	
	private void emailUser(String email) {
        System.out.println("Sending Email...");

        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(email);

        msg.setSubject("User Registration for EcommCapstone Project");
        msg.setText("Thank you for registration!");

        javaMailSender.send(msg);

        System.out.println("Email Sent.");
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
	public User getLogin(String username, String password) {
		return userRepository.findByUsernameAndPassword(username, password);
	}

	@Override
	public User getUserByName(String username, String password) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public User updateUser(UserDto userDto) {
		User user = getUser(userDto.getUserId());
		if(user != null) {
			BeanUtils.copyProperties(userDto, user);
			return userRepository.save(user);
		}
		return null;
	}

	
}
