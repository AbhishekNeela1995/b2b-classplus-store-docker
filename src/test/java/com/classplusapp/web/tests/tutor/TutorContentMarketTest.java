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

import com.classplusapp.web.pages.tutor.TutorAnnouncementPage;
import com.classplusapp.web.pages.tutor.TutorContentMarketPage;
import com.classplusapp.web.pages.tutor.TutorCreateCoursePage;
import com.classplusapp.web.tests.BaseClassplusAutomationTest;

import static com.classplusapp.store.util.Constants.*;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Epic("Store Content Market")
@Feature("Content Market Test")

public class TutorContentMarketTest extends BaseClassplusAutomationTest {

	private WebDriver driver = null;
	private TutorContentMarketPage tutorContentMarketPage = null;
	private TutorCreateCoursePage tutorCreateCoursePage = null;
	// private TutorAnnouncementPage tutorAnnouncementPage = null;

	private static final Logger logger = Logger.getLogger(TutorContentMarketTest.class.getName());

	@BeforeClass
	@Parameters({ "browser", "orgCode" })
	public void initClassplusSiteLogin(@Optional("Chrome") String browser, @Optional("learn") String orgCode)
			throws Exception {
		logger.info("Starting of initClassplusSiteLogin methond");

		// String searchCourse = testDataProp.getProperty(CONTENTMARKET_SEARCH_COURSE);
		this.driver = super.loginClassPlusSite(browser, orgCode, tutorMobileNumber, emailAddress,
				WEB_DRIVER.CONTENT_MARKET_TEST);
		// this.driver = super.clickOnStoreButton(driver, searchCourse);
		this.tutorCreateCoursePage = new TutorCreateCoursePage(driver);
		this.tutorContentMarketPage = new TutorContentMarketPage(driver);
		// this.tutorAnnouncementPage = new TutorAnnouncementPage(driver);

		logger.info("Ending of initClassplusSiteLogin method");
	}

	@Test(priority = 1, description = "Verify Content Market Page")
	@Description("Test Description:Verify Content Market Page")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verify Content Market Page")
	public void testContentMarketPage() {
		logger.info("Starting of testContentMarketPage method");

		try {
			this.tutorCreateCoursePage.clickOnStoreButton();

			// Assertion for checking content market label
			String lblContentMarket = this.tutorContentMarketPage.getContentMarketLabel();
			Assert.assertEquals(lblContentMarket, expectedAssertionsProp.getProperty(LABEL_CONTENT_MARKET));

			this.tutorContentMarketPage.clickOnContentMarketButton();
			this.tutorContentMarketPage.searchCourse(testDataProp.getProperty(CONTENTMARKET_SEARCH_COURSE));
			this.tutorContentMarketPage.clickOnCourse();
			this.tutorContentMarketPage.clickOnReadMore();
			this.tutorContentMarketPage.clickOnReadLess();
			this.tutorContentMarketPage.clickOnContentcourses();

			this.tutorContentMarketPage.clickOnAddToMyCourses();
		} catch (Exception e) {
			Assert.fail("Exception occured while testing content market page: " + e.getMessage());
			logger.error("Error occured while testing content market page ", e);
		}
		logger.info("Ending of testContentMarketPage method");

	}

	@Test(priority = 2, description = "Verify Save MyCourse Page")
	@Description("Test Description:Verify Save MyCourse Page")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verify Save Course Page")
	public void testSaveMyCourse() {
		logger.info("Starting of testSaveMyCourse method");

		try {

			// Assertion for checking save course label
			String lblSaveCourse = this.tutorContentMarketPage.getSaveCourseLabel();
			Assert.assertEquals(lblSaveCourse, expectedAssertionsProp.getProperty(CONTENT_MARKET_SAVE_COURSE_TEXT));

			this.tutorContentMarketPage.clickOnCheckBox();
			this.tutorContentMarketPage.clickOnSaveCourseButton();

		} catch (Exception e) {
			Assert.fail("Exception occured while testing Save MyCourse page: " + e.getMessage());
			logger.error("Error occured while testing Save MyCourse page ", e);
		}
		logger.info("Ending of testSaveMyCourse method");

	}

	@Test(priority = 3, description = "Verify My Courses Page")
	@Description("Test Description:Verify My Courses Page")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verify My Courses Page")
	public void testMyCoursesPage() {
		logger.info("Starting of testMyCoursesPage method");
		try {
			this.tutorCreateCoursePage.clickOnStoreButton();

			// Assertion for checking my course label
			String lblMyCourses = this.tutorContentMarketPage.getMyCoursesLabel();
			Assert.assertEquals(lblMyCourses, expectedAssertionsProp.getProperty(LABEL_STORE_MYCOURSES));

			this.tutorContentMarketPage.searchCourse(testDataProp.getProperty(MYCOURSE_SEARCH_COURSE));
			this.tutorContentMarketPage.clickOnSavedCourse();
		} catch (Exception e) {
			Assert.fail("Exception occured while testing  My Courses Page: " + e.getMessage());
			logger.error("Error occured while testing MyCourse page ", e);
		}
		logger.info("Ending of testMyCoursesPage method");

	}

	@Test(priority = 4, description = "Verify My Courses Update Page")
	@Description("Test Description:Verify My Courses Update Page")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verify My Courses Update Page")
	public void testCourseUpdatePage() {
		logger.info("Starting of testCourseUpdatePage method");
		try {

			this.tutorContentMarketPage.clickOnContent();
			this.tutorContentMarketPage.clickOnUpdateButton();

			// Assertion for checking update label
			String lblUpdate = this.tutorContentMarketPage.getUpdatesLabel();
			Assert.assertEquals(lblUpdate, expectedAssertionsProp.getProperty(LABEL_MYCOURSE_UPDATE));

		} catch (Exception e) {
			Assert.fail("Exception occured while testing my courses Update page: " + e.getMessage());
			logger.error("Error occured while testing my courses Update page ", e);
		}
		logger.info("Ending of testCourseUpdatePage method");

	}

	@Test(priority = 5, description = "Verify My Courses Student Page")
	@Description("Test Description:Verify My Courses Student Page")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verify My Courses Update Page")
	public void testStudentsPage() {
		logger.info("Starting of testStudentsPage method");
		try {

			this.tutorContentMarketPage.clickOnStudentsButton();

			// Assertion for checking Student label
			String lblStudent = this.tutorContentMarketPage.getStudentLabel();
			Assert.assertEquals(lblStudent, expectedAssertionsProp.getProperty(LABEL_MYCOURSE_STUDENT));

		} catch (Exception e) {
			Assert.fail("Exception occured while testing my courses Student page: " + e.getMessage());
			logger.error("Error occured while testing my courses Student page ", e);
		}
		logger.info("Ending of testStudentsPage method");

	}

	@Test(priority = 6, description = "Verify Make Announcement")
	@Description("Test Description: Verify Make Announcement")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verify Make Announcement")
	public void testMakeAnnouncement() {
		logger.info("Starting of testMakeAnnouncement method");

		try {
			this.tutorContentMarketPage.clickOnAnnouncementIcon();
			this.tutorContentMarketPage.clickOnMakeAnnouncement();

			// Assertion of for checking Make Announcement page label
			String makeAnnounceMessageText = this.tutorContentMarketPage.getMakeAnAnnouncementLabel();
			Assert.assertEquals(makeAnnounceMessageText, expectedAssertionsProp.getProperty(LABEL_MAKE_ANNOUNCEMENT));

		} catch (Exception e) {
			Assert.fail("Exception occured while testing MakeAnnouncement page: " + e.getMessage());
			logger.error("Error occured while testing MakeAnnouncement page ", e);
		}
		logger.info("Ending of testMakeAnnouncement method");

	}

	@Test(priority = 7, description = "Verify Post Image Announcement")
	@Description("Test Description: Verify Post Image Announcement")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verify Post Image Announcement")
	public void testImagePostAnnouncement() {
		logger.info("Starting of testImagePostAnnouncement method");

		try {
			this.tutorContentMarketPage
					.clickOnMakeAnnonceText(testDataProp.getProperty(ANNOUNCEMENT_MAKEANNOUNCE_TEXT));
			this.tutorContentMarketPage.clickOnAttachFile();

			// Assertion for checking post SMS label
			String sendSMSLabel = this.tutorContentMarketPage.getSendSMSLabel();
			Assert.assertEquals(sendSMSLabel, expectedAssertionsProp.getProperty(LABEL_POSTSMS_ANNOUNCEMENT));

			this.tutorContentMarketPage.clickOnAddPostButton();

			// Assertion for checking added image announcement text
			String addAnnounceMessageText = this.tutorContentMarketPage.getAnnounceAddedMessage();
			Assert.assertEquals(addAnnounceMessageText,
					expectedAssertionsProp.getProperty(ANNOUNCE_ADDED_SUCCESSFULLY_TEXT));

		} catch (Exception e) {
			Assert.fail("Exception occured while testing Post Image announcement: " + e.getMessage());
			logger.error("Error occured while testing Post Image announcement ", e);
		}
		logger.info("Ending of testImagePostAnnouncement method");

	}

	@Test(priority = 8, description = "Verify Post Document Announcement")
	@Description("Test Description: Verify Post Document Announcement")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verify Post Document Announcement")
	public void testPdfPostAnnouncement() {
		logger.info("Starting of testPdfPostAnnouncement method");

		try {
			this.tutorContentMarketPage.clickOnMakeAnnouncement1();
			this.tutorContentMarketPage
					.clickOnMakePdfAnnonceText(testDataProp.getProperty(ANNOUNCEMENT_MAKEANNOUNCE_DOCUMENT));
			this.tutorContentMarketPage.clickOnAttachFileDoc();
			this.tutorContentMarketPage.clickOnPost1();

			// Assertion for checking added document announcement text
			String addDocumentAnnounceMessageText = this.tutorContentMarketPage.announceAddedMessage1();
			Assert.assertEquals(addDocumentAnnounceMessageText,
					expectedAssertionsProp.getProperty(ANNOUNCE_PDF_ADDED_SUCCESSFULLY_TEXT));

		} catch (Exception e) {
			Assert.fail("Exception occured while testing Post Document announcement: " + e.getMessage());
			logger.error("Error occured while testing Post Document announcement ", e);
		}
		logger.info("Ending of testPdfPostAnnouncement method");

	}

	@Test(priority = 9, description = "Verify Post Excel Announcement")
	@Description("Test Description: Verify Post Excel  Announcement")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verify Post Excel  Announcement")
	public void testExcelPostAnnouncement() {
		logger.info("Starting of testExcelPostAnnouncement method");

		try {

			this.tutorContentMarketPage.clickOnMakeExcelAnnouncement();
			this.tutorContentMarketPage.clickOnMakeExcelAnnonceText(
					testDataProp.getProperty(CONTENTMARKET_ANNOUNCEMENT_MAKEANNOUNCE_EXCEL));
			this.tutorContentMarketPage.clickOnAttachFileExcel();
			this.tutorContentMarketPage.clickOnPost2();

			// Assertion for checking added excel announcement text
			String addAnnounceMessageText2 = this.tutorContentMarketPage.announceAddedMessage2();
			Assert.assertEquals(addAnnounceMessageText2,
					expectedAssertionsProp.getProperty(ANNOUNCE_EXCEL_ADDED_SUCCESSFULLY_TEXT));

		} catch (Exception e) {
			Assert.fail("Exception occured while testing the  post excel announcements : " + e.getMessage());
			logger.error("Error occured while testing the post excel announcements ", e);
		}

		logger.info("Ending of testExcelPostAnnouncement method");
	}

	@Test(priority = 10, description = "Verify Edit Excel Announcements")
	@Description("Test Description: Verify Edit Excel Announcement")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verify Edit Excel Announcements")
	public void testEditExcelAnnouncement() {
		logger.info("Starting of testEditExcelAnnouncement method");

		try {
			this.tutorContentMarketPage.clickOnThreeDottedMenu();
			this.tutorContentMarketPage.clickOnEditIcon();
			this.tutorContentMarketPage.clickOnEditMakeAnnonceText(
					testDataProp.getProperty(CONTENTMARKET_ANNOUNCEMENT_EDIT_MAKEANNOUNCE_TEXT));
			this.tutorContentMarketPage.clickOnEditPostButton();

			// Assertion for checking edited excel announcement text
			String editAnnounceMessage = this.tutorContentMarketPage.getAnnouncementEditedMessage();
			Assert.assertEquals(editAnnounceMessage,
					expectedAssertionsProp.getProperty(ANNOUNCE_EDIT_SUCCESSFULLY_TEXT));

		} catch (Exception e) {
			Assert.fail("Exception occured while testing the  edit excel announcements : " + e.getMessage());
			logger.error("Error occured while testing the edit excel announcements ", e);
		}

		logger.info("Ending of testEditExcelAnnouncement method");
	}

	@Test(priority = 11, description = "Verify Remove Announcements")
	@Description("Test Description: Verify Remove Announcements")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verify Remove Announcements")
	public void testDeleteAnnouncements() {
		logger.info("Starting of testDeleteAnnouncements method");

		try {
			this.tutorContentMarketPage.clickOnThreeHorizontalDottedMenu();
			this.tutorContentMarketPage.clickOnRemoveIcon();

			// Assertion for checking removed announcements Heading text
			String deleteAnnounceLabel = this.tutorContentMarketPage.getDeleteAnnouncementLabel();
			Assert.assertEquals(deleteAnnounceLabel,
					expectedAssertionsProp.getProperty(LABEL_ANNOUNCEMENT__DELETE_TEXT));

			// Assertion for checking removed announcements text
			String DeleteAnnouncementText = this.tutorContentMarketPage.getDeleteAnnouncementText();
			Assert.assertEquals(DeleteAnnouncementText,
					expectedAssertionsProp.getProperty(LABEL_ANNOUNCEMENT_DELETE_CONFIRM_TEXT));

			this.tutorContentMarketPage.clickOnDeleteButton();
			this.tutorContentMarketPage.clickOnThreeHorizontalDottedMenu();
			this.tutorContentMarketPage.clickOnRemoveIcon();
			// Assertion for checking removed announcements Heading text
			String deleteAnnounceLabel1 = this.tutorContentMarketPage.getDeleteAnnouncementLabel();
			Assert.assertEquals(deleteAnnounceLabel1,
					expectedAssertionsProp.getProperty(LABEL_ANNOUNCEMENT__DELETE_TEXT));

			// Assertion for checking removed announcements text
			String DeleteAnnouncementsText = this.tutorContentMarketPage.getDeleteAnnouncementText();
			Assert.assertEquals(DeleteAnnouncementsText,
					expectedAssertionsProp.getProperty(LABEL_ANNOUNCEMENT_DELETE_CONFIRM_TEXT));

			this.tutorContentMarketPage.clickOnDeleteButton();
			this.tutorContentMarketPage.clickOnThreeHorizontalDottedMenu();

			this.tutorContentMarketPage.clickOnRemoveIcon();
			// Assertion for checking removed announcements Heading text
			String deleteAnnouncementLabel = this.tutorContentMarketPage.getDeleteAnnouncementLabel();
			Assert.assertEquals(deleteAnnouncementLabel,
					expectedAssertionsProp.getProperty(LABEL_ANNOUNCEMENT__DELETE_TEXT));

			// Assertion for checking removed announcements text
			String DeleteAnnouncmentsText = this.tutorContentMarketPage.getDeleteAnnouncementText();
			Assert.assertEquals(DeleteAnnouncmentsText,
					expectedAssertionsProp.getProperty(LABEL_ANNOUNCEMENT_DELETE_CONFIRM_TEXT));

			this.tutorContentMarketPage.clickOnDeleteButton();
		} catch (Exception e) {
			Assert.fail("Exception occured while testing the  remove announcements : " + e.getMessage());
			logger.error("Error occured while testing the remove announcements ", e);
		}

		logger.info("Ending of testDeleteAnnouncements method");
	}

	@Test(priority = 12, description = "Verify Publish course")
	@Description("Test Description:Verify Publish course")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verify Publish course")
	public void testPublishCourse() {
		logger.info("Starting of testPublishCourse method");

		try {
			this.tutorContentMarketPage.clickOnPublishCourseButton();

			// Assertion for checking course publish label
			String lblPublishCourse = this.tutorContentMarketPage.getlabelPublishCourseText();
			Assert.assertEquals(lblPublishCourse, expectedAssertionsProp.getProperty(LABEL_CONTENT_PUBLISH_COURSE));

			this.tutorContentMarketPage.clickOnPublishCourse1();
			this.tutorContentMarketPage.clickOnCrossButton();

			// Assertion for checking course publish text
			String publishSucces = this.tutorContentMarketPage.getPublishSuccessText();
			Assert.assertEquals(publishSucces, expectedAssertionsProp.getProperty(COURSE_PUBLISHED_SUCCESSFULLY_TEXT));
		} catch (Exception e) {
			Assert.fail("Exception occured while testing  Publish course " + e.getMessage());
			logger.error("Error occured while testing Publish course ", e);
		}

		logger.info("Ending of testPublishCourse method");
	}

	@Test(priority = 13, description = "Verify UnPublish course")
	@Description("Test Description:Verify UnPublish course")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verify UnPublish course")
	public void testUnPublishCourse() {
		logger.info("starting of testUnPublishCourse course method");

		try {
			this.tutorContentMarketPage.clickOnUnpublishCourseButton();

			// Assertion for checking course UnPublish label
			String lblUnpublishCourse = this.tutorContentMarketPage.getlabelUnpulishCourseText();
			Assert.assertEquals(lblUnpublishCourse, expectedAssertionsProp.getProperty(LABEL_CONTENT_UNPUBLISH_COURSE));

			this.tutorContentMarketPage.clickOnUnpublishButton();

			// Assertion for checking course UnPublish text
			String unpublishSucces = this.tutorContentMarketPage.getUnPublishSuccessText();
			Assert.assertEquals(unpublishSucces, expectedAssertionsProp.getProperty(UNPUBLISH_COURSE_SAVE_TEXT));

		} catch (Exception e) {
			Assert.fail("Exception occured while testing  UnPublish course " + e.getMessage());
			logger.error("Error occured while testing UnPublish course", e);
		}

		logger.info("Ending of testUnPublishCourse course method");
	}

	@Test(priority = 14, description = "Verify Remove course")
	@Description("Test Description:Verify Remove course")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verify Remove course")
	public void testRemoveCourse() {
		logger.info("Starting of testRemoveCourse method");

		try {
			this.tutorContentMarketPage.clickOnOverviewButton();
			this.tutorContentMarketPage.clickOnMenuVerticalIcon7();
			this.tutorContentMarketPage.clickOnRemoveCourseButton();

			// Assertion for checking remove course label
			String lblRemoveConfirmationText = this.tutorContentMarketPage.getRemoveConfirmationText();
			Assert.assertEquals(lblRemoveConfirmationText,
					expectedAssertionsProp.getProperty(LABEL_REMOVE_CONFIRMATION));

			this.tutorContentMarketPage.removeCourseButton();
		} catch (Exception e) {
			Assert.fail("Exception occured while testing  remove course " + e.getMessage());
			logger.error("Error occured while testing Remove course ", e);
		}

		logger.info("Ending of testRemoveCourse method");
	}

	@AfterMethod
	public void getConsoleLoggers() {
		logger.info("Starting of getConsoleLogger method");

		this.logBrowserConsoleErrors(this.driver);

		logger.info("Ending of getConsoleLogger method");
	}

	@AfterClass
	public void quitDriver() {
		try {
			if (driver != null) {
				Thread.sleep(5000);
				this.loginPage.clickOnLogOut();
				this.quitDriver(this.driver, WEB_DRIVER.CONTENT_MARKET_TEST);
				logger.info("Driver quit successfully");
			}
		} catch (Exception ex) {
			logger.error(ex.getMessage());
		}
	}

}