package com.smartdude.dto;

import java.util.List;

import javax.persistence.Column;

import com.smartdude.entity.Role;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class UserDTO {
	
	@ApiModelProperty(notes = "User Unique ID")
	@Column(name = "user_id")
	private Integer userId;
	
	@ApiModelProperty(notes = "User Name")
	private String userName;
	
	@ApiModelProperty(notes = "Client Code")
	private String clientCode;
	
	@ApiModelProperty(notes = "User Password which will be Encrypted while Storing")
	private String password;
	
	@ApiModelProperty(notes = "List of roles that an user decides to play here")
	private List<Role> roles;
}
