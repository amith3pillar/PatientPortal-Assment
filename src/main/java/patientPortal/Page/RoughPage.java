package patientPortal.Page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class RoughPage {
static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", "D:\\Selenium\\MavenWorkspace\\PageObjectModel_Not_PageFactory\\Drivers\\GeckoDriver\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("https://gmedbuild01.gmed.com/PatientPortal/Develop/Router");
		driver.manage().window().maximize();
		
		driver.findElement(By.id("UserName")).sendKeys("auto15");
		driver.findElement(By.id("Password")).sendKeys("a@123");
		driver.findElement(By.xpath("//*[@type='submit']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[@class='row']//div[5]//a[1]")).click();

		driver.findElement(By.xpath("//input[@id='emailOption1']")).click();
		//driver.findElement(By.xpath("//a[contains(text(),'My Account')]")).click();
		
		/*WebElement x=driver.findElement(By.xpath("//a[contains(text(),'My Account')]"));
		System.out.println(x);
		driver.findElement(By.xpath("//li[contains(text(),'My Account')]")).click();*/
	//driver.findElement(By.xpath("//button[@id='sendNewButton']")).click();
	
	}

}
