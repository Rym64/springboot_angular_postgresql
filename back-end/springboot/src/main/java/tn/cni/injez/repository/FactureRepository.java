package tn.cni.injez.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.cni.injez.model.Facture;

@Repository
public interface FactureRepository extends JpaRepository<Facture, String>{

}
