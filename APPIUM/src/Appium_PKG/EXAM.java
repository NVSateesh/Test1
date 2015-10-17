package Appium_PKG;

import static org.junit.Assert.assertEquals;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;

public class EXAM {

	public static void main(String[] args) throws Exception {	
/*
		Screen s= new Screen();
		Pattern p= new Pattern("");
*/		
           // Invoking Firfox browser
	    	//WebDriver driver = new FirefoxDriver();
		String filepath = "D:\\Sikuli_Images\\TestReport"+System.currentTimeMillis()+".html";
		
		ExtentReports extent = ExtentReports.get(EXAM.class);
		extent.init(filepath, true);
	     // Start Test
	    extent.startTest("Login into Medscape site and verify the logged in user first and lastname");
		/*
	    System.setProperty("webdriver.chrome.driver", "D:\\Selenium_Stuff\\Selenium\\Files\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();*/
    
		WebDriver driver = new FirefoxDriver();
		
		extent.log(LogStatus.INFO, "Browser is invoked");
	    //Accessing the Medscape URL
	    	driver.get("http://www.medscape.com/");
	    
	    	extent.log(LogStatus.INFO, "Navigated to Medscape site"); 	
	     //Maximizing the window
		    driver.manage().window().maximize();
	    	extent.log(LogStatus.INFO, "Maximized the browser");
	   //Implicit wait method
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			 
			//Assertion for Log In text on splash page
			assertEquals("Log In",driver.findElement(By.xpath("//*[@id='rightheaderlinks']/div[1]/a")).getText());

			//Clicking on Login Link
			driver.findElement(By.linkText("Log In")).click();
	    	extent.log(LogStatus.INFO, "Clicked on Login Link");
			//Getting link text of "Create a free account" using getAttribute method
			System.out.println(driver.findElement(By.linkText("Create a free account")).getAttribute("href"));
			
			// clearing the text in Username field
		     driver.findElement(By.id("userId")).clear();
		    
		    // entering the text in Username field
		     driver.findElement(By.id("userId")).sendKeys("pavanlive"); //sateeshlive
		    
		     // Capturing/Getting text from the Username field 
		     WebElement x = driver.findElement(By.id("userId"));
		     String y = x.getAttribute("value");
		     System.out.println(y);
			
			//System.out.println(driver.findElement(By.id("userId")).getAttribute("value"));

				// clearing the text in Username field
		     driver.findElement(By.id("password")).clear();
       
		      // entering the text in Password field
		     driver.findElement(By.id("password")).sendKeys("pavanlive"); //123456

		     // Capturing/Getting text from the Username field 
		     System.out.println(driver.findElement(By.id("password")).getAttribute("value"));
		
		    //Clicking on login button
			driver.findElement(By.id("loginbtn")).click();

	    	extent.log(LogStatus.INFO, "Logged in with pavanlive credentials");
	    	
		    //Getting text of the Username 
			
			String userInfo =driver.findElement(By.xpath("//*[@id='userinfo']/span")).getText();
			
			System.out.println(userInfo);
			
	    	extent.log(LogStatus.INFO, "Verifying the logged in user's first and last name");
			String Browser_Titel = driver.getTitle();
			System.out.println("Browser title of the current page is : "+Browser_Titel);
			
			String source = driver.getPageSource();
			System.out.println(driver.findElement(By.xpath("//*[@id='footercontents']/iframe[1]")).getAttribute("src"));
			String guid=driver.findElement(By.xpath("//*[@id='footercontents']/iframe[1]")).getAttribute("src");
			System.out.println(guid.substring(guid.indexOf("guid"), guid.indexOf("usp")-1));
			//Assert.assertTrue(source.contains("guid=21247460"));
	    //	Assert.assertTrue(condition);
	        // Handling the pop-up or alert using windowHandle method
			
			String beforewindow = driver.getWindowHandle();
			
			System.out.println(driver.getTitle());
			
			System.out.println("beforewindow Title"+ beforewindow);
		
			driver.findElement(By.linkText("Privacy Policy")).click();
			
		    	Set<String> windows = driver.getWindowHandles();
		    	System.out.println("windows Title" + windows);
		   
		    for(String window : windows)
			{
				if(!window.equals(beforewindow)){
			
				driver.switchTo().window(window);
				System.out.println(driver.getTitle());
				}
			}
			
//			System.out.println(driver.getTitle());
			
			driver.close();
			
			driver.switchTo().window(beforewindow);
			
			System.out.println(driver.getTitle());
			
			Thread.sleep(2000);
			
         	/*Actions action = new Actions(driver);
			action.moveToElement(driver.findElement(By.xpath("//*[@id='headerrightlinkdd']"))).click().build().perform();*/
			
			//Mouse Hover on the element with Actions class
			Actions action1 = new Actions(driver);
			action1.moveToElement(driver.findElement(By.xpath("//*[@id='rightlinksetting']/a"))).build().perform();
			
			//clicking on Log Out link
			driver.findElement(By.linkText("Log Out")).click();
			
	    	extent.log(LogStatus.INFO, "Clicking on Logout link");
			
			//To get the text on buttons[CANCEL] have to use getAttribute method.
			
            String canceltext = driver.findElement(By.id("cancellogoutbtn")).getAttribute("value");
            System.out.println(canceltext);
            
            Assert.assertEquals("Cancel",canceltext);
			
            
            //To get the text on buttons[LOGOUT], using the getAttribute method.
            
            String logouttext = driver.findElement(By.id("logoutbtn")).getAttribute("value");
            System.out.println(logouttext);

            // Clicking on Logout Button
            driver.findElement(By.id("logoutbtn")).click();
			Thread.sleep(100);
			
	    	extent.log(LogStatus.INFO, "User logged out successfully");
			//Assertion for Log In text on splash page
			//Assert.assertEquals("Log In",driver.findElement(By.xpath("//*[@id='rightheaderlinks']/div[1]/a")).getText());
			
/*			//Clicking the Register link
			driver.findElement(By.linkText("Register")).click();
			
		
			 WebElement country1 = driver.findElement(By.id("country"));
			List <WebElement> countryvalues = country1.findElements(By.tagName("option"));
			for(int i=0;i<countryvalues.size();i++){
				String values = countryvalues.get(i).getText();
				System.out.println(values);	
			} 
			    
			//Selecting the value in dropdown using Select Class			
			Select country = new Select(driver.findElement(By.id("country")));
			country.selectByValue("us");
			
			//Entering the value in FirstName field
			driver.findElement(By.id("regfnamefield")).sendKeys("firstname");
			
			//Getting all the values from the profession dropdown
			
			WebElement prof = driver.findElement(By.id("profession"));
			List <WebElement> profvl = prof.findElements(By.tagName("option"));
			for(int i=1;i<profvl.size();i++){
				String profvalues = profvl.get(i).getText();
				System.out.println(profvalues);	
			}
	*/
	   //Closing the windows
			driver.quit();
	    	extent.log(LogStatus.INFO, "Browser closed");
			 extent.endTest();
	}

	
}