package com.bi.biproxyapi.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "dim_autor_emenda")
public class AutorEmenda {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_autor;
		
	public Long getId_autor() {
		return id_autor;
	}
	public void setId_autor(Long id_autor) {
		this.id_autor = id_autor;
	}


	private String cod_autor;
	
	public String getCod_autor() {
		return cod_autor;
	}
	public void setCod_autor(String cod_autor) {
		this.cod_autor = cod_autor;
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
		result = prime * result + ((id_autor == null) ? 0 : id_autor.hashCode());
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
		AutorEmenda other = (AutorEmenda) obj;
		if (id_autor == null) {
			if (other.id_autor != null)
				return false;
		} else if (!id_autor.equals(other.id_autor))
			return false;
		return true;
	}

	

	
	
	
	
}
