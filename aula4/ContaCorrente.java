package br.edu.imed;

import java.util.ArrayList;

public class ContaCorrente {

	String titular;
	static Integer numero = 0;
	Integer numeroConta;
	String agencia;
	String banco;
	Double saldo;
	String dataAbertura;
	String dataFechamento;
	// Vetor dinâmico (aloca novas posições automaticamente)
	ArrayList<String> historico = new ArrayList<String>();
	
	public void sacar(Double valor) {
		
		saldo -= valor;
		historico.add("Saque de "+valor+" da conta.");
	}
	
	public void depositar(Double valor) {
		
		saldo += valor;
		historico.add("Depósito de "+valor+" na conta.");
	}
	
	public void transferir(Double valor, ContaCorrente contaDestino) {
		
		sacar(valor);
		contaDestino.depositar(valor);
		historico.add("Transferido o valor "+valor+" na conta "+contaDestino.numeroConta+" .");
		System.out.println("Transferido o valor de R$ "+valor+ " para a conta "+contaDestino.numeroConta);
	}
	
	public void abrirConta() {
		
		numeroConta = ++numero;
		dataAbertura = "04/09/2020";
		
		System.out.println("O número da nova conta é "+numeroConta);
	}
	
	public void fecharConta() {
		
		dataFechamento = "04/09/2020";
	}
	
	public void gerarExtrato() {
		
		System.out.println("\n ============= Gerando Extrato ============ \n");		
		
		for (String evento : historico) {
			
			System.out.println(evento);
		}
	}
}
