package com.stagepfe.cni.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stagepfe.cni.models.UploadFichier;

@Repository
public interface FileRepository extends JpaRepository<UploadFichier, String> {
	List<UploadFichier> findByUserId(Long userId);
}
