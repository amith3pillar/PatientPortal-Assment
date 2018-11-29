package patientPortal.Page;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import patientPortal.OR.PPHomePageOR;
import patientPortal.OR.ppMyAccountPageOR;
import patientPortalBase.BasePage;

public class PatientPortalHomePage extends BasePage {

	public PatientPortalHomePage(WebDriver driver, ExtentTest test) {
		super(driver, test);
	}

	@FindBy(id = PPHomePageOR.REQUEST_AN_APPOINTMENT)
	public WebElement requestAnAppointment;

	@FindBy(xpath = PPHomePageOR.MY_ACCOUNT)
	public WebElement myAccountbtn;

	@FindBy(xpath = PPHomePageOR.GRANT_ACCESS)
	public WebElement clkGrantAccess;

	@FindBy(xpath = PPHomePageOR.CLK_HISTORY_LOG)
	public WebElement clkHistoryLog;

	@FindBy(xpath = PPHomePageOR.ENTER_SUBJECT)
	public WebElement enter_Subject;

	@FindBy(xpath = PPHomePageOR.ENTER_MESSAGE)
	public WebElement enter_Message;

	@FindBy(xpath = PPHomePageOR.SendBTN)
	public WebElement send_Button;

	@FindBy(xpath = PPHomePageOR.SEND_MESSAGE_BUTTON)
	public WebElement send_Message_Button;

	@FindBy(xpath = PPHomePageOR.CLK_UPDATE_INFORMATION_BTN)
	public WebElement updateInformaitonBTN;

	public PatientPortalUpdateInformationPage goToUpdateInformation() {

		return PageFactory.initElements(driver, PatientPortalUpdateInformationPage.class);

	}

	public void send_A_Message(String Sub_String, String MessageString) {
		test.log(LogStatus.INFO, "Opening New Message Page");
		Wait(send_Message_Button);
		send_Message_Button.click();
		Wait(enter_Subject);
		test.log(LogStatus.INFO, "Entering Subject as- " + Sub_String);
		enter_Subject.sendKeys("Sub_String");
		test.log(LogStatus.INFO, "Entering Message as- " + MessageString);
		enter_Message.sendKeys("MessageString");
		send_Button.click();
	}

	public void requestAppointment(String Sub_String, String MessageString) {
		test.log(LogStatus.INFO, "Opening Request an Appointment Page");
		Wait(requestAnAppointment);
		requestAnAppointment.click();
		Wait(enter_Subject);
		test.log(LogStatus.INFO, "Entering Subject as- " + Sub_String);
		enter_Subject.sendKeys("Sub_String");
		enter_Message.sendKeys("MessageString");
		test.log(LogStatus.INFO, "Entering Message as- " + MessageString);
		send_Button.click();

	}

	public PatientPortalMyAccountPage openMyAccount() throws InterruptedException {
		test.log(LogStatus.INFO, "Opening Grant Access Screen");
		Thread.sleep(3000);
		myAccountbtn.click();
		Wait(clkGrantAccess);
		clkGrantAccess.click();
		PatientPortalMyAccountPage ppMyAccountPage = new PatientPortalMyAccountPage(driver, test);
		PageFactory.initElements(driver, ppMyAccountPage);
		return ppMyAccountPage;

	}

	// Clicking on Update page
	public PatientPortalUpdateInformationPage navigatetoUpdateInformation() throws InterruptedException {
		System.out.println("Clicking on Update Button on Home Page");
	/*	
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
			    .withTimeout(30, TimeUnit.SECONDS)
			    .pollingEvery(5, TimeUnit.SECONDS)
			    .ignoring(NoSuchElementException.class)
			    .ignoring(ElementNotInteractableException.class);

			WebElement foo = wait.until(new Function<WebDriver, WebElement>() 
			{
			  public WebElement apply(WebDriver driver) {
			  return driver.findElement(By.id("//div[@class='row']//div[5]//a[1]"));
			}
			});
			foo.click();*/
		
	/*	org.openqa.selenium.support.ui.Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
			    .withTimeout(60, TimeUnit.SECONDS)
			    .pollingEvery(5, TimeUnit.SECONDS)
			    .ignoring(NoSuchElementException.class);

			WebElement foo = wait.until(new Function<WebDriver, WebElement>() 
			{
			  public WebElement apply(WebDriver driver) {
			WebElement m=   driver.findElement(By.xpath("//div[@class='row']//div[5]//a[1]"));
			return m;
			
			}
			});*/
		
		
		/*long timeoutInSeconds = 3000;
		new WebDriverWait(driver, timeoutInSeconds).until(ExpectedConditions.elementToBeClickable(By.xpath(PPHomePageOR.CLK_UPDATE_INFORMATION_BTN)));*/
		//waitfunction(updateInformaitonBTN);
		Thread.sleep(10000);
		updateInformaitonBTN.click();
		PatientPortalUpdateInformationPage ppUpdateInformation = new PatientPortalUpdateInformationPage(driver, test);
		PageFactory.initElements(driver, ppUpdateInformation);
		return ppUpdateInformation;
	}

}
