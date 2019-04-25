package com.smartdude.dto;

import java.util.List;

import com.smartdude.entity.QueueManager;
import com.smartdude.entity.Role;
import com.smartdude.entity.Vendor;

import lombok.Data;

@Data
public class UserDTO {

	private Integer userid;

	private String username;

	private String clientcode;

	private List<Role> roles;

	private Vendor vendor;

	private QueueManager qmanager;

	private Integer vendorid;

	private Integer qmanagerid;
}
