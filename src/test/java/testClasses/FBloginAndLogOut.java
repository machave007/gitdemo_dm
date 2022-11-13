package testClasses;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.devtools.v85.browser.Browser;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import pomClasses.FbHomePage;
import pomClasses.FbLoginPage;
import testBrowserSetup.POJOorBaseClass;
import utilities.utility;

public class FBloginAndLogOut extends POJOorBaseClass {
	
	WebDriver driver;      //globally declaired
	FbLoginPage login;
	FbHomePage home;
	//utility screenshot;
	SoftAssert soft;
	public static ExtentReports extent;
	public static ExtentSparkReporter spark;
	public static ExtentTest test;
	
	@BeforeTest                               //code to open cross browser 
	@Parameters("browser")
	public void launchbrowser(String browser)
	{
		System.out.println("before Test");
		
		if (browser.equalsIgnoreCase("Chrome"))
		{
			driver = openchromebrowser();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
	}	
		
	@BeforeClass     //create objects off req.pom classes and declare them globally
	public void createobject()
	{
		System.out.println("Before class");
		login=new FbLoginPage(driver);  // initilize first then import class and then declair globally
		home=new FbHomePage(driver);
	    soft=new SoftAssert();
		//screenshot=new utility();
	    extent=utility.getreports();
		
	}
	
	@BeforeMethod
	public void userlogin() throws InterruptedException
	{
		System.out.println("before method");
		driver.get("https://www.facebook.com/");
		Thread.sleep(5000);
		login.senduserid();
		login.sendpassword();
		login.clickonlogin();
		Thread.sleep(5000);
		 
	}
	
	@Test
	public void checkavailibilityoffindfriendoption() throws IOException
	{
		soft.assertTrue(home.checkfindfriendoption(),"Find Friend option is not available");
		soft.assertAll();
		utility.capturescreenshot(driver, "findfriend");
		System.out.println("test findfriend run");
		test=extent.createTest("find friend test");
		test.log(Status.PASS,"find friends option is available on Homepage");
		
	}
	
	@Test
	public void checkhomepageurl()
	{
		soft.assertEquals(driver.getCurrentUrl(),login.homepageurl(),"Result Mismatch:Fail");
		System.out.println("test home url run");
		test=extent.createTest("verification of home page URL");
		test.log(Status.PASS,"Homepage URL is Correct");
	}
	
	@AfterMethod
	public void logout() throws IOException, InterruptedException
	{
		
		System.out.println("after method");
		home.logout();
		//screenshot.takescreenshot(driver, "logout");
	}
	
	@AfterClass
	public void clearobject()
	{
		extent.flush();
		System.out.println("after class");
		login=null;
		home=null;
		soft=null;
		//screenshot=null;
	}
	
	@AfterTest
	public void closebrowser()
	{
		System.out.println("after test");
	    driver.quit();
	    driver=null;
	    System.gc();
	
	}
	
	
}