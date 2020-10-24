package vending;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import exception.EstoqueZeradoException;
import exception.PagamentoIncompletoException;
import exception.TrocoInsuficienteException;

public class VendingMachineImpl implements VendingMachine {

	private Inventario<Moeda> inventarioMoeda = new Inventario<Moeda>();
	private Inventario<Item> inventarioItem = new Inventario<Item>();
	private Item itemCorrente;
	private int balancoCorrente;
	
	public static void main(String[] args) {
		
		VendingMachineImpl v = new VendingMachineImpl();
	}
	
	public VendingMachineImpl() {
		
		for (Moeda m : Moeda.values()) {
			inventarioMoeda.put(m, 10);
		}
		
		for (Item i : Item.values()) {
			inventarioItem.put(i, 5);
		}
	}
	
	@Override
	public long selecionarItemEObterPreco(Item item) {

		if (inventarioItem.temQuantidade(item)) {
			
			itemCorrente = item;
			return itemCorrente.getPreco();
		}
		
		throw new EstoqueZeradoException("O item selecionado está esgotado.");
	}

	@Override
	public void inserirMoeda(Moeda moeda) {
		
		balancoCorrente = balancoCorrente + moeda.getDescricao();
		inventarioMoeda.adicionar(moeda);
	}

	@Override
	public List<Moeda> resgatar() {

		List<Moeda> troco = obterTroco(balancoCorrente);
		balancoCorrente = 0;
		itemCorrente = null;
		atualizarInventarioMoeda(troco);
		
		return troco;
	}
	
	private void atualizarInventarioMoeda(List<Moeda> moedas) {
		
		for (Moeda m : moedas) {
			inventarioMoeda.reduzir(m);
		}
	}
	
	private List<Moeda> obterTroco(int balanco){
		
		List<Moeda> troco = Collections.emptyList();
		
		if (balanco > 0) {
			
			troco = new ArrayList<Moeda>();
			
			int quantia = balanco;
			
			while (quantia > 0) {
				
				if (quantia >= Moeda.QUARTO.getDescricao() 
						&& inventarioMoeda.temQuantidade(Moeda.QUARTO)) {
					
					troco.add(Moeda.QUARTO);
					quantia = quantia - Moeda.QUARTO.getDescricao();
					
				} else if (quantia >= Moeda.DEZ.getDescricao() 
							&& inventarioMoeda.temQuantidade(Moeda.DEZ)) {
					
					troco.add(Moeda.DEZ);
					quantia = quantia - Moeda.DEZ.getDescricao();
					
				} else if (quantia >= Moeda.CINCO.getDescricao() 
							&& inventarioMoeda.temQuantidade(Moeda.CINCO)) {
						
					troco.add(Moeda.CINCO);
					quantia = quantia - Moeda.CINCO.getDescricao();
					
				} else if (quantia >= Moeda.CENTAVO.getDescricao() 
							&& inventarioMoeda.temQuantidade(Moeda.CENTAVO)) {
						
					troco.add(Moeda.CENTAVO);
					quantia = quantia - Moeda.CENTAVO.getDescricao();
					
				} else {
					
					throw new TrocoInsuficienteException("Não há moedas suficientes para o troco.");
				}
			}
		}
		
		return troco;
	}

	@Override
	public void reiniciar() {
		
		inventarioItem.limpar();
		inventarioMoeda.limpar();
		itemCorrente = null;
		balancoCorrente = 0;
	}

	@Override
	public Map<Item, List<Moeda>> obterItemETroco() {

		Item item = coletarItem();
		
		return null;
	}
	
	private Item coletarItem() {
		
		if (estaPago()) {
			
			if (temTrocoSuficiente()) {
				
				inventarioItem.reduzir(itemCorrente);
				
				return itemCorrente;
			}
			
			throw new TrocoInsuficienteException("Sem troco para a retirada do item.");
		}
		
		int balancoRestante = itemCorrente.getPreco() - balancoCorrente;
		
		throw new PagamentoIncompletoException("Faltou a seguinte quantia para resgatar o item", balancoRestante);
	}
	
	private boolean temTrocoSuficiente() {
		
		boolean temTroco = true;
		
		try {
			
			int quantiaAtual = balancoCorrente - itemCorrente.getPreco();
			
			obterTroco(quantiaAtual);
			
		} catch (TrocoInsuficienteException e) {
			
			temTroco = false;
		}
		
		return temTroco;
	}
	
	private boolean estaPago() {
		
		if (balancoCorrente >= itemCorrente.getPreco()) {
			return true;
		}
		
		return false;
	}

}

