package com.sissy.rentalcars.mainApp;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.sissy.rentalcars.services.AssetService;

/**
 * @author Sissy S
 * Driver class for AssetService
 *
 */
public class Driver {
    
	static Logger myLogger = Logger.getLogger(Driver.class.getName());
	
	public static void main(String[] args) {
		
		myLogger.log(Level.INFO,"Creating New AssetService Object");
		AssetService service = new AssetService();
		
		try {
			myLogger.log(Level.CONFIG,"Using file:'data/sample-full.json'");
			String fileName = "data/sample-full.json";
			
			myLogger.log(Level.INFO,"calling AssetService.loadAssetList(fileName)..");
			service.loadAssetList(fileName);
			
			myLogger.log(Level.INFO,"calling AssetService.getAllBlueTeslas()..");
			service.printAllBlueTeslas();
			
			myLogger.log(Level.INFO,"calling AssetService.getPerDayLowestRentCars()..");
			service.printPerDayLowestRentCars();
			
			myLogger.log(Level.INFO,"calling AssetService.getHigestRevenueAssets()..");
			service.printHigestRevenueAssets();
			
		} catch (JsonParseException e) {
			myLogger.log(Level.WARNING,e.getMessage());
			e.printStackTrace();
		} catch (JsonMappingException e) {	
			myLogger.log(Level.WARNING,e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			myLogger.log(Level.WARNING,e.getMessage());
			e.printStackTrace();
		}
	}

}
