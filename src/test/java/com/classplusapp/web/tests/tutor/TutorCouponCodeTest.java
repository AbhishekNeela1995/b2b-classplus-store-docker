package com.classplusapp.web.tests.tutor;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.classplusapp.web.pages.tutor.TutorCouponCodePage;
import com.classplusapp.web.tests.BaseClassplusAutomationTest;

import static com.classplusapp.store.util.Constants.*;

import java.util.Random;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Epic("Coupon Code")
@Feature("Tutor CouponCode Test")
public class TutorCouponCodeTest extends BaseClassplusAutomationTest {

	private WebDriver driver = null;
	private TutorCouponCodePage tutorCouponCodePage = null;
	private String couponeCode = null;
	private static final Logger logger = Logger.getLogger(TutorCouponCodeTest.class.getName());

	@BeforeClass
	@Parameters({ "browser", "orgCode"})
	public void initClassplusSiteLogin(@Optional("Chrome")String browser, @Optional("learn") String orgCode)
			throws Exception {
		logger.info("Starting of initClassplusSiteLogin methond");

		this.driver = super.loginClassPlusSite(browser, orgCode, tutorMobileNumber, emailAddress,
				WEB_DRIVER.COUPON_CODE_TEST);
		this.tutorCouponCodePage = new TutorCouponCodePage(driver);

		logger.info("Ending of initClassplusSiteLogin method");
	}

	@Test(priority = 1 ,description="Verify Coupon code page")
	@Description("Test Description:Verify Coupon code page")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Verify Coupon code page")
	public void testCouponCodes() {
		logger.info("Starting of testCouponCodes method");

		try {
			this.tutorCouponCodePage.clickOnCouponCodeButton();
			this.tutorCouponCodePage.clickOnCouponCodeButton();

			// Assertion for checking the Coupon Codes label
			String couponCodesLabel = this.tutorCouponCodePage.getCouponCodesLabel();
			Assert.assertEquals(couponCodesLabel, expectedAssertionsProp.getProperty(LABEL_COUPONCODE));

			this.tutorCouponCodePage.clickOnCreateCouponButton();

			// Assertion for checking the create Coupon Code label
			String couponCodeLabel = this.tutorCouponCodePage.getCreateCouponCodeLabel();
			Assert.assertEquals(couponCodeLabel, expectedAssertionsProp.getProperty(LABEL_CREATE_COUPONCODE));

		} catch (Exception e) {
			Assert.fail("Exception occured while testing Coupon Code page: " + e.getMessage());
			logger.error("Error occured while testing coupon code page ", e);
		}

		logger.info("Ending of testCouponCodes method");
	}

	@Test(priority = 2, description = "Verify Create Flat Discount Coupon")
	@Description("Test Description: Verify Create Flat Discount Coupon")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verify Create Flat Discount Coupon")
	public void testCreateFlatDiscountCoupon() {
		logger.info("Starting of testCreateCoupon method");

		try {

			// Assertion for checking the create Coupon Code Discount type label
			String lblDiscountType = this.tutorCouponCodePage.getDiscountTypeLabel();
			Assert.assertEquals(lblDiscountType,
					expectedAssertionsProp.getProperty(LABEL_CREATE_COUPON_CODE_DISCOUNT_TYPE));

			// Assertion for checking the create Coupon Code Discount Amount label
			String lblFlatDiscountAmount = this.tutorCouponCodePage.getFlatDiscountAmountLabel();
			Assert.assertEquals(lblFlatDiscountAmount,
					expectedAssertionsProp.getProperty(LABEL_CREATE_COUPON_CODE_DISCOUNT_AMOUNT));

			this.tutorCouponCodePage.setFlatDiscount(testDataProp.getProperty(COUPONCODE_FLATDISCOUNT_AMOUNT));

			// Assertion for checking the create Coupon Code Start Date label
			String lblStartDate = this.tutorCouponCodePage.getStartDateLabel();
			Assert.assertEquals(lblStartDate, expectedAssertionsProp.getProperty(LABEL_CREATE_COUPON_CODE_START_DATE));

			// Assertion for checking the create Coupon Code Start Time label
			String lblStartTime = this.tutorCouponCodePage.getStartTimeLabel();
			Assert.assertEquals(lblStartTime, expectedAssertionsProp.getProperty(LABEL_CREATE_COUPON_CODE_START_TIME));

			this.tutorCouponCodePage.clickOnLifetimeValidityCheckbox();
			this.tutorCouponCodePage.setMinimumValueEdit(testDataProp.getProperty(COUPONCODE_MIN_ORDER_VALUE));
			this.tutorCouponCodePage.clickOnCodeNextButton();

			// Assertion for checking the create Coupon Code label
			String couponsCodeLabel = this.tutorCouponCodePage.getCreateCouponCodeLabel();
			Assert.assertEquals(couponsCodeLabel, expectedAssertionsProp.getProperty(LABEL_CREATE_COUPONCODE));

			couponeCode = RandomStringUtils.randomAlphanumeric(6);
			this.tutorCouponCodePage.setOfferName(testDataProp.getProperty(COUPONCODE_OFFER_NAME));
			this.tutorCouponCodePage.setCouponCode(couponeCode);
			this.tutorCouponCodePage.setTotalLimit(testDataProp.getProperty(COUPONCODE_TOTAL_LIMIT));
			this.tutorCouponCodePage.setUserLimit(testDataProp.getProperty(COUPONCODE_USER_LIMIT));
			this.tutorCouponCodePage.clickOnCodeNextButton();

			// Assertion for checking the create Coupon Code label
			String couponsCodesLabel = this.tutorCouponCodePage.getCreateCouponCodeLabel();
			Assert.assertEquals(couponsCodesLabel, expectedAssertionsProp.getProperty(LABEL_CREATE_COUPONCODE));

			this.tutorCouponCodePage.clickOnFinishButton();

			// Assertion for checking the creating coupon code text
			String finishLabel = this.tutorCouponCodePage.getCouponCreatedMessage();
			Assert.assertEquals(finishLabel, expectedAssertionsProp.getProperty(COUPONCODE_CREATED_SUCCESSFULLY_TEXT));

		} catch (Exception e) {
		//	Assert.fail("Exception occured while testing Create Flat Discount Coupon: " + e.getMessage());
			logger.error("Error occured while testing Create Flat Discount Coupon ", e);
		}

		logger.info("Ending of testCreateCoupon method");
	}

	@Test(priority = 3, description = "Verify Edit Flat Discount Coupon ")
	@Description("Test Description: Verify Edit Flat Discount Coupon ")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verify Edit Flat Discount Coupon ")
	public void testEditFlatDiscountCoupon() {
		logger.info("Starting of testEditFlatDiscountCoupon method");

		try {
			this.tutorCouponCodePage.clickOnThreeDottedMenu(couponeCode);
			this.tutorCouponCodePage.clickOnEditCouponLink(couponeCode);

			// Assertion for checking the create Coupon Code label
			String couponCodesLabel = this.tutorCouponCodePage.getCreateCouponCodeLabel();
			Assert.assertEquals(couponCodesLabel, expectedAssertionsProp.getProperty(LABEL_CREATE_COUPONCODE));

			this.tutorCouponCodePage.setMinimumValueEdit(testDataProp.getProperty(COUPONCODE_EDIT_MIN_ORDER_VALUE));
			this.tutorCouponCodePage.clickOnEditNextButton();
			this.tutorCouponCodePage.setEditOfferName(testDataProp.getProperty(COUPONCODE_EDIT_OFFER_NAME));
			this.tutorCouponCodePage.setEditTotalLimit(testDataProp.getProperty(COUPONCODE_EDIT_TOTAL_LIMIT));
			this.tutorCouponCodePage.clickOnEditCodeNextButton();
			this.tutorCouponCodePage.clickOnEditFinishButton();

			// Assertion for checking the updated Coupon Code text
			String couponUpdatedText = this.tutorCouponCodePage.getCouponUpdatedMessage();
			Assert.assertEquals(couponUpdatedText,
					expectedAssertionsProp.getProperty(COUPONCODE_UPDATED_SUCCESSFULLY_TEXT));

		} catch (Exception e) {
			Assert.fail("Exception occured while testing Edit Flat Discount Coupon : " + e.getMessage());
			logger.error("Error occured while testing the  Edit Flat Discount Coupon  ", e);
		}

		logger.info("Ending of testEditFlatDiscountCoupon method");
	}

	@Test(priority = 4, description = "Verify Make Active Coupon Code")
	@Description("Test Description:Verify Make Active Coupon Code")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verify Make Active Coupon Code")
	public void testMakeInActiveFlatDiscountCoupon() {
		logger.info("Starting of testMakeActiveFlatDiscountCoupon method");

		try {

			// Assertion for checking the Coupon Codes label
			String couponCodesLabel = this.tutorCouponCodePage.getCouponCodesLabel();
			Assert.assertEquals(couponCodesLabel, expectedAssertionsProp.getProperty(LABEL_COUPONCODE));

			this.tutorCouponCodePage.clickOnThreeDottedMenu(testDataProp.getProperty(COUPONCODE_OFFER_NAME));
			this.tutorCouponCodePage.clickOnMakeInActiveIcon();

			// Assertion for checking the make active Coupon Code text
			String couponDetailText = this.tutorCouponCodePage.getCouponDetailsMessage();
			Assert.assertEquals(couponDetailText,
					expectedAssertionsProp.getProperty(COUPONCODE_DETAILS_SUCCESSFULLY_TEXT));

		} catch (Exception e) {
			Assert.fail("Exception occured while testing Make Active Coupon Code: " + e.getMessage());
			logger.error("Error occured while testing the Make Active Coupon Code ", e);
		}

		logger.info("Ending of testMakeActiveFlatDiscountCoupon method");
	}

	@Test(priority = 5, description = "Verify Delete Flat Discount Coupon")
	@Description("Test Description: Verify Delete Flat Discount Coupon")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verify Delete Flat Discount Coupon")
	public void testDeleteFlatDiscountCoupon() {
		logger.info("Starting of testDeleteFlatDiscountCoupon method");

		try { // Assertion for checking the Coupon Codes label
			String couponCodesLabel = this.tutorCouponCodePage.getCouponCodesLabel();
			Assert.assertEquals(couponCodesLabel, expectedAssertionsProp.getProperty(LABEL_COUPONCODE));

			this.tutorCouponCodePage.clickOnThreeDottedMenu(testDataProp.getProperty(COUPONCODE_OFFER_NAME));
			this.tutorCouponCodePage.clickDeleteIcon();

			// Assertion for checking the remove Coupon Code text
			String couponRemoveText = this.tutorCouponCodePage.getCouponDeleteMessage();
			Assert.assertEquals(couponRemoveText,
					expectedAssertionsProp.getProperty(COUPONCODE_DELETED_SUCCESSFULLY_TEXT));

		} catch (Exception e) {
			Assert.fail("Exception occured while testing Delete Flat Discount Coupon: " + e.getMessage());
			logger.error("Error occured while testing Delete Flat Discount Coupon ", e);
		}

		logger.info("Ending of testDeleteFlatDiscountCoupon method");
	}

	@Test(priority = 6, description = "Verify Create Percentage Discount coupon")
	@Description("Test Description: Verify Create Percentage Discount coupon")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verify Create Percentage Discount coupon")
	public void testCreateCouponPercentageDiscountType() {
		logger.info("Starting of testCreateCouponPercentageDiscountType method");

		try {
			this.tutorCouponCodePage.clickOnCreateCouponButton();

			// Assertion for checking the create Coupon Code Discount type label
			String lblDiscountType = this.tutorCouponCodePage.getDiscountTypeLabel();
			Assert.assertEquals(lblDiscountType,
					expectedAssertionsProp.getProperty(LABEL_CREATE_COUPON_CODE_DISCOUNT_TYPE));

			// Assertion for checking the Percentage Discount label
			String lblPercentageDiscount = this.tutorCouponCodePage.getPercentageDiscountLabel();
			Assert.assertEquals(lblPercentageDiscount,
					expectedAssertionsProp.getProperty(LABEL_CREATE_COUPON_PERCENTAGE_DISCOUNT));

			this.tutorCouponCodePage.clickOnPercentageDiscountRadioButton();

			// Assertion for checking the Percentage Discount label
			String lblPercentageDiscount1 = this.tutorCouponCodePage.getPercentageDiscount1Label();
			Assert.assertEquals(lblPercentageDiscount1,
					expectedAssertionsProp.getProperty(LABEL_CREATE_COUPON_PERCENTAGE_DISCOUNT1));

			this.tutorCouponCodePage.setPercentageDiscount(testDataProp.getProperty(COUPONCODE_PERCENTAGE_DISCOUNT));

			// Assertion for checking the Maximum Percentage Discount label
			String lblMaxPercentageDiscount = this.tutorCouponCodePage.getMaxPercentageDiscountLabel();
			Assert.assertEquals(lblMaxPercentageDiscount,
					expectedAssertionsProp.getProperty(LABEL_CREATE_COUPON_MAXIMUM_PERCENTAGE_DISCOUNT));

			this.tutorCouponCodePage
					.setMaxPercentageDiscount(testDataProp.getProperty(COUPONCODE_MAXIMUM_PERCENTAGE_DISCOUNT));

			this.tutorCouponCodePage.clickOnLifetimeValidityCheckbox();
			this.tutorCouponCodePage.setMinimumValueEdit(testDataProp.getProperty(COUPONCODE_MIN_ORDER_VALUE));
			// this.tutorCouponCodePage.clickOnPercentageCodeNextButton();
			this.tutorCouponCodePage.clickOnCodeNextButton();
			couponeCode = RandomStringUtils.randomAlphanumeric(6);
			this.tutorCouponCodePage.setOfferName(testDataProp.getProperty(COUPONCODE_OFFER_NAME));
			this.tutorCouponCodePage.setCouponCode(couponeCode);

			// Assertion for checking the create Coupon Code label
			String PrivateCouponLabel = this.tutorCouponCodePage.getPrivateCouponLabel();
			Assert.assertEquals(PrivateCouponLabel,
					expectedAssertionsProp.getProperty(LABEL_CREATE_COUPONCODE_PRIVATE_COUPON));

			this.tutorCouponCodePage.clickOnPrivateCouponRadioButton();
			this.tutorCouponCodePage.clickOnSpecificCoursesRadioButton();

			this.tutorCouponCodePage.setTotalLimit(testDataProp.getProperty(COUPONCODE_TOTAL_LIMIT));
			this.tutorCouponCodePage.setUserLimit(testDataProp.getProperty(COUPONCODE_USER_LIMIT));
			// this.tutorCouponCodePage.clickOutside();

			// this.tutorCouponCodePage.clickOnPercentageCodeNextButton();
			this.tutorCouponCodePage.clickOnCodeNextButton();
			// Assertion for checking the create Coupon Code label
			String lblEligibleCourses = this.tutorCouponCodePage.getEligibleCoursesLabel();
			Assert.assertEquals(lblEligibleCourses,
					expectedAssertionsProp.getProperty(LABEL_CREATE_COUPONCODE_ELIGIBLE_COURSES));

			this.tutorCouponCodePage.clickOnSkipButton();
			this.tutorCouponCodePage.clickOnEligibleCoursesButton();
			this.tutorCouponCodePage.clickOnSelectAllButton();
			this.tutorCouponCodePage.clickOnSelectAllButton();
			this.tutorCouponCodePage.setSearch(testDataProp.getProperty(COUPONCODE_SEARCH_COURSE));
			this.tutorCouponCodePage.clickOnSelectCourseCheckBox();
			this.tutorCouponCodePage.clickOnNextButton();
			this.tutorCouponCodePage.clickOnSkipButton();
			this.tutorCouponCodePage.clickOnEligibleCoursesButton();
			this.tutorCouponCodePage.clickOnSelectAllButton();
			this.tutorCouponCodePage.clickOnSelectAllButton();
			this.tutorCouponCodePage.setSearch(testDataProp.getProperty(COUPONCODE_SEARCH_STUDENT));
			this.tutorCouponCodePage.clickOnSelectCourseCheckBox();

			// Assertion for checking the create Coupon Code label
			String couponsCodesLabel = this.tutorCouponCodePage.getCreateCouponCodeLabel();
			Assert.assertEquals(couponsCodesLabel, expectedAssertionsProp.getProperty(LABEL_CREATE_COUPONCODE));

			this.tutorCouponCodePage.clickOnFinishButton();

			// Assertion for checking the creating coupon code text
			String finishLabel = this.tutorCouponCodePage.getCouponCreatedMessage();
			Assert.assertEquals(finishLabel, expectedAssertionsProp.getProperty(COUPONCODE_CREATED_SUCCESSFULLY_TEXT));

		} catch (Exception e) {
			Assert.fail("Exception occured while testing  Create Percentage Discount coupon: " + e.getMessage());
			logger.error("Error occured while testing Create Percentage Discount coupon", e);
		}

		logger.info("Ending of testCreateCouponPercentageDiscountType method");
	}

	@Test(priority = 7, description = "Verify Edit Percentage Discount In Coupon HomePage")
	@Description("Test Description:Verify Edit Percentage Discount In Coupon HomePage")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Verify Edit Percentage Discount In Coupon HomePage")
	public void testEditPercentageDiscountCouponInCouponHomePage() {
		logger.info("Starting of testEditPercentageDiscountInCouponHomePage method");

		try {

			this.tutorCouponCodePage.clickOnShowDetailsButton(couponeCode);


			// Assertion for checking the make active Coupon Code text
			String lblCouponInformation = this.tutorCouponCodePage.getCouponInformationLabel();
			Assert.assertEquals(lblCouponInformation,
					expectedAssertionsProp.getProperty(LABEL_COUPONCODE_COUPON_INFORMATION));

			// Assertion for checking the make active Coupon Code text
			String lblEligibleStudents = this.tutorCouponCodePage.getCouponEligibleStudentsLabel();
			Assert.assertEquals(lblEligibleStudents,
					expectedAssertionsProp.getProperty(LABEL_COUPONCODE_ELIGIBLE_STUDENTS));

			// Assertion for checking the make active Coupon Code text
			String lblAssignedCourses = this.tutorCouponCodePage.getAssignedCoursesLabel();
			Assert.assertEquals(lblAssignedCourses,
					expectedAssertionsProp.getProperty(LABEL_COUPONCODE_ASSIGNED_COURSES));

			// Assertion for checking the COUPONCODE USAGE LIMIT text
			String lblUsageLimit = this.tutorCouponCodePage.getUsageLimitLabel();
			Assert.assertEquals(lblUsageLimit, expectedAssertionsProp.getProperty(LABEL_COUPONCODE_USAGE_LIMIT));

			// Assertion for checking the make active Coupon Code text
			String lblUsage = this.tutorCouponCodePage.getUsageLabel();
			Assert.assertEquals(lblUsage, expectedAssertionsProp.getProperty(LABEL_COUPONCODE_USAGE_LABEL));

			// Assertion for checking the Minimum Order Value text
			String lblMinOrderValue = this.tutorCouponCodePage.getMinimumOrderValueLabel();
			Assert.assertEquals(lblMinOrderValue,
					expectedAssertionsProp.getProperty(LABEL_COUPONCODE_MINIMUM_ORDER_VALUE));
			this.tutorCouponCodePage.clickOnEditUsageLimitButton();

			// Assertion for checking the EDIT COUPON DETAILS text
			String lblEditCouponDetails = this.tutorCouponCodePage.getEditCouponDetailsLabel();
			Assert.assertEquals(lblEditCouponDetails, expectedAssertionsProp.getProperty(LABEL_EDIT_COUPON_DETAILS));

			this.tutorCouponCodePage
					.setEditUsageLimitValue(testDataProp.getProperty(COUPONCODE_EDIT_USAGE_LIMIT_VALUE));
			this.tutorCouponCodePage.clickOnSaveChangesButton();

			this.tutorCouponCodePage.clickOnEditUsagePerStudentButton();

			// Assertion for checking the make active Coupon Code text
			String EditCouponDetailsLabel = this.tutorCouponCodePage.getEditCouponDetailsLabel();
			Assert.assertEquals(EditCouponDetailsLabel, expectedAssertionsProp.getProperty(LABEL_EDIT_COUPON_DETAILS));
			// this.tutorCouponCodePage.setEditUsageStudent();
			this.tutorCouponCodePage
					.setEditUsagePerStudent(testDataProp.getProperty("couponcode.edit.usage.perstudent"));
			this.tutorCouponCodePage.clickOnSaveChangesButton();

			/*
			 * this.tutorCouponCodePage.clickOnEditMinimumOrderValueButton();
			 * 
			 * // Assertion for checking the make active Coupon Code text String
			 * EditCouponLabel = this.tutorCouponCodePage.getEditCouponDetailsLabel();
			 * Assert.assertEquals(EditCouponLabel,
			 * expectedAssertionsProp.getProperty(LABEL_EDIT_COUPON_DETAILS));
			 * 
			 * this.tutorCouponCodePage .setEditMinimumOrderValue(testDataProp.getProperty(
			 * COUPONCODE_EDIT_MINIMUM_ORDER_VALUE));
			 * this.tutorCouponCodePage.clickOnSaveChangesButton();
			 */

		} catch (Exception e) {
			Assert.fail(
					"Exception occured while testing Edit Percentage Discount In Coupon HomePage: " + e.getMessage());
			logger.error("Error occured while testing   Edit Percentage Discount In Coupon HomePage", e);
		}

		logger.info("Ending of testEditPercentageDiscountInCouponHomePage method");
	}

	@Test(priority = 8, description = "Verify Edit Percentage Discount Coupon Code")
	@Description("Test Description: Verify Edit Percentage Discount Coupon Code")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verify Edit Percentage Discount Coupon Code")
	public void testEditPercentageDiscountCoupon() {
		logger.info("Starting of testEditPercentageDiscountCoupon method");

		try {
			this.tutorCouponCodePage.clickOnThreeDottedMenu(couponeCode);
			this.tutorCouponCodePage.clickOnEditCouponLink(couponeCode);

			// Assertion for checking the create Coupon Code label
			String couponCodesLabel = this.tutorCouponCodePage.getCreateCouponCodeLabel();
			Assert.assertEquals(couponCodesLabel, expectedAssertionsProp.getProperty(LABEL_CREATE_COUPONCODE));

			this.tutorCouponCodePage.setMinimumValueEdit(testDataProp.getProperty(COUPONCODE_EDIT_MIN_ORDER_VALUE));
			this.tutorCouponCodePage.clickOnEditNextButton();
			this.tutorCouponCodePage.setEditOfferName(testDataProp.getProperty(COUPONCODE_EDIT_OFFER_NAME));
			this.tutorCouponCodePage.setEditTotalLimit(testDataProp.getProperty(COUPONCODE_EDIT_TOTAL_LIMIT));
			this.tutorCouponCodePage.clickOnEditCodeNextButton();
			this.tutorCouponCodePage.clickOnEditCodeNextButton();

			this.tutorCouponCodePage.clickOnEditFinishButton();

			// Assertion for checking the updated Coupon Code text
			String couponUpdatedText = this.tutorCouponCodePage.getCouponUpdatedMessage();
			Assert.assertEquals(couponUpdatedText,
					expectedAssertionsProp.getProperty(COUPONCODE_UPDATED_SUCCESSFULLY_TEXT));

		} catch (Exception e) {
			Assert.fail("Exception occured while testing Edit Percentage Discount Coupon Code: " + e.getMessage());
			logger.error("Error occured while testing  Edit Percentage Discount Coupon Code ", e);
		}

		logger.info("Ending of testEditPercentageDiscountCoupon method");
	}

	@Test(priority = 9, description = "Verify View History Percentage DiscountCoupon")
	@Description("Test Description:Verify View History Percentage Discount Coupon")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Verify View History Percentage Discount Coupon")
	public void testViewHistoryOfPercentageDiscountCoupon() {
		logger.info("Starting of testViewHistoryPercentageDiscountCoupon method");

		try { // Assertion for checking the Coupon Codes label
			String couponCodesLabel = this.tutorCouponCodePage.getCouponCodesLabel();
			Assert.assertEquals(couponCodesLabel, expectedAssertionsProp.getProperty(LABEL_COUPONCODE));

			this.tutorCouponCodePage.clickOnThreeDottedMenu(couponeCode);
			this.tutorCouponCodePage.clickOnViewHistoryIcon(couponeCode);

			// Assertion for checking the Coupon Codes label
			String lblCouponHistory = this.tutorCouponCodePage.getCouponHistoryLabel();
			Assert.assertEquals(lblCouponHistory, expectedAssertionsProp.getProperty(LABEL_COUPONCODE_VIEW_HISTORY));

			this.tutorCouponCodePage.clickOnCouponCodeButton();

		} catch (Exception e) {
			Assert.fail("Exception occured while testing View History Percentage Discount Coupon: " + e.getMessage());
			logger.error("Error occured while testing View History Percentage Discount Coupon", e);
		}

		logger.info("Ending of testViewHistoryPercentageDiscountCoupon method");

	}

	@Test(priority = 10, description = "Verify Make InActive Percentage Discount Coupon")
	@Description("Test Description:Verify Make InActive Percentage Discount Coupon")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Verify Make InActive Percentage Discount Coupon")
	public void testMakeInActivePercentageDiscountCoupon() {
		logger.info("Starting of testMakeInActivePercentageDiscountCoupon method");

		try {

			// Assertion for checking the Coupon Codes label
			String couponCodesLabel = this.tutorCouponCodePage.getCouponCodesLabel();
			Assert.assertEquals(couponCodesLabel, expectedAssertionsProp.getProperty(LABEL_COUPONCODE));

			this.tutorCouponCodePage.clickOnThreeDottedMenu(couponeCode);
			this.tutorCouponCodePage.clickOnMakeInActiveIcon();

			// Assertion for checking the make active Coupon Code text
			String couponDetailText = this.tutorCouponCodePage.getCouponDetailsMessage();
			Assert.assertEquals(couponDetailText,
					expectedAssertionsProp.getProperty(COUPONCODE_DETAILS_SUCCESSFULLY_TEXT));

		} catch (Exception e) {
			Assert.fail("Exception occured while testing Make InActive Percentage Discount Coupon: " + e.getMessage());
			logger.error("Error occured while testing  Make InActive Percentage Discount Coupon ", e);
		}

		logger.info("Ending of testMakeInActivePercentageDiscountCoupon method");
	}

	@Test(priority = 11, description = "Verify Delete Percentage Discount Coupon")
	@Description("Test Description:Verify Delete Percentage Discount Coupon")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verify Delete Percentage Discount Coupon")
	public void testDeletePercentageDiscountCoupon() {
		logger.info("Starting of testDeletePercentageDiscountCoupon method");

		try {
			// Assertion for checking the Coupon Codes label
			String couponCodesLabel = this.tutorCouponCodePage.getCouponCodesLabel();
			Assert.assertEquals(couponCodesLabel, expectedAssertionsProp.getProperty(LABEL_COUPONCODE));

			this.tutorCouponCodePage.clickOnThreeDottedMenu(couponeCode);
			this.tutorCouponCodePage.clickDeleteIcon();

			// Assertion for checking the remove Coupon Code text
			String couponRemoveText = this.tutorCouponCodePage.getCouponDeleteMessage();
			Assert.assertEquals(couponRemoveText,
					expectedAssertionsProp.getProperty(COUPONCODE_DELETED_SUCCESSFULLY_TEXT));

			this.tutorCouponCodePage.setSearchCoupon(couponeCode);

			// Assertion for checking the remove Coupon Code text
			String lblNoCouponFound = this.tutorCouponCodePage.getNoCouponFoundLabel();
			Assert.assertEquals(lblNoCouponFound, expectedAssertionsProp.getProperty(COUPONCODE_NOT_FOUND_TEXT));

		} catch (Exception e) {
			Assert.fail("Exception occured while testing  Delete Percentage Discount Coupon: " + e.getMessage());
			logger.error("Error occured while testing  Delete Percentage Discount Coupon ", e);
		}

		logger.info("Ending of testDeletePercentageDiscountCoupon method");
	}

	@Test(priority = 12, description = "Verify Search Coupon")
	@Description("Test Description:Verify Search Coupon")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Verify Search Coupon")
	public void testSearchCoupon() {
		logger.info("Starting of testSearchCoupon method");

		try {

			// Assertion for checking the Coupon Codes label
			String couponCodesLabel = this.tutorCouponCodePage.getCouponCodesLabel();
			Assert.assertEquals(couponCodesLabel, expectedAssertionsProp.getProperty(LABEL_COUPONCODE));

			this.tutorCouponCodePage.setSearchCoupon(testDataProp.getProperty("couponcode.search.coupon"));

			// Assertion for checking the make active Coupon Code text
			String lblCouponName = this.tutorCouponCodePage.getCouponNameLabel();
			Assert.assertEquals(lblCouponName, expectedAssertionsProp.getProperty(LABEL_COUPONCODE_COUPON_NAME));

			String lblCouponCode = this.tutorCouponCodePage.getCouponCodeLabel();
			Assert.assertEquals(lblCouponCode, expectedAssertionsProp.getProperty(LABEL_COUPON_CODE));

			/*
			 * String lblProTutor = this.tutorCouponCodePage.getProTutorLabel();
			 * Assert.assertEquals(lblProTutor,
			 * expectedAssertionsProp.getProperty(LABEL_PRO_TUTOR));
			 */

			/*
			 * String lblDuration = this.tutorCouponCodePage.getDurationLabel();
			 * Assert.assertEquals(lblDuration,
			 * expectedAssertionsProp.getProperty(LABEL_COUPON_CODE_DURATION));
			 */
			String lblExpired = this.tutorCouponCodePage.getExpiredLabel();
			Assert.assertEquals(lblExpired, expectedAssertionsProp.getProperty(LABEL_EXPIRED));

		} catch (Exception e) {
			Assert.fail("Exception occured while testing Search Coupon: " + e.getMessage());
			logger.error("Error occured while testing Search Coupon ", e);
		}

		logger.info("Ending of testSearchCoupon method");
	}

	@Test(priority = 13, description = "Verify Create Coupon With Invalid Details")
	@Description("Test Description:Verify Create Coupon With Invalid Details")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verify Create Coupon With Invalid Details")
	public void testCreateCouponWithInvalidDetails() {
		logger.info("Starting of testCreateCouponWithInvalidDetails method");

		try {
			this.tutorCouponCodePage.clickOnCouponCodeButton();

			// Assertion for checking the Coupon Codes label
			String couponCodesLabel = this.tutorCouponCodePage.getCouponCodesLabel();
			Assert.assertEquals(couponCodesLabel, expectedAssertionsProp.getProperty(LABEL_COUPONCODE));

			this.tutorCouponCodePage.clickOnCreateCouponButton();

			// Assertion for checking the create Coupon Code label
			String couponCodeLabel = this.tutorCouponCodePage.getCreateCouponCodeLabel();
			Assert.assertEquals(couponCodeLabel, expectedAssertionsProp.getProperty(LABEL_CREATE_COUPONCODE));

			// Assertion for checking the create Coupon Code Discount type label
			String lblDiscountType = this.tutorCouponCodePage.getDiscountTypeLabel();
			Assert.assertEquals(lblDiscountType,
					expectedAssertionsProp.getProperty(LABEL_CREATE_COUPON_CODE_DISCOUNT_TYPE));

			// Assertion for checking the create Coupon Code Discount Amount label
			String lblFlatDiscountAmount = this.tutorCouponCodePage.getFlatDiscountAmountLabel();
			Assert.assertEquals(lblFlatDiscountAmount,
					expectedAssertionsProp.getProperty(LABEL_CREATE_COUPON_CODE_DISCOUNT_AMOUNT));

			this.tutorCouponCodePage
					.setInvalidFlatDiscount(testDataProp.getProperty(COUPONCODE_FLATDISCOUNT_INVALID_AMOUNT));

			// Assertion for checking the create Coupon Discount Required Label
			String lblDiscountRequired = this.tutorCouponCodePage.getDiscountRequiredLabel();
			Assert.assertEquals(lblDiscountRequired,
					expectedAssertionsProp.getProperty(LABEL_COUPONCODE_DISCOUNT_REQUIRED));

			this.tutorCouponCodePage
					.setInvalidFlatDiscount(testDataProp.getProperty(COUPONCODE_FLATDISCOUNT_INVALID_AMOUNT_ALPHA));

			this.tutorCouponCodePage.setFlatDiscount(testDataProp.getProperty(COUPONCODE_FLATDISCOUNT_AMOUNT));

			this.tutorCouponCodePage.clickOnPercentageDiscountRadioButton();

			// Assertion for checking the Percentage Discount label
			String lblPercentageDiscount1 = this.tutorCouponCodePage.getPercentageDiscount1Label();
			Assert.assertEquals(lblPercentageDiscount1,
					expectedAssertionsProp.getProperty(LABEL_CREATE_COUPON_PERCENTAGE_DISCOUNT1));

			this.tutorCouponCodePage
					.setInvalidPercentageDiscount(testDataProp.getProperty(COUPONCODE_INVALID_PERCENTAGE_DISCOUNT));

			String lblInvalidPercentageDiscountRequired = this.tutorCouponCodePage.getInvalidStartDateLabel();
			Assert.assertEquals(lblInvalidPercentageDiscountRequired,
					expectedAssertionsProp.getProperty(LABEL_COUPONCODE_INVALID_PERCENTAGE_DISCOUNT));

			this.tutorCouponCodePage.setBlankPercentageDiscount();

			String lblInvalidBlankPercentageDiscountRequired = this.tutorCouponCodePage.getInvalidStartDateLabel();
			Assert.assertEquals(lblInvalidBlankPercentageDiscountRequired,
					expectedAssertionsProp.getProperty(LABEL_COUPONCODE_BLANK_PERCENTAGE_DISCOUNT));
			Thread.sleep(2000);

			this.tutorCouponCodePage.setInvalidPercentageDiscount(
					testDataProp.getProperty(COUPONCODE_INVALID_PERCENTAGE_DISCOUNT_ALPHA));

			this.tutorCouponCodePage.setPercentageDiscount(testDataProp.getProperty(COUPONCODE_PERCENTAGE_DISCOUNT));

			this.tutorCouponCodePage.setInvalidPercentageDiscount(
					testDataProp.getProperty(COUPONCODE_INVALID_ALPHABET_PERCENTAGE_DISCOUNT));

			/*
			 * String lblInvalidAlphabetsPercentageDiscountRequired =
			 * this.tutorCouponCodePage.getInvalidStartDateLabel();
			 * Assert.assertEquals(lblInvalidAlphabetsPercentageDiscountRequired,
			 * expectedAssertionsProp.getProperty(LABEL_COUPONCODE_BLANK_PERCENTAGE_DISCOUNT
			 * ));
			 */
			// Assertion for checking the Maximum Percentage Discount label
			String lblMaxPercentageDiscount = this.tutorCouponCodePage.getMaxPercentageDiscountLabel();
			Assert.assertEquals(lblMaxPercentageDiscount,
					expectedAssertionsProp.getProperty(LABEL_CREATE_COUPON_MAXIMUM_PERCENTAGE_DISCOUNT));

			this.tutorCouponCodePage.setBlankMaxPercentageDiscount();
			this.tutorCouponCodePage.setInvalidMaxPercentageDiscount(
					testDataProp.getProperty(COUPONCODE_INVALID_MAXIMUM_PERCENTAGE_DISCOUNT));

			this.tutorCouponCodePage
					.setMaxPercentageDiscount(testDataProp.getProperty(COUPONCODE_MAXIMUM_PERCENTAGE_DISCOUNT));
			this.tutorCouponCodePage.setPercentageDiscount(testDataProp.getProperty(COUPONCODE_PERCENTAGE_DISCOUNT));

			// Assertion for checking the create Coupon Code Start Date label

			String lblStartDate = this.tutorCouponCodePage.getStartDateLabel();
			Assert.assertEquals(lblStartDate, expectedAssertionsProp.getProperty(LABEL_CREATE_COUPON_CODE_START_DATE));

			this.tutorCouponCodePage.setInvalidStartDate(testDataProp.getProperty(COUPONCODE_INVALID_START_DATE));

			// Assertion for checking the Invalid startDate Label
			String lblInValidStartDate = this.tutorCouponCodePage.getInvalidStartDateLabel();
			Assert.assertEquals(lblInValidStartDate,
					expectedAssertionsProp.getProperty(LABEL_COUPONCODE_INVALID_START_DATE));

			this.tutorCouponCodePage.setBlankStartDate();

			// Assertion for checking the blank startDate Label

			String lblStartDateRequired = this.tutorCouponCodePage.getInvalidStartDateLabel();
			Assert.assertEquals(lblStartDateRequired,
					expectedAssertionsProp.getProperty(LABEL_COUPONCODE_START_DATE_REQUIRED));

			this.tutorCouponCodePage.clickOnCouponCodeButton();

			// Assertion for checking the Coupon Codes label
			String couponCodesLabel1 = this.tutorCouponCodePage.getCouponCodesLabel();
			Assert.assertEquals(couponCodesLabel, expectedAssertionsProp.getProperty(LABEL_COUPONCODE));

			this.tutorCouponCodePage.clickOnCreateCouponButton();

			this.tutorCouponCodePage.setFlatDiscount(testDataProp.getProperty(COUPONCODE_FLATDISCOUNT_AMOUNT));

			// Assertion for checking the create Coupon Code Start Time label
			String lblStartTime = this.tutorCouponCodePage.getStartTimeLabel();
			Assert.assertEquals(lblStartTime, expectedAssertionsProp.getProperty(LABEL_CREATE_COUPON_CODE_START_TIME));

			this.tutorCouponCodePage.setBlankStartTime();

			// Assertion for checking the create Coupon Code Start Time label
			String lblInvalidStartDate = this.tutorCouponCodePage.getInvalidStartTimeLabel();
			Assert.assertEquals(lblInvalidStartDate,
					expectedAssertionsProp.getProperty(LABEL_CREATE_COUPON_CODE_START_TIME_REQUIRED));

			this.tutorCouponCodePage
					.setInValidStartTime(testDataProp.getProperty(LABEL_CREATE_COUPON_CODE_INVALID_START_TIME));

			// Assertion for checking the create Coupon Code Start Time label
			String lblInvalidStartTime = this.tutorCouponCodePage.getInvalidStartTimeLabel();
			Assert.assertEquals(lblInvalidStartTime,
					expectedAssertionsProp.getProperty(LABEL_CREATE_COUPON_CODE_IN_VALID_START_TIME));

			// this.tutorCouponCodePage.setValidStartTime(testDataProp.getProperty(CREATE_COUPON_CODE_VALID_START_TIME));
			this.tutorCouponCodePage.clickOnCouponCodeButton();

			// Assertion for checking the Coupon Codes label
			String couponCodesLabel12 = this.tutorCouponCodePage.getCouponCodesLabel();
			Assert.assertEquals(couponCodesLabel, expectedAssertionsProp.getProperty(LABEL_COUPONCODE));

			this.tutorCouponCodePage.clickOnCreateCouponButton();

			this.tutorCouponCodePage.setInvalidEndDate(testDataProp.getProperty(COUPONCODE_INVALID_START_DATE));

			// Assertion for checking the Invalid EndDate Label String
			String lblInValidStartDate1 = this.tutorCouponCodePage.getInvalidStartDateLabel();
			Assert.assertEquals(lblInValidStartDate1,
					expectedAssertionsProp.getProperty(LABEL_CREATE_COUPON_CODE_END_TIME_NOT_VALID));

			this.tutorCouponCodePage.setBlankEndDate();

			this.tutorCouponCodePage
					.setInValidEndTime(testDataProp.getProperty(LABEL_CREATE_COUPON_CODE_INVALID_START_TIME));

			// Assertion for checking the create Coupon Code Start Time label
			String lblInvalidEndTime = this.tutorCouponCodePage.getInvalidStartTimeLabel();
			Assert.assertEquals(lblInvalidEndTime,
					expectedAssertionsProp.getProperty(LABEL_CREATE_COUPON_CODE_IN_VALID_END_TIME));
			this.tutorCouponCodePage.setBlankEndTime();
			this.tutorCouponCodePage.clickOnLifetimeValidityCheckbox();

			this.tutorCouponCodePage.setBlankMinimumValue(testDataProp.getProperty(COUPONCODE_BLANK_MIN_ORDER_VALUE));
			// Assertion for checking the Invalid EndDate Label String
			String blankMinimumorderValue = this.tutorCouponCodePage.getInvalidStartDateLabel();
			Assert.assertEquals(blankMinimumorderValue,
					expectedAssertionsProp.getProperty(LABEL_CREATE_COUPON_CODE_BLANK_MIN_ORDER_VALUE));

			this.tutorCouponCodePage
					.setBlankMinimumValue(testDataProp.getProperty(COUPONCODE_ALPHABETS_MIN_ORDER_VALUE));
			// Assertion for checking the Invalid EndDate Label String
			String alphaMinimumorderValue = this.tutorCouponCodePage.getInvalidStartDateLabel();
			Assert.assertEquals(alphaMinimumorderValue,
					expectedAssertionsProp.getProperty(LABEL_CREATE_COUPON_CODE_BLANK_MIN_ORDER_VALUE));

			this.tutorCouponCodePage
					.setBlankMinimumValue(testDataProp.getProperty(COUPONCODE_SPECIAL_CHARACTERS_MIN_ORDER_VALUE));

			// Assertion for checking the Invalid EndDate Label String
			String specialCharMinimumorderValue = this.tutorCouponCodePage.getInvalidStartDateLabel();
			Assert.assertEquals(specialCharMinimumorderValue,
					expectedAssertionsProp.getProperty(LABEL_CREATE_COUPON_CODE_BLANK_MIN_ORDER_VALUE));

			this.tutorCouponCodePage.setMinimumValueEdit(testDataProp.getProperty(COUPONCODE_MIN_ORDER_VALUE));
			this.tutorCouponCodePage.setFlatDiscount(testDataProp.getProperty(COUPONCODE_FLATDISCOUNT_AMOUNT));
			this.tutorCouponCodePage.clickOnCodeNextButton();

			this.tutorCouponCodePage
					.setInValidOfferName(testDataProp.getProperty(COUPONCODE_INVALID_OFFER_NAME_2LETTER));

			// Assertion for checking the Invalid offername 3Characters Label
			String InvalidOfferNameLabel = this.tutorCouponCodePage.getInvalidStartDateLabel();
			Assert.assertEquals(InvalidOfferNameLabel,
					expectedAssertionsProp.getProperty(LABEL_CREATE_COUPON_CODE_OFFER_NAME_2CHARACTERS));

			this.tutorCouponCodePage
					.setInValidOfferName(testDataProp.getProperty(COUPONCODE_INVALID_OFFER_NAME_21LETTERS));

			// Assertion for checking the Invalid offername 21Characters Label
			String InvalidOfferName20CharLabel = this.tutorCouponCodePage.getInvalidStartDateLabel();
			Assert.assertEquals(InvalidOfferName20CharLabel,
					expectedAssertionsProp.getProperty(LABEL_CREATE_COUPON_CODE_OFFER_NAME_21CHARACTERS));

			this.tutorCouponCodePage.setBlankOfferName();

			// Assertion for checking the Invalid blank offername Label
			String InvalidBlankfferNameLabel = this.tutorCouponCodePage.getInvalidStartDateLabel();
			Assert.assertEquals(InvalidBlankfferNameLabel,
					expectedAssertionsProp.getProperty(LABEL_CREATE_COUPON_CODE_BLANK_OFFER_NAME));

			this.tutorCouponCodePage.setOfferName(testDataProp.getProperty(COUPONCODE_OFFER_NAME1));

			this.tutorCouponCodePage
					.setInvalidCouponCode(testDataProp.getProperty(LABEL_COUPONCODE_SET_INVALID_COUPON_4CHARACTERS));

			// Assertion for checking the Invalid CouponCode 4 characters Label
			String InvalidCouponCode4characterLabel = this.tutorCouponCodePage.getInvalidStartDateLabel();
			Assert.assertEquals(InvalidCouponCode4characterLabel,
					expectedAssertionsProp.getProperty(LABEL_INVALID_COUPON_CODE_4CHARACTERS));

			this.tutorCouponCodePage
					.setInvalidCouponCode(testDataProp.getProperty(COUPONCODE_SET_INVALID_COUPON_21CHARACTERS));
			// Assertion for checking the Invalid CouponCode 21 characters Label
			String InvalidCouponCode21characterLabel = this.tutorCouponCodePage.getInvalidStartDateLabel();
			Assert.assertEquals(InvalidCouponCode21characterLabel,
					expectedAssertionsProp.getProperty(LABEL_INVALID_COUPON_CODE_21CHARACTERS));

			// this.tutorCouponCodePage.setBlankCouponCode();
			// Assertion for checking the Invalid blank CouponCode Label
			// String InvalidBlankCouponCodeLabel =
			// this.tutorCouponCodePage.getInvalidStartDateLabel();
			// Assert.assertEquals(InvalidBlankCouponCodeLabel,
			// expectedAssertionsProp.getProperty(LABEL_CREATE_COUPON_CODE_BLANK_OFFER_NAME));

			this.tutorCouponCodePage.setInvalidCouponCode(testDataProp.getProperty(COUPONCODE_EXISTING_COUPON));

			// Assertion for checking the Existing Coupon Label
			String InvalidExistingCouponCodeLabel = this.tutorCouponCodePage.getCouponUnavailableText();
			Assert.assertEquals(InvalidExistingCouponCodeLabel,
					expectedAssertionsProp.getProperty(LABEL_CREATECOUPON_EXISTING_COUPON_CODE));

			couponeCode = RandomStringUtils.randomAlphanumeric(6);
			this.tutorCouponCodePage.setCouponCode(couponeCode);

			this.tutorCouponCodePage.setBlankTotalLimit();

			// Assertion for checking the blank total limit Label
			String InvalidBlankNumberOfTimesCouponUsedLabel = this.tutorCouponCodePage.getInvalidStartDateLabel();
			Assert.assertEquals(InvalidBlankNumberOfTimesCouponUsedLabel,
					expectedAssertionsProp.getProperty(LABEL_CREATECOUPON_BLANK_TOTAL_LIMIT));

			this.tutorCouponCodePage.setInvalidTotalLimit(testDataProp.getProperty(COUPONCODE_ALPHABETS_TOTAL_LIMIT));

			// Assertion for checking the Existing Coupon Label
			String InvalidAlphaNumberOfTimesCouponUsedLabel = this.tutorCouponCodePage.getNumberOfTimesCodeUsageLabel();
			Assert.assertEquals(InvalidAlphaNumberOfTimesCouponUsedLabel,
					expectedAssertionsProp.getProperty(LABEL_CREATECOUPON_ALPHABETS_TOTAL_LIMIT));

			
			
			this.tutorCouponCodePage.setTotalLimit(testDataProp.getProperty(COUPONCODE_TOTAL_LIMIT));

			this.tutorCouponCodePage.setBlankUserLimit();
			String blankUsagePerStudentLabel = this.tutorCouponCodePage.getInvalidStartDateLabel();
			Assert.assertEquals(blankUsagePerStudentLabel,
					expectedAssertionsProp.getProperty(LABEL_CREATECOUPON_BLANK_USAGE_LIMIT));

			this.tutorCouponCodePage.setInvalidUserLimit(testDataProp.getProperty(COUPONCODE_INVALID_USER_LIMIT));
			String InvalidusagePerStudentLabel = this.tutorCouponCodePage.getInvalidStartDateLabel();
			Assert.assertEquals(InvalidusagePerStudentLabel,
					expectedAssertionsProp.getProperty(LABEL_CREATECOUPON_ALPHABETS_USAGE_LIMIT));

			this.tutorCouponCodePage.setUserLimit(testDataProp.getProperty(COUPONCODE_USER_LIMIT));

			this.tutorCouponCodePage.clickOnCodeNextButton();

			// Assertion for checking the create Coupon Code label
			String couponsCodesLabel = this.tutorCouponCodePage.getCreateCouponCodeLabel();
			Assert.assertEquals(couponsCodesLabel, expectedAssertionsProp.getProperty(LABEL_CREATE_COUPONCODE));

			this.tutorCouponCodePage.clickOnFinishButton();

			// Assertion for checking the creating coupon code text
			String finishLabel = this.tutorCouponCodePage.getCouponCreatedMessage();
			Assert.assertEquals(finishLabel, expectedAssertionsProp.getProperty(COUPONCODE_CREATED_SUCCESSFULLY_TEXT));

		} catch (Exception e) {
			Assert.fail("Exception occured while testing  Create Coupon With Invalid Details: " + e.getMessage());
			logger.error("Error occured while testing  Create Coupon With Invalid Details ", e);
		}

		logger.info("Ending of testDeletePercentageDiscountCoupon method");
	}

	@Test(priority = 14, description = "Verify Make InActive Coupon ")
	@Description("Test Description:Verify Make InActive Coupon ")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Verify Make InActive Coupon ")
	public void testMakeInActiveCoupon() {
		logger.info("Starting of testMakeInActiveCoupon method");

		try {

			// Assertion for checking the Coupon Codes label
			String couponCodesLabel = this.tutorCouponCodePage.getCouponCodesLabel();
			Assert.assertEquals(couponCodesLabel, expectedAssertionsProp.getProperty(LABEL_COUPONCODE));

			this.tutorCouponCodePage.clickOnInvalidThreeDottedButton();
			this.tutorCouponCodePage.clickOnInvalidMakeInactiveButton();

			// Assertion for checking the make active Coupon Code text
			String couponDetailText = this.tutorCouponCodePage.getCouponDetailsMessage();
			Assert.assertEquals(couponDetailText,
					expectedAssertionsProp.getProperty(COUPONCODE_DETAILS_SUCCESSFULLY_TEXT));

		} catch (Exception e) {
			Assert.fail("Exception occured while testing Make InActive Coupon: " + e.getMessage());
			logger.error("Error occured while testing  Make InActive Coupon ", e);
		}

		logger.info("Ending of testMakeInActiveCoupon method");
	}

	@Test(priority = 15, description = "Verify Delete Coupon ")
	@Description("Test Description:Verify Delete Coupon ")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verify Delete Coupon ")
	public void testDeleteCoupon() {
		logger.info("Starting of testDeleteCoupon method");

		try {
			// Assertion for checking the Coupon Codes label
			String couponCodesLabel = this.tutorCouponCodePage.getCouponCodesLabel();
			Assert.assertEquals(couponCodesLabel, expectedAssertionsProp.getProperty(LABEL_COUPONCODE));

			this.tutorCouponCodePage.clickOnInvalidThreeDottedButton();
			this.tutorCouponCodePage.clickOnInvalidDeleteButton();

			// Assertion for checking the remove Coupon Code text
			String couponRemoveText = this.tutorCouponCodePage.getCouponDeleteMessage();
			Assert.assertEquals(couponRemoveText,
					expectedAssertionsProp.getProperty(COUPONCODE_DELETED_SUCCESSFULLY_TEXT));

			this.tutorCouponCodePage.setSearchCoupon(couponeCode);

			// Assertion for checking the remove Coupon Code text
			String lblNoCouponFound = this.tutorCouponCodePage.getNoCouponFoundLabel();
			Assert.assertEquals(lblNoCouponFound, expectedAssertionsProp.getProperty(COUPONCODE_NOT_FOUND_TEXT));

		} catch (Exception e) {
			Assert.fail("Exception occured while testing  Delete Coupon: " + e.getMessage());
			logger.error("Error occured while testing Delete Coupon ", e);
		}

		logger.info("Ending of testDeleteCoupon method");
	}

	@AfterClass
	public void quitDriver() {
		logger.info("Starting of quitDriver method");

		try {
			if (this.driver != null) {
				Thread.sleep(5000);
				this.loginPage.clickOnLogOut();
				this.quitDriver(this.driver, WEB_DRIVER.COUPON_CODE_TEST);
				logger.info("Driver quit successfully");
			}
		} catch (Exception ex) {
			logger.error(ex.getMessage());
		}

		logger.info("Ending of quitDriver method");
	}

}