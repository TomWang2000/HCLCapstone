package com.hcl.ecommcapstone.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.hcl.ecommcapstone.entity.Address;
import com.hcl.ecommcapstone.entity.User;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class InvoiceDto {
	
	private Long orderId;
	
	private BigDecimal totalPrice;
	
	private Long addressId;
	//private Address address;
	
	private Long userId;
	//private User user;
	
	private LocalDate dateOrdered;
	
	private String orderStatus;
	
}
