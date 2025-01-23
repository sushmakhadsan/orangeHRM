package com.orange.objects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PrintEmployeeList {

	public PrintEmployeeList(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[normalize-space()='PIM']")
	public WebElement pim;

	@FindBy(xpath = "//a[normalize-space()='Employee List']")
	public WebElement employeeList;

	@FindBy(xpath = "//ul[@class='oxd-pagination__ul']/li")
	public List<WebElement> paginationWebElements;

	@FindBy(xpath = "//div[@class='oxd-table-card']/div/div[4]")
	public List<WebElement> empList;

	// List<WebElement> totallinksElements=
	public void printemplist() {
		pim.click();
		employeeList.click();
		int total_links = paginationWebElements.size();
		for (int i = 0; i < total_links; i++) {
			String current_linkText = paginationWebElements.get(i).getText();
			try {
				int page = Integer.parseInt(current_linkText);
				System.out.println("Page:" + page);
				paginationWebElements.get(i).click();

				for (int j = 0; j < empList.size(); j++) {
					String lastName = empList.get(i).getText();
					System.out.println(lastName);
				}
			} catch (Exception e) {
				System.out.println("not a numbersss");
			}
		}

	}
}
