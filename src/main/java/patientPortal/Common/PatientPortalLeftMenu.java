package patientPortal.Common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import patientPortal.BrowserLaunch.BaseTest;
import patientPortal.OR.PPHomePageOR;
import patientPortal.OR.PPLeftMenuOR;
import patientPortal.Page.PatientPortalLaunchPage;
import patientPortal.Page.PatientPortalLoginPage;
import patientPortalBase.BasePage;

public class PatientPortalLeftMenu {
	@FindBy(xpath = PPLeftMenuOR.LOG_OFF)
	public WebElement Logout;

	WebDriver driver;

	public PatientPortalLeftMenu(WebDriver driver) {
		this.driver = driver;
	}

	public void logoutPath() throws InterruptedException {
//		BasePage.Wait(Logout);
		Thread.sleep(30000);
		 boolean logoutbtnPresent = isElementPresent(PPLeftMenuOR.LOG_OFF);
		 if(logoutbtnPresent){
			 Logout.click();
	
		 }
	}

	public boolean isElementPresent(String locator) {

		int s = driver.findElements(By.xpath(locator)).size();
		if (s == 0) {

			return false;
		} else {

			return true;
		}
	}
}
