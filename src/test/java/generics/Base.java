package generics;

import java.io.File;
import java.io.IOException;
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
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import pageFactory.CommonActions;

public class Base extends CommonActions {
	protected WebDriver driver;
	public static ExtentReports eReports; 
	public ExtentTest sTest;
	public String browsertype;
	
	@BeforeSuite(groups={"uat","qa","dev","prod"})
	public void initReports(){		
		eReports = new ExtentReports("E:\\Septrep\\Reports\\frmreport_" + getDateTimeStamp()+ ".html");
	}
	
	
	@Parameters("browser")
	@BeforeMethod(groups={"uat","qa","dev","prod"})
	public void launchApp(String brow){
		browsertype=brow;
		if(brow.equals("ff")){
			driver = new FirefoxDriver();
		}else if(brow.equals("ch")){
		
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\test\\resources\\chromedriver.exe");
			driver = new ChromeDriver();		
			
		}else if(brow.equals("ie")){
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "\\src\\test\\resources\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		
		
		
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
