package br.edu.imed.modelo;

import br.edu.imed.util.ManterArquivos;

public class Cliente implements Armazenavel {

	private String nome;
	private String cpf;
	private String rg;
	private String endereco;
	private Double salario;
	
	@Override
	public String obterNomeArquivo() {
		return "cliente.txt";
	}
	
	@Override
	public String toString() {
		
		return nome + ManterArquivos.SEP + cpf + ManterArquivos.SEP + endereco + ManterArquivos.SEP + rg + ManterArquivos.SEP + salario;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public Double getSalario() {
		return salario;
	}
	public void setSalario(Double salario) {
		this.salario = salario;
	}
}
