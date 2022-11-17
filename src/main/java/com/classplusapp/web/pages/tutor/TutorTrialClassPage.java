package com.classplusapp.web.pages.tutor;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.classplusapp.web.pages.BaseClassplusAutomationPage;

public class TutorTrialClassPage extends BaseClassplusAutomationPage {

	@FindBy(xpath = "//div[contains(@class,'LiveVideo_ScheduleLiveClassCardButton')]//following-sibling::div")
	private WebElement btnGoLive;

	@FindBy(xpath = "//div[@class='LiveVideo_TrialEmblem__IqArr']")
	private WebElement btnGoLivePromoteClass;

	@FindBy(xpath = "//span[@class='LiveVideo_ScheduleTrialLiveClassLeft__wmVa1']")
	private WebElement lblTrialClass;

	@FindBy(xpath = "//div[@class='LiveTrial__Modal__Top--Heading']")
	private WebElement lblTrialClassHeading;

	@FindBy(xpath = "//div[contains(@class,'LiveVideo_GoLiveCardButtonWrapper')]//child::div[contains(text(),'Schedule a live class')]")
	private WebElement btnScheduleClass;

	@FindBy(xpath = "//div[@class='LiveTrial__Modal__Top--Close']")
	private WebElement btnLiveTrialCloseModal;

	@FindBy(xpath = "//div[@class='LiveTrial__Modal__Body--Banner--Left--Heading']")
	private WebElement lblTrialClassBanner;

	@FindBy(xpath = "//div[@class='LiveTrial__Modal__Body__Courses__Label']")
	private WebElement lblCourseToPromote;

	@FindBy(xpath = "//div[@class='LiveTrial__Modal__Body__Courses__List--Item--Name']")
	private WebElement lblCourseName;

	@FindBy(xpath = "//div[@class='LiveTrial__Modal__Body__Topic--Label']")
	private WebElement lblTopic;

	@FindBy(xpath = "//input[@class='LiveTrial__Modal__Body__Topic--Input']")
	private WebElement txtTopic;

	@FindBy(xpath = "//div[@class='LiveTrial__Modal__Body__Who--Label']")
	private WebElement lblWhoJoin;

	@FindBy(xpath = "//div[@class='SelectStudentModal__Top__Left--Heading']")
	private WebElement lblSelectStudents;

	@FindBy(xpath = "//div[@class='LiveTrial__Modal__Body__Who--List--Right']")
	private WebElement btnAdd;

	@FindBy(xpath = "//div[@class='SelectorSection__Right__Menu__List--Item']//label[text()='Upto 10 days from download']")
	private WebElement rdoSelectStudents;

	@FindBy(xpath = "//div[@class='SelectStudentModal__Bottom--Done']")
	private WebElement btnDone;

	@FindBy(xpath = "//span[text()='Upto 10 days from download']")
	private WebElement txtUptoDownloads;

	@FindBy(xpath = "//div[text()='Set Date']")
	private WebElement lblSetDate;

	@FindBy(xpath = "//input[@placeholder='Select date']")
	private WebElement dtpSelectDate;

	@FindBy(xpath = "//td[@class='rdtDay rdtToday']")
	private WebElement dtpToday;

	@FindBy(xpath = "//div[@class='LiveTrial__Modal__Body__DateTime__Col--Label' and text()='Set Time']")
	private WebElement lblSetTime;

	@FindBy(xpath = "//input[@placeholder='Select Time']")
	private WebElement tmrSelectTime;

	@FindBy(xpath = "(//span[@class='rdtBtn'])[1]")
	private WebElement tmrSetTime;

	@FindBy(xpath = "//button[@class='LiveTrial__Modal__Bottom--Button']")
	private WebElement btnScheduleforLater;

	@FindBy(xpath = "//div[@class='TrialLiveSuccess__Body__Text--Heading']")
	private WebElement lblScheduledSuccess;

	@FindBy(xpath = "//div[@class='ScheduledClassCard__Badges--Scheduled']")
	private WebElement lblScheduled;

	@FindBy(xpath = "//div[@class='ScheduledClassCard__Body--Actions--Date']")
	private WebElement dtpDateAndTime;

	@FindBy(xpath = "//div[text()='Take Class']")
	private WebElement btnTakeClass;

	@FindBy(xpath = "//div[text()='TAKE CLASS']")
	private WebElement btnTakeClasses;

	/*
	 * @FindBy(xpath ="//div[text()='Take Class']") private WebElement btnTakeClass;
	 */

	@FindBy(xpath = "(//button[@class='commonBtn'])[1]")
	private WebElement btnMic;

	@FindBy(xpath = "(//button[@class='commonBtn'])[2]")
	private WebElement btnVideo;

	@FindBy(xpath = "//span[@class='badge success mx10']")
	private WebElement txtAdmin;

	@FindBy(xpath = "//button[@class='LiveTrial__Modal__Bottom--Button']")
	private WebElement btnUpdateTrialClasses;

	@FindBy(xpath = "//div[@class='ScheduledClassCard__Badges--Scheduled']")
	private WebElement lblScheduledCard;

	@FindBy(xpath = "//div[text()='white label trial class update']")
	private WebElement lblScheduledBodyName;

	@FindBy(xpath = "//input[@placeholder='Select Time']")
	private WebElement tmrTime;

	@FindBy(xpath = "//div[@class='LiveTrial__Modal__Bottom--Delete']")
	private WebElement btnDelete;

	@FindBy(xpath = "//div[text()='Session delete succesfully']")
	private WebElement txtDeleteMessage;

	@FindBy(xpath = "//div[@class='Upcoming']")
	private WebElement lblUpComingLiveClasses;

	@FindBy(xpath = "//div[@class='ScheduledClassCard__Body--Actions--Date']")
	private WebElement tmrScheduledTime;

	@FindBy(xpath = "//div[@class='LiveTrial__Modal__Body--Banner--Left--Description']")
	private WebElement txtHowItWorks;

	@FindBy(xpath = "//span[text()='New App Downloads']")
	private WebElement lblNewApp;

	@FindBy(xpath = "//span[text()='How it works?']")
	private WebElement lblHowItWorks;

	@FindBy(xpath = "//label[text()='Not purchased any course']//following-sibling::input")
	private WebElement rdoNotPurchasedCourse;

	@FindBy(xpath = "//label[text()='Upto 10 days from download']//following-sibling::input")
	private WebElement rdoUptoTenDays;

	@FindBy(xpath = "//label[text()='Upto 30 days from download']//following-sibling::input")
	private WebElement rdoUptoThirtyDays;

	@FindBy(xpath = "//label[text()='New App Downloads']//following-sibling::input")
	private WebElement rdoNewAppDownloads;

	@FindBy(xpath = "//div[@class='LiveTrial__Modal__Body__Who--List--Left--Item']//span[contains(text(),'Not purchased any course')]")
	private WebElement msgNotPurchasedCourse;

	@FindBy(xpath = "//div[@class='LiveTrial__Modal__Body__Who--List--Left--Item']//span[contains(text(),'New App Downloads')]")
	private WebElement msgNewAppDownloads;

	@FindBy(xpath = "// div[@class='goLiveModalAdvanceHeader']//following-sibling::div//div/span//parent::div")
	private WebElement msgDesktopView;

	@FindBy(xpath = "//div[@class='goLiveModalAdvanceLabel']")
	private WebElement btnAdvancedSettings;

	@FindBy(xpath = "//span[@class='LeftPanel__Item--Count']")
	private WebElement btnCourses;

	@FindBy(xpath = "//div[@class='SelectorSection__Right__Menu__List--Item']//label[contains(text(),'LEARNING LIGHT 222')]//following-sibling::input")
	private WebElement chkDefaultCourse;

	@FindBy(xpath = "//span[@class='SelectorSection__Right__Menu__Label--Select']")
	private WebElement btnSelectAll;

	@FindBy(xpath = "//div[@class='SelectStudentModal__Top__Right--Clear']")
	private WebElement btnClear;

	@FindBy(xpath = "//div[@class='SelectStudentModal__Top__Right--Clear']/following-sibling::img")
	private WebElement btnCloseAdd;

	@FindBy(xpath = "//input[@class='SelectorSection__Right__Menu__Search--Input']")
	private WebElement txtSearchCourse;

	@FindBy(xpath = "//div[@class='ui fitted toggle checkbox']")
	private WebElement tglShowRecord;

	@FindBy(xpath = "//div[@class='rrt-title']/following-sibling::div[@class='rrt-text']")
	private WebElement msgTopicErrorToast;

	@FindBy(xpath = "//div[@class='LiveTrial__Modal__Body__Sms--Toggle']//input")
	private WebElement chkSendSMS;

	@FindBy(xpath = "//div[@class='TrialLiveSuccess__Body__Button']")
	private WebElement btnNotify;

	@FindBy(xpath = "//span[@class='create-notification-headerText']")
	private WebElement composeNotificationHeader;

	@FindBy(xpath = "// span[@class='SelectorSection__Right__Menu__Label--Courses']")
	private WebElement lblTotalCourses;

	@FindBy(xpath = "//div[@class='SelectorSection__Right__Menu__List--Item']/input")
	private List<WebElement> chkSelectedCourse;

	@FindBy(xpath = "//div[@class='panel-body-landing-screen-text']")
	private WebElement lblLandingScreenCourse;

	@FindBy(xpath = "//div[@class='TrialLiveSuccess__Top']/img")
	private WebElement btnNotifyClose;

	@FindBy(xpath = "//div[@class='ScheduledClassCard__Body--Name']")
	private WebElement lblOverviewTrialTopicName;

	@FindBy(xpath = "//div[@class='ScheduledClassCard__Badges--Trial']")
	private WebElement lblOverviewTrial;

	@FindBy(xpath = "//div[@class='ScheduledClassCard__Badges--Scheduled']")
	private WebElement lblOverviewScheduled;

	@FindBy(xpath = "//div[@class='LiveTrial__Modal__Bottom--Delete']")
	private WebElement btnDeleteTrialClass;

	@FindBy(xpath = "//div[contains(text(),'Live classes deleted successfully')]")
	private WebElement msgDeleteLiveClass;

	@FindBy(xpath = "//button[@class='LiveTrial__Modal__Bottom--Button']")
	private WebElement btnUpdateTrialClass;

	@FindBy(xpath = "//div[contains(text(),'Class edited successfully')]")
	private WebElement msgUpdateLiveClass;

	@FindBy(xpath = "//span[@class='NotificationRecepienctList__Text']")
	private WebElement lblSelectStudent;

	@FindBy(xpath = "//div[@class='SelectStudentModal__Body__Count']")
	private WebElement getSelectStudentCount;

	@FindBy(xpath = "//div[@class='LiveTrial__Modal__Body__Who--Info']")
	private WebElement getSelectedStudentCount;

	@FindBy(xpath = "//div[@class='Upcoming__Container__Body__ViewAll']")
	private WebElement btnViewAllClasses;

	@FindBy(xpath = "//div[@class='ScheduledClassCard']/descendant::div[@class='ScheduledClassCard__Body--Name']")
	private List<WebElement> countCreatedTrialClasses;

	@FindBy(xpath = "//div[@class='Upcoming__Container__Body__List--Item']")
	private List<WebElement> countTrialClasses;

	@FindBy(xpath = "//div[@class='Upcoming__Container__Body__List--Item']")
	private WebElement countTrialClass;

	@FindBy(xpath = "//div[@class='ScheduledClassCard__Body--Actions--Take']")
	private WebElement lblTakeClass;

	@FindBy(xpath = "//div[@class='startLiveClass']")
	private WebElement lblStartLiveClass;

	@FindBy(xpath = "//button[@class='Button ButtonEnd endLiveBtn']")
	private WebElement btnEndLiveClass;

	@FindBy(xpath = "(//div[@class='ScheduledClassCard__Body--Actions--Take'])[3]")
	private WebElement btnEditLiveClass;

	@FindBy(xpath = "//img[@class='Upcoming__Container__Top--Arrow--ScrollRight']")
	private WebElement btnRightScroll;

	@FindBy(xpath = "(//div[@class='ScheduledClassCard__Body--Actions--Take'])[4]")
	private WebElement lblLiveTakeClass;

	@FindBy(xpath = "//div[@class='UpcomingModal__FacultySelect']")
	private WebElement lblShowClassesByOtherFaculties;

	@FindBy(xpath = "//div[@class='courseContentCurrent']")
	private WebElement lblOverView;

	@FindBy(xpath = "//div[@class='ScheduledClassCard__Badges--Live']")
	private WebElement lblLiveNow;

	@FindBy(xpath = "//div[@class='publishPopupTitle']")
	private WebElement getCourse;

	@FindBy(xpath = "//div[@class='ui fitted toggle checkbox']")
	private WebElement tglFaculty;

	@FindBy(xpath = "//span[contains(text(),'Live Classes')]")
	private WebElement btnLiveClass;

	@FindBy(xpath = "//div[@class='LiveVideoTamplate__Left--Heading']")
	private WebElement lblLeftTakeTrial;

	@FindBy(xpath = "//div[@class='LiveVideoTamplate__Left--SubHeading']")
	private WebElement lblLeftPromoteSchedule;

	private static final Logger logger = Logger.getLogger(TutorTrialClassPage.class.getName());

	public TutorTrialClassPage(WebDriver driver) {
		super(driver);
		logger.info("Starting of TrailClassesPage method");

		PageFactory.initElements(driver, this);

		logger.info("Ending of TrailClassesPage method");

	}

	public void clickOnGoLive() {
		logger.info("Starting of clickOnGoLive method ");

		this.clickOnWebElement(btnGoLive);

		logger.info("Ending of clickOnGoLive method ");
	}

	public void clickOnPromoteGoLive() {
		logger.info("Starting of clickOnPromoteGoLive method ");

		this.clickOnWebElement(btnGoLivePromoteClass);

		logger.info("Ending of clickOnPromoteGoLive method ");
	}

	public void clickOnTrialClasses() {
		logger.info("Starting of clickOnTrialClasses method ");

		try {
			this.lblTrialClass.click();
		} catch (Exception e) {
			this.clickOnWebElement(lblTrialClass);

		}

		logger.info("Ending of clickOnTrialClasses method ");
	}

	public void clickOnScheduleClass() {
		logger.info("Starting of clickOnScheduleClass method");

		try {
			this.btnScheduleClass.click();
		} catch (Exception e) {
			this.clickOnWebElement(btnScheduleClass);

		}
		logger.info("Starting of clickOnScheduleClass method");

	}

	public String getTrialClassHeading() {
		logger.info("Starting of getTrialClassHeading method ");

		this.explicitWait(lblTrialClassHeading);

		logger.info("Ending of getTrialClassHeading method ");

		return this.lblTrialClassHeading.getText();
	}

	public void clickOnCloseModal() {
		logger.info("Starting of clickOnCloseModal method");

		try {
			this.btnLiveTrialCloseModal.click();
		} catch (Exception e) {
			this.clickOnWebElement(btnLiveTrialCloseModal);

		}
		logger.info("Starting of clickOnCloseModal method");

	}

	public void clickOnNotifyCloseModal() {
		logger.info("Starting of clickOnNotifyCloseModal method");

		try {
			this.btnNotifyClose.click();
		} catch (Exception e) {
			this.clickOnWebElement(btnNotifyClose);

		}
		logger.info("Ending of clickOnNotifyCloseModal method");

	}

	public String getTrialClassBanner() {
		logger.info("Starting of getTrialClassBanner method ");

		this.explicitWait(lblTrialClassBanner);

		logger.info("Ending of getTrialClassBanner method ");

		return this.lblTrialClassBanner.getText();
	}

	public String getCourseToPromote() {
		logger.info("Starting of getCourseToPromote method ");

		this.explicitWait(lblCourseToPromote);

		logger.info("Ending of getCourseToPromote method ");

		return this.lblCourseToPromote.getText();
	}

	public String getCourseName() {
		logger.info("Starting of getCourseName method ");

		this.explicitWait(lblCourseName);

		logger.info("Ending of getCourseName method ");

		return this.lblCourseName.getText();
	}

	public String getTopicText() {
		logger.info("Starting of getTopicText method ");

		this.explicitWait(lblTopic);

		logger.info("Ending of getTopicText method ");

		return this.lblTopic.getText();
	}

	public void setTopic(String strTopic) {
		logger.info("Starting of ClickOnTrialClasses method ");

		this.txtTopic.sendKeys(strTopic);

		logger.info("Ending of ClickOnTrialClasses method ");
	}

	public void setUpdateTopic(String strTopic) {
		logger.info("Starting of ClickOnTrialClasses method ");

		try {
			Thread.sleep(2000);
		} catch (Exception e) {
		}
		this.txtTopic.clear();
		this.txtTopic.sendKeys(strTopic);

		logger.info("Ending of ClickOnTrialClasses method ");
	}

	public String getWhoJoinClass() {
		logger.info("Starting of getWhoJoinClass method ");

		this.explicitWait(lblWhoJoin);

		logger.info("Ending of getWhoJoinClass method ");

		return this.lblWhoJoin.getText();
	}

	public void clickOnAddButton() {
		logger.info("Starting of clickOnAddButton method ");
		try {
			if (btnAdd.isDisplayed()) {
				this.btnAdd.click();
			}
		} catch (Exception e) {
			this.clickOnWebElement(btnAdd);
		}

		logger.info("Ending of clickOnAddButton method ");
	}

	public String getSelectStudentsText() {
		logger.info("Starting of getSelectStudentsText method ");

		this.explicitWait(lblSelectStudents);

		logger.info("Ending of getSelectStudentsText method ");

		return this.lblSelectStudents.getText();
	}

	public void clickOnSelectStudents() {
		logger.info("Starting of clickOnSelectStudents method ");

		this.rdoSelectStudents.click();

		logger.info("Ending of clickOnSelectStudents method ");
	}

	public void clickOnDone() {
		logger.info("Starting of clickOnDone method ");

		try {
			this.btnDone.click();

		} catch (Exception e) {
			this.clickOnWebElement(btnDone);
		}

		logger.info("Ending of clickOnDone method ");
	}

	public void clickOnCloseSelectStudent() {
		logger.info("Starting of clickOnCloseSelectStudent method ");

		try {
			this.btnCloseAdd.click();

		} catch (Exception e) {
			this.clickOnWebElement(btnCloseAdd);
		}

		logger.info("Ending of clickOnCloseSelectStudent method ");
	}

	public String getUpToDownloadsText() {
		logger.info("Starting of getUpToDownloadsText method ");

		this.explicitWait(txtUptoDownloads);

		logger.info("Ending of getUpToDownloadsText method ");

		return this.txtUptoDownloads.getText();
	}

	public String getSetDateText() {
		logger.info("Starting of getSetDateText method ");

		this.explicitWait(lblSetDate);

		logger.info("Ending of getSetDateText method ");

		return this.lblSetDate.getText();
	}

	public void clickOnSelectDate() {
		logger.info("Starting of clickOnSelectDate method ");

		this.dtpSelectDate.click();

		logger.info("Ending of clickOnSelectDate method ");
	}

	public void setDate() {
		logger.info("Starting of setDate method ");

		this.explicitWait(dtpToday);
		this.dtpToday.click();

		logger.info("Ending of setDate method ");
	}

	public String getSetTimeText() {
		logger.info("Starting of getSetTimeText method ");

		this.explicitWait(lblSetTime);

		logger.info("Ending of getSetTimeText method ");

		return this.lblSetDate.getText();
	}

	public void clickOnSelectTime() {
		logger.info("Starting of clickOnSelectTime method ");

		this.tmrSelectTime.click();

		logger.info("Ending of clickOnSelectTime method ");
	}

	public void setTime() {
		logger.info("Starting of setTime method ");
		
		for (int i = 1; i <= 2; i++) {
			Actions action=new Actions(driver);
			action.click(tmrSetTime).perform();
			//this.clickOnWebElement(tmrSetTime);
			// this.tmrSetTime.click();
		}
		logger.info("Ending of setTime method ");
	}

	public void setUpdateTime() {
		logger.info("Starting of setUpdateTime method ");

		this.tmrSetTime.click();

		logger.info("Ending of setUpdateTime method ");
	}

	public void clickOnScheduleForLater() {
		logger.info("Starting of clickOnScheduleForLater method ");

		this.btnScheduleforLater.click();

		logger.info("Ending of clickOnScheduleForLater method ");
	}

	public String getScheduledSuccessText() {
		logger.info("Starting of getSchedledSuccessText method ");

		this.explicitWait(lblScheduledSuccess);

		logger.info("Ending of getSchedledSuccessText method ");

		return this.lblScheduledSuccess.getText();
	}

	public String getScheduledText() {
		logger.info("Starting of getScheduledText method ");

		this.explicitWait(lblScheduled);

		logger.info("Ending of getScheduledText method ");

		return this.lblScheduled.getText();
	}

	public String getUpdatedScheduledCardName() {
		logger.info("Starting of getUpdatedScheduledCardName method ");

		this.explicitWait(lblScheduledBodyName);

		logger.info("Ending of getUpdatedScheduledCardName method ");

		return this.lblScheduledBodyName.getText();
	}

	public String getSelectTime() {
		logger.info("Starting of getSelectTime method ");

		this.explicitWait(tmrSelectTime);

		logger.info("Ending of getSelectTime method ");

		return this.tmrSelectTime.getAttribute("value").trim().toUpperCase();
	}

	public String getSelectDate() {
		logger.info("Starting of getSelectDate method ");

		this.explicitWait(dtpSelectDate);
		this.scrollIntoView(dtpSelectDate);

		logger.info("Ending of getSelectTime method ");

		return this.dtpSelectDate.getAttribute("value").trim();
	}

	public String getDateAndTimeText() {
		logger.info("Starting of getDateAndTimeText method ");

		this.explicitWait(dtpDateAndTime);

		logger.info("Ending of getDateAndTimeText method ");

		return this.dtpDateAndTime.getText();
	}

	public String getSchedultedCardTimeText() {
		logger.info("Starting of getDateAndTimeText method ");

		this.explicitWait(dtpDateAndTime);

		logger.info("Ending of getDateAndTimeText method ");

		return this.dtpDateAndTime.getText();
	}

	public void clickOnScheduledCard() {
		logger.info("Starting of clickOnScheduledCard method ");

		this.lblScheduledCard.click();

		logger.info("Ending of clickOnScheduledCard method ");
	}

	public void clickOnTakeClass() {
		logger.info("Starting of clickOnTakeClass method ");

		this.explicitWait(btnTakeClass);
		this.btnTakeClass.click();

		logger.info("Ending of clickOnTakeClass method ");
	}

	public String getTakeClassText() {
		logger.info("Starting of getTakeClassText method ");
		logger.info("Ending of getTakeClassText method ");

		return btnTakeClass.getText();
	}

	public String getTakeClassTxt() {
		logger.info("Starting of getTakeClassText method ");
		logger.info("Ending of getTakeClassText method ");

		return btnTakeClasses.getText();
	}

	public void clickOnTakeClassButton() {
		logger.info("Starting of clickOnTakeClass method ");

		this.explicitWait(lblTakeClass);
		this.lblTakeClass.click();

		logger.info("Ending of clickOnTakeClass method ");
	}

	public void clickOnUpdateTrialClass() {
		logger.info("Starting of clickOnUpdateTrialClass method ");

		this.explicitWait(btnUpdateTrialClasses);
		this.btnUpdateTrialClasses.click();

		logger.info("Ending of clickOnUpdateTrialClass method ");
	}

	public void clickOnDeleteTrialClass() {
		logger.info("Starting of clickOnDeleteTrialClass method ");

		try {
			this.btnDelete.click();
		} catch (Exception e) {
			this.clickOnWebElement(btnDelete);
		}

		logger.info("Ending of clickOnDeleteTrialClass method ");
	}

	public String getDeleteMessaage() {
		logger.info("Starting of getDeleteMessaage method ");

		this.explicitWait(txtDeleteMessage);

		logger.info("Ending of getDeleteMessaage method ");

		return this.txtDeleteMessage.getText();
	}

	public boolean isDispayedMicButton() {
		logger.info("Starting of isDispayedMicButton method ");
		logger.info("Ending of isDispayedMicButton method ");

		return btnMic.isDisplayed();
	}

	public boolean isDispalyedVideoButton() {
		logger.info("Starting of isDispalyedVideoButton method ");
		logger.info("Ending of isDispalyedVideoButton method ");

		return btnVideo.isDisplayed();
	}

	public boolean isDisplayedMicBtn() {
		logger.info("Starting of isDisplayedMicBtn method");

		this.explicitWait(btnMic);

		logger.info("Ending of isDisplayedMicBtn method");

		return btnMic.isDisplayed();
	}

	public boolean isDispalyedVideoBtn() {
		logger.info("Starting of getBtnMic method ");
		logger.info("Ending of getBtnMic method ");

		try {
			return btnVideo.isDisplayed();
		} catch (NoSuchElementException e) {
			return false;
		}
		// return btnVideo.isDisplayed();
	}

	public boolean isScheduledLiveClassesCardDisplayed() {
		logger.info("Starting of isScheduledLiveClassesCardDisplayed method ");
		logger.info("Ending of isScheduledLiveClassesCardDisplayed method ");

		try {
			return lblUpComingLiveClasses.isDisplayed();
		} catch (NoSuchElementException e) {
			return false;
		}
		// return lblUpComingLiveClasses.isDisplayed();
	}

	public String getAdminText() {
		logger.info("Starting of getAdminText method ");

		this.explicitWait(txtAdmin);

		logger.info("Ending of getAdminText method ");

		return this.txtAdmin.getText();
	}

	public String getGivenScheduleTime() {
		logger.info("Starting of getGivenScheduleTime method ");
		logger.info("Ending of getGivenScheduleTime method ");

		return tmrSelectTime.getAttribute("Value");
	}

	public String getScheduleTimeOnScheduleCard() {
		logger.info("Starting of getScheduleTimeOnScheduleCard method ");
		logger.info("Ending of getScheduleTimeOnScheduleCard method ");

		String dateAndTime = this.tmrScheduledTime.getText();
		String[] x = dateAndTime.split(" ");
		String time = (x[1] + x[2].replace("pm", "PM"));
		System.out.println("The Time is " + time);
		return time;
	}

	public String getHowItWorksText() {
		logger.info("Starting of getHowItWorksText method ");
		logger.info("Ending of getHowItWorksText method ");

		String text = this.txtHowItWorks.getText();
		String[] x = text.split(" ");
		String y = x[9] + " " + x[10] + " " + x[11];
		System.out.println("The text is " + y);

		return y;
	}

	public boolean isNewAppSelected() {
		logger.info("Starting of isNewAppDisplayed method ");
		logger.info("Ending of isNewAppDisplayed method ");

		return rdoNewAppDownloads.isSelected();
	}

	public boolean getStudentCount() throws InterruptedException {
		logger.info("Starting of getSuccessDocumentMessageText method");
		logger.info("Ending of getSuccessDocumentMessageText method");

		this.hardWait(3);
		String s = getSelectStudentCount.getText().substring(2);
		System.out.println(s);
		this.clickOnWebElement(btnDone);
		this.hardWait(5);
		String ss = getSelectedStudentCount.getText().substring(2);
		System.out.println(ss);

		if (s.equals(ss)) {
			return true;
		}
		return false;
	}

	public boolean getStudentDynamicalCount() throws InterruptedException {
		logger.info("Starting of getSuccessDocumentMessageText method");
		logger.info("Ending of getSuccessDocumentMessageText method");

		this.hardWait(3);
		String s = getSelectStudentCount.getText().substring(2);
		System.out.println(s);
		this.rdoNotPurchasedCourse.click();
		this.hardWait(3);
		String ss = getSelectStudentCount.getText().substring(2);
		System.out.println(ss);

		if (s != (ss)) {
			return true;
		}
		return false;
	}

	public boolean isEnabledHowItWorks() {
		logger.info("Starting of isEnabledHowItWorks method ");
		logger.info("Ending of isEnabledHowItWorks method ");

		return lblHowItWorks.isEnabled();
	}

	public void clickOnNotPurchasedCourse() {
		logger.info("Starting of clickOnNotPurchasedCourse method ");

		try {
			this.rdoNotPurchasedCourse.click();

		} catch (Exception e) {
			this.clickOnWebElement(rdoNotPurchasedCourse);
		}

		logger.info("Ending of clickOnNotPurchasedCourse method ");
	}

	public void clickOnTenDaysRadioButton() {
		logger.info("Starting of clickOnTenDays method ");

		try {
			this.rdoUptoTenDays.click();

		} catch (Exception e) {
			this.clickOnWebElement(rdoUptoTenDays);
		}

		logger.info("Ending of clickOnTenDays method ");
	}

	public void clickOnThirtyDaysRadioButton() {
		logger.info("Starting of clickOnThirtyDays method ");

		try {
			this.rdoUptoThirtyDays.click();

		} catch (Exception e) {
			this.clickOnWebElement(rdoUptoThirtyDays);
		}

		logger.info("Ending of clickOnThirtyDays method ");
	}

	public void clickOnNewAppDownload() {
		logger.info("Starting of clickOnNotPurchasedCourse method ");

		try {
			this.rdoNewAppDownloads.click();

		} catch (Exception e) {
			this.clickOnWebElement(rdoNewAppDownloads);
		}

		logger.info("Ending of clickOnNotPurchasedCourse method ");
	}

	public String getNotPurchasedCourse() {
		logger.info("Starting of getNotPurchasedCourse method ");
		logger.info("Ending of getNotPurchasedCourse method ");

		return msgNotPurchasedCourse.getText();
	}

	public String getNewAppDownloadsCourse() {
		logger.info("Starting of getNewAppDownloadsCourse method ");
		logger.info("Ending of getNewAppDownloadsCourse method ");

		return msgNewAppDownloads.getText();
	}

	public String getDesktopView() {
		logger.info("Starting of getDesktopView method ");
		logger.info("Ending of getDesktopView method ");

		return msgDesktopView.getText().substring(2);
	}

	public void clickOnAdvancedSettings() {
		logger.info("Starting of clickOnAdvancedSettings method ");

		try {
			this.btnAdvancedSettings.click();
		} catch (Exception e) {
			this.clickOnWebElement(btnAdvancedSettings);
		}

		logger.info("Ending of clickOnAdvancedSettings method ");
	}

	public void clickOnCourses() {
		logger.info("Starting of clickOnCourses method ");

		try {
			this.btnCourses.click();
		} catch (Exception e) {
			this.clickOnWebElement(btnCourses);
		}

		logger.info("Ending of clickOnCourses method ");
	}

	public boolean isSelectedDefaultCourse() {
		logger.info("Starting of isSelectedDefaultCourse method ");
		logger.info("Ending of isSelectedDefaultCourse method ");

		return chkDefaultCourse.isSelected();
	}

	public void clickOnSelectAllCourses() {
		logger.info("Starting of clickOnSelectAllCourses method ");

		try {
			this.btnSelectAll.click();
		} catch (Exception e) {
			this.clickOnWebElement(btnSelectAll);
		}

		logger.info("Ending of clickOnSelectAllCourses method ");
	}

	public void clickOnClearCourses() {
		logger.info("Starting of clickOnClearCourses method ");

		try {
			this.btnClear.click();
		} catch (Exception e) {
			this.clickOnWebElement(btnClear);
		}

		logger.info("Ending of clickOnClearCourses method ");
	}

	public void setSearchCourse(String strCourse) {
		logger.info("Starting of setSearchCourse method ");

		this.txtSearchCourse.sendKeys(strCourse);

		logger.info("Ending of setSearchCourse method ");
	}

	public String getSearchedCourse() {
		logger.info("Starting of getSearchedCourse method ");
		logger.info("Ending of getSearchedCourse method ");

		return txtSearchCourse.getAttribute("value");
	}

	public String getErrorTopicMessage() {
		logger.info("Starting of getErrorTopicMessage method ");
		logger.info("Ending of getErrorTopicMessage method ");
		this.explicitWait(msgTopicErrorToast);
		return msgTopicErrorToast.getText();
	}

	public void clickOnShowRecordToggle() {
		logger.info("Starting of clickOnShowRecordToggle method ");

		try {
			this.tglShowRecord.click();
		} catch (Exception e) {
			this.clickOnWebElement(tglShowRecord);
		}

		logger.info("Ending of clickOnShowRecordToggle method ");
	}

	public void clickOnSMSCheckbox() {
		logger.info("Starting of clickOnSMSCheckbox method ");

		try {
			this.chkSendSMS.click();
		} catch (Exception e) {
			this.clickOnWebElement(chkSendSMS);
		}

		logger.info("Ending of clickOnSMSCheckbox method ");
	}

	public void clickOnNotifyButton() {
		logger.info("Starting of clickOnSMSCheckbox method ");

		try {
			if (btnNotify.isDisplayed()) {
				this.btnNotify.click();
			}
		} catch (Exception e) {
			this.clickOnWebElement(btnNotify);
		}

		logger.info("Ending of clickOnSMSCheckbox method ");
	}

	public String getComposeNotificationHeader() {
		logger.info("Starting of getComposeNotificationHeader method ");
		logger.info("Ending of getComposeNotificationHeader method ");

		return composeNotificationHeader.getText();
	}

	public boolean getSelectedCoursesCount() {
		logger.info("Starting of getSelectedCoursesCount method");
		logger.info("Ending of getSelectedCoursesCount method");

		String ss = lblTotalCourses.getText().substring(9);

		String[] s = ss.split("/");
		String actualSelectedCheckBox = s[0];
		int i = 0;
		for (WebElement e : chkSelectedCourse) {
			if (e.isSelected()) {
				i++;
			} else {
				break;
			}
		}
		int actalSelectedcheckBoxOne = Integer.parseInt(actualSelectedCheckBox);
		if (i == actalSelectedcheckBoxOne) {
			return true;
		}
		return false;
	}

	public String getLandingScreenCourse() {
		logger.info("Starting of getLandingScreenCourse method ");
		logger.info("Ending of getLandingScreenCourse method ");

		return lblLandingScreenCourse.getText();
	}

	public String getTrialTopic() {
		logger.info("Starting of getTrialTopic method ");
		logger.info("Ending of getTrialTopic method ");
		this.explicitWait(txtTopic);
		return txtTopic.getText();
	}

	public String getOverviewTrialTopicName() {
		logger.info("Starting of getOverviewTrialTopicName method ");
		logger.info("Ending of getOverviewTrialTopicName method ");

		return lblOverviewTrialTopicName.getText();
	}

	public String getOverviewTrialLabel() {
		logger.info("Starting of getOverviewTrialLabel method ");
		logger.info("Ending of getOverviewTrialLabel method ");

		return lblOverviewTrial.getText();
	}

	public String getOverviewScheduledLabel() {
		logger.info("Starting of getOverviewScheduledLabel method ");
		logger.info("Ending of getOverviewScheduledLabel method ");

		return lblOverviewScheduled.getText();
	}

	public void clickOnDeleteTrialButton() {
		logger.info("Starting of clickOnDeleteTrialButton method ");

		try {
			if (btnDeleteTrialClass.isDisplayed()) {
				this.clickOnWebElement(btnDeleteTrialClass);

			}
		} catch (Exception e) {
			this.btnDeleteTrialClass.click();

		}

		logger.info("Ending of clickOnDeleteTrialButton method ");
	}

	public void clickOnDeleteLiveClass() {
		logger.info("Starting of clickOnDeleteLiveClass method ");

		try {
			this.lblStartLiveClass.click();
			this.btnEndLiveClass.click();

		} catch (Exception e) {
			if (btnDeleteTrialClass.isDisplayed()) {
				this.btnDeleteTrialClass.click();
			} else {
				this.clickOnWebElement(btnDeleteTrialClass);
			}
		}
		logger.info("Ending of clickOnDeleteLiveClass method ");
	}

	public void clickOnOverviewTrialButton() {
		logger.info("Starting of clickOnOverviewTrialButton method ");

		try {
			this.lblOverviewTrial.click();

		} catch (Exception e) {
			this.clickOnWebElement(lblOverviewTrial);
		}

		logger.info("Ending of clickOnOverviewTrialButton method ");
	}

	public String getDeleteTrialMessage() {
		logger.info("Starting of getDeleteTrialMessage method ");

		this.explicitWait(msgDeleteLiveClass);

		logger.info("Ending of getDeleteTrialMessage method ");
		return msgDeleteLiveClass.getText();
	}

	public void clickOnScheduledButton() {
		logger.info("Starting of clickOnScheduledButton method ");

		try {
			this.lblScheduled.click();
		} catch (Exception e) {
			this.clickOnWebElement(lblScheduled);
		}

		logger.info("Ending of clickOnScheduledButton method ");
	}

	public void clickOnUpdateTrialButton() {
		logger.info("Starting of clickOnUpdateTrialButton method ");

		try {
			if (btnUpdateTrialClass.isDisplayed()) {
				this.btnUpdateTrialClass.click();
			}
		} catch (Exception e) {
			this.clickOnWebElement(btnUpdateTrialClass);
		}

		logger.info("Ending of clickOnUpdateTrialButton method ");
	}

	public String getUpdateTrialMessage() {
		logger.info("Starting of getUpdateTrialMessage method ");

		this.explicitWait(msgUpdateLiveClass);

		logger.info("Ending of getUpdateTrialMessage method ");
		return msgUpdateLiveClass.getText();
	}

	public boolean isEnabledSelectStudents() {
		logger.info("Starting of isEnabledSelectStudents method");
		logger.info("Ending of isEnabledSelectStudents method ");

		return lblSelectStudent.isEnabled();
	}

	public String tomorrowDate() {
		logger.info("Starting of tomorrowDate method");
		logger.info("Ending of tomorrowDate method ");

		Calendar c = Calendar.getInstance();
		c.add(Calendar.DATE, 1);
		String tommorrow = new SimpleDateFormat("dd-MM-yyyy").format(c.getTime());
		return tommorrow;

	}

	public String tomorrowTime() {
		logger.info("Starting of tomorrowTime method");
		logger.info("Ending of tomorrowTime method ");

		Calendar c = Calendar.getInstance();
		c.add(Calendar.DATE, 1);
		String tommorrow = new SimpleDateFormat("h:mm aa").format(c.getTime());
		return tommorrow;

	}

	public String getViewAllClasses() {
		logger.info("Starting of getViewAllClasses method ");
		logger.info("Ending of getViewAllClasses method ");

		return btnViewAllClasses.getText();
	}

	public boolean getCountCreatedTrialClasses() {
		logger.info("Starting of getCountCreatedTrialClasses method");
		logger.info("Ending of getCountCreatedTrialClasses method");

		int sizeOfCreatedTrialClasses = countCreatedTrialClasses.size();

		this.btnViewAllClasses.click();

		int sizeOfTrialClasses = countTrialClasses.size();
		if (sizeOfCreatedTrialClasses == sizeOfTrialClasses) {
			return true;
		}
		System.out.println(countCreatedTrialClasses.size());
		return true;
	}

	public String getTakeClassLabel() {
		logger.info("Starting of getTakeClassLabel method ");

		this.explicitWait(lblTakeClass);

		logger.info("Ending of getTakeClassLabel method ");
		return lblTakeClass.getText();
	}

	public String getStartLiveClassLabel() {
		logger.info("Starting of getStartLiveClassLabel method ");
		logger.info("Ending of getStartLiveClassLabel method ");

		return lblStartLiveClass.getText();
	}

	public void clickOnEndLiveClass() {
		logger.info("Starting of clickOnEndLiveClass method ");

		this.explicitWait(lblStartLiveClass);
		this.lblStartLiveClass.click();
		this.explicitWait(btnEndLiveClass);
		this.btnEndLiveClass.click();

		logger.info("Ending of clickOnEndLiveClass method ");
	}

	public void clickOnViewAllClassButton() {
		logger.info("Starting of clickOnViewAllClassButton method ");

		try {
			this.btnViewAllClasses.click();

		} catch (Exception e) {
			this.clickOnWebElement(btnViewAllClasses);
		}

		logger.info("Ending of clickOnViewAllClassButton method ");
	}

	public String getOverViewLabelText() {
		logger.info("Starting of getOverViewLabelText method");
		logger.info(" Ending of getOverViewLabelText method");

		return lblOverView.getText();
	}

	public void clickOnEditLiveClassButton() {
		logger.info("Starting of clickOnEditLiveClassButton method ");

		try {
			this.btnEditLiveClass.click();

		} catch (Exception e) {
			this.clickOnWebElement(btnEditLiveClass);
		}

		logger.info("Ending of clickOnEditLiveClassButton method ");
	}

	public void clickOnLiveTakeClassButton() {
		logger.info("Starting of clickOnLiveTakeClassButton method ");

		try {
			this.lblLiveTakeClass.click();

		} catch (Exception e) {
			this.clickOnWebElement(lblLiveTakeClass);
		}

		logger.info("Ending of clickOnLiveTakeClassButton method ");
	}

	public void clickOnScrollRightButton() {
		logger.info("Starting of clickOnScrollRightButton method ");

		try {
			if (this.btnRightScroll.isDisplayed()) {
				this.btnRightScroll.click();
			}

		} catch (Exception e) {
			this.clickOnWebElement(btnRightScroll);
		}

		logger.info("Ending of clickOnScrollRightButton method ");
	}

	public String getFacultyClassesLabel() {
		logger.info("Starting of getFacultyClassesLabel method ");
		logger.info("Ending of getFacultyClassesLabel method ");

		return lblShowClassesByOtherFaculties.getText();
	}

	public boolean getFacultyClassesToggle() {
		logger.info("Starting of getFacultyClassesToggle method ");
		logger.info("Ending of getFacultyClassesToggle method ");
		try {
			lblShowClassesByOtherFaculties.isDisplayed();
			return false;
		} catch (Exception e) {
			return true;
		}

	}

	public boolean getFacultyClassesToggleAfterAddingTheFaculty() {
		logger.info("Starting of getFacultyClassesToggleAfterAddingTheFaculty method ");
		logger.info("Ending of getFacultyClassesToggleAfterAddingTheFaculty method ");
		try {
			lblShowClassesByOtherFaculties.isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public String getLiveNowLabel() {
		logger.info("Starting of getLiveNowLabel method ");
		logger.info("Ending of getLiveNowLabel method ");

		return lblLiveNow.getText();
	}

	public boolean isDisplayedLiveNowLabel() {
		logger.info("Starting of isDisplayedLiveNowLabel method ");
		logger.info("Ending of isDisplayedLiveNowLabel method ");

		try{
			lblLiveNow.isDisplayed();
		
			return true;
		}catch (NoSuchElementException e) {
			return false;
		}
	}

	public String getCourseLabel() {
		logger.info("Starting of getCourseLabel method ");
		logger.info("Ending of getCourseLabel method ");

		return getCourse.getText();
	}

	public void clickOnLiveNow() {
		logger.info("Starting of clickOnLiveNow method ");

		try {
			this.lblLiveNow.click();
		} catch (Exception e) {
			this.clickOnWebElement(lblLiveNow);
		}

		logger.info("Ending of clickOnLiveNow method ");
	}

	public boolean getAddFacultyToggle() {
		logger.info("Starting of getAddFacultyToggle method ");
		logger.info("Ending of getAddFacultyToggle method ");

		int s = this.countCreatedTrialClasses.size();
		this.tglFaculty.click();
		int ss = this.countCreatedTrialClasses.size();
		if (s + 3 == ss) {
			return true;
		}
		return false;
	}

	public boolean getDeleteTrialsCount() {
		logger.info("Starting of getDeleteTrialsCount method ");
		logger.info("Ending of getDeleteTrialsCount method ");

		try {
			countTrialClass.isDisplayed();
			return false;
		} catch (Exception e) {
			return true;
		}
	}

	public void clickOnLiveClassTab() {
		logger.info("Starting of clickOnLiveClassTab method ");

		try {
			this.btnLiveClass.click();
		} catch (Exception e) {
			this.clickOnWebElement(btnLiveClass);
		}

		logger.info("Ending of clickOnLiveClassTab method ");
	}

	public String getLeftTakeTrialClassLabel() {
		logger.info("Starting of getLeftTakeTrialClassLabel method ");
		logger.info("Ending of getLeftTakeTrialClassLabel method ");

		return lblLeftTakeTrial.getText();
	}

	public String getPromoteScheduleLabel() {
		logger.info("Starting of getPromoteScheduleLabel method ");
		logger.info("Ending of getPromoteScheduleLabel method ");

		return lblLeftPromoteSchedule.getText();
	}
	public boolean isDisplayedScheduledLabel() {
		logger.info("Starting of isDisplayedScheduledLabel method ");
		logger.info("Ending of isDisplayedScheduledLabel method ");

		try{
			lblScheduled.isDisplayed();
		
			return true;
		}catch (Exception e) {
			return false;
		}
	}
}
