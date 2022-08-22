package com.hcl.ecommcapstone.dto;

import java.math.BigDecimal;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ShoppingCartDto {
	List<CartItemsDto> cartItems;
	
	private BigDecimal totalCost;
}
