package br.edu.imed.modelo;

import java.util.ArrayList;

import br.edu.imed.util.ManterArquivos;

// Só serve para herança
public abstract class Conta {
	
	@Override
	public String toString() {
		
		return banco + ManterArquivos.SEP + agencia + ManterArquivos.SEP + saldo;
	}
	
	// Comum com conta corrente
	Cliente titular;
	static Integer numero = 0;
	Integer numeroConta;
	public String agencia;
	String banco;
	public Double saldo;
	String dataAbertura;
	String dataFechamento;
	ArrayList<String> historico = new ArrayList<String>();
	
	public void depositar(Double valor) {
		
		saldo += valor;
		historico.add("Depósito de "+valor+" na conta.");
	}
	
	public void transferir(Double valor, ContaCorrente contaDestino) {
		
		saldo -= valor;
		contaDestino.depositar(valor);
		historico.add("Transferido o valor "+valor+" na conta "+contaDestino.numeroConta+" .");
		System.out.println("Transferido o valor de R$ "+valor+ " para a conta "+contaDestino.numeroConta);
	}
	
	public void abrirConta(Cliente novoTitular) {
		
		numeroConta = ++numero;
		dataAbertura = "11/09/2020";
						
		titular = novoTitular;
		titular.setNome("ABC");
		
		System.out.println("O número da nova conta é "+numeroConta);
	}
	
	public void fecharConta() {
		
		dataFechamento = "04/09/2020";
	}
	
	public void gerarExtrato() {
		
		System.out.println("\n ============= Gerando Extrato ============ \n");		
		
		// For each
		for (String evento : historico) {
			
			System.out.println(evento);			
		}
		
		for (int i=0; i<historico.size(); i++) {
			
			String evento = historico.get(i);
			
			System.out.println(evento);
		}
	}
}
