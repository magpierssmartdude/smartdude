package com.smartdude.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.smartdude.entity.Queue;

public interface QueueRepository extends JpaRepository<Queue, Integer> {

	public List<Queue> findByLocationQueueManagerAssociationLocqmanagerassociationid(
			@Param("locqmanagerassociationid") Integer qmID);

	public Optional<Queue> findByQueueidAndLocationQueueManagerAssociationLocqmanagerassociationid(
			@Param("queueid") Integer queueid, @Param("locqmanagerassociationid") Integer qmID);

}
