package com.seleniumcpsatchallenge.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.seleniumcpsatchallenge.qa.base.TestBase;

public class CiiOnlineRegistrationPage extends TestBase {

	// page Factory - object repository
	@FindBy(xpath = "//select[@id='drpAttendee']")
	WebElement numberOfAttendee;

	@FindBy(xpath = "//select[@id='drpRegTitle']")
	WebElement dropDown;
	
	@FindBy(xpath = "//table[@id='Gridview1']/tbody//select[@id='Gridview1_ctl02_drpTitle']")
	WebElement rowNub1;

	@FindBy(xpath = "//table[@id='Gridview1']/tbody//select[@id='Gridview1_ctl03_drpTitle']")
	WebElement rowNub2;

	@FindBy(xpath = "//table[@id='Gridview1']/tbody//select[@id='Gridview1_ctl04_drpTitle']")
	WebElement rowNub3;

	// initializing the page object
	public CiiOnlineRegistrationPage() {
		PageFactory.initElements(driver, this);

	}

	public int selectNumberOfAttendees(String numberOfAttendent) {
		
		Select dropDownNumberOfAttendee = new Select(numberOfAttendee);
		dropDownNumberOfAttendee.selectByVisibleText(numberOfAttendent);
		System.out.println("Successfully selected the dropdown value as : " + numberOfAttendent);

		List<WebElement> listOfRow = driver.findElements(By.xpath("//table[@id='Gridview1']/tbody/tr"));
		int countOfRow = listOfRow.size() - 1;

		return countOfRow;

	}

	public void selectTitleForRowOne(String title) {
		Select dropDownForTitleRowOne = new Select(rowNub1);
		dropDownForTitleRowOne.selectByVisibleText(title);

	}

	public void selectTitleForRowTwo(String title) {
		Select dropDownForTitleRowTwo = new Select(rowNub2);
		dropDownForTitleRowTwo.selectByVisibleText(title);

	}

	public void selectTitleForRowThree(String title) {
		Select dropDownForTitleRowThree = new Select(rowNub3);
		dropDownForTitleRowThree.selectByVisibleText(title);

	}
	
	public void printTheListInTitleDropDown(){
		
		Select dropDownForTitle = new Select(dropDown);
		List<WebElement> listTitle = dropDownForTitle.getOptions();
		
		for (int i = 0; i < listTitle.size(); i++) {
			System.out.println(listTitle.get(i).getText());
		}
	}
	

}
