package tn.cni.injez.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import tn.cni.injez.model.Objectif;

@Repository
public interface ObjectifRepository extends JpaRepository<Objectif, String>{
	@Transactional
	@Modifying
	@Query(nativeQuery = true, value="UPDATE public.objectif SET current = 0;")
	void updateAll();

}