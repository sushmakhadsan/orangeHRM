package com.orange.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class UploadImage {

	public UploadImage(WebDriver driver) {
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//span[normalize-space()='PIM']")
	public WebElement PIM;

	@FindBy(xpath = "//a[normalize-space()='Add Employee']")
	public WebElement AddEmployee;

	@FindBy(xpath = "//input[@placeholder='First Name']")
	public WebElement EmpFirstName;

	@FindBy(xpath = "//input[@placeholder='Last Name']")
	public WebElement EmpLastName;

	@FindBy(xpath = "//button[@class='oxd-icon-button oxd-icon-button--solid-main employee-image-action']")
	public WebElement ImageAddButton;

	@FindBy(xpath = "//button[normalize-space()='Save']")
	public WebElement EmpAddSaveBtn;

	@FindBy(xpath = "//h6[normalize-space()='Personal Details']")
	public WebElement PersonalDetailsPage;

	public void uploadimage(String fname, String lname) throws Exception {
		PIM.click();
		AddEmployee.click();
		EmpFirstName.sendKeys(fname);
		EmpLastName.sendKeys(lname);
		ImageAddButton.click();
		Thread.sleep(5000);
		Runtime.getRuntime().exec("D://learning_workspace//orangeHRM//AddImageOrangeHRM.exe");
		Thread.sleep(5000);
		EmpAddSaveBtn.click();
		Thread.sleep(5000);
		String confirm_msg = PersonalDetailsPage.getText();
		Thread.sleep(5000);
		Assert.assertEquals("Personal Details", confirm_msg);

	}

}
