package runner;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

import java.security.Timestamp;
import java.sql.Date;
import java.sql.Time;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


@CucumberOptions(
		features = "src/test/resources/features/OpenAppliancePage.feature",
		glue = "stepdefinitions",
		plugin = {"pretty", "html:target/cucumber-reports.html"},
	    monochrome = true
		)

public class TestRunner extends AbstractTestNGCucumberTests{
	
	public static WebDriver driver;
	public static String getCurrentDateTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");
        return LocalDateTime.now().format(formatter);
    }
    
    private static ExtentSparkReporter  htmlReporter;
    private static ExtentReports  extent;
    private static ExtentTest test;
    
	@BeforeClass
	public static void chromeBrowserInitializtion() {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		ChromeOptions opt = new ChromeOptions();
		//opt.addArguments("--headless=new");
		//opt.addArguments("--disable-gpu");
		//opt.addArguments("--window-size=1920,1080");
	    driver = new ChromeDriver(opt);
	    //System.out.print("browser opened in headless mode");
	    driver.manage().window().maximize();
		
		
	}
	
    @AfterClass
    public void closeBrowser() throws InterruptedException {
    	Thread.sleep(10000);
    	driver.quit();
    	
    }
}
