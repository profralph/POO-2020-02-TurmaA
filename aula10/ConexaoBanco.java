package imed;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ConexaoBanco {

	public static void main(String[] args) {
		
		Connection con;
		
		List<Produto> produtos = new ArrayList<Produto>();
		
		try {
			
			String url = "jdbc:sqlite:C:/TEMP/imed.db";
			con = DriverManager.getConnection(url);
			//System.out.println("Ok!");
			
			String sql = "SELECT id_produto, nome, preco FROM produto ";
			
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
									
			while(rs.next()) {
				
				Produto p = new Produto();
				
				p.setId(rs.getInt("id_produto"));
				p.setNome(rs.getString("nome"));
				p.setPreco(rs.getDouble("preco"));
				
				produtos.add(p);
			}
			
			con.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		for (Produto p : produtos) {
			System.out.println(p);
		}
	}
}
