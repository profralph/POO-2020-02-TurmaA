package br.edu.imed.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import br.edu.imed.modelo.Armazenavel;

public class ManterArquivos {

	private static String dirPadrao;
	public static final String SEP = ",";
			
	static {
		
		dirPadrao = System.getProperty("user.home");
	}
	
	public static void gravar(Armazenavel obj, Boolean sobrescrever) {
		
		String caminhoAbsoluto = obterCaminhoAbsoluto(obj.obterNomeArquivo());
		
		// Manipulação de arquivos joga uma "checked exception"
		try (FileWriter fw = new FileWriter(caminhoAbsoluto, sobrescrever); 
			 BufferedWriter bw = new BufferedWriter(fw);	
			 PrintWriter out = new PrintWriter(bw)) { 
						
			out.println(obj.toString());
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
	public static void ler(String arquivo) {
		
		String caminhoAbsoluto = obterCaminhoAbsoluto(arquivo);
		
		try(BufferedReader br = new BufferedReader(new FileReader(caminhoAbsoluto))){
			
			String line = br.readLine();
			
			while (line != null) {
			
				//String[] vetorLinha = line.split(",");
				
				System.out.println(line);
				line = br.readLine();				
			}
						
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
	private static String obterCaminhoAbsoluto(String arquivo) {
		
		return dirPadrao + File.separator + arquivo;
	}
}



