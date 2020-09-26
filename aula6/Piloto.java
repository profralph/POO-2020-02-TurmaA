package br.edu.imed;

// É um? Sim. Há herança
public class Piloto extends Pessoa {
	
	String numeroLicenca;
	String companhiaAerea;
	String nome;
	
	public String calcularDataNascimento() {
		return "";
	}
	
	public Piloto(String nome, String cpf) {
		super(nome, cpf);
	}
}
