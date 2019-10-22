package com.seleniumcpsatchallenge.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.seleniumcpsatchallenge.qa.base.TestBase;

public class PremierLeaguePage extends TestBase{
	
	// page Factory - object repository
	@FindBy(xpath = "//main[@id='mainContent']//a[@id='advertClose']")
	WebElement advertiseCloseButton;
	
	
	@FindBy(xpath = "//div[text()='I accept cookies from this site']")
	WebElement acceptCookiesButton;
	
	@FindBy(xpath = "//a[text()='Tables']")
	WebElement tableClickButton;
	
	@FindBy(xpath = "//div[@class='website']//a")
	WebElement officailWebsite;
	
	// initializing the page object
	public PremierLeaguePage() {
		PageFactory.initElements(driver, this);

	}
	
	public void advertisementClose(){
		if(advertiseCloseButton.isDisplayed()){
		advertiseCloseButton.click();
		}
	}
	
	public void acceptCookiesOnPremierLeaguePage(){
		if(acceptCookiesButton.isDisplayed()){
		acceptCookiesButton.click();
		}
	}
	
	public void getOfficailWebsite(){
		
		String getofficailWebsite = officailWebsite.getText();
		System.out.println("The official website URL on the page : " +getofficailWebsite);
		
	}
	
	
	public void premierLeaguePageAction() throws InterruptedException{
		tableClickButton.click();
		Thread.sleep(2000);
		
		WebElement linkArsenal = driver.findElement(By.xpath("//tr[@data-filtered-table-row-name='Arsenal']//td[@class='team']/a"));

		Actions action = new Actions(driver);
		action.moveToElement(linkArsenal).build().perform();
		
		//Below is the snippet for context click to open in new window its flaky due to browser Version so i am going with shift click for problem statement
		/*action.contextClick(linkArsenal).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();*/
		
		action.keyDown(Keys.SHIFT).click(linkArsenal).keyUp(Keys.SHIFT).build().perform();
	}
	

}
