package com.smartdude.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.smartdude.entity.Locationdetail;

@Repository
public interface LocationdetailRepository extends JpaRepository<Locationdetail, Integer> {

	public void deleteByLocationid(@Param("locationid")int locationid);
}
