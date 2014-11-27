package model;

import java.util.HashMap;
import java.util.Map;

public class Pousada {
	
	private Map<String, Quarto> quartosOcupados = new HashMap<String, Quarto>();
	private Map<String, Quarto> quartosLivres = new HashMap<String, Quarto>();
	
	public Map<String, Quarto> getQuartosOcupados() {
		return quartosOcupados;
	}
	public void setQuartosOcupados(Map<String, Quarto> quartosOcupados) {
		this.quartosOcupados = quartosOcupados;
	}
	public Map<String, Quarto> getQuartosLivres() {
		return quartosLivres;
	}
	public void setQuartosLivres(Map<String, Quarto> quartosLivres) {
		this.quartosLivres = quartosLivres;
	}
	
}
