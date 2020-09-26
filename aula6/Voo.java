package br.edu.imed;

import java.time.LocalDate;
import java.time.LocalTime;

public class Voo {

	Piloto piloto;
	Piloto coPiloto;
	LocalDate dataPartida;
	LocalDate dataChegada;
	LocalTime horaPartida;
	LocalTime horaChegada;
	String numero;
	Aeroporto origem;
	Aeroporto destino;
	
	
	public Voo(Piloto piloto, Piloto coPiloto, LocalDate dataPartida, LocalDate dataChegada, String numero,
			Aeroporto origem, Aeroporto destino) {
		super();
		this.piloto = piloto;
		this.coPiloto = coPiloto;
		this.dataPartida = dataPartida;
		this.dataChegada = dataChegada;
		this.numero = numero;
		this.origem = origem;
		this.destino = destino;
	}
}
