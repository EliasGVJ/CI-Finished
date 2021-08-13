package stepDefination;

import org.openqa.selenium.WebDriver;

import General.MyDriver;
import Pages.HomePage;
import Pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class stepDefinationShoppingProcess extends MyDriver {
	private HomePage homePage;
	private LoginPage loginPage;
	private WebDriver driver;
	private String url ="http://automationpractice.com/index.php";
	@Given("^the user is on the home page$")
	public void the_user_is_on_home_page() {
		driver = initializeDriver();
		driver.get(url);
		
	}
	@When("^the user select a product$")
	public void the_user_select_a_product() {
		homePage = new HomePage(driver);
		homePage.clickFirstProduct();
		
	}
	@And("^click on add to the cart$")
	public void click_on_add_to_the_cart() {
		homePage.clickAddToCart();
	}
	@Then("^begin with the shopping process cliking on the proceed to checkout button$")
	public void begin_with_the_shopping_process() {
		homePage.clickProceedConfirmationCart();
		
	}
	@And("^confirm the summary to continue$")
	public void confirm_the_summary_to_continue() {
		homePage.clickProceedSummaryButton();
	}
	@And("^Sign in with \"([^\"]*)\" and \"([^\"]*)\" to continue$")
	public void  sign_in_with_email_and_password_to_continue(String email,String pass) {
		loginPage = new LoginPage(driver);
		loginPage.putEmailAndPassword(email, pass);
		loginPage.clicOnSiginButton();
	}
	@And("^confirm his address to continue$")
	public void confirm_his_address_to_continues() {
		homePage.clickProceedAddressButton();
	}
	@And("^confirm the shipping to continue$")
	public void confirm_the_shipping_to_continue() {
		homePage.clickProceedShippingButton();
	}
	@Then("^select the method to pay$")
	public void select_the_method_to_pay() {
		homePage.methodToPay();
	}
	@And("^click on the I confirm my order button$")
	public void click_on_the_I_confirm_my_order_button() {
		homePage.clickConfirmMyOrder();
	}
	@And("^validate the order was successfully pay$")
	public void validate_the_order_was_successfully_pay() {
		homePage.confirmOrderValidation();
	}

}
