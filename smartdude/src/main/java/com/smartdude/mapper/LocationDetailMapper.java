package com.smartdude.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import com.smartdude.dto.LocationDetailDTO;
import com.smartdude.entity.LocationDetail;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface LocationDetailMapper {

	@Mapping(source = "vendor.vendorid", target = "vendorid")
	LocationDetailDTO locationDetailToLocationDetailDTO(LocationDetail locationDetail);
	
	List<LocationDetailDTO> locationDetailListToLocationDetailDTOList(List<LocationDetail> locationDetailList);
}
