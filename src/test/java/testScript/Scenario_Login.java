package testScript;

import java.util.Map;

import generics.Base;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import pageFactory.pf_HomePage;
import pageFactory.pf_Login;

public class Scenario_Login extends Base {
	
	@Test(dataProvider="commondp",dataProviderClass=dataProvider.Dp_dataProvider.class,groups={"uat","qa","prod"})
	public void Login_inValidLogin(Map<String,String> hm) throws Exception{
		sTest = eReports.startTest(hm.get("TC_ID") + "_" + hm.get("order"));
		sTest.assignCategory("Login" + "_" + browsertype);
		sTest.log(LogStatus.INFO, "Scenario to test the invalid login","Start execution of Test case " + hm.get("TC_ID"));
		
		if(driver.getTitle().contains("Book")){
			sTest.log(LogStatus.PASS, "Home Page Validation","Passed as successfully launched home page" + sTest.addScreenCapture(sceenshot()));
		}else{
			sTest.log(LogStatus.FAIL, "Home Page Validation","Failes as expected was Rediff" + "and actual is " + driver.getTitle() + sTest.addScreenCapture(sceenshot()));
			Assert.fail();
		}
//		intitalie page factoryt
		pf_Login lg = new pf_Login(driver);
		pf_HomePage hp = new pf_HomePage(driver);
//	------*********************------------	
//		hp.lk_signIN.click();  one way of writing
		
		eleClick(hp.lk_signIN);
		
//		driver.findElement(By.linkText("Sign In")).click();
		
		lg.enterUserDetails(hm);
		
		
//		String act_msg = driver.findElement(By.xpath("//b[contains(text(),'Sorry')]")).getText();
		String act_msg = eleGetText(lg.msg_errorMsg);
		String exp_msg=hm.get("exp_msg");
		
		
//		validation
		if(act_msg.equals(exp_msg)){
			sTest.log(LogStatus.PASS, "Invalid Login Message Validation","Passed as successfully Validated the Invalid Login Message" + sTest.addScreenCapture(sceenshot()));
		}else{
			sTest.log(LogStatus.FAIL, "Invalid Login Message Validation","Failed as actual is " + act_msg + " and expected was "  + exp_msg + sTest.addScreenCapture(sceenshot()));
			Assert.fail();
		}
					
	}
		
	@Test(dataProvider="commondp",dataProviderClass=dataProvider.Dp_dataProvider.class,groups={"uat","qa","dev"})
	public void Login_ValidLogin(Map<String,String> hm) throws Exception{
		sTest = eReports.startTest(hm.get("TC_ID") + "_" + hm.get("order"));
		sTest.assignCategory("Login" + "_" + browsertype);
sTest.log(LogStatus.INFO,"Execution Start", "Start execution of Test case " + hm.get("TC_ID"));
		
		if(driver.getTitle().contains("Book")){
			sTest.log(LogStatus.PASS, "Home Page Validation","Passed as successfully launched home page" + sTest.addScreenCapture(sceenshot()));
		}else{
			sTest.log(LogStatus.FAIL, "Home Page Validation","Failes as expected was Rediff" + "and actual is " + driver.getTitle() + sTest.addScreenCapture(sceenshot()));
			Assert.fail();
		}
		
		
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
//		one way of writing-----------------
//		eleEnterValue(lg.txt_username,hm.get("username"));
//		eleEnterValue(lg.txt_pwd,hm.get("pwd"));
		
//		---------***************
//		click on login
//		driver.findElement(By.xpath("//input[@value='Login']")).click();
//		eleClick(lg.btn_login);
//		----------------------------------
//		Second way of wrting
		lg.enterUserDetails(hm);
		
		
		
		String act_user = eleGetText(hp.lk_username);
		String exp_user=hm.get("exp_msg");
		
//		validation
		if(act_user.equals(exp_user)){
			sTest.log(LogStatus.PASS, "Valid User Validation","Passed as successfully Validated the Valid User Validation" + sTest.addScreenCapture(sceenshot()));
		}else{
			sTest.log(LogStatus.FAIL, "Valid User Validation","Failed as actual is " + act_user + " and expected was "  + exp_user+ sTest.addScreenCapture(sceenshot()));
			Assert.fail();
		}
		
	
		
		
		
	}
	
		

}
