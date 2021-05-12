package com.stagepfe.cni.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(	name = "dossiercitoyen")
public class DossierCitoyen {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "image")
	private UploadFichier image;
	
	@Column(name = "certificat")
	private UploadFichier certificat;

	public DossierCitoyen() {
		
	}

	public DossierCitoyen(Long id, UploadFichier image, UploadFichier certificat) {
		super();
		this.id = id;
		this.image = image;
		this.certificat = certificat;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public UploadFichier getImage() {
		return image;
	}

	public void setImage(UploadFichier image) {
		this.image = image;
	}

	public UploadFichier getCertificat() {
		return certificat;
	}

	public void setCertificat(UploadFichier certificat) {
		this.certificat = certificat;
	}

}
