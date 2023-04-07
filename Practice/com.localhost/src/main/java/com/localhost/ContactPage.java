package com.localhost;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage {
	WebDriver ldriver;
	
	@FindBy(xpath="//a[@href='https://github.com/0x218/Go/tree/master/renderHtml']")
	WebElement lnkSourceCode;
	
	@FindBy(xpath="//a[@href='https://www.linkedin.com/in/renjithsasikumar/']")
	WebElement lnkSocialMedia;
		
	public ContactPage(WebDriver rdriver){
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	public void goToSourceCode() {
		lnkSourceCode.click();
	}
	
	public void connectToSocialMedia() {
		lnkSocialMedia.click();
	}
	
	//public String getPagTile() {
	//	return ldriver.getTitle();
	//}
}
