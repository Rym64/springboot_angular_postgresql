package com.stagepfe.cni.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stagepfe.cni.models.Vehicule;

@Repository
public interface VehiculeRepository extends JpaRepository<Vehicule, Long> {
	Boolean existsByImmatD(String immatD);
}
