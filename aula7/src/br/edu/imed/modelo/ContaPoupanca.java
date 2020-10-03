package br.edu.imed.modelo;

public class ContaPoupanca extends Conta implements Armazenavel {
	
	@Override
	public String obterNomeArquivo() {
		return "conta-poupanca.txt";
	}
	
	// Específico
	Double saldoRendimento;
	Double taxaRendimento;
	
	public void renderAplicacao() {
				
		saldoRendimento = saldo * taxaRendimento;
		saldo += saldoRendimento;
	}
}
