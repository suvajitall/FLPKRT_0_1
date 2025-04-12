Feature: Login functionality 

	Scenario: successful login with valid username and password -- Happy path scenario.
		Given user is on login page
		When user enters valid username and password
		And user clicks login button
		Then the user should be redirected to home page.
	
	
	Scenario: error will come for invalid login credentials -- Negative scenario
		Given user is on login page
		When user enters invalid username and password
		And user clicks login button
		Then error comes for invalid credentials
	
