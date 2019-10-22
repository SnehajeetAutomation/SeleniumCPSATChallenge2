package com.seleniumcpsatchallenge.qa.problemstatements;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.seleniumcpsatchallenge.qa.base.TestBase;
import com.seleniumcpsatchallenge.qa.pages.WoodlandWorldWidePage;
import com.seleniumcpsatchallenge.qa.util.TestUtil;


public class ProblemStatementWoodlandWorldWide extends TestBase{
	
	
	WoodlandWorldWidePage testWoodland;
	String sheetName = "productName";
	
	public ProblemStatementWoodlandWorldWide(){
		super();
	}

	@BeforeMethod
	public void setUp() {
		//Using Chrome Version 75.0.3770.100 (Official Build) (32-bit)
		//Pass the name of browser as argument in which you want to Execute the script 
		initialization("Chrome");
		testWoodland = new WoodlandWorldWidePage();
		driver.get("https://www.woodlandworldwide.com/");
	}
	
	@DataProvider
	public Object [][] getProductTestData(){
		Object data[][]= TestUtil.getTestData(sheetName);
		return data;
	}
	
	@Test(priority = 1 , dataProvider="getProductTestData")
	public void SearchProductTest(String searchProduct) throws InterruptedException {
		
		//pass the product name as argument
		testWoodland.searchProduct(searchProduct);
		
		//pass the product name as argument to see output on console and pass number as 8 products are in descending order of the price or not 
		testWoodland.sortingPrices(searchProduct, 8);
	}

	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	
}
