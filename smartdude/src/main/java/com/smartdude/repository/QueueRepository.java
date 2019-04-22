package com.smartdude.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smartdude.entity.Queue;

public interface QueueRepository extends JpaRepository<Queue, Integer>{

}
