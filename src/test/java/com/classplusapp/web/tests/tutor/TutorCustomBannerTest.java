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

import com.classplusapp.web.pages.tutor.TutorCustomBannerPage;
import com.classplusapp.web.tests.BaseClassplusAutomationTest;

import static com.classplusapp.store.util.Constants.*;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Epic("Store Custom Banners")
@Feature("Custom Banners Test")
public class TutorCustomBannerTest extends BaseClassplusAutomationTest {

	private WebDriver driver = null;
	private TutorCustomBannerPage tutorCustomBannerPage = null;

	private static final Logger logger = Logger.getLogger(TutorCustomBannerTest.class.getName());

	@BeforeClass
	@Parameters({ "browser", "orgCode"})
	public void initClassplusSiteLogin(@Optional("Chrome")String browser, @Optional("learn")String orgCode)
			throws Exception {
		logger.info("Starting of initClassplusSiteLogin methond");

		this.driver = super.loginClassPlusSite(browser, orgCode, tutorMobileNumber, emailAddress,
				WEB_DRIVER.CUSTOM_BANNER_TEST);
		this.tutorCustomBannerPage = new TutorCustomBannerPage(driver);

		logger.info("Ending of initClassplusSiteLogin method");
	}

	@Test(priority = 1, description = "Verify Upload Custom Banners")
	@Description("Test Description:Verify Upload Custom Banners")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Verify Upload Custom Banners")
	public void testUploadBannerImage() {
		logger.info("Starting of testUploadBannerImage method");

		try {
			this.tutorCustomBannerPage.clickOnNewIcon();

			// Assertion for checking the your Banners Label
			String yourBannersLabel = this.tutorCustomBannerPage.getYourBannersLabel();
			Assert.assertEquals(yourBannersLabel, expectedAssertionsProp.getProperty(LABEL_UPLOADBANNER_YOUR_BANNERS));

			this.tutorCustomBannerPage
					.clickOnUploadBannerImage(BASE_DIR + FILE_SEPARATOR + "src/main/resources/testdata/");

		} catch (Exception e) {
			Assert.fail("Exception occured while testing Upload Custom Banners:" + e.getMessage());
			logger.error("Error occured while testing Upload Custom Banners ", e);
		}

		logger.info("Ending of testUploadBannerImage method");
	}

	@Test(priority = 2, description = "Verify Publish Bannners in show Banners Page")
	@Description("Test Description: Verify Publish Bannners in show Banners Page")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Verify Publish Bannners in show Banners Page")
	public void testPublishBanners() {
		logger.info("Starting of testPublishBanners method");

		try {
			this.tutorCustomBannerPage.clickOnPublish();

			// Assertion for checking the publish confirmation Banners Label
			String PublishConfirmationLabel = this.tutorCustomBannerPage.getPublishConfirmationLabel();
			Assert.assertEquals(PublishConfirmationLabel,
					expectedAssertionsProp.getProperty(LABEL_PUBLISH_CONFIRMATION_BANNERS));

			this.tutorCustomBannerPage.clickOnYesPublish();

			// Assertion for checking the publish confirmation Banners text
			String bannersPublishMessage = this.tutorCustomBannerPage.getUpdatedBannersMessage();
			Assert.assertEquals(bannersPublishMessage,
					expectedAssertionsProp.getProperty(BANNERS_UPDATED_SUCCESSFULLY_TEXT));

		} catch (Exception e) {
			Assert.fail("Exception occured while testing Publish Bannners in show Banners Page: " + e.getMessage());
			logger.error("Error occured while testing Publish Bannners in show Banners Page ", e);
		}

		logger.info("Ending of clickOnPublishButton method");
	}

	@Test(priority = 3, description = "Verify Selecting Store Tab LandingScreen")
	@Description("Test Description: Verify Selecting Store Tab LandingScreen")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verify Selecting Store Tab LandingScreen")
	public void testStoreTabLandingScreen() {
		logger.info("Starting of testStoreTabLandingScreen  method");

		try {
			this.tutorCustomBannerPage.clickOnChangeButton();

			// Assertion for checking the landing screen label
			String labelSelectLAndingScreen = this.tutorCustomBannerPage.getSelectLandingScreenLabel();
			Assert.assertEquals(labelSelectLAndingScreen,
					expectedAssertionsProp.getProperty(LABEL_BANNERS_COURSE_SELECTSCREEN));

			this.tutorCustomBannerPage.clickOnStoreTab();
			this.tutorCustomBannerPage.clickDoneForStoreTab();
			
		} catch (Exception e) {
			Assert.fail("Exception occured while testing Selecting Store Tab LandingScreen: " + e.getMessage());
			logger.error("Error occured while testing Selecting Store Tab LandingScreen", e);
		}

		logger.info("Ending of testStoreTabLandingScreen method");
	}
	
	@Test(priority = 4, description = "Verify reordering of images page")
	@Description("Test Description: Verify reordering of images page")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verify reordering of images page")
	public void testReorderBanner() {
		logger.info("Starting of testReorderBanner  method");

		try {
			this.tutorCustomBannerPage.clickOnReorderMethod();
			this.tutorCustomBannerPage.clickOnSaveButton();
		} catch (Exception e) {
			logger.error("Error occured while testing reorder images method", e);
		}

		logger.info("Ending of testReorderBanner method");
	}

	@Test(priority = 5, description = "Verify Selecting LandingScreen Selcect Courses")
	@Description("Test Description: Verify Selecting LandingScreen Selcect Courses")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verify Selecting LandingScreen Select Courses")
	public void testCourseSelectLandingScreen() {
		logger.info("Starting of testCourseSelectLandingScreen  method");

		try {
			this.tutorCustomBannerPage.clickOnChangeButton();

			// Assertion for checking the landing screen label
			String labelSelectLAndingScreen = this.tutorCustomBannerPage.getSelectLandingScreenLabel();
			Assert.assertEquals(labelSelectLAndingScreen,
					expectedAssertionsProp.getProperty(LABEL_BANNERS_COURSE_SELECTSCREEN));

			this.tutorCustomBannerPage.clickOnSpecificCourses();
			this.tutorCustomBannerPage.clickSelectCourse();
			this.tutorCustomBannerPage.validateSearchCourse(testDataProp.getProperty(CUSTOM_BANNER_SEARCH_COURSE));
			this.tutorCustomBannerPage.clickOnCheckBoxOfSampling6();
			this.tutorCustomBannerPage.clickOnDoneButton();
			this.tutorCustomBannerPage.clickOnDone();
		} catch (Exception e) {
			Assert.fail("Exception occured while testing Selecting LandingScreen Select Courses : " + e.getMessage());
			logger.error("Error occured while testing Selecting LandingScreen Select Courses ", e);
		}

		logger.info("Ending of testCourseSelectLandingScreen method");
	}

	@Test(priority = 6, description = "Verify Selecting LandingScreen Courses")
	@Description("Test Description: Verify Selecting LandingScreen Courses")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verify Selecting LandingScreen Courses")
	public void testSelectLandingScreen() {
		logger.info("Starting of testSelectLandingScreen  method");

		try {
			this.tutorCustomBannerPage.clickOnChangeButton();

			// Assertion for checking the landing screen label
			String labelSelectLAndingScreen = this.tutorCustomBannerPage.getSelectLandingScreenLabel();
			Assert.assertEquals(labelSelectLAndingScreen,
					expectedAssertionsProp.getProperty(LABEL_BANNERS_COURSE_SELECTSCREEN));
			this.tutorCustomBannerPage.clickOnExternalLink();
			this.tutorCustomBannerPage.enterLinkInField(testDataProp.getProperty(CUSTOM_BANNER_EXTERNAL_LINK));
			this.tutorCustomBannerPage.clickOnDoneForExternalLink();
			this.tutorCustomBannerPage.clickOnChangeButton();
			this.tutorCustomBannerPage.clickOnYoutubeVideo();
			this.tutorCustomBannerPage.setYoutubeLink(testDataProp.getProperty(CUSTOM_BANNER_YOUTUBE_LINK));
			this.tutorCustomBannerPage.clickOnDoneForYoutubeVideo();
			this.tutorCustomBannerPage.clickOnChangeButton();
			this.tutorCustomBannerPage.clickOnFreeMaterial();
			this.tutorCustomBannerPage.clickOnDoneForFreeCourseMaterial();
		} catch (Exception e) {
			Assert.fail("Exception occured while testing landing screen courses: " + e.getMessage());
			logger.error("Error occured while testing landing Screen courses");
		}

		logger.info("Ending of testSelectLandingScreen  method");
	}
	
	@Test(priority = 7, description = "Verify Banner Publish when tutor change the banner image")
	@Description("Test Description: Verify Banner Publish when tutor change the banner image")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verify Banner Publish when tutor change the banner image")
	public void testBannerPublishWhenTutorChangeBannerImage() {
		logger.info("Starting of testBannerPublishWhenTutorChangeBannerImage  method");

		try {this.tutorCustomBannerPage.changeBannerImage();
		this.tutorCustomBannerPage.clickOnPublish();

		// Assertion for checking the publish confirmation Banners Label
		String PublishConfirmationLabel = this.tutorCustomBannerPage.getPublishConfirmationLabel();
		Assert.assertEquals(PublishConfirmationLabel,
				expectedAssertionsProp.getProperty(LABEL_PUBLISH_CONFIRMATION_BANNERS));

		this.tutorCustomBannerPage.clickOnYesPublish();

		// Assertion for checking the publish confirmation Banners text
		String bannersPublishMessage = this.tutorCustomBannerPage.getUpdatedBannersMessage();
		Assert.assertEquals(bannersPublishMessage,
				expectedAssertionsProp.getProperty(BANNERS_UPDATED_SUCCESSFULLY_TEXT));
	} catch (Exception e) {
			Assert.fail("Exception occured while updating banner image: " + e.getMessage());
			logger.error("Error occured while updating banner image");
		}

		logger.info("Ending of testBannerPublishWhenTutorChangeBannerImage  method");
	}
	

	@Test(priority = 8, description = "Verify Remove banners")

	@Description("Test Description:Verify Remove banners")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verify Remove banners")
	public void testRemoveBannners() {
		logger.info("Starting of testRemoveBannners method");

		try {
			Thread.sleep(2000);
			int size = this.tutorCustomBannerPage.getListOfRemoveBanners();
			
			for (int i = size; i > 0; i--) {
				this.tutorCustomBannerPage.clickOnRemoveButton();
				tutorCustomBannerPage.clickOnRemoveConfirmationButton();

				// Assertion for checking the removed banners text
				String removesuccess = this.tutorCustomBannerPage.getImageRemovedSuccessMessage();
				Assert.assertEquals(removesuccess,
						expectedAssertionsProp.getProperty(CUSTOM_BANNER_REMOVE_BANNERS_TEXT));
			}
		} catch (Exception e) {
			Assert.fail("Exception occured while testing remove banner: " + e.getMessage());
			logger.error("Error occured while testing the remove banners");
		}

		logger.info("Ending of testRemoveBannners method");
	}

	@Test(priority = 9, description = "Verify the publish bannners after removing the banners")
	@Description("Test Description:Verify the publish bannners after removing the banners")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verify the publish bannners after removing the banners")
	public void testRemovedBannersPublish() {
		logger.info("Starting of testRemovedBannersPublish method");

		try {
			this.tutorCustomBannerPage.clickOnPublish();

			// Assertion for checking the publish confirmation Banners Label
			String PublishConfirmationLabel = this.tutorCustomBannerPage.getPublishConfirmationLabel();
			Assert.assertEquals(PublishConfirmationLabel,
					expectedAssertionsProp.getProperty(LABEL_PUBLISH_CONFIRMATION_BANNERS));

			this.tutorCustomBannerPage.clickOnYesPublish();

			// Assertion for checking the publish removed Banners text
			String bannersPublishRemoveMessage = this.tutorCustomBannerPage.getPublishConformationRemoveMessage();
			Assert.assertEquals(bannersPublishRemoveMessage,
					expectedAssertionsProp.getProperty(BANNERS_PUBLISH_REMOVED_SUCCESSFULLY_TEXT));

		} catch (Exception e) {
			Assert.fail(
					"Exception occured while testing the publish images after removing the banners: " + e.getMessage());
			logger.error("Error occured while testing the publish images after removing the banners");
		}

		logger.info("Ending of testRemovedBannersPublish method");
	}

	@AfterClass
	public void quitDriver() {
		logger.info("Starting of quitDriver method");

		try {
			if (this.driver != null) {
				Thread.sleep(5000);
				this.loginPage.clickOnLogOut();
				this.quitDriver(this.driver, WEB_DRIVER.CUSTOM_BANNER_TEST);
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