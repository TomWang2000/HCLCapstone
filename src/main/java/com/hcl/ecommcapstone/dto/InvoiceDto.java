package com.hcl.ecommcapstone.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class InvoiceDto {
	
	private Long orderId;
	
	private BigDecimal totalPrice;
	
	private Long deliverAddress;
	
	private Long userId;
	
	private LocalDate dateOrdered;
	
	private String orderStatus;
	
}
