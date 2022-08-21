package com.hcl.ecommcapstone.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.ecommcapstone.dto.AddToCartDto;
import com.hcl.ecommcapstone.entity.Invoice;
import com.hcl.ecommcapstone.entity.Product;
import com.hcl.ecommcapstone.entity.ShoppingCart;
import com.hcl.ecommcapstone.repository.InvoiceRepository;
import com.hcl.ecommcapstone.repository.ProductRepository;
import com.hcl.ecommcapstone.service.ShoppingCartService;

@RestController
public class ShoppingCartController {
	
	@Autowired
	ShoppingCartService shoppingCartService;
	
	@Autowired
	InvoiceRepository invoiceRepository;
	
	@Autowired
	ProductRepository productRepository;
	
	@GetMapping("/cart/{sessionId}")
	public ShoppingCart getCart(@PathVariable Long sessionId) {
		return shoppingCartService.getCart(sessionId);
	}
	
	@PostMapping("/cart/add")
	public ShoppingCart addCart(@RequestBody AddToCartDto addToCartDto) {
		Optional<Invoice> optionalInvoice = invoiceRepository.findById(addToCartDto.getOrderId());
		Optional<Product> optionalProduct = productRepository.findById(addToCartDto.getOrderId());
		return shoppingCartService.addToCart(addToCartDto, optionalInvoice.get(), optionalProduct.get());
	}
}
