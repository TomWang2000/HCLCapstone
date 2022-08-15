package com.hcl.ecommcapstone.service;

import java.util.List;

import com.hcl.ecommcapstone.dto.ProductCategoryDto;
import com.hcl.ecommcapstone.entity.ProductCategory;

public interface ProductCategoryService {

	ProductCategory addProductCategory(ProductCategoryDto productCategoryDto);

	ProductCategory getProductCategory(Long categoryId);

	void deleteProductCategory(Long categoryId);

	List<ProductCategory> getAllProductCategories(int pageNumber, int pageSize);

}
