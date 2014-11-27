package model;

import org.joda.time.DateTime;

public interface Quarto {
	
 	public Double calculaDiaria();
	
	public String getNumero();
	
	public void setNumero(String numero);
	
	public DateTime getDataEntrada();
	
	public Boolean getEstaOcupado();
	
	public void setEstaOcupado(Boolean estaOcupado);
	
}
