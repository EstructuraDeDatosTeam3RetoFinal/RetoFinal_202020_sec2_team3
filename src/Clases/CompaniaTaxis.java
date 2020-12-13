package Clases;

import model.data_structures.ListaEncadenadaSinComparable;
import model.data_structures.tablaHashLinearProbing;

public class CompaniaTaxis 
{
	/**
	 * Numero de taxis de la compañia
	 */
	int cantTaxis; 
	
	/**
	 * Numero de taxis de la compañia
	 */
	String nombreCompania; 
	
	/**
	 * Lista con los taxis
	 */
	tablaHashLinearProbing<String, Taxi> listaTaxis; 
	
	/**
	 * Lista con los taxis
	 */
	int cantidadViajes; 
	
	/**
	 * Constructor
	 */
	public CompaniaTaxis(String pNombre)
	{
		cantTaxis = 0;
		nombreCompania = pNombre; 
		listaTaxis = new tablaHashLinearProbing<String, Taxi>(100000); 
		cantidadViajes = 0; 
	}
	
	/**
	 * Da la cantidad de taxis de esta compañia
	 * @return cantidad taxis
	 */
	public int darCantidadTaxis()
	{
		return cantTaxis; 
	}
	
	/**
	 * Da el nombre de esta compañia
	 * @return nombre
	 */
	public String darNombreCompania()
	{
		return nombreCompania; 
	}
	
	/**
	 * Agrega un taxi a la cantidad de taxis de la compañía
	 */
	public void agregarTaxi(Taxi taxi)
	{
		if((listaTaxis.contains(taxi.darId())== false))
		{
			listaTaxis.put(taxi.darId(), taxi);
			cantTaxis++; 
		}
	}
	
	public boolean existeTaxi(String id)
	{
		if(listaTaxis.contains(id))
		{
			return true; 
		}
		else
		{
			return false; 
		}
	}
	
	public void agregarViaje(Taxi pTaxi, Servicio servicio)
	{
		cantidadViajes++;
		Taxi taxi = listaTaxis.get(pTaxi.darId());
		taxi.AgregarServicio(servicio);
	}
	
	public int darCantidadViajes()
	{
		return cantidadViajes; 
	}
	
	
	//-----------------------------
	//Requerimiento B
	//-----------------------------
	public void ordenarViajes() {
		ListaEncadenadaSinComparable<Taxi> listaAux = listaTaxis.valueSet();
		for(int i=0;i<listaAux.contarDatos()-1;i++) {
			Taxi act = listaAux.darElemento(i);
			act.ordenarServicios();
		}
	}
}
