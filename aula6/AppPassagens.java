package br.edu.imed;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class AppPassagens {

	public static void main(String[] args) {
		
		Aeroporto a1 = new Aeroporto("PFB", 10.2, "Passo Fundo");
		Aeroporto a2 = new Aeroporto("CGN", 15.6, "São Paulo");
		
		Piloto p1 = new Piloto("Ana Maria", "1293412938");
		Piloto p2 = new Piloto("Bruno Silva", "43243242");
		
		Voo v1 = new Voo(p1, p2, LocalDate.now(), LocalDate.now().plusDays(2), "123", a1, a2);
		Voo v2 = new Voo(p1, p2, LocalDate.now().plusDays(3), LocalDate.now().plusDays(5), "124", a2, a1);
		v1.horaPartida = LocalTime.now();
		v1.horaChegada = LocalTime.of(23, 19, 10);
		
		Passageiro pg1 = new Passageiro("Carlos Santos", "23145324");
		
		Passagem pa1 = new Passagem("31", "A22", false, v1, pg1);
		
		//DateTimeFormatter dtf = new DateTimeFormatterBuilder
		
		System.out.println("Vôo "+v1.numero+ " com origem em "+v1.origem.getCidade() + " e destino em "+v1.destino.getCidade() );
		System.out.println("Vôo "+v1.numero+ " com saída em "+v1.dataPartida.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
		System.out.println("Vôo "+v1.numero+ " com chegada em "+v1.dataChegada.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
		
		System.out.println("Vôo "+v1.numero+ " com saída em "+v1.horaPartida.format(DateTimeFormatter.ofPattern("HH:mm:ss")));
		System.out.println("Vôo "+v1.numero+ " com chegada em "+v1.horaChegada.format(DateTimeFormatter.ofPattern("HH:mm:ss")));
	}
}
