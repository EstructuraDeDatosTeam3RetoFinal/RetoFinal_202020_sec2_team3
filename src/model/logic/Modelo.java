package model.logic;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

import javax.sound.midi.SysexMessage;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.exceptions.CsvValidationException;

import controller.Controller;
import model.data_structures.ArregloDinamico;
import model.data_structures.CompaniaTaxis;
import model.data_structures.IArregloDinamico;
import model.data_structures.ListaEncadenadaSinComparable;
import model.data_structures.Taxi;
import model.data_structures.tablaHashLinearProbing;

/**
 * Definicion del modelo del mundo
 *
 */
public class Modelo {
	
	private static String file = "taxi-trips-wrvz-psew-subset-large.csv";
	
	/**
	 * Atributos del modelo del mundo
	 */
	private Controller controller;
	private IArregloDinamico datos;
	private tablaHashLinearProbing<String, CompaniaTaxis> companias; 
	private int cantidadTaxis;
	
	/**
	 * Constructor del modelo del mundo con capacidad predefinida
	 */
	public Modelo(Controller pController)
	{
		controller = pController;
		companias = new tablaHashLinearProbing<String, CompaniaTaxis>(1000); 
		cantidadTaxis = 0; 
	}
	
	/**
	 * Carga de los datos utilizando CSV
	 */
	public void load()
	{
		int total = 0;
		
		int notLoaded = 0;
		
		Path path = FileSystems.getDefault().getPath("data/", file);
		Reader reader;
		
		try 
		{
			reader = Files.newBufferedReader(path);
			
			CSVParser parser = new CSVParserBuilder().withSeparator(',').withIgnoreQuotations(true).build();
				 
			CSVReader csvReader = new CSVReaderBuilder(reader).withSkipLines(1).withCSVParser(parser).build();
			
		    String[] line;
		    while ((line = csvReader.readNext()) != null) 
		    {
		    	
		    }
		    reader.close();
		    csvReader.close();  
		} 
		catch (IOException | NumberFormatException | CsvValidationException e) 
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * Carga de los datos utilizando CSV
	 */
	public void cargarDatosParteA()
	{
		
		Path path = FileSystems.getDefault().getPath("data/", file); 
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
		} 
		catch (IOException | NumberFormatException | CsvValidationException e) 
		{
			e.printStackTrace();
		}
	}
	
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
	
	public void printMessage(String message) {
		controller.printMessage(message);
	}
	
	public ListaEncadenadaSinComparable<String> darCompanias()
	{
		return companias.keySet(); 
	}
}
