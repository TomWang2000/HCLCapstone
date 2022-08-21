package com.hcl.ecommcapstone.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class InvoiceCheckoutDto {
	
	private Long invoiceId;
	
	private LocalDate dateOrdered;
	
}
