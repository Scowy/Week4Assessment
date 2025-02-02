package com.qa.SeleniumPackage;
import static org.junit.Assert.*;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

public class JenkinsTest {
	
	ChromeDriver driver;

	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", Constants.CHROMEDRIVER);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(Constants.URLLOGIN);
		JenkinsLogin jenkLog = PageFactory.initElements(driver, JenkinsLogin.class);
		jenkLog.login();
	}
	
	@After
	public void teardown() {
		driver.quit();
	}
	
	@Test
	public void newItemTest() throws InterruptedException {
		
		String itemName = "BrandNewItem";
		
		JenkinsMainPage jenkHome = PageFactory.initElements(driver, JenkinsMainPage.class);
		jenkHome.createNewItem();
		Thread.sleep(2000);
		JenkinsNewItemPage jenkNewItemP = PageFactory.initElements(driver, JenkinsNewItemPage.class);
		jenkNewItemP.inputNameandCreate(itemName);
		JenkinsItemDetails jenkItemInfo = PageFactory.initElements(driver, JenkinsItemDetails.class);
		jenkItemInfo.save();
		JenkinsItemOverview jenkItemOV = PageFactory.initElements(driver, JenkinsItemOverview.class);
		jenkItemOV.backToDashBoard();
		assertTrue("Item was not created", jenkHome.isItemCreated(itemName));
	}	
}
