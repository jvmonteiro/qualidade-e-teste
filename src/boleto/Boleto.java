package boleto;
import java.time.LocalDate;

public class Boleto {
	String codigo;
	LocalDate data;
	double valorPago;
	
	public Boleto(String cod, LocalDate data, double valor) {
		this.codigo = cod;
		this.data = data;
		this.valorPago = valor;
	}
	
	public double getValorPago() {
		return this.valorPago;
	}
}
