package com.bi.biproxyapi.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "fat_emenda")
public class FatoEmenda {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_fat_emenda;
		
	public Long getId_fat_emenda() {
		return id_fat_emenda;
	}
	public void setId_fat_emenda(Long id_fat_emenda) {
		this.id_fat_emenda = id_fat_emenda;
	}


	private Long id_tempo;
	
	public Long getId_tempo() {
		return id_tempo;
	}
	public void setId_tempo(Long id_tempo) {
		this.id_tempo = id_tempo;
	}
	
	
	private Long id_orgao;

	public Long getId_orgao() {
		return id_orgao;
	}
	public void setId_orgao(Long id_orgao) {
		this.id_orgao = id_orgao;
	}
	
	
	private Long id_uo;

	public Long getId_uo() {
		return id_uo;
	}
	public void setId_uo(Long id_uo) {
		this.id_uo = id_uo;
	}
	
	
	private String id_programa;

	
	public String getId_programa() {
		return id_programa;
	}
	
	public void setId_programa(String id_programa) {
		this.id_programa = id_programa;
	}
	
	
	
	private String id_acao;

	public String getId_acao() {
		return id_acao;
	}

	public void setId_acao(String id_acao) {
		this.id_acao = id_acao;
	}
	
	
	
	private Long id_microrregiao;

	public Long getId_microrregiao() {
		return id_microrregiao;
	}

	public void setId_microrregiao(Long id_microrregiao) {
		this.id_microrregiao = id_microrregiao;
	}
	
	
	private Long id_municipio;

	public Long getId_municipio() {
		return id_municipio;
	}

	public void setId_municipio(Long id_municipio) {
		this.id_municipio = id_municipio;
	}
	
	
	private Long id_esfera;

	public Long getId_esfera() {
		return id_esfera;
	}

	public void setId_esfera(Long id_esfera) {
		this.id_esfera = id_esfera;
	}
	
	
	private Long id_nat_despesa;

	public Long getId_nat_despesa() {
		return id_nat_despesa;
	}

	public void setId_nat_despesa(Long id_nat_despesa) {
		this.id_nat_despesa = id_nat_despesa;
	}
	
	
	private Long id_ug;


	public Long getId_ug() {
		return id_ug;
	}

	public void setId_ug(Long id_ug) {
		this.id_ug = id_ug;
	}
	
	private String id_emenda;

	public String getId_emenda() {
		return id_emenda;
	}
	
	public void setId_emenda(String id_emenda) {
		this.id_emenda = id_emenda;
	}
	
	
	private Long id_autor;

	public Long getId_autor() {
		return id_autor;
	}

	public void setId_autor(Long id_autor) {
		this.id_autor = id_autor;
	}
	
	
	private Long id_partido;

	public Long getId_partido() {
		return id_partido;
	}

	public void setId_partido(Long id_partido) {
		this.id_partido = id_partido;
	}
	
	private Long id_po;

	public Long getId_po() {
		return id_po;
	}

	public void setId_po(Long id_po) {
		this.id_po = id_po;
	}
	
	
	private Long id_iduso;

	public Long getId_iduso() {
		return id_iduso;
	}

	public void setId_iduso(Long id_iduso) {
		this.id_iduso = id_iduso;
	}
	
	private Long id_grupo_fonte;

	
	public Long getId_grupo_fonte() {
		return id_grupo_fonte;
	}

	public void setId_grupo_fonte(Long id_grupo_fonte) {
		this.id_grupo_fonte = id_grupo_fonte;
	}
	
	
	private Long id_fonte;

	public Long getId_fonte() {
		return id_fonte;
	}
	
	public void setId_fonte(Long id_fonte) {
		this.id_fonte = id_fonte;
	}
	
	
	
	private String id_ne;

	public String getId_ne() {
		return id_ne;
	}

	public void setId_ne(String id_ne) {
		this.id_ne = id_ne;
	}
	
	
	private String id_nr;

	public String getId_nr() {
		return id_nr;
	}

	public void setId_nr(String id_nr) {
		this.id_nr = id_nr;
	}
	
	
	private BigDecimal vlr_orcado;

	public BigDecimal getVlr_orcado() {
		return vlr_orcado;
	}

	public void setVlr_orcado(BigDecimal vlr_orcado) {
		this.vlr_orcado = vlr_orcado;
	}
	
	
	private BigDecimal vlr_autorizado;

	public BigDecimal getVlr_autorizado() {
		return vlr_autorizado;
	}

	public void setVlr_autorizado(BigDecimal vlr_autorizado) {
		this.vlr_autorizado = vlr_autorizado;
	}
	
	
	private BigDecimal vlr_suplementado;

	public BigDecimal getVlr_suplementado() {
		return vlr_suplementado;
	}

	public void setVlr_suplementado(BigDecimal vlr_suplementado) {
		this.vlr_suplementado = vlr_suplementado;
	}
	
	private BigDecimal vlr_anulado;

	public BigDecimal getVlr_anulado() {
		return vlr_anulado;
	}

	public void setVlr_anulado(BigDecimal vlr_anulado) {
		this.vlr_anulado = vlr_anulado;
	}
	
	
	
	private BigDecimal vlr_liquidado;

	public BigDecimal getVlr_liquidado() {
		return vlr_liquidado;
	}

	public void setVlr_liquidado(BigDecimal vlr_liquidado) {
		this.vlr_liquidado = vlr_liquidado;
	}
	
	
	private BigDecimal vlr_empenhado;

	public BigDecimal getVlr_empenhado() {
		return vlr_empenhado;
	}

	public void setVlr_empenhado(BigDecimal vlr_empenhado) {
		this.vlr_empenhado = vlr_empenhado;
	}
	
	
	
	private BigDecimal  vlr_disponivel;


	public BigDecimal getVlr_disponivel() {
		return vlr_disponivel;
	}

	public void setVlr_disponivel(BigDecimal vlr_disponivel) {
		this.vlr_disponivel = vlr_disponivel;
	}
	
	
	private BigDecimal   vlr_reservado;

	public BigDecimal getVlr_reservado() {
		return vlr_reservado;
	}

	public void setVlr_reservado(BigDecimal vlr_reservado) {
		this.vlr_reservado = vlr_reservado;
	}
	
	private BigDecimal  vlr_pago;

	public BigDecimal getVlr_pago() {
		return vlr_pago;
	}
	
	public void setVlr_pago(BigDecimal vlr_pago) {
		this.vlr_pago = vlr_pago;
	}
	
	private BigDecimal rap_pago;

	public BigDecimal getRap_pago() {
		return rap_pago;
	}

	public void setRap_pago(BigDecimal rap_pago) {
		this.rap_pago = rap_pago;
	}
	
	
	private BigDecimal rap_a_pagar;

	public BigDecimal getRap_a_pagar() {
		return rap_a_pagar;
	}

	public void setRap_a_pagar(BigDecimal rap_a_pagar) {
		this.rap_a_pagar = rap_a_pagar;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id_fat_emenda == null) ? 0 : id_fat_emenda.hashCode());
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
		FatoEmenda other = (FatoEmenda) obj;
		if (id_fat_emenda == null) {
			if (other.id_fat_emenda != null)
				return false;
		} else if (!id_fat_emenda.equals(other.id_fat_emenda))
			return false;
		return true;
	}
	
	
	
	
	
	
}
