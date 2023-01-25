package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import dataReader.ExcelLibrary;
import io.github.bonigarcia.wdm.WebDriverManager;

public class RWFromLibraryTest {

	String head1 = "Country"; 
	String head2 = "Population"; 
	String head3 = "Yearly Change"; 
	String head4 = "Net Change"; 
	String head5 = "Density"; 
	String head6 = "Land Area"; 
	String head7 = "Migrants"; 
	String head8 = "Fert. Rate"; 
	String head9 = "Med. Age"; 
	String head10 = "Urban Pop %"; 
	String head11 = "World Share";
	
	
	void setPageHeaders(ExcelLibrary writer, String sheetName) {
		writer.addColumn(sheetName, head1); 
		writer.addColumn(sheetName, head2); 
		writer.addColumn(sheetName, head3); 
		writer.addColumn(sheetName, head4); 
		writer.addColumn(sheetName, head5); 
		writer.addColumn(sheetName, head6); 
		writer.addColumn(sheetName, head7); 
		writer.addColumn(sheetName, head8); 
		writer.addColumn(sheetName, head9); 
		writer.addColumn(sheetName, head10); 
		writer.addColumn(sheetName, head11); 
	}
	

	
	@Test (priority=2)
	public void simpleWrite() {
		String inputDataFile = System.getProperty("user.dir") +"/src/test/resources/testdata/world_population.xlsx";
		System.out.println("File path is : " + inputDataFile);
		
		//The world_population.xlsx must present before execution.  This program will not create file.
		ExcelLibrary writer  = new ExcelLibrary(inputDataFile);
		
		String sheetName = "Sheet1";
		if (writer.isSheetExist(sheetName)) {
			writer.removeSheet(sheetName);
		}
		writer.addSheet(sheetName); //create fresh sheet

		String column1 = "Status";
		writer.addColumn(sheetName, column1); //create a column.
		
		writer.setCellData(sheetName, column1, 2, "Pass"); //add value in 2nd row under Column1.
		
		System.out.println("writeData Done.");
	}
	
	
	@Test (priority=2)
	public void worldPopulation() {
		String inputDataFile = System.getProperty("user.dir") +"/src/test/resources/testdata/world_population.xlsx";
		//System.out.println("File path is : " + inputDataFile);
		
		//The world_population.xlsx must present before execution.  This program will not create file.
		ExcelLibrary writer  = new ExcelLibrary(inputDataFile);
		String sheetName = "WorldPopulation";
		
		if (writer.isSheetExist(sheetName)) {
			writer.removeSheet(sheetName);
		}
		writer.addSheet(sheetName); //create fresh sheet
		setPageHeaders(writer, sheetName); //write the headers
		
		
		ThreadLocal<RemoteWebDriver> remoteDriver = new ThreadLocal<RemoteWebDriver>();
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("headless");
		remoteDriver.set( new ChromeDriver(options)); //running headless browser
		//remoteDriver.set( new ChromeDriver());
		
		remoteDriver.get().manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		remoteDriver.get().get("https://www.worldometers.info/world-population/population-by-country");	
		
		WebElement table = remoteDriver.get().findElement(By.xpath("//table[@id='example2']/tbody")); //entire table
		int rowCount = table.findElements(By.xpath("tr")).size(); //full path is //table[@id='example2']/tbody/tr.  As we are using table, we ignore table's block.
		
		//i=1 -> leaving first row of table, that is the header, but we are adding our own header.
		for(int i = 2; i <= rowCount; i++) {
			String country = table.findElement(By.xpath("tr[" + i + "]/td[2]")).getText(); // it is actually //table[@id='example2']/tbody/tr[1]/td[2]
			String population = table.findElement(By.xpath("tr[" + i + "]/td[3]")).getText(); 
			String yearlyChange = table.findElement(By.xpath("tr[" + i + "]/td[4]")).getText(); 
			String netChange = table.findElement(By.xpath("tr[" + i + "]/td[5]")).getText(); 
			String density = table.findElement(By.xpath("tr[" + i + "]/td[6]")).getText(); 
			String landArea = table.findElement(By.xpath("tr[" + i + "]/td[7]")).getText(); 
			String migrants = table.findElement(By.xpath("tr[" + i + "]/td[8]")).getText(); 
			String fertRate = table.findElement(By.xpath("tr[" + i + "]/td[9]")).getText(); 
			String medAge = table.findElement(By.xpath("tr[" + i + "]/td[10]")).getText();
			String urbanPop = table.findElement(By.xpath("tr[" + i + "]/td[11]")).getText(); 
			String worldShare = table.findElement(By.xpath("tr[" + i + "]/td[12]")).getText();
			
			
			writer.setCellData(sheetName, head1, i, country);
			writer.setCellData(sheetName, head2, i, population);
			writer.setCellData(sheetName, head3, i, yearlyChange);
			writer.setCellData(sheetName, head4, i, netChange);
			writer.setCellData(sheetName, head5, i, density);
			writer.setCellData(sheetName, head6, i, landArea);
			writer.setCellData(sheetName, head7, i, migrants);
			writer.setCellData(sheetName, head8, i, fertRate);
			writer.setCellData(sheetName, head9, i, medAge);
			writer.setCellData(sheetName, head10, i, urbanPop);
			writer.setCellData(sheetName, head11, i, worldShare);
		}
	}
}
