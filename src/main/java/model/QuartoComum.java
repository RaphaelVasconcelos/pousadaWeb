package model;

import org.joda.time.DateTime;

public class QuartoComum implements Quarto {
	
	private String numero;
	private Boolean estaOcupado;
	private Boolean possuiBanheira;
	private DateTime dataEntrada;
	private Double tarifa;
	
	@Override
	public Double calculaDiaria() {
		
		if(possuiBanheira){
			tarifa = calculaTarifaComBanheira(tarifa);
			return tarifa;
		}
		
		return tarifa;
	}
	
	@Override
	public DateTime getDataEntrada() {
		return dataEntrada;
	}
	
	public String getNumero() {
		return numero;
	}
	
	public void setNumero(String numero) {
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
	
	private Double calculaTarifaComBanheira(Double tarifaSimples) {
		
		return tarifaSimples * 1.18;
		
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
