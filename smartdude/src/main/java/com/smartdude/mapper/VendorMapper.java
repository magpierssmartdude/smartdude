package com.smartdude.mapper;
import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.smartdude.dto.VendorDTO;
import com.smartdude.entity.Vendor;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface VendorMapper {
	Vendor vendorDTOToVendor(VendorDTO dto);
	VendorDTO vendorToVendorDTO(Vendor vendor);
	List<VendorDTO> vendorListToVendorDTOList(List<Vendor> vendorList);
}
