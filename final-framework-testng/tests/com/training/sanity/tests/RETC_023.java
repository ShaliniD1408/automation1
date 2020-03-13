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

public class RETC_023 {

	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private String realUsr1;
	private String realPass1;
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
		screenShot = new ScreenShot(driver); 
		realUsr1=properties.getProperty("realUserId1");
		realPass1=properties.getProperty("realPassword1");
		// open the browser 
		driver.get(baseUrl);
		
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(100);
		driver.quit();
	}
	

	@Test
	public void RETC_022() throws InterruptedException
	{
		driver.findElement(By.className("sign-in")).click();
		loginPOM.enterUserName(realUsr1);
		loginPOM.enterPassword(realPass1);
		loginPOM.clickOnLoginWithAccount();
		screenShot.captureScreenShot();
		String pagetitle = driver.getTitle();
		System.out.println(pagetitle);
		driver.findElement(By.linkText("Users")).click();
		driver.findElement(By.linkText("All Users")).click();
		loginPOM.tableTranverseToUpdateRole("abc1");
				
	}
	
}
