package view;

import model.logic.Modelo;

public class View 
{
	    /**
	     * Metodo constructor
	     */
	    public View()
	    {

	    }
	    
		public void printMenu()
		{
			System.out.println("------------------");
			System.out.println("Seleccione una opción");
			System.out.println("1. Cargar Datos");
			System.out.println("2. Requerimiento A");
			System.out.println("3. Requerimiento B");
			System.out.println("------------------");
		}

		public void printMessage(String mensaje) {
			System.out.println(mensaje);
		}		
}
