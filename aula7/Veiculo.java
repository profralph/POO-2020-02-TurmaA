package br.edu.imed.modelo;

public class Veiculo { 

	private String placa;
	private String fabricante;
	private int anoModelo;
	
	@Override
	public String toString() {
		
		return placa + "," + fabricante + "," + anoModelo;
	}

	public Veiculo(String p, String f, int a) {
		this.setPlaca(p);
		this.setFabricante(f);
		this.setAnoModelo(a);
	}
	
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public String getFabricante() {
		return fabricante;
	}
	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	public int getAnoModelo() {
		return anoModelo;
	}

	public void setAnoModelo(int anoModelo) {
		this.anoModelo = anoModelo;
	}
	
}

