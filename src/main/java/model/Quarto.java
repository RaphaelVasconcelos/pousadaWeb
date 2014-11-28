package model;

import org.joda.time.DateTime;

public interface Quarto {
	
 	public Double calculaDiaria();
	
	public Integer getNumero();
	
	public void setNumero(Integer numero);
	
	public DateTime getDataEntrada();
	
	public Boolean getEstaOcupado();
	
	public void setEstaOcupado(Boolean estaOcupado);
	
}
