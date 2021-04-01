package tn.cni.injez.repository;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import tn.cni.injez.model.Utilisateur;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, String> {
    Optional<Utilisateur> findByUsername(String username);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);
    Optional<Utilisateur> findByName(String imageLocationAndName);
    @Transactional
	@Modifying
	@Query(nativeQuery = true, value="UPDATE public.users SET logged = 0; UPDATE public.project SET current = 0;")
	void logout();
}