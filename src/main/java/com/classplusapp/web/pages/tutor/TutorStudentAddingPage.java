package com.classplusapp.web.pages.tutor;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.classplusapp.web.pages.BaseClassplusAutomationPage;

import io.opentelemetry.exporter.logging.SystemOutLogExporter;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;

public class TutorStudentAddingPage extends BaseClassplusAutomationPage {

	@FindBy(xpath = "//div[@class='Header_Search__HAUBR Search_Container__3G4uq Search_Transparent__1AbYK']//input")
	private WebElement getSearchCourse;

	@FindBy(xpath = "//div[@class='courseContentCurrent']")
	private WebElement lblOverView;

	@FindBy(xpath = "//span[text()='Students']")
	private WebElement btnStudents;

	@FindBy(xpath = "//span[text()='Student']")
	private WebElement labelStudentStatus;

	@FindBy(xpath = "//button[@class='modalOpen activeCourseButton cursorPointer']")
	private WebElement btnAddStudents;

	@FindBy(xpath = "//p[contains(text(),'Add Students Manually')]")
	private WebElement lblAddStudentsManually;

	@FindBy(xpath = "//p[contains(text(),'Add students from Registered Users')]")
	private WebElement lblAddRegisteredStudents;

	@FindBy(xpath = "//p[contains(text(),'Upload CSV file to add students')]")
	private WebElement lblAddCSVStudents;

	@FindBy(xpath = "//div[@class='addMannually_title']//img")
	private WebElement btnBackManual;

	@FindBy(xpath = "//input[@placeholder='Enter Student Name']")
	private WebElement txtStudentName;

	@FindBy(xpath = "//input[@placeholder='Enter Student Number']")
	private WebElement txtStudentNumber;

	@FindBy(xpath = "//input[@placeholder='Enter Student Email']")
	private WebElement txtStudentEmail;

	@FindBy(xpath = "(//input[@placeholder='Enter Student Name'])[2]")
	private WebElement txtSecondStudentName;

	@FindBy(xpath = "(//input[@placeholder='Enter Student Number'])[2]")
	private WebElement txtSecondStudentNumber;

	@FindBy(xpath = "(//input[@placeholder='Enter Student Email'])[2]")
	private WebElement txtSecondStudentEmail;

	@FindBy(xpath = "//div[@class='addStudentsInfoTrayRight-button']")
	private WebElement btnProceedToPayment;

	@FindBy(xpath = "//span[@id='footer-cta']")
	private WebElement btnPay;

	@FindBy(xpath = "//div[@id='tab-title']")
	private WebElement lblPayWallet;

	@FindBy(xpath = "//div[@class='addMannually_title']")
	private WebElement addManualHeader;

	@FindBy(xpath = "//img[@alt='close']")
	private WebElement btnClose;

	@FindBy(xpath = "//div[@class='validationError_ErrorDesc']")
	private WebElement msgEmailErrorToast;

	@FindBy(xpath = "//div[@class='seven wide column']")
	private WebElement btnAddAnotherStudent;

	@FindBy(xpath = "(//i[@class='red trash alternate outline large link icon'])[2]")
	private WebElement btnDeleteAddStudent;

	@FindBy(xpath = "//i[@class='red trash alternate outline large link icon']")
	private WebElement btnDeleteStudent;

	@FindBy(xpath = "//input[@id='264802']")
	private WebElement chkStudent;

	@FindBy(xpath = "//input[@id='283939']")
	private WebElement chkSecondStudent;

	@FindBy(xpath = "//div[@class='addStudentsInfoTrayListItem']//following-sibling::span//parent::div//following-sibling::div/following-sibling::div/span/following-sibling::span")
	private WebElement getNumberOfStudents;

	@FindBy(xpath = "//img[@src='/static/media/leftArrow.a3f1b152.svg']")
	private WebElement btnBack;

	@FindBy(xpath = "(//input[@type='file'])[2]")
	private WebElement btnSelectFile;

	@FindBy(xpath = "//div[@class='pt-3']")
	private WebElement lblUploadCsv;

	@FindBy(xpath = "//div[@class='pt-3 AddStudentsModal_textCenter__2qDlD']")
	private WebElement lblUploadedCsv;

	@FindBy(xpath = "//button[contains(@class,'ui primary button ')]")
	private WebElement btnUploadFile;

	@FindBy(xpath = "//a[contains(text(),'Download sample csv file')]")
	private WebElement btnDownloadFile;

	@FindBy(xpath = "//button[contains(@class,'ui button AddStudentsModal_buttonSecondary')]")
	private WebElement btnProceedToPay;

	@FindBy(xpath = "//div[@class='PaymentModal__header header']")
	private WebElement lblEffectiveCourse;

	@FindBy(xpath = "(//div[@class='errorDivCSV'])[1]")
	private WebElement msgDuplicateEmail;

	@FindBy(xpath = "(//div[@class='errorDivCSV'])[2]")
	private WebElement msgDuplicateRow;

	@FindBy(xpath = "//div[@class='errorDivCSV']")
	private WebElement msgSubscribedCourse;

	@FindBy(xpath = "//span[contains(@class,'mt-2 AddStudentsModal_error')]")
	private WebElement msgFailedToAddStudent;

	@FindBy(xpath = "//button[contains(@class,'ui button AddStudentsModal_buttonPrimary')]")
	private WebElement lblReloadCSV;

	@FindBy(xpath = "//button[contains(@class,'ui button AddStudentsModal_buttonSecondary')]")
	private WebElement lblProceedToPayment;

	@FindBy(xpath = "//div[@class='mt-2']")
	private WebElement msgUploadCSV;

	@FindBy(xpath = "//span[contains(@class,'AddStudentsModal_success')]")
	private WebElement msgSuccessUploadCSV;

	@FindBy(xpath = "//button[contains(@class,'ui button PaymentModal__buttonSecondary')]")
	private WebElement btnPayNow;

	@FindBy(xpath = "//div[@id='modal-close']")
	private WebElement btnWalletClose;

	@FindBy(xpath = "//iframe[@class='razorpay-checkout-frame']")
	private WebElement walletIframe;

	@FindBy(xpath = "//div[@class='ui label addDetails__content--label addDetails__content--label--effective']//following-sibling::div")
	private WebElement lblEffectivePrice;

	@FindBy(xpath = "(//span[@class='item1'])[1]/following-sibling::span")
	private WebElement lblStudentManualEffectivePrice;

	@FindBy(xpath = "//img[@alt='Close']")
	private WebElement btnEditCourseClose;

	@FindBy(xpath = "(//span[@class='item1'])[2]/following-sibling::span")
	private WebElement lblActualClassplusSharePrice;

	@FindBy(xpath = "(//span[@class='item1'])[2]")
	private WebElement lblActualClassplusSharePercentage;

	@FindBy(xpath = "//div[@class='ui grid gridLayout']")
	private List<WebElement> studentCount;

	@FindBy(xpath = "//span[@class='addStudentsInfoTrayRight-title']//following-sibling::span")
	private WebElement lblToPayPrice;

	@FindBy(xpath = "//span[@class='mr-2 mt-2 mb-2 AddStudentsModal_float_right__3h6rE AddStudentsModal_downloadCsv__2dqFp']")
	private WebElement btnDownloadErrorFile;

	@FindBy(xpath = "//div[@data-cy='courseListAccordionDashboard']//img")
	private WebElement courseCarouselIcon;

	@FindBy(xpath = "//div[@data-cy='transactionType']//img")
	private WebElement transactionIcon;

	@FindBy(xpath = "//span[contains(text(),'Backend Addition')]//parent::div//input")
	private WebElement chkBackendAddition;

	@FindBy(xpath = "//div[@class='storeStudents__content--list--item storeStudents__grid--2']")
	private List<WebElement> countPurchase;

	@FindBy(xpath = "//tr[@class='backendAdditionHeader-right-row']")
	private List<WebElement> countShowTransactionHistory;

	@FindBy(xpath = "//div[@data-cy='showPartnerEarnings']//a")
	private WebElement btnShowTransactionHistory;

	@FindBy(xpath = "//div[@data-cy='showPartnerEarnings']")
	private WebElement lblEarnings;

	@FindBy(xpath = "//div[@class='transaction-container']//div[text()='TRANSACTIONS']")
	private WebElement lblTransactions;

	@FindBy(xpath = "(//img[@src='/static/media/DownloadReceipt.7c7b8f66.svg'])[1]//following-sibling::a")
	private WebElement btnDownloadReceipt;

	@FindBy(xpath = "(//img[@src='/static/media/DownloadReceipt.7c7b8f66.svg'])[1]")
	private WebElement btnPaymentDownloadReceipt;

	@FindBy(xpath = "//span[contains(text(),'TAX INVOICE')]")
	private WebElement lblTaxInvoice;

	@FindBy(xpath = "//span[contains(text(),'INVOICE')]")
	private WebElement lblInvoice;

	@FindBy(xpath = "//span[contains(text(),'backend_addition')]")
	private WebElement lblBackendAddition;

	@FindBy(xpath = "(//img[@src='/static/media/download.b6af7cfb.svg'])[1]")
	private WebElement btnStudentDownloadReciept;

	@FindBy(xpath = "//a[text()='Chat']")
	private WebElement btnChats;

	@FindBy(xpath = "//div[@class='Item_item__1PDSu  item undefined ']")
	private WebElement lblAIPoweredChatMessage;

	@FindBy(xpath = "//span[text()='Avinash']")
	private WebElement lblStudentName;

	@FindBy(xpath = "//span[@style='white-space: pre-wrap;']")
	private WebElement lblStudentFromChat;

	private static final Logger logger = Logger.getLogger(TutorStudentAddingPage.class.getName());

	public TutorStudentAddingPage(WebDriver driver) {
		super(driver);
		logger.info("Starting of StudentSortingPage method");

		PageFactory.initElements(driver, this);

		logger.info("Ending of StudentSortingPage method");
	}

	public String getOverViewLabelText() {
		logger.info("Starting of getOverViewLabelText method");
		logger.info(" Ending of getOverViewLabelText method");

		return this.lblOverView.getText();
	}

	public void clickOnStudentsButton() {
		logger.info("Starting of clickOnStudentsButton method");

		this.explicitWait(btnStudents);
		try {
			this.btnStudents.click();
		} catch (Exception e) {
			this.clickOnWebElement(btnStudents);
		}

		logger.info("Ending of clickOnStudentsButton method");
	}

	public String getStudentStatusLabelText() {
		logger.info("Starting of getStudentsLabelText method");
		logger.info(" Ending of getStudentsLabelText method");

		return labelStudentStatus.getText();
	}

	public void setSearchCourse(String Search) {
		logger.info("Starting of setSearch method");

		this.getSearchCourse.sendKeys(Search);

		logger.info("Ending of setSearch method");
	}

	public String getAddStudentButton() {
		logger.info("Starting of getAddStudentButton method");
		logger.info(" Ending of getAddStudentButton method");

		return btnAddStudents.getText();
	}

	public void clickOnAddStudentsButton() {
		logger.info("Starting of clickOnAddStudentsButton method");

		try {
			if (btnAddStudents.isDisplayed()) {
				this.btnAddStudents.click();
			}
		} catch (Exception e) {
			this.clickOnWebElement(btnAddStudents);
		}

		logger.info("Ending of clickOnAddStudentsButton method");
	}

	public void clickOnBackManualButton() {
		logger.info("Starting of clickOnBackManualButton method");

		try {
			if (btnBackManual.isDisplayed()) {
				this.btnBackManual.click();
			}
		} catch (Exception e) {
			this.clickOnWebElement(btnBackManual);
		}

		logger.info("Ending of clickOnBackManualButton method");
	}

	public String getAddStudentsManually() {
		logger.info("Starting of getAddStudentsManually method");
		logger.info(" Ending of getAddStudentsManually method");

		return lblAddStudentsManually.getText();
	}

	public void clickOnAddStudentsManuallyButton() {
		logger.info("Starting of clickOnAddStudentsManuallyButton method");

		try {
			this.lblAddStudentsManually.click();
		} catch (Exception e) {
			this.clickOnWebElement(lblAddStudentsManually);
		}

		logger.info("Ending of clickOnAddStudentsManuallyButton method");
	}

	public void clickOnAddRegisteredStudentsButton() {
		logger.info("Starting of clickOnAddRegisteredStudentsButton method");

		try {
			this.clickOnWebElement(lblAddRegisteredStudents);
		} catch (Exception e) {
			this.lblAddRegisteredStudents.click();
		}

		logger.info("Ending of clickOnAddRegisteredStudentsButton method");
	}

	public void clickOnAddCSVStudentsButton() {
		logger.info("Starting of clickOnAddCSVStudentsButton method");

		try {
			this.lblAddCSVStudents.click();
		} catch (Exception e) {
			this.clickOnWebElement(lblAddCSVStudents);
		}

		logger.info("Ending of clickOnAddCSVStudentsButton method");
	}

	public String getAddRegisteredStudents() {
		logger.info("Starting of getAddRegisteredStudents method");
		logger.info(" Ending of getAddRegisteredStudents method");

		return lblAddRegisteredStudents.getText();
	}

	public String getAddCSVStudents() {
		logger.info("Starting of getAddCSVStudents method");
		logger.info(" Ending of getAddCSVStudents method");

		return lblAddCSVStudents.getText();
	}

	public void setStudentName(String strStudentName) {
		logger.info("Starting of setStudentName method");

		this.txtStudentName.clear();
		this.txtStudentName.sendKeys(strStudentName);

		logger.info("Ending of setStudentName method");
	}

	public void setStudentNumber(String strStudentNum) {
		logger.info("Starting of setStudentNumber method");

		this.txtStudentNumber.clear();
		this.txtStudentNumber.sendKeys(strStudentNum);

		logger.info("Ending of setStudentNumber method");
	}

	public void setStudentEmail(String strStudentEmail) {
		logger.info("Starting of setStudentEmail method");

		this.txtStudentEmail.clear();
		this.txtStudentEmail.sendKeys(strStudentEmail);

		logger.info("Ending of setStudentEmail method");
	}

	public void setSecondStudentName(String strStdName) {
		logger.info("Starting of setSecondStudentName method");

		this.txtSecondStudentName.clear();
		this.txtSecondStudentName.sendKeys(strStdName);

		logger.info("Ending of setSecondStudentName method");
	}

	public void setSecondStudentNumber(String strStdtNum) {
		logger.info("Starting of setSecondStudentNumber method");

		this.txtSecondStudentNumber.clear();
		this.txtSecondStudentNumber.sendKeys(strStdtNum);

		logger.info("Ending of setSecondStudentNumber method");
	}

	public void setSecondStudentEmail(String strStdtEmail) {
		logger.info("Starting of setSecondStudentEmail method");

		this.txtSecondStudentEmail.clear();
		this.txtSecondStudentEmail.sendKeys(strStdtEmail);

		logger.info("Ending of setSecondStudentEmail method");
	}

	public void clickOnProceedToPaymentButton() {
		logger.info("Starting of clickOnProceedToPaymentButton method");

		Actions action = new Actions(driver);
		action.click(btnProceedToPayment).build().perform();

		logger.info("Ending of clickOnProceedToPaymentButton method");
	}

	public void clickOnPayButton() {
		logger.info("Starting of clickOnPayButton method");

		try {
			this.driver.switchTo().frame(0);
			this.btnPay.click();
		} catch (Exception e) {
			this.clickOnWebElement(btnPay);
		}

		logger.info("Ending of clickOnPayButton method");
	}

	public String getAddStudentsHeader() {
		logger.info("Starting of getAddStudentsHeader method");
		logger.info(" Ending of getAddStudentsHeader method");

		return addManualHeader.getText();
	}

	public void clickOnCloseButton() {
		logger.info("Starting of clickOnCloseButton method");

		try {
			this.hardWait(2);
			this.clickOnWebElement(btnClose);
		} catch (Exception e) {
			this.btnClose.click();

		}

		logger.info("Ending of clickOnCloseButton method");
	}

	public void clickOnWalletCloseButton() {
		logger.info("Starting of clickOnWalletCloseButton method");

		try {
			this.hardWait(5);
			driver.switchTo().frame(0);
			this.clickOnWebElement(btnWalletClose);
		} catch (Exception e) {
			this.btnWalletClose.click();
		}

		logger.info("Ending of clickOnWalletCloseButton method");
	}

	public String getEmailErrorToast() {
		logger.info("Starting of getEmailErrorToast method");
		logger.info(" Ending of getEmailErrorToast method");

		return msgEmailErrorToast.getText();
	}

	public void clickOnAddAnotherStudent() {
		logger.info("Starting of clickOnAddAnotherStudent method");

		try {
			this.clickOnWebElement(btnAddAnotherStudent);
		} catch (Exception e) {
			this.btnAddAnotherStudent.click();
		}

		logger.info("Ending of clickOnAddAnotherStudent method");
	}

	public void clickOnDeleteStudents() {
		logger.info("Starting of clickOnDeleteStudents method");

		try {
			this.clickOnWebElement(btnDeleteAddStudent);
		} catch (Exception e) {
			this.btnDeleteAddStudent.click();
		}

		logger.info("Ending of clickOnDeleteStudents method");
	}

	public boolean isDisplayedDeleteStudent() {
		logger.info("Starting of isDisplayedDeleteStudent method");
		logger.info("Ending of isDisplayedDeleteStudent method");

		try {
			btnDeleteStudent.isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public void clickOnSelectStudent() {
		logger.info("Starting of clickOnSelectStudent method");

		try {
			this.clickOnWebElement(chkStudent);
		} catch (Exception e) {
			this.chkStudent.click();
		}

		logger.info("Ending of clickOnSelectStudent method");
	}

	public boolean getSelectedStudentCount() {
		logger.info("Starting of getSelectedStudentCount method");

		this.scrollDown(700);
		String getUnselected = getNumberOfStudents.getText();
		int beforeSelectedStudentCount = Integer.parseInt(getUnselected);
		this.clickOnWebElement(chkStudent);
		this.clickOnWebElement(chkSecondStudent);
		String getSelected = getNumberOfStudents.getText();
		int afterSelectedStudentCount = Integer.parseInt(getSelected);

		logger.info("Ending of getSelectedStudentCount method");

		if (afterSelectedStudentCount > beforeSelectedStudentCount) {
			return true;
		} else {
			return false;
		}
	}

	public void clickOnBack() {
		logger.info("Starting of clickOnBack method");

		try {
			this.clickOnWebElement(btnBack);

		} catch (Exception e) {
			this.btnBack.click();
		}

		logger.info("Ending of clickOnBack method");
	}

	public void clickOnSelectCSVFileButton() {
		logger.info("starting of clickOnSelectCSVFileButton method");

		String osPath = System.getProperty("os.name");
		if (osPath.contains("Linux")) {
			btnSelectFile.sendKeys(TEST_FILE_PATH + "/testdata/sampleCSV.csv");
		} else {
			btnSelectFile.sendKeys(TEST_FILE_PATH + "/testdata/sampleCSV.csv");
		}

		logger.info("Ending of clickOnSelectCSVFileButton method");
	}

	public void clickOnDuplicateEntriesCSVFileButton() {
		logger.info("starting of clickOnDuplicateEntriesCSVFileButton method");

		String osPath = System.getProperty("os.name");
		if (osPath.contains("Linux")) {
			btnSelectFile.sendKeys(TEST_FILE_PATH + "/testdata/duplicateStudentEntries.csv");
		} else {
			btnSelectFile.sendKeys(TEST_FILE_PATH + "/testdata/duplicateStudentEntries.csv");
		}

		logger.info("Ending of clickOnDuplicateEntriesCSVFileButton method");
	}

	public void clickOnInvalidMobileDataCSVFileButton() {
		logger.info("starting of clickOnInvalidMobileDataCSVFileButton method");

		String osPath = System.getProperty("os.name");
		if (osPath.contains("Linux")) {
			btnSelectFile.sendKeys(TEST_FILE_PATH + "/testdata/invalidMobileData.csv");
		} else {
			btnSelectFile.sendKeys(TEST_FILE_PATH + "/testdata/invalidMobileData.csv");
		}

		logger.info("Ending of clickOnInvalidMobileDataCSVFileButton method");
	}

	public void clickOnFailedStudentFileButton() {
		logger.info("starting of clickOnFailedStudentFileButton method");

		String osPath = System.getProperty("os.name");
		if (osPath.contains("Linux")) {
			btnSelectFile.sendKeys(TEST_FILE_PATH + "/testdata/invalidData.csv");
		} else {
			btnSelectFile.sendKeys(TEST_FILE_PATH + "/testdata/invalidData.csv");
		}

		logger.info("Ending of clickOnFailedStudentFileButton method");
	}

	public void clickOnSubscribedStudentFileButton() {
		logger.info("starting of clickOnSubscribedStudentFileButton method");

		String osPath = System.getProperty("os.name");
		if (osPath.contains("Linux")) {
			btnSelectFile.sendKeys(TEST_FILE_PATH + "/testdata/subscribedData.csv");
		} else {
			btnSelectFile.sendKeys(TEST_FILE_PATH + "/testdata/subscribedData.csv");
		}

		logger.info("Ending of clickOnSubscribedStudentFileButton method");
	}

	public void clickOnAllWrongEntriesFileButton() {
		logger.info("starting of clickOnAllWrongEntriesFileButton method");

		String osPath = System.getProperty("os.name");
		if (osPath.contains("Linux")) {
			btnSelectFile.sendKeys(TEST_FILE_PATH + "/testdata/invalid.csv");
		} else {
			btnSelectFile.sendKeys(TEST_FILE_PATH + "/testdata/invalid.csv");
		}

		logger.info("Ending of clickOnAllWrongEntriesFileButton method");
	}

	public void clickOnValidEntriesFileButton() {
		logger.info("starting of clickOnValidEntriesFileButton method");

		String osPath = System.getProperty("os.name");
		if (osPath.contains("Linux")) {
			btnSelectFile.sendKeys(TEST_FILE_PATH + "/testdata/validData.csv");
		} else {
			btnSelectFile.sendKeys(TEST_FILE_PATH + "/testdata/validData.csv");
		}

		logger.info("Ending of clickOnValidEntriesFileButton method");
	}

	public void clickOnImageSelectFileButton() {
		logger.info("starting of clickOnImageSelectFileButton method");

		String osPath = System.getProperty("os.name");
		if (osPath.contains("Linux")) {
			btnSelectFile.sendKeys(TEST_FILE_PATH + "/testdata/contentimage.png");
		} else {
			btnSelectFile.sendKeys(TEST_FILE_PATH + "/testdata/contentimage.png");
		}

		logger.info("Ending of clickOnImageSelectFileButton method");
	}

	public void clickOnUploadFile() {
		logger.info("Starting of clickOnUploadFile method");

		try {
			this.clickOnWebElement(btnUploadFile);
		} catch (Exception e) {
			this.btnUploadFile.click();
		}

		logger.info("Ending of clickOnUploadFile method");
	}

	public String getUploadCsvFile() {
		logger.info("Starting of getUploadCsvFile method");
		logger.info(" Ending of getUploadCsvFile method");

		return lblUploadCsv.getText();
	}

	public String getUploadedCsvFile() {
		logger.info("Starting of getUploadedCsvFile method");
		logger.info(" Ending of getUploadedCsvFile method");

		return lblUploadedCsv.getText();
	}

	public void clickOnDownloadFile() {
		logger.info("Starting of clickOnDownloadFile method");

		try {
			this.clickOnWebElement(btnDownloadFile);
		} catch (Exception e) {
			this.btnDownloadFile.click();
		}

		logger.info("Ending of clickOnDownloadFile method");
	}

	public String getPayWallet() {
		logger.info("Starting of getPayWallet method");
		logger.info(" Ending of getPayWallet method");

		return lblPayWallet.getText();
	}

	public void clickOnProceedToPay() {
		logger.info("Starting of clickOnProceedToPay method");

		try {
			this.clickOnWebElement(btnProceedToPay);
		} catch (Exception e) {
			this.btnProceedToPay.click();
		}

		logger.info("Ending of clickOnProceedToPay method");
	}

	public String getEffectivePrice() {
		logger.info("Starting of getEffectivePrice method");
		logger.info(" Ending of getEffectivePrice method");

		return lblEffectiveCourse.getText();
	}

	public String getDuplicateEmail() {
		logger.info("Starting of getDuplicateEmail method");
		logger.info(" Ending of getDuplicateEmail method");

		return msgDuplicateEmail.getText();
	}

	public String getDuplicateRow() {
		logger.info("Starting of getDuplicateRow method");
		logger.info(" Ending of getDuplicateRow method");

		return msgDuplicateRow.getText().substring(3);
	}

	public String getDuplicateMobileNumber() {
		logger.info("Starting of getDuplicateMobileNumber method");
		logger.info(" Ending of getDuplicateMobileNumber method");

		return msgDuplicateEmail.getText();
	}

	public String getInvalidMobileNumber() {
		logger.info("Starting of getInvalidMobileNumber method");
		logger.info(" Ending of getInvalidMobileNumber method");

		return msgDuplicateRow.getText();
	}

	public String getFailedStudents() {
		logger.info("Starting of getFailedStudents method");
		logger.info(" Ending of getFailedStudents method");

		return msgFailedToAddStudent.getText().substring(2);
	}

	public String getFailedInvalidStudents() {
		logger.info("Starting of getFailedInvalidStudents method");
		logger.info(" Ending of getFailedInvalidStudents method");

		return msgFailedToAddStudent.getText();
	}

	public String getReloadCSV() {
		logger.info("Starting of getReloadCSV method");
		logger.info(" Ending of getReloadCSV method");

		return lblReloadCSV.getText();
	}

	public String getProceedToPayment() {
		logger.info("Starting of getProceedToPayment method");
		logger.info(" Ending of getProceedToPayment method");

		return lblProceedToPayment.getText();
	}

	public String getUploadValidFormat() {
		logger.info("Starting of getUploadValidFormat method");
		logger.info(" Ending of getUploadValidFormat method");

		return msgUploadCSV.getText().trim();
	}

	public String getUploadSuccessMessage() {
		logger.info("Starting of getUploadSuccessMessage method");
		logger.info(" Ending of getUploadSuccessMessage method");

		return msgSuccessUploadCSV.getText();
	}

	public String getSubscribedCourseMessage() {
		logger.info("Starting of getUploadSuccessMessage method");
		logger.info(" Ending of getUploadSuccessMessage method");

		return msgSubscribedCourse.getText().substring(2).trim();
	}

	public void clickOnPayNow() {
		logger.info("Starting of clickOnPayNow method");

		try {
			this.clickOnWebElement(btnPayNow);
		} catch (Exception e) {
			this.btnPayNow.click();
		}

		logger.info("Ending of clickOnPayNow method");
	}

	public String getEffectivePriceLabel() {
		logger.info("Starting of getEffectivePriceLabel method");
		logger.info(" Ending of getEffectivePriceLabel method");

		this.scrollIntoView(lblEffectivePrice);
		return lblEffectivePrice.getText().substring(0, 4);
	}

	public String getStudentEffectivePriceLabel() {
		logger.info("Starting of getStudentEffectivePriceLabel method");
		logger.info(" Ending of getStudentEffectivePriceLabel method");

		this.hardWait(2);
		String[] lblManualEffectivePrice = lblStudentManualEffectivePrice.getText().split("₹");
		return lblManualEffectivePrice[1];
	}

	public void clickOnEditCourseClose() {
		logger.info("Starting of clickOnEditCourseClose method");

		this.scrollIntoView(btnEditCourseClose);
		try {
			this.clickOnWebElement(btnEditCourseClose);
		} catch (Exception e) {
			this.btnEditCourseClose.click();
		}

		logger.info("Ending of clickOnEditCourseClose method");
	}

	public boolean getClassPlusShare() {
		logger.info("Starting of getClassPlusShare method");
		logger.info("Ending of getClassPlusShare method");

		System.out.println(lblActualClassplusSharePercentage.getText());
		String percentage = lblActualClassplusSharePercentage.getText().substring(17, 20);
		double getSharePercentage = Double.parseDouble(percentage);
		String priceOfCourse = lblStudentManualEffectivePrice.getText().substring(1);
		double getpriceOfCourse = Double.parseDouble(priceOfCourse);
		double classplusPrice = (getpriceOfCourse * getSharePercentage) / 100;
		String getShare = lblActualClassplusSharePrice.getText().substring(1);
		double getPercentageShare = Double.parseDouble(getShare);

		String getToPayAmount = lblToPayPrice.getText().substring(1);
		double getPayAmount = Double.parseDouble(getToPayAmount);
		if ((getPercentageShare == classplusPrice) && (getPercentageShare == getPayAmount)) {
			return true;
		}
		return false;
	}

	public boolean getNumberOfStudents() {
		logger.info("Starting of getNumberOfStudents method");
		logger.info("Ending of getNumberOfStudents method");

		int manualStudentList = studentCount.size();

		String getSelected = getNumberOfStudents.getText();
		int studentCount = Integer.parseInt(getSelected);
		if (manualStudentList == studentCount) {
			return true;
		}
		return false;
	}

	public void clickOnDownloadErrorFile() {
		logger.info("Starting of clickOnDownloadErrorFile method");

		try {
			this.clickOnWebElement(btnDownloadErrorFile);
		} catch (Exception e) {
			this.btnDownloadErrorFile.click();
		}

		logger.info("Ending of clickOnDownloadErrorFile method");
	}

	public File getReadDownloadedErrorFile() {
		File directory = new File("C://Users//Hello//Downloads");
		File[] files = directory.listFiles(File::isFile);
		long lastModifiedTime = Long.MIN_VALUE;
		File choosenFile = null;

		if (files != null) {
			for (File file : files) {
				if (file.lastModified() > lastModifiedTime) {
					choosenFile = file;
					lastModifiedTime = file.lastModified();
				}
			}
		}
		System.out.println("File path is " + choosenFile + "/n");
		return choosenFile;

	}

	public void getDowdloadCSVFile() {
		logger.info("starting of getDowdloadCSVFile method");

		String osPath = System.getProperty("os.name");
		this.clickOnWebElement(btnDownloadErrorFile);
		if (osPath.contains("Linux")) {
			btnDownloadErrorFile.sendKeys(TEST_FILE_PATH + "/testDownload/invalidData.csv");
		} else {
			btnDownloadErrorFile.sendKeys(TEST_FILE_PATH + "/testDownload/invalidData.csv");
		}

		logger.info("Ending of getDowdloadCSVFile method");
	}

	public void clickCourseTransactionIcon() {
		logger.info("Starting of clickCourseTransactionIcon method");

		try {
			this.clickOnWebElement(courseCarouselIcon);
			this.clickOnWebElement(transactionIcon);
			this.clickOnWebElement(chkBackendAddition);
		} catch (Exception e) {
			this.courseCarouselIcon.click();
			this.transactionIcon.click();
			this.chkBackendAddition.click();
		}

		logger.info("Ending of clickCourseTransactionIcon method");
	}

	public int getCountPurchase() {
		logger.info("starting of getCountPurchase method");
		logger.info("Ending of getCountPurchase method");
		this.scrollDown(500);

		return countPurchase.size();

	}

	public int getShowTransactionHistory() {
		logger.info("starting of getShowTransactionHistory method");
		logger.info("Ending of getShowTransactionHistory method");
		this.scrollDown(500);

		return countShowTransactionHistory.size();

	}

	public boolean getTransactionHistory() {
		if (getShowTransactionHistory() == getCountPurchase() + 2) {
			return true;
		} else {
			return false;
		}

	}

	public void clickOnShowTransactionHistory() {
		logger.info("Starting of clickOnShowTransactionHistory method");

		try {
			this.clickOnWebElement(btnShowTransactionHistory);
		} catch (Exception e) {
			this.btnShowTransactionHistory.click();
		}

		logger.info("Ending of clickOnShowTransactionHistory method");
	}

	public String getEarningsLabelText() {
		logger.info("Starting of getEarningsLabel method");
		logger.info("Ending of getEarningsLabel method");

		return this.lblEarnings.getText();
	}

	public boolean getBackendTransactionHistory() {
		logger.info("Starting of getBackendTransactionHistory method");
		logger.info("Ending of getBackendTransactionHistory method");

		return btnShowTransactionHistory.isDisplayed();
	}

	public String getTransactionsLabelText() {
		logger.info("Starting of getTransactionsLabel method");
		logger.info("Ending of getTransactionsLabel method");

		return this.lblTransactions.getText();
	}

	public void clickOnDownloadReceipt() {
		logger.info("Starting of clickOnDownloadReceipt method");

		this.scrollIntoView(btnDownloadReceipt);
		try {
			this.clickOnWebElement(btnDownloadReceipt);
		} catch (Exception e) {
			this.btnDownloadReceipt.click();
		}

		logger.info("Ending of clickOnDownloadReceipt method");
	}

	public void clickOnDownloadStudentReceipt() {
		logger.info("Starting of clickOnDownloadStudentReceipt method");

		this.scrollIntoView(btnStudentDownloadReciept);
		try {
			this.clickOnWebElement(btnStudentDownloadReciept);
		} catch (Exception e) {
			this.btnStudentDownloadReciept.click();
		}

		logger.info("Ending of clickOnDownloadStudentReceipt method");
	}

	public String getTaxInvoice() {
		logger.info("Starting of getTaxInvoice method");
		logger.info("Ending of getTaxInvoice method");
		this.switchToNewWindow();

		return lblTaxInvoice.getText();
	}

	public String getInvoice() {
		logger.info("Starting of getTaxInvoice method");
		logger.info("Ending of getTaxInvoice method");
		this.switchToNewWindow();

		return lblInvoice.getText();
	}

	public boolean getBackedAddition() {
		logger.info("Starting of getBackedAddition method");
		logger.info("Ending of getBackedAddition method");

		return lblBackendAddition.isDisplayed();
	}

	public boolean salesType() {
		logger.info("starting of selectedAddressData method");
		logger.info("starting of selectedAddressData method");

		if (btnShowTransactionHistory.isDisplayed() && lblBackendAddition.isDisplayed()) {

			return true;
		} else
			return false;

	}

	public void clickOnStudentDownloadReceipt() {
		logger.info("Starting of clickOnDownloadReceipt method");

		this.scrollIntoView(btnDownloadReceipt);

		try {
			this.clickOnWebElement(btnStudentDownloadReciept);
		} catch (Exception e) {
			this.btnStudentDownloadReciept.click();
		}

		logger.info("Ending of clickOnDownloadReceipt method");
	}

	public void clickOnChats() {
		logger.info("Starting of clickOnChats method");

		try {
			this.clickOnWebElement(btnChats);
		} catch (Exception e) {
			this.btnChats.click();
		}

		logger.info("Ending of clickOnChats method");
	}

	public String lblChats() {
		logger.info("Starting of lblChats method");
		logger.info("Ending of lblChats method");

		return btnChats.getText();
	}

	public void clickOnChatMessageLabel() {
		logger.info("Starting of clickOnChatMessageLabel method");

		try {
			this.clickOnWebElement(lblAIPoweredChatMessage);
		} catch (Exception e) {
			this.lblAIPoweredChatMessage.click();
		}

		logger.info("Ending of clickOnChatMessageLabel method");
	}

	public String lblStudentName() {
		logger.info("Starting of lblStudentName method");
		logger.info("Ending of lblStudentName method");

		return lblStudentName.getText();
	}

	public String lblChatStudentName() {
		logger.info("Starting of lblChatStudentName method");
		logger.info("Ending of lblChatStudentName method");

		String[] s = lblStudentFromChat.getText().split(" ");
		String ss = s[4];
		return ss;

	}
}
