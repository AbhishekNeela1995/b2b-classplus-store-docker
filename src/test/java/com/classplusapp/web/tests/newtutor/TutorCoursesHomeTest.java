package com.classplusapp.web.tests.newtutor;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import static com.classplusapp.store.util.Constants.*;
import com.classplusapp.web.pages.newtutor.TutorCoursesHomePage;
import com.classplusapp.web.pages.student.StudentBuyCoursePage;
import com.classplusapp.web.pages.tutor.TutorAddContentPage;
import com.classplusapp.web.pages.tutor.TutorCreateCoursePage;
import com.classplusapp.web.tests.CommonFunctionStoreTest;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Epic("Store MyCourses")
@Feature("Tutor CreateCourse Test")
public class TutorCoursesHomeTest extends CommonFunctionStoreTest {

	private WebDriver driver = null;
	private WebDriver newTutordriver = null;
	private TutorCreateCoursePage tutorCreateCoursePage = null;
	private TutorCoursesHomePage tutorCoursesHomePage = null;
	private TutorAddContentPage tutorAddContentPage = null;
	private StudentBuyCoursePage buyCoursePage = null;
	private TutorCoursesHomePage tutorCourseHomePage = null;

	private static final Logger logger = Logger.getLogger(TutorCoursesHomeTest.class.getName());

	@BeforeClass
	@Parameters({ "browser", "orgCode"})
	public void initClassplusSiteLogin(@Optional("Chrome")String browser, @Optional("learn")String orgCode)
			throws Exception {
		logger.info("Starting of initClassplusSiteLogin methond");

		this.driver = super.loginClassPlusSite(browser, orgCode, tutorMobileNumber, emailAddress,
				WEB_DRIVER.CREATE_COURSE_TEST);
		this.newTutordriver = super.loginClassPlusSite(browser, orgCode, tutorMobileNumber, emailAddress,
				WEB_DRIVER.CREATE_NEWCOURSE_TEST);
		this.tutorCreateCoursePage = new TutorCreateCoursePage(driver);
		this.tutorCoursesHomePage = new TutorCoursesHomePage(driver);
		this.tutorCourseHomePage = new TutorCoursesHomePage(newTutordriver);
		this.tutorAddContentPage = new TutorAddContentPage(this.driver);
		this.buyCoursePage = new StudentBuyCoursePage(this.driver);

		logger.info("Ending of initClassplusSiteLogin method");
	}

//	@Test(priority = 1, description = "Verify the tutor can create and publish the course")
	@Description("Test Description: Verify the tutor can create and publish the course")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Verify Publish course")
	public void testCreateAndPublishCourse() {
		logger.info("Starting of testCreateAndPublishCourse method");

		try {
			this.hardWait(3);
			super.createNewTutorCourse(tutorCreateCoursePage);
			super.testAddModalSubjectiveTest(tutorAddContentPage);

			// Assertion for checking the Add Subjective Test
			Assert.assertEquals(this.tutorAddContentPage.getAddSubjectiveTestMessage(),
					expectedAssertionsProp.getProperty(SUBJECTIVETEST_ADDED_SUCCESSFULLY_TEXT));
			
			this.tutorCreateCoursePage.clickOnOverviewButton();
			this.hardWait(3);
			super.testPublishCourse(tutorAddContentPage);

			// Assertion for checking the publish course text
			Assert.assertEquals(this.tutorAddContentPage.getPublishSuccessText(),
					expectedAssertionsProp.getProperty(COURSE_PUBLISHED_TEXT));

		} catch (Exception e) {
			Assert.fail("Exception occured while testing tutor can create and publish the course: " + e.getMessage());
			logger.error("Error occured while testing tutor can create and publish the course ", e);
		}

		logger.info("Ending of testCreateAndPublishCourse method");
	}

	@Test(priority = 2, description = "Verify Tutor can copy the course link")
	@Description("Test Description:Verify Tutor can copy the course link")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verify copy course")
	public void testCopyCourse() {
		logger.info("Starting of testCopyCourse method");

		try {

			this.hardWait(2);
			this.tutorCoursesHomePage.clickOnShare();
			this.tutorCoursesHomePage.clickOnCopy();

			// Assertion for checking the link copy text
			Assert.assertEquals(this.tutorCoursesHomePage.getLinkCopiedMessage(),
					expectedAssertionsProp.getProperty(MARKFEATURE_LINK_COPIED_TEXT));

			String getCopyLink = this.tutorCoursesHomePage.getCopiedCourseLink();
			this.newTutordriver.get(getCopyLink);

			// Assertion for checking the learning light text
			Assert.assertEquals(this.tutorCourseHomePage.getLearningLightLabel(),
					expectedAssertionsProp.getProperty(LEARNING_LIGHT_LABEL));

		} catch (Exception e) {
			Assert.fail("Exception occured while testing Tutor can copy the course link: " + e.getMessage());
			logger.error("Error occured while testing Tutor can copy the course link", e);
		}

		logger.info("Ending of testCopyCourse method");
	}

	@Test(priority = 3, description = "Verify Course Home Page Labels")
	@Description("Test Description: Verify Course Home Page Labels")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verify Course Home Page Labels")
	public void testCourseHomePageLabels() {
		logger.info("Starting of testCourseHomePageLabels method");

		try {

			Assert.assertEquals(this.tutorCourseHomePage.getCourseName(),
					expectedAssertionsProp.getProperty(NEW_TUTOR_COURSE_NAME_LABEL));

			Assert.assertEquals(this.tutorCourseHomePage.getAvailableOfferslabel(),
					expectedAssertionsProp.getProperty(AVAILABLE_OFFERS_LABEL));

			Assert.assertEquals(this.tutorCourseHomePage.getCouponAvailable(),
					expectedAssertionsProp.getProperty(COUPON_AVAILABLE_LABEL));

			Assert.assertEquals(this.tutorCourseHomePage.getViewAllAvailbleOffersLabel(),
					expectedAssertionsProp.getProperty(VIEW_ALL_AVAILABLE_OFFERS_LABEL));

			Assert.assertEquals(this.tutorCourseHomePage.getGetThisCourseLabel(),
					expectedAssertionsProp.getProperty(GET_THIS_COURSE_LABEL));

			Assert.assertEquals(this.tutorCourseHomePage.getOverviewAndContentLabels(),
					expectedAssertionsProp.getProperty(CONTENT_AND_OVERVIEW_LABEL));

			Assert.assertEquals(this.tutorCourseHomePage.getContactUsLabel(),
					expectedAssertionsProp.getProperty(CONTACT_US_LABEL));

			Assert.assertEquals(this.tutorCourseHomePage.getQueryLabel(),
					expectedAssertionsProp.getProperty(QUERY_LABEL));

		} catch (Exception e) {
			Assert.fail("Exception occured while testing Course Home Page Labels: " + e.getMessage());
			logger.error("Error occured while testing Course Home Page Labels", e);
		}

		logger.info("Ending of testCourseHomePageLabels method");
	}

	@Test(priority = 4, description = "Verify Total Price")
	@Description("Test Description:Verify Total Price")
	@Severity(SeverityLevel.CRITICAL)
	@Story("Verify Total Price")
	public void testTotalPrice() {
		logger.info("Starting of testTotalPrice method");

		try {
			int totalPrice = this.tutorCourseHomePage.totalPrice();
			this.tutorCourseHomePage.clickOndownCarouselPrice();
			int courseAndGSTprice = this.tutorCourseHomePage.CourseAndGSTprice();

			Assert.assertEquals(totalPrice, courseAndGSTprice);

		} catch (Exception e) {
			Assert.fail("Exception occured while testing Total Price: " + e.getMessage());
			logger.error("Error occured while testing Total Price", e);
		}

		logger.info("Ending of testTotalPrice method");
	}

	@Test(priority = 5, description = "Verify Apply coupon")
	@Description("Test Description: Verify Apply coupon")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verify Apply coupon")
	public void testApplyCoupon() {
		logger.info("Starting of testApplyCoupon method");

		try {
			this.tutorCourseHomePage.clickOnApplyHereButton();

			Assert.assertEquals(this.tutorCourseHomePage.getApplyCouponHeader(),
					expectedAssertionsProp.getProperty(APPLY_COUPON_HEADER));

			this.tutorCourseHomePage.setSearchCoupon(testDataProp.getProperty(NEW_TUTOR_SEARCH_COUPON));
			this.tutorCourseHomePage.clickOnApplyButton();

			Assert.assertEquals(this.tutorCourseHomePage.getAppliedSuccesfully(),
					expectedAssertionsProp.getProperty(APPLIED_SUCCESSFULLY_TEXT));

			this.tutorCourseHomePage.clickOnDoneButton();

			Assert.assertEquals(this.tutorCourseHomePage.getAppliedCouponName(),
					expectedAssertionsProp.getProperty(NEW_TUTOR_SEARCH_COUPON));

		} catch (Exception e) {
			Assert.fail("Exception occured while testing Course Apply coupon: " + e.getMessage());
			logger.error("Error occured while testing Apply coupon", e);
		}

		logger.info("Ending of testApplyCoupon method");
	}

	@Test(priority = 6, description = "Verify Remove coupon")
	@Description("Test Description: Verify Remove coupon")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verify Remove coupon")
	public void testRemoveCoupon() {
		logger.info("Starting of testRemoveCoupon method");

		try {
			this.tutorCourseHomePage.clickOnRemoveButton();
			
			Assert.assertTrue(this.tutorCourseHomePage.isDisplayedAppliedCoupon());
			
		} catch (Exception e) {
			Assert.fail("Exception occured while testing Course Remove coupon: " + e.getMessage());
			logger.error("Error occured while testing Remove coupon", e);
		}

		logger.info("Ending of testRemoveCoupon method");
	}


	@Test(priority = 7, description = "Verify Apply Coupon From Available Offers")
	@Description("Test Description:Verify Apply Coupon From Available Offers")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verify Apply Coupon From Available Offers")
	public void testApplyCouponFromAvailableOffers() {
		logger.info("Starting of testApplyCouponFromAvailableOffers method");

		try {

			this.tutorCourseHomePage.clickOnViewAllButton();
			super.testApplyCoupon(tutorCourseHomePage);

			Assert.assertEquals(this.tutorCourseHomePage.getAppliedCouponName(),
					expectedAssertionsProp.getProperty(NEW_TUTOR_SEARCH_COUPON));

		} catch (Exception e) {
			Assert.fail("Exception occured while testing Apply Coupon From Available Offers: " + e.getMessage());
			logger.error("Error occured while testing Apply Coupon From Available Offers", e);
		}

		logger.info("Ending of testApplyCouponFromAvailableOffers method");
	}

	@Test(priority = 8, description = "Verify Remove coupon Applied From Available Offers")
	@Description("Test Description:Verify Remove coupon Applied From Available Offers")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verify Remove coupon Applied From Available Offers")
	public void testRemoveCouponAppliedFromAvailableOffers() {
		logger.info("Starting of testRemoveCouponAppliedFromAvailableOffers method");

		try {

			this.tutorCourseHomePage.clickOnRemoveButton();

			Assert.assertTrue(this.tutorCourseHomePage.isDisplayedAppliedCoupon());

		} catch (Exception e) {
			Assert.fail(
					"Exception occured while testing Remove coupon Applied From Available Offers: " + e.getMessage());
			logger.error("Error occured while testing Remove coupon Applied From Available Offers", e);
		}

		logger.info("Ending of testRemoveCouponAppliedFromAvailableOffers method");
	}

	@Test(priority = 9, description = "Verify Apply Invalid Coupon ")
	@Description("Test Description:Verify Apply In valid Coupon ")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verify Apply In valid Coupon ")
	public void testApplyInvalidCoupon() {
		logger.info("Starting of testApplyInvalidCoupon method");

		try {
			this.tutorCourseHomePage.clickOnApplyHereButton();

			Assert.assertEquals(this.tutorCourseHomePage.getApplyCouponHeader(),
					expectedAssertionsProp.getProperty(APPLY_COUPON_HEADER));

			this.tutorCourseHomePage.setSearchCoupon(testDataProp.getProperty(NEW_TUTOR_SEARCH_IN_VALID_COUPON));
			this.tutorCourseHomePage.clickOnApplyButton();

			Assert.assertEquals(this.tutorCourseHomePage.getInvalidCouponMessage(),
					expectedAssertionsProp.getProperty(NEW_TUTOR_INVALID_COUPON_MESSAGE));

			this.tutorCourseHomePage.clickOnApplyCouponCloseIcon();

		} catch (Exception e) {
			Assert.fail("Exception occured while testing Apply In valid Coupon : " + e.getMessage());
			logger.error("Error occured while testing Apply In valid Coupon ", e);
		}

		logger.info("Ending of testApplyInvalidCoupon method");
	}

	@Test(priority = 10, description = "Verify Apply Coupon In Course Home Page")
	@Description("Test Description:Verify Apply Coupon In Course Home Page")
	@Severity(SeverityLevel.CRITICAL)
	@Story("Verify Apply Coupon In Course Home Page")
	public void testApplyCouponInCourseHomePage() {
		logger.info("Starting of testApplyCouponInCourseHomePage method");

		try {
			this.tutorCourseHomePage.clickOnCouponLabel();

			Assert.assertEquals(this.tutorCourseHomePage.getAppliedSuccesfully(),
					expectedAssertionsProp.getProperty(APPLIED_SUCCESSFULLY_TEXT));

			this.tutorCourseHomePage.clickOnDoneButton();

			Assert.assertEquals(this.tutorCourseHomePage.getAppliedCouponName(),
					expectedAssertionsProp.getProperty(NEW_TUTOR_SEARCH_COUPON));

		} catch (Exception e) {
			Assert.fail("Exception occured while testing Apply Coupon In Course Home Page: " + e.getMessage());
			logger.error("Error occured while testing Apply Coupon In Course Home Page", e);
		}

		logger.info("Ending of testApplyCouponInCourseHomePage method");
	}

	@Test(priority = 11, description = "Verify Remove coupon")
	@Description("Test Description: Verify Remove coupon")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verify Remove coupon")
	public void testRemoveAppliedCoupon() {
		logger.info("Starting of testRemoveAppliedCoupon method");

		try {
			this.tutorCourseHomePage.clickOnRemoveButton();
			
			Assert.assertTrue(this.tutorCourseHomePage.isDisplayedAppliedCoupon());
		
		} catch (Exception e) {
			Assert.fail("Exception occured while testing Course Remove coupon: " + e.getMessage());
			logger.error("Error occured while testing Remove coupon", e);
		}

		logger.info("Ending of testRemoveAppliedCoupon method");
	}

	@Test(priority = 12, description = "Verify Course Price After Applying Coupon")
	@Description("Test Description:Verify Course Price After Applying Coupon")
	@Severity(SeverityLevel.CRITICAL)
	@Story("Verify Course Price After Applying Coupon")
	public void testCoursePriceAfterApplyingCoupon() {
		logger.info("Starting of testCoursePriceAfterApplyingCoupon method");

		try {
			int priceBeforeApplyingCoupon = this.tutorCourseHomePage.totalCoursePrice();
			this.tutorCourseHomePage.clickOnApplyHereButton();

			Assert.assertEquals(this.tutorCourseHomePage.getApplyCouponHeader(),
					expectedAssertionsProp.getProperty(APPLY_COUPON_HEADER));

			this.tutorCourseHomePage.setSearchCoupon(testDataProp.getProperty(NEW_TUTOR_SEARCH_COUPON));
			this.tutorCourseHomePage.clickOnApplyButton();

			Assert.assertEquals(this.tutorCourseHomePage.getAppliedSuccesfully(),
					expectedAssertionsProp.getProperty(APPLIED_SUCCESSFULLY_TEXT));

			this.tutorCourseHomePage.clickOnDoneButton();

			Assert.assertEquals(this.tutorCourseHomePage.getAppliedCouponName(),
					expectedAssertionsProp.getProperty(NEW_TUTOR_SEARCH_COUPON));

			int couponPrice = this.tutorCourseHomePage.getDiscountPrice();
			int priceAfterApplyingCoupon = this.tutorCourseHomePage.totalCoursePrice();

			Assert.assertEquals(priceAfterApplyingCoupon, priceBeforeApplyingCoupon - couponPrice);

		} catch (Exception e) {
			Assert.fail("Exception occured while testing Course Price After Applying Coupon: " + e.getMessage());
			logger.error("Error occured while testing Course Price After Applying Coupon", e);
		}

		logger.info("Ending of testCoursePriceAfterApplyingCoupon method");
	}

	@Test(priority = 13, description = "Verify Remove coupon")
	@Description("Test Description: Verify Remove coupon")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verify Remove coupon")
	public void testRemoveAppliedCoupons() {
		logger.info("Starting of testRemoveAppliedCoupons method");

		try {
			this.tutorCourseHomePage.clickOnRemoveButton();
			
			Assert.assertTrue(this.tutorCourseHomePage.isDisplayedAppliedCoupon());

		} catch (Exception e) {
			Assert.fail("Exception occured while testing Course Remove coupon: " + e.getMessage());
			logger.error("Error occured while testing Remove coupon", e);
		}

		logger.info("Ending of testRemoveAppliedCoupons method");
	}

	@Test(priority = 14, description = "Verify Contact Us")
	@Description("Test Description: Verify Contact Us")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verify Contact Us")
	public void testContactUs() {
		logger.info("Starting of testContactUs method");

		try {
			this.tutorCourseHomePage.clickOnContactUsButton();
			this.tutorCourseHomePage.setName(testDataProp.getProperty(NAME_IN_CONTACTUS));
			this.tutorCourseHomePage.setMobileNumber(testDataProp.getProperty(MOBILE_NUMBER_IN_CONTACTUS));
			this.tutorCourseHomePage.setMessage(testDataProp.getProperty(MESSAGE_IN_CONTACTUS));
			this.tutorCourseHomePage.clickOnSubmitButton();

			Assert.assertEquals(this.tutorCourseHomePage.getQuerySubmittedMessage(),
					expectedAssertionsProp.getProperty(QUERY_SUBMITTED_SUCCESSFULLY_MESSAGE));

		} catch (Exception e) {
			Assert.fail("Exception occured while testing Contact Us: " + e.getMessage());
			logger.error("Error occured while testing Contact Us", e);
		}

		logger.info("Ending of testContactUs method");
	}

	@Test(priority = 15, description = "Verify Terms and Condition of the website")
	@Description("Test Description:Verify Terms and Condition of the website")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verify Terms And Conditions")
	public void testTermsAndConditions() {
		logger.info("Starting of testTermsAndConditions method");

		try {
			this.tutorCourseHomePage.clickOnTermsConditionLabel();

			Assert.assertEquals(this.tutorCourseHomePage.getTermsAndConditions(),
					expectedAssertionsProp.getProperty(NEW_TUTOR_TERMS_CONDITIONS));

			newTutordriver.close();

		} catch (Exception e) {
			Assert.fail("Exception occured while testing Terms and Condition of the website: " + e.getMessage());
			logger.error("Error occured while testing Terms and Condition of the website", e);
		}

		logger.info("Ending of testTermsAndConditions method");
	}

	@Test(priority = 16, description = "Verify Get Course")
	@Description("Test Description: Verify Get Course")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verify Get Course")
	public void testGetCourse() {
		logger.info("Starting of testGetCourse method");

		try {
			this.tutorCourseHomePage.clickOnGetThisCourseButton();

			Assert.assertEquals(this.tutorCourseHomePage.getFillDetailsHeader(),
					expectedAssertionsProp.getProperty(NEW_TUTOR_FILL_DETAILS_HEADER));

			this.tutorCourseHomePage.setAddressName(testDataProp.getProperty(SET_NAME_IN_ADDRESS));
			this.tutorCourseHomePage.setMobileNumber(testDataProp.getProperty(MOBILE_NUMBER_IN_CONTACTUS));
			this.tutorCourseHomePage.setEmail(testDataProp.getProperty(SET_EMAIL_IN_ADDRESS));
			this.tutorCourseHomePage.clickOnStateDropDown();
			this.tutorCourseHomePage.clickOnSelectStateDropDown(testDataProp.getProperty(SET_STATE_NAME_IN_ADDRESS));
			this.tutorCourseHomePage.clickOnBuyNowButton();
			this.buyCoursePage.closeBuyNowPage();
			this.buyCoursePage.closePaymentFailedDialogBox();

		} catch (Exception e) {
			Assert.fail("Exception occured while testing Get Course: " + e.getMessage());
			logger.error("Error occured while testing Get Course", e);
		}

		logger.info("Ending of testGetCourse method");
	}

	@Test(priority = 17, description = "Verify Course Content")
	@Description("Test Description:Verify Course Content")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verify Course Content")
	public void testCourseContent() {
		logger.info("Starting of testCourseContent method");

		try {
			this.tutorCourseHomePage.clickOnContentButton();
			
			Assert.assertTrue(this.tutorCourseHomePage.isSelectedcontent());
			
		} catch (Exception e) {
			Assert.fail("Exception occured while testing Course Content: " + e.getMessage());
			logger.error("Error occured while testing Course Content", e);
		}

		logger.info("Ending of testCourseContent method");
	}

	@Test(priority = 18, description = "Verify Cancelling Locked content")
	@Description("Test Description:Verify Cancelling Locked content")
	@Severity(SeverityLevel.CRITICAL)
	@Story("Verify Cancelling Locked content")
	public void testCancellingLockedContent() {
		logger.info("Starting of testCancellingLockedContent method");

		try {
			this.tutorCourseHomePage.clickOnContentButton();
			this.tutorCourseHomePage.clickOnContentLockedButton();

			Assert.assertEquals(this.tutorCourseHomePage.getBuyLocklabel(),
					expectedAssertionsProp.getProperty(NEW_TUTOR_BUY_LOCK_LABEL));

			Assert.assertEquals(this.tutorCourseHomePage.getBuyAccessLockedContentlabel(),
					expectedAssertionsProp.getProperty(NEW_TUTOR_LOCKED_CONTENT_ACCESS_LABEL));

			this.tutorCourseHomePage.clickOnCloseLockedContentButton();

			Assert.assertTrue(this.tutorCourseHomePage.isSelectedcontent());

		} catch (Exception e) {
			Assert.fail("Exception occured while testing Cancelling Locked content: " + e.getMessage());
			logger.error("Error occured while testing Cancelling Locked content", e);
		}

		logger.info("Ending of testCancellingLockedContent method");
	}

	@Test(priority = 19, description = "Verify Purchase Locked content")
	@Description("Test Description:Verify Purchase Locked content")
	@Severity(SeverityLevel.CRITICAL)
	@Story("Verify Purchase Locked content")
	public void testPurchaseLockedContent() {
		logger.info("Starting of testPurchaseLockedContent method");

		try {
			this.tutorCourseHomePage.clickOnContentButton();
			this.tutorCourseHomePage.clickOnContentLockedButton();

			Assert.assertEquals(this.tutorCourseHomePage.getBuyLocklabel(),
					expectedAssertionsProp.getProperty(NEW_TUTOR_BUY_LOCK_LABEL));

			Assert.assertEquals(this.tutorCourseHomePage.getBuyAccessLockedContentlabel(),
					expectedAssertionsProp.getProperty(NEW_TUTOR_LOCKED_CONTENT_ACCESS_LABEL));

			this.tutorCourseHomePage.clickOnLockedContentBuyNowButton();
			this.tutorCourseHomePage.setAddressName(testDataProp.getProperty(SET_NAME_IN_ADDRESS));
			this.tutorCourseHomePage.setMobileNumber(testDataProp.getProperty(MOBILE_NUMBER_IN_CONTACTUS));
			this.tutorCourseHomePage.setEmail(testDataProp.getProperty(SET_EMAIL_IN_ADDRESS));
			this.tutorCourseHomePage.clickOnStateDropDown();
			this.tutorCourseHomePage.clickOnSelectStateDropDown(testDataProp.getProperty(SET_STATE_NAME_IN_ADDRESS));
			this.tutorCourseHomePage.clickOnBuyNowButton();
			this.buyCoursePage.closeBuyNowPage();
			this.buyCoursePage.closePaymentFailedDialogBox();

		} catch (Exception e) {
			Assert.fail("Exception occured while testing  Purchase Locked content: " + e.getMessage());
			logger.error("Error occured while testing Purchase Locked content", e);
		}

		logger.info("Ending of testPurchaseLockedContent method");
	}

	@Test(priority = 20, description = "Verify All Category Courses")
	@Description("Test Description:Verify All Category Courses")
	@Severity(SeverityLevel.CRITICAL)
	@Story("Verify All Category Courses")
	public void testAllCategoryCourses() {
		logger.info("Starting of testAllCategoryCourses method");

		try {
			this.tutorCourseHomePage.clickOnLearningLightIcon();
			
			Assert.assertTrue(this.tutorCourseHomePage.getPopularCourses());

			this.tutorCourseHomePage.clickOnBackButton();

			Assert.assertTrue(this.tutorCourseHomePage.getRecentCourses());

			this.tutorCourseHomePage.clickOnBackButton();

			Assert.assertTrue(this.tutorCourseHomePage.getFeaturedCourses());

			this.tutorCourseHomePage.clickOnBackButton();

			Assert.assertTrue(this.tutorCourseHomePage.getAllCourses());

			this.tutorCourseHomePage.clickOnBackButton();
		} catch (Exception e) {
			Assert.fail("Exception occured while testing All Category Courses: " + e.getMessage());
			logger.error("Error occured while testing All Category Courses", e);
		}

		logger.info("Ending of testAllCategoryCourses method");
	}

	//@Test(priority = 21, description = "Verify All Category Courses")
	@Description("Test Description:Verify All Category Courses")
	@Severity(SeverityLevel.CRITICAL)
	@Story("Verify All Category Courses")
	public void testSelectCategoryFromViewAll() {
		logger.info("Starting of testAllCategoryCourses method");

		try {
			this.tutorCourseHomePage.clickOnViewAllCategoriesButton();
			this.tutorCourseHomePage.clickOnSubCategoryOption();
			this.tutorCourseHomePage.clickOnSaveAndContinueButton();

			Assert.assertTrue(this.tutorCourseHomePage.isSelectedCategoryOption());

			this.tutorCourseHomePage.clickOnViewAllCategoriesButton();
			this.tutorCourseHomePage.clickOnSubCategoryOption();
			this.tutorCourseHomePage.clickOnSaveAndContinueButton();

			Assert.assertTrue(this.tutorCourseHomePage.isNotSelectedCategoryOption());

		} catch (Exception e) {
			Assert.fail("Exception occured while testing All Category Courses: " + e.getMessage());
			logger.error("Error occured while testing All Category Courses", e);
		}

		logger.info("Ending of testAllCategoryCourses method");
	}

	//@Test(priority = 22, description = "Verify Entering Data In Search Field ")
	@Description("Test Description:Verify Entering Data In Search Field ")
	@Severity(SeverityLevel.CRITICAL)
	@Story("Verify Entering Data In Search Field ")
	public void testEnterDataInSearchField() {
		logger.info("Starting of testEnterDataInSearchField method");

		try {
			this.tutorCourseHomePage.clickOnPopularCoursesSeeAllButton();
			this.tutorCourseHomePage.searchCourse(testDataProp.getProperty(NEW_TUTOR_SEARCH_COURSE));

			Assert.assertEquals(this.tutorCourseHomePage.getSearchedData(),
					expectedAssertionsProp.getProperty(NEW_TUTOR_SEARCH_COURSE));

		} catch (Exception e) {
			Assert.fail("Exception occured while testing Entering Data In Search Field: " + e.getMessage());
			logger.error("Error occured while testing Entering Data In Search Field", e);
		}

		logger.info("Ending of testEnterDataInSearchField method");
	}

	@Test(priority = 23, description = "Verify Search With Valid Course Name", dataProvider = "searchvalidData")
	@Description("Test Description:Verify Search With Valid Course Name")
	@Severity(SeverityLevel.CRITICAL)
	@Story("Verify Search With Valid Course Name")
	public void testSearchWithValidCourseName(String searchCourse) {
		logger.info("Starting of testSearchWithValidCourseName method");

		try {
			this.tutorCourseHomePage.clickOnPopularCoursesSeeAllButton();
			this.tutorCourseHomePage.searchCourse(searchCourse);

			Assert.assertEquals(this.tutorCourseHomePage.getCourseNameLabel(),
					expectedAssertionsProp.getProperty(COURSE_NAME_lABEL));

		} catch (Exception e) {
			Assert.fail("Exception occured while testing Search Field: " + e.getMessage());
			logger.error("Error occured while testing Search Field", e);
		}

		logger.info("Ending of testSearchWithValidCourseName method");
	}
	
	@DataProvider(name = "searchvalidData")
	public Object[][] dataSet() {

		return new Object[][] { { testDataProp.getProperty(NEW_TUTOR_SEARCH_COURSE) },
				{ testDataProp.getProperty(NEW_TUTOR_SEARCH_VALID_COURSE) }, { testDataProp.getProperty(NEW_TUTOR_SEARCH_VALID_COURSES) },

		};
	}



	@Test(priority = 1, description = "Verify Search Course with invalid course name", dataProvider = "searchInvalidData")
	@Description("Test Description:Verify Search Course with invalid course name")
	@Severity(SeverityLevel.CRITICAL)
	@Story("Verify Search Course with invalid course name")
	public void testSearchCourseWithInvalidCourseName(String searchCourse) {
		logger.info("Starting of testSearchCourseWithInvalidCourseName method");

		try {
			this.tutorCourseHomePage
					.searchCourse(searchCourse);

			Assert.assertEquals(this.tutorCourseHomePage.getNoContentMessage(),
					expectedAssertionsProp.getProperty(NEW_TUTOR_NO_CONTENT_MESSAGE));

			Assert.assertEquals(this.tutorCourseHomePage.getNoResultsMessage(),
					expectedAssertionsProp.getProperty(NEW_TUTOR_NO_RESULTS_MESSAGE));

		} catch (Exception e) {
			Assert.fail("Exception occured while testing Search Course with invalid course name: " + e.getMessage());
			logger.error("Error occured while testing Search Course with invalid course name", e);
		}

		logger.info("Ending of testSearchCourseWithInvalidCourseName method");
	}
	
	@DataProvider(name = "searchInvalidData")
	public Object[][] invalidDataSet() {

		return new Object[][] { { testDataProp.getProperty(SEARCH_SPECIAL_CHARACTERS) },
				{ testDataProp.getProperty(SEARCH_MAX_CHARACTERS) }, { testDataProp.getProperty(SEARCH_INVALID_DATA) },

		};
	}
	
	@Test(priority = 25, description = "Verify Search Field Is Available")
	@Description("Test Description:Verify Search Field Is Available")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verify Search Field Is Available")
	public void testSearchFieldIsAvailable() {
		logger.info("Starting of testSearchFieldIsAvailable method");

		try {
			this.tutorCourseHomePage.clickOnPopularCoursesSeeAllButton();

			Assert.assertTrue(this.tutorCourseHomePage.getSearchField());

			this.tutorCourseHomePage.clickOnBackButton();
			this.tutorCourseHomePage.clickOnRecentCoursesSeeAllButton();

			Assert.assertTrue(this.tutorCourseHomePage.getSearchField());

			this.tutorCourseHomePage.clickOnBackButton();
			this.tutorCourseHomePage.clickOnFeaturedCoursesSeeAllButton();

			Assert.assertTrue(this.tutorCourseHomePage.getSearchField());

			this.tutorCourseHomePage.clickOnBackButton();
			this.tutorCourseHomePage.clickOnAllCoursesSeeAllButton();

			Assert.assertTrue(this.tutorCourseHomePage.getSearchField());

			this.tutorCourseHomePage.clickOnBackButton();
			this.tutorCourseHomePage.clickOnLiveCourseButton();

			Assert.assertTrue(this.tutorCourseHomePage.getSearchField());

			this.tutorCourseHomePage.clickOnBackButton();
			this.tutorCourseHomePage.clickOnNotesAndBooksButton();

			Assert.assertTrue(this.tutorCourseHomePage.getSearchField());

			this.tutorCourseHomePage.clickOnBackButton();
			this.tutorCourseHomePage.clickOnTestSeriesButton();

			Assert.assertTrue(this.tutorCourseHomePage.getSearchField());

			this.tutorCourseHomePage.clickOnBackButton();
			this.tutorCourseHomePage.clickOnRecordedCourseButton();

			Assert.assertTrue(this.tutorCourseHomePage.getSearchField());

			this.tutorCourseHomePage.clickOnBackButton();

		} catch (Exception e) {
			Assert.fail("Exception occured while testing Search Field Is Available: " + e.getMessage());
			logger.error("Error occured while testing Search Field Is Available", e);
		}

		logger.info("Ending of testSearchFieldIsAvailable method");
	}

	@Test(priority = 26, description = "Verify Free Content in course")
	@Description("Test Description:Verify Free Content in course")
	@Severity(SeverityLevel.CRITICAL)
	@Story("Verify Free Content in course")
	public void testFreeContentInCourse() {
		logger.info("Starting of testFreeContent method");

		try {
			this.tutorCourseHomePage.clickOnPopularCoursesSeeAllButton();
			this.tutorCourseHomePage.searchCourse(testDataProp.getProperty(NEW_TUTOR_FREE_CONTENT_COURSE));
			this.tutorCourseHomePage.clickOnGetCourse();
			this.tutorCourseHomePage.clickOnPlayVideoIcon();

			Assert.assertTrue(this.tutorCourseHomePage.getVideoPopup());

			this.tutorCourseHomePage.clickOnCloseVideoButton();

			Assert.assertFalse(this.tutorCourseHomePage.getVideoPopup());

			Assert.assertEquals(this.tutorCourseHomePage.getCourseName(),
					expectedAssertionsProp.getProperty(NEW_TUTOR_FREE_CONTENT_COURSE));

		} catch (Exception e) {
			Assert.fail("Exception occured while testing Free Content in course: " + e.getMessage());
			logger.error("Error occured while testing Free Content in course", e);
		}

		logger.info("Ending of testFreeContent method");
	}

	@Test(priority = 27, description = "Verify Count Of Sub-Categories")
	@Description("Test Description:Verify Count Of Sub-Categories")
	@Severity(SeverityLevel.CRITICAL)
	@Story("Verify Count Of Sub-Categories")
	public void testCountOfSubCategories() {
		logger.info("Starting of testCountOfSubCategories method");

		try {
			Integer count = this.tutorCourseHomePage.getCountText();
			Integer lstCount = this.tutorCourseHomePage.getListSubCategoriesCount();

			Assert.assertEquals(count, lstCount);

		} catch (Exception e) {
			Assert.fail("Exception occured while testing Count Of Sub-Categories: " + e.getMessage());
			logger.error("Error occured while testing Count Of Sub-Categories", e);
		}

		logger.info("Ending of testCountOfSubCategories method");
	}

	@Test(priority = 28, description = "Verify Select Categories")
	@Description("Test Description:Verify Select Categories")
	@Severity(SeverityLevel.CRITICAL)
	@Story("Verify Select Categories")
	public void testSelectCategories() {
		logger.info("Starting of testSelectCategories method");

		try {

			this.tutorCourseHomePage.clickOnCategorysOption();

			Assert.assertTrue(this.tutorCourseHomePage.isSelectedIITTab());

			Assert.assertTrue(this.tutorCourseHomePage.getSizeOfCourses());

		} catch (Exception e) {
			Assert.fail("Exception occured while testing Select Categories: " + e.getMessage());
			logger.error("Error occured while testing Select Categories", e);
		}

		logger.info("Ending of testSelectCategories method");
	}

	@Test(priority = 29, description = "Verify Select Categories")//change
	@Description("Test Description:Verify Select Categories")
	@Severity(SeverityLevel.CRITICAL)
	@Story("Verify Select Categories")
	public void testHomePageIcons() {
		logger.info("Starting of testSelectCategories method");

		try {
			this.tutorCourseHomePage.clickOnGooglePlayButton();
			this.tutorCourseHomePage.switchToNewWindow();

			Assert.assertEquals(this.tutorCourseHomePage.getGooglePlayLabel(),
					expectedAssertionsProp.getProperty(NEW_TUTOR_GOOGLE_PLAY_LABEL));

			Assert.assertEquals(this.tutorCourseHomePage.getLearningLightApplabel(),
					expectedAssertionsProp.getProperty(NEW_TUTOR_LEARNING_LIGHT_APP_LABEL));

			this.tutorCourseHomePage.switchToNewwindow();//window name

			this.tutorCourseHomePage.clickOnAppStoreButton();
			this.tutorCourseHomePage.switchToNewwindow();

			Assert.assertEquals(this.tutorCourseHomePage.getAppStorelabel(),
					expectedAssertionsProp.getProperty(NEW_TUTOR_APP_STORE_LABEL));

			Assert.assertEquals(this.tutorCourseHomePage.getAvailableForIphoneAndIpadLabel(),
					expectedAssertionsProp.getProperty(NEW_TUTOR_AVAILABLE_FOR_IPHONE_AND_IPAD_LABEL));

			this.tutorCourseHomePage.switchToNewwindow();

		} catch (Exception e) {
			Assert.fail("Exception occured while testing Select Categories: " + e.getMessage());
			logger.error("Error occured while testing Select Categories", e);
		}

		logger.info("Ending of testSelectCategories method");
	}

	@Test(priority = 30, description = "Verify Select Categories")
	@Description("Test Description:Verify Select Categories")
	@Severity(SeverityLevel.CRITICAL)
	@Story("Verify Select Categories")
	public void testCouponsCount() {
		logger.info("Starting of testSelectCategories method");

		try {
			int couponsAvailableCount = this.tutorCourseHomePage.getCouponAvailableCount();

			this.tutorCourseHomePage.clickOnApplyHereButton();

			int couponCount = this.tutorCourseHomePage.getCouponCount();

			Assert.assertEquals(couponsAvailableCount, couponCount);

			this.tutorCourseHomePage.clickOnApplyCouponCloseIcon();
		} catch (Exception e) {
			Assert.fail("Exception occured while testing Select Categories: " + e.getMessage());
			logger.error("Error occured while testing Select Categories", e);
		}

		logger.info("Ending of testSelectCategories method");
	}

	@AfterClass
	public void quitDriver() {
		logger.info("Starting of quitDriver method");

		try {
			if (driver != null) {
				Thread.sleep(5000);
				this.loginPage.clickOnLogOut();
				this.quitDriver(this.driver, WEB_DRIVER.CREATE_COURSE_TEST);
				logger.info("Driver quit successfully");
			}
			if (this.driver != null) {
				Thread.sleep(5000);
				this.loginPage.clickOnLogOut();
				this.quitDriver(this.driver, WEB_DRIVER.CREATE_NEWCOURSE_TEST);
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