package model;

import java.util.HashMap;
import java.util.Map;

public class Pousada {
	
	private Map<Integer, Quarto> quartosOcupados = new HashMap<Integer, Quarto>();
	private Map<Integer, Quarto> quartosLivres = new HashMap<Integer, Quarto>();
	
	public Map<Integer, Quarto> getQuartosOcupados() {
		return quartosOcupados;
	}
	public void setQuartosOcupados(Map<Integer, Quarto> quartosOcupados) {
		this.quartosOcupados = quartosOcupados;
	}
	public Map<Integer, Quarto> getQuartosLivres() {
		return quartosLivres;
	}
	public void setQuartosLivres(Map<Integer, Quarto> quartosLivres) {
		this.quartosLivres = quartosLivres;
	}
	
}
