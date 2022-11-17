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

public class StudentBuyCoursePage extends BaseClassplusAutomationPage {

	@FindBy(xpath = "//p[text()='Store']")
	private WebElement btnStore;

	@FindBy(xpath = "//input[@placeholder='Search for a course']")
	private WebElement txtSearch;

	@FindBy(xpath = "//div[contains(text(),'FILTER BY TOPICS')]")
	private WebElement lblFilterByTopics;

//	@FindBy(xpath = "//span[contains(text(),'B2B Testing')]")
//	private WebElement getCourse;

//	@FindBy(xpath = "//span[contains(text(),'studentTestingInstallment 1')]")
//	private WebElement getCourse;

	private String courseXpath = "//div[@class='selectorCheat']//span[text()='${courseName}']";

	@FindBy(xpath = "//span[contains(text(),' Overview ')]")
	private WebElement lblOverView;

	@FindBy(xpath = "//div[@class='publishPopupTitle']")
	private WebElement lblTitle;

	@FindBy(xpath = "//span[contains(text(),'Select State')]")
	private WebElement SelectStateDropDown;

	@FindBy(xpath = "//li[contains(text(),'Telangana')]")
	private WebElement btnState;

	@FindBy(xpath = "//button[@class='storeBuy__cta--button cursorPointer']")
	private WebElement btnBuyNow;

	@FindBy(xpath = "//div[contains(text(),'View All')]")
	private WebElement btnViewAllCouponCode;

	@FindBy(xpath = "//div[@class='storeCoupon__list--coupon']/div/div[2]")
	private WebElement btnApplyCoupon;

	@FindBy(xpath = "//div[contains(text(),'Purchase Course in Installments')]")
	private WebElement btnPurchaseCourseIntallments;

	@FindBy(xpath = "//button[contains(text(),'Pay 1st installment')]")
	private WebElement btnPayFirstInstallment;

	@FindBy(xpath = "//div//div[@id='modal-close']")
	private WebElement btncloseBuyNowPage;

	@FindBy(xpath = "(//div[@class='Modal_Modal__3QCDw']//img)[1]")
	private WebElement btnclosePaymentFailedDailogBox;

	@FindBy(xpath = "//div[contains(text(),'Netbanking')]")
	private WebElement btnNetbanking;
	@FindBy(xpath = "//div[text() = 'Card']")
	private WebElement btnCard;

	@FindBy(xpath = "//div[@id='bank-item-SBIN']")
	private WebElement btnSbiBank;

	@FindBy(xpath = "//input[@id='card_number']")
	private WebElement inputCardNumber;

	@FindBy(xpath = "//input[@id='card_number']")
	private WebElement inputCardExpiry;

	@FindBy(xpath = "//span[text()='Add New Card']")
	private WebElement lblNewCard;

	@FindBy(xpath = "//input[@id='card_cvv']")
	private WebElement inputCardCvv;

	@FindBy(xpath = "//div[@class='storeBuy__promo__apply cursorPointer']")
	private WebElement btnChange;

	@FindBy(xpath = "//div[@id='footer']/span[@id='footer-cta']")
	private WebElement btnPayAmount;

	@FindBy(xpath = "//button[contains(text(),'Success')]")
	private WebElement btnDummyPaymentSuccess;

	@FindBy(xpath = "//div[@class='modal2']/div[1]/img")
	private WebElement btnClosePaymentStatusPopup;

	@FindBy(xpath = "//div[@class='modal2']/div[2]/p")
	private WebElement getPaymentStatus;

	@FindBy(xpath = "//button[contains(text(),'Download Receipt')]")
	private WebElement btnDownloadReceipt;

	@FindBy(xpath = "//div[@class='Shipment__Buy__AddressSection--SelectAddress']")
	private WebElement btnSelectAddress;

	@FindBy(xpath = "//span[@class=\"StoreCarousels_viewAll__3bJBi\"]")
	private WebElement btnViewAllCourses;

	@FindBy(xpath = "//div[contains(text(),'YOUR PURCHASED COURSES')]/span")
	private WebElement btnViewAllPurchased;

	@FindBy(xpath = "//div[@class='razorpay-container']//iframe")
	private WebElement iframePayment;

	@FindBy(xpath = "//button[contains(text(),'Start Learning')]")
	private WebElement btnStartLearning;

	@FindBy(xpath = "//div[@class='Shipment__Modal__Body__Input']/div[1]//input")
	private WebElement inputFullName;

	@FindBy(xpath = "//div[@class='Shipment__Modal__Body__Input']/div[2]//input")
	private WebElement inputAddressLine1;

	@FindBy(xpath = "//div[@class='Shipment__Modal__Body__Input']/div[5]//input")
	private WebElement inputCity;

	@FindBy(xpath = "//div[@class='Shipment__Modal__Body__Input']/div[6]//input")
	private WebElement inputState;

	@FindBy(xpath = "//div[@class='Shipment__Modal__Body__Input']/div[7]//input")
	private WebElement inputPinCode;

	@FindBy(xpath = "//div[@class='Shipment__Modal__Body__Input']/div[8]//input")
	private WebElement inputMobileNumber;

	@FindBy(xpath = "//button[@class='Shipment__Modal__Bottom--Save']")
	private WebElement btnSaveAddress;

	@FindBy(xpath = "//button[@class='Shipment__Modal__Bottom--Save'][contains(text(),'Proceed to Payment')]")
	private WebElement btnProceedToPayment;

	@FindBy(xpath = "//div[text()='Address']/parent::div/div[3]/span[2]")
	private WebElement btnChangeAddress;

	@FindBy(xpath = "//div[@class='Shipment__Modal__Body__AddressList--Item--Actions--Delete'][text()='Delete']")
	private List<WebElement> btnDeleteAddress;

	@FindBy(xpath = "//div[@class='Shipment__DeleteModal__Body--Delete'][text()='Yes, Delete']")
	private WebElement btnConfirmDeleteAddress;

	@FindBy(xpath = "//div[text()='PRICE DETAILS']//parent::div//div[text()='Course Price']//parent::div/div[2]")
	private WebElement divCoursePrice;

	@FindBy(xpath = "//div[text()='G.S.T. (18%)']//parent::div/div/parent::div/div[2]")
	private WebElement divCourseDiscount;

	@FindBy(xpath = "//div[text()='Coupon discount(UWIPA8)']//parent::div/div/parent::div/div[2]")
	private WebElement divCouponDiscount;

	@FindBy(xpath = "//div[text()='PRICE DETAILS']//parent::div//div[text()='Internet Handling Charges']//parent::div/div[2]")
	private WebElement divInternetFees;

	@FindBy(xpath = "//div[text()='PRICE DETAILS']//parent::div//div[text()='Amount Payable']//parent::div/div[2]")
	private WebElement divAmountPayable;

	@FindBy(xpath = "//div[text()='Payment Summary']/parent::div//div[3]//div[2]")
	private WebElement divPurchasedDate;

	@FindBy(xpath = "//span[text()='Content']")
	private WebElement btnContentCourse;

	@FindBy(xpath = "//span[text()='Live Classes']")
	private WebElement btnLiveClasses;

	@FindBy(xpath = "//iframe[@class='razorpay-checkout-frame']")
	private WebElement iframe;

	@FindBy(xpath = "//input[@id='netbanking-3']")
	private WebElement rdoOthers;

	@FindBy(xpath = "//button[@class='btn svelte-h1cpdz']")
	private WebElement btnSumbit;

	@FindBy(xpath = "//span[@id='footer-cta']")
	private WebElement btnPay;

	@FindBy(xpath = "//div[@class='overview-priceContainer']//div/div/div/../following-sibling::div/div/preceding-sibling::div")
	private WebElement lblPurchasedDate;

	@FindBy(xpath = "//div[@class='overview-priceContainer']//div/div/div/../following-sibling::div/div/preceding-sibling::div/following-sibling::div")
	private WebElement lblCoursePurchasedDate;

	private static final Logger logger = Logger.getLogger(StudentBuyCoursePage.class.getName());

	public StudentBuyCoursePage(WebDriver driver) {
		super(driver);
		logger.info("Starting of StudentBuyCoursePage method");

		PageFactory.initElements(driver, this);

		logger.info("Ending of StudentBuyCoursePage method");

	}

	public void clickOnStoreButton() {
		logger.info("starting of clickOnStoreButton method");

		try {
			Thread.sleep(2000);
			this.clickOnWebElement(btnStore);
		} catch (Exception e) {
			this.btnStore.click();
		}

		logger.info("Ending of clickOnStoreButton method");
	}

	public void setSearch(String strSearch) {
		logger.info("Starting of setSearch method");

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
			this.waitForElementVisibilty(course);
			course.click();
		} catch (Exception e) {
			this.clickOnWebElement(course);
		}

		logger.info("Ending of clickOnGetCourse method");
	}

	public String getOverViewLabelText() {
		logger.info("Starting of getOverViewLabel method");
		logger.info(" Ending of getOverViewLabel method");
		return this.lblOverView.getText();
	}

	public String getTitleLabelText() {
		logger.info("Starting of getOverViewLabel method");
		logger.info(" Ending of getOverViewLabel method");
		this.explicitWait(lblTitle);
		return this.lblTitle.getText();
	}

	public void clickonSelectStateDropDown() {
		logger.info("Starting of clickonSelectStateButton method");

		try {
			this.SelectStateDropDown.click();
		} catch (Exception e) {
			this.clickOnWebElement(SelectStateDropDown);
		}

		logger.info("Ending of clickonSelectStateButton method");
	}

	public void clickonStateButton() {
		logger.info("Starting of clickonStateButton nethod");

		this.clickOnWebElement(btnState);

		logger.info("Ending of clickonStateButton method");
	}

	public void clickOnBuyNowButton() {
		logger.info("starting of clickOnBuyNowButton method");
//		this.scrollDown(200);
		try {
			this.scrollIntoView(btnBuyNow);
			this.btnBuyNow.click();
		} catch (Exception e) {
			this.clickOnWebElement(btnBuyNow);
		}

		logger.info("Ending of clickOnBuyNowButton method");
	}

	public void clickOnViewAllCouponCodeButton() {
		logger.info("starting of clickOnViewAllCouponCodeButton method");

		try {
			this.clickOnWebElement(btnViewAllCouponCode);
		} catch (Exception e) {
			this.btnViewAllCouponCode.click();
		}

		logger.info("Ending of clickOnViewAllCouponCodeButton method");
	}

	public void clickOnApplyCouponCodeButton() {
		logger.info("starting of clickOnApplyCouponCodeButton method");
		this.explicitWait(btnApplyCoupon);
		this.btnApplyCoupon.click();

		logger.info("Ending of clickOnApplyCouponCodeButton method");
	}

	public boolean checkVisibilityOfPurchaseInstallmentbtn() {
		logger.info("starting of checkVisibilityOfPurchaseInstallmentbtn method");
		try {
			if (this.btnPurchaseCourseIntallments.isDisplayed())
				return true;
			else
				return false;
		} catch (Exception e) {
			return false;
		}

	}

	public void clickOnPurchaseCourseInstallments() {
		logger.info("starting of clickOnPurchaseCourseInstallments method");
		try {
			this.btnPurchaseCourseIntallments.click();
		} catch (Exception e) {
			this.clickOnWebElement(btnPurchaseCourseIntallments);
		}

		logger.info("Ending of clickOnPurchaseCourseInstallments method");
	}

	public void clickOnPayFirstInstallment() {
		logger.info("starting of clickOnPayFirstInstallment method");

		try {
			this.clickOnWebElement(btnPayFirstInstallment);
		} catch (Exception e) {
			this.btnPayFirstInstallment.click();
		}

		logger.info("Ending of clickOnPayFirstInstallment method");
	}

	public void closeBuyNowPage() {
		logger.info("starting of closeBuyNowPage method");
		try {
			this.hardWait(10);
			this.driver.switchTo().frame(0);
			Actions act = new Actions(driver);
			act.click(btncloseBuyNowPage).perform();
			this.driver.switchTo().defaultContent();
		} catch (Exception e) {
			this.clickOnWebElement(btncloseBuyNowPage);

		}

		logger.info("Ending of closeBuyNowPage method");
	}

	public void closePaymentFailedDialogBox() {
		logger.info("Starting of closePaymentFailedDialogBox");

		try {
			this.clickOnWebElement(btnclosePaymentFailedDailogBox);
		} catch (Exception e) {
			this.btnclosePaymentFailedDailogBox.click();
		}

		logger.info("Ending of closePaymentFailedDialogBox");

	}

	public void clickOnNetbanking() {
		logger.info("starting of clickOnNetbanking method");

		try {
//			this.explicitWait(logoClassPlusInPaymentPopup);
//			this.logoClassPlusInPaymentPopup.click();
//			this.scrollIntoView(btnNetbanking);
			this.explicitWait(iframePayment);
			driver.switchTo().frame(iframePayment);
			this.scrollIntoView(btnNetbanking);
			this.btnNetbanking.click();
		} catch (Exception e) {
			this.clickOnWebElement(btnNetbanking);
		}

		logger.info("Ending of clickOnNetbanking method");
	}

	public void clickOnCard() {
		logger.info("starting of clickOnCard method");
		try {
			this.explicitWait(iframePayment);
			driver.switchTo().frame(0);
			this.scrollIntoView(btnCard);
			this.btnCard.click();
		} catch (Exception e) {
			this.clickOnWebElement(btnCard);
		}

		logger.info("ending of clickOnCard method");
	}

	public void selectBank() {
		logger.info("starting of selectBank method");
		try {
			this.btnSbiBank.click();
		} catch (Exception e) {
			this.clickOnWebElement(btnSbiBank);
		}

		logger.info("Ending of selectBank method");
	}

	public void inputCardNumber(String cardDetails) {
		logger.info("Starting of inputCardNumber");
		try {
			this.hardWait(5);
			this.waitForElementVisibilty(inputCardNumber);
			this.inputCardNumber.click();
			this.inputCardNumber.sendKeys(cardDetails);

		} catch (Exception e) {
			this.clickOnWebElement(inputCardNumber);
			this.inputCardNumber.sendKeys(cardDetails);

		}
		logger.info("Ending of inputCardNumber");
	}

	public void inputCardExpiry(String cardDetails) {
		logger.info("Starting of inputCardExpiry");
		try {
			this.hardWait(5);
			this.clickOnWebElement(lblTitle);
			this.waitForElementVisibilty(inputCardExpiry);
			this.inputCardExpiry.click();
			this.inputCardExpiry.sendKeys(cardDetails);

		} catch (Exception e) {
			this.clickOnWebElement(inputCardExpiry);
			this.inputCardExpiry.sendKeys(cardDetails);

		}
		logger.info("Ending of inputCardNumber");
	}

	public void inputCardCvv(String cardDetails) {
		logger.info("Starting of inputCardCvv");
		try {
			this.hardWait(5);
			this.waitForElementVisibilty(inputCardCvv);
			this.inputCardCvv.click();
			this.inputCardCvv.sendKeys(cardDetails);

		} catch (Exception e) {
			this.clickOnWebElement(inputCardCvv);
			this.inputCardCvv.sendKeys(cardDetails);

		}
		logger.info("Ending of inputCardNumber");
	}

	public void clickOnPayAmountButton() {
		logger.info("starting of clickOnPayAmountButton method");
		try {
			this.btnPayAmount.click();
		} catch (Exception e) {
			this.clickOnWebElement(btnPayAmount);
		}
		this.switchToNewWindow();
		this.closeWindow();

		logger.info("Ending of clickOnPayAmountButton method");
	}

	public void clickOnOthersButton() {
		logger.info("starting of clickOnOthersButton method");
		driver.switchTo().frame(iframe);

		try {
			this.rdoOthers.click();
		} catch (Exception e) {
			this.clickOnWebElement(rdoOthers);
		}

		logger.info("Ending of clickOnOthersButton method");
	}

	public void clickOnSubmitButton() {
		logger.info("starting of clickOnSubmitButton method");
		try {
			this.btnSumbit.click();
		} catch (Exception e) {
			this.clickOnWebElement(btnSumbit);
		}
		logger.info("Ending of clickOnSubmitButton method");
	}

	public void clickOnPay() {
		logger.info("starting of clickOnPay method");
		try {
			this.btnPay.click();
		} catch (Exception e) {
			this.clickOnWebElement(btnPay);
		}
		logger.info("Ending of clickOnPay method");
	}

	public void clickOnDummyPaymentSuccess() {
		logger.info("starting of clickOnDummyPaymentSuccess method");
		ArrayList<String> tab = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tab.get(1));
		try {

			this.btnDummyPaymentSuccess.click();
		} catch (Exception e) {
			this.clickOnWebElement(btnDummyPaymentSuccess);
		}
		driver.switchTo().window(tab.get(0));

		logger.info("Ending of clickOnDummyPaymentSuccess method");
	}

	public void closePaymentStatusPopup() {
		logger.info("starting of closePaymentStatusPopup method");
		try {
			this.btnStartLearning.click();
		} catch (Exception e) {
			this.clickOnWebElement(btnStartLearning);
		}

		logger.info("Ending of closePaymentStatusPopup method");
	}

	public String getPaymentStatusText() {
		logger.info("starting of closePaymentStatusPopup method");

		this.explicitWait(getPaymentStatus);

		logger.info("Ending of closePaymentStatusPopup method");
		return getPaymentStatus.getText();

	}

	public void clickOnSelectAddress() {
		logger.info("starting of clickOnSelectAddress method");
		try {
			this.explicitWait(btnSelectAddress);
			this.btnSelectAddress.click();
		} catch (Exception e) {
			this.clickOnWebElement(btnSelectAddress);
		}

		logger.info("Ending of clickOnSelectAddress method");
	}

	public void clickOnViewAllCourses() {
		logger.info("starting of clickOnViewAllCourses method");
		try {
			this.scrollIntoView(btnViewAllCourses);
			this.btnViewAllCourses.click();
		} catch (Exception e) {
			this.clickOnWebElement(btnViewAllCourses);
		}

		logger.info("Ending of clickOnViewAllCourses method");
	}

	public void setFullName(String name) {
		logger.info("starting of setFullName method");

		this.scrollIntoView(inputFullName);
		this.inputFullName.sendKeys(name);

		logger.info("Ending of setFullName method");
	}

	public void setAddress(String address) {
		logger.info("starting of setAddress method");

		this.scrollIntoView(inputAddressLine1);
		this.inputAddressLine1.sendKeys(address);

		logger.info("Ending of setAddress method");
	}

	public void setCity(String city) {
		logger.info("starting of setCity method");

		this.scrollIntoView(inputCity);
		this.inputCity.sendKeys(city);

		logger.info("Ending of setCity method");
	}

	public void setState(String state) {
		logger.info("starting of setState method");

		this.scrollIntoView(inputState);
		this.inputState.sendKeys(state);

		logger.info("Ending of setState method");
	}

	public void setPinCode(String pincode) {
		logger.info("starting of setPinCode method");

		this.scrollIntoView(inputPinCode);
		this.inputPinCode.sendKeys(pincode);

		logger.info("Ending of setPinCode method");
	}

	public void setMobileNumber(String mobileNumber) {
		logger.info("starting of setMobileNumber method");

		this.scrollIntoView(inputMobileNumber);
		this.inputMobileNumber.sendKeys(mobileNumber);

		logger.info("Ending of setMobileNumber method");
	}

	public void clickOnButtonSaveAddress() {
		logger.info("starting of clickOnButtonSaveAddress method");
		try {

			this.btnSaveAddress.click();
		} catch (Exception e) {
			this.clickOnWebElement(btnSaveAddress);
		}

		logger.info("Ending of clickOnButtonSaveAddress method");
	}

	public void clickOnButtonProceedToPayment() {
		logger.info("starting of clickOnButtonProceedToPayment method");
		try {
			this.hardWait(2);
			this.clickOnWebElement(btnProceedToPayment);
		} catch (Exception e) {
			this.btnProceedToPayment.click();
		}

		logger.info("Ending of clickOnButtonProceedToPayment method");
	}

	public boolean checkVisibilityOfChangeAddress() {
		logger.info("starting of checkVisibilityOfChangeAddress method");
		try {
			if (btnChangeAddress.isDisplayed())
				return true;
			else
				return false;
		} catch (Exception e) {
			return false;
		}
	}

	public void clickOnChangeAddressButton() {
		logger.info("starting of clickOnChangeAddressButton method");
		try {

			this.btnChangeAddress.click();
		} catch (Exception e) {
			this.clickOnWebElement(btnChangeAddress);
		}

		logger.info("Ending of clickOnChangeAddressButton method");
	}

	public void deleteSavedAddress() {
		logger.info("starting of deleteSavedAddress method");

//		this.explicitWait(btnDeleteAddress);
		for (int i = 0; i < this.btnDeleteAddress.size(); i++) {
			this.btnDeleteAddress.get(i).click();
			this.explicitWait(btnConfirmDeleteAddress);
			this.btnConfirmDeleteAddress.click();
		}

		logger.info("Ending of deleteSavedAddress method");
	}

	public float getCoursePrice() {
		logger.info("starting of getCoursePrice method");

		String coursePriceText = this.divCoursePrice.getText();
		coursePriceText = coursePriceText.replaceAll("[^0-9.]+", "");
		logger.info("Ending of getCoursePrice method");
		return Float.parseFloat(coursePriceText);
	}

	public float getCourseDiscount() {
		logger.info("starting of getCourseDiscount method");

		String courseDicountText = this.divCourseDiscount.getText();
		courseDicountText = courseDicountText.replaceAll("[^0-9.]+", "");
		logger.info("Ending of getCourseDiscount method");
		return Float.parseFloat(courseDicountText);
	}

	public float getCouponDiscount() {
		logger.info("starting of getCouponDiscount method");

		String couponDicountText = this.divCourseDiscount.getText();
		couponDicountText = couponDicountText.replaceAll("[^0-9.]+", "");
		logger.info("Ending of getCouponDiscount method");
		return Float.parseFloat(couponDicountText);
	}

	public float getInternetFees() {
		logger.info("starting of getInternetFees method");

		String courseInternetFeesText = this.divInternetFees.getText();
		courseInternetFeesText = courseInternetFeesText.replaceAll("[^0-9.]+", "");
		logger.info("Ending of getInternetFees method");
		return Float.parseFloat(courseInternetFeesText);
	}

	public float getAmountPayable() {
		logger.info("starting of getAmountPayable method");

		String courseAmountPayableText = this.divAmountPayable.getText();
		courseAmountPayableText = courseAmountPayableText.replaceAll("[^0-9.]+", "");
		logger.info("Ending of getInternetFees method");
		return Float.parseFloat(courseAmountPayableText);
	}

	public boolean getBuyCourseAmount() {
		logger.info("starting of getBuyCourseAmount method");
		logger.info("Ending of getBuyCourseAmount method");

		float a = this.getCoursePrice();
		float b = this.getCourseDiscount();
		float c = this.getInternetFees();
		float d = this.getPriceShownInBuyNow();

		if ((a + b + c) == d) {
			return true;

		} else {
			return false;
		}
	}

	public float getPriceShownInBuyNow() {
		logger.info("starting of getPriceShownInBuyNow method");

		String buyNowButtonText = this.btnBuyNow.getText();
		buyNowButtonText = buyNowButtonText.replaceAll("[^0-9.]+", "");
		logger.info("Ending of getPriceShownInBuyNow method");
		return Float.parseFloat(buyNowButtonText);
	}

	public boolean checkPurchasedDateVisibility() {
		logger.info("starting of checkPurchasedDateVisibility method");
		try {
			if (divPurchasedDate.isDisplayed())
				return true;
			else
				return false;
		} catch (Exception e) {
			return false;
		}
	}

	public void clickOnViewAllPurchased() {
		logger.info("starting of clickOnViewAllPurchased method");
		try {
			this.explicitWait(btnViewAllPurchased);
			this.btnViewAllPurchased.click();
		} catch (Exception e) {
			this.clickOnWebElement(btnViewAllPurchased);
		}

	}

	public String getPurchasedDate() {
		logger.info("Starting of getPurchasedDate method");
		logger.info("Ending of getPurchasedDate method");

		return lblPurchasedDate.getText();
	}

	public boolean isDisplayedCoursePurchasedDate() {
		logger.info("Starting of isDisplayedCoursePurchasedDate method");
		logger.info("Ending of isDisplayedCoursePurchasedDate method");
		this.scrollIntoView(lblCoursePurchasedDate);

		return lblCoursePurchasedDate.isDisplayed();
	}
}
