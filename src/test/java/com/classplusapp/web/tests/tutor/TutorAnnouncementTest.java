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
import com.classplusapp.web.tests.BaseClassplusAutomationTest;

import static com.classplusapp.store.util.Constants.*;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Epic("Store Overview")
@Feature("Tutor Post Announcements Test")

public class TutorAnnouncementTest extends BaseClassplusAutomationTest {

	private WebDriver driver = null;
	private TutorAnnouncementPage tutorAnnouncementPage = null;

	private static final Logger logger = Logger.getLogger(TutorAnnouncementTest.class.getName());

	@BeforeClass
	@Parameters({ "browser", "orgCode" })
	public void initClassplusSiteLogin(@Optional("Chrome")String browser,@Optional("learn") String orgCode)
			throws Exception {
		logger.info("Starting of initClassplusSiteLogin methond");

		String searchCourse = testDataProp.getProperty(ANNOUNCEMENT_SEARCH_COURSE);
		this.driver = super.loginClassPlusSite(browser, orgCode, tutorMobileNumber, emailAddress,
				WEB_DRIVER.ANNOUNCEMENT_TEST);
		this.driver = super.clickOnStoreButton(driver, searchCourse);
		this.tutorAnnouncementPage = new TutorAnnouncementPage(driver);

		logger.info("Ending of initClassplusSiteLogin method");
	}

	@Test(priority = 1, description = "Verify Make Announcement")
	@Description("Test Description: Verify Make Announcement")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verify Make Announcement")
	public void testMakeAnnouncement() {
		logger.info("Starting of testMakeAnnouncement method");

		try {
			this.tutorAnnouncementPage.clickOnCourseFolder();

			// Assertion of for checking Course name label
			String lblCourseNameTitle = this.tutorAnnouncementPage.getCourseNameLabel();
			Assert.assertEquals(lblCourseNameTitle, expectedAssertionsProp.getProperty(LABEL_COURSE_NAME_TITLE));

			this.tutorAnnouncementPage.clickOnAnnouncementIcon();
			this.tutorAnnouncementPage.clickOnMakeAnnouncement();

			// Assertion of for checking Make Announcement page label
			String makeAnnounceMessageText = this.tutorAnnouncementPage.getMakeAnAnnouncementLabel();
			Assert.assertEquals(makeAnnounceMessageText, expectedAssertionsProp.getProperty(LABEL_MAKE_ANNOUNCEMENT));

		} catch (Exception e) {
			Assert.fail("Exception occured while testing MakeImageAnnouncement page: " + e.getMessage());
			logger.error("Error occured while testing MakeImageAnnouncement page ", e);
		}

		logger.info("Ending of testMakeAnnouncement Page");

	}

	@Test(priority = 2, description = "Verify Post Announcement")
	@Description("Test Description: Verify Post Announcement")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verify Post Announcement")
	public void testImagePostAnnouncement() {
		logger.info("Starting of testImagePostAnnouncement method");

		try {

			this.tutorAnnouncementPage.clickOnMakeAnnonceText(testDataProp.getProperty(ANNOUNCEMENT_MAKEANNOUNCE_TEXT));
			this.tutorAnnouncementPage.clickOnAttachFile();

			// Assertion for checking post SMS label
			String sendSMSLabel = this.tutorAnnouncementPage.getSendSMSLabel();
			Assert.assertEquals(sendSMSLabel, expectedAssertionsProp.getProperty(LABEL_POSTSMS_ANNOUNCEMENT));

			this.tutorAnnouncementPage.clickOnAddPostButton();

			// Assertion for checking added image announcement text
			String addAnnounceMessageText = this.tutorAnnouncementPage.getAnnounceAddedMessage();
			Assert.assertEquals(addAnnounceMessageText,
					expectedAssertionsProp.getProperty(ANNOUNCE_ADDED_SUCCESSFULLY_TEXT));

		} catch (Exception e) {
			Assert.fail("Exception occured while testing Post Image announcement page: " + e.getMessage());
			logger.error("Error occured while testing Post Image announcement page ", e);
		}

		logger.info("Ending of testImagePostAnnouncement Page");
	}

	@Test(priority = 3, description = "Verify Post Document Announcement")
	@Description("Test Description: Verify Post Document Announcement")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verify Post Document Announcement")
	public void testPdfPostAnnouncement() {
		logger.info("Starting of testPdfPostAnnouncement method");

		try {
			this.tutorAnnouncementPage.clickOnMakeAnnouncement1();
			this.tutorAnnouncementPage
					.clickOnMakePdfAnnonceText(testDataProp.getProperty(ANNOUNCEMENT_MAKEANNOUNCE_DOCUMENT));
			this.tutorAnnouncementPage.clickOnAttachFileDoc();
			this.tutorAnnouncementPage.clickOnPost1();

			// Assertion for checking added document announcement text
			String addDocumentAnnounceMessageText = this.tutorAnnouncementPage.announceAddedMessage1();
			Assert.assertEquals(addDocumentAnnounceMessageText,
					expectedAssertionsProp.getProperty(ANNOUNCE_PDF_ADDED_SUCCESSFULLY_TEXT));

		} catch (Exception e) {
			Assert.fail("Exception occured while testing Post Document announcement page: " + e.getMessage());
			logger.error("Error occured while testing Post Document announcement page ", e);
		}
		logger.info("Ending of testPdfPostAnnouncement Page");

	}

	@Test(priority = 4, description = "Verify Post Excel Announcement")
	@Description("Test Description: Verify Post Excel Announcement")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verify Post Document Announcement")
	public void testExcelPostAnnouncement() {
		logger.info("Starting of testExcelPostAnnouncement method");

		try {
			this.tutorAnnouncementPage.clickOnMakeExcelAnnouncement();

			// Assertion of for checking Make Announcement page label
			String makeAnnounceMessageText = this.tutorAnnouncementPage.getMakeAnAnnouncementLabel();
			Assert.assertEquals(makeAnnounceMessageText, expectedAssertionsProp.getProperty(LABEL_MAKE_ANNOUNCEMENT));

			this.tutorAnnouncementPage.clickOnMakeExcelAnnonceText(
					testDataProp.getProperty(CONTENTMARKET_ANNOUNCEMENT_MAKEANNOUNCE_EXCEL));
			this.tutorAnnouncementPage.clickOnAttachFileExcel();
			this.tutorAnnouncementPage.clickOnPost2();

			// Assertion for checking added excel announcement text
			String addAnnounceMessageText2 = this.tutorAnnouncementPage.announceAddedMessage2();
			Assert.assertEquals(addAnnounceMessageText2,
					expectedAssertionsProp.getProperty(ANNOUNCE_EXCEL_ADDED_SUCCESSFULLY_TEXT));

		} catch (Exception e) {
			Assert.fail("Exception occured while testing the  post Excel announcements : " + e.getMessage());
			logger.error("Error occured while testing the post Excel announcements ", e);
		}

		logger.info("Ending of testExcelPostAnnouncement method");
	}

	@Test(priority = 5, description = "Verify Edit Excel Announcements")
	@Description("Test Description: Verify Edit Excel Announcement")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verify Edit Excel Announcements")
	public void testEditExcelAnnouncement() {
		logger.info("Starting of testEditExcelAnnouncement method");

		try {
			this.tutorAnnouncementPage.clickOnThreeDottedMenu();
			this.tutorAnnouncementPage.clickOnEditIcon();

			// Assertion of for checking Make Announcement page label
			String makeAnnounceMessageText = this.tutorAnnouncementPage.getMakeAnAnnouncementLabel();
			Assert.assertEquals(makeAnnounceMessageText, expectedAssertionsProp.getProperty(LABEL_MAKE_ANNOUNCEMENT));

			this.tutorAnnouncementPage.clickOnEditMakeAnnonceText(
					testDataProp.getProperty(CONTENTMARKET_ANNOUNCEMENT_EDIT_MAKEANNOUNCE_TEXT));
			this.tutorAnnouncementPage.clickOnEditPostButton();

			// Assertion for checking edited excel announcement text
			String editAnnounceMessage = this.tutorAnnouncementPage.getAnnouncementEditedMessage();
			Assert.assertEquals(editAnnounceMessage,
					expectedAssertionsProp.getProperty(ANNOUNCE_EDIT_SUCCESSFULLY_TEXT));

		} catch (Exception e) {
			Assert.fail("Exception occured while testing the  edit announcements : " + e.getMessage());
			logger.error("Error occured while testing the edit announcements ", e);
		}

		logger.info("Ending of testEditExcelAnnouncement method");
	}

	@Test(priority = 6, description = "Verify Search Announcements")
	@Description("Test Description: Verify Search Announcements")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verify Search Announcements")
	public void testSearchAnnouncements() {
		logger.info("Starting of testSearchAnnouncements method");

		try {
			/*
			 * this.tutorAnnouncementPage.setSearch(testDataProp.getProperty(
			 * SEARCH_PDF_ANNOUNCEMENT));
			 * 
			 * // Assertion for checking edited excel announcement text String
			 * lblPdfAnnouncement = this.tutorAnnouncementPage.getPdfAnnouncementLabel();
			 * Assert.assertEquals(lblPdfAnnouncement,
			 * expectedAssertionsProp.getProperty(LABEL_SEARCH_PDF_ANNOUNCEMENT));
			 */
			this.tutorAnnouncementPage.setSearch(testDataProp.getProperty(SEARCH_EXCEL_ANNOUNCEMENT));

			// Assertion for checking edited excel announcement text
			String lblExcelAnnouncement = this.tutorAnnouncementPage.getExcelAnnouncementLabel();
			Assert.assertEquals(lblExcelAnnouncement,
					expectedAssertionsProp.getProperty(LABEL_SEARCH_EXCEL_ANNOUNCEMENT));

			//this.tutorAnnouncementPage.clearSearch();
			
		} catch (Exception e) {
			Assert.fail("Exception occured while testing the  post Excel announcements : " + e.getMessage());
			logger.error("Error occured while testing the post Excel announcements ", e);
		}

		logger.info("Ending of testSearchAnnouncements method");
	}

	@Test(priority = 7, description = "Verify Delete Excel Announcements")
	@Description("Test Description: Verify Delete Excel Announcements")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verify Delete Excel Announcements")
	public void testDeleteExcelAnnouncements() {
		logger.info("Starting of testDeleteExcelAnnouncements method");

		try {
			this.tutorAnnouncementPage.clickOnThreeDottedMenu();
			this.tutorAnnouncementPage.clickOnRemoveIcon();

			// Assertion for checking removed announcements text
			String deleteAnnounceLabel = this.tutorAnnouncementPage.getDeleteAnnouncementLabel();
			Assert.assertEquals(deleteAnnounceLabel,
					expectedAssertionsProp.getProperty(LABEL_ANNOUNCEMENT__DELETE_TEXT));

			// Assertion for checking removed announcements text
			String DeleteAnnouncementText = this.tutorAnnouncementPage.getDeleteAnnouncementText();
			Assert.assertEquals(DeleteAnnouncementText,
					expectedAssertionsProp.getProperty(LABEL_ANNOUNCEMENT_DELETE_CONFIRM_TEXT));

			this.tutorAnnouncementPage.clickOnDeleteButton();
			//this.tutorAnnouncementPage.setSearch(testDataProp.getProperty(SEARCH_EXCEL_ANNOUNCEMENT));
		//	this.tutorAnnouncementPage.clearSearch();

		} catch (Exception e) {
			Assert.fail("Exception occured while testing Delete Excel Announcements : " + e.getMessage());
			logger.error("Error occured while testing Delete Excel Announcements ", e);
		}

		logger.info("Ending of testDeleteExcelAnnouncements method");
	}

	@Test(priority = 8, description = "Verify Delete pdf Announcements")
	@Description("Test Description: Verify Delete pdf Announcements")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verify Delete pdf Announcements")
	public void testDeletePdfAnnouncements() {
		logger.info("Starting of testDeletePdfAnnouncements method");

		try {
			this.tutorAnnouncementPage.clickOnPdfThreeHorizontalDottedMenu();
			this.tutorAnnouncementPage.clickOnRemoveIcon();

			// Assertion for checking removed announcements Heading text
			String deleteAnnounceLabel = this.tutorAnnouncementPage.getDeleteAnnouncementLabel();
			Assert.assertEquals(deleteAnnounceLabel,
					expectedAssertionsProp.getProperty(LABEL_ANNOUNCEMENT__DELETE_TEXT));

			// Assertion for checking removed announcements text
			String DeleteAnnouncementText = this.tutorAnnouncementPage.getDeleteAnnouncementText();
			Assert.assertEquals(DeleteAnnouncementText,
					expectedAssertionsProp.getProperty(LABEL_ANNOUNCEMENT_DELETE_CONFIRM_TEXT));

			this.tutorAnnouncementPage.clickOnDeleteButton();
			//this.tutorAnnouncementPage.setSearch(testDataProp.getProperty(SEARCH_PDF_ANNOUNCEMENT));
			//this.tutorAnnouncementPage.clearSearch();

		} catch (Exception e) {
			Assert.fail("Exception occured while testing Delete pdf Announcements : " + e.getMessage());
			logger.error("Error occured while testing Delete pdf Announcements", e);
		}

		logger.info("Ending of testDeletePdfAnnouncements method");
	}

	@Test(priority = 9, description = "Verify Delete Image Announcements")
	@Description("Test Description: Verify Delete Image Announcements")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verify Delete Image Announcements")
	public void testDeleteImageAnnouncements() {
		logger.info("Starting of testDeleteImageAnnouncements method");

		try {

			this.tutorAnnouncementPage.clickOnImageThreeHorizontalDottedMenu();
			this.tutorAnnouncementPage.clickOnRemoveIcon();

			// Assertion for checking removed announcements Heading text
			String deleteAnnounceLabel = this.tutorAnnouncementPage.getDeleteAnnouncementLabel();
			Assert.assertEquals(deleteAnnounceLabel,
					expectedAssertionsProp.getProperty(LABEL_ANNOUNCEMENT__DELETE_TEXT));

			// Assertion for checking removed announcements text
			String DeleteAnnouncementText = this.tutorAnnouncementPage.getDeleteAnnouncementText();
			Assert.assertEquals(DeleteAnnouncementText,
					expectedAssertionsProp.getProperty(LABEL_ANNOUNCEMENT_DELETE_CONFIRM_TEXT));

			this.tutorAnnouncementPage.clickOnDeleteButton();
		} catch (Exception e) {
			Assert.fail("Exception occured while testing Delete Image Announcements : " + e.getMessage());
			logger.error("Error occured while testing Delete Image Announcements ", e);
		}

		logger.info("Ending of testDeleteImageAnnouncements method");
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
			if (this.driver != null) {
				Thread.sleep(5000);
				this.loginPage.clickOnLogOut();
				this.quitDriver(this.driver, WEB_DRIVER.ANNOUNCEMENT_TEST);
				logger.info("Driver quit successfully");
			}
		} catch (Exception ex) {
			logger.error(ex.getMessage());
		}
	}

}