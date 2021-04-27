package com.bezkoder.springjwt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bezkoder.springjwt.models.DemandeCIN;






public interface DemandeCinRepository extends JpaRepository<DemandeCIN, Long>{
	 List<DemandeCIN> findByfirstname(String firstname );

	  List<DemandeCIN> findByaddressContaining(String address);
}

