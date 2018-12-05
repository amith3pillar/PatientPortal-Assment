package patientPortal.Page;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.ElementNotVisibleException;
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

	
	public void openMyAccountSection() throws InterruptedException{
		try{
			

		test.log(LogStatus.INFO, "Clickin on My Account section");
		Thread.sleep(2000);
		//driver.navigate().refresh();
		Wait(myAccountbtn);
		myAccountbtn.click();
		}
		catch(ElementNotVisibleException e){
			test.log(LogStatus.ERROR, e.getLocalizedMessage());
		}
	}
	
	public PatientPortalMyAccountPage openAuthorizationPage(){
		test.log(LogStatus.INFO, "Clickin on Grant Access  section Under My Account");
		Wait(clkGrantAccess);
		clkGrantAccess.click();
		PatientPortalMyAccountPage ppMyAccountPage = new PatientPortalMyAccountPage(driver, test);
		PageFactory.initElements(driver, ppMyAccountPage);
		return ppMyAccountPage;
	}
	
	
	
	// Clicking on Update page
	public PatientPortalUpdateInformationPage navigatetoUpdateInformation() throws InterruptedException {
		System.out.println("Clicking on Update Button on Home Page");
		Thread.sleep(10000);
		updateInformaitonBTN.click();
		PatientPortalUpdateInformationPage ppUpdateInformation = new PatientPortalUpdateInformationPage(driver, test);
		PageFactory.initElements(driver, ppUpdateInformation);
		return ppUpdateInformation;
	}
	
	public void clkOnSendAMessageBtn(){
		test.log(LogStatus.INFO, "Opening New Message Page");
		Wait(send_Message_Button);
		send_Message_Button.click();
	}

	public void enterSubjectText(String Sub_String ){
		Wait(enter_Subject);
		test.log(LogStatus.INFO, "Entering Subject as- " + Sub_String);
		enter_Subject.sendKeys("Sub_String");
	}
	
	public void enterMessageText(String MessageString ){
		Wait(enter_Message);
		test.log(LogStatus.INFO, "Entering Message as- " + MessageString);
		enter_Message.sendKeys("MessageString");
	}
	
	public void clickOnSndBtnOnMessagePage(){
		Wait(send_Button);
		send_Button.click();
	}
	
	public void clickOnRequestANAppointmentButton() throws InterruptedException{
		test.log(LogStatus.INFO, "Opening Request an Appointment Page");
		Wait(requestAnAppointment);
		//Thread.sleep(5000);
		requestAnAppointment.click();
	
	}
	
	public void enterSubjectAppointmentScreen(String Sub_String){
		Wait(enter_Subject);
		test.log(LogStatus.INFO, "Entering Subject as- " + Sub_String);
		enter_Subject.sendKeys("Sub_String");
	}
	
	public void enterMessageAppointmentScreen(String MessageString){
		Wait(enter_Message);
		enter_Message.sendKeys("MessageString");
		test.log(LogStatus.INFO, "Entering Message as- " + MessageString);
	}
	
	public void clickOnSendBtnOfAppointMentScreen(){
		Wait(send_Button);
		send_Button.click();

	}

}