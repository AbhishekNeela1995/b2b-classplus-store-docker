package com.classplusapp.web.pages.tutor_website;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.classplusapp.web.pages.BaseClassplusAutomationPage;
import com.classplusapp.web.pages.student.StudentPhysicalShipmentPage;

public class StudentPhysicalShipmentPage2 extends BaseClassplusAutomationPage {

	@FindBy(xpath = "//span[text()='Contains Offline Study material']")
	private WebElement physicalMaterialtag;

	@FindBy(xpath = "//span[contains(text(),\"Contains Offline Study material\")]")
	private WebElement offlineMaterialForShipmentText;

	@FindBy(xpath = "//span[contains(text(),\"Tentative Delivery:\")]")
	private WebElement TenativeDelivery;

	@FindBy(xpath = "//div[@class='Shipment__Buy__AddressSection--Description']")
	private WebElement shipmentAddressDescription;

	@FindBy(xpath = "(//div[@class='Shipment__Modal__Body__AddressList--Item--Actions--Edit'])[1]")
	private WebElement editAddressBtn;

	@FindBy(xpath = "//div[@class='Shipment_Buy_AddressSection--SelectAddress']")
	private WebElement btnSelectAddress;

	@FindBy(xpath = "//div[contains(text(),'YOUR PURCHASED COURSES')]/span")
	private WebElement btnViewAllPurchased;

	@FindBy(xpath = "//button[contains(text(),'Start Learning')]")
	private WebElement btnStartLearning;

	@FindBy(xpath = "//div[text()='Full Name*']/following-sibling::input")
	private WebElement inputFullName;

	@FindBy(xpath = "//div[text()='Address Line 1*']/following-sibling::input")
	private WebElement inputAddressLine1;

	@FindBy(xpath = "//div[text()='Address Line 2 (Optional)']/following-sibling::input")
	private WebElement inputAddressLine2;

	@FindBy(xpath = "//div[text()='Landmark (Optional)']/following-sibling::input")
	private WebElement inputLandmark;

	@FindBy(xpath = "//div[text()='City/District*']/following-sibling::input")
	private WebElement inputCity;

	@FindBy(xpath = "//div[@class='Dropdown_ChatDropdown__34tKP ChatDropdown Shipment__Modal__Body__Input--Field--State']/..//following-sibling::input")
	private WebElement inputState;

	@FindBy(xpath = "//div[text()='PinCode*']/following-sibling::input")
	private WebElement inputPinCode;

	@FindBy(xpath = "//div[text()='Mobile Number*']/following-sibling::input")
	private WebElement inputMobileNumber;

	@FindBy(xpath = "//div[@class='Shipment__Modal__Bottom']//div//following-sibling::button")
	private WebElement btnSaveAddress;

	@FindBy(xpath = "//button[@class='Shipment_Modal_Bottom--Save'][contains(text(),'Proceed to Payment')]")
	private WebElement btnProceedToPayment;

	@FindBy(xpath = "//span[@class='Shipment__Buy__AddressSection--Change']//parent::span")
	private WebElement btnChangeAddress;

	@FindBy(xpath = "//div[@class='Shipment_ModalBody_AddressList--Item--Actions--Delete'][text()='Delete']")
	private WebElement btnDeleteAddress;

	@FindBy(xpath = "//div[@class='Shipment_DeleteModal_Body--Delete'][text()='Yes, Delete']")
	private WebElement btnConfirmDeleteAddress;

	@FindBy(xpath = "//div[@class=\"Shipment__Modal__Body__AddressList--AddNew\"]")
	private WebElement addNewAddress;

	@FindBy(xpath = "//div[@class='ui checkbox']//input")
	private WebElement setasDefault;

	@FindBy(xpath = "//div[@class='Shipment__Buy__AddressSection--SelectAddress']")
	private WebElement selectedAddressData;

	@FindBy(xpath = "//div[contains(text(),\"Delivery Address\")]/following-sibling::div[2]")
	private WebElement labelDeliveryAddress;

	@FindBy(xpath = "//div[contains(text(),'Purchased Date')]//following-sibling::div")
	private WebElement labelDatePurchase;

	@FindBy(xpath = "//span[contains(text(),'Download Receipt')]")
	private WebElement btnDownloadInvoice;

	@FindBy(xpath = "//span[contains(text(), 'Bill to :')]//following-sibling::span[2]")
	private WebElement pdfAddress1;

	@FindBy(xpath = "//span[contains(text(), 'Bill to :')]//following-sibling::span[3]")
	private WebElement pdfAddress2;

	@FindBy(xpath = "//span[contains(text(),'Invoice Date')]")
	private WebElement pdfDatePurchase;

	@FindBy(xpath = "//img[@class='Shipment__Modal__Head--Close']")
	private WebElement btnCloseAddress;

	private static final Logger logger = Logger.getLogger(StudentPhysicalShipmentPage.class.getName());

	public StudentPhysicalShipmentPage2(WebDriver driver) {
		super(driver);
		logger.info("Starting of StudentBuyCoursePage method");

		PageFactory.initElements(driver, this);

		logger.info("Ending of StudentBuyCoursePage method");
	}

	public String tenativeDelivery() {
		logger.info("starting of TenativeDelivery method");
		String text = this.TenativeDelivery.getText();
		System.out.println(text);
		logger.info("Ending of TenativeDelivery method");
		return text;
	}

	public String physicalMaterial() {
		logger.info("starting of physicalMaterial method");
		String text = this.physicalMaterialtag.getText();
		logger.info("Ending of physicalMaterial method");
		return text;
	}

	public boolean notPhysicalMaterial() {
		logger.info("starting of notPhysicalMaterial method");
		try {
			if (physicalMaterialtag.isDisplayed())
				return false;
			else
				return true;
		} catch (Exception e) {
			logger.info("error found" + e);
			return false;
		}
	}

	public boolean notTentativeDelivery() {
		logger.info("starting of notTentativeDelivery method");
		try {
			if (TenativeDelivery.isDisplayed())
				return false;
			else
				return true;
		} catch (Exception e) {
			logger.info("error found" + e);
			return false;
		}
	}

	public String shipmentAddressDesction() {
		logger.info("starting of clickOnSelectAddress method");
		if (this.shipmentAddressDescription.isDisplayed()) {
			return this.shipmentAddressDescription.getText();
		} else
			return "";
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

	public void setFullName(String name) {
		logger.info("starting of setFullName method");

		this.scrollIntoView(inputFullName);
		this.inputFullName.sendKeys(name);

		logger.info("Ending of setFullName method");
	}

	public void btnDownloadInvoice() {
		logger.info("starting of btnDownloadInvoice method");

		// this.scrollIntoView(btnDownloadInvoice);
		this.btnDownloadInvoice.click();

		logger.info("Ending of btnDownloadInvoice method");
	}

	public void setAddress1(String address) {
		logger.info("starting of setAddress method");

		this.scrollIntoView(inputAddressLine1);
		this.inputAddressLine1.sendKeys(address);

		logger.info("Ending of setAddress method");
	}

	public void setAddress2(String address) {
		logger.info("starting of setAddress2 method");

		this.scrollIntoView(inputAddressLine2);
		this.inputAddressLine2.sendKeys(address);

		logger.info("Ending of setAddress2 method");
	}

	public String labelDeliveryAddress() {
		this.scrollIntoView(labelDeliveryAddress);
		System.out.println(this.labelDeliveryAddress.getText());
		return this.labelDeliveryAddress.getText();

	}

	public String labelDatePurchase() {
		this.scrollIntoView(labelDatePurchase);
		return this.labelDatePurchase.getText();

	}

	public void setLandmark(String address) {
		logger.info("starting of setLandmark method");

		this.scrollIntoView(inputLandmark);
		this.inputLandmark.sendKeys(address);

		logger.info("Ending of setLandmark method");
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
		/*
		 * try { this.clickOnWebElement(btnSaveAddress); } catch (Exception e) {
		 * this.btnSaveAddress.click(); }
		 */
		Actions act = new Actions(driver);
		act.click(btnSaveAddress).perform();

		logger.info("Ending of clickOnButtonSaveAddress method");
	}

	public void clickOnButtonProceedToPayment() {
		logger.info("starting of clickOnButtonProceedToPayment method");
		try {
			this.clickOnWebElement(btnProceedToPayment);

		} catch (Exception e) {
			this.btnProceedToPayment.click();
		}

		logger.info("Ending of clickOnButtonProceedToPayment method");
	}

	public boolean checkVisibilityOfChangeAddress() {
		logger.info("starting of checkVisibilityOfChangeAddress method");
		if (btnChangeAddress.isDisplayed())
			return true;
		else
			return false;
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

		this.explicitWait(btnDeleteAddress);
		this.btnDeleteAddress.click();
		this.explicitWait(btnConfirmDeleteAddress);
		this.btnConfirmDeleteAddress.click();

		logger.info("Ending of deleteSavedAddress method");
	}

	public boolean verifyEditBtn() {
		logger.info("starting of verifyEditBtn method");
		if (editAddressBtn.isDisplayed())
			return true;
		else
			return false;
	}

	public void clickOnEditBtn() {
		logger.info("starting of verifyEditBtn method");
		try {

			this.editAddressBtn.click();
		} catch (Exception e) {
			this.clickOnWebElement(editAddressBtn);
		}
		logger.info("Ending of clickOnAddNewAddress method");
	}

	public void clickOnAddNewAddress() {
		logger.info("starting of clickOnAddNewAddress method");
		try {

			this.addNewAddress.click();
		} catch (Exception e) {
			this.clickOnWebElement(addNewAddress);
		}

		logger.info("Ending of clickOnAddNewAddress method");
	}

	public void clickOnsetAsDefault() {
		logger.info("starting of clickOnsetAsDefault method");

		try {
			this.clickOnWebElement(setasDefault);
		} catch (Exception e) {
			this.setasDefault.click();
		}

		logger.info("Ending of clickOnsetAsDefault method");
	}

	public boolean verifyAddAddressData() {
		logger.info("starting of verifySelectedAddressData method");
		if (addNewAddress.isDisplayed())
			return true;
		else
			return false;
	}

	public String selectedAddressData() {
		logger.info("starting of selectedAddressData method");
		if (selectedAddressData.isDisplayed()) {
			String text = selectedAddressData.getText();
			return text;
		} else
			return "Text Not Found";
	}

	public boolean isNameAddressData() {
		logger.info("starting of isNameAddressData method");
		if (inputFullName.getText().length() >= 0) {
			return true;
		} else
			return false;
	}

	public String pdfAddress() {
		logger.info("starting of pdfAddress method");
		{
			this.switchToNewWindow();
			this.waitForElementVisibilty(pdfAddress1);
			this.waitForElementVisibilty(pdfAddress2);
			String text = pdfAddress1.getText();
			String text1 = pdfAddress2.getText();
			String full_text = text.concat(text1);
			System.out.println(full_text);
			logger.info("starting of pdfAddress method");
			return full_text;
		}

	}

	public String pdfDatePurchase() {
		logger.info("starting of pdfDatePurchase method");
		{
			this.switchToNewWindow();
			String full_date = pdfDatePurchase.getText().replace("Invoice Date :", "");
			System.out.println(full_date);
			logger.info("starting of pdfDatePurchase method");
			return full_date;
		}
	}
	public void clickOnCloseAddressPage() {
		logger.info("starting of clickOnCloseAddressPage method");

		try {
			this.clickOnWebElement(btnCloseAddress);
		} catch (Exception e) {
			this.btnCloseAddress.click();
		}

		logger.info("Ending of clickOnCloseAddressPage method");
	}

}
