package tn.cni.injez.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.cni.injez.model.AutreFinancement;

@Repository
public interface AutreFinancementRepository extends JpaRepository<AutreFinancement, String>{

}
