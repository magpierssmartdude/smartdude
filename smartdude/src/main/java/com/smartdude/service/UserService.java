package com.smartdude.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.smartdude.dto.UserDTO;
import com.smartdude.entity.Role;
import com.smartdude.entity.User;
import com.smartdude.entity.Vendor;
import com.smartdude.entity.exception.EntityNotFoundException;
import com.smartdude.entity.exception.EntitySaveException;
import com.smartdude.entity.exception.PasswordEncryptionException;
import com.smartdude.mapper.UserMapper;
import com.smartdude.repository.UserRepository;
import com.smartdude.repository.VendorRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserService {

	@Autowired
	private UserMapper userMapper;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private VendorRepository vendorRepository;

	@Transactional
	public User saveUser(User user) throws PasswordEncryptionException, EntitySaveException {
		try {
			String password = passwordEncoder.encode(user.getPassword());
			user.setPassword(password);
		} catch (Exception e) {
			log.info("Error Occured", e.getMessage());
			throw new PasswordEncryptionException("Password Encryption Is Unsuccessful");
		}
		try {
			return userRepository.save(user);
		} catch (Exception e) {
			log.info("Error Occured", e.getMessage());
			throw new EntitySaveException("Error Occured While Creating The User. Please Try Again.");
		}
	}

	public List<User> getUsers() {
		return userRepository.findAll();
	}

	private List<Role> setVendorRoles() {
		List<Role> roleList = new ArrayList<>();
		// Set Vendor Role For The User
		Role adminRole = new Role();
		adminRole.setRoleCode("VENDOR");
		roleList.add(adminRole);

		// Set Vendor Role For The QM
		Role qmRole = new Role();
		qmRole.setRoleCode("QM");
		roleList.add(qmRole);
		return roleList;
	}

	private User prepareUserData(Vendor vendor) throws EntitySaveException {
		try {
			User user = new User();
			user.setUsername(vendor.getVendorname());
			user.setClientcode(vendor.getVendorcode());
			user.setPassword(vendor.getPassword());

			List<Role> roles = setVendorRoles();
			user.setRoles(roles);

			// Set Vendor ID As A Foreign Key In User
			Vendor userVendor = new Vendor();
			userVendor.setVendorid(vendor.getVendorid());
			user.setVendor(userVendor);

			vendor.setAuthendicatedtime(LocalDateTime.now());
			vendor.setStatus(true);
			vendorRepository.save(vendor);
			return user;
		} catch (Exception e) {
			log.info("Error Occured", e.getMessage());
			throw new EntitySaveException("Error Occured While Saving Vendor. Please Try Again.");
		}
	}

	public User saveUser(Vendor vendor) throws EntitySaveException, PasswordEncryptionException {
		User user = prepareUserData(vendor);
		saveUser(user);
		return user;
	}

	public UserDTO approveVendor(Integer vendorID)
			throws PasswordEncryptionException, EntitySaveException, EntityNotFoundException {
		Optional<Vendor> vendor = vendorRepository.findByVendorid(vendorID);
		if (vendor.isPresent()) {
			User user = saveUser(vendor.get());
			UserDTO userDTO = userMapper.userTOUserDTO(user);
			return userDTO;
		} else {
			throw new EntityNotFoundException("Vendor Details Not Found For The Given Vendor ID " + vendorID);
		}
	}

	public UserDTO findUserDTOByuserName(String name) {
		Optional<User> user = userRepository.findByUsername(name);
		if (user.isPresent()) {
			return userMapper.userTOUserDTO(user.get());
		}
		return null;
	}

	public Optional<User> findUserByName(String name) {
		return userRepository.findByUsername(name);
	}

}
