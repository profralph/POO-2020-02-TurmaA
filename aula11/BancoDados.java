package imed;

public enum BancoDados {

	SQLITE("jdbc:sqlite:"),
	MYSQL("");
	
	private String tipo;
	
	private BancoDados(String tipo) {
	
		this.tipo = tipo;
	}

	public String getTipo() {
		return tipo;
	}
}
