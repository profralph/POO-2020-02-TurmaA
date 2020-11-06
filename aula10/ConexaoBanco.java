package imed;

import java.sql.*;

public class ConexaoBanco {

	public static void main(String[] args) {
		
		Connection con;
		
		try {
			
			String url = "jdbc:sqlite:C:/TEMP/imed.db";
			con = DriverManager.getConnection(url);
			//System.out.println("Ok!");
			
			String sql = "SELECT nome, preco FROM produto ";
			
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				
				System.out.print(rs.getString("nome"));
				System.out.print(" ");
				System.out.println(rs.getString("preco"));
			}
			
			con.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
}
