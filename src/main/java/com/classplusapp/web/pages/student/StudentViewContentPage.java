package com.classplusapp.web.pages.student;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.classplusapp.web.pages.BaseClassplusAutomationPage;

public class StudentViewContentPage extends BaseClassplusAutomationPage {

	@FindBy(xpath = "//p[text()='Store']")
	private WebElement btnStore;

	@FindBy(xpath = "//input[@placeholder='Search for a course']")
	private WebElement txtSearch;

	private String courseXpath = "//div[@class='selectorCheat']//span[text()='${courseName}']";
	@FindBy(xpath = "//div[contains(text(),'FILTER BY TOPICS')]")
	private WebElement lblFilterByTopics;

	@FindBy(xpath = "//span[text()='studentTestingContentCheckCourse']")
	private WebElement getCourse;

	@FindBy(xpath = "//span[contains(text(),' Overview ')]")
	private WebElement lblOverView;

	@FindBy(xpath = "//span[contains(text(),'Content')]//parent::div")
	private WebElement btnContent;

	@FindBy(xpath = "//p[contains(text(),'Files')]")
	private WebElement mnuFiles;

	@FindBy(xpath = "//div[contains(text(),'00:46:52')]")
	private WebElement sampleVideo;

	@FindBy(xpath = "//h3[contains(text(),'Content Locked')]")
	private WebElement lblContentCannotViewed;

	@FindBy(xpath = "//h3[contains(text(),'This content can not be viewed on the web')]")
	private WebElement lblContentCannotViewedonWeb;

	@FindBy(xpath = "(//div[@class = 'content']//img)[1]")
	private WebElement imgCancel;

	@FindBy(xpath = "//img[@class='previousIcon']")
	private WebElement previousIcon;

	// write generic xpath for the element
	@FindBy(xpath = "//div[@class='videoTime']")
	private WebElement videoTest;

	@FindBy(xpath = "//img[@alt='Close']")
	private WebElement videoTestCancel;

	// write generic xpath for the element
	@FindBy(xpath = "//p[contains(text(),'content image')]")
	private WebElement imgSample;

	@FindBy(xpath = "//span[contains(text(),'file(s)')]//preceding-sibling::span")
	private WebElement contentSummary;

	@FindBy(xpath = "//p[text()='contentdocument']")
	private WebElement documentSample;

	@FindBy(xpath = "//img[@class='previousIcon']")
	private WebElement folderBack;

	// write generic xpath for the element
	@FindBy(xpath = "//p[contains(text(), 'samplezipfile')]")
	private WebElement zipFileSample;

	@FindBy(xpath = "//p[contains(text(),'Download')]")
	private WebElement zipFileDownload;

	@FindBy(xpath = "//div[@class='studentChatWindow']//p//following-sibling::p")
	private WebElement btnTalkToTutor;

	@FindBy(xpath = "//span[contains(text(),'Chats')]")
	private WebElement lblChats;

	@FindBy(xpath = "//textarea[@type='text']")
	private WebElement msgTutor;

	@FindBy(xpath = "//img[@class='input_right__2Z46_']")
	private WebElement msgSend;

	@FindBy(xpath = "//div[@class=\"courseContentCurrent\"]")
	private WebElement btnOverView;

	@FindBy(xpath = "//button[@class='CourseShareButton']")
	private WebElement btnShare;

	@FindBy(xpath = "//div[contains(text(),'Copy')]")
	private WebElement btnCourseLink;

	@FindBy(xpath = "//div[contains(text(),'Link Copied')]")
	private WebElement msgLinkCopied;

	@FindBy(xpath = "//div[@class='ShareModal__Content__Top--Close']")
	private WebElement btnCloseShare;

	private static final Logger logger = Logger.getLogger(StudentViewContentPage.class.getName());

	public StudentViewContentPage(WebDriver driver) {
		super(driver);
		logger.info("Starting of StudentViewContentPage Method");

		PageFactory.initElements(driver, this);

		logger.info("Ending of StudentViewContentPage Method");
	}

	public void clickOnStoreButton() {
		logger.info("starting of clickOnStoreButton method");

		try {
			this.hardWait(2);
			this.clickOnWebElement(btnStore);
		} catch (Exception e) {
			this.btnStore.click();

		}

		logger.info("Ending of clickOnStoreButton method");
	}

	public void setSearchArea(String strSearch) {
		logger.info("Starting of setSearchArea method");

		this.txtSearch.sendKeys(strSearch);

		logger.info("Ending of setSearchArea method");
	}

	public String getFilterByTopicsLabel() {
		logger.info("Starting of getFilterByTopicsLabel method");

		logger.info(" Ending of getFilterByTopicsLabel method");
		return this.lblFilterByTopics.getText();
	}

	public void clickOnGetCourse(String courseTitle) {
		logger.info("starting of clickOnGetCourse method");

		WebElement course = driver.findElement(By.xpath(this.courseXpath.replace("${courseName}", courseTitle)));
		try {
			this.explicitWait(course);
			course.click();
		} catch (Exception e) {
			this.clickOnWebElement(course);
		}

		logger.info("Ending of clickOnGetCourse method");
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
		try {
			this.hardWait(2);
			this.clickOnWebElement(mnuFiles);
		} catch (Exception e) {
			this.mnuFiles.click();
		}

		logger.info("Ending of clickOnFilesMenu method");
	}

	public void clickOnImagesB2b() {
		logger.info("Starting of clickOnImagesB2b method");

		try {
			this.hardWait(2);
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

	public String getContentCannotViewedLabelonWeb() {
		logger.info("Starting of getContentCannotViewedLabelonWeb method");
		logger.info(" Ending of getContentCannotViewedLabelonWeb method");

		return this.lblContentCannotViewedonWeb.getText();
	}

	public void clickOnCancelImage() {
		logger.info("Starting of clickOnCancelImage method");

		try {
			this.clickOnWebElement(videoTestCancel);
		} catch (Exception e) {
			this.videoTestCancel.click();

		}

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

		this.hardWait(2);
		try {
			this.clickOnWebElement(videoTest);
		} catch (Exception e) {
			this.videoTest.click();
		}

		logger.info("Ending of clickOnVideoTest method");
	}

	public void clickOnVideoTestCancel() {
		logger.info("Starting of clickOnVideoTestCancel method");
		try {
			this.videoTestCancel.click();
		} catch (Exception e) {
			this.clickOnWebElement(videoTestCancel);
		}

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

		try {
			this.scrollIntoView(zipFileSample);
			this.clickOnWebElement(zipFileSample);
		} catch (Exception e) {
			this.zipFileSample.click();

		}

		logger.info("Ending of clickOnSampleZipFile method");
	}

	public void clickOnZipFileDownload() {
		logger.info("starting of clickOnZipFileDownload  method");

		this.zipFileDownload.click();

		logger.info("Ending of clickOnZipFileDownload method");
	}

	public void clickOnTalkToTutorButton() {
		logger.info("starting of clickOnTalkToTutorButton  method");

		this.hardWait(2);
		Actions act = new Actions(driver);
		act.moveToElement(btnTalkToTutor).click(btnTalkToTutor).build().perform();

		logger.info("Ending of clickOnTalkToTutorButton method");
	}

	public String getTalkToTutorText() {
		logger.info("Starting of getTalkToTutorText method");
		logger.info(" Ending of getTalkToTutorText method");

		return this.btnTalkToTutor.getText().trim();
	}

	public String getChatsLabelText() {
		logger.info("Starting of getChatsLabel method");
		this.waitForElementVisibilty(lblChats);

		logger.info(" Ending of getChatsLabel method");
		return this.lblChats.getText().trim();
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
		try {
			this.clickOnWebElement(msgSend);
		} catch (Exception e) {
			this.msgSend.click();

		}

		logger.info("Ending of clickOnSendMessage method");
	}

	public void clickOnOverviewButton() {
		logger.info("Starting of clickOnOverviewButton method");

		try {
			// this.explicitWait(btnOverView);
			this.btnOverView.click();
		} catch (Exception e) {
			this.clickOnWebElement(btnOverView);
		}
		logger.info("Ending of clickOnOverviewButton method");
	}

	public void clickOnShareButton() {
		logger.info("Starting of clickOnShareButton method");

		try {
			this.clickOnWebElement(btnShare);
		} catch (Exception e) {
			this.btnShare.click();

		}

		logger.info("Ending of clickOnShareButton method");
	}

	public void clickOnCopyLinkButton() {
		logger.info("Starting of clickOnCopyLinkButton method");
		try {
			this.clickOnWebElement(btnCourseLink);
		} catch (Exception e) {
			this.btnCourseLink.click();
		}

		logger.info("Ending of clickOnCopyLinkButton method");
	}

	public String getOnContentSummary() {
		logger.info("Starting of clickOnContentSummary method");
		String summary = this.contentSummary.getText();
		logger.info("Ending of clickOnContentSummary method");
		return summary;
	}

	public void clickOnCloseShareButton() {
		logger.info("Starting of clickOnOverviewButton method");

		try {
			this.clickOnWebElement(btnCloseShare);
		} catch (Exception e) {
			this.btnCloseShare.click();

		}
		logger.info("Ending of clickOnOverviewButton method");
	}

	public String getCourseLinkText() {
		logger.info("Starting of getCourseLinkText method");

		this.explicitWait(msgLinkCopied);

		logger.info("Ending of getCourseLinkText method");
		return this.msgLinkCopied.getText();
	}

}
