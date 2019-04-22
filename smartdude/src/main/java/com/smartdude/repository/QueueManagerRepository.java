package com.smartdude.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smartdude.entity.QueueManager;
@Repository
public interface QueueManagerRepository extends JpaRepository<QueueManager, Integer>{

}
