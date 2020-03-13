package com.training.pom;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPOM {
	private WebDriver driver; 
	
	public LoginPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="user_login")
	private WebElement userLogin;
	
	public void enterUserName(String userLogin){
		this.userLogin.clear();
		this.userLogin.sendKeys(userLogin);
	}
	
	@FindBy(name="pwd")
	private WebElement userPassword;
	
	public void enterPassword(String userPassword){
		this.userPassword.clear();
		this.userPassword.sendKeys(userPassword);
	}
	@FindBy (name="login")
	private WebElement loginButton;
	
	public void clickOnLoginWithAccount(){
		this.loginButton.click();
	}
	@FindBy (name="submit")
	private WebElement submitButton;
	
	public void clickOnSubmit(){
		this.submitButton.click();
	}
	
	@FindBy (id="message")
	private WebElement message;
	

	@FindBy (id="changeit")
	private WebElement clickOnChangeButton;
	
	public void clickOnChangeButton()
	{
		this.clickOnChangeButton.click();
	}
	
	public void tableTranverseToUpdateRole(String user) throws InterruptedException
	{
		List<WebElement> col = driver.findElements(By.xpath("//*[@id='wpbody-content']/div[3]/form/table/thead/tr/th"));
		System.out.println("No of columns in the table is: "+col.size());
		try
		{
		for(int i=0;i<col.size();i++)
		{
			String userna=col.get(i).getAttribute("id");
			if (userna.contentEquals("username"))
			{
				
				List<WebElement> row = driver.findElements(By.xpath("//*[@id='wpbody-content']/div[3]/form/table/tbody/tr/td/strong/a"));
				System.out.println("No of rows in the table is: "+row.size());
			for(int j=0;j<row.size();j++)
				{
					
					String name=row.get(j).getText();
					//System.out.println("Row is: "+j+" Data is: "+name);
					if(name.contentEquals(user))
					{
						int k=++j;
						int l = ++i;
						int m=++l;
						//System.out.println("c:"+l+"R:"+k);
						driver.findElement(By.xpath("//*[@id='wpbody-content']/div[3]/form/table/tbody/tr["+m+"]/th/input")).click();
						String oldrole=driver.findElement(By.xpath("//*[@id='wpbody-content']/div[3]/form/table/tbody/tr["+m+"]/td[4]")).getText();
						Select role1 = new Select(driver.findElement(By.id("new_role")));
						role1.selectByVisibleText("Agent");
						//role1.selectByVisibleText("Customer");
						clickOnChangeButton();
						//driver.findElement(By.id("changeit")).click();
						//WebElement message1=driver.findElement(By.id("message"));
						String messagestr=message.getText();
						System.out.println("Message displayed is "+messagestr);
						if(messagestr.contains("Changed roles"))
						{
							System.out.println("Role change was successful");
							
						}
						else
						{
							System.out.println("Role change was NOT successful");
						}
						String newrole=driver.findElement(By.xpath("//*[@id='wpbody-content']/div[3]/form/table/tbody/tr["+m+"]/td[4]")).getText();
						System.out.println("The role is changed from "+oldrole+" to "+newrole);	
						break;
					
					}
					
					
					
				}
							
			}
		}
		}
		catch(org.openqa.selenium.StaleElementReferenceException ex)
		{
			
		}
		
		}
	

	@FindBy(name="your-name")
	private WebElement enterName;
	@FindBy(name="your-email")
	private WebElement enterEmail;
	@FindBy(name="your-subject")
	private WebElement enterSubject;
	@FindBy(name="your-message")
	private WebElement enterMessage;
	@FindBy(xpath="//input[@type='submit']")
	private WebElement clickSend;
	
	public void fillEnquiriesName(String enterName)
	{
		this.enterName.clear();
		this.enterName.sendKeys(enterName);
	}
	public void fillEnquiriesEmail(String enterEmail)
	{
		
		this.enterEmail.clear();
		this.enterEmail.sendKeys(enterEmail);
	}
	public void fillEnquiriesSubject(String enterSubject)
	{
		this.enterSubject.clear();
		this.enterSubject.sendKeys(enterSubject);
	}
	public void fillEnquiriesMessage(String enterMessage)
	{
		this.enterMessage.clear();
		this.enterMessage.sendKeys(enterMessage);
	}
	public void clickEnquiriesSendButton()
	{
		this.clickSend.click();
	}

	
	@FindBy(xpath="//*[@id='menu-item-617']/a")
	private WebElement blogMenu;
	
	@FindBy(xpath="//input[@placeholder='Search here for Properties..']")
	private WebElement searchBox;
	
	@FindBy(id="ajaxsearchliteres1")
	private WebElement searchItemSelected;
	
	public void clickOnBlogMenu()
	{
		this.blogMenu.click();
	}
	public void enterInSearchBox(String searchItemName)
	{
		this.searchBox.sendKeys(searchItemName);
	}
	public void selectSearchItem()
	{
		this.searchItemSelected.click();
	}
	
	public void selectingOrders() throws InterruptedException{
		  driver.findElement(By.xpath("//a[@class='parent']/i[@class='fa fa-shopping-cart fa-fw']")).click();
		  callExplicitWait();

		  List<WebElement> obj = driver.findElements(By.xpath("//li[@id='sale']/ul/li"));
		  
		  String flag;
		  for(int i=0;i<obj.size();i++)
		  {
		  WebElement element = obj.get(i);
		  flag=obj.get(i).getText();
		  if(flag.equals("Orders"))
		  {
		  element.click();
		  Thread.sleep(10000);
		  break;
		  }
		  } 
		 }
	
	public void selectingCategories() throws InterruptedException{
		  driver.findElement(By.xpath("//a[@class='parent']/i[@class='fa fa-tags fa-fw']")).click();
		  callExplicitWait();
		  List<WebElement> obj = driver.findElements(By.xpath("//li[@id='catalog']/ul/li"));
		  
		  String flag;
		  for(int i=0;i<obj.size();i++)
		  {
		  WebElement element = obj.get(i);
		  flag=obj.get(i).getText();
		  if(flag.equals("Categories"))
		  {
		  element.click();
		  Thread.sleep(10000);
		  break;
		  }
		  } 
		 }
	
	public void selectingProducts() throws InterruptedException{
		  driver.findElement(By.xpath("//a[@class='parent']/i[@class='fa fa-tags fa-fw']")).click();
		  callExplicitWait();
		  List<WebElement> obj = driver.findElements(By.xpath("//li[@id='catalog']/ul/li"));
		  
		  String flag;
		  for(int i=0;i<obj.size();i++)
		  {
		  WebElement element = obj.get(i);
		  flag=obj.get(i).getText();
		  if(flag.equals("Products"))
		  {
		  element.click();
		  Thread.sleep(10000);
		  break;
		  }
		  } 
		 }
	
	public void getProductNamefromExcelSheet() throws IOException, InterruptedException{
	FileInputStream fis = new FileInputStream("C:\\Users\\SHALINID\\Desktop\\UpSkill\\Project\\Assignment 3\\Uniform - Complex Test Cases.xlsx");
	XSSFWorkbook workbook = new XSSFWorkbook(fis);
	XSSFSheet sheet = workbook.getSheetAt(2);
	String productName = sheet.getRow(79).getCell(3).getStringCellValue();
	System.out.println("Product name read from excel: "+productName);
	driver.findElement(By.name("product")).sendKeys(productName);
	callExplicitWait();
	}
	
	public void getProductQuantityfromExcelSheet() throws IOException, InterruptedException{
		FileInputStream fis = new FileInputStream("C:\\Users\\SHALINID\\Desktop\\UpSkill\\Project\\Assignment 3\\Uniform - Complex Test Cases.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(2);
	int productQuantity = (int) sheet.getRow(79).getCell(4).getNumericCellValue();
	System.out.println("Product quantity read from excel: "+productQuantity);
	 String convertProductQuantity = Integer.toString(productQuantity);
	 driver.findElement(By.name("quantity")).clear();
		driver.findElement(By.name("quantity")).sendKeys(convertProductQuantity);
		callExplicitWait();
	 
	}
	public void getCategoryNamefromExcelSheet()throws IOException{
		FileInputStream fis = new FileInputStream("C:\\Users\\SHALINID\\Desktop\\UpSkill\\Project\\Assignment 3\\Uniform - Complex Test Cases.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(2);
	String categoryName = sheet.getRow(86).getCell(2).getStringCellValue();
	System.out.println("Category Name read from excel: "+categoryName);
	  driver.findElement(By.xpath("//*[@id='input-name1']")).clear();
		driver.findElement(By.xpath("//*[@id='input-name1']")).sendKeys(categoryName);
		callExplicitWait();
	}
	public void getCategoryDescriptionfromExcelSheet()throws IOException{
		FileInputStream fis = new FileInputStream("C:\\Users\\SHALINID\\Desktop\\UpSkill\\Project\\Assignment 3\\Uniform - Complex Test Cases.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(2);
	String categoryDescriptionName = sheet.getRow(86).getCell(3).getStringCellValue();
	System.out.println("Category Description Name read from excel: "+categoryDescriptionName);
	  driver.findElement(By.xpath("//*[@class='note-editable panel-body']")).clear();
		driver.findElement(By.xpath("//*[@class='note-editable panel-body']")).sendKeys(categoryDescriptionName);
		callExplicitWait();	
	}
	public void getMetaTagTitlefromExcelSheet() throws IOException{
		FileInputStream fis = new FileInputStream("C:\\Users\\SHALINID\\Desktop\\UpSkill\\Project\\Assignment 3\\Uniform - Complex Test Cases.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(2);
	String megaTagTitle = sheet.getRow(86).getCell(4).getStringCellValue();
	System.out.println("Meta tag Title read from excel: "+megaTagTitle);
	  driver.findElement(By.xpath("//*[@id='input-meta-title1']")).clear();
		driver.findElement(By.xpath("//*[@id='input-meta-title1']")).sendKeys(megaTagTitle);
		callExplicitWait();
	}
	public void getMetaTagDescriptionfromExcelSheet()throws IOException{
		FileInputStream fis = new FileInputStream("C:\\Users\\SHALINID\\Desktop\\UpSkill\\Project\\Assignment 3\\Uniform - Complex Test Cases.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(2);
	String megaTagDescription = sheet.getRow(86).getCell(4).getStringCellValue();
	System.out.println("Category Meta Tag Description read from excel: "+megaTagDescription);
	  driver.findElement(By.xpath("//*[@id='input-meta-description1']")).clear();
		driver.findElement(By.xpath("//*[@id='input-meta-description1']")).sendKeys(megaTagDescription);
		callExplicitWait();		
	}
	public void getAddProductNamefromExcelSheet() throws IOException{
		FileInputStream fis = new FileInputStream("C:\\Users\\SHALINID\\Desktop\\UpSkill\\Project\\Assignment 3\\Uniform - Complex Test Cases.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(2);
	String addProductName = sheet.getRow(86).getCell(6).getStringCellValue();
	System.out.println("Product Name read from excel: "+addProductName);
	  driver.findElement(By.xpath("//*[@id='input-name1']")).clear();
		driver.findElement(By.xpath("//*[@id='input-name1']")).sendKeys(addProductName);
		callExplicitWait();		
	}
	public void getAddProductMetaTitlefromExcelSheet() throws IOException{
		FileInputStream fis = new FileInputStream("C:\\Users\\SHALINID\\Desktop\\UpSkill\\Project\\Assignment 3\\Uniform - Complex Test Cases.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(2);
	String addProductMetaTitle = sheet.getRow(86).getCell(7).getStringCellValue();
	System.out.println("Product MetaTitle read from excel: "+addProductMetaTitle);
	  driver.findElement(By.xpath("//*[@id='input-meta-title1']")).clear();
		driver.findElement(By.xpath("//*[@id='input-meta-title1']")).sendKeys(addProductMetaTitle);
		callExplicitWait();			
	}
	public void getAddProductLinkCategoryfromExcelSheet() throws IOException{
		FileInputStream fis = new FileInputStream("C:\\Users\\SHALINID\\Desktop\\UpSkill\\Project\\Assignment 3\\Uniform - Complex Test Cases.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(2);
	String addProductLinkCategory = sheet.getRow(86).getCell(8).getStringCellValue();
	System.out.println("Product Link Category read from excel: "+addProductLinkCategory);
	  driver.findElement(By.xpath("//*[@id='input-category']")).clear();
		driver.findElement(By.xpath("//*[@id='input-category']")).sendKeys(addProductLinkCategory);
		callExplicitWait();			
	}
	public void messageDisplayed(){
	String message1=driver.findElement(By.xpath("//*[contains(@class,'alert-success')]")).getText();
	System.out.println("Displayed Message: "+message1);
	}
	

	@FindBy(xpath="//*[@id='content']/div[1]/div/div/a[1]")
	private WebElement addCategories;
	@FindBy(xpath="//*[@type='submit']")
	private WebElement categoriesSubmit;
	@FindBy(xpath="//*[contains(@class,'fa-plus')]")
	private WebElement addCatProducts;
	@FindBy(xpath="//*[@id='form-product']/ul/li[2]/a")
	private WebElement clickOnData;
	@FindBy(xpath="//*[@id='input-model']")
	private WebElement enterModelData;
	@FindBy(xpath="//*[@id='form-product']/ul/li[3]/a")
	private WebElement clickOnLinks;
	@FindBy(xpath="//*[@type='submit']")
	private WebElement clickOnProductsSaveBtn;
	
	public void clickOnAddCategories() {
		this.addCategories.click(); 
		callExplicitWait();
	}
	
	public void clickOnCategoriesSubmit() {
		this.categoriesSubmit.click(); 
		callExplicitWait();
	}	
	
	public void clickOnAddCatProducts() {
		this.addCatProducts.click(); 
		callExplicitWait();
	}
	
	public void clickOnDataTab() {
		this.clickOnData.click(); 
		callExplicitWait();
	}
	public void clickOnLinksTab() {
		this.clickOnLinks.click(); 
		callExplicitWait();
	}
	
	public void enterModelDatafun() {
		this.enterModelData.clear();
		this.enterModelData.sendKeys("123");
		callExplicitWait();
	}
	public void clickOnProductsSaveBtnTab() {
		this.clickOnProductsSaveBtn.click(); 
		callExplicitWait();
	}
	
	@FindBy(id="button-product-add")
	private WebElement uniAddProductBtn;
	@FindBy(id="button-cart")
	private WebElement uniContinueCartBtn;
	
	@FindBy(id="button-payment-address")
	private WebElement uniContinuePaymentBtn;
	@FindBy(id="button-shipping-address")
	private WebElement uniContinueShippingBtn;
	
	public void clickUniAddProductBtn() {
		this.uniAddProductBtn.click(); 
		callExplicitWait();
	}
	public void clickUniContinueCartBtn() {
		this.uniContinueCartBtn.click(); 
		callExplicitWait();
	}
	public void clickUniContinuePaymentBtn() {
		this.uniContinuePaymentBtn.click(); 
		callExplicitWait();
	}
	public void clickUniContinueShippingBtn() {
		this.uniContinueShippingBtn.click(); 
	}
	
	
	@FindBy(xpath="(//*[@class='text-center'])[1]")
	private WebElement uniRemoveBtn;
	public void clickUniRemoveBtn() {
		this.uniRemoveBtn.click(); 
		callExplicitWait();
	}
	
	@FindBy(xpath="//*[@value='251']")
	private WebElement uniValue;
	@FindBy(xpath="//*[@data-original-title='Edit']")
	private WebElement uniEdit;
	@FindBy(id="button-customer")
	private WebElement uniContinueBtn;
	
	public void clickUniValue() {
		this.uniValue.click(); 
		callExplicitWait();
	}
	public void clickUniEdit() {
		this.uniEdit.click(); 
		callExplicitWait();
	}
	public void clickUniContinue() {
		this.uniContinueBtn.click(); 
		callExplicitWait();
	}
	
	
	@FindBy(xpath="//*[@name='username']")
	private WebElement uniUserName;
	@FindBy(xpath="//*[@name='password']")
	private WebElement uniPassword;
	@FindBy(xpath="//*[@type='submit']")
	private WebElement uniSubmit;
	
	public void enterUniUserName(String uniUserName) {
		this.uniUserName.clear();
		this.uniUserName.sendKeys(uniUserName);
		callExplicitWait();
	}
	public void enterUniPassword(String uniPassword) {
		this.uniPassword.clear();
		this.uniPassword.sendKeys(uniPassword);
		callExplicitWait();
	}
	
	public void clickUniSubmitBtn() {
		this.uniSubmit.click(); 
		callExplicitWait();
	}
	public void callExplicitWait()
	{
		WebDriverWait wait=new WebDriverWait(driver,8000);
	}
	/*@FindBy(class="sign-in")
	private WebElement signin;*/
	
	/*@FindBy(name="log")
	private WebElement usename;*/
	
	/*@FindBy(id="login")
	private WebElement userName; 
	
	@FindBy(id="password")
	private WebElement password;
	
	
	
	@FindBy(id="formLogin_submitAuth")
	private WebElement loginBtn; 
	
	public void sendUserName(String userName) {
		this.userName.clear();
		this.userName.sendKeys(userName);
	}
	
	public void sendPassword(String password) {
		this.password.clear(); 
		this.password.sendKeys(password); 
	}
	
	public void clickLoginBtn() {
		this.loginBtn.click(); 
	}
	*/
	public void clickOnLogin()
	{
		//driver.findElement(By.xpath("//*[class='sign-in']")).click();
		//this.signin.click();
	}
	public void enterUsername()
	{
		//this.usename.sendKeys("manzoor@gmail.com");
	}
}
