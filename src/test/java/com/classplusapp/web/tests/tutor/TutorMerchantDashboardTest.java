package com.classplusapp.web.tests.tutor;

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

import com.classplusapp.web.pages.tutor.TutorMerchantDashboardPage;
import com.classplusapp.web.tests.BaseClassplusAutomationTest;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Epic("Store Dashboard")
@Feature("Merchant Dashborad Test")
public class TutorMerchantDashboardTest extends BaseClassplusAutomationTest {

	private WebDriver driver = null;
	private TutorMerchantDashboardPage tutorMerchantDashboardPage = null;
	String revenueLabel;

	private static final Logger logger = Logger.getLogger(TutorMerchantDashboardTest.class.getName());

	@BeforeClass
	@Parameters({ "browser","orgCode"})
	public void initClassplusSiteLogin(@Optional("Chrome")String browser, @Optional("learn")String orgCode)
			throws Exception {
		logger.info("Starting of initClassplusSiteLogin methond");

		this.driver = super.loginClassPlusSite(browser, orgCode, tutorMobileNumber, emailAddress,
				WEB_DRIVER.MERCHANT_DASHBOARD_TEST);
		this.tutorMerchantDashboardPage = new TutorMerchantDashboardPage(driver);

		logger.info("Ending of initClassplusSiteLogin method");
	}

	@Test(priority = 1, description = "Verify Merchant dashboard Page")
	@Description("Test Description : Verify Merchant dashboard Page")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Verify Merchant dashboard Page")
	public void testFiltersMerchantdashboardPage() {
		logger.info("Starting of testFilterMerchantdashboardPage method");

		try {
			this.tutorMerchantDashboardPage.clickOnTutorDropdown();
			this.tutorMerchantDashboardPage.clickOnMerchantDashboardLabel();

			// Assertion for checking the Filters label
			String filtersLabel = this.tutorMerchantDashboardPage.getFiltersLabelText();
			Assert.assertEquals(filtersLabel, expectedAssertionsProp.getProperty(LABEL_FILTERS));

			this.tutorMerchantDashboardPage.clickOnOwningCheckBox();
			revenueLabel = this.tutorMerchantDashboardPage.getTotalRevenueLabelText();
			Assert.assertEquals(revenueLabel, expectedAssertionsProp.getProperty(LABEL_TOTAL_REVENUE));

			String numberPurchasesLabel = this.tutorMerchantDashboardPage.getNumberPurchaseLabelText();
			Assert.assertEquals(numberPurchasesLabel, expectedAssertionsProp.getProperty(LABEL_NUMBER_PURCHASE));
			this.tutorMerchantDashboardPage.clickOnOwningCheckBox();
			this.tutorMerchantDashboardPage.clickOnResellingCheckBox();
			revenueLabel = this.tutorMerchantDashboardPage.getTotalRevenueLabelText();
			Assert.assertEquals(revenueLabel, expectedAssertionsProp.getProperty(LABEL_TOTAL_REVENUE));

			String numberPurchasesLabel1 = this.tutorMerchantDashboardPage.getNumberPurchaseLabelText();
			Assert.assertEquals(numberPurchasesLabel1, expectedAssertionsProp.getProperty(LABEL_NUMBER_PURCHASE));
			this.tutorMerchantDashboardPage.clickOnResellingCheckBox();
			this.tutorMerchantDashboardPage.clickOnCourseCheckBox();
			revenueLabel = this.tutorMerchantDashboardPage.getTotalRevenueLabelText();
			Assert.assertEquals(revenueLabel, expectedAssertionsProp.getProperty(LABEL_TOTAL_REVENUE));

			String numberPurchasesLabel2 = this.tutorMerchantDashboardPage.getNumberPurchaseLabelText();
			Assert.assertEquals(numberPurchasesLabel2, expectedAssertionsProp.getProperty(LABEL_NUMBER_PURCHASE));
			this.tutorMerchantDashboardPage.clickOnCourseCheckBox();

		} catch (Exception e) {
			Assert.fail("Exception occured while testing the  merchant dashboard Page: " + e.getMessage());
			logger.error("Error occured while testing the merchant dashboard page");
		}

		logger.info("Ending of testFilterMerchantdashboardPage method");
	}
	@Test(priority = 2, description = "Verify testInstallmentMerchantdashboardPage dashboard Page")
	@Description("Test Description : Verify testInstallmentMerchantdashboardPage")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Verify Merchant dashboard Page")
	public void testInstallmentMerchantdashboardPage() {
		logger.info("Starting of testInstallmentMerchantdashboardPage method");

		try {
			this.tutorMerchantDashboardPage.clickOnTutorDropdown();
			this.tutorMerchantDashboardPage.clickOnMerchantDashboardLabel();
			this.tutorMerchantDashboardPage.clickOnSeeMoreButton();
			this.tutorMerchantDashboardPage.searchTransactionsSeeMore("Installment");
			this.tutorMerchantDashboardPage.clickOnCheckBoxCourse();
			this.tutorMerchantDashboardPage.clickOnApplyFiltersButton();
			boolean lblInstallment = this.tutorMerchantDashboardPage.getInstallmentLabel();
			Assert.assertTrue(lblInstallment);
			
		} catch (Exception e) {
			Assert.fail("Exception occured while testing the  merchant dashboard Page: " + e.getMessage());
			logger.error("Error occured while testing the merchant dashboard page");
		}

		logger.info("Ending of testInstallmentMerchantdashboardPage method");
		
	}

	@Test(priority =3, description = "Verify Merchant dashboard Page")
	@Description("Test Description : Verify Merchant dashboard Page")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Verify Merchant dashboard Page")
	public void testMerchantdashboardPage() {
		logger.info("Starting of testTutorMerchantdashboardPage method");

		try {
			this.tutorMerchantDashboardPage.clickOnTutorDropdown();
			this.tutorMerchantDashboardPage.clickOnMerchantDashboardLabel();

			// Assertion for checking the Filters label
			String earningsLabel = this.tutorMerchantDashboardPage.getEarningsLabelText();
			Assert.assertEquals(earningsLabel, expectedAssertionsProp.getProperty(LABEL_EARNINGS));

			revenueLabel = this.tutorMerchantDashboardPage.getTotalRevenueLabelText();
			Assert.assertEquals(revenueLabel, expectedAssertionsProp.getProperty(LABEL_TOTAL_REVENUE));

			String numberPurchasesLabel = this.tutorMerchantDashboardPage.getNumberPurchaseLabelText();
			Assert.assertEquals(numberPurchasesLabel, expectedAssertionsProp.getProperty(LABEL_NUMBER_PURCHASE));

		} catch (Exception e) {
			Assert.fail("Exception occured while testing the  merchant dashboard Page: " + e.getMessage());
			logger.error("Error occured while testing the merchant dashboard page");
		}

		logger.info("Ending of testTutorMerchantdashboardPage method");
	}

	@Test(priority = 4, description = "Verify Merchant dashboard Page")
	@Description("Test Description : Verify Merchant dashboard Page")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Verify Merchant dashboard Page")
	public void testTimeFilterMerchantdashboardPage() throws Exception {
		logger.info("Starting of testTimeFilterMerchantdashboardPage method");
		
			try {
				this.tutorMerchantDashboardPage.clickOnTutorDropdown();
				this.tutorMerchantDashboardPage.clickOnMerchantDashboardLabel();

				this.tutorMerchantDashboardPage.clickOnOwningCheckBox();
				this.tutorMerchantDashboardPage.selectTime();
				this.tutorMerchantDashboardPage.selectDuration();

				Assert.assertNotEquals(this.tutorMerchantDashboardPage.getRevenue(), "0");
				Assert.assertNotEquals(this.tutorMerchantDashboardPage.getPurchase(), "0");

			} catch (Exception e) {
			
				
					Assert.fail("Exception occured while testing the  merchant dashboard Page: " + e.getMessage());
					logger.error("Error occured while testing the merchant dashboard page");
				
			}

			logger.info("Ending of testTimeFilterMerchantdashboardPage method");
		
	}

	@Test(priority =5, description = "Verify test Course Filter Merchant dashboard Page Page")
	@Description("Test Description : Verify test Course Filter Merchant dashboard Page")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Verify Merchant dashboard Page")
	public void testCourseFilterMerchantdashboardPage() {
		logger.info("Starting of testCourseFilterMerchantdashboardPage method");

		try {
			this.tutorMerchantDashboardPage.clickOnTutorDropdown();
			this.tutorMerchantDashboardPage.clickOnMerchantDashboardLabel();
			this.tutorMerchantDashboardPage.selectDuration();

			this.tutorMerchantDashboardPage.clickOnCourseCheckBox();

			Assert.assertNotEquals(this.tutorMerchantDashboardPage.getRevenue(), "0");
			Assert.assertNotEquals(this.tutorMerchantDashboardPage.getPurchase(), "0");

		} catch (Exception e) {
			Assert.fail("Exception occured while testing the  merchant dashboard Page: " + e.getMessage());
			logger.error("Error occured while testing the merchant dashboard page");
		}

		logger.info("Ending of testCourseFilterMerchantdashboardPage method");
	}

	@Test(priority = 6, description = "Verify Merchant dashboard Page")
	@Description("Test Description : Verify Merchant dashboard Page")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Verify Merchant dashboard Page")
	public void testResellerOwnerFilterMerchantdashboardPage() {
		logger.info("Starting of test Reseller Owner Filter Merchant dashboard Page method");

		try {
			this.tutorMerchantDashboardPage.clickOnTutorDropdown();
			this.tutorMerchantDashboardPage.clickOnMerchantDashboardLabel();
			this.tutorMerchantDashboardPage.selectTime();
			this.tutorMerchantDashboardPage.selectDuration();
			this.tutorMerchantDashboardPage.clickOnCourse();
			this.tutorMerchantDashboardPage.clickOnResellerOwnerCheckBox();

			Assert.assertNotEquals(this.tutorMerchantDashboardPage.getRevenue(), "0");
			Assert.assertNotEquals(this.tutorMerchantDashboardPage.getPurchase(), "0");

		} catch (Exception e) {
			Assert.fail("Exception occured while testing the  merchant dashboard Page: " + e.getMessage());
			logger.error("Error occured while testing the merchant dashboard page");
		}

		logger.info("Ending of test Reseller Owner Filter Merchant dashboard Page method");
	}

	@Test(priority = 7, description = "Verify Merchant dashboard Page")
	@Description("Test Description : Verify Merchant dashboard Page")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Verify Merchant dashboard Page")
	public void testMyStudentMerchantdashboardPage() {
		logger.info("Starting of testResellerOwnerFilterMerchantdashboardPage method");

		try {
			this.tutorMerchantDashboardPage.clickOnTutorDropdown();
			this.tutorMerchantDashboardPage.clickOnMerchantDashboardLabel();
			this.tutorMerchantDashboardPage.selectTime();
			this.tutorMerchantDashboardPage.selectDuration();

			this.tutorMerchantDashboardPage.clickOnFilterButton();
			this.tutorMerchantDashboardPage.clickOnMyStudents();

			Assert.assertNotEquals(this.tutorMerchantDashboardPage.getRevenue(), "0");
			Assert.assertNotEquals(this.tutorMerchantDashboardPage.getPurchase(), "0");
		} catch (Exception e) {
			Assert.fail("Exception occured while testing the  merchant dashboard Page: " + e.getMessage());
			logger.error("Error occured while testing the merchant dashboard page");
		}

		logger.info("Ending of testResellerOwnerFilterMerchantdashboardPage method");
	}

	@Test(priority = 8, description = "Verify Merchant dashboard Page")
	@Description("Tes Description : Verify Merchant dashboard Page")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Verify Merchant dashboard Page")
	public void testResellerStudentMerchantdashboardPage() {
		logger.info("Starting of testTutorMerchantdashboardPage method");

		try {
			this.tutorMerchantDashboardPage.clickOnTutorDropdown();
			this.tutorMerchantDashboardPage.clickOnMerchantDashboardLabel();
			this.tutorMerchantDashboardPage.selectTime();
			this.tutorMerchantDashboardPage.selectDuration();

			this.tutorMerchantDashboardPage.clickOnFilterButton();
			this.tutorMerchantDashboardPage.clickOnResellerStudents();

			Assert.assertNotEquals(this.tutorMerchantDashboardPage.getRevenue(), "0");
			Assert.assertNotEquals(this.tutorMerchantDashboardPage.getPurchase(), "0");
		} catch (Exception e) {
			Assert.fail("Exception occured while testing the  merchant dashboard Page: " + e.getMessage());
			logger.error("Error occured while testing the merchant dashboard page");
		}

		logger.info("Ending of testTutorMerchantdashboardPage method");
	}

	@Test(priority = 9, description = "Verify Merchant dashboard Page")
	@Description("Test Description : Verify Merchant dashboard Page")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Verify Merchant dashboard Page")
	public void testSearchMerchantdashboardPage() {
		logger.info("Starting of testTutorMerchantdashboardPage method");

		try {
			this.tutorMerchantDashboardPage.clickOnTutorDropdown();
			this.tutorMerchantDashboardPage.clickOnMerchantDashboardLabel();
			this.tutorMerchantDashboardPage.refresh();
			this.tutorMerchantDashboardPage.selectTime();
			this.tutorMerchantDashboardPage.selectDuration();

			String name = this.tutorMerchantDashboardPage.getStudentName();
			this.tutorMerchantDashboardPage.searchTransactions(name);
			Assert.assertNotEquals(this.tutorMerchantDashboardPage.getRevenue(), "0");
			Assert.assertNotEquals(this.tutorMerchantDashboardPage.getPurchase(), "0");
		} catch (Exception e) {
			Assert.fail("Exception occured while testing the  merchant dashboard Page: " + e.getMessage());
			logger.error("Error occured while testing the merchant dashboard page");
		}

		logger.info("Ending of testTutorMerchantdashboardPage method");
	}

	@Test(priority = 10, description = "Verify Merchant dashboard Page")
	@Description("Test Description : Verify Merchant dashboard Page")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Verify Merchant dashboard Page")
	public void testUncheckTimeMerchantdashboardPage() {
		logger.info("Starting of testTutorMerchantdashboardPage method");

		try {
			this.tutorMerchantDashboardPage.clickOnTutorDropdown();
			this.tutorMerchantDashboardPage.clickOnMerchantDashboardLabel();
			this.tutorMerchantDashboardPage.refresh();
			this.tutorMerchantDashboardPage.selectTime();
			this.tutorMerchantDashboardPage.selectDuration();
			Assert.assertNotEquals(this.tutorMerchantDashboardPage.getRevenue(), "0");
			Assert.assertNotEquals(this.tutorMerchantDashboardPage.getPurchase(), "0");
			this.tutorMerchantDashboardPage.selectDuration();
			Assert.assertNotEquals(this.tutorMerchantDashboardPage.getRevenue(), "0");
			Assert.assertNotEquals(this.tutorMerchantDashboardPage.getPurchase(), "0");
		} catch (Exception e) {
			Assert.fail("Exception occured while testing the  merchant dashboard Page: " + e.getMessage());
			logger.error("Error occured while testing the merchant dashboard page");
		}

		logger.info("Ending of testTutorMerchantdashboardPage method");
	}

	@Test(priority = 11, description = "Verify Settigs Page")
	@Description("Test Description :Verify Settigs Page")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verify Settigs Page")
	public void testSettingsPage() {
		logger.info("Starting of testGroupStudyToggleSettings method");

		try {
			this.tutorMerchantDashboardPage.clickOnTutorDropdown();
			this.tutorMerchantDashboardPage.clickOnSettings();

			// Assertion for checking the group study label
			String lblGroupStudy = this.tutorMerchantDashboardPage.getGroupStudyLabel();
			Assert.assertEquals(lblGroupStudy, expectedAssertionsProp.getProperty(LABEL_GROUP_STUDY));

		} catch (Exception e) {
			Assert.fail("Exception occured while testing the settings page : " + e.getMessage());
			logger.error("Error occured while testing the settings page");
		}

		logger.info("Ending of testGroupStudyToggleSettings method");
	}

	@Test(priority = 12, description = "Verify Upload Water Mark")
	@Description("Test Description :Verify Upload Water Mark")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verify Upload Water Mark")
	public void testUploadAndRemoveWaterMark() {
		logger.info("Starting of testUploadWaterMark method");

		try {
			this.tutorMerchantDashboardPage.clickOnTutorDropdown();
			this.tutorMerchantDashboardPage.clickOnSettings();

			this.tutorMerchantDashboardPage.clickOnUploadButton();

			boolean lblImage = this.tutorMerchantDashboardPage.getImageLabel();
			Assert.assertTrue(lblImage);
			
			String addWatermarkImage = this.tutorMerchantDashboardPage.getSrcOfWatermark();
			
			this.tutorMerchantDashboardPage.clickOnCrossButton();
//			
//			String removeWatermarkImage = this.tutorMerchantDashboardPage.getSrcOfWatermark();
//			Assert.assertFalse(addWatermarkImage.equals(removeWatermarkImage));
			


//			this.tutorMerchantDashboardPage.clickOnCrossButton();
			this.driver.navigate().refresh();

			boolean lblImage1 = this.tutorMerchantDashboardPage.getImageLabel();
			Assert.assertFalse(lblImage1);

		} catch (Exception e) {
			Assert.fail("Exception occured while testing the Upload Water Mark : " + e.getMessage());
			logger.error("Error occured while testing the Upload Water Mark");
		}

		logger.info("Ending of testUploadWaterMark method");
	}

	@Test(priority = 13, description = "Verify Customize And Give Grades To Students According To Their Performance")
	@Description("Test Description :Verify Customize And Give Grades To Students According To Their Performance")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verify Customize And Give Grades To Students According To Their Performance")
	public void testCustomizeAndGiveGradesToStudentsAccordingToTheirPerformance() {
		logger.info("Starting of testCustomizeAndGiveGradesToStudentsAccordingToTheirPerformance method");

		try {

			String lblCustomizeClassTestGrading = this.tutorMerchantDashboardPage.getCustomizeClassTestGradingLabel();
			Assert.assertEquals(lblCustomizeClassTestGrading,
					expectedAssertionsProp.getProperty(LABEL_CUSTOMIZE_CLASS_TEST_GRADING));

			this.tutorMerchantDashboardPage.clickOnAnalyticsButton();

			/*
			 * String lblCustomizeClassTestGradingHeading = this.tutorMerchantDashboardPage
			 * .getCustomizeClassTestGradingLabelHeading();
			 * Assert.assertEquals(lblCustomizeClassTestGradingHeading,
			 * expectedAssertionsProp.getProperty(LABEL_CUSTOMIZE_CLASS_TEST_GRADING_HEADING
			 * ));
			 */
			String lblCustomizeClassGrading = this.tutorMerchantDashboardPage.getCustomizeClassGradingLabel();
			Assert.assertEquals(lblCustomizeClassGrading,
					expectedAssertionsProp.getProperty(LABEL_CUSTOMIZE_CLASS_TEST_GRADING_TEXT));

			this.tutorMerchantDashboardPage.clickOnGradeADropDown();
			this.tutorMerchantDashboardPage.clickOnSelectGradeADropDown();

			String lblGradeAValue = this.tutorMerchantDashboardPage.getGradeAValue();
			Assert.assertEquals(lblGradeAValue, expectedAssertionsProp.getProperty(LABEL_GRADE_A_VALUE));

			this.tutorMerchantDashboardPage.clickOnGradeBDropDown();
			this.tutorMerchantDashboardPage.clickOnSelectGradeBDropDown();

			String lblGradeBValue = this.tutorMerchantDashboardPage.getGradeBValue();
			Assert.assertEquals(lblGradeBValue, expectedAssertionsProp.getProperty(LABEL_GRADE_B_VALUE));

			this.tutorMerchantDashboardPage.clickOnGradeCDropDown();
			this.tutorMerchantDashboardPage.clickOnSelectGradeCDropDown();

			String lblGradeCValue = this.tutorMerchantDashboardPage.getGradeCValue();
			Assert.assertEquals(lblGradeCValue, expectedAssertionsProp.getProperty(LABEL_GRADE_C_VALUE));

			this.tutorMerchantDashboardPage.clickOnGradeDDropDown();
			this.tutorMerchantDashboardPage.clickOnSelectGradeDDropDown();

			String lblGradeDValue = this.tutorMerchantDashboardPage.getGradeDValue();
			Assert.assertEquals(lblGradeDValue, expectedAssertionsProp.getProperty(LABEL_GRADE_D_VALUE));

			this.tutorMerchantDashboardPage.clickOnGradeEDropDown();
			this.tutorMerchantDashboardPage.clickOnSelectGradeEFromDropDown();

			String lblGradeEValue = this.tutorMerchantDashboardPage.getGradeEValue();
			Assert.assertEquals(lblGradeEValue, expectedAssertionsProp.getProperty(LABEL_GRADE_E_VALUE));

			this.tutorMerchantDashboardPage.clickOnSaveButton();

		} catch (Exception e) {
			Assert.fail(
					"Exception occured while testing Customize And Give Grades To Students According To Their Performance : "
							+ e.getMessage());
			logger.error(
					"Error occured while testing the Customize And Give Grades To Students According To Their Performance");
		}

		logger.info("Ending of testCustomizeAndGiveGradesToStudentsAccordingToTheirPerformance method");
	}

	@Test(priority = 14, description = "Verify the Dashboard Page")
	@Description("Test Description : Verify the Dashboard Page")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Verify the Dashboard Page")
	public void testDashboardPage() {
		logger.info("Starting of testDashboardPage method");

		try {
			this.tutorMerchantDashboardPage.clickOnTutorDropdown();
			this.tutorMerchantDashboardPage.clickOnDashboard();

			// Assertion for checking the Download Reports label
			String DownloadReports = this.tutorMerchantDashboardPage.getDownloadReports();
			Assert.assertEquals(DownloadReports, expectedAssertionsProp.getProperty(LABEL_DOWNLOAD_REPORTS));

			this.tutorMerchantDashboardPage.clickOnSelectReportField();
			this.tutorMerchantDashboardPage.clickOnEnquiries();
			this.tutorMerchantDashboardPage.clickOnSelectDateField();
			this.tutorMerchantDashboardPage.clickOnSelectedDate();
			this.tutorMerchantDashboardPage.clickOnExportData();

			// Assertion for checking the Download Reports label
			String ExportSuccessMessage = this.tutorMerchantDashboardPage.getExportSuccessMessage();
			Assert.assertEquals(ExportSuccessMessage, expectedAssertionsProp.getProperty(EXPORT_SUCCESS_MESSAGE_TEXT));

		} catch (Exception e) {
			Assert.fail("Exception occured while testing the dashboard page : " + e.getMessage());
			logger.error("Error occured while testing the Dashboard page");
		}

		logger.info("Ending of testDashboardPage method");
	}

	public void quitDriver() {
		logger.info("Starting of quitDriver method");

		try {
			if (this.driver != null) {
				Thread.sleep(5000);
				this.loginPage.clickOnLogOut();
				this.quitDriver(this.driver, WEB_DRIVER.MERCHANT_DASHBOARD_TEST);
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