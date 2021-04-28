package com.stagepfe.cni.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stagepfe.cni.models.DemandeCIN;






public interface DemandeCinRepository extends JpaRepository<DemandeCIN, Long>{
	 List<DemandeCIN> findByfirstname(String firstname );

	  List<DemandeCIN> findByaddressContaining(String address);
}

