package imed;

public class Produto {

	private Integer id;
	private String nome;
	private Double preco;
	
	@Override
	public String toString() {
		
		return id + " " + nome + " " + preco;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Double getPreco() {
		return preco;
	}
	public void setPreco(Double preco) {
		this.preco = preco;
	}
}
