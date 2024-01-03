package com.pro.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageBase {

	WebDriver driver;

	public PageBase(WebDriver driver) {

		this.driver = driver;

	}

	public void doclick(WebElement element, int waittime) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waittime));
		wait.until(ExpectedConditions.elementToBeClickable(element));

	}

	public WebElement waitforElement(WebElement element, int waittime) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waittime));
		return wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public void type(WebElement element, String text) {

		element = waitforElement(element, 5);
		element.click();
		element.clear();
		element.sendKeys(text);

	}

	public void SelectdropDown(WebElement element, String text) {
		Select select = new Select(element);
		select.selectByVisibleText(text);

	}

	public void mousoveActionandClick(WebElement element) {

		Actions action = new Actions(driver);
		action.moveToElement(element).click().perform();

	}

}
