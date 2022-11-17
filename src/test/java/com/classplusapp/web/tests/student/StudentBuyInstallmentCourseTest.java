package com.classplusapp.web.tests.student;

import org.testng.annotations.Test;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static com.classplusapp.store.util.Constants.*;

import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.Set;

import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

import com.classplusapp.web.pages.student.StudentPayInstallmentCoursePage;
import com.classplusapp.web.pages.tutor.TutorAddContentPage;
import com.classplusapp.web.pages.tutor.TutorCreateCoursePage;
import com.classplusapp.web.pages.tutor.TutorCreateInstallmentPage;
import com.classplusapp.web.pages.student.StudentBuyCoursePage;

import com.classplusapp.web.tests.BaseClassplusAutomationTest;
//import com.classplusapp.web.tests.BaseClassplusAutomationTest.WEB_DRIVER;
import com.classplusapp.web.tests.CommonFunctionStoreTest;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Epic("Store Overview")
@Feature("Student Installment Course Test")
public class StudentBuyInstallmentCourseTest extends BaseClassplusAutomationTest {

	private WebDriver driver = null;
	private WebDriver tutorDriver = null;
	private StudentPayInstallmentCoursePage buyInstallmentCoursePage = null;
	private StudentBuyCoursePage buyCoursePage = null;
	private TutorCreateCoursePage createCoursePage = null;
	private TutorCreateInstallmentPage createInstallmentPage = null;
	private CommonFunctionStoreTest storeCommonFunctions = null;
	private TutorAddContentPage addContentPage = null;

	private DateTimeFormatter dtf = null;
	private static final Logger logger = Logger.getLogger(StudentBuyInstallmentCourseTest.class.getName());

	@BeforeClass
	@Parameters({ "browser", "orgCode", "orgCode2"})
	public void initClassplusSiteLogin(@Optional("Chrome")String browser,@Optional("learn") String tutorOrgCode, @Optional("learn")String studentOrgCode
			) throws Exception {
		logger.info("Starting of initClassplusSiteLogin methond");

		this.driver = super.loginClassPlusSite(browser, studentOrgCode, studentMobileNumber, emailAddress,
				WEB_DRIVER.STUDENT_BUY_INSTALLMENT_COURSE_TEST);

		this.tutorDriver = super.loginClassPlusSite(browser, tutorOrgCode, tutorMobileNumber, emailAddress,
				WEB_DRIVER.TUTOR_CREATE_COURSE_AUTOMATION_TESTING);

		this.buyInstallmentCoursePage = new StudentPayInstallmentCoursePage(this.driver);
		this.buyCoursePage = new StudentBuyCoursePage(this.driver);
		this.createCoursePage = new TutorCreateCoursePage(this.tutorDriver);
		this.createInstallmentPage = new TutorCreateInstallmentPage(this.tutorDriver);
		this.storeCommonFunctions = new CommonFunctionStoreTest();
		this.addContentPage = new TutorAddContentPage(this.tutorDriver);

		this.dtf = DateTimeFormatter.ofPattern("yy/MM/dd-HH:mm:ss");

		logger.info("Ending of initClassplusSiteLogin method");
	}

	@Test(priority = 1, description = "Verify Purchase Course in installment button")
	@Description("Test Description:Verify Purchase Course in installment button")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verify Purchase Course in installment button")
	public void testPurchaseInstallmentButton() {
		logger.info("Starting of testPurchaseInstallmentButton method");

		try {
			String createdInstallmentCourseName = this.storeCommonFunctions.createSimpleCourse(createCoursePage);
			this.storeCommonFunctions.addCourseContent(addContentPage,
					testDataProp.getProperty(LABEL_FOR_UPLOADING_IMAGE));
			String toastMsgText1 = this.addContentPage.getSuccessImageMessageText();
			Assert.assertEquals(toastMsgText1, expectedAssertionsProp.getProperty(IMAGE_ADDED_SUCCESSFULLY_TEXT));
			this.storeCommonFunctions.publishCourse(createCoursePage);
			this.storeCommonFunctions.createCourseInstallments(createInstallmentPage);

			String createdSimpleCourseName = this.storeCommonFunctions.createSimpleCourse(createCoursePage);
			this.storeCommonFunctions.addCourseContent(addContentPage,
					testDataProp.getProperty(LABEL_FOR_UPLOADING_IMAGE));
			String toastMsgText2 = this.addContentPage.getSuccessImageMessageText();
			Assert.assertEquals(toastMsgText2, expectedAssertionsProp.getProperty(IMAGE_ADDED_SUCCESSFULLY_TEXT));
			this.storeCommonFunctions.publishCourse(createCoursePage);

			this.buyCoursePage.clickOnStoreButton();
			this.buyCoursePage.setSearch(createdInstallmentCourseName);
			this.buyCoursePage.clickOnGetCourse(createdInstallmentCourseName);
			String lblTitle1 = this.buyCoursePage.getTitleLabelText();
			Assert.assertEquals(lblTitle1, createdInstallmentCourseName);

			Assert.assertTrue(this.buyCoursePage.checkVisibilityOfPurchaseInstallmentbtn());

			this.buyCoursePage.clickOnStoreButton();
			this.buyCoursePage.setSearch(createdSimpleCourseName);
			this.buyCoursePage.clickOnGetCourse(createdSimpleCourseName);
			String lblTitle2 = this.buyCoursePage.getTitleLabelText();
			Assert.assertEquals(lblTitle2, createdSimpleCourseName);

			Assert.assertFalse(this.buyCoursePage.checkVisibilityOfPurchaseInstallmentbtn());

		} catch (Exception e) {
			Assert.fail(
					"Exception occured while testing Verify Purchase Course in installment button: " + e.getMessage());
			logger.error("Error occured while testing Verify Purchase Course in installment button", e);
		}

		logger.info("Ending of testPurchaseInstallmentButton method");
	}

	@Test(priority = 2, description = "Verify Purchase Course in installment page details")
	@Description("Test Description:Verify Purchase Course in installment page details")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verify Purchase Course in installment page details")
	public void purchaseInstallmentDetailsTest() {
		logger.info("Starting of purchaseInstallmentDetailsTest method");

		try {

			String createdCourseName = this.storeCommonFunctions.createSimpleCourse(createCoursePage);
			this.storeCommonFunctions.addCourseContent(addContentPage,
					testDataProp.getProperty(LABEL_FOR_UPLOADING_IMAGE));
			String toastMsgText1 = this.addContentPage.getSuccessImageMessageText();
			Assert.assertEquals(toastMsgText1, expectedAssertionsProp.getProperty(IMAGE_ADDED_SUCCESSFULLY_TEXT));
			this.storeCommonFunctions.publishCourse(createCoursePage);
			this.storeCommonFunctions.createCourseInstallments(createInstallmentPage);

			this.buyCoursePage.clickOnStoreButton();
			this.buyCoursePage.setSearch(createdCourseName);
			this.buyCoursePage.clickOnGetCourse(createdCourseName);
			String lblTitle1 = this.buyCoursePage.getTitleLabelText();
			Assert.assertEquals(lblTitle1, createdCourseName);
			this.buyCoursePage.clickOnPurchaseCourseInstallments();
			this.buyInstallmentCoursePage.isDisplayedVisibilityOfPriceSummary();
			Assert.assertTrue(this.buyInstallmentCoursePage.checkInstallmentSequence());

			Assert.assertTrue(this.buyInstallmentCoursePage.checkVisibilityOfPayFirstInstallmentBtn());

			Float firstInstallmentAmount = this.buyInstallmentCoursePage.getFirstInstallmentAmount();
			Float amtInPayFirstInstallmentBtn = this.buyInstallmentCoursePage.getAmtInPayFirstInstallmentBtn();
			
			Assert.assertEquals(firstInstallmentAmount, amtInPayFirstInstallmentBtn);

		} catch (Exception e) {
			Assert.fail("Exception occured while testing Verify Purchase Course in installment page details: "
					+ e.getMessage());
			logger.error("Error occured while testing Verify Purchase Course in installment page details", e);
		}

		logger.info("Ending of purchaseInstallmentDetailsTest method");
	}

	@Test(priority = 3, description = "Verify buy installment type course without installment")
	@Description("Test Description:Verify buy installment type course without installment")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Verify buy installment type course without installment")
	public void testBuyInstallmentCourseWithOutInstallment() {
		logger.info("Starting of testBuyInstallmentCourseWithOutInstallment method");

		try {

			String createdCourseName = this.storeCommonFunctions.createSimpleCourse(createCoursePage);
			this.storeCommonFunctions.addCourseContent(addContentPage,
					testDataProp.getProperty(LABEL_FOR_UPLOADING_IMAGE));
			String toastMsgText1 = this.addContentPage.getSuccessImageMessageText();
			Assert.assertEquals(toastMsgText1, expectedAssertionsProp.getProperty(IMAGE_ADDED_SUCCESSFULLY_TEXT));
			this.storeCommonFunctions.publishCourse(createCoursePage);
			this.storeCommonFunctions.createCourseInstallments(createInstallmentPage);

			this.buyCoursePage.clickOnStoreButton();
			this.buyCoursePage.setSearch(createdCourseName);
			this.buyCoursePage.clickOnGetCourse(createdCourseName);
			String lblTitle1 = this.buyCoursePage.getTitleLabelText();
			Assert.assertEquals(lblTitle1, createdCourseName);

			Assert.assertTrue(this.buyCoursePage.checkVisibilityOfPurchaseInstallmentbtn());
			this.buyCoursePage.clickonSelectStateDropDown();
			this.buyCoursePage.clickonStateButton();
//			this.buyCoursePage.clickOnBuyNowButton();
//			this.buyCoursePage.clickOnNetbanking();
//			this.buyCoursePage.selectBank();
//			this.buyCoursePage.clickOnPayAmountButton();
//			
//			
//			this.buyCoursePage.clickOnDummyPaymentSuccess();
////			this.buyCoursePage.switchToParentWindow();
//			driver.switchTo().defaultContent();
//			String pmtStatus=this.buyCoursePage.getPaymentStatusText();
//			Assert.assertEquals(pmtStatus, expectedAssertionsProp.getProperty(PAYMENT_STATUS_SUCCESS_TEXT));
//			this.buyCoursePage.closePaymentStatusPopup();

		} catch (Exception e) {
			Assert.fail("Exception occured while testing Buy Course Page: " + e.getMessage());
			logger.error("Error occured while testing Buy Course Page", e);
		}

		logger.info("Ending of testBuyInstallmentCourseWithOutInstallment method");
	}

	@Test(priority = 4, description = "Verify Buy Course Page without installment option")
	@Description("Test Description:Verify Buy Course Page without installment option")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Verify Buy Course Page without installment option")
	public void testBuyCourseWithoutInstallmentOption() {
		logger.info("Starting of testBuyCourseWithoutInstallmentOption method");

		try {
			String createdCourseName = this.storeCommonFunctions.createSimpleCourse(createCoursePage);
			this.storeCommonFunctions.addCourseContent(addContentPage,
					testDataProp.getProperty(LABEL_FOR_UPLOADING_IMAGE));
			String toastMsgText1 = this.addContentPage.getSuccessImageMessageText();
			Assert.assertEquals(toastMsgText1, expectedAssertionsProp.getProperty(IMAGE_ADDED_SUCCESSFULLY_TEXT));
			this.storeCommonFunctions.publishCourse(createCoursePage);

			this.buyCoursePage.clickOnStoreButton();
			this.buyCoursePage.setSearch(createdCourseName);
			this.buyCoursePage.clickOnGetCourse(createdCourseName);
			String lblTitle1 = this.buyCoursePage.getTitleLabelText();
			Assert.assertEquals(lblTitle1, createdCourseName);
			this.buyCoursePage.clickonSelectStateDropDown();
			this.buyCoursePage.clickonStateButton();
//			this.buyCoursePage.clickOnBuyNowButton();
//			this.buyCoursePage.clickOnNetbanking();
//			this.buyCoursePage.selectBank();
//			this.buyCoursePage.clickOnPayAmountButton();
//			
//			
////			this.buyCoursePage.switchToNewWindow();
//			
//			this.buyCoursePage.clickOnDummyPaymentSuccess();
////			this.buyCoursePage.switchToParentWindow();
//			driver.switchTo().defaultContent();
//			String pmtStatus=this.buyCoursePage.getPaymentStatusText();
//			Assert.assertEquals(pmtStatus, expectedAssertionsProp.getProperty(PAYMENT_STATUS_SUCCESS_TEXT));
//			this.buyCoursePage.closePaymentStatusPopup();

		} catch (Exception e) {
			Assert.fail("Exception occured while testing Verify Buy Course Page without installment option: "
					+ e.getMessage());
			logger.error("Error occured while testing Verify Buy Course Page without installment option", e);
		}

		logger.info("Ending of testBuyCourseWithoutInstallmentOption method");
	}

	@Test(priority = 5, description = "Verify pay with first installment button")
	@Description("Test Description:Verify pay with first installment button")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verify pay with first installment button")
	public void testPayFirstInstallment() {
		logger.info("Starting of testPayFirstInstallment method");

		try {

			String createdCourseName = this.storeCommonFunctions.createSimpleCourse(createCoursePage);
			this.storeCommonFunctions.addCourseContent(addContentPage,
					testDataProp.getProperty(LABEL_FOR_UPLOADING_IMAGE));
			String toastMsgText1 = this.addContentPage.getSuccessImageMessageText();
			Assert.assertEquals(toastMsgText1, expectedAssertionsProp.getProperty(IMAGE_ADDED_SUCCESSFULLY_TEXT));
			this.storeCommonFunctions.publishCourse(createCoursePage);
			this.storeCommonFunctions.createCourseInstallments(createInstallmentPage);

			this.buyCoursePage.clickOnStoreButton();
			this.buyCoursePage.setSearch(createdCourseName);
			this.buyCoursePage.clickOnGetCourse(createdCourseName);
			String lblTitle = this.buyCoursePage.getTitleLabelText();
			Assert.assertEquals(lblTitle, createdCourseName);

			this.buyCoursePage.clickonSelectStateDropDown();
			this.buyCoursePage.clickonStateButton();

//			this.buyCoursePage.clickOnPurchaseCourseInstallments();
//			this.buyCoursePage.clickOnPayFirstInstallment();
//			this.buyCoursePage.clickOnNetbanking();
//			this.buyCoursePage.selectBank();
//			this.buyCoursePage.clickOnPayAmountButton();
//			
//			
//			this.buyCoursePage.clickOnDummyPaymentSuccess();
//			
//			driver.switchTo().defaultContent();
//			String pmtStatus=this.buyCoursePage.getPaymentStatusText();
//			Assert.assertEquals(pmtStatus, expectedAssertionsProp.getProperty(PAYMENT_STATUS_SUCCESS_TEXT));
//			this.buyCoursePage.closePaymentStatusPopup();

		} catch (Exception e) {
			Assert.fail("Exception occured while testing Verify pay with first installment button: " + e.getMessage());
			logger.error("Error occured while testing Verify pay with first installment button", e);
		}

		logger.info("Ending of testPayFirstInstallment method");
	}

	@Test(priority = 6, description = "Verify Price summary Details")
	@Description("Test Description:Verify Price summary Details")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verify Price summary Details")
	public void testPriceSummaryDetails() {
		logger.info("Starting of testPriceSummaryDetails method");

		try {

			String createdCourseName = this.storeCommonFunctions.createSimpleCourse(createCoursePage);
			this.storeCommonFunctions.addCourseContent(addContentPage,
					testDataProp.getProperty(LABEL_FOR_UPLOADING_IMAGE));
			String toastMsgText1 = this.addContentPage.getSuccessImageMessageText();
			Assert.assertEquals(toastMsgText1, expectedAssertionsProp.getProperty(IMAGE_ADDED_SUCCESSFULLY_TEXT));
			this.storeCommonFunctions.publishCourse(createCoursePage);
			this.storeCommonFunctions.createCourseInstallments(createInstallmentPage);

			this.buyCoursePage.clickOnStoreButton();
			this.buyCoursePage.setSearch(createdCourseName);
			this.buyCoursePage.clickOnGetCourse(createdCourseName);
			String lblTitle1 = this.buyCoursePage.getTitleLabelText();
			Assert.assertEquals(lblTitle1, createdCourseName);

			this.buyCoursePage.clickOnPurchaseCourseInstallments();
			this.buyInstallmentCoursePage.clickOnPriceSummaryButton();
			String lblTitle2 = this.buyInstallmentCoursePage.getPriceSummaryHeadingText();
			Assert.assertEquals(lblTitle2, expectedAssertionsProp.getProperty(LABEL_PRICE_SUMMARY_HEADING));

			Assert.assertTrue(this.buyInstallmentCoursePage.checkVisibilityOfCoursePrice());
			Assert.assertTrue(this.buyInstallmentCoursePage.checkVisibilityOfAmountPayable());
			this.buyInstallmentCoursePage.closePriceSummary();
			this.buyInstallmentCoursePage.closePurchaseInInstallments();

		} catch (Exception e) {
			Assert.fail("Exception occured while testing Verify Price summary Details: " + e.getMessage());
			logger.error("Error occured while testing Verify Price summary Details", e);
		}

		logger.info("Ending of testPriceSummaryDetails method");
	}

//	@Test(priority = 7, description = "Verify bottom Payment Summary View all installent and pay 2nd installment button")    Not possible because of paying 1st isntallment
	@Description("Test Description:Verify bottom Payment Summary View all installent and pay 2nd installment button")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verify bottom Payment Summary View all installent and pay 2nd installment button")
	public void testBottomPaymentSummary() {
		logger.info("Starting of testBottomPaymentSummary method");

		try {

			String createdCourseName = this.storeCommonFunctions.createSimpleCourse(createCoursePage);
			this.storeCommonFunctions.addCourseContent(addContentPage,
					testDataProp.getProperty(LABEL_FOR_UPLOADING_IMAGE));
			String toastMsgText1 = this.addContentPage.getSuccessImageMessageText();
			Assert.assertEquals(toastMsgText1, expectedAssertionsProp.getProperty(IMAGE_ADDED_SUCCESSFULLY_TEXT));
			this.storeCommonFunctions.publishCourse(createCoursePage);
			this.storeCommonFunctions.createCourseInstallments(createInstallmentPage);

			this.buyCoursePage.clickOnStoreButton();
			this.buyCoursePage.setSearch(createdCourseName);
			this.buyCoursePage.clickOnGetCourse(createdCourseName);
			String lblTitle = this.buyCoursePage.getTitleLabelText();
			Assert.assertEquals(lblTitle, createdCourseName);

			this.buyCoursePage.clickonSelectStateDropDown();
			this.buyCoursePage.clickonStateButton();

//			this.buyCoursePage.clickOnPurchaseCourseInstallments();
//			this.buyCoursePage.clickOnPayFirstInstallment();
//			this.buyCoursePage.clickOnNetbanking();
//			this.buyCoursePage.selectBank();
//			this.buyCoursePage.clickOnPayAmountButton();
//			
//			
//			this.buyCoursePage.clickOnDummyPaymentSuccess();
//			
//			driver.switchTo().defaultContent();
//			String pmtStatus=this.buyCoursePage.getPaymentStatusText();
//			Assert.assertEquals(pmtStatus, expectedAssertionsProp.getProperty(PAYMENT_STATUS_SUCCESS_TEXT));
//			this.buyCoursePage.closePaymentStatusPopup();

			this.buyCoursePage.clickOnStoreButton();
			this.buyCoursePage.clickOnViewAllPurchased();
			this.buyCoursePage.setSearch(createdCourseName);
			this.buyCoursePage.clickOnGetCourse(createdCourseName);
			String lblTitle1 = this.buyCoursePage.getTitleLabelText();
			Assert.assertEquals(lblTitle1, createdCourseName);

			Assert.assertTrue(this.buyInstallmentCoursePage.isDisplayedUpSecondPaymentButton());
			Assert.assertTrue(this.buyInstallmentCoursePage.isDisplayedUpViewAllButton());

			Assert.assertTrue(this.buyInstallmentCoursePage.checkVisibilityOfBottomViewAllInstallmentBtn());
			Assert.assertTrue(this.buyInstallmentCoursePage.checkVisibilityOfBottomPayxthInstallmentBtn());

		} catch (Exception e) {
			Assert.fail(
					"Exception occured while testing Verify bottom Payment Summary View all installent and pay 2nd installment button: "
							+ e.getMessage());
			logger.error(
					"Error occured while testing Verify bottom Payment Summary View all installent and pay 2nd installment button",
					e);
		}

		logger.info("Ending of testBottomPaymentSummary method");
	}

//	@Test(priority = 8, description = "Verify side Payment Summary View all installent and pay 2nd installment button")   Not possible bcoz of payment of 1st installment
	@Description("Test Description:Verify side Payment Summary View all installent and pay 2nd installment button")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verify side Payment Summary View all installent and pay 2nd installment button")
	public void testSidePaymentSummary() {
		logger.info("Starting of testSidePaymentSummary method");

		try {

			String createdCourseName = this.storeCommonFunctions.createSimpleCourse(createCoursePage);
			this.storeCommonFunctions.addCourseContent(addContentPage,
					testDataProp.getProperty(LABEL_FOR_UPLOADING_IMAGE));
			String toastMsgText1 = this.addContentPage.getSuccessImageMessageText();
			Assert.assertEquals(toastMsgText1, expectedAssertionsProp.getProperty(IMAGE_ADDED_SUCCESSFULLY_TEXT));
			this.storeCommonFunctions.publishCourse(createCoursePage);
			this.storeCommonFunctions.createCourseInstallments(createInstallmentPage);

			this.buyCoursePage.clickOnStoreButton();
			this.buyCoursePage.setSearch(createdCourseName);
			this.buyCoursePage.clickOnGetCourse(createdCourseName);
			String lblTitle = this.buyCoursePage.getTitleLabelText();
			Assert.assertEquals(lblTitle, createdCourseName);

			this.buyCoursePage.clickonSelectStateDropDown();
			this.buyCoursePage.clickonStateButton();

//			this.buyCoursePage.clickOnPurchaseCourseInstallments();
//			this.buyCoursePage.clickOnPayFirstInstallment();
//			this.buyCoursePage.clickOnNetbanking();
//			this.buyCoursePage.selectBank();
//			this.buyCoursePage.clickOnPayAmountButton();
//			
//			
//			this.buyCoursePage.clickOnDummyPaymentSuccess();
//			
//			driver.switchTo().defaultContent();
//			String pmtStatus=this.buyCoursePage.getPaymentStatusText();
//			Assert.assertEquals(pmtStatus, expectedAssertionsProp.getProperty(PAYMENT_STATUS_SUCCESS_TEXT));
//			this.buyCoursePage.closePaymentStatusPopup();

			this.buyCoursePage.clickOnStoreButton();
			this.buyCoursePage.clickOnViewAllPurchased();
			this.buyCoursePage
					.setSearch(testDataProp.getProperty(LABEL_STUDENT_PURCHASE_COURSE_WITH_FIRST_INSTALLMENT_TITLE));
			this.buyCoursePage.clickOnGetCourse(
					testDataProp.getProperty(LABEL_STUDENT_PURCHASE_COURSE_WITH_FIRST_INSTALLMENT_TITLE));
			String lblTitle1 = this.buyCoursePage.getTitleLabelText();
			Assert.assertEquals(lblTitle1,
					expectedAssertionsProp.getProperty(LABEL_STUDENT_PURCHASE_COURSE_WITH_FIRST_INSTALLMENT_TITLE));

			Assert.assertTrue(this.buyInstallmentCoursePage.checkVisibilityOfSideViewAllInstallmentBtn());
			Assert.assertTrue(this.buyInstallmentCoursePage.checkVisibilityOfSidePayxthInstallmentBtn());

		} catch (Exception e) {
			Assert.fail(
					"Exception occured while testing Verify side Payment Summary View all installent and pay 2nd installment button: "
							+ e.getMessage());
			logger.error(
					"Error occured while testing Verify side Payment Summary View all installent and pay 2nd installment button",
					e);
		}

		logger.info("Ending of testSidePaymentSummary method");
	}

//	@Test(priority = 9, description = "Verify click on Pay Xth installment button")  // Not possible due to need to purchase course first
	@Description("Test Description:Verify click on Pay Xth installment button")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verify click on Pay Xth installment button")
	public void testClickOnPayXthInstallment() {
		logger.info("Starting of testClickOnPayXthInstallment method");

		try {

			String createdCourseName = this.storeCommonFunctions.createSimpleCourse(createCoursePage);
			this.storeCommonFunctions.addCourseContent(addContentPage,
					testDataProp.getProperty(LABEL_FOR_UPLOADING_IMAGE));
			String toastMsgText1 = this.addContentPage.getSuccessImageMessageText();
			Assert.assertEquals(toastMsgText1, expectedAssertionsProp.getProperty(IMAGE_ADDED_SUCCESSFULLY_TEXT));
			this.storeCommonFunctions.publishCourse(createCoursePage);
			this.storeCommonFunctions.createCourseInstallments(createInstallmentPage);

			this.buyCoursePage.clickOnStoreButton();
			this.buyCoursePage.setSearch(createdCourseName);
			this.buyCoursePage.clickOnGetCourse(createdCourseName);
			String lblTitle = this.buyCoursePage.getTitleLabelText();
			Assert.assertEquals(lblTitle, createdCourseName);

			this.buyCoursePage.clickonSelectStateDropDown();
			this.buyCoursePage.clickonStateButton();

//			this.buyCoursePage.clickOnPurchaseCourseInstallments();
//			this.buyCoursePage.clickOnPayFirstInstallment();
//			this.buyCoursePage.clickOnNetbanking();
//			this.buyCoursePage.selectBank();
//			this.buyCoursePage.clickOnPayAmountButton();
//			
//			
//			this.buyCoursePage.clickOnDummyPaymentSuccess();
//			
//			driver.switchTo().defaultContent();
//			String pmtStatus=this.buyCoursePage.getPaymentStatusText();
//			Assert.assertEquals(pmtStatus, expectedAssertionsProp.getProperty(PAYMENT_STATUS_SUCCESS_TEXT));
//			this.buyCoursePage.closePaymentStatusPopup();

			this.buyCoursePage.clickOnStoreButton();
			this.buyCoursePage.clickOnViewAllPurchased();
			this.buyCoursePage.setSearch(createdCourseName);
			this.buyCoursePage.clickOnGetCourse(createdCourseName);
			String lblTitle1 = this.buyCoursePage.getTitleLabelText();
			Assert.assertEquals(lblTitle1, createdCourseName);

//			this.buyInstallmentCoursePage.clickOnBottomPayxthInstallmentButton();
//			this.buyInstallmentCoursePage.closeRazorPayPopup();
//			driver.switchTo().defaultContent();
			this.buyInstallmentCoursePage.clickOnSidePayxthInstallmentButton();
			this.buyInstallmentCoursePage.closeRazorPayPopup();
			driver.switchTo().defaultContent();

		} catch (Exception e) {
			Assert.fail(
					"Exception occured while testing Verify click on Pay Xth installment button: " + e.getMessage());
			logger.error("Error occured while testing Verify click on Pay Xth installment button", e);
		}

		logger.info("Ending of testClickOnPayXthInstallment method");
	}

//	@Test(priority = 10, description = "Verify click on View all installment ")   // Not possible due to purchasing of course first
	@Description("Test Description:Verify click on View all installment ")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verify click on View all installment ")
	public void testClickOnViewAllInstallment() {
		logger.info("Starting of testClickOnViewAllInstallment method");

		try {
			String createdCourseName = this.storeCommonFunctions.createSimpleCourse(createCoursePage);
			this.storeCommonFunctions.addCourseContent(addContentPage,
					testDataProp.getProperty(LABEL_FOR_UPLOADING_IMAGE));
			String toastMsgText1 = this.addContentPage.getSuccessImageMessageText();
			Assert.assertEquals(toastMsgText1, expectedAssertionsProp.getProperty(IMAGE_ADDED_SUCCESSFULLY_TEXT));
			this.storeCommonFunctions.publishCourse(createCoursePage);
			this.storeCommonFunctions.createCourseInstallments(createInstallmentPage);

			this.buyCoursePage.clickOnStoreButton();
			this.buyCoursePage.setSearch(createdCourseName);
			this.buyCoursePage.clickOnGetCourse(createdCourseName);
			String lblTitle = this.buyCoursePage.getTitleLabelText();
			Assert.assertEquals(lblTitle, createdCourseName);

			this.buyCoursePage.clickonSelectStateDropDown();
			this.buyCoursePage.clickonStateButton();

			//// below to purchase course by paying installments one by one

//			int installmentCount=1;
//			while(true) {
//				if(installmentCount==1)
//					this.buyCoursePage.clickOnPurchaseCourseInstallments();
//				else
//					this.buyInstallmentCoursePage.clickOnSideViewAllInstallmentButton();
//				if(this.buyInstallmentCoursePage.checkPayXthInstallmentInViewAllInstallment())
//				{
//					
//					this.buyInstallmentCoursePage.clickOnPayXthInstallmentInViewAllInstallment();
//					this.buyCoursePage.clickOnNetbanking();
//					this.buyCoursePage.selectBank();
//					this.buyCoursePage.clickOnPayAmountButton();
//					
//					this.buyCoursePage.clickOnDummyPaymentSuccess();
//					
//					driver.switchTo().defaultContent();
//					String pmtStatus=this.buyCoursePage.getPaymentStatusText();
//					Assert.assertEquals(pmtStatus, expectedAssertionsProp.getProperty(PAYMENT_STATUS_SUCCESS_TEXT));
//					this.buyCoursePage.closePaymentStatusPopup();
//				}
//				else {
//					this.buyInstallmentCoursePage.closePurchaseInInstallments();
//					break;
//				}
//					
//				installmentCount++;
//			}

			this.buyCoursePage.clickOnStoreButton();
			this.buyCoursePage.clickOnViewAllPurchased();
			this.buyCoursePage
					.setSearch(testDataProp.getProperty(LABEL_STUDENT_PURCHASE_COURSE_WITH_FIRST_INSTALLMENT_TITLE));
			this.buyCoursePage.clickOnGetCourse(
					testDataProp.getProperty(LABEL_STUDENT_PURCHASE_COURSE_WITH_FIRST_INSTALLMENT_TITLE));
			String lblTitle1 = this.buyCoursePage.getTitleLabelText();
			Assert.assertEquals(lblTitle1,
					expectedAssertionsProp.getProperty(LABEL_STUDENT_PURCHASE_COURSE_WITH_FIRST_INSTALLMENT_TITLE));

			this.buyInstallmentCoursePage.clickOnBottomViewAllInstallmentButton();
			this.buyInstallmentCoursePage.closePurchaseInInstallments();

			this.buyInstallmentCoursePage.clickOnSideViewAllInstallmentButton();
			this.buyInstallmentCoursePage.closePurchaseInInstallments();

		} catch (Exception e) {
			Assert.fail("Exception occured while testing Verify click on View all installment : " + e.getMessage());
			logger.error("Error occured while testing Verify click on View all installment ", e);
		}

		logger.info("Ending of testClickOnViewAllInstallment method");
	}

	@Test(priority = 11, description = "Verify presence of Pay Xth installment button in View all installment button ")
	@Description("Test Description:Verify presence of Pay Xth installment button in View all installment button ")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verify presence of Pay Xth installment button in View all installment button")
	public void testVisOfPayXthInstallmentInViewAllInstallment() {
		logger.info("Starting of testVisOfPayXthInstallmentInViewAllInstallment method");

		try {
			String createdCourseName = this.storeCommonFunctions.createSimpleCourse(createCoursePage);
			this.storeCommonFunctions.addCourseContent(addContentPage,
					testDataProp.getProperty(LABEL_FOR_UPLOADING_IMAGE));
			String toastMsgText1 = this.addContentPage.getSuccessImageMessageText();
			Assert.assertEquals(toastMsgText1, expectedAssertionsProp.getProperty(IMAGE_ADDED_SUCCESSFULLY_TEXT));
			this.storeCommonFunctions.publishCourse(createCoursePage);
			this.storeCommonFunctions.createCourseInstallments(createInstallmentPage);

			this.buyCoursePage.clickOnStoreButton();
			this.buyCoursePage.setSearch(createdCourseName);
			this.buyCoursePage.clickOnGetCourse(createdCourseName);
			String lblTitle = this.buyCoursePage.getTitleLabelText();
			Assert.assertEquals(lblTitle, createdCourseName);

			this.buyCoursePage.clickonSelectStateDropDown();
			this.buyCoursePage.clickonStateButton();

			//// below to purchase course by paying installments one by one

//			int installmentCount=1;
//			while(true) {
//				if(installmentCount==1)
//					this.buyCoursePage.clickOnPurchaseCourseInstallments();
//				else
//					this.buyInstallmentCoursePage.clickOnSideViewAllInstallmentButton();
//				if(this.buyInstallmentCoursePage.checkPayXthInstallmentInViewAllInstallment())
//				{
//					
//					this.buyInstallmentCoursePage.clickOnPayXthInstallmentInViewAllInstallment();
//					this.buyCoursePage.clickOnNetbanking();
//					this.buyCoursePage.selectBank();
//					this.buyCoursePage.clickOnPayAmountButton();
//					
//					this.buyCoursePage.clickOnDummyPaymentSuccess();
//					
//					driver.switchTo().defaultContent();
//					String pmtStatus=this.buyCoursePage.getPaymentStatusText();
//					Assert.assertEquals(pmtStatus, expectedAssertionsProp.getProperty(PAYMENT_STATUS_SUCCESS_TEXT));
//					this.buyCoursePage.closePaymentStatusPopup();
//				}
//				else {
//					this.buyInstallmentCoursePage.closePurchaseInInstallments();
//					break;
//				}
//					
//				installmentCount++;
//			}

			this.buyCoursePage.clickOnStoreButton();
			this.buyCoursePage.clickOnViewAllPurchased();
			this.buyCoursePage.setSearch(testDataProp.getProperty(LABEL_COURSE_WITH_INSTALLMENT_TITLE));
			this.buyCoursePage.clickOnGetCourse(testDataProp.getProperty(LABEL_COURSE_WITH_INSTALLMENT_TITLE));
			String lblTitle1 = this.buyCoursePage.getTitleLabelText();
			Assert.assertEquals(lblTitle1, expectedAssertionsProp.getProperty(LABEL_COURSE_WITH_INSTALLMENT_TITLE));

			this.buyInstallmentCoursePage.clickOnSideViewAllInstallmentButton();
			Assert.assertFalse(this.buyInstallmentCoursePage.checkPayXthInstallmentInViewAllInstallment());
			this.buyInstallmentCoursePage.closePurchaseInInstallments();

		} catch (Exception e) {
			Assert.fail(
					"Exception occured while testing Verify presence of Pay Xth installment button in View all installment button: "
							+ e.getMessage());
			logger.error(
					"Error occured while testing Verify presence of Pay Xth installment button in View all installment button ",
					e);
		}

		logger.info("Ending of testVisOfPayXthInstallmentInViewAllInstallment method");
	}

	@Test(priority = 12, description = "Verify Dowload receipt button in View All Installment ")
	@Description("Test Description:Verify Dowload receipt button in View All Installment ")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verify Dowload receipt button in View All Installment ")
	public void testReceiptDownloadInViewAllInstallment() {
		logger.info("Starting of testReceiptDownloadInViewAllInstallment method");

		try {

			String createdCourseName = this.storeCommonFunctions.createSimpleCourse(createCoursePage);
			this.storeCommonFunctions.addCourseContent(addContentPage,
					testDataProp.getProperty(LABEL_FOR_UPLOADING_IMAGE));
			String toastMsgText1 = this.addContentPage.getSuccessImageMessageText();
			Assert.assertEquals(toastMsgText1, expectedAssertionsProp.getProperty(IMAGE_ADDED_SUCCESSFULLY_TEXT));
			this.storeCommonFunctions.publishCourse(createCoursePage);
			this.storeCommonFunctions.createCourseInstallments(createInstallmentPage);

			this.buyCoursePage.clickOnStoreButton();
			this.buyCoursePage.setSearch(createdCourseName);
			this.buyCoursePage.clickOnGetCourse(createdCourseName);
			String lblTitle = this.buyCoursePage.getTitleLabelText();
			Assert.assertEquals(lblTitle, createdCourseName);

			this.buyCoursePage.clickonSelectStateDropDown();
			this.buyCoursePage.clickonStateButton();

			//// below to purchase course by paying installments one by one

//			int installmentCount=1;
//			while(true) {
//				if(installmentCount==1)
//					this.buyCoursePage.clickOnPurchaseCourseInstallments();
//				else
//					this.buyInstallmentCoursePage.clickOnSideViewAllInstallmentButton();
//				if(this.buyInstallmentCoursePage.checkPayXthInstallmentInViewAllInstallment())
//				{
//					
//					this.buyInstallmentCoursePage.clickOnPayXthInstallmentInViewAllInstallment();
//					this.buyCoursePage.clickOnNetbanking();
//					this.buyCoursePage.selectBank();
//					this.buyCoursePage.clickOnPayAmountButton();
//					
//					this.buyCoursePage.clickOnDummyPaymentSuccess();
//					
//					driver.switchTo().defaultContent();
//					String pmtStatus=this.buyCoursePage.getPaymentStatusText();
//					Assert.assertEquals(pmtStatus, expectedAssertionsProp.getProperty(PAYMENT_STATUS_SUCCESS_TEXT));
//					this.buyCoursePage.closePaymentStatusPopup();
//				}
//				else {
//					this.buyInstallmentCoursePage.closePurchaseInInstallments();
//					break;
//				}
//					
//				installmentCount++;
//			}

			this.buyCoursePage.clickOnStoreButton();
			this.buyCoursePage.clickOnViewAllPurchased();
			this.buyCoursePage.setSearch(testDataProp.getProperty(LABEL_COURSE_WITH_INSTALLMENT_TITLE));
			this.buyCoursePage.clickOnGetCourse(testDataProp.getProperty(LABEL_COURSE_WITH_INSTALLMENT_TITLE));
			String lblTitle1 = this.buyCoursePage.getTitleLabelText();
			Assert.assertEquals(lblTitle1, expectedAssertionsProp.getProperty(LABEL_COURSE_WITH_INSTALLMENT_TITLE));

			this.buyInstallmentCoursePage.clickOnSideViewAllInstallmentButton();
			this.buyInstallmentCoursePage.checkReceiptButton();
			this.buyInstallmentCoursePage.closePurchaseInInstallments();

		} catch (Exception e) {
			Assert.fail("Exception occured while testing Verify Dowload receipt button in View All Installment : "
					+ e.getMessage());
			logger.error("Error occured while testing Verify Dowload receipt button in View All Installment ", e);
		}

		logger.info("Ending of testReceiptDownloadInViewAllInstallment method");
	}

//	@Test(priority = 13, description = "Verify visibility of Buy with X amount button in course overview page ")  Not possible because of purchasing the course first
	@Description("Test Description:Verify visibility of Buy with X amount button in course overview page")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verify visibility of Buy with X amount button in course overview page")
	public void testVisOfBuyNowWithXAmount() {
		logger.info("Starting of testVisOfBuyNowWithXAmount method");

		try {

			String createdCourseName = this.storeCommonFunctions.createSimpleCourse(createCoursePage);
			this.storeCommonFunctions.addCourseContent(addContentPage,
					testDataProp.getProperty(LABEL_FOR_UPLOADING_IMAGE));
			String toastMsgText1 = this.addContentPage.getSuccessImageMessageText();
			Assert.assertEquals(toastMsgText1, expectedAssertionsProp.getProperty(IMAGE_ADDED_SUCCESSFULLY_TEXT));
			this.storeCommonFunctions.publishCourse(createCoursePage);
			this.storeCommonFunctions.createCourseInstallments(createInstallmentPage);

			this.buyCoursePage.clickOnStoreButton();
			this.buyCoursePage.setSearch(createdCourseName);
			this.buyCoursePage.clickOnGetCourse(createdCourseName);
			String lblTitle = this.buyCoursePage.getTitleLabelText();
			Assert.assertEquals(lblTitle, createdCourseName);

			this.buyCoursePage.clickonSelectStateDropDown();
			this.buyCoursePage.clickonStateButton();

			//// below to purchase course by paying installments one by one

//			int installmentCount=1;
//			while(true) {
//				if(installmentCount==1)
//					this.buyCoursePage.clickOnPurchaseCourseInstallments();
//				else
//					this.buyInstallmentCoursePage.clickOnSideViewAllInstallmentButton();
//				if(this.buyInstallmentCoursePage.checkPayXthInstallmentInViewAllInstallment())
//				{
//					
//					this.buyInstallmentCoursePage.clickOnPayXthInstallmentInViewAllInstallment();
//					this.buyCoursePage.clickOnNetbanking();
//					this.buyCoursePage.selectBank();
//					this.buyCoursePage.clickOnPayAmountButton();
//					
//					this.buyCoursePage.clickOnDummyPaymentSuccess();
//					
//					driver.switchTo().defaultContent();
//					String pmtStatus=this.buyCoursePage.getPaymentStatusText();
//					Assert.assertEquals(pmtStatus, expectedAssertionsProp.getProperty(PAYMENT_STATUS_SUCCESS_TEXT));
//					this.buyCoursePage.closePaymentStatusPopup();
//				}
//				else {
//					this.buyInstallmentCoursePage.closePurchaseInInstallments();
//					break;
//				}
//					
//				installmentCount++;
//			}

			this.buyCoursePage.clickOnStoreButton();
			this.buyCoursePage.clickOnViewAllPurchased();
			this.buyCoursePage
					.setSearch(testDataProp.getProperty(LABEL_STUDENT_PURCHASE_COURSE_WITH_FIRST_INSTALLMENT_TITLE));
			this.buyCoursePage.clickOnGetCourse(
					testDataProp.getProperty(LABEL_STUDENT_PURCHASE_COURSE_WITH_FIRST_INSTALLMENT_TITLE));
			String lblTitle1 = this.buyCoursePage.getTitleLabelText();
			Assert.assertEquals(lblTitle1,
					expectedAssertionsProp.getProperty(LABEL_STUDENT_PURCHASE_COURSE_WITH_FIRST_INSTALLMENT_TITLE));

			Assert.assertFalse(this.buyInstallmentCoursePage.checkVisibilityBuyNowButton());

		} catch (Exception e) {
			Assert.fail(
					"Exception occured while testing Verify visibility of Buy with X amount button in course overview page: "
							+ e.getMessage());
			logger.error(
					"Error occured while testing Verify visibility of Buy with X amount button in course overview page",
					e);
		}

		logger.info("Ending of testVisOfBuyNowWithXAmount method");
	}

	@Test(priority = 14, description = "Verify visibility Pay Xtn installment button after paying all installments in course overview page ")
	@Description("Test Description:Verify visibility Pay Xtn installment button after paying all installments in course overview page")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verify visibility Pay Xtn installment button after paying all installments in course overview page")
	public void testVisOfPayXthInstallmentInOverview() {
		logger.info("Starting of testVisOfPayXthInstallmentInOverview method");

		try {

			String createdCourseName = this.storeCommonFunctions.createSimpleCourse(createCoursePage);
			this.storeCommonFunctions.addCourseContent(addContentPage,
					testDataProp.getProperty(LABEL_FOR_UPLOADING_IMAGE));
			String toastMsgText1 = this.addContentPage.getSuccessImageMessageText();
			Assert.assertEquals(toastMsgText1, expectedAssertionsProp.getProperty(IMAGE_ADDED_SUCCESSFULLY_TEXT));
			this.storeCommonFunctions.publishCourse(createCoursePage);
			this.storeCommonFunctions.createCourseInstallments(createInstallmentPage);

			this.buyCoursePage.clickOnStoreButton();
			this.buyCoursePage.setSearch(createdCourseName);
			this.buyCoursePage.clickOnGetCourse(createdCourseName);
			String lblTitle = this.buyCoursePage.getTitleLabelText();
			Assert.assertEquals(lblTitle, createdCourseName);

			this.buyCoursePage.clickonSelectStateDropDown();
			this.buyCoursePage.clickonStateButton();

			//// below to purchase course by paying installments one by one

//			int installmentCount=1;
//			while(true) {
//				if(installmentCount==1)
//					this.buyCoursePage.clickOnPurchaseCourseInstallments();
//				else
//					this.buyInstallmentCoursePage.clickOnSideViewAllInstallmentButton();
//				if(this.buyInstallmentCoursePage.checkPayXthInstallmentInViewAllInstallment())
//				{
//					
//					this.buyInstallmentCoursePage.clickOnPayXthInstallmentInViewAllInstallment();
//					this.buyCoursePage.clickOnNetbanking();
//					this.buyCoursePage.selectBank();
//					this.buyCoursePage.clickOnPayAmountButton();
//					
//					this.buyCoursePage.clickOnDummyPaymentSuccess();
//					
//					driver.switchTo().defaultContent();
//					String pmtStatus=this.buyCoursePage.getPaymentStatusText();
//					Assert.assertEquals(pmtStatus, expectedAssertionsProp.getProperty(PAYMENT_STATUS_SUCCESS_TEXT));
//					this.buyCoursePage.closePaymentStatusPopup();
//				}
//				else {
//					this.buyInstallmentCoursePage.closePurchaseInInstallments();
//					break;
//				}
//					
//				installmentCount++;
//			}

			this.buyCoursePage.clickOnStoreButton();
			this.buyCoursePage.clickOnViewAllPurchased();
			this.buyCoursePage.setSearch(testDataProp.getProperty(LABEL_COURSE_PAY_ALL_INSTALLMENT_TITLE));
			this.buyCoursePage.clickOnGetCourse(testDataProp.getProperty(LABEL_COURSE_PAY_ALL_INSTALLMENT_TITLE));
			String lblTitle1 = this.buyCoursePage.getTitleLabelText();
			Assert.assertEquals(lblTitle1, expectedAssertionsProp.getProperty(LABEL_COURSE_PAY_ALL_INSTALLMENT_TITLE));

			Assert.assertFalse(this.buyInstallmentCoursePage.checkVisibilityOfBottomPayxthInstallmentBtn());
			Assert.assertFalse(this.buyInstallmentCoursePage.checkVisibilityOfSidePayxthInstallmentBtn());

		} catch (Exception e) {
			Assert.fail(
					"Exception occured while testing Verify visibility Pay Xtn installment button after paying all installments in course overview pagee: "
							+ e.getMessage());
			logger.error(
					"Error occured while testing Verify visibility Pay Xtn installment button after paying all installments in course overview page",
					e);
		}

		logger.info("Ending of testVisOfPayXthInstallmentInOverview method");
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