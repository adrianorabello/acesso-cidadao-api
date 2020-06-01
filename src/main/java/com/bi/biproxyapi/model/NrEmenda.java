package com.bi.biproxyapi.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "dim_nr_emenda")
public class NrEmenda {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id_nr;
	
	
	public String getId_nr() {
		return id_nr;
	}
	public void setId_nr(String id_nr) {
		this.id_nr = id_nr;
	}


	private Long ano_documento;

	public Long getAno_documento() {
		return ano_documento;
	}
	public void setAno_documento(Long ano_documento) {
		this.ano_documento = ano_documento;
	}
	
	
	private String cod_nr;

	public String getCod_nr() {
		return cod_nr;
	}
	
	public void setCod_nr(String cod_nr) {
		this.cod_nr = cod_nr;
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
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id_nr == null) ? 0 : id_nr.hashCode());
		return result;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NrEmenda other = (NrEmenda) obj;
		if (id_nr == null) {
			if (other.id_nr != null)
				return false;
		} else if (!id_nr.equals(other.id_nr))
			return false;
		return true;
	}
	
	
	
	
	
	
	
}
