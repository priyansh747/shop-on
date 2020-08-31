package com.ShopOn.BaseTest;


import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class BaseTest {

	public WebDriver driver; 
	protected static ExtentTest test;
	protected static ExtentReports report;

	
	@BeforeClass
	public static  void startTest()
	{
	report = new ExtentReports("D:\\2019"+"\\ExtentReportResults.html",false);
	System.setProperty("webdriver.chrome.driver", "D:\\2019\\chromedriver.exe"); 
	//test = report.startTest("ExtentDemo");
	}

	
	@Before 

	public void setUp(){ 

	//Initiate the Browser 





	driver = new ChromeDriver();
	 

	//Open Admin Login 

	driver.get("http://15.206.89.124:8080/shop/customer/customLogon.html"); 

	 

	} 
	
	
	
	@After
	public void tearDown() throws Exception {
		//TestResult result=new TestResult(driver);
		//System.out.println("after class");
		driver.close();
	}

	
	@AfterClass
	public static void endTest()
	{
	report.endTest(test);
	report.flush();
	}
}
