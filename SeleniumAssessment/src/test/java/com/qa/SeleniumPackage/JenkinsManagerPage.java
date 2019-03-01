package com.qa.SeleniumPackage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class JenkinsManagerPage {

	@FindBy (xpath = "//*[@id=\"main-panel\"]/div[16]/a")
	private WebElement manageUsersButton;
	
	public void manageUsers() {
		manageUsersButton.click();
	}
}
