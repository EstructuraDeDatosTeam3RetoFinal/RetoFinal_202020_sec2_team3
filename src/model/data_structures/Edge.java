package model.data_structures;

public class Edge<K extends Comparable<K>, V extends Comparable<V>> implements Comparable
{
	/**
	 * Peso de ese arco, en este caso el promedio de horas de los ciclistas que han pasado por ese camino
	 */
	int peso;;

	
	/**
	 * Vertice del que sale el arco
	 */
	Vertex<K, V> source;
	
	/**
	 * Vertice al que llega el arco
	 */
	Vertex<K, V> destination;
	
	/**
	 * Crea un vertice segun el origen y el destino que le den 
	 * @param origen vertice del que sale
	 * @param destino vertice al que entra
	 */
	public Edge(Vertex origen, Vertex destino, int pPeso)
	{
		source = origen;
		destination = destino;
		this.peso = pPeso; 
	}
	
	/**
	 * Retorna vertice del source
	 * @return source
	 */
	public Vertex<K, V> getSource()
	{
		return source;
	}

	/**
	 * Retorna vertice del destino
	 * @return destination
	 */
	public Vertex<K, V> getDest()
	{
		return destination;
	}
	
	/**
	 * El peso del arco actual
	 * @return weight 
	 */
	public int getPeso()
	{
		return peso;
	}
	
	/**
	 * Cambia el peso por el valor que entra por parametro
	 * @param newWeight nuevo valor del peso que entra por parametro
	 */
	public void setViaje(int pPeso)
	{
		peso = pPeso;
	}

	public void revert()
	{
		Vertex<K, V> temp = source;
		source = destination;
		destination = temp; 
	}
	public int compareTo(Object o) {
		if(((Edge) o).getPeso() > this.getPeso())
			return 1;
		else if(((Edge) o).getPeso() < this.getPeso())
			return -1;
		else
			return 0;
	}
	
}
