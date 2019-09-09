
package com.sissy.rentalcars.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.sissy.rentalcars.entity.Assets;



class AssetServiceTest {

	AssetService service;
	
	
	@BeforeEach
	public void init() throws JsonParseException, JsonMappingException, IOException
	{
		service = new AssetService();
		service.loadAssetList("data/sample-full.json");
	}
	
	@Test
	public void testGetAssetList() { 
		assertNotNull(service.getAssetList());
		assertTrue(service.getAssetList().get(0) instanceof Assets);
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void testGetAssetsForGivenMakeAndColor() 
			throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
		Method method =  AssetService.class.getDeclaredMethod("getAssetsForGivenMakeAndColor", String.class,String.class);
		method.setAccessible(true);
		
		List<Assets> output1  = (List<Assets>) method.invoke(service,"Tesla","Blue");
		assertEquals(1, output1.size());
		assertEquals("tesla",output1.get(0).getCar().getMake().toLowerCase());
		assertEquals("blue",output1.get(0).getCar().getMetadata().getColor().toLowerCase());
		
		List<Assets> output2  = (List<Assets>) method.invoke(service,"tesla","blue");
		assertEquals(1, output2.size());
		assertEquals("tesla",output2.get(0).getCar().getMake().toLowerCase());
		assertEquals("blue",output2.get(0).getCar().getMetadata().getColor().toLowerCase());
	
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void testPrintAllBlueTeslas()
			throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
		Method method =  AssetService.class.getDeclaredMethod("getAssetsForGivenMakeAndColor", String.class,String.class);
		method.setAccessible(true);
		
		List<Assets> output  = (List<Assets>) method.invoke(service,"Tesla","Blue");
	    
	    assertNotNull(output);
	    assertEquals(1,output.size());
				
	}

	
	@Test
	public void testGetRentAfterDiscount() 
			throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
		List<Assets> inputList = service.getAssetList();
		
		assertNotNull(inputList);
	    assertTrue(inputList.size()!=0);
	    
	    Assets input = inputList.get(0);
		
		Method method =  AssetService.class.getDeclaredMethod("getRentAfterDiscount", Assets.class);
		method.setAccessible(true);
		
		double output = (double) method.invoke(service, input);
		
		assertEquals(125,output,0.001);
			
	}
	
	@Test
	public void testGetLowestPerDayRent() 
			throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
		List<Assets> inputList = service.getAssetList();
		
		assertNotNull(inputList);
	    assertTrue(inputList.size()!=0);
	    
	   
	    assertEquals(125,service.getLowestPerDayRent(),0.001);
				
	}
	
	@Test
	public void testGetTotalAvenue() 
			throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
		List<Assets> inputList = service.getAssetList();
		
		assertNotNull(inputList);
	    assertTrue(inputList.size()!=0);
	    
	    Assets input = inputList.get(0);
		
		Method method =  AssetService.class.getDeclaredMethod("getTotalAvenue", Assets.class);
		method.setAccessible(true);
		
		double output = (double) method.invoke(service, input);
		
		assertEquals(23177.81,output,0.01);
			
	}
	
	@Test
	public void testGetHigestRevenue()
			throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
		List<Assets> inputList = service.getAssetList();
		
		assertNotNull(inputList);
	    assertTrue(inputList.size()!=0);
	    
	   
	    assertEquals(49777.81,service.getHigestRevenue(),0.01);
				
	}
	
	
}
