package pages;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.codehaus.plexus.util.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import stepdefinitions.Login;

public class HomePage {
	
	WebDriver driver;
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[contains(text(),'Appliances')]")
	WebElement appliance_menu_option;
	
	public void click_appliance_option() {
		appliance_menu_option.click();
	}
	
	@FindBy(xpath="//*[@id=\"container\"]/div/div[3]/div[2]/div/div[1]/div[4]")
	WebElement banner;
	
	public void clickBanner() throws IOException {
		banner.click();
		
		
	}
	
}
