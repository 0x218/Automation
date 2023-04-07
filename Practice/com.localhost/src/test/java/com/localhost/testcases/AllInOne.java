package com.localhost.testcases;

import com.localhost.PageBase;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

//-------------------------------
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//-------------------------------------------
public class AllInOne extends PageBase{
	  @Test
	  public void allInOne() {
	    getDriver().get("http://localhost:3000");
	    getDriver().manage().window().setSize(new Dimension(1332, 942));
	    getDriver().findElement(By.id("uname")).click();
	    getDriver().findElement(By.id("uname")).sendKeys("test");
	    getDriver().findElement(By.id("pwd")).sendKeys("test");
	    getDriver().findElement(By.cssSelector("input:nth-child(10)")).click();
	    getDriver().findElement(By.linkText("here")).click();
	    {
	      WebElement element = getDriver().findElement(By.cssSelector("button:nth-child(13)"));
	      Actions builder = new Actions(getDriver());
	      builder.doubleClick(element).perform();
	    }
	    {
	      WebElement dragged = getDriver().findElement(By.id("drag1"));
	      WebElement dropped = getDriver().findElement(By.id("div1"));
	      Actions builder = new Actions(getDriver());
	      builder.dragAndDrop(dragged, dropped).perform();  //not working correctly
	    }
	    getDriver().findElement(By.id("fname")).sendKeys("Automation");
	    getDriver().findElement(By.id("lname")).sendKeys("Practice");
	    getDriver().findElement(By.id("male")).click();
	    getDriver().findElement(By.id("female")).click();
	    getDriver().findElement(By.id("other")).click();
	    getDriver().findElement(By.id("male")).click();
	    getDriver().findElement(By.cssSelector("form > fieldset")).click();
	    {
	      WebElement dropdown = getDriver().findElement(By.id("option"));
	      dropdown.findElement(By.xpath("//option[. = 'Option 1']")).click();
	    }
	    {
	      WebElement dropdown = getDriver().findElement(By.id("option"));
	      dropdown.findElement(By.xpath("//option[. = 'Option 3']")).click();
	    }
	    {
	      WebElement dropdown = getDriver().findElement(By.id("owc"));
	      dropdown.findElement(By.xpath("//option[. = 'Option 1']")).click();
	    }
	    {
	      WebElement dropdown = getDriver().findElement(By.id("owc"));
	      dropdown.findElement(By.xpath("//option[. = 'Option']")).click();
	    }
	    {
	      WebElement dropdown = getDriver().findElement(By.id("owc"));
	      dropdown.findElement(By.xpath("//option[. = 'Option 1']")).click();
	    }
	    {
	      WebElement dropdown = getDriver().findElement(By.id("owc"));
	      dropdown.findElement(By.xpath("//option[. = 'Option']")).click();
	    }
	    getDriver().findElement(By.id("moption")).click();
	    getDriver().findElement(By.name("option2")).click();
	    getDriver().findElement(By.name("option3")).click();
	    getDriver().findElement(By.name("option2")).click();
	    getDriver().findElement(By.name("Options")).click();
	    getDriver().findElement(By.name("Options")).sendKeys("Vanilla");
	    getDriver().findElement(By.id("favcolor")).sendKeys("#f20707");
	    getDriver().findElement(By.id("day")).sendKeys("2023-01-18");
	    getDriver().findElement(By.id("a")).sendKeys("87");
	    getDriver().findElement(By.id("quantity")).sendKeys("1");
	    getDriver().findElement(By.id("quantity")).sendKeys("4");
	    getDriver().findElement(By.id("quantity")).sendKeys("5");
	    getDriver().findElement(By.name("message")).sendKeys("The cat was playing in the garden.The quick brown fox jumped over a lazy sheep.");
	    
//	    vars.put("window_handles", getDriver().getWindowHandles());
//	    getDriver().findElement(By.cssSelector(".btn")).click();
//	    vars.put("win4355", waitForWindow(2000));
//	    vars.put("root", getDriver().getWindowHandle());
//	    getDriver().switchTo().window(vars.get("win4355").toString());
//	    getDriver().switchTo().window(vars.get("root").toString());
	    
	    String originWindow = getDriver().getWindowHandle();
	    getDriver().findElement(By.cssSelector(".btn")).click();
	    WebDriverWait wait = new WebDriverWait(getDriver(), 5);
	    wait.until(ExpectedConditions.numberOfWindowsToBe(2)); //wait for the new window/tab

	    
	    //// Switch to previous tab  
	    ////you can use either - 
	    List<String> windowHandles = new ArrayList<>(getDriver().getWindowHandles());
	    System.err.println(windowHandles);
	    getDriver().switchTo().window(windowHandles.get(1));
	    ////OR
	    for (String windowHandle : getDriver().getWindowHandles()) {
	        if(!originWindow.contentEquals(windowHandle)) {
	            getDriver().switchTo().window(windowHandle);
	            break;
	        }
	    }
	    //
	    
	    

	    getDriver().findElement(By.id("date")).click();
	    getDriver().findElement(By.id("date")).sendKeys("2023-03-06");
	    getDriver().findElement(By.id("date")).sendKeys("2023-03-23");
	    getDriver().findElement(By.linkText("here")).click();
	    getDriver().findElement(By.linkText("Contact")).click();
	    getDriver().findElement(By.linkText("Home")).click();
	    getDriver().close();
	}
}
