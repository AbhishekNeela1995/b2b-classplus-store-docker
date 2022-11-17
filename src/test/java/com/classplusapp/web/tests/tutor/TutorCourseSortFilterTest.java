package com.classplusapp.web.tests.tutor;

import static com.classplusapp.store.util.Constants.FACULTY_NOTHING_FOUND_MESSAGE;
import static com.classplusapp.store.util.Constants.LABEL_COURSES_SORT_FILTER_LIST;
import static com.classplusapp.store.util.Constants.LABEL_COURSE_SORT_AND_ORDER_LIST;
import static com.classplusapp.store.util.Constants.LABEL_COURSE_STATUS_SORT_FILTER_LIST;
import static com.classplusapp.store.util.Constants.LABEL_SORT_FILTER_LIST;

import java.time.format.DateTimeFormatter;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.classplusapp.web.pages.tutor.TutorCourseSortFilterPage;
import com.classplusapp.web.pages.tutor.TutorCreateCoursePage;
import com.classplusapp.web.tests.CommonFunctionStoreTest;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Epic("Course Sort And Filter")
@Feature("Tutor Course Sort And Filter Test")
public class TutorCourseSortFilterTest extends CommonFunctionStoreTest {

	private WebDriver driver = null;
	private TutorCreateCoursePage tutorCreateCoursePage = null;
	private TutorCourseSortFilterPage tutorCourseSortFilterPage = null;

	private static final Logger logger = Logger.getLogger(TutorCourseSortFilterTest.class.getName());
	private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yy/MM/dd-HH:mm:ss");

	@BeforeClass
	@Parameters({ "browser", "orgCode" })
	public void initClassplusSiteLogin(@Optional("Chrome") String browser, @Optional("learn") String orgCode)
			throws Exception {
		logger.info("Starting of initClassplusSiteLogin methond");

		this.driver = super.loginClassPlusSite(browser, orgCode, tutorMobileNumber, emailAddress,
				WEB_DRIVER.COURSE_SORT_FILTER_TEST);
		this.tutorCreateCoursePage = new TutorCreateCoursePage(driver);
		this.tutorCourseSortFilterPage = new TutorCourseSortFilterPage(driver);

		logger.info("Ending of initClassplusSiteLogin method");
	}

	@Test(priority = 1, description = "Verify Courses sort and filter")
	@Description("Test Description:Verify Courses sort and filter")
	@Severity(SeverityLevel.CRITICAL)
	@Story("Verify courses sort and filter")
	public void testCoursesFilter() {
		logger.info("Starting of testCoursesFilter method");

		try {
			super.clickOnCourseSearchbar(tutorCreateCoursePage);
			this.tutorCourseSortFilterPage.clickOnSortAndFilterButton();

			Assert.assertTrue(this.tutorCourseSortFilterPage.isSelectedCoursesLabel());

			Assert.assertEquals(this.tutorCourseSortFilterPage.getSortFilterList(),
					this.getPropertyList(expectedAssertionsProp.getProperty(LABEL_SORT_FILTER_LIST)));

			Assert.assertEquals(this.tutorCourseSortFilterPage.getCoursesSortFilterList(),
					this.getPropertyList(expectedAssertionsProp.getProperty(LABEL_COURSES_SORT_FILTER_LIST)));

			this.tutorCourseSortFilterPage.clickOnCreatedByMeCheckbox();
			this.tutorCourseSortFilterPage.clickOnApplyButton();

			Assert.assertTrue(this.tutorCourseSortFilterPage.getCreatedByMeCourses());

			this.tutorCourseSortFilterPage.clickOnSortAndFilterButton();
			this.tutorCourseSortFilterPage.clickOnClearAllButton();
			this.tutorCourseSortFilterPage.clickOnSortAndFilterButton();

			Assert.assertFalse(this.tutorCourseSortFilterPage.isSelectedCreatedByMeCheckbox());

			this.tutorCourseSortFilterPage.clickOnApplyButton();
			super.clickOnCourseSearchbar(tutorCreateCoursePage);
			this.tutorCourseSortFilterPage.clickOnSortAndFilterButton();
			this.tutorCourseSortFilterPage.clickOnImportedCourseCheckbox();
			this.tutorCourseSortFilterPage.clickOnApplyButton();

			Assert.assertTrue(this.tutorCourseSortFilterPage.getImportedCourses());

			this.tutorCourseSortFilterPage.clickOnSortAndFilterButton();
			this.tutorCourseSortFilterPage.clickOnClearAllButton();
			this.tutorCourseSortFilterPage.clickOnSortAndFilterButton();

			Assert.assertFalse(this.tutorCourseSortFilterPage.isSelectedImportedCheckbox());

		} catch (Exception e) {
			Assert.fail("Exception occured while testing  Courses sort and filter: " + e.getMessage());
			logger.error("Error occured while testing  Courses sort and filter ", e);
		}

		logger.info("Ending of testCoursesFilter method");
	}

	@Test(priority = 2, description = "Verify Course status sort and filter")
	@Description("Test Description:Verify Course status sort and filter")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verify Course status sort and filter")
	public void testCourseStatusFilter() {
		logger.info("Starting of testCourseStatusFilter method");

		try {
			super.clickOnCourseSearchbar(tutorCreateCoursePage);
			this.tutorCourseSortFilterPage.clickOnSortAndFilterButton();
			this.tutorCourseSortFilterPage.clickOnCourseStatus();

			Assert.assertEquals(this.tutorCourseSortFilterPage.getCoursesSortFilterList(),
					this.getPropertyList(expectedAssertionsProp.getProperty(LABEL_COURSE_STATUS_SORT_FILTER_LIST)));

		} catch (Exception e) {
			Assert.fail("Exception occured while testing  Courses sort and filter: " + e.getMessage());
			logger.error("Error occured while testing  Courses sort and filter ", e);
		}

		logger.info("Ending of testCourseStatusFilter method");
	}

	@Test(priority = 3, description = "Verify selected price range courses")
	@Description("Test Description: Verify selected price range courses")
	@Severity(SeverityLevel.CRITICAL)
	@Story("Verify Course Price Range")
	public void testCoursePriceRange() {
		logger.info("Starting of testCoursePriceRange method");

		try {
			super.clickOnCourseSearchbar(tutorCreateCoursePage);
			this.tutorCourseSortFilterPage.clickOnSortAndFilterButton();
			this.tutorCourseSortFilterPage.clickOnPriceRange();

			Assert.assertTrue(this.tutorCourseSortFilterPage.getDefaultPriceRangeCourses());

			super.clickOnCourseSearchbar(tutorCreateCoursePage);
			this.tutorCourseSortFilterPage.clickOnSortAndFilterButton();
			this.tutorCourseSortFilterPage.clickOnPriceRange();
			this.tutorCourseSortFilterPage.clickOnSetCoursePriceRange();
			this.tutorCourseSortFilterPage.clickOnApplyButton();

			Assert.assertEquals(this.tutorCreateCoursePage.getNothingFoundMessage(),
					expectedAssertionsProp.getProperty(FACULTY_NOTHING_FOUND_MESSAGE));

		} catch (Exception e) {
			Assert.fail("Exception occured while testing  selected price range courses: " + e.getMessage());
			logger.error("Error occured while testing selected price range courses ", e);
		}

		logger.info("Ending of testCoursePriceRange method");
	}

	@Test(priority = 4, description = "Verify sort and order courses")
	@Description("Test Description:Verify sort and order courses")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verify sort and order courses")
	public void testSortAndOrderCourses() {
		logger.info("Starting of testSortAndOrderCourses method");

		try {
			super.clickOnCourseSearchbar(tutorCreateCoursePage);
			this.tutorCourseSortFilterPage.clickOnSortAndFilterButton();
			this.tutorCourseSortFilterPage.clickOnSortAndOrder();

			Assert.assertEquals(this.tutorCourseSortFilterPage.getCourseSortAndOrderList(),
					this.getPropertyList(expectedAssertionsProp.getProperty(LABEL_COURSE_SORT_AND_ORDER_LIST)));

		} catch (Exception e) {
			Assert.fail("Exception occured while testing  Courses sort and order: " + e.getMessage());
			logger.error("Error occured while testing  Courses sort and order ", e);
		}

		logger.info("Ending of testSortAndOrderCourses method");
	}

	@Test(priority = 5, description = "Verify sort and order apply for high to low price courses")
	@Description("Test Description:Verify sort and order apply for high to low price courses")
	@Severity(SeverityLevel.CRITICAL)
	@Story("Verify high to low price courses")
	public void testHighToLowPriceCourses() {
		logger.info("Starting of testHighToLowPriceCourses method");

		try {
			this.tutorCourseSortFilterPage.clickOnHighToLowRadioButton();
			this.tutorCourseSortFilterPage.clickOnApplyButton();

			Assert.assertTrue(this.tutorCourseSortFilterPage.getHighToLowPriceRangeCourses());

		} catch (Exception e) {
			Assert.fail("Exception occured while testing sort and order apply for high to low price courses: "
					+ e.getMessage());
			logger.error("Error occured while testing sort and order apply for high to low price courses ", e);
		}

		logger.info("Ending of testHighToLowPriceCourses method");
	}

	@Test(priority = 6, description = "Verify sort and order apply for low to high price courses")
	@Description("Test Description:Verify sort and order apply for low to high price courses")
	@Severity(SeverityLevel.CRITICAL)
	@Story("Verify high to low price courses")
	public void testLowToHighPriceCourses() {
		logger.info("Starting of testLowToHighPriceCourses method");

		try {
			super.clickOnCourseSearchbar(tutorCreateCoursePage);
			this.tutorCourseSortFilterPage.clickOnSortAndFilterButton();
			this.tutorCourseSortFilterPage.clickOnLowToHighRadioButton();
			this.tutorCourseSortFilterPage.clickOnApplyButton();

			Assert.assertTrue(this.tutorCourseSortFilterPage.getLowToHighPriceRangeCourses());

		} catch (Exception e) {
			Assert.fail("Exception occured while testing sort and order apply for low to high price courses: "
					+ e.getMessage());
			logger.error("Error occured while testing sort and order apply for low to high price courses ", e);
		}

		logger.info("Ending of testLowToHighPriceCourses method");
	}

	@Test(priority = 7, description = "Verify Courses sort and filter")
	@Description("Test Description:Verify Courses sort and filter")
	@Severity(SeverityLevel.CRITICAL)
	@Story("Verify CreatedByMe and Imported Course filters")
	public void testCreatedByMeImportedCourseFilters() {
		logger.info("Starting of testCreatedByMeImportedCourseFilters method");

		try {
			super.clickOnCourseSearchbar(tutorCreateCoursePage);
			this.tutorCourseSortFilterPage.clickOnSortAndFilterButton();
			this.tutorCourseSortFilterPage.clickOnCreatedByMeCheckbox();
			this.tutorCourseSortFilterPage.clickOnImportedCourseCheckbox();
			this.tutorCourseSortFilterPage.clickOnApplyButton();

			Assert.assertEquals(this.tutorCreateCoursePage.getNothingFoundMessage(),
					expectedAssertionsProp.getProperty(FACULTY_NOTHING_FOUND_MESSAGE));

		} catch (Exception e) {
			Assert.fail("Exception occured while testing sort and order apply for low to high price courses: "
					+ e.getMessage());
			logger.error("Error occured while testing sort and order apply for low to high price courses ", e);
		}

		logger.info("Ending of testCreatedByMeImportedCourseFilters method");
	}

	@Test(priority = 8, description = "Verify Created By Me with Default Price Range Courses")
	@Description("Test Description:Verify Created By Me with Default Price Range Courses")
	@Severity(SeverityLevel.CRITICAL)
	@Story("Verify CreatedByMe and default price range Courses")
	public void testCreatedByDefaultPriceRangeCourses() {
		logger.info("Starting of testCreatedByDefaultPriceRangeCourses method");

		try {
			super.clickOnCourseSearchbar(tutorCreateCoursePage);
			this.tutorCourseSortFilterPage.clickOnSortAndFilterButton();
			this.tutorCourseSortFilterPage.clickOnCreatedByMeCheckbox();
			this.tutorCourseSortFilterPage.clickOnPriceRange();

			Assert.assertTrue(this.tutorCourseSortFilterPage.getCreatedByMeDefaultPriceRangeCourse());

		} catch (Exception e) {
			Assert.fail("Exception occured while testing Created By Me with Default Price Range Courses: "
					+ e.getMessage());
			logger.error("Error occured while testing Created By Me with Default Price Range Courses ", e);
		}

		logger.info("Ending of testCreatedByDefaultPriceRangeCourses method");
	}

	@Test(priority = 9, description = "Verify Created By Me with min to max and max to min Price Range Courses")
	@Description("Test Description:Verify Created By Me with min to max and max to min Price Range Courses")
	@Severity(SeverityLevel.CRITICAL)
	@Story("Verify CreatedByMe and move slider price range Courses")
	public void testCreatedByMeWithSliderPriceRangeCourses() {
		logger.info("Starting of testCreatedByMeWithSliderPriceRangeCourses method");

		try {
			super.clickOnCourseSearchbar(tutorCreateCoursePage);
			super.clickOnCreatedByMePriceRange(tutorCourseSortFilterPage);
			this.tutorCourseSortFilterPage.clickOnSetCoursePriceRange();
			this.tutorCourseSortFilterPage.clickOnApplyButton();

			Assert.assertEquals(this.tutorCreateCoursePage.getNothingFoundMessage(),
					expectedAssertionsProp.getProperty(FACULTY_NOTHING_FOUND_MESSAGE));

			super.clickOnCourseSearchbar(tutorCreateCoursePage);
			super.clickOnCreatedByMePriceRange(tutorCourseSortFilterPage);
			this.tutorCourseSortFilterPage.clickOnMaxToMinSetCoursePriceRange();

			Assert.assertTrue(this.tutorCourseSortFilterPage.getCreatedByMePriceRangeCourse());

			super.clickOnClearAllFilter(tutorCourseSortFilterPage);

		} catch (Exception e) {
			Assert.fail(
					"Exception occured while testing Created By Me with min to max and max to min Price Range Courses: "
							+ e.getMessage());
			logger.error(
					"Error occured while testing Created By Me with min to max and max to min Price Range Courses ", e);
		}

		logger.info("Ending of testCreatedByMeWithSliderPriceRangeCourses method");
	}

	@Test(priority = 10, description = "Verify Imported with Default Price Range Courses")
	@Description("Test Description:Verify Imported with Default Price Range Courses")
	@Severity(SeverityLevel.CRITICAL)
	@Story("Verify Imported and default price range Courses")
	public void testImportedDefaultPriceRangeCourses() {
		logger.info("Starting of testImportedDefaultPriceRangeCourses method");

		try {
			super.clickOnCourseSearchbar(tutorCreateCoursePage);
			this.tutorCourseSortFilterPage.clickOnSortAndFilterButton();
			this.tutorCourseSortFilterPage.clickOnImportedCourseCheckbox();
			this.tutorCourseSortFilterPage.clickOnPriceRange();

			Assert.assertTrue(this.tutorCourseSortFilterPage.getDefaultPriceRangeImportedCourses());

		} catch (Exception e) {
			Assert.fail("Exception occured while testing Imported with Default Price Range Courses: " + e.getMessage());
			logger.error("Error occured while testing Imported with Default Price Range Courses ", e);
		}

		logger.info("Ending of testImportedDefaultPriceRangeCourses method");
	}

	@Test(priority = 11, description = "Verify imported with min to max and max to min Price Range Courses")
	@Description("Test Description:Verify imported with min to max and max to min Price Range Courses")
	@Severity(SeverityLevel.CRITICAL)
	@Story("Verify imported and move slider price range Courses")
	public void testMaxAndMinSliderPriceRangeImportedCourses() {
		logger.info("Starting of testMaxAndMinSliderPriceRangeImportedCourses method");

		try {
			super.clickOnCourseSearchbar(tutorCreateCoursePage);
			super.clickOnImportedPriceRange(tutorCourseSortFilterPage);
			this.tutorCourseSortFilterPage.clickOnSetCoursePriceRange();
			this.tutorCourseSortFilterPage.clickOnApplyButton();

			Assert.assertEquals(this.tutorCreateCoursePage.getNothingFoundMessage(),
					expectedAssertionsProp.getProperty(FACULTY_NOTHING_FOUND_MESSAGE));

			super.clickOnCourseSearchbar(tutorCreateCoursePage);
			super.clickOnImportedPriceRange(tutorCourseSortFilterPage);
			this.tutorCourseSortFilterPage.clickOnMaxToMinSetCoursePriceRange();

			Assert.assertTrue(this.tutorCourseSortFilterPage.getImportedPriceRangeCourse());

			super.clickOnClearAllFilter(tutorCourseSortFilterPage);

		} catch (Exception e) {
			Assert.fail("Exception occured while testing imported with min to max and max to min Price Range Courses: "
					+ e.getMessage());
			logger.error("Error occured while testing imported with min to max and max to min Price Range Courses ", e);
		}

		logger.info("Ending of testMaxAndMinSliderPriceRangeImportedCourses method");
	}

	@Test(priority = 12, description = "Verify sort and filter combination with Created By Me , Default Price Range and low to high price of Courses")
	@Description("Test Description:Verify sort and filter combination with Created By Me , Default Price Range and low to high price of Courses")
	@Severity(SeverityLevel.CRITICAL)
	@Story("Verify Low To High Price Created By Me Courses")
	public void testLowToHighDefaultPriceCreatedByMeCourses() {
		logger.info("Starting of testLowToHighDefaultPriceCreatedByMeCourses method");

		try {
			super.clickOnCourseSearchbar(tutorCreateCoursePage);
			this.tutorCourseSortFilterPage.clickOnSortAndFilterButton();
			this.tutorCourseSortFilterPage.clickOnCreatedByMeCheckbox();
			this.tutorCourseSortFilterPage.clickOnSortAndOrder();
			this.tutorCourseSortFilterPage.clickOnLowToHighRadioButton();
			this.tutorCourseSortFilterPage.clickOnPriceRange();

			Assert.assertTrue(this.tutorCourseSortFilterPage.getLowToHighCreatedByMeCourses());

		} catch (Exception e) {
			Assert.fail(
					"Exception occured while testing sort and filter combination with Created By Me , Default Price Range and low to high price of Courses: "
							+ e.getMessage());
			logger.error(
					"Error occured while testing sort and filter combination with Created By Me , Default Price Range and low to high price of Courses ",
					e);
		}

		logger.info("Ending of testLowToHighDefaultPriceCreatedByMeCourses method");
	}

	@Test(priority = 13, description = "Verify sort and filter combination with Created By Me , changing Price Range slider and low to high price ofCourses")
	@Description("Test Description:Verify sort and filter combination with Created By Me ,changing Price Range slider and low to high price of Courses")
	@Severity(SeverityLevel.CRITICAL)
	@Story("Verify Low To High Slider change Price, Created By Me Courses")
	public void testLowToHighSliderChangePriceCreatedByMeCourses() {
		logger.info("Starting of testLowToHighSliderChangePriceCreatedByMeCourses method");

		try {
			super.clickOnCourseSearchbar(tutorCreateCoursePage);
			super.selectCombinationFilter(tutorCourseSortFilterPage);
			this.tutorCourseSortFilterPage.clickOnSetCoursePriceRange();
			this.tutorCourseSortFilterPage.clickOnApplyButton();

			Assert.assertEquals(this.tutorCreateCoursePage.getNothingFoundMessage(),
					expectedAssertionsProp.getProperty(FACULTY_NOTHING_FOUND_MESSAGE));

			super.clickOnCourseSearchbar(tutorCreateCoursePage);
			super.selectCombinationFilter(tutorCourseSortFilterPage);
			this.tutorCourseSortFilterPage.clickOnMaxToMinSetCoursePriceRange();

			Assert.assertTrue(this.tutorCourseSortFilterPage.getLowToHighCreatedByMeCourses());

		} catch (Exception e) {
			Assert.fail(
					"Exception occured while testing sort and filter combination with Created By Me , changing Price Range slider and low to high price of Courses: "
							+ e.getMessage());
			logger.error(
					"Error occured while testing sort and filter combination with Created By Me , changing Price Range slider and low to high price of Courses ",
					e);
		}

		logger.info("Ending of testLowToHighSliderChangePriceCreatedByMeCourses method");
	}

	@Test(priority = 14, description = "Verify sort and filter combinationwithCreated By Me , Default Price Range and high to low price of Courses")
	@Description("Test Description:Verify sort and filter combination with Created By Me , Default Price Range and high to low price of Courses")
	@Severity(SeverityLevel.CRITICAL)
	@Story("Verify High To Low Price Created By Me Courses")
	public void testHighToLowDefaultPriceCreatedByMeCourses() {
		logger.info("Starting of testHighToLowDefaultPriceCreatedByMeCourses method");

		try {
			super.clickOnCourseSearchbar(tutorCreateCoursePage);
			this.tutorCourseSortFilterPage.clickOnSortAndFilterButton();
			this.tutorCourseSortFilterPage.clickOnCreatedByMeCheckbox();
			this.tutorCourseSortFilterPage.clickOnSortAndOrder();
			this.tutorCourseSortFilterPage.clickOnHighToLowRadioButton();
			this.tutorCourseSortFilterPage.clickOnPriceRange();

			Assert.assertTrue(this.tutorCourseSortFilterPage.getHighToLowCreatedByMeCourses());

		} catch (Exception e) {
			Assert.fail(
					"Exception occured while testing sort and filter combination with Created By Me , Default Price Range and high to low price of Courses: "
							+ e.getMessage());
			logger.error(
					"Error occured while testing sort and filter combination with Created By Me , Default Price Range and high to low price of Courses ",
					e);
		}

		logger.info("Ending of testHighToLowDefaultPriceCreatedByMeCourses method");
	}

	@Test(priority = 15, description = "Verify sort and filter combination with Created By Me , changing Price Range slider and high to low price of Courses")
	@Description("Test Description:Verify sort and filter combination with Created By Me ,changing Price Range slider and high to low price of Courses")
	@Severity(SeverityLevel.CRITICAL)
	@Story("Verify high to low Slider change Price, Created By Me Courses")
	public void testHighToLowSliderChangePriceCreatedByMeCourses() {
		logger.info("Starting of testHighToLowSliderChangePriceCreatedByMeCourses method");

		try {
			super.clickOnCourseSearchbar(tutorCreateCoursePage);
			super.selectCombinationFilters(tutorCourseSortFilterPage);
			this.tutorCourseSortFilterPage.clickOnSetCoursePriceRange();
			this.tutorCourseSortFilterPage.clickOnApplyButton();

			Assert.assertEquals(this.tutorCreateCoursePage.getNothingFoundMessage(),
					expectedAssertionsProp.getProperty(FACULTY_NOTHING_FOUND_MESSAGE));

			super.clickOnCourseSearchbar(tutorCreateCoursePage);
			super.selectCombinationFilters(tutorCourseSortFilterPage);
			this.tutorCourseSortFilterPage.clickOnMaxToMinSetCoursePriceRange();

			Assert.assertTrue(this.tutorCourseSortFilterPage.getHighToLowCreatedByMeCourses());

			super.clickOnClearAllFilter(tutorCourseSortFilterPage);

		} catch (Exception e) {
			Assert.fail(
					"Exception occured while testing sort and filter combination with Created By Me , changing Price Range slider and high to low price of Courses: "
							+ e.getMessage());
			logger.error(
					"Error occured while testing sort and filter combination with Created By Me , changing Price Range slider and high to low price of Courses ",
					e);
		}

		logger.info("Ending of testHighToLowSliderChangePriceCreatedByMeCourses method");
	}

	@Test(priority = 16, description = "Verify sort and filter combination with Created By Me , Default Price Range and low to high price of Courses")
	@Description("Test Description:Verify sort and filter combination with Created By Me , Default Price Range and low to high price of Courses")
	@Severity(SeverityLevel.CRITICAL)
	@Story("Verify Low To High Price Created By Me Courses")
	public void testLowToHighDefaultPriceImportedCourses() {
		logger.info("Starting of testLowToHighDefaultPriceImportedCourses method");

		try {
			super.clickOnCourseSearchbar(tutorCreateCoursePage);
			this.tutorCourseSortFilterPage.clickOnSortAndFilterButton();
			this.tutorCourseSortFilterPage.clickOnImportedCourseCheckbox();
			this.tutorCourseSortFilterPage.clickOnSortAndOrder();
			this.tutorCourseSortFilterPage.clickOnLowToHighRadioButton();
			this.tutorCourseSortFilterPage.clickOnPriceRange();

			Assert.assertTrue(this.tutorCourseSortFilterPage.getLowToHighImportedCourses());

		} catch (Exception e) {
			Assert.fail(
					"Exception occured while testing sort and filter combination with Imported, Default Price Range and low to high price of Courses: "
							+ e.getMessage());
			logger.error(
					"Error occured while testing sort and filter combination with Imported , Default Price Range and low to high price of Courses ",
					e);
		}

		logger.info("Ending of testLowToHighDefaultPriceImportedCourses method");
	}

	@Test(priority = 17, description = "Verify sort and filter combination withimported courses , changing Price Range slider and low to high price of Courses")
	@Description("Test Description:Verify sort and filter combination with imported courses ,changing Price Range slider and low to high price of Courses")
	@Severity(SeverityLevel.CRITICAL)
	@Story("Verify Low To High Slider change Price, imported courses Courses")
	public void testLowToHighSliderChangeImportedCourses() {
		logger.info("Starting of testLowToHighSliderChangePriceCreatedByMeCourses method");

		try {
			super.clickOnCourseSearchbar(tutorCreateCoursePage);
			super.selectCombinationImportFilter(tutorCourseSortFilterPage);
			this.tutorCourseSortFilterPage.clickOnSetCoursePriceRange();
			this.tutorCourseSortFilterPage.clickOnApplyButton();

			Assert.assertEquals(this.tutorCreateCoursePage.getNothingFoundMessage(),
					expectedAssertionsProp.getProperty(FACULTY_NOTHING_FOUND_MESSAGE));

			super.clickOnCourseSearchbar(tutorCreateCoursePage);
			super.selectCombinationImportFilters(tutorCourseSortFilterPage);
			this.tutorCourseSortFilterPage.clickOnMaxToMinSetCoursePriceRange();

			Assert.assertTrue(this.tutorCourseSortFilterPage.getLowToHighImportedCourses());

		} catch (Exception e) {
			Assert.fail(
					"Exception occured while testing sort and filter combination with Imported , changing Price Range slider and low to high price of Courses: "
							+ e.getMessage());
			logger.error(
					"Error occured while testing sort and filter combination with Imported , changing Price Range slider and low to high price of Courses ",
					e);
		}

		logger.info("Ending of testLowToHighSliderChangePriceCreatedByMeCourses method");
	}

	@Test(priority = 18, description = "Verify sort and filter combinationwith Imported , Default Price Range and high to low price ofCourses")
	@Description("Test Description:Verify sort and filter combination with Imported , Default Price Range and high to low price of Courses")
	@Severity(SeverityLevel.CRITICAL)
	@Story("Verify High To Low Price Created By Me Courses")
	public void testHighToLowDefaultPriceImportedCourses() {
		logger.info("Starting of testHighToLowDefaultPriceImportedCourses method");

		try {
			super.clickOnCourseSearchbar(tutorCreateCoursePage);
			this.tutorCourseSortFilterPage.clickOnSortAndFilterButton();
			this.tutorCourseSortFilterPage.clickOnImportedCourseCheckbox();
			this.tutorCourseSortFilterPage.clickOnSortAndOrder();
			this.tutorCourseSortFilterPage.clickOnHighToLowRadioButton();
			this.tutorCourseSortFilterPage.clickOnPriceRange();

			Assert.assertTrue(this.tutorCourseSortFilterPage.getHighToLowImportedCourses());

		} catch (Exception e) {
			Assert.fail(
					"Exception occured while testing sort and filter combination with Imported , Default Price Range and high to low price of Courses: "
							+ e.getMessage());
			logger.error(
					"Error occured while testing sort and filter combination with Imported, Default Price Range and high to low price of Courses ",
					e);
		}

		logger.info("Ending of testHighToLowDefaultPriceImportedCourses method");
	}

	@Test(priority = 19, description = "Verify sort and filter combination with Imported , changing Price Range slider and high to low price of Courses")
	@Description("Test Description:Verify sort and filter combination with Imported ,changing Price Range slider and high to low price of Courses")
	@Severity(SeverityLevel.CRITICAL)
	@Story("Verify high to low Slider change Price, Imported Courses")
	public void testHighToLowSliderChangePriceImportedCourses() {
		logger.info("Starting of testHighToLowSliderChangePriceImportedCourses method");

		try {
			super.clickOnCourseSearchbar(tutorCreateCoursePage);
			super.selectCombinationImportFilter(tutorCourseSortFilterPage);
			this.tutorCourseSortFilterPage.clickOnSetCoursePriceRange();
			this.tutorCourseSortFilterPage.clickOnApplyButton();

			Assert.assertEquals(this.tutorCreateCoursePage.getNothingFoundMessage(),
					expectedAssertionsProp.getProperty(FACULTY_NOTHING_FOUND_MESSAGE));

			super.clickOnCourseSearchbar(tutorCreateCoursePage);
			super.selectCombinationImportFilters(tutorCourseSortFilterPage);
			this.tutorCourseSortFilterPage.clickOnMaxToMinSetCoursePriceRange();

			Assert.assertTrue(this.tutorCourseSortFilterPage.getHighToLowImportedCourses());

			super.clickOnClearAllFilter(tutorCourseSortFilterPage);

		} catch (Exception e) {
			Assert.fail(
					"Exception occured while testing sort and filter combination with Imported , changing Price Range slider and high to low price of Courses: "
							+ e.getMessage());
			logger.error(
					"Error occured while testing sort and filter combination with Imported, changing Price Range slider and high to low price of Courses ",
					e);
		}

		logger.info("Ending of testHighToLowSliderChangePriceImportedCourses method");
	}

	@Test(priority = 20, description = "Verify sort and filter combination with created by me,imported and low to high price range courses")
	@Description("Test Description:Verify sort and filter combination with created by me,imported and low to high price range courses")
	@Severity(SeverityLevel.CRITICAL)
	@Story("Verify CreatedByMe Imported With Slider PriceRange Course")
	public void testCreatedByMeImportedWithSliderPriceRangeCourse() {
		logger.info("Starting of testCreatedByMeImportedWithSliderPriceRangeCourse method");

		try {
			super.clickOnCourseSearchbar(tutorCreateCoursePage);
			this.tutorCourseSortFilterPage.clickOnSortAndFilterButton();
			this.tutorCourseSortFilterPage.clickOnCreatedByMeCheckbox();
			this.tutorCourseSortFilterPage.clickOnImportedCourseCheckbox();
			this.tutorCourseSortFilterPage.clickOnSortAndOrder();
			this.tutorCourseSortFilterPage.clickOnLowToHighRadioButton();
			this.tutorCourseSortFilterPage.clickOnApplyButton();

			driver.navigate().refresh();
			Assert.assertEquals(this.tutorCreateCoursePage.getNothingFoundMessage(),
					expectedAssertionsProp.getProperty(FACULTY_NOTHING_FOUND_MESSAGE));

		} catch (Exception e) {
			Assert.fail(
					"Exception occured while testing sort and filter combination with created by me,imported and low to high price range courses: "
							+ e.getMessage());
			logger.error(
					"Error occured while testing sort and filter combination with created by me,imported and low to high price range courses ",
					e);
		}

		logger.info("Ending of testCreatedByMeImportedWithSliderPriceRangeCourse method");
	}

	@AfterClass
	public void quitDriver() {
		logger.info("Starting of quitDriver method");

		try {
			if (driver != null) {
				Thread.sleep(5000);
				this.loginPage.clickOnLogOut();
				this.quitDriver(this.driver, WEB_DRIVER.COURSE_SORT_FILTER_TEST);
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