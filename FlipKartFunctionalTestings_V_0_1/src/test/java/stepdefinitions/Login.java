package stepdefinitions;
import org.openqa.selenium.WebDriver;
import java.io.File;
import java.io.IOException;
import java.security.Timestamp;
import java.sql.Date;
import java.sql.Time;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;



import io.cucumber.java.en.*;
import pages.HomePage;
import pages.LoginPage;
import runner.TestRunner;

import org.codehaus.plexus.util.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
public class Login {
	WebDriver driver = TestRunner.driver;
	public static String getCurrentDateTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");
        return LocalDateTime.now().format(formatter);
    }
    @Given("user is on login page")
    public void user_on_login_page() throws IOException {
    	String timestamp = Login.getCurrentDateTime();
    	driver.get("https://www.flipkart.com/");
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    	TakesScreenshot src = (TakesScreenshot)driver;
    	File src_sht = src.getScreenshotAs(OutputType.FILE);
    	File dest_file = new File("screenshots/Login/"+timestamp+".png");
    	FileUtils.copyFile(src_sht, dest_file);
    	
    }
    @And("user clicks login button")
    public void user_clicks_login_button() {
     
    	 System.out.println("user clicks login button");
    }

    @When("user enters valid email or contact")
    public void user_enters_credentials() throws IOException {
    	String timestamp = Login.getCurrentDateTime();
    	LoginPage page = new LoginPage(driver);
    	page.click_login_icon();
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    	page.enter_email_phoneNumber("9038338072");
    	TakesScreenshot src = (TakesScreenshot)driver;
    	File src_sht = src.getScreenshotAs(OutputType.FILE);
    	File dest_file = new File("screenshots/Login/"+timestamp+".png");
    	FileUtils.copyFile(src_sht, dest_file);
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    	//page.verifyOtp();
    	//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    	//TakesScreenshot src1 = (TakesScreenshot)driver;
    	
    	
    }

    @Then("user should be redirected to home page")
    public void redirected_to_homepage() {
        String expectedUrl = "https://www.flipkart.com/account/login?ret=/";
        Assert.assertEquals(expectedUrl, driver.getCurrentUrl());
    }
    
    
   /* @When("user enters invalid username and password")
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
    }*/
    
    
    @When("user clicks on the appliance option in dashboard")
    public void user_clicks_on_the_appliance_option_in_dashboard() {
        // Write code here that turns the phrase above into concrete actions
    	HomePage page = new HomePage(driver);
    	page.click_appliance_option();
    }
    @When("user is redirected to appliance page")
    public void user_is_redirected_to_appliance_page() {
        // Write code here that turns the phrase above into concrete actions
        
    }
    @Then("user clicks the banner")
    public void user_clicks_the_banner() throws IOException {
        // Write code here that turns the phrase above into concrete actions
    	String timestamp = Login.getCurrentDateTime();
    	HomePage hmpg = new HomePage(driver);
    	hmpg.clickBanner();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
    	TakesScreenshot src = (TakesScreenshot)driver;
    	File src_sht = src.getScreenshotAs(OutputType.FILE);
    	File dest_file = new File("screenshots/Login/"+timestamp+".png");
    	FileUtils.copyFile(src_sht, dest_file);
    	
    }


    

}