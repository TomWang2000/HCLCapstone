package com.hcl.ecommcapstone.dto;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class InvoiceCreateDto {
	
	private BigDecimal totalPrice;
	
	private Long userId;
}
