package selenium.TestComponents;

import java.io.IOException;
import java.security.cert.Extension;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import sivamani.Resorce.ExtentReportNG;

public class Listeners extends BaseTest implements ITestListener{

	ExtentTest test;
	ExtentReports extent= ExtentReportNG.getReportObjects();
	ThreadLocal<ExtentTest> extentTest=new ThreadLocal<ExtentTest>();
	private String filePath;
	@Override
	public void onTestStart(ITestResult result) {
     test=extent.createTest(result.getMethod().getMethodName());
     extentTest.set(test);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
     extentTest.get().log(Status.PASS, "Test Passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
    extentTest.get().fail(result.getThrowable());
    try {
    	driver=(WebDriver)result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
    }
    catch(Exception e)
    {
    	e.printStackTrace();
    }
    String filepath=null;
    try {
    filepath=getScreenshot(result.getMethod().getMethodName(), driver);
    }
    catch(IOException e1)
    {
    	e1.printStackTrace();
    }
    extentTest.get().addScreenCaptureFromPath(filePath, result.getMethod().getMethodName());
	}

	@Override
	public void onFinish(ITestContext context) {
        extent.flush();
	}

	
	
}
