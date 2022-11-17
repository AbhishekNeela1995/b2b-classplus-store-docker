package com.classplusapp.web.tests.parent;

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

import com.classplusapp.web.pages.ClassplusLoginPage;
import com.classplusapp.web.pages.parent.ParentViewContentPage;
import com.classplusapp.web.tests.BaseClassplusAutomationTest;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Epic("Store Overview")
@Feature("Parent View Content Test")
public class ParentViewContentTest extends BaseClassplusAutomationTest {

	private WebDriver driver = null;
	private ParentViewContentPage parentViewContentPage = null;

	private static final Logger logger = Logger.getLogger(ParentViewContentTest.class.getName());

	@BeforeClass
	@Parameters({ "browser", "orgCode4" })
	public void initClassplusSiteLogin(@Optional("Chrome")String browser,@Optional("learn") String orgCode)
			throws Exception {
		logger.info("Starting of initClassplusSiteLogin methond");

		this.driver = super.loginClassPlusSite(browser, orgCode, parentMobileNumber, emailAddress,
				WEB_DRIVER.PARENT_VIEW_CONTENT_TEST);
		this.parentViewContentPage = new ParentViewContentPage(this.driver);

		logger.info("Ending of initClassplusSiteLogin method");
	}

	@Test(priority = 1, description = "Verify Parent Select Course Page")
	@Description("Test Description:Verify Parent Select Course Page")
	@Severity(SeverityLevel.CRITICAL)
	@Story("Verify Parent Select Course Page")
	public void testSelectCourse() {
		logger.info("Starting of testSelectCourse method");

		try {
			Thread.sleep(3000);
			this.driver.navigate().refresh();
			Thread.sleep(4000);
			this.parentViewContentPage.clickOnStorebutton();

			String lblFilterByTopics = this.parentViewContentPage.getFilterByTopicsLabel();
			Assert.assertEquals(lblFilterByTopics, expectedAssertionsProp.getProperty(LABEL_PARENT_VIEW_COURSE_FILTER));

			this.parentViewContentPage.setSearchArea(testDataProp.getProperty(PARENT_SEARCH_COURSE));
			Thread.sleep(2000);
			this.parentViewContentPage.clickOnGetCourse();
			Thread.sleep(2000);
			this.parentViewContentPage.clickOnContentButton();
		} catch (Exception e) {
			Assert.fail("Exception occured while testing Parent Select Course : " + e.getMessage());
			logger.error("Error occured while testing Select Course ", e);
		}

		logger.info("Ending of testSelectCourse method");
	}

	@Test(priority = 2, description = "Verify Parent View Folder Page")
	@Description("Test Description:Verify Parent View Folder Page")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verify Parent View Folder Page")
	public void testViewFolder() {
		logger.info("Starting of testViewFolder method");

		try {
			this.parentViewContentPage.clickOnFilesMenu();
			this.parentViewContentPage.clickOnImagesB2b();

			String lblContentCannotViewed = this.parentViewContentPage.getContentCannotViewedLabel();
			Assert.assertEquals(lblContentCannotViewed,
					expectedAssertionsProp.getProperty(LABEL_PARENT_CONTENT_CANNOT_VIEWED));

			this.parentViewContentPage.clickOnCancelImage();
			Thread.sleep(3000);
			this.parentViewContentPage.clickOnPreviousIcon();
		} catch (Exception e) {
			Assert.fail("Exception occured while testing Parent View Folder Page : " + e.getMessage());
			logger.error("Error occured while testing Parent View Folder Page ", e);
		}

		logger.info("Ending of testViewFolder method");
	}

	@Test(priority = 3, description = "Verify Parent View Video")
	@Description("Test Description:Verify Parent View Video")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Verify Parent View Video")
	public void testViewVideo() {
		logger.info("Starting of testViewVideo method");

		try {
			this.parentViewContentPage.clickOnVideoTest();

			String lblContentCannotViewed = this.parentViewContentPage.getContentCannotViewedLabel();
			Assert.assertEquals(lblContentCannotViewed,
					expectedAssertionsProp.getProperty(LABEL_PARENT_CONTENT_CANNOT_VIEWED));

			this.parentViewContentPage.clickOnVideoTestCancel();
			Thread.sleep(3000);
		} catch (Exception e) {
			Assert.fail("Exception occured while testing  Parent View Video: " + e.getMessage());
			logger.error("Error occured while testing  View Video", e);
		}

		logger.info("Ending of testViewVideo method");
	}

	@Test(priority = 4, description = "Verify Parent View Image")
	@Description("Test Description:Verify Parent View Image")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verify Parent View Image")
	public void testViewImage() {
		logger.info("Starting of testviewImage method");

		try {
			this.parentViewContentPage.clickOnSampleImage();

			String lblContentCannotViewed = this.parentViewContentPage.getContentCannotViewedLabel();
			Assert.assertEquals(lblContentCannotViewed,
					expectedAssertionsProp.getProperty(LABEL_PARENT_CONTENT_CANNOT_VIEWED));

			this.parentViewContentPage.clickOnCancelImage();
		} catch (Exception e) {
			Assert.fail("Exception occured while testing View Image: " + e.getMessage());
			logger.error("Error occured while testing View Image ", e);
		}

		logger.info("Ending of testviewImage method");
	}

	@Test(priority = 5, description = "Verify student View Document")
	@Description("Test Description:Verify student View Document")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Verify student View Document")
	public void testViewDocument() {
		logger.info("Starting of testviewDocument method");

		try {
			this.parentViewContentPage.clickOnDocumentSample();
			Thread.sleep(3000);

			String lblContentCannotViewed = this.parentViewContentPage.getContentCannotViewedLabel();
			Assert.assertEquals(lblContentCannotViewed,
					expectedAssertionsProp.getProperty(LABEL_PARENT_CONTENT_CANNOT_VIEWED));

			this.parentViewContentPage.clickOnCancelImage();
		} catch (Exception e) {
			Assert.fail("Exception occured while testing   View Document: " + e.getMessage());
			logger.error("Error occured while testing  View Document", e);
		}

		logger.info("Ending of testviewDocument method");
	}

	@Test(priority = 6, description = "Verify Parent Download ZipFile")
	@Description("Test Description:Verify Parent Download ZipFile")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Verify Parent Download ZipFile")
	public void testViewZipFile() {
		logger.info("Starting of testDownloadZipFile method");

		try {
			this.parentViewContentPage.clickOnSampleZipFile();
			Thread.sleep(3000);

			String lblContentCannotViewed = this.parentViewContentPage.getContentCannotViewedLabel();
			Assert.assertEquals(lblContentCannotViewed,
					expectedAssertionsProp.getProperty(LABEL_PARENT_CONTENT_CANNOT_VIEWED));

			this.parentViewContentPage.clickOnCancelImage();
		} catch (Exception e) {
			Assert.fail("Exception occured while testing  Download ZipFile: " + e.getMessage());
			logger.error("Error occured while testing Download ZipFile ", e);
		}

		logger.info("Ending of testDownloadZipFile method");
	}

	@Test(priority = 7, description = "Verify Parent Talk to Tutor")
	@Description("Test Description:Verify Parent Talk to Tutor")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verify Parent Talk to Tutor")
	public void testTalkToTutor() {
		logger.info("Starting of testTalkToTutor method");

		try {
			this.parentViewContentPage.clickOnTalkToTutorButton();

			Thread.sleep(5000);
			String lblChats = this.parentViewContentPage.getChatsLabelText();
			Assert.assertEquals(lblChats, expectedAssertionsProp.getProperty(PARENT_VIEW_CONTENT_TALK_TO_TUTOR));

			Thread.sleep(3000);
			this.parentViewContentPage.setMessageToTutor(testDataProp.getProperty(PARENT_MESSAGE_TO_TUTOR));
			Thread.sleep(5000);
			this.parentViewContentPage.clickOnSendMessage();
		} catch (Exception e) {
			Assert.fail("Exception occured while testing  Parent Talk to Tutor: " + e.getMessage());
			logger.error("Error occured while testing Parent Talk to Tutor", e);
		}

		logger.info("Ending of testTalkToTutor method");
	}

	@Test(priority = 8, description = "Verify Parent Copy Course Link")
	@Description("Test Description:Verify Parent Copy Course Link")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verify Parent Copy Course Link")
	public void testCopyCourseLink() {
		logger.info("Starting of testCopyCourseLink method");

		try {
			this.parentViewContentPage.getWebDriver().navigate().back();
			this.parentViewContentPage.clickOnOverviewButton();
			this.parentViewContentPage.clickOnShareButton();
			this.parentViewContentPage.clickOnCopyLinkButton();

			String linkcopied = this.parentViewContentPage.getCourseLinkText();
			Assert.assertEquals(linkcopied, expectedAssertionsProp.getProperty(PARENT_LINK_COPIED_TEXT));

		} catch (Exception e) {
			Assert.fail("Exception occured while testing  Parent Copy Course Link: " + e.getMessage());
			logger.error("Error occured while testing Copy Course Link ", e);
		}

		logger.info("Ending of testCopyCourseLink method");
	}

	@AfterClass
	public void quitDriver() {
		logger.info("Starting of quitDriver method");

		try {
			if (driver != null) {
				this.loginPage.clickOnLogOut();
				this.quitDriver(this.driver, WEB_DRIVER.PARENT_VIEW_CONTENT_TEST);
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
