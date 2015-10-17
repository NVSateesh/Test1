package Appium_PKG;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class NewTest2 extends Assert{
  @Test
  public void TestCase_2() {
	  System.out.println("TestCase_2 is executed");
	  boolean actual = true;
	  boolean expected  = false;//true; //
	try{
	  Assert.assertEquals(actual, expected);
	  System.out.println("Assertion is successfully verified and it is Passed");
	    
	} catch (Error e){
	//	System.out.println("Error : "+e);
		
		System.out.println("Assertion is successfully verified and it is Failed");

		Reporter.log("Error : " + e.getMessage());

		//Reporter.log("Error : " + e.getLocalizedMessage());
	}
	
	
	
	  /*if(actual == expected)
		  System.out.println("Assertion is successfully verified and it is Passed");
		  else
			  System.out.println("Assertion is successfully verified and it is failed");*/
		
//	Reporter
	  
  }  

}
