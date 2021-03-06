package com.smartdude.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.smartdude.entity.QueueManager;

@Repository
public interface QueueManagerRepository extends JpaRepository<QueueManager, Integer> {

	public List<QueueManager> findByVendorVendorid(@Param("vendorid") Integer vendorID);

	public Optional<QueueManager> findByQueuemanageridAndVendorVendorid(@Param("queuemanagerid") Integer queuemanagerid,
			@Param("vendorid") Integer vendorID);

}
