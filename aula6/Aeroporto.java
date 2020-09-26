package br.edu.imed;

public class Aeroporto {

	private String codigo;
	private Double tamanhoPista;
	private String cidade;
	
	public Aeroporto () { 
		
	}
	
	public Aeroporto (String codigo) { 
		
		this.codigo = codigo;
	}
	
	public Aeroporto (String codigo, Double tamanhoPista) { 
		this(codigo);
		this.tamanhoPista = tamanhoPista;
	}
	
	public Aeroporto (String codigo, Double tamanhoPista, String cidade) {
		this(codigo, tamanhoPista);
		this.cidade = cidade;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo.toUpperCase();
	}

	public Double getTamanhoPista() {
		return tamanhoPista;
	}

	public void setTamanhoPista(Double tamanhoPista) {
		this.tamanhoPista = tamanhoPista;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	
	
}
