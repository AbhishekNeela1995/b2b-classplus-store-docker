package com.classplusapp.web.pages.parent;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.classplusapp.web.pages.BaseClassplusAutomationPage;

public class ParentViewContentPage extends BaseClassplusAutomationPage {

	@FindBy(xpath = "//p[text()='Store']")
	private WebElement btnStore;

	@FindBy(xpath = "//input[@placeholder=\"Search for a course\"]")
	private WebElement txtSearch;

	@FindBy(xpath = "//div[contains(text(),'FILTER BY TOPICS')]")
	private WebElement lblFilterByTopics;

	@FindBy(xpath = "//span[contains(text(),'Hello NestJS')]")
	private WebElement getCourse;

	@FindBy(xpath = "//span[contains(text(),' Overview ')]")
	private WebElement lblOverView;

	@FindBy(xpath = "//span[contains(text(),'Content')]//parent::div")
	private WebElement btnContent;

	@FindBy(xpath = "//p[contains(text(),'Files')]")
	private WebElement mnuFiles;

	@FindBy(xpath = "//div[contains(text(),'00:46:52')]")
	private WebElement sampleVideo;

	@FindBy(xpath = "//h3[contains(text(),'This content can not be viewed on the web')]")
	private WebElement lblContentCannotViewed;

	@FindBy(xpath = "//img[@class=\"addContent__SVGClose\"]")
	private WebElement imgCancel;

	@FindBy(xpath = "//img[@class='previousIcon']")
	private WebElement previousIcon;

	// write generic xpath for the element
	@FindBy(xpath = "//div[contains(text(),'00:00:57')]")
	private WebElement videoTest;

	@FindBy(xpath = "//img[@class=\"addContent__SVGClose\"]")
	private WebElement videoTestCancel;

	// write generic xpath for the element
	@FindBy(xpath = "//div[contains(text(),'00:01:03')]")
	private WebElement imgSample;

	@FindBy(xpath = "//div[contains(text(),'01:48:31')]")
	private WebElement documentSample;

	@FindBy(xpath = "//img[@class='previousIcon']")
	private WebElement folderBack;

	// write generic xpath for the element
	@FindBy(xpath = "//div[contains(text(),'00:01:03')]")
	private WebElement zipFileSample;

	@FindBy(xpath = "//p[contains(text(),'Download')]")
	private WebElement zipFileDownload;

	@FindBy(xpath = "//p[contains(text(),'Talk to Tutor ')]")
	private WebElement btnTalkToTutor;

	@FindBy(xpath = "//span[contains(text(),'Chats')]")
	private WebElement lblChats;

	@FindBy(xpath = "//textarea[@type='text']")
	private WebElement msgTutor;

	@FindBy(xpath = "//img[@class='input_right__2Z46_']")
	private WebElement msgSend;

	@FindBy(xpath = "//span[contains(text(),'Overview ')]")
	private WebElement btnOverView;

	@FindBy(xpath = "//img[@alt='Share']")
	private WebElement btnShare;

	@FindBy(xpath = "//div[contains(text(),'Copy')]")
	private WebElement btnCourseLink;

	@FindBy(xpath = "//div[contains(text(),'Link Copied')]")
	private WebElement msgLinkCopied;

	private static final Logger logger = Logger.getLogger(ParentViewContentPage.class.getName());

	public ParentViewContentPage(WebDriver driver) {
		super(driver);
		logger.info("Starting of ParentViewContentPage method");
		PageFactory.initElements(driver, this);
		logger.info("Ending of ParentViewContentPage method");
	}

	public void clickOnStorebutton() {
		logger.info("starting of clickOnStorebutton method");

		waitForElementVisibilty(btnStore);
		// this.explicitWait(storeButton);
		this.btnStore.click();

		logger.info("Ending of clickOnStorebutton method");
	}

	public void setSearchArea(String strSearch) {
		logger.info("Starting of setSearchArea method");

		// waitForElementVisibilty(search);
		this.txtSearch.sendKeys(strSearch);

		logger.info("Ending of setSearchArea method");
	}

	public String getFilterByTopicsLabel() {
		logger.info("Starting of getFilterByTopicsLabel method");

		logger.info(" Ending of getFilterByTopicsLabel method");
		return this.lblFilterByTopics.getText();
	}

	public void clickOnGetCourse() {
		logger.info("starting of clickOnGetCourse method");

		this.getCourse.click();

		logger.info("Ending clickOnGetCourse method");
	}

	public String getOverViewLabel() {
		logger.info("Starting of getOverViewLabel method");
		logger.info(" Ending of getOverViewLabel method");
		return this.lblOverView.getText();
	}

	public void clickOnContentButton() {
		logger.info("Starting of clickOnContentButton method");

		this.clickOnWebElement(btnContent);

		logger.info("Ending of clickOnContentButton method");
	}

	public void clickOnFilesMenu() {
		logger.info("Starting of clickOnFilesMenu method");

		this.explicitWait(mnuFiles);
		this.mnuFiles.click();

		logger.info("Ending of clickOnFilesMenu method");
	}

	public void clickOnImagesB2b() {
		logger.info("Starting of clickOnImagesB2b method");
		try {
			Thread.sleep(1000);
			this.sampleVideo.click();
		} catch (Exception e) {
			this.clickOnWebElement(sampleVideo);
		}

		logger.info("Ending of clickOnImagesB2b method");
	}

	public String getContentCannotViewedLabel() {
		logger.info("Starting of getContentCannontViewedLabel method");
		logger.info(" Ending of getContentCannontViewedLabel method");
		return this.lblContentCannotViewed.getText();
	}

	public void clickOnCancelImage() {
		logger.info("Starting of clickOnCancelImage method");

		waitForElementVisibilty(imgCancel);
		this.imgCancel.click();

		logger.info("Ending of clickOnCancelImage method");
	}

	public void clickOnPreviousIcon() {
		logger.info("Starting of clickOnPreviousIcon method");

		waitForElementVisibilty(previousIcon);
		this.previousIcon.click();

		logger.info("Ending of clickOnPreviousIcon method");
	}

	public void clickOnVideoTest() {
		logger.info("Starting of clickOnVideoTest method");

		waitForElementVisibilty(videoTest);
		this.videoTest.click();

		logger.info("Ending of clickOnVideoTest method");
	}

	public void clickOnVideoTestCancel() {
		logger.info("Starting of clickOnVideoTestCancel method");

		waitForElementVisibilty(videoTestCancel);
		this.videoTestCancel.click();

		logger.info("Ending of clickOnVideoTestCancel method");
	}

	public void clickOnSampleImage() {
		logger.info("starting of clickOnSampleImage  method");

		this.clickOnWebElement(imgSample);

		logger.info("Ending of clickOnSampleImage method");
	}

	public void clickOnDocumentSample() {
		logger.info("starting of clickOnDocumentSample method");

		this.documentSample.click();

		logger.info("Ending of clickOnDocumentSample method");
	}

	public void clickOnSampleZipFile() {
		logger.info("starting of clickOnSampleZipFile  method");

		this.zipFileSample.click();

		logger.info("Ending of clickOnSampleZipFile method");
	}

	public void clickOnZipFileDownload() {
		logger.info("starting of clickOnZipFileDownload  method");

		this.zipFileDownload.click();

		logger.info("Ending of clickOnZipFileDownload method");
	}

	public void clickOnTalkToTutorButton() {
		logger.info("starting of clickOnTalkToTutorButton  method");

		this.scrollDown(-300);
		this.clickOnWebElement(btnTalkToTutor);

		logger.info("Ending of clickOnTalkToTutorButton method");
	}

	public String getChatsLabelText() {
		logger.info("Starting of getChatsLabel method");

		logger.info(" Ending of getChatsLabel method");
		return this.lblChats.getText();
	}

	public void setMessageToTutor(String strMessage) {
		logger.info("Starting of setMessageToTutor method");

		this.waitForElementVisibilty(msgTutor);
		this.msgTutor.clear();
		this.msgTutor.sendKeys(strMessage);

		logger.info("Ending of setMessageToTutor method");
	}

	public void clickOnSendMessage() {
		logger.info("starting of clickOnSendMessage  method");

		this.waitForElementVisibilty(msgSend);
		this.msgSend.click();

		logger.info("Ending of clickOnSendMessage method");
	}

	public void clickOnOverviewButton() {
		logger.info("Starting of clickOnOverviewButton method");

		this.btnOverView.click();

		logger.info("Ending of clickOnOverviewButton method");
	}

	public void clickOnShareButton() {
		logger.info("Starting of clickOnShareButton method");

		this.btnShare.click();

		logger.info("Ending of clickOnShareButton method");
	}

	public void clickOnCopyLinkButton() {
		logger.info("Starting of clickOnCopyLinkButton method");

		this.btnCourseLink.click();

		logger.info("Ending of clickOnCopyLinkButton method");
	}

	public String getCourseLinkText() {
		logger.info("Starting of getCourseLinkText method");

		this.explicitWait(msgLinkCopied);

		logger.info("Ending of getCourseLinkText method");
		return this.msgLinkCopied.getText();
	}
}
