package com.smartdude.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.smartdude.entity.Role;
import com.smartdude.entity.User;
import com.smartdude.entity.Vendor;
import com.smartdude.entity.exception.EntitySaveException;
import com.smartdude.entity.exception.PasswordEncryptionException;
import com.smartdude.repository.UserRepository;
import com.smartdude.repository.VendorRepository;

@Service
public class UserService {

	/*
	 * @Autowired private UserMapper userMapper;
	 */
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
			throw new PasswordEncryptionException("Password Encryption Is Unsuccessful");
		}
		try {
			return userRepository.save(user);
		} catch (Exception e) {
			throw new EntitySaveException("Error Occured While Creating The User. Please Try Again.");
		}
	}
	
	public List<User> getUsers() {
		return userRepository.findAll();
	}

	
	public User approveVendor(Vendor vendor) throws PasswordEncryptionException, EntitySaveException {
		
	//	User user = userMapper.vendorToUser(vendor);
		User user = new User();
		user.setUsername(vendor.getVendorname());
		user.setClientcode(vendor.getVendorcode());
		user.setPassword(passwordEncoder.encode(vendor.getPassword()));
		
		List<Role> roles = new ArrayList();
		Role adminRole = new Role();
		adminRole.setRoleCode("VENDOR");
		roles.add(adminRole);
		
		Role qmRole = new Role();
		qmRole.setRoleCode("QM");
		roles.add(qmRole);
		
		user.setRoles(roles);
		
		Vendor userVendor = new Vendor();
		userVendor.setVendorid(vendor.getVendorid());
		user.setVendor(userVendor);
		
		vendor.setAuthendicatedtime(LocalDateTime.now());
		vendor.setStatus(true);
		vendorRepository.save(vendor);
		saveUser(user);
		return user;
	}

	public User approveVendor(Integer vendorID) throws PasswordEncryptionException, EntitySaveException {
		Vendor vendor=  vendorRepository.findByVendorid(vendorID);
		if(vendor!=null) {
			return approveVendor(vendor);
		}
		return null;
	}
	
}
