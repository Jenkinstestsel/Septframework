package generics;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Emicalc {
	
	@SuppressWarnings("resource")
	public static void main(String[] args) throws Exception {
		
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\GlobalSettings.properties");
		
		Properties prop = new Properties();
		prop.load(fis);
		
		String url = prop.getProperty("dummyurl");
		
		
		
//		launch App
		FirefoxDriver ff = new FirefoxDriver();
		ff.get(url);
		
//		Enter amount
		ff.findElement(By.id("one")).sendKeys("100000");		
//		Enter rate
		ff.findElement(By.id("two")).sendKeys("10");
//		Enter Tenure
		ff.findElement(By.id("three")).sendKeys("120");
//		Click Calculate
		ff.findElement(By.name("B1")).click();
//		Extarct EMI
		
		String output = ff.findElement(By.id("four")).getAttribute("value");
		System.out.println(output);
		
//		close App
		ff.close();
		
		
		
	}
}
