package com.bi.biproxyapi.model;

public class Indicador {
	
	private String indicador;
	private Double valor;
	private String unidade;
	private Double min;
	private Double max;
	
	public String getIndicador() {
		return indicador;
	}
	public void setIndicador(String indicador) {
		this.indicador = indicador;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	public String getUnidade() {
		return unidade;
	}
	public void setUnidade(String unidade) {
		this.unidade = unidade;
	}
	public Double getMin() {
		return min;
	}
	public void setMin(Double min) {
		this.min = min;
	}
	public Double getMax() {
		return max;
	}
	public void setMax(Double max) {
		this.max = max;
	}
}
