package br.edu.imed.sistema;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import br.edu.imed.modelo.Veiculo;

public class App {

	public static void main(String[] args) {
	
		String dirPadrao = System.getProperty("user.home");
		
		String arquivo = "poo-sexta.txt";
		
		String caminhoAbsoluto = dirPadrao + File.separator + arquivo;
		
		//System.out.println(caminhoAbsoluto);
		
		// Manipulação de arquivos joga uma "checked exception"
		try (FileWriter fw = new FileWriter(caminhoAbsoluto, false); 
			 BufferedWriter bw = new BufferedWriter(fw);	
			 PrintWriter out = new PrintWriter(bw)) { 
			
			Veiculo v1 = new Veiculo("XYZ-1234", "ACME", 1975);
			Veiculo v2 = new Veiculo("ABC-0002", "XPTO", 1986);
			
			out.println(v1.toString());
			out.println(v2.toString());
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		try(BufferedReader br = new BufferedReader(new FileReader(caminhoAbsoluto))){
			
			String line = br.readLine();
			
			while (line != null) {
			
				String[] vetorLinha = line.split(",");
				Integer ano = Integer.parseInt(vetorLinha[2]);
				Veiculo v1 = new Veiculo(vetorLinha[0], vetorLinha[1], ano);
				
				System.out.println(v1.toString());
				line = br.readLine();				
			}
						
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
}



