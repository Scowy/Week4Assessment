package com.qa.SeleniumPackage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class JenkinsItemDetails {

	@FindBy (xpath = "//*[@id=\"yui-gen38-button\"]")
	private WebElement saveButton;
	
	public void save() {
		saveButton.click();
	}
}
