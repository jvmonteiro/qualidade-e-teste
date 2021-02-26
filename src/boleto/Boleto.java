package boleto;
import java.util.Date;

class Boleto {
	String codigo;
	Date data;
	double valorPago;
	
	Boleto(String cod, Date data, double valor) {
		this.codigo = cod;
		this.data = data;
		this.valorPago = valor;
	}
	
	public double getValorPago() {
		return this.valorPago;
	}
}
