package com.orange.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ApplyLeave {

	public ApplyLeave(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(linkText = "Leave")
	public WebElement leave;
	
	@FindBy(xpath = "//a[normalize-space()='Apply']")
	public WebElement apply;
	
	public void applyLeave() {
		leave.click();
		apply.click();
		
	}
}
