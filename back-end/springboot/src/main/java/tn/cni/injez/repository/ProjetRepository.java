package tn.cni.injez.repository;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.cni.injez.model.Decomposition;
import tn.cni.injez.model.Projet;

@Repository
public interface ProjetRepository extends JpaRepository<Projet, String> {
	@Transactional
	public Projet findByCode(String code);
	@Transactional
	public void deleteByCode (String code);
	@Transactional
	@Modifying
	@Query(nativeQuery = true, value="UPDATE public.project SET current = 0;")
	void updateAll();
	
	@Transactional
	@Modifying
	@Query(nativeQuery = true, value="update public.project SET code_financement_public = NULL , libelle_financement_public = NULL, date_financement_public = NULL, montant_financement_public = NULL, montant_financement_public_actualise = NULL , date_actualisation_financement_public = NULL where code = :myStr ;")

	void deleteFinancementPublic(@Param("myStr") String myStr);
}
