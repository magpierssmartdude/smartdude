package com.smartdude.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.smartdude.entity.Service;

@Repository
public interface ServiceRepository extends JpaRepository<Service, Integer>	{

	public List<Service> findByQueueQueueid(@Param("queueid")Integer queueid);

	public Optional<Service> findByServiceidAndQueueQueueid(@Param("serviceid")Integer serviceid,@Param("queueid")Integer queueid);
	
}
