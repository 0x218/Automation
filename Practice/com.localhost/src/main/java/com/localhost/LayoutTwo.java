package com.localhost;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LayoutTwo  {
	WebDriver ldriver;
	
	@FindBy(xpath="//button[@onclick='alertfunction()']")
	WebElement btnAlert;
	
	@FindBy(xpath="//div[@class='tooltip']")
	WebElement ctrlToolTip;
	
	@FindBy(xpath="//button[@ondblclick='myDoubleClick()']")
	WebElement btnDoubleClick;
	
	public LayoutTwo(WebDriver rdriver){
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
		ldriver.manage().window().maximize();
	}
	
	public void clickAlertButton(boolean okButton) {
		btnAlert.click();
		
		Alert alert = ldriver.switchTo().alert();
		if (okButton) {
			alert.accept();
		}else {
			alert.dismiss();
		}
	}
	
	
	public void getToolTip() {
		//If the tooltip is defined under "title" : 
		//String toolTip = ctrlToolTip.getAttribute("title");
		//System.out.println(toolTip);
		
		//If the tooltip is defined under "class" : String toolTip = ctrlToolTip.getAttribute("title");
		Actions actions = new Actions(ldriver);
		actions.moveToElement(ctrlToolTip).perform();
		WebElement toolTipElem = ldriver.findElement(By.cssSelector(".tooltiptext"));
		String toolTipText = toolTipElem.getText();
		System.out.println(toolTipText);
	}
	
	public void doubleClickMe() {    
	      
	      Actions actions = new Actions(ldriver);
	      actions.doubleClick(btnDoubleClick).perform();;

	}
	
	public void dragAndDrop() {
		
		WebElement dragFrom = ldriver.findElement(By.xpath("//img[@id='drag1']"));
		WebElement dragTo = ldriver.findElement(By.xpath("//div[@id='div1']"));
		
	      //WebElement dragFrom = ldriver.findElement(By.id("drag1"));
	      //WebElement dragTo = ldriver.findElement(By.id("div1"));
	      Actions builder = new Actions(ldriver);
	      builder.dragAndDrop(dragFrom, dragTo).perform();
	}
}
