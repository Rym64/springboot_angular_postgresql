package com.stagepfe.cni.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.stagepfe.cni.models.ETypeV;
import com.stagepfe.cni.models.TypeEm;

@Repository
public interface TypeEmRepository extends JpaRepository<TypeEm, Long> {
	Optional<TypeEm> findByType(ETypeV name);
}
