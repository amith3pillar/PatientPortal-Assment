package patientPortal.Page;

import javax.net.ssl.HostnameVerifier;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import patientPortal.OR.PPHomePageOR;
import patientPortal.OR.ppMyAccountPageOR;
import patientPortalBase.BasePage;

public class PatientPortalMyAccountPage extends BasePage {

	public PatientPortalMyAccountPage(WebDriver driver, ExtentTest test) {
		super(driver, test);
		
	}
	@FindBy(xpath=ppMyAccountPageOR.MY_ACCOUNT)
	public WebElement myAccountbtn;

	@FindBy(xpath=ppMyAccountPageOR.CLK_HISTORY_LOG)
	public WebElement clkHistoryLog;
	
	
	@FindBy(xpath = ppMyAccountPageOR.AUTH_USER_NAME)
	public WebElement enterUserName;

	@FindBy(xpath = ppMyAccountPageOR.AUTH_PASSWORD)
	public WebElement enterPassword;

	@FindBy(xpath = ppMyAccountPageOR.AUTH_REENTER_PASSWORD)
	public WebElement enterCon_Password;

	@FindBy(xpath = ppMyAccountPageOR.AUTH_FIRST_NAME)
	public WebElement firstName;

	@FindBy(xpath = ppMyAccountPageOR.AUTH_LAST_NAME)
	public WebElement last_Name;

	@FindBy(xpath = ppMyAccountPageOR.AUTH_SAVE_BUTTON)
	public WebElement Btn_Save;

	@FindBy(xpath = ppMyAccountPageOR.NOTIFICATION_BTN1)
	public WebElement Btn_Notice;


	
	// This method is for creating new user by Clicking on MyAccount from left
	// pannel
	/*public void grantAccessToNewUser(String authUserName, String authPassword, String AuthConfirmPass,
		String FirstName, String LastName) throws InterruptedException {
		test.log(LogStatus.INFO, "Entering values in authontication page");
		//Thread.sleep(3000);
		Wait(enterUserName);
		enterUserName.clear();
		test.log(LogStatus.INFO, "Loggin In-"+authUserName +"/"+ authPassword+"/"+FirstName+"/"+LastName);
		enterUserName.sendKeys(authUserName);
		enterPassword.sendKeys(authPassword);
		enterCon_Password.sendKeys(AuthConfirmPass);
		firstName.clear();
		firstName.sendKeys(FirstName);
		last_Name.clear();
		last_Name.sendKeys(LastName);
		Btn_Save.click();
		test.log(LogStatus.INFO, "New Crediential Created ");
		Thread.sleep(3000);

	}*/
	public void authorizedUserName(String authUserName){
		test.log(LogStatus.INFO, "Entering Authorized Representative User Name");
		Wait(enterUserName);
		enterUserName.clear();
		test.log(LogStatus.INFO, "Loggin In-"+authUserName);
		enterUserName.sendKeys(authUserName);
	}
	
	public void authorizedPassword(String authPassword){
		test.log(LogStatus.INFO, "Entering Password for  Authorized Representative ");
		Wait(enterPassword);
		enterPassword.clear();
		enterPassword.sendKeys(authPassword);
	}
	
	
	public void authorizedConfirmPassword(String AuthConfirmPass){
		test.log(LogStatus.INFO, "Entering Confirm Password for  Authorized Representative ");
		Wait(enterCon_Password);
		enterCon_Password.clear();
		enterCon_Password.sendKeys(AuthConfirmPass);
	}
	
	public void authorizedFirstName(String FirstName){
		test.log(LogStatus.INFO, "Entering First Name of  Authorized Representative ");
		Wait(firstName);
		firstName.clear();
		firstName.sendKeys(FirstName);
	}
	
	
	public void authorizedLastName(String LastName){
		test.log(LogStatus.INFO, "Entering Last Name of  Authorized Representative ");
		Wait(last_Name);
		last_Name.clear();
		last_Name.sendKeys(LastName);
	}
	
	
	public void clickOnSaveBtn(){
		test.log(LogStatus.INFO, "Clicking on Save  Button on  Authorized Representative ");
		Wait(Btn_Save);
		Btn_Save.click();
	}
	
	
	
	//This function is used for clicking on Notice button 
	public PatientPortalHomePage clickOnNotice() throws InterruptedException{
		Thread.sleep(3000);
		Btn_Notice.click();
		PatientPortalHomePage ppHomePage = new PatientPortalHomePage(driver, test);
		PageFactory.initElements(driver, ppHomePage);
		return ppHomePage;

	}

	public void clickOnHistoryLog() throws InterruptedException{
		Thread.sleep(3000);
		//Wait(myAccountbtn);
		myAccountbtn.click();
		Thread.sleep(3000);
		clkHistoryLog.click();
			
	}
	
	
	public void clkOnMyAccountSection(){
		test.log(LogStatus.INFO, "Clicking on My Account Section");
	}

	
}
