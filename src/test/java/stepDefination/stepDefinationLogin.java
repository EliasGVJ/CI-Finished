package stepDefination;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import General.MyDriver;
import Pages.HomePage;
import Pages.LoginPage;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class stepDefinationLogin extends MyDriver {
	public WebDriver driver;
	LoginPage loginPage;
	HomePage homePage;
	

	@Given("^the user is on the login page$")
    public void the_user_is_in_the_login_page(){
		System.out.println("---\tInitialize Login test\t\t\t---");
    	System.out.println(getMethodName());
    	driver = initializeDriver();
    	driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
    }
    @When("^the user provide \"([^\"]*)\" and \"([^\"]*)\"$")
    public void the_user_provide_correo_and_password(String correo, String password){
    	System.out.println(getMethodName());
    	loginPage = new LoginPage(driver);
    	loginPage.putEmailAndPassword(correo, password);
    }
    @Then("^click on the button sign in$")
    public void click_on_the_button_sign_in() {
    	System.out.println(getMethodName());
    	loginPage.clicOnSiginButton();
    }
    @And("^validate if the login was successful$")
    public void validate_if_the_login_was_successful() {
    	System.out.println(getMethodName());

    	loginPage.verifyLogout();
    }
    @AfterStep
	public void addScreenshot(Scenario scenario) throws IOException, InterruptedException {
    	if(scenario.isFailed()) {
        	System.out.println("--FAILURE-- "+getMethodName());
		  getScreenShot(scenario);
    	}

	}

}
