package com.qa.SeleniumPackage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class JenkinsNewItemPage {

	@FindBy (xpath = "//*[@id=\"name\"]")
	private WebElement nameInput;
	
	@FindBy (xpath = "//*[@id=\"j-add-item-type-standalone-projects\"]/ul/li[1]")
	private WebElement freeStyleProj;
	
	@FindBy (xpath = "//*[@id=\"ok-button\"]")
	private WebElement okButton;
	
	public void inputNameandCreate(String name) {
		nameInput.sendKeys(name);
		freeStyleProj.click();
		okButton.click();
	}
}
