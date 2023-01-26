package com.w2a.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.w2a.PageObjects.PageObjectManager;
import com.w2a.base.Interactions;
import com.w2a.base.TestBase;

public class LoginTest extends TestBase{
	
	public PageObjectManager pageobjectManager;
	public Interactions interactions;
	@Test
	public void loginAsManagerTest() throws Exception {
		log.debug("Inside Login Test!!!");
		pageobjectManager = new PageObjectManager(driver);
		pageobjectManager.getHomePage().managerLoginButton.click();
		
		interactions = new Interactions();
		Assert.assertTrue(interactions.isElementVisible(pageobjectManager.getManagerPage().addCustomerButton),"Login is not successful");
		Thread.sleep(3000);
		log.debug("Login successfully Executed");
		
	}

}
