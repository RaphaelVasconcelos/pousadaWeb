package model;

import org.joda.time.DateTime;

public class QuartoComum implements Quarto {
	
	private Integer numero;
	private Boolean estaOcupado;
	private Boolean possuiBanheira;
	private DateTime dataEntrada;
	private Double tarifa;
	
	@Override
	public Double calculaDiaria() {
		
		if(possuiBanheira){
			return calculaTarifaComBanheira();
		}
		
		return tarifa;
	}
	
	@Override
	public DateTime getDataEntrada() {
		return dataEntrada;
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
	
	public Boolean getPossuiBanheira() {
		return possuiBanheira;
	}
	
	public void setPossuiBanheira(Boolean possuiBanheira) {
		this.possuiBanheira = possuiBanheira;
	}
	
	private Double calculaTarifaComBanheira() {
		
		return tarifa * 1.18;
		
	}
	
	public void setTarifa(Double tarifa) {
		this.tarifa = tarifa;
	}
	
	public Double getTarifa() {
		return tarifa;
	}
	
	public void setDataEntrada(DateTime dataEntrada) {
		this.dataEntrada = dataEntrada;
	}
}
