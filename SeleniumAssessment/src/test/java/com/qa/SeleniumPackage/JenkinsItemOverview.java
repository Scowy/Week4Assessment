package com.qa.SeleniumPackage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class JenkinsItemOverview {

	@FindBy (xpath = "//*[@id=\"tasks\"]/div[1]/a[2]")
	private WebElement backToDashButton;
	
	public void backToDashBoard() {
		backToDashButton.click();
	}
}
