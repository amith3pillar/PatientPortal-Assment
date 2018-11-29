package patientPortalBase;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.Assertion;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import patientPortal.Common.PatientPortalLeftMenu;
import patientPortal.Util.PPConstant;

public class BasePage {

	public WebDriver driver;
	public ExtentTest test;
	public PatientPortalLeftMenu leftMenu;
	public WebElement wait;
	Actions action;
	public BasePage() {
	}

	public BasePage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
		leftMenu = PageFactory.initElements(driver, PatientPortalLeftMenu.class);
	}

	public void Wait(WebElement element) {
		try {
			long timeoutInSeconds = 50000;
			new WebDriverWait(driver, timeoutInSeconds).until(ExpectedConditions.elementToBeClickable(element));

		} catch (Exception e) {
			System.out.println("Waited for too long time........");
		}
	}
	

/*	public void findElement(WebElement element){
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", element);
	}
*/
/*	public WebElement   getElementWithFluentWait(By element1){
		FluentWait<EventFiringWebDriver> wait = new FluentWait<EventFiringWebDriver>(driver);
		//wait.pollingEvery(200, TimeUnit.SECONDS);
		//wait.withTimeout(10, TimeUnit.SECONDS);
		wait.pollingEvery(100, TimeUnit.MILLISECONDS);
		wait.withTimeout(30, TimeUnit.SECONDS);
		wait.ignoring(NoSuchElementException.class);
		wait.ignoring(ElementNotVisibleException.class);
		Function<EventFiringWebDriver, WebElement> function = new Function<EventFiringWebDriver, WebElement>() {
			public WebElement apply(EventFiringWebDriver driver) {
				return driver.findElement(element1);
			}
		};
		return wait.until(function);

	}*/
/*
	public void sleep(WebElement element) {
		try {
			long timeout = 100;
			wait = new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOf(element));
		} catch (Exception e) {
			System.out.println("Waited for too long time........");
		}

	}
*/
	public void waitfunction(WebElement element) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@id='loadingOverlay']")));
			element.click();
		} catch (Exception e) {
			System.out.println("Waited for too long time for loading ........");
		}

	}

	/*public void ajexoverlay(WebElement element) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(
					ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='ajax-loader-overlay']")));
			element.click();
		} catch (Exception e) {
			System.out.println("Waited for too long time for loading ........");
		}
	}*/

	public String verifyText(String locator, String ExpText) {

		return "";

	}

	public boolean isElementPresent(String locator) {
		test.log(LogStatus.INFO, "Trying to find Elements->" + locator);
		int s = driver.findElements(By.xpath(locator)).size();
		if (s == 0) {
			test.log(LogStatus.INFO, "Element not found");
			return false;
		} else {
			test.log(LogStatus.INFO, "Element found");

			return true;
		}
	}

	public PatientPortalLeftMenu getLeftMenu() {
		return leftMenu;
	}

	public void takeScreenShot() {

		// Below line will add the screen shot in the log
		// test.log(LogStatus.INFO,test.addScreenCapture("C:\\Users\\amit.haldar\\Desktop\\test.png"));

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

	// Assertion method which will verify the title
	public boolean verifyTitle(String expectedTitle) {
		// boolean isTitlePresent=false;
		String text = driver.getTitle();
		System.out.println("You are in - " + text + " - Page");
		if (text.contains(expectedTitle)) {
			return true;
		} else {
			return false;
		}

	}

	/*public void fluentwait(By Locatar){
	FluentWait wait = new FluentWait(driver )
			.withTimeout(100, TimeUnit.SECONDS)
			.pollingEvery(5, TimeUnit.SECONDS)
			.ignoring(Exception.class);
	
			WebElement foo=(WebElement) wait.until(new Function<WebDriver, WebElement>() {
			public WebElement applyy(WebDriver driver) {
			return driver.findElement(By.id("foo"));
			}

			public WebElement apply(WebDriver arg0) {
				// TODO Auto-generated method stub
				return driver.findElement(Locatar);
			}
			});
	}*/
	}
