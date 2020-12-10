package Clases;

import model.data_structures.IListaEncadenada;
import model.data_structures.ListaEncadenada;

public class Taxi 
{
	String idTaxi;
	IListaEncadenada servicios = new ListaEncadenada();
	
	public Taxi(String pId)
	{
		idTaxi = pId; 
	}
	
	public String darId()
	{
		return idTaxi; 
	}
	
	public void AgregarServicio(String fechaInicial, String fechaFinal, int pMillas, int pPago) {
		Servicio servicio = new Servicio(fechaInicial,fechaFinal,pMillas,pPago);
		servicios.insert(servicio);
	}
}