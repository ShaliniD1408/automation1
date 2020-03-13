package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class UNF_077 {

	private WebDriver driver;
	private String secondUrl;
	private String uniUsr;
	private String uniPass;
	private LoginPOM loginPOM;
	private static Properties properties;
	

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
		secondUrl = properties.getProperty("secondProjectURL");
		uniUsr=properties.getProperty("uniUserId");
		uniPass=properties.getProperty("uniPassword");
		driver.get(secondUrl);
	
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(100);
		driver.quit();
	}
	
	@Test
	public void UNF_077() throws InterruptedException, IOException {
	
		loginPOM.enterUniUserName(uniUsr);
		loginPOM.enterUniPassword(uniPass);
		loginPOM.clickUniSubmitBtn();
		loginPOM.selectingOrders();
		loginPOM.clickUniValue(); 
	    loginPOM.clickUniEdit();  
	    loginPOM.clickUniContinue();
        loginPOM.clickUniRemoveBtn();
		loginPOM.getProductNamefromExcelSheet();	
		loginPOM.getProductQuantityfromExcelSheet();
		loginPOM.clickUniAddProductBtn();
		loginPOM.clickUniContinueCartBtn();
		loginPOM.clickUniContinuePaymentBtn();
		loginPOM.clickUniContinueShippingBtn();

}
}
	
