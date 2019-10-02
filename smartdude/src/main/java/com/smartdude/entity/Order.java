package com.smartdude.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@Table(name = "order")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@AllArgsConstructor
@NoArgsConstructor
public class Order implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "orderid")
	private Integer orderId;
	
	@Column(name = "orderrefid")
	private String orderRefId;
	
	@Column(name = "ordercreatedtime")
	private LocalDateTime orderCreatedTime;
	
	@Column(name = "orderstatus")
	private String orderStatus;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "paymentid", nullable = false)
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Payment paymentId;
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "cartid", nullable = false)
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private List<Cart> cart;
	
}
