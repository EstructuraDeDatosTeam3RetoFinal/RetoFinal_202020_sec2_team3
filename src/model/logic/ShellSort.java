package model.logic;

public class ShellSort {

	public static void ShellSort(Comparable[] array,int tamano) {
		int salto, i;
		Comparable aux;
        boolean cambios;
    	for (salto = tamano / 2; salto != 0; salto /= 2) {
            cambios = true;
            while (cambios) {                                         
                cambios = false;
                for (i = salto; i < tamano; i++)  
                {
                    if ((array[i - salto]).compareTo(array[i])<0) {       
                        aux = array[i];                 
                        array[i] = array[i - salto];
                        array[i - salto] = aux;
                        cambios = true;  
                    }
                }
            }
        }
	}
	
}
