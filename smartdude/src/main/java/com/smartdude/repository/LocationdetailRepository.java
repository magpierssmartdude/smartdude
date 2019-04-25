package com.smartdude.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.smartdude.entity.LocationDetail;

@Repository
public interface LocationdetailRepository extends JpaRepository<LocationDetail, Integer> {

	public List<LocationDetail> findByVendorVendorid(Integer vendorID);

	public LocationDetail findByVendorVendoridAndLocationid(@Param("vendorid") Integer vendorID,
			@Param("locationid") Integer locationID);

}
