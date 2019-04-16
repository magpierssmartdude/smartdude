package com.smartdude.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.smartdude.entity.Vendor;
import com.smartdude.repository.VendorRepository;

@RestController
public class VendorDetailsController {
	
	@Autowired
	private VendorRepository vendorRepository;

	@PostMapping("/smartdude/signup")
	public Vendor vendorSignUp(@RequestBody Vendor vendor) {
		
		LocalDateTime createdTimeStamp = LocalDateTime.now();
		vendor.setCreatedTimeStamp(createdTimeStamp);
		return vendorRepository.save(vendor);
		
	}
	
	@GetMapping("/admin/findAllVendors")
	public List<Vendor> finAllVendors(){
	return vendorRepository.findAll();
	}
	@PutMapping("admin/updateVendor/{vendorID}")
	public Vendor updateVendorDetial(@RequestBody Vendor vendor,@PathVariable("vendorID") String vendorId ) {
		
		LocalDateTime createdTimeStamp = LocalDateTime.now();
		vendor.setAuthendicatedTime(createdTimeStamp);
		return vendorRepository.save(vendor);
	}
	
}
