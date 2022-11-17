package com.classplusapp.web.pages.tutor;

import java.io.File;

import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.classplusapp.web.pages.BaseClassplusAutomationPage;

public class TutorContentMarketPage extends BaseClassplusAutomationPage {

	@FindBy(xpath = "//div[contains(text(),'Content Market')]")
	private WebElement lblContentMarket;

	@FindBy(xpath = "//div[@class=\"Header_Tab__1Zpfr\"]")
	private WebElement btnContentMarket;

	@FindBy(xpath = "//input[@placeholder='Search for a course']")
	private WebElement txtsearchCourse;

	@FindBy(xpath = "//div[contains(text(),'SHOWING RESULT FOR')]")
	private WebElement lblAllContentMarket;

	@FindBy(xpath = "//div[@class='cursorPointer Card_FeaturedCourse__3o0XN Card_CarouselAllCourses__1EQX_ CourseList_responsiveCourseListCard__VLCdP ']/child::div/child::div/descendant::span[@class='Card_featuredCourseName__3LjAi']")
	private WebElement getCourseName;

	@FindBy(xpath = "//button[@class='storeReadMore']")
	private WebElement btnReadMore;

	@FindBy(xpath = "//button[@class='storeReadMore']")
	private WebElement btnReadLess;

	@FindBy(xpath = "//span[contains(text(),'Content')]//parent::div")
	private WebElement lblContent;

	@FindBy(xpath = "//span[contains(text(),'Add To My Courses')]/parent::div")
	private WebElement btnAddToMyCourses;

	@FindBy(xpath = "//span[contains(text(),\"Save Course\")]")
	private WebElement lblSaveCourse;

	@FindBy(xpath = "//input[@type=\"checkbox\"]//parent::div[@class=\"ui fitted checkbox\"]")
	private WebElement chkTermsAndConditions;

	@FindBy(xpath = "//button[contains(text(),\"Save Course\")]")
	private WebElement btnSaveCourse;

	@FindBy(xpath = "//div[contains(text(),\"Course Added\")]")
	private WebElement msgCourseAddedSuccessful;

	@FindBy(xpath = "//div[contains(text(),\"My Courses\")]")
	private WebElement lblMyCourses;

	@FindBy(xpath = "//div[@class='cursorPointer Card_FeaturedCourse__3o0XN Card_CarouselAllCourses__1EQX_ CourseList_responsiveCourseListCard__VLCdP ']/child::div/child::div/descendant::span[@class='Card_featuredCourseName__3LjAi']")
	private WebElement getMyCourse;

	@FindBy(xpath = " //span[contains(text(),'Content')]")
	private WebElement lblContent1;

	@FindBy(xpath = "//span[text()=\"Updates\"]")
	private WebElement btnUpdates;

	@FindBy(xpath = "//b[contains(text(),'No recent changes have been made to the course.')]/parent::p")
	private WebElement lblUpdates;

	@FindBy(xpath = "//span[text()=\"Students\"]")
	private WebElement btnStudents;

	@FindBy(xpath = "//span[@class='storeStudents__heading--text']")
	private WebElement lblStudent;

	@FindBy(xpath = "//span[text()=\"Announcements\"]")
	private WebElement lblAnnouncements;

	@FindBy(xpath = "//span[contains(text(),'Make an announcement')]")
	private WebElement btnMakeAnAnnouncement;

	@FindBy(xpath = "//span[contains(text(),'Announcements')]")
	private WebElement mnuAnnouncementsIcon;

	@FindBy(xpath = "//h3[contains(text(),'Gunjan Gupta tutor')]")
	private WebElement lblGunjanGuptaTutor;

	@FindBy(xpath = "//span[contains(text(),'Make an announcement')]")
	private WebElement makeAnnounce;

	@FindBy(xpath = "//div[contains(text(),'Make an announcement')]")
	private WebElement lblMakeAnAnnouncement;

	@FindBy(xpath = "//textarea[@placeholder='Make an announcement']")
	private WebElement txtMakeAnnouncement;

	@FindBy(xpath = "//button[@class='ui grey tiny basic button customButtonStyle']/ preceding-sibling::input")
	private WebElement btnAttachFiles;

	@FindBy(xpath = "//label[contains(text(),'Send SMS')]")
	private WebElement lblSendSMS;

	@FindBy(xpath = "//button[@class='ui mini primary button']")
	private WebElement btnAddPost;

	@FindBy(xpath = "//div[contains(text(),'Announcement added successfully')]")
	private WebElement msgAddedAnnouncement;

	@FindBy(xpath = "//span[contains(text(),'Make an announcement')]")
	private WebElement makeAnnounce1;

	@FindBy(xpath = "//textarea[@placeholder='Make an announcement']")
	private WebElement makePdfAnnounceText;

	@FindBy(xpath = "//input[@type='file']")
	private WebElement attachFile1;

	@FindBy(xpath = "//button[@class='ui mini primary button']")
	private WebElement postButton1;

	@FindBy(xpath = "//div[contains(text(),'Announcement added successfully')]")
	private WebElement announceMessage1;

	@FindBy(xpath = "//span[contains(text(),'Make an announcement')]")
	private WebElement makeExcelAnnouncement;

	@FindBy(xpath = "//textarea[@placeholder='Make an announcement']")
	private WebElement makeExcelAnnounceText;

	@FindBy(xpath = "//button[@class='ui grey tiny basic button customButtonStyle']/ preceding-sibling::input")
	private WebElement attachFile2;

	@FindBy(xpath = "//button[@class='ui mini primary button']")
	private WebElement postButton2;

	@FindBy(xpath = "//div[contains(text(),'Announcement added successfully')]")
	private WebElement announceMessage2;

	@FindBy(xpath = "//span[contains(text(),'sample automation excel')]/parent::h3/parent::div/parent::div/parent::div/parent::div/parent::div/following-sibling::div/child::div")
	private WebElement mnuHorizontalIcon;

	@FindBy(xpath = "(//div[@class='item an-dr-menu'])[1]")
	private WebElement mnuEditIcon;

	@FindBy(xpath = "//textarea[@placeholder='Make an announcement']")
	private WebElement txtEditAnnouncement;

	@FindBy(xpath = "//button[@class='ui mini primary button']")
	private WebElement btnEditPost;

	@FindBy(xpath = "//div[contains(text(),'Announcement edited successfully')]")
	private WebElement msgEditedAnnounement;

	@FindBy(xpath = "//i[@class='ellipsis horizontal icon']")
	private WebElement mnuHorizontalIcon1;

	@FindBy(xpath = "(//div[@class='item an-dr-menu'])[2]")
	private WebElement mnuRemoveIcon;

	@FindBy(xpath = "//div[contains(text(),'Delete Announcement?')]")
	private WebElement lblDeleteAnnouncement;

	@FindBy(xpath = "//p[contains(text(),'Are you sure you want to delete the announcement?')]")
	private WebElement lblAreYouSureYouWantToDeleteTheAnnouncement;

	@FindBy(xpath = "//button[contains(text(),'Delete')]")
	private WebElement btnDelete;

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

	@FindBy(xpath = "//div[@class=\"courseContentCurrent\"]")
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

	@FindBy(xpath = "//div[@class='ui header']/following-sibling::div[@class='content']")
	private WebElement lblDeleteAnnouncementText;

	@FindBy(xpath = "//input[@type='text']")
	private WebElement txtSearch;

	@FindBy(xpath = "//span[@class='Linkify']")
	private WebElement lblExcelAnnouncement;

	private static final Logger logger = Logger.getLogger(TutorContentMarketPage.class.getName());

	public TutorContentMarketPage(WebDriver driver) {
		super(driver);
		logger.info("Starting of ContentMarketPage method");

		PageFactory.initElements(driver, this);

		logger.info("Ending of ContentMarketPage method");
	}

	public String getContentMarketLabel() {
		logger.info("starting of getContentMarketLabel method");

		logger.info("Ending of getContentMarketLabel method");
		return lblContentMarket.getText();
	}

	public void clickOnContentMarketButton() {
		logger.info("starting of clickOnContent method");

		try {
			this.hardWait(3);
			this.clickOnWebElement(btnContentMarket);
		} catch (Exception e) {
			this.btnContentMarket.click();

		}

		logger.info("Ending clickOnContent method");
	}

	public void searchCourse(String strSearch) {
		logger.info("Starting of setSearchArea method");
		this.txtsearchCourse.click();
		this.txtsearchCourse.sendKeys(strSearch);
		this.hardWait(4);

		logger.info("Ending of setSearchArea method");
	}

	public String getAllContentMarketLabel() {
		logger.info("starting of getAllContentMarketLabel method");

		logger.info("Ending of getAllContentMarketLabel method");
		return lblAllContentMarket.getText();
	}

	public void clickOnCourse() {
		logger.info("starting of clickOnCourse method");
		try {
			this.hardWait(3);
			this.getCourseName.click();
		} catch (Exception e) {
			this.clickOnWebElement(getCourseName);
		}

		logger.info("Ending clickOnCourse method");
	}

	public void clickOnReadMore() {
		logger.info("starting of clickOnReadMore method");

		this.clickOnWebElement(btnReadMore);

		logger.info("Ending clickOnReadMore method");
	}

	public void clickOnReadLess() {
		logger.info("starting of clickOnReadMore method");

		this.clickOnWebElement(btnReadLess);

		logger.info("Ending clickOnReadMore method");
	}

	public void clickOnContentcourses() {
		logger.info("Starting of clickOnContentcourses method");

		this.clickOnWebElement(lblContent);

		logger.info("Ending of clickOnContentcourses method");
	}

	public void clickOnAddToMyCourses() {
		logger.info("starting of clickOnAddCourse method");

		try {
			Thread.sleep(1000);
			this.btnAddToMyCourses.click();
		} catch (Exception e) {
			this.clickOnWebElement(btnAddToMyCourses);
		}

		logger.info("Ending clickOnAddCourse method");
	}

	public String getSaveCourseLabel() {
		logger.info("starting of getSaveCourseLabel method");

		logger.info("Ending of getSaveCourseLabel method");
		return lblSaveCourse.getText();
	}

	public void clickOnCheckBox() {
		logger.info("starting of clickOnCheckBox method");

		this.scrollDown(700);
		try {
			Thread.sleep(1000);
			this.chkTermsAndConditions.click();
		} catch (Exception e) {
			this.clickOnWebElement(chkTermsAndConditions);
		}

		logger.info("Ending clickOnCheckBox method");
	}

	public void clickOnSaveCourseButton() {
		logger.info("starting of clickOnSave method");

		this.btnSaveCourse.click();

		logger.info("Ending clickOnSave method");
	}

	public String getcourseAddedMessage() {
		logger.info("Starting of courseAddedMessage method");
		logger.info("Ending of courseAddedMessage method");

		return msgCourseAddedSuccessful.getText();

	}

	public String getMyCoursesLabel() {
		logger.info("starting of getMyCoursesLabel method");
		logger.info("Ending getMyCoursesLabel method");
		return lblMyCourses.getText();
	}

	public void clickOnSavedCourse() {
		logger.info("starting of clickOnSavedCourse method");

		try {
			this.hardWait(3);
			this.getMyCourse.click();
		} catch (Exception e) {
			this.clickOnWebElement(getMyCourse);
		}

		logger.info("Ending of clickOnSavedCourse method");
	}

	public void clickOnContent() {
		logger.info("starting of clickOnContent method");

		try {
			this.lblContent.click();
		} catch (Exception e) {
			this.clickOnWebElement(lblContent);
		}

		logger.info("Ending clicclickOnContent method");
	}

	public void clickOnUpdateButton() {
		logger.info("starting of clickOnUpdateButton method");

		this.clickOnWebElement(btnUpdates);

		logger.info("Ending clickOnUpdateButton method");
	}

	public String getUpdatesLabel() {
		logger.info("starting of getUpdatesLabel method");
		logger.info("Ending getUpdatesLabel method");
		return lblUpdates.getText();
	}

	public void clickOnStudentsButton() {
		logger.info("starting of clickOnStudentsButton method");

		this.clickOnWebElement(btnStudents);

		logger.info("Ending clickOnStudentsButton method");
	}

	public String getStudentLabel() {
		logger.info("starting of getStudentLabel method");

		logger.info("Ending of getStudentLabel method");
		return lblStudent.getText();
	}

	public void clickOnAnnouncement() {
		logger.info("Starting of clickOnAnnouncement method");

		this.clickOnWebElement(lblAnnouncements);

		logger.info("Ending of clickOnAnnouncement method");
	}

	public void clickOnMakeAnAnnouncement() {
		logger.info("Starting of clickOnMakeAnAnnouncement method");

		this.btnMakeAnAnnouncement.click();

		logger.info("Ending of clickOnMakeAnAnnouncement method");
	}

	public void clickOnAnnouncementIcon() {
		logger.info("Starting of clickOnAnnouncementIcon method");

		try {

			this.mnuAnnouncementsIcon.click();
		} catch (Exception e) {
			this.clickOnWebElement(mnuAnnouncementsIcon);
		}

		logger.info("Ending of clickOnAnnouncementIcon method");
	}

	public String getGunjanGuptaTutorLabel() {
		logger.info("Starting of getGunjanGuptaTutorLabel method");
		logger.info("Ending of getGunjanGuptaTutorLabel method");
		return lblGunjanGuptaTutor.getText();
	}

	public void clickOnMakeAnnouncement() {
		logger.info("Starting of clickOnMakeAnnouncement method");

		try {

			this.makeAnnounce.click();
		} catch (Exception e) {
			this.clickOnWebElement(makeAnnounce);
		}

		logger.info("Ending of clickOnMakeAnnouncement method");
	}

	public String getMakeAnAnnouncementLabel() {
		logger.info("Starting of getMakeAnAnnouncementLabel method");
		logger.info("Ending of getMakeAnAnnouncementLabel method");
		return lblMakeAnAnnouncement.getText();
	}

	public void clickOnMakeAnnonceText(String strText) {
		logger.info("Starting of clickOnMakeAnnonceText method");

		this.txtMakeAnnouncement.sendKeys(strText);

		logger.info("Ending of clickOnMakeAnnonceText method");
	}

	public void clickOnAttachFile() {
		logger.info("Starting of clickOnAttachFile method");
		String osPath = System.getProperty("os.name");
		if (osPath.contains("Linux")) {
			btnAttachFiles.sendKeys(TEST_FILE_PATH + "/testdata/annonceimage.jpg");
		} else {
			btnAttachFiles.sendKeys(TEST_FILE_PATH + "/testdata/annonceimage.jpg");
		}
		logger.info("Ending of clickOnAttachFile method");
	}

	public String getSendSMSLabel() {
		logger.info("Starting of clickOnSendSMSLabel method");
		logger.info("Ending of clickOnSendSMSLabel method");
		return lblSendSMS.getText();
	}

	public void clickOnAddPostButton() {
		logger.info("Starting of clickOnAddPostButton method");

		this.btnAddPost.click();

		logger.info("Ending of clickOnAddPostButton method");
	}

	public String getAnnounceAddedMessage() {
		logger.info("Starting of getAnnounceAddedMessage method");

		this.explicitWait(msgAddedAnnouncement);

		logger.info("Ending of getAnnounceAddedMessage method");
		return msgAddedAnnouncement.getText();
	}

	public void clickOnMakeAnnouncement1() {
		logger.info("Starting of clickOnMakeAnnouncement1 method");

		this.clickOnWebElement(makeAnnounce1);

		logger.info("Ending of clickOnMakeAnnouncement1 method");
	}

	public void clickOnMakePdfAnnonceText(String strText) {
		logger.info("Starting of clickOnMakePdfAnnonceText method");

		this.makePdfAnnounceText.sendKeys(strText);

		logger.info("Ending of clickOnMakePdfAnnonceText method");
	}

	public void clickOnAttachFileDoc() {
		logger.info("Starting of clickOnAttachFileDoc method");
		String osPath = System.getProperty("os.name");
		if (osPath.contains("Linux")) {
			attachFile1.sendKeys(TEST_FILE_PATH + "/testdata/annoncePdf.pdf");
		} else {
			attachFile1.sendKeys(TEST_FILE_PATH + "/testdata/annoncePdf.pdf");
		}
		logger.info("Ending of clickOnAttachFileDoc method");
	}

	public void clickOnPost1() {
		logger.info("Starting of clickOnPost1 method");

		this.postButton1.click();

		logger.info("Ending of clickOnPost1 method");
	}

	public String announceAddedMessage1() {
		logger.info("Starting of announceAddedMessage1 method");

		this.explicitWait(announceMessage1);

		logger.info("Ending of announceAddedMessage1 method");
		return this.announceMessage1.getText();
	}

	public void clickOnMakeExcelAnnouncement() {
		logger.info("Starting of clickOnMakeExcelAnnouncement method");

		try {
			this.makeExcelAnnouncement.click();
		} catch (Exception e) {
			this.clickOnWebElement(makeExcelAnnouncement);
		}

		logger.info("Ending of clickOnMakeExcelAnnouncement method");
	}

	public void clickOnMakeExcelAnnonceText(String strText) {
		logger.info("Starting of clickOnMakeAnnonceText2 method");

		this.makeExcelAnnounceText.sendKeys(strText);

		logger.info("Ending of clickOnMakeAnnonceText2 method");
	}

	public void clickOnAttachFileExcel() {
		logger.info("Starting of clickOnAttachFileExcel method");
		String osPath = System.getProperty("os.name");
		if (osPath.contains("Linux")) {
			attachFile1.sendKeys(TEST_FILE_PATH + "/testdata/announceExcel(naukri TC).xlsx");
		} else {
			attachFile1.sendKeys(
					TEST_FILE_PATH + File.separator + "testdata" + File.separator + "announceExcel(naukri TC).xlsx");
		}
		logger.info("Ending of clickOnAttachFileExcel method");
	}

	public void clickOnPost2() {
		logger.info("Starting of clickOnPost2 method");

		this.postButton2.click();

		logger.info("Ending of clickOnPost2 method");
	}

	public String announceAddedMessage2() {
		logger.info("Starting of announceAddedMessage2 method");

		this.explicitWait(announceMessage2);

		logger.info("Ending of announceAddedMessage2 method");
		return this.announceMessage2.getText();
	}

	public void clickOnThreeDottedMenu() {
		logger.info("Starting of clickOnThreeDottedMenu method");

		this.clickOnWebElement(mnuHorizontalIcon);

		logger.info("Ending of clickOnThreeDottedMenu method");
	}

	public void clickOnEditIcon() {
		logger.info("Starting of clickOnEditIcon method");

		this.clickOnWebElement(mnuEditIcon);

		logger.info("Ending of clickOnEditIcon method");
	}

	public void clickOnEditMakeAnnonceText(String strText) {
		logger.info("Starting of clickOnEditMakeAnnonceText method");

		this.txtEditAnnouncement.clear();
		this.txtEditAnnouncement.sendKeys(strText);

		logger.info("Ending of clickOnEditMakeAnnonceText method");
	}

	public void clickOnEditPostButton() {
		logger.info("Starting of clickOnEditPostButton method");

		this.btnEditPost.click();

		logger.info("Ending of clickOnEditPostButton method");
	}

	public String getAnnouncementEditedMessage() {
		logger.info("Starting of getAnnouncementEditedMessage method");

		this.explicitWait(msgEditedAnnounement);

		logger.info("Ending of getAnnouncementEditedMessage method");
		return msgEditedAnnounement.getText();
	}

	public void clickOnThreeHorizontalDottedMenu() {
		logger.info("Starting of clickOnThreeHorizontalDottedMenu method");

		try {
			this.hardWait(2);
			this.mnuHorizontalIcon1.click();
		} catch (Exception e) {
			this.clickOnWebElement(mnuHorizontalIcon1);
		}

		logger.info("Ending of clickOnThreeHorizontalDottedMenu method");
	}

	public void clickOnRemoveIcon() {
		logger.info("Starting of clickOnRemoveIcon method");

		try {
			this.mnuRemoveIcon.click();
		} catch (Exception e) {
			this.clickOnWebElement(mnuRemoveIcon);
		}

		logger.info("Ending of clickOnRemoveIcon method");
	}

	public String getDeleteAnnouncementLabel() {
		logger.info("Starting of getDeleteAnnouncementLabel method");
		logger.info("Ending of getDeleteAnnouncementLabel method");
		return lblDeleteAnnouncement.getText();
	}

	public void clickOnDeleteButton() {
		logger.info("Starting of clickOnDeleteButton method");

		try {
			this.btnDelete.click();
		} catch (Exception e) {
			this.clickOnWebElement(btnDelete);
		}

		logger.info("Ending of clickOnDeleteButton method");
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

		return msgPublishSucces.getText();
	}

	public void clickOnUnpublishCourseButton() {
		logger.info("Starting of clickOnUnpublishCourseButton method");

		try {
			this.btnUnpublishCourse.click();
		} catch (Exception e) {
			this.clickOnWebElement(btnUnpublishCourse);
		}

		logger.info("Ending of clickOnUnpublishCourseButton method");
	}

	public String getlabelUnpulishCourseText() {
		logger.info("Starting of getlabelUnpulishCourseText method");
		this.hardWait(1);
		logger.info("Ending of getlabelUnpulishCourseText method");
		return lblUnpublishCourse.getText();
	}

	public void clickOnUnpublishButton() {
		logger.info("Starting of clickOnUnpublishButton  method");

		try {
			this.hardWait(1);
			this.btnUnpublish.click();
		} catch (Exception e) {
			this.clickOnWebElement(btnUnpublish);

		}

		logger.info("Ending of clickOnUnpublishButton  method");
	}

	public String getUnPublishSuccessText() {
		logger.info("Starting of getUnPublishSuccessText method");
		logger.info("Ending of getUnPublishSuccess method");

		this.explicitWait(msgUnpublishSuccess);
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

	public void setSearch(String strSearch) {
		logger.info("Starting of setSearch method");

		this.explicitWait(txtSearch);
		this.txtSearch.sendKeys(Keys.CONTROL + "a");
		this.txtSearch.sendKeys(Keys.DELETE);

		this.txtSearch.sendKeys(strSearch);

		logger.info("Ending of setSearch method");
	}

	public String getDeleteAnnouncementText() {
		logger.info("Starting of getAnnounceAddedMessage method");

		this.explicitWait(lblDeleteAnnouncementText);

		logger.info("Ending of getAnnounceAddedMessage method");
		return lblDeleteAnnouncementText.getText();
	}

	public String getExcelAnnouncementLabel() {
		logger.info("Starting of getExcelAnnouncementLabel method");

		this.explicitWait(lblExcelAnnouncement);

		logger.info("Ending of getExcelAnnouncementLabel method");
		return lblExcelAnnouncement.getText();
	}

	public void clearSearch() {
		logger.info("Starting of clearSearch method");

		this.txtSearch.click();
		this.txtSearch.sendKeys(Keys.CONTROL + "a");
		this.txtSearch.sendKeys(Keys.DELETE);

		logger.info("Ending of clearSearch method");
	}
}
