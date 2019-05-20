package com.smartdude.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.smartdude.dto.VendorDTO;
import com.smartdude.entity.Vendor;
import com.smartdude.entity.exception.EntityNotFoundException;
import com.smartdude.entity.exception.EntitySaveException;
import com.smartdude.mapper.VendorMapper;
import com.smartdude.repository.VendorRepository;

@Service
public class VendorDetailsService {

	@Autowired
	private VendorRepository vendoRepository;

	@Autowired
	private VendorMapper vendorMapper;

	@Transactional
	public VendorDTO vendorSignUp(Vendor vendor) throws EntitySaveException {
		try {
			String vendorFirstName = vendor.getVendorname().substring(0, 2);
			String vendorCode = vendor.getVendorcode();
			String phoneNum = vendor.getPhonenumber().substring(0, 4);
			String password = vendorFirstName + vendorCode + phoneNum;
			vendor.setPassword(password);
			vendor.setCreatedTimeStamp(LocalDateTime.now());
			Vendor savedVendor = vendoRepository.save(vendor);
			VendorDTO vendorDTO = vendorMapper.vendorToVendorDTO(savedVendor);
			return vendorDTO;
		} catch (Exception e) {
			throw new EntitySaveException("Error Occured While Creating The Vendor. Please Try Again.");
		}
	}

	@Transactional
	public VendorDTO updateActiveStatus(Vendor vendor) throws EntitySaveException {
		try {
			Optional<Vendor> vendorObject = vendoRepository.findByVendorid(vendor.getVendorid());
			if (vendorObject.isPresent()) {
				Vendor updatedVendor = vendorObject.get();
				updatedVendor.setAuthendicatedtime(LocalDateTime.now());
				updatedVendor.setStatus(true);
				Vendor savedObject = vendoRepository.save(updatedVendor);
				VendorDTO vendorDTO = vendorMapper.vendorToVendorDTO(savedObject);
				return vendorDTO;
			} else {
				throw new EntityNotFoundException("Vendor Details Not Found For The Provided Vendor ID " + vendor.getVendorid());
			}
		} catch (Exception e) {
			throw new EntitySaveException("Error Occured While Authenticating The Vendor. Please Try Again.");
		}
	}

	public VendorDTO findByVendorid(Integer vendorId) throws EntityNotFoundException {
		Optional<Vendor> vendor = vendoRepository.findByVendorid(vendorId);
		if (vendor.isPresent()) {
			Vendor vendorDetails = vendor.get();
			VendorDTO vendorDTO = vendorMapper.vendorToVendorDTO(vendorDetails);
			return vendorDTO;
		} else {
			throw new EntityNotFoundException("Vendor Details Not Found For The Given Vendor ID " + vendorId);
		}
	}

	public List<VendorDTO> findAllVendors() throws EntityNotFoundException {
		List<Vendor> vendorList = vendoRepository.findAll();
		List<VendorDTO> vendorDTOList = vendorMapper.vendorListToVendorDTOList(vendorList);
		if (CollectionUtils.isEmpty(vendorDTOList)) {
			throw new EntityNotFoundException("Vendor Details Not Found");
		}
		return vendorDTOList;
	}
}
