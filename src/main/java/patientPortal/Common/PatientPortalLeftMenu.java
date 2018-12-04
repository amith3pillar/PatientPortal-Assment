package patientPortal.Common;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

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

	@FindBy(xpath = PPLeftMenuOR.LOG_OFF_LOADER)
	public WebElement loader;

	WebDriver driver;

	public PatientPortalLeftMenu(WebDriver driver) {
		this.driver = driver;
	}

	public void logoutPath() throws InterruptedException {
		Wait(Logout);
		boolean logoutbtnPresent = isElementPresent(PPLeftMenuOR.LOG_OFF);
		if (logoutbtnPresent) {
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


	public void Wait(WebElement element) {
		try {
			
			long timeoutInSeconds = 50000;
			driver.navigate().refresh();
			new WebDriverWait(driver, timeoutInSeconds).until(ExpectedConditions.elementToBeClickable(Logout));
			
		} catch (Exception e) {
			System.out.println("Waited for too long time........");
		}
	}
	
	
/*	public void Wait(WebElement element) {
		try {
			long timeoutInSeconds = 5000;

			WebElement logOffIcon_WE = driver.findElement(By.xpath("//a[@class='icon-background menu-icon-logout']"));
			new WebDriverWait(driver, timeoutInSeconds).until(ExpectedConditions.attributeToBe(logOffIcon_WE, "href",
					"/PatientPortal/Develop/PP/Account/LogOff"));

		} catch (Exception e) {
			System.out.println("Waited for too long time........");
		}
	}*/
}
