package controller;

import java.util.Scanner;

import model.logic.Modelo;
import view.View;

public class Controller {

	/* Instancia del Modelo*/
	private Modelo modelo;
	
	/* Instancia de la Vista*/
	private View view;
	
	/**
	 * Crear la vista y el modelo del proyecto
	 * @param capacidad tamaNo inicial del arreglo
	 */
	public Controller ()
	{
		view = new View();
		modelo = new Modelo(this);
	}
		
	public void run() 
	{
		Scanner lector = new Scanner(System.in);
		boolean fin = false;
		String dato = "";
		String respuesta = "";

		while( !fin ){
			view.printMenu();

			int option = lector.nextInt();
			switch(option){
				case 1:
					view.printMessage("--------- \n Cargando Taxis: ");			
					modelo.cargarDatosParteA();
					int cantidadTaxis = modelo.darCantidadTaxis();
					view.printMessage("--------- \n La cantidad de Taxis es: " + cantidadTaxis);	
					break;

				default: 
					view.printMessage("--------- \n Opcion Invalida !! \n---------");
					break;
			}
		}
	}
	
	public void printMessage(String message) {
		view.printMessage(message);
	}
}
