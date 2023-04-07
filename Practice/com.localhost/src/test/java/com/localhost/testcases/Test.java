package com.localhost.testcases;

import com.localhost.ContactPage;
import com.localhost.LayoutTwo;
import com.localhost.LoginPage;
import com.localhost.PageBase;

public class Test extends PageBase{
	@org.testng.annotations.Test
	public void doIt() {
		getDriver().get("http://localhost:3000");
		
//		ContactPage contactPage = new ContactPage(getDriver());
//		contactPage.goToSourceCode();
//		contactPage.connectToSocialMedia();
		
		LayoutTwo layout2 = new LayoutTwo(getDriver());
		//layout2.doubleClickMe();
		//layout2.clickAlertButton(true);
		//layout2.getToolTip();
		layout2.dragAndDrop();
	}
}
