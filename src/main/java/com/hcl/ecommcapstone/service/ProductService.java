package com.hcl.ecommcapstone.service;

import java.util.List;

import com.hcl.ecommcapstone.dto.ProductDto;
import com.hcl.ecommcapstone.entity.Product;
import com.hcl.ecommcapstone.entity.User;

public interface ProductService {
	
	Product addProduct(ProductDto productDto);
	
	Product getProduct(Long productId);
	
	void deleteProduct(Long productId);
	
	List<Product> getAllProducts(int pageNumber, int pageSize);

	Product updateProduct(ProductDto productDto);
	
}
