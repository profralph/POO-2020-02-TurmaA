package imed;

import java.sql.*;
import java.util.List;

public class ConexaoBanco {

	public static void main(String[] args) {
		
		Connection con;
			
		String url = "C:/TEMP/imed.db";

		con = ManterConexaoBancoDados.obterConexao(BancoDados.SQLITE, url);
					
		ManterProduto mp = new ManterProduto(con);
					
		/*Produto p = new Produto();
		p.setId(6);
		p.setNome("Armário");
		p.setPreco(560.2);
		
		mp.inserirProduto(p);*/
		
		Produto p = mp.selecionarProduto(1);
		System.out.println(p);
		
		List<Produto> prods = mp.selecionarProdutos();
		//mp.mostrarProdutos(prods);
								
		ManterConexaoBancoDados.fecharConexao(con);
	}
}
