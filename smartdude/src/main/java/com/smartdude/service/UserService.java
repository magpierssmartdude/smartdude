package com.smartdude.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.smartdude.dto.UserDTO;
import com.smartdude.entity.User;
import com.smartdude.entity.exception.EntitySaveException;
import com.smartdude.entity.exception.PasswordEncryptionException;
import com.smartdude.mapper.UserMapper;
import com.smartdude.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserMapper userMapper;

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private UserRepository userRepository;

	
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

}
