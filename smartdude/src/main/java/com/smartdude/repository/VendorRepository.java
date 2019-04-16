package com.smartdude.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.smartdude.entity.Vendor;

@Repository
public interface VendorRepository extends MongoRepository<Vendor, String> {

}
