package com.stagepfe.cni.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stagepfe.cni.models.FinanceV;

public interface FinanceVRepository extends JpaRepository<FinanceV, Long>{
	List<FinanceV> findByVehiculeId(Long vehiculeId);

}
