package com.classplusapp.web.tests.tutor;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static com.classplusapp.store.util.Constants.*;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.function.Function;

import com.classplusapp.web.pages.tutor.TutorAddContentPage;
import com.classplusapp.web.pages.tutor.TutorCreateCoursePage;
import com.classplusapp.web.tests.BaseClassplusAutomationTest;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Epic("Store MyCourses")
@Feature("Tutor CreateCourse Test")
public class TutorCreateCourseTest extends BaseClassplusAutomationTest {

	private WebDriver driver = null;
	private TutorCreateCoursePage tutorCreateCoursePage = null;
	private TutorAddContentPage tutorAddContentPage = null;

	private static final Logger logger = Logger.getLogger(TutorCreateCourseTest.class.getName());
	private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yy/MM/dd-HH:mm:ss");

	@BeforeClass
	@Parameters({ "browser", "orgCode" })
	public void initClassplusSiteLogin(@Optional("Chrome")String browser,@Optional("learn") String orgCode)
			throws Exception {
		logger.info("Starting of initClassplusSiteLogin methond");

		this.driver = super.loginClassPlusSite(browser, orgCode, tutorMobileNumber, emailAddress,
				WEB_DRIVER.CREATE_COURSE_TEST);
		this.tutorCreateCoursePage = new TutorCreateCoursePage(driver);
		this.tutorAddContentPage = new TutorAddContentPage(driver);
		logger.info("Ending of initClassplusSiteLogin method");
	}

	@Test(priority = 1, description = "Verify My Courses Page")
	@Description("Test Description: Verify My Courses Page")
	@Severity(SeverityLevel.CRITICAL)
	@Story("Verify My Courses Page")
	public void testMyCoursesPage() {
		logger.info("Starting of testMyCoursesPage method");

		try {
			this.tutorCreateCoursePage.clickOnStoreButton();
			this.tutorCreateCoursePage.clickOnCreateCourseButton();
			this.tutorCreateCoursePage.clickOnBackToCourse();

			Assert.assertEquals(this.tutorCreateCoursePage.getStoreLabel(),
					expectedAssertionsProp.getProperty(LABEL_STORE));

			// Assertion for checking the My Courses label
			Assert.assertEquals(this.tutorCreateCoursePage.getMyCourses(),
					expectedAssertionsProp.getProperty(LABEL_STORE_MYCOURSES));

		} catch (Exception e) {
			Assert.fail("Exception occured while testing the MyCoursesPage: " + e.getMessage());
			logger.error("Error occured while testing MyCoursesPage ", e);
		}

		logger.info("Ending of testMyCoursesPage method");
	}

	@Test(priority = 2, description = "Verify Store home Page")
	@Description("Test Description:Verify Store home Page")
	@Severity(SeverityLevel.CRITICAL)
	@Story("Verify Store home Page")
	public void testStoreHomePage() {
		logger.info("Starting of testStoreHomePage method");

		try {
			this.tutorCreateCoursePage.clickOnStoreButton();

			Assert.assertEquals(this.tutorCreateCoursePage.getContentMarket(),
					expectedAssertionsProp.getProperty(LABEL_CONTENT_MARKET));

			this.tutorCreateCoursePage.clickOnSearchBar();

			Assert.assertEquals(this.tutorCreateCoursePage.getSearchBar(),
					expectedAssertionsProp.getProperty(LABEL_SEARCH));

			this.tutorCreateCoursePage
					.clickOnTxtSearchCourse(testDataProp.getProperty(FACULTY_SEARCH_WITH_INVALID_COURSE));
			Assert.assertEquals(this.tutorCreateCoursePage.getNothingFoundMessage(),
					expectedAssertionsProp.getProperty(FACULTY_NOTHING_FOUND_MESSAGE));

			Assert.assertEquals(this.tutorCreateCoursePage.getSortFiltersLabel(),
					expectedAssertionsProp.getProperty(LABEL_SORT_FILTER));

			this.tutorCreateCoursePage.clickOnBackFromSearchBar();

			Assert.assertEquals(this.tutorCreateCoursePage.getStoreCreateCourseLabel(),
					expectedAssertionsProp.getProperty(LABEL_CREATECOURSE));

			Assert.assertTrue(this.tutorCreateCoursePage.isdisplayedHelpIcon());

			this.tutorCreateCoursePage.clickOnCourseBanner();
			this.tutorCreateCoursePage.switchToDefault();

			Assert.assertEquals(this.tutorCreateCoursePage.getStatsLabel(),
					expectedAssertionsProp.getProperty(LABEL_STATS));

			Assert.assertTrue(this.tutorCreateCoursePage.getStatsCard());

			Assert.assertEquals(this.tutorCreateCoursePage.getCouponsLabel(),
					expectedAssertionsProp.getProperty(LABEL_COUPONS));

			Assert.assertTrue(this.tutorCreateCoursePage.getCouponsCard());

			Assert.assertEquals(this.tutorCreateCoursePage.getCategorySubcategoryLabel(),
					expectedAssertionsProp.getProperty(LABEL_COURSES_SUBCATEGORIES));

			Assert.assertEquals(this.tutorCreateCoursePage.getCoursesLabel(),
					expectedAssertionsProp.getProperty(LABEL_HOMEPAGE_COURSES));

			Assert.assertTrue(this.tutorCreateCoursePage.getCourseCard());

			Assert.assertTrue(this.tutorCreateCoursePage.isdisplayedWhatsAppIcon());

			Assert.assertEquals(this.tutorCreateCoursePage.getViewAll(),
					expectedAssertionsProp.getProperty(LABEL_VIEWALL_COURSES));

		} catch (Exception e) {
			Assert.fail("Exception occured while testing the StoreHomePage: " + e.getMessage());
			logger.error("Error occured while testing StoreHomePage ", e);
		}

		logger.info("Ending of testStoreHomePage method");
	}

	@Test(priority = 3, description = "Verify Tutor can create the new course")
	@Description("Test Description: Verify Tutor can create the new course")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verify Tutor can create the new course")
	public void testCreateCourse() {
		logger.info("Starting of testCreateCourseTutor method");

		try {
			this.tutorCreateCoursePage.clickOnStoreButton();
			this.tutorCreateCoursePage.clickOnCreateCourseButton();

			// Assertion for checking the Create Course label
			String createCourseLabel = this.tutorCreateCoursePage.getCreateCourseLabel();
			Assert.assertEquals(createCourseLabel, expectedAssertionsProp.getProperty(LABEL_STORE_CREATECOURSE));

			// Assertion for checking the Course Name label
			String CourseNameLabel = this.tutorCreateCoursePage.getCourseNameLabel();
			Assert.assertEquals(CourseNameLabel,
					expectedAssertionsProp.getProperty(LABEL_STORE_CREATECOURSE_COURSE_NAME));

			this.tutorCreateCoursePage.setCourseName(testDataProp.getProperty(TUTOR_COURSE_NAME));

			/*
			 * // Assertion for checking the Description label String descriptionLabel =
			 * this.tutorCreateCoursePage.getDescriptionLabel();
			 * Assert.assertEquals(descriptionLabel,
			 * expectedAssertionsProp.getProperty(LABEL_STORE_CREATECOURSE_DESCRIPTION));
			 */
			this.tutorCreateCoursePage.setDescription(testDataProp.getProperty(COURSE_DESCRIPTION));
			this.tutorCreateCoursePage.clickOnUploadImageButton();

			// Assertion for checking the Categories label
			String categoriesLabel = this.tutorCreateCoursePage.getCategoryLabel();
			Assert.assertEquals(categoriesLabel,
					expectedAssertionsProp.getProperty(LABEL_STORE_CREATECOURSE_CATEGORIES));

			this.tutorCreateCoursePage.clickOnCategoryDropdown();

			// Assertion for checking the Sub Categories Label
			String subCategoriesLabel = this.tutorCreateCoursePage.getSubCategoriesLabel();
			Assert.assertEquals(subCategoriesLabel,
					expectedAssertionsProp.getProperty(LABEL_STORE_CREATECOURSE_SUB_CATEGORIES));

			this.tutorCreateCoursePage.setCategory();
			this.tutorCreateCoursePage.clickOnSubCategoryDropdown();
			this.tutorCreateCoursePage.setSubCategory();

			// Assertion for checking the Enter Price Label
			String lblEnterPrice = this.tutorCreateCoursePage.getEnterPriceLabel();
			Assert.assertEquals(lblEnterPrice,
					expectedAssertionsProp.getProperty(LABEL_STORE_CREATECOURSE_ENTER_PRICE));

			this.tutorCreateCoursePage.setPrice(testDataProp.getProperty(CREATE_COURSE_PRICE));

			// Assertion for checking the Discount Label
			String lblDiscount = this.tutorCreateCoursePage.getDiscountLabel();
			Assert.assertEquals(lblDiscount, expectedAssertionsProp.getProperty(LABEL_STORE_CREATECOURSE_DISCOUNT));

			this.tutorCreateCoursePage.setDiscount(testDataProp.getProperty(CREATE_COURSE_DISCOUNT));

			// Assertion for checking the Internet Handling Charges Label
			String internetChargesLabel = this.tutorCreateCoursePage.getInternetHandlingChargesLabel();
			Assert.assertEquals(internetChargesLabel,
					expectedAssertionsProp.getProperty(LABEL_STORE_CREATECOURSE_INTERNET_HANDLING_CHARGES));

			// Assertion for checking the Effective Price Label
			String lblEffectivePrice = this.tutorCreateCoursePage.getEffectivePriceLabel();
			Assert.assertEquals(lblEffectivePrice,
					expectedAssertionsProp.getProperty(LABEL_STORE_CREATECOURSE_EFFECTIVE_PRICE));

			this.tutorCreateCoursePage.clickOnInternetChargesToggle();

			// Assertion for checking the Tax details label
			String taxDetailsLabel = this.tutorCreateCoursePage.getTaxDetailsLabel();
			Assert.assertEquals(taxDetailsLabel,
					expectedAssertionsProp.getProperty(LABEL_STORE_CREATECOURSE_TAX_DETAILS));

			this.tutorCreateCoursePage.clickOnTaxDetailsToggle();

			// Assertion for checking the Are You Sure You Want To Exclude Tax Details label
			String excludeTaxDetailsLabel = this.tutorCreateCoursePage.getExcludeTaxDetailsLabel();
			Assert.assertEquals(excludeTaxDetailsLabel,
					expectedAssertionsProp.getProperty(LABEL_COURSE_TAX_DETAILS_HEADING_TEXT));

			this.tutorCreateCoursePage.clickOnTaxDetailsCancelButton();

			// Assertion for checking the course Duration Label
			String courseDurationLabel = this.tutorCreateCoursePage.getCourseDurationLabel();
			Assert.assertEquals(courseDurationLabel,
					expectedAssertionsProp.getProperty(LABEL_STORE_CREATECOURSE_COURSE_DURATION));

			// Assertion for checking the Course Sharing Label
			String lblCourseSharing = this.tutorCreateCoursePage.getCourseSharingLabel();
			Assert.assertEquals(lblCourseSharing,
					expectedAssertionsProp.getProperty(LABEL_STORE_CREATECOURSE_COURSE_SHARING));

			this.tutorCreateCoursePage.clickOnLifeTimeDurationRadioButton();

			// Assertion for checking the Offline Shipment Label
			String lblOfflineShipment = this.tutorCreateCoursePage.getOfflineShipmentLabel();
			Assert.assertEquals(lblOfflineShipment,
					expectedAssertionsProp.getProperty(LABEL_STORE_CREATECOURSE_OFFLINE_SHIPMENT));

			Assert.assertEquals(this.tutorCreateCoursePage.getCourseShipmentSwitchOnToggleText(),
					expectedAssertionsProp.getProperty(TEXT_CREATECOURSE_SHIPMENT));
			Assert.assertFalse(this.tutorCreateCoursePage.checkCourseShipmentToggle());

			this.tutorCreateCoursePage.clickOnPhysicalShipmentToggle();

			// Assertion for checking the offline Access Permissions Label
			String offlineAccessPermissionsLabel = this.tutorCreateCoursePage.getOfflineAccessPermissionsLabel();
			Assert.assertEquals(offlineAccessPermissionsLabel,
					expectedAssertionsProp.getProperty(LABEL_STORE_CREATECOURSE_OFFLINE_ACCESS_PERMISSIONS));

			this.tutorCreateCoursePage.clickOnOfflineToggle();

			// Assertion for checking the pdf download Permissions Label
			String pdfdownloadPermissionsLabel = this.tutorCreateCoursePage.getPdfdownloadPermissionsLabel();
			Assert.assertEquals(pdfdownloadPermissionsLabel,
					expectedAssertionsProp.getProperty(LABEL_STORE_CREATECOURSE_PDF_DOWNLOAD_PERMISSION));

			Assert.assertEquals(this.tutorCreateCoursePage.getPdfDownloadedPermissionsSwitchOnToggle(),
					expectedAssertionsProp.getProperty(LABEL_SAVE_PDF_TOOGLE));
			Assert.assertEquals(this.tutorCreateCoursePage.getHelpTextToSavePDF(),
					expectedAssertionsProp.getProperty(HELP_TEXT_SAVE_PDF_TOOGLE));

			this.tutorCreateCoursePage.clickOnPdfToggle();

			// Assertion for checking the live Classes Label
			String liveClassesLabel = this.tutorCreateCoursePage.getLiveClassesLabel();
			Assert.assertEquals(liveClassesLabel,
					expectedAssertionsProp.getProperty(LABEL_STORE_CREATECOURSE_LIVE_CLASSES));

			this.tutorCreateCoursePage.clickOnLiveClassesToggle();

			// Assertion for checking the video Restrictions Label
			String videoRestrictionsLabel = this.tutorCreateCoursePage.getVideoRestrictionsLabel();
			Assert.assertEquals(videoRestrictionsLabel,
					expectedAssertionsProp.getProperty(LABEL_STORE_CREATECOURSE_VIDEO_RESTRICTIONS));

			this.tutorCreateCoursePage.clickOnVideoRestrictionToggle();
			this.tutorCreateCoursePage.clickOnVideoRestrictionsOnVideo();
			this.tutorCreateCoursePage.clickOnMaxViews();
			this.tutorCreateCoursePage.setMaxViews(testDataProp.getProperty(COURSE_VIDEO_MAXVIEWS));
			this.tutorCreateCoursePage.clickOnViewDurations();
			this.tutorCreateCoursePage.setViewDur();
			this.tutorCreateCoursePage.showView();

			// Assertion for checking the preview Course Feature Label
			String previewCourseFeatureLabel = this.tutorCreateCoursePage.getPreviewCourseFeatureLabel();
			Assert.assertEquals(previewCourseFeatureLabel,
					expectedAssertionsProp.getProperty(LABEL_STORE_CREATECOURSE_PREVIEW_COURSE_FEATURE));

			this.tutorCreateCoursePage.clickOnPreviewCourse();

			// Assertion for checking the Student Certificate Label
			String lblStudentCertificate = this.tutorCreateCoursePage.getStudentCertificateLabel();
			Assert.assertEquals(lblStudentCertificate,
					expectedAssertionsProp.getProperty(LABEL_STORE_CREATECOURSE_STUDENT_CERTIFICATE));

			this.tutorCreateCoursePage.clickOnTermsAndConditionCheckBox();

		} catch (Exception e) {
			Assert.fail("Exception occured while testing Tutor can create the new course: " + e.getMessage());
			logger.error("Error occured while testing Tutor can create the new course ", e);
		}

		logger.info("Ending of testCreateCourseTutor method");
	}

	@Test(priority = 4, description = "Verify Content Course Page")
	@Description("Test Description:Verify Content Course")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verify Content Course")
	public void testCourseContent() {
		logger.info("Starting  of testCourseContent  method");

		try {
			this.tutorCreateCoursePage.clickOnAddContentButton();

			// Assertion for checking the create course text
			String addContentMessageText = this.tutorCreateCoursePage.getCourseCreatedMessage();
			Assert.assertEquals(addContentMessageText,
					expectedAssertionsProp.getProperty(COURSE_CREATED_SUCCESSFULLY_TEXT));

			this.tutorCreateCoursePage.clickOnOverviewButton();

			// Assertion for checking the Content label
			String contentLabel = this.tutorCreateCoursePage.getContentLabel();
			Assert.assertEquals(contentLabel, expectedAssertionsProp.getProperty(LABEL_COURSE_CONTENT));

		} catch (Exception e) {
			Assert.fail("Exception occured while testing Content Course: " + e.getMessage());
			logger.error("Error occured while testing Content Course", e);
		}

		logger.info("Ending of testCourseContent method");
	}

	@Test(priority = 5, description = "Verify Create Course Offline Shipment Toggle")
	@Description("Test Description:Verify Create Course Offline Shipment Toggle")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verify Create Course Offline Shipment Toggle")
	public void testErrorMessageAppearsOnOfflineShipmentToggleWhenCourseSharingChecked() {
		try {
			this.tutorCreateCoursePage.clickOnStoreButton();
			this.tutorCreateCoursePage.clickOnCreateCourseButton();
			String currentDateTime = dtf.format(LocalDateTime.now());
			this.tutorCreateCoursePage
					.setCourseName(testDataProp.getProperty(TUTOR_DUMMY_CREATE_COURSE_NAME) + currentDateTime);
			this.tutorCreateCoursePage.setDescription(testDataProp.getProperty(COURSE_DESCRIPTION) + currentDateTime);
			this.tutorCreateCoursePage.clickOnCategoryDropdown();
			this.tutorCreateCoursePage.setCategory();
			this.tutorCreateCoursePage.clickOnCourseShareCheckBox();
			String shipmentNote = this.tutorCreateCoursePage.errorMessageOnCourseShipment();
			Assert.assertEquals(shipmentNote, expectedAssertionsProp.getProperty(NOTE_COURSE_OFFLINE_SHIPMENT));

			this.tutorCreateCoursePage.uncheckCourseShareCheckBox();
			Assert.assertFalse(this.tutorCreateCoursePage.checkCourseShipmentToggle());
			this.tutorCreateCoursePage.enableCourseShipmentToggle();
			Assert.assertTrue(this.tutorCreateCoursePage.verifyCourseSharingCheckboxDisabled());

			Assert.assertEquals(this.tutorCreateCoursePage.getTentativeDaysLabelWhenCourseShipmentToggleisON(),
					expectedAssertionsProp.getProperty(TENTATIVE_DAYS));
			this.tutorCreateCoursePage.clickOnSetTentaiveDelivery();
			this.tutorCreateCoursePage.selectTentativeDays();

			this.tutorCreateCoursePage.clickOnTermsAndConditionCheckBox();
			this.tutorCreateCoursePage.clickOnAddContentButton();
			this.tutorCreateCoursePage.clickOnOverviewLeftSide();

		} catch (Exception e) {
			Assert.fail("Exception occured while testing Create Course Offline Shipment Toggle: " + e.getMessage());
			logger.error("Error occured while testing Create Course Offline Shipment Toggle", e);
		}
	}

	@Test(priority = 6, description = "Verify Physical Material on Course Thumbnail")
	@Description("Test Description:Verify Physical Material on Course Thumbnail")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verify Physical Material on Course Thumbnail")
	public void testPhysicalMaterialOnCourseThumbnail() {
		try {
			Assert.assertTrue(this.tutorCreateCoursePage.verifyPhysicalMaterialTag());
			String tentativeDays = this.tutorCreateCoursePage.getTentativeDaysOnCourseOverview();
			Assert.assertEquals(tentativeDays, expectedAssertionsProp.getProperty(TENTATIVEDAYS_TEXT_COURSEOVERVIEW));

			this.tutorAddContentPage.clickOnMenuVerticalIcon1();
			this.tutorAddContentPage.clickOnMenuEditButton();
			this.tutorCreateCoursePage.uncheckSetTentaiveDelivery();
			this.tutorAddContentPage.clickOnEditSaveButton();
			Assert.assertEquals(this.tutorCreateCoursePage.verifyToasterMessage(),
					expectedAssertionsProp.getProperty(COURSE_EDIT_SICCESSFULLY));
			this.tutorCreateCoursePage.closeEditCoursePricePopup();
			Assert.assertFalse(this.tutorCreateCoursePage.verifyTentativeDaysTextPresentWhenTutorNotSelected());
			String helpTxtShipment = this.tutorCreateCoursePage.hoverOnShipmentHelpTextOnOverviewPage();
			Assert.assertEquals(helpTxtShipment,
					expectedAssertionsProp.getProperty(SHIPMENT_HELPTEXT_COURSEOVERVIEW_PAGE));

			this.tutorAddContentPage.clickOnMenuVerticalIcon1();
			this.tutorAddContentPage.clickOnMenuEditButton();
			this.tutorCreateCoursePage.switchOffCourseShipmentToggle();
			this.tutorAddContentPage.clickOnEditSaveButton();
			Assert.assertEquals(this.tutorCreateCoursePage.verifyToasterMessage(),
					expectedAssertionsProp.getProperty(COURSE_EDIT_SICCESSFULLY));

			Assert.assertFalse(this.tutorCreateCoursePage.verifyCourseOfflineShipmentVisibilityOnCourseOverview());

		} catch (Exception e) {
			Assert.fail("Exception occured while testing Physical Material: " + e.getMessage());
			logger.error("Error occured while testing Physical Material", e);
		}
	}

	@Test(priority = 7, description = "Verify Physical Delivery on Edit Course")
	@Description("Test Description:Verify Physical Delivery on Edit Course")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verify Physical Delivery on Edit Course")
	public void testOfflineMaterialForShipmentOnEditCourse() {
		try {
			this.tutorAddContentPage.clickOnMenuVerticalIcon1();
			this.tutorAddContentPage.clickOnMenuEditButton();
			Assert.assertFalse(this.tutorCreateCoursePage.verifyCourseShipmentToggle());
			this.tutorCreateCoursePage.clickOnCourseShareCheckBox();
			Assert.assertTrue(this.tutorCreateCoursePage.verifyOfflineShipmentToggleBtn());
			String shipmentNote = this.tutorCreateCoursePage.errorMessageOnCourseShipment();
			Assert.assertEquals(shipmentNote, expectedAssertionsProp.getProperty(NOTE_COURSE_OFFLINE_SHIPMENT));

			this.tutorCreateCoursePage.uncheckCourseShareCheckBox();
			Assert.assertFalse(this.tutorCreateCoursePage.verifyOfflineShipmentToggleBtn());
			this.tutorCreateCoursePage.enableCourseShipmentToggle();
			Assert.assertTrue(this.tutorCreateCoursePage.verifyCourseSharingCheckboxDisabled());
			Assert.assertEquals(this.tutorCreateCoursePage.getTentativeDaysLabelWhenCourseShipmentToggleisON(),
					expectedAssertionsProp.getProperty(TENTATIVE_DAYS));
			this.tutorCreateCoursePage.clickOnSetTentaiveDelivery();
			this.tutorCreateCoursePage.selectTentativeDays();
			this.tutorCreateCoursePage.switchOffCourseShipmentToggle();
			String shipmentNote2 = this.tutorCreateCoursePage.errorMessageOnCourseShipment();
			Assert.assertEquals(shipmentNote2, expectedAssertionsProp.getProperty(NOTE_COURSE_OFFLINE_SHIPMENT2));
			this.tutorAddContentPage.clickOnEditSaveButton();

		} catch (Exception e) {
			Assert.fail("Exception occured while testing Offline Material for Shipment: " + e.getMessage());
			logger.error("Error occured while testing Offline Material for Shipment", e);
		}
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