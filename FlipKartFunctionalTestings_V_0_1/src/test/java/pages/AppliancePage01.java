package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AppliancePage01 {
	
		WebDriver driver;
		
		public AppliancePage01(WebDriver driver) {
			PageFactory.initElements(driver,this);
		}
		
		@FindBy(xpath="//div[4]//div[1]//a[1]//div[1]//img[2]")
		WebElement banner;
		public void click_product_banner() {
			banner.click();
		}
		
		@FindBy(xpath="//section[2]/div[4]/div[3]/select")
		WebElement select_price;
		public void select_price(int index) {
			Select price_dropDown = new Select(select_price);
			price_dropDown.selectByIndex(index);
			
		}
		
		/*@FindBy(xpath="//div[@data-id]")
		List<WebElement> products;
		
		public void check_product_price() {
			for(int i=0;i<4;i++) {
				
			}
		}*/
}
