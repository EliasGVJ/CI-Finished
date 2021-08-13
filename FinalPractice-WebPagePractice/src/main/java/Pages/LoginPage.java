package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Assert;

import com.github.javafaker.Faker;



public class LoginPage {

	
	Faker fake = new Faker();
	private WebDriver driver;
	private By email = By.cssSelector("#email_create");
	private By createAccount = By.cssSelector("#SubmitCreate");
	private By title = By.cssSelector("#id_gender1");
	private By inputFName = By.id("customer_firstname");
	private By inputFName2 = By.id("firstname");
	private By inputLName = By.id("customer_lastname");
	private By inputLName2 = By.id("lastname");
	private By inputPass = By.id("passwd");
	private By inputDays = By.id("days");
	private By inputMonths = By.id("months");
	private By inputYears = By.id("years");
	private By inputNewsletter =  By.id("newsletter");
	private By inputSpecialOffers = By.id("uniform-optin");
	private By inputCompany = By.id("company");
	private By inputAddress1 = By.id("address1");
	private By inputAddress2 = By.id("address2");
	private By inputCity = By.id("city");
	private By inputState = By.id("id_state");
	private By inputZipCode = By.id("postcode");
	private By inputCountry = By.id("id_country");
	private By inputAdditionalInfo = By.id("other");
	private By inputHomePhone = By.id("phone");
	private By inputMobilePhone = By.id("phone_mobile");
	private By inputAddressAlias = By.id("alias");
	private By buttonRegister = By.id("submitAccount");
	private By buttonLogout = By.cssSelector("div[class='header_user_info'] a[class='logout']");
	private By inputAccountName = By.cssSelector("div[class='header_user_info'] a[class='account'] span");
	private By inputLoginEmail = By.id("email");
	private By inputLoginPassword = By.id("passwd");
	private By buttonSigin = By.id("SubmitLogin");
	
	
	private String fName = fake.name().firstName().toString();
	private String lName = fake.name().lastName().toString();
	private String mail;
	private String password = "password";
	private String company = fake.company().toString();
	private String address = fake.address().fullAddress().toString();
	private String address2 = fake.address().buildingNumber();
	private String city = fake.address().cityName().toString();
	private String zip = (fake.address().zipCode().split("-"))[0];
	private String additionalInfo = "Is on the corner";
	private String homePhone = (fake.phoneNumber().phoneNumber().split(" "))[0];
	private String mobilePhone = fake.phoneNumber().cellPhone();
	private String addressAlias =fake.funnyName().name().toString();

	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
	}
	public void putEmail(String emailAddress) {
		driver.findElement(email).sendKeys(emailAddress);	
		mail=emailAddress;
	}
	public void clickCreateAccount() {
		driver.findElement(createAccount).click();		
	}
	public void verifyLogout(){
		WebDriverWait wait = new WebDriverWait(driver,10000);///se pasa sel driver y los segundos maximos a esperar
		wait.until(ExpectedConditions.visibilityOfElementLocated(buttonLogout));// espera hasta que se avisible el boton de codigo

		Assert.assertTrue(driver.findElement(buttonLogout).isDisplayed()); 
	}
	public void clickOnSignOutButton() {
		verifyLogout();
		driver.findElement(buttonLogout).click();
	}
	public void validateSignOut() {
		Assert.assertTrue(driver.findElement(buttonSigin).isDisplayed());
		
	}
	public void filledData() {
		WebDriverWait wait = new WebDriverWait(driver,10000);///se pasa sel driver y los segundos maximos a esperar
		WebElement dropDown;
		wait.until(ExpectedConditions.visibilityOfElementLocated(title));// espera hasta que se avisible el boton de codigo
		driver.findElement(title).click();    	
		driver.findElement(inputFName).sendKeys(fName);
		driver.findElement(inputLName).sendKeys(lName);
		driver.findElement(inputPass).sendKeys(password);
		dropDown= driver.findElement(inputDays);
		Select optionsDays = new Select(dropDown);
		optionsDays.selectByValue("26");;
		dropDown= driver.findElement(inputMonths);
		Select optionsMonth = new Select(dropDown);
		optionsMonth.selectByIndex(7);;
		dropDown= driver.findElement(inputYears);
		Select optionsYear = new Select(dropDown);
		optionsYear.selectByValue("2000");
		driver.findElement(inputNewsletter).click();
		driver.findElement(inputSpecialOffers).click();
		
		driver.findElement(inputFName2).sendKeys(fName);
		driver.findElement(inputLName2).sendKeys(lName);
		driver.findElement(inputCompany).sendKeys(company);
		driver.findElement(inputAddress1).sendKeys(address);
		driver.findElement(inputAddress2).sendKeys(address2);
		driver.findElement(inputCity).sendKeys(city);
		dropDown= driver.findElement(inputState);
		Select optionsState = new Select(dropDown);
		optionsState.selectByIndex(8);;
		driver.findElement(inputZipCode).sendKeys(zip);
		dropDown = driver.findElement(inputCountry);
		Select optionsCountry = new Select(dropDown);
		optionsCountry.selectByIndex(1);
		driver.findElement(inputAdditionalInfo).sendKeys(additionalInfo);
		driver.findElement(inputHomePhone).sendKeys(homePhone);
		driver.findElement(inputMobilePhone).sendKeys(mobilePhone);
		driver.findElement(inputAddressAlias).sendKeys(addressAlias);
		driver.findElement(buttonRegister).click();
		System.out.println("Phone number: "+mobilePhone);
		System.out.println("Home Number: "+homePhone);
	
	}
	
	public void validateSigInCorrectly() {
		Assert.assertTrue(driver.findElement(inputAccountName).isDisplayed());
		Assert.assertEquals(fName+lName ,driver.findElement(inputAccountName).getText().replace(" ", ""));
	}
	public void putEmailAndPassword(String email, String pass) {
		driver.findElement(inputLoginEmail).sendKeys(email);
		driver.findElement(inputLoginPassword).sendKeys(pass);
	}
	public void clicOnSiginButton() {
		driver.findElement(buttonSigin).click();
	}
}
