package com.bi.biproxyapi.model;

import java.math.BigDecimal;

public class ResultadoComposto {

	
	private String ano;
	private String mes;
	private BigDecimal vlrReceita;
	private BigDecimal vlrDespesa;
	private BigDecimal vlrResultado;
	/**
	 * @return the ano
	 */
	public String getAno() {
		return ano;
	}
	/**
	 * @param ano the ano to set
	 */
	public void setAno(String ano) {
		this.ano = ano;
	}
	/**
	 * @return the mes
	 */
	public String getMes() {
		return mes;
	}
	/**
	 * @param mes the mes to set
	 */
	public void setMes(String mes) {
		this.mes = mes;
	}
	/**
	 * @return the vlrReceita
	 */
	public BigDecimal getVlrReceita() {
		return vlrReceita;
	}
	/**
	 * @param vlrReceita the vlrReceita to set
	 */
	public void setVlrReceita(BigDecimal vlrReceita) {
		this.vlrReceita = vlrReceita;
	}
	/**
	 * @return the vlrDespesa
	 */
	public BigDecimal getVlrDespesa() {
		return vlrDespesa;
	}
	/**
	 * @param vlrDespesa the vlrDespesa to set
	 */
	public void setVlrDespesa(BigDecimal vlrDespesa) {
		this.vlrDespesa = vlrDespesa;
	}
	/**
	 * @return the vlrResultado
	 */
	public BigDecimal getVlrResultado() {
		return vlrResultado;
	}
	/**
	 * @param vlrResultado the vlrResultado to set
	 */
	public void setVlrResultado(BigDecimal vlrResultado) {
		this.vlrResultado = vlrResultado;
	}
	
	
	
	
	
}
