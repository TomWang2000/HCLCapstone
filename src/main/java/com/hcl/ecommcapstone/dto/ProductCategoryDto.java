package com.hcl.ecommcapstone.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProductCategoryDto {

	private String categoryname;
	
	public String getCategoryName() {
		return categoryname;
	}
	public void setCategoryName(String categoryname) {
		this.categoryname = categoryname;
	}
}
