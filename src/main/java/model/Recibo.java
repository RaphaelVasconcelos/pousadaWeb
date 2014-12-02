package model;

import org.joda.time.DateTime;
import org.joda.time.Days;

public class Recibo {
	
	private String locatario;
	private Integer numDiarias;
	
	public String getLocatario() {
		return locatario;
	}
	public void setLocatario(String locatario) {
		this.locatario = locatario;
	}
	
	public Integer getNumDiarias() {
		return numDiarias;
	}
	public void setNumDiarias(Integer numDiarias) {
		this.numDiarias = numDiarias;
	}
	public Double getTotalDevido(Quarto quarto , DateTime datasaida) {
		
		numDiarias = Days.daysBetween(quarto.getDataEntrada(), datasaida).getDays();
		return numDiarias * quarto.calculaDiaria();
	}
}
