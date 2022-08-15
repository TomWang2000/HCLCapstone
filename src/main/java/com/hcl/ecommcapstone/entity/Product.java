package com.hcl.ecommcapstone.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "product")
@Setter
@Getter
public class Product {

	@Id
	@Column(name = "product_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long productId;

	@Column(name = "product_name")
	private String productname;

	@Column(name = "unit_price")
	private BigDecimal unitprice;

	@Column(name = "stock_count")
	private int stockcount;

	@Column(name = "date_created")
	private Date datecreated;

	@Column(name = "date_last_updated")
	private Date datelastupdated;

	@Column(name = "image_url")
	private String imageurl;

	@Column(name = "category_id")
	private Long categoryid;

	
}
