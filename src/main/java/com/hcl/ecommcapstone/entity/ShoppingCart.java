package com.hcl.ecommcapstone.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "shopping_cart")
@Setter
@Getter
public class ShoppingCart {
	
	@Id
	@Column(name = "session_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long sessionId;
	
	@ManyToOne
	@JoinColumn(name = "order_id")
	private Invoice invoice;
	
	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;
	
	@Column(name = "product_quantity")
	private int productQuantity;

}
