package com.smartdude.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.smartdude.dto.UserDTO;
import com.smartdude.entity.User;
import com.smartdude.entity.exception.EntitySaveException;
import com.smartdude.entity.exception.PasswordEncryptionException;
import com.smartdude.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@Api(value = "User Controller", tags = "User API", consumes = "application/json")
public class UserController {

	@Autowired
	private UserService userService;

	@ApiOperation(value = "To Save User Details", response = User.class, nickname = "Save User")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = User.class),
			@ApiResponse(code = 500, message = "ENS -> Error While Saving User Details", response = com.smartdude.entity.exception.Error.class) })
	@PostMapping(value = "/saveUser", consumes = "application/json", produces = "application/json")
	public ResponseEntity<User> saveUser(
			@ApiParam(value = "User Details For Storing In Database", required = true, name = "userDTO") @RequestBody User user)
			throws PasswordEncryptionException, EntitySaveException {
		User savedUser = userService.saveUser(user);
		return new ResponseEntity<>(savedUser, HttpStatus.OK);
	}

	@ApiOperation(value = "To Get Users List", response = User.class, nickname = "User List")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = User.class) })
	@GetMapping(value = "/smartdude/getUser", produces = "application/json")
	public ResponseEntity<List<User>> getUsers() {
		List<User> userList = userService.getUsers();
		return new ResponseEntity<>(userList, HttpStatus.OK);
	}
	
	@GetMapping("/all/findCurrentUser")
	public UserDTO findCurretUser(Principal principle) {
		String name = principle.getName();
		return userService.findUserDTOByuserName(name);
	}
	
}
