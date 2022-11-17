package com.classplusapp.web.tests.tutor;

import static com.classplusapp.store.util.Constants.INSTALLMENT_PERIOD_LIST;
import static com.classplusapp.store.util.Constants.LABEL_STORE_OVERVIEW;
import static com.classplusapp.store.util.Constants.MESSAGE_EDIT_SUCCESSFULL;
import static com.classplusapp.store.util.Constants.MESSAGE_INTRODUCING_INSTALLMENT;
import static com.classplusapp.store.util.Constants.MESSAGE_MAX12_INSTALMENT;
import static com.classplusapp.store.util.Constants.MESSAGE_ZERO_INSTALMENT;
import static com.classplusapp.store.util.Constants.NUMBER_OF_INSTALLMENTS;
import static com.classplusapp.store.util.Constants.NUMBER_OF_TOTAL_INSTALLMENTS;
import static com.classplusapp.store.util.Constants.NUMBER_OF_ZERO_INSTALLMENTS;
import static com.classplusapp.store.util.Constants.SET_EDIT_FIRST_INSTALLMENT;
import static com.classplusapp.store.util.Constants.SET_EDIT_INSTALLMENT;
import static com.classplusapp.store.util.Constants.TUTOR_DELETE_COURSE;
import static com.classplusapp.store.util.Constants.*;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.classplusapp.web.pages.student.StudentPayInstallmentCoursePage;
import com.classplusapp.web.pages.tutor.TutorContentMarketPage;
import com.classplusapp.web.pages.tutor.TutorCreateCoursePage;
import com.classplusapp.web.pages.tutor.TutorCreateInstallmentPage;
import com.classplusapp.web.pages.tutor.TutorEditCoursePage;
import com.classplusapp.web.pages.tutor.TutorPayInInstallmentPage;
import com.classplusapp.web.pages.tutor.TutorStudentSortingPage;
import com.classplusapp.web.tests.CommonFunctionStoreTest;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Epic("Store PayInInstallment")
@Feature("Pay in Installments Test")
public class TutorPayInInstallmentTest extends CommonFunctionStoreTest {

	private WebDriver driver = null;
	private TutorPayInInstallmentPage tutorPayInInstallmentPage = null;
	private TutorCreateCoursePage createCoursePage = null;
	private TutorCreateInstallmentPage tutorCreateInstallmentPage = null;
	private TutorStudentSortingPage tutorStudentSortingPage = null;
	private StudentPayInstallmentCoursePage studentPayInstallmentCoursePage = null;
	private TutorContentMarketPage tutorContentMarketPage = null;
	private TutorEditCoursePage tutorEditCoursePage;

	private static final Logger logger = Logger.getLogger(TutorPayInInstallmentTest.class.getName());

	@BeforeClass
	@Parameters({ "browser", "orgCode" })
	public void initClassplusSiteLogin(@Optional("Chrome")String browser, @Optional("learn")String orgCode)
			throws Exception {
		logger.info("Starting of initClassplusSiteLogin methond");

		this.driver = super.loginClassPlusSite(browser, orgCode, tutorMobileNumber, emailAddress,
				WEB_DRIVER.PAYIN_INSTALLMENT_TEST);

		this.tutorPayInInstallmentPage = new TutorPayInInstallmentPage(driver);
		this.createCoursePage = new TutorCreateCoursePage(this.driver);
		this.tutorCreateInstallmentPage = new TutorCreateInstallmentPage(this.driver);
		this.tutorStudentSortingPage = new TutorStudentSortingPage(this.driver);
		this.studentPayInstallmentCoursePage = new StudentPayInstallmentCoursePage(driver);
		this.tutorContentMarketPage = new TutorContentMarketPage(driver);
		this.tutorEditCoursePage = new TutorEditCoursePage(driver);

		logger.info("Ending of initClassplusSiteLogin method");
	}

	@Test(priority = 1, description = "Verify Pop up information message will display or not, when tutor keeps coursor on Create instalment button")
	@Description("Test Description: Verify Pop up information message will display or not, when tutor keeps coursor on Create instalment button")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Verify Create Installment Information")
	public void testCreateInstallmentInformation() {
		logger.info("Starting of testCreateInstallmentInformation method");

		try {
			this.hardWait(2);
			super.createTutorPaymentCourse(createCoursePage);
			this.hardWait(2);
			this.tutorPayInInstallmentPage.clickOnOverviewButton();
			this.hardWait(2);

			Assert.assertEquals(this.tutorPayInInstallmentPage.getMessageInformation(),
					expectedAssertionsProp.getProperty(MESSAGE_INTRODUCING_INSTALLMENT));

			Assert.assertTrue(this.tutorPayInInstallmentPage.isDisplayedGotItPopup());

			this.tutorPayInInstallmentPage.closeInstallmentGotItPopup();

			Assert.assertFalse(this.tutorPayInInstallmentPage.isDisplayedGotItPopup());

			Assert.assertEquals(this.tutorStudentSortingPage.getOverViewLabelText(),
					expectedAssertionsProp.getProperty(LABEL_STORE_OVERVIEW));

		} catch (Exception e) {
			Assert.fail(
					"Exception occured while testing Pop up information message will display or not, when tutor keeps coursor on Create instalment button.: "
							+ e.getMessage());
			logger.error(
					"Error occured while testing Pop up information message will display or not, when tutor keeps coursor on Create instalment button. ",
					e);
		}

		logger.info("Ending of testCreateInstallmentInformation method");
	}

	@Test(priority = 2, description = "Verify Current course price will be auto-fetched & tutor can edit it or not, In Create installment page")
	@Description("Test Description:Verify Current course price will be auto-fetched & tutor can edit it or not, In Create installment page")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Verify edit Installment")
	public void testEditInstallment() {
		logger.info("Starting of testEditInstallment method");

		try {
			this.tutorPayInInstallmentPage.clickOnCreateInstallment();

			Assert.assertFalse(this.tutorPayInInstallmentPage.isDisabledInstallmentPeriodLabel());

			this.tutorPayInInstallmentPage.giveInstallments(testDataProp.getProperty(NUMBER_OF_INSTALLMENTS));

			Assert.assertTrue(this.tutorPayInInstallmentPage.isDisabledInstallmentPeriodLabel());

			this.tutorPayInInstallmentPage.clickOnInstallmentPeriodInput();
			this.tutorPayInInstallmentPage.selectBiWeekly();
			this.tutorPayInInstallmentPage.clickOnCreateInstallmentButton();

			Boolean lblNumberOfInstallment = this.tutorPayInInstallmentPage.numberOfInstallments();
			Assert.assertTrue(lblNumberOfInstallment);

			this.tutorPayInInstallmentPage.clickOnSetInstallmentButton();
			this.tutorPayInInstallmentPage.clickOnDoneButton();
			super.editCourseInstallments(tutorCreateInstallmentPage);

			// Assertion for checking the edit successfull label
			Assert.assertEquals(this.tutorPayInInstallmentPage.getEditSuccessfullMessage(),
					expectedAssertionsProp.getProperty(MESSAGE_EDIT_SUCCESSFULL));

			super.editCourseWithMaxInstallments(tutorCreateInstallmentPage);
			this.hardWait(4);

			// Assertion for checking the error maximum Installment label
			Assert.assertEquals(this.tutorPayInInstallmentPage.getErrorMaxInstallmentsMessage(),
					expectedAssertionsProp.getProperty(MESSAGE_MAX12_INSTALMENT));

			this.tutorPayInInstallmentPage.clickOnCloseButton();

		} catch (Exception e) {
			Assert.fail(
					"Exception occured while testing Current course price will be auto-fetched & tutor can edit it or not, In Create installment page: "
							+ e.getMessage());
			logger.error(
					"Error occured while testing Current course price will be auto-fetched & tutor can edit it or not, In Create installment page",
					e);
		}

		logger.info("Ending of testEditInstallment method");
	}

	@Test(priority = 3, description = "Verify According elegibility criteria Options in Instalment Period dropdown will enable & rest of will be disabledor")
	@Description("Test Description:Verify  According elegibility criteria Options in Instalment Period dropdown will enable & rest of will be disabled")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Verify Installment Period")
	public void testInstallmentPeriod() {
		logger.info("Starting of testInstallmentPeriod method");

		try {
			this.hardWait(2);
			super.testInstallmentsPeriod(tutorCreateInstallmentPage);
			this.hardWait(2);

			// Assertion for checking the monthly period Installment label
//			Assert.assertEquals(this.tutorPayInInstallmentPage.getMonthlyPeriodLabel(),
//					expectedAssertionsProp.getProperty(MESSAGE_MONTHLY_PERIOD));

			Assert.assertEquals(this.tutorPayInInstallmentPage.getInstallmentPeriodList(),
					this.getPropertyList(testDataProp.getProperty(INSTALLMENT_PERIOD_LIST)));

//			Assert.assertTrue(this.tutorPayInInstallmentPage.getInstallmentPeriodOptions());

			// Assert.assertTrue(this.tutorPayInInstallmentPage.getInstallmentPeriodEnableOptions());

			Assert.assertFalse(this.tutorPayInInstallmentPage.getInstallmentPeriod());

			this.tutorPayInInstallmentPage.clickOnCloseButton();

		} catch (Exception e) {

			Assert.fail(
					"Exception occured while testing  According elegibility criteria Options in Instalment Period dropdown will enable & rest of will be disabled: "
							+ e.getMessage());

			logger.error(
					"Error occured while testing  According elegibility criteria Options in Instalment Period dropdown will enable & rest of will be disabled",
					e);
		}

		logger.info("Ending of testInstallmentPeriod method");
	}

	@Test(priority = 4, description = "Verify tutor can edit installments amounts Except last installment")
	@Description("Test Description:Verify tutor can edit installments amounts Except last installment")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Verify edit Installment")
	public void testEditInstallmentExceptLastAmount() {
		logger.info("Starting of testEditInstallmentExceptLastAmount method");

		try {
			super.testInstallmentsPeriod(tutorCreateInstallmentPage);

			this.hardWait(2);
			this.tutorPayInInstallmentPage.setEditAmount(testDataProp.getProperty(SET_EDIT_INSTALLMENT));

			Assert.assertTrue(this.tutorPayInInstallmentPage.isEnabledLastInstallment());

			this.tutorPayInInstallmentPage.clickOnCloseButton();

		} catch (Exception e) {

			Assert.fail(
					"Exception occured while testing tutor can edit installments amounts Except last installment or not: "
							+ e.getMessage());

			logger.error(
					"Error occured while testing  tutor can edit installments amounts Except last installment or not",
					e);
		}

		logger.info("Ending of testEditInstallmentExceptLastAmount method");
	}

	@Test(priority = 5, description = "Verify On changing/editing any amount value, the later values will be equally splitted ")
	@Description("Test Description:Verify On changing/editing any amount value, the later values will be equally splitted")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Verify edit Installments splilled equally with amounts")
	public void testEditInstallmentSplittedWithEqualAmount() {
		logger.info("Starting of testEditInstallmentSplittedWithEqualAmount method");

		try {
			super.testInstallmentsPeriod(tutorCreateInstallmentPage);

			this.hardWait(2);
			Assert.assertTrue(tutorPayInInstallmentPage
					.setEqualEditAmounts(testDataProp.getProperty(SET_EDIT_FIRST_INSTALLMENT)));
			this.tutorPayInInstallmentPage.clickOnCloseButton();
			super.testDeleteInstallment(tutorCreateInstallmentPage);
		} catch (Exception e) {
			Assert.fail("Exception occured while testing tutor can edit installments amounts Except last installment: "
					+ e.getMessage());
			logger.error("Error occured while testing  tutor can edit installments amounts Except last installment", e);
		}

		logger.info("Ending of testEditInstallmentSplittedWithEqualAmount method");
	}

	@DataProvider(name = "setInstallments")
	public Object[][] setTotalInstallments() {

		return new Object[][] { { testDataProp.getProperty(NUMBER_OF_ZERO_INSTALLMENTS) },
				{ testDataProp.getProperty(NUMBER_OF_TOTAL_INSTALLMENTS) } };
	}

	@Test(priority = 6, description = "Verify Installment money, if entered zero validate error toaster", dataProvider = "setInstallments")
	@Description("Test Description:Verify Installment money, if entered zero validate error toaster")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Verify Installment Money")
	public void testInstallmentMoney(String priceInstallments) {
		logger.info("Starting of testInstallmentMoney method");

		try {

			this.tutorPayInInstallmentPage.clickOnCreateInstallment();
			// this.tutorPayInInstallmentPage.setCoursePriceInstallments(testDataProp.getProperty(NUMBER_OF_ZERO_INSTALLMENTS));

			this.tutorPayInInstallmentPage.setCoursePriceInstallments(priceInstallments);

			// Assertion for checking the error Zero Installment label
			Assert.assertEquals(this.tutorPayInInstallmentPage.getErrorZeroInstallmentsMessage(),
					expectedAssertionsProp.getProperty(MESSAGE_ZERO_INSTALMENT));

			this.tutorPayInInstallmentPage.clickOnCloseButton();

		} catch (Exception e) {
			Assert.fail("Exception occured while testing Installment money, if entered zero validate error toaster: "
					+ e.getMessage());
			logger.error("Error occured while testing Installment money, if entered zero validate error toaster", e);
		}

		logger.info("Ending of testInstallmentMoney method");
	}

	@Test(priority = 7, description = "Verify tutor can create Installment in course which has physical shipment")
	@Description("Test Description:Verify tutor can create Installment in course which has physical shipment")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verify Purchase Physical Shipment Course")
	public void testPhysicalShipmentCourse() {
		logger.info("Starting of testPurchasePhysicalShipmentCourse method");

		try {

			super.createPhysicalShipmentCourse(createCoursePage);

			this.createCoursePage.scrollDown(700);
			this.hardWait(2);

			this.studentPayInstallmentCoursePage.clickOnPhysicalShipmentToggle();
			this.studentPayInstallmentCoursePage.clickOnDeliveryDateCheckbox();

			createCoursePage.clickOnTermsAndConditionCheckBox();
			createCoursePage.clickOnAddContentButton();
			this.tutorPayInInstallmentPage.clickOnOverviewButton();

			Assert.assertFalse(this.tutorPayInInstallmentPage.getCreateInstallment());

		} catch (Exception e) {
			Assert.fail(
					"Exception occured while the tutor can create Installment in course which has physical shipment: "
							+ e.getMessage());
			logger.error("Error occured while the tutor can create Installment in course which has physical shipment",
					e);
		}

		logger.info("Ending of testPurchasePhysicalShipmentCourse method");

	}

	@Test(priority = 8, description = "Verify if tutor edit course to make course as physical shipment, Installment will be removed")
	@Description("Test Description: Verify if tutor edit course to make course as physical shipment, Installment will be removed")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Verify edit Physicalshipment course")
	public void testEditCourseWithPhysicalShipment() {
		logger.info("Starting of testEditCourseWithPhysicalShipment method");

		try {
			this.hardWait(2);
			super.createTutorPhysicalShipmentCourse(createCoursePage);
			this.hardWait(2);
			this.tutorPayInInstallmentPage.clickOnOverviewButton();
			this.hardWait(2);
			Assert.assertTrue(this.tutorPayInInstallmentPage.isDisplayedCreateInstallment());

			super.editPhysicalShipmentCourse(tutorEditCoursePage);

			this.createCoursePage.scrollDown(700);
			this.hardWait(2);
			this.studentPayInstallmentCoursePage.clickOnPhysicalShipmentToggle();
			this.studentPayInstallmentCoursePage.clickOnDeliveryDateCheckbox();
			this.createCoursePage.scrollDown(1000);
			this.tutorEditCoursePage.clickOnSaveButton();
			this.hardWait(2);
			Assert.assertFalse(this.tutorPayInInstallmentPage.getCreateInstallment());

			super.testRemoveCourse(tutorEditCoursePage);

			// Assertion for checking the delete course Text
			Assert.assertEquals(tutorPayInInstallmentPage.getLabelDeleteCourseText(),
					expectedAssertionsProp.getProperty(TUTOR_DELETE_COURSE));

		} catch (Exception e) {
			Assert.fail(
					"Exception occured while testing tutor edit course to make course as physical shipment, Installment will be removed.: "
							+ e.getMessage());
			logger.error(
					"Error occured while testing tutor edit course to make course as physical shipment, Installment will be removed ",
					e);
		}

		logger.info("Ending of testEditCourseWithPhysicalShipment method");
	}

	//@Test(priority = 9, description = "Verify Create installment option is visible or not, while course created by different owner/Tutor, (OrImported)")
	@Description("Test Description: Verify Create installment option is visible or not, while course created by different owner/Tutor, (Or Imported)")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Verify imported Course")
	public void testImportedCourse() {
		logger.info("Starting of testImportedCourse method");

		try {
			super.testImportContentCourse(tutorContentMarketPage, createCoursePage);

			Assert.assertFalse(this.tutorPayInInstallmentPage.getCreateInstallment());

		} catch (Exception e) {
			Assert.fail(
					"Exception occured while testing Create installment option is visible or not, while course created by different owner/Tutor, (Or Imported): "
							+ e.getMessage());
			logger.error(
					"Error occured while testing Create installment option is visible or not, while course created by different owner/Tutor, (Or Imported) ",
					e);
		}

		logger.info("Ending of testImportedCourse method");
	}

	@Test(priority = 10, description = "Verify Status in student tab, In case there’s any pending instalment")
	@Description("Test Description: Verify Status in student tab, In case there’s any pending instalment")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Verify Pending installment status in student tab")
	public void testPendingInstallmentStatus() {
		logger.info("Starting of testPendingInstallmentStatus method");

		try {
			this.createCoursePage.clickOnStoreButton();
			this.tutorPayInInstallmentPage.setSearch(testDataProp.getProperty(GET_COURSE));
			this.tutorPayInInstallmentPage.refresh();
			this.tutorPayInInstallmentPage.setSearch(testDataProp.getProperty(GET_COURSE));

			this.tutorPayInInstallmentPage.clickOnGetInstallmentStatusCourse(testDataProp.getProperty(GET_COURSE));

			super.selectStudentSortingCourse(tutorStudentSortingPage);

			Assert.assertTrue(this.tutorPayInInstallmentPage.isDisplayedPendingPayment());

			tutorStudentSortingPage.clickOnPricePaidIcon();

			Assert.assertTrue(this.tutorPayInInstallmentPage.isDisplayedFullPayment());

			Assert.assertEquals(this.tutorPayInInstallmentPage.getPaymentDetailsLabel(),
					expectedAssertionsProp.getProperty(LABEL_PAYMENT_DETAILS));

		} catch (Exception e) {
			Assert.fail(
					"Exception occured while testing Status in student tab, In case there’s any pending instalment: "
							+ e.getMessage());
			logger.error("Error occured while testing Status in student tab, In case there’s any pending instalment ",
					e);
		}

		logger.info("Ending of testPendingInstallmentStatus method");
	}

	@Test(priority = 11, description = "Verify the pending Paymnet details in student tab")
	@Description("Test Description:Verify the pending Paymnet details in student tab")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Verify Payment details column")
	public void testPaymentDetailsStatus() {
		logger.info("Starting of testPaymentDetailsStatus method");

		try {
			this.createCoursePage.clickOnOverviewButton();
			this.tutorStudentSortingPage.clickOnStudentsButton();
			this.tutorPayInInstallmentPage.clickOnPendingInstallment();

			Assert.assertEquals(this.tutorPayInInstallmentPage.getPaidColor(),
					expectedAssertionsProp.getProperty(LABEL_COLOR));

			Assert.assertTrue(this.tutorPayInInstallmentPage.isDisplayedPaidPaymentDate());

			Assert.assertTrue(this.tutorPayInInstallmentPage.getPendingPaymentDate());

			Assert.assertTrue(this.tutorPayInInstallmentPage.getDuePaymentDate());

			this.tutorPayInInstallmentPage.closePurchaseInInstallments();

		} catch (Exception e) {
			Assert.fail("Exception occured while testing  Payment detail column in Student tab: " + e.getMessage());
			logger.error("Error occured while testing Payment detail column in Student tab ", e);
		}

		logger.info("Ending of testPaymentDetailsStatus method");
	}

	@Test(priority = 12, description = "Verify Effective Course Price will show proper tooltip according to the course taxes & Handling charges")
	@Description("Test Description: Verify Effective Course Price will show proper tooltip according to the course taxes & Handling charges")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Verify effective Course Price")
	public void testEffectiveCoursePrice() {
		logger.info("Starting of testEffectiveCoursePrice method");

		try {
			this.hardWait(2);
			super.createEffectivePriceCourse(createCoursePage);
			this.hardWait(2);
			this.tutorPayInInstallmentPage.clickOnOverviewButton();
			this.hardWait(2);
			//this.tutorPayInInstallmentPage.closeInstallmentGotItPopup();

			super.createCourseInstallments(tutorCreateInstallmentPage);

			this.tutorPayInInstallmentPage.clickViewInstallmentsButton();
			this.tutorPayInInstallmentPage.clickEditInstallment();

			this.tutorPayInInstallmentPage.effectivePriceIcon();

			Assert.assertEquals(this.tutorPayInInstallmentPage.getEffectivePriceText(),
					expectedAssertionsProp.getProperty(MESSAGE_EFFECTIVEPRICE_INFORMATION));

			this.tutorPayInInstallmentPage.clickOnCloseButton();

		} catch (Exception e) {
			Assert.fail(
					"Exception occured while testing Effective Course Price will show proper tooltip according to the course taxes & Handling charges: "
							+ e.getMessage());
			logger.error(
					"Error occured while testing Effective Course Price will show proper tooltip according to the course taxes & Handling charges ",
					e);
		}

		logger.info("Ending of testEffectiveCoursePrice method");

	}

	@AfterClass
	public void quitDriver() {
		logger.info("Starting of quitDriver method");

		try {
			if (driver != null) {
				Thread.sleep(5000);
				this.loginPage.clickOnLogOut();
				this.quitDriver(this.driver, WEB_DRIVER.PAYIN_INSTALLMENT_TEST);
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