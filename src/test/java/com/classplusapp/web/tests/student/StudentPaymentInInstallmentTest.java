package com.classplusapp.web.tests.student;

import static com.classplusapp.store.util.Constants.*;

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

import com.classplusapp.web.pages.student.StudentBuyCoursePage;
import com.classplusapp.web.pages.student.StudentPayInstallmentCoursePage;
import com.classplusapp.web.pages.student.StudentViewContentPage;
import com.classplusapp.web.pages.tutor.TutorAddContentPage;
import com.classplusapp.web.pages.tutor.TutorCouponCodePage;
import com.classplusapp.web.pages.tutor.TutorCreateCoursePage;
import com.classplusapp.web.pages.tutor.TutorCreateInstallmentPage;
import com.classplusapp.web.pages.tutor.TutorEditCoursePage;
import com.classplusapp.web.pages.tutor.TutorMerchantDashboardPage;
import com.classplusapp.web.pages.tutor.TutorStudentSortingPage;
import com.classplusapp.web.tests.BaseClassplusAutomationTest;
import com.classplusapp.web.tests.CommonFunctionStoreTest;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

public class StudentPaymentInInstallmentTest extends CommonFunctionStoreTest {

	private WebDriver driver = null;
	private WebDriver tutorDriver;
	private StudentPayInstallmentCoursePage studentPayInstallmentCoursePage = null;
	private StudentPayInstallmentCoursePage studentPayInstallmentTutorCoursePage = null;
	private StudentBuyCoursePage buyCoursePage = null;
	private TutorCreateCoursePage createCoursePage = null;
	private TutorEditCoursePage tutorEditCoursePage = null;
	private TutorCouponCodePage tutorCouponCodePage = null;
	private String courseName;
	private String physicalCourseName;

	private TutorCreateInstallmentPage createInstallmentPage = null;
	private CommonFunctionStoreTest storeCommonFunctions = null;
	private TutorAddContentPage tutorAddContentPage = null;
	private TutorStudentSortingPage tutorStudentSortingPage = null;
	private TutorMerchantDashboardPage tutorMerchantDashboardPage = null;
	private StudentViewContentPage studentViewContentPage = null;
	private DateTimeFormatter dtf = null;
	private static final Logger logger = Logger.getLogger(StudentPaymentInInstallmentTest.class.getName());

	@BeforeClass
	@Parameters({ "browser", "orgCode", "orgCode2" })
	public void initClassplusSiteLogin(@Optional("Chrome") String browser, @Optional("learn") String tutorOrgCode,
			@Optional("learn") String studentOrgCode) throws Exception {
		logger.info("Starting of initClassplusSiteLogin method");

		this.driver = super.loginClassPlusSite(browser, studentOrgCode, studentMobileNumber, emailAddress,
				WEB_DRIVER.STUDENT_BUY_INSTALLMENT_COURSE_TEST);

		this.tutorDriver = super.loginClassPlusSite(browser, tutorOrgCode, tutorMobileNumber, emailAddress,
				WEB_DRIVER.TUTOR_CREATE_COURSE_AUTOMATION_TESTING);

		this.studentPayInstallmentCoursePage = new StudentPayInstallmentCoursePage(this.driver);
		this.buyCoursePage = new StudentBuyCoursePage(this.driver);
		this.tutorStudentSortingPage = new TutorStudentSortingPage(this.driver);
		this.studentViewContentPage = new StudentViewContentPage(this.driver);
		this.createCoursePage = new TutorCreateCoursePage(this.tutorDriver);
		this.tutorEditCoursePage = new TutorEditCoursePage(this.tutorDriver);
		this.studentPayInstallmentTutorCoursePage = new StudentPayInstallmentCoursePage(this.tutorDriver);

		this.createInstallmentPage = new TutorCreateInstallmentPage(this.tutorDriver);
		this.storeCommonFunctions = new CommonFunctionStoreTest();
		this.tutorAddContentPage = new TutorAddContentPage(this.tutorDriver);
		this.tutorMerchantDashboardPage = new TutorMerchantDashboardPage(this.tutorDriver);
		this.tutorCouponCodePage = new TutorCouponCodePage(this.tutorDriver);

		this.dtf = DateTimeFormatter.ofPattern("yy/MM/dd-HH:mm:ss");

		logger.info("Ending of initClassplusSiteLogin method");
	}

	@Test(priority = 1, description = "Verify user can craete the Course")
	@Description("Test Description:Verify user can craete  the  Course")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verify Select Course Page")
	public void testSelectCourse() {
		logger.info("Starting of testSelectCourse method");

		try {
			this.hardWait(2);
			courseName = this.createSimpleCourse(createCoursePage);

			// Assertion for checking the create course text
			Assert.assertEquals(this.createCoursePage.getCourseCreatedMessage(),
					expectedAssertionsProp.getProperty(COURSE_CREATED_SUCCESSFULLY_TEXT));

		} catch (Exception e) {
			Assert.fail("Exception occured while testing Select Course Page: " + e.getMessage());
			logger.error("Error occured while testing Select Course Page", e);
		}

		logger.info("Ending of testSelectCourse method");
	}

	@Test(priority = 2, description = "Verify the user can add content andpublish the course")
	@Description("Test Description:Verify the add content and publish the course")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verify the add content")
	public void testAddContent() {
		logger.info("Starting of testAddContent method");

		try {
			super.testAddModalSubjectiveTest(tutorAddContentPage);

			// Assertion for checking the Add Subjective Test
			Assert.assertEquals(this.tutorAddContentPage.getAddSubjectiveTestMessage(),
					expectedAssertionsProp.getProperty(SUBJECTIVETEST_ADDED_SUCCESSFULLY_TEXT));
			this.hardWait(3);

			super.testPublishCourse(tutorAddContentPage);

			// Assertion for checking the publish course text
			Assert.assertEquals(this.tutorAddContentPage.getPublishSuccessText(),
					expectedAssertionsProp.getProperty(COURSE_PUBLISHED_TEXT));

		} catch (Exception e) {
			Assert.fail("Exception occured while testing the user can add content and publish the course: "
					+ e.getMessage());
			logger.error("Error occured while testing  the user can add content and publish the course", e);
		}

		logger.info("Ending of testAddContent method");
	}

	@Test(priority = 3, description = "Verify the create course and createinstallment")
	@Description("Test Description:Verify the create course and create installment")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verify create installment")
	public void testCreateInstallment() {
		logger.info("Starting of testCreateInstallment method");

		try {
			super.createCourseInstallments(createInstallmentPage);

			// Assertion for checking the created installments text
			Assert.assertEquals(this.studentPayInstallmentTutorCoursePage.lblCreatedInstallments(),
					expectedAssertionsProp.getProperty(MSG_COURSE_CREATED_INSTALLMENTS));

		} catch (Exception e) {
			Assert.fail("Exception occured while testing the create course and create installment: " + e.getMessage());
			logger.error("Error occured while testing the create course and create installment", e);
		}

		logger.info("Ending of testCreateInstallment method");
	}

	@Test(priority = 4, description = "Verify the purchase intsallment details")
	@Description("Test Description:Verify the purchase intsallment details")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verify Purchase Installment Details")
	public void testPurchaseInstallmentDetails() {
		logger.info("Starting of testPurchaseInstallmentDetails method");

		try {
			this.buyCoursePage.clickOnStoreButton();
			this.buyCoursePage.setSearch(courseName);
			this.buyCoursePage.clickOnGetCourse(courseName);

			this.buyCoursePage.clickOnPurchaseCourseInstallments();

			Assert.assertTrue(this.studentPayInstallmentCoursePage.isDisplayedPayInInstallment());

			Assert.assertTrue(this.studentPayInstallmentCoursePage.isDisplayedVisibilityOfPriceSummary());

			Assert.assertTrue(this.studentPayInstallmentCoursePage.checkInstallmentSequence());

			Assert.assertTrue(this.studentPayInstallmentCoursePage.getInstallmentHeaderLabel());

			Assert.assertTrue(this.studentPayInstallmentCoursePage.checkVisibilityOfPayFirstInstallmentBtn());

		} catch (Exception e) {
			Assert.fail("Exception occured while testing Select Course Page: " + e.getMessage());
			logger.error("Error occured while testing Select Course Page", e);
		}

		logger.info("Ending of testPurchaseInstallmentDetails method");
	}

	@Test(priority = 5, description = "Verify Student can pay the firstinstallment")
	@Description("Test Description:Verify Student can pay the first installment")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verify Pay First Installment")
	public void testPayFirstInstallment() {
		logger.info("Starting of testPurchaseInstallmentDetails method");

		try {
			this.studentPayInstallmentCoursePage.clickOnFirstInstallmentBtn();
			super.testBuyNowCourse(buyCoursePage);

			buyCoursePage.closeBuyNowPage();

			Assert.assertEquals(this.studentPayInstallmentCoursePage.getPaymentFailedHeadingLabel(),
					expectedAssertionsProp.getProperty(LABEL_PAYMENT_FAILED_HEADING));

			buyCoursePage.closePaymentFailedDialogBox();
		} catch (Exception e) {
			Assert.fail("Exception occured while testing Select Course Page: " + e.getMessage());
			logger.error("Error occured while testing Select Course Page", e);
		}

		logger.info("Ending of testPurchaseInstallmentDetails method");

	}

	// Payment blocker
	// @Test(priority = 6, description = "Verify the user can purchase the course
	// without using the installment option")
	@Description("Test Description:Verify the user can purchase the course without using the insstallment option")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verify BuyNow Course Without Insatllment")
	public void testBuyNowCourseWithoutInsatllment() {
		logger.info("Starting of testBuyNowCourseWithoutInsatllment method");

		try {
			String courseName = super.createSimpleCourse(createCoursePage);
			super.testAddModalSubjectiveTest(tutorAddContentPage);
			this.hardWait(3);
			super.testPublishCourse(tutorAddContentPage);
			super.testGetStudentCourse(buyCoursePage, courseName);
			this.buyCoursePage.clickOnBuyNowButton();
			this.buyCoursePage.closeBuyNowPage();

			Assert.assertEquals(this.studentPayInstallmentCoursePage.getPaymentFailedHeadingLabel(),
					expectedAssertionsProp.getProperty(LABEL_PAYMENT_FAILED_HEADING));

			this.buyCoursePage.closePaymentFailedDialogBox();

		} catch (Exception e) {
			Assert.fail(
					"Exception occured while testing the user can purchase the course without using the insstallment option: "
							+ e.getMessage());
			logger.error(
					"Error occured while testing the user can purchase the course without using the insstallment option",
					e);
		}

		logger.info("Ending of testBuyNowCourseWithoutInsatllment method");

	}

	@Test(priority = 7, description = "Verify the student can validate the pricesummary screen details")
	@Description("Test Description:Verify the student can validate the price summary screen details")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verify Price Summary Details")
	public void testPriceSummaryDetails() {
		logger.info("Starting of testPriceSummaryDetails method");

		try {
			this.hardWait(4);
			this.buyCoursePage.clickOnPurchaseCourseInstallments();

			this.studentPayInstallmentCoursePage.clickOnPriceSummaryButton();
			String lblTitle2 = this.studentPayInstallmentCoursePage.getPriceSummaryHeadingText();
			Assert.assertEquals(lblTitle2, expectedAssertionsProp.getProperty(LABEL_PRICE_SUMMARY_HEADING));

			Assert.assertTrue(this.studentPayInstallmentCoursePage.checkVisibilityOfCoursePrice());
			Assert.assertTrue(this.studentPayInstallmentCoursePage.checkVisibilityOfAmountPayable());

			this.studentPayInstallmentCoursePage.closePriceSummary();
			this.studentPayInstallmentCoursePage.closePurchaseInInstallments();

		} catch (Exception e) {
			Assert.fail("Exception occured while testing the student can validate the price summary screen details: "
					+ e.getMessage());
			logger.error("Error occured while testing the student can validate the price summary screen details", e);
		}

		logger.info("Ending of testPriceSummaryDetails method");

	}

	@Test(priority = 8, description = "Verify Student can buy coursewithinstallment option")
	@Description("Test Description:Verify Student can buy course with installment option")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verify Buy Course With Installment")
	public void testBuyCourseWithInstallment() {
		logger.info("Starting of testPurchaseInstallmentDetails method");

		try {
			super.testBuyNowCourse(buyCoursePage);
			buyCoursePage.closeBuyNowPage();

			Assert.assertEquals(this.studentPayInstallmentCoursePage.getPaymentFailedHeadingLabel(),
					expectedAssertionsProp.getProperty(LABEL_PAYMENT_FAILED_HEADING));

			this.buyCoursePage.closePaymentFailedDialogBox();

		} catch (Exception e) {
			Assert.fail("Exception occured while testing Select Course Page: " + e.getMessage());
			logger.error("Error occured while testing Select Course Page", e);
		}

		logger.info("Ending of testPurchaseInstallmentDetails method");

	}

	@Test(priority = 9, description = "Verify Student can buy course without using installment option")
	@Description("Test Description:Verify Student cacn buy course without using installment option")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verify Buy Course WithOut Installment")
	public void testBuyCourseWithOutInstallment() {
		logger.info("Starting of testBuyCourseWithOutInstallment method");

		try {
			String courseName = super.createSimpleCourse(createCoursePage);
			super.testAddModalSubjectiveTest(tutorAddContentPage);
			this.hardWait(3);
			super.testPublishCourse(tutorAddContentPage);
			super.testGetStudentCourse(buyCoursePage, courseName);
			super.testBuyNowCourse(buyCoursePage);

			buyCoursePage.closeBuyNowPage();

			Assert.assertEquals(this.studentPayInstallmentCoursePage.getPaymentFailedHeadingLabel(),
					expectedAssertionsProp.getProperty(LABEL_PAYMENT_FAILED_HEADING));

			buyCoursePage.closePaymentFailedDialogBox();

			Assert.assertEquals(this.studentPayInstallmentCoursePage.getPaymentFailedHeadingLabel(),
					expectedAssertionsProp.getProperty(LABEL_PAYMENT_FAILED_HEADING));

		} catch (Exception e) {
			Assert.fail("Exception occured while testing Student can buy course without using installment option: "
					+ e.getMessage());
			logger.error("Error occured while testing Student can buy course without using installment option", e);
		}

		logger.info("Ending of testBuyCourseWithOutInstallment method");

	}

	@Test(priority = 10, description = "Verify the user can validate the second payment label after paid 1st innsatllment")
	@Description("Test Description:Verify the user cacn validate the second payment label after paid 1st innsatllment")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verify Second PayInstallment Validations")
	public void testSecondPayInstallmentValidations() {
		logger.info("Starting of testSecondPayInstallmentValidations method");

		try {
			this.buyCoursePage.clickOnStoreButton();
			this.studentPayInstallmentCoursePage.clickOnGetInstallmentCourse();

			Assert.assertTrue(this.studentPayInstallmentCoursePage.isDisplayedUpSecondPaymentButton());
			Assert.assertTrue(this.studentPayInstallmentCoursePage.isDisplayedUpViewAllButton());

			Assert.assertTrue(this.studentPayInstallmentCoursePage.checkVisibilityOfBottomViewAllInstallmentBtn());
			Assert.assertTrue(this.studentPayInstallmentCoursePage.checkVisibilityOfBottomPayxthInstallmentBtn());

		} catch (Exception e) {
			Assert.fail(
					"Exception occured while testing the user can validate the second payment label after paid 1st innsatllment: "
							+ e.getMessage());
			logger.error(
					"Error occured while testingthe user can validate the second payment label after paid 1st innsatllment",
					e);
		}

		logger.info("Ending of testSecondPayInstallmentValidations method");

	}

	@Test(priority = 11, description = "Verify Student can download thepaymentreceipt after 1st payment")
	@Description("Test Description:Verify Student can download the payment receipt after 1st payment")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verify Download Receipt")
	public void testDownloadReceipt() {
		logger.info("Starting of testDownloadReceipt method");

		try {
			this.buyCoursePage.clickOnStoreButton();
			this.studentPayInstallmentCoursePage.clickOnGetInstallmentCourse();
			this.studentPayInstallmentCoursePage.clickOnUpViewAllButton();
			this.studentPayInstallmentCoursePage.clickOnReceiptButton();
			this.studentPayInstallmentCoursePage.closePurchaseInInstallments();

			Assert.assertEquals(this.tutorStudentSortingPage.getOverViewLabelText(),
					expectedAssertionsProp.getProperty(LABEL_STORE_OVERVIEW));

		} catch (Exception e) {
			Assert.fail("Exception occured while testing  Student can download the payment receipt after 1st payment: "
					+ e.getMessage());
			logger.error("Error occured while testing  Student can download the payment receipt after 1st payment", e);
		}

		logger.info("Ending of testSecondPayInstallmentValidations method");

	}

	@Test(priority = 12, description = "Verify the student can validate the course amount with price summary payable amount")
	@Description("Test Description:Verify the student can validate the course amount with price summary payable amount")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verify Course Amount with payable amount ")
	public void testAmountPayable() {
		logger.info("Starting of testAmountPayable method");

		try {
			this.buyCoursePage.clickOnStoreButton();
			this.studentPayInstallmentCoursePage.clickOnGetInstallmentCourse();
			this.studentPayInstallmentCoursePage.clickOnUpViewAllButton();
			String courseInstallmentAmount = this.studentPayInstallmentCoursePage.getStudentAmountLabel();
			this.studentPayInstallmentCoursePage.clickOnPriceSummaryButton();
			String amtInPayableInstallment = this.studentPayInstallmentCoursePage.getPayableAmountLabel();

			Assert.assertEquals(courseInstallmentAmount, amtInPayableInstallment);

			this.studentPayInstallmentCoursePage.clickOnClosePriceButton();
			this.studentPayInstallmentCoursePage.clickOnCloseInstallButton();

		} catch (Exception e) {
			Assert.fail(
					"Exception occured while testing  the student can validate the course amount with price summary payable amount "
							+ e.getMessage());
			logger.error(
					"Error occured while testing  the student can validate the course amount with price summary payable amount",
					e);
		}

		logger.info("Ending of testAmountPayable method");

	}

	@Test(priority = 13, description = "Verify the student can validate the pending and locked course after paid the first installment")
	@Description("Test Description:Verify the student can validate the pending and locked course after paid the first installment")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verify Locked course")
	public void testLockedCoursePaymentDetails() {
		logger.info("Starting of testLockedCoursePaymentDetails method");

		try {
			this.buyCoursePage.clickOnStoreButton();
			this.studentPayInstallmentCoursePage.clickOnGetInstallmentCourse();

			Assert.assertEquals(this.studentPayInstallmentCoursePage.getCourseLockedHeader(),
					expectedAssertionsProp.getProperty(LABEL_LOCKED_COURSE));

			Assert.assertTrue(this.studentPayInstallmentCoursePage.isDisplayedLockedCouse());
			Assert.assertTrue(this.studentPayInstallmentCoursePage.isDisplayedPayPending());
			Assert.assertTrue(this.studentPayInstallmentCoursePage.isDisplayedViewAll());

			this.studentPayInstallmentCoursePage.clickOnPayPendingButton();
			this.studentPayInstallmentCoursePage.closeRazorPayPopup();

			Assert.assertEquals(this.tutorStudentSortingPage.getOverViewLabelText(),
					expectedAssertionsProp.getProperty(LABEL_STORE_OVERVIEW));

		} catch (Exception e) {
			Assert.fail(
					"Exception occured while the student can validate the pending and locked course after paid the first installment: "
							+ e.getMessage());
			logger.error(
					"Error occured whilethe student can validate the pending and locked course after paid the first installment",
					e);
		}

		logger.info("Ending of testLockedCoursePaymentDetails method");

	}

	@Test(priority = 14, description = "Verify the student can Purchase physicalshipment course")
	@Description("Test Description:Verify the student can  Purchase physical shipment course")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verify Purchase Physical Shipment Course")
	public void testPurchasePhysicalShipmentCourse() {
		logger.info("Starting of testPurchasePhysicalShipmentCourse method");

		try {
			super.createPhysicalShipmentCourse(createCoursePage);
			this.studentPayInstallmentCoursePage.clickOnPhysicalShipmentToggle();
			this.studentPayInstallmentCoursePage.clickOnDeliveryDateCheckbox();
			createCoursePage.clickOnTermsAndConditionCheckBox();
			createCoursePage.clickOnAddContentButton();
			super.testAddModalSubjectiveTest(tutorAddContentPage);
			super.testPublishCourse(tutorAddContentPage);
			this.buyCoursePage.clickOnStoreButton();
			String physicalCourseName = this.storeCommonFunctions.createPhysicalShipmentCourse(createCoursePage);
			this.buyCoursePage.setSearch(physicalCourseName);
			this.buyCoursePage.clickOnGetCourse(physicalCourseName);
			this.studentPayInstallmentCoursePage.clickOnSelectAddress();
			this.studentPayInstallmentCoursePage.setFullName(testDataProp.getProperty(TXT_FULL_NAME));
			this.studentPayInstallmentCoursePage.setAddress(testDataProp.getProperty(TXT_ADDRESS));
			this.studentPayInstallmentCoursePage
					.setAlternativeAddress(testDataProp.getProperty(TXT_ALTERNATIVE_ADDRESS));
			this.studentPayInstallmentCoursePage.setCity(testDataProp.getProperty(TXT_CITY));
			this.studentPayInstallmentCoursePage.clickonStateDropdown();
			this.studentPayInstallmentCoursePage.clickonSelectState();
			this.studentPayInstallmentCoursePage.setPin(testDataProp.getProperty(TXT_PIN));
			this.studentPayInstallmentCoursePage.setMobile(testDataProp.getProperty(TXT_MOBILE));
			this.studentPayInstallmentCoursePage.clickOnShipmentSave();
			this.studentPayInstallmentCoursePage.clickOnShipmentSave();

			super.testBuyNowCourse(buyCoursePage);

			Assert.assertEquals(this.studentPayInstallmentCoursePage.getPaymentFailedHeadingLabel(),
					expectedAssertionsProp.getProperty(LABEL_PAYMENT_FAILED_HEADING));

			this.studentPayInstallmentCoursePage.clickOnDeleteButton();
			this.studentPayInstallmentCoursePage.clickOnYesDelete();

		} catch (Exception e) {
			Assert.fail(
					"Exception occured while the student can  Purchase physical shipment course: " + e.getMessage());
			logger.error("Error occured while the student can  Purchase physical shipment course", e);
		}

		logger.info("Ending of testPurchasePhysicalShipmentCourse method");

	}

	@Test(priority = 15, description = "Verify the student can Purchase course with coupon applied on the course")
	@Description("Test Description:Verify the student can Purchase course with coupon applied on the course")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verify Coupon Applied Purchase Course")
	public void testCouponAppliedPurchaseCourse() {
		logger.info("Starting of testCouponAppliedPurchaseCourse method");

		try {
			super.createCouponCourse(createCoursePage);
			createCoursePage.clickOnAddContentButton();
			super.testAddModalSubjectiveTest(tutorAddContentPage);
			this.hardWait(3);
			super.testPublishCourse(tutorAddContentPage);
			this.buyCoursePage.clickOnStoreButton();
			this.buyCoursePage.setSearch(testDataProp.getProperty(LABEL_STUDENT_COUPON_COURSE));
			this.studentPayInstallmentCoursePage.clickOnGetCouponCourse();
			this.studentPayInstallmentCoursePage.clickOnViewAllCoupon();
			this.hardWait(4);
			this.studentPayInstallmentCoursePage.setSearchCoupon(testDataProp.getProperty(TXT_SEARCH_COUPON));
			this.studentPayInstallmentCoursePage.clickOnApplyCoupon();

			Assert.assertEquals(this.studentPayInstallmentCoursePage.getCouponAppliedLabel(),
					expectedAssertionsProp.getProperty(LABEL_COUPON_APPLIED_MESSAGE));

			this.studentPayInstallmentCoursePage.scrollDown(500);

			super.testBuyNowCourse(buyCoursePage);
			studentPayInstallmentCoursePage.closeBuyNowPage();
			buyCoursePage.closePaymentFailedDialogBox();

			Assert.assertEquals(this.studentPayInstallmentCoursePage.getPaymentFailedHeadingLabel(),
					expectedAssertionsProp.getProperty(LABEL_PAYMENT_FAILED_HEADING));

		} catch (Exception e) {
			Assert.fail("Exception occured while the student can Purchase course with coupon applied on the course: "
					+ e.getMessage());
			logger.error("Error occured while the student can Purchase course with coupon applied on the course", e);
		}

		logger.info("Ending of testCouponAppliedPurchaseCourse method");

	}

	@Test(priority = 16, description = "Verify that While student purchasing course in which INH & Tax fees is applied displays in the price section ")
	@Description("Test Description:Verify that While student  purchasing a course in which INH & Tax fees is applied displays in the price section  ")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verify Coupon Applied Purchase Course")
	public void testPurchaseCourseWithTaxFees() {
		logger.info("Starting of testPurchaseCourseWithTaxFees method");

		try {
			super.createCourseWithTaxDetails(createCoursePage);
			super.testAddModalSubjectiveTest(tutorAddContentPage);
			super.testPublishCourse(tutorAddContentPage);

			this.buyCoursePage.clickOnStoreButton();
			this.buyCoursePage.setSearch(testDataProp.getProperty(LABEL_STUDENT_COUPON_COURSE));
			this.studentPayInstallmentCoursePage.clickOnGetCouponCourse();

			Assert.assertTrue(this.studentPayInstallmentCoursePage.isDisplayedCoursePriceLabel());
			Assert.assertTrue(this.studentPayInstallmentCoursePage.isDisplayedInternetPriceLabel());
			Assert.assertTrue(this.studentPayInstallmentCoursePage.isDisplayedAmountPayableLabel());

			super.testBuyNowCourse(buyCoursePage);
			studentPayInstallmentCoursePage.closeBuyNowPage();

			Assert.assertEquals(this.studentPayInstallmentCoursePage.getPaymentFailedHeadingLabel(),
					expectedAssertionsProp.getProperty(LABEL_PAYMENT_FAILED_HEADING));

			buyCoursePage.closePaymentFailedDialogBox();
		} catch (Exception e) {
			Assert.fail(
					"Exception occured while the that While student  purchasing a course in which INH & Tax fees is applied displays in the price section : "
							+ e.getMessage());
			logger.error(
					"Error occured while the that While student  purchasing a course in which INH & Tax fees is applied displays in the price section ",
					e);
		}

		logger.info("Ending of testPurchaseCourseWithTaxFees method");

	}

	@Test(priority = 17, description = "Verify student can access the contents or not once after purchased course")
	@Description("Test Description:Verify student can access the contents or not once after purchased course")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verify Student Get Access Content After Purchase Course")
	public void testStudentGetAccessAfterPurchaseCourse() {
		logger.info("Starting of testStudentAccessContentAfterPurchaseCourse method");

		try {
			this.hardWait(3);
			super.studentAccessContentCourse(studentViewContentPage);

			Assert.assertEquals(this.studentPayInstallmentCoursePage.getContentLabel(),
					expectedAssertionsProp.getProperty(LABEL_COURSE_CONTENT));

		} catch (Exception e) {
			Assert.fail(
					"Exception occured while the that While student can access the contents or not once after purchased course : "
							+ e.getMessage());
			logger.error(
					"Error occured while the that While student can access the contents or not once after purchased course ",
					e);
		}

		logger.info("Ending of testPurchaseCourseWithTaxFees method");

	}

	@Test(priority = 18, description = "Verify Uloaded watermark is visible or not for students While playing video from content tab")
	@Description("Test Description:Verify Uloaded watermark is visible or not for students  While playing video from content tab")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test Water Mak Visibility")
	public void testWaterMarkVisibility() {
		logger.info("Starting of testWaterMarkVisibility method");

		try {
			super.testSettingsPage(tutorMerchantDashboardPage);

			// Assertion for checking the upload water mark
			Assert.assertEquals(this.tutorMerchantDashboardPage.getUploadWaterMark(),
					expectedAssertionsProp.getProperty(MSG_UPLOAD_WATER_MARK));

			this.buyCoursePage.clickOnStoreButton();
			this.studentPayInstallmentCoursePage.clickOnGetInstallmentCourse();
			this.studentPayInstallmentCoursePage.clickOnClosePriceButton();
			super.testGetVideo(studentViewContentPage);
			this.hardWait(2);
			Assert.assertTrue(this.studentPayInstallmentCoursePage.isDisplayedWaterMarkLabel());
			this.studentPayInstallmentCoursePage.clickOnVideoTestCancel();

			Assert.assertEquals(this.studentPayInstallmentCoursePage.getContentLabel(),
					expectedAssertionsProp.getProperty(LABEL_COURSE_CONTENT));

		} catch (Exception e) {

			Assert.fail(
					"Exception occured while the that While student can access the contents or not once after purchased course : "
							+ e.getMessage());

			logger.error(
					"Error occured while the that While student can access the contents or not once after purchased course ",
					e);
		}

		logger.info("Ending of testWaterMarkVisibility method");

	}

	@Test(priority = 19, description = "Verify Uploaded watermark is visible or not for students While playing video from content tab")
	@Description("Test Description:Verify Uloaded watermark is visible or not for students  While playing video from content tab")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test Remove Water Mak Visibility")
	public void testDeletedWaterMakVisibility() {
		logger.info("Starting of testDeletedWaterMakVisibility method");

		try {
			super.testSettingsPage(tutorMerchantDashboardPage);
			this.tutorMerchantDashboardPage.clickOnCrossButton();

			// Assertion for checking the delete water mark
			Assert.assertEquals(this.tutorMerchantDashboardPage.getDeleteWaterMark(),
					expectedAssertionsProp.getProperty(MSG_DELETE_WATER_MARK));

			this.buyCoursePage.clickOnStoreButton();
			this.studentPayInstallmentCoursePage.clickOnGetInstallmentCourse();
			this.studentPayInstallmentCoursePage.clickOnClosePriceButton();
			super.testGetVideo(studentViewContentPage);
			Assert.assertFalse(this.studentPayInstallmentCoursePage.isDisplayedWaterMarkLabel());
			this.studentPayInstallmentCoursePage.clickOnVideoTestCancel();

			Assert.assertEquals(this.studentPayInstallmentCoursePage.getContentLabel(),
					expectedAssertionsProp.getProperty(LABEL_COURSE_CONTENT));

		} catch (Exception e) {
			Assert.fail(
					"Exception occured while the that While student can access the contents or not once after purchased course : "
							+ e.getMessage());
			logger.error(
					"Error occured while the that While student can access the contents or not once after purchased course ",
					e);
		}

		logger.info("Ending of testDeletedWaterMakVisibility method");

	}

	@Test(priority = 20, description = "Verify that when student click on the available coupon mentioned under the coupon for you section all courseslistslinked with that coupon reflects to the student")
	@Description("Test Description:Verify that when student click on the available coupon mentioned under the coupon for you section all courses lists  linked with that coupon reflects to the student")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test Avaiable coupon in coupon section link with all courses test ")
	public void testAvailableCoupon() {
		logger.info("Starting of testAvailableCoupon method");

		try {
			super.testCreateCouponPercentageDiscountType(tutorCouponCodePage);

			// Assertion for checking the creating coupon code text
			String finishLabel = tutorCouponCodePage.getCouponCreatedMessage();
			Assert.assertEquals(finishLabel, expectedAssertionsProp.getProperty(COUPONCODE_CREATED_SUCCESSFULLY_TEXT));

			this.buyCoursePage.clickOnStoreButton();

			Assert.assertTrue(this.studentPayInstallmentCoursePage.isDisplayedCouponsForYouHeader());

			this.hardWait(2);
			this.studentPayInstallmentCoursePage.clickOnCouroselButton();
			this.hardWait(2);
			this.studentPayInstallmentCoursePage.clickOnBackwardCouroselButton();
			this.studentPayInstallmentCoursePage.clickOnCouroselButton();

			Assert.assertTrue(this.studentPayInstallmentCoursePage.isDisplayedAvailableCouponCourse());

			this.studentPayInstallmentCoursePage.getAvailableCourse();
			this.studentPayInstallmentCoursePage.clickOnViewAllCoupon();

			Assert.assertTrue(this.studentPayInstallmentCoursePage.isDisplayedCoupon());

			this.tutorCouponCodePage.clickOnThreeDottedMenu(testDataProp.getProperty(COUPONCODE_OFFER_NAME));
			this.studentPayInstallmentTutorCoursePage.clickOnMakeInActiveIcon();
			this.tutorCouponCodePage.clickOnThreeDottedMenu(testDataProp.getProperty(COUPONCODE_OFFER_NAME));
			this.studentPayInstallmentTutorCoursePage.clickDeleteIcon();

			// Assertion for checking the remove Coupon Code text
			String couponRemoveText = tutorCouponCodePage.getCouponDeleteMessage();
			Assert.assertEquals(couponRemoveText,
					expectedAssertionsProp.getProperty(COUPONCODE_DELETED_SUCCESSFULLY_TEXT));

		} catch (Exception e) {
			Assert.fail(
					"Exception occured while the that when student click on the available coupon mentioned under the coupon for you section all courses lists  linked with that coupon reflects to the student : "
							+ e.getMessage());
			logger.error(
					"Error occured while the that when student click on the available coupon mentioned under the coupon for you section all courses lists  linked with that coupon reflects to the student ",
					e);
		}

		logger.info("Ending of testAvailableCoupon method");

	}

	@AfterClass
	public void quitDriver() {
		logger.info("Starting of quitDriver method");

		try {
			if (this.driver != null) {
				Thread.sleep(5000);
				this.loginPage.clickOnLogOut();
				this.quitDriver(this.driver, WEB_DRIVER.STUDENT_BUY_INSTALLMENT_COURSE_TEST);
				logger.info("Driver quit successfully");
			}
			if (this.driver != null) {
				Thread.sleep(5000);
				this.loginPage.clickOnLogOut();
				this.quitDriver(this.driver, WEB_DRIVER.TUTOR_CREATE_COURSE_AUTOMATION_TESTING);
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