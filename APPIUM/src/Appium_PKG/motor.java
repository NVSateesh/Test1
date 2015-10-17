package Appium_PKG;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class motor {

	public static void main(String[] args) throws Exception {
		

		//System.setProperty("webdriver.chrome.driver", "D:\\Selenium_Stuff\\Selenium\\Files\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new FirefoxDriver();
    	  //Accessing the Medscape URL
	    	driver.get("http://www.motortrend.com/");
	     //Maximizing the window
		    driver.manage().window().maximize();
	   //Implicit wait method
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			 
			//Clicking on Login Link
			driver.findElement(By.xpath("//div[@id='head-cont']/div/span[2]/span")).click();
			
		Thread.sleep(1000);
		     driver.switchTo().frame("auth2relay235753208");
		     Thread.sleep(1000);
		 	driver.findElement(By.xpath("//div[@id='signin_or_create_account']/input[2]")).click();
		     
		     
		     

	}

}
