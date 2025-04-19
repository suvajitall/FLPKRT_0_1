package runner;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = "src/test/resources/features",
		glue = "stepdefinitions",
		plugin = {"pretty", "html:target/cucumber-reports.html"},
	    monochrome = true
		)

public class TestRunner extends AbstractTestNGCucumberTests{
	
	public static WebDriver driver;
	
	@BeforeClass
	public static void chromeBrowserInitializtion() {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		ChromeOptions opt = new ChromeOptions();
		//opt.addArguments("--headless=new");
		//opt.addArguments("--disable-gpu");
		//opt.addArguments("--window-size=1920,1080");
	    driver = new ChromeDriver(opt);
	    System.out.print("browser opened in headless mode");
		
		
	}
    @AfterClass
    public void closeBrowser() throws InterruptedException {
    	Thread.sleep(10000);
    	driver.quit();
    }
}
