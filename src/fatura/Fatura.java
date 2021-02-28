package fatura;

import java.time.LocalDate;
public class Fatura {
	// Campos basicos
	String cliente;
	LocalDate data;
	double total;
	
	// Flag para a fatura paga	
	boolean isPaga;
	
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
}
