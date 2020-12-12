package Clases;

import java.text.SimpleDateFormat;
import org.joda.time.LocalDateTime;
import model.data_structures.ListaEncadenadaSinComparable;

public class Taxi 
{
	String idTaxi;
	float puntos = 0;
	ListaEncadenadaSinComparable<Servicio> servicios;
	SimpleDateFormat format = new SimpleDateFormat();
	
	public Taxi(String pId)
	{
		idTaxi = pId; 
		servicios = new ListaEncadenadaSinComparable<Servicio>();
	}
	
	public String darId()
	{
		return idTaxi; 
	}
	
	public void AgregarServicio(Servicio servicio) {
		servicios.insert(servicio);
	}
	
	public void ordenarServicios() {
		
	}
	
	public void darPuntosAntesDe(String pFecha){
		LocalDateTime fecha = LocalDateTime.parse(pFecha);
		for (int i = 0;i<servicios.contarDatos();i++) {
			Servicio servicioAct = servicios.darPosicionDatos(i);
			if(servicioAct.darFecha().isAfter(fecha)) {
				break;
			}
			else {
				puntos+=servicioAct.darPuntos();
			}
		}
	}
	
	public void darPuntosEntre(String pFechaInicial, String pFechaFinal){
		LocalDateTime fechaInicial = LocalDateTime.parse(pFechaInicial);
		LocalDateTime fechaFinal = LocalDateTime.parse(pFechaFinal);
		for (int i = 0;i<servicios.contarDatos();i++) {
			Servicio servicioAct = servicios.darPosicionDatos(i);
			if(servicioAct.darFecha().isAfter(fechaFinal)) {
				break;
			}
			else {
				if(servicioAct.darFecha().isAfter(fechaInicial)) {
					puntos+=servicioAct.darPuntos();
				}
			}
		}
	}
	
}