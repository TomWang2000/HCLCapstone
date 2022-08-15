package com.hcl.ecommcapstone.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.ecommcapstone.dto.ProductDto;
import com.hcl.ecommcapstone.entity.Product;
import com.hcl.ecommcapstone.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	ProductRepository productRepository;
	
	@Override
	public Product addProduct(ProductDto productDto) {
		Product product = new Product();
		BeanUtils.copyProperties(productDto, product);
		return productRepository.save(product);
	}

	@Override
	public Product getProduct(Long productId) {
		Optional<Product> product = productRepository.findById(productId);
		if (product.isPresent()) {
			return product.get();
		}
		return null;
	}

	@Override
	public void deleteProduct(Long productId) {
		productRepository.deleteById(productId);
		
	}

	@Override
	public List<Product> getAllProducts(int pageNumber, int pageSize) {
		return productRepository.findAll();
	}
	
}
