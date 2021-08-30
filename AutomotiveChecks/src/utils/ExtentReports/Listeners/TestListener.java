package utils.ExtentReports.Listeners;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utils.*;
import utils.ExtentReports.ExtentReports.ExtentManager;
import utils.ExtentReports.ExtentReports.ExtentTestManager;
import pages.Page;
import tests.BaseTest;

public class TestListener extends BaseTest implements ITestListener {
	
	public String destination;
	
    public void onTestStart(ITestResult result) {
    	System.out.println("I am in onTestStart method " +  result.getName() + " start");
           //Start operation for extentreports.
        ExtentTestManager.startTest( result.getName()," test started");
    }
	
    public void onTestFailure(ITestResult result) {
    	System.out.println("Logger is "+ExtentTestManager.getTest());
    	System.out.println("***** Error "+result.getName()+" test has failed *****");
    	String methodName=result.getName().toString().trim();
    	Object currentClass = result.getInstance();
        WebDriver driver = ((BaseTest) currentClass).getDriver();
        ExtentTestManager.getTest().log(LogStatus.FAIL, "Test case failed"+result.getThrowable());
    	takeScreenShot(methodName,driver);
    }
    
    public void takeScreenShot(String methodName, WebDriver driver) {
       	
    	final String filePath = System.getProperty("user.dir")+"\\ErrorScreenshot"; 
    	
    	System.out.println(filePath);
    	File errorDirectory = new File(filePath);
    	
    	 if (! errorDirectory.exists()){
    		 errorDirectory.mkdir();
    	        // If you require it to make the entire directory path including parents,
    	        // use directory.mkdirs(); here instead.
    	        System.out.println("Error Directory created");

    	    }
    	 String currentDateTime =  new SimpleDateFormat("yyyy-MM-dd hh_mm_ss").format(new Date());
    	 File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    	 destination = errorDirectory+"\\"+methodName+" "+currentDateTime+".png";
         //The below method will save the screen shot in d drive with test method name 
            try {
            	FileUtils.copyFile(scrFile, new File(destination));
				System.out.println("***Placed screen shot in "+errorDirectory+" ***");
			} catch (IOException e) {
				e.printStackTrace();
			}
            ExtentTestManager.getTest().log(LogStatus.FAIL,  ExtentTestManager.getTest().addScreenCapture(destination));
    }
    
    public String getImageDestination() {
		return destination ;
    }
    
 
	public void onFinish(ITestContext context) {
		ExtentTestManager.endTest();
        ExtentManager.getReporter().flush();
	}
 
  
    public void onTestSuccess(ITestResult result) {
    	ExtentTestManager.getTest().log(LogStatus.PASS, result.getName()+" test passed");
    }

    public void onTestSkipped(ITestResult result) { 
    	ExtentTestManager.getTest().log(LogStatus.SKIP, result.getName()+" test skipped");
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {   }

    public void onStart(ITestContext context) {   }
}  


