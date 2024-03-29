// Generated by Selenium IDE
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import java.util.*;
import java.net.MalformedURLException;
import java.net.URL;
public class AllInOneTest {
  private WebDriver driver;
  private Map<String, Object> vars;
  JavascriptExecutor js;
  @Before
  public void setUp() {
    driver = new ChromeDriver();
    js = (JavascriptExecutor) driver;
    vars = new HashMap<String, Object>();
  }
  @After
  public void tearDown() {
    driver.quit();
  }
  public String waitForWindow(int timeout) {
    try {
      Thread.sleep(timeout);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    Set<String> whNow = driver.getWindowHandles();
    Set<String> whThen = (Set<String>) vars.get("window_handles");
    if (whNow.size() > whThen.size()) {
      whNow.removeAll(whThen);
    }
    return whNow.iterator().next();
  }
  @Test
  public void allInOne() {
    driver.get("http://localhost:3000/");
    driver.manage().window().setSize(new Dimension(1332, 942));
    driver.findElement(By.id("uname")).click();
    driver.findElement(By.id("uname")).sendKeys("test");
    driver.findElement(By.id("pwd")).sendKeys("test");
    driver.findElement(By.cssSelector("input:nth-child(10)")).click();
    driver.findElement(By.linkText("here")).click();
    {
      WebElement element = driver.findElement(By.cssSelector("button:nth-child(13)"));
      Actions builder = new Actions(driver);
      builder.doubleClick(element).perform();
    }
    {
      WebElement dragged = driver.findElement(By.id("drag1"));
      WebElement dropped = driver.findElement(By.id("div1"));
      Actions builder = new Actions(driver);
      builder.dragAndDrop(dragged, dropped).perform();
    }
    driver.findElement(By.id("fname")).sendKeys("Automation");
    driver.findElement(By.id("lname")).sendKeys("Practice");
    driver.findElement(By.id("male")).click();
    driver.findElement(By.id("female")).click();
    driver.findElement(By.id("other")).click();
    driver.findElement(By.id("male")).click();
    driver.findElement(By.cssSelector("form > fieldset")).click();
    {
      WebElement dropdown = driver.findElement(By.id("option"));
      dropdown.findElement(By.xpath("//option[. = 'Option 1']")).click();
    }
    {
      WebElement dropdown = driver.findElement(By.id("option"));
      dropdown.findElement(By.xpath("//option[. = 'Option 3']")).click();
    }
    {
      WebElement dropdown = driver.findElement(By.id("owc"));
      dropdown.findElement(By.xpath("//option[. = 'Option 1']")).click();
    }
    {
      WebElement dropdown = driver.findElement(By.id("owc"));
      dropdown.findElement(By.xpath("//option[. = 'Option']")).click();
    }
    {
      WebElement dropdown = driver.findElement(By.id("owc"));
      dropdown.findElement(By.xpath("//option[. = 'Option 1']")).click();
    }
    {
      WebElement dropdown = driver.findElement(By.id("owc"));
      dropdown.findElement(By.xpath("//option[. = 'Option']")).click();
    }
    driver.findElement(By.id("moption")).click();
    driver.findElement(By.name("option2")).click();
    driver.findElement(By.name("option3")).click();
    driver.findElement(By.name("option2")).click();
    driver.findElement(By.name("Options")).click();
    driver.findElement(By.name("Options")).sendKeys("Vanilla");
    driver.findElement(By.id("favcolor")).sendKeys("#f20707");
    driver.findElement(By.id("day")).sendKeys("2023-01-18");
    driver.findElement(By.id("a")).sendKeys("87");
    driver.findElement(By.id("quantity")).sendKeys("1");
    driver.findElement(By.id("quantity")).sendKeys("4");
    driver.findElement(By.id("quantity")).sendKeys("5");
    driver.findElement(By.name("message")).sendKeys("The cat was playing in the garden.The quick brown fox jumped over a lazy sheep.");
    vars.put("window_handles", driver.getWindowHandles());
    driver.findElement(By.cssSelector(".btn")).click();
    vars.put("win4355", waitForWindow(2000));
    vars.put("root", driver.getWindowHandle());
    driver.switchTo().window(vars.get("win4355").toString());
    driver.switchTo().window(vars.get("root").toString());
    driver.findElement(By.id("date")).click();
    driver.findElement(By.id("date")).sendKeys("2023-03-06");
    driver.findElement(By.id("date")).sendKeys("2023-03-23");
    driver.findElement(By.linkText("here")).click();
    driver.findElement(By.linkText("Contact")).click();
    driver.findElement(By.linkText("Home")).click();
    driver.close();
    driver.switchTo().window(vars.get("win4355").toString());
    driver.close();
  }
}
