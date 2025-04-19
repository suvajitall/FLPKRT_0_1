Feature: Login functionality 

	 Background:
		Given user is on login page
		
	Scenario: successful login with valid username and password -- Happy path scenario.
		
		When user enters valid email or contact
		And user clicks login button
		Then user should be redirected to home page
	
	
	#Scenario: error will come for invalid login credentials -- Negative scenario
		
		#When user enters invalid username and password
		#And user clicks login button
		#Then error comes for invalid credentials
	
