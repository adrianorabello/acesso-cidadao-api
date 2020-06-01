package com.bi.biproxyapi.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "dim_orgao_emenda")
public class OrgaoEmenda {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_orgao;
		
	public Long getId_orgao() {
		return id_orgao;
	}

	public void setId_orgao(Long id_orgao) {
		this.id_orgao = id_orgao;
	}


	private String cod_orgao;
	
	public String getCod_orgao() {
		return cod_orgao;
	}
	public void setCod_orgao(String cod_orgao) {
		this.cod_orgao = cod_orgao;
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

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id_orgao == null) ? 0 : id_orgao.hashCode());
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
		OrgaoEmenda other = (OrgaoEmenda) obj;
		if (id_orgao == null) {
			if (other.id_orgao != null)
				return false;
		} else if (!id_orgao.equals(other.id_orgao))
			return false;
		return true;
	}

	
	
	
	
}
