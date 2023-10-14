package testPack;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import pages.AirIndia_Main_Page;
import utilize.Utility;

public class Passengers_Textbox {
	
	private	WebDriver driver;
	private String testID; 
	private	AirIndia_Main_Page airIndia_Main_Page;
	
	   static ExtentTest test;
	   static ExtentHtmlReporter reporter; 
	
	@Parameters("Browser")
	@BeforeTest
	public void Open_the_Browser(String Browsername) throws InterruptedException 
	{
		 reporter = new ExtentHtmlReporter("test-output/ExtendReport/Extent.html");
         ExtentReports extend = new ExtentReports();
         extend.attachReporter(reporter);
		
		if(Browsername.equals("Chrome")) {
			
			driver = base.Browser.launchChrome();
			driver.get("https://www.airindia.com/");
			Thread.sleep(1000);
			driver.manage().window().maximize();
			Thread.sleep(1000);
			airIndia_Main_Page = new AirIndia_Main_Page(driver);
			airIndia_Main_Page.ScrollOnFlightsWord();
			Thread.sleep(1000);
		}
		if(Browsername.equals("Firefox"))
		{
			driver = base.Browser.launchFirefox();
			driver.get("https://airindia.com/");
			Thread.sleep(1000);
			airIndia_Main_Page = new AirIndia_Main_Page(driver);
			airIndia_Main_Page.ScrollOnFlightsWord();
			Thread.sleep(1000);
		}
	}
	@BeforeClass
	public void POM_Class_Object()
	{
		airIndia_Main_Page = new AirIndia_Main_Page(driver);
	}
	
	@BeforeMethod
	public void ClickOnPassengerTextbox() 
	{
		airIndia_Main_Page.clickOnPassengerTextboxDropdown();
	}	
			@Test (priority = 1)
			public void Verify_Adult_Increase_Decrease_button() throws InterruptedException 
			{
				testID = "TC_005" ;
				
				for(int i=0;i<=5;i++)
				{
				airIndia_Main_Page.ClickOnPassengerDropdownAdultIncreaseButton();
				Thread.sleep(1000);
				}
				for(int j=0;j<=3;j++)
				{
					airIndia_Main_Page.ClickOnPassengerDropdownAdultDecreaseButton();
					Thread.sleep(1000);
				}
			}	
		    @Test (priority = 2)
			public void Verify_Children_Increase_Decrease_Button() throws InterruptedException 
			{
		    	testID = "TC_006" ;
						
					for(int k=1;k<=5;k++)
					{
						airIndia_Main_Page.ClickOnPassengerDropdownChildrenIncreaseButton();
						Thread.sleep(1000);
					}
					for(int a=1;a<=3;a++)
					{
						airIndia_Main_Page.ClickOnPassengerDropdownChildrenDecreaseButton();
						Thread.sleep(1000);
					}
			}
			@Test (priority = 3)
			public void Verify_Infant_Icrease_Decrease_Button() throws InterruptedException 
			{
				testID = "TC_007" ;
				
				for(int b=1;b<=5;b++)
				{
					airIndia_Main_Page.ClickOnPassengerDropdownInfantIncreaseButton();
					Thread.sleep(1000);
				}
				for(int c=1;c<=3;c++)
				{
					airIndia_Main_Page.ClickOnPassengerDropdownInfantDecreaseButton();
					Thread.sleep(1000);
				}
			}
	  
	
	@AfterMethod
	public void ClickAgainOnPassengerTextbox(ITestResult result) throws IOException 
	{
		airIndia_Main_Page.clickOnPassengerTextboxDropdown();
		if(ITestResult.FAILURE == result.getStatus()) 
		{
			Utility.TakeScreenShotOf(driver, testID);
		}
	}
	
	@AfterClass
	public void ClearObject()
	{
		airIndia_Main_Page = null;
	}
	@AfterTest
	public void Close_The_Browser() 
	{
		driver.close();
		driver = null;
		System.gc();
	}
}