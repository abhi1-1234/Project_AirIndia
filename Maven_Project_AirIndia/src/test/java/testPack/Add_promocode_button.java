package testPack;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.AirIndia_Main_Page;

public class Add_promocode_button {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

System.setProperty("webdriver.chrome.driver", "C:\\Users\\lenovo\\Documents\\Automation\\Selenium\\chromedriver-win64\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.airindia.com/");
		Thread.sleep(1000);
		driver.manage().window().maximize();
		
		AirIndia_Main_Page airIndia_Main_Page = new AirIndia_Main_Page(driver);
		
		airIndia_Main_Page.ScrollOnFlightsWord();
		Thread.sleep(1000);
		airIndia_Main_Page.ClickOnAddPromoCodeButton();
		Thread.sleep(1000);
		airIndia_Main_Page.SendKeysInAddPromocodeTextbox("4656dfgjk");
		
	}

}
