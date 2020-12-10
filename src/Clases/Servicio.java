package Clases;
	
import org.joda.time.LocalDateTime;

public class Servicio implements Comparable {
	
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

	@Override
	public int compareTo(Object o) {
		try {
			Servicio otro = (Servicio)o;
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
		catch(Exception e) {
			e.printStackTrace();
		}
		return -2;
	}
}
