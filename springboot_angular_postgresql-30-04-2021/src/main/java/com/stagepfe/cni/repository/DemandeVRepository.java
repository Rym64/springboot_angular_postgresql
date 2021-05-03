package com.stagepfe.cni.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stagepfe.cni.models.DemandeV;





public interface DemandeVRepository extends JpaRepository<DemandeV, Long>{
	List<DemandeV> findByVehiculeId(Long vehiculeId);
}