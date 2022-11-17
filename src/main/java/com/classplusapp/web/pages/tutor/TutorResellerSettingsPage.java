package com.classplusapp.web.pages.tutor;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.classplusapp.web.pages.BaseClassplusAutomationPage;

public class TutorResellerSettingsPage extends BaseClassplusAutomationPage {

	@FindBy(xpath = "//span[contains(text(),'Sampling 3 - Automation Course')]")
	private WebElement resellerCourseFolder;

	// Assertion
	@FindBy(xpath = "//span[contains(text(),\" Overview \")]")
	private WebElement lblOverview;

	// Assertion
	@FindBy(xpath = "//span[contains(text(),\"Content\")]")
	private WebElement lblContent;

	@FindBy(xpath = " //span[contains(text(),'Reseller Settings')]")
	private WebElement btnResellerSettings;

	// Assertion
	@FindBy(xpath = "//span[contains(text(),'Resale Settings')]")
	private WebElement lblResaleSettings;

	@FindBy(xpath = "//span[contains(text(),'View edit permissions')]")
	private WebElement lblViewEditPermissions;

	// Assertion
	@FindBy(xpath = "//div[contains(text(),'Edit Permissions')]")
	private WebElement lblEditPermissions;

	@FindBy(xpath = "(//input[@type='checkbox'])[2]")
	private WebElement btnTogglePricing;

	@FindBy(xpath = "(//input[@type='checkbox'])[3]")
	private WebElement btnToggleName;

	@FindBy(xpath = "(//input[@type='checkbox'])[4]")
	private WebElement btnToggleDescription;

	@FindBy(xpath = "(//input[@type='checkbox'])[5]")
	private WebElement btnToggleCourseImage;

	@FindBy(xpath = "//button[contains(text(),'Save')]")
	private WebElement btnSave;

	// Assertion
	@FindBy(xpath = "//div[contains(text(),'Changed permission')]")
	private WebElement txtPermissionSuccess;

	// Assertion
	@FindBy(xpath = "//div[contains(text(),\"Resellers\")]")
	private WebElement lblResellers;

	@FindBy(xpath = "//span[@class='cursorPointer ml-4']")
	private WebElement lblTutorName;

	@FindBy(xpath = "//span[contains(text(),'Share Date')]")
	private WebElement lblShareDate;

	@FindBy(xpath = "//span[contains(text(),'Selling Price')]")
	private WebElement lblSellingPrice;

	@FindBy(xpath = "//span[contains(text(),'Price Share')]")
	private WebElement lblPriceShare;

	@FindBy(xpath = "//span[contains(text(),'Purchases')]")
	private WebElement lblPurchases;

	@FindBy(xpath = "(//span[contains(text(),'ENABLE')])[1]")
	private WebElement btnEnable;

	// Assertion
	@FindBy(xpath = "//div[contains(text(),'Successfully enabled')]")
	private WebElement txtEnableSuccess;

	@FindBy(xpath = "(//span[contains(text(),'REVOKE')])[1]")
	private WebElement btnRevoke;

	@FindBy(xpath = "//button[contains(text(),'OK')]")
	private WebElement btnOk;

	@FindBy(xpath = "(//div[contains(@class,'toastr')]//div[@class='rrt-text'])[last()]")
	private WebElement revokeSuccessMessage;

	private static final Logger logger = Logger.getLogger(TutorResellerSettingsPage.class.getName());

	public TutorResellerSettingsPage(WebDriver driver) {
		super(driver);
		logger.info("Starting of ResellerSettingsPage method");

		PageFactory.initElements(driver, this);

		logger.info("Ending of ResellerSettingsPage method");
	}

	public void clickOnCourseFolder() {
		logger.info("Starting of clickOnCourseFolder method");

		this.clickOnWebElement(resellerCourseFolder);

		logger.info("Ending of clickOnCourseFolder method");
	}

	public String getOverviewLabel() {
		logger.info("Starting of getlblOverview method");
		logger.info("Ending of getlblOverview method");
		return lblOverview.getText();
	}

	public String getContentLabel() {
		logger.info("Starting of getlblOverview method");
		logger.info("Ending of getlblOverview method");
		return lblContent.getText();
	}

	public void clickOnResellerSettingsButton() {
		logger.info("Starting of clickOnResellerSettings method");

		this.clickOnWebElement(btnResellerSettings);

		logger.info("Ending of clickOnResellerSettings method");
	}

	public String getlblResaleSettingsLabel() {
		logger.info("Starting of getlblResaleSettings method");
		logger.info("Ending of getlblResaleSettings method");
		return lblResaleSettings.getText();
	}

	public void clickOnViewEditPermissionsLabel() {
		logger.info("Starting of clickOnViewEditPermissions method");

		this.clickOnWebElement(lblViewEditPermissions);

		logger.info("Ending of clickOnViewEditPermissions method");
	}

	public String getEditPermissionsLabel() {
		logger.info("Starting of getEditPermissionsLabel method");
		logger.info("Ending of getEditPermissionsLabel method");
		this.explicitWait(lblEditPermissions);

		return lblEditPermissions.getText();
	}

	public void clickOnPricingToggleButton() {
		logger.info("Starting of clickOnPricingToggleButton method");

		this.clickOnWebElement(btnTogglePricing);

		logger.info("Ending of clickOnPricingToggleButton method");
	}

	public void clickOnNameToggleButton() {
		logger.info("Starting of nameToggleOn method");

		this.clickOnWebElement(btnToggleName);

		logger.info("Ending of nameToggleOn method");
	}

	public void clickOnDescriptionToggle() {
		logger.info("Starting of clickOnDescriptionToggle method");

		this.clickOnWebElement(btnToggleDescription);

		logger.info("Ending of clickOnDescriptionToggle method");
	}

	public void clickOnCourseImageToggleButton() {
		logger.info("Starting of clickOnCourseImageToggleButton method");

		this.clickOnWebElement(btnToggleCourseImage);

		logger.info("Ending of clickOnCourseImageToggleButton method");
	}

	public void clickOnSaveButton() {
		logger.info("Starting of clickOnSaveButton method");

		this.clickOnWebElement(btnSave);

		logger.info("Ending of clickOnSaveButton method");
	}

	public String getPermissionSuccessMessage() {
		logger.info("Starting of getPermissionSuccessMessage method");
		this.explicitWait(txtPermissionSuccess);
		logger.info("Ending of getPermissionSuccessMessage method");
		return txtPermissionSuccess.getText();
	}

	public String getResellersLabel() {
		logger.info("Starting of getResellersLabel method");
		logger.info("Ending of getResellersLabel method");
		return lblResellers.getText();
	}

	public void clickOnTutorName() {
		logger.info("Starting of clickOnTutorName method");

		this.scrollDown(700);
		try {
			this.lblTutorName.click();
		} catch (Exception e) {
			this.clickOnWebElement(lblTutorName);
		}

		logger.info("Ending of clickOnTutorName method");
	}

	public void clickOnShareDate() {
		logger.info("Starting of clickOnShareDate method");
		try {
			this.lblShareDate.click();
		} catch (Exception e) {
			this.clickOnWebElement(lblShareDate);
		}

		logger.info("Ending of clickOnShareDate method");

	}

	public void clickOnSellingPrice() {
		logger.info("Starting of clickOnSellingPrice method");

		this.clickOnWebElement(lblSellingPrice);

		logger.info("Ending of clickOnSellingPrice method");
	}

	public void clickOnPriceShare() {
		logger.info("Starting of clickOnPriceShare method");

		this.clickOnWebElement(lblPriceShare);

		logger.info("Ending of clickOnPriceShare method");
	}

	public void clickOnPurchases() {
		logger.info("Starting of clickOnPurchases method");

		this.clickOnWebElement(lblPurchases);

		logger.info("Ending of clickOnPurchases method");
	}

	public void clickOnEnable() {
		logger.info("Starting of clickOnEnable method");

		this.clickOnWebElement(btnEnable);

		logger.info("Ending of clickOnEnable method");
	}

	public String getEnableSuccessMessage() {
		logger.info("Starting of getEnableSuccessMessage method");
		logger.info("Ending of getEnableSuccessMessage method");
		return txtEnableSuccess.getText();
	}

	public void clickOnRevoke() {
		logger.info("Starting of clickOnRevoke method");

		try {
			this.btnRevoke.click();
		} catch (Exception e) {
			this.clickOnWebElement(btnRevoke);
		}

		logger.info("Ending of clickOnRevoke method");
	}

	public void clickOnOkButton() {
		logger.info("Starting of clickOnOkButton method");
		try {
			this.btnOk.click();
		} catch (Exception e) {
			this.clickOnWebElement(btnOk);
		}

		logger.info("Ending of clickOnOkButton method");
	}

	public String getRevokeSuccessMessage() {
		logger.info("Starting of revokeMessage method");
		this.scrollDown(800);
		logger.info("Ending of revokeMessage method");
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
		}
		return revokeSuccessMessage.getText();
	}
}