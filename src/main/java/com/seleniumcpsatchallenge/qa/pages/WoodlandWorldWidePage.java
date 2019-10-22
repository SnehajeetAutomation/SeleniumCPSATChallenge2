package com.seleniumcpsatchallenge.qa.pages;

import java.util.ArrayList;
//import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.seleniumcpsatchallenge.qa.base.TestBase;

public class WoodlandWorldWidePage extends TestBase{
	
	// page Factory - object repository
	@FindBy(xpath = "//form[@id='searchForm']/div[contains(@class,'searchIcon')]")
	WebElement searchProduct;
	
	
	@FindBy(xpath = "//input[@id='searchkey']")
	WebElement sendProductName;
	
	
	@FindBy(xpath = "//input[@id='searchBtn']")
	WebElement searchButton;
	
	@FindBy(xpath = "//input[@id='prcHTL_sort' and @type='radio']//parent::li[contains(text(),' ')]")
	WebElement radioButton;
	
	// initializing the page object
	public WoodlandWorldWidePage() {
		PageFactory.initElements(driver, this);

	}
	
	
	//Action
	public void searchProduct(String productname){
		
		searchProduct.click();
		sendProductName.sendKeys(productname);
		searchButton.click();
		
	}
	
	public void sortingPrices(String productname , int numberOfFirstProductToSort) throws InterruptedException{  
		radioButton.click();

		List<WebElement> productPriceList = driver.findElements(By.xpath("//span[@class='mrp']"));
		ArrayList<Float> priceList = new ArrayList<Float>();

		for (int i = 0; i <= numberOfFirstProductToSort ; i = i + 1) {

			priceList.add(Float.parseFloat(productPriceList.get(i).getText().replace("R ", "")));

		}
		
		 if(!descendingCheck(priceList)){
		        Assert.fail("Price list Not is descending order");
		        System.out.println("Price list for Searched Product Name [ " + productname + " ] for First 8 product is NOT in descending order.");
		    }else{
		    	System.out.println("Price list for Searched Product Name [ " + productname + " ] for First 8 product is in descending order.");
		    }
		

	}
	
	public Boolean descendingCheck(ArrayList<Float> data){         
        for (int i = 0; i < data.size()-1; i++) {
            if (data.get(i) < data.get(i+1)) {
                return false;
            }       
         }
         return true;
     }
	
	public Boolean ascendingCheck(ArrayList<Float> data){         
        for (int i = 0; i < data.size()-1; i++) {
            if (data.get(i) > data.get(i+1)) {
                return false;
            }       
         }
         return true;
     }

}
