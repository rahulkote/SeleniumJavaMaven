package tests;

import java.io.File;
import java.net.MalformedURLException;
import pages.Base;
import pages.HomePage;
import utils.ExtentReports.ExtentReports.ExtentTestManager;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;


import org.openqa.selenium.WebDriver;

public class TestHomePage extends BaseTest {
  
	private Base base;
	private HomePage home;
	
	
	
/*	@BeforeClass
	public void setup() throws MalformedURLException{
		driver.get("https://www.carwale.com/");
	}
	*/
	@BeforeMethod()
	public void setup_method() throws MalformedURLException{
		System.out.println("In before method driver value" +driver);
		home= new HomePage (driver);
	}
	
	@Test()
    public void sumFun() throws InterruptedException {
	int sum=2+2;
	Assert.assertEquals(4,sum);
    }
	
	@Test()
    public void searchCarOnPage() throws InterruptedException {
		home.searchCar("dezire");
		ExtentTestManager.getTest().log(LogStatus.INFO, "Searched the car on home page");
		Assert.assertEquals(1,2);
		ExtentTestManager.getTest().log(LogStatus.INFO, "Assertion completed");
    }

	
	@AfterMethod()
	public void tearDown_method() throws MalformedURLException{


	}
	
}