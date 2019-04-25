package com.smartdude.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smartdude.dto.UserDTO;
import com.smartdude.entity.User;
import com.smartdude.entity.exception.EntityNotFoundException;
import com.smartdude.entity.exception.EntitySaveException;
import com.smartdude.entity.exception.PasswordEncryptionException;
import com.smartdude.service.UserService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class AdminController {

	@Autowired
	private UserService userService;

	@ApiOperation(value = "Approve Vendor", response = User.class, nickname = "Vendor Approval")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = User.class),
			@ApiResponse(code = 500, message = "ENS -> Error While Saving Vendor Details Or User Details", response = com.smartdude.entity.exception.Error.class),
			@ApiResponse(code = 404, message = "ENF -> Vendor Details Not Found", response = com.smartdude.entity.exception.Error.class),
			@ApiResponse(code = 500, message = "NO_PASS_ENCR -> Error Occured During Password Encryption", response = com.smartdude.entity.exception.Error.class) })
	@PostMapping("/admin/approveVendor/{vendorID}")
	public ResponseEntity<UserDTO> approveVendor(
			@ApiParam(value = "Vendor's Unique ID", required = true, allowMultiple = false, name = "vendorID") @PathVariable Integer vendorID)
			throws PasswordEncryptionException, EntitySaveException, EntityNotFoundException {
		UserDTO user = userService.approveVendor(vendorID);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}

}
