package com.classplusapp.web.pages.tutor;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.awt.Robot;
import java.awt.Toolkit;
//import java.awt.Robot;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.classplusapp.web.pages.BaseClassplusAutomationPage;

public class TutorAddContentPage extends BaseClassplusAutomationPage {

	@FindBy(xpath = "//p[text()='Store']")
	private WebElement btnStore;

	@FindBy(xpath = "//div[contains(text(),'My Courses')]")
	private WebElement lblMyCourses;

	@FindBy(xpath = "//button[@class='EnablePreviewCourse__Button1']")
	private WebElement btnOnNoThanks;

	@FindBy(xpath = "//button[@class='EnablePreviewCourse__Button2']")
	private WebElement btnYesEnablePreview;

	@FindBy(xpath = "//input[@class=\"Search_Input__1Ba9Y \"]")
	private WebElement txtSearchCourse;

	@FindBy(xpath = "//div[@class='Header_Search__HAUBR Search_Container__3G4uq Search_Transparent__1AbYK']/input")
	private WebElement getSearchCourse;

	@FindBy(xpath = "//span[contains(text(),'B2B Faculty')]")
	private WebElement getCourse;

	@FindBy(xpath = "//span[contains(text(),'faculty course')]")
	private WebElement getCreatedCourse;

	@FindBy(xpath = "//span[contains(text(),'Content')]")
	private WebElement btnContent;

	@FindBy(xpath = "//div[contains(text(),'Add Content')]")
	private WebElement lblAddContent;

	@FindBy(xpath = "//a[contains(text(),'Folder')]")
	private WebElement mnuAddFolderIcon;

	@FindBy(xpath = "//p[contains(text(),'B2B Faculty')]")
	private WebElement lblB2bContent;

	@FindBy(xpath = "//input[@placeholder='Enter Folder Name and then press enter']")
	private WebElement txtFolderName;

	@FindBy(xpath = "//button[contains(text(),'Save')]")
	private WebElement btnSaveFolder;

	@FindBy(xpath = "//div[contains(text(),'Content added successfully')]")
	private WebElement msgSaveFolderName;

	@FindBy(xpath = "//i[@class=\"ellipsis vertical icon\"][1]")
	private WebElement mnuVerticalIcon;

	@FindBy(xpath = "(//i[@class='ellipsis vertical icon'])[1]")
	private WebElement mnuVerticalIcon1;

	@FindBy(xpath = "//span[contains(text(),'Edit')]")
	private WebElement btnEdit;
	@FindBy(xpath = "(//img[contains(@src,'folder')]/../../../..//div[@class='lockContainer']//following-sibling::div//following-sibling::span)[2]")
	private WebElement mnuFolderBtnEdit;

	@FindBy(xpath = "//div[contains(text(),'Edit Content')]")
	private WebElement lblEditContent;

	@FindBy(xpath = "//input[@value='metadata']")
	private WebElement txtEditFolderName;

	@FindBy(xpath = "//button[contains(text(),'Save')]")
	private WebElement btnEditSaveFolder;

	@FindBy(xpath = "//div[contains(text(),'Content edited successfully')]")
	private WebElement msgEditFolder;

	@FindBy(xpath = "(//img[contains(@src,'folder')]/../../../..//div[@class='lockContainer']//following-sibling::div//following-sibling::span)[3]")
	private WebElement btnRemoveFolder;

	@FindBy(xpath = "//div[contains(text(),'Confirm Folder Delete?')]")
	private WebElement lblDeleteContent;

	@FindBy(xpath = "//button[contains(text(),'Remove')]")
	private WebElement btnConfirmRemove;

	@FindBy(xpath = "//div[contains(text(),'Content deleted successfully')]")
	private WebElement msgDeletedSuccesfullText;

	@FindBy(xpath = "//button[contains(text(),'Video')]/..")
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
	@FindBy(xpath = "//div[@class='videoTime']/../../../..//div[@class='lockContainer']//following-sibling::div")
	private WebElement mnuVerticalVideo;
	@FindBy(xpath = "//img[contains(@src,'folder')]/../../../..//div[@class='lockContainer']//following-sibling::div")
	private WebElement mnuVerticalFolder;

	@FindBy(xpath = "//span[contains(text(),'Remove')]")
	private WebElement btnRemove;
	@FindBy(xpath = "(//div[@class='videoTime']/../../../..//div[@class='lockContainer']//following-sibling::div//following-sibling::span)[3]")
	private WebElement btnRemoveVideo;

	@FindBy(xpath = "//div[contains(text(),'Content deleted successfully')]")
	private WebElement msgVideoDeleteText;

	@FindBy(xpath = "//div[@style='display: flex; align-items: center;']/parent::div[@class='item addContent__block--item']")
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

	@FindBy(xpath = "//input[@type=\"file\"]")
	private WebElement btnAddFiles;

	@FindBy(xpath = "//div[contains(text(),'1 File(s) added successfully')]")
	private WebElement msgFileUploadedSubjText;

	@FindBy(xpath = "//div[contains(text(),'Create & Add Test')]")
	private WebElement btnCreateAndAddSubjTest;

	@FindBy(xpath = "//div[contains(text(),'Subjective Test Added Successfully')]")
	private WebElement msgFileAddedSubj;

	@FindBy(xpath = "//i[@class='ellipsis vertical icon']")
	private WebElement mnuVerticalIcon3;
	@FindBy(xpath = "//img[contains(@src,'SubjectiveTestImg')]/../../../..//div[@class='lockContainer']//following-sibling::div")
	private WebElement mnuSubjectiveVerticalIcon;

	@FindBy(xpath = "(//img[contains(@src,'SubjectiveTestImg')]/../../../..//div[@class='lockContainer']//following-sibling::div//following-sibling::span)[2]")
	private WebElement btnUnlockSubjtiveTest;

	@FindBy(xpath = "(//img[contains(@src,'SubjectiveTestImg')]/../../../..//div[@class='lockContainer']//p)[1]")
	private WebElement lblUnlockMessage;

	@FindBy(xpath = "//p[@class='greytext']")
	private List<WebElement> btnLockAndUnlockContent;

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

	@FindBy(xpath = "//button[@class='ui primary button dropdownmarginleft']/following-sibling::input[@type='file']")
	private WebElement btnSelectDoc;

	@FindBy(xpath = "//button[contains(text(),'Upload Document')]")
	private WebElement btnUploadDoc;

	@FindBy(xpath = "//button[contains(text(),'Document')]")
	private WebElement btnUploadDocument;

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

	@FindBy(xpath = "//button[contains(text(),'Remove')]")
	private WebElement btnRemoveSubjective;
	@FindBy(xpath = "(//img[contains(@src,'SubjectiveTestImg')]/../../../..//div[@class='lockContainer']//following-sibling::div//following-sibling::span)[3]")
	private WebElement btnRemoveSubjectiveTest;

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
	private WebElement btnChooseZipFile;

	@FindBy(xpath = "//button[contains(text(),'Upload Zip')]")
	private WebElement btnUploadZipFile;

	@FindBy(xpath = "//div[contains(text(),'Content added successfully')]")
	private WebElement msgFileUploadedZip;

	@FindBy(xpath = "//p[@class='greytext']")
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

	@FindBy(xpath = "//p[@style=\"color: rgb(255, 255, 255);\"]")
	private WebElement btnLiveSelected;

	@FindBy(xpath = "//div[contains(text(),'Content imported Successfully')]")
	private WebElement msgLiveSuccess;

	@FindBy(xpath = "//span[contains(text(),'Publish Course')]")
	private WebElement btnPublishCourse;

	@FindBy(xpath = "(//span[contains(text(),'Publish Course')])[2]")
	private WebElement lblPublishCourse;

	@FindBy(xpath = "//button[contains(text(),'Publish Course')]")
	private WebElement btnPublishCourse1;

	@FindBy(xpath = "//div[@class='ShareModal__Content__Top--Close']")
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

	@FindBy(xpath = "//button[contains(text(),'Preview')]")
	private WebElement btnPreview;

	@FindBy(xpath = "//div[text()='Test Stats']")
	private WebElement msgTestStats;

	@FindBy(xpath = "//h2[contains(text(),'No stats available!')]")
	private WebElement noStatsLabel;

	@FindBy(xpath = "//p[contains(text(),'No student has attempted the test yet.')]")
	private WebElement noStudentAttemptedLabel;

	@FindBy(xpath = "//div[contains(@class,'header_download')]")
	private WebElement btnDownload;

	@FindBy(xpath = "//img[@alt='Close']")
	private WebElement btnClose;

	@FindBy(xpath = "//div[@class='item blockheading']")
	private WebElement lblAddContentHeader;

	@FindBy(xpath = "//div[contains(@class,'header-text margin')]")
	private WebElement lblSubjectiveTestHeader;

	@FindBy(xpath = "//iframe[@class='testIframe--test']")
	private WebElement testFrame;

	@FindBy(xpath = "//input[@class='SubAddTest__SearchSub__Input']")
	private WebElement txtSearchSubjectiveTest;

	@FindBy(xpath = "(//div[@class='SubjectivePaper__Preview'])[1]")
	private WebElement txtPreviewSubjectiveTest;

	@FindBy(xpath = "(//div[@class='SubjectivePaper__AddSub'])[1]")
	private WebElement addSubjectiveTest;

	@FindBy(xpath = "(//div[@class='SubjectivePaper__AddSub'])[1]")
	private WebElement AddSubjectiveTest;

	@FindBy(xpath = "//p[@class='greytext'][text()='Locked']")
	private WebElement btnUnlockContent;

	@FindBy(xpath = "//div[contains(text(),'Subjective Test Added Successfully')]")
	private WebElement msgAddSubjectiveTest;

	@FindBy(xpath = "//div[contains(text(),'Subjective Test')]")
	private WebElement subjectiveTestIcon;

	@FindBy(xpath = "//div[contains(text(),'Downloading  Question Paper')]")
	private WebElement msgDownloadQuestionPaper;

	@FindBy(xpath = "//div[contains(@class,'SubAddTest__CreateSubBtn')]")
	private WebElement lblCreateButton;

	@FindBy(xpath = "//input[@placeholder='Search Tests']")
	private WebElement lblSearchIcon;

	@FindBy(xpath = "//div[contains(@class,'NoSearchResult__data')]")
	private WebElement lblNoTestFound;

	@FindBy(xpath = "//img[@class='CreateSubTest-File-Icon']")
	private WebElement pdfIcon;

	@FindBy(xpath = "//div[@class='CreateSubTest-File-Header']")
	private WebElement countQuestionPaper;

	@FindBy(xpath = "//img[@src='/newApp/static/media/RightArrow.34736437.svg']")
	private WebElement btnCreateNewTest;

	@FindBy(xpath = "//div[contains(text(),'File size cannot be greater than 40 MB!')]")
	private WebElement msgErrorFile;

	@FindBy(xpath = "//div[@class='fileUplaoderButton']")
	private WebElement btnCancel;

	@FindBy(xpath = "//div[contains(text(),'Only similar file type is allowed. Please try and upload same type of files')]")
	private WebElement msgTryAgainError;

	@FindBy(xpath = "(//div[@class='fileUplaoderStatusTextContainer']//following-sibling::div)[1]")
	private WebElement uploadPercent;

	private static final Logger logger = Logger.getLogger(TutorAddContentPage.class.getName());

	public TutorAddContentPage(WebDriver driver) {
		super(driver);
		logger.info("Starting of AddContentPage method");

		PageFactory.initElements(driver, this);

		logger.info("Ending of AddContentPage method");
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
		logger.info("Ending of getMyCoursesPage method");
		return lblMyCourses.getText();
	}

	public boolean getSearchField() {
		logger.info("Starting of getSearchField method");
		logger.info("Ending of getSearchField method");
		return txtSearchCourse.isDisplayed();
	}

	public void clickOnTxtSearchCourse(String strSearch) {
		logger.info("Starting of clickOnTxtSearchCourse method");

		try {
			this.txtSearchCourse.sendKeys(strSearch);
			Thread.sleep(2000);
		} catch (Exception e) {
			this.txtSearchCourse.sendKeys(strSearch);
		}

		logger.info("Ending of clickOnTxtSearchCourse method");
	}

	public boolean getEnteredDataInSearchField(String Search) {
		logger.info("Starting of getEnteredDataInSearchField method");
		logger.info("Ending of getEnteredDataInSearchField method");

		String value = getSearchCourse.getAttribute("value");
		if (value.equals(Search)) {
			return true;
		}

		return false;
	}

	public void clickOnGetCourseFolder() {
		logger.info("Starting of clickOnGetCourseFolder method");

		try {
			Thread.sleep(2000);
			this.getCourse.click();
		} catch (Exception e) {

			this.clickOnWebElement(getCourse);
		}

		logger.info("Ending of clickOnGetCourseFolder method");
	}

	public String getB2bFacultyLabel() {
		logger.info("Starting of getB2bFacultyLabel method");

		this.explicitWait(getCreatedCourse);
		logger.info("Ending of getB2bFacultyLabel method");

		return getCreatedCourse.getText();
	}

	public void clickOnContentButton() {
		logger.info("Starting of clickOnContentButton method");

		// this.explicitWait(btnContent);
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
		this.hardWait(2);
		this.txtFolderName.clear();
		this.hardWait(5);
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

	public void clickOnMenuFolderVerticalIcon() {
		logger.info("starting of clickOnMenuVerticalIcon2  method");

		try {
			this.explicitWait(mnuVerticalFolder);
			this.clickOnWebElement(mnuVerticalFolder);
			this.scrollIntoView(mnuVerticalFolder);
		} catch (Exception e) {
			this.clickOnWebElement(mnuVerticalFolder);
		}
		logger.info("Ending of clickOnMenuVerticalIcon2 method");
	}

	public void clickOnFolderMenuEditButton() {
		logger.info("Starting of  clickOnMenuEditButton method");

		this.explicitWait(mnuFolderBtnEdit);
		this.clickOnWebElement(mnuFolderBtnEdit);

		logger.info("Ending of clickOnMenuEditButton method");
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
			Actions action = new Actions(driver);
			action.click(mnuAddVideoIcon).perform();
		} catch (Exception e) {
			this.clickOnWebElement(mnuAddVideoIcon);
		}

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
//			Thread.sleep(3000);
//			this.closeOSWindow();
//			Thread.sleep(4000);
//
//			this.btnVideoUpload.sendKeys(filepath);
			this.clickOnWebElement(btnUploadVideo);
			String osPath = System.getProperty("os.name");
			System.out.println(osPath);
			if (osPath.contains("Mac OS X")) {
				Thread.sleep(3000);
				File file = new File(filepath);
				StringSelection stringSelection= new StringSelection(file.getAbsolutePath());
				Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
				
				Robot robot = new Robot();
				
//				robot.keyPress(KeyEvent.VK_META);
//
//				robot.keyPress(KeyEvent.VK_TAB);
//
//				robot.keyRelease(KeyEvent.VK_META);
//
//				robot.keyRelease(KeyEvent.VK_TAB);
//
//				robot.delay(500);

				robot.keyPress(KeyEvent.VK_META);

				robot.keyPress(KeyEvent.VK_SHIFT);

				robot.keyPress(KeyEvent.VK_G);

				robot.keyRelease(KeyEvent.VK_META);

				robot.keyRelease(KeyEvent.VK_SHIFT);

				robot.keyRelease(KeyEvent.VK_G);

				robot.keyPress(KeyEvent.VK_META);

				robot.keyPress(KeyEvent.VK_V);

				robot.keyRelease(KeyEvent.VK_META);

				robot.keyRelease(KeyEvent.VK_V);

						//Press Enter key to close the Goto window and Upload window

				robot.keyPress(KeyEvent.VK_ENTER);

				robot.keyRelease(KeyEvent.VK_ENTER);

				robot.delay(500);

				robot.keyPress(KeyEvent.VK_ENTER);

				robot.keyRelease(KeyEvent.VK_ENTER);

						
				
			}
			
		} catch (Exception e) {
		}

		logger.info("Ending of uploadVideoButton method");
	}

	public String getVideoUploadedMessageText() {
		logger.info("Starting of getVideoUploadedMessage method");

		// this.explicitWait(msgUploadVideoText);

		logger.info(" Ending of getVideoUploadedMessage method");
		return this.msgUploadVideoText.getText();
	}

	public void clickOnDoneButton() {
		logger.info("Starting of clickOnDoneButton method");

		this.explicitWait(btnDone);
		this.clickOnWebElement(btnDone);

		logger.info("Ending of clickOnDoneButton method");
	}

	public void clickOnNoThanks() {
		logger.info("Starting of clickOnNoThanks method");

		this.explicitWait(btnOnNoThanks);
		this.scrollIntoView(btnOnNoThanks);
		this.clickOnWebElement(btnOnNoThanks);

		logger.info("Ending of clickOnNoThanks method");
	}

	public void clickOnYesEnablePreview() {
		logger.info("Starting of clickOnNoThanks method");

		this.explicitWait(btnYesEnablePreview);
		this.scrollIntoView(btnYesEnablePreview);
		this.clickOnWebElement(btnYesEnablePreview);

		logger.info("Ending of clickOnNoThanks method");
	}

	public void clickOnRemoveVideo() {
		logger.info("Starting of clickOnRemoveVideo method");

		try {
			this.explicitWait(mnuVerticalVideo);
			this.scrollIntoView(mnuVerticalVideo);
			this.mnuVerticalVideo.click();
		} catch (Exception e) {
			this.clickOnWebElement(mnuVerticalVideo);
		}

		logger.info("Ending of clickOnRemoveVideo method");
	}

	public void clickOnRemoveVideoButton() {
		logger.info("Starting of clickOnRemoveVideoButton method");

		this.explicitWait(btnRemoveVideo);
		this.clickOnWebElement(btnRemoveVideo);

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
		Actions action = new Actions(driver);
		action.click(mnuSubjectiveTestIcon).build().perform();
		// this.clickOnWebElement(mnuSubjectiveTestIcon);

		logger.info("Ending of clickOnMenuSubjectiveTestIcon method");
	}

	public String getSubjectiveTestLabel() {
		logger.info("Starting of getSubjectiveTestLabel method");
		logger.info("Ending of getSubjectiveTestLabel method");

		return this.lblSubjectiveTest.getText();
	}

	public boolean isDisplayedSubjectiveTestLabel() {
		logger.info("Starting of isDisplayedSubjectiveTestLabel method");
		logger.info("Ending of isDisplayedSubjectiveTestLabel method");

		return subjectiveTestIcon.isDisplayed();
	}

	public void clickOnCreateNewTestButton() {
		logger.info("Starting of clickOnCreateNewTestButton method");
		try {
			this.btnCreateNewSubjTest.click();
		} catch (Exception e) {
			this.clickOnWebElement(btnCreateNewSubjTest);
		}

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

	public void setTestName(String strTestName) {
		logger.info("Starting of setTestName method");

		this.txtSubjName.sendKeys(strTestName);
		this.txtSubjName.clear();
		this.txtSubjName.sendKeys(strTestName);

		logger.info("Ending of setTestName method");

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
			btnAddFiles.sendKeys(TEST_FILE_PATH + "/testdata/subjectiveTutorPdf.pdf");
		}

		logger.info("Ending of setUploadImageButton method");
	}

	public void clickOnMaxAddFilesButton() throws Exception {
		logger.info("starting of clickOnMaxAddFilesButton method");

		for (int i = 0; i < 5; i++) {
			String osPath = System.getProperty("os.name");
			if (osPath.contains("Linux")) {
				btnAddFiles.sendKeys(TEST_FILE_PATH + "/testdata/sampleSubjPdf.pdf");
			} else {
				btnAddFiles.sendKeys(TEST_FILE_PATH + "/testdata/sampleSubjPdf.pdf");
				Thread.sleep(2000);
			}
		}

		logger.info("Ending of clickOnMaxAddFilesButton method");
	}

	public void clickOnUploadInvalidPdf() throws InterruptedException {
		logger.info("starting of clickOnUploadPdf method");

		String osPath = System.getProperty("os.name");
		if (osPath.contains("Linux")) {
			btnAddFiles.sendKeys(TEST_FILE_PATH + "/testdata/invalidSubjTest.pdf");
		} else {
			btnAddFiles.sendKeys(TEST_FILE_PATH + "/testdata/invalidSubjTest.pdf");
			Thread.sleep(2000);

		}

		logger.info("Ending of clickOnUploadPdf method");
	}

	/*
	 * public void clickOnAddFilesButton(String filepath) {
	 * logger.info("Starting of clickOnAddFilesButton method");
	 * 
	 * this.clickOnWebElement(btnAddFiles); try { Thread.sleep(2000); } catch
	 * (InterruptedException e) { e.printStackTrace(); } this.uploadFile(filepath);
	 * this.closeOSWindow();
	 * 
	 * logger.info("Ending of clickOnAddFilesButton method"); }
	 */
	public String getSaveSubjSuccessMessage() {
		logger.info("Starting of getSaveSubjSuccessMessage method");

		logger.info("Ending of getSaveSubjSuccessMessage method");
		return msgFileUploadedSubjText.getText();
	}

	public void clickOnCreateAndAddTestButton() {
		logger.info("Starting of clickOnCreateAndAddTestButton method");

		this.clickOnWebElement(btnCreateAndAddSubjTest);

		logger.info("Ending of clickOnCreateAndAddTestButton method");
	}

	public boolean isDisplayedCreateAndAddTestButton() {
		logger.info("Starting of isDisplayedCreateAndAddTestButton method");
		logger.info("Ending of isDisplayedCreateAndAddTestButton method");

		return btnCreateAndAddSubjTest.isDisplayed();
	}

	public String getAddedfileSuccessMessageText() {
		logger.info("Starting of getAddedfileSuccessMessageText method");

		logger.info("Ending of getAddedfileSuccessMessageText method");
		return msgFileAddedSubj.getText();
	}

	public void clickOnUnlockSubjectiveTest() {
		logger.info("Starting of clickOnUnlockButton method");

		this.clickOnWebElement(btnUnlockSubjtiveTest);

		logger.info("Ending of clickOnUnlockButton method");

	}

	public String getUnlockText() {
		logger.info("Starting of getUnlockText method");
		logger.info("Ending of getUnlockText method");

		return lblUnlockMessage.getText();

	}

	public void clickOnMenuVerticalIcon3() {
		logger.info("Starting of clickOnMenuVerticalIcon3 method");

		try {

			this.mnuVerticalIcon3.click();
		} catch (Exception e) {
			this.clickOnWebElement(mnuVerticalIcon3);
		}

		logger.info("Ending of clickOnMenuVerticalIcon3 method");

	}

	public void clickOnSubjectiveTestMenuVerticalIcon() {
		logger.info("Starting of clickOnMenuVerticalIcon3 method");

		try {
			this.scrollIntoView(mnuSubjectiveVerticalIcon);
			this.mnuSubjectiveVerticalIcon.click();
		} catch (Exception e) {
			this.clickOnWebElement(mnuSubjectiveVerticalIcon);
		}
		logger.info("Ending of clickOnMenuVerticalIcon3 method");
	}

	public void clickOnLockSubjectiveButton() {
		logger.info("Starting of clickOnLockSubjectiveButton method");

		this.btnLockSubj.click();

		logger.info("Ending of clickOnLockSubjectiveButton method");

	}

	public void clickOnRemoveSubjectiveButton() {
		logger.info("Starting of clickOnRemoveSubjectiveButton method");

		this.clickOnWebElement(btnRemoveSubjectiveTest);

		logger.info("Ending of clickOnRemoveSubjectiveButton method");

	}

	public String getLabelRemoveConfirmationText() {
		logger.info("Starting of getlabelRemoveConfirmationText method");

		logger.info("Ending of getlabelRemoveConfirmationText method");
		return lblRemoveConfirmation.getText();
	}

	public void clickOnRemoveSubjConfirmButton() {
		logger.info("Starting of clickOnRemoveSubjConfirmButton method");

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

		// this.explicitWait(mnuDocumentIcon);
		this.hardWait(5);
		this.clickOnWebElement(mnuDocumentIcon);

		logger.info("Ending of clickOnMenuDocumentIcon method");
	}

	public String getlabelDocumentText() {
		logger.info("Starting of getlabelDocumentText method");

		logger.info("Ending of getlabelDocumentText method");
		return lblAddDocumentText.getText();
	}

	public void setTextDocument(String strDoc) {
		logger.info("Starting of setTextDocument method");

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
		this.hardWait(5);
		// this.explicitWait(btnSelectDoc);
		String osPath = System.getProperty("os.name");
		if (osPath.contains("Linux")) {
			btnSelectDoc.sendKeys(TEST_FILE_PATH + "/testdata/contentdocument.pdf");
		} else {

			btnSelectDoc
					.sendKeys(TEST_FILE_PATH + File.separator + "testdata" + File.separator + "contentdocument.pdf");

		}

		logger.info("Ending of clickOnSelectDocumentButton method");
	}

	public void clickOnUploadDocumentButton() {
		logger.info("Starting of clickOnUploadDocumentButton method");

		try {
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
			this.mnuImageIcon.click();
		} catch (Exception e) {
			this.clickOnWebElement(mnuImageIcon);
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
			btnSelectImage.sendKeys(TEST_FILE_PATH + File.separator + "testdata" + File.separator + "contentimage.png");
		}

		logger.info("Ending of setUploadImageButton method");
	}

	public void clickOnUploadImgButton() {
		logger.info("Starting of clickOnUploadImgButton method");
		try {

			this.btnUploadImage.click();
		} catch (Exception e) {
			this.clickOnWebElement(btnUploadImage);
		}

		logger.info("Ending of clickOnUploadImgButton method");
	}

	public String getSuccessImageMessageText() {
		logger.info("Starting of getSuccessImageMessageText method");
		logger.info("Ending of getSuccessImageMessageText method");
		try {

			Thread.sleep(2000);
		} catch (Exception e) {
		}
		return this.btnImageSuccess.getText();
	}

	public void clickOnMenuZipIcon() {
		logger.info("Starting of clickOnMenuZipIcon method");

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
			// btnChooseZipFile.sendKeys(TEST_FILE_PATH + "/testdata/samplezipfile.zip");

			btnChooseZipFile
					.sendKeys(TEST_FILE_PATH + File.separator + "testdata" + File.separator + "samplezipfile.zip");
		}
		logger.info("Ending of clickOnChooseFileButton method");
	}

	public void clickOnUploadZipButton() {

		logger.info("Starting of clickOnUploadZipButton method");

		this.btnUploadZipFile.click();

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

		this.explicitWait(msgPublishSucces);

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

		logger.info("Ending of deleteMessageText method");
		return this.msgDelete.getText();
	}

	public void clickOnViewStatsButton() {
		logger.info("starting of clickOnViewStatsButton method");

		try {
			this.btnViewStats.click();
		} catch (Exception e) {
			this.clickOnWebElement(btnViewStats);
		}

		logger.info("Ending of clickOnViewStatsButton method");
	}

	public boolean isDisplayedViewStatsButton() {
		logger.info("starting of isDisplayedViewStatsButton method");
		logger.info("Ending of isDisplayedViewStatsButton method");

		return btnViewStats.isDisplayed();
	}

	public boolean isDisplayedPreviewButton() {
		logger.info("starting of isDisplayedPreviewButton method");
		logger.info("Ending of isDisplayedPreviewButton method");

		return btnPreview.isDisplayed();
	}

	public String getTestStatsHeader() {
		logger.info("Starting of getTestStatsHeader method");
		logger.info("Ending of getTestStatsHeader method");

		return msgTestStats.getText();
	}

	public String getNoStatsLabel() {
		logger.info("Starting of getNoStatsLabel method");
		logger.info("Ending of getNoStatsLabel method");

		return noStatsLabel.getText();
	}

	public String getNoStudentLabel() {
		logger.info("Starting of getNoStudentLabel method");
		logger.info("Ending of getNoStudentLabel method");

		return noStudentAttemptedLabel.getText();
	}

	public void clickOnPreviewButton() {
		logger.info("starting of clickOnPreviewButton method");

		try {
			this.btnPreview.click();
		} catch (Exception e) {
			this.clickOnWebElement(btnPreview);
		}
		logger.info("Ending of clickOnPreviewButton method");
	}

	public void clickOnDownloadButton() {
		logger.info("starting of clickOnDownloadButton method");

		this.switchToNewWindow();

		Actions action = new Actions(driver);
		action.click(btnDownload).perform();

		logger.info("Ending of clickOnDownloadButton method");
	}

	public void clickOnNewCreateButton() {
		logger.info("starting of clickOnNewCreateButton method");

		Actions action = new Actions(driver);
		action.click(btnCreateNewTest).perform();

		logger.info("Ending of clickOnNewCreateButton method");
	}

	public void clickOnCloseButton() {
		logger.info("starting of clickOnCloseButton method");

		try {
			this.btnClose.click();
		} catch (Exception e) {
			this.clickOnWebElement(btnClose);
		}

		logger.info("Ending of clickOnCloseButton method");
	}

	public String getAddContentHeader() {
		logger.info("Starting of getAddContentHeader method");
		logger.info("Ending of getAddContentHeader method");

		return lblAddContentHeader.getText();
	}

	public boolean getSubjectiveTestHeader() {
		logger.info("Starting of getSubjectiveTestHeader method");
		logger.info("Ending of getSubjectiveTestHeader method");

		return lblSubjectiveTestHeader.isDisplayed();
	}

	public void setSearchSubjectiveTest(String strSearchSubjectiveTest) {
		logger.info("Starting of setFolderName method");

		this.explicitWait(txtSearchSubjectiveTest);
		// this.txtSearchSubjectiveTest.clear();
		this.txtSearchSubjectiveTest.clear();
		this.txtSearchSubjectiveTest.sendKeys(strSearchSubjectiveTest);

		logger.info("Ending of setFolderName method");
	}

	public void clickOnPreviewSubjectiveTest() {
		logger.info("Starting of clickOnPreviewSubjectiveTest method");

		this.explicitWait(txtPreviewSubjectiveTest);
		this.txtPreviewSubjectiveTest.click();
		this.switchToNewWindow();

		driver.close();
		logger.info("Ending of clickOnPreviewSubjectiveTests method");
	}

	public void clickOnAddCourseButton() {
		logger.info("Starting of removeCourseButton method");

		this.clickOnWebElement(addSubjectiveTest);

		logger.info("Ending of removeCourseButton method");
	}

	public void unlockContent() {
		logger.info("Starting of unlockContent method");

		try {
			this.explicitWait(btnUnlockContent);
			this.btnUnlockContent.click();
		} catch (Exception e) {
			this.clickOnWebElement(btnUnlockSubjtiveTest);
		}

		logger.info("Ending of unlockContent method");
	}

	public String getSuccessDocumentMessageText() {
		logger.info("Starting of getSuccessDocumentMessageText method");

		this.explicitWait(this.msgDocumentUploaded);

		logger.info("Ending of getSuccessDocumentMessageText method");
		return this.msgDocumentUploaded.getText();
	}

	public String getAddSubjectiveTestMessage() {
		logger.info("Starting of getAddSubjectiveTestMessage method");
		logger.info("Ending of getAddSubjectiveTestMessage method");

		this.explicitWait(msgAddSubjectiveTest);
		return msgAddSubjectiveTest.getText();
	}

	public void getTimeout() {
		while (true) {
			String upload = this.uploadPercent.getText().replace("%", "");
			int percent = Integer.parseInt(upload);
			// System.out.println(percent);
			if (percent > 90)
				break;
		}
	}

	public String getDownloadPaperMessage() {
		logger.info("Starting of getDownloadPaperMessage method");
		logger.info("Ending of getDownloadPaperMessage method");
		this.switchToNewWindow();

		return msgDownloadQuestionPaper.getText();

	}

	public boolean getCreateLabel() {
		logger.info("Starting of getCreateLabel method");
		logger.info("Ending of getCreateLabel method");

		return lblCreateButton.isDisplayed();

	}

	public boolean getSearchLabel() {
		logger.info("Starting of getSearchLabel method");
		logger.info("Ending of getSearchLabel method");

		return lblSearchIcon.isDisplayed();

	}

	public String getNoTestFoundLabel() {
		logger.info("Starting of getNoTestFoundLabel method");
		logger.info("Ending of getNoTestFoundLabel method");

		return lblNoTestFound.getText();

	}

	public boolean getPdfIcon() {
		logger.info("Starting of getPdfIcon method");
		this.explicitWait(pdfIcon);
		logger.info("Ending of getPdfIcon method");

		return pdfIcon.isDisplayed();

	}

	public int getQuestionPapersCount() {
		logger.info("Starting of getQuestionPapersCount method");

		WebElement countPaper = countQuestionPaper;
		String paperCount = countPaper.getText().substring(19, 20);
		System.out.println("********COUNT**********" + paperCount);
		int count = Integer.parseInt(paperCount);

		logger.info("Ending of getQuestionPapersCount method");

		return count;
	}

	public String getMessageErrorFile() {
		logger.info("Starting of getMessageErrorFile method");
		logger.info("Ending of getMessageErrorFile method");

		return msgErrorFile.getText();

	}

	public void clickOnCancelButton() {
		logger.info("starting of clickOnCancelButton method");

		try {
			this.btnCancel.click();
		} catch (Exception e) {
			this.clickOnWebElement(btnCancel);
		}
		logger.info("Ending of clickOnCancelButton method");
	}

	public boolean isdisplayedCancel() {
		logger.info("starting of isdisplayedCancel method");
		logger.info("Ending of isdisplayedCancel method");

		return btnCancel.isDisplayed();
	}

	public String getTryAndUploadPdfMessage() {
		logger.info("Starting of getTryAndUploadPdfMessage method");
		logger.info("Ending of getTryAndUploadPdfMessage method");

		this.explicitWait(msgTryAgainError);
		return msgTryAgainError.getText();

	}

	public void clickOnAddZipFileButton() {
		logger.info("starting of clickOnAddZipFileButton method");

		String osPath = System.getProperty("os.name");
		if (osPath.contains("Linux")) {
			btnAddFiles.sendKeys(TEST_FILE_PATH + "/testdata/samplezipfile.zip");
		} else {
			btnAddFiles.sendKeys(TEST_FILE_PATH + "/testdata/samplezipfile.zip");
		}

		logger.info("Ending of clickOnAddZipFileButton method");
	}

	public boolean verifyPrice() {
		String s[] = btnCreateAndAddSubjTest.getText().split(" ");
		String belowPrice = s[1];
		int actualBelowPrice = Integer.parseInt(belowPrice);

		String ss[] = btnCreateAndAddSubjTest.getText().split(" ");
		String abovePrice = s[1];
		int actualAbovePrice = Integer.parseInt(abovePrice);
		for (WebElement e : btnLockAndUnlockContent) {
			String coursePrice = e.getText().substring(1);
			int actualCoursePrice = Integer.parseInt(coursePrice);

			if (!(actualCoursePrice <= actualAbovePrice || actualCoursePrice >= actualBelowPrice)) {
				return false;
			}
		}
		return true;

	}
}