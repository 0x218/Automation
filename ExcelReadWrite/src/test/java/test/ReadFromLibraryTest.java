/**
 * 
 */
package test;

import org.testng.annotations.Test;

import dataReader.ExcelLibrary;

/**
 * @author DC0451K
 *
 */
public class ReadFromLibraryTest {
	@Test (priority=1)
	public void simpleRead() throws Throwable {	
		String inputDataFile = System.getProperty("user.dir") +"/src/test/resources/testdata/inputData.xlsx";
		System.out.println("File path is : " + inputDataFile);
		
		ExcelLibrary reader  = new ExcelLibrary(inputDataFile);
		
		//The excel is expected to have a sheet named "login" and atleast one field named "UserId" and some value under "UserId".
		String sheetName = "login";
		String fieldName = "UserId";
		
		//print value of row# 2 under column "UserId" 
		System.out.println(reader.getCellData(sheetName, fieldName, 2)); 
		//or //System.out.println(reader.getCellData(sheetName, 0, 2));
		
		System.out.println("printData Done.");
	}
}
