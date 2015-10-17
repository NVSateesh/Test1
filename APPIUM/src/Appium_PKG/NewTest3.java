package Appium_PKG;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class NewTest3 extends Assert{
  @Test
  public void TestCase_3() {
	  System.out.println("TestCase_3 is executed");
	  boolean actual = true;
	  boolean expected  = false;//true; //
	Assert.assertEquals(actual, expected);
	  
  }
}