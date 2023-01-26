package com.w2a.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	public WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "button[ng-click='customer()']")
	public WebElement customerLoginButton;
	
	@FindBy(css = "button[ng-click='manager()']")
	public WebElement managerLoginButton;
	
	

}
