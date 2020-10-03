package br.edu.imed.app;

import br.edu.imed.modelo.Cliente;
import br.edu.imed.modelo.ContaCorrente;
import br.edu.imed.modelo.ContaPoupanca;
import br.edu.imed.util.ManterArquivos;

// Classe de sistema
public class SistemaBancario {

	public static void main(String[] args) {
		
		Cliente cli = new Cliente();
		cli.setNome("Ana Maria");
		cli.setEndereco("Rua X, Nr 0");
		cli.setCpf("12093");
		cli.setRg("43254");
		cli.setSalario(2500d);
		
		ManterArquivos.gravar(cli, true);
		
		ContaCorrente cc1 = new ContaCorrente("ACME", "XYZ", 100d);				
		cc1.abrirConta(cli);
		
		ManterArquivos.gravar(cc1, true);
		
		
		ContaPoupanca cp1 = new ContaPoupanca();
		cp1.agencia = "3212";
		cp1.saldo = 231d;
				
		cc1.calcularJurosLimite();
		cc1.calcularJurosLimite();
		
		//System.out.println("O limite do cliente "+cli.nome+" é de "+cc1.limiteChequeEspecial);
		//System.out.println("O cliente "+cli.nome+" deve "+cc1.valorJurosLimite+ " de limite utilizado.");
		
		cc1.depositar(100d);
		cc1.depositar(200d);
		cc1.sacar(20d);
		
		/*cc1.titular.endereco = "Avenida Pres Vargas, 10";
								
		ContaCorrente cc2 = new ContaCorrente();
		cc2.abrirConta(cli);
		cc2.banco = "XYZ";
		cc2.agencia = "009";
		cc2.saldo = 0d;*/
		
		//cc1.transferir(75d, cc2);
		
		//System.out.println("Endereço: "+cli.endereco);
		
		//System.out.println("O saldo da conta Nr: "+cc1.numeroConta+ " titular: "+
		//		cc1.titular.nome+ " é: "+cc1.saldo);
		
		//System.out.println("Numero CC2: "+cc2.numero);
		
		//System.out.println("Saldo da conta: "+cc1.saldo);
		//System.out.println("Saldo da conta cc2: "+cc2.saldo);
		
		//cc1.gerarExtrato();
	}
}
