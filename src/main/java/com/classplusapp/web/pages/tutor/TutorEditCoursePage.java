package com.classplusapp.web.pages.tutor;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.classplusapp.web.pages.BaseClassplusAutomationPage;

public class TutorEditCoursePage extends BaseClassplusAutomationPage {

	@FindBy(xpath = "//input[@class=\"Search_Input__1Ba9Y \"]")
	private WebElement txtSearchCourse;

	@FindBy(xpath = "//input[contains(@class,\"Search_Input__1Ba9Y \")]")
	private WebElement inpSearchCourse;

	@FindBy(xpath = "//span[contains(text(),'B2B Add content')]")
	private WebElement getCourse;

	@FindBy(xpath = "//span[contains(text(),'Certy')]")
	private WebElement getCourseRestriction;
	
	@FindBy(xpath = "//span[contains(text(),'1 rs installment course')]")
	private WebElement getCourseInstallment;

	@FindBy(xpath = "//div[contains(text(),'SUB-CATEGORIES')]")
	private WebElement lblSubCategories;

	@FindBy(xpath = "//p[contains(text(),'B2B Add content')]")
	private WebElement lblB2BBankCourse;

	@FindBy(xpath = " //span[contains(text(),'Overview')]")
	private WebElement lblOverView;

	@FindBy(xpath = "//i[@class='ellipsis vertical icon']")
	private WebElement mnuVerticalIcon;

	@FindBy(xpath = "//span[contains(text(),'Edit Course')]")
	private WebElement mnuEditCourseIcon;
	
	@FindBy(xpath = "//button[normalize-space()='Discard']")
	private WebElement btnDiscard;
	@FindBy(xpath = "//div[@style='display: flex; justify-content: space-between;']")
	private WebElement lblEditCourse;

	@FindBy(xpath = "//textarea[@placeholder='Description goes here']")
	private WebElement txtDescription;

	@FindBy(xpath = "//input[@style='width: 100%;']")
	private WebElement txtEditPrice;

	@FindBy(xpath = "//input[@style='width: 100%; margin-left: 4px;']")
	private WebElement txtEditDiscount;

	@FindBy(xpath = "(//input[@class=\"hidden\"])[1]")
	private WebElement tglInternetCharges;

	@FindBy(xpath = "//input[@id='expiryType1']")
	private WebElement rdoValidityOfCourse;

	@FindBy(xpath = "//div[@class=\"ui fitted checkbox\"]/input")
	private WebElement chkTermsAndConditions;

	@FindBy(xpath = "//button[contains(text(),'Save')]")
	private WebElement btnSave;

	@FindBy(xpath = "//button[contains(text(),'Add Content')]")
	private WebElement btnAddContent;

	@FindBy(xpath = "//div[contains(text(),'Edit Successful')]")
	private WebElement msgCourseUpdated;

	@FindBy(xpath = "//span[contains(text(),'Content')]//parent::div")
	private WebElement lblContent;

	@FindBy(xpath = "//div[@class=\"courseContentCurrent\"]")
	private WebElement btnOverView;
	@FindBy(xpath = "//img[@src='/static/media/SVGViewEye.560facb0.svg'][1]")
	private WebElement imgRestrictions;

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

	@FindBy(xpath = "//span[contains(text(),'Remove Course')]")
	private WebElement lblRemove;

	@FindBy(xpath = "//div[@class='littleModalContent']")
	private WebElement lblRemoveConfirmation;

	@FindBy(xpath = "//div[contains(text(),'Course Name')]")
	private WebElement lblCourseName;

	@FindBy(xpath = "(//div[contains(text(),'Description')])[2]")
	private WebElement lblDescription;

	@FindBy(xpath = "//div[contains(text(),'Category')]")
	private WebElement lblCategory;
	@FindBy(xpath = "//label[@for='expiryType3']")
	private WebElement lblLifetime;

	@FindBy(xpath = "//p[@class='createCourse__courseDuration__warnLine']")
	private WebElement lblLifetimeAssert;

	@FindBy(xpath = "//div[contains(text(),'Sub-Categories')]")
	private WebElement lblSubCategory;

	private static final Logger logger = Logger.getLogger(TutorEditCoursePage.class.getName());

	public TutorEditCoursePage(WebDriver driver) {
		super(driver);
		logger.info("Starting of EditCoursePage method");
		PageFactory.initElements(driver, this);
		logger.info("Edning of EditCoursePage method");

	}

	public void setSearchCourse(String strSearch) {
		logger.info("Starting of setSearchCourse method");

		this.waitForElementVisibilty(txtSearchCourse);
		this.txtSearchCourse.click();
		this.inpSearchCourse.sendKeys(strSearch);

		logger.info("Ending of setSearchCourse method");
	}

	public void clickOnCourseFolder() {
		logger.info("Starting of clickOnCourseFolder method");

		this.waitForElementVisibilty(getCourse);
		this.clickOnWebElement(getCourse);

		logger.info("Ending of clickOnCourseFolder method");
	}

	public void clickOnCourseFolderRestriction() {
		logger.info("Starting of clickOnCourseFolder method");

		this.waitForElementVisibilty(getCourseRestriction);
		this.clickOnWebElement(getCourseRestriction);

		logger.info("Ending of clickOnCourseFolder method");
	}

	public void clickOnCourseInstallmentLifetime() {
		logger.info("Starting of clickOnCourseInstallmentLifetime method");

		this.waitForElementVisibilty(getCourseInstallment);
		this.clickOnWebElement(getCourseInstallment);

		logger.info("Ending of clickOnCourseInstallmentLifetime method");
	}

	public void clickOnLifetime() {
		logger.info("Starting of clickOnLifetime method");

		this.scrollIntoView(lblLifetime);
		this.clickOnWebElement(lblLifetime);

		logger.info("Ending of clickOnLifetime method");
	}

	public boolean checkVisibilityRestrictions() {
		logger.info("Starting of checkVisibilityRestrictions method");
		this.waitForElementVisibilty(imgRestrictions);
		logger.info("Ending of checkVisibilityRestrictions method");
		return this.imgRestrictions.isDisplayed();

	}

	public String getSubCategoriesLabel() {
		logger.info("Starting of getSubCategoriesLabel method");
		logger.info("Ending of getSubCategoriesLabel method");
		return lblSubCategories.getText();
	}

	public String getB2BCourseLabel() {
		logger.info("Starting of getB2BCourseLabel method");
		logger.info("Ending of getB2BCourseLabel method");
		return lblB2BBankCourse.getText();
	}

	public String getOverViewLabel() {
		logger.info("Starting of getOverViewLabel method");
		logger.info("Ending of getOverViewLabel method");
		return lblOverView.getText();
	}

	public void clickOnThreeDottedMenu() {
		logger.info("Starting of clickOnThreeDottedMenu method");

		this.clickOnWebElement(mnuVerticalIcon);

		logger.info("Ending of clickOnThreeDottedMenu method");
	}

	public void clickOnEditIcon() {
		logger.info("Starting of clickOnEditIcon method");

		this.clickOnWebElement(mnuEditCourseIcon);

		logger.info("Ending of clickOnEditIcon method");
	}
	public void clickOnDiscard() {
		logger.info("Starting of clickOnDiscard method");

		this.waitForElementVisibilty(btnDiscard);
		this.clickOnWebElement(btnDiscard);

		logger.info("Ending of clickOnDiscard method");
	}

	public String getEditCourseLabel() {
		logger.info("Starting of getEditCourseLabel method");
		logger.info("Ending of getEditCourseLabel method");
		return lblEditCourse.getText();
	}

	public String getLabelLifetime() {
		logger.info("Starting of getLabelLifetime method");
		logger.info("Ending of getLabelLifetime method");
		return lblLifetimeAssert.getText();
		}

	public void setDescription(String strDiscription) {
		logger.info("Starting of setDescription method");

		this.waitForElementVisibilty(txtDescription);

		// this.explicitWait(txtDescription);
		this.txtDescription.clear();
		this.txtDescription.sendKeys(strDiscription);

		logger.info("Ending of setDescription method");
	}

	public void setPrice(String strPrice) {
		logger.info("Starting of setPrice method");

		this.waitForElementVisibilty(txtEditPrice);
		this.scrollDown(300);
		this.txtEditPrice.clear();
		this.txtEditPrice.sendKeys(strPrice);

		logger.info("Ending of setPrice method");
	}

	public void setDiscount(String strDiscount) {
		logger.info("Starting of setDiscount method");

		this.waitForElementVisibilty(txtEditDiscount);

		this.txtEditDiscount.clear();
		this.txtEditDiscount.sendKeys(strDiscount);

		logger.info("Ending of setDiscount method");
	}

	public void clickOnInternetChargesToggle() {
		logger.info("Starting of clickOnInternetChargesToggle method");

		this.clickOnWebElement(tglInternetCharges);

		logger.info("Ending of clickOnInternetChargesToggle method");
	}

	public void clickOnValityCourseRadioButton() {
		logger.info("Starting of clickOnValityCourseRadioButton method");

		this.scrollDown(500);
		this.clickOnWebElement(rdoValidityOfCourse);

		logger.info("Ending of clickOnValityCourseRadioButton method");
	}

	public void clickOnTermsAndConditionCheckBox() {
		logger.info("Starting of clickOnTermsAndConditionCheckBox method ");

		this.waitForElementVisibilty(chkTermsAndConditions);
		this.clickOnWebElement(chkTermsAndConditions);

		logger.info("Ending of clickOnTermsAndConditionCheckBox method");
	}

	public void clickOnSaveButton() {
		logger.info("Starting of clickOnSaveButton method ");

		this.waitForElementVisibilty(btnSave);
		this.clickOnWebElement(btnSave);

		logger.info("Ending of clickOnSaveButton method");
	}

	public void clickOnAddContentButton() {
		logger.info("Starting of clickOnAddContentButton method");

		this.waitForElementVisibilty(btnAddContent);
		this.clickOnWebElement(btnAddContent);

		logger.info("Ending of clickOnAddContentButton method");
	}

	public String getCourseEditedMessage() {
		logger.info("Starting of getCourseEditedMessage method");
		logger.info("Ending of getCourseEditedMessage method");
		return msgCourseUpdated.getText();
	}

	public String getContentLabel() {
		logger.info("Starting of getContentLabel method");
		logger.info("Ending of getContentLabel method");
		return this.lblContent.getText();
	}

	public void clickOnOverviewButton() {
		logger.info("Starting of clickOnOverviewButton method");

		this.clickOnWebElement(btnOverView);

		logger.info("Ending of clickOnOverviewButton method");
	}

	public void clickOnMenuVerticalIcon() {
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

	public String getRemoveLabel() {
		logger.info("Starting of getRemoveLabel method");
		logger.info("Ending of getRemoveLabel method");
		return lblRemove.getText();
	}

	public String getRemoveConfirmationLabel() {
		logger.info("Starting of getRemoveConfirmationLabel method");
		logger.info("Ending of getRemoveConfirmationLabel method");
		return lblRemoveConfirmation.getText();
	}

	public String getCourseNameLabel() {
		logger.info("Starting of getCourseNameLabel method");

		this.explicitWait(lblCourseName);

		logger.info("Ending of getCourseNameLabel method");
		return lblCourseName.getText();
	}

	public String getDescriptionLabel() {
		logger.info("Starting of getDescriptionLabel method");

		this.explicitWait(lblDescription);

		logger.info("Ending of getDescriptionLabel method");
		return lblDescription.getText();
	}

	public String getCategoryLabel() {
		logger.info("Starting of getCategoryLabel method");

		this.explicitWait(lblCategory);

		logger.info("Ending of getCategoryLabel method");
		return lblCategory.getText();
	}

	public String getSubCategoryLabel() {
		logger.info("Starting of getSubCategoryLabel method");

		this.explicitWait(lblSubCategories);

		logger.info("Ending of getSubCategoryLabel method");
		return lblSubCategories.getText();
	}

}