package dataReader;

public class DataProviderBase {

	public Object[][] dataFromTable(String inputDataFile, String worksheetName){
		
		//use ExcelDataProcessor to read row/column.
		ExcelLibrary dataprovider = new ExcelLibrary(inputDataFile);
		
		int rows = dataprovider.getRowCount(worksheetName);
		int columns = dataprovider.getColumnCount(worksheetName);
		
		int actualRows = rows - 1;//ignore header
		Object[][] dataResult = new Object[actualRows][columns];
		
		for(int i = 0; i < actualRows; i++) {
			for (int j = 0; j < columns; j++) {
				dataResult[i][j] = dataprovider.getCellData(worksheetName, j, i + 2);
			}
		}
		return dataResult;
	}
	
}
