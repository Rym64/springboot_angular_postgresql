package com.stagepfe.cni.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stagepfe.cni.models.Permis;

@Repository
public interface PermisRepository  extends JpaRepository<Permis, Long>{
	List<Permis> findByUserId(Long userId);
}
