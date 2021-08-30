package pages;


import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import tests.BaseTest;



public class HomePage extends BaseTest {

	private Base base;
	private Page page;
	
	/*locators*/
	private String searchTextID = "newCarsList";
	private String firstSuggestId = "//ul[@class='ui-autocomplete ui-front ui-menu ui-widget ui-widget-content']/li";

	public HomePage(WebDriver driver) throws MalformedURLException{
		this.driver=driver;
		page = new Page(driver);
	}
 
	public void searchCar(String carname) {
	System.out.println("before search car driver value"+driver);
	driver.findElement(By.id(searchTextID)).sendKeys(carname);
	page.waitTillElementVisible(firstSuggestId);
	driver.findElement(By.xpath(firstSuggestId)).click();
	//driver.findElement(By.id("btnFindCarNew")).click();
	System.out.println("after search car");
	}
}
