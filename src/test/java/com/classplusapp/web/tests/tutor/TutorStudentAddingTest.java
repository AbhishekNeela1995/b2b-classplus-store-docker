package com.classplusapp.web.tests.tutor;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static com.classplusapp.store.util.Constants.*;

import com.classplusapp.web.pages.student.StudentPayInstallmentCoursePage;
import com.classplusapp.web.pages.tutor.TutorTrialClassPage;
import com.classplusapp.web.pages.tutor.TutorAddContentPage;
import com.classplusapp.web.pages.tutor.TutorCreateCoursePage;
import com.classplusapp.web.pages.tutor.TutorCreateInstallmentPage;
import com.classplusapp.web.pages.tutor.TutorEditCoursePage;
import com.classplusapp.web.pages.tutor.TutorMerchantDashboardPage;
import com.classplusapp.web.pages.tutor.TutorStudentAddingPage;
import com.classplusapp.web.pages.tutor.TutorStudentSortingPage;
import com.classplusapp.web.tests.CommonFunctionStoreTest;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Epic("Store Overview")
@Feature("Student Sorting Test")
public class TutorStudentAddingTest extends CommonFunctionStoreTest {

	private WebDriver driver = null;
	private TutorStudentAddingPage tutorStudentAddingPage = null;
	private TutorCreateCoursePage createCoursePage = null;
	private TutorAddContentPage tutorAddContentPage = null;
	private TutorCreateInstallmentPage tutorCreateInstallmentPage = null;
	private TutorTrialClassPage tutorTrialClassPage = null;
	private TutorEditCoursePage tutorEditCoursePage = null;
	private StudentPayInstallmentCoursePage studentPayInstallmentCoursePage = null;
	private TutorMerchantDashboardPage tutorMerchantDashboardPage = null;
	private TutorStudentSortingPage tutorStudentSortingPage = null;

	private static final Logger logger = Logger.getLogger(TutorStudentAddingTest.class.getName());

	@BeforeClass
	@Parameters({ "browser", "orgCode"})
	public void initClassplusSiteLogin(@Optional("Chrome")String browser, @Optional("learn")String orgCode)
			throws Exception {
		logger.info("Starting of initClassplusSiteLogin methond");

		this.driver = super.loginClassPlusSite(browser, orgCode, tutorMobileNumber, emailAddress,
				WEB_DRIVER.TUTOR_STUDENT_ADDING_TEST);

		this.tutorStudentAddingPage = new TutorStudentAddingPage(driver);
		this.createCoursePage = new TutorCreateCoursePage(this.driver);
		this.tutorAddContentPage = new TutorAddContentPage(driver);
		this.tutorCreateInstallmentPage = new TutorCreateInstallmentPage(driver);
		this.tutorTrialClassPage = new TutorTrialClassPage(driver);
		this.studentPayInstallmentCoursePage = new StudentPayInstallmentCoursePage(driver);
		this.tutorEditCoursePage = new TutorEditCoursePage(driver);
		this.tutorMerchantDashboardPage = new TutorMerchantDashboardPage(driver);
		this.tutorStudentSortingPage = new TutorStudentSortingPage(driver);

		logger.info("Ending of initClassplusSiteLogin method");
	}

	@Test(priority = 1, description = "Verify the tutor can get the course")
	@Description("Test Description: Verify the tutor can get the course")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Verify Get Course")
	public void testGetCourse() {
		logger.info("Starting of testGetCourse method");

		try {
			this.tutorCreateInstallmentPage.clickOnStoreButton();
			driver.navigate().refresh();
			this.hardWait(3);
			this.tutorCreateInstallmentPage.setSearch(testDataProp.getProperty(TUTOR_STUDENT_ADDING_COURSE_TESTING));
			this.tutorCreateInstallmentPage
					.clickOnGetCourse(testDataProp.getProperty(TUTOR_STUDENT_ADDING_COURSE_TESTING));

			Assert.assertEquals(this.tutorTrialClassPage.getCourseLabel(),
					expectedAssertionsProp.getProperty(LABEL_COURSE));

		} catch (Exception e) {
			Assert.fail("Exception occured while testing the tutor can get the course: " + e.getMessage());
			logger.error("Error occured while testing the tutor can get the course ", e);
		}

		logger.info("Ending of testGetCourse method");
	}

	@Test(priority = 2, description = "Verify Student Sorting Page")
	@Description("Test Description: Verify Student Sorting Page")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Verify Student Sorting Page")
	public void testStudentSortingPage() {
		logger.info("Starting of testStudentSortingPage method");

		try {
			this.tutorStudentAddingPage.clickOnStudentsButton();

			// Assertion for checking the student status Label
			Assert.assertEquals(this.tutorStudentAddingPage.getStudentStatusLabelText(),
					expectedAssertionsProp.getProperty(LABEL_STUDENT_STATUS));

			// Assertion for checking the add student Label
			Assert.assertEquals(this.tutorStudentAddingPage.getAddStudentButton(),
					expectedAssertionsProp.getProperty(LABEL_ADD_STUDENT));

		} catch (Exception e) {
			Assert.fail("Exception occured while testing Student Sorting Page: " + e.getMessage());
			logger.error("Error occured while testing Student Sorting Page ", e);
		}

		logger.info("Ending of testStudentSortingPage method");
	}

	@Test(priority = 3, description = "Verify Availability of options are givento the tutor by clicking the â€œAdd Studentsâ€� button")
	@Description("Test Description:Verify Availability of  options are given to the tutor by clicking the  â€œAdd Studentsâ€� button")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Verify Add Students Options")
	public void testAddStudentsAvailabilityOptions() {
		logger.info("Starting of testAddStudentsAvailabilityOptions method");

		try {
			this.tutorStudentAddingPage.clickOnAddStudentsButton();

			Assert.assertEquals(this.tutorStudentAddingPage.getAddStudentsManually(),
					expectedAssertionsProp.getProperty(LABEL_STUDENT_ADDED_MANUALLY));

			Assert.assertEquals(this.tutorStudentAddingPage.getAddRegisteredStudents(),
					expectedAssertionsProp.getProperty(LABEL_STUDENT_ADDED_REGISTERED));

			Assert.assertEquals(this.tutorStudentAddingPage.getAddCSVStudents(),
					expectedAssertionsProp.getProperty(LABEL_STUDENT_ADDED_CSV));

		} catch (Exception e) {
			Assert.fail(
					"Exception occured while testing Availability of  options are given to the tutor by clicking the  â€œAdd Studentsâ€� button: "
							+ e.getMessage());
			logger.error(
					"Error occured while testing Availability of  options are given to the tutor by clicking the  â€œAdd Studentsâ€� button ",
					e);
		}

		logger.info("Ending of testAddStudentsAvailabilityOptions method");
	}

	@Test(priority = 4, description = "Verify add students and delete studentsmanually in the course")
	@Description("Test Description: Verify add students and delete students manually in the course")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Verify Add Students Manually")
	public void testAddStudentsManually() {
		logger.info("Starting of testAddStudentsManually method");

		try {
			this.tutorStudentAddingPage.clickOnAddStudentsManuallyButton();

			Assert.assertEquals(this.tutorStudentAddingPage.getAddStudentsHeader(),
					expectedAssertionsProp.getProperty(LABEL_STUDENT_ADDED_HEADER));

			this.tutorStudentAddingPage.setStudentName(testDataProp.getProperty(TXT_ADD_STUDENT_NAME));
			this.tutorStudentAddingPage.setStudentNumber(testDataProp.getProperty(TXT_ADD_STUDENT_NUMBER));
			this.tutorStudentAddingPage.setStudentEmail(testDataProp.getProperty(TXT_ADD_STUDENT_EMAIL));
			this.tutorStudentAddingPage.clickOnAddAnotherStudent();
			this.tutorStudentAddingPage.setSecondStudentName(testDataProp.getProperty(TXT_ADD_SECOND_STUDENT_NAME));
			this.tutorStudentAddingPage.setSecondStudentNumber(testDataProp.getProperty(TXT_ADD_SECOND_STUDENT_NUMBER));
			this.tutorStudentAddingPage.setSecondStudentEmail(testDataProp.getProperty(TXT_ADD_SECOND_STUDENT_EMAIL));
			this.tutorStudentAddingPage.clickOnDeleteStudents();

			Assert.assertFalse(this.tutorStudentAddingPage.isDisplayedDeleteStudent());

			this.tutorStudentAddingPage.clickOnBackManualButton();

			/*
			 * this.tutorStudentAddingPage.clickOnProceedToPaymentButton();
			 * 
			 * Assert.assertEquals(this.tutorStudentAddingPage.getPayWallet(),
			 * expectedAssertionsProp.getProperty(LABEL_PAY_WALLET));
			 * 
			 * this.tutorStudentAddingPage.clickOnPayButton();
			 * 
			 * Assert.assertEquals(this.studentPayInstallmentCoursePage.
			 * getPaymentFailedHeadingLabel(),
			 * expectedAssertionsProp.getProperty(LABEL_PAYMENT_FAILED_HEADING));
			 * 
			 * this.tutorStudentAddingPage.clickOnCloseButton();
			 */
		} catch (

		Exception e) {
			Assert.fail("Exception occured while testing add students and delete students manually in the course: "
					+ e.getMessage());
			logger.error("Error occured while testing add students and delete students manually in the course ", e);
		}

		logger.info("Ending of testAddStudentsManually method");
	}

	@Test(priority = 5, description = "Verify Adding students from registeredusers")
	@Description("Test Description:Verify Adding students from registered users")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Verify Add Students from registered users")
	public void testAddStudentsFromRegisteredUsers() {
		logger.info("Starting of testAddStudentsFromRegisteredUsers method");

		try {
			this.tutorStudentAddingPage.clickOnAddStudentsButton();
			this.tutorStudentAddingPage.clickOnAddRegisteredStudentsButton();

			Assert.assertTrue(this.tutorStudentAddingPage.getSelectedStudentCount());

			this.tutorStudentAddingPage.clickOnBack();

		} catch (Exception e) {
			Assert.fail("Exception occured while testing  Adding students from registered users: " + e.getMessage());
			logger.error("Error occured while testing Adding students from registered users ", e);
		}

		logger.info("Ending of testAddStudentsFromRegisteredUsers method");
	}

	@Test(priority = 6, description = "Verify adding students by Uploading CSV to add students")
	@Description("Test Description:Verify adding students by Uploading CSV to add students")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Verify Add Students from CSV file")
	public void testUploadCSVfileToAddStudents() {
		logger.info("Starting of testUploadCSVfileToAddStudents method");

		try {
			this.tutorStudentAddingPage.clickOnAddStudentsButton();
			this.tutorStudentAddingPage.clickOnAddCSVStudentsButton();
			// this.tutorStudentAddingPage.clickOnDownloadFile();

			Assert.assertEquals(this.tutorStudentAddingPage.getUploadCsvFile(),
					expectedAssertionsProp.getProperty(LBL_UPLOAD_CSV));

			this.tutorStudentAddingPage.clickOnSelectCSVFileButton();

			Assert.assertEquals(this.tutorStudentAddingPage.getUploadedCsvFile(),
					expectedAssertionsProp.getProperty(LBL_UPLOADED_CSV));

			this.tutorStudentAddingPage.clickOnUploadFile();
			this.tutorStudentAddingPage.clickOnProceedToPay();

			Assert.assertEquals(this.tutorStudentAddingPage.getEffectivePrice(),
					expectedAssertionsProp.getProperty(LBL_EFFECTIVE_PRICE));

			this.tutorStudentAddingPage.clickOnCloseButton();

		} catch (Exception e) {
			Assert.fail("Exception occured while testing adding students by Uploading CSV to add students: "
					+ e.getMessage());
			logger.error("Error occured while testing adding students by Uploading CSV to add students ", e);
		}

		logger.info("Ending of testUploadCSVfileToAddStudents method");
	}

	@Test(priority = 7, description = "Verify add invalid students detailsmanually")
	@Description("Test Description:Verify add invalid students details manually")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Verify add invalid students details")
	public void testAddInvalidStudentDetails() {
		logger.info("Starting of testAddInvalidStudentDetails method");

		try {
			this.tutorStudentAddingPage.clickOnStudentsButton();
			this.tutorStudentAddingPage.clickOnAddStudentsButton();
			this.tutorStudentAddingPage.clickOnAddStudentsManuallyButton();

			this.tutorStudentAddingPage.setStudentName(testDataProp.getProperty(TXT_ADD_STUDENT_NAME));
			this.hardWait(3);
			this.tutorStudentAddingPage.clickOnProceedToPaymentButton();

			Assert.assertEquals(this.tutorStudentAddingPage.getEmailErrorToast(),
					expectedAssertionsProp.getProperty(MSG_EMAIL_ERROR));

			this.tutorStudentAddingPage.clickOnBackManualButton();

		} catch (Exception e) {
			Assert.fail("Exception occured while testing add invalid students details manually: " + e.getMessage());
			logger.error("Error occured while testing  Message to Student manually", e);
		}

		logger.info("Ending of testAddInvalidStudentDetails method");
	}

	@Test(priority = 8, description = "Verify if duplicate entry is added")
	@Description("Test Description:Verify if duplicate entry is added")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Verify Dupliacte Student Entries")
	public void testDuplicateStudentEntries() {
		logger.info("Starting of testDuplicateStudentEntries method");

		try {
			this.tutorStudentAddingPage.clickOnAddStudentsButton();
			this.tutorStudentAddingPage.clickOnAddCSVStudentsButton();
			this.tutorStudentAddingPage.clickOnDuplicateEntriesCSVFileButton();
			this.tutorStudentAddingPage.clickOnUploadFile();

			Assert.assertEquals(this.tutorStudentAddingPage.getDuplicateEmail(),
					expectedAssertionsProp.getProperty(LBL_DUPLICATE_EMAIL));

			Assert.assertEquals(this.tutorStudentAddingPage.getDuplicateRow(),
					expectedAssertionsProp.getProperty(LBL_THIRDROW_DUPLICATE));

			this.tutorStudentAddingPage.clickOnCloseButton();
		} catch (Exception e) {
			Assert.fail("Exception occured while testing adding students as duplicate entry: " + e.getMessage());
			logger.error("Error occured while testing adding students as duplicate entry ", e);
		}

		logger.info("Ending of testDuplicateStudentEntries method");
	}

	@Test(priority = 9, description = "Verify if Invalid phone number is added")
	@Description("Test Description:Verify if Invalid phone number is added")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Verify invalid contact")
	public void testInvalidMobileStudentEntries() {
		logger.info("Starting of testInvalidMobileStudentEntries method");

		try {
			this.tutorStudentAddingPage.clickOnAddStudentsButton();
			this.tutorStudentAddingPage.clickOnAddCSVStudentsButton();
			this.tutorStudentAddingPage.clickOnInvalidMobileDataCSVFileButton();
			this.tutorStudentAddingPage.clickOnUploadFile();

			Assert.assertEquals(this.tutorStudentAddingPage.getDuplicateMobileNumber(),
					expectedAssertionsProp.getProperty(LBL_DUPLICATE_CONTACT));

			Assert.assertEquals(this.tutorStudentAddingPage.getInvalidMobileNumber(),
					expectedAssertionsProp.getProperty(LBL_INVALID_CONTACT));

			this.tutorStudentAddingPage.clickOnCloseButton();
		} catch (Exception e) {
			Assert.fail("Exception occured while testing adding students by Invalid phone number: " + e.getMessage());
			logger.error("Error occured while testing adding students by Invalid phone number ", e);
		}

		logger.info("Ending of testInvalidMobileStudentEntries method");
	}

	@Test(priority = 10, description = "Verify if some of the entries valid and some of the invalid")
	@Description("Test Description:Verify if some of the entries valid and some of the invalid")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Verify failed student data")
	public void testFailedStudentData() {
		logger.info("Starting of testFailedStudentData method");

		try {
			this.tutorStudentAddingPage.clickOnAddStudentsButton();
			this.tutorStudentAddingPage.clickOnAddCSVStudentsButton();
			this.tutorStudentAddingPage.clickOnFailedStudentFileButton();
			this.tutorStudentAddingPage.clickOnUploadFile();

			Assert.assertEquals(this.tutorStudentAddingPage.getFailedStudents(),
					expectedAssertionsProp.getProperty(LBL_INVALID_FAIL_STUDENT));

			Assert.assertEquals(this.tutorStudentAddingPage.getReloadCSV(),
					expectedAssertionsProp.getProperty(LBL_REUPLOAD_CSV));

			Assert.assertEquals(this.tutorStudentAddingPage.getProceedToPayment(),
					expectedAssertionsProp.getProperty(LBL_PROCEED_PAYMENT));
			this.tutorStudentAddingPage.clickOnCloseButton();
		} catch (Exception e) {
			Assert.fail(
					"Exception occured while testing adding students some of the entries valid and some of the invalid: "
							+ e.getMessage());
			logger.error(
					"Error occured while testing adding students some of the entries valid and some of the invalid ",
					e);
		}

		logger.info("Ending of testFailedStudentData method");
	}

	@Test(priority = 11, description = "Verify if some of the entries valid an some of the invalid,check reason for fail data")
	@Description("Test Description:Verify if some of the entries valid and some of the invalid,check reason for fail data")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Verify Reason for fail data")
	public void testReasonOnFailData() {
		logger.info("Starting of testReasonOnFailData method");

		try {
			super.uploadInvalidCSVFile(tutorStudentAddingPage);
			this.tutorStudentAddingPage.clickOnDownloadErrorFile();
			// this.tutorStudentAddingPage.getDowdloadCSVFile();
			this.tutorStudentAddingPage.clickOnCloseButton();

		} catch (Exception e) {
			Assert.fail(
					"Exception occured while testing adding students some of the entries valid and some of the invalid,check reason for fail data: "
							+ e.getMessage());
			logger.error(
					"Error occured while testing adding students some of the entries valid and some of the invalid,check reason for fail data ",
					e);
		}

		logger.info("Ending of testReasonOnFailData method");
	}

	@Test(priority = 12, description = "Verify if the number added is Already subscribed to the course ")
	@Description("Test Description:Verify  if the number added is Already subscribed to the course ")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Verify failed student data")
	public void testSubscribedCourse() {
		logger.info("Starting of testFailedStudentData method");

		try {
			this.tutorStudentAddingPage.clickOnAddStudentsButton();
			this.tutorStudentAddingPage.clickOnAddCSVStudentsButton();
			this.tutorStudentAddingPage.clickOnSubscribedStudentFileButton();
			this.tutorStudentAddingPage.clickOnUploadFile();

			Assert.assertEquals(this.tutorStudentAddingPage.getSubscribedCourseMessage(),
					expectedAssertionsProp.getProperty(LBL_SUBSCRIBED_STUDENT));

			this.tutorStudentAddingPage.clickOnCloseButton();
		} catch (Exception e) {
			Assert.fail(
					"Exception occured while testing adding students number added is Already subscribed to the course: "
							+ e.getMessage());
			logger.error("Error occured while testing adding students number added is Already subscribed to the course",
					e);
		}

		logger.info("Ending of testFailedStudentData method");
	}

	@Test(priority = 13, description = "Verify the adding student with other than csv file")
	@Description("Test Description:Verify the adding student with other than csv file")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Verify Add Student except CSV file")
	public void testWrongFormatFileExceptCSV() {
		logger.info("Starting of testWrongFormatFileExceptCSV method");

		try {
			this.tutorStudentAddingPage.clickOnAddStudentsButton();
			this.tutorStudentAddingPage.clickOnAddCSVStudentsButton();
			this.tutorStudentAddingPage.clickOnImageSelectFileButton();
			this.tutorStudentAddingPage.clickOnUploadFile();

			Assert.assertEquals(this.tutorStudentAddingPage.getUploadValidFormat(),
					expectedAssertionsProp.getProperty(LBL_UPLOAD_CSV_FORMAT));

			Assert.assertEquals(this.tutorStudentAddingPage.getReloadCSV(),
					expectedAssertionsProp.getProperty(LBL_REUPLOAD_CSV));

			this.tutorStudentAddingPage.clickOnCloseButton();
		} catch (Exception e) {
			Assert.fail("Exception occured while testing adding students by Uploading CSV to add students: "
					+ e.getMessage());
			logger.error("Error occured while testing adding students by Uploading CSV to add students ", e);
		}

		logger.info("Ending of testWrongFormatFileExceptCSV method");
	}

	@Test(priority = 14, description = "Verify the adding student with allinvalid entries csv file")
	@Description("Test Description:Verify the adding student with all invalid entries csv file")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Verify Add Student with all invalid entries CSV file")
	public void testWithAllInvalidCSVEntries() {
		logger.info("Starting of testWrongFormatFileExceptCSV method");

		try {
			this.tutorStudentAddingPage.clickOnAddStudentsButton();
			this.tutorStudentAddingPage.clickOnAddCSVStudentsButton();
			this.tutorStudentAddingPage.clickOnAllWrongEntriesFileButton();
			this.tutorStudentAddingPage.clickOnUploadFile();

			Assert.assertEquals(this.tutorStudentAddingPage.getFailedInvalidStudents(),
					expectedAssertionsProp.getProperty(LBL_FAIL_ADD_STUDENT));

			Assert.assertEquals(this.tutorStudentAddingPage.getReloadCSV(),
					expectedAssertionsProp.getProperty(LBL_REUPLOAD_CSV));

			this.tutorStudentAddingPage.clickOnCloseButton();
		} catch (Exception e) {
			Assert.fail("Exception occured while testing adding students by Uploading CSV to add students: "
					+ e.getMessage());
			logger.error("Error occured while testing adding students by Uploading CSV to add students ", e);
		}

		logger.info("Ending of testWrongFormatFileExceptCSV method");
	}

	@Test(priority = 15, description = "Verify the adding student with all valid entries csv file")
	@Description("Test Description:Verify the adding student with all valid entries csv file")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Verify Add Student with all invalid entries CSV file")
	public void testWithAllValidCSVEntries() {
		logger.info("Starting of testWithAllValidCSVEntries method");

		try {
			this.tutorStudentAddingPage.clickOnAddStudentsButton();
			this.tutorStudentAddingPage.clickOnAddCSVStudentsButton();
			this.tutorStudentAddingPage.clickOnValidEntriesFileButton();
			this.tutorStudentAddingPage.clickOnUploadFile();

			Assert.assertEquals(this.tutorStudentAddingPage.getUploadSuccessMessage(),
					expectedAssertionsProp.getProperty(MSG_SUUCCESS_UPLOADED_STUDENT));

			this.tutorStudentAddingPage.clickOnCloseButton();

			/*
			 * this.tutorStudentAddingPage.clickOnProceedToPay();
			 * this.tutorStudentAddingPage.clickOnPayNow();
			 * 
			 * Assert.assertEquals(this.tutorStudentAddingPage.getPayWallet(),
			 * expectedAssertionsProp.getProperty(LABEL_PAY_WALLET));
			 * 
			 * this.tutorStudentAddingPage.clickOnWalletCloseButton();
			 * this.tutorStudentAddingPage.clickOnCloseButton();
			 */
		} catch (Exception e) {
			Assert.fail("Exception occured while testing adding student with all valid entries csv file: "
					+ e.getMessage());
			logger.error("Error occured while testing adding student with all valid entries csv file ", e);
		}

		logger.info("Ending of testWithAllValidCSVEntries method");
	}

	@Test(priority = 16, description = "Verify the Information Visibility ForFinal Payment of student adding availablity options")
	@Description("Test Description:Verify the Information Visibility For Final Payment of student adding availablity options")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Verify Infromation visibility for final payment ")
	public void testInformationVisibilityForFinalPayment() {
		logger.info("Starting of testInformationVisibilityForFinalPayment method");

		try {
			this.tutorEditCoursePage.clickOnOverviewButton();
			this.tutorEditCoursePage.clickOnThreeDottedMenu();
			this.tutorEditCoursePage.clickOnEditIcon();

			String effectivePrice = this.tutorStudentAddingPage.getEffectivePriceLabel();
			Assert.assertEquals(effectivePrice, expectedAssertionsProp.getProperty(LABEL_EFFECTIVE_PRICE));

			this.tutorStudentAddingPage.clickOnEditCourseClose();
			this.tutorStudentAddingPage.clickOnStudentsButton();
			this.tutorStudentAddingPage.clickOnAddStudentsButton();
			this.tutorStudentAddingPage.clickOnAddStudentsManuallyButton();

			String effectiveStudentPrice = this.tutorStudentAddingPage.getStudentEffectivePriceLabel();
			Assert.assertEquals(effectiveStudentPrice, expectedAssertionsProp.getProperty(LABEL_EFFECTIVE_PRICE));

			Assert.assertEquals(effectivePrice, effectiveStudentPrice);

			Assert.assertTrue(this.tutorStudentAddingPage.getClassPlusShare());

			Assert.assertTrue(this.tutorStudentAddingPage.getNumberOfStudents());
		} catch (Exception e) {
			Assert.fail(
					"Exception occured while testing  Information Visibility For Final Payment of student adding availablity options: "
							+ e.getMessage());
			logger.error(
					"Error occured while testing  Information Visibility For Final Payment of student adding availablity options",
					e);
		}

		logger.info("Ending of testInformationVisibilityForFinalPayment method");
	}

	@Test(priority = 17, description = "Validate behaviour when tutor pressess back button or refrshes page or cancel")
	@Description("Test Description:Validate behaviour when tutor pressess back button or refrshes page or cancel")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Verify student failed payment")
	public void testStudentFailedPaymentCSVData() {
		logger.info("Starting of testFailedStudentData method");

		try {
			this.tutorStudentAddingPage.clickOnAddStudentsButton();
			this.tutorStudentAddingPage.clickOnAddCSVStudentsButton();
			this.tutorStudentAddingPage.clickOnFailedStudentFileButton();
			this.tutorStudentAddingPage.clickOnUploadFile();
			this.tutorStudentAddingPage.clickOnProceedToPay();
			this.tutorStudentAddingPage.clickOnPayNow();
			this.tutorStudentAddingPage.clickOnWalletCloseButton();

			Assert.assertEquals(this.studentPayInstallmentCoursePage.getPaymentFailedHeadingLabel(),
					expectedAssertionsProp.getProperty(LABEL_PAYMENT_FAILED_HEADING));

			this.tutorStudentAddingPage.clickOnCloseButton();
		} catch (Exception e) {
			Assert.fail(
					"Exception occured while testing adding students behaviour when tutor pressess back button or refrshes page or cancel: "
							+ e.getMessage());
			logger.error(
					"Error occured while testing adding students behaviour when tutor pressess back button or refrshes page or cancel ",
					e);
		}

		logger.info("Ending of testFailedStudentData method");
	}

	@Test(priority = 18, description = "Verify the tutor should be able to filterand see the transactions in the merchant dashboard")
	@Description("Test Description:Verify the tutor should be able to filter and see the transactions in the merchant dashboard")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Verify student transaction history")
	public void testStudentTransactionHistory() {
		logger.info("Starting of testStudentTransactionHistory method");

		try {
			this.tutorMerchantDashboardPage.clickOnTutorDropdown();
			this.tutorMerchantDashboardPage.clickOnMerchantDashboardLabel();

			Assert.assertEquals(this.tutorStudentAddingPage.getEarningsLabelText(),
					expectedAssertionsProp.getProperty(LABEL_EARNINGS));

			Assert.assertEquals(this.tutorStudentAddingPage.getTransactionsLabelText(),
					expectedAssertionsProp.getProperty(LBL_TRANSACTIONS));

			this.tutorStudentAddingPage.clickCourseTransactionIcon();
			this.tutorStudentAddingPage.getCountPurchase();
			this.tutorStudentAddingPage.clickOnShowTransactionHistory();
			this.tutorStudentAddingPage.getShowTransactionHistory();

			Assert.assertTrue(this.tutorStudentAddingPage.getTransactionHistory());
		} catch (Exception e) {
			Assert.fail(
					"Exception occured while testing adding the tutor should be able to filter and see the transactions in the merchant dashboard: "
							+ e.getMessage());
			logger.error(
					"Error occured while testing adding the tutor should be able to filter and see the transactions in the merchant dashboard ",
					e);
		}

		logger.info("Ending of testStudentTransactionHistory method");
	}

	@Test(priority = 19, description = "Verify the tutor is able to download the payment receipt of paying the commission amount from merchant dashboard")
	@Description("Test Description:Verify the tutor is able to download the payment receipt of paying the commission amount from merchant dashboard")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Verify download student Reciept")
	public void testDownloadedPaymentReceiptFromStudentTab() {
		logger.info("Starting of testDownloadedPaymentReceipt method");

		try {
			this.tutorStudentAddingPage.clickOnStudentsButton();
			this.tutorStudentSortingPage.clickOnKebabButton();
			this.tutorStudentAddingPage.clickOnDownloadReceipt();

			Assert.assertEquals(this.tutorStudentAddingPage.getInvoice(),
					expectedAssertionsProp.getProperty(LBL_INVOICE));

			System.out.println(driver.getWindowHandles());
			tutorMerchantDashboardPage.switchToDefault();
		} catch (Exception e) {
			Assert.fail("Exception occured while testing adding students download payment Reciept: " + e.getMessage());
			logger.error("Error occured while testing adding students download payment Reciept ", e);
		}

		logger.info("Ending of testDownloadedPaymentReceipt method");
	}

	@Test(priority = 20, description = "Verify the tutor is able to downloadthepayment receipt of paying the commission amount from merchant dashboard")
	@Description("Test Description:Verify the tutor is able to download the payment receipt of paying the commission amount from merchant dashboard")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Verify download student Reciept")
	public void testDownloadedPaymentReceipt() {
		logger.info("Starting of testDownloadedPaymentReceipt method");

		try {
			this.tutorMerchantDashboardPage.clickOnTutorDropdown();
			this.tutorMerchantDashboardPage.clickOnMerchantDashboardLabel();

			boolean salesType = this.tutorStudentAddingPage.getBackendTransactionHistory();

			this.tutorStudentAddingPage.clickOnShowTransactionHistory();
			this.tutorStudentAddingPage.clickOnDownloadStudentReceipt();

			Assert.assertEquals(this.tutorStudentAddingPage.getTaxInvoice(),
					expectedAssertionsProp.getProperty(LBL_TAX_INVOICE));

			boolean invoiceSalesType = this.tutorStudentAddingPage.getBackedAddition();

			Assert.assertEquals(salesType, invoiceSalesType);
			driver.close();

		} catch (Exception e) {
			Assert.fail("Exception occured while testing adding students download payment Reciept: " + e.getMessage());
			logger.error("Error occured while testing adding students download payment Reciept ", e);
		}

		logger.info("Ending of testDownloadedPaymentReceipt method");
	}

	@Test(priority = 21, description = "Verify student receive notification in chats")
	@Description("Test Description:Verify student recieve notification in chats")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Verify student receive notification ")
	public void testDownloadRecieptStatusInChats() {
		logger.info("Starting of testFailedStudentData method");

		try {
			this.tutorStudentAddingPage.clickOnStudentsButton();
			String studentName = this.tutorStudentAddingPage.lblStudentName();
			this.tutorStudentSortingPage.clickOnKebabButton();
			this.tutorStudentAddingPage.clickOnStudentDownloadReceipt();
			this.tutorStudentAddingPage.clickOnChats();

			Assert.assertEquals(this.tutorStudentAddingPage.lblChats(), expectedAssertionsProp.getProperty(LBL_CHATS));

			this.tutorStudentAddingPage.clickOnChatMessageLabel();
			String studentChatName = this.tutorStudentAddingPage.lblChatStudentName();

			Assert.assertEquals(studentName, studentChatName);
		} catch (Exception e) {
			Assert.fail("Exception occured while testing student receive notification in chats: " + e.getMessage());
			logger.error("Error occured while testing astudent receive notification in chat ", e);
		}

		logger.info("Ending of testFailedStudentData method");
	}

	@AfterClass
	public void quitDriver() {
		logger.info("Starting of quitDriver method");

		try {
			if (this.driver != null) {
				Thread.sleep(5000);
				this.loginPage.clickOnLogOut();
				this.quitDriver(this.driver, WEB_DRIVER.TUTOR_STUDENT_ADDING_TEST);
				logger.info("Driver quit successfully");
			}
		} catch (Exception ex) {
			logger.error(ex.getMessage());
		}

		logger.info("Ending of quitDriver method");
	}

	@AfterMethod
	public void getConsoleLoggers() {
		logger.info("Starting of getConsoleLogger method");

		this.logBrowserConsoleErrors(this.driver);

		logger.info("Ending of getConsoleLogger method");
	}

}