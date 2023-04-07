package com.localhost;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PageBase {

	public static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();
	public String baseURL="http://localhost:3000";
	
	
	@BeforeClass
	public void setup() {
		//WebDriverManager.chromedriver().setup();
		//driver.set(new ChromeDriver());
		
		//WebDriverManager.firefoxdriver().setup();
		//driver.set(new FirefoxDriver());
		
		WebDriverManager.edgedriver().setup();
		driver.set(new EdgeDriver());
	}
	
	public static WebDriver getDriver() {
		// Get Driver from threadLocalmap
		return driver.get();
	}
	
	public String getPageTitle() {
		return getDriver().getTitle();
	}
	
	
	@AfterClass
	public void tearDown() {
		//getDriver().quit();
	}
}
