package Appium_PKG;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class browser_mob {

	public static void main(String[] args) {
		
		WebDriver driver = new FirefoxDriver();
		/*Capabilities cap = ((RemoteWebDriver)driver).getCapabilities();
		String browser = cap.getBrowserName();
		System.out.println(browser);
		Platform OS = cap.getPlatform();
		System.out.println(OS);
		String v = cap.getVersion();
		System.out.println(v);
		String y = cap.getCapability(cap);
		System.out.println(y);
		Class<? extends Capabilities> x = cap.getClass();
		System.out.println(x);
		driver.close();
		*/
		
           Capabilities cap = ((RemoteWebDriver)driver).getCapabilities();
	
		
		/*WebDriver driver;
		DesiredCapabilities cap = new DesiredCapabilities();
		driver = new FirefoxDriver(cap);
		*/
		String browserName = cap.getBrowserName();
				System.out.println(browserName);
		
		
		String os = cap.getPlatform().toString();
		System.out.println(os);
		
		String v = cap.getVersion().toString();
		System.out.println(v);	
		
		 String x= (String) cap.getCapability(browserName);
	    System.out.println(x);
		
	    Object y = cap.getCapability(browserName);
	    System.out.println(y);
		
	    Object z = cap.getClass();
	    System.out.println(z);
	   
	    String z1 = cap.getClass().toString();
	    System.out.println(z1);
	    
	    Class<? extends Capabilities> p = cap.getClass();
	    System.out.println(z);
	    
	    driver.close();
	}

}
