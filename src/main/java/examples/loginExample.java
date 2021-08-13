package examples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class loginExample {

	public static void main(String[] arg) {
		System.setProperty("webdriver.chrome.chromeDriver", "C://work2//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://automationpractice.com/index.php");
		driver.findElement(By.cssSelector(".header_user_info a[title='Log in to your customer account']")).click();
		driver.findElement(By.cssSelector("#email_create")).sendKeys("algoas@algo.com");	
		driver.findElement(By.cssSelector("#SubmitCreate")).click();

	}
}
