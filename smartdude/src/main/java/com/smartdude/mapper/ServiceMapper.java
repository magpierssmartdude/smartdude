package com.smartdude.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.smartdude.dto.ServiceDTO;
import com.smartdude.entity.Service;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ServiceMapper {

	ServiceDTO serviceToServiceDTO (Service service);
}
