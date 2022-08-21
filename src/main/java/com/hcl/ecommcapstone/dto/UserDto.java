package com.hcl.ecommcapstone.dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserDto {
	
	private Long userId;
	
	private String firstName;

	private String lastName;

	private String cell;

	private LocalDate date_of_birth;

	private String email;

	private String username;

	private String password;
	
}
