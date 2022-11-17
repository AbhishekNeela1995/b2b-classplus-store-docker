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

import com.classplusapp.web.pages.tutor.TutorResellerSettingsPage;
import com.classplusapp.web.tests.BaseClassplusAutomationTest;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Epic("Store Overview")
@Feature("Reseller Settings Test")
public class TutorResellerSettingsTest extends BaseClassplusAutomationTest {

	private WebDriver driver = null;
	private TutorResellerSettingsPage tutorResellerSettingsPage = null;

	private static final Logger logger = Logger.getLogger(TutorResellerSettingsTest.class.getName());

	@BeforeClass
	@Parameters({ "browser", "orgCode"})
	public void initClassplusSiteLogin(@Optional("Chrome")String browser, @Optional("learn")String orgCode)
			throws Exception {
		logger.info("Starting of initClassplusSiteLogin methond");

		String searchCourse = testDataProp.getProperty(RESELLERS_SEARCH_COURSE);
		this.driver = super.loginClassPlusSite(browser, orgCode, tutorMobileNumber, emailAddress,
				WEB_DRIVER.RESELLER_SETTINGS_TEST);
		this.driver = super.clickOnStoreButton(driver, searchCourse);
		this.tutorResellerSettingsPage = new TutorResellerSettingsPage(driver);

		logger.info("Ending of initClassplusSiteLogin method");
	}

	@Test(priority = 1, description = "Verify Reseller Settings Page")
	@Description("Test Descriprtion : Verify Reseller Settings Page")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Verify Reseller Settings Page")
	public void testResellerSettingsPage() {
		logger.info("Starting of testResellerSettingsPage method");

		try {
			this.tutorResellerSettingsPage.clickOnCourseFolder();
			this.driver.navigate().refresh();
			this.tutorResellerSettingsPage.clickOnResellerSettingsButton();
			
			// Assertion for checking the resell settings Label
			String lblResaleSettings = this.tutorResellerSettingsPage.getlblResaleSettingsLabel();
			Assert.assertEquals(lblResaleSettings, expectedAssertionsProp.getProperty(LABEL_RESALE_SETTINGS));

		} catch (Exception e) {
			Assert.fail("Exception occured while testing the Reseller Settings Page: " + e.getMessage());
			logger.error("Error occured while testing the Reseller Settings Page");
		}

		logger.info("Ending of testResellerSettingsPage method");
	}

	@Test(priority = 2, description = "Verify Resale Settings page")
	@Description("Test Description : Verify Resale Settings page")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verify Resale Settings page")
	public void testResalesettings() {
		logger.info("Starting of testResalesettings method");

		try {

			this.tutorResellerSettingsPage.clickOnViewEditPermissionsLabel();
			

			// Assertion for checking the edit permissions Label
			String lblEditPermissions = this.tutorResellerSettingsPage.getEditPermissionsLabel();
			Assert.assertEquals(lblEditPermissions, expectedAssertionsProp.getProperty(LABEL_EDIT_PERMISSIONS));

			this.tutorResellerSettingsPage.clickOnPricingToggleButton();
			this.tutorResellerSettingsPage.clickOnNameToggleButton();
			this.tutorResellerSettingsPage.clickOnDescriptionToggle();
			this.tutorResellerSettingsPage.clickOnCourseImageToggleButton();
			this.tutorResellerSettingsPage.clickOnSaveButton();

			String txtPermissionSuccess = this.tutorResellerSettingsPage.getPermissionSuccessMessage();
			Assert.assertEquals(txtPermissionSuccess,
					expectedAssertionsProp.getProperty(PERMISSION_SUCCESS_MESSAGE_TEXT));

		} catch (Exception e) {
			Assert.fail("Exception occured while testing the Resale settings page: " + e.getMessage());
			logger.error("Error occured while testing the Resale settings page");
		}

		logger.info("Ending of testResalesettings method");
	}

	@Test(priority = 3, description = "Verify Revoke Reseller Settings")
	@Description("Test Description : Verify Revoke Reseller Settings")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verify Revoke Reseller Settings")
	public void testRevokeResellers() {
		logger.info("Starting of testRevokeResellers method");

		try {
			this.tutorResellerSettingsPage.clickOnTutorName();
			this.tutorResellerSettingsPage.clickOnShareDate();
			this.tutorResellerSettingsPage.clickOnSellingPrice();
			this.tutorResellerSettingsPage.clickOnPriceShare();
			this.tutorResellerSettingsPage.clickOnPurchases();
			this.tutorResellerSettingsPage.clickOnRevoke();
			this.tutorResellerSettingsPage.clickOnOkButton();

			// Assertion for checking the revoke resellers text
			String revokeSuccessMessage = this.tutorResellerSettingsPage.getRevokeSuccessMessage();
			Assert.assertEquals(revokeSuccessMessage,
					expectedAssertionsProp.getProperty(RESELLERS_REVOKED_SUCCESSFULLY_TEXT));

			this.driver.navigate().refresh();
			Thread.sleep(2000);
			this.tutorResellerSettingsPage.clickOnEnable();
			Thread.sleep(2000);

			/*
			 * String txtEnableSuccess =
			 * this.resellerSettingsPage.getEnableSuccessMessage();
			 * Assert.assertEquals(txtEnableSuccess,
			 * expectedAssertionsProp.getProperty(ENABLED_SUCCESSFULLY_TEXT));
			 */

		} catch (Exception e) {
			Assert.fail("Exception occured while testing the Revoke Reseller Settings: " + e.getMessage());
			logger.error("Error occured while testing the the Revoke Reseller Settings");
		}

		logger.info("Ending of testRevokeResellers method");
	}

	@AfterClass
	public void quitDriver() {
		logger.info("Starting of quitDriver method");

		try {
			if (this.driver != null) {
				Thread.sleep(5000);
				this.loginPage.clickOnLogOut();
				this.quitDriver(this.driver, WEB_DRIVER.RESELLER_SETTINGS_TEST);
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