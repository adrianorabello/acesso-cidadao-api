package com.bi.biproxyapi.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "dim_emenda_emenda")
public class Emenda {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id_emenda;
		
	public String getId_emenda() {
		return id_emenda;
	}
	public void setId_emenda(String id_emenda) {
		this.id_emenda = id_emenda;
	}


	private String cod_emenda;
	
	public String getCod_emenda() {
		return cod_emenda;
	}
	public void setCod_emenda(String cod_emenda) {
		this.cod_emenda = cod_emenda;
	}


	private String nome;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id_emenda == null) ? 0 : id_emenda.hashCode());
		return result;
	}
	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Emenda other = (Emenda) obj;
		if (id_emenda == null) {
			if (other.id_emenda != null)
				return false;
		} else if (!id_emenda.equals(other.id_emenda))
			return false;
		return true;
	}
	
	
	
	
	
}
