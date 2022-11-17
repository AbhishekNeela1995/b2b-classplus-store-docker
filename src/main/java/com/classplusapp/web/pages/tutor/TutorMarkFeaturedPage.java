package com.classplusapp.web.pages.tutor;

import java.io.File;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import com.classplusapp.web.pages.BaseClassplusAutomationPage;

public class TutorMarkFeaturedPage extends BaseClassplusAutomationPage {

	@FindBy(xpath = "//span[contains(text(),'Mark featured Courses')]")
	private WebElement getCourseFolder;

	// assertion
	@FindBy(xpath = "//div[contains(text(),'Mark featured Course')]")
	private WebElement lblMarkfeaturedCourse;

	@FindBy(xpath = "//span[contains(text(),'Content')]//parent::div")
	private WebElement btnContent;

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


	@FindBy(xpath = "//input[@type='file']")
	private WebElement btnChooseZipFile;

	@FindBy(xpath = "//button[contains(text(),'Upload Zip')]")
	private WebElement btnUploadZipFile;

	@FindBy(xpath = "//div[contains(text(),'Content added successfully')]")
	private WebElement msgFileUploadedZip;

	@FindBy(xpath = "//div[@class=\"flexrow alignCenter\"]/parent::button/child::div")
	private WebElement btnPublishCourse;

	// Assertion
	@FindBy(xpath = "(//span[contains(text(),'Publish Course')])[2]")
	private WebElement lblPublishCourse;

	@FindBy(xpath = "//button[contains(text(),'Publish Course')]")
	private WebElement btnPublishCourses;

	// Assertion-6
	@FindBy(xpath = "//div[contains(text(),'Course Published Successfully')]")
	private WebElement lblCoursePublishedSuccessfully;

	@FindBy(xpath = "//div[@class='ShareModal__Content__Top--Close']")
	private WebElement btnPublishPopupClose;

	@FindBy(xpath = "//div[contains(text(),'Course Published')]")
	private WebElement msgPublishSuccess;

	@FindBy(xpath = "//i[@class=\"ellipsis vertical icon\"]")
	private WebElement btnVerticalDots;

	@FindBy(xpath = "//span[contains(text(),'Mark')]")
	private WebElement btnMarkAsFeatured;

	// Assertion-8
	@FindBy(xpath = "//div[contains(text(),'Course marked as featured')]")
	private WebElement lblCourseMarkedfeatured;

	@FindBy(xpath = "//div[@class='MarkedFeatured__Content__Actions--Edit']")
	private WebElement btnEditFeaturedList;
	// assertion
	@FindBy(xpath = "//div[contains(text(),'Featured Courses List')]")
	private WebElement lblFeaturedCoursesList;

	@FindBy(xpath = "(//span[contains(text(),'Feature')])[1]")
	private WebElement btnRemoveCourse;

	@FindBy(xpath = "//div[contains(text(),'Removed course from the list. Click on Save button to confirm changes')]")
	private WebElement msgCourseRemoved;

	/*
	 * @FindBy(xpath =
	 * "//div[contains(text(),'Mark featured Course')]/parent::div//parent::div/parent::div/following-sibling::div[@class=\"ReorderCard__Course__Action\"]/child::span[contains(text(),'Feature')]"
	 * ) private WebElement btnFeature;
	 */

	@FindBy(xpath = "//div[contains(text(),'Added course back to the list. Click on Save button to confirm changes')]")
	private WebElement msgCourseAddedBackToList;

	@FindBys({ @FindBy(xpath = "//div[@aria-roledescription='Draggable item. Press space bar to lift']") })
	private List<WebElement> draggableImages;

	@FindBy(xpath = "//div[contains(text(),'Course list reordered. Click on Save button to confirm changes.')]")
	private WebElement msgCourseRecorded;

	@FindBy(xpath = "//div[contains(text(),\"Save\")]")
	private WebElement btnSaveReorderdImage;

	/*
	 * @FindBy(xpath = "//div[contains(text(),'Save')]") private WebElement
	 * saveButton;
	 */

	@FindBy(xpath = "//div[contains(text(),'List successfully updated. Changes may take some time to reflect')]")
	private WebElement msgListUpdatedSucessfully;

	@FindBy(xpath = "//span[contains(text(),'Recommend Course')]")
	private WebElement btnRecommendCourse;

	// Assertion
	@FindBy(xpath = "//div[contains(text(),\"Recommend Course \")]")
	private WebElement lblRecommendCourse;

	@FindBy(xpath = "//div[@class='user-search-icon']//following-sibling::div[contains(text(),'Filter')]")
	private WebElement btnFilter;

	@FindBy(xpath = "(//div[contains(text(),'App Downloads')])[1]")
	private WebElement lblAppDownloads;

	@FindBy(xpath = "//div[contains(text(),'All App Downloads')]")
	private WebElement rdoAllAppDownloads;

	@FindBy(xpath = "//div[contains(text(),'Apply')]")
	private WebElement btnApply;

	@FindBy(xpath = "//div[@class='selectUser-head']/img")
	private WebElement btnBackSymbol;

	@FindBy(xpath = "//span[contains(text(),'Copy Course Link')]")
	private WebElement btnCopyCourseLink;

	@FindBy(xpath = "//div[contains(text(),'Link Copied')]")
	private WebElement msgLinkCopied;

	@FindBy(xpath = "(//div[@class=\"menu transition visible\"]/child::div/following-sibling::div/span[@class=\"menutoggle--items--content--span\"])[1]")
	private WebElement btnUmarkFeatured;

	@FindBy(xpath = "//div[contains(text(),'Course removed from featured courses list')]")
	private WebElement msgUnmarkedSucceess;

	@FindBy(xpath = "//span[contains(text(),'Unpublish Course')]")
	private WebElement btnUnpublishCourse;

	// Assertion-7
	@FindBy(xpath = "//div[contains(text(),'Unpublish Confirmation')]")
	private WebElement lblUnpublishConfirmation;

	@FindBy(xpath = "//button[contains(text(),'Unpublish')]")
	private WebElement btnUnpublish;

	@FindBy(xpath = "//div[contains(text(),'Status updated successfully.')]")
	private WebElement msgUnpublishSuccess;

	@FindBy(xpath = "//p[contains(text(),\"Mark featured Course\")]")
	private WebElement lblMarkFeaturedCourse;

	@FindBy(xpath = "//i[@class='ellipsis vertical icon']")
	private WebElement mnuThreeDottedDocument;

	@FindBy(xpath = "//span[contains(text(),'Remove')]")
	private WebElement btnRemoveDocument;

	@FindBy(xpath = "//div[contains(text(),'Content deleted successfully')]")
	private WebElement msgDocumentDeleted;

	@FindBy(xpath = "//i[@class='ellipsis vertical icon']")
	private WebElement btnThreeDottedZipFile;

	@FindBy(xpath = "//span[contains(text(),'Remove')]")
	private WebElement btnRemoveZipFile;

	@FindBy(xpath = "//div[contains(text(),'Content deleted successfully')]")
	private WebElement msgZipFileDeleted;

	@FindBy(xpath = "//i[@class=\"ellipsis vertical icon\"]")
	private WebElement mnuThreedottedImage;

	@FindBy(xpath = "//span[contains(text(),'Remove')]")
	private WebElement btnRemoveImage;

	@FindBy(xpath = "//div[contains(text(),'Content deleted successfully')]")
	private WebElement msgImageDeletedSuccessfully;

	private static final Logger logger = Logger.getLogger(TutorMarkFeaturedPage.class.getName());

	public TutorMarkFeaturedPage(WebDriver driver) {
		super(driver);
		logger.info("Starting of MarkFeaturedPage method");
		
		PageFactory.initElements(driver, this);
		
		logger.info("Ending of MarkFeaturedPage method");

	}

	public void clickOnCourseFolder() {
		logger.info("Starting of clickOnCourseFolder method");

		try {
			this.getCourseFolder.click();
		} catch (Exception e) {
			this.clickOnWebElement(getCourseFolder);
		}

		logger.info("Ending of clickOnCourseFolder method");
	}

	// Assertion--1
	public String getMarkfeaturedCourseLabel() {
		logger.info("Starting of getMarkfeaturedCourseLabel method");

		logger.info("Ending of getMarkfeaturedCourseLabel method");

		return lblMarkfeaturedCourse.getText();

	}

	public void clickOnContentButton() {
		logger.info("Starting of clickOnContentButton method");

		this.clickOnWebElement(btnContent);

		logger.info("Ending of clickOnContentButton method");
	}

	public void clickOnMenuDocumentIcon() {
		logger.info("Starting of clickOnMenuDocumentIcon method");

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

		String osPath = System.getProperty("os.name");
		if (osPath.contains("Linux")) {
			btnSelectDoc.sendKeys(TEST_FILE_PATH + "/testdata/annoncePdf.pdf");
		} else {
			btnSelectDoc.sendKeys(TEST_FILE_PATH +File.separator+ "testdata"+File.separator+"annoncePdf.pdf");
		}

		logger.info("Ending of clickOnSelectDocumentButton method");
	}

	public void clickOnUploadDocumentButton() {
		logger.info("Starting of clickOnUploadDocumentButton method");
		
		this.btnUploadDoc.click();

		logger.info("Ending of clickOnUploadDocumentButton method");
	}

	public String documentUploadedMessageText() {
		logger.info("Starting of documentUploadedMessageText method");
		logger.info(" Ending of documentUploadedMessageTexts method");
		try {
			Thread.sleep(2000);

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return this.msgDocumentUploaded.getText();

	}

	public void clickOnMenuImageIcon() {
		logger.info("Starting of clickOnMenuImageIcon method");

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
			btnSelectImage.sendKeys(TEST_FILE_PATH + "/testdata/annonceimage.jpg");
		} else {
			btnSelectImage.sendKeys(TEST_FILE_PATH + "/testdata/annonceimage.jpg");
		}

		logger.info("Ending of setUploadImageButton method");
	}

	public void clickOnUploadImgButton() {
		logger.info("Starting of clickOnUploadImgButton method");

		waitForElementVisibilty(btnUploadImage);
		this.btnUploadImage.click();

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
			btnChooseZipFile.sendKeys(TEST_FILE_PATH + File.separator+"testdata"+File.separator+"samplezipfile.zip");
		}
		logger.info("Ending of clickOnChooseFileButton method");
	}

	public void clickOnUploadZipButton() {

		logger.info("Starting of clickOnUploadZipButton method");
		try {
			Thread.sleep(2000);
			this.btnUploadZipFile.click();
		} catch (Exception e) {
			this.clickOnWebElement(btnUploadZipFile);
		}

		logger.info("Ending of clickOnUploadZipButton method");
	}

	public String getSaveSuccessZipMessageText() {
		logger.info("Starting of getSaveSuccessZipMessageText method");
		logger.info("Ending of getSaveSuccessZipMessageText method");
		return msgFileUploadedZip.getText();
	}

	public void clickOnPublishCourseButton() {
		logger.info("Starting of clickOnPublishCourseButton method");

		if(btnPublishCourse.isDisplayed()) {
		this.clickOnWebElement(btnPublishCourse);
		}
		logger.info("Ending of clickOnPublishCourseButton method");
	}

	// Assertion-5
	public String getPublishCourseLable() {
		logger.info("Starting of getAddZipLable method");
		logger.info("Ending of getAddZipLable method");
		return lblPublishCourse.getText();
	}

	public void clickOnPublishCourseButton1() {
		logger.info("Starting of clickOnPublishCourseButton1 method");

		this.clickOnWebElement(btnPublishCourses);

		logger.info("Ending clickOnPublishCourseButton1 method");
	}

	// Assertion-6
	public String getCoursePublishedSuccessfullyLabel() {
		logger.info("Starting of getCoursePublishedSuccessfullyLabel method");
		logger.info("Ending of getCoursePublishedSuccessfullyLabel method");
		return this.lblCoursePublishedSuccessfully.getText();
	}

	public void clickOnCrossButton() {
		logger.info("Starting of clickOnCrossButton method");

		this.clickOnWebElement(btnPublishPopupClose);

		logger.info("Ending of clickOnCrossButton method");
	}

	public String getPublishSuccessMessage() {
		logger.info("Starting of getPublishSuccessMessage method");
		logger.info("Ending of getPublishSuccessMessage method");
		return this.msgPublishSuccess.getText();
	}

	public void clickOnVerticalMenuButton() {
		logger.info("Starting of clickOnVerticalMenuButton method");

		this.clickOnWebElement(btnVerticalDots);

		logger.info("Ending of clickOnVerticalMenuButton method");
	}

	public void clickOnMarkAsFeaturedButton() {
		logger.info("Starting of clickOnMarkAsFeaturedButton method");

		this.explicitWait(btnMarkAsFeatured);
		this.clickOnWebElement(btnMarkAsFeatured);

		logger.info("Ending of clickOnMarkAsFeaturedButton method");
	}

	public String getCourseMarkedAsFeaturedLabel() {
		logger.info("Starting of getCourseMarkedAsFeaturedLabel method");
		logger.info("Ending of getCourseMarkedAsFeaturedLabel method");
		return this.lblCourseMarkedfeatured.getText();
	}

	public void clickOnEditMarkAsFeatured() {
		logger.info("Starting of clickOnEditMarkAsFeatured method");

		this.explicitWait(btnEditFeaturedList);
		this.clickOnWebElement(btnEditFeaturedList);

		logger.info("Ending of clickOnEditMarkAsFeatured method");
	}

	public String getFeaturedCoursesListLabel() {
		logger.info("Starting of getFeaturedCoursesListLable method");
		logger.info("Ending of getFeaturedCoursesListLable method");
		return this.lblFeaturedCoursesList.getText();
	}

	public void clickOnRemoveButton() {
		logger.info("Starting of clickOnRemoveButton method");

		this.waitForElementVisibilty(btnRemoveCourse);
		this.clickOnWebElement(btnRemoveCourse);

		logger.info("Ending of clickOnRemoveButton method");
	}

	public String getCourseRemovedMessage() {
		logger.info("Starting of getCourseRemovedMessage method");
		logger.info("Ending of getCourseRemovedMessage method");
		return msgCourseRemoved.getText();
	}

	/*
	 * public void clickOnFeatureButton() {
	 * logger.info("Starting of clickOnFeature method");
	 * 
	 * this.clickOnWebElement(btnFeature);
	 * 
	 * logger.info("Ending of clickOnFeature method"); }
	 */
	public String getCourseAddedBackToListMessage() {
		logger.info("Starting of getCourseAddedBackToListMessage method");
		logger.info("Ending of getCourseAddedBackToListMessage method");
		this.explicitWait(msgCourseAddedBackToList);

		return msgCourseAddedBackToList.getText();
	}

	public void reorderImages(String secondIndex, String firstIndex) {
		logger.info("Starting of draggableElements method");

		this.explicitWait(draggableImages);
		this.dragAndSort(draggableImages, Integer.parseInt(secondIndex), Integer.parseInt(firstIndex));

		logger.info("Ending of draggableElements method");
	}

	public String reorderListMessage() {
		logger.info("Starting of reorderListMessage method");
		logger.info("Ending of reorderListMessage method");
		return this.msgCourseRecorded.getText();
	}

	public void clickOnSaveButton() {
		logger.info("Starting of clickOnsaveButton method");

		this.btnSaveReorderdImage.click();

		logger.info("Ending of clickOnsavebutton method");
	}

	public String reorderSavedMessage() {
		logger.info("Starting of reorderSavedMessage method");
		logger.info("Ending of reorderSavedMessage method");
		return msgListUpdatedSucessfully.getText();
	}

	public void clickOnRecommendCourse() {
		logger.info("Starting of clickOnRecommendCourse method");

		this.clickOnWebElement(btnRecommendCourse);

		logger.info("Ending of clickOnRecommendCourse method");
	}

	public String getRecommendCourseLable() {
		logger.info("Starting of getRecommendCourseLable method");
		logger.info("Ending of getRecommendCourseLable method");
		return this.lblRecommendCourse.getText();
	}

	public void clickOnFilterButton() {
		logger.info("Starting of clickOnFilterButton method");
		
		try {
			Thread.sleep(3000);
			this.btnFilter.click();
		} catch (Exception e) {
			this.clickOnWebElement(btnFilter);

		}
		//this.explicitWait(btnFilter);
		

		logger.info("Ending of clickOnFilterButton method");
	}

	public void clickOnallAppDownloads() {
		logger.info("Starting of clickOnAppDownloads method");
		
		waitForElementVisibilty(rdoAllAppDownloads);
		this.rdoAllAppDownloads.click();

		logger.info("Ending of clickOnAppDownloads method");
	}

	public String getAppDownloadsLable() {
		logger.info("Starting of getAppDownloadsLable method");
		logger.info("Ending of getAppDownloadsLable method");
		return this.lblAppDownloads.getText();
	}

	public void clickOnApplyButton() {
		logger.info("Starting of clickOnApplyButton method");
		
		try {
			this.btnApply.click();
		} catch (Exception e) {
			this.clickOnWebElement(btnApply);
		}

		logger.info("Ending of clickOnApplyButton method");
	}

	public void clickOnBackSymbolButton() {
		logger.info("Starting of clickOnBackSymbolButton method");

		this.btnBackSymbol.click();

		logger.info("Ending of clickOnBackSymbolButton method");
	}

	public void clickOnCopyCourseLink() {
		logger.info("Starting of clickOnCopyCourseLink method");

		this.clickOnWebElement(btnCopyCourseLink);

		logger.info("Ending of clickOnCopyCourseLink method");
	}

	public String getLinkCopiedMessage() {
		logger.info("Starting of getLinkCopiedMessage method");
		logger.info("Ending of getLinkCopiedMessage method");
		return msgLinkCopied.getText();
	}

	public void clickOnUnMarkfeatureButton() {
		logger.info("Starting of clickOnUnMarkfeatureButton method");

		waitForElementVisibilty(btnUmarkFeatured);
		this.clickOnWebElement(btnUmarkFeatured);

		logger.info("Ending of clickOnUnMarkfeatureButton method");
	}

	public String getUnmarkSuccessMessage() {
		logger.info("Starting of getUnmarkSuccessMessage method");
		
		this.explicitWait(msgUnmarkedSucceess);
		
		logger.info("Ending of getUnmarkSuccessMessage method");
		return msgUnmarkedSucceess.getText();
	}

	public void clickOnUnpublishCourseButton() {
		logger.info("Starting of clickOnUnpublishCourseButton method");
  if(btnUnpublishCourse.isDisplayed()) {
		this.clickOnWebElement(btnUnpublishCourse);
  }
		logger.info("Ending of clickOnUnpublishCourseButton method");
	}

	// Assertion-7
	public String getUnpublishConfirmationLabel() {
		logger.info("Starting of getUnpublishConfirmationLable method");
		logger.info("Ending of getUnpublishConfirmationLable method");
		return this.lblUnpublishConfirmation.getText();
	}

	public void clickOnUnpublishButton() {
		logger.info("Starting of clickOnUnpublishButton  method");

		this.btnUnpublish.click();

		logger.info("Ending of clickOnUnpublishButton  method");
	}

	public String getUnPublishSuccessMessage() {
		logger.info("Starting of getUnPublishSuccessMessage method");
		logger.info("Ending of getUnPublishSuccessMessage method");
		try {Thread.sleep(2000);}catch(Exception e) {}
		return msgUnpublishSuccess.getText();
	}

	public String getMarkFeaturedCourseLabel() {
		logger.info("Starting of getUnPublishSuccess method");
		logger.info("Ending of getUnPublishSuccess method");
		return lblMarkFeaturedCourse.getText();
	}

	public void clickOnThreeDottedMenuForDocument() {
		logger.info("starting of clickOnThreeDottedMenuForDocument  method");

		this.mnuThreeDottedDocument.click();

		logger.info("Ending of clickOnThreeDottedMenuForDocument method");
	}

	public void clickOnRemoveButtonForDocument() {
		logger.info("starting of clickOnRemoveButtonForDocument  method");

		this.btnRemoveDocument.click();

		logger.info("Ending of clickOnRemoveButtonForDocument method");
	}

	public String getContentDeletedSuccesMessageForDocument() {
		logger.info("Starting of getContentDeletedSuccesMessageForDocument method");
		
		this.explicitWait(msgDocumentDeleted);
		
		logger.info("Ending of getContentDeletedSuccesMessageForDocument method");
		return this.msgDocumentDeleted.getText();
	}

	public void clickOnThreeDottedMenuForZipFile() {
		logger.info("starting of clickOnThreeDottedMenuForZipFile  method");

		this.clickOnWebElement(btnThreeDottedZipFile);

		logger.info("Ending of clickOnThreeDottedMenuForZipFile method");
	}

	public void clickOnRemoveButtonForZipFile() {
		logger.info("starting of clickOnRemoveButtonForZipFile  method");

		this.clickOnWebElement(btnRemoveZipFile);

		logger.info("Ending of clickOnRemoveButtonForZipFile method");
	}

	public String getDeleteSuccessMessageForZipFile() {
		logger.info("Starting of getDeleteSuccessMessageForZipFile method");

		this.explicitWait(msgZipFileDeleted);

		logger.info("Ending of getDeleteSuccessMessageForZipFile method");
		return msgZipFileDeleted.getText();
	}

	public void clickOnThreeDottedMenuForImage() {
		logger.info("starting of clickOnThreeDottedMenuForImage  method");

		this.clickOnWebElement(mnuThreedottedImage);

		logger.info("Ending of clickOnThreeDottedMenuForImage method");
	}

	public void clickOnRemoveButtonForImage() {
		logger.info("starting of clickOnRemoveButtonForImage  method");

		this.clickOnWebElement(btnRemoveImage);

		logger.info("Ending of clickOnRemoveButtonForImage method");
	}

	public String getDeleteSuccessMessageForImage() {
		logger.info("Starting of getDeleteSuccessMessageForImage method");
		logger.info("Ending of getDeleteSuccessMessageForImage method");
		
		return msgImageDeletedSuccessfully.getText();
	}
}