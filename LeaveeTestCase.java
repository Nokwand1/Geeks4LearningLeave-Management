package Leave;

import static org.junit.Assert.*;

import java.time.Duration;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.paulhammant.ngwebdriver.NgWebDriver;

public class LeaveeTestCase {
	WebDriver driver;


	JavascriptExecutor jsDriver = (JavascriptExecutor) driver;
	NgWebDriver ngDriver = new NgWebDriver(jsDriver);
	//ngDriver.waitForAngularRequestsToFinish();

	@Before
	public void setUp() throws Exception {

		int implicitTimeout = 30;

		// Call up landing page

		String cd = "C:\\Users\\user\\Downloads\\selenium\\chromedriver_win32\\chromedriver.exe";

		System.setProperty("webdriver.chrome.driver", cd);

		driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitTimeout));

		driver.get("https://g4l-sit.netlify.app/login");

		driver.manage().window().maximize();

		// Verify that we are on the landing page 4

		String landingPageMessage = "geeks4learning";

		String errmsg1 = "Not on landing page";

		String bodytext1 = driver.findElement(By.tagName("body")).getText();

		System.out.println("bodytext=" + bodytext1);

		Assert.assertTrue(errmsg1, bodytext1.contains(landingPageMessage)); // JUnit

	}

	@After
	public void tearDown() throws Exception {

	}

	@Test
	public void LoginTest() {
		System.out.println("Successfully completed");

		driver.findElement(By.id("inputEmail4")).clear();
		driver.findElement(By.id("inputEmail4")).sendKeys("super.admin@gmail.com");

		// Navigate to the password
		driver.findElement(By.id("inputPassword4")).clear();
		driver.findElement(By.id("inputPassword4")).sendKeys("P@ssword1");

		// click login

		driver.findElement(By.xpath("/html/body/app-root/app-login/div/form/button")).click();


		// driver.quit();

	}

	@Test
	public void Test() {
		// fail("Not yet implemented");
		
		
		//Clicking on the user management button
		driver.findElement(By.xpath("/html/body/app-root/app-master-layout/app-side-nav/aside/div[2]/ul/li[4]/a")).click();


		
		
		System.out.println("Successfully viewed leave form");
		// driver.findElement(By.xpath("/html/body/app-root/app-master-layout/app-side-nav/aside/div[2]/ul/li[4]/a")).click();
	}

}
