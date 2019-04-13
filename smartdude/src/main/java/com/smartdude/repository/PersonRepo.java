package com.smartdude.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.smartdude.entity.Person;

@Repository
public interface PersonRepo extends MongoRepository<Person, Long>
{
		@Query("{'name' : ?0}")
		public Iterable<Person> searchByName(String personName);

	/*
	 * @Query("db.person.find()") public List<Person> findAll()
	 */;
}
