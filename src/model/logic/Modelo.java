package model.logic;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.exceptions.CsvValidationException;

import Clases.CompaniaTaxis;
import Clases.Taxi;
import controller.Controller;
import model.data_structures.ArregloDinamico;
import model.data_structures.IArregloDinamico;
import model.data_structures.ListaEncadenadaSinComparable;
import model.data_structures.tablaHashLinearProbing;

/**
 * Definicion del modelo del mundo
 *
 */
public class Modelo {
	
	//--------------------------------------------------------------------------------
	//Variables y constantes
	//--------------------------------------------------------------------------------
	
	private static String fileLarge = "taxi-trips-wrvz-psew-subset-large.csv";
	private static String fileMedium = "taxi-trips-wrvz-psew-subset-medium.csv";
	private static String fileSmall = "taxi-trips-wrvz-psew-subset-small.csv";
	
	/**
	 * Atributos del modelo del mundo
	 */
	private ShellSort sort;
	private Controller controller;
	private IArregloDinamico datos;
	private tablaHashLinearProbing<String, CompaniaTaxis> companias; 
	private int cantidadTaxis;
	private boolean data;
	
	
	
	//--------------------------------------------------------------------------------
	//Constructor
	//--------------------------------------------------------------------------------
	
	/**
	 * Constructor del modelo del mundo con capacidad predefinida
	 */
	public Modelo(Controller pController)
	{
		controller = pController;
		sort = new ShellSort();
	}
	
	
	
	//--------------------------------------------------------------------------------
	//Carga de datos
	//--------------------------------------------------------------------------------
	
	/**
	 * Carga de los datos utilizando CSV, el file que carga es la data_large.
	 */
	public void loadLarge()
	{
		companias = new tablaHashLinearProbing<String, CompaniaTaxis>(1000);
		cantidadTaxis = 0; 
		data = false;
		Path path = FileSystems.getDefault().getPath("data/", fileLarge); 
		Reader reader;
		
		try 
		{
			reader = Files.newBufferedReader(path);
			
			CSVParser parser = new CSVParserBuilder().withSeparator(',').withIgnoreQuotations(true).build();
			CSVReader csvReader = new CSVReaderBuilder(reader).withSkipLines(1).withCSVParser(parser).build();
			
		    String[] line;
		    while ((line = csvReader.readNext()) != null) 
		    {
		  
		    	if(line[12].equals("Chicago Independents"))
		    	{
		    		if((companias.contains("Independent Owner"))==false)
		    		{
		    			CompaniaTaxis nueva = new CompaniaTaxis("Independent Owner"); 
		    			Taxi taxiAct = new Taxi(line[1]); 
			    		nueva.agregarTaxi(taxiAct);    
			    		companias.put(nueva.darNombreCompania(), nueva);
			    	}
		    		else
		    		{
		    			if((companias.get("Independent Owner").existeTaxi(line[1]))==false)
		    			{
		    				Taxi taxiAct = new Taxi(line[1]);
		    				companias.get("Independent Owner").agregarTaxi(taxiAct);
		    			
		    			}
		    		}
		    	}
		    	else if((companias.contains(line[12])== false))
		    	{
		    		CompaniaTaxis nueva = new CompaniaTaxis(line[12]); 
		    		Taxi taxiAct = new Taxi(line[1]);
		    		nueva.agregarTaxi(taxiAct);
		    		companias.put(nueva.darNombreCompania(), nueva);
		    	}
		    	else
		    	{
		    		if((companias.get(line[12]).existeTaxi(line[1])==false))
		    		{
		    			Taxi taxiAct = new Taxi(line[1]);
		    			companias.get(line[12]).agregarTaxi(taxiAct);
		    			
		    		}
		    	}
		    }
		    reader.close();
		    csvReader.close();  
		    data = true;
		} 
		catch (IOException | NumberFormatException | CsvValidationException e) 
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * Carga de los datos utilizando CSV, el file que carga es la data_medium.
	 */
	public void loadMedium()
	{
		companias = new tablaHashLinearProbing<String, CompaniaTaxis>(1000);
		cantidadTaxis = 0; 
		data = false;
		Path path = FileSystems.getDefault().getPath("data/", fileMedium); 
		Reader reader;
		
		try 
		{
			reader = Files.newBufferedReader(path);
			
			CSVParser parser = new CSVParserBuilder().withSeparator(',').withIgnoreQuotations(true).build();
			CSVReader csvReader = new CSVReaderBuilder(reader).withSkipLines(1).withCSVParser(parser).build();
			
		    String[] line;
		    while ((line = csvReader.readNext()) != null) 
		    {
		  
		    	if(line[13].equals("Chicago Independents"))
		    	{
		    		if((companias.contains("Independent Owner"))==false)
		    		{
		    			CompaniaTaxis nueva = new CompaniaTaxis("Independent Owner"); 
		    			Taxi taxiAct = new Taxi(line[1]); 
			    		nueva.agregarTaxi(taxiAct);    
			    		companias.put(nueva.darNombreCompania(), nueva);
			    	}
		    		else
		    		{
		    			if((companias.get("Independent Owner").existeTaxi(line[1]))==false)
		    			{
		    				Taxi taxiAct = new Taxi(line[1]);
		    				companias.get("Independent Owner").agregarTaxi(taxiAct);
		    			
		    			}
		    		}
		    	}
		    	else if((companias.contains(line[13])== false))
		    	{
		    		CompaniaTaxis nueva = new CompaniaTaxis(line[13]); 
		    		Taxi taxiAct = new Taxi(line[1]);
		    		nueva.agregarTaxi(taxiAct);
		    		companias.put(nueva.darNombreCompania(), nueva);
		    	}
		    	else
		    	{
		    		if((companias.get(line[13]).existeTaxi(line[1])==false))
		    		{
		    			Taxi taxiAct = new Taxi(line[1]);
		    			companias.get(line[13]).agregarTaxi(taxiAct);
		    			
		    		}
		    	}
		    }
		    reader.close();
		    csvReader.close();
		    data = true;
		} 
		catch (IOException | NumberFormatException | CsvValidationException e) 
		{
			e.printStackTrace();
		}
	}

	/**
	 * Carga de los datos utilizando CSV, el file que carga es la data_small.
	 */
	public void loadSmall() {
		companias = new tablaHashLinearProbing<String, CompaniaTaxis>(1000);
		cantidadTaxis = 0; 
		data = false;
		Path path = FileSystems.getDefault().getPath("data/", fileSmall); 
		Reader reader;
		
		try 
		{
			reader = Files.newBufferedReader(path);
			
			CSVParser parser = new CSVParserBuilder().withSeparator(',').withIgnoreQuotations(true).build();
			CSVReader csvReader = new CSVReaderBuilder(reader).withSkipLines(1).withCSVParser(parser).build();
			
		    String[] line;
		    while ((line = csvReader.readNext()) != null) 
		    {
		  
		    	if(line[14].equals("Chicago Independents"))
		    	{
		    		if((companias.contains("Independent Owner"))==false)
		    		{
		    			CompaniaTaxis nueva = new CompaniaTaxis("Independent Owner"); 
		    			Taxi taxiAct = new Taxi(line[1]); 
			    		nueva.agregarTaxi(taxiAct);    
			    		companias.put(nueva.darNombreCompania(), nueva);
			    	}
		    		else
		    		{
		    			if((companias.get("Independent Owner").existeTaxi(line[1]))==false)
		    			{
		    				Taxi taxiAct = new Taxi(line[1]);
		    				companias.get("Independent Owner").agregarTaxi(taxiAct);
		    			
		    			}
		    		}
		    	}
		    	else if((companias.contains(line[14])== false))
		    	{
		    		CompaniaTaxis nueva = new CompaniaTaxis(line[14]); 
		    		Taxi taxiAct = new Taxi(line[1]);
		    		nueva.agregarTaxi(taxiAct);
		    		companias.put(nueva.darNombreCompania(), nueva);
		    	}
		    	else
		    	{
		    		if((companias.get(line[14]).existeTaxi(line[1])==false))
		    		{
		    			Taxi taxiAct = new Taxi(line[1]);
		    			companias.get(line[14]).agregarTaxi(taxiAct);
		    			
		    		}
		    	}
		    }
		    reader.close();
		    csvReader.close(); 
		    data = true;
		} 
		catch (IOException | NumberFormatException | CsvValidationException e) 
		{
			e.printStackTrace();
		}
	}

	
	//--------------------------------------------------------------------------------
	//Metodos Generales
	//--------------------------------------------------------------------------------
	public void printMessage(String message) {
		controller.printMessage(message);
	}
	
	
	public ListaEncadenadaSinComparable<String> darCompanias()
	{
		return companias.keySet(); 
	}
	
	public boolean darCarga() {
		return data;
	}
	
	public void ShellSort(Comparable[]list, int tamanio) {
		sort.ShellSort(list, tamanio);
	}
	//--------------------------------------------------------------------------------
	//Metodos Parte A
	//--------------------------------------------------------------------------------
	public int darCantidadTaxis()
	{
		ListaEncadenadaSinComparable<CompaniaTaxis> companiasTaxis = companias.valueSet(); 
		for (int i = 0; i < companias.valueSet().contarDatos(); i++) 
		{
			CompaniaTaxis act = companiasTaxis.darElemento(i); 
			cantidadTaxis += act.darCantidadTaxis();
		}
		return cantidadTaxis; 
	}
	
	//--------------------------------------------------------------------------------
	//Metodos Parte B
	//--------------------------------------------------------------------------------
	
}
