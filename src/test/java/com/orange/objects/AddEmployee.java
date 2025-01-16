package com.orange.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class AddEmployee {

	public AddEmployee(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[normalize-space()='PIM']")
	public WebElement PIM;

	@FindBy(xpath = "//a[normalize-space()='Add Employee']")
	public WebElement AddEmployee;

	@FindBy(xpath = "//input[@placeholder='First Name']")
	public WebElement EmpFirstName;

	@FindBy(xpath = "//input[@placeholder='Middle Name']")
	public WebElement EmpMidName;

	@FindBy(xpath = "//input[@placeholder='Last Name']")
	public WebElement EmpLastName;

	@FindBy(xpath = "//button[normalize-space()='Save']")
	public WebElement EmpAddSaveBtn;

	@FindBy(xpath = "//span[@class='oxd-switch-input oxd-switch-input--active --label-right']")
	public WebElement CreateLoginDetailsToggle;

	@FindBy(xpath = "(//input[@class='oxd-input oxd-input--active'])[3]")
	public WebElement Username;

	@FindBy(xpath = "//input[@type='radio'][@value='1']")
	public WebElement StatusRadiobtn;

	@FindBy(xpath = "(//input[@type='password'])[1]")
	public WebElement Password;

	@FindBy(xpath = "(//input[@type='password'])[2]")
	public WebElement ConfmPassword;

	@FindBy(xpath = "//button[normalize-space()='Save']")
	public WebElement SaveBtn;

	@FindBy(xpath = "//h6[normalize-space()='Personal Details']")
	public WebElement PersonalDetailsPage;

	public void addemployee(String fname, String mname, String lname) throws Exception {
		PIM.click();
		Thread.sleep(1000);
		AddEmployee.click();
		Thread.sleep(1000);
		EmpFirstName.sendKeys(fname);
		Thread.sleep(1000);
		EmpMidName.sendKeys(mname);
		Thread.sleep(1000);
		EmpLastName.sendKeys(lname);
		Thread.sleep(1000);
		 EmpAddSaveBtn.click();
		 Thread.sleep(5000);
	}

	public void addempwithlogincredential(String UName, String pwd, String cpwd) throws Exception {
		CreateLoginDetailsToggle.click();
		Thread.sleep(1000);
		Username.sendKeys(UName);
		Thread.sleep(1000);
		boolean flag = StatusRadiobtn.isSelected();

		if (!flag) {
			// click btn
			StatusRadiobtn.click();
		}
		Password.sendKeys(pwd);
		ConfmPassword.sendKeys(cpwd);
		Thread.sleep(5000);
		SaveBtn.click();
	}

	public void verifyaddemp() {
		String confirm_msg = PersonalDetailsPage.getText();
		Assert.assertEquals("Personal Details", confirm_msg);
	}

}
