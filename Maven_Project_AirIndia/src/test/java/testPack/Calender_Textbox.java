package testPack;

import static org.testng.Assert.assertNotNull;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import base.Browser;
import pages.AirIndia_Main_Page;
import utilize.Utility;

public class Calender_Textbox extends Browser {
	
	private WebDriver driver;
    private	AirIndia_Main_Page airIndia_Main_Page;
    private String testID ;
    
    static ExtentTest test;
    static ExtentHtmlReporter reporter; 
    
	@Parameters("Browser")
	@BeforeTest
	public void open_Browser(String Browsername) throws InterruptedException {
		
		 reporter = new ExtentHtmlReporter("test-output/ExtendReport/Extent.html");
         ExtentReports extend = new ExtentReports();
         extend.attachReporter(reporter);
		
		if(Browsername.equals("Chrome")) 
		{
		    driver = launchChrome();
			driver.get("https://www.airindia.com/");
			Thread.sleep(1000);
			driver.manage().window().maximize();
		
		}
		if(Browsername.equals("Firefox")) 
		{
			driver = launchFirefox();
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\lenovo\\Documents\\Automation\\Selenium\\geckodriver.exe");
			driver = new FirefoxDriver(); 
			driver.get("https://www.airindia.com/");
			Thread.sleep(1000);
			driver.manage().window().maximize();
			
		}
	}
	@BeforeClass
	public void Creating_POM_Object()
	{
		airIndia_Main_Page = new AirIndia_Main_Page(driver);
	}
	
		@Test (priority = 1)
		public void Verify_Depart_Calender_Side() throws InterruptedException {
		testID = "TC_002" ;
			
		airIndia_Main_Page.ScrollOnFlightsWord();
		Thread.sleep(1000);
		airIndia_Main_Page.ClickOnDepartCalenderButton();
		Thread.sleep(1000);
		airIndia_Main_Page.SelectMonth("Nov");
		Thread.sleep(1000);
	}
		@Test (priority = 2)
		public void Verify_Return_Calender_Side() throws InterruptedException {
		testID = "TC_002" ;
			
		airIndia_Main_Page.ClickOnDateInCalender();
		Thread.sleep(1000);
		airIndia_Main_Page.ClickOnReturnCalenderButton();
		Thread.sleep(1000);
		airIndia_Main_Page.SelectMonth("Dec");
		Thread.sleep(1000);
		airIndia_Main_Page.ClickOnDateInCalender();
		Thread.sleep(1000);
	}
		
		@AfterMethod
		public void TakeScreenshot_Of_Failed_Test_Methods(ITestResult result) throws IOException {
			if(ITestResult.FAILURE == result.getStatus())
			{
				Utility.TakeScreenShotOf(driver, testID);
			}
			
		}
		
	@AfterTest
	public void Close_the_Browser() {
		driver.close();
		driver = null;
		System.gc();
	}

}
