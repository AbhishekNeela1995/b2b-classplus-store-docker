package com.classplusapp.web.tests.faculty;

import static com.classplusapp.store.util.Constants.*;

import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.classplusapp.web.pages.faculty.FacultyAddContentPage;
import com.classplusapp.web.pages.faculty.FacultySearchCoursePage;
import com.classplusapp.web.pages.faculty.TutorAddingFacultyToCoursePage;
import com.classplusapp.web.pages.tutor.TutorAddContentPage;
import com.classplusapp.web.pages.tutor.TutorCreateCoursePage;
import com.classplusapp.web.pages.tutor.TutorCreateInstallmentPage;
import com.classplusapp.web.pages.tutor.TutorEditCoursePage;
import com.classplusapp.web.tests.BaseClassplusAutomationTest;
import com.classplusapp.web.tests.CommonFunctionStoreTest;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Epic("Store Faculty over view ")
@Feature("Tutor Adding Faculty To Course Test")

public class TutorAddingFacultyToCourseTest extends CommonFunctionStoreTest {

	private WebDriver tutorDriver = null;
	private WebDriver facultyDriver = null;

	private FacultyAddContentPage facultyAddContentPage = null;
	private TutorAddContentPage tutorAddContentPage = null;
	private TutorAddingFacultyToCoursePage tutorAddFacultyToCoursePage = null;
	private TutorAddingFacultyToCoursePage tutorAddFacultyToCoursePageTutor = null;
	private TutorCreateCoursePage tutorCreateCoursePage = null;
	private TutorAddContentPage tutorAddContentPageFaculty = null;
	private FacultySearchCoursePage searchCoursePage = null;
	private TutorCreateInstallmentPage tutorCreateInstallmentPage = null;
	private TutorEditCoursePage tutorEditCoursePage = null;
	private CommonFunctionStoreTest storeCommonFunctions = null;
	private TutorCreateCoursePage createCoursePage = null;

	private static final Logger logger = Logger.getLogger(TutorAddingFacultyToCourseTest.class.getName());

	@BeforeClass
	@Parameters({ "browser", "orgCode3" })
	public void initClassplusSiteLogin(@Optional("Chrome") String browser, @Optional("learn") String orgCode)
			throws Exception {
		logger.info("Starting of initClassplusSiteLogin method");

		this.tutorDriver = super.loginClassPlusSite(browser, orgCode, tutorMobileNumber, emailAddress,
				WEB_DRIVER.TUTOR_DRIVER);
		this.facultyDriver = super.loginClassPlusSite(browser, orgCode, facultyTwoMobileNumber, emailAddress,
				WEB_DRIVER.FACULTY_ADD_CONTENT_TEST);
		this.facultyAddContentPage = new FacultyAddContentPage(this.facultyDriver);
		this.tutorAddContentPage = new TutorAddContentPage(this.tutorDriver);
		this.tutorAddFacultyToCoursePage = new TutorAddingFacultyToCoursePage(this.facultyDriver);
		this.tutorAddFacultyToCoursePageTutor = new TutorAddingFacultyToCoursePage(this.tutorDriver);
		this.tutorCreateCoursePage = new TutorCreateCoursePage(this.tutorDriver);
		this.tutorAddContentPageFaculty = new TutorAddContentPage(this.facultyDriver);
		this.tutorCreateInstallmentPage = new TutorCreateInstallmentPage(this.facultyDriver);
		this.searchCoursePage = new FacultySearchCoursePage(this.tutorDriver);
		this.tutorEditCoursePage = new TutorEditCoursePage(this.tutorDriver);
		this.storeCommonFunctions = new CommonFunctionStoreTest();
		this.createCoursePage = new TutorCreateCoursePage(this.tutorDriver);

		logger.info("Ending of initClassplusSiteLogin method");
	}

	@Test(priority = 1, description = "verify when faculty added in a course only that course reflects in the store module")
	@Description("Test Description:verify when faculty added in a course only that course reflects in the store module")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Test Tutor Add Faculty")
	public void testTutorAddFaculty() {
		logger.info("Starting of testTutorAddFaculty method");

		try {
			super.createSimpleCourse(tutorCreateCoursePage);
			this.tutorCreateCoursePage.clickOnOverviewButton();

			this.tutorAddFacultyToCoursePageTutor.clickOnAddButton();

			Assert.assertEquals(tutorAddFacultyToCoursePageTutor.getAddFacultyHeader(),
					expectedAssertionsProp.getProperty(FACULTY_HEADER_LABEL));

			this.tutorAddFacultyToCoursePageTutor.setfacultyName(testDataProp.getProperty(TXT_FACULTY_NAME));
			this.tutorAddFacultyToCoursePageTutor
					.setFacultyMobileNumber(testDataProp.getProperty(TXT_FACULTY_MOBILE_NUMBER));
			this.tutorAddFacultyToCoursePageTutor.enterEmail(testDataProp.getProperty(TXT_FACULTY_EMAIL));
			this.tutorAddFacultyToCoursePageTutor.clickOnAddFacultyButton();
			this.tutorAddFacultyToCoursePageTutor.clickOnCloseButton();
			this.tutorDriver.navigate().refresh();

			Assert.assertTrue(this.tutorAddFacultyToCoursePageTutor.getAddedFacultyLabel());

			this.facultyAddContentPage.clickOnStoreButton();

			Assert.assertTrue(this.tutorAddFacultyToCoursePage.getAddedCourseLabel());

		} catch (Exception e) {
			Assert.fail(
					"Exception occured while testing faculty added in a course only that course reflects in the store module: "
							+ e.getMessage());
			logger.error(
					"Error occured while testing faculty added in a course only that course reflects in the store module",
					e);
		}

		logger.info("Ending of testTutorAddFaculty method");
	}

	@Test(priority = 2, description = "Verify Not yet added in any course Text")
	@Description("Test Description:Verify Not yet added in any course Text")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Verify Not yet added in any course Text")
	public void testVerifyNotYetAddedText() {
		logger.info("Starting of testVerifyNotYetAddedText method");

		try {
			String createdCourseName = this.storeCommonFunctions.createSimpleCourse(createCoursePage);

			logger.debug(createdCourseName);
			this.tutorAddContentPage.clickOnStoreButton();
			this.tutorAddContentPage.clickOnTxtSearchCourse(createdCourseName);
			this.tutorAddFacultyToCoursePageTutor.clickOnGetAdddedCourseFolder();
			this.tutorAddFacultyToCoursePageTutor.clickOnViewAllButton();
			this.tutorAddFacultyToCoursePageTutor.clickOnRemoveButton();

			Assert.assertEquals(tutorAddFacultyToCoursePageTutor.getRemoveConfirmationheader(),
					expectedAssertionsProp.getProperty(REMOVE_CONFIRMATION_HEADER));

			this.tutorAddFacultyToCoursePageTutor.clickOnYesRemoveButton();
			this.facultyAddContentPage.clickOnStoreButton();
			this.facultyDriver.navigate().refresh();

			String msgNotAddedInAnyCourses = this.tutorAddFacultyToCoursePage.getNotAddedInAnyCoursesMessage();
			Assert.assertEquals(msgNotAddedInAnyCourses,
					expectedAssertionsProp.getProperty(NOT_YET_ADDED_IN_ANY_COURSE_MESSAGE));

		} catch (Exception e) {
			Assert.fail("Exception occured while testing Not Yet Added Text: " + e.getMessage());
			logger.error("Error occured while testing Not Yet Added Text", e);
		}

		logger.info("Ending of testVerifyNotYetAddedText method");
	}

	@Test(priority = 3, description = "Verify Remove course")
	@Description("Test Description:Verify Remove course")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verify Remove course")
	public void testRemoveCourse() {
		logger.info("Starting of testRemoveCourse method");

		try {
			this.tutorAddContentPage.clickOnStoreButton();
			this.tutorAddContentPage.clickOnTxtSearchCourse(testDataProp.getProperty(CREATECOURSE_FACULTY_TITLE));
			this.tutorCreateInstallmentPage.clickOnGetCourse(testDataProp.getProperty(CREATECOURSE_FACULTY_TITLE));
			this.tutorEditCoursePage.clickOnOverviewButton();
			this.tutorEditCoursePage.clickOnMenuVerticalIcon();

			// Assertion for checking the remove text
			String lblRemove = this.tutorEditCoursePage.getRemoveLabel();
			Assert.assertEquals(lblRemove, expectedAssertionsProp.getProperty(LABEL_COURSE_REMOVE));

			this.tutorEditCoursePage.clickOnRemoveCourseButton();

			// Assertion for checking the remove course text
			String lblRemoveConfirmationText = this.tutorEditCoursePage.getRemoveConfirmationText();
			Assert.assertEquals(lblRemoveConfirmationText,
					expectedAssertionsProp.getProperty(LABEL_COURSE_REMOVE_CONFIRMATION));

			this.tutorEditCoursePage.removeCourseButton();
		} catch (Exception e) {
			Assert.fail("Exception occured while testing  remove course " + e.getMessage());
			logger.error("Error occured while testing remove course ", e);
		}

		logger.info("Ending of testRemoveCourse method");
	}

	@AfterClass
	public void quitDriver() {
		try {
			if (tutorDriver != null) {
				Thread.sleep(5000);
				this.loginPage.clickOnLogOut();
				this.quitDriver(this.tutorDriver, WEB_DRIVER.TUTOR_DRIVER);
				logger.info("Tutor Driver quit successfully");

				if (facultyDriver != null) {
					Thread.sleep(5000);
					this.loginPage.clickOnLogOut();
					this.quitDriver(this.facultyDriver, WEB_DRIVER.FACULTY_ADD_CONTENT_TEST);
					logger.info("Faculty Driver quit successfully");
				}
			}
		} catch (Exception ex) {
			logger.error(ex.getMessage());
		}
	}

}
