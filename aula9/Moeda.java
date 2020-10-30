package vending;

public enum Moeda {

	CENTAVO(1),
	CINCO(5),
	DEZ(10),
	QUARTO(25);
	
	private int descricao;

	private Moeda(int descricao) {
		this.descricao = descricao;
	}
	
	public int getDescricao() {
		return descricao;
	}
}
