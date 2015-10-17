package Appium_PKG;

import static org.junit.Assert.assertEquals;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Gmail {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new FirefoxDriver();

		// Accessing the Medscape URL
		driver.get("https://mail.google.com/");

		// Maximizing the window
		driver.manage().window().maximize();
		// Implicit wait method
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		// clearing the text in Username field
		driver.findElement(By.id("Email")).clear();
		driver.findElement(By.id("Email")).sendKeys("sateesh.kumar.contractor@weather.com");
		driver.findElement(By.id("next")).click();
		Thread.sleep(1000);

		String title = driver.getTitle();
		System.out.println("Title of the weather page : 1: "+title);
		
		String logoText = driver.findElement(By.xpath("//img[@alt='The Weather Channel']")).getAttribute("alt");
		System.out.println(" :2: " + logoText);
		
		/*String logoText1 = driver.findElement(By.xpath("//div[@class='logo']/img")).getAttribute("alt");
		System.out.println(" :3: " +logoText1);*/
		
		driver.findElement(By.xpath("//input[@id='user-signin']")).sendKeys("sateesh.kumar.contractor@weather.com");
		
		driver.findElement(By.xpath("//input[@id='pass-signin']")).sendKeys("10Welcome");
		
		driver.findElement(By.xpath("//input[@id='signin-button']")).click();
		
		System.out.println("Logged in into weather account");
		
		Thread.sleep(10000);
		
		String weatherAccTitle = driver.getTitle();
	    System.out.println(":4:- Weather account page: "+weatherAccTitle);
	    
		String pw = driver.getWindowHandle();
		driver.findElement(By.xpath("//div[@class='T-I J-J5-Ji T-I-KE L3']")).click();  //div[@id=':d7']/div/div //div[@class='T-I J-J5-Ji T-I-KE L3']
		System.out.println("Clicked on compose button");
		Thread.sleep(10000);
		
		Set <String> windows = driver.getWindowHandles();
		
		for ( String newwindow : windows)
		{
			/*if(!newwindow.equals(pw))
			{*/
		       driver.switchTo().window(newwindow);
		       Thread.sleep(4000);
		       System.out.println("Switched to new window of compose new mail section");
		       driver.findElement(By.name("subjectbox")).click();
		       driver.findElement(By.name("subjectbox")).sendKeys("Subject");		
			//}
			
		}		
		
		driver.close();
		driver.switchTo().window(pw);
	    String pwTitle = driver.getTitle();
	    System.out.println(pwTitle);
		Thread.sleep(1000);
	       
		
		

	}

}
