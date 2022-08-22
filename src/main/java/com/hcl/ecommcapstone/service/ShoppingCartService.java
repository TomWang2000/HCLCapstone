package com.hcl.ecommcapstone.service;

import java.util.List;

import com.hcl.ecommcapstone.dto.AddToCartDto;
import com.hcl.ecommcapstone.dto.ProductDto;
import com.hcl.ecommcapstone.entity.Address;
import com.hcl.ecommcapstone.entity.Invoice;
import com.hcl.ecommcapstone.entity.Product;
import com.hcl.ecommcapstone.entity.ShoppingCart;

public interface ShoppingCartService {

	ShoppingCart getCart(Long sessionId);

	ShoppingCart addToCart(AddToCartDto addToCartDto, Invoice invoice, Product product);

	void deleteCart(Long sessionid);

	void deleteItem(Long productId);

	List<ShoppingCart> getAllCarts(int pageNumber, int pageSize);

}
