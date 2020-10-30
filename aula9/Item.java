package vending;

public enum Item {

	COCA("Coca-Cola", 25),
	PEPSI("Pepsi Cola", 35),
	SODA("Soda Limonada", 45);
	
	private String nome;
	private int preco;
	
	private Item(String nome, int preco) {
		this.nome = nome;
		this.preco = preco;
	}

	public String getNome() {
		return nome;
	}

	public int getPreco() {
		return preco;
	}
}
