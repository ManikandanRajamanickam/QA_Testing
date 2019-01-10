package com.altius.automation;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

import bsh.Variable;

import org.testng.annotations.Test;

import org.testng.annotations.Test;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestAutomation {

	WebDriver d;

	static org.apache.log4j.Logger logger;
	
	
	@Test (priority = 1)
	public void search() throws InterruptedException {
		
		try {
			
		WebElement srch = d.findElement(By.name("q"));
		
		srch.sendKeys("Software Testing");
		
		logger.info("user can enter the search keyword");
		
		Thread.sleep(2000);
		
		srch.sendKeys(Keys.ENTER);
		
			
	}
	 catch (Exception e) {
	
		 
		 logger.error("user can enter the search keyword");
	}

	}
	
	
	
	@Test (priority = 2)
	
	public void select() throws InterruptedException {
		
		try 
		{
		WebElement select = d.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div[1]/div/div/div[1]/a/h3"));
		
		select.click();
		
		Thread.sleep(2000);
		
		logger.info("user can open the link");
		
	}
		
		catch (Exception e) {
		
			logger.error("user can open the link");
		
		}
		
	}
	
	
	

	@BeforeTest
	public void beforeTest() {

		try {

			logger = logger.getLogger(" Habitos ERP");

			PropertyConfigurator.configure("log4jproperties.txt");

			System.setProperty("webdriver.chrome.driver",
					"..\\AltiusAutomationTemplate\\src\\test\\resources\\chromedriver.exe");

			// ChromeOptions options = new ChromeOptions();

			// options.addArguments("window-size=800,480");

			d = new ChromeDriver();

			logger.info("browser gets open");
			
			// ChromeOptions options = new ChromeOptions();

			// options.addArguments("start-maximized");

			Thread.sleep(1000);

			d.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			Thread.sleep(500);
			
			d.get("http://www.google.com/");

			logger.info("browser gets valid ip address");

		}

		catch (Exception e) {

			logger.error("isn't working");

			System.out.println("isn't working");

		}

	}
	/*  
	@Test
	public static void main(String[] args) throws InterruptedException {

		logger = logger.getLogger(" Habitos - ERP");

		PropertyConfigurator.configure("log4jproperties.txt");

		// DOMConfigurator.configure("logging.xml");

		TestAutomation hts = new TestAutomation();

		System.out.println("first method is running");
		hts.beforeTest();
		
		System.out.println("2nd method is running");
		hts.Login_invalid();
		
		System.out.println("3rd method is running");
		hts.Login_valid();
		
		System.out.println("4th method is running");
	
		//	hts.boundary_valus();
		
		hts.Crminfo_Add();
		
		System.out.println("5th method is running");
		hts.info_add();
		
		hts.Crminfo_Add_meal();
		
		hts.CRM_update();
		
	}

	*/

	@AfterTest
	public void afterTest() {

		d.quit();
	}

}
