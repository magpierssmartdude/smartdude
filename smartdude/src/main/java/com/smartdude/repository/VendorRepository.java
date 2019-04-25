package com.smartdude.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.smartdude.entity.Vendor;

@Repository
public interface VendorRepository extends JpaRepository<Vendor, String> {
	
	public Optional<Vendor> findByVendorid(@Param("vendorid")Integer vendorId);

}
