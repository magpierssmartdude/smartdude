package com.smartdude.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.smartdude.dto.DaysDTO;
import com.smartdude.entity.Days;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DaysMapper {

	DaysDTO daysToDaysDTO(Days days);
	
	List<DaysDTO> daysListToDaysDTOList(List<Days> days);
}
