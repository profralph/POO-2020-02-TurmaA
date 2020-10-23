package vending;

import java.util.HashMap;
import java.util.Map;

public class Inventario<T> {

	Map<T, Integer> inventario = new HashMap<T, Integer>();
	
	public int obterQuantidade(T item) {
		
		Integer quantidade = inventario.get(item);
		
		if (quantidade == null) {
			
			return 0;
		}
		
		return quantidade;
	}
	
	public void adicionar(T item) {
		
		int contagemAtual = inventario.get(item);
		inventario.put(item, contagemAtual + 1);
	}
	
	public void put(T item, int quantidade) {
		
		inventario.put(item, quantidade);
	}
	
	public void limpar() {
		
		inventario.clear();
	}
}
