package com.classplusapp.web.pages.tutor;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import com.classplusapp.web.pages.BaseClassplusAutomationPage;

public class TutorPayInInstallmentPage extends BaseClassplusAutomationPage {

	@FindBy(xpath = "//span[contains(text(),'B2b Installment')]")
	private WebElement btnGetCourse;

	@FindBy(xpath = "//input[@placeholder='Search for a course']")
	private WebElement txtSearch;

	private String courseXpath = "//div[@class='selectorCheat']//span[text()='${courseName}']";

	@FindBy(xpath = "//span[contains(text(),' Overview ')]")
	private WebElement lblOverview;

	@FindBy(xpath = "//div[text()='Create Installments']")
	private WebElement btnCreateInstallment;

	@FindBy(xpath = "//div[@class='modalContainer__modal__header']/child::div")
	private WebElement lblCreateInstallment;

	@FindBy(xpath = "//input[@placeholder='Course price']")
	private WebElement txtPrice;

	@FindBy(xpath = "//input[@value='12']")
	public WebElement txtInstallmentAmout;

	@FindBy(xpath = "//input[@id='totalInstallments']")
	private WebElement txtGiveInstallments;

	@FindBy(xpath = "//div[@class='createInstallmentModal__content__formContainer__form__input__installPriceInputContainer']/child::select")
	private WebElement txtSelectInstallmentPeriod;

	@FindBy(xpath = "//select[@id='installmentPeriod']")
	private WebElement inputInstallmentPeriod;

	@FindBy(xpath = "//option[contains(text(),'Bi-Weekly')]")
	private WebElement txtSelectBiWkly;

	@FindBy(xpath = "//option[@value='3']")
	private WebElement txtSelectMonth;

	@FindBy(xpath = "//div[@class='createInstallmentModal__content__formContainer__submit']/button")
	private WebElement btnCreateInstallment1;

	@FindBy(xpath = "//button[contains(text(),'Set Installments')]")
	private WebElement btnSetInstallment;

	@FindBy(xpath = "//div[contains(text(),'Installment saved successfully')]")
	private WebElement lblInstallmentSuccessMsg;

	/*
	 * @FindBy(xpath =
	 * "//div[@class='promptModalContainer__promptModal__crossIcon']") private
	 * WebElement btnDone;
	 */

	@FindBy(xpath = "//div[@class='introducingInstallmentOverlay__prompt__bottom']/button")
	private WebElement btnInstallmentGotItPopup;

	@FindBy(xpath = "//div[contains(text(),'View Installments')]")
	private WebElement btnViewInstallments;

	@FindBy(xpath = "//div[@class=\"modalContainer__modal__header__heading\"]")
	private WebElement lblInstallment;

	@FindBy(xpath = "//button[contains(text(),'Edit Installment')]")
	private WebElement btnEditInstallment;

	@FindBy(xpath = "//input[@placeholder='Course price']")
	private WebElement txtGivePrice;

	@FindBy(xpath = "//input[@id=\"totalInstallments\"]")
	private WebElement txtGiveInstallment;

	@FindBy(xpath = "//select[@id='installmentPeriod']")
	private WebElement txtSelectInstallmentType;

	@FindBy(xpath = "//option[contains(text(),'Monthly')]")
	private WebElement txtSelectMonthly;

	@FindBy(xpath = "//button[contains(text(),'Create Installments')]")
	private WebElement btnCreateInstallments;

	@FindBy(xpath = "//button[contains(text(),'Save Installments')]")
	private WebElement btnSaveInstallments;

	@FindBy(xpath = "//p[contains(text(),'Save Changes')]//following-sibling::button[contains(text(),'Save Installments')]")
	private WebElement lblSaveInstallments;

	@FindBy(xpath = "//div[@class='promptModalContainer__promptModal__crossIcon']")
	private WebElement btnDoneYes;

	@FindBy(xpath = "//div[contains(text(),'View Installments')]")
	private WebElement btnAgainViewInstallments;

	@FindBy(xpath = "//button[@class=\"viewInstallmentModal__content__installmentBreif__actions__button viewInstallmentModal__content__installmentBreif__actions__button--red\"]")
	private WebElement btnDeleteSymbol;

	@FindBy(xpath = "//button[contains(text(),'Yes, Delete')]")
	private WebElement lblDelete;

	@FindBy(xpath = "//div[contains(text(),'Installment removed successfully')]")
	private WebElement lblInstallmentRemovedMsg;

	@FindBy(xpath = "//div[contains(text(),'View Installments')]")
	private WebElement viewInstallmentsButton;

	@FindBy(xpath = "//button[@class=\"viewInstallmentModal__content__installmentBreif__actions__button viewInstallmentModal__content__installmentBreif__actions__button--red\"]")
	private WebElement deleteIcon;

	@FindBy(xpath = "//p[text()='Store']")
	private WebElement btnStore;

	@FindBy(xpath = "//p[contains(text(),'Delete Installment')]")
	private WebElement lblDeleteInstallments;

	@FindBy(xpath = "//button[contains(text(),'Yes, Delete')]")
	private WebElement btnYesDelete;

	@FindBy(xpath = "//button[@class=\"promptModalContainer__promptModal__button\"]")
	private WebElement btnDone;

	@FindBy(xpath = "//div[@class='rrt-title']")
	private WebElement msgEditSuccessful;

	@FindBy(xpath = "//label[@class='createInstallmentModal__content__formContainer__form__input__label']")
	private WebElement lblCoursePrice;

	@FindBy(xpath = "//label[@for='totalInstallments']")
	private WebElement lblTotalInstallment;

	@FindBy(xpath = "//span[@class='createInstallmentModal__content__formContainer__form__input__infoText__txtSpan']")
	private WebElement lblEffectiveCoursePrice;

	@FindBy(xpath = "//label[contains(text(),'Installment Period')]")
	private WebElement lblInstallmentPeriod;

	@FindBy(xpath = "//p[@class='createInstallmentModal__content__installmentDetails__headingContainer__heading']")
	private WebElement lblInstallmentDetails;

	@FindBy(xpath = "//p[@class='createInstallmentModal__content__installmentDetails__headingContainer__subHeading']")
	private WebElement lblInstallmentEffectivePrice;

	@FindBy(xpath = "//p[contains(text(),'1st Installment')]")
	private WebElement lbl1stInstallment;

	@FindBy(xpath = "//p[contains(text(),'Date of purchase (DOP)')]")
	private WebElement lblDateOfPurchase;

	@FindBy(xpath = "//p[contains(text(),'2nd Installment')]")
	private WebElement lbl2ndInstallment;

	@FindBy(xpath = "//p[contains(text(),'Important Information')]")
	private WebElement lblImportantInformation;

	@FindBy(xpath = "//li[contains(text(),'If a student misses any installments then that installment amount will be added to the next installment.')]")
	private WebElement lblMissedInstallments;

	@FindBy(xpath = "//li[contains(text(),'The student will lose course access till the time they pay the pending installment amount.')]")
	private WebElement lblLoseCourseText;

	@FindBy(xpath = "//li[contains(text(),'Coupons can�t be assigned on installments.')]")
	private WebElement lblCouponsCantAssigned;

	@FindBy(xpath = "//p[contains(text(),'Installments Created')]")
	private WebElement lblInstallmentsCreated;

	@FindBy(xpath = "//p[contains(text(),'Now students can buy this course with multiple installments.')]")
	private WebElement lblMultipleInstallmentsText;

	@FindBy(xpath = "//p[@class='viewInstallmentModal__content__installmentBreif__text__p1']")
	private WebElement lblStudentCanPayAmountInInstallment;

	@FindBy(xpath = "//p[@class='viewInstallmentModal__content__installmentBreif__text__p2']")
	private WebElement lblEditInstallment;

	@FindBy(xpath = "(//option[contains(text(),'Weekly')])[1]")
	private WebElement lblWeekly;

	@FindBy(xpath = "//option[contains(text(),'Every 6 Months')]")
	private WebElement lblEverySixMonths;

	@FindBys({
			@FindBy(xpath = "//div[@class='installmentDetailsRow false undefined']/child::div/following-sibling::div/child::input[@placeholder='Installment price']") })
	private List<WebElement> lblInstallmentPrice;

	@FindBys({ @FindBy(xpath = "//p[@class='installmentDetailsRow__installNum__installNumText__num']") })
	private List<WebElement> lblNumberOfInstallment;

	@FindBy(xpath = "//div[@class='createInstallmentModal__content__installmentDetails__details']")
	private List<WebElement> lblInstallments;

	@FindBy(xpath = "//p[@class='installmentDetailsRow__installNum__installNumText__date']")
	private List<WebElement> lblInstallmentPeriods;

	@FindBy(xpath = "//p[@class='introducingInstallmentOverlay__prompt__top__textContainer__heading']")
	private WebElement msgInformation;

	@FindBy(xpath = "//button[@class='introducingInstallmentOverlay__prompt__bottom__button']")
	private WebElement lblGotIt;

	@FindBy(xpath = "//div[@id='root']/div/div/div/div/div[@class='innerCourse__grid']/div[@class='courseLeftPanel']/div[@class='ui blue pointing secondary vertical left fixed fullscreen-position-static menu']/div/div[@class='courseContent']/div[1]")
	private WebElement btnOverView;

	@FindBy(xpath = "//span[@class='createInstallmentModal__content__formContainer__form__input__installPriceInputContainer__installPriceInputError']")
	private WebElement msgErrorMaxInstallments;

	@FindBy(xpath = "//img[@class='modalContainer__modal__header__image']")
	private WebElement btnCloseContainer;

	@FindBys({ @FindBy(xpath = "//select[@id='installmentPeriod']//option//following-sibling::option") })
	private List<WebElement> lblInstallmentEnablePeriod;

	@FindBys({ @FindBy(xpath = "//input[@placeholder='Installment price']") })
	private List<WebElement> txtEditInstallmentPrice;

	@FindBy(xpath = "//input[@class='installmentDetailsRow__installPriceInputContainer__installPriceInput installmentDetailsRow--4']")
	private WebElement lblLastEditInstallment;

	@FindBy(xpath = "//select[@id='installmentPeriod']")
	private WebElement lblMonthlyPeriod;

	@FindBys({

			@FindBy(xpath = "//div[@class='installmentDetailsRow false undefined']/div[@class='installmentDetailsRow__installNum']/following-sibling::div/input") })
	private List<WebElement> txtEditEqualInstallmentPrice;

	/*
	 * @FindBys({
	 * 
	 * @FindBy(xpath =
	 * "//div[@class='installmentDetailsRow false undefined']/following-sibling::div/div/following-sibling::div//input"
	 * ) }) private List<WebElement> txtEditEqualInstallmentPrice;
	 */

	@FindBy(xpath = "//input[@class='installmentDetailsRow__installPriceInputContainer__installPriceInput installmentDetailsRow--1']")
	private WebElement lblFirstEditInstallment;

	@FindBy(xpath = "//span[@class='createInstallmentModal__content__formContainer__form__input__infoText__txtSpan__moneyBold']")
	private WebElement lblEffectivePrice;

	@FindBy(xpath = "//span[@class='createInstallmentModal__content__formContainer__form__input__installPriceInputContainer__installPriceInputError2']")
	private WebElement msgErrorZeroInstallments;

	@FindBy(xpath = "//div[contains(text(),'Course Deleted Successfully')]")
	private WebElement msgDeleteCourse;

	@FindBy(xpath = "//span[contains(text(),'Ankita')]/parent::span//parent::div/following-sibling::div[@class='storeStudent__content--list--item storeStudents__grid__installmentColumn']")
	private WebElement lblPendingPayment;

	@FindBy(xpath = "//span[contains(text(),'Ankita')]/parent::span//parent::div/following-sibling::div[@class='storeStudent__content--list--item storeStudents__grid__installmentColumn']//following-sibling::div//div/span")
	private WebElement lblInactiveStatus;

	@FindBy(xpath = "//span[contains(text(),'UGAOGYMF')]/parent::span//parent::div/following-sibling::div[@class='storeStudent__content--list--item undefined']")
	private WebElement lblFullPayment;

	@FindBy(xpath = "//span[contains(text(),'UGAOGYMF')]/parent::span//parent::div/following-sibling::div[@class='storeStudent__content--list--item undefined']//following-sibling::div/div/span")
	private WebElement lblActiveStatus;

	@FindBy(xpath = "//span[contains(text(),'Payment Detail')]")
	private WebElement lblPaymentDetails;

	@FindBy(xpath = "//div[@class='installmentDetailsRow__installNum']//div/img/parent::div")
	private WebElement lblGreenColor;

	@FindBy(xpath = "(//div[@class='installmentDetailsRow__installNum__installNumText'])[1]//parent::p/following-sibling::p")
	private WebElement lblPaidDate;

	@FindBy(xpath = "//p[contains(text(),'2nd Installment')]//child::span[@class='installmentDetailsRow__installNum__installmentBadge']")
	private WebElement lblPendingStatus;

	@FindBy(xpath = "//p[contains(text(),'2nd Installment')]//following-sibling::p")
	private WebElement lblPendingDate;

	@FindBy(xpath = "//p[contains(text(),'6th Installment')]//child::span[@class='installmentDetailsRow__installNum__installmentBadge']")
	private WebElement lblDueStatus;

	@FindBy(xpath = "//p[contains(text(),'6th Installment')]//following-sibling::p")
	private WebElement lblDueDate;

	@FindBy(xpath = "//img[@class='modalContainer__modal__header__image']")
	private WebElement btnClosePurchaseInInstallments;

	@FindBy(xpath = "//select[@id='installmentPeriod']")
	private WebElement lblInstallmentPeriodOption;

	@FindBy(xpath = "//div[@class='tooltipComponent']")
	private WebElement effectivePriceIcon;

	@FindBy(xpath = "//div[@class='tooltipComponent__tooltipText']")
	private WebElement effectivePriceText;

	@FindBy(css = ".storeStudents__content--heading--item:nth-child(1) span")
	private WebElement studentSort;
	
	private static final Logger logger = Logger.getLogger(TutorPayInInstallmentPage.class.getName());

	public TutorPayInInstallmentPage(WebDriver driver) {
		super(driver);
		logger.info("Starting of TutorPayInInstallmentPage method");

		PageFactory.initElements(driver, this);

		logger.info("Ending of TutorPayInInstallmentPage method");
	}

	public void clickOnCourse() {
		logger.info("Starting of ClickOnCourse");

		waitForElementVisibilty(btnGetCourse);
		this.btnGetCourse.click();

		logger.info("Ending of ClickOnCourse");
	}

	public String getOverviewLabel() {
		logger.info("Starting of getOverviewLabel method");
		logger.info("Ending of getOverviewLabel method");

		return lblOverview.getText();

	}

	public void clickOnStoreButton() {
		logger.info("starting of clickOnStoreButton method");

		try {
			Thread.sleep(2000);
			this.btnStore.click();
		} catch (Exception e) {
			this.clickOnWebElement(btnStore);
		}

		logger.info("Ending of clickOnStoreButton method");
	}

	public void setSearch(String strSearch) {
		logger.info("Starting of setSearch method");

		this.txtSearch.sendKeys(strSearch);

		logger.info("Ending of setSearchArea method");
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

	public void closeInstallmentGotItPopup() {
		logger.info("Starting of closeInstallmentGotItPopup method");

		try {
			this.btnInstallmentGotItPopup.click();
		} catch (Exception e) {
			this.clickOnWebElement(btnInstallmentGotItPopup);
		}

		logger.info("Ending of closeInstallmentGotItPopup method");
	}

	public void clickOnCreateInstallment() {
		logger.info("Starting of ClickOnCreateInstallment method");

		try {
			this.btnCreateInstallment.click();
		} catch (Exception e) {
			this.clickOnWebElement(btnCreateInstallment);
		}

		logger.info("Ending of ClickOnCreateInstallment method");
	}

	public String getPriceLabel() {
		logger.info("Starting of getpriceLabel method");

		this.explicitWait(txtPrice);

		logger.info("Ending of getpriceLabel method");
		return txtPrice.getAttribute("value");

	}

	public String getInstallmentAmountLabel() {
		logger.info("Starting of getInstallmentAmountLabel method");
		logger.info("Ending of getInstallmentAmountLabel method");

		return txtInstallmentAmout.getText();

	}

	public String getCreateInstallmentLabel() {
		logger.info("Starting of getCreateInstallmentLabel method");
		logger.info("Ending of getCreateInstallmentLabel method");
		return lblCreateInstallment.getText();

	}

	public void giveInstallments(String Installments) {
		logger.info("Starting of GiveInstallments");

		this.txtGiveInstallments.sendKeys(Installments);

		logger.info("Ending of GiveInstallments");
	}

	public void setCoursePriceInstallments(String priceInstallments) {
		logger.info("Starting of setCoursePriceInstallments method");

		this.txtPrice.clear();
		this.txtPrice.sendKeys(priceInstallments);

		logger.info("Ending of setCoursePriceInstallments method");
	}

	public void selectInstallmentPeriod() {
		logger.info("Starting of SelectInstallmentPeriod");

		this.explicitWait(txtSelectInstallmentPeriod);
		this.txtSelectInstallmentPeriod.click();

		logger.info("Ending of SelectInstallmentPeriod");
	}

	public void clickOnInstallmentPeriodInput() {
		logger.info("starting of clickOnInstallmentPeriodInput");
		try {
			this.inputInstallmentPeriod.click();

		} catch (Exception e) {
			this.clickOnWebElement(this.inputInstallmentPeriod);
		}
		logger.info("ending of clickOnInstallmentPeriodInput");

	}

	public void selectBiWeekly() {
		logger.info("Starting of selectBiWkly");

		this.txtSelectBiWkly.click();

		logger.info("Ending of selectBiWkly");
	}

	public void clickOnCreateInstallmentButton() {
		logger.info("Starting of ClickOnCreateInstallmentButton");
		try {
			this.clickOnWebElement(btnCreateInstallment1);
		} catch (Exception e) {
			this.btnCreateInstallment1.click();
		}

		logger.info("Ending of ClickOnCreateInstallmentButton");
	}

	public void clickOnSetInstallmentButton() throws InterruptedException {
		logger.info("Starting of ClickOnSetInstallmentButton");

//		this.scrollDown(700);
		try {
			this.btnSetInstallment.click();
		} catch (Exception e) {
			this.clickOnWebElement(this.btnSetInstallment);
		}

		logger.info("Ending of ClickOnSetInstallmentButton");
	}

	public String getInstallmentSuccessMsg() {
		logger.info("Starting of InstallmentSuccessMsg");

		logger.info("Ending of InstallmentSuccessMsg");
		return lblInstallmentSuccessMsg.getText();
	}

	public void clickOnDoneButton() {
		logger.info("Starting of ClickDoneButton");

		this.explicitWait(btnDone);
		this.clickOnWebElement(btnDone);

		logger.info("Ending of ClickDoneButton");
	}

	public void clickOnMonthlyoption() {
		logger.info("Starting of clickOnMonthlyoption method");

		this.btnCreateInstallment1.click();

		logger.info("Ending of clickOnMonthlyoption method");
	}

	public void clickViewInstallments() {
		logger.info("Starting of ClickViewInstallments method");

		try {
			this.btnViewInstallments.click();
		} catch (Exception e) {
			this.clickOnWebElement(btnViewInstallments);
			e.printStackTrace();
		}

		logger.info("Ending of ClickViewInstallments method");
	}

	public String getInstallmentLabel() {
		logger.info("Starting of getInstallmentLabel method");

		logger.info("Ending of getInstallmentLabel method");
		return lblInstallment.getText();

	}

	public void clickEditInstallment() {
		logger.info("Starting of ClickEditInstallment");

		this.clickOnWebElement(btnEditInstallment);

		logger.info("Ending of ClickEditInstallment");
	}

	public void givePriceOnField(String enterPrice) {
		logger.info("Starting of GivePriceOnField");

		this.txtGivePrice.sendKeys(Keys.DELETE);
		this.txtGivePrice.sendKeys(Keys.CONTROL + "a");
		this.clickOnWebElement(txtGivePrice);
		this.txtGivePrice.sendKeys(enterPrice);

		logger.info("Ending of GivePriceOnField");
	}

	public void giveInstallment(String giveInstallment) {
		logger.info("Starting of GiveInstallment");

		this.txtGiveInstallment.sendKeys(Keys.DELETE);
		this.txtGiveInstallment.sendKeys(Keys.CONTROL + "a");
		this.clickOnWebElement(txtGiveInstallments);
		this.txtGiveInstallment.sendKeys(giveInstallment);

		logger.info("Ending of GiveInstallment");
	}

	public void selectInstallmentType() {
		logger.info("Starting of selectInstallmentType method");

		this.clickOnWebElement(txtSelectInstallmentType);

		logger.info("Ending of selectInstallmentType method");
	}

	public void selectAsMonthly() {
		logger.info("Starting of SelectMonthly");

		waitForElementVisibilty(txtSelectMonthly);
		this.txtSelectMonthly.click();

		logger.info("Ending of selectMonthly");
	}

	public void clickOnEditCreateInstall() {
		logger.info("Starting of clickOnEditCreateInstall");

		this.btnCreateInstallments.click();

		logger.info("Ending of clickOnEditCreateInstall");
	}

	public void clickOnSaveInstallmentButton() {
		logger.info("Starting of ClickOnSetInstallmentButton");
		try {
			this.explicitWait(btnSaveInstallments);
			this.btnSaveInstallments.click();
		} catch (Exception e) {
			this.clickOnWebElement(btnSaveInstallments);

		}

		logger.info("Ending of ClickOnSetInstallmentButton");
	}

	public void clickOnSaveInstallmentButton2() {
		logger.info("Starting of ClickOnSetInstallmentButton");

		try {
			this.explicitWait(this.lblSaveInstallments);
			this.lblSaveInstallments.click();
		} catch (Exception e) {
			this.clickOnWebElement(lblSaveInstallments);
		}

		logger.info("Ending of ClickOnSetInstallmentButton");
	}

	public void clickViewInstallmentsButton() throws InterruptedException {
		logger.info("Starting of clickViewInstallmentsButton method");

		Thread.sleep(2000);

		waitForElementVisibilty(viewInstallmentsButton);
		this.clickOnWebElement(viewInstallmentsButton);

		logger.info("Ending of clickViewInstallmentsButton method");
	}

	public void clickOnDeleteIcon() {
		logger.info("Starting of clickOnDeleteIcon method");

		this.deleteIcon.click();

		logger.info("Ending of clickOnDeleteIcon method");
	}

	public String getDeleteInstallmentLabel() {
		logger.info("Starting of getDeleteInstallmentLabel method");
		logger.info("Ending of getDeleteInstallmentLabel method");

		return lblDeleteInstallments.getText();

	}

	public void clickonYesDelete() throws InterruptedException {
		logger.info("Starting of ClickOnSetInstallmentButton");

		this.btnYesDelete.click();

		logger.info("Ending of ClickOnSetInstallmentButton");
	}

	public String getCoursePriceLabel() {
		logger.info("Starting of getCoursePriceLabel method");

		this.explicitWait(lblCoursePrice);

		logger.info("Ending of getCoursePriceLabel method");
		return lblCoursePrice.getText();

	}

	public String getTotalInstallmentLabel() {
		logger.info("Starting of getTotalInstallmentLabel method");

		this.explicitWait(lblTotalInstallment);

		logger.info("Ending of getTotalInstallmentLabel method");
		return lblTotalInstallment.getText();

	}

	public String getEffectiveCoursePriceLabel() {
		logger.info("Starting of getEffectiveCoursePriceLabel method");

		this.explicitWait(lblEffectiveCoursePrice);

		logger.info("Ending of getEffectiveCoursePriceLabel method");
		return lblEffectiveCoursePrice.getText();

	}

	public String getInstallmentPeriodLabel() {
		logger.info("Starting of getInstallmentPeriodLabel method");

		this.explicitWait(lblInstallmentPeriod);

		logger.info("Ending of getInstallmentPeriodLabel method");
		return lblInstallmentPeriod.getText();

	}

	public String getInstallmentDetailsLabel() {
		logger.info("Starting of getInstallmentDetailsLabel method");

		this.explicitWait(lblInstallmentDetails);

		logger.info("Ending of getInstallmentDetailsLabel method");
		return lblInstallmentDetails.getText();

	}

	public String getInstallmentEffectivePriceLabel() {
		logger.info("Starting of getInstallmentEffectivePriceLabel method");

		this.explicitWait(lblInstallmentEffectivePrice);

		logger.info("Ending of getInstallmentEffectivePriceLabel method");
		return lblInstallmentEffectivePrice.getText();

	}

	public String get1stInstallmentLabel() {
		logger.info("Starting of get1stInstallmentLabel method");

		this.explicitWait(lbl1stInstallment);

		logger.info("Ending of get1stInstallmentLabel method");
		return lbl1stInstallment.getText();

	}

	public String getDateOfPurchaseLabel() {
		logger.info("Starting of getDateOfPurchaseLabel method");

		this.scrollDown(300);
		this.explicitWait(lblDateOfPurchase);

		logger.info("Ending of getDateOfPurchaseLabel method");
		return lblDateOfPurchase.getText();

	}

	public String get2ndInstallmentLabel() {
		logger.info("Starting of get2ndInstallmentLabel method");

		this.explicitWait(lbl2ndInstallment);

		logger.info("Ending of get2ndInstallmentLabel method");
		return lbl2ndInstallment.getText();

	}

	public String getImportantInformationLabel() {
		logger.info("Starting of get3rdInstallmentLabel method");

		this.explicitWait(lblImportantInformation);

		logger.info("Ending of get3rdInstallmentLabel method");
		return lblImportantInformation.getText();

	}

	public String getMissedInstallmentsLabel() {
		logger.info("Starting of getMissedInstallmentsLabel method");

		this.explicitWait(lblMissedInstallments);

		logger.info("Ending of getMissedInstallmentsLabel method");
		return lblMissedInstallments.getText();

	}

	public String getLoseCourseTextLabel() {
		logger.info("Starting of getLoseCourseTextLabel method");

		this.scrollIntoView(lblLoseCourseText);

		logger.info("Ending of getLoseCourseTextLabel method");
		return lblLoseCourseText.getText();

	}

	public String getCouponsCantAssignedLabel() {
		logger.info("Starting of getCouponsCantAssignedLabel method");

		this.explicitWait(lblCouponsCantAssigned);

		logger.info("Ending of getCouponsCantAssignedLabel method");
		return lblCouponsCantAssigned.getText();

	}

	public String getInstallmentsCreatedLabel() {
		logger.info("Starting of getInstallmentsCreatedLabel method");

		this.explicitWait(lblInstallmentsCreated);

		logger.info("Ending of getInstallmentsCreatedLabel method");
		return lblInstallmentsCreated.getText();

	}

	public String getMultipleInstallmentsText() {
		logger.info("Starting of getMultipleInstallmentsText method");

		this.explicitWait(lblMultipleInstallmentsText);

		logger.info("Ending of getMultipleInstallmentsText method");
		return lblMultipleInstallmentsText.getText();

	}

	public String getStudentCanPayAmountInInstallmentLabel() {
		logger.info("Starting of getStudentCanPayAmountInInstallmentLabel method");

		this.explicitWait(lblStudentCanPayAmountInInstallment);

		logger.info("Ending of getStudentCanPayAmountInInstallmentLabel method");
		return lblStudentCanPayAmountInInstallment.getText();

	}

	public String getEditInstallmentText() {
		logger.info("Starting of getEditInstallmentText method");

		this.explicitWait(lblEditInstallment);

		logger.info("Ending of getEditInstallmentText method");
		return lblEditInstallment.getText();

	}

	public boolean getCreateInstallment() {
		logger.info("Starting of getCreateInstallment method");
		logger.info("Ending of getCreateInstallment method");

		try {
			return btnCreateInstallment.isDisplayed();
		} catch (NoSuchElementException e) {
			return false;

		}
	}

	public boolean isDisplayedCreateInstallment() {
		logger.info("Starting of isDisplayedCreateInstallment method");
		logger.info("Ending of isDisplayedCreateInstallment method");

		return btnCreateInstallment.isDisplayed();
	}

	public boolean setMonthlyInstallmentPrice(String strEnterPrice, String strInstallment) {
		logger.info("Starting of setMonthlyInstallmentPrice method");
		logger.info("Ending of setMonthlyInstallmentPrice method");
		try {
			Thread.sleep(5000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Double k = Double.parseDouble(strEnterPrice);
		Double l = Double.parseDouble(strInstallment);
		Double j = k / l;

		if (!(lblInstallmentPrice.size() == Integer.parseInt(strInstallment)))
			return false;
		for (WebElement price : lblInstallmentPrice) {
			if (!(j == Double.parseDouble(price.getAttribute("value")))) {
				return false;
			}
		}
		return true;
	}

	public boolean numberOfInstallments() {
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
		}
		for (int i = 0; i < lblNumberOfInstallment.size(); i++) {
			if (!(lblNumberOfInstallment.get(i).getText().contains("Installment"))) {
				return false;
			}
		}
		String[] valueArray = new String[4];
		String value = null;
		String a = null;
		int installmentValue = 0;

		StringBuilder builder = null;

		for (int i = 0; i < lblNumberOfInstallment.size(); i++) {

			valueArray = lblNumberOfInstallment.get(i).getText().split("\\D");
			value = valueArray[0];
			installmentValue = i;
			installmentValue++;
			a = String.valueOf(installmentValue);
			if (!(a.contains(value))) {
				return false;
			}

		}
		return true;
	}

	public boolean getInstallmentsLabel(String Installments) {
		logger.info("Starting of getInstallmentsLabel method");
		logger.info("Ending of getInstallmentsLabel method");
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
		}
		for (WebElement element : lblNumberOfInstallment) {
			System.out.println(element.getText());
			element.getText().contains(Installments);
			return true;
		}
		return false;
	}

	public void selectAsWeekly() {
		logger.info("Starting of selectAsWeekly");

		waitForElementVisibilty(lblWeekly);
		this.lblWeekly.click();

		logger.info("Ending of selectAsWeekly");
	}

	public void clickOnEverysixMonthsButton() {
		logger.info("Starting of clickOnEveryTwoMonthsButton method");

		this.lblEverySixMonths.click();

		logger.info("Ending of clickOnEveryTwoMonthsButton method");
	}

	public String getMessageInformation() {
		logger.info("Starting of getMessageInformation method");
		logger.info("Ending of getMessageInformation method");

		return msgInformation.getText();
	}

	public boolean isDisplayedGotItPopup() {
		logger.info("Starting of isDisplayedGotItPopup method");
		boolean flag = false;
		logger.info("Ending of isDisplayedGotItPopup method");
		try {
			if (this.btnInstallmentGotItPopup.isDisplayed())
				flag = true;
		} catch (NoSuchElementException e) {
			flag = false;
		}
		return flag;
	}

	public void clickOnOverviewButton() {
		logger.info("Starting of clickOnOverviewButton method");
		try {
			this.btnOverView.click();
			this.hardWait(2);
		} catch (Exception e) {

			this.clickOnWebElement(btnOverView);
		}
		logger.info("Ending of clickOnOverviewButton method");
	}

	public String getErrorMaxInstallmentsMessage() {
		logger.info("Starting of getErrorMaxInstallmentsMessage method");
		this.explicitWait(msgErrorMaxInstallments);
		logger.info("Ending of getErrorMaxInstallmentsMessage method");

		return msgErrorMaxInstallments.getText();
	}

	public void clickOnCloseButton() {
		logger.info("Starting of clickOnCloseButton method");

		try {
			this.btnCloseContainer.click();
		} catch (Exception e) {
			this.clickOnWebElement(btnCloseContainer);
		}

		logger.info("Ending of clickOnCloseButton method");
	}

	public boolean getInstallmentPeriod() {
		logger.info("Starting of getInstallmentPeriod method");
		logger.info("Ending of getInstallmentPeriod method");
		boolean flag = true;
		for (WebElement element : lblInstallmentEnablePeriod) {
			String value = element.getAttribute("value");
			int values = Integer.parseInt(value);

			if (values > 4) {
				if (!(element.isEnabled())) {
					flag = false;
				}
			} else if (values != 5 && values != 6) {
				if (!(element.isEnabled())) {
					flag = false;
				}
			}
		}
		return flag;
	}

	public boolean getInstallmentPeriodOptions() {
		logger.info("Starting of getInstallmentPeriod method");
		logger.info("Ending of getInstallmentPeriod method");

		for (WebElement element : lblInstallmentEnablePeriod) {
			if (!(element.isDisplayed())) {
				return false;
			}
		}
		return true;
	}

	public boolean getInstallmentPeriodEnableOptions() {
		logger.info("Starting of getInstallmentPeriodEnableOptions method");
		logger.info("Ending of getInstallmentPeriodEnableOptions method");

		for (WebElement element : lblInstallmentEnablePeriod) {
			if (!(element.isEnabled())) {
				return false;
			}
		}
		return true;
	}

	public void setEditAmount(String amount) {
		logger.info("Starting of setEditAmount method");

		for (int i = 0; i < txtEditEqualInstallmentPrice.size() - 1; i++) {
			txtEditEqualInstallmentPrice.get(i).clear();
			txtEditEqualInstallmentPrice.get(i).sendKeys(amount);
		}
		logger.info("Ending of setEditAmount method");

	}

	public boolean isEnabledLastInstallment() {
		logger.info("Starting of isEnabledLastInstallment method");
		logger.info("Ending of isEnabledLastInstallment method");

		if (this.lblLastEditInstallment.isEnabled())
			return false;
		else
			return true;
	}

	public String getMonthlyPeriodLabel() {
		logger.info("Starting of getMonthlyPeriodLabel method");
		logger.info("Ending of getMonthlyPeriodLabel method");

		return lblMonthlyPeriod.getText();
	}

	public boolean setEqualEditAmounts(String lblIstinstallment) {
		logger.info("Starting of setEqualEditAmounts method");
		logger.info("Ending of setEqualEditAmounts method");
		boolean flag = true;
		String EffectiveCoursePrice = lblEffectivePrice.getText().substring(1);

		lblFirstEditInstallment.clear();
		lblFirstEditInstallment.sendKeys(lblIstinstallment);
		Double lblIstinstallmentOne = Double.parseDouble(lblIstinstallment);
		int installmentsize = txtEditEqualInstallmentPrice.size();
		Double EffectiveCoursePrice1 = Double.parseDouble(EffectiveCoursePrice);
		Double remainingPrice = (EffectiveCoursePrice1 - lblIstinstallmentOne) / installmentsize;
		String equalRemainingPrice1 = String.valueOf(remainingPrice);
		String equalRemainingPrice2 = equalRemainingPrice1.substring(0, 6);

		Double actualRemaningPrice = Double.parseDouble(equalRemainingPrice2);

		for (int i = 1; i < txtEditEqualInstallmentPrice.size(); i++) {
			String actualPrice = txtEditEqualInstallmentPrice.get(i).getAttribute("value");
			Double actualInstallmentPrice = Double.parseDouble(actualPrice);
			if ((actualInstallmentPrice.equals(actualRemaningPrice))) {
				flag = false;
				break;
			}
		}

		return flag;

	}

	public String getErrorZeroInstallmentsMessage() {
		logger.info("Starting of getErrorZeroInstallmentsMessage method");

		this.explicitWait(msgErrorZeroInstallments);

		logger.info("Ending of getErrorZeroInstallmentsMessage method");

		return msgErrorZeroInstallments.getText();
	}

	public String getLabelDeleteCourseText() {
		logger.info("Starting of getLabelDeleteCourseText method");

		this.explicitWait(msgDeleteCourse);

		logger.info("Ending of getLabelDeleteCourseText method");

		return msgDeleteCourse.getText();
	}

	public void clickOnGetInstallmentStatusCourse(String courseTitle) {
		logger.info("starting of clickOnGetInstallmentStatusCourse method");

		WebElement course = driver.findElement(By.xpath("(//span[contains(text(),'" + courseTitle + "')])[2]"));
		try {
			this.explicitWait(course);
			course.click();
		} catch (Exception e) {
			this.clickOnWebElement(course);
		}

		logger.info("Ending of clickOnGetInstallmentStatusCourse method");
	}

	public boolean isDisplayedPendingPayment() {
		logger.info("Starting of isDisplayedPendingPayment method");
		logger.info("Ending of isDisplayedPendingPayment method");

		if (lblPendingPayment.getText().equals("1/12 Installment") && lblInactiveStatus.getText().equals("INACTIVE")) {
			return true;

		} else
			return false;
	}

	public boolean isDisplayedFullPayment() {
		logger.info("Starting of isDisplayedFullPayment method");
		logger.info("Ending of isDisplayedFullPayment method");

		if (lblFullPayment.getText().equals("Full Payment") && lblActiveStatus.getText().equals("ACTIVE")) {

			return true;

		} else
			return false;
	}

	public String getPaymentDetailsLabel() {
		logger.info("Starting of getPaymentDetailsLabel method");
		logger.info("Ending of getPaymentDetailsLabel method");

		return lblPaymentDetails.getText();

	}

	public String getPaidColor() {
		logger.info("Starting of getPaidColor method");
		String colorString = lblGreenColor.getCssValue("color");
		String hex = Color.fromString(colorString).asHex();
		System.out.println("**********************************colorString************" + hex);

		logger.info("Ending of getPaidColor method");

		return hex;
	}

	public void clickOnPendingInstallment() {
		logger.info("Starting of clickOnPendingInstallment method");
		try {
			this.clickOnWebElement(studentSort);
			this.lblPendingPayment.click();
		} catch (NoSuchElementException e) {
			
			this.clickOnWebElement(lblPendingPayment);	
		}

		logger.info("Ending of clickOnPendingInstallment method");
	}

	public boolean isDisplayedPaidPaymentDate() {
		logger.info("Starting of isDisplayedPaidPaymentDate method");
		logger.info("Ending of isDisplayedPaidPaymentDate method");

		if (this.lblGreenColor.isDisplayed() && lblPaidDate.isDisplayed()) {
			return true;

		} else
			return false;
	}

	public boolean getPendingPaymentDate() {
		logger.info("Starting of getPendingPaymentDate method");
		logger.info("Ending of getPendingPaymentDate method");

		if (this.lblPendingStatus.getText().equalsIgnoreCase("Pending")
				&& lblPendingDate.getText().contains("Due Date")) {
			return true;

		} else
			return false;
	}

	public boolean getDuePaymentDate() {
		logger.info("Starting of getDuePaymentDate method");
		logger.info("Ending of getDuePaymentDate method");

		if (this.lblDueStatus.getText().equalsIgnoreCase("Due") && lblDueDate.getText().contains("Due Date")) {
			return true;

		} else
			return false;
	}

	public void closePurchaseInInstallments() {
		logger.info("Starting of closePurchaseInInstallments method");
		try {

			this.btnClosePurchaseInInstallments.click();
		} catch (Exception e) {
			this.clickOnWebElement(btnClosePurchaseInInstallments);
		}
		logger.info("Ending of closePurchaseInInstallments method");

	}

	public List<String> getInstallmentPeriodList() {
		logger.info("Starting of getInstallmentPeriodList method");
		logger.info("Ending of getInstallmentPeriodList method");

		List<String> titleList = new ArrayList<String>();
		for (WebElement e : lblInstallmentEnablePeriod) {
			titleList.add(e.getText());
		}
		logger.info(titleList);
		return titleList;
	}

	public String getEditSuccessfullMessage() {
		logger.info("Starting of getEditSuccessfullMessage method");

		this.explicitWait(msgEditSuccessful);

		logger.info("Ending of getEditSuccessfullMessage method");
		return msgEditSuccessful.getText();
	}

	public boolean isDisabledInstallmentPeriodLabel() {
		logger.info("Starting of isDisabledInstallmentPeriodLabel method");
		logger.info("Ending of isDisabledInstallmentPeriodLabel method");

		return lblInstallmentPeriodOption.isEnabled();
	}

	public void effectivePriceIcon() {
		logger.info("Starting of effectivePriceIcon method");

		this.mouseHover(effectivePriceIcon);

		logger.info("Ending of effectivePriceIcon method");

	}

	public String getEffectivePriceText() {
		logger.info("Starting of getEffectivePriceText method");

		this.explicitWait(effectivePriceText);

		logger.info("Ending of getEffectivePriceText method");
		return effectivePriceText.getText();
	}

}
