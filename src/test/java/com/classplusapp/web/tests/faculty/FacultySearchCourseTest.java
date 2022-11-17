package com.classplusapp.web.tests.faculty;

import static com.classplusapp.store.util.Constants.*;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.classplusapp.web.pages.faculty.FacultySearchCoursePage;
import com.classplusapp.web.pages.faculty.TutorAddingFacultyToCoursePage;
import com.classplusapp.web.pages.tutor.TutorAddContentPage;
import com.classplusapp.web.pages.tutor.TutorCreateCoursePage;
import com.classplusapp.web.pages.tutor.TutorCreateInstallmentPage;
import com.classplusapp.web.pages.tutor.TutorMarkFeaturedPage;
import com.classplusapp.web.tests.BaseClassplusAutomationTest;
import com.classplusapp.web.tests.CommonFunctionStoreTest;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Epic("Store Search Course")
@Feature("Faculty Search Course Test")
public class FacultySearchCourseTest extends CommonFunctionStoreTest {

	//private WebDriver tutorDriver = null;
	private WebDriver facultyDriver = null;
	private TutorAddContentPage tutorAddContentPage = null;
	private TutorAddContentPage tutorAddContentPageFaculty = null;
	private FacultySearchCoursePage searchCoursePage = null;
	private TutorMarkFeaturedPage tutorMarkFeaturedPage = null;
	private TutorAddingFacultyToCoursePage tutorAddFacultyToCoursePage = null;
	private TutorCreateInstallmentPage tutorCreateInstallmentPage = null;
	private TutorMarkFeaturedPage tutorMarkfeaturedPage = null;
	private FacultySearchCoursePage searchCoursePageTutor = null;

	private static final Logger logger = Logger.getLogger(FacultySearchCourseTest.class.getName());

	@BeforeClass
	@Parameters({ "browser", "orgCode3"})
	public void initClassplusSiteLogin(@Optional("Chrome")String browser, @Optional("learn")String orgCode) throws Exception {
		logger.info("Starting of initClassplusSiteLogin method");

	//	this.tutorDriver = super.loginClassPlusSite(browser, orgCode, mobileNumber, emailAddress,
		//		WEB_DRIVER.TUTOR_DRIVER);
		this.facultyDriver = super.loginClassPlusSite(browser, orgCode, facultyOneMobileNumber, emailAddress,
				WEB_DRIVER.SEARCH_COURSE_DRIVER);
		this.tutorAddContentPage = new TutorAddContentPage(facultyDriver);
		this.tutorAddContentPageFaculty = new TutorAddContentPage(facultyDriver);
		//this.tutorCreateCoursePage = new TutorCreateCoursePage(tutorDriver);
		this.tutorCreateCoursePageFaculty = new TutorCreateCoursePage(facultyDriver);

		this.searchCoursePage = new FacultySearchCoursePage(facultyDriver);
		//this.searchCoursePageTutor = new FacultySearchCoursePage(tutorDriver);
		this.tutorMarkFeaturedPage = new TutorMarkFeaturedPage(facultyDriver);
		this.tutorAddFacultyToCoursePage = new TutorAddingFacultyToCoursePage(facultyDriver);
		this.tutorCreateInstallmentPage = new TutorCreateInstallmentPage(facultyDriver);
		this.tutorMarkfeaturedPage = new TutorMarkFeaturedPage(facultyDriver);

		logger.info("Ending of initClassplusSiteLogin method");
	}

	@Test(priority = 1, description = "verify that by clicking on Store tab, Search option is available for faculty.")
	@Description("Test Description:verify that by clicking on Store tab, Search option is available for faculty.")
	@Severity(SeverityLevel.BLOCKER)
	@Story("test Search Field")
	public void testSearchField() {
		logger.info("Starting of testSearchField method");

	try {
			this.tutorAddContentPageFaculty.clickOnStoreButton();

			Assert.assertTrue(this.tutorAddContentPageFaculty.getSearchField());

	} catch (Exception e) {
			Assert.fail(
					"Exception occured while testing that by clicking on Store tab, Search option is available for faculty: "
							+ e.getMessage());
			logger.error(
					"Error occured while testing that by clicking on Store tab, Search option is available for faculty",
					e);
		}

		logger.info("Ending of testSearchField method");
	}

	@Test(priority = 2, description = "verify that by clicking on Search bar, faculty can enter data.")
	@Description("Test Description:verify that by clicking on Search bar, faculty can enter data.")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Test Search Field Get Entered Data")
	public void testSearchFieldGetEnteredData() {
		logger.info("Starting of testSearchField method");

		try {
			this.tutorAddContentPageFaculty.clickOnStoreButton();
			this.tutorAddContentPageFaculty
					.clickOnTxtSearchCourse(testDataProp.getProperty(CREATECOURSE_FACULTY_TITLE));
			this.clickOutside(facultyDriver);

			Assert.assertTrue(this.tutorAddContentPage
					.getEnteredDataInSearchField(testDataProp.getProperty(CREATECOURSE_FACULTY_TITLE)));

		} catch (Exception e) {
			Assert.fail("Exception occured while testing that by clicking on Search bar, faculty can enter data: "
					+ e.getMessage());
			logger.error("error occured while testing that by clicking on Search bar, faculty can enter data: ", e);
		}

		logger.info("Ending of testSearchFieldGetEnteredData method");
	}

	@Test(priority = 3, description = "verify that search bar on the store page reflects the courses as per the input provided by faculty")
	@Description("Test Description:verify  that search bar on the store page reflects the courses as per the input provided by faculty")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Test Search Course")
	public void testSearchCourse() {
		logger.info("Starting of testSearchCourse method");

		try {
			this.tutorAddContentPageFaculty.clickOnStoreButton();
			this.tutorAddContentPageFaculty
					.clickOnTxtSearchCourse(testDataProp.getProperty(CREATECOURSE_FACULTY_TITLE));

			Assert.assertEquals(this.tutorAddContentPageFaculty.getB2bFacultyLabel(),
					expectedAssertionsProp.getProperty(CREATED_FACULTY_NAME_LABEL));

		} catch (Exception e) {
			Assert.fail(
					"Exception occured while testing search bar on the store page reflects the courses as per the input provided by faculty: "
							+ e.getMessage());
			logger.error(
					"Error occured while testing search bar on the store page reflects the courses as per the input provided by faculty",
					e);
	}

		logger.info("Ending of testSearchCourse method");
	}

	@Test(priority = 4, description = "verify that when faculty enter the invalid or wrong course name in the search bar Nothing found!Your search returned no results. Try searching something else. text reflects on the faculty")
	@Description("Test Description:verify that when faculty  enter the invalid or wrong course name in the search bar Nothing found!Your search returned no results. Try searching something else. text reflects on the faculty")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test Search Course With Invalid Course Name")
	public void testSearchCourseWithInvalidCourseName() {
		logger.info("Starting of testSearchCourseWithInvalidCourseName method");

		try {
			this.tutorAddContentPageFaculty.clickOnStoreButton();

			this.tutorAddContentPageFaculty
					.clickOnTxtSearchCourse(testDataProp.getProperty(FACULTY_SEARCH_WITH_INVALID_COURSE));

			Assert.assertEquals(this.searchCoursePage.getNothingFoundMessage(),
					expectedAssertionsProp.getProperty(FACULTY_NOTHING_FOUND_MESSAGE));

			Assert.assertEquals(this.searchCoursePage.getNoResultsMessage(),
					expectedAssertionsProp.getProperty(FACULTY_NO_RESULTS_MESSAGE));
		} catch (Exception e) {
			Assert.fail(
					"Exception occured while testing when faculty  enter the invalid or wrong course name in the search bar Nothing found!Your search returned no results. Try searching something else. text reflects on the faculty: "
							+ e.getMessage());
			logger.error(
					"Error occured while testing when faculty  enter the invalid or wrong course name in the search bar Nothing found!Your search returned no results. Try searching something else. text reflects on the faculty: ",
					e);
		}

		logger.info("Ending of testSearchCourseWithInvalidCourseName method");
	}
	@Test(priority = 5, description = "Verify that 'View All' CTA is available at the bottom of the courses.")
	@Description("Test Description:Verify that 'View All' CTA is available at the bottom of the courses.")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test View All CTA At Bottom")
	public void testViewAllCTAAtBottom() {
		logger.info("Starting of testViewAllCourses method");

		try {
			this.tutorAddContentPageFaculty.clickOnStoreButton();

			Assert.assertTrue(this.searchCoursePage.getViewAllText());

		} catch (Exception e) {
			Assert.fail("Exception occured while testing 'View All' CTA is available at the bottom of the courses: "
					+ e.getMessage());
			logger.error("error occured while testing 'View All' CTA is available at the bottom of the courses: ", e);
		}

		logger.info("Ending of testViewAllCourses method");
	}

	@Test(priority = 6, description = "Verify view all button at the bottom of the page on the store page displays all courses in which faculty is added by the tutor")
	@Description("Test Description:Verify view all button at the bottom of the page on the store page displays all courses in which faculty is added by the tutor")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test View All Courses")
	public void testViewAllCourses() {
		logger.info("Starting of testViewAllCourses method");

		try {
			this.tutorAddContentPageFaculty.clickOnStoreButton();

			Assert.assertTrue(this.searchCoursePage.getCoursesCount());

		} catch (Exception e) {
			Assert.fail(
					"Exception occured while testing  view all button at the bottom of the page on the store page displays all courses in which faculty is added by the tutor: "
							+ e.getMessage());
			logger.error(
					"error occured while testing view all button at the bottom of the page on the store page displays all courses in which faculty is added by the tutor: ",
					e);
		}

		logger.info("Ending of testViewAllCourses method");
	}

	@Test(priority = 7, description = "verify when faculty get inside in a course only 4 modules reflect on the faculty screen")
	@Description("Test Description:Verify when faculty get inside in a course only 4 modules reflect on the faculty screen")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test Course Left Menu")
	public void testCourseLeftMenu() {
		logger.info("Starting of testCourseLeftMenu method");

		try {
			this.tutorAddContentPageFaculty.clickOnStoreButton();
			this.tutorAddContentPageFaculty
					.clickOnTxtSearchCourse(testDataProp.getProperty(CREATECOURSE_FACULTY_TITLE));
			this.searchCoursePage.clickOnGetCourseFolder();
			this.searchCoursePage.getLeftMenuLabels(expectedAssertionsProp.getProperty(LEFT_MENU_LABELS));

		} catch (Exception e) {
			Assert.fail(
					"Exception occured while testing when faculty get inside in a course only 4 modules reflect on the faculty screen: "
							+ e.getMessage());
		logger.error(
				"error occured while testing when faculty get inside in a course only 4 modules reflect on the faculty screen: ",
					e);
		}

		logger.info("Ending of testCourseLeftMenu method");
	}

	@Test(priority = 8, description = "Verify that on the overview section of the course by clicking on the 3 horizontal dots faculty copy the course link ")
	@Description("Test Description:Verify that on the overview section of the course by clicking on the 3 horizontal dots faculty copy the course link ")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test Copy Course Link")
	public void testCopyCourseLink() {
		logger.info("Starting of testCopyCourseLink method");

		try {
			this.tutorAddContentPageFaculty.clickOnStoreButton();
			this.tutorAddContentPageFaculty
					.clickOnTxtSearchCourse(testDataProp.getProperty(CREATECOURSE_FACULTY_TITLE));
			this.searchCoursePage.clickOnGetCourseFolder();
			super.testCopyCourseLink(tutorMarkFeaturedPage);

			// Assertion for checking the link copy text
			String msgLinkCopied = tutorMarkfeaturedPage.getLinkCopiedMessage();
			Assert.assertEquals(msgLinkCopied, expectedAssertionsProp.getProperty(MARKFEATURE_LINK_COPIED_TEXT));

		} catch (Exception e) {
			Assert.fail(
					"Exception occured while testing the overview section of the course by clicking on the 3 horizontal dots faculty copy the course link : "
							+ e.getMessage());
			logger.error(
					"error occured while testing the overview section of the course by clicking on the 3 horizontal dots faculty copy the course link : ",
					e);
		}

		logger.info("Ending of testCopyCourseLink method");
	}

	@Test(priority = 9, description = "Verify that by clicking on the view details of live classes section ")
	@Description("Test Description: Verify that by clicking on the view details of live classes section  ")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test Live Classes View Details")
	public void testLiveClassesViewDetails() {
		logger.info("Starting of testLiveClassesViewDetails method");

		try {
			this.tutorAddContentPageFaculty.clickOnStoreButton();
			this.tutorAddContentPageFaculty
					.clickOnTxtSearchCourse(testDataProp.getProperty(FACULTY_LIVE_CLASSES_COURSE));
			this.tutorCreateInstallmentPage.clickOnGetCourse(testDataProp.getProperty(FACULTY_LIVE_CLASSES_COURSE));
			this.tutorAddFacultyToCoursePage.clickOnLiveClass();

			//Assert.assertTrue(this.tutorAddFacultyToCoursePage.getCountLiveClass());

			this.tutorAddFacultyToCoursePage.clickOnLiveClassMenu();
			this.tutorAddFacultyToCoursePage.clickOnViewLiveClassDetails();
			

			Assert.assertEquals(this.tutorAddFacultyToCoursePage.getLiveClassDetailsHeader(),
					expectedAssertionsProp.getProperty(LIVE_CLASS_DETAILS_HEADER));

		this.tutorAddFacultyToCoursePage.clickOnLiveClassClose();
		} catch (Exception e) {
			Assert.fail(
					"Exception occured while testing that by clicking on theview details of live classes section  : "
							+ e.getMessage());
			logger.error("Error occured while testing  that by clicking on theview details of live classes section  ",
					e);
	}

		logger.info("Ending of testLiveClassesViewDetails method");
	}

	@Test(priority = 10, description = "Verify that the Content summary on the overview page of the course reflects the total count of courses available inthe course along with their duration ")
	@Description("Test Description:Verify that the Content summary on the overview page of the course reflects the total count of courses available in the course along with their duration")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test Course Content Summary")
	public void testCourseContentSummary() {
		logger.info("Starting of testCourseContentSummary method");

		try {
			this.tutorAddContentPageFaculty.clickOnStoreButton();
			this.tutorAddContentPageFaculty
					.clickOnTxtSearchCourse(testDataProp.getProperty(FACULTY_LIVE_CLASSES_COURSE));
			this.tutorCreateInstallmentPage.clickOnGetCourse(testDataProp.getProperty(FACULTY_LIVE_CLASSES_COURSE));
			// super.createSimpleCourse(tutorCreateCoursePage);
			super.testAddContent(tutorAddContentPageFaculty);
			this.facultyDriver.navigate().refresh();
			this.tutorCreateCoursePageFaculty.clickOnOverviewButton();

			Assert.assertTrue(this.tutorAddFacultyToCoursePage.getContentSummaryCount());

		} catch (Exception e) {
			Assert.fail(
					"Exception occured while testing  that the Content summary on the overview page of the course reflects the total count of courses available in the course along with their duration : "
							+ e.getMessage());
			logger.error(
					"Error occured while testing   that the Content summary on the overview page of the course reflects the total count of courses available in the course along with their duration ",
					e);
		}
		logger.info("Ending of testCourseContentSummary Page");
	}

	@Test(priority = 11, description = "Verify that Free content added by tutor in the course displays in the content summary section to the faculty ")
	@Description("Test Description: Verify that Free content added by tutor in the course displays in the content summary section to the faculty  ")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test View Free Content")
	public void testViewFreeContent() {
		logger.info("Starting of testViewFreeContent method");

	try {
		this.tutorAddContentPageFaculty.clickOnStoreButton();
		this.tutorAddContentPageFaculty
				.clickOnTxtSearchCourse(testDataProp.getProperty(FACULTY_LIVE_CLASSES_COURSE));
		this.tutorCreateInstallmentPage.clickOnGetCourse(testDataProp.getProperty(FACULTY_LIVE_CLASSES_COURSE));
		
			Assert.assertEquals(this.tutorAddFacultyToCoursePage.getFreeContentText(),
					expectedAssertionsProp.getProperty(FREE_CONTENT_TEXT));

		} catch (Exception e) {
			Assert.fail(
					"Exception occured while testing the Free content added by tutor in the course displays in the content summary section to the faculty  : "
							+ e.getMessage());
			logger.error(
					"Error occured while testing the Free content added by tutor in the course displays in the content summary section to the faculty ",
					e);
		}

		logger.info("Ending of testViewFreeContent Page");
	}

	@AfterClass
	public void quitDriver() {
		try {
			
				if (facultyDriver != null) {
					Thread.sleep(5000);
					this.loginPage.clickOnLogOut();
					this.quitDriver(this.facultyDriver, WEB_DRIVER.SEARCH_COURSE_DRIVER);
					logger.info("Faculty Driver quit successfully");
				}
		
		} catch (Exception ex) {
			logger.error(ex.getMessage());
		}
	}

}