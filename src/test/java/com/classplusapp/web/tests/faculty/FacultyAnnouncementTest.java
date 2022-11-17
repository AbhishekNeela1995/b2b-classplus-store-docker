package com.classplusapp.web.tests.faculty;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.classplusapp.web.pages.faculty.FacultyAddContentPage;
import com.classplusapp.web.pages.faculty.FacultySearchCoursePage;
import com.classplusapp.web.pages.faculty.TutorAddingFacultyToCoursePage;
import com.classplusapp.web.pages.tutor.TutorAddContentPage;
import com.classplusapp.web.pages.tutor.TutorAnnouncementPage;
import com.classplusapp.web.pages.tutor.TutorCreateCoursePage;
import com.classplusapp.web.pages.tutor.TutorCreateInstallmentPage;
import com.classplusapp.web.tests.CommonFunctionStoreTest;

import static com.classplusapp.store.util.Constants.*;

import java.util.ArrayList;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Epic("Store Overview")
@Feature("Faculty Post Announcements Test")

public class FacultyAnnouncementTest extends CommonFunctionStoreTest {

	//private WebDriver tutorDriver = null;
	private WebDriver facultyDriver = null;
	private TutorCreateCoursePage tutorCreateCoursePage = null;
	private FacultySearchCoursePage searchCoursePage = null;
	private TutorAddContentPage tutorAddContentPageFaculty = null;
	private TutorAddContentPage tutorAddContentPage =null;
	private TutorAnnouncementPage tutorAnnouncementPage = null;
	private TutorCreateInstallmentPage tutorCreateInstallmentPage =null;
	private TutorAddingFacultyToCoursePage tutorAddFacultyToCoursePage =null;
	private TutorAddingFacultyToCoursePage tutorAddFacultyToCoursePageTutor =null;
	private FacultyAddContentPage facultyAddContentPage =null;

	private static final Logger logger = Logger.getLogger(FacultyAnnouncementTest.class.getName());

	@BeforeClass
	@Parameters({ "browser", "orgCode" })
	public void initClassplusSiteLogin(@Optional("Chrome")String browser, @Optional("learn")String orgCode)
			throws Exception {
		logger.info("Starting of initClassplusSiteLogin methond");

		this.facultyDriver = super.loginClassPlusSite(browser, orgCode, facultyOneMobileNumber, emailAddress,
				WEB_DRIVER.FACULTY_ANNOUNCEMENT_TEST);
		/*
		 * this.tutorDriver = super.loginClassPlusSite(browser, orgCode, mobileNumber,
		 * emailAddress, WEB_DRIVER.TUTOR_DRIVER);
		 */
		this.tutorAnnouncementPage = new TutorAnnouncementPage(facultyDriver);
		//this.tutorCreateCoursePage = new TutorCreateCoursePage(tutorDriver);
		this.searchCoursePage = new FacultySearchCoursePage(facultyDriver);
		this.tutorAddContentPageFaculty = new TutorAddContentPage(facultyDriver);
		//this.tutorAddContentPage = new TutorAddContentPage(tutorDriver);
		this.tutorCreateInstallmentPage = new TutorCreateInstallmentPage(facultyDriver);
		this.tutorAddFacultyToCoursePage = new TutorAddingFacultyToCoursePage(facultyDriver);
		//this.tutorAddFacultyToCoursePageTutor = new TutorAddingFacultyToCoursePage(tutorDriver);
		this.facultyAddContentPage = new FacultyAddContentPage(this.facultyDriver);

		logger.info("Ending of initClassplusSiteLogin method");
	}

	@Test(priority = 1, description = "Verify that by clicking on the announcement section mentioned on the left side of the store tutor create announcements for the purchased course students")
	@Description("Test Description: Verify that by clicking on the announcement section mentioned on the left side of the store tutor create announcements for the purchased course students")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test Make Announcement")
	public void testMakeAnnouncement() {
		logger.info("Starting of testMakeAnnouncement method");

		try {
			this.tutorAddContentPageFaculty.clickOnStoreButton();
			this.tutorAddContentPageFaculty.clickOnTxtSearchCourse(testDataProp.getProperty(FACULTY_SEARCH_COURSE));
			this.facultyAddContentPage.clickOnGetCourseFolder();
			super.testPostAnnouncement(tutorAnnouncementPage);

			//Assertion for checking added image announcement text
			String addAnnounceMessageText = this.tutorAnnouncementPage.getAnnounceAddedMessage();
			Assert.assertEquals(addAnnounceMessageText,
					expectedAssertionsProp.getProperty(ANNOUNCE_ADDED_SUCCESSFULLY_TEXT));

		} catch (Exception e) {
			Assert.fail(
					"Exception occured while testing the clicking on the announcement section mentioned on the left side of the store tutor create announcements for the purchased course students : "
							+ e.getMessage());
			logger.error(
					"Error occured while testing the clicking on the announcement section mentioned on the left side of the store tutor create announcements for the purchased course students  ",
					e);
		}

		logger.info("Ending of testMakeAnnouncement Page");
	}

	@Test(priority = 2, description = "Verify that by clicking on three dots tutor can edit the created announcement ")
	@Description("Test Description: Verify that by clicking on three dots tutor can edit the created announcement ")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test Edit Announcement")
	public void testEditAnnouncement() {
		logger.info("Starting of testEditAnnouncement method");

		try {
			super.testEditAnnouncement(tutorAnnouncementPage);

			// Assertion for checking edit announcement text
			String editAnnounceMessage = tutorAnnouncementPage.getAnnouncementEditedMessage();
			Assert.assertEquals(editAnnounceMessage,
					expectedAssertionsProp.getProperty(ANNOUNCE_EDIT_SUCCESSFULLY_TEXT));

		} catch (Exception e) {
			Assert.fail(
					"Exception occured while testing tutor can edit the created announcement : "
							+ e.getMessage());
			logger.error("Error occured while testing tutor can edit the created announcement ", e);
		}

		logger.info("Ending of testEditAnnouncement Page");
	}

	@Test(priority = 3, description = "Verify that by clicking on 3 dots tutor can remove the created announcement ")
	@Description("Test Description: Verify that by clicking on 3 dots tutor can remove the created announcement")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test Remove Announcement")
	public void testRemoveAnnouncement() {
		logger.info("Starting of testRemoveAnnouncement method");

		try {
			super.testDeleteAnnouncements(tutorAnnouncementPage);

			// Assertion for checking removed announcements text
			String DeleteAnnouncementText = tutorAnnouncementPage.getDeleteAnnouncementText();
			Assert.assertEquals(DeleteAnnouncementText,
					expectedAssertionsProp.getProperty(LABEL_ANNOUNCEMENT_DELETE_CONFIRM_TEXT));

			tutorAnnouncementPage.clickOnDeleteButton();
			this.tutorAnnouncementPage.setSearch(testDataProp.getProperty(CONTENTMARKET_ANNOUNCEMENT_MAKEANNOUNCE_EXCEL));
			
			Assert.assertEquals(this.tutorAnnouncementPage.getNoAnnouncementText(),expectedAssertionsProp.getProperty(NO_ANNOUNCEMENT_TEXT));
			
		} catch (Exception e) {
			Assert.fail(
					"Exception occured while testing tutor can remove the created announcement : "
							+ e.getMessage());
			logger.error("Error occured while testing tutor can remove the created announcement ",
					e);
		}
		
		logger.info("Ending of testRemoveAnnouncement method");
	}

	@Test(priority = 4, description = "Verify  that when faculty  click on the  Share button share the course on the overview page  by using the available option like facebook,whatsapp,linkdin & telegram ")
	@Description("Test Description: Verify  that when faculty  click on the  Share button share the course on the overview page  by using the available option like facebook,whatsapp,linkdin & telegram ")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test Share Course")
	public void testShareCourse() {
		logger.info("Starting of testShareCourse method");

		try {

			this.tutorAddContentPageFaculty.clickOnStoreButton();
			this.tutorAddContentPageFaculty.clickOnTxtSearchCourse(testDataProp.getProperty(FACULTY_LIVE_CLASSES_COURSE));
			this.tutorCreateInstallmentPage.clickOnGetCourse(testDataProp.getProperty(FACULTY_LIVE_CLASSES_COURSE));
			this.tutorAddFacultyToCoursePage.clickOnShareButton();
			this.tutorAddFacultyToCoursePage.clickOnSocialListIcons();
			this.tutorAddFacultyToCoursePage.switchToNewwindow();

			Assert.assertTrue(tutorAddFacultyToCoursePage.getLinkedInHeader());

			facultyDriver.close();
			this.tutorAddFacultyToCoursePage.switchToNewwindow();

			Assert.assertTrue(tutorAddFacultyToCoursePage.getLinkedInHeader());

			facultyDriver.close();
			this.tutorAddFacultyToCoursePage.switchToNewwindow();

			Assert.assertEquals(tutorAddFacultyToCoursePage.getFacebookHeader(),
					expectedAssertionsProp.getProperty(FACEBOOK_HEADER_LABEL));

			facultyDriver.close();
			this.tutorAddFacultyToCoursePage.switchToNewwindow();

			Assert.assertTrue(tutorAddFacultyToCoursePage.getWhatsappHeader());

			facultyDriver.close();
			ArrayList<String> tab = new ArrayList<String>(facultyDriver.getWindowHandles());
			facultyDriver.switchTo().window(tab.get(0));

		//	this.tutorAddFacultyToCoursePage.switchToNewwindow();

		} catch (

		Exception e) {
			Assert.fail(
					"Exception occured while testing when faculty click on the Share button share  the course on the overview page by using the available option like  facebook,whatsapp,linkdin & telegram : "
							+ e.getMessage());
			logger.error(
					"Error occured while testing when faculty click on the Share button share the course on the overview page by using the available option like  facebook,whatsapp,linkdin & telegram ",
					e);
		}

		logger.info("Ending of testShareCourse method");
	}

	@Test(priority = 5, description = "Verify that Course list is available for student with some attributes")
	@Description("Test Description: Verify that Course list is available for student with some attributes")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test Course List With Attributes")
	public void testCourseListWithAttributes() {
		logger.info("Starting of testCourseListWithAttributes method");

		try {
			this.tutorAddContentPageFaculty.clickOnStoreButton();
			this.tutorAddContentPageFaculty.clickOnTxtSearchCourse(testDataProp.getProperty(FACULTY_LIVE_CLASSES_COURSE));
			this.tutorCreateInstallmentPage.clickOnGetCourse(testDataProp.getProperty(FACULTY_LIVE_CLASSES_COURSE));
			Assert.assertEquals(this.tutorAddFacultyToCoursePage.getCourseTitleText(),
					expectedAssertionsProp.getProperty(FACULTY_LIVE_CLASSES_COURSE));

			Assert.assertTrue(this.tutorAddFacultyToCoursePage.isDisplayedCourseThumbnail());

			Assert.assertTrue(this.tutorAddFacultyToCoursePage.isDisplayedImageLikes());

			Assert.assertEquals(this.tutorAddFacultyToCoursePage.getFreeContentText(),
					expectedAssertionsProp.getProperty(FREE_CONTENT_TEXT));

		} catch (Exception e) {
			Assert.fail(
					"Exception occured while testing the Course list is available for student with some attributes : "
							+ e.getMessage());
			logger.error("Error occured while testing the Course list is available for student with some attributes  ",
					e);
		}

		logger.info("Ending of testCourseListWithAttributes method");
	}

	@AfterMethod
	public void getConsoleLoggers() {
		logger.info("Starting of getConsoleLogger method");

		//this.logBrowserConsoleErrors(this.tutorDriver);
		this.logBrowserConsoleErrors(this.facultyDriver);

		logger.info("Ending of getConsoleLogger method");
	}

	@AfterClass
	public void quitDriver() {
		try {
			/*
			 * if (this.tutorDriver != null) { Thread.sleep(5000);
			 * this.loginPage.clickOnLogOut(); this.quitDriver(this.tutorDriver,
			 * WEB_DRIVER.ANNOUNCEMENT_TEST); logger.info("Driver quit successfully"); }
			 */
			
			if (this.facultyDriver != null) {
				Thread.sleep(5000);
				this.loginPage.clickOnLogOut();
				this.quitDriver(this.facultyDriver, WEB_DRIVER.FACULTY_ANNOUNCEMENT_TEST);
				
				logger.info("Driver quit successfully");
			}
		} catch (Exception ex) {
			logger.error(ex.getMessage());
		}
	}

}
