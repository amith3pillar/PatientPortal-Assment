package patientPortal.OR;

public class PPHomePageOR {


	
	public static final String GRANT_ACCESS = " //span[contains(text(),'Grant Access')]";

	public static final String MY_ACCOUNT = "//a[contains(text(),'My Account')]";
	
	
	public static final String CLK_HISTORY_LOG = "//a[@href='/PatientPortal/Develop/PP/AccessLog/AccessLog']";


	public static final String ENTER_SUBJECT = "//input[@id='Subject']";

	public static final String ENTER_MESSAGE = "//textarea[@id='Message']";

	public static final String SendBTN = "//button[@id='messageSendNew']";
	
	

	public static final String SEND_MESSAGE_BUTTON = "//button[@id='sendNewButton']";
	
	public static final String REQUEST_AN_APPOINTMENT="//button[@id='sendApptRequest']";

	//public static final String CLK_UPDATE_INFORMATION_BTN = "//span[contains(text(),'Update your information')]";

	public static final String CLK_UPDATE_INFORMATION_BTN = "//div[@class='row']//div[5]//a[1]";
}
