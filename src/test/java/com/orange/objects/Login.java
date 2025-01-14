package com.orange.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Login {

	/* class level parameter */
	private WebDriver driver;

	/* initializing class parameter through constructor */
	public Login(WebDriver driver) {
		super();
		this.driver = driver;
	}

	/* Parameter declaration */
	By userNameXPath = By.xpath("//input[@placeholder='Username']");
	By passwordXPath = By.xpath("//input[@placeholder='Password']");
	By loginbtnXPath = By.xpath("//button[normalize-space()='Login']");
	By dashboardXPath = By.xpath("//h6[normalize-space()='Dashboard']");
	By logoutdropdwnXPath = By.xpath("//span[@class='oxd-userdropdown-tab']");
	By logoutXPath = By.xpath("//a[normalize-space()='Logout']");
	By forgotpwdXPath = By.xpath("//p[@class='oxd-text oxd-text--p orangehrm-login-forgot-header']");
	By resetunameXPath = By.xpath("//input[@placeholder='Username']");
	By resetpassbtnXPath = By.xpath("//button[normalize-space()='Reset Password']");
	By resetlinkmsgXPath = By.xpath("//h6[@class='oxd-text oxd-text--h6 orangehrm-forgot-password-title']");

	/* pass userName and password and click login button */
	public void loginHRM(String userName, String password) {
		try {
			driver.findElement(userNameXPath).sendKeys(userName);
			Thread.sleep(1000);
			driver.findElement(passwordXPath).sendKeys(password);
			Thread.sleep(1000);
			driver.findElement(loginbtnXPath).click();
		} catch (Exception e) {
			System.out.println("Exception Cought" + e.getMessage());
		}
	}

	public void verifyloginHRM() {
		try {
			driver.findElement(dashboardXPath).getText();
			Assert.assertEquals(driver.findElement(dashboardXPath).getText(), "Dashboard");
		} catch (Exception e) {
			System.out.println("Exception Cought" + e.getMessage());
		}

	}

	/* forget Password input: userName */
	public void forgotPassword(String userName) {
		driver.findElement(forgotpwdXPath).click();
		driver.findElement(resetunameXPath).sendKeys(userName);
		driver.findElement(resetpassbtnXPath).click();
		driver.findElement(resetlinkmsgXPath).getText();
		Assert.assertEquals(driver.findElement(resetlinkmsgXPath).getText(), "Reset Password link sent successfully");

	}

	public void logout() {
		driver.findElement(logoutdropdwnXPath).click();
		driver.findElement(logoutXPath).click();

	}
}
