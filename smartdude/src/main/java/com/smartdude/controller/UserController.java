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
import com.smartdude.entity.exception.EntityNotFoundException;
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
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = UserDTO.class),
			@ApiResponse(code = 500, message = "ENS -> Error While Saving User Details, NO_PASS_ENCR -> Error During Password Encryption", response = com.smartdude.entity.exception.Error.class) })
	@PostMapping(value = "/saveUser", consumes = "application/json", produces = "application/json")
	public ResponseEntity<UserDTO> saveUser(
			@ApiParam(value = "User Details", required = true, name = "user") @RequestBody User user)
			throws PasswordEncryptionException, EntitySaveException {
		UserDTO savedUser = userService.saveUser(user);
		return new ResponseEntity<>(savedUser, HttpStatus.OK);
	}

	@ApiOperation(value = "To Get Users List", response = User.class, nickname = "User List")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = UserDTO.class),
			@ApiResponse(code = 404, message = "User Not Found", response = com.smartdude.entity.exception.Error.class)})
	@GetMapping(value = "/smartdude/getUser", produces = "application/json")
	public ResponseEntity<List<UserDTO>> getUsers() throws EntityNotFoundException {
		List<UserDTO> userDTOList = userService.getUsers();
		return new ResponseEntity<>(userDTOList, HttpStatus.OK);
	}

	@ApiOperation(value = "To Get Current User Details", response = UserDTO.class, nickname = "User Details")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = UserDTO.class),
			@ApiResponse(code = 404, message = "User Not Found", response = com.smartdude.entity.exception.Error.class)})
	@GetMapping("/all/findCurrentUser")
	public ResponseEntity<UserDTO> findCurretUser(Principal principle) throws EntityNotFoundException {
		String name = principle.getName();
		UserDTO userDTO = userService.findUserDTOByuserName(name);
		return new ResponseEntity<>(userDTO, HttpStatus.OK);
	}

}
