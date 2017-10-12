package pageFactory;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class pf_HomePage extends CommonActions{
	
	@FindBy(linkText="Sign In")
	public WebElement lk_signIN;
	
	@FindBy(id="username")
	public WebElement lk_username;
	
	@FindBy(id="srchword")
	public WebElement txt_searchOption;
	
	@FindBy(className="newsrchbtn")
	public WebElement btn_bookSearch;
	
	@FindBy(className="sorrymsg")
	public WebElement lbl_invalidSearchMsg;
	
	@FindBy(id="find")
	public WebElement lbl_searchCount;
	
	@FindBy(xpath="//div[@id='myDataDiv']//div[@class='bookbox'][1]//img")
	public WebElement img_firstBook;
	
	
	public pf_HomePage(WebDriver driver){
		PageFactory.initElements(driver, this);	
		
	}
		
	
	public void enterSearch(Map<String,String> hm){
		
		eleEnterValue(txt_searchOption, hm.get("Search_option"));
		eleClick(btn_bookSearch);	
		
	}
	
	

}







