package com.sissy.rentalcars.services;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sissy.rentalcars.entity.Assets;

/**
 * @author Sissy S
 * service class for Rental cars
 *
 */
public class AssetService {

	static Logger myLogger = Logger.getLogger(AssetService.class.getName());
	private List<Assets> assetList;

	/**
	 * non-arg constructor 
	 */
	public AssetService() {
		myLogger.log(Level.INFO,"non-arg constructor of AssetService.. ");
		this.assetList = new ArrayList<Assets>();
	}

	/**
	 * @param fileName
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 * use mapper object to unMarshal json to pojo
	 * load instance variable with pojo list.
	 */
	public void loadAssetList(String fileName) throws JsonParseException, JsonMappingException, IOException {

		myLogger.log(Level.INFO,"Creating a new ObjectMapper..");
		ObjectMapper mapper = new ObjectMapper();

		myLogger.log(Level.INFO,"Reading values from provided json file..");
		this.assetList = mapper.readValue(new File(fileName), new TypeReference<List<Assets>>() {});

	}

	/**
	 * @return the assetList
	 * getter method for assetList
	 */
	public List<Assets> getAssetList() {
		return assetList;
	}

	/**
	 * @param givenMake
	 * @param givenColor
	 * @return list of cars with given Make and Color
	 */
	private List<Assets> getAssetsForGivenMakeAndColor(String givenMake, String givenColor) {

		List<Assets> carList = new ArrayList<Assets>();

		if (this.assetList.size() != 0) {
			for (Assets asset : this.assetList) {
				String currMake = asset.getCar().getMake();
				String currColor = asset.getCar().getMetadata().getColor();
				if (currMake.equalsIgnoreCase(givenMake) && currColor.equalsIgnoreCase(givenColor)) {
					carList.add(asset);
				}
			} // end of for loop.
		}

		return carList;
	}

	
	/**
	 * void method.
	 * Prints all blueTesals details
	 */
	public void printAllBlueTeslas() {
        
		myLogger.log(Level.INFO,"calling AsserService.getAssetsForGivenMakeAndColor(String givenMake, String givenColor)");
		List<Assets> blueTeslasList = new ArrayList<Assets>(getAssetsForGivenMakeAndColor("Tesla", "blue"));

		System.out.println("\nTotal no. of blue Teslas : " + blueTeslasList.size());

		if (blueTeslasList.size() != 0) {
			System.out.println("\nDetails of blue Teslas\n");

			for (Assets asset : blueTeslasList) {

				System.out.println("Model :" + asset.getCar().getModel());
				System.out.println("Vin :" + asset.getCar().getVin());
				System.out.println("Notes :" + asset.getCar().getMetadata().getNotes());

			}

		}

	}

	/**
	 * @param asset
	 * @return final price after discount for per day rent
	 */
	private double getRentAfterDiscount(Assets asset) {

		double actualPrice = (double) asset.getCar().getPerdayrent().getPrice();
		double discount = (double) asset.getCar().getPerdayrent().getDiscount();

		double finalPrice = actualPrice - discount;

		return finalPrice;

	}

	
	/**
	 * @return lowest per day rent available among assets
	 * 	 */
	public double getLowestPerDayRent() {

		double lowestRent = Double.MAX_VALUE;

		if (this.assetList.size() != 0) {
			for (Assets asset : this.assetList) {
               
				myLogger.log(Level.INFO,"calling AsserService.getRentAfterDiscount(asset)..");
				double finalPrice = getRentAfterDiscount(asset);
				if (finalPrice < lowestRent) {
					lowestRent = finalPrice;
				}

			} // end of for loop
		}

		return lowestRent;
	}
	
  
	/**
	 * prints list of cars having lowest per day rent
	 */
	public void printPerDayLowestRentCars() {

		myLogger.log(Level.INFO,"calling AsserService.getLowestPerDayRent()..");
		double lowestRent = getLowestPerDayRent();

		System.out.println("\n\nLowest per day rental cost : " + lowestRent);
		System.out.println("Car details haing lowest per day rental cost \n");

		if (this.assetList.size() != 0) {
			for (Assets asset : this.assetList) {
				myLogger.log(Level.INFO,"calling AsserService.getRentAfterDiscount(asset)..");
				if (getRentAfterDiscount(asset) == lowestRent) {
					System.out.println("\n" + asset);
				}
			} // end of for loop

		}
	}

	/**
	 * @param asset
	 * @return total revenue per year per asset
	 */
	private double getTotalAvenue(Assets asset) {
		double totalRevenue = 0;
       
		float totalExpence = asset.getCar().getMetrics().getYoymaintenancecost()
				+ asset.getCar().getMetrics().getDepreciation();

		int yearToDate = asset.getCar().getMetrics().getRentalcount().getYeartodate();
		float totalPricePerDay = asset.getCar().getPerdayrent().getPrice()
				- asset.getCar().getPerdayrent().getDiscount();
		double totalIncome = (double) (totalPricePerDay * yearToDate);
         
		totalRevenue = totalIncome - totalExpence;
        
		return totalRevenue;
		
	}

	/**
	 * @return highest revenue per year among assets
	 */
	public double getHigestRevenue() {

		double higestIncome = Double.MIN_VALUE;

		if (this.assetList.size() != 0) {

			for (Assets asset : this.assetList) {
				myLogger.log(Level.INFO,"calling AsserService.getTotalAvenue(asset)..");
				double currIncome = getTotalAvenue(asset);

				if (currIncome > higestIncome) {

					higestIncome = currIncome;
				}

			}
		}
		return higestIncome;
	}

	/**
	 * prints highest revenue generated assets
	 */
	public void printHigestRevenueAssets() {

		myLogger.log(Level.INFO,"calling AsserService.getHigestRevenue()..");
		double higestIncome = getHigestRevenue();

		System.out.println("\n\nHigest Revenue :" + higestIncome);
		System.out.println("HigestRevenueAssets :");
		if (this.assetList.size() != 0) {

			for (Assets asset : this.assetList) {
				myLogger.log(Level.INFO,"calling AsserService.getTotalAvenue(asset)..");
				if (getTotalAvenue(asset) == higestIncome) {

					System.out.println(asset);
				}

			} // end of for loop
		}
	}

}
