package com.seleniumcpsatchallenge.qa.problemstatements;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import com.seleniumcpsatchallenge.qa.base.TestBase;
import com.seleniumcpsatchallenge.qa.pages.HomeTownPage;

public class ProblemStatementHomeTown extends TestBase{
	
	HomeTownPage testHomePage;
	
	public ProblemStatementHomeTown(){
		super();
	}

	@Before
	public void setUp() {
		//using FireFox 60.7.2esr (32-bit)
		// Pass the name of browser as argument in which you want to Execute script
		initialization("FireFox");
		driver.get("https://www.hometown.in/");
		testHomePage = new HomeTownPage();
	}
	
	@Test
	public void homeTownProductTest() throws InterruptedException{
		
		testHomePage.popUpHandlesIfExist();
		
		//implementation is place in below method for problem statement HomeTown web page
		testHomePage.homeTownProblemStatementImplementation();

	}
	

	@After
	public void tearDown() {
		driver.quit();
	}

}
