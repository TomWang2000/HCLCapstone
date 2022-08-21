package com.hcl.ecommcapstone.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AddressDto {
	
	private Long addressId;
	
	private String street;
	
	private String secondary;
	
	private String city;
	
	private String state;
	
	private int zip;
	
}
