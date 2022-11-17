package com.classplusapp.web.pages.faculty;

import org.apache.log4j.Logger;
import java.io.File;
import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.classplusapp.web.pages.BaseClassplusAutomationPage;

public class FacultyAddContentPage extends BaseClassplusAutomationPage {

	@FindBy(xpath = "//p[text()='Store']")
	private WebElement btnStore;

	@FindBy(xpath = "//span[@style='padding-bottom: 1rem;']")
	private WebElement lblMyCourses;

	@FindBy(xpath = "//input[@placeholder='Search for a course']")
	private WebElement txtSearchCourse;

	@FindBy(xpath = "//div[contains(text(),'SUB-CATEGORIES')]")
	private WebElement lblSubCategories;

	@FindBy(xpath = "//span[contains(text(),'B2B Faculty')]")
	private WebElement getCourse;

	@FindBy(xpath = "//span[contains(text(),'Content')]//parent::div")
	private WebElement btnContent;

	@FindBy(xpath = "//div[contains(text(),'Add Content')]")
	private WebElement lblAddContent;

	@FindBy(xpath = "//a[contains(text(),'Folder')]")
	private WebElement mnuAddFolderIcon;

	@FindBy(xpath = "//p[contains(text(),'B2B Faculty')]")
	private WebElement lblB2bContent;

	@FindBy(xpath = "//input[@placeholder=\"Enter Folder Name and then press enter\"]")
	private WebElement txtFolderName;

	@FindBy(xpath = "//button[contains(text(),'Save')]")
	private WebElement btnSaveFolder;

	@FindBy(xpath = "//div[contains(text(),'Content added successfully')]")
	private WebElement msgSaveFolderName;

	@FindBy(xpath = "//i[@class=\"ellipsis vertical icon\"][1]")
	private WebElement mnuVerticalIcon;

	@FindBy(xpath = "(//span[contains(text(),'Edit')])[last()]")
	private WebElement btnEdit;

	@FindBy(xpath = "//div[contains(text(),'Edit Content')]")
	private WebElement lblEditContent;

	@FindBy(xpath = "//div[text()='Name']/..//following-sibling::div//input")
	private WebElement txtEditFolderName;

	@FindBy(xpath = "//button[contains(text(),'Save')]")
	private WebElement btnEditSaveFolder;

	@FindBy(xpath = "//div[contains(text(),'Content edited successfully')]")
	private WebElement msgEditFolder;

	@FindBy(xpath = "(//span[contains(text(),'Remove')])[last()]")
	private WebElement btnRemoveFolder;

	@FindBy(xpath = "//div[contains(@class,'ui small modal')]//div[@class='header']")
	private WebElement lblDeleteContent;

	@FindBy(xpath = "(//i[@class='ellipsis vertical icon'])[1]")
	private WebElement mnuVerticalIcon1;

	@FindBy(xpath = "//button[contains(text(),'Remove')]")
	private WebElement btnConfirmRemove;

	@FindBy(xpath = "//div[contains(text(),'Content deleted successfully')]")
	private WebElement msgDeletedSuccesfullText;

	@FindBy(xpath = "//button[contains(text(),'Video')]")
	private WebElement mnuAddVideoIcon;

	@FindBy(xpath = "//div[contains(text(),'Add Video')]")
	private WebElement lblAddVideo;

	@FindBy(xpath = "//span[contains(text(),'Upload from your PC')]/parent::button")
	private WebElement btnUpload;

	@FindBy(xpath = "//span[contains(text(),'Upload from your PC')]")
	private WebElement btnUploadVideo;

	@FindBy(xpath = "//div[contains(text(),'File uploaded sucessfully. It would be available soon')]")
	private WebElement msgUploadVideoText;

	@FindBy(xpath = "//button[contains(text(),'Done')]")
	private WebElement btnDone;

	@FindBy(xpath = "//i[@class=\"ellipsis vertical icon\"]")
	private WebElement mnuVerticalIcon2;

	@FindBy(xpath = "(//span[contains(text(),'Remove')])[last()]")
	private WebElement btnRemove;

	@FindBy(xpath = "//div[contains(text(),'Content deleted successfully')]")
	private WebElement msgVideoDeleteText;

	@FindBy(xpath = "//div[@style='display: flex; align-items: center;']")
	private WebElement mnuSubjectiveTestIcon;

	@FindBy(xpath = "//div[contains(text(),'Add Subjective Test')]")
	private WebElement lblSubjectiveTest;

	@FindBy(xpath = "//div[@class='SubAddTest__CreateSubBtn']")
	private WebElement btnCreateNewSubjTest;

	@FindBy(xpath = "//div[contains(text(),'Create New Subjective Test')]")
	private WebElement lblCreateNewSubjectiveTest;

	@FindBy(xpath = "//input[@type='text']")
	private WebElement txtSubjName;

	@FindBy(xpath = "//input[@type='number']")
	private WebElement txtTotalSubjMarks;

	@FindBy(xpath = "//input[@type='file']")
	private WebElement btnAddFiles;

	@FindBy(xpath = "//div[contains(text(),'1 File(s) added successfully')]")
	private WebElement msgFileUploadedSubjText;

	@FindBy(xpath = "//div[contains(text(),'Create & Add Test')]")
	private WebElement btnCreateAndAddSubjTest;

	@FindBy(xpath = "//div[contains(text(),'Subjective Test Added Successfully')]")
	private WebElement msgFileAddedSubj;

	@FindBy(xpath = "//i[@class='ellipsis vertical icon']")
	private WebElement mnuVerticalIcon3;

	@FindBy(xpath = "//p[@class='greytext']")
	private WebElement btnUnlockSubjtiveTest;

	@FindBy(xpath = "//span[@style='margin-left: 0.4rem;']")
	private WebElement btnLockSubj;

	@FindBy(xpath = "//span[contains(text(),'Remove')]")
	private WebElement btnRemoveSubj;

	@FindBy(xpath = "//div[contains(text(),'Remove Confirmation')]")
	private WebElement lblRemoveConfirmation;

	@FindBy(xpath = "(//button[@role='button'])[2]")
	private WebElement btnRemoveConfirmSubj;

	@FindBy(xpath = "//div[contains(text(),'Content deleted successfully')]")
	private WebElement msgSubjTestDelete;

	@FindBy(xpath = "//button[contains(text(),'Document')]")
	private WebElement mnuDocumentIcon;

	@FindBy(xpath = "//div[contains(text(),'Add Document')]")
	private WebElement lblAddDocumentText;

	@FindBy(xpath = "//input[@placeholder='Enter Document Name']")
	private WebElement txtDocument;

	@FindBy(xpath = "//textarea[@placeholder=\"Description goes here\"]")
	private WebElement txtDocDescription;

	@FindBy(xpath = "//button[@class=\"ui primary button dropdownmarginleft\"] / following-sibling::input")
	private WebElement btnSelectDoc;

	@FindBy(xpath = "//button[contains(text(),'Upload Document')]")
	private WebElement btnUploadDoc;

	@FindBy(xpath = "//div[contains(text(),'Content added successfully')]")
	private WebElement msgDocumentUploaded;

	@FindBy(xpath = "//button[contains(text(),'Image')]")
	private WebElement mnuImageIcon;

	@FindBy(xpath = "//div[contains(text(),'Add Image')]")
	private WebElement lblAddImage;

	@FindBy(xpath = "//input[@placeholder='Enter Image Name']")
	private WebElement txtImageName;

	@FindBy(xpath = "//textarea[@placeholder=\"Description goes here\"]")
	private WebElement txtImgDescription;

	@FindBy(xpath = "//button[contains(text(),'Select Image')]/ following-sibling::input")
	private WebElement btnSelectImage;

	@FindBy(xpath = "//button[contains(text(),'Upload Image')]")
	private WebElement btnUploadImage;

	@FindBy(xpath = "//div[contains(text(),'Content added successfully')]")
	private WebElement btnImageSuccess;

	@FindBy(xpath = "//div[contains(text(),'Zip File')]")
	private WebElement mnuZipFileIcon;

	@FindBy(xpath = "//div[contains(text(),'Add Zip')]")
	private WebElement lblAddZip;

	@FindBy(xpath = "//input[@placeholder=\"Enter Zip Name\"]")
	private WebElement txtZipFileName;

	@FindBy(xpath = "//textarea[@placeholder='Description goes here']")
	private WebElement txtDescriptionZip;

	@FindBy(xpath = "//div[contains(text(),'Choose Files')]/preceding-sibling::form/input/preceding-sibling::input")
	// @FindBy(xpath = "//input[@type='file']")
	private WebElement btnChooseZipFile;

	@FindBy(xpath = "//button[contains(text(),'Upload Zip')]")
	private WebElement btnUploadZipFile;

	@FindBy(xpath = "//div[contains(text(),'Content added successfully')]")
	private WebElement msgFileUploadedZip;

	@FindBy(xpath = "//p[@class=\"greytext\"]")
	private WebElement btnLockZip;

	@FindBy(xpath = "//div[contains(text(),'Content edited successfully')]")
	private WebElement msgLockSuccesfullZip;

	@FindBy(xpath = "(//i[@class='ellipsis vertical icon'])[3]")
	private WebElement mnuVerticalIcon4;

	@FindBy(xpath = "//span[contains(text(),'Edit')]")
	private WebElement btnEditMenuZip;

	@FindBy(xpath = "//input[@placeholder='Enter New Name']")
	private WebElement txtEditZipFileName;

	@FindBy(xpath = "//button[contains(text(),'Save')]")
	private WebElement btnZipFileSave;

	@FindBy(xpath = "//div[contains(text(),'Content edited successfully')]")
	private WebElement editSuccesfullMessageZip;

	@FindBy(xpath = "//i[@class='ellipsis vertical icon']")
	private WebElement mnuVerticalIcon5;

	@FindBy(xpath = "//span[contains(text(),'Unlock')]")
	private WebElement btnUnlockZip;

	@FindBy(xpath = "//div[contains(text(),'Content edited successfully')]")
	private WebElement msgLockedSuccesfull;

	@FindBy(xpath = "//i[@class='ellipsis vertical icon']")
	private WebElement mnuVerticalIcon6;

	@FindBy(xpath = "//span[contains(text(),'Remove')]")
	private WebElement btnRemoveFileZip;

	@FindBy(xpath = "//div[contains(text(),'Content deleted successfully')]")
	private WebElement msgDeletedSuccesfullTextZip;

	@FindBy(xpath = "//button[contains(text(),'Import Content')]")
	private WebElement mnuImportContentIcon;

	@FindBy(xpath = "//span[contains(text(),'Import Content')]")
	private WebElement lblImportContent;

	@FindBy(xpath = "(//span[@class=\"checkbox-custom rectangular\"])[1]")
	private WebElement chkImportContent;

	@FindBy(xpath = "(//button[@class=\"ui button dropdownmarginleft\"])[2]")
	private WebElement btnImportSelected;

	@FindBy(xpath = "//div[contains(text(),'Content imported Successfully')]")
	private WebElement msgImported;

	@FindBy(xpath = "//button[contains(text(),'Import Live')]")
	private WebElement mnuImportLiveIcon;

	@FindBy(xpath = "//span[contains(text(),'Import Live Classes')]")
	private WebElement lblImportLiveClasses;

	@FindBy(xpath = "(//span[@class=\"checkbox-custom rectangular\"])[1]")
	private WebElement chkLiveClasses;

	@FindBy(xpath = "//p[contains(text(),'Import Selected')]")
	private WebElement btnLiveSelected;

	@FindBy(xpath = "//div[contains(text(),'Content imported Successfully')]")
	private WebElement msgLiveSuccess;

	@FindBy(xpath = "//span[contains(text(),'Publish Course')]")
	private WebElement btnPublishCourse;

	@FindBy(xpath = "(//span[contains(text(),'Publish Course')])[2]")
	private WebElement lblPublishCourse;

	@FindBy(xpath = "//button[contains(text(),'Publish Course')]")
	private WebElement btnPublishCourse1;

	@FindBy(xpath = "//div[@class='ShareModal_Content_Top--Close']")
	private WebElement btnCross;

	@FindBy(xpath = "//div[contains(text(),'Course Published')]")
	private WebElement msgPublishSucces;

	@FindBy(xpath = "//span[contains(text(),'Unpublish Course')]")
	private WebElement btnUnpublishCourse;

	@FindBy(xpath = "//div[contains(text(),'Unpublish Confirmation')]")
	private WebElement lblUnpublishCourse;

	@FindBy(xpath = "//button[contains(text(),'Unpublish')]")
	private WebElement btnUnpublish;

	@FindBy(xpath = "//div[contains(text(),'Status updated successfully.')]")
	private WebElement msgUnpublishSuccess;

	@FindBy(xpath = " //span[contains(text(),'Overview ')]")
	private WebElement btnOverView;

	@FindBy(xpath = "//i[@class=\"ellipsis vertical icon\"]")
	private WebElement mnuVerticalIcon7;

	@FindBy(xpath = "//span[contains(text(),\"Remove Course\")]")
	private WebElement btnRemoveCourse;

	@FindBy(xpath = "//div[contains(text(),'Remove Confirmation')]")
	private WebElement lblRemoveConfirmationText;

	@FindBy(xpath = "//button[contains(text(),'Remove')]")
	private WebElement btnCourseRemove;

	@FindBy(xpath = "//div[contains(text(),'Course Deleted Successfully')]")
	private WebElement msgDelete;

	@FindBy(xpath = "//input[@type=\"file\"]")
	private WebElement btnVideoUpload;

	@FindBy(xpath = "//button[contains(text(),'View Stats')]")
	private WebElement btnViewStats;

	@FindBy(xpath = "//button[contains(text(),'View Leaderboard')]")
	private WebElement btnViewLeaderBoard;

	@FindBy(xpath = "//div[text()='VIEW ANSWER SHEET']")
	private WebElement btnViewAnswerSheet;

	@FindBy(xpath = "//iframe[@class='testIframe--test']")
	private WebElement testFrame;

	@FindBy(xpath = "//iframe[@class='razorpay-checkout-frame']")
	private WebElement testIframe;

	@FindBy(xpath = "//div[@class='header_download']/span")
	private WebElement btnDownload;

	@FindBy(xpath = "//div[contains(text(),'Success Downloading Answer Paper')]")
	private WebElement msgDownloaded;

	@FindBy(xpath = "(//div[@class='header'])[2]")
	private WebElement lblStatsHeader;

	@FindBy(xpath = "//div[text()='VIEW ANSWER SHEET']")
	private WebElement btnStatsViewAnswerSheet;

	@FindBy(xpath = "//img[@class='addContent__SVGClose']")
	private WebElement imgClose;

	@FindBy(xpath = "//span[text()='Download']")
	private WebElement imgDownload;

	@FindBy(xpath = "//div[text()='Your score']")
	private WebElement lblYourScoreName;

	@FindBy(xpath = "//span[@class='statsModal-score-marks ']/following-sibling::span[@class='statsModal-score-fullMarks']//parent::div")
	private WebElement lblMarks;

	@FindBy(xpath = "//div[text()='Highest score']")
	private WebElement lblHighScoreName;

	@FindBy(xpath = "//span[@class='statsModal-score-marks']//following-sibling::span[@class='statsModal-score-fullMarks']//parent::div")
	private WebElement lblHighScoreMarks;

	@FindBy(xpath = "//div[@class='Timeline__data']//child::div[text()='Submitted']")
	private WebElement lblSubmittedName;

	@FindBy(xpath = "( //div[@class='Timeline_data'])//child::div[@class='Timeline_desc'][1]")
	private WebElement lblSubmittedDateAndTime;

	@FindBy(xpath = "( //div[@class='Timeline__data'])//child::div[text()='Evaluated'][1]")
	private WebElement lblEvaluatedName;

	@FindBy(xpath = "(//div[text()='Evaluated'])//following-sibling::div[@class='Timeline__desc'][1]")
	private WebElement lblEvaluatedDateAndTime;

	@FindBy(xpath = "//span[@class='NameTile_MarksObtained']//following-sibling::span[@class='NameTile_TotalMarks']/parent::div")
	private WebElement lblObtainedTotalMarks;

	@FindBy(xpath = "//div[@class='header-text margin_0']")
	private WebElement subjectiveTestHeader;

	@FindBy(xpath = "//div[@class='addContent__content--buttons flexrow']/button/following-sibling::button")
	private WebElement txtPreviewSubjectiveTest;

	@FindBy(xpath = "//div[@class='rrt-text']")
	private WebElement msgDownloadQuestionPaper;

	private static final String menuVerticalIcon = "//p[text()='${text}']/..//..//following-sibling::div//i";
	private static final Logger logger = Logger.getLogger(FacultyAddContentPage.class.getName());

	public FacultyAddContentPage(WebDriver driver) {
		super(driver);
		logger.info("Starting of FacultyAddContentPage method");
		PageFactory.initElements(driver, this);
		logger.info("Ending of FacultyAddContentPage method");

	}

	public void clickOnStoreButton() {
		logger.info("starting of clickOnStoreButton method");

		try {
			this.btnStore.click();
		} catch (Exception e) {
			this.clickOnWebElement(btnStore);
		}

		logger.info("Ending of clickOnStoreButton method");
	}

	public String getMyCoursesPage() {
		logger.info("Starting of getMyCoursesPage method");

		this.explicitWait(lblMyCourses);

		logger.info("Ending of getMyCoursesPage method");
		String[] s = lblMyCourses.getText().split(" ");
		return s[0];
	}

	public void clickOnTxtSearchCourse(String strSearch) {
		logger.info("Starting of clickOnTxtSearchCourse method");

		this.txtSearchCourse.sendKeys(strSearch);

		logger.info("Ending of clickOnTxtSearchCourse method");
	}

	public String getSubCategoriesLabel() {
		logger.info("Starting of getSubCategoriesLabel method");
		logger.info("Ending of getSubCategoriesLabel method");
		return lblSubCategories.getText();
	}

	public void clickOnGetCourseFolder() {
		logger.info("Starting of clickOnGetCourseFolder method");

		// this.explicitWait(getCourse);
		this.clickOnWebElement(getCourse);

		logger.info("Ending of clickOnGetCourseFolder method");
	}

	public void clickOnContentButton() {
		logger.info("Starting of clickOnContentButton method");

		waitForElementVisibilty(btnContent);
		this.clickOnWebElement(btnContent);

		logger.info("Ending of clickOnContentButton method");
	}

	public String getAddContentLabel() {
		logger.info("Starting of getAddContentLabel method");

		logger.info("Ending of getAddContentLabel method");
		return this.lblAddContent.getText();
	}

	public void clickOnMenuAddFolderIcon() {
		logger.info("starting of clickOnMenuAddFolderIcon  method");

		this.clickOnWebElement(mnuAddFolderIcon);

		logger.info("Ending of clickOnMenuAddFolderIcon method");
	}

	public String getB2bAddContentLabel() {
		logger.info("Starting of getB2bAddContentLabel method");

		logger.info("Ending of getB2bAddContentLabel method");
		return this.lblB2bContent.getText();
	}

	public void setFolderName(String strfoldername) {
		logger.info("Starting of setFolderName method");

		this.explicitWait(txtFolderName);
		this.txtFolderName.clear();
		this.txtFolderName.sendKeys(strfoldername);

		logger.info("Ending of setFolderName method");
	}

	public void clickOnSaveFolderButton() {
		logger.info("starting of clickOnSaveFolderButton  method");

		this.explicitWait(btnSaveFolder);
		this.btnSaveFolder.click();

		logger.info("Ending of clickOnSaveFolderButton method");
	}

	public String getSaveSuccessMessageText() {
		logger.info("Starting of getSaveSuccessMessageText method");

		this.explicitWait(msgSaveFolderName);

		logger.info("Ending of getSaveSuccessMessageText method");
		return this.msgSaveFolderName.getText();
	}

	public void clickOnMenuVerticalIcon2() {
		logger.info("starting of clickOnMenuVerticalIcon2  method");

		this.explicitWait(mnuVerticalIcon2);
		this.clickOnWebElement(mnuVerticalIcon2);

		logger.info("Ending of clickOnMenuVerticalIcon2 method");
	}

	public void clickOnMenuEditButton() {
		logger.info("Starting of  clickOnMenuEditButton method");

		this.explicitWait(btnEdit);
		this.clickOnWebElement(btnEdit);

		logger.info("Ending of clickOnMenuEditButton method");
	}

	public String getLabelEditContentText() {
		logger.info("Starting of getLabelEditContentText method");

		logger.info("Ending of getLabelEditContentText method");
		return lblEditContent.getText();
	}

	public void setFolder(String strEditFolder) {
		logger.info("Starting of setFolder method");

		this.explicitWait(txtEditFolderName);
		this.clickOnWebElement(txtEditFolderName);
		this.clickOnWebElement(txtEditFolderName);
		this.explicitWait(txtEditFolderName);

		this.txtEditFolderName.clear();
		this.txtEditFolderName.sendKeys(strEditFolder);

		logger.info("Ending of setFolder method");
	}

	public void clickOnEditSaveButton() {
		logger.info("Starting of clickOnEditSaveButton method");

		this.explicitWait(btnEditSaveFolder);
		this.clickOnWebElement(btnEditSaveFolder);

		logger.info("Ending of clickOnEditSaveButton method");
	}

	public String getEditSuccessMessageText() {
		logger.info("Starting of getEditSuccessMessageText method");

		this.explicitWait(msgEditFolder);

		logger.info("Ending of getEditSuccessMessageText method");
		return this.msgEditFolder.getText();
	}

	public void clickOnMenuVerticalIcon1(String contentTitle) {
		logger.info("starting of clickOnMenuVerticalIcon1  method");

		this.explicitWait(driver.findElement(By.xpath(menuVerticalIcon.replace("${text}", contentTitle))));
		this.clickOnWebElement(driver.findElement(By.xpath(menuVerticalIcon.replace("${text}", contentTitle))));

		logger.info("Ending of clickOnMenuVerticalIcon1 method");
	}

	public void clickOnRemoveFolderButton() {
		logger.info("starting of clickOnRemoveFolderButton  method");

		this.explicitWait(btnRemoveFolder);
		this.clickOnWebElement(btnRemoveFolder);

		logger.info("Ending of clickOnRemoveFolderButton method");
	}

	public String getLabelDeleteContentText() {
		logger.info("Starting of getLabelDeleteContentText method");

		logger.info("Ending of getLabelDeleteContentText method");
		return lblDeleteContent.getText();

	}

	public void clickOnMenuVerticalIcon1() {
		logger.info("starting of clickOnMenuVerticalIcon1  method");

		try {
			this.explicitWait(mnuVerticalIcon1);
			this.clickOnWebElement(mnuVerticalIcon1);
		} catch (Exception e) {
			this.clickOnWebElement(mnuVerticalIcon1);
		}
		logger.info("Ending of clickOnMenuVerticalIcon1 method");
	}

	public void clickOnConfirmRemoveButton() {
		logger.info("starting of clickOnConfirmRemoveButton  method");

		this.explicitWait(btnConfirmRemove);
		this.btnConfirmRemove.click();

		logger.info("Ending of clickOnConfirmRemoveButton method");
	}

	public String getDeleteSuccessMessageText() {
		logger.info("Starting of getDeleteSuccessMessageText method");

		// this.explicitWait(msgDeletedSuccesfullText);

		logger.info("Ending of getDeleteSuccessMessageText method");
		return this.msgDeletedSuccesfullTextZip.getText();
	}

	public void clickOnMenuAddVideoIcon() {
		logger.info("starting of clickOnMenuAddVideoIcon method");

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.clickOnWebElement(mnuAddVideoIcon);

		logger.info("Ending of clickOnMenuAddVideoIcon method");
	}

	public String getAddVideoLabelText() {
		logger.info("Starting of getAddVideoLabelText method");

		logger.info("Ending of getAddVideoLabelText method");
		return this.lblAddVideo.getText();
	}

	public void uploadVideoButton(String filepath) {
		logger.info("Starting of uploadVideoButton method");

		try {
			this.clickOnWebElement(btnUploadVideo);
			Thread.sleep(1000);
			this.closeOSWindow();
			Thread.sleep(1000);
			this.btnVideoUpload.sendKeys(filepath);
		} catch (Exception e) {
		}

		logger.info("Ending of uploadVideoButton method");
	}

	public String getVideoUploadedMessageText() {
		logger.info("Starting of getVideoUploadedMessage method");
		logger.info(" Ending of getVideoUploadedMessage method");

		return this.msgUploadVideoText.getText();
	}

	public void clickOnDoneButton() {
		logger.info("Starting of clickOnDoneButton method");

		this.explicitWait(btnDone);
		this.clickOnWebElement(btnDone);

		logger.info("Ending of clickOnDoneButton method");
	}

	public void clickOnRemoveVideo() {
		logger.info("Starting of clickOnRemoveVideo method");
		try {
			Thread.sleep(2000);
			this.mnuVerticalIcon2.click();
		} catch (Exception e) {
			this.clickOnWebElement(mnuVerticalIcon2);
		}

		logger.info("Ending of clickOnRemoveVideo method");
	}

	public void clickOnRemoveVideoButton() {
		logger.info("Starting of clickOnRemoveVideoButton method");

		this.explicitWait(btnRemove);
		this.clickOnWebElement(btnRemove);

		logger.info("Ending of clickOnRemoveVideoButton method");
	}

	public String videoRemoveMessageText() {
		logger.info("Starting of videoRemoveMessageText method");

		this.explicitWait(msgVideoDeleteText);

		logger.info(" Ending of videoRemoveMessageText method");
		return this.msgVideoDeleteText.getText();
	}

	public void clickOnMenuSubjectiveTestIcon() {
		logger.info("Starting of clickOnMenuSubjectiveTestIcon method");

		this.explicitWait(mnuSubjectiveTestIcon);
		this.clickOnWebElement(mnuSubjectiveTestIcon);

		logger.info("Ending of clickOnMenuSubjectiveTestIcon method");
	}

	public String getSubjectiveTestLabel() {
		logger.info("Starting of getSubjectiveTestLabel method");

		// this.explicitWait(msgDeletedSuccesfullText);

		logger.info("Ending of getSubjectiveTestLabel method");
		return this.lblSubjectiveTest.getText();
	}

	public void clickOnCreateNewTestButton() {
		logger.info("Starting of clickOnCreateNewTestButton method");

		this.clickOnWebElement(btnCreateNewSubjTest);

		logger.info("Ending of clickOnCreateNewTestButton method");

	}

	public String getCreateNewSubjectiveTestLabel() {
		logger.info("Starting of getCreateNewSubjectiveTestLabel method");

		// this.explicitWait(msgDeletedSuccesfullText);

		logger.info("Ending of getCreateNewSubjectiveTestLabel method");
		return this.lblCreateNewSubjectiveTest.getText();
	}

	public void setTextTestName(String strName) {
		logger.info("Starting of setTextTestName method");

		this.txtSubjName.sendKeys(strName);

		logger.info("Ending of setTextTestName method");

	}

	public void clickOnTextTotalMarks(String strName) {
		logger.info("Starting of clickOnTextTotalMarks method");

		this.txtTotalSubjMarks.sendKeys(strName);

		logger.info("Ending of clickOnTextTotalMarks method");

	}

	public void clickOnAddFilesButton() {
		logger.info("starting of setUploadImageButton method");

		String osPath = System.getProperty("os.name");
		if (osPath.contains("Linux")) {
			btnAddFiles.sendKeys(TEST_FILE_PATH + "/testdata/subjectiveTutorPdf.pdf");
		} else {

			btnAddFiles.sendKeys(TEST_FILE_PATH + "\\testdata\\subjectiveTutorPdf.pdf");
			// btnAddFiles.sendKeys(TEST_FILE_PATH + File.separator + "testdata" +
			// File.separator + "subjectiveTutorPdf.pdf");
		}

		logger.info("Ending of setUploadImageButton method");
	}

	public String getSaveSubjSuccessMessage() {
		logger.info("Starting of getSaveSubjSuccessMessage method");

		logger.info("Ending of getSaveSubjSuccessMessage method");
		return msgFileUploadedSubjText.getText();
	}

	public void clickOnCreateAndAddTestButton() {
		logger.info("Starting of clickOnCreateAndAddTestButton method");

		try {
			this.clickOnWebElement(btnCreateAndAddSubjTest);
		} catch (Exception e) {
			Actions act = new Actions(driver);
			act.click(btnCreateAndAddSubjTest).perform();
		}

		logger.info("Ending of clickOnCreateAndAddTestButton method");
	}

	public String getAddedfileSuccessMessageText() {
		logger.info("Starting of getAddedfileSuccessMessageText method");

		logger.info("Ending of getAddedfileSuccessMessageText method");
		return msgFileAddedSubj.getText();
	}

	public void clickOnUnlockButton() {
		logger.info("Starting of clickOnUnlockButton method");

		this.clickOnWebElement(btnUnlockSubjtiveTest);

		logger.info("Ending of clickOnUnlockButton method");

	}

	public void clickOnMenuVerticalIcon3() {
		logger.info("Starting of clickOnMenuVerticalIcon3 method");

		this.explicitWait(mnuVerticalIcon3);
		this.clickOnWebElement(mnuVerticalIcon3);

		logger.info("Ending of clickOnMenuVerticalIcon3 method");

	}

	public void clickOnLockSubjectiveButton() {
		logger.info("Starting of clickOnLockSubjectiveButton method");

		this.btnLockSubj.click();

		logger.info("Ending of clickOnLockSubjectiveButton method");

	}

	public void clickOnRemoveSubjectiveButton() {
		logger.info("Starting of clickOnRemoveSubjectiveButton method");

		waitForElementVisibilty(btnRemoveSubj);
		this.clickOnWebElement(btnRemoveSubj);

		logger.info("Ending of clickOnRemoveSubjectiveButton method");

	}

	public String getlabelRemoveConfirmationText() {
		logger.info("Starting of getlabelRemoveConfirmationText method");

		logger.info("Ending of getlabelRemoveConfirmationText method");
		return lblRemoveConfirmation.getText();
	}

	public void clickOnRemoveSubjConfirmButton() {
		logger.info("Starting of clickOnRemoveSubjConfirmButton method");

		waitForElementVisibilty(btnRemoveConfirmSubj);
		this.clickOnWebElement(btnRemoveConfirmSubj);

		logger.info("Ending of clickOnRemoveSubjConfirmButton method");

	}

	public String subjTestRemovedMessageText() {
		logger.info("Starting of subjTestRemovedMessageText method");

		this.explicitWait(msgSubjTestDelete);

		logger.info(" Ending of subjTestRemovedMessageText method");
		return this.msgSubjTestDelete.getText();
	}

	public void clickOnMenuDocumentIcon() {
		logger.info("Starting of clickOnMenuDocumentIcon method");

		ArrayList<String> tab = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tab.get(0));
		this.explicitWait(mnuDocumentIcon);
		this.clickOnWebElement(mnuDocumentIcon);

		logger.info("Ending of clickOnMenuDocumentIcon method");
	}

	public String getLabelDocumentText() {
		logger.info("Starting of getLabelDocumentText method");

		logger.info("Ending of getlabelDocumentText method");
		return lblAddDocumentText.getText();
	}

	public void setTextDocument(String strDoc) {
		logger.info("Starting of getLabelDocumentText method");

		this.txtDocument.sendKeys(strDoc);

		logger.info("Ending of setTextDocument method");
	}

	public void setTextDocDescription(String strDscrtn) {
		logger.info("Starting of setTextDocDescription method");

		this.txtDocDescription.sendKeys(strDscrtn);

		logger.info("Ending of setTextDocDescription method");
	}

	public void clickOnSelectDocumentButton() {
		logger.info("starting of clickOnSelectDocumentButton method");

		String osPath = System.getProperty("os.name");
		if (osPath.contains("Linux")) {
			btnSelectDoc.sendKeys(TEST_FILE_PATH + "/testdata/contentdocument.pdf");
		} else {
			btnSelectDoc.sendKeys(TEST_FILE_PATH + "\\testdata\\contentdocument.pdf");

			// btnSelectDoc.sendKeys(TEST_FILE_PATH + File.separator + "testdata" +
			// File.separator + "contentdocument.pdf");
		}

		logger.info("Ending of clickOnSelectDocumentButton method");
	}

	public void clickOnUploadDocumentButton() {
		logger.info("Starting of clickOnUploadDocumentButton method");

		try {
			Thread.sleep(1000);
			this.btnUploadDoc.click();
		} catch (Exception e) {
			this.clickOnWebElement(btnUploadDoc);
		}

		logger.info("Ending of clickOnUploadDocumentButton method");
	}

	public String documentUploadedMessageText() {
		logger.info("Starting of documentUploadedMessageText method");

		this.explicitWait(msgDocumentUploaded);

		logger.info(" Ending of documentUploadedMessageTexts method");
		return this.msgDocumentUploaded.getText();
	}

	public void clickOnMenuImageIcon() {
		logger.info("Starting of clickOnMenuImageIcon method");

		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.clickOnWebElement(mnuImageIcon);

		logger.info("Ending of clickOnMenuImageIcon method");
	}

	public String getLabelAddImageText() {
		logger.info("Starting of getLabelAddImageText method");

		logger.info(" Ending of getLabelAddImageText method");

		return this.lblAddImage.getText();
	}

	public void setTextImageName(String strImg) {
		logger.info("Starting of setTextImageName method");

		this.txtImageName.sendKeys(strImg);

		logger.info("Ending of setTextImageName method");
	}

	public void setTextImageDescription(String strDscrptn) {
		logger.info("Starting of setTextImageDescription method");

		this.txtImgDescription.sendKeys(strDscrptn);

		logger.info("Ending of setTextImageDescription method");
	}

	public void setUploadImageButton() {
		logger.info("starting of setUploadImageButton method");

		String osPath = System.getProperty("os.name");
		if (osPath.contains("Linux")) {
			btnSelectImage.sendKeys(TEST_FILE_PATH + "/testdata/contentimage.png");
		} else {
			btnSelectImage.sendKeys(TEST_FILE_PATH + "\\testdata\\contentimage.png");

			// btnSelectImage.sendKeys(TEST_FILE_PATH + File.separator + "testdata" +
			// File.separator + "contentimage.png");
		}

		logger.info("Ending of setUploadImageButton method");
	}

	public void clickOnUploadImgButton() {
		logger.info("Starting of clickOnUploadImgButton method");

		waitForElementVisibilty(btnUploadImage);
		this.clickOnWebElement(btnUploadImage);

		logger.info("Ending of clickOnUploadImgButton method");
	}

	public String getSuccessImageMessageText() {
		logger.info("Starting of getSuccessImageMessageText method");

		this.explicitWait(btnImageSuccess);

		logger.info("Ending of getSuccessImageMessageText method");
		return this.btnImageSuccess.getText();
	}

	public void clickOnMenuZipIcon() {
		logger.info("Starting of clickOnMenuZipIcon method");

		waitForElementVisibilty(mnuZipFileIcon);
		this.clickOnWebElement(mnuZipFileIcon);

		logger.info("Ending of clickOnMenuZipIcon method");
	}

	public String getLabelAddZipText() {
		logger.info("Starting of getLabelAddZipText method");

		logger.info(" Ending of getLabelAddZipText method");
		return this.lblAddZip.getText();
	}

	public void setTextFileName(String strFileName) {
		logger.info("Starting of setTextFileName method");

		this.txtZipFileName.sendKeys(strFileName);

		logger.info("Ending of setTextFileName method");
	}

	public void setTextDescription(String strDesc) {
		logger.info("Starting of setTextDescription method");

		this.explicitWait(txtDescriptionZip);
		this.txtDescriptionZip.sendKeys(strDesc);

		logger.info("Ending of setTextDescription method");
	}

	public void clickOnChooseFileButton() {
		logger.info("starting of clickOnChooseFileButton method");

		String osPath = System.getProperty("os.name");
		if (osPath.contains("Linux")) {
			btnChooseZipFile.sendKeys(TEST_FILE_PATH + "/testdata/samplezipfile.zip");
		} else {
			btnChooseZipFile.sendKeys(TEST_FILE_PATH + "\\testdata\\samplezipfile.zip");

			// btnChooseZipFile.sendKeys(TEST_FILE_PATH + File.separator + "testdata" +
			// File.separator + "samplezipfile.zip");
		}
		logger.info("Ending of clickOnChooseFileButton method");
	}

	public void clickOnUploadZipButton() {

		logger.info("Starting of clickOnUploadZipButton method");

		waitForElementVisibilty(btnUploadZipFile);
		this.clickOnWebElement(btnUploadZipFile);

		logger.info("Ending of clickOnUploadZipButton method");
	}

	public String getSaveSuccessZipMessageText() {
		logger.info("Starting of getSaveSuccessZipMessageText method");

		this.explicitWait(msgFileUploadedZip);

		logger.info("Ending of getSaveSuccessZipMessageText method");
		return msgFileUploadedZip.getText();
	}

	public void clickOnLockZipButton() {
		logger.info("Starting of  clickOnLockZipButton method");

		this.clickOnWebElement(btnLockZip);

		logger.info("Ending of clickOnLockZipButton method");
	}

	public String lockedEditSuccessMessageText() {
		logger.info("Starting of lockedEditSuccessMessageText method");

		this.explicitWait(msgLockedSuccesfull);

		logger.info("Ending of lockedEditSuccessMessageText method");
		return msgLockedSuccesfull.getText();
	}

	public void clickOnVerticalMenuZip() {
		logger.info("starting of clickOnVerticalMenuZip  method");

		this.clickOnWebElement(mnuVerticalIcon2);
		logger.info("Ending of clickOnVerticalMenuZip method");
	}

	public void clickOnEditfileButton() {
		logger.info("Starting of  clickOnEditfileButton method");

		this.clickOnWebElement(btnEditMenuZip);

		logger.info("Ending of clickOnEditfileButton method");
	}

	public void setEditName(String strFile) {
		logger.info("Starting of setEditName method");

		this.clickOnWebElement(txtEditZipFileName);
		this.txtEditZipFileName.clear();
		this.txtEditZipFileName.sendKeys(strFile);

		logger.info("Ending of setEditName method");
	}

	public void clickOnZipSaveEditedButton() {
		logger.info("Starting of clickOnZipSaveEditedButton method");

		this.clickOnWebElement(btnEditMenuZip);

		logger.info("Ending of clickOnZipSaveEditedButton method");
	}

	public String editZipSuccessMessageText() {
		logger.info("Starting of editZipSuccessMessageText method");

		this.explicitWait(editSuccesfullMessageZip);

		logger.info("Ending of editZipSuccessMessageText method");
		return this.editSuccesfullMessageZip.getText();
	}

	public void clickOnMenuVerticalIcon5() {
		logger.info("starting of clickOnMenuVerticalIcon5  method");

		this.clickOnWebElement(mnuVerticalIcon5);

		logger.info("Ending of clickOnMenuVerticalIcon5 method");
	}

	public void clickOnUnLockedButton() {
		logger.info("Starting of  clickOnUnLockedButton method");

		this.clickOnWebElement(btnUnlockZip);

		logger.info("Ending of clickOnUnLockedButton method");
	}

	public String unlockSuccessMessageText() {
		logger.info("Starting of unlockSuccessMessageText method");

		this.explicitWait(msgLockedSuccesfull);

		logger.info("Ending of unlockSuccessMessageText method");
		return msgLockedSuccesfull.getText();
	}

	public void clickOnMenuVerticalIcon6() {
		logger.info("starting of clickOnMenuVerticalIcon6  method");

		this.clickOnWebElement(mnuVerticalIcon6);

		logger.info("Ending of clickOnMenuVerticalIcon6 method");
	}

	public void clickOnRemoveFileButton() {
		logger.info("starting of clickOnRemoveFileButton  method");

		this.clickOnWebElement(btnRemoveFileZip);

		logger.info("Ending of clickOnRemoveFileButton method");
	}

	public String deleteZipSuccessMessageText() {
		logger.info("Starting of deleteZipSuccessMessageText method");

		this.explicitWait(msgDeletedSuccesfullTextZip);

		logger.info("Ending of deleteSuccessMessage method");
		return this.msgDeletedSuccesfullTextZip.getText();
	}

	public void clickOnMenuImportContentIcon() {
		logger.info("Starting of clickOnMenuImportContentIcon method");

		this.clickOnWebElement(mnuImportContentIcon);

		logger.info("Ending of clickOnMenuImportContentIcon method");
	}

	public String getlabelImportContentText() {
		logger.info("Starting of getlabelImportContentText method");
		logger.info("Ending of getlabelImportContentText method");
		return lblImportContent.getText();
	}

	public void clickOnImportCheckBox() {
		logger.info("Starting of clickOnImportCheckBox method");

		this.clickOnWebElement(chkImportContent);

		logger.info("Ending of clickOnImportCheckBox method");
	}

	public void clickOnImportSelectedButton() {
		logger.info("Starting of clickOnImportSelectedButton method");

		this.btnImportSelected.click();

		logger.info("Ending of clickOnImportSelectedButton method");
	}

	public String getSuccesImportMessageText() {
		logger.info("Starting of getSuccesImportMessageText method");

		this.explicitWait(msgImported);

		logger.info("Ending of getSuccesImportMessageText method");
		return this.msgImported.getText();
	}

	public void clickOnMenuImportLiveIcon() {
		logger.info("Starting of clickOnMenuImportLiveIcon method");

		this.clickOnWebElement(mnuImportLiveIcon);

		logger.info("Ending of clickOnMenuImportLiveIcon method");
	}

	public String getlabelImportLiveText() {
		logger.info("Starting of getlabelImportLiveText method");

		logger.info("Ending of getlabelImportLiveText method");
		return lblImportLiveClasses.getText();
	}

	public void clickOnLiveCheckBox() {
		logger.info("Starting of clickOnLiveCheckBox method");

		this.clickOnWebElement(chkLiveClasses);

		logger.info("Ending of clickOnLiveCheckBox method");
	}

	public void clickOnLiveSelectedButton() {
		logger.info("Starting of clickOnLiveSelectedButton method");

		this.clickOnWebElement(btnLiveSelected);

		logger.info("Ending of clickOnLiveSelectedButton method");
	}

	public String getSuccesLiveMessageText() {
		logger.info("Starting of getSuccesLiveMessageText method");

		this.explicitWait(msgLiveSuccess);

		logger.info("Ending of getSuccesLiveMessageText method");
		return this.msgLiveSuccess.getText();
	}

	public void clickOnPublishCourseButton() {
		logger.info("Starting of clickOnPublishCourseButton method");

		this.clickOnWebElement(btnPublishCourse);

		logger.info("Ending of clickOnPublishCourseButton method");
	}

	public String getlabelPublishCourseText() {
		logger.info("Starting of getlabelPublishCourseText method");

		logger.info("Ending of getlabelPublishCourseText method");
		return lblPublishCourse.getText();
	}

	public void clickOnPublishCourse1() {
		logger.info("Starting of clickOnPublishCourse1 method");

		this.clickOnWebElement(btnPublishCourse1);

		logger.info("Ending ofclickOnPublishCourse1 method");
	}

	public void clickOnCrossButton() {
		logger.info("Starting of clickOnCrossButton method");

		this.clickOnWebElement(btnCross);

		logger.info("Ending of clickOnCrossButton method");
	}

	public String getPublishSuccessText() {
		logger.info("Starting of getPublishSuccessText method");

		logger.info("Ending of getPublishSuccessText method");
		return this.msgPublishSucces.getText();
	}

	public void clickOnUnpublishCourseButton() {
		logger.info("Starting of clickOnUnpublishCourseButton method");

		// this.unpublishCourse.click();
		this.clickOnWebElement(btnUnpublishCourse);

		logger.info("Ending of clickOnUnpublishCourseButton method");
	}

	public String getlabelUnpulishCourseText() {
		logger.info("Starting of getlabelUnpulishCourseText method");

		logger.info("Ending of getlabelUnpulishCourseText method");
		return lblUnpublishCourse.getText();
	}

	public void clickOnUnpublishButton() {
		logger.info("Starting of clickOnUnpublishButton  method");

		this.btnUnpublish.click();

		logger.info("Ending of clickOnUnpublishButton  method");
	}

	public String getUnPublishSuccessText() {
		logger.info("Starting of getUnPublishSuccessText method");

		this.explicitWait(msgUnpublishSuccess);

		logger.info("Ending of getUnPublishSuccess method");
		return this.msgUnpublishSuccess.getText();
	}

	public void clickOnOverviewButton() {
		logger.info("Starting of clickOnOverviewButton method");

		this.clickOnWebElement(btnOverView);

		logger.info("Ending of clickOnOverviewButton method");
	}

	public void clickOnMenuVerticalIcon7() {
		logger.info("Starting of clickOnMenuVerticalIcon7 method");

		this.clickOnWebElement(mnuVerticalIcon7);

		logger.info("Ending of clickOnMenuVerticalIcon7 method");
	}

	public void clickOnRemoveCourseButton() {
		logger.info("Starting of clickOnRemoveCourseButton method");

		this.clickOnWebElement(btnRemoveCourse);

		logger.info("Ending of clickOnRemoveCourseButton method");
	}

	public String getRemoveConfirmationText() {
		logger.info("Starting of getRemoveConfirmationText method");

		this.explicitWait(lblRemoveConfirmationText);

		logger.info("Ending of getRemoveConfirmationText method");
		return lblRemoveConfirmationText.getText();
	}

	public void removeCourseButton() {
		logger.info("Starting of removeCourseButton method");

		this.clickOnWebElement(btnCourseRemove);

		logger.info("Ending of removeCourseButton method");
	}

	public String deleteMessageText() {
		logger.info("Starting of deleteMessageText method");

		this.explicitWait(msgDelete);

		logger.info("Ending of deleteMessageText method");
		return this.msgDelete.getText();
	}

	public void clickOnViewStats() {
		logger.info("Starting of clickOnViewStats method");

		try {
			this.clickOnWebElement(btnAddFiles);
		} catch (Exception e) {
			this.btnViewStats.click();
		}

		logger.info("Ending of clickOnViewStats method");

	}

	public void clickOnViewAnswerSheetButton() {
		logger.info("Starting of clickOnViewAnswerSheetButton method");

		try {
			this.btnViewAnswerSheet.click();
		} catch (Exception e) {
			this.clickOnWebElement(btnViewAnswerSheet);
		}
		this.driver.switchTo().frame(testFrame);

		logger.info("Ending of clickOnViewAnswerSheetButton method");
	}

	public void clickOnDownloadButton() {
		logger.info("Starting of clickOnDownloadButton method");

		// this.driver.switchTo().frame(testFrame);
		this.explicitWait(btnDownload);
		this.clickOnWebElement(btnDownload);

		logger.info("Ending of clickOnDownloadButton method");
	}

	public String getViewStatsLabelText() {
		logger.info("Starting of getViewStatsLabelText method");
		logger.info("Ending of getViewStatsLabelText method");

		return btnViewStats.getText();
	}

	public boolean isStatsHearderDisplayed() {
		logger.info("Starting of isStatsHearderDisplayed method");
		logger.info("Ending of isStatsHearderDisplayed method");

		return lblStatsHeader.isDisplayed();
	}

	public String getStatsViewAnswerSheetText() {
		logger.info("Starting of getStatsViewAnswerSheetText method");
		logger.info("Ending of getStatsViewAnswerSheetText method");

		return btnStatsViewAnswerSheet.getText();
	}

	public void clickOnCloseImage() {
		logger.info("Starting of clickOnCloseImage method");

		this.imgClose.click();

		logger.info("Ending of clickOnCloseImage method");
	}

	public String getDownloadText() {
		logger.info("Starting of getDownloadText method");

		this.explicitWait(imgDownload);

		logger.info("Ending of getDownloadText method");
		return imgDownload.getText();
	}

	public String getYourScoreNameLabelText() {
		logger.info("Starting of getYourScoreNameLabelText Method");
		logger.info("Ending of getYourScoreNameLabelText Method");

		return lblYourScoreName.getText();
	}

	public String getMarksLabelText() {
		logger.info("Starting of getMarksLabelText Method");
		logger.info("Ending of getMarksLabelText Method");

		return lblMarks.getAttribute("value");
	}

	public String getHighScoreNameLabelText() {
		logger.info("Starting of getHighScoreNameLabelText Method");
		logger.info("Ending of getHighScoreNameLabelText Method");

		return lblHighScoreName.getText();
	}

	public String getHighScoreMarksLabelText() {
		logger.info("Starting of getHighScoreMarksLabelText Method");
		logger.info("Ending of getHighScoreMarksLabelText Method");

		return lblHighScoreMarks.getAttribute("value");
	}

	public String getsubjectiveTestHeader() {
		logger.info("Starting of getsubjectiveTestHeader method");
		logger.info("Ending of getsubjectiveTestHeader method");
		this.switchToNewWindow();
		String ss = subjectiveTestHeader.getText();
		driver.close();
		return ss;

	}

	public void clickOnPreviewSubjectiveTest() {
		logger.info("Starting of clickOnPreviewSubjectiveTest method");

		this.explicitWait(txtPreviewSubjectiveTest);
		// this.txtPreviewSubjectiveTest.click();
		this.clickOnWebElement(txtPreviewSubjectiveTest);
		this.switchToNewWindow();

		logger.info("Ending of clickOnPreviewSubjectiveTests method");
	}

	public String getDownloadQuestionPaperMessage() {
		logger.info("Starting of getDownloadQuestionPaperMessage method");

		this.explicitWait(msgDownloadQuestionPaper);

		logger.info("Ending of getDownloadQuestionPaperMessage method");
		return msgDownloadQuestionPaper.getText();
	}

}