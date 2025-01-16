package com.orange.test.cases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.orange.objects.AddEmployee;
import com.orange.objects.Login;

/*Common runner class*/
public class HRMTestRunner {
	/* declare variables */
	private WebDriver driver;
	private Login login;
	private AddEmployee addemp;

	public String baseUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
	/* declare constant */
	private static final String userName = "Admin";
	private static final String password = "admin123";

	/*
	 * Called at once before the actual test method run created ChromDriver Object
	 * one time and will use it multiple time when necessary
	 */
	@BeforeTest
	public void setup() {
		this.driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(baseUrl);

		login = new Login(driver);
		addemp = new AddEmployee(driver);
	}

	@Test(priority = 0)
	public void loginTest() throws Exception {
		/* Instance created for Login class by passing driver object */
		Thread.sleep(5000);
		login.loginHRM(userName, password);
	}

	@Test(priority = 1, enabled = false)
	public void verifyloginTest() {
		login.verifyloginHRM();
	}

	@Test(priority = 2, enabled = false)
	public void logoutTest() {
		login.logout();

	}

	/* Forget password */
	@Test(priority = 3, enabled = false)
	public void forgotPasswordTest() {
		login.forgotPassword(userName);
	}

	@Test(priority = 1)
	public void addemployeeTest() throws Exception {
		addemp.addemployee("devivisvakumar12", "vishva12", "kumar12");

	}

	@Test(priority = 2)
	public void verifyaddemployeeTest() throws Exception {
		addemp.verifyaddemp();

	}

	@Test(priority = 2, enabled = false)
	public void addempwithloginTest() throws Exception {
		addemp.addemployee("devivisvakumar", "vishva", "kumar");

	}

	/* execute one time after all test method run */
	@AfterTest
	public void teardown() {
		driver.quit();
	}
}
