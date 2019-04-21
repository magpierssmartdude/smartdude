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
import javax.persistence.Table;

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
	@Column(name = "user_id")
	private Integer userId;

	@Column(name = "user_name")
	@ApiModelProperty(notes = "User Name", required = true)
	private String userName;

	@Column(name = "client_code")
	@ApiModelProperty(notes = "Client Code", required = true)
	private String clientCode;

	@Column(name = "password")
	@ApiModelProperty(notes = "User Password which will be Encrypted while Storing", required = true)
	private String password;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id", nullable = false)
	@ApiModelProperty(notes = "List of roles that an user decides to play here", required = true)
	private List<Role> roles;
	
	public User(User user) {
		super();
		this.userName = user.getUserName();
		this.password = user.getPassword();
		this.clientCode = user.getClientCode();
		this.roles = user.getRoles();
	}
}
