package com.stagepfe.cni.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stagepfe.cni.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	List<User> findByUsernameContaining(String username);
	Optional<User> findByUsername(String username);
	Boolean existsByUsername(String username);

	Boolean existsByEmail(String email);
}
