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

import com.smartdude.entity.User;
import com.smartdude.entity.Vendor;
import com.smartdude.repository.UserRepository;
import com.smartdude.repository.VendorRepository;

@RestController
public class VendorDetailsController {
	
	/*
	 * @Autowired private VendorRepository vendorRepository;
	 */
	
//	@Autowired 
	//private PasswordEncoder passwordEncoder;

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private VendorRepository vendoRepository;
	
	/*
	 * @Autowired private RoleRepository roleRepo;
	 */
	
	
	@PostMapping("/smartdude/signup")
	public Vendor vendorSignUp(@RequestBody Vendor vendor) {

		vendor.setCreatedtimestamp(LocalDateTime.now());
		return vendoRepository.save(vendor);
	}
	  
	  @PutMapping("/admin/updateVendorStatus")
	  public Vendor activteStatus(@RequestBody Vendor vendor) {
		  vendor.setAuthendicatedtime(LocalDateTime.now());
		  return vendoRepository.save(vendor);  
	  }
	  
	  @GetMapping("/admin/getVendors")
	  public List<Vendor> getAllVendors(){
		  return vendoRepository.findAll();
	  }
	  
	  @GetMapping("/admin/getVendor/{vendorID}")
	  public Vendor getVendorsByCode(@PathVariable Integer vendorID){
		  return vendoRepository.findByVendorid(vendorID);
	  }
	  
	@PostMapping("/saveUser")
	public User saveUser(@RequestBody User user) {
	//	String password = passwordEncoder.encode(user.getPassword());
		//user.setPassword(password);
		 User userf = userRepository.save(user);
		/*
		 * List<Role> role = user.getRoles();
		 * 
		 * role.forEach(r->{ r.setUsers(userf); }); roleRepo.saveAll(role);
		 */
		 return userf;
		 
	}
	
	@GetMapping("/smartdude/getUser")
	public List<User> getUser() {
		return userRepository.findAll();
	}
	/*
	 * @GetMapping("/admin/findAllVendors") public List<Vendor> finAllVendors(){
	 * return vendorRepository.findAll(); }
	 * 
	 * @PutMapping("admin/updateVendor/{vendorID}") public Vendor
	 * updateVendorDetial(@RequestBody Vendor vendor,@PathVariable("vendorID")
	 * String vendorId ) {
	 * 
	 * LocalDateTime createdTimeStamp = LocalDateTime.now();
	 * vendor.setAuthendicatedTime(createdTimeStamp); return
	 * vendorRepository.save(vendor); }
	 */
	
}
