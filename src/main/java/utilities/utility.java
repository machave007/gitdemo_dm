package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class utility {
	
	public static ExtentReports extent;
	public static ExtentSparkReporter spark;
	public static ExtentTest test;
	
	/*public static void takescreenshot(WebDriver driver, String filename) throws IOException
	{
		File source=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		DateTimeFormatter format= DateTimeFormatter.ofPattern("HH:MM:ss");
		String time=LocalDateTime.now().format(format);
		File dest=new File("E:\\ScreenShot-selenium\\"+filename+time+".jpg");
		FileHandler.copy(source, dest);
     }*/
	
	/*public static void  screenshot(WebDriver driver,String filename) throws IOException
	{
		File source=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		DateTimeFormatter format=DateTimeFormatter.ofPattern("HH:mm:ss");
		String time=LocalDateTime.now().format(format);
		File dest=new File("E:\\Automation\\ScreenShot\\"+filename+time+".jpg");
		FileHandler.copy(source, dest);
	}*/

	public static void capturescreenshot(WebDriver driver, String filename) throws IOException
	{
		Date d=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("ddMMYYYY_HHmmss");
		String timeStamp = sdf.format(d);
		
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE) ;
		File dest=new File("E:\\ScreenShot-selenium\\fb_login\\"+filename+timeStamp+".jpg");
		FileUtils.copyFile(src, dest);
	}
	
	public static ExtentReports getreports()  {
	   if(extent==null)	{
		   extent=new ExtentReports();
		   System.out.println(System.getProperty("user.dir"));
		   extent=new ExtentReports();
		   spark=new ExtentSparkReporter(System.getProperty("user.dir")+"\\extentreports\\");
		   spark.config().setReportName("Facebook login and homepage");
		   spark.config().setDocumentTitle("sanity suite");
		   spark.config().setTheme(Theme.DARK);
		   spark.config().setEncoding("utf-8");
		   extent.attachReporter(spark);             }
	return extent;       
	}
	   
	}
	
	
	


