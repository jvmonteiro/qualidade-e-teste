package procboleto;


import static org.junit.jupiter.api.Assertions.assertTrue;

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
	
	public LocalDate geraData() {
		Random random = new Random();
		int minDay = (int) LocalDate.of(1900, 1, 1).toEpochDay();
		int maxDay = (int) LocalDate.of(2015, 1, 1).toEpochDay();
		long randomDay = minDay + random.nextInt(maxDay - minDay);

		LocalDate randomDate = LocalDate.ofEpochDay(randomDay);
		return randomDate;
	}
	@BeforeEach
	public void inicializa() {
		procbol = new ProcessadorBoletos();
	}
	
	
	@DisplayName("[Teste 1] Paga a fatura quando seu valor eh zero")
	@Test
	public void pagaFaturaZero() {
		// Cria um boleto.		
		String cod1 = "0123456789";
		LocalDate d1 = geraData();
		double valor = 500.00;
		Boleto bol = new Boleto(cod1, d1, valor);
		ArrayList<Boleto> boletos = new ArrayList<Boleto>();
		boletos.add(bol);
		// Cria uma fatura de valor 0.			
		Fatura fat = new Fatura("Jose", d1, 0.00);
		// Processa a fatura.
		procbol.processa(fat, boletos);
		assertTrue(fat.getIsPaga());
	}
}

