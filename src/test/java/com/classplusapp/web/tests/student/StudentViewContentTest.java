package com.classplusapp.web.tests.student;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static com.classplusapp.store.util.Constants.*;

import com.classplusapp.web.pages.student.StudentBuyCoursePage;
import com.classplusapp.web.pages.student.StudentViewContentPage;
import com.classplusapp.web.pages.tutor.TutorAddContentPage;
import com.classplusapp.web.pages.tutor.TutorCreateCoursePage;
import com.classplusapp.web.tests.BaseClassplusAutomationTest;
import com.classplusapp.web.tests.CommonFunctionStoreTest;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Epic("Store Overview")
@Feature("Student View Content Test")
public class StudentViewContentTest extends BaseClassplusAutomationTest {

	private WebDriver driver = null;
	private WebDriver tutorDriver = null;
	private StudentViewContentPage studentViewContentPage = null;
	private StudentBuyCoursePage buyCoursePage = null;
	private CommonFunctionStoreTest storeCommonFunctions = null;
	private TutorCreateCoursePage createCoursePage = null;
	private String createdCourseName;
	private TutorAddContentPage addContentPage = null;
	private static final Logger logger = Logger.getLogger(StudentViewContentTest.class.getName());

	@BeforeClass
	@Parameters({ "browser", "orgCode", "orgCode2" })
	public void initClassplusSiteLogin(@Optional("Chrome") String browser, @Optional("learn") String tutorOrgCode,
			@Optional("learn") String studentOrgCode) throws Exception {
		logger.info("Starting of initClassplusSiteLogin methond");

		this.driver = super.loginClassPlusSite(browser, studentOrgCode, studentMobileNumber, emailAddress,
				WEB_DRIVER.STUDENT_VIEW_CONTENT_TEST);
		this.tutorDriver = super.loginClassPlusSite(browser, tutorOrgCode, tutorMobileNumber, emailAddress,
				WEB_DRIVER.TUTOR_CREATE_COURSE_AUTOMATION_TESTING);
		this.studentViewContentPage = new StudentViewContentPage(this.driver);
		buyCoursePage = new StudentBuyCoursePage(this.driver);
		this.studentViewContentPage = new StudentViewContentPage(this.driver);
		buyCoursePage = new StudentBuyCoursePage(this.driver);
		this.storeCommonFunctions = new CommonFunctionStoreTest();
		this.createCoursePage = new TutorCreateCoursePage(this.tutorDriver);
		this.addContentPage = new TutorAddContentPage(this.tutorDriver);

		createdCourseName = this.storeCommonFunctions.createSimpleCourse(createCoursePage);
		this.storeCommonFunctions.addCourseContent(addContentPage, testDataProp.getProperty(LABEL_FOR_UPLOADING_IMAGE));
		String toastMsgText1 = this.addContentPage.getSuccessImageMessageText();
		Assert.assertEquals(toastMsgText1, expectedAssertionsProp.getProperty(IMAGE_ADDED_SUCCESSFULLY_TEXT));
		this.tutorDriver.navigate().refresh();
		Thread.sleep(2000);

		this.storeCommonFunctions.addCourseContent(addContentPage, testDataProp.getProperty(LABEL_FOR_UPLOADING_PDF));
		String toastMsgText2 = this.addContentPage.getSuccessDocumentMessageText();
		Assert.assertEquals(toastMsgText2, expectedAssertionsProp.getProperty(ADD_DOCUMENT_SUCCESSFULLY_TEXT));
		this.tutorDriver.navigate().refresh();

		this.storeCommonFunctions.publishCourse(createCoursePage);

		logger.info("Ending of initClassplusSiteLogin method");
	}

	@Test(priority = 1, description = "Verify Student Select Course Page and Course Content Summary")
	@Description("Test Description:Verify Student Select Course Page and Course Content Summary")
	@Severity(SeverityLevel.CRITICAL)
	@Story("Verify Student Select Course Page and Course Content Summary")
	public void testSelectCourseandCourseContentSummary() {
		logger.info("Starting of testSelectCourse method");

		try {
			this.studentViewContentPage.clickOnStoreButton();
			this.studentViewContentPage.setSearchArea(createdCourseName);
			this.studentViewContentPage.clickOnGetCourse(createdCourseName);
			this.studentViewContentPage.clickOnOverviewButton();

			String lblSummary = this.studentViewContentPage.getOnContentSummary();
			Assert.assertEquals(lblSummary, expectedAssertionsProp.getProperty(STUDENT_VIEW_CONTENT_SUMMARY));

		} catch (Exception e) {
			Assert.fail("Exception occured while testing Student Select Course Page : " + e.getMessage());
			logger.error("Error occured while testing Student Select Course Page ", e);
		}

		logger.info("Ending of testSelectCourse method");
	}

	@Test(priority = 2, description = "Verify Student View Folder Page")
	@Description("Test Description:Verify Student View Folder Page")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verify Student View Folder Page")
	public void testViewFolder() {
		logger.info("Starting of testViewFolder method");

		try {
			this.studentViewContentPage.clickOnStoreButton();
			this.studentViewContentPage.setSearchArea(testDataProp.getProperty(STUDENT_VIEW_CONTENT_SEARCH_COURSE));
			this.studentViewContentPage.clickOnGetCourse(testDataProp.getProperty(STUDENT_VIEW_CONTENT_SEARCH_COURSE));
			this.studentViewContentPage.clickOnContentButton();
			this.studentViewContentPage.clickOnFilesMenu();
			this.studentViewContentPage.clickOnImagesB2b();

			String lblContentCannotViewed = this.studentViewContentPage.getContentCannotViewedLabel();
			Assert.assertEquals(lblContentCannotViewed,
					expectedAssertionsProp.getProperty(LABEL_STUDENT_CONTENT_CANNOT_VIEWED));

			this.studentViewContentPage.clickOnVideoTestCancel();
			this.studentViewContentPage.clickOnPreviousIcon();
		} catch (Exception e) {
			Assert.fail("Exception occured while testing Student View Folder Page : " + e.getMessage());
			logger.error("Error occured while testing Student View Folder Page ", e);
		}

		logger.info("Ending of testViewFolder method");
	}

	@Test(priority = 3, description = "Verify Student View Video")
	@Description("Test Description:Verify Student View Video")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Verify Student View Video")
	public void testViewVideo() {
		logger.info("Starting of testViewVideo method");

		try {
			this.studentViewContentPage.clickOnStoreButton();
			Thread.sleep(2000);
			this.studentViewContentPage.setSearchArea(testDataProp.getProperty(STUDENT_VIEW_CONTENT_SEARCH_COURSE));
			this.studentViewContentPage.clickOnGetCourse(testDataProp.getProperty(STUDENT_VIEW_CONTENT_SEARCH_COURSE));
			this.studentViewContentPage.clickOnContentButton();
			this.studentViewContentPage.clickOnVideoTest();

			String lblContentCannotViewed = this.studentViewContentPage.getContentCannotViewedLabel();
			System.out.println(lblContentCannotViewed);
			Assert.assertEquals(lblContentCannotViewed,
					expectedAssertionsProp.getProperty(LABEL_STUDENT_CONTENT_CANNOT_VIEWED));

			this.studentViewContentPage.clickOnVideoTestCancel();

		} catch (Exception e) {
			Assert.fail("Exception occured while testing  Student View Video: " + e.getMessage());
			logger.error("Error occured while testing Student View Video", e);
		}

		logger.info("Ending of testViewVideo method");
	}

	@Test(priority = 4, description = "Verify Student View Image")
	@Description("Test Description:Verify Student View Image")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verify Student View Image")
	public void testViewImage() {
		logger.info("Starting of testViewImage method");

		try {
			this.studentViewContentPage.clickOnStoreButton();
			Thread.sleep(2000);
			this.studentViewContentPage.setSearchArea(createdCourseName);
			this.studentViewContentPage.clickOnGetCourse(createdCourseName);
			this.studentViewContentPage.clickOnContentButton();
			this.studentViewContentPage.clickOnSampleImage();
			try {
				String lblContentCannotViewed = this.studentViewContentPage.getContentCannotViewedLabel();
				System.out.println(lblContentCannotViewed);
				Assert.assertEquals(lblContentCannotViewed,
						expectedAssertionsProp.getProperty(LABEL_STUDENT_CONTENT_CANNOT_VIEWED));
			} catch (Exception e) {
				String lblContentCannotViewed = this.studentViewContentPage.getContentCannotViewedLabelonWeb();
				Assert.assertEquals(lblContentCannotViewed,
						expectedAssertionsProp.getProperty(LABEL_STUDENT_CONTENT_CANNOT_VIEWED_ON_THE_WEB));
			}

			this.studentViewContentPage.clickOnCancelImage();
		} catch (Exception e) {
			Assert.fail("Exception occured while testing Student View Image: " + e.getLocalizedMessage());
			logger.error("Error occured while testing Student View Image ", e);
		}

		logger.info("Ending of testViewImage method");
	}

	@Test(priority = 5, description = "Verify student View Document")
	@Description("Test Description:Verify Student View Document")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Verify student View Document")
	public void testViewDocument() {
		logger.info("Starting of testviewDocument method");

		try {
			this.studentViewContentPage.clickOnStoreButton();
			Thread.sleep(2000);
			this.studentViewContentPage.setSearchArea(createdCourseName);
			this.studentViewContentPage.clickOnGetCourse(createdCourseName);
			this.studentViewContentPage.clickOnContentButton();
			this.studentViewContentPage.clickOnDocumentSample();

			String lblContentCannotViewed = this.studentViewContentPage.getContentCannotViewedLabelonWeb();
			Assert.assertEquals(lblContentCannotViewed,
					expectedAssertionsProp.getProperty(LABEL_STUDENT_CONTENT_CANNOT_VIEWED_ON_THE_WEB));

			this.studentViewContentPage.clickOnCancelImage();
		} catch (Exception e) {
			Assert.fail("Exception occured while testing Student View Document: " + e.getMessage());
			logger.error("Error occured while testing Student View Document", e);
		}

		logger.info("Ending of testviewDocument method");
	}

	@Test(priority = 6, description = "Verify Student Download ZipFile")
	@Description("Test Description:Verify Student Download ZipFile")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Verify Student Download ZipFile")
	public void testViewZipFile() {
		logger.info("Starting of testDownloadZipFile method");

		try {
			this.studentViewContentPage.clickOnStoreButton();
			Thread.sleep(2000);
			this.studentViewContentPage.setSearchArea(testDataProp.getProperty(STUDENT_VIEW_CONTENT_SEARCH_COURSE));
			this.studentViewContentPage.clickOnGetCourse(testDataProp.getProperty(STUDENT_VIEW_CONTENT_SEARCH_COURSE));
			this.studentViewContentPage.clickOnContentButton();
			this.studentViewContentPage.clickOnSampleZipFile();

			try {
				String lblContentCannotViewed = this.studentViewContentPage.getContentCannotViewedLabel();
				System.out.println(lblContentCannotViewed);
				Assert.assertEquals(lblContentCannotViewed,
						expectedAssertionsProp.getProperty(LABEL_STUDENT_CONTENT_CANNOT_VIEWED));
			} catch (Exception e) {

				String lblContentCannotViewed = this.studentViewContentPage.getContentCannotViewedLabelonWeb();
				Assert.assertEquals(lblContentCannotViewed,
						expectedAssertionsProp.getProperty(LABEL_STUDENT_CONTENT_CANNOT_VIEWED_ON_THE_WEB));
			}

			this.studentViewContentPage.clickOnVideoTestCancel();

		} catch (Exception e) {
			Assert.fail("Exception occured while testing Student Download ZipFile: " + e.getMessage());
			logger.error("Error occured while testing Student Download ZipFile ", e);
		}

		logger.info("Ending of testDownloadZipFile method");
	}

	@Test(priority = 7, description = "Verify Student Talk to Tutor")
	@Description("Test Description:Verify Student Talk to Tutor")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verify Student Talk to Tutor")
	public void testTalkToTutor() {
		logger.info("Starting of testTalkToTutor method");

		try {
			this.studentViewContentPage.clickOnStoreButton();
			this.studentViewContentPage.setSearchArea(testDataProp.getProperty(STUDENT_VIEW_CONTENT_SEARCH_COURSE));
			this.studentViewContentPage.clickOnGetCourse(testDataProp.getProperty(STUDENT_VIEW_CONTENT_SEARCH_COURSE));
			this.studentViewContentPage.clickOnContentButton();
			this.studentViewContentPage.clickOnTalkToTutorButton();

			String lblChats = this.studentViewContentPage.getChatsLabelText();
			Assert.assertEquals(lblChats, expectedAssertionsProp.getProperty(STUDENT_VIEW_CONTENT_TALK_TO_TUTOR));

			this.studentViewContentPage.setMessageToTutor(testDataProp.getProperty(STUDENT_MESSAGE_TO_TUTOR));
			this.studentViewContentPage.clickOnSendMessage();
		} catch (Exception e) {
			Assert.fail("Exception occured while testing Student Talk to Tutor: " + e.getMessage());
			logger.error("Error occured while testing Student Talk to Tutor", e);
		}

		logger.info("Ending of testTalkToTutor method");
	}

	@Test(priority = 8, description = "Verify Student Copy Course Link")
	@Description("Test Description:Verify Student Copy Course Link")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verify Student Copy Course Link")
	public void testCopyCourseLink() {
		logger.info("Starting of testCopyCourseLink method");

		try {
			this.studentViewContentPage.clickOnStoreButton();
			this.studentViewContentPage.setSearchArea(testDataProp.getProperty(STUDENT_VIEW_CONTENT_SEARCH_COURSE));
			this.studentViewContentPage.clickOnGetCourse(testDataProp.getProperty(STUDENT_VIEW_CONTENT_SEARCH_COURSE));
			this.studentViewContentPage.clickOnOverviewButton();
			this.studentViewContentPage.clickOnShareButton();
			this.studentViewContentPage.clickOnCopyLinkButton();

			String linkcopied = this.studentViewContentPage.getCourseLinkText();
			Assert.assertEquals(linkcopied, expectedAssertionsProp.getProperty(STUDENT_LINK_COPIED_TEXT));

			this.studentViewContentPage.clickOnCloseShareButton();

		} catch (Exception e) {
			Assert.fail("Exception occured while testing Student Copy Course Link: " + e.getMessage());
			logger.error("Error occured while testing Student Copy Course Link ", e);
		}

		logger.info("Ending of testCopyCourseLink method");
	}

	@AfterClass
	public void quitDriver() {
		logger.info("Starting of quitDriver method");

		try {
			if (this.driver != null) {
				Thread.sleep(10000);
				this.loginPage.clickOnLogOut();
				this.quitDriver(this.driver, WEB_DRIVER.STUDENT_VIEW_CONTENT_TEST);
				logger.info("Driver quit successfully");
			}
		} catch (Exception ex) {
			logger.error(ex.getMessage());
		}

		logger.info("Ending of quitDriver method");
	}

}
