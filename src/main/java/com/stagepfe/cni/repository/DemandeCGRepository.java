package com.stagepfe.cni.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stagepfe.cni.models.DemandeCG;

public interface DemandeCGRepository extends JpaRepository<DemandeCG, Long>{
	List<DemandeCG> findByUserId(Long userId);	
}


