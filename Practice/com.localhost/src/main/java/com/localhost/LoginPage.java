package com.localhost;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver ldriver;
	
	@FindBy(id="uname")
	WebElement txtUserName;
	
	@FindBy(id="pwd")
	WebElement txtPassword;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement btnLogin;
	
	@FindBy(partialLinkText = "here")
	WebElement lnkLogout;
	
	public LoginPage(WebDriver rdriver){
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	
	public void setUserName(String uname) {
		txtUserName.sendKeys(uname);
	}
	
	public void setPassword(String pswd) {
		txtPassword.sendKeys(pswd);
	}
	
	public void clickLoginButton() {
		btnLogin.click();
	}
	
	public void signIn(String userName, String password) {
		this.setUserName(userName);
		this.setPassword(password);
		this.clickLoginButton();
	}
	
	public void logout() {
		String temp = ldriver.getTitle();
		if (ldriver.getTitle().equals("Login Success")) {
			lnkLogout.click();
		}
			
	}
}
