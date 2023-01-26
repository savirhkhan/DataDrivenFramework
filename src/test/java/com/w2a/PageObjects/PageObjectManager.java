package com.w2a.PageObjects;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {

	private WebDriver driver;
	private HomePage homePage;
	private ManagerPage managerPage;

	public PageObjectManager(WebDriver driver) {
		this.driver = driver;
	}

	public HomePage getHomePage() {
		homePage = new HomePage(driver);
		return homePage;
	}

	public ManagerPage getManagerPage() {
		managerPage = new ManagerPage(driver);
		return managerPage;
	}

}
