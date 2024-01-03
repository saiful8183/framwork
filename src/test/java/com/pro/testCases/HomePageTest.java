package com.pro.testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.pro.Utilities.BrowserFactory;
import com.pro.pages.HomePage;
import com.pro.pages.TestBase;

public class HomePageTest extends TestBase {

	@Test(groups= {"Regression","Smoke","Sanity"})
	public void TestBankManagerLogin()  {
		
		extenttest.info("Browser launched");

		HomePage homepage=PageFactory.initElements(driver, HomePage.class);
		homepage.TestBankManagerLoginBtn();
		extenttest.info("Loged in as a bank manager");
		
		homepage.AddnewCustomer(excel.getStringData("Customer", 1, 0),excel.getStringData("Customer", 1, 1),excel.getStringData("Customer", 1, 2));
		
		
		extenttest.info("created a new customer");
		System.out.println(driver.switchTo().alert().getText());
		
		Assert.assertTrue(driver.switchTo().alert().getText().contains("Customer added successfully with customer id :6"));
	
			
		
		
	
	}
}