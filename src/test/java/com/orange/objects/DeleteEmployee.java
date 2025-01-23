package com.orange.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class DeleteEmployee {
	public DeleteEmployee(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[normalize-space()='PIM']")
	public WebElement PIM;

	@FindBy(xpath = "//a[normalize-space()='Employee List']")
	public WebElement EmployeeList;

	@FindBy(xpath = "(//input[@placeholder='Type for hints...'])[1]")
	public WebElement EmployeeName;

	@FindBy(xpath = "//button[normalize-space()='Search']")
	public WebElement Searchemp;

	@FindBy(xpath = "//span[normalize-space()='(1) Record Found']")
	public WebElement EmpRecords;

	@FindBy(xpath = "//i[@class='oxd-icon bi-trash']")
	public WebElement DeleteIcon;

	@FindBy(xpath = "//button[normalize-space()='Yes, Delete']")
	public WebElement YesDelete;

	@FindBy(xpath = "(//span[@class='oxd-text oxd-text--span'])[1]")
	public WebElement Records;

	public void deleteEmplyee(String ename) throws Exception {
		PIM.click();
		EmployeeList.click();
		EmployeeName.sendKeys(ename);
		Searchemp.click();
		if (!Records.getText().equals("No Records Found")) {
			Thread.sleep(2000);
			DeleteIcon.click();
			Thread.sleep(2000);
			YesDelete.click();
			Thread.sleep(2000);
			String act_msg = Records.getText();
			Assert.assertEquals(act_msg, "No Records Found");
		}

	}

}
