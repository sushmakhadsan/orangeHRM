package com.orange.test.cases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.orange.objects.Login;

/*Common runner class*/
public class HRMTestRunner {
	private WebDriver driver;
	private Login login;

	private static final String userName = "Admin";
	private static final String password = "admin123";

	/*
	 * Called at once before the actual test method run created ChromDriver Object
	 * one time and will use it multiple time when necessary
	 */
	@BeforeTest
	public void beforeTest() {
		this.driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

		login = new Login(driver);
	}

	@Test(priority = 0)
	public void loginTest() throws Exception {
		/* Instance created for Login class by passing driver object */
		Thread.sleep(5000);
		login.loginHRM(userName, password);
	}

	@Test(priority = 1)
	public void verifyloginTest() {
		login.verifyloginHRM();
	}

	@Test(priority = 2)
	public void logoutTest() {
		login.logout();

	}

	/* Forget password */
	@Test(priority = 3)
	public void forgotPasswordTest() {
		login.forgotPassword(userName);
	}

	/* execute one time after all test method run */
	@AfterTest
	public void afterTest() {
		driver.quit();
	}
}
