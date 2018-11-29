package patientPortal.OR;

public class ppMyAccountPageOR {

	public static final String AUTH_USER_NAME = "//input[@id='UserName']";
	public static final String AUTH_PASSWORD = "//input[@id='PasswordModel_Password']";
	public static final String AUTH_REENTER_PASSWORD = "//input[@id='PasswordModel_ReEnterPassword']";
	public static final String AUTH_FIRST_NAME = "//input[@id='FirstName']";
	public static final String AUTH_LAST_NAME = "//input[@id='LastName']";
	public static final String AUTH_SAVE_BUTTON = "//input[@value='Save']";
	public static final String NOTIFICATION_BTN = "//button[@type='button'and class ='btn-btn-primary']";
	//div[@class='modal-content']//button[@type='button'][contains(text(),'Ok')]
	public static final String NOTIFICATION_BTN1 ="//div[@id='systemMessagesDialog']//span[@aria-hidden='true'][contains(text(),'×')]";
	public static final String CLK_HISTORY_LOG = "//a[@href='/PatientPortal/Develop/PP/AccessLog/AccessLog']";
	public static final String MY_ACCOUNT = "//a[@class='icon-background menu-icon-account']";
}
