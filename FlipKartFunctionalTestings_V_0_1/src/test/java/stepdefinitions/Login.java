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

    @Then("user should be redirected to homepage")
    public void redirected_to_homepage() {
        System.out.println("User landed on homepage");
    }
}