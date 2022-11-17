package com.classplusapp.web.tests.tutor;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static com.classplusapp.store.util.Constants.*;

import com.classplusapp.web.pages.tutor.TutorCreateInstallmentPage;
import com.classplusapp.web.pages.tutor.TutorMarkFeaturedPage;
import com.classplusapp.web.tests.BaseClassplusAutomationTest;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Epic("Store MarkFeatured Course")
@Feature("MarkFeaturedCourse Test")
public class TutorMarkFeaturedTest extends BaseClassplusAutomationTest {

	private WebDriver driver = null;
	private TutorMarkFeaturedPage tutorMarkfeaturedPage = null;
	private TutorCreateInstallmentPage tutorCreateInstallmentPage =null; 

	private static final Logger logger = Logger.getLogger(TutorMarkFeaturedTest.class.getName());

	@BeforeClass
	@Parameters({ "browser", "orgCode"})
	public void initClassplusSiteLogin(@Optional("Chrome")String browser, @Optional("learn")String orgCode)
			throws Exception {
		logger.info("Starting of initClassplusSiteLogin methond");

		String searchCourse = testDataProp.getProperty(MARKFEATURED_SEARCH_COURSE);
		this.driver = super.loginClassPlusSite(browser, orgCode, tutorMobileNumber, emailAddress,
				WEB_DRIVER.MARK_FEATURED_TEST);
		this.driver = super.clickOnStoreButton(driver, searchCourse);
		this.tutorMarkfeaturedPage = new TutorMarkFeaturedPage(driver);
        this.tutorCreateInstallmentPage = new TutorCreateInstallmentPage(driver);
		logger.info("Ending of initClassplusSiteLogin method");
	}

	@Test(priority = 1, description = "Verify Add Document")
	@Description("Test Description : Verify Add Document")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verify Add Document")
	public void testAddDocument() {
		logger.info("Starting of testAddDocument Method");

		try {
			this.tutorMarkfeaturedPage.clickOnCourseFolder();

			// Assertion for checking the mark featured label
			String lblMarkfeaturedCourse = this.tutorMarkfeaturedPage.getMarkfeaturedCourseLabel();
			Assert.assertEquals(lblMarkfeaturedCourse, expectedAssertionsProp.getProperty(LABEL_MARK_FEATURED_COURSE));

			this.tutorMarkfeaturedPage.clickOnContentButton();
			this.tutorMarkfeaturedPage.clickOnMenuDocumentIcon();

			// Assertion for checking the document added label
			String lblAddDocumentText = this.tutorMarkfeaturedPage.getlabelDocumentText();
			Assert.assertEquals(lblAddDocumentText, expectedAssertionsProp.getProperty(LABEL_ADD_DOCUMENT));

			this.tutorMarkfeaturedPage.setTextDocument(testDataProp.getProperty(ADDCONTENT_DOCUMENT_NAME));
			this.tutorMarkfeaturedPage.setTextDocDescription(testDataProp.getProperty(ADDCONTENT_DOCUMENT_DESCRIPTION));
			this.tutorMarkfeaturedPage.clickOnSelectDocumentButton();
			this.tutorMarkfeaturedPage.clickOnUploadDocumentButton();

			// Assertion for checking the document added text
			String documentSuccess = this.tutorMarkfeaturedPage.documentUploadedMessageText();
			Assert.assertEquals(documentSuccess, expectedAssertionsProp.getProperty(ADD_DOCUMENT_SUCCESSFULLY_TEXT));
		} catch (Exception e) {
			Assert.fail("Exception occured while testing  Add Document: " + e.getMessage());
			logger.error("Error occured while testing Add Document", e);
		}

		logger.info("Ending of testAddDocument method");
	}

	@Test(priority = 2, description = "Verify Add Image")
	@Description("Test Description:Verify Add Image")
	@Severity(SeverityLevel.CRITICAL)
	@Story("Verify Add Image")
	public void testAddImage() {
		logger.info("Starting of testAddImage method");

		try {
			this.tutorMarkfeaturedPage.clickOnMenuImageIcon();

			// Assertion for checking the image added label
			String lblAddImageText = this.tutorMarkfeaturedPage.getLabelAddImageText();
			Assert.assertEquals(lblAddImageText, expectedAssertionsProp.getProperty(LABEL_ADD_IMAGE));

			this.tutorMarkfeaturedPage.setTextImageName(testDataProp.getProperty(ADDCONTENT_IMAGE_NAME));
			this.tutorMarkfeaturedPage.setTextImageDescription(testDataProp.getProperty(ADDCONTENT_IMAGE_DESCRIPTION));
			this.tutorMarkfeaturedPage.setUploadImageButton();
			this.tutorMarkfeaturedPage.clickOnUploadImgButton();

			// Assertion for checking the image added text
			String imgSuccess = this.tutorMarkfeaturedPage.getSuccessImageMessageText();
			Assert.assertEquals(imgSuccess, expectedAssertionsProp.getProperty(IMAGE_ADDED_SUCCESSFULLY_TEXT));

		} catch (Exception e) {
			Assert.fail("Exception occured while testing Add Image: " + e.getMessage());
			logger.error("Error occured while Adding the Image");
		}

		logger.info("Ending of testAddImage Method");
	}

	@Test(priority = 3, description = "Verify Add zip file ")
	@Description("Test Description:Verify Add zip file ")
	@Severity(SeverityLevel.CRITICAL)
	@Story("Verify Add zip file")
	public void testAddZipFile() {
		logger.info("Starting of testAddZipFile method");

		try {
			this.tutorMarkfeaturedPage.clickOnMenuZipIcon();

			// Assertion for checking the zip file label
			String lblAddZip = this.tutorMarkfeaturedPage.getLabelAddZipText();
			Assert.assertEquals(lblAddZip, expectedAssertionsProp.getProperty(LABEL_ADD_ZIPFILE));

			this.tutorMarkfeaturedPage.setTextFileName(testDataProp.getProperty(ADDCONTENT_ZIPFILE_NAME));
			this.tutorMarkfeaturedPage.setTextDescription(testDataProp.getProperty(ADDCONTENT_ZIPFILE_DESCRIPTION));
			this.tutorMarkfeaturedPage.clickOnChooseFileButton();
			this.tutorMarkfeaturedPage.clickOnUploadZipButton();

			// Assertion for checking the zip file added text
			String fileSaveSuccessMessage = this.tutorMarkfeaturedPage.getSaveSuccessZipMessageText();
			Assert.assertEquals(fileSaveSuccessMessage,
					expectedAssertionsProp.getProperty(ZIPFILE_SAVE_SUCCESSFULLY_TEXT));

		} catch (Exception e) {
			Assert.fail("Exception occured while testing  Add Zip file: " + e.getMessage());
			logger.error("Error occured while testing Add zip file  ", e);
		}

		logger.info("Ending of testAddZipFile  method");
	}

	@Test(priority = 4, description = "Verify Publish course")
	@Description("Test Description:Verify Publish course")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verify Publish course")
	public void testPublishCourse() {
		logger.info("Starting of testPublishCourse method");

		try {
			// this.markfeaturedpage.clickOnContentButton();
			this.tutorMarkfeaturedPage.clickOnPublishCourseButton();

			// Assertion for checking the publish course label
			String lblPublishCourse = this.tutorMarkfeaturedPage.getPublishCourseLable();
			Assert.assertEquals(lblPublishCourse, expectedAssertionsProp.getProperty(LABEL_PUBLISH_COURSE));

			this.tutorMarkfeaturedPage.clickOnPublishCourseButton1();
			this.tutorMarkfeaturedPage.clickOnCrossButton();

			// Assertion for checking the publish course text
			String msgPublishSuccess = this.tutorMarkfeaturedPage.getPublishSuccessMessage();
			Assert.assertEquals(msgPublishSuccess, expectedAssertionsProp.getProperty(COURSE_PUBLISHED_TEXT));

		} catch (Exception e) {
			this.tutorMarkfeaturedPage.clickOnPublishCourseButton();
			this.tutorMarkfeaturedPage.clickOnPublishCourseButton1();
			this.tutorMarkfeaturedPage.clickOnCrossButton();

			Assert.fail("Exception occured while testing  Publish course " + e.getMessage());
			logger.error("Error occured while testing Publish course ", e);
		}

		logger.info("Ending of testPublishCourse method");
	}

	@Test(priority = 5, description = "verify markfeatured course ")
	@Description("Test Description : verify markfeatured course ")
	@Severity(SeverityLevel.NORMAL)
	@Story("verify markfeatured course ")
	public void testMarkFeaturedCourse() {
		logger.info("Starting of editMarkFeaturedList method");

		try {
			//this.tutorCreateCoursePage.clickOnOverviewLeftSide();
			this.tutorCreateInstallmentPage.closeInstallmentGotItPopup();
			this.tutorMarkfeaturedPage.clickOnVerticalMenuButton();
			this.tutorMarkfeaturedPage.clickOnMarkAsFeaturedButton();

			// Assertion for checking the featured courses text
			String lblCoursemarkedasfeatured = this.tutorMarkfeaturedPage.getCourseMarkedAsFeaturedLabel();
			Assert.assertEquals(lblCoursemarkedasfeatured,
					expectedAssertionsProp.getProperty(COURSE_MARK_AS_FEATURED_TEXT));

			this.tutorMarkfeaturedPage.clickOnEditMarkAsFeatured();

			// Assertion for checking the featured courses label
			String lblFeaturedCoursesList = this.tutorMarkfeaturedPage.getFeaturedCoursesListLabel();
			Assert.assertEquals(lblFeaturedCoursesList, expectedAssertionsProp.getProperty(LABEL_FEATURED_COURSELIST));

			this.tutorMarkfeaturedPage.clickOnRemoveButton();

			// Assertion for checking the removed course list text
			String msgCourseRemoved = this.tutorMarkfeaturedPage.getCourseRemovedMessage();
			Assert.assertEquals(msgCourseRemoved, expectedAssertionsProp.getProperty(COURSE_REMOVED_FROM_LIST_TEXT));

			this.tutorMarkfeaturedPage.clickOnRemoveButton();

			// Assertion for checking the course added text
			String msgCourseAddedBackToList = this.tutorMarkfeaturedPage.getCourseAddedBackToListMessage();
			Assert.assertEquals(msgCourseAddedBackToList,
					expectedAssertionsProp.getProperty(COURSE_ADDED_TO_LIST_TEXT));

			tutorMarkfeaturedPage.reorderImages(testDataProp.getProperty(MARKFEATURED_DRAGGABLE_ELEMENT_INDEX1),
					testDataProp.getProperty(MARKFEATURED_DRAGGABLE_ELEMENT_INDEX2));
			Thread.sleep(2000);

			// Assertion for checking the re-ordered list label
			String reorderListMessage = this.tutorMarkfeaturedPage.reorderListMessage();
			Assert.assertEquals(reorderListMessage, expectedAssertionsProp.getProperty(REORDER_LIST_SUCCESS_TEXT));

			this.tutorMarkfeaturedPage.clickOnSaveButton();

			// Assertion for checking the re-ordered course text
			String msgListUpdatedSucessfully = this.tutorMarkfeaturedPage.reorderSavedMessage();
			Assert.assertEquals(msgListUpdatedSucessfully,
					expectedAssertionsProp.getProperty(REORDER_LIST_SAVE_SUCCESSFULL_TEXT));

		} catch (Exception e) {
			Assert.fail("Exception occured while testing markfeatured course: " + e.getMessage());
			logger.error("Error occured while testing the markfeatured course");
		}

		logger.info("Ending of editMarkFeaturedList method");
	}

	@Test(priority = 6, description = "Verify Recommended Courses")
	@Description("Test Description :Verify Recommended Courses")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verify Recommended Courses")
	public void testRecommendedCourses() {
		logger.info("starting of addFilterInRecommendCourse method");

		try {
			this.tutorMarkfeaturedPage.clickOnVerticalMenuButton();
			this.tutorMarkfeaturedPage.clickOnRecommendCourse();
			this.tutorMarkfeaturedPage.clickOnFilterButton();

			// Assertion for checking the App download label
			String lblAppDownloads = this.tutorMarkfeaturedPage.getAppDownloadsLable();
			Assert.assertEquals(lblAppDownloads, expectedAssertionsProp.getProperty(LABEL_MARKFEATURE_APP_DOWNLOADS));

			this.tutorMarkfeaturedPage.clickOnallAppDownloads();
			this.tutorMarkfeaturedPage.clickOnApplyButton();
			this.tutorMarkfeaturedPage.clickOnBackSymbolButton();
		} catch (Exception e) {
			Assert.fail("Exception occured while testing  Recommended Courses: " + e.getMessage());
			logger.error("Error occured while testing the Recommended Courses");
		}

		logger.info("Ending of addFilterInRecommendCourse method");
	}

	@Test(priority = 7, description = "Verify Copy Course Link")
	@Description("Test Description : Verify Copy Course Link")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verify Copy Course Link")
	public void testCopyCourseLink() {
		logger.info("Starting of clickOnCopyCourseLinkButtton method");

		try {
			this.tutorMarkfeaturedPage.clickOnVerticalMenuButton();
			this.tutorMarkfeaturedPage.clickOnCopyCourseLink();

			// Assertion for checking the link copy text
			String msgLinkCopied = this.tutorMarkfeaturedPage.getLinkCopiedMessage();
			Assert.assertEquals(msgLinkCopied, expectedAssertionsProp.getProperty(MARKFEATURE_LINK_COPIED_TEXT));

		} catch (Exception e) {
			Assert.fail("Exception occured while testing  Copy Course Link: " + e.getMessage());
			logger.error("Error occured while testing Copy Course Link");
		}

		logger.info("Ending of clickOnCopyCourseLinkButtton method");
	}

	@Test(priority = 8, description = "Verify UnPublish course")
	@Description("Test Description:Verify UnPublish course")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verify UnPublish course")
	public void testUnPublishCourse() {
		logger.info("starting of testUnPublishCourse course");

		try {
			this.tutorMarkfeaturedPage.clickOnVerticalMenuButton();
			this.tutorMarkfeaturedPage.clickOnUnMarkfeatureButton();

			// Assertion for checking the removed featured courses text
			String msgUnmarkedSucceess = this.tutorMarkfeaturedPage.getUnmarkSuccessMessage();
			Assert.assertEquals(msgUnmarkedSucceess,
					expectedAssertionsProp.getProperty(COURSE_REMOVED_FROM_FEATURED_COURSES_TEXT));

			this.tutorMarkfeaturedPage.clickOnUnpublishCourseButton();

			// Assertion for checking the UnPublish course label
			String lblUnpublishConfirmation = this.tutorMarkfeaturedPage.getUnpublishConfirmationLabel();
			Assert.assertEquals(lblUnpublishConfirmation, expectedAssertionsProp.getProperty(LABEL_UNPUBLISH_COURSE));

			this.tutorMarkfeaturedPage.clickOnUnpublishButton();

			// Assertion for checking the UnPublish course text
			String msgUnpublishSuccess = this.tutorMarkfeaturedPage.getUnPublishSuccessMessage();
			Assert.assertEquals(msgUnpublishSuccess, expectedAssertionsProp.getProperty(UNPUBLISH_COURSE_TEXT));

		} catch (Exception e) {
			this.tutorMarkfeaturedPage.clickOnUnpublishCourseButton();
			this.tutorMarkfeaturedPage.clickOnUnpublishButton();
			Assert.fail("Exception occured while testing  UnPublish course " + e.getMessage());
			logger.error("Error occured while testing UnPublish course", e);
		}

		logger.info("Ending of testUnPublishCourse course");
	}

	@Test(priority = 9, description = "Verify Remove document ")
	@Description("Test Description:Verify Remove document ")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verify Remove document ")
	public void testRemoveDocument() {
		logger.info("Starting of testRemoveDocument method");

		try {
			this.tutorMarkfeaturedPage.clickOnContentButton();
			this.tutorMarkfeaturedPage.clickOnThreeDottedMenuForDocument();
			this.tutorMarkfeaturedPage.clickOnRemoveButtonForDocument();

			// Assertion for checking the document file deleted text
			String msgContentDeletedForDocument = this.tutorMarkfeaturedPage
					.getContentDeletedSuccesMessageForDocument();
			Assert.assertEquals(msgContentDeletedForDocument,
					expectedAssertionsProp.getProperty(CONTENT_DELETED_SUCCESSFULLY_TEXT));

		} catch (Exception e) {
			Assert.fail("Exception occured while testing Remove document : " + e.getMessage());
			logger.error("Error occured while testing Remove document ", e);
		}

		logger.info("Ending of testRemoveDocument method");
	}

	//@Test(priority = 10, description = "Verify Remove zip file ")
	@Description("Test Description:Verify Remove zip file ")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verify Remove zip file ")
	public void testRemoveZipFile() {
		logger.info("Starting of testRemoveZipFile method");

		try {
			this.tutorMarkfeaturedPage.clickOnThreeDottedMenuForZipFile();
			this.tutorMarkfeaturedPage.clickOnRemoveButtonForZipFile();

			// Assertion for checking the Zip file deleted text
			String msgContentDeletedForZip = this.tutorMarkfeaturedPage.getDeleteSuccessMessageForZipFile();
			Assert.assertEquals(msgContentDeletedForZip,
					expectedAssertionsProp.getProperty(CONTENT_DELETED_SUCCESSFULLY_TEXT));

		} catch (Exception e) {
			Assert.fail("Exception occured while testing  Remove ZIPfile: " + e.getMessage());
			logger.error("Error occured while testing Remove zip file ", e);
		}

		logger.info("Ending of testRemoveZipFile method");
	}

	@Test(priority = 11, description = "Verify Remove Image ")
	@Description("Test Description:Verify Remove Image")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verify Remove Image")
	public void testRemoveImage() {
		logger.info("Starting of testRemoveImage method");

		try {
			this.tutorMarkfeaturedPage.clickOnThreeDottedMenuForImage();
			this.tutorMarkfeaturedPage.clickOnRemoveButtonForImage();

			// Assertion for checking the image deleted text
			String txtContentDeletedSuccessfullyForImage = this.tutorMarkfeaturedPage.getDeleteSuccessMessageForImage();
			Assert.assertEquals(txtContentDeletedSuccessfullyForImage,
					expectedAssertionsProp.getProperty(CONTENT_DELETED_SUCCESSFULLY_TEXT));

		} catch (Exception e) {
			Assert.fail("Exception occured while testing  Remove Image: " + e.getMessage());
			logger.error("Error occured while testing Remove Image", e);
		}

		logger.info("Ending of testRemoveImage method");
	}

	@AfterClass
	public void quitDriver() {
		logger.info("Starting of quitDriver method");

		try {
			if (this.driver != null) {
				Thread.sleep(5000);
				this.loginPage.clickOnLogOut();
				this.quitDriver(this.driver, WEB_DRIVER.MARK_FEATURED_TEST);
				logger.info("Driver quit successfully");
			}
		} catch (Exception ex) {
			logger.error(ex.getMessage());
		}

		logger.info("Ending of quitDriver method");
	}

}