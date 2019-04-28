package com.smartdude.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.smartdude.dto.LocationDetailDTO;
import com.smartdude.entity.LocationDetail;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface LocationDetailMapper {

	LocationDetailDTO locationDetailToLocationDetailDTO(LocationDetail locationDetail);
}
