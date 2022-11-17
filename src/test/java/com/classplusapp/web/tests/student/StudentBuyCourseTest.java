package com.classplusapp.web.tests.student;

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

import java.util.Iterator;
import java.util.Set;

import com.classplusapp.web.pages.student.StudentBuyCoursePage;
import com.classplusapp.web.pages.student.StudentPayInstallmentCoursePage;
import com.classplusapp.web.pages.student.StudentViewContentPage;
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
@Feature("Student Buy Course Test")
public class StudentBuyCourseTest extends CommonFunctionStoreTest {
	private WebDriver driver = null;
	private WebDriver tutorDriver = null;

	private StudentBuyCoursePage buyCoursePage = null;
	private CommonFunctionStoreTest storeCommonFunctions = null;
	private StudentPayInstallmentCoursePage buyInstallmentCoursePage = null;
	private TutorCreateCoursePage createCoursePage = null;
	private TutorCreateInstallmentPage createInstallmentPage = null;
	private TutorAddContentPage addContentPage = null;
	private TutorAddContentPage tutorAddContentPage = null;
	private StudentPayInstallmentCoursePage studentPayInstallmentCoursePage = null;
	private StudentViewContentPage studentViewContentPage = null;
	private String createdCourseName;

	private static final Logger logger = Logger.getLogger(StudentBuyCourseTest.class.getName());

	@BeforeClass
	@Parameters({ "browser", "orgCode", "orgCode2" })
	public void initClassplusSiteLogin(@Optional("Chrome") String browser, @Optional("learn") String tutorOrgCode,
			@Optional("learn") String orgCode) throws Exception {
		logger.info("Starting of initClassplusSiteLogin methond");

		this.driver = super.loginClassPlusSite(browser, orgCode, studentMobileNumber, emailAddress,
				WEB_DRIVER.STUDENT_BUY_COURSE_TEST);

		this.tutorDriver = super.loginClassPlusSite(browser, tutorOrgCode, tutorMobileNumber, emailAddress,
				WEB_DRIVER.TUTOR_CREATE_COURSE_AUTOMATION_TESTING);

		this.buyCoursePage = new StudentBuyCoursePage(this.driver);
		this.studentViewContentPage = new StudentViewContentPage(driver);
		this.createCoursePage = new TutorCreateCoursePage(this.tutorDriver);
		this.tutorAddContentPage = new TutorAddContentPage(this.tutorDriver);
		this.storeCommonFunctions = new CommonFunctionStoreTest();
		this.addContentPage = new TutorAddContentPage(this.tutorDriver);
		createdCourseName = this.storeCommonFunctions.createSimpleCourse(createCoursePage);
		this.studentPayInstallmentCoursePage = new StudentPayInstallmentCoursePage(this.driver);

		this.storeCommonFunctions.addCourseContent(addContentPage, testDataProp.getProperty(LABEL_FOR_UPLOADING_PDF));
		String toastMsgText2 = this.addContentPage.getSuccessDocumentMessageText();
		Assert.assertEquals(toastMsgText2, expectedAssertionsProp.getProperty(ADD_DOCUMENT_SUCCESSFULLY_TEXT));
		this.tutorDriver.navigate().refresh();

		this.storeCommonFunctions.publishCourse(createCoursePage);

		logger.info("Ending of initClassplusSiteLogin method");

		this.buyInstallmentCoursePage = new StudentPayInstallmentCoursePage(this.driver);
		this.buyCoursePage = new StudentBuyCoursePage(this.driver);

		logger.info("Ending of initClassplusSiteLogin method");
	}

	@Test(priority = 1, description = "Verify Select Course Page")
	@Description("Test Description:Verify Select Course Page")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verify Select Course Page")
	public void testSelectCourse() {
		logger.info("Starting of testSelectCourse method");

		try {
			this.buyCoursePage.clickOnStoreButton();
			this.buyCoursePage.setSearch(testDataProp.getProperty(LABEL_STUDENT_PURCHASE_COURSE_TITLE));
			this.buyCoursePage.clickOnGetCourse(testDataProp.getProperty(LABEL_STUDENT_PURCHASE_COURSE_TITLE));
			String lblTitle = this.buyCoursePage.getTitleLabelText();
			Assert.assertEquals(lblTitle, expectedAssertionsProp.getProperty(LABEL_STUDENT_PURCHASE_COURSE_TITLE));

		} catch (Exception e) {
			Assert.fail("Exception occured while testing Select Course Page: " + e.getMessage());
			logger.error("Error occured while testing Select Course Page", e);
		}

		logger.info("Ending of testSelectCourse method");
	}

	@Test(priority = 2, description = "Verify Buy Course with Coupon Page")
	@Description("Test Description:Verify Buy Course with Coupon Page")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Verify Buy Course with Coupon Page")
	public void testBuyNowCourseWithCoupon() {
		logger.info("Starting of testBuyNowCourseWithCoupon method");

		try {
			this.buyCoursePage.clickOnStoreButton();
			this.buyCoursePage.setSearch(testDataProp.getProperty(LABEL_STUDENT_PURCHASE_COURSE_WITH_COUPON_TITLE));
			this.buyCoursePage
					.clickOnGetCourse(testDataProp.getProperty(LABEL_STUDENT_PURCHASE_COURSE_WITH_COUPON_TITLE));
			String lblTitle = this.buyCoursePage.getTitleLabelText();
			Assert.assertEquals(lblTitle,
					expectedAssertionsProp.getProperty(LABEL_STUDENT_PURCHASE_COURSE_WITH_COUPON_TITLE));

			this.buyCoursePage.clickonSelectStateDropDown();
			this.buyCoursePage.clickonStateButton();
			this.buyCoursePage.clickOnViewAllCouponCodeButton();
			this.buyCoursePage.clickOnApplyCouponCodeButton();
			super.testBuyNowCourse(buyCoursePage);
			/*
			 * this.buyCoursePage.clickOnNetbanking(); this.buyCoursePage.selectBank();
			 * this.buyCoursePage.clickOnPayAmountButton();
			 * this.buyCoursePage.clickOnDummyPaymentSuccess();
			 * driver.switchTo().defaultContent(); String
			 * pmtStatus=this.buyCoursePage.getPaymentStatusText();
			 * Assert.assertEquals(pmtStatus,
			 * expectedAssertionsProp.getProperty(PAYMENT_STATUS_SUCCESS_TEXT));
			 */
			this.buyCoursePage.closeBuyNowPage();

			Assert.assertEquals(studentPayInstallmentCoursePage.getPaymentFailedHeadingLabel(),
					expectedAssertionsProp.getProperty(LABEL_PAYMENT_FAILED_HEADING));

			this.buyCoursePage.closePaymentFailedDialogBox();
		} catch (Exception e) {
			Assert.fail("Exception occured while testing Buy Course with coupon Page: " + e.getMessage());
			logger.error("Error occured while testing Buy Course with coupon Page", e);
		}

		logger.info("Ending of testBuyNowCourseWithCoupon method");
	}

	@Test(priority = 3, description = "Verify Buy Course with shipment")
	@Description("Test Description:Verify Buy Course with shipment")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Verify Buy Course with shipment")
	public void testBuyNowCourseWithShipment() {
		logger.info("Starting of testBuyNowCourseWithShipment method");

		try {
			this.buyCoursePage.clickOnStoreButton();
			this.buyCoursePage.setSearch(testDataProp.getProperty(LABEL_STUDENT_PURCHASE_COURSE_WITH_SHIPMENT_TITLE));
			this.buyCoursePage
					.clickOnGetCourse(testDataProp.getProperty(LABEL_STUDENT_PURCHASE_COURSE_WITH_SHIPMENT_TITLE));
			String lblTitle = this.buyCoursePage.getTitleLabelText();
			Assert.assertEquals(lblTitle,
					expectedAssertionsProp.getProperty(LABEL_STUDENT_PURCHASE_COURSE_WITH_SHIPMENT_TITLE));
			if (this.buyCoursePage.checkVisibilityOfChangeAddress()) {
				this.buyCoursePage.clickOnChangeAddressButton();
				this.buyCoursePage.deleteSavedAddress();
			} else {
				this.buyCoursePage.clickOnSelectAddress();
			}
			this.buyCoursePage.setFullName(testDataProp.getProperty(STUDENT_FULL_NAME_FOR_SHIPMENT_COURSE));
			this.buyCoursePage.setAddress(testDataProp.getProperty(STUDENT_ADDRESS_FOR_SHIPMENT_COURSE));
			this.buyCoursePage.setCity(testDataProp.getProperty(STUDENT_CITY_FOR_SHIPMENT_COURSE));
			this.buyCoursePage.setState(testDataProp.getProperty(STUDENT_STATE_FOR_SHIPMENT_COURSE));
			this.buyCoursePage.setPinCode(testDataProp.getProperty(STUDENT_PINCODE_FOR_SHIPMENT_COURSE));
			this.buyCoursePage.setMobileNumber(testDataProp.getProperty(STUDENT_MOBILE_NUMBER_FOR_SHIPMENT_COURSE));
			this.buyCoursePage.clickOnButtonSaveAddress();
			this.buyCoursePage.clickOnButtonProceedToPayment();

			buyCoursePage.clickOnBuyNowButton();
			/*
			 * this.buyCoursePage.clickOnNetbanking(); this.buyCoursePage.selectBank();
			 * this.buyCoursePage.clickOnPayAmountButton();
			 * 
			 * this.buyCoursePage.clickOnDummyPaymentSuccess();
			 * 
			 * driver.switchTo().defaultContent(); String pmtStatus =
			 * this.buyCoursePage.getPaymentStatusText(); Assert.assertEquals(pmtStatus,
			 * expectedAssertionsProp.getProperty(PAYMENT_STATUS_SUCCESS_TEXT));
			 */
			this.buyCoursePage.closeBuyNowPage();

			Assert.assertEquals(studentPayInstallmentCoursePage.getPaymentFailedHeadingLabel(),
					expectedAssertionsProp.getProperty(LABEL_PAYMENT_FAILED_HEADING));

			this.buyCoursePage.closePaymentFailedDialogBox();

		} catch (Exception e) {
			Assert.fail("Exception occured while testing Buy Course with shipment Page: " + e.getMessage());
			logger.error("Error occured while testing Buy Course with shipment Page", e);
		}

		logger.info("Ending of testBuyNowCourseWithShipment method");
	}

	@Test(priority = 4, description = "Verify Buy Course with First Installment")
	@Description("Test Description:Verify Buy Course with First Installment")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Verify Buy Course with First Installment")
	public void testBuyNowCourseFirstInstallment() {
		logger.info("Starting of testBuyNowCourseFirstInstallment method");

		try {
			this.buyCoursePage.clickOnStoreButton();
			this.buyCoursePage
					.setSearch(testDataProp.getProperty(LABEL_STUDENT_PURCHASE_COURSE_WITH_INSTALLMENT_TITLE));
			this.buyCoursePage
					.clickOnGetCourse(testDataProp.getProperty(LABEL_STUDENT_PURCHASE_COURSE_WITH_INSTALLMENT_TITLE));
			String lblTitle = this.buyCoursePage.getTitleLabelText();
			Assert.assertEquals(lblTitle,
					expectedAssertionsProp.getProperty(LABEL_STUDENT_PURCHASE_COURSE_WITH_INSTALLMENT_TITLE));

			this.buyCoursePage.clickonSelectStateDropDown();
			this.buyCoursePage.clickonStateButton();

			this.buyCoursePage.clickOnPurchaseCourseInstallments();
			this.buyCoursePage.clickOnPayFirstInstallment();
			/*
			 * this.buyCoursePage.clickOnNetbanking(); this.buyCoursePage.selectBank();
			 * this.buyCoursePage.clickOnPayAmountButton();
			 * 
			 * this.buyCoursePage.clickOnDummyPaymentSuccess();
			 * 
			 * driver.switchTo().defaultContent(); String pmtStatus =
			 * this.buyCoursePage.getPaymentStatusText(); Assert.assertEquals(pmtStatus,
			 * expectedAssertionsProp.getProperty(PAYMENT_STATUS_SUCCESS_TEXT));
			 */
			this.buyCoursePage.closeBuyNowPage();

			Assert.assertEquals(studentPayInstallmentCoursePage.getPaymentFailedHeadingLabel(),
					expectedAssertionsProp.getProperty(LABEL_PAYMENT_FAILED_HEADING));

			this.buyCoursePage.closePaymentFailedDialogBox();

		} catch (Exception e) {
			Assert.fail("Exception occured while testing Buy Course with First Installment page: " + e.getMessage());
			logger.error("Error occured while testing Buy Course with First Installment page", e);
		}

		logger.info("Ending of testBuyNowCourseFirstInstallment method");
	}

	@Test(priority = 5, description = "Verify price amount including internetcharges and discount")
	@Description("Test Description:Verify price amount including internet charges and discount")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Verify price amount including internet charges and discount")
	public void verifyAmountPayable() {
		logger.info("Starting of verifyCoursePurchaseDate method");

		try {
			this.buyCoursePage.clickOnStoreButton();
			Thread.sleep(2000);
			this.studentViewContentPage.setSearchArea(createdCourseName);
			this.studentViewContentPage.clickOnGetCourse(createdCourseName);
			this.studentViewContentPage.clickOnContentButton();

			Assert.assertTrue(this.buyCoursePage.getBuyCourseAmount());

		} catch (Exception e) {
			Assert.fail("Exception occured while Verify price amount including internet charges and discount: "
					+ e.getMessage());
			logger.error("Error occured while testing Verify price amount including internet charges and discount", e);
		}

		logger.info("Ending of verifyAmountPayable method");
	}

	@Test(priority = 6, description = "Verify course purchase date")
	@Description("Test Description:Verify course purchase date")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Verify course purchase date")
	public void verifyCoursePurchaseDate() {
		logger.info("Starting of verifyCoursePurchaseDate method");

		try {
			this.buyCoursePage.clickOnStoreButton();
			this.buyCoursePage.clickOnViewAllPurchased();
			this.buyCoursePage.setSearch(testDataProp.getProperty(LABEL_STUDENT_AlREADY_PURCHASED_COURSE_TITLE));
			this.buyCoursePage.clickOnGetCourse(testDataProp.getProperty(LABEL_STUDENT_AlREADY_PURCHASED_COURSE_TITLE));

			String lblTitle = this.buyCoursePage.getTitleLabelText();
			Assert.assertEquals(lblTitle,
					expectedAssertionsProp.getProperty(LABEL_STUDENT_AlREADY_PURCHASED_COURSE_TITLE));

			Assert.assertTrue(this.buyCoursePage.isDisplayedCoursePurchasedDate());

			Assert.assertEquals(this.buyCoursePage.getPurchasedDate(),
					expectedAssertionsProp.getProperty(LABEL_STUDENT_PURCHASED_COURSE_TEXT));

		} catch (Exception e) {
			Assert.fail("Exception occured while Verify course purchase date: " + e.getMessage());
			logger.error("Error occured while testing Verify course purchase date", e);
		}

		logger.info("Ending of verifyCoursePurchaseDate method");
	}

	@AfterClass
	public void quitDriver() {
		logger.info("Starting of quitDriver method");

		try {
			if (this.driver != null) {
				Thread.sleep(5000);
				this.loginPage.clickOnLogOut();
				this.quitDriver(this.driver, WEB_DRIVER.STUDENT_BUY_COURSE_TEST);
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
