package patientPortal.BrowserLaunch;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import patientPortal.Page.PatientPortalHomePage;
import patientPortal.Page.PatientPortalLaunchPage;
import patientPortal.Page.PatientPortalLoginPage;
import patientPortal.Page.PatientPortalMyAccountPage;
import patientPortal.Page.PatientPortalUpdateInformationPage;
import patientPortal.Util.ExtentManager;
import patientPortal.Util.PPConstant;
import patientPortal.Util.Xls_Reader;

public class BaseTest {

	
	public ExtentReports extent= ExtentManager.getInstance();
	
	public ExtentTest test;
	public  WebDriver driver;
	public Xls_Reader xls= new Xls_Reader(PPConstant.DATA_XLS_PATH);
	public  WebDriverWait wait;
	public PatientPortalLaunchPage pplaunchPage ;
	public PatientPortalLoginPage pploginpage;
	public PatientPortalHomePage ppHomePage;
	public PatientPortalMyAccountPage	ppMyAccountPage;
	public PatientPortalUpdateInformationPage ppUpdateInformation;

	public void init(String bType) {
		if (bType.equalsIgnoreCase("Mozilla")) {
			System.setProperty("webdriver.gecko.driver",PPConstant.MOZILLA_DRIVER);
			driver = new FirefoxDriver();
		} else if (bType.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver",PPConstant.CHROME_DRIVER);
			driver = new ChromeDriver();

		} else if (bType.equalsIgnoreCase("IE")) {
			System.setProperty("webdriver.ie.driver",PPConstant.INTERNET_DRIVER);
			driver = new InternetExplorerDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	
	}
	
	
	public void reportFailure(String failureMessage){
		test.log(LogStatus.FAIL, "Failing the test");
		takeScreenShot();
		Assert.fail(failureMessage);
	}
	

public void takeScreenShot(){
		
		//Below line will add the screen shot in the log
	//	test.log(LogStatus.INFO,test.addScreenCapture("C:\\Users\\amit.haldar\\Desktop\\test.png"));
		
		Date d = new Date();
		System.out.println(d);
		String screenShot = d.toString().replace(":", "_").replace(" ", "_") + ".png";
		String filePath = PPConstant.REPORT_PATH + "ScreenImages//" + screenShot;
		// Folder\\"+screenShot;

		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {

			FileUtils.copyFile(scrFile, new File(filePath));
		} catch (IOException e) {
			e.printStackTrace();
		}

		test.log(LogStatus.INFO, test.addScreenCapture(filePath));
		
	}
/*
//Assertion method which will verify the title
public  boolean verifyTitle(String expectedTitle){
	//boolean isTitlePresent=false;
	String text=driver.getTitle();
	System.out.println("The Title is-"+text);
	if(text.contains(expectedTitle)){
		return true;
	}
	else{
		return false;
	}
	
}*/



}
