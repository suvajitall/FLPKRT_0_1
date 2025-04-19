package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	public LoginPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//span[text()='Login']")
	WebElement loginButton;
	
	public void click_login_icon() {
		loginButton.click();
	}
	
	@FindBy(xpath="//form[@autocomplete='on']/div/input[@type='text']")
	WebElement emailPhoneNumberIput;
	
	@FindBy(xpath="//form[@autocomplete='on']/div/button")
	WebElement otpButton;
	
	public void enter_email_phoneNumber(String email_phoneNumber) {
		emailPhoneNumberIput.sendKeys(email_phoneNumber);
		//otpButton.click();
		
	}
	
	@FindBy(xpath="//button[contains(text(),'Verify')]")
	WebElement verifyButton;
	
	public void verifyOtp() {
		verifyButton.click();
	}
	

}
