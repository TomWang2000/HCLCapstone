package com.hcl.ecommcapstone.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.ecommcapstone.dto.AddToCartDto;
import com.hcl.ecommcapstone.entity.Invoice;
import com.hcl.ecommcapstone.entity.Product;
import com.hcl.ecommcapstone.entity.ShoppingCart;
import com.hcl.ecommcapstone.entity.User;
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
	
	@GetMapping("/cart/")
	public ShoppingCart getCart(@RequestParam Long sessionId) {
		return shoppingCartService.getCart(sessionId);
	}
	
	@PostMapping("/cart/add")
	public ShoppingCart addCart(@RequestBody AddToCartDto addToCartDto) {
		Optional<Invoice> optionalInvoice = invoiceRepository.findById(addToCartDto.getOrderId());
		Optional<Product> optionalProduct = productRepository.findById(addToCartDto.getOrderId());
		return shoppingCartService.addToCart(addToCartDto, optionalInvoice.get(), optionalProduct.get());
	}
	
	@DeleteMapping("/cart/delete")
	public String deleteCart(@RequestParam Long sessionId) {
		shoppingCartService.deleteCart(sessionId);
		return "Session " + sessionId + " has been deleted";
	}
	
	@DeleteMapping("/cart/product/delete")
	public String deleteCartItem(@RequestParam Long productId) {
		shoppingCartService.deleteItem(productId);
		return "Product " + productId + " has been deleted";
	}
	
	@GetMapping("/cart/all")
	public List<ShoppingCart> getAllCarts(int pageNumber, int pageSize) {
		return shoppingCartService.getAllCarts(pageNumber, pageSize);
	}
	
}
