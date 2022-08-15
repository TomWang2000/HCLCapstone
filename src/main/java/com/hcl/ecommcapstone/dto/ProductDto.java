package com.hcl.ecommcapstone.dto;

import java.math.BigDecimal;
import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProductDto {
	
	private String productname;
	
	private BigDecimal unitprice;
	
	private int stockcount;
	
	private Date datecreated;
	
	private Date datelastupdated;
	
	private String imageurl;
	
	//private Long categoryid;
	
	
}
