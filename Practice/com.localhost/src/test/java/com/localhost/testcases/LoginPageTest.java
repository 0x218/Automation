package com.localhost.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.localhost.LoginPage;
import com.localhost.PageBase;

public class LoginPageTest extends PageBase{
	
	@Test(priority = 1)
	public void logTest() {
		getDriver().get(baseURL);
		
		LoginPage loginPage = new LoginPage(getDriver());
		loginPage.signIn("test", "test");
		
//		loginPage.setUserName("test");
//		loginPage.setPassword("test");
//		loginPage.clickLoginButton();
		
		Assert.assertEquals("Login Success", getPageTitle());
	}
	
	@Test(priority=2)
	public void logOut() {
		LoginPage loginPage = new LoginPage(getDriver());
		loginPage.logout();
	}
}
