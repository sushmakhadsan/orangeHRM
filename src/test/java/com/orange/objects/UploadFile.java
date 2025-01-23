package com.orange.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UploadFile {

	public UploadFile(WebDriver driver) {
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//span[normalize-space()='PIM']")
	public WebElement PIM;

	@FindBy(xpath = "//span[@class='oxd-topbar-body-nav-tab-item']")
	public WebElement Configuration;

	@FindBy(partialLinkText = "Data")
	public WebElement DataImport;

	@FindBy(xpath = "//div[@class='oxd-file-button']")
	public WebElement Browse;

	@FindBy(xpath = "//button[normalize-space()='Upload']")
	public WebElement Upload;

	public void uploadfile() throws Exception {
		PIM.click();
		Configuration.click();
		DataImport.click();
		Browse.click();
		Thread.sleep(3000);
		Runtime.getRuntime().exec("D://learning_workspace//orangeHRM//FileUploadOrangeHrm.exe");
		Thread.sleep(3000);
		Upload.submit();

	}

}
