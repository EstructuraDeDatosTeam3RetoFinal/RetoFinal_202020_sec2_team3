package Clases;
	
import org.joda.time.LocalDateTime;

public class Servicio {
	
	private int millas;
	private int pago;
	private LocalDateTime fechaInicio, fechaFin;
	
	public Servicio(int pMillas,int pPago) {
		millas = pMillas;
		pago = pPago;
	}
	
	public int darPuntos() {
		return (millas/pago);
	}
}
