package stepdefinitions;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.codehaus.plexus.util.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AppliancePage01;
import runner.TestRunner;
import stepdefinitions.Hooks.Hooks;

public class Application_Filter {
	
	WebDriver driver = TestRunner.driver;

	@Given("use is on the application page")
	public void use_is_on_the_application_page() {
	  String url = driver.getCurrentUrl();
	  Hooks.getTest().info("url is opened");	  //boolean current_url = String.contains(url);
	   //Assert.assertEquals(curr_url, expected_fixed_url);
	}
	@When("user clicks the min_max dropdown as min")
	public void user_clicks_the_min_max_dropdown_as_min() {
	    System.out.println("test");
	    
	}
	@When("user clicks the price dropdown as {int}")
	public void user_clicks_the_price_dropdown_as(Integer int1) throws InterruptedException {
		
		AppliancePage01 selectPrice = new AppliancePage01(driver);
		selectPrice.select_price(int1);
		Thread.sleep(10000);
		
		Hooks.getTest().info("user clicks the price dropdown");
	}
	@Then("products under range should come")
	public void products_under_range_should_come() throws IOException {
		String timestamp = Login.getCurrentDateTime();
		TakesScreenshot src = (TakesScreenshot)driver;
    	File src_sht = src.getScreenshotAs(OutputType.FILE);
    	File dest_file = new File("screenshots/products/"+timestamp+".png");
    	FileUtils.copyFile(src_sht, dest_file);
    	Hooks.getTest().info("products under range should come");
	}
	@Then("take screenshot")
	public void take_screenshot() {
		System.out.println("test");
	}


	
}
