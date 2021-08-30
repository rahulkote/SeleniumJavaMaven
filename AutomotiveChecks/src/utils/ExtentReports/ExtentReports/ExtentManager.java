package utils.ExtentReports.ExtentReports;
 
import java.io.File;

import com.relevantcodes.extentreports.ExtentReports;
 
//OB: ExtentReports extent instance created here. That instance can be reachable by getReporter() method.
 
public class ExtentManager {
 
    private static ExtentReports extent;
 
    public synchronized static ExtentReports getReporter(){
        if(extent == null){
            extent = new ExtentReports (System.getProperty("user.dir") +"/test-output/CarwaleReport.html", true);
            extent.loadConfig(new File(System.getProperty("user.dir")+"/src/extent-config.xml"));
        }
        return extent;
    }
}