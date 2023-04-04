package testClasses;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import testUtility.BrowserWait;
import testUtility.CaptureScreenshot;
import testUtility.StaticBrowser;

public class BaseClass {

	static WebDriver driver;
	static ExtentReports report;
	static ExtentHtmlReporter extent;
	static ExtentTest logger;
	
	@Parameters ({"browser"})
	
	@BeforeTest
	public  void beforeTest(String browser) {
		report = new ExtentReports();
		extent = new ExtentHtmlReporter("test-output"+File.separator+"Reports"+File.separator+"Amazon"+System.currentTimeMillis()+".html");
		report.attachReporter(extent);
		
		WebDriver driver = StaticBrowser.openBrowser(browser, "https://www.amazon.com/");
		this.driver=driver;
		BrowserWait.waitForBrowserToLoad(10, driver);
	}
	
	@AfterMethod
	public void afterMethod(ITestResult result) throws InterruptedException, IOException {
		Thread.sleep(1000);
		
		if(result.getStatus()==ITestResult.FAILURE) {
			String path = CaptureScreenshot.captureWebPageScrreenshot(driver);
			logger.fail("Test case failed", MediaEntityBuilder.createScreenCaptureFromPath(path).build());
		}	
		logger.pass("Test case passed");
		report.flush();
	}
	
	@AfterTest
	public void afterTest() {
		driver.quit();
	}
}
