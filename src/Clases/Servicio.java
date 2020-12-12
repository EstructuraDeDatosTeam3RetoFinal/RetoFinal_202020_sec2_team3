package Clases;
	
import org.joda.time.LocalDateTime;

public class Servicio {
	
	private float millas;
	private float pago;
	private LocalDateTime fecha;
	
	public Servicio(String pFecha, float pMillas,float pPago) {
		millas = pMillas;
		pago = pPago;
	}
	
	public float darPuntos() {
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
