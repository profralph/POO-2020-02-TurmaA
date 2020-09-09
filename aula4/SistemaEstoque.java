package br.edu.imed;

/*
 * Classe de sistema
 * */
public class SistemaEstoque {

	public static void main(String[] args) {
		
		Produto prod = new Produto();
		prod.descricao = "Mouse";
		prod.fabricante = "ACME";
		prod.preco = 9.9;
		
		prod.adicionarEstoque(1);
		prod.removerEstoque(3);
		prod.removerEstoque(5);
		
		System.out.println("Quantidade em estoque: "+prod.quantidadeEstoque);
	}
}
