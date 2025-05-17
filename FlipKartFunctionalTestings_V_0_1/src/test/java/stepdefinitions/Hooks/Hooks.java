package stepdefinitions.Hooks;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
//import com.aventstack.extentreports.gherkin.model.Scenario;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import io.cucumber.plugin.event.Status;

public class Hooks {
	
	public static String getCurrentDateTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");
        return LocalDateTime.now().format(formatter);
    }
    
    private static ExtentSparkReporter  htmlReporter;
    private static ExtentReports  extent;
    private static ExtentTest test;
    public static ExtentTest scenarioTest;
    public static ThreadLocal<ExtentTest> testThread = new ThreadLocal<>();
		@BeforeAll
		public static void setup_report() {
			String timestamp = getCurrentDateTime();
			htmlReporter = new ExtentSparkReporter ("Reports/reports_"+timestamp+".html");
		    extent  = new ExtentReports ();
		    extent.attachReporter(htmlReporter);
		}
		
		@Before
		public static void create_report(Scenario scenario) {
			
			 scenarioTest = extent.createTest(scenario.getName());
		        testThread.set(scenarioTest);
	    		
	    }
		
		@After
		public static void test_logs(Scenario scenario) {
			if(scenario.getStatus().name().equalsIgnoreCase("FAILED")) {
				testThread.get().fail("Scenario failed");
			}
			else {
				
				 testThread.get().pass("Scenario passed");
			}	
		}
		
		@AfterAll
		public static void generate_report() {
			extent.flush();
		}
		
		public static ExtentTest getTest() {
	        return testThread.get();
	    }
}
