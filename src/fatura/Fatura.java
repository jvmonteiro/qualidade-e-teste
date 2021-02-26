package fatura;

import java.util.Date;
public class Fatura {
	// Campos basicos
	Date data;
	double total;
	String cliente;
	
	// Flag para a fatura paga	
	boolean isPaga;
	
	Fatura(Date data, double valorTotal, String nomeCliente){
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
}
