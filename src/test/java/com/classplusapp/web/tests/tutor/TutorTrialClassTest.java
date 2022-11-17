package com.classplusapp.web.tests.tutor;

import static com.classplusapp.store.util.Constants.*;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.classplusapp.web.pages.faculty.TutorAddingFacultyToCoursePage;
import com.classplusapp.web.pages.tutor.TutorTrialClassPage;
import com.classplusapp.web.pages.tutor.TutorAddContentPage;
import com.classplusapp.web.pages.tutor.TutorContentMarketPage;
import com.classplusapp.web.pages.tutor.TutorCreateCoursePage;
import com.classplusapp.web.pages.tutor.TutorCreateInstallmentPage;
import com.classplusapp.web.pages.tutor.TutorEditCoursePage;
import com.classplusapp.web.tests.CommonFunctionStoreTest;
import com.classplusapp.web.tests.faculty.TutorAddingFacultyToCourseTest;
import com.classplusapp.web.tests.tutor.TutorPayInInstallmentTest;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Epic("Promote Course With Trial Clssses")
@Feature("Start Live Class From Trial Classes")
public class TutorTrialClassTest extends CommonFunctionStoreTest {

	private WebDriver driver = null;
	private WebDriver fdriver = null;
	private TutorTrialClassPage tutorTrialClassPage = null;
	private TutorTrialClassPage facultyTrialClassPage = null;
	private TutorCreateCoursePage createCoursePage = null;
	private TutorContentMarketPage tutorContentMarketPage = null;
	private TutorAddContentPage tutorAddContentPage = null;
	private TutorAddingFacultyToCoursePage tutorAddFacultyToCoursePageTutor = null;
	private TutorCreateInstallmentPage tutorCreateInstallmentPage = null;
	private TutorEditCoursePage tutorEditCoursePage = null;
	private CommonFunctionStoreTest commonFunctionStoreTest = null;

	private static final Logger logger = Logger.getLogger(TutorPayInInstallmentTest.class.getName());

	@BeforeClass
	@Parameters({ "browser", "orgCode" })
	public void initClassplusSiteLogin(@Optional("Chrome") String browser, @Optional("learn") String orgCode)
			throws Exception {
		logger.info("Starting of initClassplusSiteLogin methond");

		this.driver = super.loginClassPlusSite(browser, orgCode, tutorTwoMobileNumber, emailAddress,
				WEB_DRIVER.TUTOR_TRIAL_CLASS);

		this.fdriver = super.loginClassPlusSite(browser, orgCode, facultyOneMobileNumber, emailAddress,
				WEB_DRIVER.FACULTY_TRIAL_CLASS);

		this.createCoursePage = new TutorCreateCoursePage(driver);
		this.tutorTrialClassPage = new TutorTrialClassPage(driver);
		this.facultyTrialClassPage = new TutorTrialClassPage(fdriver);
		this.tutorCreateInstallmentPage = new TutorCreateInstallmentPage(fdriver);
		this.tutorAddContentPage = new TutorAddContentPage(driver);
		this.tutorAddFacultyToCoursePageTutor = new TutorAddingFacultyToCoursePage(driver);
		this.tutorContentMarketPage = new TutorContentMarketPage(driver);
		this.tutorEditCoursePage = new TutorEditCoursePage(driver);

		logger.info("Ending of initClassplusSiteLogin method");
	}

	@Test(priority = 1, description = "Verify Promote your courses by taking a live trial class from Go live page")
	@Description("Test Description: Verify Promote your courses by taking a live trial class from Go live page")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Verify Go live Class")
	public void testGoLiveTrialClass() {
		logger.info("Starting of testGoLiveTrialClass method");

		try {
			super.createNewTutorCourse(createCoursePage);
			super.testAddModalSubjectiveTest(tutorAddContentPage);
			this.hardWait(3);
			super.testPublishCourse(tutorAddContentPage);

			// Assertion for checking the publish course text
			Assert.assertEquals(this.tutorAddContentPage.getPublishSuccessText(),
					expectedAssertionsProp.getProperty(COURSE_PUBLISHED_TEXT));

			this.tutorTrialClassPage.clickOnGoLive();
			this.tutorTrialClassPage.clickOnPromoteGoLive();

			// Assert to Check Trial class heading
			Assert.assertEquals(this.tutorTrialClassPage.getTrialClassHeading(),
					expectedAssertionsProp.getProperty(TRIAL_CLASSES_TITLE));

			this.tutorTrialClassPage.clickOnCloseModal();
		} catch (Exception e) {
			Assert.fail(
					"Exception occured while testing Promote your courses by taking a live trial class from Go live page: "
							+ e.getMessage());
			logger.error(
					"Error occured while testing Promote your courses by taking a live trial class from Go live page ",
					e);
		}

		logger.info("Ending of testGoLiveTrialClass method");
	}

	@Test(priority = 2, description = "Verify Promote your courses by taking a live trial class from scheduled class")
	@Description("Test Description:Verify Promote your courses by taking a live trial class from scheduled class")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Verify Scheduled Trail Class")
	public void testScheduleTrialClass() {
		logger.info("Starting of testScheduleTrialClass method");

		try {
			this.hardWait(2);
			this.tutorTrialClassPage.clickOnScheduleClass();
			this.tutorTrialClassPage.clickOnPromoteGoLive();

			// Assert to Check Trial class heading
			Assert.assertEquals(this.tutorTrialClassPage.getTrialClassHeading(),
					expectedAssertionsProp.getProperty(TRIAL_CLASSES_TITLE));

			// Assert to Check how it is works label
			Assert.assertEquals(this.tutorTrialClassPage.getHowItWorksText(),
					expectedAssertionsProp.getProperty(LABEL_HOW_IT_WORKS));

			Assert.assertTrue(this.tutorTrialClassPage.isEnabledHowItWorks());

			this.tutorTrialClassPage.clickOnAddButton();
			// Assert.assertTrue(this.tutorTrialClassPage.isNewAppSelected());
			Assert.assertTrue(this.tutorTrialClassPage.getStudentCount());
			this.tutorTrialClassPage.clickOnAddButton();
			this.tutorTrialClassPage.clickOnNotPurchasedCourse();

			Assert.assertTrue(this.tutorTrialClassPage.getStudentCount());

			this.tutorTrialClassPage.clickOnAddButton();
			this.tutorTrialClassPage.clickOnTenDaysRadioButton();

			Assert.assertTrue(this.tutorTrialClassPage.getStudentCount());

			this.tutorTrialClassPage.clickOnAddButton();
			this.tutorTrialClassPage.clickOnThirtyDaysRadioButton();

			Assert.assertTrue(this.tutorTrialClassPage.getStudentCount());

			this.tutorTrialClassPage.clickOnCloseModal();

		} catch (Exception e) {
			Assert.fail(
					"Exception occured while testing Promote your courses by taking a scheduled class from Go live page: "
							+ e.getMessage());
			logger.error(
					"Error occured while testing Promote your courses by taking a scheduled  class from Go live page ",
					e);
		}

		logger.info("Ending of testScheduleTrialClass method");
	}

	@Test(priority = 3, description = "Verify Desktop view toggel disabled in Live trial calss page")
	@Description("Test Description: Verify Desktop view toggel disabled in Live trial calss page")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Verify Desktop view state in trial class")
	public void testDesktopViewState() {
		logger.info("Starting of testDesktopViewState method");

		try {
			this.hardWait(2);
			this.tutorTrialClassPage.clickOnTrialClasses();
			this.tutorTrialClassPage.clickOnAdvancedSettings();

			// Assert to Check desktop view label
			Assert.assertEquals(this.tutorTrialClassPage.getDesktopView(),
					expectedAssertionsProp.getProperty(LABEL_DESKTOP_VIEW));

			this.tutorTrialClassPage.clickOnCloseModal();

		} catch (Exception e) {
			Assert.fail("Exception occured while testing Desktop view toggel disabled in Live trial calss page: "
					+ e.getMessage());
			logger.error("Error occured while testing Desktop view toggel disabled in Live trial calss page ", e);
		}

		logger.info("Ending of testDesktopViewState method");
	}

	@Test(priority = 4, description = "Verify clear the Select students,which not removed except promoted course")
	@Description("Test Description: Verify clear the Select students,which not removed except promoted course")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Verify Go live Class")
	public void testPromotedCourse() {
		logger.info("Starting of testPromotedCourse method");

		try {
			this.hardWait(2);
			this.tutorTrialClassPage.clickOnTrialClasses();
			this.hardWait(2);
			this.tutorTrialClassPage.clickOnAddButton();
			this.tutorTrialClassPage.clickOnCourses();

			Assert.assertTrue(this.tutorTrialClassPage.isSelectedDefaultCourse());

			this.tutorTrialClassPage.clickOnSelectAllCourses();
			this.tutorTrialClassPage.clickOnClearCourses();

			Assert.assertTrue(this.tutorTrialClassPage.isSelectedDefaultCourse());

			this.tutorTrialClassPage.clickOnCloseModal();

		} catch (Exception e) {
			Assert.fail(
					"Exception occured while testing clear the Select students,which not removed except promoted course: "
							+ e.getMessage());
			logger.error(
					"Error occured while testing clear the Select students,which not removed except promoted course",
					e);
		}

		logger.info("Ending of testPromotedCourse method");
	}

	@Test(priority = 5, description = "Verify clear the Select students,which notremoved except promoted course")
	@Description("Test Description: Verify clear the Select students,which not removed except promoted course")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Verify Go live Class")
	public void testSelectedCourses() {
		logger.info("Starting of testSelectedCourses method");

		try {
			this.hardWait(2);
			this.tutorTrialClassPage.clickOnTrialClasses();
			this.tutorTrialClassPage.clickOnAddButton();
			this.tutorTrialClassPage.clickOnCourses();
			this.tutorTrialClassPage.clickOnSelectAllCourses();

			Assert.assertTrue(this.tutorTrialClassPage.getSelectedCoursesCount());

			this.tutorTrialClassPage.clickOnClearCourses();

			Assert.assertTrue(this.tutorTrialClassPage.isSelectedDefaultCourse());
			this.tutorTrialClassPage.clickOnCloseModal();

		} catch (Exception e) {
			Assert.fail(
					"Exception occured while testing clear the Select students,which not removed except promoted course: "
							+ e.getMessage());
			logger.error(
					"Error occured while testing clear the Select students,which not removed except promoted course",
					e);
		}

		logger.info("Ending of testSelectedCourses method");
	}

	@Test(priority = 6, description = "Verify search box with entered data, inselect students page")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Verify Search Course")
	public void testSearchCourse() {
		logger.info("Starting of testSearchCourse method");

		try {
			this.hardWait(2);
			this.tutorTrialClassPage.clickOnTrialClasses();
			this.tutorTrialClassPage.clickOnAddButton();
			this.tutorTrialClassPage.clickOnCourses();

			this.tutorTrialClassPage.setSearchCourse(testDataProp.getProperty(TXT_SEARCH_TRIAL_COURSE));

			// Assert to Check desktop view label
			Assert.assertEquals(this.tutorTrialClassPage.getSearchedCourse(),
					expectedAssertionsProp.getProperty(TXT_SEARCH_COURSE));
			this.tutorTrialClassPage.clickOnCloseSelectStudent();

			this.tutorTrialClassPage.clickOnCloseModal();

		} catch (Exception e) {
			Assert.fail("Exception occured while testing search box with entered data, in select students page: "
					+ e.getMessage());
			logger.error("Error occured while testing search box with entered data, in select students page", e);
		}

		logger.info("Ending of testSearchCourse method");
	}

	@Test(priority = 7, description = "Verify empty state of topic field, in Live trial class page")
	@Description("Test Description: Verify empty state of topic field, in Live trial class page")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Verify Scheduled Class without topic")
	public void testScheduleClassExpectTopic() {
		logger.info("Starting of testScheduleClassExpectTopic method");

		try {
			this.hardWait(2);
			this.tutorTrialClassPage.clickOnTrialClasses();
			this.tutorTrialClassPage.scrollDown(500);
			this.tutorTrialClassPage.clickOnAdvancedSettings();
			this.tutorTrialClassPage.clickOnShowRecordToggle();
			this.tutorTrialClassPage.clickOnSMSCheckbox();
			this.tutorTrialClassPage.clickOnScheduleForLater();

			// Assert to Check desktop view label
			Assert.assertEquals(this.tutorTrialClassPage.getErrorTopicMessage(),
					expectedAssertionsProp.getProperty(MSG_ERROR_TOPIC_TOAST));

			this.tutorTrialClassPage.clickOnCloseModal();

		} catch (Exception e) {
			Assert.fail("Exception occured while testing empty state of topic field, in Live trial class page: "
					+ e.getMessage());
			logger.error("Error occured while testing empty state of topic field, in Live trial class page", e);
		}

		logger.info("Ending of testScheduleClassExpectTopic method");
	}

	@Test(priority = 8, description = "Verify schedule a class and get compose notification page after clicking on notify students")
	@Description("Test Description: Verify schedule a class and get compose notification page after clicking on notify students")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Verify Compose Notifications")
	public void testEditScheduledTrialClassCards() {
		logger.info("Starting of testEditScheduledTrialClassCards method");

		try {
			super.createScheduledClass(tutorTrialClassPage);
			this.tutorTrialClassPage.clickOnScheduledButton();
			this.tutorTrialClassPage.setTopic(testDataProp.getProperty(TRIAL_CLASS_EDIT_TOPIC_TEXT));
			this.tutorTrialClassPage.clickOnSelectTime();
			this.tutorTrialClassPage.setTime();
			this.tutorTrialClassPage.setTime();

			this.tutorTrialClassPage.clickOnUpdateTrialButton();

			// Assertion for checking delete trial text
			Assert.assertEquals(this.tutorTrialClassPage.getUpdateTrialMessage(),
					expectedAssertionsProp.getProperty(MSG_UPDATE_TRIAL_TOPIC));

			this.tutorTrialClassPage.clickOnScheduledButton();
			this.tutorTrialClassPage.clickOnDeleteTrialButton();

			// Assertion for checking delete trial text
			Assert.assertEquals(this.tutorTrialClassPage.getDeleteTrialMessage(),
					expectedAssertionsProp.getProperty(MSG_DELETE_TRIAL_TOPIC));

			Assert.assertTrue(this.tutorTrialClassPage.getDeleteTrialsCount());

		} catch (Exception e) {
			Assert.fail(
					"Exception occured while testing schedule a class and get compose notification page after clicking on notify students: "
							+ e.getMessage());
			logger.error(
					"Error occured while testing schedule a class and get compose notification page after clicking on notify students",
					e);
		}

		logger.info("Ending of testEditScheduledTrialClassCards method");

	}

	@Test(priority = 9, description = "Verify schedule a class and get composenotification page after clicking on notify students")
	@Description("Test Description: Verify schedule a class and get compose notification page after clicking on notify students")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Verify Scheduled class cards")
	public void testScheduledTrialClassCards() {
		logger.info("Starting of testScheduledTrialClassCards method");

		try {
			super.createScheduledClass(tutorTrialClassPage);
			this.tutorTrialClassPage.clickOnTrialClasses();

			// Assert to Check Trial class heading
			Assert.assertEquals(tutorTrialClassPage.getTrialClassHeading(),
					expectedAssertionsProp.getProperty(TRIAL_CLASSES_TITLE));

			this.tutorTrialClassPage.setTopic(testDataProp.getProperty(TRIAL_CLASS_TOPIC_TEXT));
			this.tutorTrialClassPage.clickOnAddButton();
			this.tutorTrialClassPage.clickOnSelectStudents();
			this.tutorTrialClassPage.clickOnDone();

			// Assertion for check upto 10 days from download
			Assert.assertEquals(tutorTrialClassPage.getUpToDownloadsText(),
					expectedAssertionsProp.getProperty(LABEL_UPTO_TEN_DAYS_DOWNLOAD));

			this.tutorTrialClassPage.clickOnSelectDate();
			this.tutorTrialClassPage.setDate();
			this.tutorTrialClassPage.clickOnSelectTime();
			this.tutorTrialClassPage.setTime();
			this.tutorTrialClassPage.setTime();
			this.tutorTrialClassPage.clickOnScheduleForLater();

			// Assertion for checking scheduled success text
			Assert.assertEquals(this.tutorTrialClassPage.getScheduledSuccessText(),
					expectedAssertionsProp.getProperty(LABEL_SCHEDULE_SUCCESS_TEXT));

			this.tutorTrialClassPage.clickOnNotifyCloseModal();

			Assert.assertEquals(this.tutorTrialClassPage.getOverviewScheduledLabel(),
					expectedAssertionsProp.getProperty(TXT_OVERVIEW_SCHEDULED));

			// Assertion for checking trial in the overview text
			Assert.assertEquals(this.tutorTrialClassPage.getOverviewTrialLabel(),
					expectedAssertionsProp.getProperty(TXT_OVERVIEW_TRIAL));

			// Assertion for checking topic text
			Assert.assertEquals(this.tutorTrialClassPage.getOverviewTrialTopicName(),
					expectedAssertionsProp.getProperty(TXT_OVERVIEW_TRIAL_TOPIC));

			this.tutorTrialClassPage.clickOnOverviewTrialButton();
			this.tutorTrialClassPage.setTopic(testDataProp.getProperty(TRIAL_CLASS_EDIT_TOPIC_TEXT));
			this.tutorTrialClassPage.clickOnUpdateTrialButton();

			// Assertion for checking delete trial text
			Assert.assertEquals(this.tutorTrialClassPage.getUpdateTrialMessage(),
					expectedAssertionsProp.getProperty(MSG_UPDATE_TRIAL_TOPIC));
			for (int i = 1; i <= 2; i++) {
				if (this.tutorTrialClassPage.isDisplayedScheduledLabel() == true) {
					this.tutorTrialClassPage.clickOnOverviewTrialButton();
					this.tutorTrialClassPage.clickOnDeleteTrialButton();

					// Assertion for checking delete trial text
					Assert.assertEquals(this.tutorTrialClassPage.getDeleteTrialMessage(),
							expectedAssertionsProp.getProperty(MSG_DELETE_TRIAL_TOPIC));
				} else {
					super.deleteLiveClass(tutorTrialClassPage);
					Assert.assertEquals(tutorTrialClassPage.getOverViewLabelText(),
							expectedAssertionsProp.getProperty(LABEL_STORE_OVERVIEW));
				}
			}
			Assert.assertTrue(this.tutorTrialClassPage.getDeleteTrialsCount());

		} catch (Exception e) {
			Assert.fail(
					"Exception occured while testing schedule a class and get compose notification page after clicking on notify students: "
							+ e.getMessage());
			logger.error(
					"Error occured while testing schedule a class and get compose notification page after clicking on notify students",
					e);
		}

		logger.info("Ending of testScheduledTrialClassCards method");

	}

	@Test(priority = 10, description = "Verify view all classes button, in upcoming live classes from overview page")
	@Description("Test Description:Verify view all classes button, in upcoming live classes from overview page")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Verify test viewAll classses")
	public void testViewAllClasses() {
		logger.info("Starting of testComposeNotification method");
		try {
			for (int i = 0; i <= 2; i++) {
				super.createScheduledClass(tutorTrialClassPage);
			}

			Assert.assertTrue(this.tutorTrialClassPage.getCountCreatedTrialClasses());
			super.addFacultyToCourse(tutorAddFacultyToCoursePageTutor);

			// Assertion for checking view all classes text
			Assert.assertEquals(this.tutorTrialClassPage.getViewAllClasses(),
					expectedAssertionsProp.getProperty(TXT_VIEWALL_CLASSES));

			this.tutorTrialClassPage.clickOnScrollRightButton();
			this.tutorTrialClassPage.clickOnViewAllClassButton();

			// Assertion for checking faculty toggle classes text
			Assert.assertEquals(this.tutorTrialClassPage.getFacultyClassesLabel(),
					expectedAssertionsProp.getProperty(LBL_FACULTY_CLASSES));

			this.tutorTrialClassPage.clickOnEditLiveClassButton();

			super.editScheduledClass(tutorTrialClassPage);

			this.tutorTrialClassPage.clickOnLiveTakeClassButton();

			// Assertion for checking live class text
			Assert.assertEquals(this.tutorTrialClassPage.getStartLiveClassLabel(),
					expectedAssertionsProp.getProperty(TXT_START_LIVE_CLASSES));

			this.tutorTrialClassPage.clickOnEndLiveClass();
			super.deleteFacultyToCourse(tutorAddFacultyToCoursePageTutor);

			for (int i = 0; i <= 2; i++) {
				if (this.tutorTrialClassPage.isDisplayedScheduledLabel() == true) {
					this.tutorTrialClassPage.clickOnOverviewTrialButton();
					this.tutorTrialClassPage.clickOnDeleteTrialButton();

					// Assertion for checking delete trial text
					Assert.assertEquals(this.tutorTrialClassPage.getDeleteTrialMessage(),
							expectedAssertionsProp.getProperty(MSG_DELETE_TRIAL_TOPIC));

				} else {
					super.deleteLiveClass(tutorTrialClassPage);
					Assert.assertEquals(tutorTrialClassPage.getOverViewLabelText(),
							expectedAssertionsProp.getProperty(LABEL_STORE_OVERVIEW));
				}
			}
		} catch (

		Exception e) {
			Assert.fail(
					"Exception occured while testing schedule a class and get compose notification page after clicking on notify students: "
							+ e.getMessage());
			logger.error(
					"Error occured while testing schedule a class and get compose notification page after clicking on notify students",
					e);
		}

		logger.info("Ending of testScheduledTrialClassCards method");

	}

	@Test(priority = 11, description = "Verify view all classes button, in upcoming live classes from overview page")
	@Description("Test Description:Verify view all classes button, in upcoming live classes from overview page")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Verify test start live classses")
	public void testStartLiveClass() {
		logger.info("Starting of testStartLiveClass method");

		try {
			super.createScheduledClass(tutorTrialClassPage);

			this.hardWait(60);
			// Assertion for checking take class text
			Assert.assertEquals(this.tutorTrialClassPage.getTakeClassLabel(),
					expectedAssertionsProp.getProperty(TXT_TAKE_CLASSES));

			this.tutorTrialClassPage.clickOnTakeClass();

			// Assertion for checking live class text
			Assert.assertEquals(this.tutorTrialClassPage.getStartLiveClassLabel(),
					expectedAssertionsProp.getProperty(TXT_START_LIVE_CLASSES));

			this.tutorTrialClassPage.clickOnEndLiveClass();

			Assert.assertEquals(this.tutorTrialClassPage.getOverViewLabelText(),
					expectedAssertionsProp.getProperty(LABEL_STORE_OVERVIEW));

		} catch (Exception e) {
			Assert.fail(
					"Exception occured while testing schedule a class and get compose notification page after clicking on notify students: "
							+ e.getMessage());
			logger.error(
					"Error occured while testing schedule a class and get compose notification page after clicking on notify students",
					e);
		}

		logger.info("Ending of testStartLiveClass method");

	}

	@Test(priority = 12, description = "Verify schedule a class and get compose notification page after clicking on notify students")
	@Description("Test Description: Verify schedule a class and get compose notification page after clicking on notify students")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Verify Compose Notifications")
	public void testComposeNotification() {
		logger.info("Starting of testComposeNotification method");
		try {
			String course = this.commonFunctionStoreTest.createNewTutorCourse(createCoursePage);
			this.tutorTrialClassPage.clickOnTrialClasses();

			// Assert to Check Trial class heading
			Assert.assertEquals(tutorTrialClassPage.getTrialClassHeading(),
					expectedAssertionsProp.getProperty(TRIAL_CLASSES_TITLE));

			this.tutorTrialClassPage.setTopic(testDataProp.getProperty(TRIAL_CLASS_TOPIC_TEXT));
			this.tutorTrialClassPage.clickOnAddButton();
			this.tutorTrialClassPage.clickOnSelectStudents();
			this.tutorTrialClassPage.clickOnDone();

			// Assertion for check upto 10 days from download
			Assert.assertEquals(tutorTrialClassPage.getUpToDownloadsText(),
					expectedAssertionsProp.getProperty(LABEL_UPTO_TEN_DAYS_DOWNLOAD));

			this.tutorTrialClassPage.clickOnSelectDate();
			this.tutorTrialClassPage.setDate();
			this.tutorTrialClassPage.clickOnSelectTime();
			this.tutorTrialClassPage.setTime();
			this.tutorTrialClassPage.clickOnScheduleForLater();

			// Assertion for checking scheduled success text
			Assert.assertEquals(this.tutorTrialClassPage.getScheduledSuccessText(),
					expectedAssertionsProp.getProperty(LABEL_SCHEDULE_SUCCESS_TEXT));

			this.tutorTrialClassPage.clickOnNotifyButton();

			// Assertion for checking compose notification success text
			Assert.assertEquals(tutorTrialClassPage.getComposeNotificationHeader(),
					expectedAssertionsProp.getProperty(LABEL_COMPOSE_NOTIFICATION_TEXT));

			Assert.assertTrue(this.tutorTrialClassPage.isEnabledSelectStudents());

			this.tutorTrialClassPage.scrollDown(400);

			// Assertion for checking landing course text
			Assert.assertEquals(tutorTrialClassPage.getLandingScreenCourse(), course);

			Assert.assertEquals(tutorTrialClassPage.getCourseLabel(), tutorTrialClassPage.getLandingScreenCourse());

		} catch (Exception e) {
			Assert.fail(
					"Exception occured while testing schedule a class and get compose notification page after clicking on notify students: "
							+ e.getMessage());
			logger.error(
					"Error occured while testing schedule a class and get compose notification page after clicking on notify students",
					e);
		}

		logger.info("Ending of testComposeNotification method");

	}

	@Test(priority = 13, description = "Verify set date and set time, in Live trial calss page.")
	@Description("Test Description:Verify set date and set time, in Live trial calss page.")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Verify Set Time")
	public void testTimeAndDate() {
		logger.info("Starting of testTimeAndDate method");

		try {
			this.tutorTrialClassPage.clickOnTrialClasses();

			// Assert to Check next day date
			logger.debug(this.tutorTrialClassPage.getSelectDate());
			logger.debug(this.tutorTrialClassPage.tomorrowDate());
			Assert.assertEquals(this.tutorTrialClassPage.getSelectDate(), this.tutorTrialClassPage.tomorrowDate());

			// Assert to Check next day time
			logger.debug(this.tutorTrialClassPage.getSelectTime());
			logger.debug(this.tutorTrialClassPage.tomorrowTime());
			Assert.assertEquals(this.tutorTrialClassPage.getSelectTime(), this.tutorTrialClassPage.tomorrowTime());

			this.tutorTrialClassPage.clickOnCloseModal();

		} catch (

		Exception e) {
			Assert.fail(
					"Exception occured while testing schedule a class and get compose notification page after clicking on notify students: "
							+ e.getMessage());
			logger.error(
					"Error occured while testing schedule a class and get compose notification page after clicking on notify students",
					e);
		}

		logger.info("Ending of testTimeAndDate method");

	}

	@Test(priority = 14, description = "Verify Live portal by tapping live now option")
	@Description("Test Description:Verify Live portal by tapping live now option")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Verify live classses")
	public void testShowClassToFaculty() {
		logger.info("Starting of testTakeLiveNowClass method");

		try {
			for (int i = 0; i <= 2; i++) {
				super.createScheduledClass(tutorTrialClassPage);
			}

			this.tutorTrialClassPage.clickOnViewAllClassButton();

			Assert.assertTrue(this.tutorTrialClassPage.getFacultyClassesToggle());

			this.tutorTrialClassPage.clickOnCloseModal();

			super.addFacultyToCourse(tutorAddFacultyToCoursePageTutor);
			this.tutorTrialClassPage.clickOnViewAllClassButton();

			Assert.assertTrue(this.tutorTrialClassPage.getFacultyClassesToggleAfterAddingTheFaculty());

			super.deleteFacultyToCourse(tutorAddFacultyToCoursePageTutor);

			for (int i = 0; i <= 2; i++) {
				super.deleteScheduledClass(facultyTrialClassPage);
			}

			for (int i = 0; i <= 2; i++) {
				super.deleteScheduledClass(tutorTrialClassPage);
			}

			// Assertion for checking delete trial text
			Assert.assertEquals(this.tutorTrialClassPage.getDeleteTrialMessage(),
					expectedAssertionsProp.getProperty(MSG_DELETE_TRIAL_TOPIC));

			Assert.assertTrue(this.tutorTrialClassPage.getDeleteTrialsCount());

		} catch (

		Exception e) {
			Assert.fail(
					"Exception occured while testing schedule a class and get compose notification page after clicking on notify students: "
							+ e.getMessage());
			logger.error(
					"Error occured while testing schedule a class and get compose notification page after clicking on notify students",
					e);
		}

		logger.info("Ending of testTakeLiveNowClass method");

	}

	@Test(priority = 15, description = "Verify Live portal by tapping live now option")
	@Description("Test Description:Verify Live portal by tapping live now option")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Verify live classses")
	public void testAddLiveClassFromFaculty() {
		logger.info("Starting of testAddLiveClassFromFaculty method");

		try {
			for (int i = 0; i <= 2; i++) {
				super.createScheduledClass(tutorTrialClassPage);
			}

			super.addFacultyToCourse(tutorAddFacultyToCoursePageTutor);

			this.tutorCreateInstallmentPage.clickOnStoreButton();
			this.tutorCreateInstallmentPage.setSearch(testDataProp.getProperty(TUTOR_NEWWEBSITE_AUTOMATION_TESTING));
			this.tutorCreateInstallmentPage
					.clickOnGetCourse(testDataProp.getProperty(TUTOR_NEWWEBSITE_AUTOMATION_TESTING));

			for (int i = 0; i <= 2; i++) {
				super.createScheduledClass(facultyTrialClassPage);
			}
			this.tutorTrialClassPage.clickOnViewAllClassButton();

			Assert.assertTrue(this.tutorTrialClassPage.getAddFacultyToggle());

			super.deleteFacultyToCourse(tutorAddFacultyToCoursePageTutor);

			for (int i = 0; i <= 2; i++) {
				super.deleteScheduledClass(tutorTrialClassPage);
			}

			// Assertion for checking delete trial text
			Assert.assertEquals(this.tutorTrialClassPage.getDeleteTrialMessage(),
					expectedAssertionsProp.getProperty(MSG_DELETE_TRIAL_TOPIC));

			Assert.assertTrue(this.tutorTrialClassPage.getDeleteTrialsCount());

		} catch (

		Exception e) {
			Assert.fail(
					"Exception occured while testing schedule a class and get compose notification page after clicking on notify students: "
							+ e.getMessage());
			logger.error(
					"Error occured while testing schedule a class and get compose notification page after clicking on notify students",
					e);
		}

		logger.info("Ending of testTakeLiveNowClass method");

	}

	@Test(priority = 16, description = "Verify Live portal by tapping live now option")
	@Description("Test Description:Verify Live portal by tapping live now option")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Verify live classses")
	public void testTakeLiveNowClass() {
		logger.info("Starting of testTakeLiveNowClass method");

		try {
			super.createScheduledClass(tutorTrialClassPage);

			this.tutorTrialClassPage.clickOnLiveNow();

			// Assertion for checking live class text
			Assert.assertEquals(this.tutorTrialClassPage.getStartLiveClassLabel(),
					expectedAssertionsProp.getProperty(TXT_START_LIVE_CLASSES));

			this.tutorTrialClassPage.clickOnEndLiveClass();

			Assert.assertEquals(this.tutorTrialClassPage.getOverViewLabelText(),
					expectedAssertionsProp.getProperty(LABEL_STORE_OVERVIEW));

		} catch (

		Exception e) {
			Assert.fail(
					"Exception occured while testing schedule a class and get compose notification page after clicking on notify students: "
							+ e.getMessage());
			logger.error(
					"Error occured while testing schedule a class and get compose notification page after clicking on notify students",
					e);
		}

		logger.info("Ending of testTakeLiveNowClass method");

	}

	@Test(priority = 18, description = "Verify Live portal by tapping live now option")
	@Description("Test Description:Verify Live portal by tapping live now option")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Verify live classses")
	public void testTrialClassFromLiveClassTab() {
		logger.info("Starting of testTakeLiveNowClass method");

		try {
			String course = this.commonFunctionStoreTest.createNewTutorCourse(createCoursePage);
			this.createCoursePage.clickOnStoreButton();
			this.tutorCreateInstallmentPage.setSearch(course);
			this.tutorCreateInstallmentPage.clickOnGetCourse(course);

			Assert.assertEquals(this.tutorTrialClassPage.getLeftTakeTrialClassLabel(),
					expectedAssertionsProp.getProperty(LBL_TAKE_TRIAL));

			Assert.assertEquals(this.tutorTrialClassPage.getPromoteScheduleLabel(),
					expectedAssertionsProp.getProperty(LBL_SCHEDULED_TRIAL));

		} catch (

		Exception e) {
			Assert.fail(
					"Exception occured while testing schedule a class and get compose notification page after clicking on notify students: "
							+ e.getMessage());
			logger.error(
					"Error occured while testing schedule a class and get compose notification page after clicking on notify students",
					e);
		}

		logger.info("Ending of testTakeLiveNowClass method");

	}

	@AfterClass
	public void quitDriver() {
		logger.info("Starting of quitDriver method");

		try {
			if (this.driver != null) {
				Thread.sleep(50000);
				this.loginPage.clickOnLogOut();
				this.quitDriver(this.driver, WEB_DRIVER.TUTOR_TRIAL_CLASS);
				this.quitDriver(this.driver, WEB_DRIVER.FACULTY_TRIAL_CLASS);
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

		logger.info("Starting of getConsoleLogger method");
	}
}