package General;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyDriver {

	private WebDriver driver;

	public WebDriver initializeDriver() {
		System.setProperty("webdriver.chrome.chromeDriver", "C://work2//chromedriver.exe");
		driver = new ChromeDriver();
		return driver;
	}
}
