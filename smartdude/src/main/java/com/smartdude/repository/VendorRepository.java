package com.smartdude.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smartdude.entity.Vendor;

@Repository
public interface VendorRepository extends JpaRepository<Vendor, String> {

	Vendor findOne(Integer vendorID);

}
