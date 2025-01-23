package com.orange.test.cases;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.orange.objects.AddEmployee;
import com.orange.objects.DeleteEmployee;
import com.orange.objects.LoginPage;
import com.orange.objects.PrintEmployeeList;
import com.orange.objects.UploadFile;
import com.orange.objects.UploadImage;

/*Common runner class*/
public class HRMTestRunner {
	/* declare variables */
	private WebDriver driver;
	private LoginPage login;
	private AddEmployee addEmployee;
	private UploadFile uploadFile;
	private UploadImage uploadImage;
	private DeleteEmployee deleteEmployee;
	private PrintEmployeeList printEmployeeList;

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

		login = new LoginPage(driver);
		addEmployee = new AddEmployee(driver);
		uploadFile = new UploadFile(driver);
		uploadImage = new UploadImage(driver);
		deleteEmployee = new DeleteEmployee(driver);
		printEmployeeList = new PrintEmployeeList(driver);
	}

	@Test(priority = 1)
	public void loginTest() throws Exception {
		/* Instance created for Login class by passing driver object */
		Thread.sleep(5000);
		login.loginHRM(userName, password);
		Assert.assertEquals(driver.getTitle(), "OrangeHRM");
	}

	@Test(priority = 2)
	public void logoutTest() {
		login.logout();

	}

	/* Forget password */
	@Test(priority = 3, enabled = false)
	public void forgotPasswordTest() {
		login.forgotPassword(userName);
	}

	@Test(priority = 4)
	public void addemployeeTest() throws Exception {
		loginTest();
		addEmployee.addemployee("devish", "kumar");
		logoutTest();

	}

	@Test(priority = 2, enabled = false)
	public void addempwithloginTest() throws Exception {
		addEmployee.addemployee("devish", "kumar");

	}

	@Test(priority = 5)
	public void searchempbynameTest() throws Exception {
		loginTest();
		addEmployee.searchempbyname("devish");
		JavascriptExecutor exector = (JavascriptExecutor) driver;
		exector.executeScript("window.scrollBy(0," + 500 + ")");
		logoutTest();
	}

	@Test(priority = 6)
	public void searchempbyidTest() throws Exception {
		loginTest();
		addEmployee.searchempbyid("0370");
		JavascriptExecutor exector = (JavascriptExecutor) driver;
		exector.executeScript("window.scrollBy(0," + 500 + ")");
		logoutTest();
	}

	@Test(priority = 7)
	public void uploadfileTest() throws Exception {
		loginTest();
		uploadFile.uploadfile();
		logoutTest();
	}

	@Test(priority = 8)
	public void uploadimageTest() throws Exception {
		loginTest();
		uploadImage.uploadimage("suvish", "sharma");
		logoutTest();
	}

	@Test(priority = 9)
	public void deleteEmployeeTest() throws Exception {
		loginTest();
		deleteEmployee.deleteEmplyee("devish");
		logoutTest();
	}

	@Test(priority = 10)
	public void printEmplyeeTest() throws Exception {
		loginTest();
		printEmployeeList.printemplist();
		logoutTest();
	}

	@Test(priority = 1, enabled = false)
	public void applyLeaveTest() {

	}

	/* execute one time after all test method run */
	@AfterTest
	public void teardown() {
		driver.quit();
	}
}
