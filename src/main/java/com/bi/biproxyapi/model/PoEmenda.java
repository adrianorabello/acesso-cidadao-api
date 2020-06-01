package com.bi.biproxyapi.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "dim_po_emenda")
public class PoEmenda {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_po;
		

	public Long getId_po() {
		return id_po;
	}
	public void setId_po(Long id_po) {
		this.id_po = id_po;
	}


	private String cod_po;
	
	public String getCod_po() {
		return cod_po;
	}
	
	public void setCod_po(String cod_po) {
		this.cod_po = cod_po;
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
		result = prime * result + ((id_po == null) ? 0 : id_po.hashCode());
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
		PoEmenda other = (PoEmenda) obj;
		if (id_po == null) {
			if (other.id_po != null)
				return false;
		} else if (!id_po.equals(other.id_po))
			return false;
		return true;
	}
	
	
	
	
	
}
