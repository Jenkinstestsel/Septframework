package testScript;

import java.util.Map;

import generics.Base;

import org.junit.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import pageFactory.pf_Cartpage;
import pageFactory.pf_HomePage;
import pageFactory.pf_ProductDetailsPage;

public class Scenario_Cart extends Base{
	
	@Test(dataProvider="commondp",dataProviderClass=dataProvider.Dp_dataProvider.class,groups={"qa"})
	public void Cart_Addbook(Map<String,String> hm) throws Exception{
		sTest = eReports.startTest(hm.get("TC_ID") + "_" + hm.get("order"));
		sTest.assignCategory("Cart" + "_" + browsertype);	
		
		if(driver.getTitle().contains("Buy Books Online")){
			sTest.log(LogStatus.PASS, "Home Page Validation","Passed as successfully launched home page" + sTest.addScreenCapture(sceenshot()));
		}else{
			sTest.log(LogStatus.FAIL, "Home Page Validation","Failes as expected was Rediff" + "and actual is " + driver.getTitle() + sTest.addScreenCapture(sceenshot()));
			Assert.fail();
		}
		pf_HomePage hp = new pf_HomePage(driver);
		
		hp.enterSearch(hm);
//		click on first book
		eleClick(hp.img_firstBook);
		
		
//		Navigate to Product details page
		if(driver.getTitle().toLowerCase().contains(hm.get("Search_option").toLowerCase())){
			sTest.log(LogStatus.PASS, "Product details Page Validation","Passed as successfully launched Product details page" + sTest.addScreenCapture(sceenshot()));
		}else{
			sTest.log(LogStatus.FAIL, "Product details Page Validation","Failes as didnot find the book in the title"  + sTest.addScreenCapture(sceenshot()));
			Assert.fail();
		}
		
		
		
		pf_ProductDetailsPage pdp = new pf_ProductDetailsPage(driver);
		
		eleClick(pdp.btn_BuyNow);
		
		
//		Naviagate Cart Page
		
		if(driver.getTitle().contains("Shopping")){
			sTest.log(LogStatus.PASS, "Cart Page Validation","Passed as successfully launched Cart page" + sTest.addScreenCapture(sceenshot()));
		}else{
			sTest.log(LogStatus.FAIL, "Cart Page Validation","Failes as expected was Shopping" + "and actual is " + driver.getTitle() + sTest.addScreenCapture(sceenshot()));
			Assert.fail();
		}
		
		
		pf_Cartpage pcp = new pf_Cartpage(driver);
		
		driver.switchTo().frame(pcp.frm_cart);
		
		String booktitle = eleGetText(pcp.lbl_book);
		
		
		if(booktitle.toLowerCase().contains(hm.get("Search_option").toLowerCase())){
			sTest.log(LogStatus.PASS, "Add book Validation","Passed as successfully Added th book" + sTest.addScreenCapture(sceenshot()));
		}else{
			sTest.log(LogStatus.FAIL, "Add book Validation","Failes as expected was " + hm.get("Search_option") + "and actual is " + booktitle + sTest.addScreenCapture(sceenshot()));
			Assert.fail();
		}
		
		
		
		
		
	}
	

	

}
