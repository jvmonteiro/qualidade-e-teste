package procboleto;

import fatura.Fatura;
import java.util.ArrayList;
import boleto.Boleto;

import java.util.HashMap;
import java.time.LocalDate;

public class ProcessadorBoletos {
	
	public boolean processa(Fatura f, ArrayList<Boleto> b) {
		double somaBoletos = 0;
		for(Boleto bol:b) {
			HashMap<String, Object> pag = new HashMap<String, Object>();
			pag.put("valor", bol.getValorPago());
			pag.put("data", LocalDate.now());
			pag.put("tipo", "BOLETO");
			f.adicionaPagamento(pag);
			somaBoletos += bol.getValorPago();
		}
		
		if(f.getTotal() == 0) {
			f.setIsPaga(true);
		}
		
		if(somaBoletos >= f.getTotal()) {
			f.setIsPaga(true);
		}
		return true;
	}
}
