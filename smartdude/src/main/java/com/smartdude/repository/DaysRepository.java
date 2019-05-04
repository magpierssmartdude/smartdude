package com.smartdude.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.smartdude.entity.Days;

@Repository
public interface DaysRepository extends JpaRepository<Days, Integer>{
	
	
	public List<Days> findByServiceServiceid(@Param("serviceid") Integer serviceid);

}
