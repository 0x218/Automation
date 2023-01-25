package test;

import org.testng.annotations.Test;

import dataReader.DataProviderAgent;

public class ReadFromDataProviderTest {
	@Test(
			dataProvider = "Get_UserId_Password", dataProviderClass =  DataProviderAgent.class
			)
	public void getUserIdPassword(String[] strArray) throws Throwable {	
		for (int i = 0; i < strArray.length; i++) {
			System.out.println( i + " -> " + strArray[i]);
		}	
	}
}
