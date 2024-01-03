package com.pro.pages;

import java.awt.Desktop;
import java.io.File;
import java.lang.reflect.Method;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.pro.Utilities.BrowserFactory;
import com.pro.Utilities.ConfigDataProvider;
import com.pro.Utilities.ExcelDataProvider;
import com.pro.Utilities.Utill;

public class TestBase {

	public WebDriver driver;
	public ConfigDataProvider config;
	public ExcelDataProvider excel;
	
	
	
	
	//public static ExtentReports extentReportes;
	//public static ExtentTest extenttest;

	public static ExtentReports extentreports;
	public static ExtentTest extenttest;
	
	
	
	
	
	
	
	
	
	
	
	
	@BeforeSuite
	public void SetupSuit() {

		config = new ConfigDataProvider();
		excel = new ExcelDataProvider();
		
		//extentReportes = new ExtentReports();
		//ExtentSparkReporter sparkreporter = new ExtentSparkReporter("./Reports/report.html");
		//sparkreporter.config().setReportName("Bank Test");
		//extentReportes.attachReporter(sparkreporter);
		//extentReportes.setSystemInfo("OS", System.getProperty("OS.name"));
		//extentReportes.setSystemInfo("Java version ", System.getProperty("Java.version"));
		
		extentreports=new ExtentReports();
		ExtentSparkReporter sparkreporter=new ExtentSparkReporter("./Reports/report.html") ;
		sparkreporter.config().setReportName("Bank Test");
		extentreports.attachReporter(sparkreporter);
		extentreports.setSystemInfo("OS", System.getProperty("OS.name"));
		extentreports.setSystemInfo("Java version", System.getProperty("Java.version"));
		
		
		
		
		
		
	}

	@AfterSuite
	public void AfterSuit() throws Exception {
		//extentReportes.flush();
		//Desktop.getDesktop().open(new File("./Reports/report.html"));

		extentreports.flush();
		Desktop.getDesktop().open(new File("./Reports/report.html"));
		
		
		
		
	}
    
	@Parameters("browserName")
	@BeforeTest
	public void setupBrowser(String browserName, ITestContext contex) {

		// driver = BrowserFactory.LaunchApplication(driver, config.getbrowser(),
		// config.getUrl());
		driver = BrowserFactory.LaunchApplication(driver, browserName, config.getUrl());

		
		
		Capabilities capabilities=((RemoteWebDriver)driver).getCapabilities();
		
		String device=capabilities.getBrowserName()+"_"+capabilities.getBrowserVersion();
		String author=contex.getCurrentXmlTest().getParameter("author");
		
		extenttest=extentreports.createTest(contex.getName());

		extenttest.assignAuthor(author);
		extenttest.assignDevice(device);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		//Capabilities capabilities = ((RemoteWebDriver) driver).getCapabilities();
		//String device = capabilities.getBrowserName() + "_" + capabilities.getBrowserVersion();
		//String author = contex.getCurrentXmlTest().getParameter("author");
		//extenttest = extentReportes.createTest(contex.getName());

		//extenttest.assignAuthor(author);
		//extenttest.assignDevice(device);

	}

	@AfterTest
	public void closebrowser() {

		BrowserFactory.Teardown(driver);

	}

	@AfterMethod
	public void Teardown(ITestResult result, Method m) {
		// if (result.getStatus() == ITestResult.FAILURE);
		// Utill.capturescreenshot(driver,m.getName());
		if (result.getStatus() == ITestResult.FAILURE) {
			extenttest.fail(m.getName() + "failed");
			Utill.capturescreenshot(driver, m.getName());
			extenttest.fail(m.getName() + "failed");
			extenttest.fail(result.getThrowable());

		} else if (result.getStatus() == ITestResult.SUCCESS) {
			extenttest.pass(m.getName() + "pass");
			Utill.capturescreenshot(driver, m.getName());

		} else if (result.getStatus() == ITestResult.SKIP) {
			extenttest.skip(m.getName() + "skipped");

		}
		extenttest.assignCategory(m.getAnnotation(org.testng.annotations.Test.class).groups());
		// extenttest.assignCategory(m.getAnnotation(Test.class).groups());
	}

}
