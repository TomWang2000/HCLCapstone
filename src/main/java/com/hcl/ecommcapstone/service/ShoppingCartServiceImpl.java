package com.hcl.ecommcapstone.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.ecommcapstone.dto.AddToCartDto;
import com.hcl.ecommcapstone.entity.Address;
import com.hcl.ecommcapstone.entity.Invoice;
import com.hcl.ecommcapstone.entity.Product;
import com.hcl.ecommcapstone.entity.ShoppingCart;
import com.hcl.ecommcapstone.repository.ShoppingCartRepository;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {
	
	@Autowired
	ShoppingCartRepository shoppingCartRepository;
	
	@Autowired 
	ProductService productService;
	
	@Override 
	public ShoppingCart getCart(Long sessionId) {
		Optional<ShoppingCart> cart = shoppingCartRepository.findById(sessionId);
		if (cart.isPresent()) {
			return cart.get();
		}
		return null;
	}

	@Override
	public ShoppingCart addToCart(AddToCartDto addToCartDto, Invoice invoice, Product product) {
		ShoppingCart cart = new ShoppingCart();
		BeanUtils.copyProperties(addToCartDto, cart);
		cart.setSessionId(addToCartDto.getSessionId());
		cart.setInvoice(invoice);
		cart.setProduct(product);
		return shoppingCartRepository.save(cart);
		
	}
	
	@Override
	public void deleteCart(Long sessionid) {
		shoppingCartRepository.deleteById(sessionid);
	}

	@Override
	public void deleteItem(Long productId) {
		Optional<ShoppingCart> optionalCart = shoppingCartRepository.findById(productId);
		ShoppingCart cart = optionalCart.get();
		shoppingCartRepository.delete(cart);
	}

	@Override
	public List<ShoppingCart> getAllCarts(int pageNumber, int pageSize) {
		return shoppingCartRepository.findAll();
	}
}
