package com.stagepfe.cni.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stagepfe.cni.models.DemandeCIN;

@Repository
public interface DemandeCinRepository extends JpaRepository<DemandeCIN, Long>{
	List<DemandeCIN> findByUserId(Long userId);
}

