package patientPortal.Test;

import java.util.Hashtable;

import org.jsoup.helper.DataUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import patientPortal.BrowserLaunch.BaseTest;
import patientPortal.Common.PatientPortalLeftMenu;
import patientPortal.Page.PatientPortalHomePage;
import patientPortal.Page.PatientPortalLaunchPage;
import patientPortal.Page.PatientPortalLoginPage;
import patientPortal.Util.PPConstant;


public class PatientPortalLoginTest extends BaseTest {
	String testCaseName = "LoginTest";

	/*@Test(dataProvider = "getData")
	public void testLogin(Hashtable<String,String> data) throws InterruptedException {
		
		test = extent.startTest("Login Test");
		
		if (! patientPortal.Util.DataUtil.isTestExecutable(xls, testCaseName) ||  data.get(PPConstant.RUNMODE_COL).equals("N")) {
			test.log(LogStatus.SKIP, "skipping the test as the runmode of this test case is NO");
			throw new SkipException("skipping the test as the runmode of this test case is NO");
		}

		test.log(LogStatus.INFO, "Opening Browser"+data.get(PPConstant.BROWSER_COL));
		init(data.get(PPConstant.BROWSER_COL));
		
		pplaunchPage = new PatientPortalLaunchPage(driver, test);
		PageFactory.initElements(driver, pplaunchPage);
		pploginpage = pplaunchPage.goToLoginPage();
		
		
		Object page = pploginpage.doLogin(data.get("UserName"), data.get("Password"));

		String actualResult="";
		if (page instanceof PatientPortalHomePage)
			actualResult="Success";
			else
			actualResult="Unsucessful";
			//Assert.fail("LoginFail");
			//reportFailure("Could not login with incorrect UID?PWD");
		
		if (!actualResult.equals(data.get(PPConstant.EXPECTED_RESULT_COL))){
			reportFailure("Failure message");
		}
			test.log(LogStatus.PASS, "Login test successfully");

			pploginpage.leftMenu.logoutPath();
	}	*/
			
	@Test(dataProvider = "getData")
		public void doLogin(Hashtable<String,String> data) throws InterruptedException	{

			test = extent.startTest("Login Test");
			
			if (! patientPortal.Util.DataUtil.isTestExecutable(xls, testCaseName) 
					||  data.get(PPConstant.RUNMODE_COL).equals("N")) {
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
			

			String actualResult="";
			if (page instanceof PatientPortalHomePage)
				actualResult="Success";
				else
				actualResult="Unsucessful";
				//Assert.fail("LoginFail");
				//reportFailure("Could not login with incorrect UID?PWD");
			
			if (!actualResult.equals(data.get(PPConstant.EXPECTED_RESULT_COL))){
				reportFailure("Failure message");
			}
				test.log(LogStatus.PASS, "Login test successfully");

				pploginpage.leftMenu.logoutPath();
			
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
