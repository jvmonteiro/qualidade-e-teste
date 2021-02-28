package procboleto;


import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import fatura.Fatura;
import boleto.Boleto;
import java.time.LocalDate;
import java.util.Random;
import java.util.ArrayList;
public class ProcessadorBoletosTest {
	ProcessadorBoletos procbol;
	ArrayList<Boleto> boletos; 
	public LocalDate geraData() {
		Random random = new Random();
		int minDay = (int) LocalDate.of(1900, 1, 1).toEpochDay();
		int maxDay = (int) LocalDate.of(2015, 1, 1).toEpochDay();
		long randomDay = minDay + random.nextInt(maxDay - minDay);

		LocalDate randomDate = LocalDate.ofEpochDay(randomDay);
		return randomDate;
	}
	
	public Boleto geraBoleto(String cod, double valor) {
		LocalDate data = geraData();
		Boleto bol = new Boleto(cod, data, valor);
		return bol;
	}
	
	@BeforeEach
	public void inicializa() {
		procbol = new ProcessadorBoletos();
		boletos = new ArrayList<Boleto>();
	}
	
	
	@DisplayName("[Teste 1] Paga a fatura quando seu valor eh zero")
	@Test
	public void pagaFaturaZero() {
		// Cria um boleto.
		Boleto bol = geraBoleto("0123456789", 500.00);
		boletos.add(bol);
		// Cria uma fatura de valor 0.			
		Fatura fat = new Fatura("Jose", geraData(), 0.00);
		// Processa a fatura.
		procbol.processa(fat, boletos);
		assertTrue(fat.getIsPaga());
		assertEquals(fat.getPagamentos().size(), 1);
	}
	
	@DisplayName("[Teste 2] Paga a fatura quando seu valor eh maior do que zero")
	@Test
	public void pagaFaturaMaiorQueZero() {
		// Cria um boleto.
		Boleto bol = geraBoleto("0123456789", 500.00);
		boletos.add(bol);
		// Cria uma fatura de valor 0.			
		Fatura fat = new Fatura("Jose", geraData(), 500.00);
		// Processa a fatura.
		procbol.processa(fat, boletos);
		assertTrue(fat.getIsPaga());
		assertEquals(fat.getPagamentos().size(), 1);
	}
	
	@DisplayName("[Teste 3] Paga a fatura quando a soma dos boletos ultrapassa o valor da fatura")
	@Test
	public void pagaFaturaBoletoUltrapassa() {
		// Cria um boleto.
		Boleto bol = geraBoleto("0123456789", 500.00);
		Boleto bol2 = geraBoleto("0122334444", 750.00);
		boletos.add(bol);
		boletos.add(bol2);
		// Cria uma fatura de valor 0.			
		Fatura fat = new Fatura("Jose", geraData(), 500.00);
		// Processa a fatura.
		procbol.processa(fat, boletos);
		assertTrue(fat.getIsPaga());
		assertEquals(fat.getPagamentos().size(), 2);
	}
	
}

