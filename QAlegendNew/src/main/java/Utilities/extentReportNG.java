package Utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class extentReportNG {
	
static ExtentReports extent;

public static ExtentReports getObjectReport()
{
	String path = System.getProperty("user.dir")+ "\\test-output\\Report.html";
	 ExtentSparkReporter reporter =new ExtentSparkReporter(path);//to customize teh report
	 reporter.config().setReportName("Web Automation Report");
	 reporter.config().setDocumentTitle("Test Result");
	 extent=new ExtentReports();
	 extent.attachReporter(reporter);
	 extent.setSystemInfo("Tester", "Athira");	
	 return extent;
}

}
