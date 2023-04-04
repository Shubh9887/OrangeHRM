package testUtility;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class CaptureScreenshot {
	public static String captureWebPageScrreenshot(WebDriver driver) throws IOException {
		String currentDirectory = System.getProperty("user.dir");
		
		String path = currentDirectory+File.separator+"test-output"+File.separator+"Screenshots"+File.separator+"Amazon"+File.separator+System.currentTimeMillis()+".png" ;
		
		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File destination = new File (path);
		FileHandler.copy(source, destination);
		
		return path;
	}

}

