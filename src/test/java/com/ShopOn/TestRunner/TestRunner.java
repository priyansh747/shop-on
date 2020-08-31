package com.ShopOn.TestRunner;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;

import com.ShopOn.test.LoginTest;


public class TestRunner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// TODO Auto-generated method stub
		Result result=JUnitCore.runClasses(LoginTest.class);
		System.out.println(result.getRunCount());
		System.out.println(result.getFailureCount());
		System.out.println(result.getRunTime());
		//MakePDF pdf=new MakePDF(result.getRunCount(),result.getFailureCount(),result.getRunTime());
		//pdf.pdfMake();
		//Email.sendEmail();
		

	}

	}


