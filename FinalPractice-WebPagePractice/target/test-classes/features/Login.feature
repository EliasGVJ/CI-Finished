Feature: Login with an account		
	Scenario: Login with a valid account
		Given the user is on the login page
		When the user provide "eliasCorreo@correo2.com" and "password"
		Then click on the button sign in
		And validate if the login was successful