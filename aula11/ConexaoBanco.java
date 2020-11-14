package imed;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ConexaoBanco {

	public static void main(String[] args) {
		
		Connection con;
						
		try {
			
			String url = "jdbc:sqlite:C:/TEMP/imed.db";
			con = DriverManager.getConnection(url);
			//System.out.println("Ok!");
			
			ManterProduto mp = new ManterProduto(con);
						
			Produto p = new Produto();
			p.setId(6);
			p.setNome("Armário");
			p.setPreco(560.2);
			
			mp.inserirProduto(p);
			
			List<Produto> prods = mp.selecionarProdutos();
			mp.mostrarProdutos(prods);
									
			con.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
}
