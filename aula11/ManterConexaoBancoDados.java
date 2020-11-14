package imed;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ManterConexaoBancoDados {

	public static Connection obterConexao(BancoDados bd, String url) {
		
		Connection con = null;
		
		try {
			
			con = DriverManager.getConnection(bd.getTipo()+url);
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return con;
	}
	
	public static void fecharConexao(Connection con) {
		
		try {
			
			if (!con.isClosed()) {
				
				con.close();			
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}		
	}
}
