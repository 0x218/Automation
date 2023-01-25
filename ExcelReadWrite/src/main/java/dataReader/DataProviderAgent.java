package dataReader;

import org.testng.annotations.DataProvider;


//Extends DataProvider and sends input to get result
public class DataProviderAgent extends DataProviderBase {
	
	String inputDataFile = System.getProperty("user.dir") + "/src/test/resources/testdata/inputData.xlsx";
	
	public DataProviderAgent(String inputFile) {
		inputDataFile = inputFile;
	}
	
	@DataProvider(name = "Get_Browser_and_URL")
	public Object[][] getUrlandBrowser(){ //forgot userid asks email to notify userid
		String worksheetName = "Navigation";
		return dataFromTable (inputDataFile, worksheetName);
	}
	
	
	@DataProvider(name = "Get_UserId_Password")
	public Object[][] getUserIdPassword(){
		String worksheetName = "SiginInPage";
		return dataFromTable (inputDataFile, worksheetName);
	}
}
