package com.hcl.ecommcapstone.service;

import com.hcl.ecommcapstone.dto.AddToCartDto;
import com.hcl.ecommcapstone.dto.ProductDto;
import com.hcl.ecommcapstone.entity.Invoice;
import com.hcl.ecommcapstone.entity.Product;
import com.hcl.ecommcapstone.entity.ShoppingCart;

public interface ShoppingCartService {

	ShoppingCart getCart(Long sessionId);

	ShoppingCart addToCart(AddToCartDto addToCartDto, Invoice invoice, Product product);

}
