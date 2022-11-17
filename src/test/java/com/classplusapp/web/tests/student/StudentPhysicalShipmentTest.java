package com.classplusapp.web.tests.student;

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
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import com.classplusapp.web.pages.student.StudentPhysicalShipmentPage;
import com.classplusapp.web.pages.student.StudentBuyCoursePage;
import com.classplusapp.web.pages.student.StudentCourseOverviewPage;
import com.classplusapp.web.pages.tutor.TutorCreateCoursePage;
import com.classplusapp.web.tests.BaseClassplusAutomationTest;
import com.classplusapp.web.tests.CommonFunctionStoreTest;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

public class StudentPhysicalShipmentTest extends CommonFunctionStoreTest {
	private WebDriver studentDriver = null;
	private WebDriver tutorDriver = null;
	private StudentPhysicalShipmentPage studentPhysicalShipmentPage = null;
	private StudentBuyCoursePage buyCoursePage = null;
	private TutorCreateCoursePage createCourse = null;
	private CommonFunctionStoreTest storeCommonFunction = null;
	private DateTimeFormatter dtf = null;
	private StudentCourseOverviewPage courseOverviewPage = null;
	public String courseName;
	public String tentativeCourseName;
	private static final Logger logger = Logger.getLogger(StudentPhysicalShipmentTest.class.getName());

	@BeforeClass
	@Parameters({ "browser", "orgCode", "orgCode2" })
	public void initClassplusSiteLogin(@Optional("Chrome") String browser, @Optional("learn") String orgCode,
			@Optional("learn") String orgCode2) throws Exception {
		logger.info("Starting of initClassplusSiteLogin methond");

		this.studentDriver = super.loginClassPlusSite(browser, orgCode2, studentMobileNumber, emailAddress,
				WEB_DRIVER.COURSE_OVERVIEW_TEST_STUDENT);
		this.tutorDriver = super.loginClassPlusSite(browser, orgCode, tutorMobileNumber, emailAddress,
				WEB_DRIVER.COURSE_OVERVIEW_TEST_TUTOR);
		this.buyCoursePage = new StudentBuyCoursePage(this.studentDriver);
		this.courseOverviewPage = new StudentCourseOverviewPage(this.studentDriver);
		this.studentPhysicalShipmentPage = new StudentPhysicalShipmentPage(this.studentDriver);
		this.storeCommonFunction = new CommonFunctionStoreTest();
		this.createCourse = new TutorCreateCoursePage(tutorDriver);
		this.dtf = DateTimeFormatter.ofPattern("yy/MM/dd-HH:mm:ss");

		courseName = this.storeCommonFunction.offlineMaterialForShipmentOn(createCourse);
		this.storeCommonFunction.addContentImage(createCourse);
		this.storeCommonFunction.publishCourse(createCourse); // Tentative Delivery
		tentativeCourseName = this.storeCommonFunction.tentativeDeliveryNotAvailable(createCourse);
		this.storeCommonFunction.addContentImage(createCourse);
		this.storeCommonFunction.publishCourse(createCourse);

		logger.info("Ending of initClassplusSiteLogin method");
	}

	@Test(priority = 1, description = "Verify Offline Material for Shipment is on")
	@Description("Verify Offline Material for Shipment is on")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verify Offline Material for Shipment is on")
	public void verifyOfflineMaterialForShipmentOn() {
		logger.info("Starting of verifyOfflineMaterialForShipmentOn method");

		try {
			this.buyCoursePage.clickOnStoreButton();
			this.buyCoursePage.setSearch(courseName);
			this.buyCoursePage.clickOnGetCourse(courseName);
			String offineMaterialForShipmentText = this.studentPhysicalShipmentPage.physicalMaterial();
			Assert.assertEquals(offineMaterialForShipmentText,
					expectedAssertionsProp.getProperty(STUDENT_OVERVIEW_TEST_CONTAINS_OFFLINE_STUDY_MATERIAL));
		} catch (Exception e) {
			Assert.fail("Exception occured while testing Offline Material for Shipment is on: " + e.getMessage());
			logger.error("Error occured while testing Offline Material for Shipment is on:", e);
		}

		logger.info("Ending of verifyOfflineMaterialForShipmentOn method");
	}

	@Test(priority = 2, description = "Verify Offline Material for Shipment is off")
	@Description("Verify Offline Material for Shipment is off")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verify Offline Material for Shipment is off")
	public void verifOfflineMaterialForShipmentOff() {
		logger.info("Starting of verifOfflineMaterialForShipmentOff method");

		try {
			this.buyCoursePage.clickOnStoreButton();
			this.buyCoursePage.setSearch(courseName);
			this.buyCoursePage.clickOnGetCourse(courseName);
			Assert.assertFalse(this.studentPhysicalShipmentPage.notPhysicalMaterial());
		} catch (Exception e) {
			Assert.fail("Exception occured while testing Offline Material for Shipment is off: " + e.getMessage());
			logger.error("Error occured while testing Offline Material for Shipment is off:", e);
		}

		logger.info("Ending of verifOfflineMaterialForShipmentOff method");
	}

	@Test(priority = 3, description = "Verify Tentative Delivery for shipment is available")
	@Description("Verify Tentative Delivery for shipment is available")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verify Tentative Delivery for shipment is available")
	public void tentaiveDeliveryAvailable() {
		logger.info("Starting of tentaiveDeliveryAvailable method");

		try {
			this.buyCoursePage.clickOnStoreButton();
			this.buyCoursePage.setSearch(tentativeCourseName);
			this.buyCoursePage.clickOnGetCourse(tentativeCourseName);
			String offineMaterialForShipmentText = this.studentPhysicalShipmentPage.physicalMaterial();
			String tenativeDeliveryText = this.studentPhysicalShipmentPage.tenativeDelivery();
			String[] arrOfStr = tenativeDeliveryText.split(":", 2);
			Assert.assertEquals(offineMaterialForShipmentText,
					expectedAssertionsProp.getProperty(STUDENT_OVERVIEW_TEST_CONTAINS_OFFLINE_STUDY_MATERIAL));
			Assert.assertEquals(arrOfStr[0] + ":",
					expectedAssertionsProp.getProperty(STUDENT_OVERVIEW_TEST_TENATIVE_DELIVERY));
		} catch (Exception e) {
			Assert.fail(
					"Exception occured while testing Tentative Delivery for shipment is available: " + e.getMessage());
			logger.error("Error occured while testing Tentative Delivery for shipment is available:", e);
		}

		logger.info("Ending of tentaiveDeliveryAvailable method");
	}

	@Test(priority = 4, description = "Verify Tentative Delivery for shipment is not available")
	@Description("Verify Tentative Delivery for shipment is not available")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verify Tentative Delivery for shipment is not available")
	public void tentaiveDeliveryNotAvailable() {
		logger.info("Starting of tentaiveDeliveryNotAvailable method");

		try {
			this.buyCoursePage.clickOnStoreButton();
			this.buyCoursePage.setSearch(tentativeCourseName);
			this.buyCoursePage.clickOnGetCourse(tentativeCourseName);
			String offineMaterialForShipmentText = this.studentPhysicalShipmentPage.physicalMaterial();
			Assert.assertEquals(offineMaterialForShipmentText,
					expectedAssertionsProp.getProperty(STUDENT_OVERVIEW_TEST_CONTAINS_OFFLINE_STUDY_MATERIAL));
			Assert.assertFalse(this.studentPhysicalShipmentPage.notTentativeDelivery());
		} catch (Exception e) {
			Assert.fail("Exception occured while testing Tentative Delivery for shipment is not available: "
					+ e.getMessage());
			logger.error("Error occured while testing Tentative Delivery for shipment is not available:", e);
		}

		logger.info("Ending of tentaiveDeliveryNotAvailable method");
	}

	@Test(priority = 5, description = "Verify Address Page is displayed")
	@Description("Verify Address Page is displayed")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verify Address Page is displayed")
	public void verifyAddressPage() {
		logger.info("Starting of verifyAddressPage method");

		try {
			// super.createPhysicalShipmentCourse(createCourse);
			this.buyCoursePage.clickOnStoreButton();
			this.buyCoursePage.setSearch(courseName);
			this.buyCoursePage.clickOnGetCourse(courseName);

			Assert.assertEquals(this.studentPhysicalShipmentPage.shipmentAddressDesction(),
					expectedAssertionsProp.getProperty(STUDENT_ADDRESS_DESCRIPTION));

			super.fillAddressFromBuyCourse(studentPhysicalShipmentPage);

		} catch (Exception e) {
			Assert.fail("Exception occured while testing Verify Address Page is displayed " + e.getMessage());
			logger.error("Error occured while testing Verify Address Page is displayed", e);
		}

		logger.info("Ending of verifyAddressPage method");
	}

	@Test(priority = 6, description = "Verify Filled Address Page is displayed")
	@Description("Verify Filled Address Page is displayed")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verify Filled Address Page is displayed")
	public void verifyFilledAddressPage() {
		logger.info("Starting of verifyFilledAddressPage method");

		try {
			this.buyCoursePage.clickOnStoreButton();
			this.buyCoursePage.setSearch(courseName);
			this.buyCoursePage.clickOnGetCourse(courseName);
			this.hardWait(3);
			if (this.studentPhysicalShipmentPage.checkVisibilityOfChangeAddress() == true) {
				this.studentPhysicalShipmentPage.clickOnChangeAddressButton();
				this.studentPhysicalShipmentPage.clickOnAddNewAddress();
				this.studentPhysicalShipmentPage
						.setFullName(testDataProp.getProperty(STUDENT_FULL_NAME_FOR_SHIPMENT_COURSE));
				this.studentPhysicalShipmentPage
						.setAddress1(testDataProp.getProperty(STUDENT_ADDRESS_FOR_SHIPMENT_COURSE));
				this.studentPhysicalShipmentPage
						.setAddress2(testDataProp.getProperty(STUDENT_ADDRESS2_FOR_SHIPMENT_COURSE));
				this.studentPhysicalShipmentPage
						.setLandmark(testDataProp.getProperty(STUDENT_LANDMARK_FOR_SHIPMENT_COURSE));
				this.studentPhysicalShipmentPage.setCity(testDataProp.getProperty(STUDENT_CITY_FOR_SHIPMENT_COURSE));
				this.studentPhysicalShipmentPage.setState(testDataProp.getProperty(STUDENT_STATE_FOR_SHIPMENT_COURSE));
				this.studentPhysicalShipmentPage
						.setPinCode(testDataProp.getProperty(STUDENT_PINCODE_FOR_SHIPMENT_COURSE));
				this.studentPhysicalShipmentPage
						.setMobileNumber(testDataProp.getProperty(STUDENT_MOBILE_NUMBER_FOR_SHIPMENT_COURSE));
				this.studentPhysicalShipmentPage.clickOnsetAsDefault();
				this.studentPhysicalShipmentPage.clickOnButtonSaveAddress();
				this.studentPhysicalShipmentPage.clickOnButtonProceedToPayment();
				String Actualtext = this.studentPhysicalShipmentPage.selectedAddressData();
				String DesiredText = testDataProp.getProperty(STUDENT_ADDRESS_FOR_SHIPMENT_COURSE) + ", "
						+ testDataProp.getProperty(STUDENT_ADDRESS2_FOR_SHIPMENT_COURSE) + ", "
						+ testDataProp.getProperty(STUDENT_CITY_FOR_SHIPMENT_COURSE) + ", "
						+ testDataProp.getProperty(STUDENT_STATE_FOR_SHIPMENT_COURSE) + ", "
						+ testDataProp.getProperty(STUDENT_PINCODE_FOR_SHIPMENT_COURSE);
				Assert.assertEquals(Actualtext, DesiredText);
			}
		} catch (Exception e) {
			Assert.fail("Exception occured while testing Verify Filled Address Page is displayed " + e.getMessage());
			logger.error("Error occured while testing Verify Filled Address Page is displayed", e);
		}

		logger.info("Ending of verifyFilledAddressPage method");
	}

	@Test(priority = 7, description = "Verify edit Address and add Address Button is displayed")
	@Description("Verify edit Address and add Address Button is displayed")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verify Address Page is displayed")
	public void verifyEditAndAddBtn() {
		logger.info("Starting of verifyEditAndAddBtn method");

		try {
			this.buyCoursePage.clickOnStoreButton();
			this.buyCoursePage.setSearch(courseName);
			this.buyCoursePage.clickOnGetCourse(courseName);
			if (this.studentPhysicalShipmentPage.checkVisibilityOfChangeAddress() == true) {
				this.studentPhysicalShipmentPage.clickOnChangeAddressButton();
				Assert.assertTrue(this.studentPhysicalShipmentPage.verifyAddAddressData());
				Assert.assertTrue(this.studentPhysicalShipmentPage.verifyEditBtn());
			}
		} catch (Exception e) {
			Assert.fail("Exception occured while testing Verify edit Address and add Address Button is displayed"
					+ e.getMessage());
			logger.error("Error occured while testing Verify edit Address and add Address Button is displayed", e);
		}

		logger.info("Ending of verifyEditAndAddBtn method");
	}

	@Test(priority = 8, description = "Verify edit Address page is displayed")
	@Description("Verify edit Address page is  displayed")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verify Edit Address Page is displayed")
	public void verifyEditPage() {
		logger.info("Starting of verifyEditPage method");

		try {
			this.buyCoursePage.clickOnStoreButton();
			this.buyCoursePage.setSearch(courseName);
			this.buyCoursePage.clickOnGetCourse(courseName);
			if (this.studentPhysicalShipmentPage.checkVisibilityOfChangeAddress() == true) {
				this.studentPhysicalShipmentPage.clickOnChangeAddressButton();
				this.studentPhysicalShipmentPage.clickOnEditBtn();

				Assert.assertTrue(this.studentPhysicalShipmentPage.isNameAddressData());

				this.studentPhysicalShipmentPage.clickOnCloseAddressPage();
			}
		} catch (Exception e) {
			Assert.fail("Exception occured while testing Verify edit Address page is  displayed" + e.getMessage());
			logger.error("Error occured while testing Verify edit Address page is  displayed", e);
		}

		logger.info("Ending of verifyEditPage method");
	}

	@Test(priority = 9, description = "Verify Add Address page is displayed")
	@Description("Verify Add Address page is  displayed")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verify Add Address Page is displayed")
	public void verifyAddPage() {
		logger.info("Starting of verifyAddPage method");

		try {
			this.buyCoursePage.clickOnStoreButton();
			this.buyCoursePage.setSearch(courseName);
			this.buyCoursePage.clickOnGetCourse(courseName);
			if (this.studentPhysicalShipmentPage.checkVisibilityOfChangeAddress() == true) {
				this.studentPhysicalShipmentPage.clickOnChangeAddressButton();
				this.studentPhysicalShipmentPage.clickOnAddNewAddress();
				Assert.assertTrue(this.studentPhysicalShipmentPage.isNameAddressData());
			}
		} catch (Exception e) {
			Assert.fail("Exception occured while testing Verify Add Address page is  displayed" + e.getMessage());
			logger.error("Error occured while testing Verify Add Address page is  displayed", e);
		}

		logger.info("Ending of verifyAddPage method");
	}

	@Test(priority = 10, description = "Verify Delivery Address Post Purchase page is displayed")
	@Description("Verify Delivery Address Post Purchase page is  displayed")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verify Delivery Address Post Purchase page is  displayed")
	public void verifyDeliveryAddressPostPurchase() {
		logger.info("Starting of VerifyDeliveryAddressPostPurchase method");

		try {
			this.buyCoursePage.clickOnStoreButton();
			this.buyCoursePage.clickOnViewAllCourses();
			this.buyCoursePage.setSearch("Physical Shipment Course");
			this.buyCoursePage.clickOnGetCourse("Physical Shipment Course");

			String address = this.studentPhysicalShipmentPage.labelDeliveryAddress();
			Assert.assertEquals(address,
					expectedAssertionsProp.getProperty(STUDENT_FULL_ADDRESS_PHYSICAL_SHIPMENT_COURSE));

		} catch (Exception e) {
			Assert.fail("Exception occured while testing Verify Delivery Address Post Purchase page is  displayed"
					+ e.getMessage());
			logger.error("Error occured while testing Verify Delivery Address Post Purchase is  displayed", e);
		}

		logger.info("Ending of verifyDeliveryAddressPostPurchase method");
	}

	@Test(priority = 11, description = "Verify Delivery Address in Invoice page is displayed")
	@Description("Verify Delivery Address in Invoice page is  displayed")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verify Delivery Address Post Purchase page is  displayed")
	public void verifyDeliveryAddressInvoice() {
		logger.info("Starting of verifyDeliveryAddressInvoice method");

		try {
			this.buyCoursePage.clickOnStoreButton();
			this.buyCoursePage.clickOnViewAllCourses();
			this.buyCoursePage.setSearch("Physical Shipment Course");
			this.buyCoursePage.clickOnGetCourse("Physical Shipment Course");
			String address = this.studentPhysicalShipmentPage.labelDeliveryAddress();
			this.studentPhysicalShipmentPage.btnDownloadInvoice();

			String invoiceAddress = this.studentPhysicalShipmentPage.pdfAddress();
			// Assert.assertEquals(invoiceAddress, address);
			this.courseOverviewPage.closeWindow();

		} catch (Exception e) {
			Assert.fail("Exception occured while testing Verify Delivery Address Invoice page is  displayed"
					+ e.getMessage());
			logger.error("Error occured while testing Verify Delivery Address Invoice is  displayed", e);
		}

		logger.info("Ending of verifyDeliveryAddressInvoice method");
	}

	@Test(priority = 12, description = "Verify Delivery Address in Invoice page is displayed")
	@Description("Verify Delivery Address in Invoice page is  displayed")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verify Delivery Address Post Purchase page is  displayed")
	public void verifyDatePurchaseInvoice() {
		logger.info("Starting of verifyDatePurchaseInvoice method");

		try {
			this.buyCoursePage.clickOnStoreButton();
			this.buyCoursePage.clickOnViewAllCourses();
			this.buyCoursePage.setSearch("Physical Shipment Course");
			this.buyCoursePage.clickOnGetCourse("Physical Shipment Course");
			String datePurchase = this.studentPhysicalShipmentPage.labelDatePurchase();
			this.studentPhysicalShipmentPage.btnDownloadInvoice();

			String invoiceDatePurchase = this.studentPhysicalShipmentPage.pdfDatePurchase();
			Assert.assertEquals(invoiceDatePurchase, datePurchase);
			this.courseOverviewPage.closeWindow();

		} catch (Exception e) {
			Assert.fail(
					"Exception occured while testing verify Date Purchase Invoice page is  displayed" + e.getMessage());
			logger.error("Error occured while testing verify Date Purchase Invoice is  displayed", e);
		}

		logger.info("Ending of verifyDatePurchaseInvoice method");
	}

	@Test(priority = 13, description = "Verify delete address")
	@Description("Verify delete address")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verify Add Address Page is displayed")
	public void deleteSavedAddress() {
		logger.info("Starting of deleteSavedAddress method");

		try {
			this.buyCoursePage.clickOnStoreButton();
			this.buyCoursePage.setSearch(courseName);
			this.buyCoursePage.clickOnGetCourse(courseName);
			for (int i = 0; i < 2; i++) {
				super.deleteAddressFromBuyCourse(studentPhysicalShipmentPage);
			}
		} catch (Exception e) {
			Assert.fail("Exception occured while testing Verify delete Address " + e.getMessage());
			logger.error("Error occured while testing Verify delete Address", e);
		}

		logger.info("Ending of deleteSavedAddress method");
	}

	@AfterClass
	public void quitDriver() {
		logger.info("Starting of quitDriver method");

		try {
			if (this.tutorDriver != null) {
				Thread.sleep(5000);
				this.loginPage.clickOnLogOut();
				this.quitDriver(this.tutorDriver, WEB_DRIVER.COURSE_OVERVIEW_TEST_TUTOR);
				logger.info("Tutor Driver quit successfully");
			}
			if (this.studentDriver != null) {
				Thread.sleep(5000);
				this.loginPage.clickOnLogOut();
				this.quitDriver(this.studentDriver, WEB_DRIVER.COURSE_OVERVIEW_TEST_STUDENT);
				logger.info("Student Driver quit successfully");
			}
		} catch (Exception ex) {
			logger.error(ex.getMessage());
		}

		logger.info("Ending of quitDriver method");
	}

	@AfterMethod
	public void getConsoleLoggers() {
		logger.info("Starting of getConsoleLogger method");

		this.logBrowserConsoleErrors(this.studentDriver);

		logger.info("Ending of getConsoleLogger method");
	}
}