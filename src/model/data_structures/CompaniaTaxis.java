package model.data_structures;

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
	 * Constructor
	 */
	public CompaniaTaxis(String pNombre)
	{
		cantTaxis = 0;
		nombreCompania = pNombre; 
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
	public void agregarTaxi()
	{
		cantTaxis++; 
	}
}
