package com.qa.SeleniumPackage;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

public class JenkinsMainPage {

	@FindBy(xpath = "//*[@id=\"tasks\"]/div[1]/a[2]")
	private WebElement newItemButton;

	@FindAll({ @FindBy(className = "model-link") })
	private List<WebElement> items = new ArrayList<>();
	
	@FindBy(xpath = "//*[@id=\"tasks\"]/div[4]/a[2]")
	private WebElement manageJenkinsButton;

	public void createNewItem() {
		newItemButton.click();
	}

	public Boolean isItemCreated(String name) {

		for (WebElement ob : items) {
			if (ob.getText().equals(name)) {
				return true;
			}
		}
		return false;
	}
	
	public void manageJenkins() {
		manageJenkinsButton.click();
	}

}
