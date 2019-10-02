package com.smartdude.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name="cartitem")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@AllArgsConstructor
@NoArgsConstructor
public class CartItem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cartitemid")
	private Integer cartItemId;
	
	@Column(name = "itemname")
	private String itemName;
	
	@Column(name = "price")
	private BigDecimal price;
	
	@Column(name = "tax")
	private BigDecimal tax;
	
	@Column(name = "quantity")
	private Integer quantity;
	
	@Column(name = "totalamount")
	private BigDecimal totalAmount;
	
	@Column(name = "discountpercent")
	private Integer discountPercent;
	

}
