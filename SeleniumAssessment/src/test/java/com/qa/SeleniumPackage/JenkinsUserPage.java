package com.qa.SeleniumPackage;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

public class JenkinsUserPage {

	@FindBy(xpath = "//*[@id=\"tasks\"]/div[3]/a[2]")
	private WebElement createUserButton;

	@FindAll({ @FindBy(tagName = "td"), @FindBy(tagName = "a") })
	private List<WebElement> users = new ArrayList<>();

	public void addUser() {
		createUserButton.click();
	}

	public Boolean isUserCreater(String username) {

		for (WebElement ob : users) {

			if (ob.getText().equals(username)) {
				return true;
			}
		}
		return false;
	}
}
