package com.smartdude.entity;

import java.io.Serializable;
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

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "user")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(notes = "User Unique ID")
	@Column(name = "userID")
	private Integer userid;

	@Column(name = "username")
	@ApiModelProperty(notes = "User Name", required = true)
	private String username;

	@Column(name = "clientcode")
	@ApiModelProperty(notes = "Client Code", required = true)
	private String clientcode;

	@Column(name = "password")
	@ApiModelProperty(notes = "User Password which will be Encrypted while Storing", required = true)
	private String password;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "userid", nullable = false)
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@ApiModelProperty(notes = "List of roles that an user decides to play here", required = true)
	private List<Role> roles;
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "orderid", nullable = false)
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private List<Order> order;
	
	@OneToOne(fetch = FetchType.LAZY)
	@ApiModelProperty(notes = "Vendor Unique ID", required = true)
	@JoinColumn(name = "vendorid", nullable = false)
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Vendor vendor;
	
	@OneToOne(fetch = FetchType.LAZY)
	@ApiModelProperty(notes = "queue manager Unique ID", required = true)
	@JoinColumn(name = "qmanagerid", nullable = false)
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private QueueManager qmanager;
	
	public User(User user) {
		super();
		this.username = user.getUsername();
		this.password = user.getPassword();
		this.clientcode = user.getClientcode();
		this.roles = user.getRoles();
		this.qmanager = user.getQmanager();
		this.vendor = user.getVendor();
		this.order = user.getOrder();
	}
}
