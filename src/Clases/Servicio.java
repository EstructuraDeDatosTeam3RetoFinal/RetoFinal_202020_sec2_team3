package Clases;
	
import org.joda.time.LocalDateTime;

public class Servicio {
	
	private float millas;
	private float pago;
	private LocalDateTime fecha;
	
	public Servicio(String pFecha, float pMillas,float pPago) {
		if(!pFecha.isEmpty()) {
			fecha = LocalDateTime.parse(pFecha);	
		}
		else {
			fecha = LocalDateTime.now();
		}
		millas = pMillas;
		pago = pPago;
	}
	
	public float darPuntos() {
		if(millas>0 && pago>0) {
			return (millas/pago);
		}
		return 0;
	}
	
	public LocalDateTime darFecha() {
		return fecha;
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
