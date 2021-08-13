package stepDefination;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.runner.RunWith;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import General.MyDriver;
import Pages.HomePage;
import Pages.LoginPage;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
public class stepDefinationCreateAccount extends MyDriver {
public WebDriver driver;
LoginPage loginPage;
HomePage homePage;

    @Given("^Initialize the browser with chrome$")
    public void initialize_the_browser_with_chrome() throws Throwable {
    	driver = initializeDriver();
    
    }
    

    @When("^the user typing his email \"([^\"]*)\"$")
    public void the_user_provide_his_email_something(String email) throws Throwable {
    	loginPage = new LoginPage(driver);
    	loginPage.putEmail(email);
    	
    }


    @And("^verify if the account will be creat successfully$")
    public void verify_if_the_account_will_be_creat_successfully() throws Throwable {
    	loginPage.validateSigInCorrectly();
    }

    @And("^Navigate to \"([^\"]*)\"$")
    public void navigate_to_something(String url) throws Throwable {
    	driver.get(url);
    }

    @And("^Click on Sign in$")
    public void click_on_sign_in() throws Throwable {
    	homePage = new HomePage(driver);
    	homePage.goToSignIn();
    }
    @And("^fill the data$")
    public void fill_the_data() throws Throwable {

    	loginPage.filledData();
    }


    @Then("^click on create an account$")
    public void click_on_create_an_account() throws Throwable {
    	loginPage.clickCreateAccount();
    }

    @After
    public void closeBrowser() throws InterruptedException {
    	Thread.sleep(3000L);
    	driver.close();
    }
    @AfterStep
	public void addScreenshot(Scenario scenario) throws IOException, InterruptedException {
    	if(scenario.isFailed()) {
		  getScreenShot(scenario);
    	}
		
	}
}
