package com.stagepfe.cni.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stagepfe.cni.models.Demande;

@Repository
public interface DemandeRepository extends JpaRepository<Demande, Long> {
	List<Demande> findByUserId(Long userId);
}
