package pages;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;

import tests.BaseTest;


public class Base extends BaseTest{

	protected WebDriver driver;
	Dimension size;
	private Page page;
	
	public Base(WebDriver driver) {
		this.driver = driver;
	}
	
	public void getTitle(){
		System.out.print("Title is displayed");
	}
	   
	
	
}
