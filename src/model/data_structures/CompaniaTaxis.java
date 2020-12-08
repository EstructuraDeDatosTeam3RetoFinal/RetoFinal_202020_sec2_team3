package model.data_structures;

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
	 * Constructor
	 */
	public CompaniaTaxis(String pNombre)
	{
		cantTaxis = 0;
		nombreCompania = pNombre; 
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
	public void agregarTaxi()
	{
		cantTaxis++; 
	}
}
