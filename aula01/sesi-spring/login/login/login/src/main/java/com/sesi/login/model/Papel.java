package com.sesi.login.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Papel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPapel;
	
	@Column(nullable = false, unique = true)
	private String nomePapel;
	
	

	public Papel() {
	}

	public Papel(Long idPapel, String nomePapel) {
		this.idPapel = idPapel;
		this.nomePapel = nomePapel;
	}

	public Long getIdPapel() {
		return idPapel;
	}

	public void setIdPapel(Long idPapel) {
		this.idPapel = idPapel;
	}

	public String getNomePapel() {
		return nomePapel;
	}

	public void setNomePapel(String nomePapel) {
		this.nomePapel = nomePapel;
	}
	

	
	
	
}
