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

import com.smartdude.dto.LocationDetailDTO;
import com.smartdude.dto.VendorDTO;
import com.smartdude.entity.LocationDetail;
import com.smartdude.entity.Vendor;
import com.smartdude.entity.exception.EntityNotFoundException;
import com.smartdude.entity.exception.EntitySaveException;
import com.smartdude.service.LocationDetailService;
import com.smartdude.service.VendorDetailsService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@Api(value = "Vendor Details Controller", tags = "Vendor Details API", consumes = "application/json")
public class VendorDetailsController {

	@Autowired
	private VendorDetailsService vendorDetailsService;

	@Autowired
	private LocationDetailService locationDetailsService;

	@ApiOperation(value = "To Save Vendor Details", response = Vendor.class, nickname = "Vendor SignUp")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = VendorDTO.class),
			@ApiResponse(code = 500, message = "ENS-> Error While Saving Vendor Details", response = com.smartdude.entity.exception.Error.class) })
	@PostMapping(value = "/smartdude/signup", consumes = "application/json", produces = "application/json")
	public ResponseEntity<VendorDTO> vendorSignUp(
			@ApiParam(value = "Vendor details like Vendor Code, Vendor Name, Organization Type, Organization Name, Phone Number. All these fields are required to signup", required = true, name = "vendor") @RequestBody Vendor vendor)
			throws EntitySaveException {
		VendorDTO savedVendor = vendorDetailsService.vendorSignUp(vendor);
		return new ResponseEntity<>(savedVendor, HttpStatus.OK);
	}

	@ApiOperation(value = "To Update Vendor Authenticating Details With Active Status Changed", response = VendorDTO.class, nickname = "Vendor Authentication Update")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = VendorDTO.class),
			@ApiResponse(code = 500, message = "ENS -> Error While Updating Vendor Details", response = com.smartdude.entity.exception.Error.class) })
	@PutMapping("/admin/updatevendorstatus")
	public ResponseEntity<VendorDTO> activteStatus(
			@ApiParam(value = "Vendor Id Is Mandatory To Update The Status", required = true, name = "vendor") @RequestBody Vendor vendor)
			throws EntitySaveException {
		VendorDTO vendorDTO = vendorDetailsService.updateActiveStatus(vendor);
		return new ResponseEntity<>(vendorDTO, HttpStatus.OK);
	}

	@ApiOperation(value = "To Get Vendor Details With Their Code", response = VendorDTO.class, nickname = "Vendor Detail")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = VendorDTO.class),
			@ApiResponse(code = 404, message = "ENF -> Vendor Details Not Found For the Given Vendor ID", response = com.smartdude.entity.exception.Error.class) })
	@GetMapping("/admin/getvendor/{vendorId}")
	public ResponseEntity<VendorDTO> getVendorsByCode(
			@ApiParam(value = "Vendor's Unique Code", required = true, allowMultiple = false, name = "vendorId") @PathVariable Integer vendorId)
			throws EntityNotFoundException {
		VendorDTO vendorDTO = vendorDetailsService.findByVendorid(vendorId);
		return new ResponseEntity<>(vendorDTO, HttpStatus.OK);
	}

	@ApiOperation(value = "To Save Vendor Location Details", response = LocationDetailDTO.class, nickname = "Vendor Location Save")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = LocationDetailDTO.class),
			@ApiResponse(code = 500, message = "ENS-> Error While Saving Vendor Location Details", response = com.smartdude.entity.exception.Error.class) })
	@PostMapping("/vendor/savelocation")
	public ResponseEntity<LocationDetailDTO> saveLocation(
			@ApiParam(value = "All Location Details (State, Area, City, Landmark, Building, Floor, Block) Fields Are Mandatory To Save The Details. In Vendor Details , Vendor ID Alone Is Sufficient To Save Location Details", required = true, name = "locationDetail") @RequestBody LocationDetail locationDetail)
			throws EntitySaveException {
		LocationDetailDTO locationDetailDTO = locationDetailsService.save(locationDetail);
		return new ResponseEntity<>(locationDetailDTO, HttpStatus.OK);
	}

	@ApiOperation(value = "To Update Vendor Location Details", response = LocationDetailDTO.class, nickname = "Vendor Location Update")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = LocationDetailDTO.class),
			@ApiResponse(code = 500, message = "ENS-> Error While Saving Vendor Location Details", response = com.smartdude.entity.exception.Error.class) })
	@PutMapping("/vendor/updatelocation/{locationID}")
	public ResponseEntity<LocationDetailDTO> updateLocation(
			@ApiParam(value = "All Location Details (State, Area, City, Landmark, Building, Floor, Block) amoung thesefield need To Be Changed Has To Fill. In Vendor Details , Vendor ID Alone Is Sufficient To Save Location Details", required = true, name = "locationDetail") @RequestBody LocationDetail locationDetail,
			@ApiParam(value = "Location's Unique Code", required = true, allowMultiple = false, name = "locationID") @PathVariable("locationID") Integer locationID)
			throws EntitySaveException {
		locationDetail.setLocationid(locationID);
		LocationDetailDTO locationDetailDTO = locationDetailsService.save(locationDetail);
		return new ResponseEntity<>(locationDetailDTO, HttpStatus.OK);
	}

	@ApiOperation(value = "Get Location Details", response = LocationDetailDTO.class, nickname = "Get Locations")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = LocationDetailDTO.class),
			@ApiResponse(code = 404, message = "ENF-> Location Details Not Found For The Given Vendor ID", response = com.smartdude.entity.exception.Error.class) })
	@GetMapping("/vendor/{vendorID}/locations")
	public ResponseEntity<List<LocationDetailDTO>> findAllLocations(
			@ApiParam(value = "Vendor's Unique Code", required = true, allowMultiple = false, name = "vendorID") @PathVariable("vendorID") Integer vendorID)
			throws EntitySaveException, EntityNotFoundException {
		List<LocationDetailDTO> locationDetailDTOList = locationDetailsService.findAllLocations(vendorID);
		return new ResponseEntity<>(locationDetailDTOList, HttpStatus.OK);
	}

	@ApiOperation(value = "Get Location Detail", response = LocationDetailDTO.class, nickname = "Get Location")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = LocationDetailDTO.class),
			@ApiResponse(code = 404, message = "ENF-> Location Details Not Found For The Given Vendor & Location ID ID", response = com.smartdude.entity.exception.Error.class) })
	@GetMapping("/vendor/{vendorID}/locations/{locationID}")
	public ResponseEntity<LocationDetailDTO> findLocationByID(
			@ApiParam(value = "Vendor's Unique Code", required = true, allowMultiple = false, name = "vendorID") @PathVariable("vendorID") Integer vendorID,
			@ApiParam(value = "Locations's Unique Code", required = true, allowMultiple = false, name = "locationID") @PathVariable("locationID") Integer locationID)
			throws EntityNotFoundException {
		LocationDetailDTO locationDetailDTO = locationDetailsService.findLocationByLocationID(vendorID, locationID);
		return new ResponseEntity<>(locationDetailDTO, HttpStatus.OK);
	}

	@ApiOperation(value = "Delete Location Detail", response = LocationDetailDTO.class, nickname = "Delete Location")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK") })
	@DeleteMapping("/vendor/{vendorID}/deletelocation/{locationID}")
	public void deleteLocation(
			@ApiParam(value = "Location's Unique Code", required = true, allowMultiple = false, name = "locationID") @PathVariable("locationID") Integer locationID,
			@ApiParam(value = "Vendor's Unique Code", required = true, allowMultiple = false, name = "vendorID") @PathVariable("vendorID") Integer vendorID)
			throws Exception {
		locationDetailsService.deleteById(locationID);
	}

	@ApiOperation(value = "Get Vendor List", response = LocationDetailDTO.class, nickname = "Get Vendor")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = VendorDTO.class),
			@ApiResponse(code = 404, message = "ENF-> Vendor Details Not Found", response = com.smartdude.entity.exception.Error.class) })
	@GetMapping("/admin/findallvendors")
	public ResponseEntity<List<VendorDTO>> findAllUsers() throws EntityNotFoundException {
		List<VendorDTO> vendorDTOList = vendorDetailsService.findAllVendors();
		return new ResponseEntity<>(vendorDTOList, HttpStatus.OK);
	}

}
