package com.seleniumcpsatchallenge.qa.problemstatements;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.seleniumcpsatchallenge.qa.base.TestBase;
import com.seleniumcpsatchallenge.qa.pages.MeriPustakPage;

public class ProblemStatementMeriPustakTest extends TestBase{
	
	MeriPustakPage testMeriPustak;
	
	public ProblemStatementMeriPustakTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		//Using Chrome Version 75.0.3770.100 (Official Build) (32-bit)
		//Pass the name of browser as argument in which you want to Execute the script 
		initialization("Chrome");
		testMeriPustak = new MeriPustakPage();
		driver.get("https://www.meripustak.com/");
	}
	
	//Print the width and height of the logo 
	@Test(priority = 1)
	public void logoForMeriPustakTest() {
		//implementation is place is below method
		testMeriPustak.printWidthHeightMeriPustakLogo();
	}

	@Test(priority = 2)
	public void twitterHrefTest() {
		//implementation is place is below method
		testMeriPustak.printHerfForTwitter();
	}

	@Test(priority = 3)
	public void clickAndVerifyCartMessageTest() {
		//implementation is place is below method
		testMeriPustak.verifyCartMessage();

	}

	@Test(priority = 4)
	public void addJavaBookAndVerifyCardMessageTest() {
		
		
		if (driver.findElement(By.xpath("//span[ text()='0 Item' and @id='lblNoCartItem']")).isDisplayed()) {
			
			//implementation is place is below method
			testMeriPustak.addJavaBookVerifyNessage();

		}

	}

	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	
}
