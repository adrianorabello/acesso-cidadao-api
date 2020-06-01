package com.bi.biproxyapi.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "dim_municipio_emenda")
public class MunicipioEmenda {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_municipio;
		
	public Long getId_municipio() {
		return id_municipio;
	}

	public void setId_municipio(Long id_municipio) {
		this.id_municipio = id_municipio;
	}




	private String cod_municipio;
	

	public String getCod_municipio() {
		return cod_municipio;
	}

	public void setCod_municipio(String cod_municipio) {
		this.cod_municipio = cod_municipio;
	}




	private String nome;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id_municipio == null) ? 0 : id_municipio.hashCode());
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
		MunicipioEmenda other = (MunicipioEmenda) obj;
		if (id_municipio == null) {
			if (other.id_municipio != null)
				return false;
		} else if (!id_municipio.equals(other.id_municipio))
			return false;
		return true;
	}
	
	
	
	
	
}
