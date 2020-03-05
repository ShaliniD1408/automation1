package com.training.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

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
