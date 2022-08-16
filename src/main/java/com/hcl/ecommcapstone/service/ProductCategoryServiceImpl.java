package com.hcl.ecommcapstone.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.ecommcapstone.dto.ProductCategoryDto;
import com.hcl.ecommcapstone.entity.Product;
import com.hcl.ecommcapstone.entity.ProductCategory;
import com.hcl.ecommcapstone.repository.ProductCategoryRepository;

@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {

	@Autowired
	ProductCategoryRepository productCategoryRepository;

	@Override
	public ProductCategory addProductCategory(ProductCategoryDto productCategoryDto) {
		ProductCategory productCategory = new ProductCategory();
		BeanUtils.copyProperties(productCategoryDto, productCategory);
		return productCategoryRepository.save(productCategory);
	}

	@Override
	public ProductCategory getProductCategory(Long categoryId) {
		Optional<ProductCategory> productCategory = productCategoryRepository.findById(categoryId);
		if (productCategory.isPresent()) {
			return productCategory.get();
		}
		return null;
	}

	@Override
	public void deleteProductCategory(Long categoryId) {
		productCategoryRepository.deleteById(categoryId);
	}

	@Override
	public List<ProductCategory> getAllProductCategories(int pageNumber, int pageSize) {
		return productCategoryRepository.findAll();
	}

	@Override
	public ProductCategory updateProduct(ProductCategoryDto productCategoryDto) {
		ProductCategory productCategory = getProductCategory(productCategoryDto.getCatergoryId());
		if(productCategory != null) {
			BeanUtils.copyProperties(productCategoryDto, productCategory);
			return productCategoryRepository.save(productCategory);
		}
		return null;
	}
}
