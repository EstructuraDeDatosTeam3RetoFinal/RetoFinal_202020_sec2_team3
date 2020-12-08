package model.logic;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.exceptions.CsvValidationException;

import controller.Controller;
import model.data_structures.ArregloDinamico;
import model.data_structures.IArregloDinamico;

/**
 * Definicion del modelo del mundo
 *
 */
public class Modelo {
	
	private static String file = "";
	
	/**
	 * Atributos del modelo del mundo
	 */
	private Controller controller;
	private IArregloDinamico datos;
	
	/**
	 * Constructor del modelo del mundo con capacidad predefinida
	 */
	public Modelo(Controller pController)
	{
		controller = pController;
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
	
	public void printMessage(String message) {
		controller.printMessage(message);
	}
	
}
