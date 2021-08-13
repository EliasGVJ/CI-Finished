package Pages;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class HomePage {

	private String url ="http://automationpractice.com/index.php";
	private String textConfimation = "Your order on My Store is complete.";
	private WebDriver driver;
	
	private By signIn =  By.cssSelector(".header_user_info a[title='Log in to your customer account']");
	private By firstProduct = By.cssSelector("ul#homefeatured li:nth-child(1)");
	private By addToCartButton = By.cssSelector("p#add_to_cart button");
	private By proceedConfirmation = By.cssSelector("div#layer_cart div.button-container a[title='Proceed to checkout']");
	private By proceedSummaryButton = By.cssSelector("div#center_column p[class*='cart_navigation clearfix'] a[title*='Proceed to checkout']");
	private By proceedAddressButton = By.cssSelector("div#center_column p[class*='cart_navigation'] button[name='processAddress']");
	private By termsServiceCheck = By.id("cgv");
	private By proceedShippingButton = By.cssSelector("p[class*='cart_navigation'] button");
	private By paymentMethodBankWire = By.cssSelector("a.bankwire");
	private By confirmOrderButton = By.cssSelector("p#cart_navigation button");
	private By textConfirmationTag = By.cssSelector("div.box p.cheque-indent strong");
	
//	private By email = By.id("user_email");
//	By pass = By.cssSelector("input[type='password']");
//	By button = By.cssSelector("input[name='commit']");
//	By forgotPass = By.cssSelector("[href*='password/new']");
	
	public HomePage(WebDriver driver){
		this.driver = driver;
		this.driver.get(url);
	}
	public void goToSignIn() {
		driver.findElement(signIn).click();
	}
	public void clickFirstProduct() {
		driver.findElement(firstProduct).click();
	}
	public void clickAddToCart() {
		driver.findElement(addToCartButton).click();
	}
	public void clickProceedConfirmationCart() {
		WebDriverWait wait = new WebDriverWait(driver,10000);///se pasa sel driver y los segundos maximos a esperar
		wait.until(ExpectedConditions.visibilityOfElementLocated(proceedConfirmation));// espera hasta que se avisible el boton de codigo
		driver.findElement(proceedConfirmation).click();;
	}
	public void clickProceedSummaryButton() {
		driver.findElement(proceedSummaryButton).click();
	}
	public void clickProceedAddressButton() {
		driver.findElement(proceedAddressButton).click();
	}
	public void clickProceedShippingButton() {
		driver.findElement(termsServiceCheck).click();
		driver.findElement(proceedShippingButton).click();
	}
	public void methodToPay() {
		driver.findElement(paymentMethodBankWire).click();
	}
	public void clickConfirmMyOrder() {
		driver.findElement(confirmOrderButton).click();

	}
	public void confirmOrderValidation() {
		Assert.assertEquals(textConfimation, driver.findElement(textConfirmationTag).getText());		
	}
}
