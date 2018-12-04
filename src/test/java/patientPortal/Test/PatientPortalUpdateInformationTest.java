package patientPortal.Test;

import java.awt.AWTException;
import java.util.Hashtable;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import patientPortal.BrowserLaunch.BaseTest;
import patientPortal.Page.PatientPortalHomePage;
import patientPortal.Page.PatientPortalLaunchPage;
import patientPortal.Page.PatientPortalLoginPage;
import patientPortal.Page.PatientPortalUpdateInformationPage;
import patientPortal.Util.PPConstant;

public class PatientPortalUpdateInformationTest extends BaseTest {
	String testCaseName = "UpdateInformationEnterEmail";

	@Test(dataProvider = "getData", groups = { "email" }, priority = 1)
	public void addWorkEmailId(Hashtable<String, String> data) throws InterruptedException, AWTException {
		test = extent.startTest("Update Information page");
		if (!patientPortal.Util.DataUtil.isTestExecutable(xls, testCaseName)
				|| data.get(PPConstant.RUNMODE_COL).equals("N")) {
			test.log(LogStatus.SKIP, "skipping the test as the runmode of this test case is NO");
			throw new SkipException("skipping the test as the runmode of this test case is NO");
		}

		test.log(LogStatus.INFO, "Opening Browser" + data.get("Browser"));
		init(data.get("Browser"));

		pplaunchPage = new PatientPortalLaunchPage(driver, test);
		PageFactory.initElements(driver, pplaunchPage);
		pploginpage = pplaunchPage.goToLoginPage();
		pploginpage.enterUserName(PPConstant.PROD_USERNAME);
		pploginpage.enterPassword(PPConstant.PROD_PASSWORD);

		Object page = 	pploginpage.clickOnSignIn();
		if (page instanceof PatientPortalLoginPage)
			Assert.fail("Login failed ");
		else if (page instanceof PatientPortalHomePage)
			System.out.println("Logged in successfully");

		ppHomePage = (PatientPortalHomePage) page;
		ppUpdateInformation = ppHomePage.navigatetoUpdateInformation();
		ppUpdateInformation.selectWorkEmail();
		ppUpdateInformation.clickOnEditWorkEmail();
		ppUpdateInformation.editEmailbox(data.get("WorkEmail"));
		ppUpdateInformation.clickOnUpdateBtn();
		ppUpdateInformation.clickOnSendBtn();

	}

	@Test(groups = { "email" }, priority = 2)
	public void addPersonalEmailId() throws InterruptedException, AWTException {

		ppUpdateInformation = ppHomePage.navigatetoUpdateInformation();
		ppUpdateInformation.selectWorkEmail();
		ppUpdateInformation.clickOnEditPersonalEmail();
		// ppUpdateInformation.editEmailbox(data.get("PersonalEmail"));
		ppUpdateInformation.editEmailbox(PPConstant.PERSONAL_EMAIL);
		ppUpdateInformation.clickOnUpdateBtn();
		ppUpdateInformation.clickOnSendBtn();

	}

	@Test(dependsOnMethods = { "addPersonalEmailId" }, groups = { "email" }, priority = 3)
	public void deletePersonalEmailId() throws InterruptedException {
		ppUpdateInformation = ppHomePage.navigatetoUpdateInformation();
		ppUpdateInformation.clickOnPrivateEmailDeleteBtn();
		ppUpdateInformation.clickOnSendBtn();
		//my name is 
	}
	
@Test(dependsOnMethods = { "addWorkEmailId" }, groups = { "email" }, priority = 4)
	public void doubleClickOnPatientInfromation() throws InterruptedException{
	ppUpdateInformation = ppHomePage.navigatetoUpdateInformation();
	ppUpdateInformation.myInformationSection();
		
	}
	
	

	@DataProvider
	public Object[][] getData() {
		return patientPortal.Util.DataUtil.getData(xls, testCaseName);
	}

	@AfterMethod
	public void quit() {
		if (extent != null) {
			extent.endTest(test);
			extent.flush();
		}
	}
}
