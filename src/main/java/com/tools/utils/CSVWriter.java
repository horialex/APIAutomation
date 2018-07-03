package com.tools.utils;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.tools.constants.EnvironmentConstants;

public class CSVWriter {
	
	public static void writeCSV() {
		String fileName = "csvImport.csv";
		String csvPath =  EnvironmentConstants.CSV_RESOURCES_PATH + fileName;
		
		try {
			 BufferedWriter writer = Files.newBufferedWriter(Paths.get(csvPath));
			  CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT.withHeader("Name", "Item", "tag", "Description"));
//			  csvPrinter.printRecord(values);
	                    
		}catch(Exception e) {
			
		}finally {
			
		}
	}

}
