package com.qa.SeleniumPackage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class JenkinsCreatingUserPage {

	@FindBy(name = "username")
	private WebElement usernameInput;

	@FindBy(name = "password1")
	private WebElement passwordInput;

	@FindBy(name = "password2")
	private WebElement confirmPasswordInput;

	@FindBy(name = "fullname")
	private WebElement fullNameInput;

	@FindBy(name = "email")
	private WebElement emailInput;

	@FindBy(id = "yui-gen1-button")
	private WebElement createButton;

	public void createUser(String username, String password, String confirmPassword, String fullname, String email) throws InterruptedException {
		usernameInput.sendKeys(username);
		Thread.sleep(150);
		passwordInput.sendKeys(password);
		Thread.sleep(150);
		confirmPasswordInput.sendKeys(confirmPassword);
		Thread.sleep(150);
		fullNameInput.sendKeys(fullname);
		Thread.sleep(150);
		emailInput.sendKeys(email);
		Thread.sleep(150);
		createButton.click();
	}

}
