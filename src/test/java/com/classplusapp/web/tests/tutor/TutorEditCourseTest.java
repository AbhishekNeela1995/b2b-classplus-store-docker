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
import com.classplusapp.web.pages.tutor.TutorEditCoursePage;
import com.classplusapp.web.tests.BaseClassplusAutomationTest;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Epic("Store Overview")
@Feature("EditCourse Test")
public class TutorEditCourseTest extends BaseClassplusAutomationTest {

	private WebDriver driver = null;
	private TutorEditCoursePage tutorEditCoursePage = null;
	private TutorAddContentPage tutorAddContentPage = null;
	private String searchCourse;
	private static final Logger logger = Logger.getLogger(TutorEditCourseTest.class.getName());

	@BeforeClass
	@Parameters({ "browser", "orgCode" })
	public void initClassplusSiteLogin(@Optional("Chrome")String browser,@Optional("learn") String orgCode)
			throws Exception {
		logger.info("Starting of initClassplusSiteLogin methond");

		searchCourse = testDataProp.getProperty(EDIT_SEARCH_COURSE);
		this.driver = super.loginClassPlusSite(browser, orgCode, tutorMobileNumber, emailAddress,
				WEB_DRIVER.EDIT_COURSE_TEST);
		this.driver = super.clickOnStoreButton(driver, searchCourse);
		this.tutorEditCoursePage = new TutorEditCoursePage(driver);
		this.tutorAddContentPage = new TutorAddContentPage(this.driver);

		logger.info("Ending of initClassplusSiteLogin method");
	}

	@Test(priority = 1, description = "Verify Edit Course")
	@Description("Test Description: Verify Edit Course")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verify Edit Course")
	public void testEditCourse() {
		logger.info("Starting of testEditCourse method");

		try {
			this.tutorEditCoursePage.clickOnCourseFolder();
			this.tutorEditCoursePage.clickOnThreeDottedMenu();
			this.tutorEditCoursePage.clickOnEditIcon();

			// Assertion for checking the edit course Label
			String editCourseLabel = this.tutorEditCoursePage.getEditCourseLabel();
			Assert.assertEquals(editCourseLabel, expectedAssertionsProp.getProperty(LABEL_EDIT_COURSE));

			// Assertion for checking the Course Name label
			String CourseNameLabel = this.tutorCreateCoursePage.getCourseNameLabel();
			Assert.assertEquals(CourseNameLabel,
					expectedAssertionsProp.getProperty(LABEL_STORE_CREATECOURSE_COURSE_NAME));

			// Assertion for checking the Description label
			String descriptionLabel = this.tutorCreateCoursePage.getDescriptionLabel();
			Assert.assertEquals(descriptionLabel,
					expectedAssertionsProp.getProperty(LABEL_STORE_CREATECOURSE_DESCRIPTION));

			this.tutorEditCoursePage.setDescription(testDataProp.getProperty(EDIT_COURSE_DISCRIPTION));

			// Assertion for checking the Categories label
			String categoriesLabel = this.tutorCreateCoursePage.getCategoryLabel();
			Assert.assertEquals(categoriesLabel,
					expectedAssertionsProp.getProperty(LABEL_STORE_CREATECOURSE_CATEGORIES));

			// Assertion for checking the Sub Categories Label
			String subCategoriesLabel = this.tutorCreateCoursePage.getSubCategoriesLabel();
			Assert.assertEquals(subCategoriesLabel,
					expectedAssertionsProp.getProperty(LABEL_STORE_CREATECOURSE_SUB_CATEGORIES));

			// Assertion for checking the Enter Price Label
			String lblEnterPrice = this.tutorCreateCoursePage.getEnterPriceLabel();
			Assert.assertEquals(lblEnterPrice,
					expectedAssertionsProp.getProperty(LABEL_STORE_CREATECOURSE_ENTER_PRICE));

			this.tutorEditCoursePage.setPrice(testDataProp.getProperty(EDIT_COURSE_PRICE));
			// Assertion for checking the Discount Label
			String lblDiscount = this.tutorCreateCoursePage.getDiscountLabel();
			Assert.assertEquals(lblDiscount, expectedAssertionsProp.getProperty(LABEL_STORE_CREATECOURSE_DISCOUNT));

			this.tutorEditCoursePage.setDiscount(testDataProp.getProperty(EDIT_COURSE_DISCOUNT));

			// Assertion for checking the Effective Price Label
			String lblEffectivePrice = this.tutorCreateCoursePage.getEffectivePriceLabel();
			Assert.assertEquals(lblEffectivePrice,
					expectedAssertionsProp.getProperty(LABEL_STORE_CREATECOURSE_EFFECTIVE_PRICE));

			// Assertion for checking the Internet Handling Charges Label
			String internetChargesLabel = this.tutorCreateCoursePage.getInternetHandlingChargesLabel();
			Assert.assertEquals(internetChargesLabel,
					expectedAssertionsProp.getProperty(LABEL_STORE_CREATECOURSE_INTERNET_HANDLING_CHARGES));

			// Assertion for checking the Tax details label
			String taxDetailsLabel = this.tutorCreateCoursePage.getTaxDetailsLabel();
			Assert.assertEquals(taxDetailsLabel,
					expectedAssertionsProp.getProperty(LABEL_STORE_CREATECOURSE_TAX_DETAILS));

			this.tutorEditCoursePage.clickOnInternetChargesToggle();

			// Assertion for checking the course Duration Label
			String courseDurationLabel = this.tutorCreateCoursePage.getCourseDurationLabel();
			Assert.assertEquals(courseDurationLabel,
					expectedAssertionsProp.getProperty(LABEL_STORE_CREATECOURSE_COURSE_DURATION));

			// Assertion for checking the offline Access Permissions Label
			String offlineAccessPermissionsLabel = this.tutorCreateCoursePage.getOfflineAccessPermissionsLabel();
			Assert.assertEquals(offlineAccessPermissionsLabel,
					expectedAssertionsProp.getProperty(LABEL_STORE_CREATECOURSE_OFFLINE_ACCESS_PERMISSIONS));

			// Assertion for checking the pdf download Permissions Label
			String pdfdownloadPermissionsLabel = this.tutorCreateCoursePage.getPdfdownloadPermissionsLabel();
			Assert.assertEquals(pdfdownloadPermissionsLabel,
					expectedAssertionsProp.getProperty(LABEL_STORE_CREATECOURSE_PDF_DOWNLOAD_PERMISSION));

			// Assertion for checking the video Restrictions Label
			String videoRestrictionsLabel = this.tutorCreateCoursePage.getVideoRestrictionsLabel();
			Assert.assertEquals(videoRestrictionsLabel,
					expectedAssertionsProp.getProperty(LABEL_STORE_CREATECOURSE_VIDEO_RESTRICTIONS));

			// Assertion for checking the Course Sharing Label
			String lblCourseSharing = this.tutorCreateCoursePage.getCourseSharingLabel();
			Assert.assertEquals(lblCourseSharing,
					expectedAssertionsProp.getProperty(LABEL_STORE_CREATECOURSE_COURSE_SHARING));

			// Assertion for checking the Offline Shipment Label
			String lblOfflineShipment = this.tutorCreateCoursePage.getOfflineShipmentLabel();
			Assert.assertEquals(lblOfflineShipment,
					expectedAssertionsProp.getProperty(LABEL_STORE_CREATECOURSE_OFFLINE_SHIPMENT));

			// Assertion for checking the Student Certificate Label
			String lblStudentCertificate = this.tutorCreateCoursePage.getStudentCertificateLabel();
			Assert.assertEquals(lblStudentCertificate,
					expectedAssertionsProp.getProperty(LABEL_STORE_CREATECOURSE_STUDENT_CERTIFICATE));

			this.tutorEditCoursePage.clickOnValityCourseRadioButton();
			this.tutorEditCoursePage.clickOnSaveButton();
		} catch (Exception e) {
			Assert.fail("Exception occured while testing edit course: " + e.getMessage());
			logger.error("Error occured while testing edit course details ", e);
		}
		logger.info("Ending of testOverviewPage method");

	}

	@Test(priority = 2, description = "Verify Restrict course")
	@Description("Test Description:Verify Restrict course")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verify Remove course")
	public void testRestrictCourse() {
		logger.info("Starting of testRestrictCourse method");

		try {
			this.tutorCreateCoursePage.clickOnStoreButton();
			this.tutorEditCoursePage.clickOnCourseFolderRestriction();
			this.tutorEditCoursePage.clickOnThreeDottedMenu();
			this.tutorEditCoursePage.clickOnEditIcon();
			String videoRestrictionsLabel = this.tutorCreateCoursePage.getVideoRestrictionsLabel();
			Assert.assertEquals(videoRestrictionsLabel,
					expectedAssertionsProp.getProperty(LABEL_STORE_CREATECOURSE_VIDEO_RESTRICTIONS));
			this.tutorCreateCoursePage.clickOnVideoRestrictionToggle();
			this.tutorCreateCoursePage.clickOnVideoRestrictionsOnVideo();
			this.tutorCreateCoursePage.clickOnMaxViews();
			this.tutorCreateCoursePage.setMaxViews("10");
			this.tutorCreateCoursePage.clickOnViewDurations();
			this.tutorCreateCoursePage.setViewDur();
			this.tutorCreateCoursePage.clickOnUpdateRestriction();
			this.tutorEditCoursePage.clickOnSaveButton();
			this.tutorAddContentPage.clickOnContentButton();
			Assert.assertTrue(this.tutorEditCoursePage.checkVisibilityRestrictions());

		} catch (Exception e) {
			Assert.fail("Exception occured while testing Restrict Course: " + e.getMessage());
			logger.error("Error occured while testing Restrict Course details ", e);
		}
		logger.info("Ending of testRestrictCourse method");

	}

	@Test(priority = 3, description = "Verify Life Time Installment course")
	@Description("Test Description:Verify Restrict course")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verify Remove course")
	public void testLifeInstallmentCourse() {
		logger.info("Starting of testLifeInstallmentCourse method");

		try {
			this.tutorCreateCoursePage.clickOnStoreButton();
			String searchCourse = testDataProp.getProperty(LABEL_INSTALLMENT_COURSE);
			this.driver = super.clickOnStoreButton(driver, searchCourse);
			this.tutorEditCoursePage.clickOnCourseInstallmentLifetime();
			this.tutorEditCoursePage.clickOnThreeDottedMenu();
			this.tutorEditCoursePage.clickOnEditIcon();
			this.tutorEditCoursePage.clickOnLifetime();
			Assert.assertEquals(this.tutorEditCoursePage.getLabelLifetime(), expectedAssertionsProp.getProperty(LABEL_CHANGE_COURSE_DURATION));
			this.tutorEditCoursePage.clickOnDiscard();

	} catch (Exception e) {
		Assert.fail("Exception occured while testing Life Installment Course: " + e.getMessage());
		logger.error("Error occured while testing Life Installment Course details ", e);
	}
	logger.info("Ending of testLifeInstallmentCourse method");
	}

	@Test(priority = 4, description = "Verify Remove course")
	@Description("Test Description:Verify Remove course")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verify Remove course")
	public void testRemoveCourse() {
		logger.info("Starting of testRemoveCourse method");

		try {
			//this.tutorCreateCoursePage.clickOnStoreButton();
			super.clickOnStoreButton(driver, searchCourse);
			this.tutorEditCoursePage.clickOnCourseFolder();
			this.tutorEditCoursePage.clickOnOverviewButton();
			this.tutorEditCoursePage.clickOnMenuVerticalIcon();

			/*
			 * // Assertion for checking the remove text String lblRemove =
			 * this.tutorEditCoursePage.getRemoveLabel(); Assert.assertEquals(lblRemove,
			 * expectedAssertionsProp.getProperty(LABEL_COURSE_REMOVE));
			 */
			this.tutorEditCoursePage.clickOnRemoveCourseButton();

			// Assertion for checking the remove course text
			String lblRemoveConfirmationText = this.tutorEditCoursePage.getRemoveConfirmationText();
			Assert.assertEquals(lblRemoveConfirmationText,
					expectedAssertionsProp.getProperty(LABEL_COURSE_REMOVE_CONFIRMATION));

			// Assertion for checking the remove course text
			String lblRemoveConfirmation = this.tutorEditCoursePage.getRemoveConfirmationLabel();
			Assert.assertEquals(lblRemoveConfirmation,
					expectedAssertionsProp.getProperty(LABEL_COURSE_REMOVE_CONFIRMATION_TEXT));

			this.tutorEditCoursePage.removeCourseButton();
		} catch (Exception e) {
			Assert.fail("Exception occured while testing  remove course " + e.getMessage());
			logger.error("Error occured while testing remove course ", e);
		}

		logger.info("Ending of testRemoveCourse method");
	}

	@AfterClass
	public void quitDriver() {
		logger.info("Starting of quitDriver method");

		try {
			if (this.driver != null) {
				Thread.sleep(5000);
				this.loginPage.clickOnLogOut();
				this.quitDriver(this.driver, WEB_DRIVER.EDIT_COURSE_TEST);
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