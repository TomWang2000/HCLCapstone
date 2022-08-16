package com.hcl.ecommcapstone.dto;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProductDto {
	
	private long productId;
	
	private String productname;
	
	private BigDecimal unitprice;
	
	private int stockcount;
	
	private LocalDate datecreated;
	
	private LocalDate datelastupdated;
	
	private String imageurl;
	
	//private Long categoryid;
	
	
}
