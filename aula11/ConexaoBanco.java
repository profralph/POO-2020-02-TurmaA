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
			
			/*String sqlIns = "INSERT INTO produto(id_produto, nome, preco) VALUES(5, 'Sofá', 750.34) ";
			
			stmt = con.createStatement();
			stmt.executeQuery(sqlIns);*/
			
			String sqlIns = "INSERT INTO produto(id_produto, nome, preco) VALUES(?, ?, ?) ";
			
			PreparedStatement pstmt = con.prepareStatement(sqlIns);
			pstmt.setInt(1, 5);
			pstmt.setString(2, "Sofá");
			pstmt.setDouble(3, 750.34);
			
			//pstmt.executeUpdate();
			
			String sqlUpd = "UPDATE produto SET preco = ? WHERE id_produto = ?";
			
			PreparedStatement pstmt2 = con.prepareStatement(sqlUpd);			
			pstmt2.setDouble(1, 810.2);
			pstmt2.setInt(2, 5);
			
			pstmt2.executeUpdate();
			
			String sqlDel = "DELETE FROM produto WHERE id_produto = ?";
			
			PreparedStatement pstmt3 = con.prepareStatement(sqlDel);			
			pstmt3.setDouble(1, 5);
			
			//pstmt3.executeUpdate();
			
			con.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		for (Produto p : produtos) {
			System.out.println(p);
		}
	}
}
