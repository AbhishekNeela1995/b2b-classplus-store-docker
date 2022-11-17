

package com.classplusapp.web.tests.tutor;

import static com.classplusapp.store.util.Constants.*;

import java.time.LocalDateTime;
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

import com.classplusapp.web.pages.tutor.TutorNotificationPage;
import com.classplusapp.web.tests.BaseClassplusAutomationTest;
//import com.classplusapp.web.tests.BaseClassplusAutomationTest.WEB_DRIVER;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

public class TutorNotificationTest extends BaseClassplusAutomationTest {
	private WebDriver driver = null;
	private TutorNotificationPage notification = null;
//	private int beforeCount;
	private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yy/MM/dd-HH:mm:ss");

	private static final Logger logger = Logger.getLogger(TutorNotificationPage.class.getName());

	@BeforeClass
	@Parameters({ "browser", "orgCode"})
	public void initClassplusSiteLogin(@Optional("Chrome")String browser,@Optional("learn") String orgCode)
			throws Exception {
		logger.info("Starting of initClassplusSiteLogin methond");

		this.driver = super.loginClassPlusSite(browser, orgCode, tutorMobileNumber, emailAddress,
				WEB_DRIVER.NOTIFICATION_TEST);
		this.notification = new TutorNotificationPage(driver);

		logger.info("Ending of initClassplusSiteLogin method");
	}

	@Test(priority = 1, description = "Verify create Notification")
	@Description("Test Description:Verify create Notification")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Verify create Notification")
	public void createNotification() {
		logger.info("Starting of createNotification method");
		String currentDateTime = dtf.format(LocalDateTime.now());
		try {
			this.notification.clickOnNotifiacitonIcon();
			this.notification.clickOnCreateOption();
			this.notification.clickOnToPlusBtn();
			this.notification
					.sendTitle(testDataProp.getProperty(LABEL_CREATENOTIFICATION_PRE_TITLE_FOR_AUTOMATION_TESTING)
							+ currentDateTime);
			this.notification
					.sendText(testDataProp.getProperty(LABEL_CREATENOTIFICATION_PRE_DESCRIPTION_FOR_AUTOMATION_TESTING)
							+ currentDateTime);
			this.notification.selectFromLibray();
			this.notification.landingScreen();
			this.notification.send();
			Assert.assertEquals(this.notification.getSuccessMessage(),
					expectedAssertionsProp.getProperty(NOTIFICATION_SENT), "ASSERTION FAILED:: Notification not sent");
			Assert.assertEquals(this.notification.getSentNotificationTitle(),
					testDataProp.getProperty(LABEL_CREATENOTIFICATION_PRE_TITLE_FOR_AUTOMATION_TESTING)
							+ currentDateTime + " -",
					"ASSERTION FAILED:: Notification not shown");
			Assert.assertEquals(this.notification.getSentNotificationDescription(),
					testDataProp.getProperty(LABEL_CREATENOTIFICATION_PRE_DESCRIPTION_FOR_AUTOMATION_TESTING)
							+ currentDateTime,
					"ASSERTION FAILED:: Notification not shown");
		} catch (Exception e) {
			Assert.fail("Exception occured while testing create Notification:" + e.getMessage());
			logger.error("Error occured while testing create Notification ", e);
		}
		logger.info("Ending of createNotification method");
	}

	/**
	 * Add Image function is not working in input
	 */
//	@Test(priority = 2, description = "Verify create Notification_2")
//	@Description("Test Description:Verify create Notification")
//	@Severity(SeverityLevel.BLOCKER)
//	@Story("Verify create Notification_2")
	public void createNotification_2() {
		logger.info("Starting of createNotification_2 method");
		String currentDateTime = dtf.format(LocalDateTime.now());

		try {
			this.notification.clickOnNotifiacitonIcon();
			this.notification.clickOnCreateOption();
			this.notification.clickOnToPlusBtn();
			this.notification
					.sendTitle(testDataProp.getProperty(LABEL_CREATENOTIFICATION_PRE_DESCRIPTION_FOR_AUTOMATION_TESTING)
							+ currentDateTime);
			this.notification
					.sendText(testDataProp.getProperty(LABEL_CREATENOTIFICATION_PRE_TITLE_FOR_AUTOMATION_TESTING)
							+ currentDateTime);
			this.notification.addImage(BASE_DIR + FILE_SEPARATOR + "/src/main/resources/testdata/0.jpg");
			this.notification.landingScreen();
			this.notification.send();
			Assert.assertEquals(this.notification.getSuccessMessage(),
					expectedAssertionsProp.getProperty(NOTIFICATION_SENT), "ASSERTION FAILED:: Notification not sent");
			Assert.assertEquals(this.notification.getSentNotificationTitle(),
					testDataProp.getProperty(LABEL_CREATENOTIFICATION_PRE_TITLE_FOR_AUTOMATION_TESTING)
							+ currentDateTime + " -",
					"ASSERTION FAILED:: Notification not shown");
			Assert.assertEquals(this.notification.getSentNotificationDescription(),
					testDataProp.getProperty(LABEL_CREATENOTIFICATION_PRE_DESCRIPTION_FOR_AUTOMATION_TESTING)
							+ currentDateTime,
					"ASSERTION FAILED:: Notification not shown");
		} catch (Exception e) {
			Assert.fail("Exception occured while testing create Notification:" + e.getMessage());
			logger.error("Error occured while testing create Notification ", e);
		}
		logger.info("Ending of createNotification_2 method");
	}

	@Test(priority = 3, description = "Verify create schedule_Notification")
	@Description("Test Description:Verify create schedule_Notification")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Verify create schedule_Notification")
	public void scheduleNotification() {
		logger.info("Starting of create schedule_Notification method");
		String currentDateTime = dtf.format(LocalDateTime.now());

		try {
			this.notification.clickOnNotifiacitonIcon();
			this.notification.clickOnSeeAllBtn();
			int beforeCount = this.notification.getScheduledCount();
			this.notification.clickOnNotifiacitonIcon();
			this.notification.clickOnCreateOption();
			this.notification.clickOnToPlusBtn();
			this.notification
					.sendTitle(testDataProp.getProperty(LABEL_CREATENOTIFICATION_PRE_TITLE_FOR_AUTOMATION_TESTING)
							+ currentDateTime);
			this.notification
					.sendText(testDataProp.getProperty(LABEL_CREATENOTIFICATION_PRE_DESCRIPTION_FOR_AUTOMATION_TESTING)
							+ currentDateTime);
			this.notification.selectFromLibray();
			this.notification.selectDate();
			this.notification.selectTime();
			this.notification.landingScreen();
			this.notification.send();
			this.notification.clickOnscheduledNOtification();
			Assert.assertEquals(this.notification.getScheduledCount(), beforeCount + 1,
					"ASSERTION FAILED:: Scheduled count not matched");
			Assert.assertTrue(this.notification.getScheduledNotificationTitle(testDataProp.getProperty(LABEL_CREATENOTIFICATION_PRE_TITLE_FOR_AUTOMATION_TESTING)
					+ currentDateTime + " -"),
					"ASSERTION FAILED:: Notification not shown");
			Assert.assertTrue(this.notification.getScheduledNotificationDescription(
					testDataProp.getProperty(LABEL_CREATENOTIFICATION_PRE_DESCRIPTION_FOR_AUTOMATION_TESTING)
							+ currentDateTime),
					"ASSERTION FAILED:: Notification not shown");
		} catch (Exception e) {
			Assert.fail("Exception occured while testing create schedule_Notification:" + e.getMessage());
			logger.error("Error occured while testing create schedule_Notification", e);
		}
		logger.info("Ending of create schedule_Notification method");
	}

	@Test(priority = 4, description = "Verify edit schedule_Notification")
	@Description("Test Description:Verify edit schedule_Notification")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Verify edit schedule_Notification")
	public void editScheduleNotification() {
		logger.info("Starting of edit schedule_Notification method");
		String currentDateTime = dtf.format(LocalDateTime.now());

		try {
			this.notification.clickOnNotifiacitonIcon();
			this.notification.clickOnSeeAllBtn();
			this.notification.clickOnscheduledNOtification();
			this.notification.editNotification(0,
					testDataProp.getProperty(LABEL_EDITNOTIFICATION_PRE_TITLE_FOR_AUTOMATION_TESTING) + currentDateTime,
					testDataProp.getProperty(LABEL_EDITNOTIFICATION_PRE_DESCRIPTION_FOR_AUTOMATION_TESTING)
							+ currentDateTime);

			this.notification.send();

			Assert.assertEquals(this.notification.getTextSuccessMessage(),
					expectedAssertionsProp.getProperty(NOTIFICATION_EDIT),
					"ASSERTION FAILED:: Notification not edited");
			this.notification.clickOnscheduledNOtification();
			Assert.assertEquals(this.notification.getSentNotificationTitle(),
					testDataProp.getProperty(LABEL_EDITNOTIFICATION_PRE_TITLE_FOR_AUTOMATION_TESTING) + currentDateTime
							+ " -",
					"ASSERTION FAILED:: Edited Notification not shown");
			Assert.assertEquals(this.notification.getSentNotificationDescription(),
					testDataProp.getProperty(LABEL_EDITNOTIFICATION_PRE_DESCRIPTION_FOR_AUTOMATION_TESTING)
							+ currentDateTime,
					"ASSERTION FAILED:: Edited Notification not shown");
		} catch (Exception e) {
			Assert.fail("Exception occured while testing edit schedule_Notification:" + e.getMessage());
			logger.error("Error occured while testing edit schedule_Notification ", e);
		}
		logger.info("Ending of edit schedule_Notification method");
	}

	@Test(priority = 5, description = "Verify share schedule_Notification")
	@Description("Test Description:Verify share schedule_Notification")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Verify share schedule_Notification")
	public void shareScheduleNotification() {
		logger.info("Starting of share schedule_Notification method");

		try {
			this.notification.clickOnNotifiacitonIcon();
			this.notification.clickOnSeeAllBtn();
			this.notification.clickOnscheduledNOtification();
			this.notification.shareOnWhatsAppNotification(0);
			Assert.assertTrue(this.driver.getCurrentUrl().contains(expectedAssertionsProp.getProperty(URL_WHATSAPP)),
					"ASSERTION FAILED:: Whatsapp url not matched");
			this.notification.switchToParentWindow();
		} catch (Exception e) {
			this.notification.switchToParentWindow();
			Assert.fail("Exception occured while testing share schedule_Notification:" + e.getMessage());
			logger.error("Error occured while share schedule_Notification ", e);
		}
		logger.info("Ending of share schedule_Notification method");
	}

	@Test(priority = 6 ,description = "Verify delete schedule_Notification")
	@Description("Test Description:Verify delete schedule_Notification")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Verify delete schedule_Notification")
	public void deleteScheduleNotification() {
		logger.info("Starting of delete schedule_Notification method");

		try {
			this.notification.clickOnNotifiacitonIcon();
			this.notification.clickOnSeeAllBtn();
			this.notification.clickOnscheduledNOtification();
			int beforeCount = this.notification.getScheduledCount();
			this.notification.deleteNotification(0);
			Assert.assertEquals(this.notification.getSuccessMessage(),
					expectedAssertionsProp.getProperty(NOTIFICATION_DELETE),
					"ASSERTION FAILED:: Notification not deleted");
			Assert.assertEquals(this.notification.getScheduledCount() + 1, beforeCount,
					"ASSERTION FAILED:: Scheduled count not matched");

		} catch (Exception e) {
			Assert.fail("Exception occured while testing delete schedule_Notification:" + e.getMessage());
			logger.error("Error occured while testing delete schedule_Notification ", e);
		}
		logger.info("Ending of delete schedule_Notification method");
	}

	@AfterClass
	public void quitDriver() {
		logger.info("Starting of quitDriver method");

		try {
			if (this.driver != null) {
				Thread.sleep(50000);
				this.loginPage.clickOnLogOut();
				this.quitDriver(this.driver, WEB_DRIVER.NOTIFICATION_TEST);
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

		logger.info("Starting of getConsoleLogger method");
	}
}
