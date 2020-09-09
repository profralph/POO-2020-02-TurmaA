package br.edu.imed;

public class SistemaBancario {

	public static void main(String[] args) {
		
		ContaCorrente cc1 = new ContaCorrente();
		cc1.abrirConta();
		cc1.titular = "Ana Maria";
		cc1.banco = "ACME";
		cc1.agencia = "123";
		cc1.saldo = 0d;
		
		cc1.depositar(100d);
		cc1.depositar(200d);
		cc1.sacar(20d);
		
		System.out.println("Saldo da conta: "+cc1.saldo);
						
		ContaCorrente cc2 = new ContaCorrente();
		cc2.abrirConta();
		cc2.titular = "Bruno Silva";
		cc2.banco = "XYZ";
		cc2.agencia = "009";
		cc2.saldo = 0d;
		
		cc1.transferir(75d, cc2);
		
		System.out.println("Saldo da conta: "+cc1.saldo);
		System.out.println("Saldo da conta cc2: "+cc2.saldo);
		
		cc1.gerarExtrato();
	}
}
