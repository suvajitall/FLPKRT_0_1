package stepdefinitions;

import io.cucumber.java.en.*;

public class Login {

    @Given("user is on login page")
    public void user_on_login_page() {
        System.out.println("Navigating to login page");
    }

    @When("user enters valid username and password")
    public void user_enters_credentials() {
        System.out.println("Entering username and password");
    }

    @Then("user should be redirected to home page")
    public void redirected_to_homepage() {
        System.out.println("User landed on homepage");
    }
    
    
    @When("user enters invalid username and password")
    public void user_enters_invalid_username_and_password() {
       
    	 System.out.println("user enters invalid username and password");
    }
    @And("user clicks login button")
    public void user_clicks_login_button() {
     
    	 System.out.println("user clicks login button");
    }
    @Then("error comes for invalid credentials")
    public void error_comes_for_invalid_credentials() {
        
    	 System.out.println("error comes for invalid credentials");
    }
}