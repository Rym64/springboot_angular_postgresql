package tn.cni.injez.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.cni.injez.model.Etablissement;


@Repository
public interface EtablissementRepository extends JpaRepository<Etablissement, String> {

}
