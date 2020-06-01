package com.bi.biproxyapi.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "dim_ne_emenda")
public class NeEmenda {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id_ne;
	
	public String getId_ne() {
		return id_ne;
	}
	public void setId_ne(String id_ne) {
		this.id_ne = id_ne;
	}


	private Long ano_documento;
	public Long getAno_documento() {
		return ano_documento;
	}
	public void setAno_documento(Long ano_documento) {
		this.ano_documento = ano_documento;
	}
	
	
	private String cod_ne;
	public String getCod_ne() {
		return cod_ne;
	}
	public void setCod_ne(String cod_ne) {
		this.cod_ne = cod_ne;
	}
	
	private String observacao;
	public String getObservacao() {
		return observacao;
	}
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	
	
	private String cod_processo;
	public String getCod_processo() {
		return cod_processo;
	}

	public void setCod_processo(String cod_processo) {
		this.cod_processo = cod_processo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id_ne == null) ? 0 : id_ne.hashCode());
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
		NeEmenda other = (NeEmenda) obj;
		if (id_ne == null) {
			if (other.id_ne != null)
				return false;
		} else if (!id_ne.equals(other.id_ne))
			return false;
		return true;
	}
	
	
	
	
	
	
}
