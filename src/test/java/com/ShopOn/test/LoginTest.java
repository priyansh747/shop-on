package com.ShopOn.test;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ShopOn.BaseTest.BaseTest;
import com.ShopOn.PageObjects.LoginPage;




public class LoginTest extends BaseTest {
	
	public static void startTest() {
		BaseTest.startTest();
		test = report.startTest("Valid Details TestCase");
	}
	
	public void setUp() {

		super.setUp();
	
	}
	
	
	public void tearDown() throws Exception {
		super.tearDown();
	}
	
	
	public static void endTest() {
		BaseTest.endTest();
	}
	
	
	@Test
	public void Login() {
		
		LoginPage objlogin = new LoginPage(super.driver);

		objlogin.setUserName("qwerty1");

		objlogin.setPassword("qwerty");
		objlogin.clickSubmit();
		
		
		
	}
	
	

}
