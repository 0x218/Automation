package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ReadFromTestNgTest {
	@Test
	@Parameters({"browser", "url"})
	
	//get input from testNG.xml
	public void navigateToURL(String browser, String url) {
		ThreadLocal<RemoteWebDriver> remoteDriver = new ThreadLocal<RemoteWebDriver>();
		WebDriverManager.firefoxdriver().setup();
		remoteDriver.set( new FirefoxDriver());
		remoteDriver.get().manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		remoteDriver.get().get(url);
	}
	
	
}
