package com.smartdude.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.smartdude.entity.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>{
	@Query("{'userName' : ?0}")
	public Optional<User> searchByName(String personName);
}
