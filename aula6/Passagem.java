package br.edu.imed;

public class Passagem {

	String numero;
	String assento;
	Boolean temBagagem;
	Voo voo;
	Passageiro passageiro;
	
	
	public Passagem(String numero, String assento, Boolean temBagagem, Voo voo, Passageiro passageiro) {
		super();
		this.numero = numero;
		this.assento = assento;
		this.temBagagem = temBagagem;
		this.voo = voo;
		this.passageiro = passageiro;
	}
}
