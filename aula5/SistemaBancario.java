package br.edu.imed;

// Classe de sistema
public class SistemaBancario {

	public static void main(String[] args) {
		
		Cliente cli = new Cliente();
		cli.nome = "Ana Maria";
		cli.endereco = "Rua X, Nr 0";
		cli.cpf = "12093";
		cli.rg = "43254";
		cli.salario = 2500d;
		
		ContaCorrente cc1 = new ContaCorrente();
		cc1.abrirConta(cli);
		cc1.banco = "ACME";
		cc1.agencia = "123";
		cc1.saldo = 0d;
		
		cc1.calcularJurosLimite();
		cc1.calcularJurosLimite();
		
		//System.out.println("O limite do cliente "+cli.nome+" é de "+cc1.limiteChequeEspecial);
		System.out.println("O cliente "+cli.nome+" deve "+cc1.valorJurosLimite+ " de limite utilizado.");
		
		cc1.depositar(100d);
		cc1.depositar(200d);
		cc1.sacar(20d);
		
		cc1.titular.endereco = "Avenida Pres Vargas, 10";
								
		ContaCorrente cc2 = new ContaCorrente();
		cc2.abrirConta(cli);
		cc2.banco = "XYZ";
		cc2.agencia = "009";
		cc2.saldo = 0d;
		
		cc1.transferir(75d, cc2);
		
		System.out.println("Endereço: "+cli.endereco);
		
		//System.out.println("O saldo da conta Nr: "+cc1.numeroConta+ " titular: "+
		//		cc1.titular.nome+ " é: "+cc1.saldo);
		
		//System.out.println("Numero CC2: "+cc2.numero);
		
		//System.out.println("Saldo da conta: "+cc1.saldo);
		//System.out.println("Saldo da conta cc2: "+cc2.saldo);
		
		//cc1.gerarExtrato();
	}
}
