package com.training.sanity.tests;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC_037 {

	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private String realUsr2;
	private String realPass2;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new LoginPOM(driver); 
		baseUrl = properties.getProperty("baseURL");
		realUsr2=properties.getProperty("realUserId2");
		realPass2=properties.getProperty("realPassword2");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
		
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(100);
		driver.quit();
	}
	
	@Test(priority =3, enabled = true )
	public void RETC_037() throws InterruptedException {
		driver.findElement(By.className("sign-in")).click();
		loginPOM.enterUserName(realUsr2);
		loginPOM.enterPassword(realPass2);
		loginPOM.clickOnLoginWithAccount();
		driver.findElement(By.linkText("Real Estate")).click();
		driver.findElement(By.linkText("Plots")).click();
		driver.findElement(By.partialLinkText("Nullam")).click();
		loginPOM.callExplicitWait();
		loginPOM.fillEnquiriesName("selenium");
		loginPOM.fillEnquiriesEmail("selenium@gmail.com");
		loginPOM.fillEnquiriesSubject("apartment");
		loginPOM.fillEnquiriesMessage("looking for apartment");
		loginPOM.clickEnquiriesSendButton();
		screenShot.captureScreenShot();
	}

	}
	
