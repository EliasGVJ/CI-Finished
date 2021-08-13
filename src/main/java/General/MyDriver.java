package General;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.Scenario;

public class MyDriver {

	private WebDriver driver;

	public WebDriver initializeDriver() {
		System.setProperty("webdriver.chrome.chromeDriver", "C://work2//chromedriver.exe");
		driver = new ChromeDriver();
		return driver;
	}
	public void getScreenShot(Scenario scenario) throws IOException, InterruptedException {
		Thread.sleep(2000L);
		 File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		  byte[] fileContent = FileUtils.readFileToByteArray(screenshot);
		  scenario.attach(fileContent, "image/png", scenario.getName());
	}
	public static String getMethodName() {

	    // Verficamos que exista
	    if (Thread.currentThread().getStackTrace().length>2) {
	        return "Step: "+Thread.currentThread().getStackTrace()[2].getMethodName();
	    } else {
	        return "undefined";
	    }
	}
	public void closeBrowser(WebDriver driver) throws InterruptedException {
    	Thread.sleep(8000L);
    	driver.close();
	}
}
