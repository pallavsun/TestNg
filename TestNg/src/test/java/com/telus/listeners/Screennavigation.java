package com.telus.listeners;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;


public class Screennavigation {

	public WebDriver driver;
	String url = "https://nxtgenaiacademy.com/";
	
	@BeforeClass
	public void launchApplication() {

		// Set the system property for the chrome driver
    //  System.setProperty("webdriver.chrome.driver", ".\\Driver\\chromedriver.exe");
		
		WebDriverManager.chromedriver().setup();

		//Creating instance of Chrome driver
		driver=new ChromeDriver();

		//Maximize  the browser 
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);

		// ========Launch the URL============
		driver.get(url);
		System.out.println("Welcome to NXTGen AI Academy home page");

		System.out.println("Application is launched");
	}
	
	
	@AfterClass
	public void closeApplication() {

		driver.quit();
		System.out.println("Application is closed");
	}
	
	
	
	

	@Test(priority = 1)
	public void navigateToRegisterDemo() {


		//=======Create an object of Action class======= 
		Actions act=new Actions(driver);


		// Webelement for QA Automation Link
		WebElement qaAutomationLink = driver.findElement(By.xpath("//spa[text()='QA Automation']"));

		// Check whether the  QA Automation link is enabled or not.
		if (qaAutomationLink.isDisplayed())
		{
			act.moveToElement(qaAutomationLink).perform();
			System.out.println("QA Automation  link is displayed On Register page");
			
		}

		else
		{
			System.out.println("QA Automation link is not displayed");
		}



		//======= Move the cursor to  Practice Automation link==========
		// Webelement for Practice automation link
		WebElement practiceAutomation = driver.findElement(By.xpath("//span[text()='Practice Automation']"));

		// Check whether Practice Automation link is displayed or not.
		if (practiceAutomation.isDisplayed()) 
		{
			//If Practice Automation link  is displayed move the cursor on it.

			act.moveToElement(practiceAutomation).perform();
			System.out.println("Practice Automation link is displayed");
			
		}

		else 
		{
			System.out.println("Practice Automation link is not displayed");
		}		


		// ========= Move the cursor to Registration Form=========
		WebElement registrationLink = driver.findElement(By.partialLinkText("Registration Form"));

		// Check whether 'Demo Site-Registration Form' link is Displayed or not.

		if (registrationLink.isDisplayed())
		{
			System.out.println("Demo Site-Registration  link is displayed");
			registrationLink.click();     // Click on Demo Registration form link
			

		}
		else 
		{
			System.out.println("Demo Site-Registration  link is not displayed");
		}

		System.out.println("Register demo page is displayed");

	}

	
	



	
	
	
}
