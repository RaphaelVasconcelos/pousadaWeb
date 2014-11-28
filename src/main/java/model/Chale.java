package model;

import org.joda.time.DateTime;

public class Chale implements Quarto {
	
	private Integer numero;
	private Boolean estaOcupado;
	private Boolean camaExtra;
	private Integer qtdCamaExtra;
	private DateTime dataEntrada;
	private Double tarifa;
	
	@Override
	public Double calculaDiaria() {
		Double tarifaFinal = tarifa * 1.2;
		
		if(qtdCamaExtra != null){
			tarifaFinal = calculaCamaExtra(tarifaFinal);
		}
		
		return tarifa;
	}
	
	public Boolean getCamaExtra() {
		return camaExtra;
	}
	
	public void setCamasExtra(Boolean camaExtra) {
		this.camaExtra = camaExtra;
	}
	
	public Integer getQtdCamaExtra() {
		return qtdCamaExtra;
	}
	
	public void setQtdCamaExtra(Integer qtdCamaExtra) {
		this.qtdCamaExtra = qtdCamaExtra;
	}
	
	public Integer getNumero() {
		return numero;
	}
	
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	
	public Boolean getEstaOcupado() {
		return estaOcupado;
	}
	
	public void setEstaOcupado(Boolean estaOcupado) {
		this.estaOcupado = estaOcupado;
	}
	
	private Double calculaCamaExtra(Double tarifaFinal) {
		
		return tarifaFinal * (qtdCamaExtra*10 / 100 + 1);
		
	}
	
	public DateTime getDataEntrada() {
		return dataEntrada;
	}
	
	public void setDataEntrada(DateTime dataEntrada) {
		this.dataEntrada = dataEntrada;
	}
	
	public void setCamaExtra(Boolean camaExtra) {
		this.camaExtra = camaExtra;
	}
	
	public void setTarifa(Double tarifa) {
		this.tarifa = tarifa;
	}
	
	public Double getTarifa() {
		return tarifa;
	}
	
}
