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
	
	public void AgregarServicio(Servicio servicio) {
		servicios.insert(servicio);
	}
}