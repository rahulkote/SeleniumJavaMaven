package tests;

import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;

public class BaseTest {
	protected WebDriver driver;
	public ExtentReports extent;
	protected ExtentTest logger;

    public WebDriver getDriver() {
            return driver;
}

	  
  @BeforeSuite
  public void setUpClass() {
	  System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\lib\\chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.get("https://www.carwale.com/");
  }
  


  @AfterSuite
  public void tearDownClass() {
	  driver.quit();
	  
  }
  
  

}
