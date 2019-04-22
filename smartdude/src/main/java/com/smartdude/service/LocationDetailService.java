package com.smartdude.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.smartdude.entity.LocationDetail;
import com.smartdude.entity.exception.EntitySaveException;
import com.smartdude.repository.LocationdetailRepository;

@Service
public class LocationDetailService {

	@Autowired
	private LocationdetailRepository locationRepository;

	@Transactional
	public LocationDetail save(LocationDetail locationDetail) throws EntitySaveException {
		try {
			return locationRepository.save(locationDetail);
		} catch (Exception e) {
			throw new EntitySaveException("Error Occured While Creating The Vendor Location Details. Please Try Again.");
		}
	}

	public void deleteById(Integer locationID) {
	
		locationRepository.deleteById(locationID);
		
	}

}
