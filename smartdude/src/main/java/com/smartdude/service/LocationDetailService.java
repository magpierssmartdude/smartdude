package com.smartdude.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.smartdude.dto.LocationDetailDTO;
import com.smartdude.entity.LocationDetail;
import com.smartdude.entity.exception.EntitySaveException;
import com.smartdude.mapper.LocationDetailMapper;
import com.smartdude.repository.LocationdetailRepository;

@Service
public class LocationDetailService {

	@Autowired
	private LocationdetailRepository locationRepository;
	@Autowired
	private LocationDetailMapper locationDetailMapper;

	@Transactional
	public LocationDetailDTO save(LocationDetail locationDetail) throws EntitySaveException {
		try {
			LocationDetail savedLocationDetail = locationRepository.save(locationDetail);
			LocationDetailDTO locationDetailDTO = locationDetailMapper.locationDetailToLocationDetailDTO(savedLocationDetail);
			return locationDetailDTO;
		} catch (Exception e) {
			throw new EntitySaveException("Error Occured While Saving The Vendor Location Details. Please Try Again.");
		}
	}

	public void deleteById(Integer locationID) {
	
		locationRepository.deleteById(locationID);
		
	}

	public List<LocationDetail> findAllLocations(Integer vendorID) {
		if(vendorID!=null && vendorID!=0) {
		return locationRepository.findByVendorVendorid(vendorID);
		}
		return null;
	}

	public LocationDetail findLocationByLocationID(Integer vendorID, Integer locationID) {
		if(vendorID!=null && vendorID!=0 && locationID!=null && locationID!=0) {
			return locationRepository.findByVendorVendoridAndLocationid(vendorID,locationID);
		}
		return null;
	}

}
