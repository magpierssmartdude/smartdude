package com.smartdude.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.smartdude.dto.VendorDTO;
import com.smartdude.entity.LocationDetail;
import com.smartdude.entity.Vendor;
import com.smartdude.entity.exception.EntityNotFoundException;
import com.smartdude.entity.exception.EntitySaveException;
import com.smartdude.service.LocationDetailService;
import com.smartdude.service.VendorDetailsService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class VendorDetailsController {

	@Autowired
	private VendorDetailsService vendorDetailsService;

	@Autowired
	private LocationDetailService locationDetailsService;

	@ApiOperation(value = "To Save Vendor Details", response = Vendor.class, nickname = "Vendor SignUp")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = Vendor.class),
			@ApiResponse(code = 500, message = "ENS-> Error While Saving Vendor Details", response = com.smartdude.entity.exception.Error.class) })
	@PostMapping(value = "/smartdude/signup", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Vendor> vendorSignUp(
			@ApiParam(value = "Vendor details like Vendor Code & Vendor Name", required = true, name = "VendorDTO") @RequestBody VendorDTO vendorDTO)
			throws EntitySaveException {
		Vendor vendor = vendorDetailsService.vendorSignUp(vendorDTO);
		return new ResponseEntity<>(vendor, HttpStatus.OK);
	}

	@ApiOperation(value = "To Update Vendor Authenticating Details With Active Status Changed", response = Vendor.class, nickname = "Vendor Authentication Update")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = Vendor.class),
			@ApiResponse(code = 500, message = "ENS -> Error While Saving Vendor Details", response = com.smartdude.entity.exception.Error.class) })
	@PutMapping("/admin/updateVendorStatus")
	public ResponseEntity<Vendor> activteStatus(
			@ApiParam(value = "Vendor Details With Updated Active Status", required = true, name = "VendorDTO") @RequestBody VendorDTO vendorDTO)
			throws EntitySaveException {
		Vendor vendor = vendorDetailsService.updateActiveStatus(vendorDTO);
		return new ResponseEntity<>(vendor, HttpStatus.OK);
	}

	@ApiOperation(value = "To Get Vendor Details With Their Code", response = Vendor.class, nickname = "Vendor Detail")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = Vendor.class),
			@ApiResponse(code = 404, message = "ENF -> Vendor Details Not Found For the Given Vendor ID", response = com.smartdude.entity.exception.Error.class) })
	@GetMapping("/admin/getVendor/{vendorId}")
	public ResponseEntity<Vendor> getVendorsByCode(
			@ApiParam(value = "Vendor's Unique Code", required = true, allowMultiple = false, name = "vendorId") @PathVariable Integer vendorId)
			throws EntityNotFoundException {
		Vendor vendor = vendorDetailsService.findByVendorid(vendorId);
		return new ResponseEntity<>(vendor, HttpStatus.OK);
	}

	@ApiOperation(value = "To Save Vendor Details", response = Vendor.class, nickname = "Vendor SignUp")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = Vendor.class),
			@ApiResponse(code = 500, message = "ENS-> Error While Saving Vendor Location Details", response = com.smartdude.entity.exception.Error.class) })
	@PostMapping("/vendor/saveLocation")
	public LocationDetail saveLocation(@RequestBody LocationDetail locationDetail) throws EntitySaveException {
		return locationDetailsService.save(locationDetail);
	}
	
	@PutMapping("/vendor/updateLocation/{locationID}")
	public LocationDetail updateLocation(@RequestBody LocationDetail locationDetail,@PathVariable("locationID") Integer locationID) throws EntitySaveException {
		locationDetail.setLocationid(locationID);
		return locationDetailsService.save(locationDetail);
	}
	
	@GetMapping("/vendor/findAllLocations")
	public List<LocationDetail> findAllLocations() throws EntitySaveException {
		return locationDetailsService.findAllLocations();
	}
	
	
	@DeleteMapping("/vendor/deleteLocation/{locationID}")
	public void deleteLocation(@PathVariable("locationID") Integer locationID) {
		locationDetailsService.deleteById(locationID);
	}
	
	@GetMapping("/admin/findAllVendors")
	public List<Vendor> findAllUsers(){
		return vendorDetailsService.findAllVendors();
	}
	
}
