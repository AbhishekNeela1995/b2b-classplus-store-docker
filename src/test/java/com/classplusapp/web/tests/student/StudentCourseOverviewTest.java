package com.classplusapp.web.tests.student;

import static com.classplusapp.store.util.Constants.*;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.classplusapp.web.pages.student.StudentBuyCoursePage;
import com.classplusapp.web.pages.student.StudentCourseOverviewPage;
import com.classplusapp.web.tests.BaseClassplusAutomationTest;
import com.classplusapp.web.pages.student.StudentViewContentPage;
import com.classplusapp.web.pages.tutor.TutorAddContentPage;
import com.classplusapp.web.pages.tutor.TutorCreateCoursePage;
import com.classplusapp.web.tests.CommonFunctionStoreTest;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

public class StudentCourseOverviewTest extends BaseClassplusAutomationTest {

	private WebDriver driver = null;
	private WebDriver tutorDriver = null;
	private StudentCourseOverviewPage courseOverviewPage = null;
	private StudentBuyCoursePage buyCoursePage = null;
	private StudentViewContentPage viewContentPage = null;
	private static final Logger logger = Logger.getLogger(StudentCourseOverviewTest.class.getName());
	private CommonFunctionStoreTest storeCommonFunctions = null;
	private TutorCreateCoursePage createCoursePage = null;
	private TutorAddContentPage addContentPage = null;
	private String createdCourseName;

	@BeforeClass
	@Parameters({ "browser", "orgCode", "orgCode2" })
	public void initClassplusSiteLogin(@Optional("Chrome") String browser, @Optional("learn") String tutorOrgCode,
			@Optional("learn") String studentOrgCode) throws Exception {
		logger.info("Starting of initClassplusSiteLogin methond");

		this.driver = super.loginClassPlusSite(browser, studentOrgCode, studentMobileNumber, emailAddress,
				WEB_DRIVER.STUDENT_COURSE_OVERVIEW_TEST);

		this.tutorDriver = super.loginClassPlusSite(browser, tutorOrgCode, tutorMobileNumber, emailAddress,
				WEB_DRIVER.TUTOR_CREATE_COURSE_AUTOMATION_TESTING);

		this.courseOverviewPage = new StudentCourseOverviewPage(this.driver);
		this.buyCoursePage = new StudentBuyCoursePage(this.driver);
		this.viewContentPage = new StudentViewContentPage(this.driver);
		this.storeCommonFunctions = new CommonFunctionStoreTest();
		this.createCoursePage = new TutorCreateCoursePage(this.tutorDriver);
		this.addContentPage = new TutorAddContentPage(this.tutorDriver);

		createdCourseName = this.storeCommonFunctions.createCourseWithShipmentAndCertification(createCoursePage);

		this.storeCommonFunctions.addCourseContent(addContentPage, testDataProp.getProperty(LABEL_FOR_UPLOADING_IMAGE));
		String toastMsgText1 = this.addContentPage.getSuccessImageMessageText();
		Assert.assertEquals(toastMsgText1, expectedAssertionsProp.getProperty(IMAGE_ADDED_SUCCESSFULLY_TEXT));
		this.tutorDriver.navigate().refresh();
		this.addContentPage.unlockContent();
		String unlockMsg1 = this.addContentPage.unlockSuccessMessageText();
		Assert.assertEquals(unlockMsg1, expectedAssertionsProp.getProperty(EDIT_SUCCESSFUL_TEXT));

		this.storeCommonFunctions.addCourseContent(addContentPage, testDataProp.getProperty(LABEL_FOR_UPLOADING_PDF));
		String toastMsgText2 = this.addContentPage.getSuccessDocumentMessageText();
		Assert.assertEquals(toastMsgText2, expectedAssertionsProp.getProperty(ADD_DOCUMENT_SUCCESSFULLY_TEXT));
		this.tutorDriver.navigate().refresh();
		this.addContentPage.unlockContent();
		String unlockMsg2 = this.addContentPage.unlockSuccessMessageText();
		Assert.assertEquals(unlockMsg2, expectedAssertionsProp.getProperty(EDIT_SUCCESSFUL_TEXT));

		this.storeCommonFunctions.addCourseContent(addContentPage, testDataProp.getProperty(LABEL_FOR_UPLOADING_IMAGE));
		String toastMsgText3 = this.addContentPage.getSuccessImageMessageText();
		Assert.assertEquals(toastMsgText3, expectedAssertionsProp.getProperty(IMAGE_ADDED_SUCCESSFULLY_TEXT));
		this.tutorDriver.navigate().refresh();
		this.storeCommonFunctions.publishCourse(createCoursePage);

		logger.info("Ending of initClassplusSiteLogin method");
	}

	@Test(priority = 1, description = "Verify click on course thumbnail clickredirect to course overview")
	@Description("Test Description:Verify click on course thumbnail click redirect to course overview")
	@Severity(SeverityLevel.CRITICAL)
	@Story("Verify click on course thumbnail click redirect to course overview")
	public void testClickCourseThumbnail() {
		logger.info("Starting of testClickCourseThumbnail method");

		try {
			this.buyCoursePage.clickOnStoreButton();
			this.buyCoursePage.setSearch(createdCourseName);
			this.buyCoursePage.clickOnGetCourse(createdCourseName);
			Assert.assertTrue(this.courseOverviewPage.checkOverviewLbl());

		} catch (Exception e) {
			Assert.fail(
					"Exception occured while testing Verify click on course thumbnail click redirect to course overview : "
							+ e.getMessage());
			logger.error(
					"Error occured while testing Verify click on course thumbnail click redirect to course overview ",
					e);
		}

		logger.info("Ending of testClickCourseThumbnail method");
	}

	@Test(priority = 2, description = "Verify like count increases on clicking on like button")
	@Description("Test Description:Verify like count increases on clicking on like button")
	@Severity(SeverityLevel.CRITICAL)
	@Story("Verify like count increases on clicking on like button")
	public void testLikesCount() {
		logger.info("Starting of testLikesCount method");

		try {
			this.buyCoursePage.clickOnStoreButton();
			this.buyCoursePage.setSearch(createdCourseName);
			this.buyCoursePage.clickOnGetCourse(createdCourseName);
			this.courseOverviewPage.clickOnLikeButton();
			int LikeCount1 = this.courseOverviewPage.getCourseLikeCount();
			this.courseOverviewPage.clickOnLikeButton();
			int LikeCount2 = this.courseOverviewPage.getCourseLikeCount();

			Assert.assertEquals(1, Math.abs(LikeCount1 - LikeCount2));

		} catch (Exception e) {
			Assert.fail("Exception occured while testing Verify like count increases on clicking on like button : "
					+ e.getMessage());
			logger.error("Error occured while testing Verify like count increases on clicking on like button ", e);
		}

		logger.info("Ending of testLikesCount method");
	}

	@Test(priority = 3, description = "Verify course share button")
	@Description("Test Description:Verify course share button")
	@Severity(SeverityLevel.CRITICAL)
	@Story("Verify course share button")
	public void testCourseShareButton() {
		logger.info("Starting of testCourseShareButton method");

		try {
			this.buyCoursePage.clickOnStoreButton();
			this.buyCoursePage.setSearch(createdCourseName);
			this.buyCoursePage.clickOnGetCourse(createdCourseName);
			this.courseOverviewPage.clickOnShareCourseButton();
			// Whatsapp
			this.courseOverviewPage.clickOnShareWhatsappLink();
			Assert.assertTrue(this.courseOverviewPage.verifyPageUrl().contains(testDataProp.getProperty(WHATSAP_URL)),
					"ASSERTION FAILED:: Whatsap Url is not working");
			this.courseOverviewPage.closeWindow();
			// Facebook
			this.courseOverviewPage.clickOnShareFBLink();
			Assert.assertTrue(this.courseOverviewPage.verifyPageUrl().contains(testDataProp.getProperty(FACEBOOK_URL)),
					"ASSERTION FAILED:: Facebook Url is not working");
			this.courseOverviewPage.closeWindow();
			// Telegram
			this.courseOverviewPage.clickOnShareTelegramLink();
			Assert.assertTrue(this.courseOverviewPage.verifyPageUrl().contains(testDataProp.getProperty(TELEGRAM_URL)),
					"ASSERTION FAILED:: Telegram Url is not working");
			this.courseOverviewPage.closeWindow();
			// Linkden
			this.courseOverviewPage.clickOnShareLinkedinLink();
			Assert.assertTrue(this.courseOverviewPage.verifyPageUrl().contains(testDataProp.getProperty(LINKDIN_URL)),
					"ASSERTION FAILED:: Telegram Url is not working");
			this.courseOverviewPage.switchToNewWindow();
			this.courseOverviewPage.closeWindow();

			this.courseOverviewPage.closeShareCoursePopup();

		} catch (Exception e) {
			Assert.fail("Exception occured while testing Verify course share button : " + e.getMessage());
			logger.error("Error occured while testing Verify course share button ", e);
		}

		logger.info("Ending of testCourseShareButton method");
	}

	@Test(priority = 4, description = "Verify content count and duration inContent summary")
	@Description("Test Description:Verify content count and duration in Content summary")
	@Severity(SeverityLevel.CRITICAL)
	@Story("Verify content count and duration in Content summary")
	public void testContentCountInSummary() {
		logger.info("Starting of testContentCountInSummary method");

		try {
			this.buyCoursePage.clickOnStoreButton();
			this.buyCoursePage.setSearch(createdCourseName);
			this.buyCoursePage.clickOnGetCourse(createdCourseName);
			int contentCountInSummary = this.courseOverviewPage.getContentCountOfContentSummary();
			this.viewContentPage.clickOnContentButton();
			int contentCountInContentPage = this.courseOverviewPage.getContentCountFromContentPage();
			Assert.assertEquals(contentCountInSummary, contentCountInContentPage);
			this.courseOverviewPage.clickOnOverviewButton();
			Assert.assertTrue(this.courseOverviewPage.checkContentDuration());

		} catch (Exception e) {
			Assert.fail("Exception occured while testing Verify content count and duration in Content summary: "
					+ e.getMessage());
			logger.error("Error occured while testing Verify content count and duration in Content summary ", e);
		}

		logger.info("Ending of testContentCountInSummary method");
	}

	@Test(priority = 5, description = "Verify content count and duration in Content summary")
	@Description("Test Description:Verify content count and duration in Content summary")
	@Severity(SeverityLevel.CRITICAL)
	@Story("Verify content count and duration in Content summary")
	public void testFreeContentInContentSummary() {
		logger.info("Starting of testFreeContentInContentSummary method");

		try {
			this.buyCoursePage.clickOnStoreButton();
			this.buyCoursePage.setSearch(createdCourseName);
			this.buyCoursePage.clickOnGetCourse(createdCourseName);
			this.viewContentPage.clickOnContentButton();
			List<String> freeContentNameInContent = this.courseOverviewPage.getFreeContentInContent();
			this.courseOverviewPage.clickOnOverviewButton();
			List<String> freeContentNameInContentSummary = this.courseOverviewPage.getFreeContentInContentSummary();
			Assert.assertEquals(freeContentNameInContent.size(), freeContentNameInContentSummary.size());

			for (int i = 0; i < freeContentNameInContent.size(); i++) {

				Assert.assertEquals(freeContentNameInContent.get(i), freeContentNameInContentSummary.get(i));
			}
		} catch (Exception e) {
			Assert.fail("Exception occured while testing Verify content count and duration in Content summary: "
					+ e.getMessage());
			logger.error("Error occured while testing Verify content count and duration in Content summary ", e);
		}

		logger.info("Ending of testFreeContentInContentSummary method");
	}

	@Test(priority = 6, description = "Verify You may like courses section in overview page")
	@Description("Test Description:Verify You may like courses section in overview page")
	@Severity(SeverityLevel.CRITICAL)
	@Story("Verify You may like courses section in overview page")
	public void testYouMayLikeCoursesSection() {
		logger.info("Starting of testYouMayLikeCoursesSection method");

		try {
			this.buyCoursePage.clickOnStoreButton();
			this.buyCoursePage.setSearch(createdCourseName);
			this.buyCoursePage.clickOnGetCourse(createdCourseName);
			Assert.assertTrue(this.courseOverviewPage.checkYouMayLikeLbl());
			int countYouMayLikeCourse = this.courseOverviewPage.getCountOfYouMayLikeCourses();
			Assert.assertTrue(countYouMayLikeCourse > 0);

		} catch (Exception e) {
			Assert.fail("Exception occured while testing Verify You may like courses section in overview page: "
					+ e.getMessage());
			logger.error("Error occured while testing Verify You may like courses section in overview page ", e);
		}

		logger.info("Ending of testYouMayLikeCoursesSection method");
	}

	@Test(priority = 7, description = "Verify Price details section in overview page")
	@Description("Test Description:Verify Price details section in overview page")
	@Severity(SeverityLevel.CRITICAL)
	@Story("Verify Price details section in overview page")
	public void testPriceDetailsSections() {
		logger.info("Starting of testPriceDetailsSections method");

		try {
			this.buyCoursePage.clickOnStoreButton();
			this.buyCoursePage.setSearch(createdCourseName);
			this.buyCoursePage.clickOnGetCourse(createdCourseName);
			List<String> priceDetailsSectionsTitle = this.courseOverviewPage.getSectionTitlesInPriceDetails();
			Assert.assertEquals(priceDetailsSectionsTitle.get(0),
					testDataProp.getProperty(LABEL_COURSE_PRICE_IN_PRICE_DETAILS));
			Assert.assertTrue(this.courseOverviewPage.checkCoursePriceDiv());
			Assert.assertEquals(priceDetailsSectionsTitle.get(1), testDataProp.getProperty(LABEL_COURSE_PRICE_GST));
			Assert.assertTrue(this.courseOverviewPage.checkCoursePriceGst());
			Assert.assertEquals(priceDetailsSectionsTitle.get(2),
					testDataProp.getProperty(LABEL_INTERNET_FEES_IN_PRICE_DETAILS));
			Assert.assertTrue(this.courseOverviewPage.checkInternetFeesDiv());
			Assert.assertEquals(priceDetailsSectionsTitle.get(3),
					testDataProp.getProperty(LABEL_AMOUNT_PAYABLE_IN_PRICE_DETAILS));
			Assert.assertTrue(this.courseOverviewPage.checkAmountPayableDiv());

		} catch (Exception e) {
			Assert.fail(
					"Exception occured while testing Verify Price details section in overview page: " + e.getMessage());
			logger.error("Error occured while testing Verify Price details section in overview page ", e);
		}

		logger.info("Ending of testPriceDetailsSections method");
	}

	@Test(priority = 8, description = "Verify Offline Material and Certificaion Available tag")
	@Description("Test Description:Verify Offline Material and Certificaion Available tag")
	@Severity(SeverityLevel.CRITICAL)
	@Story("Verify Offline Material and Certificaion Available tag")
	public void testOfflineMaterialAndCertificationTag() {
		logger.info("Starting of testOfflineMaterialAndCertificationTag method");

		try {
			this.buyCoursePage.clickOnStoreButton();
			this.buyCoursePage.setSearch(createdCourseName);
			this.buyCoursePage.clickOnGetCourse(createdCourseName);
			Assert.assertTrue(this.courseOverviewPage.checkLblOfflineMaterial());
			Assert.assertTrue(this.courseOverviewPage.checkLblCertificationAvailable());

		} catch (Exception e) {
			Assert.fail("Exception occured while testing Verify Offline Material and Certificaion Available tag: "
					+ e.getMessage());
			logger.error("Error occured while testing Verify Offline Material and Certificaion Available tag", e);
		}

		logger.info("Ending of testOfflineMaterialAndCertificationTag method");
	}

	@AfterClass
	public void quitDriver() {
		logger.info("Starting of quitDriver method");

		try {
			if (this.driver != null) {
				Thread.sleep(5000);
				this.loginPage.clickOnLogOut();
				this.quitDriver(this.driver, WEB_DRIVER.STUDENT_COURSE_OVERVIEW_TEST);
				logger.info("Driver quit successfully");
			}
		} catch (Exception ex) {
			logger.error(ex.getMessage());
		}

		logger.info("Ending of quitDriver method");
	}

}
