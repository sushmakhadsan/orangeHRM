package com.orange.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class Login {

	/* initializing class parameter through constructor */
	public Login(WebDriver driver) {
		super();
		PageFactory.initElements(driver, this);
	}

	/* Xpath variable declaration */
	@FindBy(xpath = "//input[@placeholder='Username']")
	public WebElement userNameXPath;

	@FindBy(xpath = "//input[@placeholder='Password']")
	public WebElement passwordXPath;

	@FindBy(xpath = "//button[normalize-space()='Login']")
	public WebElement loginbtnXPath;

	@FindBy(xpath = "//h6[normalize-space()='Dashboard']")
	public WebElement dashboardXPath;

	@FindBy(xpath = "//span[@class='oxd-userdropdown-tab']")
	public WebElement logoutdropdwnXPath;

	@FindBy(xpath = "//a[normalize-space()='Logout']")
	public WebElement logoutXPath;
	@FindBy(xpath = "//p[@class='oxd-text oxd-text--p orangehrm-login-forgot-header']")
	public WebElement forgotpwdXPath;

	@FindBy(xpath = "//input[@placeholder='Username']")
	public WebElement resetunameXPath;

	@FindBy(xpath = "//button[normalize-space()='Reset Password']")
	public WebElement resetpassbtnXPath;

	@FindBy(xpath = "//h6[@class='oxd-text oxd-text--h6 orangehrm-forgot-password-title']")
	public WebElement resetlinkmsgXPath;

	/* pass userName and password and click login button */
	public void loginHRM(String userName, String password) {
		try {
			userNameXPath.sendKeys(userName);
			Thread.sleep(1000);
			passwordXPath.sendKeys(password);
			Thread.sleep(1000);
			loginbtnXPath.click();
		} catch (Exception e) {
			System.out.println("Exception Cought" + e.getMessage());
		}
	}

	/* Verify if user login successfully */
	public void verifyloginHRM() {
		try {
			dashboardXPath.getText();
			Assert.assertEquals(dashboardXPath.getText(), "Dashboard");
		} catch (Exception e) {
			System.out.println("Exception Cought" + e.getMessage());
		}

	}

	/* forget Password input: userName */
	public void forgotPassword(String userName) {
		forgotpwdXPath.click();
		resetunameXPath.sendKeys(userName);
		resetpassbtnXPath.click();
		resetlinkmsgXPath.getText();
		Assert.assertEquals(resetlinkmsgXPath.getText(), "Reset Password link sent successfully");

	}

	public void logout() {
		logoutdropdwnXPath.click();
		logoutXPath.click();

	}

}
