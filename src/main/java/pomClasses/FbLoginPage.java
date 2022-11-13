package pomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FbLoginPage {
	
	WebDriver driver;  // globallay declaired
	
	@FindBy (xpath="//input[@id='email']")
	private WebElement userid;
	
	@FindBy(xpath="//input[@id='pass']")
	private WebElement password;
	
	@FindBy(xpath="//button[@name='login']")
	private WebElement login;
	
		
	public FbLoginPage(WebDriver driver) {  // create constructor to open browser
        this.driver=driver;		//initiallized
		PageFactory.initElements(driver,this);
	}
	
	  
	  
	public void senduserid() throws InterruptedException
	{
		userid.sendKeys("9503464989");
		Thread.sleep(3000);
	}
	
	public void sendpassword() throws InterruptedException
	{
		password.sendKeys("apoorva9503464989");
		Thread.sleep(3000);
	}
	
	public void clickonlogin() throws InterruptedException
	{
		login.click();
		Thread.sleep(5000);
	}
	
	public String homepageurl()
	{
		String expected="https://www.facebook.com/?sk=welcome";
		return expected;
	}

  
}
