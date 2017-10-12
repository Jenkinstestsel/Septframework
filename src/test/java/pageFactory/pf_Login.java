package pageFactory;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class pf_Login extends CommonActions{
	
	
	@FindBy(name="logid")
	public WebElement txt_username;
	
	@FindBy(name="pswd")
	public WebElement txt_pwd;
	
	@FindBy(xpath="//input[@value='Login']")
	public WebElement btn_login;
	
	@FindBy(xpath="//b[contains(text(),'Sorry')]")
	public WebElement msg_errorMsg;
	
	
	public pf_Login(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	
	public void enterUserDetails(Map<String,String> hm){
		eleEnterValue(txt_username, hm.get("username"));
		eleEnterValue(txt_pwd, hm.get("pwd"));
		
		eleClick(btn_login);		
	}
	
	
	

}






