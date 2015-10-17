package Appium_PKG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.sikuli.script.SikuliException;

public class Sikuli {

	public static void main(String[] args) throws SikuliException, Throwable {

/*
 * 		System.setProperty("webdriver.chrome.driver", "D:\\Selenium_Stuff\\Selenium\\Files\\chromedriver_win32\\chromedriver.exe");
		   
		WebDriver driver = new ChromeDriver();*/
				
        Screen s= new Screen();  

		WebDriver driver = new FirefoxDriver();
        
		driver.get("https://www.google.co.in/");
		
		driver.manage().window().maximize();
		
		System.out.println("Browse opened successfully");
		
		Pattern gmail = new Pattern("D:\\Sikuli_Images\\Logo_gmail.PNG");
		
		Pattern email = new Pattern("D:\\Sikuli_Images\\email.PNG");
		
		Pattern next = new Pattern("D:\\Sikuli_Images\\next.PNG");
		
		Pattern password = new Pattern("D:\\Sikuli_Images\\password.PNG");
		
		Pattern signin = new Pattern("D:\\Sikuli_Images\\signin.PNG");
                   
    /*    //Thread.sleep(2000);        
        
		s.wait("Logo_gmail.PNG", 10);
          
//		s.setAutoWaitTimeout(15);
		
        s.click("Logo_gmail.PNG");
          
       // s.setAutoWaitTimeout(10);
     
        Thread.sleep(1000);
        
        s.wait("email.PNG", 10);
     
        s.type("email.PNG", "sateesh.2276");
          
        s.click("next.PNG");
          
        s.type("password.PNG", "ratnama1a%");
          
        s.click("signin.PNG");*/             

        Thread.sleep(1000);
		
        s.wait(gmail, 10);
        
        s.click(gmail);
        
        Thread.sleep(1000);  
      
        s.wait(email, 10);
      
        s.type(email, "sateesh.2276");
       
        s.click(next);
      
        s.type(password, "ratnama1a%");
          
        s.click(signin);

	}

}
