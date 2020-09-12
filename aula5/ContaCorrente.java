package br.edu.imed;

import java.util.*;

// Classe de negócio
public class ContaCorrente {

	/*
	 * Primitivas (valor físico da memória):
	 * int, float, double, char, boolean, short, long
	 * 
	 * Wrapper (objeto):
	 * Integer, Float, Double, Char, Boolean, Short, Long
	 * */
	
	Cliente titular;
	static Integer numero = 0;
	Integer numeroConta;
	String agencia;
	String banco;
	Double saldo;
	String dataAbertura;
	String dataFechamento;
	Double limiteChequeEspecial = 0d;
	Double valorJurosLimite = 0d;
	static final Double percentualLimite = 0.1; // constante
	static final Double percentualJuros = 0.02; // constante
	// Vetor dinâmico (aloca novas posições automaticamente)
	ArrayList<String> historico = new ArrayList<String>();
			
	public void sacar(Double valor) {
		
		// 120d > (80d + 30d) 
		if (valor > (saldo + limiteChequeEspecial)) {
			
			System.out.println("Valor solicitado excede disponibilidades.");			
		
		} else {
		
			// Valor solicitado excede o saldo
			if (valor > saldo) {
	
				Double sobra = valor - saldo;
				
				saldo = 0d;
							
				limiteChequeEspecial -= sobra;			
				
				historico.add("Saque de "+valor+" da conta.");
				
			} else {
			
				if (saldo == 0) {
					
					limiteChequeEspecial -= valor;
					
				} else {
				
					saldo -= valor;
				}
				
				historico.add("Saque de "+valor+" da conta.");
			}
		}
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
	
	public void abrirConta(Cliente novoTitular) {
		
		numeroConta = ++numero;
		dataAbertura = "11/09/2020";
				
		limiteChequeEspecial = novoTitular.salario * percentualLimite;
		
		titular = novoTitular;
		
		System.out.println("O número da nova conta é "+numeroConta);
	}
	
	public void calcularJurosLimite() {
		
		valorJurosLimite += limiteChequeEspecial * percentualJuros;
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
