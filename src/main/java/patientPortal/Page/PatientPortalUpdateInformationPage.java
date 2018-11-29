package patientPortal.Page;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;

import patientPortal.OR.PPUpdateInformationOR;

import patientPortalBase.BasePage;

public class PatientPortalUpdateInformationPage extends BasePage {

	@FindBy(xpath = PPUpdateInformationOR.SLT_WORK_EMAIL)
	public WebElement sltWorkEmail;

	@FindBy(xpath = PPUpdateInformationOR.EDIT_WORK_EMAIL)
	public WebElement editWorkEmail;

	@FindBy(xpath = PPUpdateInformationOR.EDIT_PERSONAL_EMAIL)
	public WebElement editPersonalEmail;

	@FindBy(xpath = PPUpdateInformationOR.EDIT_EMAIL_BOX)
	public WebElement editEmailBox;

	@FindBy(xpath = PPUpdateInformationOR.CLK_ON_UPDATE_BTN)
	public WebElement clkUpdateBtn;

	@FindBy(xpath = PPUpdateInformationOR.CLK_ON_SEND_BTN)
	public WebElement clkSendBtn;

	@FindBy(xpath = PPUpdateInformationOR.PVT_EMAIL_DELETE_BTN)
	public WebElement PrivateEmailDeleteBTN;

	// a[@id='btnSendTop']

	public PatientPortalUpdateInformationPage(WebDriver driver, ExtentTest test) {
		super(driver, test);
	}

	// To select WorkEmail in Update Informaition Page
	public void selectWorkEmail() throws InterruptedException, AWTException {
		Wait(sltWorkEmail);
		sltWorkEmail.click();

	}

	// To click on Edit button of Work Email section
	public void clickOnEditWorkEmail() throws InterruptedException {
		Wait(editWorkEmail);
		editWorkEmail.click();
		System.out.println("Edit work email pencil clicked");
	}

	// To click on Edit button of Work Email section
	public void clickOnEditPersonalEmail() throws InterruptedException {
		Wait(editPersonalEmail);
		editPersonalEmail.click();
		System.out.println("Clicking on Edit Personal Email");
	}

	// Enter Email address
	public void editEmailbox(String editEmail) throws InterruptedException {

		Wait(editEmailBox);
		editEmailBox.clear();
		editEmailBox.sendKeys(editEmail);
		System.out.println("Clicking on Edit  Email Box");
	}

	// Click on Update button
	public void clickOnUpdateBtn() {
		clkUpdateBtn.click();
		System.out.println("Click on Update button");
	}

	// Deleting Private Email
	public void clickOnPrivateEmailDeleteBtn() throws InterruptedException {
		PrivateEmailDeleteBTN.click();
		System.out.println("Deleting Private Email ");
	}

	// Clicking on send button at the top and navigating to HomePage
	public PatientPortalHomePage clickOnSendBtn() throws InterruptedException {
		Thread.sleep(10000);
		
		/* WebDriverWait wait = new WebDriverWait(driver ,3000);

         wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='btnSendTop']")));
              // click on the compose button as soon as the "compose" button is visible
         driver.findElement(By.xpath("//a[@id='btnSendTop']")).click();
		
		*/
		
		clkSendBtn.click();
		System.out.println("Clicking on send button at the top and navigating to HomePage");
		PatientPortalHomePage ppHomePage = new PatientPortalHomePage(driver, test);
		PageFactory.initElements(driver, ppHomePage);
		return ppHomePage;

	}
}
