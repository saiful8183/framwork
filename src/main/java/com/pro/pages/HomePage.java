package com.pro.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage{

	WebDriver driver;

	public HomePage(WebDriver driver) {

		this.driver = driver;

	}

	@FindBy(xpath = "//button[@ng-click='manager()']")
	//@FindBy(xpath = "//button[@ng-click='abc()']")
	public WebElement BankManagerLogin;

	 
	
	@FindBy(xpath = "//button[@ng-class='btnClass1']")
	public WebElement AddCustomer;

	@FindBy(xpath = "//input[@ng-model='fName']")
	public WebElement FirstNmae;

	
	@FindBy(xpath = "//input[@ng-model='lName']")
	public WebElement LastName;

	@FindBy(xpath = "//input[@ng-model='postCd']")
	public WebElement PostCode;

	@FindBy(xpath = "//button[@type='submit']")
	public WebElement SubmitBtn;

	public void TestBankManagerLoginBtn() {

		BankManagerLogin.click();
		
	
	}

	public void AddnewCustomer(String FName, String LName, String ZipCode)  {

		AddCustomer.click();
		FirstNmae.sendKeys(FName);
		LastName.sendKeys(LName);
		PostCode.sendKeys(ZipCode);
		SubmitBtn.click();

	}
}
