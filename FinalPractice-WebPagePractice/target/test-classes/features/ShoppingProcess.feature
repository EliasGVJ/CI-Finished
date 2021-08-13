Feature: follow the shopping process
	Scenario: validate the shopping process till the end
		Given the user is on the home page
		When the user select a product
		And click on add to the cart
		Then begin with the shopping process cliking on the proceed to checkout button
		And confirm the summary to continue
		And Sign in with "eliasCorreo@correo2.com" and "password" to continue
		And confirm his address to continue
		And confirm the shipping to continue
		Then select the method to pay
		And click on the I confirm my order button
		And validate the order was successfully pay
		