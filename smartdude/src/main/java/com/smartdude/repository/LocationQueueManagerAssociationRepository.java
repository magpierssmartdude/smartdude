package com.smartdude.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.smartdude.entity.LocationQueueManagerAssociation;

@Repository
public interface LocationQueueManagerAssociationRepository extends JpaRepository<LocationQueueManagerAssociation, Integer> {

	public LocationQueueManagerAssociation findByQmanagerid(@Param("qmanagerid")Integer qmID);

	public LocationQueueManagerAssociation findByVendorVendorid(@Param("vendorid")Integer vendorID);

}
