package com.hcl.ecommcapstone.service;

import java.util.List;

import com.hcl.ecommcapstone.dto.ProductDto;
import com.hcl.ecommcapstone.entity.Product;
import com.hcl.ecommcapstone.entity.ProductCategory;

public interface ProductService {
	
	Product getProduct(Long productId);
	
	void deleteProduct(Long productId);
	
	List<Product> getAllProducts(int pageNumber, int pageSize);

	Product addProduct(ProductDto productDto, ProductCategory productCategory);

	Product updateProduct(ProductDto productDto, ProductCategory productCategory);

	Product findById(Long productId);
	
}
