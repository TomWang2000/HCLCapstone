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

import com.hcl.ecommcapstone.dto.ProductCategoryDto;
import com.hcl.ecommcapstone.entity.ProductCategory;
import com.hcl.ecommcapstone.service.ProductCategoryService;

@RestController
public class ProductCategoryController {

	@Autowired
	ProductCategoryService productCategoryService;
	
	@PostMapping("/admin/productcategory/add")
	public ProductCategory addProductCategory(@RequestBody ProductCategoryDto productCategoryDto) {
		return productCategoryService.addProductCategory(productCategoryDto);
	}
	
	@GetMapping("/admin/productcategory/{categoryId}")
	public ProductCategory getProductCategory(@PathVariable Long categoryId) {
		return productCategoryService.getProductCategory(categoryId);
	}
	
	@DeleteMapping("/admin/productcategory/delete")
	public String deleteProductCategory(@RequestParam Long categoryId) {
		productCategoryService.deleteProductCategory(categoryId);
		return "Product Category " + categoryId + " has been deleted";
	}
	
	@GetMapping("/admin/productcategory/all")
	public List<ProductCategory> getAllProducts(int pageNumber, int pageSize) {
		return productCategoryService.getAllProductCategories(pageNumber, pageSize);
	}
	
	@PostMapping("/admin/productcategory/update")
	public ProductCategory updateProductCategory(@RequestBody ProductCategoryDto productCategoryDto) {
		return productCategoryService.updateProduct(productCategoryDto);
	} 
}
