package testPack;

import static org.testng.Assert.assertNotNull;

import java.io.IOException;

import javax.annotation.Tainted;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
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

public class From_and_To_Textbox extends Browser{
		
		private WebDriver driver;
		private AirIndia_Main_Page airIndia_Main_Page;
		private String testID;
		
		 static ExtentTest test;
		 static ExtentHtmlReporter reporter; 
		
		@Parameters("Browser")
		@BeforeTest
		public void Open_the_Browser(String Browsername) throws InterruptedException {
			
			 reporter = new ExtentHtmlReporter("test-output/ExtendReport/Extent.html");
	         ExtentReports extend = new ExtentReports();
	         extend.attachReporter(reporter);
			
			if(Browsername.equals("Chrome"))
			{
				driver = launchChrome();
				driver.get("https://airindia.com/");
				Thread.sleep(1000);
				driver.manage().window().maximize();
				Thread.sleep(1000);
			}
			if(Browsername.equals("Firefox"))
			{
				driver = launchFirefox();
				driver.get("https://airindia.com/");
				Thread.sleep(1000);
				driver.manage().window().maximize();
				Thread.sleep(1000);
			}
	
		}
		@BeforeClass
		public void CreatingPOM_Object()
		{
			airIndia_Main_Page = new AirIndia_Main_Page(driver);
		}
		
		@Test (priority = 1)
		public void Verify_From_Side_Textbox() throws InterruptedException {
		testID = "TC_003" ;
			
		airIndia_Main_Page.ScrollOnFlightsWord();
		airIndia_Main_Page.FromTextboxSendKeys("Nagpur");
		Thread.sleep(1000);
		airIndia_Main_Page.ClickOnOptionfromFromTextbox();
		Thread.sleep(1000);
		}
		
		@Test (priority = 2)
		public void Verify_TO_Textbox_Side() throws InterruptedException { 
		testID = "TC_004" ;
			
		airIndia_Main_Page.TOTextbox("Delhi");
		Thread.sleep(1000);
		airIndia_Main_Page.ClickOnOptionfromToTextbox();
		Thread.sleep(1000);
		airIndia_Main_Page.ClickOnSwitchButtonInFromToTextbox();
		
	}
		
	@AfterMethod
	public void TakeScreenshot_Of_Failed_Test_Methods(ITestResult result) throws IOException {
		
		if(ITestResult.FAILURE == result.getStatus())
		{
			Utility.TakeScreenShotOf(driver, testID);
			
		}
		
	}
		
	@AfterClass
	public void Clear_Object()
	{
		airIndia_Main_Page = null;
	}

	@AfterTest
	public void Close_the_Browser() {
		driver.close();
		driver = null;
		System.gc();
	}
}
