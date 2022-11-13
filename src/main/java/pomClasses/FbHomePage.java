package pomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FbHomePage {
	WebDriver driver;
	@FindBy (xpath="//div[@aria-label='Your profile']")
     private WebElement profile;
	@FindBy (xpath="(//span[@dir='auto'])[29]")
    private WebElement logout;
	@FindBy(xpath="//span[text()='Find Friends']")
	private WebElement findfriend;

	
	public FbHomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public boolean checkfindfriendoption()
    {
    	boolean result=findfriend.isDisplayed();
    	return result;
    }

	
	public void logout() throws InterruptedException
	{
		profile.click();
		Thread.sleep(3000);
		logout.click();
		
	}
	
}
