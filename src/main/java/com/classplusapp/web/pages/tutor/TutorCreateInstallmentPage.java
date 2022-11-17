package com.classplusapp.web.pages.tutor;

import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.log4j.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import com.classplusapp.web.pages.BaseClassplusAutomationPage;

import io.opentelemetry.exporter.logging.SystemOutLogExporter;
import io.qameta.allure.internal.shadowed.jackson.databind.deser.impl.MergingSettableBeanProperty;
import net.bytebuddy.agent.builder.AgentBuilder.InitializationStrategy.SelfInjection.Split;

public class TutorCreateInstallmentPage extends BaseClassplusAutomationPage {

	@FindBy(xpath = "//span[contains(text(),'B2b Installment')]")
	private WebElement btnGetCourse;

	@FindBy(xpath = "//input[@type='text']")
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

	@FindBy(xpath = "//p[@class='introducingInstallmentOverlay__prompt__top__textContainer__heading']")
	private WebElement lblIntroducingInstallments;

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

	@FindBy(xpath = "//p[contains(text(),'DOP + 2 week')]")
	private WebElement lbl2ndWeek;

	@FindBy(xpath = "//p[contains(text(),'DOP + 1 month')]")
	private WebElement lbl1stMonth;

	@FindBy(xpath = "//p[contains(text(),'DOP + 2 month')]")
	private WebElement lbl2ndMonth;

	@FindBy(xpath = "//p[contains(text(),'DOP + 3 month')]")
	private WebElement lbl3rdMonth;

	@FindBy(xpath = "//p[contains(text(),'DOP + 4 month')]")
	private WebElement lbl4rthMonth;

	@FindBy(xpath = "//p[contains(text(),'DOP + 5 month')]")
	private WebElement lbl5thMonth;

	@FindBy(xpath = "//p[contains(text(),'DOP + 6 month')]")
	private WebElement lbl6thMonth;

	@FindBy(xpath = "//p[contains(text(),'DOP + 7 month')]")
	private WebElement lbl7thMonth;

	@FindBy(xpath = "//p[contains(text(),'DOP + 8 month')]")
	private WebElement lbl8thMonth;

	@FindBy(xpath = "//p[contains(text(),'DOP + 9 month')]")
	private WebElement lbl9thMonth;

	@FindBy(xpath = "//p[contains(text(),'DOP + 10 month')]")
	private WebElement lbl10thMonth;

	@FindBy(xpath = "//p[contains(text(),'DOP + 11 month')]")
	private WebElement lbl11thMonth;

	@FindBy(xpath = "//p[contains(text(),'5th Installment')]")
	private WebElement lbl5thInstallment;

	@FindBy(xpath = "//p[contains(text(),'6th Installment')]")
	private WebElement lbl6thInstallment;

	@FindBy(xpath = "//p[contains(text(),'7th Installment')]")
	private WebElement lbl7thInstallment;

	@FindBy(xpath = "//p[contains(text(),'8th Installment')]")
	private WebElement lbl8thInstallment;

	@FindBy(xpath = "//p[contains(text(),'9th Installment')]")
	private WebElement lbl9thInstallment;

	@FindBy(xpath = "//p[contains(text(),'10th Installment')]")
	private WebElement lbl10thInstallment;

	@FindBy(xpath = "//p[contains(text(),'11th Installment')]")
	private WebElement lbl11thInstallment;

	@FindBy(xpath = "//p[contains(text(),'12th Installment')]")
	private WebElement lbl12thInstallment;

	@FindBy(xpath = "//p[contains(text(),'3rd Installment')]")
	private WebElement lbl3rdInstallment;

	@FindBy(xpath = "//p[contains(text(),'DOP + 4 week')]")
	private WebElement lbl4rthWeek;

	@FindBy(xpath = "//p[contains(text(),'4th Installment')]")
	private WebElement lbl4rthInstallment;

	@FindBy(xpath = "//p[contains(text(),'DOP + 6 week')]")
	private WebElement lbl6thweek;

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

	@FindBy(xpath = "(//input[@value='82.5'])[1]")
	private WebElement lblInstallmentPrices;

	@FindBy(xpath = "(//option[contains(text(),'Weekly')])[1]")
	private WebElement lblWeekly;

	@FindBy(xpath = "//p[contains(text(),'DOP + 12 month')]")
	private WebElement lbl12thMonth;

	@FindBy(xpath = "//p[contains(text(),'DOP + 14 month')]")
	private WebElement lbl14thMonth;

	@FindBy(xpath = "//p[contains(text(),'DOP + 16 month')]")
	private WebElement lbl16thMonth;

	@FindBy(xpath = "//p[contains(text(),'DOP + 18 month')]")
	private WebElement lbl18thMonth;
	@FindBy(xpath = "//p[contains(text(),'DOP + 20 month')]")
	private WebElement lbl20thMonth;
	@FindBy(xpath = "//p[contains(text(),'DOP + 22 month')]")
	private WebElement lbl22thMonth;

	@FindBy(xpath = "//option[contains(text(),'Every 2 Months')]")
	private WebElement lblEveryTwoMonths;

	@FindBy(xpath = "//option[contains(text(),'Every 3 Months')]")
	private WebElement lblEveryThreeMonths;

	@FindBy(xpath = "//p[contains(text(),'DOP + 15 month')]")
	private WebElement lbl15thMonth;

	@FindBy(xpath = "//p[contains(text(),'DOP + 21 month')]")
	private WebElement lbl21thMonth;

	@FindBy(xpath = "(//input[@value='123.75'])[1]")
	private WebElement lblInstallmentPriceForEveryThreeMonths;

	@FindBy(xpath = "//p[contains(text(),'DOP + 24 month')]")
	private WebElement lbl24thMonth;

	@FindBy(xpath = "//p[contains(text(),'DOP + 27 month')]")
	private WebElement lbl27thMonth;

	@FindBy(xpath = "//p[contains(text(),'DOP + 30 month')]")
	private WebElement lbl30thMonth;

	@FindBy(xpath = "//p[contains(text(),'DOP + 33 month')]")
	private WebElement lbl33thMonth;

	@FindBy(xpath = "//p[contains(text(),'DOP + 36 month')]")
	private WebElement lbl36thMonth;

	@FindBy(xpath = "//p[contains(text(),'DOP + 42 month')]")
	private WebElement lbl42ndMonth;

	@FindBy(xpath = "//p[contains(text(),'DOP + 48 month')]")
	private WebElement lbl48ndMonth;
	@FindBy(xpath = "//p[contains(text(),'DOP + 54 month')]")
	private WebElement lbl54ndMonth;
	@FindBy(xpath = "//p[contains(text(),'DOP + 60 month')]")
	private WebElement lbl60ndMonth;
	@FindBy(xpath = "//p[contains(text(),'DOP + 66 month')]")
	private WebElement lbl66ndMonth;

	@FindBy(xpath = "//option[contains(text(),'Every 6 Months')]")
	private WebElement lblEverySixMonths;

	@FindBy(xpath = "//img[contains(@src,'trashIcon.svg')]")
	private WebElement lblDeleteIcon;

	@FindBys({
			@FindBy(xpath = "//div[@class='installmentDetailsRow false undefined']/child::div/following-sibling::div/child::input[@placeholder='Installment price']") })
	private List<WebElement> lblInstallmentPrice;

	@FindBys({ @FindBy(xpath = "//p[@class='installmentDetailsRow__installNum__installNumText__num']") })
	private List<WebElement> lblNumberOfInstallment;

	@FindBy(xpath = "//div[@class='createInstallmentModal__content__installmentDetails__details']")
	private List<WebElement> lblInstallments;

	@FindBy(xpath = "//p[@class='installmentDetailsRow__installNum__installNumText__date']")
	private List<WebElement> lblInstallmentPeriods;

	@FindBy(xpath = "//div[@class='rrt-title']")
	private WebElement msgInstallmentSavedSuccessfully;

	private static final Logger logger = Logger.getLogger(TutorCreateInstallmentPage.class.getName());

	public TutorCreateInstallmentPage(WebDriver driver) {
		super(driver);
		logger.info("Starting of CreateInstallmentPage method");

		PageFactory.initElements(driver, this);

		logger.info("Ending of CreateInstallmentPage method");
	}

	public String getInstallmentSavedSuccessfullyMessage() {
		logger.info("Starting of getInstallmentSavedSuccessfullyMessage method");
		logger.info("Ending of getInstallmentSavedSuccessfullyMessage method");

		return msgInstallmentSavedSuccessfully.getText();

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

		WebElement course = driver.findElement(By.xpath("//span[contains(text(),'" + courseTitle + "')]/.."));
		System.out.println(course);
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

		if (lblIntroducingInstallments.isDisplayed()) {
			try {
				this.btnInstallmentGotItPopup.click();
			} catch (Exception e) {
				this.clickOnWebElement(btnInstallmentGotItPopup);
			}
		}

		logger.info("Ending of closeInstallmentGotItPopup method");
	}

	public void clickOnCreateInstallment() {
		logger.info("Starting of ClickOnCreateInstallment method");

		try {
			if (btnCreateInstallment.isDisplayed()) {
				this.btnCreateInstallment.click();
			}
		} catch (NoSuchElementException e) {
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
		this.txtGiveInstallments.clear();
		this.txtGiveInstallments.sendKeys(Installments);

		logger.info("Ending of GiveInstallments");
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

	public void selectBiWkly() {
		logger.info("Starting of selectBiWkly");

		this.txtSelectBiWkly.click();

		logger.info("Ending of selectBiWkly");
	}

	public void setBiweeklyOption() {
		logger.info("starting of setBiweeklyOption method");

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

		this.hardWait(5);
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
		this.hardWait(2);
		String osPath = System.getProperty("os.name");
		if (osPath.contains("Linux") || osPath.contains("Windows")) {

			this.txtGiveInstallment.sendKeys(Keys.chord(Keys.CONTROL + "a"), Keys.DELETE);
		} else {
			this.txtGiveInstallment.sendKeys(Keys.chord(Keys.COMMAND + "a"), Keys.DELETE);

		}
		// this.clickOnWebElement(txtGiveInstallments);
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
		// this.clickOnWebElement(lblSaveInstallments);

		logger.info("Ending of ClickOnSetInstallmentButton");
	}

	public void clickViewInstallmentsButton() throws InterruptedException {
		logger.info("Starting of clickViewInstallmentsButton method");

		Thread.sleep(2000);

		this.explicitWait(viewInstallmentsButton);
		this.clickOnWebElement(viewInstallmentsButton);

		logger.info("Ending of clickViewInstallmentsButton method");
	}

	public void clickOnDeleteIcon() {
		logger.info("Starting of clickOnDeleteIcon method");

		this.explicitWait(deleteIcon);
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
		String s[] = lblEffectiveCoursePrice.getText().split(" ");
		return s[0] + " " + s[1] + " " + s[2];
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

	public String get2ndWeekLabel() {
		logger.info("Starting of get2ndWeekLabel method");

		this.scrollIntoView(lbl2ndWeek);

		logger.info("Ending of get2ndWeekLabel method");
		return lbl2ndWeek.getText();

	}

	public String get3rdInstallmentLabel() {
		logger.info("Starting of get3rdInstallmentLabel method");

		this.explicitWait(lbl3rdInstallment);

		logger.info("Ending of get3rdInstallmentLabel method");
		return lbl3rdInstallment.getText();

	}

	public String get4rthWeekLabel() {
		logger.info("Starting of get4rthWeekLabel method");

		this.scrollIntoView(lbl4rthWeek);

		logger.info("Ending of get4rthWeekLabel method");
		return lbl4rthWeek.getText();

	}

	public String get4rthInstallmentLabel() {
		logger.info("Starting of get4rthInstallmentLabel method");

		this.scrollIntoView(lbl4rthInstallment);

		logger.info("Ending of get4rthInstallmentLabel method");
		return lbl4rthInstallment.getText();

	}

	public String get6thweekLabel() {
		logger.info("Starting of get6thweekLabel method");

		this.scrollIntoView(lbl6thweek);

		logger.info("Ending of get6thweekLabel method");
		return lbl6thweek.getText();

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

	public String getCreateInstallmentText() {
		logger.info("Starting of getCreateInstallmentText method");

		this.explicitWait(btnCreateInstallment);

		logger.info("Ending of getCreateInstallmentText method");
		return btnCreateInstallment.getText();
	}

	public String get1MonthLabel() {
		logger.info("Starting of get1MonthLabel method");

		this.explicitWait(lbl1stMonth);

		logger.info("Ending of get1MonthLabel method");
		return lbl1stMonth.getText();
	}

	public String get2ndMonthLabel() {
		logger.info("Starting of get2ndMonthLabel method");

		this.explicitWait(lbl2ndMonth);

		logger.info("Ending of get2ndMonthLabel method");
		return lbl2ndMonth.getText();
	}

	public String get3rdMonthLabel() {
		logger.info("Starting of get3rdMonthLabel method");

		this.explicitWait(lbl3rdMonth);

		logger.info("Ending of get3rdMonthLabel method");
		return lbl3rdMonth.getText();
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

		// this.explicitWait(lblInstallmentPrices);
		if (!(lblInstallmentPrice.size() == Integer.parseInt(strInstallment)))
			return false;
		for (WebElement price : lblInstallmentPrice) {
			if (!(j == Double.parseDouble(price.getAttribute("value")))) {
				return false;
			}
		}
		return true;
	}

	public boolean NumberOfInstallments() {
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

	public String get4rthMonthLabel() {
		logger.info("Starting of get4rthMonthLabel method");

		this.explicitWait(lbl4rthMonth);

		logger.info("Ending of get4rthMonthLabel method");
		return lbl4rthMonth.getText();

	}

	public String get5thMonthLabel() {
		logger.info("Starting of get5thMonthLabel method");

		this.explicitWait(lbl5thMonth);

		logger.info("Ending of get5thMonthLabel method");
		return lbl5thMonth.getText();

	}

	public String get6thMonthLabel() {
		logger.info("Starting of get6thMonthLabel method");

		this.explicitWait(lbl6thMonth);

		logger.info("Ending of get6thMonthLabel method");
		return lbl6thMonth.getText();
	}

	public String get7thMonthLabel() {
		logger.info("Starting of get7thMonthLabel method");

		this.explicitWait(lbl7thMonth);

		logger.info("Ending of get7thMonthLabel method");
		return lbl7thMonth.getText();
	}

	public String get8thMonthLabel() {
		logger.info("Starting of get8thMonthLabel method");

		this.explicitWait(lbl8thMonth);

		logger.info("Ending of get8thMonthLabel method");
		return lbl8thMonth.getText();
	}

	public String get9thMonthLabel() {
		logger.info("Starting of get9thMonthLabel method");

		this.explicitWait(lbl9thMonth);

		logger.info("Ending of get9thMonthLabel method");
		return lbl9thMonth.getText();
	}

	public String get10thMonthLabel() {
		logger.info("Starting of get10thMonthLabel method");

		this.explicitWait(lbl10thMonth);

		logger.info("Ending of get10thMonthLabel method");
		return lbl10thMonth.getText();
	}

	public String get11thMonthLabel() {
		logger.info("Starting of get11thMonthLabel method");

		this.explicitWait(lbl11thMonth);

		logger.info("Ending of get11thMonthLabel method");
		return lbl11thMonth.getText();
	}

	public String get5thInstallmentLabel() {
		logger.info("Starting of get5thInstallmentLabel method");

		this.explicitWait(lbl5thInstallment);

		logger.info("Ending of get5thInstallmentLabel method");
		return lbl5thInstallment.getText();

	}

	public String get6thInstallmentLabel() {
		logger.info("Starting of get6thInstallmentLabel method");

		this.explicitWait(lbl6thInstallment);

		logger.info("Ending of get6thInstallmentLabel method");
		return lbl6thInstallment.getText();
	}

	public String get7thInstallmentLabel() {
		logger.info("Starting of get7thInstallmentLabel method");

		this.explicitWait(lbl7thInstallment);

		logger.info("Ending of get7thInstallmentLabel method");
		return lbl7thInstallment.getText();
	}

	public String get8thInstallmentLabel() {
		logger.info("Starting of get8thInstallmentLabel method");

		this.explicitWait(lbl8thInstallment);

		logger.info("Ending of get8thInstallmentLabel method");
		return lbl8thInstallment.getText();
	}

	public String get9thInstallmentLabel() {
		logger.info("Starting of get9thInstallmentLabel method");

		this.explicitWait(lbl9thInstallment);

		logger.info("Ending of get9thInstallmentLabel method");
		return lbl9thInstallment.getText();
	}

	public String get10thInstallmentLabel() {
		logger.info("Starting of get10thInstallmentLabel method");

		this.explicitWait(lbl10thInstallment);

		logger.info("Ending of get10thInstallmentLabel method");
		return lbl10thInstallment.getText();
	}

	public String get11thInstallmentLabel() {
		logger.info("Starting of get11thInstallmentLabel method");

		this.explicitWait(lbl11thInstallment);

		logger.info("Ending of get11thInstallmentLabel method");
		return lbl11thInstallment.getText();
	}

	public String get12thInstallmentLabel() {
		logger.info("Starting of get12thInstallmentLabel method");

		this.explicitWait(lbl12thInstallment);

		logger.info("Ending of get12thInstallmentLabel method");
		return lbl12thInstallment.getText();
	}

	public String get12thMonthLabel() {
		logger.info("Starting of get12thMonthLabel method");

		this.explicitWait(lbl12thMonth);

		logger.info("Ending of get12thMonthLabel method");
		return lbl12thMonth.getText();
	}

	public String get14thMonthLabel() {
		logger.info("Starting of get14thMonthLabel method");

		this.explicitWait(lbl14thMonth);

		logger.info("Ending of get10thMonthLabel method");
		return lbl14thMonth.getText();
	}

	public String get16thMonthLabel() {
		logger.info("Starting of get16thMonthLabel method");

		this.explicitWait(lbl16thMonth);

		logger.info("Ending of get16thMonthLabel method");
		return lbl16thMonth.getText();
	}

	public String get18thMonthLabel() {
		logger.info("Starting of get18thMonthLabel method");

		this.explicitWait(lbl18thMonth);

		logger.info("Ending of get18thMonthLabel method");
		return lbl18thMonth.getText();
	}

	public String get20thMonthLabel() {
		logger.info("Starting of get20thMonthLabel method");

		this.explicitWait(lbl20thMonth);

		logger.info("Ending of get20thMonthLabel method");
		return lbl20thMonth.getText();
	}

	public String get22thMonthLabel() {
		logger.info("Starting of get22thMonthLabel method");

		this.explicitWait(lbl22thMonth);

		logger.info("Ending of get22thMonthLabel method");
		return lbl22thMonth.getText();
	}

	public void clickOnEveryTwoMonthsButton() {
		logger.info("Starting of clickOnEveryTwoMonthsButton method");

		this.lblEveryTwoMonths.click();

		logger.info("Ending of clickOnEveryTwoMonthsButton method");
	}

	public void clickOnEveryThreeMonthsButton() {
		logger.info("Starting of clickOnEveryThreeMonthsButton method");

		this.lblEveryThreeMonths.click();

		logger.info("Ending of clickOnEveryThreeMonthsButton method");
	}

	public String get15thMonthLabel() {
		logger.info("Starting of get16thMonthLabel method");

		this.explicitWait(lbl15thMonth);

		logger.info("Ending of get16thMonthLabel method");
		return lbl15thMonth.getText();
	}

	public String get21thMonthLabel() {
		logger.info("Starting of get16thMonthLabel method");

		this.explicitWait(lbl21thMonth);

		logger.info("Ending of get16thMonthLabel method");
		return lbl21thMonth.getText();
	}

	public boolean setEveryThreeMonthsInstallmentPrice(String strEnterPrice, String strInstallment) {

		this.explicitWait(lblInstallmentPriceForEveryThreeMonths);
		Double k = Double.parseDouble(strEnterPrice);
		Double l = Double.parseDouble(strInstallment);
		Double j = k / l;

		if (j == Double.parseDouble(lblInstallmentPriceForEveryThreeMonths.getAttribute("value"))) {
			return true;
		}
		return false;

	}

	public String get24thMonthLabel() {
		logger.info("Starting of get24thMonthLabel method");

		this.explicitWait(lbl24thMonth);

		logger.info("Ending of get16thMonthLabel method");
		return lbl24thMonth.getText();
	}

	public String get27thMonthLabel() {
		logger.info("Starting of get27thMonthLabel method");

		this.explicitWait(lbl27thMonth);

		logger.info("Ending of get27thMonthLabel method");
		return lbl27thMonth.getText();
	}

	public String get30thMonthLabel() {
		logger.info("Starting of get30thMonthLabel method");

		this.explicitWait(lbl30thMonth);

		logger.info("Ending of get30thMonthLabel method");
		return lbl30thMonth.getText();
	}

	public String get33thMonthLabel() {
		logger.info("Starting of get33thMonthLabel method");

		this.explicitWait(lbl33thMonth);

		logger.info("Ending of get33thMonthLabel method");
		return lbl33thMonth.getText();
	}

	public String get36thMonthLabel() {
		logger.info("Starting of get36thMonthLabel method");

		this.explicitWait(lbl36thMonth);

		logger.info("Ending of get36thMonthLabel method");
		return lbl36thMonth.getText();
	}

	public String get42ndMonthLabel() {
		logger.info("Starting of get42ndMonthLabel method");

		this.explicitWait(lbl42ndMonth);

		logger.info("Ending of get42ndMonthLabel method");
		return lbl42ndMonth.getText();
	}

	public String get48ndMonthLabel() {
		logger.info("Starting of get48ndMonthLabel method");

		this.explicitWait(lbl48ndMonth);

		logger.info("Ending of get48ndMonthLabel method");
		return lbl48ndMonth.getText();
	}

	public String get54ndMonthLabel() {
		logger.info("Starting of get54ndMonthLabel method");

		this.explicitWait(lbl54ndMonth);

		logger.info("Ending of get54ndMonthLabel method");
		return lbl54ndMonth.getText();
	}

	public String get60ndMonthLabel() {
		logger.info("Starting of get60ndMonthLabel method");

		this.explicitWait(lbl60ndMonth);

		logger.info("Ending of get60ndMonthLabel method");
		return lbl60ndMonth.getText();
	}

	public String get66ndMonthLabel() {
		logger.info("Starting of get66dMonthLabel method");

		this.explicitWait(lbl66ndMonth);

		logger.info("Ending of get66dMonthLabel method");
		return lbl66ndMonth.getText();
	}

	public void clickOnEverysixMonthsButton() {
		logger.info("Starting of clickOnEveryTwoMonthsButton method");

		this.lblEverySixMonths.click();

		logger.info("Ending of clickOnEveryTwoMonthsButton method");
	}

	public boolean isDisplayedDeleteIcon() {
		logger.info("Starting of isDisplayedDeleteIcon method");
		logger.info("Ending of isDisplayedDeleteIcon method");

		return deleteIcon.isDisplayed();
	}

	public boolean clickOnEverysixMonthsButton1() {

		for (WebElement element : lblInstallmentPrice) {
			String value = element.getAttribute("value");
			int values = Integer.parseInt(value);
			if (values == 5 && values == 6) {
				if (!(element.isEnabled())) {
					return true;
				}
			} else if (values != 5 && values != 6) {
				if (element.isEnabled()) {
					return true;
				}
			}
		}
		return false;
	}

	public boolean setEveryThreeMonthsInstallmentPrice1(String strEnterPrice, String strInstallment,
			String lblIstinstallment) {

		/*
		 * this.explicitWait(lblInstallmentPriceForEveryThreeMonths); Double k =
		 * Double.parseDouble(strEnterPrice); Double l =
		 * Double.parseDouble(strInstallment); Double j = k / l;
		 */
		String EffectiveCoursePrice = lblEverySixMonths.getText().substring(1);

		lblEverySixMonths.sendKeys(lblIstinstallment);
		// String EffectiveCoursePrice= lblEverySixMonths.getText();
		Double lblIstinstallment1 = Double.parseDouble(lblIstinstallment);

		Double EffectiveCoursePrice1 = Double.parseDouble(EffectiveCoursePrice);
		Double remainingPrice = EffectiveCoursePrice1 - lblIstinstallment1;

		for (WebElement element : lblInstallmentPrice) {
			if (!(element.getText().equals(remainingPrice))) {
				return false;
			}

		}

		return true;

	}
}
