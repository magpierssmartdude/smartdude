package com.smartdude.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.smartdude.dto.VendorDTO;
import com.smartdude.entity.Vendor;
import com.smartdude.entity.exception.EntityNotFoundException;
import com.smartdude.entity.exception.EntitySaveException;
import com.smartdude.repository.VendorRepository;

@Service
public class VendorDetailsService {

	@Autowired
	private VendorRepository vendoRepository;

	/*
	 * @Autowired private VendorMapper vendorMapper;
	 */

	@Transactional
	public Vendor vendorSignUp(Vendor vendor) throws EntitySaveException {
	//	Vendor vendor = vendorMapper.vendorDTOToVendor(vendorDTO);
		try {
			String vendorFirstName  = vendor.getVendorname().substring(0,2);
			String vendorCode = vendor.getVendorcode();
			String phoneNum = vendor.getPhonenumber().substring(0,4);
			String password = vendorFirstName+vendorCode+phoneNum;
			vendor.setPassword(password);
			vendor.setCreatedTimeStamp(LocalDateTime.now());
			return vendoRepository.save(vendor);
		} catch (Exception e) {
			throw new EntitySaveException("Error Occured While Creating The Vendor. Please Try Again.");
		}
	}

	@Transactional
	public Vendor updateActiveStatus(VendorDTO vendorDTO) throws EntitySaveException {
		try {
			/*
			 * Vendor vendor = vendorMapper.vendorDTOToVendor(vendorDTO);
			 * vendor.setAuthendicatedtime(LocalDateTime.now()); return
			 * vendoRepository.save(vendor);
			 */
			return null;
		} catch (Exception e) {
			throw new EntitySaveException("Error Occured While Authenticating The Vendor. Please Try Again.");
		}
	}

	public Vendor findByVendorid(Integer vendorId) throws EntityNotFoundException {
		Vendor vendor = vendoRepository.findByVendorid(vendorId);
		if (vendor == null) {
			throw new EntityNotFoundException("Vendor Details Not Found For The Given Vendor ID " + vendorId);
		}
		return vendor;
	}

	public List<Vendor> findAllVendors() {
		// TODO Auto-generated method stub
		return vendoRepository.findAll();
	}
}