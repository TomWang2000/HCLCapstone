package com.hcl.ecommcapstone.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.ecommcapstone.dto.ProductDto;
import com.hcl.ecommcapstone.entity.Product;
import com.hcl.ecommcapstone.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	ProductService productService;

	@PostMapping("/admin/product/add")
	public Product addProduct(@RequestBody ProductDto productDto) {
		return productService.addProduct(productDto);
	}

	@GetMapping("/admin/product/{productId}")
	public Product getProduct(@PathVariable Long productId) {
		return productService.getProduct(productId);
	}

	@DeleteMapping("/admin/product/delete")
	public String deleteProduct(@RequestParam Long productId) {
		productService.deleteProduct(productId);
		return "Product " + productId + " has been deleted";
	}

	@GetMapping("/admin/product/all")
	public List<Product> getAllProducts(int pageNumber, int pageSize) {
		return productService.getAllProducts(pageNumber, pageSize);
	}
	
	@PostMapping("/admin/product/update")
	public Product updateProduct(@RequestBody ProductDto productDto) {
		return productService.updateProduct(productDto);
	}
}
