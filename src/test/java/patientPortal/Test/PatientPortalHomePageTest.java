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
import patientPortal.Util.PPConstant;

public class PatientPortalHomePageTest extends BaseTest {
	String testCaseName = "HomePage";
	Assertion assertLogin = new Assertion();

	/*This Test is to Send a message to the gGastro */
	@Test(dataProvider = "getData", priority = 1)
	public void sendMessage(Hashtable<String, String> data) throws InterruptedException {
		// String testCaseName = "HomePage_SendMessage";
		test = extent.startTest("Home Page");
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

		Object page = pploginpage.doLogin(PPConstant.PROD_USERNAME, PPConstant.PROD_PASSWORD);
		if (page instanceof PatientPortalLoginPage)
			Assert.fail("Login failed ");
		else if (page instanceof PatientPortalHomePage)
			System.out.println("Logged in successfully");

		ppHomePage = (PatientPortalHomePage) page;
		Thread.sleep(3000);
		ppHomePage.send_A_Message(data.get("Subject"), data.get("Message"));
		test.log(LogStatus.PASS, "Test Passed");
		test.log(LogStatus.INFO, "Message send successfully");
		ppHomePage.takeScreenShot();
	
		Assert.assertTrue(ppHomePage.verifyTitle("Home"));
	
		ppHomePage.leftMenu.logoutPath();
		Assert.assertTrue(ppHomePage.verifyTitle("Log on"));
		

	}
	/*This Test is to send appointment request to  gGastro */
	@Test(dataProvider = "getData", priority = 2)
	public void requestAnAppointment(Hashtable<String, String> data) throws InterruptedException {

		test = extent.startTest("Home Page");
		if (!patientPortal.Util.DataUtil.isTestExecutable(xls, testCaseName)
				|| data.get(PPConstant.RUNMODE_COL).equals("N")) {
			test.log(LogStatus.SKIP, "skipping the test as the runmode of this test case is NO");
			throw new SkipException("skipping the test as the runmode of this test case is NO");
		}

		test.log(LogStatus.INFO, "Opening Browser" + data.get("Browser"));
		init(data.get("Browser"));

		PatientPortalLaunchPage pplaunchPage = new PatientPortalLaunchPage(driver, test);
		PageFactory.initElements(driver, pplaunchPage);

		PatientPortalLoginPage	pploginpage = pplaunchPage.goToLoginPage();

		Object page = pploginpage.doLogin(PPConstant.PROD_USERNAME, PPConstant.PROD_PASSWORD);
		if (page instanceof PatientPortalLoginPage)
			Assert.fail("Login failed ");
		else if (page instanceof PatientPortalHomePage)
			System.out.println("Logged in successfully");

		PatientPortalHomePage	ppHomePage = (PatientPortalHomePage) page;
		Thread.sleep(3000);
		ppHomePage.send_A_Message(data.get("Subject"), data.get("Message"));
		test.log(LogStatus.PASS, "Test Passed");
		ppHomePage.takeScreenShot();

		Assert.assertTrue(ppHomePage.verifyTitle("Home"));
		ppHomePage.leftMenu.logoutPath();
		Assert.assertTrue(ppHomePage.verifyTitle("Log on"));
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
