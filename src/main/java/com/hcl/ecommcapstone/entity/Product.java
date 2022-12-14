package com.hcl.ecommcapstone.entity;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
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
	private LocalDate datecreated;

	@Column(name = "date_last_updated")
	private LocalDate datelastupdated;

	@Column(name = "image_url")
	private String imageurl;

	@ManyToOne
	@JoinColumn(name = "category_id")
	private ProductCategory productCategory;
	
	
	
}
