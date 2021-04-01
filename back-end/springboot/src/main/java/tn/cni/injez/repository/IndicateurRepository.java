package tn.cni.injez.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.cni.injez.model.Indicateur;

@Repository
public interface IndicateurRepository extends JpaRepository<Indicateur, String>{

}