package com.smartdude.service;

import java.util.List;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.smartdude.dto.LocationDetailDTO;
import com.smartdude.entity.LocationDetail;
import com.smartdude.entity.exception.EntityNotFoundException;
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
			LocationDetailDTO locationDetailDTO = locationDetailMapper
					.locationDetailToLocationDetailDTO(savedLocationDetail);
			return locationDetailDTO;
		} catch(ConstraintViolationException e) {
			throw new EntitySaveException("Error Occured While Saving The Vendor Location Details. Constraint violation exception"+ e);
		}
		catch (Exception e) {
			throw new EntitySaveException("Error Occured While Saving The Vendor Location Details. Please Try Again."+ e);
		}
	}

	@Transactional
	public void deleteById(Integer locationID) throws Exception {
		try {
		locationRepository.deleteById(locationID);
		} catch (Exception e) {
			throw new Exception("Error Occured While Deleting Location Details" + e);
		}
	}

	public List<LocationDetailDTO> findAllLocations(Integer vendorID) throws EntityNotFoundException {
		if (vendorID != null && vendorID != 0) {
			List<LocationDetail> locationDetailList = locationRepository.findByVendorVendorid(vendorID);
			List<LocationDetailDTO> locationDetailDTOList = locationDetailMapper
					.locationDetailListToLocationDetailDTOList(locationDetailList);
			return locationDetailDTOList;
		} else {
			throw new EntityNotFoundException("Location Details Not Found For The Provided Vendor ID " + vendorID );
		}
	}

	public LocationDetailDTO findLocationByLocationID(Integer vendorID, Integer locationID) throws EntityNotFoundException {
		if (vendorID != null && vendorID != 0 && locationID != null && locationID != 0) {
			LocationDetail locationDetail = locationRepository.findByVendorVendoridAndLocationid(vendorID, locationID);
			LocationDetailDTO locationDetailDTO = locationDetailMapper.locationDetailToLocationDetailDTO(locationDetail);
			return locationDetailDTO;
		} else {
			throw new EntityNotFoundException("Location Details Not Found For The Provided Location ID " + locationID);
		}
	}

}
