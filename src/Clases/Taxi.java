package Clases;

import model.data_structures.ListaEncadenadaSinComparable;

public class Taxi 
{
	String idTaxi;
	ListaEncadenadaSinComparable<Servicio> servicios = new ListaEncadenadaSinComparable<Servicio>();
	
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