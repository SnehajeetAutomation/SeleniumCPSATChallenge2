package com.seleniumcpsatchallenge.qa.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.seleniumcpsatchallenge.qa.base.TestBase;

public class HomeTownPage extends TestBase{

		// page Factory - object repository
		@FindBy(xpath = "//a[text()='Electronics']")
		WebElement clickOnElectronics;
		
		@FindBy(xpath = "//label[text()='Filter By']")
		WebElement filterBy;
		
		@FindBy(xpath = "//button[text()='Color']")
		WebElement mouseHoverToColorFilter;

		
		@FindBy(xpath = "//button[text()='Color']//following-sibling::div//label[@for='checkbox' and text()='Black']")
		WebElement checkboxSelect;
		
		
		@FindBy(xpath = "//img[contains(@alt,'Zone Wine Cooler in Black Colour by Koryo')]")
		WebElement firstProductInList;
		
		
		@FindBy(xpath = "(//button[text()='QUICK VIEW'])[1]")
		WebElement quickViewClick;
		
		
		@FindBy(xpath = "//a[contains(text(),'Zone Wine Cooler in Black Colour by Koryo')]")
		WebElement productNameOnQuickView;
		
		
		@FindBy(xpath = "//button[@class='styles_closeButton__20ID4']")
		WebElement closeButtonOnQuickView;
		
		@FindBy(xpath = "//label[text()='Applied Filters']//following-sibling::div/ul//li[contains(text(),'Black')]")
		WebElement appliedfiltersLabel;
		
		
		@FindBy(xpath = "//button[contains(@class ,'styles_closeButton__' )]")
		WebElement popupClose;
		
		// initializing the page object
		public HomeTownPage() {
			PageFactory.initElements(driver, this);

		}
		
		public void popUpHandlesIfExist(){
			//implementation to handle pop up
			if(driver.findElements(By.xpath("//button[contains(@class ,'styles_closeButton__' )]")).size() > 0){
				popupClose.click();
			}
		}
		
		public void homeTownProblemStatementImplementation() throws InterruptedException{
			
			clickOnElectronics.click();
			Thread.sleep(5000);
			Actions action = new Actions(driver);
			
			
			action.moveToElement(mouseHoverToColorFilter).build().perform();
			
			
			checkboxSelect.click();
			
			action.moveToElement(firstProductInList).build().perform();
			quickViewClick.click();
			
			String actualProductName = productNameOnQuickView.getText();
			System.out.println("Product name on click for quick view : " +actualProductName);
			
			String expectedKeyInProductName = "Black";
			
			//Assert that product name contains Black in a name.
			Assert.assertTrue(actualProductName.contains(expectedKeyInProductName));
			
			closeButtonOnQuickView.click();
			
			//verify if Black is also present in Applied filters 
			
			if(appliedfiltersLabel.isDisplayed()){
				System.out.println("Black is also present in Applied filters");
			}else{
				System.out.println("Black is also NOT present in Applied filters");
			}
			
			
		}
	
}
