package Clases;

import model.data_structures.ListaEncadenadaSinComparable;
import model.data_structures.tablaHashLinearProbing;

public class CompaniaTaxis 
{
	/**
	 * Numero de taxis de la compa�ia
	 */
	int cantTaxis; 
	
	/**
	 * Numero de taxis de la compa�ia
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
	
	public ListaEncadenadaSinComparable<Taxi> darTaxis()
	{
		return listaTaxis.valueSet(); 
	}
	/**
	 * Da la cantidad de taxis de esta compa�ia
	 * @return cantidad taxis
	 */
	public int darCantidadTaxis()
	{
		return cantTaxis; 
	}
	
	/**
	 * Da el nombre de esta compa�ia
	 * @return nombre
	 */
	public String darNombreCompania()
	{
		return nombreCompania; 
	}
	
	/**
	 * Agrega un taxi a la cantidad de taxis de la compa��a
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
		for(int i=0;i<listaAux.contarDatos();i++) {
			Taxi act = listaAux.darElemento(i);
			act.ordenarServicios();
		}
	}
}
