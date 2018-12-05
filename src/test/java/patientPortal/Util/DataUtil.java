package patientPortal.Util;

import java.util.Hashtable;

public class DataUtil {
	
	
	public static Object[][] getData(Xls_Reader xls, String testCaseName){
		String xlssheetName = PPConstant.TESTDATA_SHEET_NAME;

		int testStartRowNum = 1;
		while (!xls.getCellData(xlssheetName, 0, testStartRowNum).equals(testCaseName)) {
			testStartRowNum++;
		}
		System.out.println("Test Cases start from " + testStartRowNum);
		int colStartRowNum = testStartRowNum + 1;
		int dataValueStartRowNum = testStartRowNum + 2;

		System.out.println("" + dataValueStartRowNum);

		// Calcualte rows of data

		int rows = 0;
		while (!xls.getCellData(xlssheetName, 0, dataValueStartRowNum + rows).equals("")) {
			rows++;
		}
		System.out.println("Total number of rows " + rows);
		// Calculate total cols

		int cols = 0;
		while (!xls.getCellData(xlssheetName, cols, colStartRowNum).equals("")) {
			cols++;

		}
		System.out.println("Total number of cols " + cols);

		// create a Object Array
		Object[][] data = new Object[rows][1];

		// Read the data
		int dataRow = 0;
		Hashtable<String, String> table = null;
		for (int rNum = dataValueStartRowNum; rNum < dataValueStartRowNum + rows; rNum++) {
			table = new Hashtable<String, String>();
			for (int cNum = 0; cNum < cols; cNum++) {
				// System.out.println(xls.getCellData(xlssheetName, cNum,
				// rNum));
				String key = xls.getCellData(xlssheetName, cNum, colStartRowNum);
				String value = xls.getCellData(xlssheetName, cNum, rNum);
				table.put(key, value);
			}
			data[dataRow][0] = table;
			dataRow++;
		}
		return data;
	}
	
	
	
	
	public static boolean isTestExecutable(Xls_Reader xls, String testCaseName){
		int rows= xls.getRowCount(PPConstant.TESTCASES_SHEET);
		for(int rNum=2;rNum<=rows;rNum++){
			String tcid=xls.getCellData(PPConstant.TESTCASES_SHEET, "TCID", rNum);
			if(tcid.equals(testCaseName)){
				String runmode=xls.getCellData(PPConstant.TESTCASES_SHEET, "Runmode", rNum);
				if(runmode.equals("Y"))
					return true;
				else
					return false;
			}
			
		}
		return false;
	}

}
