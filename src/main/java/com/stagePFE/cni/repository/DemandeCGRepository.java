package com.stagePFE.cni.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stagePFE.cni.models.DemandeCG;

public interface DemandeCGRepository extends JpaRepository<DemandeCG, Long>{
	List<DemandeCG> findByUserId(Long userId);
	Optional<DemandeCG> findByIdAndUserId(Long id, Long userId);
}


