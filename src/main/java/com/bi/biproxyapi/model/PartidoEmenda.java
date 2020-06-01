package com.bi.biproxyapi.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "dim_partido_emenda")
public class PartidoEmenda {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_partido;
		

	public Long getId_partido() {
		return id_partido;
	}


	public void setId_partido(Long id_partido) {
		this.id_partido = id_partido;
	}


	private Long cod_partido;
	
	public Long getCod_partido() {
		return cod_partido;
	}

	public void setCod_partido(Long cod_partido) {
		this.cod_partido = cod_partido;
	}




	private String nome;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	private String sigla;

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	
	
	
}
