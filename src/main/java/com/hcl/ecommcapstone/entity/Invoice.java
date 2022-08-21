package com.hcl.ecommcapstone.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

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
@Table(name = "invoice")
@Setter
@Getter
public class Invoice {

	@Id
	@Column(name = "order_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long orderId;

	@Column(name = "total_price")
	private BigDecimal totalprice;
	
	@ManyToOne
	@JoinColumn(name = "address_id")
	private Address addressId;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User userId;

	@Column(name = "date_ordered")
	private LocalDate dateordered;

	@Column(name = "order_status")
	private String orderstatus;
	
	
}
