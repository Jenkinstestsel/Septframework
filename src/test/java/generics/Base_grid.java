package generics;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import pageFactory.CommonActions;

public class Base_grid extends CommonActions {
	protected WebDriver driver;
	public static ExtentReports eReports; 
	public ExtentTest sTest;
	public String browsertype;
	
	@BeforeSuite(groups={"uat","qa","dev","prod"})
	public void initReports(){		
		eReports = new ExtentReports("E:\\Septrep\\Reports\\frmreport_" + getDateTimeStamp()+ ".html");
	}
	
	
	@Parameters("config")
	@BeforeMethod(groups={"uat","qa","dev","prod"})
	public void launchApp(String config) throws Exception{
		browsertype=config;
		
		DesiredCapabilities dcap = new DesiredCapabilities();
		
		if(config.equals("c1")){
			dcap.setCapability("browserName", "chrome");
			dcap.setCapability("version", "46");
			dcap.setCapability("platform", "WINDOWS");	
		}else if(config.equals("c2")){
			dcap.setCapability("browserName", "firefox");
			dcap.setCapability("version", "42");
			dcap.setCapability("platform", "WINDOWS");	
		}
		
		driver = new RemoteWebDriver(new URL("http://192.168.1.77:4444/wd/hub"),dcap);
		
		driver.get("http://books.rediff.com/");
		driver.manage().window().maximize();	
		driver.manage().timeouts().implicitlyWait(75, TimeUnit.SECONDS);
	}
	
	
	@AfterMethod(groups={"uat","qa","dev","prod"})
	public void tearDown(ITestResult re) throws Exception{
		
		if(re.getStatus()==ITestResult.FAILURE){
			sTest.log(LogStatus.FAIL, "Final Status", re.getThrowable() + sTest.addScreenCapture(sceenshot()));
		}else if(re.getStatus()==ITestResult.SKIP){
			sTest.log(LogStatus.SKIP, "Final Status", re.getThrowable() + sTest.addScreenCapture(sceenshot()));
		}else if(re.getStatus()==ITestResult.SUCCESS){
			sTest.log(LogStatus.PASS, "Final Status",  sTest.addScreenCapture(sceenshot()));
		}
		
		
		eReports.endTest(sTest);
		eReports.flush();
		driver.quit();	
		
	}
	
	
		public String sceenshot() throws Exception{
			TakesScreenshot img = (TakesScreenshot)driver;
			File screenshotAs = img.getScreenshotAs(OutputType.FILE);
			String path="E:\\Septrep\\test" + getDateTimeStamp() + ".png";
			FileUtils.copyFile(screenshotAs, new File(path));
			return path;
		}	
	
	public String getDateTimeStamp(){
		Date xdate = new Date();
		System.out.println(xdate);
		
		SimpleDateFormat sf = new SimpleDateFormat("dd-MMM-yyyy hh-mm-ss");
		String dt = sf.format(xdate);
		return dt;
	
	}
}
