package model;

public class Aluguel {
	
	private String nome;
	private String dataEntrada;
	private String dataSaida;
	private Double valor;
	private Integer qtdHospedes;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDataEntrada() {
		return dataEntrada;
	}
	public void setDataEntrada(String dataEntrada) {
		this.dataEntrada = dataEntrada;
	}
	public String getDataSaida() {
		return dataSaida;
	}
	public void setDataSaida(String dataSaida) {
		this.dataSaida = dataSaida;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	public Integer getQtdHospedes() {
		return qtdHospedes;
	}
	public void setQtdHospedes(Integer qtdHospedes) {
		this.qtdHospedes = qtdHospedes;
	}

}
