package controller;

import java.util.Scanner;

import Clases.CompaniaTaxis;
import Clases.Servicio;
import Clases.Taxi;
import model.data_structures.ListaEncadenadaSinComparable;
import model.logic.Modelo;
import view.View;

public class Controller {

	private Modelo modelo;
	
	private View view;
	
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
					view.printMessage("------------------\nIndique cual data desea cargar: ");	
					view.printMessage("1. Data completa ");	
					view.printMessage("2. Data media");	
					view.printMessage("3. Data resumida");	
					view.printMessage("------------------");
					int database = lector.nextInt();
					switch(database) {
					case 1:
						view.printMessage("------------------");
						modelo.loadLarge();
						view.printMessage("Carga completada");
						break;
					case 2:
						view.printMessage("------------------");
						modelo.loadMedium();
						view.printMessage("Carga completada");
						break;
					case 3:
						view.printMessage("------------------");
						modelo.loadSmall();
						view.printMessage("Carga completada");
						break;
					default:
						view.printMessage("------------------");
						view.printMessage("Error, opcion incorrecta");	
						break;
					}
					break;
					
				case 2:
					if (modelo.darCarga()) {
						view.printMessage("------------------\nLa cantidad de Taxis es: " + modelo.darCantidadTaxis());
						view.printMessage("------------------\nLas compañias con más de un taxi son:\n------------------");
						ListaEncadenadaSinComparable<String> companias = modelo.darCompanias(); 
						for (int i = 0; i < companias.contarDatos(); i++) 
						{
							view.printMessage(companias.darElemento(i)); 
						}	
						Scanner sc = new Scanner(System.in);
						view.printMessage("------------------\n Compañías con mayor cantidad de taxis");
						view.printMessage("Ingrese de cuantas compañías quiere que sea el top :");
						int cantidad = sc.nextInt(); 
						view.printMessage("El top " + cantidad + " de compañias con más taxis son:\n------------------");
						CompaniaTaxis[] topCompanias = modelo.darCompaniasConMasTaxis();
						for (int i = 0; i < cantidad; i++) 
						{
							int pos = i+1;
							CompaniaTaxis act = topCompanias[i];
							view.printMessage(pos+". " + act.darNombreCompania() + ": " + act.darCantidadTaxis() + " taxis");
							
						}
						
						view.printMessage("------------------\nCompañías con mayor cantidad de viajes");
						view.printMessage("------------------\nIngrese de cuantas compañías quiere que sea el top :");
						int cantidad2 = sc.nextInt(); 
						view.printMessage("------------------\nEl top " + cantidad2 + " de compañias con más viajes son:\n------------------");
						CompaniaTaxis[] topCompanias2 = modelo.darCompaniasConMasViajes();
						for (int i = 0; i < cantidad2; i++) 
						{
							int pos = i+1;
							CompaniaTaxis act = topCompanias2[i];
							view.printMessage(pos+". " + act.darNombreCompania() + ": " + act.darCantidadViajes() + " viajes");
						}
						
						view.printMessage("------------------\n");
					}
					else {
						view.printMessage("------------------\nNo hay datos cargados");
					}
					break;
					
				case 3:
					if (modelo.darCarga()) {
						int cantidad;
						Scanner sc = new Scanner(System.in);
						Taxi[] taxis;
						view.printMessage("Seleccione que tipo de lista desea");	
						view.printMessage("------------------");
						view.printMessage("1. Antes de cierta fecha ");	
						view.printMessage("2. Entre una y otra fecha");	
						int tipo = lector.nextInt();
						switch(tipo) {
						case 1:
							view.printMessage("------------------\nTop taxis con mas puntos antes de una fecha");
							view.printMessage("Ingrese la fecha maxima para generar el top, utilize el formato YYYY-MM-DDTHH:mm:ss");
							String pFecha = sc.nextLine(); 
							view.printMessage("Ingrese el numero del Top a generar");
							cantidad = sc.nextInt(); 
							view.printMessage("El top " + cantidad + " de Taxis con mas puntos antes de "+ pFecha +" es:\n------------------");
							taxis = modelo.ShellSortTaxis(modelo.CalcularPuntosAntesDe(pFecha));
							for(int i = 1;i<=cantidad;i++) {
								view.printMessage(taxis[i].darId()+": "+taxis[i].darPuntos()+" puntos.");
							}
							break;
						case 2:
							view.printMessage("------------------\nTop taxis con mas puntos entre una fecha y otra fecha");
							view.printMessage("Ingrese la fecha minima para generar el top, utilize el formato YYYY-MM-DDTHH:mm:ss");
							String pFechaInicial = sc.nextLine(); 
							view.printMessage("Ingrese la fecha maxima para generar el top, utilize el formato YYYY-MM-DDTHH:mm:ss");
							String pFechaFinal = sc.nextLine(); 
							view.printMessage("Ingrese el numero del Top a generar");
							cantidad = sc.nextInt(); 
							view.printMessage("El top " + cantidad + " de Taxis con mas puntos entre "+ pFechaInicial +" y "+ pFechaFinal +" es:\n------------------");
							taxis = modelo.ShellSortTaxis(modelo.CalcularPuntosEntre(pFechaInicial,pFechaFinal));
							for(int i = 1;i<=cantidad;i++) {
								view.printMessage(taxis[i].darId()+": "+taxis[i].darPuntos()+" puntos.");
							}
							break;
						}
					}
					else {
						view.printMessage("------------------\nNo hay datos cargados");
					}
					break;

				default: 
					view.printMessage("------------------\nOpcion Invalida");
					break;
			}
		}
	}
	
	public void printMessage(String message) {
		view.printMessage(message);
	}
}
