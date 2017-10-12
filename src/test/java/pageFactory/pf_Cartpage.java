package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class pf_Cartpage {
	
	
	@FindBy(xpath="//li[@class='last']/cite[@class='mid']/span[2]")
	public WebElement lbl_book;
	
	@FindBy(id="frmCart")
	public WebElement frm_cart;
	
	public pf_Cartpage(WebDriver driver){
		
		PageFactory.initElements(driver, this);
	}
	
		

}
