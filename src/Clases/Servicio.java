package Clases;
	
import org.joda.time.LocalDateTime;

public class Servicio {
	
	private int millas;
	private int pago;
	private LocalDateTime fecha;
	
	public Servicio(String pFechaIncial, String pFechaFinal, int pMillas,int pPago) {
		millas = pMillas;
		pago = pPago;
	}
	
	public int darPuntos() {
		return (millas/pago);
	}

	public int compareTo(Servicio otro) {
			if (fecha.isAfter(otro.fecha)) {
				return 1;
			}
			else if (fecha.isBefore(otro.fecha)) {
				return -1;
			}
			else {
				return 0;
			}
	}
}
