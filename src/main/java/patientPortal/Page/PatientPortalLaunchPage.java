package patientPortal.Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import patientPortal.Util.PPConstant;
import patientPortalBase.BasePage;

public class PatientPortalLaunchPage extends BasePage{
	
	//public ExtentTest test;
	public PatientPortalLaunchPage(WebDriver driver , ExtentTest test){
		super(driver,test);
		//this.test=test;
	}
	
	
	public PatientPortalLoginPage goToLoginPage(){
		
		test.log(LogStatus.INFO, "Launching Patient Portal"+PPConstant.PORTALURL );
		
		driver.get(PPConstant.PORTALURL);
	
		
		PatientPortalLoginPage pploginpage= new PatientPortalLoginPage(driver,test);
		PageFactory.initElements(driver, pploginpage);
		return pploginpage;
		
				
	}
		
}

