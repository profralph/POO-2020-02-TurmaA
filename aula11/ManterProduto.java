package imed;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ManterProduto {

	private Connection con;
		
	public ManterProduto(Connection con) {
		
		this.con = con;
	} 
	
	public List<Produto> selecionarProdutos() {
		
		assert(con != null);
		
		List<Produto> produtos = new ArrayList<Produto>();
		
		String sql = "SELECT id_produto, nome, preco FROM produto ";
		
		try {
		
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
								
			while(rs.next()) {
				
				Produto p = new Produto();
				
				p.setId(rs.getInt("id_produto"));
				p.setNome(rs.getString("nome"));
				p.setPreco(rs.getDouble("preco"));
				
				produtos.add(p);
			}
			
			stmt.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return produtos;
	}
	
	public Produto selecionarProduto(Integer id) {
		
		String sql = "SELECT id_produto, nome, preco FROM produto WHERE id_produto = ? ";
		
		Produto p = new Produto();
		
		try {
		
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
								
			while(rs.next()) {
												
				p.setId(rs.getInt("id_produto"));
				p.setNome(rs.getString("nome"));
				p.setPreco(rs.getDouble("preco"));
			}
			
			stmt.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return p;
	}
	
	public void mostrarProdutos(List<Produto> produtos) {
		
		for (Produto p : produtos) {
			System.out.println(p);
		}
	}
	
	public void inserirProduto(Produto produto) {
		
		assert(con != null);
		
		try {
			
			String sqlIns = "INSERT INTO produto(id_produto, nome, preco) VALUES(?, ?, ?) ";
			
			PreparedStatement pstmt = con.prepareStatement(sqlIns);
			pstmt.setInt(1, produto.getId());
			pstmt.setString(2, produto.getNome());
			pstmt.setDouble(3, produto.getPreco());
			
			pstmt.executeUpdate();
			pstmt.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	public void alterarProduto(Produto produto) {
		
		assert(con != null);
		
		String sqlUpd = "UPDATE produto SET preco = ?, nome = ? WHERE id_produto = ?";
		
		PreparedStatement pstmt;
		
		try {
			
			pstmt = con.prepareStatement(sqlUpd);
			
			pstmt.setDouble(1, produto.getPreco());
			pstmt.setString(2, produto.getNome());
			pstmt.setInt(3, produto.getId());
			
			pstmt.executeUpdate();
			pstmt.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}	
	}
	
	public void excluirProduto(Produto produto) {
		
		assert(con != null);
				
		String sqlDel = "DELETE FROM produto WHERE nome = ?";
		
		try {
			
			PreparedStatement pstmt = con.prepareStatement(sqlDel);			
			pstmt.setInt(1, produto.getId());		
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
		
			e.printStackTrace();
		}	
	}
}
