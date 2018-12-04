package patientPortal.Test;

import java.util.Hashtable;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import com.relevantcodes.extentreports.LogStatus;

import patientPortal.BrowserLaunch.BaseTest;
import patientPortal.Page.PatientPortalHomePage;
import patientPortal.Page.PatientPortalLaunchPage;
import patientPortal.Page.PatientPortalLoginPage;
import patientPortal.Page.PatientPortalMyAccountPage;
import patientPortal.Util.PPConstant;

public class PatientPortalMyAccountTest extends BaseTest{
	String testCaseName = "AccessGrant";
	
	 Assertion assertLogin = new Assertion();
	 
	 
	//This test will create a user from My Account Section 
	@Test(dataProvider = "getData",priority =1)
	public void CreatingMyAccount(Hashtable<String,String> data) throws InterruptedException{
	
		test = extent.startTest("My Account");
		
		if (! patientPortal.Util.DataUtil.isTestExecutable(xls, testCaseName) ||  data.get(PPConstant.RUNMODE_COL).equals("N")) {
			test.log(LogStatus.SKIP, "skipping the test as the runmode of this test case is NO");
			throw new SkipException("skipping the test as the runmode of this test case is NO");
		}

		test.log(LogStatus.INFO, "Opening Browser"+data.get(PPConstant.BROWSER_COL));
		init(data.get(PPConstant.BROWSER_COL));
		
		pplaunchPage = new PatientPortalLaunchPage(driver, test);
		PageFactory.initElements(driver, pplaunchPage);
		pploginpage = pplaunchPage.goToLoginPage();
		pploginpage.enterUserName(data.get("UserName"));
		pploginpage.enterPassword(data.get("Password"));
		Object page =pploginpage.clickOnSignIn();
		
		
		Assert.assertTrue(pploginpage.verifyTitle("Home"));
		
		ppHomePage = (PatientPortalHomePage) page;
		ppHomePage.openMyAccountSection();
		ppMyAccountPage =ppHomePage.openAuthorizationPage();
		test.log(LogStatus.INFO, "Clicking on Grant Access Under My Account");
		Assert.assertTrue(ppMyAccountPage.verifyTitle("Grant Access"));
		takeScreenShot();
		
		test.log(LogStatus.INFO,"Creating New user Credientials");
		ppMyAccountPage.authorizedUserName(data.get("AutoUserName"));
		ppMyAccountPage.authorizedPassword(data.get("AutoPassword"));
		ppMyAccountPage.authorizedConfirmPassword(data.get("AutoConfimPassword"));
		ppMyAccountPage.authorizedFirstName(data.get("FirstName"));
		ppMyAccountPage.authorizedLastName(data.get("LastName"));
		ppMyAccountPage.clickOnSaveBtn();
		ppHomePage = ppMyAccountPage.clickOnNotice();
		Assert.assertTrue(ppMyAccountPage.verifyTitle("Home"));
		ppMyAccountPage.clickOnHistoryLog();
		Assert.assertTrue(ppMyAccountPage.verifyTitle("History Log"));
		ppMyAccountPage.leftMenu.logoutPath();
		Assert.assertTrue(ppMyAccountPage.verifyTitle("Log on"));
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