package com.hcl.ecommcapstone.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "product_category")
@Setter
@Getter
public class ProductCategory {
	
	@Id
	@Column(name = "category_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long categoryid;
	
	@Column(name = "category_name")
	private String categoryname;
	
	public Long getCategoryId() {
		return categoryid;
	}
	public void setCategoryId(Long categoryid) {
		this.categoryid = categoryid;
	}
	
	public String getCategoryName() {
		return categoryname;
	}
	public void setCategoryName(String categoryname) {
		this.categoryname = categoryname;
	}
}
