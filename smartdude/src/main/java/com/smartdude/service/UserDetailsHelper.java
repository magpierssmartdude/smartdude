package com.smartdude.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.smartdude.entity.QueueManager;
import com.smartdude.entity.Role;
import com.smartdude.entity.User;
import com.smartdude.entity.exception.EntitySaveException;
import com.smartdude.mapper.UserMapper;
import com.smartdude.repository.UserRepository;

@Component
public class UserDetailsHelper {

	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private UserRepository userRepository;
	
	public void addQManagerToUserTable(QueueManager queueManager) throws EntitySaveException {
		try {
		User user = userMapper.queueManagerToUser(queueManager);
		List<Role> roles = new ArrayList<>();
		Role role = new Role();
		role.setRoleCode("QM");
		roles.add(role);
		user.setRoles(roles);
		userRepository.save(user);
	} catch (Exception e) {
		throw new EntitySaveException("Error Occured While adding The queue manager Details. Please Try Again."+ e);
	}
	
	}
}
