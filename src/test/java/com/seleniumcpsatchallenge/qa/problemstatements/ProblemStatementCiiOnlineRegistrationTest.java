package com.seleniumcpsatchallenge.qa.problemstatements;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.seleniumcpsatchallenge.qa.base.TestBase;
import com.seleniumcpsatchallenge.qa.pages.CiiOnlineRegistrationPage;


public class ProblemStatementCiiOnlineRegistrationTest extends TestBase {

	CiiOnlineRegistrationPage testCiiOnlineRegistration;

	public ProblemStatementCiiOnlineRegistrationTest() {
		super();
	}

	@Before
	public void setUp() {
		//using FireFox 60.7.2esr (32-bit)
		// Pass the name of browser as argument in which you want to Execute script
		initialization("FireFox");
		driver.get("https://www.cii.in/OnlineRegistration.aspx");
		testCiiOnlineRegistration = new CiiOnlineRegistrationPage();
	}

	@Test
	public void numberOfAttendeesTest() {

		int expectedCountForRow = 3;
		// Pass the number of attendees in string format as argument to the method below
		int actualRowCountAttendeesTable = testCiiOnlineRegistration.selectNumberOfAttendees("3");
		Assert.assertEquals(expectedCountForRow, actualRowCountAttendeesTable);

	}

	@Test
	public void selectTitleForAttendeesRowTest() {
		// Pass the number of attendees in string format as argument to the method below
		testCiiOnlineRegistration.selectNumberOfAttendees("3");

		// Pass the Title in string format as argument to the method below to select title created three method as method in problem statement
		testCiiOnlineRegistration.selectTitleForRowOne("Admiral");
		testCiiOnlineRegistration.selectTitleForRowTwo("CA");
		testCiiOnlineRegistration.selectTitleForRowThree("CS");
	}

	@Test
	public void printOptionInTitleTest() {
		System.out.println("Below is the list of Title present in dropdown");
		System.out.println("==============================================");
		testCiiOnlineRegistration.printTheListInTitleDropDown();
	}

	@After
	public void tearDown() {
		driver.quit();
	}

}
