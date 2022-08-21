package com.hcl.ecommcapstone.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AddToCartDto {
	
	private Long productId;
	
	private Long sessionId;
	
	private int productQuantity;
	
	private Long orderId;
	
}
