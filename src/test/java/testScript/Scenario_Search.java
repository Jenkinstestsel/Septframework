package testScript;

import java.util.Map;

import generics.Base;

import org.junit.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import pageFactory.pf_HomePage;

public class Scenario_Search extends Base{
	
	@Test(dataProvider="commondp",dataProviderClass=dataProvider.Dp_dataProvider.class,groups={"qa"})
	public void Search_ValidSearch(Map<String,String> hm) throws Exception{
		sTest = eReports.startTest(hm.get("TC_ID") + "_" + hm.get("order"));
		sTest.assignCategory("Search" + "_" + browsertype);	
		
		if(driver.getTitle().contains("Buy Books Online")){
			sTest.log(LogStatus.PASS, "Home Page Validation","Passed as successfully launched home page" + sTest.addScreenCapture(sceenshot()));
		}else{
			sTest.log(LogStatus.FAIL, "Home Page Validation","Failes as expected was Rediff" + "and actual is " + driver.getTitle() + sTest.addScreenCapture(sceenshot()));
			Assert.fail();
		}
		pf_HomePage hp = new pf_HomePage(driver);
		
		hp.enterSearch(hm);
		
		String act_count = eleGetText(hp.lbl_searchCount);	
		
		if(act_count.equals(hm.get("Exp_result"))){
			sTest.log(LogStatus.PASS, "Search Count Validation","Passed as successfully Validated the Search Count Validation" + sTest.addScreenCapture(sceenshot()));
		}else{
			
			sTest.log(LogStatus.FAIL, "Search Count Validation","Failed as actual is " + act_count + " and expected was "  + hm.get("Exp_result")+ sTest.addScreenCapture(sceenshot()));
			Assert.fail();
		}
		
		
		
	}
	
	
	@Test(dataProvider="commondp",dataProviderClass=dataProvider.Dp_dataProvider.class,groups={"uat"})
	public void Search_inValidSearch(Map<String,String> hm) throws Exception{
			
		sTest = eReports.startTest(hm.get("TC_ID") + "_" + hm.get("order"));
		sTest.assignCategory("Search" + "_" + browsertype);	
		
		if(driver.getTitle().contains("Buy Books Online")){
			sTest.log(LogStatus.PASS, "Home Page Validation","Passed as successfully launched home page" + sTest.addScreenCapture(sceenshot()));
		}else{
			sTest.log(LogStatus.FAIL, "Home Page Validation","Failes as expected was Rediff" + "and actual is " + driver.getTitle() + sTest.addScreenCapture(sceenshot()));
			Assert.fail();
		}
		pf_HomePage hp = new pf_HomePage(driver);
		
		hp.enterSearch(hm);
		
		String act_msg = eleGetText(hp.lbl_invalidSearchMsg);	
		
		if(act_msg.equals(hm.get("Exp_result"))){
			sTest.log(LogStatus.PASS, "Search msg Validation","Passed as successfully Validated the Search msg Validation" + sTest.addScreenCapture(sceenshot()));
		}else{
			
			sTest.log(LogStatus.FAIL, "Search msg Validation","Failed as actual is " + act_msg + " and expected was "  + hm.get("Exp_result")+ sTest.addScreenCapture(sceenshot()));
			Assert.fail();
		}
		
		
		
	}
	
	
	

}
