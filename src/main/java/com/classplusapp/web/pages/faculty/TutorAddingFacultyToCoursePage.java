package com.classplusapp.web.pages.faculty;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.classplusapp.web.pages.BaseClassplusAutomationPage;

public class TutorAddingFacultyToCoursePage extends BaseClassplusAutomationPage {

	@FindBy(xpath = "//div[@class='coownerEmptyText']/parent::div")
	private WebElement msgNotAddedInAnyCourses;

	@FindBy(xpath = "//div[@class='storeFacutlyAddbutton']")
	private WebElement btnAdd;

	@FindBy(xpath = "//div[@class='addFacultyHeader']")
	private WebElement lblAddFacultyHeader;

	@FindBy(xpath = "//input[@placeholder='Enter Name']")
	private WebElement txtFacultyName;

	@FindBy(xpath = "//input[@placeholder='Enter Mobile No.']")
	private WebElement txtFacultyMobileNumber;

	@FindBy(xpath = "//input[@placeholder='Enter Email']")
	private WebElement txtFacultyEmail;

	@FindBy(xpath = "//button[@class='addFacultyActionSave']")
	private WebElement btnAddFaculty;

	@FindBy(xpath = "//div[@class='closeprops']/img")
	private WebElement btnClose;

	@FindBy(xpath = "//div[@class='storeFacutlyElement']")
	private WebElement lblAddedFaculty;

	@FindBy(xpath = "//span[contains(@class,'Card_featuredCourseName')]")
	private WebElement lblAddedCourse;

	@FindBy(xpath = "//span[contains(text(),'faculty course')]")
	private WebElement getCourse;

	@FindBy(xpath = "//div[@class='storeFacutlyFooterButton']")
	private WebElement btnViewAll;

	@FindBy(xpath = "//div[@class='removeFacultyText']")
	private WebElement btnRemove;

	@FindBy(xpath = "//div[@class='removeFacultyHeaderText']")
	private WebElement headerRemoveConfirmation;

	@FindBy(xpath = "//button[@class='addFacultyActionSave']")
	private WebElement btnYesRemove;

	@FindBy(xpath = "(//div[@class='courseContentCurrent']/following-sibling::div/following-sibling::div/span)[1]")
	private WebElement lblLiveClass;

	@FindBy(xpath = "(//div[@class='ui item dropdown']//following-sibling::i[@class='ellipsis vertical icon'])[1]")
	private WebElement btnLiveClassThreeDotMenu;

	@FindBy(xpath = "//div[@class='menu transition visible']//following-sibling::span[contains(text(),'View Details')]")
	private WebElement btnLiveClassViewDetails;

	@FindBy(xpath = "//div[@class='LiveClassDetails__Container__Head--Title']")
	private WebElement lblLiveClassDetails;

	@FindBy(xpath = "//img[@alt='X']")
	private WebElement btnLiveClassClose;

	@FindBy(xpath = "//div[contains(@class,'LiveVideo_HeaderText')]")
	private WebElement getLiveClassCount;

	@FindBy(xpath = "//div[@class='LiveVideo_SingleContentContainer__3GYhJ']")
	private List<WebElement> getLiveClassesSize;

	@FindBy(xpath = "//div[@class='flexColumn']/span/preceding-sibling::span/../../../preceding-sibling::div/div/div/span/preceding-sibling::span")
	private List<WebElement> getContentSummaryCount;

	@FindBy(xpath = "//div[@class='freeContent-text']")
	private WebElement lblFreeContent;

	@FindBy(xpath = "//div[@class='publishPopupTitle']")
	private WebElement lblCourseTitle;

	@FindBy(xpath = "//div[@class='borderNone paddingmin']/img")
	private WebElement courseThumbnail;

	@FindBy(xpath = "//div[@class='flexrow cursorPointer posRel']")
	private WebElement imgLikes;

	@FindBy(xpath = "//div[@class='ShareModal__Content__Body--SocialList']/div")
	private List<WebElement> icnSocialList;

	@FindBy(xpath = "//button[@class='CourseShareButton']")
	private WebElement btnShare;
	@FindBy(xpath = "(//span[@class='_advp _aeam']/img)[1]")
	private WebElement lblWhatsappHeader;

	@FindBy(xpath = "//div[@class='lfloat _ohe']/h2")
	private WebElement lblFacebookHeader;

	@FindBy(xpath = "//*[local-name()='svg']")
	private WebElement lblLinkedInHeader;

	@FindBy(xpath = "//span[contains(@class,'Card_featuredCourseName')]")
	private WebElement getAddedCourse;

	public TutorAddingFacultyToCoursePage(WebDriver driver) {
		super(driver);
		logger.info("Starting of TutorAddFacultyToCoursePage method");

		PageFactory.initElements(driver, this);

		logger.info("Ending of TutorAddFacultyToCoursePage method");

	}

	public String getNotAddedInAnyCoursesMessage() {
		logger.info("Starting of getNotAddedInAnyCoursesMessage method");
		logger.info("Ending of getNotAddedInAnyCoursesMessage method");

		return msgNotAddedInAnyCourses.getText();
	}

	public void clickOnAddButton() {
		logger.info("starting of clickOnAddButton  method");

		this.scrollIntoView(btnAdd);
		this.clickOnWebElement(btnAdd);

		logger.info("Ending of clickOnAddButton method");
	}

	public String getAddFacultyHeader() {
		logger.info("Starting of getAddFacultyHeader method");
		logger.info("Ending of getAddFacultyHeader method");

		return lblAddFacultyHeader.getText();
	}

	public void setfacultyName(String facultyName) {
		logger.info("Starting of setfacultyName method");

		this.txtFacultyName.sendKeys(facultyName);

		logger.info("Ending of setfacultyName method");
	}

	public void setFacultyMobileNumber(String FacultyMobileNumber) {
		logger.info("Starting of setFacultyMobileNumber method");

		this.txtFacultyMobileNumber.sendKeys(FacultyMobileNumber);

		logger.info("Ending of setFacultyMobileNumber method");
	}

	public void clickOnAddFacultyButton() {
		logger.info("starting of clickOnAddFacultyButton  method");

		this.clickOnWebElement(btnAddFaculty);

		logger.info("Ending of clickOnAddFacultyButton method");
	}

	public void clickOnCloseButton() {
		logger.info("starting of clickOnCloseButton  method");

		this.clickOnWebElement(btnClose);

		logger.info("Ending of clickOnCloseButton method");
	}

	public boolean getAddedFacultyLabel() {
		logger.info("starting of getAddedFacultyLabel  method");
		logger.info("starting of getAddedFacultyLabel  method");

		return lblAddedFaculty.isDisplayed();
	}

	public boolean getAddedCourseLabel() {
		logger.info("starting of getAddedCourseLabel  method");
		logger.info("starting of getAddedCourseLabel  method");

		return lblAddedCourse.isDisplayed();
	}

	public void clickOnGetCourseFolder() {
		logger.info("Starting of clickOnGetCourseFolder method");

		try {
			Thread.sleep(2000);
			// this.explicitWait(getCourse);
			this.getCourse.click();
		} catch (Exception e) {

			this.clickOnWebElement(getCourse);
		}

		logger.info("Ending of clickOnGetCourseFolder method");
	}

	public void clickOnViewAllButton() {
		logger.info("starting of clickOnViewAllButton  method");

		this.clickOnWebElement(btnViewAll);

		logger.info("Ending of clickOnViewAllButton method");
	}

	public void clickOnRemoveButton() {
		logger.info("starting of clickOnRemoveButton  method");

		this.clickOnWebElement(btnRemove);

		logger.info("Ending of clickOnRemoveButton method");
	}

	public String getRemoveConfirmationheader() {
		logger.info("starting of getRemoveConfirmationheader  method");
		logger.info("starting of getRemoveConfirmationheader  method");

		return headerRemoveConfirmation.getText();
	}

	public void clickOnYesRemoveButton() {
		logger.info("starting of clickOnYesRemoveButton  method");

		this.clickOnWebElement(btnYesRemove);

		logger.info("Ending of clickOnYesRemoveButton method");
	}

	public void clickOnLiveClass() {
		logger.info("Starting of clickOnLiveClass method");

		try {
			this.lblLiveClass.click();
		} catch (Exception e) {

			this.clickOnWebElement(lblLiveClass);
		}

		logger.info("Ending of clickOnLiveClass method");
	}

	public void clickOnLiveClassMenu() {
		logger.info("Starting of clickOnLiveClassMenu method");

		try {
			this.btnLiveClassThreeDotMenu.click();
		} catch (Exception e) {

			this.clickOnWebElement(btnLiveClassThreeDotMenu);
		}

		logger.info("Ending of clickOnLiveClassMenu method");
	}

	public String getLiveClassDetailsHeader() {
		logger.info("Starting of getLiveClassDetailsHeader method");
		logger.info("Ending of getLiveClassDetailsHeader method");

		return lblLiveClassDetails.getText();
	}

	public void clickOnViewLiveClassDetails() {
		logger.info("Starting of clickOnViewLiveClassDetails method");

		try {
			this.btnLiveClassViewDetails.click();
		} catch (Exception e) {

			this.clickOnWebElement(btnLiveClassViewDetails);
		}

		logger.info("Ending of clickOnViewLiveClassDetails method");
	}

	public void clickOnLiveClassClose() {
		logger.info("Starting of clickOnLiveClassClose method");

		try {
			this.btnLiveClassClose.click();
		} catch (Exception e) {

			this.clickOnWebElement(btnLiveClassClose);
		}

		logger.info("Ending of clickOnLiveClassClose method");
	}

	public boolean getCountLiveClass() {
		logger.info("Starting of getCountLiveClass method");
		logger.info("Ending of getCountLiveClass method");

		String liveClassCount = getLiveClassCount.getText().substring(14, 16);

		for (int i = 1; i <= 10; i++) {
			this.scrollDown(1000);
		}
		int i = 0;
		while (i < getLiveClassesSize.size()) {
			this.scrollDown(500);

			i++;
		}
		int liveClassesCount = Integer.parseInt(liveClassCount);
		int liveClasses = getLiveClassesSize.size();
		if (liveClassesCount == liveClasses) {
			return true;
		}

		return false;

	}

	public boolean getContentSummaryCount() {
		logger.info("Starting of getContentSummaryCount method");
		logger.info("Ending of getContentSummaryCount method");

		for (WebElement element : getContentSummaryCount) {
			String s = element.getText();
			int i = Integer.parseInt(s);

			if (!(i >= 1)) {
				return false;
			}
		}
		return true;
	}

	public String getFreeContentText() {
		logger.info("Starting of getFreeContentText method");
		logger.info("Ending of getFreeContentText method");

		return lblFreeContent.getText();
	}

	public String getCourseTitleText() {
		logger.info("Starting of getCourseTitleText method");
		logger.info("Ending of getCourseTitleText method");

		return lblCourseTitle.getText();
	}

	public boolean isDisplayedImageLikes() {
		logger.info("Starting of isDisplayedImageLikes method");
		logger.info("Ending of isDisplayedImageLikes method");

		return imgLikes.isDisplayed();
	}

	public boolean isDisplayedCourseThumbnail() {
		logger.info("Starting of isDisplayedCourseThumbnail method");
		logger.info("Ending of isDisplayedCourseThumbnail method");

		return courseThumbnail.isDisplayed();
	}

	public void clickOnShareButton() {
		logger.info("Starting of clickOnShareButton method");

		try {
			this.btnShare.click();
		} catch (Exception e) {

			this.clickOnWebElement(btnShare);
		}

		logger.info("Ending of clickOnShareButton method");
	}

	public void clickOnSocialListIcons() {
		logger.info("Starting of clickOnSocialListIcons method");

		for (WebElement ele : icnSocialList) {
			ele.click();
		}

		logger.info("Ending of clickOnSocialListIcons method");
	}

	public void switchToNewwindow() {
		logger.info("Starting of switchToNewWindow method");

		this.switchToNewWindow();

		logger.info("Ending of switchToNewWindow method");
	}

	public boolean getWhatsappHeader() {
		logger.info("Starting of getWhatsappHeader method");
		logger.info("Ending of getWhatsappHeader method");
		this.explicitWait(lblWhatsappHeader);
		return lblWhatsappHeader.isDisplayed();
	}

	public String getFacebookHeader() {
		logger.info("Starting of getFacebookHeader method");
		logger.info("Ending of getFacebookHeader method");
		this.explicitWait(lblFacebookHeader);

		return lblFacebookHeader.getText();
	}

	public boolean getLinkedInHeader() {
		logger.info("Starting of getLinkedInHeader method");
		logger.info("Ending of getLinkedInHeader method");
		this.explicitWait(lblLinkedInHeader);
		return lblLinkedInHeader.isDisplayed();
	}

	public void enterEmail(String email) {
		logger.info("Starting of enterEmail method");

		try {
			this.txtFacultyEmail.sendKeys(email);
		} catch (Exception e) {
			// this.clickOnWebElement(txtFacultyEmail);
		}

		logger.info("Ending of enterEmail method");
	}

	public void clickOnGetAdddedCourseFolder() {
		logger.info("Starting of clickOnGetAdddedCourseFolder method");

		try {
			Thread.sleep(2000);
			// this.explicitWait(getCourse);
			this.getAddedCourse.click();
		} catch (Exception e) {

			this.clickOnWebElement(getAddedCourse);
		}

		logger.info("Ending of clickOnGetAdddedCourseFolder method");
	}

}
