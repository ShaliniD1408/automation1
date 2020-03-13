package com.training.sanity.tests;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;

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

public class RETC_38 {

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
		screenShot = new ScreenShot(driver); 
		realUsr2=properties.getProperty("realUserId2");
		realPass2=properties.getProperty("realPassword2");
		// open the browser 
		driver.get(baseUrl);
		
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(100);
		driver.quit();
	}
	
	@Test
	public void RETC_037() throws InterruptedException {
		driver.findElement(By.className("sign-in")).click();
		loginPOM.enterUserName(realUsr2);
		loginPOM.enterPassword(realPass2);
		loginPOM.clickOnLoginWithAccount();
		driver.findElement(By.linkText("Real Estate")).click();
		loginPOM.callExplicitWait();
		loginPOM.clickOnBlogMenu();
		loginPOM.callExplicitWait();
		loginPOM.enterInSearchBox("Nullam hendrerit apartment");
		String parent=driver.getWindowHandle();
		loginPOM.selectSearchItem();
		Set<String>s1=driver.getWindowHandles();
		Iterator<String> I1= s1.iterator();
		while(I1.hasNext())
		{
 
			String child_window=I1.next();
			if(!parent.equals(child_window))
			{
				driver.switchTo().window(child_window);
    		   loginPOM.fillEnquiriesName("selenium");
			   loginPOM.fillEnquiriesEmail("selenium@gmail.com");
			   loginPOM.fillEnquiriesSubject("apartment");
			   loginPOM.fillEnquiriesMessage("looking for apartment");
			   loginPOM.clickEnquiriesSendButton();

    
			   driver.close();
   }
    
   }
		driver.switchTo().window(parent);
	}

	}
	
