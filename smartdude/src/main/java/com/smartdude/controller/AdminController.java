package com.smartdude.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smartdude.entity.User;
import com.smartdude.entity.exception.EntitySaveException;
import com.smartdude.entity.exception.PasswordEncryptionException;
import com.smartdude.service.UserService;

@RestController
public class AdminController {
 
	@Autowired
	private UserService userService;
	
	
	@PostMapping("/admin/approveVendor/{vendorID}")
	public User approveVendor(@PathVariable Integer vendorID) throws PasswordEncryptionException, EntitySaveException {
		return userService.approveVendor(vendorID);
	}


}
