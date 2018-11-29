package patientPortal.Util;

public class PPConstant {

	
	//Drivers Locations 
	public static final String MOZILLA_DRIVER = System.getProperty("user.dir")
			+ "\\Drivers\\GeckoDriver\\geckodriver.exe";
	public static final String CHROME_DRIVER = System.getProperty("user.dir")
			+ "\\Drivers\\ChromeDriver\\chromedriver.exe";
	public static final String INTERNET_DRIVER = System.getProperty("user.dir")
			+ "\\Drivers\\InternetExplorer\\IEDriverServer.exe";

	// Reports Path
	public static final String REPORT_PATH = System.getProperty("user.dir") +"\\Reports\\";
	
	
//PROJECT URL
	public static final String PORTALURL = "https://gmedbuild01.gmed.com/PatientPortal/Develop/Router";

	// Excelfile Path
	public static final String DATA_XLS_PATH = System.getProperty("user.dir") + "//Data//Data.xlsx";
	public static final String TESTDATA_SHEET_NAME = "TestData";
	public static final Object RUNMODE_COL = "Runmode";
	public static final Object BROWSER_COL = "Browser";

	public static final Object EXPECTED_RESULT_COL = "ExpectedResult";
	public static final String TESTCASES_SHEET = "TestCases";



	// Production User
	public static final String PROD_USERNAME = "auto15";
	public static final String PROD_PASSWORD = "a@123";
	
	
	
	//Update Inforamiton page
	public static final String PERSONAL_EMAIL="haldarjan15@gmail.com";
	

}
