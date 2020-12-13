package Clases;

import java.text.SimpleDateFormat;
import org.joda.time.LocalDateTime;
import model.data_structures.ListaEncadenadaSinComparable;

public class Taxi 
{
	//--------------------------------------
	//Atributos
	//--------------------------------------
	String idTaxi;
	float puntos;
	ListaEncadenadaSinComparable<Servicio> servicios;
	SimpleDateFormat format = new SimpleDateFormat();
	
	//--------------------------------------
	//Constructor
	//--------------------------------------
	public Taxi(String pId){
		puntos = 0;
		idTaxi = pId; 
		servicios = new ListaEncadenadaSinComparable<Servicio>();
	}
	
	
	//--------------------------------------
	//Gets
	//--------------------------------------
	public String darId(){
		return idTaxi; 
	}
	
	public float darPuntos() {
		return puntos;
	}
	
	//--------------------------------------
	//Sets
	//--------------------------------------
	public void AgregarServicio(Servicio servicio) {
		servicios.insert(servicio);
	}
	
	
	//--------------------------------------
	//Sorts
	//--------------------------------------
	public void ordenarServicios() {
		Servicio[] lista= new Servicio[servicios.contarDatos()];
		for (int i=0;i<servicios.contarDatos();i++) {
			lista[i]=servicios.darElemento(i);
		}
		
		//ShellSort
		int salto, i;
		Servicio aux;
        boolean cambios;
        for (salto = lista.length / 2; salto != 0; salto /= 2) {
            cambios = true;
            while (cambios) {                                     
                cambios = false;
                for (i = salto; i < lista.length; i++)   
                {
                    if (lista[i - salto].compareTo(lista[i]) == -1) {       
                        aux = lista[i];                 
                        lista[i] = lista[i - salto];
                        lista[i - salto] = aux;
                        cambios = true;                                             
                    }
                }
            }
        }
       
        //-------------------
        servicios = new ListaEncadenadaSinComparable<Servicio>();
        for (Servicio act:lista) {
        	servicios.insert(act);
        }
	}
	
	
	//--------------------------------------
	//Requerimiento B
	//--------------------------------------
	public void darPuntosAntesDe(String pFecha){
		puntos = 0;
		LocalDateTime fecha = LocalDateTime.parse(pFecha);
		for (int i = 0;i<servicios.contarDatos();i++) {
			Servicio servicioAct = servicios.darElemento(i);
			if(servicioAct.darFecha().isAfter(fecha)) {
				break;
			}
			else {
				puntos+=servicioAct.darPuntos();
			}
		}
	}
	
	
	public void darPuntosEntre(String pFechaInicial, String pFechaFinal){
		puntos = 0;
		LocalDateTime fechaInicial = LocalDateTime.parse(pFechaInicial);
		LocalDateTime fechaFinal = LocalDateTime.parse(pFechaFinal);
		for (int i = 0;i<servicios.contarDatos();i++) {
			Servicio servicioAct = servicios.darElemento(i);
			if(servicioAct.darFecha().isAfter(fechaFinal)) {
				break;
			}
			else {
				if(servicioAct.darFecha().isAfter(fechaInicial)) {
					puntos+=servicioAct.darPuntos();
				}
			}
		}
	}
	
}