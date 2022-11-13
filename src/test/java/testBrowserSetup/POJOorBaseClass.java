package testBrowserSetup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class POJOorBaseClass {
	
	public static WebDriver openchromebrowser()
	{
		System.setProperty("webdriver.chrome.driver","E:\\Selenium\\ChromeDriver Letest\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
	    driver.manage().window().maximize();
	    return driver;
	}

}
