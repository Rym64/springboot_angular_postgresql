package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.models.DemandeCG;


public interface DemandeCGRepository extends JpaRepository<DemandeCG, Long> {
	List<DemandeCG> findByUserId(Long userId);	
}
