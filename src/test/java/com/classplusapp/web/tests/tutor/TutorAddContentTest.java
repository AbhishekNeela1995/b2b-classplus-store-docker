package com.classplusapp.web.tests.tutor;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static com.classplusapp.store.util.Constants.*;

import java.io.File;

import com.classplusapp.web.pages.tutor.TutorAddContentPage;
import com.classplusapp.web.tests.BaseClassplusAutomationTest;
import com.classplusapp.web.tests.CommonFunctionStoreTest;
import com.classplusapp.web.tests.CommonTest;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Epic("Store Course content")
@Feature("Tutor Add Content Test")
public class TutorAddContentTest extends CommonFunctionStoreTest {

	private WebDriver driver = null;
	private TutorAddContentPage tutorAddContentPage = null;

	private static final Logger logger = Logger.getLogger(TutorAddContentTest.class.getName());

	@BeforeClass
	@Parameters({ "browser", "orgCode"})
	public void initClassplusSiteLogin(@Optional("Chrome")String browser, @Optional("learn")String orgCode)
			throws Exception {
		logger.info("Starting of initClassplusSiteLogin methond");
		String searchCourse = testDataProp.getProperty(ADDCONTENT_SEARCH_COURSE);

		this.driver = this.loginClassPlusSite(browser, orgCode, tutorMobileNumber, emailAddress,
				WEB_DRIVER.ADD_CONTENT_TEST);
		this.driver = super.clickOnStoreButton(driver, searchCourse);
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
			this.tutorAddContentPage.clickOnGetCourseFolder();
			this.tutorAddContentPage.clickOnContentButton();

			// Assertion for checking the Add folder Label
			String addContentText = this.tutorAddContentPage.getAddContentLabel();
			Assert.assertEquals(addContentText, expectedAssertionsProp.getProperty(LABEL_ADD_FOLDER));

		} catch (Exception e) {
			Assert.fail("Exception occured while testing addContent: " + e.getMessage());
			logger.error("Error occured while testing Add content Page", e);
		}

		logger.info("Ending of testAddContent method");
	}

	@Test(priority = 2, description = "Verify Remove Subjective Test")
	@Description("Test Description:Verify Remove Subjective Test")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verify Remove Subjective Test")
	public void testRemoveFacultySubjectiveTest() {
		logger.info("Starting of testRemoveSubjectiveTest method");

		try {
			this.tutorAddContentPage.clickOnSubjectiveTestMenuVerticalIcon();
			this.tutorAddContentPage.clickOnUnlockSubjectiveTest();
			this.tutorAddContentPage.clickOnSubjectiveTestMenuVerticalIcon();
			this.tutorAddContentPage.clickOnRemoveSubjectiveButton();

			// Assertion for checking the remove subjective text
			String lblRemoveConfirmation = this.tutorAddContentPage.getLabelRemoveConfirmationText();
			Assert.assertEquals(lblRemoveConfirmation, expectedAssertionsProp.getProperty(LABEL_REMOVE_SUBJECTIVETEST));

			this.tutorAddContentPage.clickOnRemoveSubjConfirmButton();

			// Assertion for checking the remove subjective text
			String removeSubjMessage = this.tutorAddContentPage.subjTestRemovedMessageText();
			Assert.assertEquals(removeSubjMessage,
					expectedAssertionsProp.getProperty(REMOVED_SUBJECTIVETEST_SUCCESSFULLY_TEXT));
		} catch (Exception e) {
			Assert.fail("Exception occured while testing  Remove Subjective test: " + e.getMessage());
			logger.error("Error occured while testing Remove Subjective Test ", e);
		}

		logger.info("Ending of testRemoveSubjectiveTest method");
	}

	@Test(priority = 3, description = "Verify Add Folder")
	@Description("Test Description:Verify Add Folder")
	@Severity(SeverityLevel.CRITICAL)
	@Story("Verify Add Folder")
	public void testAddFolder() {
		logger.info("Starting of testAddFolder method");

		try {
			this.tutorAddContentPage.clickOnMenuAddFolderIcon();

			// Assertion for checking the B2b content Label
			String lblB2bContent = this.tutorAddContentPage.getB2bAddContentLabel();
			Assert.assertEquals(lblB2bContent, expectedAssertionsProp.getProperty(LABEL_FACULTY_ADD_CONTENT));

			this.tutorAddContentPage.setFolderName(testDataProp.getProperty(ADDCONTENT_FOLDER_NAME));
			this.tutorAddContentPage.clickOnSaveFolderButton();

			// Assertion for checking the save folder text
//			String msgSaveFolderName = this.tutorAddContentPage.getSaveSuccessMessageText();
//			Assert.assertEquals(msgSaveFolderName, expectedAssertionsProp.getProperty(SAVE_FOLDER_SUCCESSFULLY_TEXT));

		} catch (Exception e) {
			Assert.fail("Exception occured while testing addFolder: " + e.getMessage());
			logger.error("Error occured while testing Add Folder ", e);
		}

		logger.info("Ending of testAddFolder method");
	}

	@Test(priority = 4, description = "Verify Edit Folder")
	@Description("Test Description:Verify Edit Folder")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verify Edit Folder")
	public void testEditFolder() {
		logger.info("Starting of testEditFolder method");

		try {
			this.tutorAddContentPage.clickOnMenuFolderVerticalIcon();
			this.tutorAddContentPage.clickOnFolderMenuEditButton();

			// Assertion for checking the Edit content Label
			String lblEditContent = this.tutorAddContentPage.getLabelEditContentText();
			Assert.assertEquals(lblEditContent, expectedAssertionsProp.getProperty(LABEL_EDIT_FOLDER));

			this.tutorAddContentPage.setFolder(testDataProp.getProperty(ADDCONTENT_EDIT_FOLDER_NAME));
			this.tutorAddContentPage.clickOnEditSaveButton();

			// Assertion for checking the Edit folder text
			String msgEditFolder = this.tutorAddContentPage.getEditSuccessMessageText();
			Assert.assertEquals(msgEditFolder, expectedAssertionsProp.getProperty(FOLDER_EDITED_SUCCESSFULLY_TEXT));

		} catch (Exception e) {
			Assert.fail("Exception occured while testing edit Folder: " + e.getMessage());
			logger.error("Error occured while testing Remove Folder ", e);
		}

		logger.info("Ending of editFolder method");
	}

	@Test(priority = 5, description = "Verify Remove Folder")
	@Description("Test Description:Verify Remove Folder")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verify Remove Folder")
	public void testRemoveFolder() {
		logger.info("Starting of testRemoveFolder method");

		try {
			this.tutorAddContentPage.clickOnMenuFolderVerticalIcon();
			this.tutorAddContentPage.clickOnRemoveFolderButton();

			// Assertion for checking the delete content Text
			String lblDeleteContent = this.tutorAddContentPage.getLabelDeleteContentText();
			Assert.assertEquals(lblDeleteContent, expectedAssertionsProp.getProperty(DELETE_FOLDER_TEXT));

			this.tutorAddContentPage.clickOnConfirmRemoveButton();
		} catch (Exception e) {
			Assert.fail("Exception occured while testing remove Folder: " + e.getMessage());
			logger.error("Error occured while testing Remove Folder ", e);
		}

		logger.info("Ending of testRemoveFolder method");
	}

	@Test(priority = 6, description = "Verify Add video")
	@Description("Test Description:Verify Add video")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verify Add video")
	public void testAddVideo() {
		logger.info("Starting of addVideo method");

		try {
			this.tutorAddContentPage.clickOnMenuAddVideoIcon();
			// this.addcontentpage.clickOnVideo();

			// Assertion for checking the Add Video Label
			String addVideolabel = this.tutorAddContentPage.getAddVideoLabelText();
			Assert.assertEquals(addVideolabel, expectedAssertionsProp.getProperty(LABEL_ADD_VIDEO_HEADING));

			this.tutorAddContentPage.uploadVideoButton(System.getProperty("user.dir")
					+ File.separator + testDataProp.getProperty(ADDCONTENT_UPLOAD_LINUX_VIDEO));
			Thread.sleep(4000);
			this.tutorAddContentPage.clickOnDoneButton();

		} catch (Exception e) {
			Assert.fail("Exception occured while testing  add video: " + e.getMessage());
			logger.error("Error occured while testing Add video ", e);
		}

		logger.info("Ending of addVideo method");
	}
	@Test(priority = 7, description = "Verify Remove Video")
	@Description("Test Description:Verify Remove Video")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verify Remove Video")
	public void testRemoveVideo() {
		logger.info("Starting of testRemoveVideo method");

		try {
			this.tutorAddContentPage.clickOnStoreButton();

			// Assertion for checking the My courses Label
			String myCoursesLabel = this.tutorAddContentPage.getMyCoursesPage();
			Assert.assertEquals(myCoursesLabel, expectedAssertionsProp.getProperty(LABEL_ADDCONTENT_MYCOURSES));

			this.tutorAddContentPage.clickOnTxtSearchCourse(testDataProp.getProperty(ADDCONTENT_SEARCH_COURSE));
			this.driver.navigate().refresh();
			this.tutorAddContentPage.clickOnGetCourseFolder();
			this.tutorAddContentPage.clickOnContentButton();
			this.tutorAddContentPage.clickOnRemoveVideo();
			this.tutorAddContentPage.clickOnRemoveVideoButton();

			// Assertion for checking the remove video text
			String removeVedioMessage = this.tutorAddContentPage.videoRemoveMessageText();
			Assert.assertEquals(removeVedioMessage,
					expectedAssertionsProp.getProperty(CONTENT_DELETED_SUCCESSFULLY_TEXT));

		} catch (Exception e) {
			Assert.fail("Exception occured while testing  Remove Video: " + e.getMessage());
			logger.error("Error occured while testing Remove Video ", e);
		}

		logger.info("Ending of testRemoveVideo method");
	}

	@Test(priority = 8, description = "Verify user can Upload Valid pdf in Add Subjective Test")
	@Description("Test Description:Verify user can Upload Valid pdf in Add Subjective Test")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verify Add Subjective Test")
	public void testAddSubjectiveTest() {
		logger.info("Starting of testAddSubjectiveTest method");

		try {
			Assert.assertTrue(this.tutorAddContentPage.isDisplayedSubjectiveTestLabel());

			this.tutorAddContentPage.clickOnMenuSubjectiveTestIcon();

			// Assertion for checking the Subjective Test Label
			Assert.assertEquals(this.tutorAddContentPage.getSubjectiveTestLabel(),
					expectedAssertionsProp.getProperty(LABEL_ADD_SUBJECTIVETEST));

			Assert.assertTrue(this.tutorAddContentPage.getCreateLabel());

			Assert.assertTrue(this.tutorAddContentPage.getSearchLabel());

			this.tutorAddContentPage.clickOnCreateNewTestButton();

			// Assertion for checking the Create New Subjective Test Label
			String lblCreateNewSubjectiveTest = this.tutorAddContentPage.getCreateNewSubjectiveTestLabel();
			Assert.assertEquals(lblCreateNewSubjectiveTest,
					expectedAssertionsProp.getProperty(LABEL_CREATE_SUBJECTIVETEST));

			this.tutorAddContentPage.setTextTestName(testDataProp.getProperty(ADDCONTENT_SUBJECTIVETEST_TESTNAME));
			this.tutorAddContentPage
					.clickOnTextTotalMarks(testDataProp.getProperty(ADDCONTENT_SUBJECTIVETEST_TOTALMARKS));
			this.tutorAddContentPage.clickOnAddFilesButton();

			Assert.assertTrue(this.tutorAddContentPage.isDisplayedCreateAndAddTestButton());

			Assert.assertTrue(this.tutorAddContentPage.getPdfIcon());

			this.tutorAddContentPage.clickOnCreateAndAddTestButton();

			// Assertion for checking the Add Subjective Test
			Assert.assertEquals(this.tutorAddContentPage.getAddSubjectiveTestMessage(),
					expectedAssertionsProp.getProperty(SUBJECTIVETEST_ADDED_SUCCESSFULLY_TEXT));

		} catch (Exception e) {
			Assert.fail("Exception occured while testing add Subjective test: " + e.getMessage());
			logger.error("Error occured while testing Add Subjective Test ", e);
		}

		logger.info("Ending of testAddSubjectiveTest method");
	}

	@Test(priority = 9, description = "Verify user can View Stats and Preview labels of Subjective Test")
	@Description("Test Description:Verify user can View Stats and Preview labels of Subjective Test")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verify View Stats and Preview screen of Subjective Test")
	public void testViewStatsAndPreviewLabels() {
		logger.info("Starting of testViewStatsAndPreviewLabels method");

		try {
			Assert.assertTrue(this.tutorAddContentPage.isDisplayedViewStatsButton());
			Assert.assertTrue(this.tutorAddContentPage.isDisplayedPreviewButton());

		} catch (Exception e) {
			Assert.fail("Exception occured while testing View Preview Screen: " + e.getMessage());
			logger.error("Error occured while testing View PreviewS creen ", e);
		}

		logger.info("Ending of testViewStatsAndPreviewLabels method");
	}

	@Test(priority = 10, description = "Verify User can Lock and Unlock Subjective Test")
	@Description("Test Description:Verify User can Lock and Unlock Subjective Test")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verify LockUnlock Subjective Test")
	public void testLockUnlockSubjectiveTest() {
		logger.info("Starting of testLockUnlockSubjectiveTest method");

		try {
			this.tutorAddContentPage.clickOnUnlockSubjectiveTest();

			// Assertion for checking the edit successfull text
			String lockMessageSavedText = this.tutorAddContentPage.lockedEditSuccessMessageText();
			Assert.assertEquals(lockMessageSavedText, expectedAssertionsProp.getProperty(EDIT_SUCCESSFUL_TEXT));

			// Assertion for checking the Unlock text
			String unlockText = this.tutorAddContentPage.getUnlockText();
			Assert.assertEquals(unlockText, expectedAssertionsProp.getProperty(SUBJECTIVE_TEST_UNLOCKED_TEXT));

			this.tutorAddContentPage.clickOnUnlockSubjectiveTest();

			// Assertion for checking the lock text
			String lockedText = this.tutorAddContentPage.getUnlockText();
			Assert.assertEquals(lockedText, expectedAssertionsProp.getProperty(SUBJECTIVE_TEST_LOCKED_TEXT));

		} catch (Exception e) {
			Assert.fail("Exception occured while testing Lock Unlock Subjective test: " + e.getMessage());
			logger.error("Error occured while testing Lock Unlock Subjective Test ", e);
		}

		logger.info("Ending of testLockUnlockSubjectiveTest method");
	}

	@Test(priority = 11, description = "Verify the user can visit for th first time ViewStats Subjective Test")
	@Description("Test Description:Verify the user can visit for th first time ViewStats Subjective Test")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verify ViewStatsSubjectiveTest Subjective Test")
	public void testNoStudentAttempedSubjectiveTest() {
		logger.info("Starting of testNoStudentAttempedSubjectiveTest method");

		try {
			this.tutorAddContentPage.clickOnViewStatsButton();

			Assert.assertEquals(this.tutorAddContentPage.getTestStatsHeader(),
					expectedAssertionsProp.getProperty(SUBJECTIVETEST_TESTSTATS_HEADER_TEXT));

			Assert.assertEquals(this.tutorAddContentPage.getNoStatsLabel(),
					expectedAssertionsProp.getProperty(NO_TESTSTATS__TEXT));

			Assert.assertEquals(this.tutorAddContentPage.getNoStudentLabel(),
					expectedAssertionsProp.getProperty(NO_STUDENT_ATTEMPTED_TEXT));

			this.tutorAddContentPage.clickOnCloseButton();

			Assert.assertEquals(this.tutorAddContentPage.getAddContentHeader(),
					expectedAssertionsProp.getProperty(ADDCONTENT_HEADER));

		} catch (Exception e) {
			Assert.fail("Exception occured while testing  View Stats  Subjective test: " + e.getMessage());
			logger.error("Error occured while testing View Stats  Subjective Test ", e);
		}

		logger.info("Ending of testNoStudentAttempedSubjectiveTest method");

	}

	@Test(priority = 12, description = "Verify user can download the Preview of Subjective Test")
	@Description("Test Description:Verify user can download the Preview of Subjective Test")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verify ViewStatsSubjectiveTest Subjective Test")
	public void testPreviewSubjectiveTest() {
		logger.info("Starting of testPreviewSubjectiveTest method");

		try {
			this.tutorAddContentPage.clickOnPreviewButton();
			this.tutorAddContentPage.clickOnDownloadButton();

			Assert.assertEquals(this.tutorAddContentPage.getDownloadPaperMessage(),
					expectedAssertionsProp.getProperty(DOWNLOAD_QUESTION_PAPER_MESSAGE));

			this.tutorAddContentPage.closeWindow();
		} catch (Exception e) {
			Assert.fail("Exception occured while testing preview Subjective test: " + e.getMessage());
			logger.error("Error occured while testing preview Subjective Test ", e);
		}

		logger.info("Ending of testPreviewSubjectiveTest method");
	}


	@Test(priority = 13, description = "Verify User can Search invalid Subjective Test")
	@Description("Test Description:Verify User can Search invalid Subjective Test")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verify Search invalid Subjective Test")
	public void testSearchInvalidSubjectiveTest() {
		logger.info("Starting of testSearchInvalidSubjectiveTest method");

		try {
			this.tutorAddContentPage.clickOnMenuSubjectiveTestIcon();
			this.tutorAddContentPage.setSearchSubjectiveTest(testDataProp.getProperty(SEARCH_INVALID_SUBJECTIVE_TEST));

			// Assertion for checking the no test found Subjective Test
			Assert.assertEquals(this.tutorAddContentPage.getNoTestFoundLabel(),
					expectedAssertionsProp.getProperty(SUBJECTIVETEST_NO_TEST_FOUND));

			this.tutorAddContentPage.clickOnCloseButton();

		} catch (Exception e) {
			Assert.fail("Exception occured while testing  Search invalid Subjective test: " + e.getMessage());
			logger.error("Error occured while testing Search invalid Subjective Test ", e);
		}

		logger.info("Ending of testSearchInvalidSubjectiveTest method");
	}

	@Test(priority = 14, description = "Verify user can Search with valid Subjective Test")
	@Description("Test Description:Verify user can Search with valid Subjective Test")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verify Search Subjective Test")
	public void testSearchSubjectiveTest() {
		logger.info("Starting of testSearchSubjectiveTest method");

		try {
			this.tutorAddContentPage.clickOnMenuSubjectiveTestIcon();

			this.tutorAddContentPage.setSearchSubjectiveTest(testDataProp.getProperty(SEARCH_SUBJECTIVE_TEST));
			this.tutorAddContentPage.clickOnAddCourseButton();
			this.tutorAddContentPage.clickOnCloseButton();

			// Assertion for checking the Add Subjective Test
			Assert.assertEquals(this.tutorAddContentPage.getAddSubjectiveTestMessage(),
					expectedAssertionsProp.getProperty(SUBJECTIVETEST_ADDED_SUCCESSFULLY_TEXT));

		} catch (Exception e) {
			Assert.fail("Exception occured while testing  Search Subjective test: " + e.getMessage());
			logger.error("Error occured while testing Search Subjective Test ", e);
		}

		logger.info("Ending of testSearchSubjectiveTest method");
	}

	@Test(priority = 15, description = "Verify  Subjective Test from add modal")
	@Description("Test Description:Verify  Subjective Test from add modal")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verify Subjective Test from add modal")
	public void testAddModalSubjectiveTest() {
		logger.info("Starting of testAddModalSubjectiveTest method");

		try {
			this.tutorAddContentPage.clickOnMenuSubjectiveTestIcon();
			this.tutorAddContentPage.clickOnAddCourseButton();

			// Assertion for checking the Add Subjective Test
			Assert.assertEquals(this.tutorAddContentPage.getAddSubjectiveTestMessage(),
					expectedAssertionsProp.getProperty(SUBJECTIVETEST_ADDED_SUCCESSFULLY_TEXT));

		} catch (Exception e) {
			Assert.fail("Exception occured while testing  Subjective test through add modal: " + e.getMessage());
			logger.error("Error occured while testing  Subjective Test through add modal ", e);
		}

		logger.info("Ending of testAddModalSubjectiveTest method");
	}

	@Test(priority = 16, description = "Verify user can maximum uploads of Subjective Test")
	@Description("Test Description:Verify user can maximum uploads of Subjective Test")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verify maximum uploads of Subjective Test")
	public void testMaximumUploadsSubjectiveTest() {
		logger.info("Starting of testMaximumUploadsAddSubjectiveTest method");

		try {
			super.subjectiveDetails(tutorAddContentPage);

			this.tutorAddContentPage.clickOnMaxAddFilesButton();

			super.clickOnCreateAndAdd(tutorAddContentPage);
			
			this.tutorAddContentPage.getTimeout();		

			// Assertion for checking the Add Subjective Test
			String toastMesage = this.tutorAddContentPage.getAddSubjectiveTestMessage();
			Assert.assertEquals(toastMesage,
					expectedAssertionsProp.getProperty(SUBJECTIVETEST_ADDED_SUCCESSFULLY_TEXT));
			

		} catch (Exception e) {
			Assert.fail("Exception occured while testing  Maximum Uploads AddSubjectiveTest  : " + e.getMessage());
			logger.error("Error occured while testing Maximum Uploads AddSubjectiveTest   ", e);
		}

		logger.info("Ending of testMaximumUploadsAddSubjectiveTest method");
	}


	@Test(priority = 17, description = "Verify Invalid file upload Subjective Test")
	@Description("Test Description:Verify Invalid file upload Subjective Test")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verify Invalid file upload Subjective Test")
	public void testUploadInvalidPdf() {
		logger.info("Starting of testUploadInvalidPdf method");

		try {
			super.subjectiveDetails(tutorAddContentPage);
			this.tutorAddContentPage.clickOnUploadInvalidPdf();

			// Assertion for checking the Subjective Test invalid text
			Assert.assertEquals(this.tutorAddContentPage.getMessageErrorFile(),
					expectedAssertionsProp.getProperty(SUBJECTIVETEST_INVALID_TEXT));

			this.tutorAddContentPage.clickOnCloseButton();

		} catch (Exception e) {
			Assert.fail("Exception occured while testing  invalid Subjective test: " + e.getMessage());
			logger.error("Error occured while testing invalid Subjective Test ", e);
		}

		logger.info("Ending of testUploadInvalidPdf method");
	}

	@Test(priority = 18, description = "Verify user can cancel the process while uploading the Subjective Test")
	@Description("Test Description:Verify user can cancel the process while uploading the Subjective Test")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verify Cancel Uploading Subjective Test")
	public void testCancelUploadingdPdf() {
		logger.info("Starting of testCancelUploadingdPdf method");

		try {
			super.subjectiveDetails(tutorAddContentPage);

			this.tutorAddContentPage.clickOnMaxAddFilesButton();

			super.clickOnCreateAndAdd(tutorAddContentPage);

			Assert.assertTrue(this.tutorAddContentPage.isdisplayedCancel());

			this.tutorAddContentPage.clickOnCancelButton();

			Assert.assertEquals(this.tutorAddContentPage.getAddContentHeader(),
					expectedAssertionsProp.getProperty(ADDCONTENT_HEADER));
			
			this.tutorAddContentPage.clickOnCloseButton();

		} catch (Exception e) {
			Assert.fail("Exception occured while testing cancel the process while uploading the Subjective Test: "
					+ e.getMessage());
			logger.error("Error occured while testing cancel the process while uploading the Subjective Test ", e);
		}

		logger.info("Ending of testCancelUploadingdPdf method");
	}

	@Test(priority = 19, description = "Verify upload the file other than pdf instead of Subjective Test")
	@Description("Test Description:Verify upload the file other than pdf instead of Subjective Test")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verify Zip file instead of pdf of Subjective Test")
	public void testWithFailedUpload() {
		logger.info("Starting of testWithFailedUpload method");

		try {
			super.subjectiveDetails(tutorAddContentPage);
			this.tutorAddContentPage.clickOnAddZipFileButton();

			Assert.assertEquals(this.tutorAddContentPage.getTryAndUploadPdfMessage(),
					expectedAssertionsProp.getProperty(MESSAGE_TRY_UPLOAD_PDF));

			this.tutorAddContentPage.clickOnCloseButton();
				} catch (Exception e) {
			Assert.fail("Exception occured while testing  invalid Subjective test: " + e.getMessage());
			logger.error("Error occured while testing invalid Subjective Test ", e);
		}

		logger.info("Ending of testWithFailedUpload method");
	}

	@Test(priority = 20, description = "Verify Add Document")
	@Description("Test Description:Verify Add Document")
	@Severity(SeverityLevel.CRITICAL)
	@Story("Verify Add Document")
	public void testAddDocument() {
		logger.info("Starting of testAddDocument method");

		try {
			this.tutorAddContentPage.clickOnMenuDocumentIcon();

			// Assertion for checking the Add Document Label
			String lblAddDocumentText = this.tutorAddContentPage.getlabelDocumentText();
			Assert.assertEquals(lblAddDocumentText, expectedAssertionsProp.getProperty(LABEL_ADD_DOCUMENT));

			this.tutorAddContentPage.setTextDocument(testDataProp.getProperty(ADDCONTENT_DOCUMENT_NAME));
			this.tutorAddContentPage.setTextDocDescription(testDataProp.getProperty(ADDCONTENT_DOCUMENT_DESCRIPTION));
			this.tutorAddContentPage.clickOnSelectDocumentButton();
			this.tutorAddContentPage.clickOnUploadDocumentButton();

			// Assertion for checking the Add Document text
			String documentSuccess = this.tutorAddContentPage.documentUploadedMessageText();
			Assert.assertEquals(documentSuccess, expectedAssertionsProp.getProperty(ADD_DOCUMENT_SUCCESSFULLY_TEXT));

		} catch (Exception e) {
			Assert.fail("Exception occured while testing  Add Document: " + e.getMessage());
			logger.error("Error occured while testing Add Document", e);
		}

		logger.info("Ending of testAddDocument method");
	}

	@Test(priority = 21, description = "Verify Edit Document")
	@Description("Test Description:Verify Edit Document")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verify Edit Document")
	public void testEditDocument() {
		logger.info("Starting of testEditDocument method");

		try {
			this.tutorAddContentPage.clickOnLockZipButton();

			// Assertion for checking the edit Document text
			String lockMessageSavedText = this.tutorAddContentPage.lockedEditSuccessMessageText();
			Assert.assertEquals(lockMessageSavedText, expectedAssertionsProp.getProperty(EDIT_SUCCESSFUL_TEXT));

			this.tutorAddContentPage.clickOnVerticalMenuZip();
			this.tutorAddContentPage.clickOnEditfileButton();

			// Assertion for checking the edit Document label
			String lblEditContent = this.tutorAddContentPage.getLabelEditContentText();
			Assert.assertEquals(lblEditContent, expectedAssertionsProp.getProperty(LABEL_EDIT_HEADING));

			this.tutorAddContentPage.setEditName(testDataProp.getProperty(ADDCONTENT_EDIT_DOCUMENT_NAME));
			this.tutorAddContentPage.clickOnEditSaveButton();

			// Assertion for checking the edit Document text
			String editSavedSuccessMessage = this.tutorAddContentPage.getEditSuccessMessageText();
			Assert.assertEquals(editSavedSuccessMessage, expectedAssertionsProp.getProperty(EDIT_SUCCESSFUL_TEXT));

		} catch (Exception e) {
			Assert.fail("Exception occured while testing  Edit Document: " + e.getMessage());
			logger.error("Error occured while testing Edit Document ", e);
		}

		logger.info("Ending of testEditDocument method");
	}

	@Test(priority = 22, description = "Verify Remove document ")
	@Description("Test Description:Verify Remove document ")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verify Remove document ")
	public void testRemoveDocument() {
		logger.info("Starting of testRemoveDocument method");

		try {
			this.tutorAddContentPage.clickOnMenuVerticalIcon6();
			this.tutorAddContentPage.clickOnRemoveFileButton();
			

			// Assertion for checking the remove Document text
			String deleteMessageText = this.tutorAddContentPage.deleteZipSuccessMessageText();
			Assert.assertEquals(deleteMessageText,
					expectedAssertionsProp.getProperty(CONTENT_DELETED_SUCCESSFULLY_TEXT));

		} catch (Exception e) {
			Assert.fail("Exception occured while testing Remove document : " + e.getMessage());
			logger.error("Error occured while testing Remove document ", e);
		}

		logger.info("Ending of testRemoveDocument method");
	}

	@Test(priority = 23, description = "Verify Add Image")
	@Description("Test Description:Verify Add Image")
	@Severity(SeverityLevel.CRITICAL)
	@Story("Verify Add Image")
	public void testAddImage() {
		logger.info("Starting of testAddImage method");

		try {
			this.tutorAddContentPage.clickOnMenuImageIcon();

			// Assertion for checking the add image label
			String lblAddImageText = this.tutorAddContentPage.getLabelAddImageText();
			Assert.assertEquals(lblAddImageText, expectedAssertionsProp.getProperty(LABEL_ADD_IMAGE));

			this.tutorAddContentPage.setTextImageName(testDataProp.getProperty(ADDCONTENT_IMAGE_NAME));
			this.tutorAddContentPage.setTextImageDescription(testDataProp.getProperty(ADDCONTENT_IMAGE_DESCRIPTION));
			this.tutorAddContentPage.setUploadImageButton();
			this.tutorAddContentPage.clickOnUploadImgButton();

			// Assertion for checking the add image text
			String imgSuccess = this.tutorAddContentPage.getSuccessImageMessageText();
			Assert.assertEquals(imgSuccess, expectedAssertionsProp.getProperty(IMAGE_ADDED_SUCCESSFULLY_TEXT));

		} catch (Exception e) {
			Assert.fail("Exception occured while testing  Add Image: " + e.getMessage());
			logger.error("Error occured while testing Add Image ", e);
		}

		logger.info("Ending of testAddImage method");
	}

	@Test(priority = 24, description = "Verify Edit Image")
	@Description("Test Description:Verify Edit Image")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verify Edit Image")
	public void testEditImage() {
		logger.info("Starting of testEditImage method");

		try {
			this.tutorAddContentPage.clickOnLockZipButton();

			// Assertion for checking the edit image text
			String lockMessageSavedText = this.tutorAddContentPage.lockedEditSuccessMessageText();
			Assert.assertEquals(lockMessageSavedText, expectedAssertionsProp.getProperty(EDIT_SUCCESSFUL_TEXT));

			this.tutorAddContentPage.clickOnVerticalMenuZip();
			this.tutorAddContentPage.clickOnEditfileButton();

			// Assertion for checking the edit image label
			String lblEditContent = this.tutorAddContentPage.getLabelEditContentText();
			Assert.assertEquals(lblEditContent, expectedAssertionsProp.getProperty(LABEL_EDIT_HEADING));

			this.tutorAddContentPage.setEditName(testDataProp.getProperty(ADDCONTENT_EDIT_DOCUMENT_NAME));
			this.tutorAddContentPage.clickOnEditSaveButton();

			// Assertion for checking the edit image text
			String editSavedSuccessMessage = this.tutorAddContentPage.getEditSuccessMessageText();
			Assert.assertEquals(editSavedSuccessMessage, expectedAssertionsProp.getProperty(EDIT_SUCCESSFUL_TEXT));

		} catch (Exception e) {
			Assert.fail("Exception occured while testing  Edit Image: " + e.getMessage());
			logger.error("Error occured while testing Edit Image ", e);
		}

		logger.info("Ending of testEditImage method");
	}

	@Test(priority = 25, description = "Verify Remove Image ")
	@Description("Test Description:Verify Remove Image")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verify Remove Image")
	public void testRemoveImage() {
		logger.info("Starting of testRemoveImage method");

		try {
			this.tutorAddContentPage.clickOnMenuVerticalIcon6();
			this.tutorAddContentPage.clickOnRemoveFileButton();
			this.tutorAddContentPage.removeCourseButton();

			// Assertion for checking the delete image text
			String deleteMessageText = this.tutorAddContentPage.deleteZipSuccessMessageText();
			Assert.assertEquals(deleteMessageText,
					expectedAssertionsProp.getProperty(CONTENT_DELETED_SUCCESSFULLY_TEXT));

		} catch (Exception e) {
			Assert.fail("Exception occured while testing  Remove Image: " + e.getMessage());
			logger.error("Error occured while testing Remove Image", e);
		}

		logger.info("Ending of testRemoveImage method");
	}

	@Test(priority = 26, description = "Verify Add zip file ")
	@Description("Test Description:Verify Add zip file ")
	@Severity(SeverityLevel.CRITICAL)
	@Story("Verify Add zip file")
	public void testAddZipFile() {
		logger.info("Starting of testAddZipFile method");

		try {
			this.tutorAddContentPage.clickOnMenuZipIcon();

			// Assertion for checking the add zipfile label
			String lblAddZip = this.tutorAddContentPage.getLabelAddZipText();
			Assert.assertEquals(lblAddZip, expectedAssertionsProp.getProperty(LABEL_ADD_ZIPFILE));

			this.tutorAddContentPage.setTextFileName(testDataProp.getProperty(ADDCONTENT_ZIPFILE_NAME));
			this.tutorAddContentPage.setTextDescription(testDataProp.getProperty(ADDCONTENT_ZIPFILE_DESCRIPTION));
			this.tutorAddContentPage.clickOnChooseFileButton();
			this.tutorAddContentPage.clickOnUploadZipButton();

			// Assertion for checking the add zipfile text
			String fileSaveSuccessMessage = this.tutorAddContentPage.getSaveSuccessZipMessageText();
			Assert.assertEquals(fileSaveSuccessMessage,
					expectedAssertionsProp.getProperty(ZIPFILE_SAVE_SUCCESSFULLY_TEXT));

		} catch (Exception e) {
			Assert.fail("Exception occured while testing  Add ZIPfile: " + e.getMessage());
			logger.error("Error occured while testing Add zip file  ", e);
		}

		logger.info("Ending of testAddZipFile method");
	}

	@Test(priority = 27, description = "Verify Remove zip file ")
	@Description("Test Description:Verify Remove zip file ")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verify Remove zip file ")
	public void testRemoveZipFile() {
		logger.info("Starting of testDeleteZipFile method");

		try {
			this.tutorAddContentPage.clickOnMenuVerticalIcon6();
			this.tutorAddContentPage.clickOnRemoveFileButton();
			this.tutorAddContentPage.removeCourseButton();

			// Assertion for checking the remove zipfile text
			String deleteMessageText = this.tutorAddContentPage.deleteZipSuccessMessageText();
			Assert.assertEquals(deleteMessageText,
					expectedAssertionsProp.getProperty(CONTENT_DELETED_SUCCESSFULLY_TEXT));

		} catch (Exception e) {
			Assert.fail("Exception occured while testing  Remove ZIPfile: " + e.getMessage());
			logger.error("Error occured while testing Remove zip file ", e);
		}

		logger.info("Ending of testDeleteZipFile method");
	}

	@Test(priority = 28, description = "Verify Add import content")
	@Description("Test Description:Verify Add import content")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verify Add import content")
	public void testAddImportContent() {
		logger.info("Starting of testImportContent method");

		try {
			this.tutorAddContentPage.clickOnMenuImportContentIcon();

			// Assertion for checking the import content label
			String lblImportContent = this.tutorAddContentPage.getlabelImportContentText();
			Assert.assertEquals(lblImportContent, expectedAssertionsProp.getProperty(LABEL_IMPORT_CONTENT));

			this.tutorAddContentPage.clickOnImportCheckBox();
			this.tutorAddContentPage.clickOnImportSelectedButton();

			// Assertion for checking the import content text
			String importSucces = this.tutorAddContentPage.getSuccesImportMessageText();
			Assert.assertEquals(importSucces, expectedAssertionsProp.getProperty(CONTENT_IMPORTED_SUCCESSFULLY_TEXT));

		} catch (Exception e) {
			Assert.fail("Exception occured while testing  Add import content: " + e.getMessage());
			logger.error("Error occured while testing Add import content ", e);
		}

		logger.info("Ending of testImportContent method");
	}

	@Test(priority = 29, description = "Verify Add Import Live")
	@Description("Test Description:Verify Add Import Live")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verify Add Import Live")
	public void testAddImportLive() {
		logger.info("Ending of testAddImportLive method");

		try {
			this.tutorAddContentPage.clickOnMenuImportLiveIcon();

			// Assertion for checking the import live label
			String lblImportLiveClasses = this.tutorAddContentPage.getlabelImportLiveText();
			Assert.assertEquals(lblImportLiveClasses, expectedAssertionsProp.getProperty(LABEL_IMPORT_LIVE_CLASSES));

			this.tutorAddContentPage.clickOnLiveCheckBox();
			this.tutorAddContentPage.clickOnLiveSelectedButton();

			// Assertion for checking the import live text
			String liveSuccess = this.tutorAddContentPage.getSuccesImportMessageText();
			Assert.assertEquals(liveSuccess, expectedAssertionsProp.getProperty(CONTENT_IMPORTED_SUCCESSFULLY_TEXT));

		} catch (Exception e) {
			Assert.fail("Exception occured while testing  Add import Live: " + e.getMessage());
			logger.error("Error occured while testing Add Import Live ", e);
		}

		logger.info("Ending of testAddImportLive method");
	}

	@Test(priority = 30, description = "Verify Publish course")
	@Description("Test Description:Verify Publish course")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verify Publish course")
	public void testPublishCourse() {
		logger.info("Starting of testPublishCourse method");

		try {
			this.tutorAddContentPage.clickOnPublishCourseButton();

			// Assertion for checking the publish course label
			String lblPublishCourse = this.tutorAddContentPage.getlabelPublishCourseText();
			Assert.assertEquals(lblPublishCourse, expectedAssertionsProp.getProperty(LABEL_PUBLISH_COURSE));

			this.tutorAddContentPage.clickOnPublishCourse1();
			this.tutorAddContentPage.clickOnCrossButton();

			// Assertion for checking the publish course text
			String publishSucces = this.tutorAddContentPage.getPublishSuccessText();
			Assert.assertEquals(publishSucces, expectedAssertionsProp.getProperty(COURSE_PUBLISHED_TEXT));

		} catch (Exception e) {
			Assert.fail("Exception occured while testing  Publish course " + e.getMessage());
			logger.error("Error occured while testing Publish course ", e);
		}

		logger.info("Ending of testPublishCourse method");
	}

	@Test(priority = 31, description = "Verify UnPublish course")
	@Description("Test Description:Verify UnPublish course")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verify UnPublish course")
	public void testUnPublishCourse() {
		logger.info("starting of testUnPublishCourse course");

		try {
			this.tutorAddContentPage.clickOnUnpublishCourseButton();

			// Assertion for checking the unpublish course label
			String lblUnpublishCourse = this.tutorAddContentPage.getlabelUnpulishCourseText();
			Assert.assertEquals(lblUnpublishCourse, expectedAssertionsProp.getProperty(LABEL_UNPUBLISH_COURSE));

			this.tutorAddContentPage.clickOnUnpublishButton();

			// Assertion for checking the unpublish course text
			String unpublishSucces = this.tutorAddContentPage.getUnPublishSuccessText();
			Assert.assertEquals(unpublishSucces, expectedAssertionsProp.getProperty(UNPUBLISH_COURSE_TEXT));

		} catch (Exception e) {
			Assert.fail("Exception occured while testing  UnPublish course " + e.getMessage());
			logger.error("Error occured while testing UnPublish course", e);
		}

		logger.info("Ending of testUnPublishCourse course");
	}

	@Test(priority = 32, description = "Verify Remove Import Content")
	@Description("Test Description:Verify Remove Import Content")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verify Remove Import Content")
	public void testRemoveImportContent() {
		logger.info("Starting of testRemoveImportContent method");

		try {
			this.tutorAddContentPage.clickOnContentButton();
			this.tutorAddContentPage.clickOnMenuVerticalIcon1();
			this.tutorAddContentPage.clickOnRemoveFolderButton();

			// Assertion for checking the delete import ontent text
			String lblDeleteContent = this.tutorAddContentPage.getLabelDeleteContentText();
			Assert.assertEquals(lblDeleteContent, expectedAssertionsProp.getProperty(DELETE_FOLDER_TEXT));

			this.tutorAddContentPage.clickOnConfirmRemoveButton();
		} catch (Exception e) {
			Assert.fail("Exception occured while testing  Remove Import Content: " + e.getMessage());
			logger.error("Error occured while testing  Remove Import Content", e);
		}

		logger.info("Ending of testRemoveImportContent method");
	}

	@Test(priority = 33, description = "Verify Remove Import Live")
	@Description("Test Description:Verify Remove Import Live")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verify Remove Import Live")
	public void testRemoveImportLive() {
		logger.info("Starting of testRemoveImportLive method");

		try {
			this.tutorAddContentPage.clickOnRemoveVideo();
			this.tutorAddContentPage.clickOnRemoveVideoButton();

			// Assertion for checking the remove importlive text
			String removeVedioMessage = this.tutorAddContentPage.videoRemoveMessageText();
			Assert.assertEquals(removeVedioMessage,
					expectedAssertionsProp.getProperty(CONTENT_DELETED_SUCCESSFULLY_TEXT));

		} catch (Exception e) {
			Assert.fail("Exception occured while testing  Remove Import Live: " + e.getMessage());
			logger.error("Error occured while testing Remove Import Live", e);
		}

		logger.info("Ending of testRemoveImportLive method");
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
			if (this.driver != null) {
				Thread.sleep(5000);
				this.loginPage.clickOnLogOut();
				this.quitDriver(this.driver, WEB_DRIVER.ADD_CONTENT_TEST);
				logger.info("Driver quit successfully");
			}

		} catch (Exception ex) {
			logger.error(ex.getMessage());
		}
	}

	@AfterMethod
	public void logBrowserConsoleErrors() {
		LogEntries logentries = driver.manage().logs().get(LogType.BROWSER);
		for (LogEntry logentrey : logentries) {
			logger.error(logentrey);
		}
	}
}