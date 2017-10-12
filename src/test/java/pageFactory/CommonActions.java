package pageFactory;

import org.openqa.selenium.WebElement;

public class CommonActions {
	
//	Click operation
	public void eleClick(WebElement ele){
		
		ele.click();
	}
	
//	Enter Value operation
	public void eleEnterValue(WebElement ele, String Val){
		
		ele.sendKeys(Val);
	}	
	
	
//	GetText operation
	public String eleGetText(WebElement ele){
		
		return ele.getText();
	}	
	
	
	
	
	
	
	
	

}
