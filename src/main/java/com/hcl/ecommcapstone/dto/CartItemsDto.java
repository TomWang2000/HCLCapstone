package com.hcl.ecommcapstone.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CartItemsDto {
	private Long id;
	
	private int quantity;
	
	private ProductDto product;
}
