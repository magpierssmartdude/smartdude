package com.smartdude.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smartdude.entity.LocationQueueManagerAssociation;

@Repository
public interface LocationQueueManagerAssociationRepository extends JpaRepository<LocationQueueManagerAssociation, Integer> {

}
