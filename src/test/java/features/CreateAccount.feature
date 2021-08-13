Feature: Validate the creation of a new account
	Scenario: create a new account
		Given Initialize the browser with chrome
		And Navigate to "http://automationpractice.com/index.php"
		And Click on Sign in
		When the user typing his email "micoreo1231@correo.com.mx"
		Then click on create an account
		And fill the data
		And verify if the account will be creat successfully
