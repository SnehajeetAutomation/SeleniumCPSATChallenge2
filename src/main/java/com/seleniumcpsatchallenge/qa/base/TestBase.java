package com.seleniumcpsatchallenge.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.seleniumcpsatchallenge.qa.util.TestUtil;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase() {

		try {
			prop = new Properties();
			FileInputStream configfile = new FileInputStream(System.getProperty("user.dir")
					+ "//src//main//java//com//seleniumcpsatchallenge//qa//config//config.properties");
			prop.load(configfile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void initialization(String browserName) {
		//String browserName = prop.getProperty("browser");
		
		if (browserName.equals("Chrome")) {

			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//resources//chromedriver.exe");
			// Open browser
			driver = new ChromeDriver();

		} else if (browserName.equals("FireFox")) {
			
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"//resources//geckodriver.exe");
			// Open browser
			driver = new FirefoxDriver();

		}
	
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		
	}

}
