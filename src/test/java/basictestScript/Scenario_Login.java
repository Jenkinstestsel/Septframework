package basictestScript;

import java.util.Map;

import generics.Base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import pageFactory.pf_HomePage;
import pageFactory.pf_Login;

public class Scenario_Login extends Base {
	
	@Test(dataProvider="invalidlogin",dataProviderClass=dataProvider.Dp_dataProvider.class)
	public void inValidLogin(Map<String,String> hm){
//		intitalie page factory
		pf_Login lg = new pf_Login(driver);
		pf_HomePage hp = new pf_HomePage(driver);
//	------*********************------------	
//		hp.lk_signIN.click();  one way of writing
		
		eleClick(hp.lk_signIN);
		
//		driver.findElement(By.linkText("Sign In")).click();
//-------**********************------------
//		---------************
//		enter user credentials
//		driver.findElement(By.name("logid")).sendKeys(hm.get("username"));
//		driver.findElement(By.name("pswd")).sendKeys(hm.get("pwd"));
		eleEnterValue(lg.txt_username,hm.get("username"));
		eleEnterValue(lg.txt_pwd,hm.get("pwd"));
		
//		---------***************
//		click on login
//		driver.findElement(By.xpath("//input[@value='Login']")).click();
		eleClick(lg.btn_login);
		
		
//		String act_msg = driver.findElement(By.xpath("//b[contains(text(),'Sorry')]")).getText();
		String act_msg = eleGetText(lg.msg_errorMsg);
		String exp_msg=hm.get("exp_msg");
		
		
//		validation
		if(act_msg.equals(exp_msg)){
			System.out.println("pass");
		}else{
			System.out.println("fail");
		}
					
	}
		
	@Test(dataProvider="validlogin",dataProviderClass=dataProvider.Dp_dataProvider.class)
	public void validLogin(Map<String,String> hm){

		pf_Login lg = new pf_Login(driver);
		pf_HomePage hp = new pf_HomePage(driver);
		
//		------*********************------------	
//		hp.lk_signIN.click();  one way of writing
		
		eleClick(hp.lk_signIN);
		
//		driver.findElement(By.linkText("Sign In")).click();
//-------**********************------------
//		---------************
//		enter user credentials
//		driver.findElement(By.name("logid")).sendKeys(hm.get("username"));
//		driver.findElement(By.name("pswd")).sendKeys(hm.get("pwd"));
		eleEnterValue(lg.txt_username,hm.get("username"));
		eleEnterValue(lg.txt_pwd,hm.get("pwd"));
		
//		---------***************
//		click on login
//		driver.findElement(By.xpath("//input[@value='Login']")).click();
		eleClick(lg.btn_login);
		
		String act_user = eleGetText(hp.lk_username);
		String exp_user=hm.get("exp_msg");
		
//		validation
		if(act_user.equals(exp_user)){
			System.out.println("pass");
		}else{
			System.out.println("fail");
		}
		
	
		
		
		
	}
	
		

}
