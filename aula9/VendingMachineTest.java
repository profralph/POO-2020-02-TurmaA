package vending;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Map;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class VendingMachineTest {

	@SuppressWarnings("unused")
	private static VendingMachine vm;
	
	@BeforeClass
	public static void setUp() {
		
		vm = new VendingMachineImpl();
	}

	@AfterClass
	public static void tearDown() {
		
		vm = null;
	}
		
	@Test
	public void comprarItemComPrecoExato() {
		
		//Seleciona o pre�o do item na m�quina
		long preco = vm.selecionarItemEObterPreco(Item.SODA);
		
		//O pre�o � o mesmo da lista enumerada
		assertEquals(preco, Item.SODA.getPreco());
		
		vm.inserirMoeda(Moeda.QUARTO);
		vm.inserirMoeda(Moeda.DEZ);
		vm.inserirMoeda(Moeda.DEZ);
		Map<Item, List<Moeda>> troco = vm.obterItemETroco();
		Item item = (Item)troco.keySet().toArray()[0];
		List<Moeda> moedas = (List<Moeda>)troco.get(item);
		
		assertEquals(Item.SODA, item);
		assertTrue(moedas.isEmpty());	
	}
	
}
