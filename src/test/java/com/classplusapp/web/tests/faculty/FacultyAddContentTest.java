
package com.classplusapp.web.tests.faculty;

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

import java.io.File;

import com.classplusapp.web.pages.faculty.FacultyAddContentPage;
import com.classplusapp.web.pages.tutor.TutorAddContentPage;
import com.classplusapp.web.pages.tutor.TutorCreateInstallmentPage;
import com.classplusapp.web.tests.BaseClassplusAutomationTest;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Epic("Store Course content")
@Feature("Faculty Add Content Test")
public class FacultyAddContentTest extends BaseClassplusAutomationTest {

	private WebDriver driver = null;
	private FacultyAddContentPage facultyAddContentPage = null;
	private String editFolderName;

	private static final Logger logger = Logger.getLogger(FacultyAddContentTest.class.getName());
	private TutorCreateInstallmentPage tutorCreateInstallmentPage = null;
	private TutorAddContentPage tutorAddContentPage = null;

	@BeforeClass
	@Parameters({ "browser", "orgCode3" })
	public void initClassplusSiteLogin(@Optional("Chrome")String browser,@Optional("learn") String orgCode)
			throws Exception {
		logger.info("Starting of initClassplusSiteLogin method");

		this.driver = super.loginClassPlusSite(browser, orgCode, facultyOneMobileNumber, emailAddress,
				WEB_DRIVER.FACULTY_ADD_CONTENT_TEST);
		this.facultyAddContentPage = new FacultyAddContentPage(this.driver);
		this.tutorCreateInstallmentPage = new TutorCreateInstallmentPage(this.driver);
		this.tutorAddContentPage = new TutorAddContentPage(this.driver);

		logger.info("Ending of initClassplusSiteLogin method");
	}

	@Test(priority = 1, description = "Verify Add content Page")
	@Description("Test Description:Verify Add content Page")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Verify Add content Page")
	public void testAddContent() {
		logger.info("Starting of testAddContent method");

		try {
			this.facultyAddContentPage.clickOnStoreButton();
			Thread.sleep(2000);

			// Assertion for checking the My courses Label
			String myCoursesLabel = this.facultyAddContentPage.getMyCoursesPage();
			Assert.assertEquals(myCoursesLabel, expectedAssertionsProp.getProperty(LABEL_FACULTY_MYCOURSES));

			this.facultyAddContentPage.clickOnTxtSearchCourse(testDataProp.getProperty(FACULTY_SEARCH_COURSE));
			this.facultyAddContentPage.clickOnGetCourseFolder();
			this.facultyAddContentPage.clickOnContentButton();

			// Assertion for checking the Add content Label
			String addContentText = this.facultyAddContentPage.getAddContentLabel();
			Assert.assertEquals(addContentText, expectedAssertionsProp.getProperty(LABEL_ADD_FOLDER));

		} catch (Exception e) {
			Assert.fail("Exception occured while testing addContent Page: " + e.getMessage());
			logger.error("Error occured while testing Add content Page", e);
		}

		logger.info("Ending of testAddContent method");
	}

	@Test(priority = 2, description = "Verify Add Folder")
	@Description("Test Description:Verify Add Folder")
	@Severity(SeverityLevel.CRITICAL)
	@Story("Verify Add Folder")
	public void testAddFolder() {
		logger.info("Starting of testAddFolder method");

		try {
			Thread.sleep(3000);
			this.facultyAddContentPage.clickOnMenuAddFolderIcon();

			// Assertion for checking the B2b content Label
			String lblB2bContent = this.facultyAddContentPage.getB2bAddContentLabel();
			Assert.assertEquals(lblB2bContent, expectedAssertionsProp.getProperty(LABEL_FACULTY_ADD_CONTENT));

			this.facultyAddContentPage.setFolderName(testDataProp.getProperty(ADDCONTENT_FOLDER_NAME));
			String addFolderName = "Automation_FolderName" + System.currentTimeMillis();
			this.facultyAddContentPage.setFolderName(addFolderName);
			this.facultyAddContentPage.clickOnSaveFolderButton();

			// Assertion for checking the save folder text
			String msgSaveFolderName = this.facultyAddContentPage.getSaveSuccessMessageText();
			Assert.assertEquals(msgSaveFolderName, expectedAssertionsProp.getProperty(SAVE_FOLDER_SUCCESSFULLY_TEXT));

		} catch (Exception e) {
			Assert.fail("Exception occured while testing Add Folder: " + e.getMessage());
			logger.error("Error occured while testing Add Folder ", e);
		}

		logger.info("Ending of testAddFolder method");
	}

	@Test(priority = 3, description = "Verify Edit Folder")
	@Description("Test Description:Verify Edit Folder")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verify Edit Folder")
	public void testEditFolder() {
		logger.info("Starting of testEditFolder method");

		try {
			this.facultyAddContentPage.clickOnMenuVerticalIcon2();
			this.facultyAddContentPage.clickOnMenuEditButton();

			// Assertion for checking the Edit content Label
			String lblEditContent = this.facultyAddContentPage.getLabelEditContentText();
			Assert.assertEquals(lblEditContent, expectedAssertionsProp.getProperty(LABEL_EDIT_FOLDER));

			this.facultyAddContentPage.setFolder(testDataProp.getProperty(ADDCONTENT_EDIT_FOLDER_NAME));
			editFolderName = "Automation_EditFolderName" + System.currentTimeMillis();
			this.facultyAddContentPage.setFolder(editFolderName);
			this.facultyAddContentPage.clickOnEditSaveButton();

			// Assertion for checking the Edit folder text
			String msgEditFolder = this.facultyAddContentPage.getEditSuccessMessageText();
			Assert.assertEquals(msgEditFolder, expectedAssertionsProp.getProperty(FOLDER_EDITED_SUCCESSFULLY_TEXT));

		} catch (Exception e) {
			Assert.fail("Exception occured while testing Edit Folder: " + e.getMessage());
			logger.error("Error occured while testing Edit Folder ", e);
		}

		logger.info("Ending of editFolder method");
	}

	@Test(priority = 4, description = "Verify Remove Folder")
	@Description("Test Description:Verify Remove Folder")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verify Remove Folder")
	public void testRemoveFolder() {
		logger.info("Starting of testRemoveFolder method");

		try {
			this.facultyAddContentPage.clickOnMenuVerticalIcon1();
			this.facultyAddContentPage.clickOnRemoveFolderButton();

			// Assertion for checking the delete content Label
			String lblDeleteContent = this.facultyAddContentPage.getLabelDeleteContentText();
			Assert.assertEquals(lblDeleteContent, expectedAssertionsProp.getProperty(DELETE_FOLDER_TEXT));

			this.facultyAddContentPage.clickOnConfirmRemoveButton();
		} catch (Exception e) {
			Assert.fail("Exception occured while testing Remove Folder: " + e.getMessage());
			logger.error("Error occured while testing Remove Folder ", e);
		}

		logger.info("Ending of testRemoveFolder method");
	}

	@Test(priority = 5, description = "Verify Add video")
	@Description("Test Description:Verify Add video")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verify Add video")
	public void testAddVideo() {
		logger.info("Starting of addVideo method");

		try {
			this.facultyAddContentPage.clickOnMenuAddVideoIcon();
			// this.addcontentpage.clickOnVideo();

			// Assertion for checking the Add Video Label
			String addVideoLabel = this.facultyAddContentPage.getAddVideoLabelText();
			Assert.assertEquals(addVideoLabel, expectedAssertionsProp.getProperty(LABEL_ADD_VIDEO_HEADING));

			this.facultyAddContentPage.uploadVideoButton(System.getProperty("user.dir")
					+ System.getProperty("file.separator") + testDataProp.getProperty(ADDCONTENT_UPLOAD_LINUX_VIDEO));
			System.out.println(testDataProp.getProperty(ADDCONTENT_UPLOAD_LINUX_VIDEO));
			//this.facultyAddContentPage.uploadVideoButton(facultyAddContentPage.TEST_FILE_PATH + File.separator
				//	+ testDataProp.getProperty(ADDCONTENT_UPLOAD_LINUX_VIDEO));
			this.facultyAddContentPage.clickOnDoneButton();
			this.facultyAddContentPage.clickOnStoreButton();
			this.facultyAddContentPage.clickOnTxtSearchCourse(testDataProp.getProperty(FACULTY_SEARCH_COURSE));
			this.facultyAddContentPage.clickOnGetCourseFolder();
			this.facultyAddContentPage.clickOnContentButton();
		} catch (Exception e) {
			Assert.fail("Exception occured while testing  add video: " + e.getMessage());
			logger.error("Error occured while testing Add video ", e);
		}

		logger.info("Ending of addVideo method");
	}

	@Test(priority = 6, description = "Verify Remove Video")
	@Description("Test Description:Verify Remove Video")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verify Remove Video")
	public void testRemoveVideo() {
		logger.info("Starting of testRemoveVideo method");

		try {
			this.facultyAddContentPage.clickOnRemoveVideo();
			this.facultyAddContentPage.clickOnRemoveVideoButton();
			// Assertion for checking the remove video text
			String removeVedioMessage = this.facultyAddContentPage.videoRemoveMessageText();
			Assert.assertEquals(removeVedioMessage,
					expectedAssertionsProp.getProperty(CONTENT_DELETED_SUCCESSFULLY_TEXT));

		} catch (Exception e) {
			Assert.fail("Exception occured while testing  Remove Video: " + e.getMessage());
			logger.error("Error occured while testing Remove Video ", e);
		}
		logger.info("Ending of testRemoveVideo method");
	}

	@Test(priority = 7, description = "Verify Add Subjective Test")
	@Description("Test Description:Verify Add Subjective Test")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verify Add Subjective Test")
	public void testAddSubjectiveTest() {
		logger.info("Starting of testAddSubjectiveTest method");

		try {
			this.facultyAddContentPage.clickOnMenuSubjectiveTestIcon();

			// Assertion for checking the Subjective Test Label
			String lblSubjectiveTest = this.facultyAddContentPage.getSubjectiveTestLabel();
			Assert.assertEquals(lblSubjectiveTest, expectedAssertionsProp.getProperty(LABEL_ADD_SUBJECTIVETEST));

			this.facultyAddContentPage.clickOnCreateNewTestButton();

			// Assertion for checking the Create New Subjective Test Label
			String lblCreateNewSubjectiveTest = this.facultyAddContentPage.getCreateNewSubjectiveTestLabel();
			Assert.assertEquals(lblCreateNewSubjectiveTest,
					expectedAssertionsProp.getProperty(LABEL_CREATE_SUBJECTIVETEST));

			this.facultyAddContentPage.setTextTestName(testDataProp.getProperty(ADDCONTENT_SUBJECTIVETEST_TESTNAME));
			this.facultyAddContentPage
					.clickOnTextTotalMarks(testDataProp.getProperty(ADDCONTENT_SUBJECTIVETEST_TOTALMARKS));
			this.facultyAddContentPage.clickOnAddFilesButton();

			// Assertion for checking the Subjective Test created text
			String fileSaveSuccessMessage = this.facultyAddContentPage.getSaveSubjSuccessMessage();
			Assert.assertEquals(fileSaveSuccessMessage,
					expectedAssertionsProp.getProperty(SUBJECTIVETEST_UPLOADED_SUCCESSFULLY_TEXT));

			this.facultyAddContentPage.clickOnCreateAndAddTestButton();
		} catch (Exception e) {
			Assert.fail("Exception occured while testing  add Subjective test: " + e.getMessage());
			logger.error("Error occured while testing Add Subjective Test ", e);
		}

		logger.info("Ending of testAddSubjectiveTest method");
	}

	@Test(priority = 8, description = "Verify view stats")
	@Description("Test Description: Verify view stats")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verify view stats")
	public void testViewStatsTest() {
		logger.info("Starting of testViewStatsTest method");

		// try {
		this.facultyAddContentPage.clickOnStoreButton();

		this.facultyAddContentPage
				.clickOnTxtSearchCourse(testDataProp.getProperty(FACULTY_SEARCH_COURSE));
		this.facultyAddContentPage.clickOnGetCourseFolder();
		this.facultyAddContentPage.clickOnContentButton();

		String viewStatsLabelText = this.facultyAddContentPage.getViewStatsLabelText();
		Assert.assertEquals(viewStatsLabelText, expectedAssertionsProp.getProperty(VIEW_STATS_LABEL_TEXT));

		this.facultyAddContentPage.clickOnViewStats();

		Assert.assertTrue(this.facultyAddContentPage.isStatsHearderDisplayed());

		/*
		 * String yourScoreNameLabelText =
		 * this.facultyAddContentPage.getYourScoreNameLabelText();
		 * Assert.assertEquals(yourScoreNameLabelText,
		 * expectedAssertionsProp.getProperty(YOUR_SCORE_NAME_LABEL_TEXT));
		 */

		this.facultyAddContentPage.clickOnCloseImage();
		//this.facultyAddContentPage.clickOnViewAnswerSheetButton();
		this.facultyAddContentPage.clickOnPreviewSubjectiveTest();
		String downloadText = this.facultyAddContentPage.getDownloadText();
		Assert.assertEquals(downloadText, expectedAssertionsProp.getProperty(DOWNLOAD_BUTTON_TEXT));

		this.facultyAddContentPage.clickOnDownloadButton();
		
		Assert.assertEquals(this.facultyAddContentPage.getDownloadQuestionPaperMessage(), expectedAssertionsProp.getProperty(DOWNLOAD_QUESTION_PAPER_MESSAGE));
		//driver.close();
		
		/*
		 * } catch (Exception e) {
		 * Assert.fail("Exception occured while testing view stats: " + e.getMessage());
		 * logger.error("Error occured while testing view stats", e); }
		 */

		logger.info("Ending of testViewStatsTest method");
	}

	@Test(priority = 9, description = "Verify Add Document")
	@Description("Test Description:Verify Add Document")
	@Severity(SeverityLevel.CRITICAL)
	@Story("Verify Add Document")
	public void testAddDocument() {
		logger.info("Starting of testAddDocument method");

		try {
			this.facultyAddContentPage.clickOnMenuDocumentIcon();

			// Assertion for checking the Add Document Label
			String lblAddDocumentText = this.facultyAddContentPage.getLabelDocumentText();
			Assert.assertEquals(lblAddDocumentText, expectedAssertionsProp.getProperty(LABEL_ADD_DOCUMENT));

			this.facultyAddContentPage.setTextDocument(testDataProp.getProperty(ADDCONTENT_DOCUMENT_NAME));
			this.facultyAddContentPage.setTextDocDescription(testDataProp.getProperty(ADDCONTENT_DOCUMENT_DESCRIPTION));
			this.facultyAddContentPage.clickOnSelectDocumentButton();
			this.facultyAddContentPage.clickOnUploadDocumentButton();

			// Assertion for checking the Add Document text
			String documentSuccess = this.facultyAddContentPage.documentUploadedMessageText();
			Assert.assertEquals(documentSuccess, expectedAssertionsProp.getProperty(ADD_DOCUMENT_SUCCESSFULLY_TEXT));

		} catch (Exception e) {
			Assert.fail("Exception occured while testing  Add Document: " + e.getMessage());
			logger.error("Error occured while testing Add Document", e);
		}

		logger.info("Ending of testAddDocument method");
	}

	@Test(priority = 10, description = "Verify Edit Document")
	@Description("Test Description:Verify Edit Document")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verify Edit Document")
	public void testEditDocument() {
		logger.info("Starting of testEditDocument method");

		try {
			this.facultyAddContentPage.clickOnLockZipButton();

			// Assertion for checking the edit Document text
			String lockMessageSavedText = this.facultyAddContentPage.lockedEditSuccessMessageText();
			Assert.assertEquals(lockMessageSavedText, expectedAssertionsProp.getProperty(EDIT_SUCCESSFUL_TEXT));

			this.facultyAddContentPage.clickOnVerticalMenuZip();
			this.facultyAddContentPage.clickOnEditfileButton();

			// Assertion for checking the edit Document label
			String lblEditContent = this.facultyAddContentPage.getLabelEditContentText();
			Assert.assertEquals(lblEditContent, expectedAssertionsProp.getProperty(LABEL_EDIT_HEADING));

			this.facultyAddContentPage.setEditName(testDataProp.getProperty(ADDCONTENT_EDIT_DOCUMENT_NAME));
			this.facultyAddContentPage.clickOnEditSaveButton();

			// Assertion for checking the edit Document text
			String editSavedSuccessMessage = this.facultyAddContentPage.getEditSuccessMessageText();
			Assert.assertEquals(editSavedSuccessMessage, expectedAssertionsProp.getProperty(EDIT_SUCCESSFUL_TEXT));

		} catch (Exception e) {
			Assert.fail("Exception occured while testing  Edit Document: " + e.getMessage());
			logger.error("Error occured while testing Edit Document ", e);
		}

		logger.info("Ending of testEditDocument method");
	}

	@Test(priority = 11, description = "Verify Remove document ")
	@Description("Test Description:Verify Remove document ")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verify Remove document ")
	public void testRemoveDocument() {
		logger.info("Starting of testRemoveDocument method");

		try {
			this.facultyAddContentPage.clickOnMenuVerticalIcon6();
			this.facultyAddContentPage.clickOnRemoveFileButton();

			// Assertion for checking the remove Document text
			String deleteMessageText = this.facultyAddContentPage.deleteZipSuccessMessageText();
			Assert.assertEquals(deleteMessageText,
					expectedAssertionsProp.getProperty(CONTENT_DELETED_SUCCESSFULLY_TEXT));

		} catch (Exception e) {
			Assert.fail("Exception occured while testing Remove document : " + e.getMessage());
			logger.error("Error occured while testing Remove document ", e);
		}

		logger.info("Ending of testRemoveDocument method");
	}

	@Test(priority = 12, description = "Verify Add Image")
	@Description("Test Description:Verify Add Image")
	@Severity(SeverityLevel.CRITICAL)
	@Story("Verify Add Image")
	public void testAddImage() {
		logger.info("Starting of testAddImage method");

		try {
			this.facultyAddContentPage.clickOnMenuImageIcon();

			// Assertion for checking the add image label
			String lblAddImageText = this.facultyAddContentPage.getLabelAddImageText();
			Assert.assertEquals(lblAddImageText, expectedAssertionsProp.getProperty(LABEL_ADD_IMAGE));

			this.facultyAddContentPage.setTextImageName(testDataProp.getProperty(ADDCONTENT_IMAGE_NAME));
			this.facultyAddContentPage.setTextImageDescription(testDataProp.getProperty(ADDCONTENT_IMAGE_DESCRIPTION));
			this.facultyAddContentPage.setUploadImageButton();
			this.facultyAddContentPage.clickOnUploadImgButton();

			// Assertion for checking the add image text
			String imgSuccess = this.facultyAddContentPage.getSuccessImageMessageText();
			Assert.assertEquals(imgSuccess, expectedAssertionsProp.getProperty(IMAGE_ADDED_SUCCESSFULLY_TEXT));

		} catch (Exception e) {
			Assert.fail("Exception occured while testing  Add Image: " + e.getMessage());
			logger.error("Error occured while testing Add Image ", e);
		}

		logger.info("Ending of testAddImage method");
	}

	@Test(priority = 13, description = "Verify Edit Image")
	@Description("Test Description:Verify Edit Image")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verify Edit Image")
	public void testEditImage() {
		logger.info("Starting of testEditImage method");

		try {
			this.facultyAddContentPage.clickOnLockZipButton();

			// Assertion for checking the edit image text
			String lockMessageSavedText = this.facultyAddContentPage.lockedEditSuccessMessageText();
			Assert.assertEquals(lockMessageSavedText, expectedAssertionsProp.getProperty(EDIT_SUCCESSFUL_TEXT));

			this.facultyAddContentPage.clickOnVerticalMenuZip();
			this.facultyAddContentPage.clickOnEditfileButton();

			// Assertion for checking the edit image label
			String lblEditContent = this.facultyAddContentPage.getLabelEditContentText();
			Assert.assertEquals(lblEditContent, expectedAssertionsProp.getProperty(LABEL_EDIT_HEADING));

			this.facultyAddContentPage.setEditName(testDataProp.getProperty(ADDCONTENT_EDIT_DOCUMENT_NAME));
			this.facultyAddContentPage.clickOnEditSaveButton();

			// Assertion for checking the edit image text
			String editSavedSuccessMessage = this.facultyAddContentPage.getEditSuccessMessageText();
			Assert.assertEquals(editSavedSuccessMessage, expectedAssertionsProp.getProperty(EDIT_SUCCESSFUL_TEXT));

		} catch (Exception e) {
			Assert.fail("Exception occured while testing  Edit Image: " + e.getMessage());
			logger.error("Error occured while testing Edit Image ", e);
		}

		logger.info("Ending of testEditImage method");
	}

	@Test(priority = 14, description = "Verify Remove Image ")
	@Description("Test Description:Verify Remove Image")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verify Remove Image")
	public void testRemoveImage() {
		logger.info("Starting of testRemoveImage method");

		try {
			this.facultyAddContentPage.clickOnMenuVerticalIcon6();
			this.facultyAddContentPage.clickOnRemoveFileButton();

			// Assertion for checking the delete image text
			String deleteMessageText = this.facultyAddContentPage.deleteZipSuccessMessageText();
			Assert.assertEquals(deleteMessageText,
					expectedAssertionsProp.getProperty(CONTENT_DELETED_SUCCESSFULLY_TEXT));

		} catch (Exception e) {
			Assert.fail("Exception occured while testing  Remove Image: " + e.getMessage());
			logger.error("Error occured while testing Remove Image", e);
		}

		logger.info("Ending of testRemoveImage method");
	}

	@Test(priority = 15, description = "Verify Add zip file ")
	@Description("Test Description:Verify Add zip file ")
	@Severity(SeverityLevel.CRITICAL)
	@Story("Verify Add zip file")
	public void testAddZipFile() {
		logger.info("Starting of testAddZipFile method");

		try {
			this.facultyAddContentPage.clickOnMenuZipIcon();

			// Assertion for checking the add zip file label
			String lblAddZip = this.facultyAddContentPage.getLabelAddZipText();
			Assert.assertEquals(lblAddZip, expectedAssertionsProp.getProperty(LABEL_ADD_ZIPFILE));

			this.facultyAddContentPage.setTextFileName(testDataProp.getProperty(ADDCONTENT_ZIPFILE_NAME));
			this.facultyAddContentPage.setTextDescription(testDataProp.getProperty(ADDCONTENT_ZIPFILE_DESCRIPTION));
			this.facultyAddContentPage.clickOnChooseFileButton();
			this.facultyAddContentPage.clickOnUploadZipButton();

			// Assertion for checking the add zipfile text
			String fileSaveSuccessMessage = this.facultyAddContentPage.getSaveSuccessZipMessageText();
			Assert.assertEquals(fileSaveSuccessMessage,
					expectedAssertionsProp.getProperty(ZIPFILE_SAVE_SUCCESSFULLY_TEXT));

		} catch (Exception e) {
			Assert.fail("Exception occured while testing  Add ZIPfile: " + e.getMessage());
			logger.error("Error occured while testing Add zip file  ", e);
		}

		logger.info("Ending of testAddZipFile method");
	}

	@Test(priority = 16, description = "Verify Edit Zip FIle")
	@Description("Test Description:Verify Edit Zip FIle")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verify Edit Image")
	public void testEditZipFIle() {
		logger.info("Starting of testEditZipFIle method");

		try {
			this.facultyAddContentPage.clickOnLockZipButton();

			// Assertion for checking the edit zipfile text
			String lockMessageSavedText = this.facultyAddContentPage.lockedEditSuccessMessageText();
			Assert.assertEquals(lockMessageSavedText, expectedAssertionsProp.getProperty(EDIT_SUCCESSFUL_TEXT));

			this.facultyAddContentPage.clickOnVerticalMenuZip();
			this.facultyAddContentPage.clickOnEditfileButton();

			// Assertion for checking the edit zipfile label
			String lblEditContent = this.facultyAddContentPage.getLabelEditContentText();
			Assert.assertEquals(lblEditContent, expectedAssertionsProp.getProperty(LABEL_EDIT_HEADING));

			this.facultyAddContentPage.setEditName(testDataProp.getProperty(ADDCONTENT_EDIT_DOCUMENT_NAME));
			this.facultyAddContentPage.clickOnEditSaveButton();

			// Assertion for checking the edit zipfile success text
			String editSavedSuccessMessage = this.facultyAddContentPage.getEditSuccessMessageText();
			Assert.assertEquals(editSavedSuccessMessage, expectedAssertionsProp.getProperty(EDIT_SUCCESSFUL_TEXT));

		} catch (Exception e) {
			Assert.fail("Exception occured while testing  Edit Zip File: " + e.getMessage());
			logger.error("Error occured while testing Edit Zip FIle", e);
		}

		logger.info("Ending of testEditZipFIle method");
	}

	@Test(priority = 17, description = "Verify Remove zip file ")
	@Description("Test Description:Verify Remove zip file ")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verify Remove zip file ")
	public void testRemoveZipFile() {
		logger.info("Starting of testRemoveZipFile method");

		try {
			this.facultyAddContentPage.clickOnMenuVerticalIcon6();
			this.facultyAddContentPage.clickOnRemoveFileButton();

			// Assertion for checking the remove zipfile text
			String deleteMessageText = this.facultyAddContentPage.deleteZipSuccessMessageText();
			Assert.assertEquals(deleteMessageText,
					expectedAssertionsProp.getProperty(CONTENT_DELETED_SUCCESSFULLY_TEXT));

		} catch (Exception e) {
			Assert.fail("Exception occured while testing  Remove Zip file: " + e.getMessage());
			logger.error("Error occured while testing Remove zip file ", e);
		}

		logger.info("Ending of testRemoveZipFile method");
	}

	@AfterMethod
	public void getConsoleLoggers() {
		logger.info("Starting of getConsoleLogger method");

		this.logBrowserConsoleErrors(this.driver);

		logger.info("Ending of getConsoleLogger method");
	}

	@AfterClass
	public void quitDriver() {
		try {
			if (driver != null) {
				Thread.sleep(5000);
				this.loginPage.clickOnLogOut();
				this.quitDriver(this.driver, WEB_DRIVER.FACULTY_ADD_CONTENT_TEST);
				logger.info("Driver quit successfully");
			}
		} catch (Exception ex) {
			logger.error(ex.getMessage());
		}
	}
}