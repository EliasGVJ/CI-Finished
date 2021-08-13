package stepDefination;

import org.openqa.selenium.WebDriver;

import General.MyDriver;
import Pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class stepDefnationSignOut extends MyDriver {
	private WebDriver driver;
	private LoginPage loginPage;

	@Given("^The user put his \"([^\"]*)\" and \"([^\"]*)\" to Sign in$")
	public void the_user_put_his_email_and_password_to_sign_in(String email,String password) {
		driver = initializeDriver();
    	driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
		loginPage = new LoginPage(driver);
		loginPage.putEmailAndPassword(email, password);
		
	}
	@And("^click on sign in button$")
	public void click_on_sign_in_button() {
		loginPage.clicOnSiginButton();
	}
	@When("^the user click on the Sign out button$")
	public void the_user_click_on_the_sign_out_button() {
		loginPage.clickOnSignOutButton();
	}
	@Then("^Validate if the session was closed correctly$")
	public void validate_if_the_session_was_closed_correctly() {
		loginPage.validateSignOut();
	}


	
}
