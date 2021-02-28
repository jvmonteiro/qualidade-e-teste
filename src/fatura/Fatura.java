package fatura;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

public class Fatura {
	// Campos basicos
	String cliente;
	LocalDate data;
	double total;
	
	// Flag para a fatura paga	
	boolean isPaga;
	
	// Hashmap de pagamentos
	ArrayList<HashMap<String, Object>> pagamentos;
	
	public Fatura(String nomeCliente, LocalDate data, double valorTotal){
		this.data = data;
		this.total = valorTotal;
		this.cliente = nomeCliente;
		this.isPaga = false;
	}
	
	public double getTotal() {
		return this.total;
	}
	
	public void setIsPaga(boolean paga) {
		this.isPaga = paga;
	}
	
	public boolean getIsPaga() {
		return this.isPaga;
	}
	
	public void adicionaPagamento(HashMap<String, Object> pag) {
		pagamentos.add(pag);
	}
}
