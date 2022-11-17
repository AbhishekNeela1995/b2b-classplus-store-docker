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

import static com.classplusapp.store.util.Constants.*;

import com.classplusapp.web.pages.tutor.TutorAddContentPage;
import com.classplusapp.web.pages.tutor.TutorCreateCoursePage;
import com.classplusapp.web.pages.tutor.TutorCreateInstallmentPage;
import com.classplusapp.web.tests.BaseClassplusAutomationTest;
import com.classplusapp.web.tests.CommonFunctionStoreTest;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Epic("Store Overview")
@Feature("Create Installments Test")
public class TutorCreateInstallmentTest extends BaseClassplusAutomationTest {

	private WebDriver driver = null;
	private TutorCreateInstallmentPage tutorCreateInstallmentPage = null;
	private CommonFunctionStoreTest storeCommonFunctions = null;
	private TutorCreateCoursePage createCoursePage = null;
	private TutorAddContentPage addContentPage = null;
	private String createdCourseName;

	private static final Logger logger = Logger.getLogger(TutorCreateInstallmentTest.class.getName());

	@BeforeClass
	@Parameters({ "browser", "orgCode" })
	public void initClassplusSiteLogin(@Optional("Chrome") String browser, @Optional("learn") String orgCode)
			throws Exception {
		logger.info("Starting of initClassplusSiteLogin method");

		this.driver = super.loginClassPlusSite(browser, orgCode, tutorMobileNumber, emailAddress,
				WEB_DRIVER.CREATE_INSTALLMENT_TEST);
		this.tutorCreateInstallmentPage = new TutorCreateInstallmentPage(driver);
		this.createCoursePage = new TutorCreateCoursePage(driver);
		this.addContentPage = new TutorAddContentPage(driver);
		this.storeCommonFunctions = new CommonFunctionStoreTest();

		createdCourseName = this.storeCommonFunctions.createSimpleCourseWithoutInternetCharges(this.createCoursePage);
		this.storeCommonFunctions.addCourseContent(addContentPage, testDataProp.getProperty(LABEL_FOR_UPLOADING_IMAGE));
		String toastMsgText1 = this.addContentPage.getSuccessImageMessageText();
		Assert.assertEquals(toastMsgText1, expectedAssertionsProp.getProperty(IMAGE_ADDED_SUCCESSFULLY_TEXT));
		this.storeCommonFunctions.publishCourse(createCoursePage);

		logger.info("Ending of initClassplusSiteLogin method");
	}

	@Test(priority = 1, description = "Verify creating BiWeekly installment")
	@Description("Test Description: Verify creating BiWeekly installment")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Verify creating BiWeekly installment")
	public void testCreateBiWeeklyInstallment() {
		logger.info("Starting of testCreateBiWeeklyInstallment method");

		try {
			this.tutorCreateInstallmentPage.clickOnStoreButton();
			this.driver.navigate().refresh();
			this.tutorCreateInstallmentPage.setSearch(createdCourseName);
			this.tutorCreateInstallmentPage.clickOnGetCourse(createdCourseName);
			this.tutorCreateInstallmentPage.closeInstallmentGotItPopup();
			this.tutorCreateInstallmentPage.clickOnCreateInstallment();

			// Assertion for checking the Create Installment label
			String lblCreateInstallment = this.tutorCreateInstallmentPage.getCreateInstallmentLabel();
			Assert.assertEquals(lblCreateInstallment, expectedAssertionsProp.getProperty(LABEL_CREATEINSTALLMENT));

			// Assertion for checking the Course Price label
			String lblCoursePrice = this.tutorCreateInstallmentPage.getCoursePriceLabel();
			Assert.assertEquals(lblCoursePrice,
					expectedAssertionsProp.getProperty(LABEL_CREATEINSTALLMENT_COURSE_PRICE));

			this.tutorCreateInstallmentPage.giveInstallments(testDataProp.getProperty(NUMBER_OF_INSTALLMENTS));

			// Assertion for checking the TotalInstallment label
			String lblTotalInstallment = this.tutorCreateInstallmentPage.getTotalInstallmentLabel();
			Assert.assertEquals(lblTotalInstallment,
					expectedAssertionsProp.getProperty(LABEL_CREATEINSTALLMENT_TOTAL_INSTALLMENTS));

			// this.tutorCreateInstallmentPage.selectInstallmentPeriod();

			// Assertion for checking the Effective Course Price label
			String lblEffectiveCoursePrice = this.tutorCreateInstallmentPage.getEffectiveCoursePriceLabel();
			Assert.assertEquals(lblEffectiveCoursePrice,
					expectedAssertionsProp.getProperty(LABEL_CREATEINSTALLMENT_EFFECTIVE_COURSE_PRICE));

			// Assertion for checking the Installment Period label
			String lblInstallmentPeriod = this.tutorCreateInstallmentPage.getInstallmentPeriodLabel();
			Assert.assertEquals(lblInstallmentPeriod,
					expectedAssertionsProp.getProperty(LABEL_CREATEINSTALLMENT_INSTALLMENT_PERIOD));

			this.tutorCreateInstallmentPage.clickOnInstallmentPeriodInput();
			this.tutorCreateInstallmentPage.selectBiWkly();
			this.tutorCreateInstallmentPage.clickOnCreateInstallmentButton();

			// Assertion for checking the Installment Details label
			String lblInstallmentDetails = this.tutorCreateInstallmentPage.getInstallmentDetailsLabel();
			Assert.assertEquals(lblInstallmentDetails,
					expectedAssertionsProp.getProperty(LABEL_CREATEINSTALLMENT_INSTALLMENTS_DETAILS));

			// Assertion for checking the Installment Effective Price label
			String lblInstallmentEffectivePrice = this.tutorCreateInstallmentPage.getInstallmentEffectivePriceLabel();
			Assert.assertEquals(lblInstallmentEffectivePrice,
					expectedAssertionsProp.getProperty(LABEL_CREATEINSTALLMENT_EFFECTIVE_PRICE));

			Boolean lblNumberOfInstallment = this.tutorCreateInstallmentPage.NumberOfInstallments();
			Assert.assertTrue(lblNumberOfInstallment);

			// Assertion for checking the Date Of Purchase label
			String lblDateOfPurchase = this.tutorCreateInstallmentPage.getDateOfPurchaseLabel();
			Assert.assertEquals(lblDateOfPurchase,
					expectedAssertionsProp.getProperty(LABEL_CREATEINSTALLMENT_DATE_OF_PURCHASE));

			// Assertion for checking the 2ndWeek label
			String lbl2ndWeek = this.tutorCreateInstallmentPage.get2ndWeekLabel();
			Assert.assertEquals(lbl2ndWeek, expectedAssertionsProp.getProperty(LABEL_CREATEINSTALLMENT_2ND_WEEK_LABEL));

			// Assertion for checking the 4rthWeeklabel
			String lbl4rthWeek = this.tutorCreateInstallmentPage.get4rthWeekLabel();
			Assert.assertEquals(lbl4rthWeek,
					expectedAssertionsProp.getProperty(LABEL_CREATEINSTALLMENT_4RTH_WEEK_LABEL));

			// Assertion for checking the 6thweek label
			String lbl6thweek = this.tutorCreateInstallmentPage.get6thweekLabel();
			Assert.assertEquals(lbl6thweek, expectedAssertionsProp.getProperty(LABEL_CREATEINSTALLMENT_6TH_WEEK_LABEL));

			// Assertion for checking the 4rthWeeklabel
			String lblMissedInstallments = this.tutorCreateInstallmentPage.getMissedInstallmentsLabel();
			Assert.assertEquals(lblMissedInstallments,
					expectedAssertionsProp.getProperty(LABEL_CREATEINSTALLMENT_MISSED_INSTALLMENTS));

			// Assertion for checking the 6thweek label
			String lblLoseCourseText = this.tutorCreateInstallmentPage.getLoseCourseTextLabel();
			Assert.assertEquals(lblLoseCourseText,
					expectedAssertionsProp.getProperty(LABEL_CREATEINSTALLMENT_LOSE_COURSE));

			this.tutorCreateInstallmentPage.clickOnSetInstallmentButton();

			String lblInstallmentsCreated = this.tutorCreateInstallmentPage.getInstallmentsCreatedLabel();
			Assert.assertEquals(lblInstallmentsCreated,
					expectedAssertionsProp.getProperty(LABEL_CREATEINSTALLMENT_INSTALLMENTS_CREATED));

			// Assertion for checking the Coupons Can't Assigned label
			String lblMultipleInstallmentsText = this.tutorCreateInstallmentPage.getMultipleInstallmentsText();
			Assert.assertEquals(lblMultipleInstallmentsText,
					expectedAssertionsProp.getProperty(LABEL_CREATEINSTALLMENT_MULTIPLE_INSTALLMENTS));

			this.tutorCreateInstallmentPage.clickOnDoneButton();
		} catch (Exception e) {
			Assert.fail("Exception occured while testing creating BiWeekly installment: " + e.getMessage());
			logger.error("Error occured while testing creating BiWeekly installment ", e);
		}

		logger.info("Ending of testCreateBiWeeklyInstallment method");
	}

	@Test(priority = 2, description = "Verify Edit details of BiWeekly installments")
	@Description("Test Description:Verify Edit details of BiWeekly installments")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verify Edit details of BiWeekly installments")
	public void testEditBiWeeklyInstallments() {
		logger.info("Starting of testEditBiWeeklyInstallments method");

		try {
			this.tutorCreateInstallmentPage.clickViewInstallmentsButton();

			// Assertion for checking the Installment label
			String lblInstallment = this.tutorCreateInstallmentPage.getInstallmentLabel();
			Assert.assertEquals(lblInstallment, expectedAssertionsProp.getProperty(LABEL_INSTALLMENT));

			Assert.assertTrue(this.tutorCreateInstallmentPage.isDisplayedDeleteIcon());

			/*
			 * // Assertion for checking the Installment label String
			 * lblStudentCanPayAmountInInstallment = this.tutorCreateInstallmentPage
			 * .getStudentCanPayAmountInInstallmentLabel();
			 * Assert.assertEquals(lblStudentCanPayAmountInInstallment,
			 * expectedAssertionsProp.getProperty(
			 * LABEL_INSTALLMENT_STUDENT_PAY_AMOUNT_INSTALLMENT));
			 */
			// Assertion for checking the Installment label
			String lblEditInstallment = this.tutorCreateInstallmentPage.getEditInstallmentText();
			Assert.assertEquals(lblEditInstallment,
					expectedAssertionsProp.getProperty(LABEL_INSTALLMENT_EDIT_INSTALLMENT_TEXT));

			this.tutorCreateInstallmentPage.clickEditInstallment();
			// this.tutorCreateInstallmentPage.givePriceOnField(testDataProp.getProperty(CREATE_INSTALLMENT_EDIT_PRICE));
			this.tutorCreateInstallmentPage
					.giveInstallment(testDataProp.getProperty(CRAETE_INSTALLMENT_EDIT_TOTALINSTALLMENT));
			this.tutorCreateInstallmentPage.selectInstallmentType();
			this.tutorCreateInstallmentPage.selectAsWeekly();
			this.tutorCreateInstallmentPage.clickOnSaveInstallmentButton();
			this.tutorCreateInstallmentPage.clickOnSaveInstallmentButton2();
			driver.navigate().refresh();

		} catch (Exception e) {
			logger.error("Error occured while testing  Edit details of BiWeekly installments ", e);
			Assert.fail("Exception occured while testing  Edit details of BiWeekly installments: " + e.getMessage());
		}

		logger.info("Ending of testEditBiWeeklyInstallments method");
	}

	@Test(priority = 3, description = "Verify delete BiWeekly installments")
	@Description("Test Description:Verify delete BiWeekly installments")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verify delete BiWeekly installments")

	public void testDeleteBiWeeklyInstallment() {
		logger.info("Starting of testDeleteBiWeeklyInstallment method");

		try {
			this.tutorCreateInstallmentPage.clickViewInstallmentsButton();
			this.tutorCreateInstallmentPage.clickOnDeleteIcon();

			// Assertion for checking the Delete Installment label
			String lblDelete = this.tutorCreateInstallmentPage.getDeleteInstallmentLabel();
			Assert.assertEquals(lblDelete, expectedAssertionsProp.getProperty(LABEL__INSTALMENT_DELETE));

			this.tutorCreateInstallmentPage.clickonYesDelete();

			// Assertion for checking the Delete Installment label
			String createInstallmentLabel = this.tutorCreateInstallmentPage.getCreateInstallmentText();
			Assert.assertEquals(createInstallmentLabel, expectedAssertionsProp.getProperty(LABEL_CREATE_INSTALMENT));

		} catch (Exception e) {
			logger.error("Error occured while testing delete BiWeekly installments ", e);
			Assert.fail("Exception occured while testing delete BiWeekly installments: " + e.getMessage());
		}

		logger.info("Ending of testDeleteBiWeeklyInstallment method");
	}

	@Test(priority = 4, description = "Verify creating Monthly installment")
	@Description("Test Description: Verify creating Monthly installment")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Verify creating Monthly installment")
	public void testCreateMonthlyInstallment() {
		logger.info("Starting of testCreateMonthlyInstallment method");

		try {
			// this.tutorCreateInstallmentPage.clickOnCourse();
			this.tutorCreateInstallmentPage.clickOnCreateInstallment();

			// String price = this.webelement.getAttribute(value);
			// String price = this.tutorCreateInstallmentPage.getPriceLabel();

			// Assertion for checking the Create Installment label
			String lblCreateInstallment = this.tutorCreateInstallmentPage.getCreateInstallmentLabel();
			Assert.assertEquals(lblCreateInstallment, expectedAssertionsProp.getProperty(LABEL_CREATEINSTALLMENT));

			// Assertion for checking the Course Price label
			String lblCoursePrice = this.tutorCreateInstallmentPage.getCoursePriceLabel();
			Assert.assertEquals(lblCoursePrice,
					expectedAssertionsProp.getProperty(LABEL_CREATEINSTALLMENT_COURSE_PRICE));

			this.tutorCreateInstallmentPage.giveInstallments(testDataProp.getProperty(NUMBER_OF_INSTALLMENTS));

			// String installmentAmount =
			// this.tutorCreateInstallmentPage.getInstallmentAmountLabel();

			// Assertion for checking the TotalInstallment label
			String lblTotalInstallment = this.tutorCreateInstallmentPage.getTotalInstallmentLabel();
			Assert.assertEquals(lblTotalInstallment,
					expectedAssertionsProp.getProperty(LABEL_CREATEINSTALLMENT_TOTAL_INSTALLMENTS));

			// this.tutorCreateInstallmentPage.selectInstallmentPeriod();

			// Assertion for checking the Effective Course Price label
			String lblEffectiveCoursePrice = this.tutorCreateInstallmentPage.getEffectiveCoursePriceLabel();
			Assert.assertEquals(lblEffectiveCoursePrice,
					expectedAssertionsProp.getProperty(LABEL_CREATEINSTALLMENT_EFFECTIVE_COURSE_PRICE));

			// Assertion for checking the Installment Period label
			String lblInstallmentPeriod = this.tutorCreateInstallmentPage.getInstallmentPeriodLabel();
			Assert.assertEquals(lblInstallmentPeriod,
					expectedAssertionsProp.getProperty(LABEL_CREATEINSTALLMENT_INSTALLMENT_PERIOD));

			this.tutorCreateInstallmentPage.selectAsMonthly();
			// this.tutorCreateInstallmentPage.clickOnCreateInstallmentButton();

//			Boolean lblInstallmentPrices = this.tutorCreateInstallmentPage.setMonthlyInstallmentPrice(
//					testDataProp.getProperty(CREATE_INSTALLMENT_COURSE_PRICE),
//					testDataProp.getProperty(NUMBER_OF_INSTALLMENTS));
//			Assert.assertTrue(lblInstallmentPrices);

			this.tutorCreateInstallmentPage.clickOnCreateInstallmentButton();

			// Assertion for checking the Installment Details label
			String lblInstallmentDetails = this.tutorCreateInstallmentPage.getInstallmentDetailsLabel();
			Assert.assertEquals(lblInstallmentDetails,
					expectedAssertionsProp.getProperty(LABEL_CREATEINSTALLMENT_INSTALLMENTS_DETAILS));

			Boolean lblNumberOfInstallment = this.tutorCreateInstallmentPage.NumberOfInstallments();
			Assert.assertTrue(lblNumberOfInstallment);

			// Assertion for checking the Date Of Purchase label
			String lblDateOfPurchase = this.tutorCreateInstallmentPage.getDateOfPurchaseLabel();
			Assert.assertEquals(lblDateOfPurchase,
					expectedAssertionsProp.getProperty(LABEL_CREATEINSTALLMENT_DATE_OF_PURCHASE));

			// Assertion for checking the 1st month label
			String lbl1stMonth = this.tutorCreateInstallmentPage.get1MonthLabel();
			Assert.assertEquals(lbl1stMonth,
					expectedAssertionsProp.getProperty(LABEL_CREATEINSTALLMENT_1ST_MONTH_LABEL));

			String price = this.tutorCreateInstallmentPage.getPriceLabel();

			this.tutorCreateInstallmentPage.setMonthlyInstallmentPrice(price,
					testDataProp.getProperty(NUMBER_OF_INSTALLMENTS));

			// Assertion for checking the 2nd month label
			String lbl2ndMonth = this.tutorCreateInstallmentPage.get2ndMonthLabel();
			Assert.assertEquals(lbl2ndMonth,
					expectedAssertionsProp.getProperty(LABEL_CREATEINSTALLMENT_2ND_MONTH_LABEL));

			// Assertion for checking the 3rd month label
			String lbl3rdMonth = this.tutorCreateInstallmentPage.get3rdMonthLabel();
			Assert.assertEquals(lbl3rdMonth,
					expectedAssertionsProp.getProperty(LABEL_CREATEINSTALLMENT_3RD_MONTH_LABEL));

			// Assertion for checking the 4rth month label
			String lbl4thMonth = this.tutorCreateInstallmentPage.get4rthMonthLabel();
			Assert.assertEquals(lbl4thMonth,
					expectedAssertionsProp.getProperty(LABEL_CREATEINSTALLMENT_4TH_MONTH_LABEL));

			// Assertion for checking the 5th month label
			String lbl5thMonth = this.tutorCreateInstallmentPage.get5thMonthLabel();
			Assert.assertEquals(lbl5thMonth,
					expectedAssertionsProp.getProperty(LABEL_CREATEINSTALLMENT_5TH_MONTH_LABEL));

			// Assertion for checking the 6th month label
			String lbl6thMonth = this.tutorCreateInstallmentPage.get6thMonthLabel();
			Assert.assertEquals(lbl6thMonth,
					expectedAssertionsProp.getProperty(LABEL_CREATEINSTALLMENT_6TH_MONTH_LABEL));

			// Assertion for checking the 7th month label
			String lbl7thMonth = this.tutorCreateInstallmentPage.get7thMonthLabel();
			Assert.assertEquals(lbl7thMonth,
					expectedAssertionsProp.getProperty(LABEL_CREATEINSTALLMENT_7TH_MONTH_LABEL));

			// Assertion for checking the 8th month label
			String lbl8thMonth = this.tutorCreateInstallmentPage.get8thMonthLabel();
			Assert.assertEquals(lbl8thMonth,
					expectedAssertionsProp.getProperty(LABEL_CREATEINSTALLMENT_8TH_MONTH_LABEL));

			// Assertion for checking the 9th month label
			String lbl9thMonth = this.tutorCreateInstallmentPage.get9thMonthLabel();
			Assert.assertEquals(lbl9thMonth,
					expectedAssertionsProp.getProperty(LABEL_CREATEINSTALLMENT_9TH_MONTH_LABEL));

			// Assertion for checking the 10th month label
			String lbl10thMonth = this.tutorCreateInstallmentPage.get10thMonthLabel();
			Assert.assertEquals(lbl10thMonth,
					expectedAssertionsProp.getProperty(LABEL_CREATEINSTALLMENT_10TH_MONTH_LABEL));

			// Assertion for checking the 11th month label
			String lbl11thMonth = this.tutorCreateInstallmentPage.get11thMonthLabel();
			Assert.assertEquals(lbl11thMonth,
					expectedAssertionsProp.getProperty(LABEL_CREATEINSTALLMENT_11TH_MONTH_LABEL));

			// Assertion for checking the Important Information label
			String lblImportantInformation = this.tutorCreateInstallmentPage.getImportantInformationLabel();
			Assert.assertEquals(lblImportantInformation,
					expectedAssertionsProp.getProperty(LABEL_CREATEINSTALLMENT_IMPORTANT_INFORMATION));

			// Assertion for checking the Missed Installments label
			String lblMissedInstallments = this.tutorCreateInstallmentPage.getMissedInstallmentsLabel();
			Assert.assertEquals(lblMissedInstallments,
					expectedAssertionsProp.getProperty(LABEL_CREATEINSTALLMENT_MISSED_INSTALLMENTS));

			// Assertion for checking the Lose Course Text
			String lblLoseCourseText = this.tutorCreateInstallmentPage.getLoseCourseTextLabel();
			Assert.assertEquals(lblLoseCourseText,
					expectedAssertionsProp.getProperty(LABEL_CREATEINSTALLMENT_LOSE_COURSE));

			this.tutorCreateInstallmentPage.clickOnSetInstallmentButton();

			// Assertion for checking the Installments Created label
			String lblInstallmentsCreated = this.tutorCreateInstallmentPage.getInstallmentsCreatedLabel();
			Assert.assertEquals(lblInstallmentsCreated,
					expectedAssertionsProp.getProperty(LABEL_CREATEINSTALLMENT_INSTALLMENTS_CREATED));

			// Assertion for checking the Multiple Installments label
			String lblMultipleInstallmentsText = this.tutorCreateInstallmentPage.getMultipleInstallmentsText();
			Assert.assertEquals(lblMultipleInstallmentsText,
					expectedAssertionsProp.getProperty(LABEL_CREATEINSTALLMENT_MULTIPLE_INSTALLMENTS));

			this.tutorCreateInstallmentPage.clickOnDoneButton();
		} catch (Exception e) {
			Assert.fail("Exception occured while testing creating Monthly installment: " + e.getMessage());
			logger.error("Error occured while testing creating Monthly installment ", e);
		}

		logger.info("Ending of testCreateMonthlyInstallment method");
	}

	@Test(priority = 5, description = "Verify Edit Monthly installments")
	@Description("Test Description:Verify Edit Monthly installments")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verify Edit Monthly installments")
	public void testEditMonthlyInstallments() {
		logger.info("Starting of testEditMonthlyInstallments method");

		try {
			this.tutorCreateInstallmentPage.clickViewInstallmentsButton();

			// Assertion for checking the Installment label
			String lblInstallment = this.tutorCreateInstallmentPage.getInstallmentLabel();
			Assert.assertEquals(lblInstallment, expectedAssertionsProp.getProperty(LABEL_INSTALLMENT));

			// Assertion for checking the Installment label
			String lblEditInstallment = this.tutorCreateInstallmentPage.getEditInstallmentText();
			Assert.assertEquals(lblEditInstallment,
					expectedAssertionsProp.getProperty(LABEL_INSTALLMENT_EDIT_INSTALLMENT_TEXT));

			this.tutorCreateInstallmentPage.clickEditInstallment();
			// this.tutorCreateInstallmentPage.givePriceOnField(testDataProp.getProperty(CREATE_INSTALLMENT_EDIT_PRICE));
			this.tutorCreateInstallmentPage
					.giveInstallment(testDataProp.getProperty(CRAETE_INSTALLMENT_EDIT_TOTALINSTALLMENT));
			this.tutorCreateInstallmentPage.selectInstallmentType();
			this.tutorCreateInstallmentPage.clickOnEveryTwoMonthsButton();
			// this.tutorCreateInstallmentPage.clickOnCreateInstallmentButton();

//			 String price = this.tutorCreateInstallmentPage.getPriceLabel();
//
//			 Boolean lblInstallmentPrices =	this.tutorCreateInstallmentPage.setMonthlyInstallmentPrice(price,
//						testDataProp.getProperty(NUMBER_OF_INSTALLMENTS));
//			 		 
			Boolean lblInstallmentPrices = this.tutorCreateInstallmentPage.setMonthlyInstallmentPrice(
					testDataProp.getProperty(CREATE_INSTALLMENT_COURSE_PRICE),
					testDataProp.getProperty(NUMBER_OF_INSTALLMENTS));
			// Assert.assertTrue(lblInstallmentPrices);

			Boolean lblNumberOfInstallment = this.tutorCreateInstallmentPage.NumberOfInstallments();
			Assert.assertTrue(lblNumberOfInstallment);

			// Assertion for checking the Date Of Purchase label
			String lblDateOfPurchase = this.tutorCreateInstallmentPage.getDateOfPurchaseLabel();
			Assert.assertEquals(lblDateOfPurchase,
					expectedAssertionsProp.getProperty(LABEL_CREATEINSTALLMENT_DATE_OF_PURCHASE));

			// Assertion for checking the 2nd month label
			String lbl2ndMonth = this.tutorCreateInstallmentPage.get2ndMonthLabel();
			Assert.assertEquals(lbl2ndMonth,
					expectedAssertionsProp.getProperty(LABEL_CREATEINSTALLMENT_2ND_MONTH_LABEL));

			// Assertion for checking the 4rth month label
			String lbl4thMonth = this.tutorCreateInstallmentPage.get4rthMonthLabel();
			Assert.assertEquals(lbl4thMonth,
					expectedAssertionsProp.getProperty(LABEL_CREATEINSTALLMENT_4TH_MONTH_LABEL));

			// Assertion for checking the 6th month label
			String lbl6thMonth = this.tutorCreateInstallmentPage.get6thMonthLabel();
			Assert.assertEquals(lbl6thMonth,
					expectedAssertionsProp.getProperty(LABEL_CREATEINSTALLMENT_6TH_MONTH_LABEL));

			// Assertion for checking the 8th month label
			String lbl8thMonth = this.tutorCreateInstallmentPage.get8thMonthLabel();
			Assert.assertEquals(lbl8thMonth,
					expectedAssertionsProp.getProperty(LABEL_CREATEINSTALLMENT_8TH_MONTH_LABEL));

			// Assertion for checking the 10th month label
			String lbl10thMonth = this.tutorCreateInstallmentPage.get10thMonthLabel();
			Assert.assertEquals(lbl10thMonth,
					expectedAssertionsProp.getProperty(LABEL_CREATEINSTALLMENT_10TH_MONTH_LABEL));

			// Assertion for checking the 12th month label
			String lbl12thMonth = this.tutorCreateInstallmentPage.get12thMonthLabel();
			Assert.assertEquals(lbl12thMonth,
					expectedAssertionsProp.getProperty(LABEL_CREATEINSTALLMENT_12TH_MONTH_LABEL));

			// Assertion for checking the 14th month label
			String lbl14thMonth = this.tutorCreateInstallmentPage.get14thMonthLabel();
			Assert.assertEquals(lbl14thMonth,
					expectedAssertionsProp.getProperty(LABEL_CREATEINSTALLMENT_14TH_MONTH_LABEL));

			this.tutorCreateInstallmentPage.clickOnSaveInstallmentButton();
			this.tutorCreateInstallmentPage.clickOnSaveInstallmentButton2();

		} catch (Exception e) {
			logger.error("Error occured while testing  Edit Monthly installments ", e);
			Assert.fail("Exception occured while testing  Edit Monthly installments: " + e.getMessage());
		}

		logger.info("Ending of testEditMonthlyInstallments method");
	}

	@Test(priority = 6, description = "Verify delete Monthly installments")
	@Description("Test Description:Verify delete Monthly installments")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verify delete Monthly installments")
	public void testDeleteMonthlyInstallment() {
		logger.info("Starting of testDeleteMonthlyInstallment method");

		try {
			this.tutorCreateInstallmentPage.clickViewInstallmentsButton();
			this.tutorCreateInstallmentPage.clickOnDeleteIcon();

			// Assertion for checking the Delete Installment label
			String lblDelete = this.tutorCreateInstallmentPage.getDeleteInstallmentLabel();
			Assert.assertEquals(lblDelete, expectedAssertionsProp.getProperty(LABEL__INSTALMENT_DELETE));

			this.tutorCreateInstallmentPage.clickonYesDelete();

			// Assertion for checking the Delete Installment label
			String createInstallmentLabel = this.tutorCreateInstallmentPage.getCreateInstallmentText();
			Assert.assertEquals(createInstallmentLabel, expectedAssertionsProp.getProperty(LABEL_CREATE_INSTALMENT));

		} catch (Exception e) {
			logger.error("Error occured while testing delete Monthly installments ", e);
			Assert.fail("Exception occured while testing delete Monthly installments: " + e.getMessage());
		}

		logger.info("Ending of testDeleteMonthlyInstallment method");
	}

	@Test(priority = 7, description = "Verify Creating Every Three Months installments")
	@Description("Test Description:Verify Creating Every Three Months installments")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verify Creating Every Three Months installments")
	public void testCreateEveryThreeMonthsInstallments() {
		logger.info("Starting of testCreateEveryThreeMonthsInstallments method");

		try {
			// this.tutorCreateInstallmentPage.clickOnCourse();
			this.tutorCreateInstallmentPage.clickOnCreateInstallment();

			// Assertion for checking the Create Installment label
			String lblCreateInstallment = this.tutorCreateInstallmentPage.getCreateInstallmentLabel();
			Assert.assertEquals(lblCreateInstallment, expectedAssertionsProp.getProperty(LABEL_CREATEINSTALLMENT));

			// Assertion for checking the Course Price label
			String lblCoursePrice = this.tutorCreateInstallmentPage.getCoursePriceLabel();
			Assert.assertEquals(lblCoursePrice,
					expectedAssertionsProp.getProperty(LABEL_CREATEINSTALLMENT_COURSE_PRICE));

			this.tutorCreateInstallmentPage.giveInstallments(testDataProp.getProperty(NUMBER_OF_INSTALLMENTS));
			this.tutorCreateInstallmentPage.selectInstallmentType();
			this.tutorCreateInstallmentPage.clickOnEveryThreeMonthsButton();
			this.tutorCreateInstallmentPage.clickOnCreateInstallmentButton();
//			String price = this.tutorCreateInstallmentPage.getPriceLabel();
//
//			 Boolean lblInstallmentPrices =	this.tutorCreateInstallmentPage.setMonthlyInstallmentPrice(price,
//						testDataProp.getProperty(NUMBER_OF_INSTALLMENTS));
//			Boolean lblInstallmentPrices = this.tutorCreateInstallmentPage.setMonthlyInstallmentPrice(
//					testDataProp.getProperty(CREATE_INSTALLMENT_COURSE_PRICE),
//					testDataProp.getProperty(NUMBER_OF_INSTALLMENTS));
			// Assert.assertTrue(lblInstallmentPrices);

			Boolean lblNumberOfInstallment = this.tutorCreateInstallmentPage.NumberOfInstallments();
			Assert.assertTrue(lblNumberOfInstallment);

			this.tutorCreateInstallmentPage.clickOnSetInstallmentButton();

			// Assertion for checking the Installments created label
			String lblInstallmentsCreated = this.tutorCreateInstallmentPage.getInstallmentsCreatedLabel();
			Assert.assertEquals(lblInstallmentsCreated,
					expectedAssertionsProp.getProperty(LABEL_CREATEINSTALLMENT_INSTALLMENTS_CREATED));

			// Assertion for checking the Coupons Can't Assigned label
			String lblMultipleInstallmentsText = this.tutorCreateInstallmentPage.getMultipleInstallmentsText();
			Assert.assertEquals(lblMultipleInstallmentsText,
					expectedAssertionsProp.getProperty(LABEL_CREATEINSTALLMENT_MULTIPLE_INSTALLMENTS));

			this.tutorCreateInstallmentPage.clickOnDoneButton();

		} catch (Exception e) {

			logger.error("Error occured while testing  Creating Every Three Months installments ", e);
			Assert.fail("Exception occured while testing  Creating Every Three Months installments: " + e.getMessage());
		}

		logger.info("Ending of testCreateEveryThreeMonthsInstallments method");
	}

	@Test(priority = 8, description = "Verify Edit Every Three Months  installments")
	@Description("Test Description:Verify Edit Every Three Months installments")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verify Edit Every Three Months installments")
	public void testEditEveryThreeMonthsInstallment() {
		logger.info("Starting of testEditMonthlyInstallments method");

		try {
			this.tutorCreateInstallmentPage.clickViewInstallmentsButton();

			// Assertion for checking the Installment label
			String lblInstallment = this.tutorCreateInstallmentPage.getInstallmentLabel();
			Assert.assertEquals(lblInstallment, expectedAssertionsProp.getProperty(LABEL_INSTALLMENT));

			// Assertion for checking the Installment label
			String lblEditInstallment = this.tutorCreateInstallmentPage.getEditInstallmentText();
			Assert.assertEquals(lblEditInstallment,
					expectedAssertionsProp.getProperty(LABEL_INSTALLMENT_EDIT_INSTALLMENT_TEXT));

			this.tutorCreateInstallmentPage.clickEditInstallment();
			// this.tutorCreateInstallmentPage.givePriceOnField(testDataProp.getProperty(CREATE_INSTALLMENT_EDIT_PRICE));
			// this.tutorCreateInstallmentPage
			// .giveInstallment(testDataProp.getProperty(CRAETE_INSTALLMENT_EDIT_TOTALINSTALLMENT));
			this.tutorCreateInstallmentPage.selectInstallmentType();
			this.tutorCreateInstallmentPage.clickOnEverysixMonthsButton();

			// this.tutorCreateInstallmentPage.clickOnCreateInstallmentButton();

//			String price = this.tutorCreateInstallmentPage.getPriceLabel();
//
//			 Boolean lblInstallmentPrices =	this.tutorCreateInstallmentPage.setMonthlyInstallmentPrice(price,
//						testDataProp.getProperty(NUMBER_OF_INSTALLMENTS));
////			Boolean lblInstallmentPrice = this.tutorCreateInstallmentPage.setMonthlyInstallmentPrice(
////					testDataProp.getProperty(CREATE_INSTALLMENT_COURSE_PRICE),
////					testDataProp.getProperty(NUMBER_OF_INSTALLMENTS));
//			Assert.assertTrue(lblInstallmentPrices);

			Boolean lblNumberOfInstallment = this.tutorCreateInstallmentPage.NumberOfInstallments();
			Assert.assertTrue(lblNumberOfInstallment);

			// Assertion for checking the 1stInstallment label
			String lbl1stInstallment = this.tutorCreateInstallmentPage.get1stInstallmentLabel();
			Assert.assertEquals(lbl1stInstallment,
					expectedAssertionsProp.getProperty(LABEL_CREATEINSTALLMENT_1ST_INSTALLMENT));

			// Assertion for checking the Date Of Purchase label
			String lblDateOfPurchase = this.tutorCreateInstallmentPage.getDateOfPurchaseLabel();
			Assert.assertEquals(lblDateOfPurchase,
					expectedAssertionsProp.getProperty(LABEL_CREATEINSTALLMENT_DATE_OF_PURCHASE));

			// Assertion for checking the 6th month label
			String lbl6thMonth = this.tutorCreateInstallmentPage.get6thMonthLabel();
			Assert.assertEquals(lbl6thMonth,
					expectedAssertionsProp.getProperty(LABEL_CREATEINSTALLMENT_6TH_MONTH_LABEL));

			String price = this.tutorCreateInstallmentPage.getPriceLabel();

			this.tutorCreateInstallmentPage.setMonthlyInstallmentPrice(price,
					testDataProp.getProperty(NUMBER_OF_INSTALLMENTS));

			// Assertion for checking the 12th month label
			String lbl12thMonth = this.tutorCreateInstallmentPage.get12thMonthLabel();
			Assert.assertEquals(lbl12thMonth,
					expectedAssertionsProp.getProperty(LABEL_CREATEINSTALLMENT_12TH_MONTH_LABEL));

			// Assertion for checking the 18th month label
			String lbleighteenthMonth = this.tutorCreateInstallmentPage.get18thMonthLabel();
			Assert.assertEquals(lbleighteenthMonth,
					expectedAssertionsProp.getProperty(LABEL_CREATEINSTALLMENT_18TH_MONTH_LABEL));

			// Assertion for checking the 24thMonth label
			String lbl24thInstallment = this.tutorCreateInstallmentPage.get24thMonthLabel();
			Assert.assertEquals(lbl24thInstallment,
					expectedAssertionsProp.getProperty(LABEL_CREATEINSTALLMENT_24TH_MONTH_LABEL));

			// Assertion for checking the 30thMonth label
			String lbl30thInstallment = this.tutorCreateInstallmentPage.get30thMonthLabel();
			Assert.assertEquals(lbl30thInstallment,
					expectedAssertionsProp.getProperty(LABEL_CREATEINSTALLMENT_30TH_MONTH_LABEL));

			// Assertion for checking the 36thMonth label
			String lbl36thInstallment = this.tutorCreateInstallmentPage.get36thMonthLabel();
			Assert.assertEquals(lbl36thInstallment,
					expectedAssertionsProp.getProperty(LABEL_CREATEINSTALLMENT_36TH_MONTH_LABEL));

			// Assertion for checking the 42nd Month label
			String lbl42ndInstallment = this.tutorCreateInstallmentPage.get42ndMonthLabel();
			Assert.assertEquals(lbl42ndInstallment,
					expectedAssertionsProp.getProperty(LABEL_CREATEINSTALLMENT_42ND_MONTH_LABEL));

			String lbl48ndInstallment = this.tutorCreateInstallmentPage.get48ndMonthLabel();
			Assert.assertEquals(lbl48ndInstallment,
					expectedAssertionsProp.getProperty(LABEL_CREATEINSTALLMENT_48TH_MONTH_LABEL));

			String lbl54ndInstallment = this.tutorCreateInstallmentPage.get54ndMonthLabel();
			Assert.assertEquals(lbl54ndInstallment,
					expectedAssertionsProp.getProperty(LABEL_CREATEINSTALLMENT_54TH_MONTH_LABEL));

			String lbl60ndInstallment = this.tutorCreateInstallmentPage.get60ndMonthLabel();
			Assert.assertEquals(lbl60ndInstallment,
					expectedAssertionsProp.getProperty(LABEL_CREATEINSTALLMENT_60TH_MONTH_LABEL));

			String lbl66ndInstallment = this.tutorCreateInstallmentPage.get66ndMonthLabel();
			Assert.assertEquals(lbl66ndInstallment,
					expectedAssertionsProp.getProperty(LABEL_CREATEINSTALLMENT_66TH_MONTH_LABEL));

			this.tutorCreateInstallmentPage.clickOnSaveInstallmentButton();
			this.tutorCreateInstallmentPage.clickOnSaveInstallmentButton2();

		} catch (Exception e) {

			logger.error("Error occured while testing Edit Every Three Months installments ", e);
			Assert.fail("Exception occured while testing  Edit Every Three Months installments: " + e.getMessage());
		}

		logger.info("Ending of testCreateEveryThreeMonthsInstallments method");
	}

	@Test(priority = 9, description = "Verify delete Every Six Months installments")
	@Description("Test Description:Verify delete Every Six Months installments")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verify delete Every Six Months installments")
	public void testDeleteEverySixMonthsInstallment() {
		logger.info("Starting of testDeleteMonthlyInstallment method");

		try {
			this.tutorCreateInstallmentPage.clickViewInstallmentsButton();
			this.tutorCreateInstallmentPage.clickOnDeleteIcon();

			// Assertion for checking the Delete Installment label
			String lblDelete = this.tutorCreateInstallmentPage.getDeleteInstallmentLabel();
			Assert.assertEquals(lblDelete, expectedAssertionsProp.getProperty(LABEL__INSTALMENT_DELETE));

			this.tutorCreateInstallmentPage.clickonYesDelete();

			// Assertion for checking the Delete Installment label
			String createInstallmentLabel = this.tutorCreateInstallmentPage.getCreateInstallmentText();
			Assert.assertEquals(createInstallmentLabel, expectedAssertionsProp.getProperty(LABEL_CREATE_INSTALMENT));

		} catch (Exception e) {
			logger.error("Error occured while testing delete  Every Six Months installments ", e);
			Assert.fail("Exception occured while testing delete Every Six Months installments: " + e.getMessage());
		}

		logger.info("Ending of testDeleteMonthlyInstallment method");
	}

	@AfterClass
	public void quitDriver() {
		logger.info("Starting of quitDriver method");

		try {
			if (driver != null) {
				Thread.sleep(5000);
				this.loginPage.clickOnLogOut();
				this.quitDriver(this.driver, WEB_DRIVER.CREATE_INSTALLMENT_TEST);
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