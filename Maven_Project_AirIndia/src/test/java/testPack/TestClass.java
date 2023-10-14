package testPack;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.AirIndia_Main_Page;

public class TestClass {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

System.setProperty("webdriver.chrome.driver", "C:\\Users\\lenovo\\Documents\\Automation\\Selenium\\chromedriver-win64\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://travel.airindia.in/booking/availability/0");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		AirIndia_Main_Page airIndia_Main_Page = new AirIndia_Main_Page(driver);
		
		airIndia_Main_Page.ClickOnClickToVerifyButton();
		
		
		
		
		
		
		
		
	}

}
