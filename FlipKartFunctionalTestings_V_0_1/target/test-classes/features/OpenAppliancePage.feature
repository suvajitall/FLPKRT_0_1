Feature: Opening the applicance page

	Scenario: Click the appliance option and then banner of appliance page
		
		Given user is on login page
		When user clicks on the appliance option in dashboard
		And user is redirected to appliance page
		Then user clicks the banner
		
		
	Scenario: Filter functionalities -- price
	
		Given use is on the application page
		When user clicks the min_max dropdown as min
		When user clicks the price dropdown as 2
		Then products under range should come
		And take screenshot
		
	