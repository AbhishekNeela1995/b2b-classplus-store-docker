package com.classplusapp.web.pages.tutor;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.classplusapp.web.pages.BaseClassplusAutomationPage;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;

public class TutorStudentSortingPage extends BaseClassplusAutomationPage {

	@FindBy(xpath = "//span[contains(text(),'2nd Course')]")
	private WebElement getCourse;

	@FindBy(xpath = "//div[@class='courseContentCurrent']")
	private WebElement lblOverView;

	@FindBy(xpath = "//span[text()='Students']")
	private WebElement btnStudents;

	@FindBy(xpath = "//span[text()='Student']")
	private WebElement labelStudentStatus;

	@FindBy(xpath = "//span[contains(text(),'Student')]/parent::div[@class=\"storeStudents__content--heading--item\"]/span")
	private WebElement mnuStudentIcon;

	@FindBy(xpath = "//span[contains(text(),'Enroll Date')]")
	private WebElement mnuEnrollDateIcon;

	@FindBy(xpath = "//span[contains(text(),'Expiry Date')]")
	private WebElement mnuExpiryDateIcon;

	@FindBy(xpath = "//span[contains(text(),'Price Paid')]")
	private WebElement mnuPricePaidIcon;

	@FindBy(xpath = "//span[contains(text(),'Payment Detail')]")
	private WebElement mnuPaymentDetailIcon;

	@FindBy(xpath = "//span[contains(text(),'Status')]")
	private WebElement mnuStatusIcon;

	@FindBy(xpath = "(//i[@class='ellipsis vertical icon'])[1]")
	private WebElement mnuVerticalIcon;

	@FindBy(xpath = "//input[@class='minWidthSearchInput']")
	private WebElement txtSearchStudent;

	@FindBy(xpath = "//span[@style='display: flex;']")
	private WebElement lblStudentName;

	@FindBy(xpath = "//span[@style='color: rgba(0, 0, 0, 0.6); font-size: 12px;']")
	private WebElement lblStudentMobileNumber;

	@FindBy(xpath = "//textarea[@type='text']")
	private WebElement txtMessageToStudent;

	@FindBy(xpath = "//i[@class='ellipsis vertical icon']")
	private WebElement btnKebab;

	@FindBy(xpath = "//div[contains(text(),'Message')]")
	private WebElement btnMessageToStudent;

	@FindBy(xpath = "//img[@class='input_right__2Z46_']")
	private WebElement btnSendMessage;

	@FindBy(xpath = "//span[contains(text(),'Manan')]")
	private WebElement lblStudentNameHeading;

	@FindBy(xpath = "//span[contains(text(),'Hi student')]")
	private WebElement lblMessage;

	private static final Logger logger = Logger.getLogger(TutorStudentSortingPage.class.getName());

	public TutorStudentSortingPage(WebDriver driver) {
		super(driver);
		logger.info("Starting of StudentSortingPage method");

		PageFactory.initElements(driver, this);

		logger.info("Ending of StudentSortingPage method");

	}

	public void clickOnCourseFolder() {
		logger.info("Starting of clickOnCourseFolder method");

		try {
			this.getCourse.click();
		} catch (Exception e) {
			this.clickOnWebElement(getCourse);

		}

		logger.info("Ending of clickOnCourseFolder method");
	}

	public String getOverViewLabelText() {
		logger.info("Starting of getOverViewLabelText method");
		logger.info(" Ending of getOverViewLabelText method");
		this.explicitWait(lblOverView);

		return this.lblOverView.getText();
	}

	public void clickOnStudentsButton() {
		logger.info("Starting of clickOnStudentsButton method");

		this.explicitWait(btnStudents);
		try {
			this.btnStudents.click();
		} catch (Exception e) {
			this.clickOnWebElement(btnStudents);
		}

		logger.info("Ending of clickOnStudentsButton method");
	}

	public String getStudentStatusLabelText() {
		logger.info("Starting of getStudentsLabelText method");
		logger.info(" Ending of getStudentsLabelText method");

		return labelStudentStatus.getText();
	}

	public void clickOnStudentsIcon() {
		logger.info("Starting of clickOnStudentsIcon method");

		this.clickOnWebElement(mnuStudentIcon);

		logger.info("Ending of clickOnStudentsIcon method");
	}

	public void clickOnEnrollDateIcon() {
		logger.info("Starting of clickOnEnrollDateIcon method");

		this.clickOnWebElement(mnuEnrollDateIcon);

		logger.info("Ending of clickOnEnrollDateIcon method");
	}

	public void clickOnExpiryDateIcon() {
		logger.info("Starting of clickOnExpiryDateIcon method");

		this.clickOnWebElement(mnuExpiryDateIcon);

		logger.info("Ending of clickOnExpiryDateIcon method");
	}

	public void clickOnPricePaidIcon() {
		logger.info("Starting of clickOnPricePaidIcon method");

		this.clickOnWebElement(mnuPricePaidIcon);

		logger.info("Ending of clickOnPricePaidIcon method");
	}

	public void clickOnPaymentDetailIcon() {
		logger.info("Starting of clickOnPaymentDetailIcon method");

		this.clickOnWebElement(mnuPaymentDetailIcon);

		logger.info("Ending of clickOnPaymentDetailIcon method");
	}

	public void clickOnStatusIcon() {
		logger.info("Starting of clickOnStatusIcon method");

		this.clickOnWebElement(mnuStatusIcon);

		logger.info("Ending of clickOnStatusIcon method");
	}

	public void clickOnMenuButton() {
		logger.info("Starting of clickOnMenuButton method");

		this.clickOnWebElement(mnuVerticalIcon);

		logger.info("Ending of clickOnMenuButton method");
	}

	public void setSearch(String Search) {
		logger.info("Starting of setSearch method");

		this.txtSearchStudent.sendKeys(Search);
		;

		logger.info("Ending of setSearch method");
	}

	public String getStudentNameLabel() {
		logger.info("Starting of getStudentNameLabel method");
		logger.info(" Ending of getStudentNameLabel method");

		return lblStudentName.getText();
	}

	public String getStudentMobileNumberLabel() {
		logger.info("Starting of getStudentMobileNumberText method");
		logger.info(" Ending of getStudentMobileNumberText method");

		return lblStudentMobileNumber.getText();
	}

	public void clickOnKebabButton() {
		logger.info("Starting of clickOnKebabButton method");

		this.clickOnWebElement(btnKebab);

		logger.info("Ending of clickOnKebabButton method");
	}

	public void clickOnMessageButton() {
		logger.info("Starting of clickOnKebabButton method");

		this.clickOnWebElement(btnMessageToStudent);

		logger.info("Ending of clickOnKebabButton method");
	}

	public void setMessage(String Search) {
		logger.info("Starting of setSearch method");
		this.txtMessageToStudent.click();
		this.txtMessageToStudent.sendKeys(Search);
		;

		logger.info("Ending of setSearch method");
	}

	public String getStudentNameHeading() {
		logger.info("Starting of getStudentNameHeading method");
		logger.info(" Ending of getStudentNameHeading method");

		return lblStudentNameHeading.getText();
	}

	public void clickOnSendButton() {
		logger.info("Starting of clickOnSendButton method");

		this.clickOnWebElement(btnSendMessage);

		logger.info("Ending of clickOnSendButton method");
	}

	public String getMessagelabel() {
		logger.info("Starting of getMessagelabel method");
		logger.info(" Ending of getMessagelabel method");

		return lblMessage.getText();
	}
}