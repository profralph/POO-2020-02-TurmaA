package br.edu.imed.modelo;

import br.edu.imed.util.ManterArquivos;

// Classe de negócio
public class ContaCorrente extends Conta implements Armazenavel {
	
	/*
	 * Primitivas (valor físico da memória):
	 * int, float, double, char, boolean, short, long
	 * 
	 * Wrapper (objeto):
	 * Integer, Float, Double, Char, Boolean, Short, Long
	 * */
	Double limiteChequeEspecial = 0d;
	Double valorJurosLimite = 0d;
	static final Double percentualLimite = 0.1; // constante
	static final Double percentualJuros = 0.02; // constante
	
	@Override
	public String obterNomeArquivo() {
		return "conta-corrente.txt";
	}
			
	// Construtor: não especifica retorno
	public ContaCorrente() {
		
	}
	
	public ContaCorrente(String banco, String agencia, Double saldo) {
		
		this.banco = banco;
		this.agencia = agencia;
		this.saldo = saldo;
	}
	
	public ContaCorrente(String banco, String agencia, Double saldo, Cliente titular) {
		
		this(banco, agencia, saldo);		
		this.titular = titular;	
	}
	
			
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
	
	public void calcularJurosLimite() {
		
		valorJurosLimite += limiteChequeEspecial * percentualJuros;
	}
	
}
