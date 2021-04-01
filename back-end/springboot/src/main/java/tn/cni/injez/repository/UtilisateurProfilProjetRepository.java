package tn.cni.injez.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.cni.injez.model.UtilisateurProfilProjet;


@Repository
public interface UtilisateurProfilProjetRepository extends JpaRepository<UtilisateurProfilProjet, Integer>{

}
