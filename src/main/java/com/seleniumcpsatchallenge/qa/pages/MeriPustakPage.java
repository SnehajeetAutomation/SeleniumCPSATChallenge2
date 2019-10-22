package com.seleniumcpsatchallenge.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.seleniumcpsatchallenge.qa.base.TestBase;

public class MeriPustakPage extends TestBase{
	
	//page Factory - object repository
	@FindBy(xpath="//img[@alt='Meripustak logo']")
	WebElement Meripustaklogo;
	
	
	
	
	//initializing the page object
	public MeriPustakPage(){
		PageFactory.initElements(driver, this);
		
	}
	
	
	//Action:
	public void printWidthHeightMeriPustakLogo() {

		int width = Meripustaklogo.getSize().getWidth();
		int height = Meripustaklogo.getSize().getHeight();
		
		System.out.println("Width of MeriPustak Logo is : " +width);
		System.out.println("Height of MeriPustak Logo is : " +height);
	}
	
	
	public void printHerfForTwitter(){
		String hrefTwitter ="https://twitter.com/meripustak";
		
		List<WebElement> allLinks = driver.findElements(By.tagName("a"));
		
		for (int i = 0; i < allLinks.size(); i++) {
			
			String link = allLinks.get(i).getAttribute("href");
			if(null!= link && link.equals(hrefTwitter)){
				System.out.println("The href link for Twitter is : "+allLinks.get(i).getAttribute("href"));
				break;
			}
		}
		
	}
	
	public void verifyCartMessage(){
		if (driver.findElement(By.xpath("//span[ text()='0 Item' and @id='lblNoCartItem']")).isDisplayed()) {

			driver.findElement(By.xpath("//span[@id='lblNoCartItem']")).click();
			String emptyCartMessage = driver
					.findElement(By
							.xpath("//table[@id='ContentPlaceHolder1_gvCartTable']/tbody/tr/td"))
					.getText();

			Assert.assertEquals(emptyCartMessage, "No Item is Added In Cart yet.Cart is Empty!!!",
					"Empty Cart message is not as expected");
			System.out.println("Verification of message on shopping cart table is SUCCESSFULL ");
			 
		}
	}
	
	public void addJavaBookVerifyNessage(){
		
		driver.findElement(By.xpath("//input[@id='txtsearch']")).sendKeys("JAVA");
		driver.findElement(By.xpath("//a[@id='btnsearch']")).click();
		driver.findElement(By.xpath("//span[text()='Core and Advanced Java, Black Book, Recommended by CDAC, Revised and Upgraded']")).click();
		driver.findElement(By.xpath("//input[@id='ContentPlaceHolder1_AddtoCart']")).click();
		
		String webtest= driver.findElement(By.xpath("//table[@id='ContentPlaceHolder1_gvCartTable']/tbody/tr/td")).getText();
		
		if( webtest.contains("No Item is Added In Cart yet.Cart is Empty!!!")){
			System.out.println("Empty Cart  message exists in the shopping cart table on meripustak.com");
		}else{
			System.out.println("Empty Cart  message does NOT exists in the shopping cart table on meripustak.com");
			System.out.println("===================================================================================");
		}
		
	}
	
	

}
