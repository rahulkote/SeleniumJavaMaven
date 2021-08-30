package pages;

import tests.BaseTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class Page extends BaseTest {
	private Base base;
	
	public Page(WebDriver driver) {
		this.driver=driver;
		base = new Base(driver);
	
	}
	
	public WebElement waitTillElementVisible(String locator){
		WebDriverWait wait = new WebDriverWait(driver, 10); 
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
		return element;
	}
	
	public void waitTillElmentInvisble(String id){
		WebDriverWait wait = new WebDriverWait(driver, 10); 
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id(id)));
	}
	
	public boolean isElementDisplayed(String locator){
		return driver.findElement(By.xpath(locator)).isDisplayed();
	}
	
  
	
}
