package Appium_PKG;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;

import io.appium.java_client.android.AndroidDriver;

public class TestAppium {

	public static void main(String[] args) throws Exception {
		
		TestAppium ssa = new TestAppium();

		//ssa.stopServer();
		
		Thread.sleep(1000);
		
		//ssa.startServer();
	
		Thread.sleep(1000);
		
System.out.println("Starting the test");
		AppiumDriver driver;

		DesiredCapabilities c = new DesiredCapabilities();

		c.setCapability("deviceName", "Samsung");
		//c.setCapability("deviceName", "SamsungGalaxyS5-4.4.4-API19-1080X1920");
		// c.setCapability("deviceName", "google_sdk"); //Android Emulator
		c.setCapability("platformVersion", "4.2.2");
		c.setCapability("platformName", "Android");
		/*
		 * c.setCapability("deviceName", "SM-G9201"); //SM-G9201 //Galaxy S6
		 * c.setCapability("platformVersion", "5.0.2");
		 *
		 *	
		driver.findElement(By.xpath("//*[@class='android.widget.Button' and @index='4']")).click();

		driver.findElement(By.id("com.flipkart.android:id/btn_skip")).click();

        driver.close();
	 */
			// File("C:\\Users\\Sateesh NV\\workspace4\\APPIUM\\FK_APK\\com.flipkart.android-3.4.0.5-APK4Fun.com.apk");
		File f = new File("D:\\com.flipkart.android-3.4.0.4-APK4Fun.com.apk");
		c.setCapability("app", f.getAbsolutePath());
		 c.setCapability("appPackage", "com.flipkart.android");
		 c.setCapability("appActivity", ".SplashActivity");
		 c.setCapability("appWaitActivity", ".SplashActivity");
		
		//driver = new AndroidDriver(new URL("http://172.16.0.5:4723/wd/hub"), c);
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),c);
		// );
		// AndroidDriver
		Thread.sleep(1258);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		Thread.sleep(20000);

		System.out.println("Flipkart app is installed/up and runnning");
		WebElement backButton  = driver.findElement(By.className("android.widget.ImageButton"));
   /*if(backButton.isDisplayed())
   {
		driver.findElement(By.className("android.widget.ImageButton")).click();
		
		System.out.println("Clicked on back button");
		
		Thread.sleep(1000);
   }*/	
		//driver.findElement(By.className("android.widget.RelativeLayout")).click();
		
		Thread.sleep(4000);
		/*
		 JavascriptExecutor js = (JavascriptExecutor) driver;
	        HashMap<String, Double> swipeObject = new HashMap<String, Double>();
	        swipeObject.put("startX", 0.50);
	        swipeObject.put("startY", 0.95);
	        swipeObject.put("endX", 0.50);
	        swipeObject.put("endY", 0.01);
	        swipeObject.put("duration", 3.0);
	        js.executeScript("mobile: swipe", swipeObject);*/
	    
		 /*int messageSent=((AppiumDriver)driver).findElements(By.className("android.widget.RelativeLayout")).size();

		 AndroidElement messageSentIndex=(AndroidElement)((AppiumDriver)driver).findElementByXPath("//android.widget.RelativeLayout[4]//android.widget.ImageView");
*/		
//		https://github.com/testvagrant/AppiumDemo/tree/master/src/test/java/scenarios
		WebElement element=driver.findElementByClassName("android.widget.LinearLayout[@index:3]");   //(By.className("android.widget.LinearLayout"));	//android.widget.ImageView
		JavascriptExecutor js = (JavascriptExecutor) driver;
		HashMap<String, String> scrollObject = new HashMap<String, String>();
		scrollObject.put("direction", "down");
		scrollObject.put("element", ((RemoteWebElement) element).getId());
		js.executeScript("mobile: scroll", scrollObject);	

	}
	
	public void stopServer() throws Exception{

		System.out.println("Stopping the Appium Server");
		
		Process q = Runtime.getRuntime().exec("cmd /c echo off & FOR /F \"usebackq tokens=5\" %a in (`netstat -nao ^| findstr /R /C:\"4723\"`) do (FOR /F \"usebackq\" %b in (`TASKLIST /FI \"PID eq %a\" ^| findstr /I node.exe`) do taskkill /F /PID %a)");
		
		System.out.println("Appium Server is stopped");
		
		Thread.sleep(20000);
	}
	
	public void startServer() throws Exception{
	System.out.println("Starting the Appium Server through code");
	
	Process p = Runtime.getRuntime().exec("\"C:/Program Files (x86)/Appium/node.exe\" \"C:/Program Files (x86)/Appium/node_modules/appium/bin/appium.js\" --no-reset --local-timezone");

	System.out.println("AppiumServer is Started");
	
	Thread.sleep(40000);
	}
	

    
}
