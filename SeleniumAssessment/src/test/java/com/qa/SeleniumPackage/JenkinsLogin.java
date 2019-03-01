package com.qa.SeleniumPackage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class JenkinsLogin {
	
	@FindBy (xpath = "//*[@id=\"j_username\"]")
	private WebElement username;
	
	@FindBy (xpath = "/html/body/div/div/form/div[2]/input")
	private WebElement password;
	
	@FindBy (xpath = "/html/body/div/div/form/div[3]/input")
	private WebElement submitButton;
	
	public void login() {
		username.sendKeys("admin");
		password.sendKeys("admin");
		submitButton.click();
	}
	
}
