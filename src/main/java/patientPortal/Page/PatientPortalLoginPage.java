package patientPortal.Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import patientPortal.OR.PPHomePageOR;
import patientPortal.OR.PPLoginPageOR;
import patientPortalBase.BasePage;

public class PatientPortalLoginPage extends BasePage {

	@FindBy(id = PPLoginPageOR.USERNAME)
	public WebElement UserName;

	@FindBy(id = PPLoginPageOR.PASSWORD)
	public WebElement Password;

	@FindBy(xpath = PPLoginPageOR.CLICKONSUBMIT_BTN)
	public WebElement ClickOnSubmit;

	public PatientPortalLoginPage(WebDriver driver, ExtentTest test) {
		super(driver, test);

	}

	public Object doLogin(String usName, String pWord) throws InterruptedException {
		test.log(LogStatus.INFO, "Loggin In-"+usName +"/"+ pWord);
		UserName.sendKeys(usName);
		Password.sendKeys(pWord);
		ClickOnSubmit.click();
	//	wait1.until(ExpectedConditions.)
		Thread.sleep(2000); // Need to Implement Explicite wait or Implicite
							// wait
		boolean loginsuccess = 	isElementPresent(PPHomePageOR.REQUEST_AN_APPOINTMENT);
		

		if (loginsuccess){
			test.log(LogStatus.INFO, "Loggin success-");
			PatientPortalHomePage pphomepage= new PatientPortalHomePage(driver,test);
			PageFactory.initElements(driver, pphomepage);
			return pphomepage;
		}	//return PageFactory.initElements(driver, PatientPortalHomePage.class);
		else{
			test.log(LogStatus.INFO, "Loggin is not success-");
			PatientPortalLoginPage pploginpage = new PatientPortalLoginPage(driver,test);
			PageFactory.initElements(driver, pploginpage);
			return pploginpage;
			//return PageFactory.initElements(driver, PatientPortalLoginPage.class);
		}
	}

}
