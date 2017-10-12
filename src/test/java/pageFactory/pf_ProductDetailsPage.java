package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class pf_ProductDetailsPage {
	
	
	@FindBy(className="buynowbtnbig")
	public WebElement btn_BuyNow;
	
	
	public pf_ProductDetailsPage(WebDriver driver){
		
		PageFactory.initElements(driver, this);
	}
	
		

}
