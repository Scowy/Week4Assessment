package com.qa.SeleniumPackage;

import static org.junit.Assert.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

@RunWith(Parameterized.class)
public class ParameterizedExcel {

	@Parameters
	public static Collection<Object[]> data() throws IOException {

		FileInputStream file = new FileInputStream(Constants.EXCELFILE);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheetAt(0);

		Object[][] ob = new Object[sheet.getPhysicalNumberOfRows() - 1][5];

		for (int row = 0; row < sheet.getPhysicalNumberOfRows(); row++) {

			for (int column = 0; column < 5; column++) {
				if(row != 0) {
					ob[row - 1][column] = sheet.getRow(row).getCell(column).getStringCellValue();
				}
			}
		}
		return Arrays.asList(ob);
	}

	private String username;
	private String password;
	private String confirmPassword;
	private String fullname;
	private String email;

	public ParameterizedExcel(String username, String fullname, String password, String confirmPassword, String email) {

		this.username = username;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.fullname = fullname;
		this.email = email;
	}

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
	public void testingExcel() throws InterruptedException {
		
		JenkinsMainPage jenkHome = PageFactory.initElements(driver, JenkinsMainPage.class);
		jenkHome.manageJenkins();
		Actions action = new Actions(driver);
		action.sendKeys(Keys.PAGE_DOWN);
		Thread.sleep(500);
		JenkinsManagerPage jenkManager = PageFactory.initElements(driver, JenkinsManagerPage.class);
		jenkManager.manageUsers();
		Thread.sleep(500);
		JenkinsUserPage jenkUserPage = PageFactory.initElements(driver, JenkinsUserPage.class);
		jenkUserPage.addUser();
		Thread.sleep(500);
		JenkinsCreatingUserPage jenkinsUserMaker = PageFactory.initElements(driver, JenkinsCreatingUserPage.class);
		jenkinsUserMaker.createUser(username, password, confirmPassword, fullname, email);
		
		assertTrue("User not created", jenkUserPage.isUserCreater(username));
	}

}
