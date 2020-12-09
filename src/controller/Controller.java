package controller;

import java.util.Scanner;

import model.data_structures.ListaEncadenadaSinComparable;
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
					view.printMessage("--------- \n Indique cual data desea cargar: ");	
					view.printMessage("1. Data completa ");	
					view.printMessage("2. Data media");	
					view.printMessage("3. Data resumida");	
					int database = lector.nextInt();
					switch(database) {
					case 1:
						modelo.loadLarge();
						break;
					case 2:
						modelo.loadMedium();
						break;
					case 3:
						modelo.loadSmall();
						break;
					default:
						view.printMessage("Error, opcion incorrecta");	
						break;
					}
					if (modelo.darCarga()) {
						view.printMessage("---------\n La cantidad de Taxis es: " + modelo.darCantidadTaxis());
						view.printMessage("---------\nLas compañias con más de un taxi son:\n---------");
						ListaEncadenadaSinComparable<String> companias = modelo.darCompanias(); 
						for (int i = 0; i < companias.contarDatos(); i++) 
						{
							view.printMessage(companias.darElemento(i)); 
						}	
						view.printMessage("\n");
					}
					else {
						view.printMessage("--------- \n Ocurrio un error al cargar los datos");
					}
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
