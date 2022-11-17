package com.classplusapp.web.pages.student;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.JavascriptExecutor;

import com.classplusapp.web.pages.BaseClassplusAutomationPage;

public class StudentPayInstallmentCoursePage extends BaseClassplusAutomationPage {

	@FindBy(xpath = "//div[@class='modalContainer_modal_header']")
	private WebElement lblPurchaseInInstallmentHeading;

	@FindBy(xpath = "//div[@class='InstallmentCard_installNum_installNumText']")
	private List<WebElement> lblInstallmentNum;

//	@FindBy(xpath="//p[@class='InstallmentCard_installNuminstallNumText_num'][contains(text(),'Installment - Paid')]" )
//	private List<WebElement> lblPaidInstallmentsText;

	@FindBy(xpath = "//p[contains(text(),'Installment - Paid')]/ancestor::div[@class='InstallmentCard']//div[contains(text(),'Receipt')]")
	private List<WebElement> btnInstallmentReceipts;

	@FindBy(xpath = "//p[contains(text(),'Installment - Paid')]/ancestor::div[@class='InstallmentCard']//div[contains(text(),'Receipt')]")
	private WebElement btnInstallmentReceipt;

	@FindBy(xpath = "//div[@class='CompleteCourseCard']//div[text()='Price Summary']")
	private WebElement btnPriceSummary;

	@FindBy(xpath = "//div[@class='promptModalContainer__promptModal']/div/div")
	private WebElement lblPriceSummaryHeading;

	@FindBy(xpath = "//div[@class='promptModalContainer__promptModal']//div[text()='Course price']")
	private WebElement divCoursePrice;

	@FindBy(xpath = "//div[@class='promptModalContainer__promptModal']//div[text()='Course price']/parent::div/div[2]")
	private WebElement divCoursePriceAmount;

	@FindBy(xpath = "//div[@class='promptModalContainer__promptModal']//div[text()='Amount Payable']")
	private WebElement divAmountPayableText;

	@FindBy(xpath = "//div[@class='promptModalContainer__promptModal']//div[text()='Amount Payable']/parent::div/div[2]")
	private WebElement divAmountPayableAmount;

	@FindBy(xpath = "//div[@class='promptModalContainer__promptModal']//img")
	private WebElement btnCrossPriceSummary;

	@FindBy(xpath = "//div[@class='modalContainer__modal']//img")
	private WebElement btnCrossPurchaseInInstallments;

	@FindBy(xpath = "//div[@class='InstallmentCard_Row1']//p[@class='InstallmentCard_installPriceText']")
	private WebElement textFirstInstallmentAmount;

	@FindBy(xpath = "//button[contains(text(),'Pay 1st installment')]")
	private WebElement btnPayFirstInstallment;

	@FindBy(xpath = "//button[@class='storeBuy__cta--button cursorPointer']")
	private WebElement btnBuyNow;

	@FindBy(xpath = "//div[@class='topRight']/following-sibling::div//div[contains(text(),'View All Installment')]")
	private WebElement btnBottomViewAllInstallment;

	@FindBy(xpath = "//div[@class='storeBuy']/div[2]/div")
	private WebElement btnSideViewAllInstallment;

	@FindBy(xpath = "//div[@class='topRight']/following-sibling::div//button")
	private WebElement btnBottomPayxthInstallment;

	@FindBy(xpath = "//div[@class='storeBuy']/div[2]/button")
	private WebElement btnSidePayxthInstallment;

	@FindBy(xpath = "//div[@id='modal-close']")
	private WebElement btnCloseRazorPayPopup;

	@FindBy(xpath = "//div[@class='razorpay-container']//iframe")
	private WebElement iframePayment;

	@FindBy(xpath = "//div[@class='Modal--Container__bottom']/button[contains(text(),'Pay')]")
	private WebElement btnPayXthInstallmentInViewAllInstallment;

	@FindBy(xpath = "//span[contains(text(),'Overview')]")
	private WebElement btnOverview;

	@FindBy(xpath = "//div[contains(text(),'Create Installments')]")
	private WebElement btnCreateInstallment;

	@FindBy(xpath = "//div[contains(text(),'Course with Instalment')]")
	private WebElement getInstallmentCourse;

	@FindBy(xpath = "//div[@class='storeBuy_cta storeBuy_btm  flex-c']//button")
	private WebElement btnUpPaySecondInstallment;

	@FindBy(xpath = "//div[@class='storeBuy_cta storeBuy_btm  flex-c']//div")
	private WebElement btnUpViewAllInstallment;

	@FindBy(xpath = "//div[@class='PromtPlaceholder__Heading']")
	private WebElement lblPaymentFail;

	@FindBy(xpath = "//div[@class='StudentPaymentDetails__Heading']")
	private WebElement lblStudentInstallments;

	@FindBy(xpath = "//div[@class='CompleteCourseCard_Header_TP']")
	private WebElement lblStudentAmount;

	@FindBy(xpath = "//div[@class='BottomSheet_Body_Row Bold']//div[2]")
	private WebElement lblPayableAmount;

	@FindBy(xpath = "//img[@class='modalContainer_modalheader_image']")
	private WebElement btnInstallClose;

	@FindBy(xpath = "//img[@class='cursorPointer']")
	private WebElement btnPriceSummaryClose;

	@FindBy(xpath = "//div[@class='storeBuy_installments_heading']")
	private WebElement lblCourseLocked;

	@FindBy(xpath = "//button[contains(@class,'promptModalContainer_promptModal_button p10 mt-32')]")
	private WebElement lblPayPendiing;

	@FindBy(xpath = "//div[@class='promptModalContainer_promptModalpara storeBuy_viewInstallment cursorPointer']")
	private WebElement lblViewInstallment;

	@FindBy(xpath = "//p[@class='promptModalContainer_promptModal_heading']")
	private WebElement lblCourseLock;

	@FindBy(xpath = "//div[@class='storeBuy_installments_heading']")
	private WebElement lblPayInInstallment;

	@FindBy(xpath = "//div[@class='Shipment__CreateCourse__Option--Label']/following-sibling::div/descendant::div[@class='ui fitted toggle checkbox']/input")
	private WebElement tglPhysicalShipment;

	@FindBy(xpath = "//div[@class='Shipment_CreateCourse_Option--Description']/parent::div/following-sibling::div//input")
	private WebElement chkSetDeliveryDate;

	@FindBy(xpath = "(//span[text()='Physicalshipment Course'])[2]")
	private WebElement getShipmentCourse;

	@FindBy(xpath = "//div[@class='Shipment_Buy_AddressSection--SelectAddress']")
	private WebElement btnSelectAddress;

	@FindBy(xpath = "//input[@class='Shipment_ModalBodyInput--Field--Area ShipmentModalBody_Input--Field--Name']")
	private WebElement txtFullName;

	@FindBy(xpath = "//input[@class='Shipment_ModalBodyInput--Field--Area ShipmentModalBody_Input--Field--AddressOne']")
	private WebElement txtAddress;

	@FindBy(xpath = "//input[@class='Shipment_ModalBodyInput--Field--Area ShipmentModalBody_Input--Field--AddressTwo']")
	private WebElement txtAlternativeAddress;

	@FindBy(xpath = "//input[@class='Shipment_ModalBodyInput--Field--Area ShipmentModalBody_Input--Field--City']")
	private WebElement txtCity;

	@FindBy(xpath = "//input[@placeholder='Select a state']")
	private WebElement drpState;

	@FindBy(xpath = "//li[contains(text(),'Telangana')]")
	private WebElement btnSelectState;

	@FindBy(xpath = "//input[@class='Shipment_ModalBodyInput--Field--Area ShipmentModalBody_Input--Field--Pin']")
	private WebElement txtPin;

	@FindBy(xpath = "//button[@class='Shipment_Modal_Bottom--Save']")
	private WebElement btnSaveAddress;

	@FindBy(xpath = "//span[@class='Shipment_Buy_AddressSection--Change']")
	private WebElement btnChange;

	@FindBy(xpath = "//div[@class='Shipment_ModalBody_AddressList--Item--Actions--Delete']")
	private WebElement btnDelete;

	@FindBy(xpath = "//div[@class='Shipment_DeleteModal_Body--Delete']")
	private WebElement btnYesDelete;

	@FindBy(xpath = "//input[@class='Shipment_ModalBodyInput--Field--Area ShipmentModalBody_Input--Field--Mobile']")
	private WebElement txtMobile;

	@FindBy(xpath = "//span[contains(text(),'CouponTesting Course')]")
	private WebElement getCouponCourse;

	@FindBy(xpath = "//div[text()='View All']")
	private WebElement btnCouponViewAll;

	@FindBy(xpath = "//input[@placeholder='Enter coupon code']")
	private WebElement txtSearchCoupon;

	@FindBy(xpath = "//body/div[@class='ui page modals dimmer transition visible active']/div[@class='ui tiny modal transition visible active']/div[@class='content']/div[1]/div[1]")
	private WebElement btnApplyCoupon;

	@FindBy(xpath = "//div[text()='REMOVE']")
	private WebElement btnCouponRemove;

	@FindBy(xpath = "//div[@class='rrt-title']")
	private WebElement msgCouponApplied;

	@FindBy(xpath = "//div[text()='Course Price']")
	private WebElement lblCoursePrice;

	@FindBy(xpath = "//div[contains(text(),'G.S.T. (18%)')]")
	private WebElement lblInternetHandlingCharges;

	@FindBy(xpath = "//div[text()='Amount Payable']")
	private WebElement lblAmountPayable;

	@FindBy(xpath = "//img[contains(@class,'videojs_watermark')]")
	private WebElement lblWaterMark;

	@FindBy(xpath = "//div[contains(@class,'StoreCarousels_cardHeader__141K1 StoreCarousels_statsHeader')]")
	private WebElement lblCouponsForYou;

	@FindBy(xpath = "//div[@class='StoreCarousels_paddingClass_sLnyM']//button[@class='Carousel_Right_33zBq']//img")
	private WebElement btnForwardCourosel;

	@FindBy(xpath = "//button[@class='Carousel_Left_1GxvH']//span[contains(@class,'Carousel_roundButton_3P_Hl')]")
	private WebElement btnBackwardCourosel;

	@FindBy(xpath = "//div[normalize-space()='BY0022']")
	private WebElement getCoupon;

	@FindBy(xpath = "//span[contains(text(),'UI REVAMP1')]")
	private WebElement getAvailableCouponCourse;

	@FindBy(xpath = "//div[text()='BY0022']")
	private WebElement getCouponDisplayed;

	@FindBy(xpath = "//div[@class='header-expanded']//div[@class='close']")
	private WebElement btnCloseBuyNowPage;

	@FindBy(xpath = "//span[contains(text(),'Content')]//parent::div")
	private WebElement lblContent;

	@FindBy(xpath = "//i[@class='close large icon float-right']")
	private WebElement videoTestCancel;

	// @FindBy(xpath =
	// "//div[contains(text(),'B2BSTORE')]//parent::div//parent::div//parent::div//parent::div/descendant::i[@class='ellipsis
	// vertical
	// icon']/following-sibling::div/descendant::div/descendant::img[@alt='active
	// icon']")
	@FindBy(xpath = "//div[contains(text(),'B2BSTORE')]//parent::div//parent::div//parent::div//parent::div/descendant::i[@class='ellipsis vertical icon']/following-sibling::div/descendant::div/descendant::img[@alt='active icon']")
	private WebElement makeActiveIcon;

	@FindBy(xpath = "//div[contains(text(),'B2BSTORE')]//parent::div//parent::div//parent::div//parent::div/descendant::i/following-sibling::div/child::div/descendant::span[contains(text(),'Delete')]")
	private WebElement deleteIcon;

	private static final Logger logger = Logger.getLogger(StudentPayInstallmentCoursePage.class.getName());

	public StudentPayInstallmentCoursePage(WebDriver driver) {
		super(driver);
		logger.info("Starting of StudentBuyCoursePage method");

		PageFactory.initElements(driver, this);

		logger.info("Ending of StudentBuyCoursePage method");

	}

	public String getPurchaseInInstallmentsHeading() {
		logger.info("Starting of getPurchaseInInstallmentsHeading method");

		this.explicitWait(this.lblPurchaseInInstallmentHeading);

		logger.info("Ending of getPurchaseInInstallmentsHeading method");

		return this.lblPurchaseInInstallmentHeading.getText();
	}

	public String getPriceSummaryHeadingText() {
		logger.info("Starting of getPriceSummaryHeadingText method");
		this.explicitWait(this.lblPriceSummaryHeading);
		logger.info("Ending of getPriceSummaryHeadingText method");
		return this.lblPriceSummaryHeading.getText();

	}

	public boolean isDisplayedVisibilityOfPriceSummary() {
		logger.info("Starting of getPriceSummaryHeadingText method");
		this.explicitWait(this.lblPurchaseInInstallmentHeading);
		if (this.btnPriceSummary.isDisplayed())
			return true;
		else
			return false;
	}

	public void clickOnPriceSummaryButton() {
		logger.info("Starting of clickOnPriceSummaryButton method");
		try {
			this.explicitWait(this.btnPriceSummary);
			this.btnPriceSummary.click();
		} catch (Exception e) {
			this.clickOnWebElement(btnPriceSummary);
		}
		logger.info("Ending of clickOnPriceSummaryButton method");

	}

	public boolean checkVisibilityOfCoursePrice() {
		logger.info("starting of checkVisibilityOfCoursePrice method");
		if (this.divCoursePrice.isDisplayed()) {
			if (this.divCoursePriceAmount.isDisplayed())
				return true;
			else
				return false;
		} else
			return false;

	}

	public boolean checkVisibilityOfAmountPayable() {
		logger.info("starting of checkVisibilityOfAmountPayable method");
		if (this.divAmountPayableText.isDisplayed()) {
			if (this.divAmountPayableAmount.isDisplayed())
				return true;
			else
				return false;
		} else
			return false;
	}

	public void closePriceSummary() {
		logger.info("Starting of closePriceSummary method");
		try {

			this.btnCrossPriceSummary.click();
		} catch (Exception e) {
			this.clickOnWebElement(btnCrossPriceSummary);
		}
		logger.info("Ending of closePriceSummary method");

	}

	public void closePurchaseInInstallments() {
		logger.info("Starting of closePurchaseInInstallments method");
		try {

			this.btnCrossPurchaseInInstallments.click();
		} catch (Exception e) {
			this.clickOnWebElement(btnCrossPurchaseInInstallments);
		}
		logger.info("Ending of closePurchaseInInstallments method");

	}

	public boolean checkInstallmentSequence() {
		logger.info("Starting of checkInstallmentSequence method");
		boolean flag = true;

		for (int i = 0; i < this.lblInstallmentNum.size(); i++) {
			if (Integer.parseInt(this.lblInstallmentNum.get(i).getText().replaceAll("[^0-9]+", "")) != (i + 1)) {
				flag = false;
				break;
			}
		}
		return flag;
	}

	public Float getFirstInstallmentAmount() {
		logger.info("starting of getFirstInstallmentAmount method");
		return Float.parseFloat(this.textFirstInstallmentAmount.getText().replaceAll("[^0-9]+", ""));
	}

	public Float getAmtInPayFirstInstallmentBtn() {
		logger.info("starting of getAmtInPayFirstInstallmentbtn method");
		return Float.parseFloat(this.textFirstInstallmentAmount.getText().substring(1).replaceAll("[^0-9]+", ""));
	}

	public boolean checkVisibilityOfPayFirstInstallmentBtn() {
		logger.info("Starting of checkVisibilityOfPayFirstInstallmentBtn method");
		if (this.btnPayFirstInstallment.isDisplayed())
			return true;
		else
			return false;
	}

	public void clickOnFirstInstallmentBtn() {
		logger.info("Starting of clickOnFirstInstallmentBtn method");
		try {
			this.btnPayFirstInstallment.click();
		} catch (Exception e) {
			this.clickOnWebElement(btnPayFirstInstallment);
		}
		logger.info("Starting of clickOnFirstInstallmentBtn method");

	}

	public boolean checkVisibilityOfBottomViewAllInstallmentBtn() {
		logger.info("Starting of checkVisibilityOfBottomViewAllInstallmentBtn method");
		this.scrollDown(200);
		if (this.btnBottomViewAllInstallment.isDisplayed())
			return true;
		else
			return false;
	}

	public boolean checkVisibilityOfBottomPayxthInstallmentBtn() {
		logger.info("Starting of checkVisibilityOfBottomPay2ndInstallmentBtn method");
		try {
			if (this.btnBottomPayxthInstallment.isDisplayed())
				return true;
			else
				return false;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean checkVisibilityOfSideViewAllInstallmentBtn() {
		logger.info("Starting of checkVisibilityOfSideViewAllInstallmentBtn method");

		if (this.btnSideViewAllInstallment.isDisplayed())
			return true;
		else
			return false;

	}

	public boolean checkVisibilityOfSidePayxthInstallmentBtn() {
		logger.info("Starting of checkVisibilityOfSidePay2ndInstallmentBtn method");
		try {
			if (this.btnSidePayxthInstallment.isDisplayed())
				return true;
			else
				return false;
		} catch (Exception e) {
			return false;
		}

	}

	public void clickOnBottomPayxthInstallmentButton() {
		logger.info("Starting of clickOnBottomPayxthInstallmentButton method");
		try {

			this.scrollIntoView(this.btnBottomPayxthInstallment);
			this.btnBottomPayxthInstallment.click();
		} catch (Exception e) {
			this.clickOnWebElement(btnBottomPayxthInstallment);
		}
		logger.info("Ending of clickOnBottomPayxthInstallmentButton method");

	}

	public void clickOnSidePayxthInstallmentButton() {
		logger.info("Starting of clickOnSidePayxthInstallmentButton method");
		try {

			this.scrollIntoView(this.btnSidePayxthInstallment);
			this.btnSidePayxthInstallment.click();
		} catch (Exception e) {
			this.clickOnWebElement(btnSidePayxthInstallment);
		}
		logger.info("Ending of clickOnSidePayxthInstallmentButton method");

	}

	public void clickOnBottomViewAllInstallmentButton() {
		logger.info("Starting of clickOnBottomViewAllInstallmentButton method");
		try {

			this.btnBottomViewAllInstallment.click();
		} catch (Exception e) {
			this.clickOnWebElement(btnBottomViewAllInstallment);
		}
		logger.info("Ending of clickOnBottomViewAllInstallmentButton method");

	}

	public void clickOnSideViewAllInstallmentButton() {
		logger.info("Starting of clickOnSideViewAllInstallmentButton method");
		try {

			this.btnSideViewAllInstallment.click();
		} catch (Exception e) {
			this.clickOnWebElement(btnSideViewAllInstallment);
		}
		logger.info("Ending of clickOnSideViewAllInstallmentButton method");

	}

	public void closeRazorPayPopup() {
		logger.info("starting of closeRazorPayPopup method");
		try {
			this.explicitWait(iframePayment);
			driver.switchTo().frame(iframePayment);
			this.btnCloseRazorPayPopup.click();
		} catch (Exception e) {
			this.clickOnWebElement(this.btnCloseRazorPayPopup);
		}
		logger.info("ending of closeRazorPayPopup method");

	}

	public boolean checkPayXthInstallmentInViewAllInstallment() {
		logger.info("Starting of checkPayXthInstallmentInViewAllInstallment method");
		try {
			if (this.btnPayXthInstallmentInViewAllInstallment.isDisplayed())
				return true;
			else
				return false;
		} catch (Exception e) {
			return false;
		}

	}

	public void clickOnPayXthInstallmentInViewAllInstallment() {
		logger.info("starting of clickOnPayXthInstallmentInViewAllInstallment method");
		try {
			this.explicitWait(this.btnPayXthInstallmentInViewAllInstallment);
			this.btnPayXthInstallmentInViewAllInstallment.click();
		} catch (Exception e) {
			this.clickOnWebElement(this.btnPayXthInstallmentInViewAllInstallment);
		}
		logger.info("ending of clickOnPayXthInstallmentInViewAllInstallment method");

	}

	public boolean checkVisibilityBuyNowButton() {
		logger.info("Starting of checkVisibilityBuyNowButton method");
		try {
			if (this.btnBuyNow.isDisplayed())
				return true;
			else
				return false;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean checkReceiptButton() {

		logger.info("Starting of checkReceiptButton method");
		boolean flag = true;
		this.explicitWait(this.lblPurchaseInInstallmentHeading);
		for (int i = 0; i < this.btnInstallmentReceipts.size(); i++) {
			try {
				logger.info("clicking on receipt button");
				this.btnInstallmentReceipts.get(i).click();
				logger.info("receipt button is clicked");
				Thread.sleep(2000);
				this.switchToNewWindow();
				this.switchToParentWindow();
			} catch (Exception e) {
				this.switchToParentWindow();
				flag = false;
			}
		}
		return flag;

	}

	public void clickOnOverviewButton() {
		logger.info("Starting of clickOnOverviewButton method");

		this.btnOverview.click();

		logger.info("Ending of clickOnOverviewButton method");
	}

	public void clickOnCreateInstallmentButton() {
		logger.info("Starting of clickOnCreateInstallmentButton method");

		try {
			this.btnCreateInstallment.click();
		} catch (Exception e) {

			this.clickOnWebElement(btnCreateInstallment);
		}

		logger.info("Ending of clickOnCreateInstallmentButton method");
	}

	public void clickOnGetInstallmentCourse() {
		logger.info("starting of clickOnGetInstallmentCourse method");

		try {
			this.getInstallmentCourse.click();
		} catch (Exception e) {
			this.clickOnWebElement(getInstallmentCourse);
		}

		logger.info("Ending of clickOnGetCourse method");
	}

	public boolean isDisplayedUpSecondPaymentButton() {
		logger.info("Starting of isDisplayedUpSecondPaymentButton method");
		logger.info("Ending of isDisplayedUpSecondPaymentButton method");

		if (this.btnUpPaySecondInstallment.isDisplayed()) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isDisplayedUpViewAllButton() {
		logger.info("Starting of isDisplayedUpViewAllButton method");
		logger.info("Ending of isDisplayedUpViewAllButton method");

		if (this.btnUpViewAllInstallment.isDisplayed()) {
			return true;
		} else {
			return false;
		}
	}

	public String getPaymentFailedHeadingLabel() {
		logger.info("Starting of getPaymentFailedHeadingLabel method");
		logger.info("Ending of getPaymentFailedHeadingLabel method");
		this.explicitWait(lblPaymentFail);

		return lblPaymentFail.getText();
	}

	public boolean getInstallmentHeaderLabel() {
		logger.info("Starting of getInstallmentHeaderLabel method");
		logger.info("Ending of getInstallmentHeaderLabel method");

		return lblStudentInstallments.isDisplayed();
	}

	public void clickOnUpViewAllButton() {
		logger.info("Starting of clickOnUpViewAllButton method");
		try {

			this.btnUpViewAllInstallment.click();
		} catch (Exception e) {
			this.clickOnWebElement(btnUpViewAllInstallment);
		}
		logger.info("Ending of clickOnUpViewAllButton method");

	}

	public void clickOnReceiptButton() {
		logger.info("Starting of clickOnReceiptButton method");
		try {

			this.btnInstallmentReceipt.click();
		} catch (Exception e) {
			this.clickOnWebElement(btnInstallmentReceipt);
		}
		this.switchToNewWindow();
		this.closeWindow();
		logger.info("Ending of btnInstallmentReceipts method");

	}

	public String getStudentAmountLabel() {
		logger.info("Starting of getStudentAmountLabel method");
		logger.info("Ending of getStudentAmountLabel method");

		String[] bb = lblStudentAmount.getText().trim().split("₹ ");
		System.out.println("********" + bb[1]);
		return bb[1];
	}

	public String getPayableAmountLabel() {
		logger.info("Starting of getPayableAmountLabel method");
		logger.info("Ending of getPayableAmountLabel method");

		String[] bb = lblPayableAmount.getText().trim().split("₹");
		System.out.println("********" + bb[1]);
		return bb[1];

	}

	public void clickOnCloseInstallButton() {
		logger.info("Starting of clickOnCloseInstallButton method");
		try {

			this.btnInstallClose.click();
		} catch (Exception e) {
			this.clickOnWebElement(btnInstallClose);
		}
		logger.info("Ending of clickOnCloseInstallButton method");

	}

	public void clickOnClosePriceButton() {
		logger.info("Starting of clickOnClosePriceButton method");
		try {

			this.btnPriceSummaryClose.click();
		} catch (Exception e) {
			this.clickOnWebElement(btnPriceSummaryClose);
		}
		logger.info("Ending of clickOnClosePriceButton method");

	}

	public String getCourseLockedHeader() {
		logger.info("Starting of getCourseLockedHeader method");
		logger.info("Ending of getCourseLockedHeader method");

		return lblCourseLocked.getText();
	}

	public boolean isDisplayedPayPending() {
		logger.info("Starting of isDisplayedPayPending method");
		logger.info("Ending of isDisplayedPayPending method");

		return lblPayPendiing.isDisplayed();
	}

	public boolean isDisplayedViewAll() {
		logger.info("Starting of isDisplayedViewAll method");
		logger.info("Ending of isDisplayedViewAll method");

		return lblViewInstallment.isDisplayed();

	}

	public boolean isDisplayedLockedCouse() {
		logger.info("Starting of isDisplayedLockedCouse method");
		logger.info("Ending of isDisplayedLockedCouse method");

		return lblCourseLock.isDisplayed();

	}

	public String lblCreatedInstallments() {
		logger.info("Starting of lblCreatedInstallments method");
		logger.info("Ending of lblCreatedInstallments method");

		return lblCourseLock.getText();

	}

	public void clickOnPayPendingButton() {
		logger.info("Starting of clickOnPayPendingButton method");

		try {
			this.lblPayPendiing.click();
		} catch (Exception e) {
			this.clickOnWebElement(lblPayPendiing);
		}

		logger.info("Ending of clickOnPayPendingButton method");
	}

	public boolean isDisplayedPayInInstallment() {
		logger.info("Starting of isDisplayedPayInInstallment method");
		logger.info("Ending of isDisplayedPayInInstallment method");

		return lblPayInInstallment.isDisplayed();

	}

	public void clickOnPhysicalShipmentToggle() {
		logger.info("starting of clickOnPhysicalShipmentToggle method");

		/*
		 * try { this.scrollDown(1300); this.clickOnWebElement(tglPhysicalShipment);
		 * 
		 * } catch (Exception e) {
		 */
		this.scrollDown(3000);
		Actions act = new Actions(driver);
		act.moveToElement(tglPhysicalShipment).perform();

		logger.info("Ending of clickOnPhysicalShipmentToggle method");
	}

	public void clickOnDeliveryDateCheckbox() {
		logger.info("starting of clickOnPhysicalShipmentToggle method");

		try {
			this.chkSetDeliveryDate.click();
		} catch (Exception e) {
			this.clickOnWebElement(chkSetDeliveryDate);
		}

		logger.info("Ending of clickOnPhysicalShipmentToggle method");
	}

	public void clickOnGetShipmentCourse() {
		logger.info("starting of clickOnGetShipmentCourse method");

		try {
			this.getShipmentCourse.click();
		} catch (Exception e) {
			this.clickOnWebElement(getShipmentCourse);
		}

		logger.info("Ending of clickOnGetShipmentCourse method");
	}

	public void clickOnSelectAddress() {
		logger.info("starting of clickOnGetShipmentCourse method");

		try {
			this.btnSelectAddress.click();
		} catch (Exception e) {
			this.clickOnWebElement(btnSelectAddress);
		}

		logger.info("Ending of clickOnGetShipmentCourse method");
	}

	public void setFullName(String strFullName) {
		logger.info("Starting of setFullName method");

		this.txtFullName.sendKeys(strFullName);

		logger.info("Ending of setFullName method");
	}

	public void setAddress(String strAddress) {
		logger.info("Starting of setAddress method");

		this.txtAddress.sendKeys(strAddress);

		logger.info("Ending of setAddress method");
	}

	public void setAlternativeAddress(String strSecondAddress) {
		logger.info("Starting of setAlternativeAddress method");

		this.txtAlternativeAddress.sendKeys(strSecondAddress);

		logger.info("Ending of setAlternativeAddress method");
	}

	public void setCity(String strCity) {
		logger.info("Starting of setCity method");

		this.txtCity.sendKeys(strCity);

		logger.info("Ending of setCity method");
	}

	public void setPin(String strPin) {
		logger.info("Starting of setCity method");

		this.txtPin.sendKeys(strPin);

		logger.info("Ending of setCity method");
	}

	public void setMobile(String strMobile) {
		logger.info("Starting of setMobile method");

		this.txtMobile.sendKeys(strMobile);

		logger.info("Ending of setMobile method");
	}

	public void clickOnShipmentSave() {
		logger.info("starting of clickOnShipmentSave method");

		try {
			this.btnSaveAddress.click();
		} catch (Exception e) {
			this.clickOnWebElement(btnSaveAddress);
		}

		logger.info("Ending of clickOnShipmentSave method");
	}

	public void clickOnShipmentChange() {
		logger.info("starting of clickOnShipmentChange method");

		try {
			this.btnChange.click();
		} catch (Exception e) {
			this.clickOnWebElement(btnChange);
		}

		logger.info("Ending of clickOnShipmentChange method");
	}

	public void clickOnDeleteButton() {
		logger.info("starting of clickOnDeleteButton method");

		try {
			this.btnDelete.click();
		} catch (Exception e) {
			this.clickOnWebElement(btnDelete);
		}

		logger.info("Ending of clickOnDeleteButton method");
	}

	public void clickOnYesDelete() {
		logger.info("starting of clickOnYesDelete method");

		try {
			this.btnYesDelete.click();
		} catch (Exception e) {
			this.clickOnWebElement(btnYesDelete);
		}

		logger.info("Ending of clickOnYesDelete method");
	}

	public void clickOnGetCouponCourse() {
		logger.info("starting of clickOnGetCouponCourse method");

		try {
			this.getCouponCourse.click();
		} catch (Exception e) {
			this.clickOnWebElement(getCouponCourse);
		}

		logger.info("Ending of clickOnGetCouponCourse method");
	}

	public void clickOnViewAllCoupon() {
		logger.info("starting of clickOnViewAllCoupon method");

		try {
			this.btnCouponViewAll.click();
		} catch (Exception e) {
			this.clickOnWebElement(btnCouponViewAll);
		}

		logger.info("Ending of clickOnViewAllCoupon method");
	}

	public void setSearchCoupon(String strSearch) {
		logger.info("Starting of setSearchCoupon method");

		this.txtSearchCoupon.sendKeys(strSearch);

		logger.info("Ending of setSearchCoupon method");
	}

	public void clickOnApplyCoupon() {
		logger.info("starting of clickOnApplyCoupon method");

		try {
			this.btnCouponRemove.click();
			this.btnCouponViewAll.click();
			this.clickOnWebElement(btnApplyCoupon);
		} catch (Exception e) {
			this.btnCouponViewAll.click();
			this.btnApplyCoupon.click();
		}

		logger.info("Ending of clickOnApplyCoupon method");
	}

	public String getCouponAppliedLabel() {
		logger.info("Starting of getCouponAppliedLabel method");
		logger.info("Ending of getCouponAppliedLabel method");

		return msgCouponApplied.getText();
	}

	public boolean isDisplayedCoursePriceLabel() {
		logger.info("Starting of isdisplayedCoursePriceLabel method");
		logger.info("Ending of isdisplayedCoursePriceLabel method");

		return lblCoursePrice.isDisplayed();
	}

	public boolean isDisplayedInternetPriceLabel() {
		logger.info("Starting of isDisplayedInternetPriceLabel method");
		logger.info("Ending of isDisplayedInternetPriceLabel method");

		return lblInternetHandlingCharges.isDisplayed();
	}

	public boolean isDisplayedAmountPayableLabel() {
		logger.info("Starting of isDisplayedAmountPayableLabel method");
		logger.info("Ending of isDisplayedAmountPayableLabel method");

		return lblAmountPayable.isDisplayed();
	}

	public void clickonStateDropdown() {
		logger.info("Starting of clickonStateDropdown nethod");

		this.clickOnWebElement(drpState);

		logger.info("Ending of clickonStateDropdown method");
	}

	public void clickonSelectState() {
		logger.info("Starting of clickonSelectState nethod");

		this.clickOnWebElement(btnSelectState);

		logger.info("Ending of clickonSelectState method");
	}

	public boolean verifyTotalPrice() {
		logger.info("starting of verifyTotalPrice method");
		logger.info("Ending of verifyTotalPrice method");

		String[] coursePrice = driver
				.findElement(By.xpath("(//div[@class='storeBuy__priceDetails--distributed--price'])[1]")).getText()
				.split(" ");
		String[] coursePrices = coursePrice[1].split("/");
		String coursePrice1 = coursePrices[0];
		Integer actualCoursePrice = Integer.valueOf(coursePrice1);

		String[] discountPrice = driver
				.findElement(By.xpath("(//div[@class='storeBuy__priceDetails--distributed--price'])[2]")).getText()
				.split(" ");
		String[] discountPrices = discountPrice[1].split("/");
		String discountCoursePrice1 = discountPrices[0];
		Integer actualDiscountPrice = Integer.valueOf(discountCoursePrice1);

		String[] internetHandlingCharges = driver
				.findElement(By.xpath("(//div[@class='storeBuy__priceDetails--distributed--price'])[3]")).getText()
				.split(" ");
		String[] internetHandlingCharge = internetHandlingCharges[1].split("/");
		String internetHandlingCharges1 = internetHandlingCharge[0];
		Integer actualInternetHandlingCharges1 = Integer.valueOf(internetHandlingCharges1);

		String[] totalPrice = driver
				.findElement(By.xpath("(//div[@class='storeBuy__priceDetails--distributed--price'])[4]")).getText()
				.split(" ");
		String[] totalPrices = totalPrice[1].split("/");
		String totalPrices1 = totalPrices[0];
		Integer actualTotalPrice = Integer.valueOf(totalPrices1);

		int courseTotalPrice = actualCoursePrice - actualDiscountPrice + actualInternetHandlingCharges1;
		if (courseTotalPrice == actualTotalPrice) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isDisplayedWaterMarkLabel() {
		logger.info("Starting of isDisplayedWaterMarkLabel method");
		logger.info("Ending of isDisplayedWaterMarkLabel method");

		try {
			lblWaterMark.isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean isDisplayedCouponsForYouHeader() {
		logger.info("Starting of isDisplayedCouponsForYouHeader method");
		logger.info("Ending of isDisplayedCouponsForYouHeader method");

		if (this.lblCouponsForYou.isDisplayed())
			return true;
		else
			return false;
	}

	public void clickOnCouroselButton() {
		logger.info("Starting of clickOnCouroselButton method");
		for (int i = 0; i < 2; i++) {

			try {
				Actions actions = new Actions(driver);
				actions.moveToElement(btnForwardCourosel).click(btnForwardCourosel).perform();

			} catch (Exception e) {
				this.clickOnWebElement(btnForwardCourosel);
			}
		}
		logger.info("Ending of clickOnCouroselButton method");

	}

	public void clickOnBackwardCouroselButton() {
		logger.info("Starting of clickOnBackwardCouroselButton method");

		for (int i = 0; i < 2; i++) {

			try {
				Actions actions = new Actions(driver);
				actions.moveToElement(btnBackwardCourosel).click(btnBackwardCourosel).perform();
			} catch (Exception e) {
				this.clickOnWebElement(btnBackwardCourosel);
			}
		}

		logger.info("Ending of clickOnBackwardCouroselButton method");
	}

	public void getAvailableCoupon() {
		logger.info("Starting of getAvailableCoupon method");

		try {
			this.getCoupon.click();

		} catch (Exception e) {
			this.clickOnWebElement(getCoupon);
		}

		logger.info("Ending of getAvailableCoupon method");

	}

	public void getAvailableCourse() {
		logger.info("Starting of getAvailableCourse method");

		try {
			this.getAvailableCouponCourse.click();

		} catch (Exception e) {
			this.clickOnWebElement(getAvailableCouponCourse);
		}

		logger.info("Ending of getAvailableCourse method");

	}

	public boolean isDisplayedAvailableCouponCourse() {
		logger.info("Starting of isDisplayedAvailableCouponCourse method");
		logger.info("Ending of isDisplayedAvailableCouponCourse method");

		if (this.getAvailableCouponCourse.isDisplayed())
			return true;
		else
			return false;
	}

	public boolean isDisplayedCoupon() {
		logger.info("Starting of isDisplayedCoupon method");
		logger.info("Ending of isDisplayedCoupon method");

		return getCouponDisplayed.isDisplayed();
	}

	public void closeBuyNowPage() {
		logger.info("starting of closeBuyNowPage method");

		this.hardWait(10);
		this.driver.switchTo().frame(0);
		Actions act = new Actions(driver);
		act.click(btnCloseBuyNowPage).perform();
		this.driver.switchTo().defaultContent();

		logger.info("Ending of closeBuyNowPage method");
	}

	public String getContentLabel() {
		logger.info("Starting of getContentLabel method");
		logger.info("Ending of getContentLabel method");

		return this.lblContent.getText();
	}

	public void clickOnVideoTestCancel() {
		logger.info("Starting of clickOnVideoTestCancel method");

		try {
			this.clickOnWebElement(videoTestCancel);
		} catch (Exception e) {
			this.videoTestCancel.click();
		}

		logger.info("Ending of clickOnVideoTestCancel method");
	}

	public void clickOnMakeInActiveIcon() {
		logger.info("starting of clickOnMakeActiveIcon method");

		this.clickOnWebElement(makeActiveIcon);

		logger.info("Ending of clickOnMakeActiveIcon method");
	}

	public void clickDeleteIcon() {
		logger.info("starting of clickDeleteIcon method");

		this.clickOnWebElement(deleteIcon);

		logger.info("Ending of clickDeleteIcon method");
	}

}