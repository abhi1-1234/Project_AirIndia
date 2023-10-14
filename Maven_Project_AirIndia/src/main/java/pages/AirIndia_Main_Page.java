package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AirIndia_Main_Page {

	@FindBy (xpath = "//span[text()='One Way']")
	private WebElement OneWayRadioButton;
	
	@FindBy (xpath = "//span[text()='Round Trip']")
	private WebElement RoundTripRadioButton;
	
	@FindBy (xpath = "//a[text()='Multicity']")
	private WebElement MulticityLink;
	
	@FindBy (xpath = "//input[@id='From']")
	private WebElement FromTextbox;
	
	@FindBy (xpath = "(//div[@class='col-9'])[1]")
	private WebElement OptionfromFromTextbox;
	
	@FindBy (xpath = "//input[@id='To']")
	private WebElement TOTextbox;
	
	@FindBy (xpath = "(//div[@class='col-9'])[1]")
	private WebElement OptionfromToTextbox;
	
	@FindBy (xpath = "(//input[@class='btn bi bi-calendar3'])[1]")
	private WebElement DepartCalenderButton;
	
	@FindBy (xpath = "(//input[@class='btn bi bi-calendar3'])[2]")
	private WebElement ReturnCalenderButton;
	
	@FindBy (xpath = "//select[@aria-label='Select month']")
	private WebElement SelectMonthFromCalender; 
	
	@FindBy(xpath = "(//span[@class='custom-day ng-star-inserted'])[12]")
	private WebElement SelectDateFromCalender;
	
	@FindBy (xpath = "//span[text()='Flights']")
	private WebElement FlightsWord;
	
	@FindBy (xpath = "//div[@id='dropdownForm1']")
	private WebElement PassengerTextboxDropdown;
	
	@FindBy (xpath = "(//button[contains(@Class,'col-2')])[1]")
	private WebElement PassengerDropdownAdultDecreaseButton;
	
	@FindBy (xpath = "(//button[contains(@Class,'col-2')])[2]")
	private WebElement PassengerDropdownAdultIncreaseButton;
	
	@FindBy (xpath = "(//button[contains(@Class,'col-2')])[3]")
	private WebElement PassengerDropdownChildrenDecreaseButton;
	
	@FindBy (xpath = "(//button[contains(@Class,'col-2')])[4]")
	private WebElement PassengerDropdownChildrenIncreaseButton;

	@FindBy (xpath = "(//button[contains(@Class,'col-2')])[5]")
	private WebElement PassengerDropdownInfantDecreaseButton;
	
	@FindBy (xpath = "(//button[contains(@Class,'col-2')])[6]")
	private WebElement PassengerDropdownInfantIncreaseButton;
	
	@FindBy (xpath = "//div[@id='mat-select-value-1']")
	private WebElement ClassTextbox;
	
	@FindBy (xpath = "//div[@class='mat-select-arrow-wrapper ng-tns-c42-5']")
	private WebElement ConsessionTypeTextbox;
	
	@FindBy (xpath = "//a[text()='Check Eligibility']")
	private WebElement CheckEligibilityLink;
	
	@FindBy (xpath = "//span[text()='+ Add promocode']")
	private WebElement AddPromoCodeButton;
	
	@FindBy (xpath = "(//input[@type='text'])[5]")
	private WebElement AddPromocodeTextbox;
	
	@FindBy (xpath = "//span[text()='Booking']")
	private WebElement ManageBookingTab ;

	@FindBy (xpath = "//div[@class='switch-btn position-absolute']")
	private WebElement SwitchButton;
	
	@FindBy (xpath = "//button[text()=' SHOW FLIGHTS ']")
	private WebElement ShowFlightsButton;
	
	@FindBy (xpath = "//span[text()='Click to verify']")
	private WebElement ClickToVerifyButton;
	
	Actions act;
	
	WebDriver driver;
	//Constructor - public
	
	public AirIndia_Main_Page(WebDriver driver)
	{
        PageFactory.initElements(driver, this);
        this.driver = driver;
        act = new Actions(driver);
	}
	
	//Method - public
	
	public void ClickOnClickToVerifyButton() {
		act.moveToElement(ClickToVerifyButton).click().build().perform();
		ClickToVerifyButton.click();
	}
	
	public void ClickOnShowFlightsButton() {
		
		ShowFlightsButton.click();
	}
	
	public void ClickOnSwitchButtonInFromToTextbox() {
		SwitchButton.click();
	}
	
	public void clickOnOneWayRadioButton()
	{
		OneWayRadioButton.click();
	}
	
	public void ClickOnRoundTripRadioButton() 
	{
		RoundTripRadioButton.click();
	}
	
	public void MulticityLink()
	{
		MulticityLink.click();
	}
	
	public void FromTextboxSendKeys(String s)
	{
		FromTextbox.sendKeys(s);
	}
	
	public void TOTextbox(String h)
	{
		TOTextbox.sendKeys(h);
	}
	
	public void ClickOnDepartCalenderButton()
	{
		DepartCalenderButton.click();
	}
	
	public void ClickOnReturnCalenderButton()
	{
		ReturnCalenderButton.click();
	}
	
	public void SelectMonth(String d)
	{
		Select s = new Select(SelectMonthFromCalender);
		s.selectByVisibleText(d);
	}
	
	public void ClickOnDateInCalender()
	{
		SelectDateFromCalender.click();
	}
	
	public void ScrollOnFlightsWord() throws InterruptedException
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true)", FlightsWord);
		Thread.sleep(1000);
		js.executeScript("window.scrollBy(0, -100)");
	}
	
	public void clickOnPassengerTextboxDropdown()
	{
		PassengerTextboxDropdown.click();
	}
	
	public void ClickOnPassengerDropdownAdultDecreaseButton() {
		PassengerDropdownAdultDecreaseButton.click();
	}
	
	public void ClickOnPassengerDropdownAdultIncreaseButton() {
		PassengerDropdownAdultIncreaseButton.click();
	}
	
	public void ClickOnPassengerDropdownChildrenDecreaseButton() {
		PassengerDropdownChildrenDecreaseButton.click();
	}
	
	public void ClickOnPassengerDropdownChildrenIncreaseButton() {
		PassengerDropdownChildrenIncreaseButton.click();
	}
	
	public void ClickOnPassengerDropdownInfantDecreaseButton() {
		PassengerDropdownInfantDecreaseButton.click();
	}
	
	public void ClickOnPassengerDropdownInfantIncreaseButton() {
		PassengerDropdownInfantIncreaseButton.click();
	}
	
	public void clickOnClassTextbox()
	{
		ClassTextbox.click();
	}
	
	public void ClickOnConsessionTypeTextbox()
	{
		ConsessionTypeTextbox.click();
	}
	
	public void ClickOnCheckEligibilityLink()
	{
		CheckEligibilityLink.click();
	}
	
	public void ClickOnAddPromoCodeButton()
	{
		AddPromoCodeButton.click();
	}
	
	public void SendKeysInAddPromocodeTextbox(String k)
	{
		AddPromocodeTextbox.sendKeys(k);
	}
	
	public void ClickOnManageBookingTab()
	{
		ManageBookingTab.click();
	}
	
	public void ClickOnOptionfromFromTextbox() {
		OptionfromFromTextbox.click();
	}
	
	public void ClickOnOptionfromToTextbox() {
		OptionfromToTextbox.click();
	}
}
	
	
	
	

