Feature: Sign off from the session
	Scenario: validate sign off from an active session account 
		Given The user put his "eliasCorreo@correo2.com" and "password" to Sign in
		And click on sign in button
		When the user click on the Sign out button
		Then Validate if the session was closed correctly