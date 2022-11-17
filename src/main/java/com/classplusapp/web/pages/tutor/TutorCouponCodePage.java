package com.classplusapp.web.pages.tutor;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.classplusapp.web.pages.BaseClassplusAutomationPage;

public class TutorCouponCodePage extends BaseClassplusAutomationPage {

	@FindBy(xpath = "//p[contains(text(),'Coupon Code')]")
	private WebElement btnCouponCode;

	@FindBy(xpath = "//h1[@class='ui header']")
	private WebElement lblCouponCode;

	@FindBy(xpath = "//button[text()='Create Coupon']")
	private WebElement btnCreateCoupon;

	@FindBy(xpath = "//div[contains(text(),'Create Coupon Code')]")
	private WebElement lblCreateCouponCode;

	@FindBy(xpath = "//input[@placeholder='Enter discount amount']")
	private WebElement txtDiscountAmount;

	@FindBy(xpath = "//input[@name='isLifetime']")
	private WebElement chkCouponLifetimeValidity;

	@FindBy(xpath = "//input[@name='minimumCartValueAllowed']")
	private WebElement txtMinOrderValue;

	@FindBy(xpath = "//button[contains(text(),'Next')]")
	private WebElement btnNext;

	@FindBy(xpath = "//div[contains(text(),'Create Coupon Code')]")
	private WebElement lblCreateCouponCodes;

	@FindBy(xpath = "//input[@placeholder='Enter Offer Name']")
	private WebElement txtEnterOfferName;

	@FindBy(xpath = "//input[@placeholder=\"Enter Coupon Code\"]")
	private WebElement txtEnterCouponCode;

	@FindBy(xpath = "//input[@name='totalLimit']")
	private WebElement txtEnterTotalLimit;

	@FindBy(xpath = "//input[@name='userLimit']")
	private WebElement txtEnterUsageLimit;

	@FindBy(xpath = "//div[@style=\"text-align: center; margin-top: 4rem;\"]/child::div/child::div/following-sibling::div/following-sibling::div/button[@class=\"sc-fjdhpX kHoCiF sc-jTzLTM iUXcVE\"]")
	// @FindBy(xpath ="//div[@style='text-align: center; margin-top:
	// 4rem;']/child::div/child::div/following-sibling::div/following-sibling::div/button[@class='sc-fjdhpX
	// kHoCiF sc-jTzLTM iUXcVE']")
	private WebElement btnNext1;

	@FindBy(xpath = "//div[@style='text-align: center; margin-top: 4rem;']/child::div/child::div/following-sibling::div/following-sibling::div/button[@class='sc-fjdhpX kHoCiF sc-jTzLTM iUXcVE']")
	private WebElement btnNextPercentage1;

	@FindBy(xpath = "//div[contains(text(),'Create Coupon Code')]")
	private WebElement lblCreateCouponCode1;

	@FindBy(xpath = "//div[@style=\"text-align: center; margin-top: 4rem;\"]/child::div/child::div/following-sibling::div/following-sibling::div/child::div/child::button[@class=\"sc-fjdhpX kHoCiF sc-jTzLTM iUXcVE\"]")
	private WebElement btnFinish;

	@FindBy(xpath = "//div[contains(text(),'Coupon created Successfully!')]")
	private WebElement msgCouponCreated;

	@FindBy(xpath = "//div[contains(text(),'B2BSTORE')]//parent::div//parent::div//parent::div//parent::div/descendant::i[@class=\"ellipsis vertical icon\"]")
	private WebElement mnuEditVerticalIcon;

	@FindBy(xpath = "//div[contains(text(),'B2BSTORE')]//parent::div//parent::div//parent::div//parent::div/descendant::i[@class=\"ellipsis vertical icon\"]/following-sibling::div/descendant::div/descendant::span[contains(text(),'Details')]")
	private WebElement editCouponIcon;

	@FindBy(xpath = "//div[contains(text(),'Create Coupon Code')]")
	private WebElement lblEditCreateCouponCode;

	@FindBy(xpath = "//input[@name='minimumCartValueAllowed']")
	private WebElement txtEditMinOrderValue;

	@FindBy(xpath = "//button[contains(text(),'Next')]")
	private WebElement btnNextEdit;

	@FindBy(xpath = "//input[@placeholder='Enter Offer Name']")
	private WebElement txtEditOfferName;

	@FindBy(xpath = "//input[@name='totalLimit']")
	private WebElement txtEditTotalLimit;

	@FindBy(xpath = "//button[contains(text(),'Next')]")
	private WebElement btnUpdateNext;

	@FindBy(xpath = "//button[contains(text(),'Finish')]")
	private WebElement btnFinishEdited;

	@FindBy(xpath = "//div[contains(text(),'Coupon Updated Successfully')]")
	private WebElement msgCouponUpdated;

	@FindBy(xpath = "//div[contains(text(),'B2BTEST')]//parent::div//parent::div//parent::div//parent::div/descendant::i[@class=\"ellipsis vertical icon\"]")
	private WebElement mnuVerticalIcon;

	/*
	 * @FindBy(xpath =
	 * "//div[contains(text(),'B2BSTORE')]//parent::div//parent::div//parent::div//parent::div/descendant::i[@class="ellipsis
	 * vertical icon"] private WebElement mnuEditVerticalIcon1;
	 */
	@FindBy(xpath = "//div[contains(text(),'B2BTEST')]//parent::div//parent::div//parent::div//parent::div/descendant::i[@class=\"ellipsis vertical icon\"]/following-sibling::div/descendant::div/descendant::img[@alt=\"active icon\"]")
	private WebElement makeActiveIcon;

	@FindBy(xpath = "//div[contains(text(),'Coupon details Updated!')]")
	private WebElement msgCouponUpdatedDetails;

	@FindBy(xpath = "//div[contains(text(),'B2BTEST')]//parent::div//parent::div//parent::div//parent::div/descendant::i/following-sibling::div/child::div/descendant::span[contains(text(),'Delete')]")
	private WebElement deleteIcon;

	@FindBy(xpath = "//div[contains(text(),'Coupon Removed')]")
	private WebElement msgCouponRemoved;

	@FindBy(xpath = "//div[@class=\"sixteen wide computer column\"]/div[@class=\"sc-bZQynM hbCwKq\"]")
	private WebElement lblDiscountType;

	@FindBy(xpath = "//div[@class=\"ui fluid left labeled input CouponForm_input__E1Qbf\"]/preceding-sibling::div")
	private WebElement lblFlatDiscountAmount;

	@FindBy(xpath = "//div[@class=\"ui grid\"]/child::div[3]/child::div[@class=\"eight wide computer column CouponForm_dFlex__2-8ye\"]/child::div[@class=\"sc-bZQynM hbCwKq\"]")
	private WebElement lblStartDate;

	@FindBy(xpath = "//div[@class=\"ui grid\"]/child::div[3]/child::div[@class=\"eight wide computer column CouponForm_dFlex__2-8ye\"]/following-sibling::div/child::div[@class=\"sc-bZQynM hbCwKq\"]")
	private WebElement lblStartTime;

	@FindBy(xpath = "//div[@class=\"sixteen wide computer column CouponForm_dFlex__2-8ye\"]/child::div[3]/label[contains(text(),'Private Coupon')]")
	private WebElement lblPrivateCoupon;

	@FindBy(xpath = "//div[@class=\"ui radio checkbox CouponForm_radio__MkViX\"]/label")
	private WebElement lblPercentageDiscount;

	@FindBy(xpath = "//div[@class=\"nine wide computer column\"]/div/input[@class=\"hidden\"]")
	private WebElement rdoPercentageDiscount;

	@FindBy(xpath = "//div[@class=\"ui basic label label\"]/preceding-sibling::input")
	private WebElement txtPercentageDiscount;

	// assertion
	@FindBy(xpath = "//div[@class=\"ui basic label label\"]/parent::div/preceding-sibling::div/span/parent::div")
	private WebElement lblPercentageDiscount1;

	@FindBy(xpath = "//input[@name=\"maxAmount\"]//parent::div[@class=\"ui fluid labeled input CouponForm_input__E1Qbf\"]/parent::div/child::div[@class=\"sc-bZQynM hbCwKq\"]")
	private WebElement lblMaxPercentageDiscount;

	@FindBy(xpath = "//div[@class=\"ui basic label label\"]/parent::div/child::input[@name=\"maxAmount\"]")
	private WebElement txtMaxPercentageDiscount;

	@FindBy(xpath = "//div[@class=\"ui radio checkbox CouponForm_radio__MkViX\"]/input[@name=\"couponType\"]")
	private WebElement rdoPrivateCoupon;

	@FindBy(xpath = "//div[@class=\"ui radio checkbox CouponForm_radio__MkViX\"]/input[@name=\"isApplicableToAllCourses\"]")
	private WebElement rdoSpecificCourses;

	@FindBy(xpath = "//button[@class=\"CouponForm_selectButton__Iu3XW\"]")
	private WebElement btnSelectAll;

	@FindBy(xpath = "//input[@type=\"text\"]")
	private WebElement txtSearch;

	@FindBy(xpath = "//div[@class=\"CouponForm_footerBox__115vK sc-kpOJdX ibTeNu\"]/child::div/button[contains(text(),'Skip')]")
	private WebElement btnSkip;

	// Assigncourses
	@FindBy(xpath = "//div[@class=\"CouponForm_skipFooter__3yGVQ sc-kpOJdX ibTeNu\"]/button[@class=\"sc-fjdhpX kHoCiF sc-jTzLTM iUXcVE\"]")
	private WebElement btnSelectEligibleCourses;

	// checkbox
	@FindBy(xpath = "//input[@class=\"hidden\"]")
	private WebElement chkSelectCourse;

	@FindBy(xpath = "//div[@class=\"sc-bZQynM eZWqDz\"]")
	private WebElement lblEligibleCourses;

	@FindBy(xpath = "//div[contains(text(),'B2BTEST')]//parent::div//parent::div//parent::div//parent::div/descendant::i[@class='ellipsis vertical icon']/following-sibling::div/descendant::div/following-sibling::div/following-sibling::div")
	private WebElement viewHistoryIcon;

	@FindBy(xpath = "//p[@class='CouponEditHistory_subHeading__379C8']")
	private WebElement lblCouponHistory;

	@FindBy(xpath = "//input[@type=\"text\"]")
	private WebElement txtSearchCoupon;

	// Assertions
	@FindBy(xpath = "//span[@class=\"fontSmall gray\"]/parent::div/parent::div/parent::div/span[@class=\"fontMedium\"]")
	private WebElement lblCouponInformation;

	@FindBy(xpath = "//span[contains(text(),'Total Eligible Students')]")
	private WebElement lblEligibleStudents;

	@FindBy(xpath = "//span[contains(text(),'Total Assigned Courses')]")
	private WebElement lblAssignedCourses;

	@FindBy(xpath = "//span[contains(text(),'Overall Usage Limit')]")
	private WebElement lblUsageLimit;

	@FindBy(xpath = "//span[contains(text(),'Usage Per Student')]")
	private WebElement lblUsage;

	@FindBy(xpath = "//span[contains(text(),'Min Order Value')]")
	private WebElement lblMinOrderValue;

	@FindBy(xpath = "//span[contains(text(),'Overall Usage Limit')]/parent::div")
	private WebElement lblOverallUsageLimit;

	@FindBy(xpath = "//span[contains(text(),'Overall Usage Limit')]/../child::div/child::button")
	private WebElement btnEditUsageLimit;

	// assertion
	@FindBy(xpath = "//div[@class=\"sc-kGXeez cQTWuf\"]")
	private WebElement lblEditCouponDetails;

	@FindBy(xpath = "//input[@name=\"totalLimit\"]")
	private WebElement txtEditUsageLimitValue;

	@FindBy(xpath = "//div[@class=\"sc-kpOJdX ibTeNu\"]/button")
	private WebElement btnSaveChanges;

//	@FindBy(xpath = "//div[contains(text(),'B2BSTORE')]/parent::div/parent::div/following-sibling::div/child::button")
//	private WebElement btnShowDetails;

	@FindBy(xpath = "//div[@class=\"CouponListCard_couponName__3d9xG\"]")
	private WebElement lblCouponName;

	@FindBy(xpath = "//span[contains(text(),'Usage Per Student')]/..")
	private WebElement lblUsagePerStudent;

	@FindBy(xpath = "//span[contains(text(),'Usage Per Student')]/../child::div/child::button")
	private WebElement btnEditUsagePerStudent;

	@FindBy(xpath = "//input[@name='userLimit']")
	private WebElement txtEditUsagePerStudent;

	@FindBy(xpath = "//span[contains(text(),'Min Order Value')]/..")
	private WebElement lblMinimumOrderValue;

	@FindBy(xpath = "//span[contains(text(),'Min Order Value')]/../descendant::button")
	private WebElement btnEditMinimumOrderValue;

	@FindBy(xpath = "//input[@name='minimumCartValueAllowed']")
	private WebElement txtMinimumOrderValue;

	@FindBy(xpath = "//P[@class='sc-bwzfXH ctcHvS']")
	private WebElement lblNoCouponFound;

	@FindBy(xpath = "//span[text()='654365']")
	private WebElement lblCouponCode1;

	@FindBy(xpath = "//span[text()='2022/03/21, 05:40 pm']/parent::div")
	private WebElement lblDuration;

	@FindBy(xpath = "(//span[text()='public Coupon'])[1]")
	private WebElement lblPublicCoupon;

	@FindBy(xpath = "(//div[@class='fontSmall'])[2]")
	private WebElement lblProTutor;

	@FindBy(xpath = "(//span[text()='Expired'])[1]")
	private WebElement lblExpired;

	// Negative

	@FindBy(xpath = "//input[@placeholder='Enter discount amount']/parent::div/following-sibling::div")
	private WebElement lblDiscountRequired;

	@FindBy(xpath = "//input[@placeholder='Enter Start Date']")
	private WebElement txtStartDate;

	@FindBy(xpath = "//input[@placeholder='Enter Start Time']")
	private WebElement txtStartTime;

	@FindBy(xpath = "//div[@class='ui red pointing basic label CouponForm_errorMsg__IhMjz']")
	private WebElement lblInvalidStartDate;

	@FindBy(xpath = "//input[@placeholder='Enter End Date']")
	private WebElement txtEndDate;

	@FindBy(xpath = "//input[@placeholder='Enter End Time']")
	private WebElement txtEndTime;

	@FindBy(xpath = "//div[contains(text(),'A minimum limit for a coupon code is required')]")
	private WebElement lblNumberOfTimesCodeUsage;

	@FindBy(xpath = "//div[contains(text(),'sample coupon')]//parent::div//parent::div//parent::div//parent::div/descendant::i[@class=\"ellipsis vertical icon\"]")
	private WebElement btnThreedotted;

	@FindBy(xpath = "//div[contains(text(),'sample coupon')]//parent::div//parent::div//parent::div//parent::div/descendant::i[@class=\"ellipsis vertical icon\"]/following-sibling::div/descendant::div/descendant::img[@alt='active icon']")
	private WebElement btnMakeInactive;

	@FindBy(xpath = "//div[contains(text(),'sample coupon')]//parent::div//parent::div//parent::div//parent::div/descendant::i/following-sibling::div/child::div/descendant::span[contains(text(),'Delete')]")
	private WebElement btnDeleteInvalidCoupon;

	@FindBy(xpath = "//div[contains(text(),'Coupon code not available')]")
	private WebElement lblCouponUnavailableText;

	private static final String menuVerticalCouponIcon = "//div[contains(text(),'${text}')]/../..//div//parent::div//parent::div/descendant::i[@class='ellipsis vertical icon']";
	private static final String btnShowDetails = "(//span[contains(text(),'${text}')]/..//..//following-sibling::div//button)[2]";
	private static final String btnDetails = "//div[contains(text(),'${text}')]//parent::div//parent::div//parent::div//parent::div/descendant::i[@class='ellipsis vertical icon']/following-sibling::div/descendant::div/descendant::span[contains(text(),'Details')]";
	private static final String btnViewHistory = "//div[contains(text(),'${text}')]//parent::div//parent::div//parent::div//parent::div/descendant::i[@class='ellipsis vertical icon']/following-sibling::div/descendant::div/following-sibling::div/following-sibling::div";

	private static final Logger logger = Logger.getLogger(TutorCouponCodePage.class.getName());

	public TutorCouponCodePage(WebDriver driver) {
		super(driver);
		logger.info("Starting of CouponCodePage method");

		PageFactory.initElements(driver, this);

		logger.info("Ending of CouponCodePage method");
	}

	public void clickOnCouponCodeButton() {
		logger.info("starting of clickOnCouponCodeButton method");
		try {
			this.explicitWait(btnCouponCode);
			this.btnCouponCode.click();
		} catch (Exception e) {
			this.clickOnWebElement(btnCouponCode);
		}

		logger.info("Ending of clickOnCouponCodeButton method");
	}

	public String getCouponCodesLabel() {
		logger.info("Starting of getCouponCodesLabel method");

		this.explicitWait(lblCouponCode);

		this.waitForElementVisibilty(lblCouponCode);
		logger.info("Ending of getCouponCodesLabel method");

		return lblCouponCode.getText();
	}

	public void clickOnCreateCouponButton() {
		logger.info("starting of clickOnCreateCouponButton method");
		try {
			this.btnCreateCoupon.click();
		} catch (Exception e) {
			this.clickOnWebElement(btnCreateCoupon);
		}
		logger.info("Ending of clickOnCreateCouponButton method");
	}

	public String getCreateCouponCodeLabel() {
		logger.info("Starting of getCreateCouponCodeLabel method");

		this.explicitWait(lblCreateCouponCode);

		logger.info("Ending of getCreateCouponCodeLabel method");

		return lblCreateCouponCode.getText();
	}

	public String getDiscountTypeLabel() {
		logger.info("Starting of getDiscountTypeLabel method");
		logger.info("Ending of getDiscountTypeLabel method");

		return lblDiscountType.getText();
	}

	public String getFlatDiscountAmountLabel() {
		logger.info("Starting of getFlatDiscountAmountLabel method");
		logger.info("Ending of getFlatDiscountAmountLabel method");

		return lblFlatDiscountAmount.getText();
	}

	public String getStartDateLabel() {
		logger.info("Starting of getStartDateLabel method");
		logger.info("Ending of getStartDateLabel method");

		return lblStartDate.getText();
	}

	public String getStartTimeLabel() {
		logger.info("Starting of getStartTimeLabel method");
		logger.info("Ending of getStartTimeLabel method");

		return lblStartTime.getText();
	}

	public void setFlatDiscount(String strDiscount) {
		logger.info("Starting of setFlatDiscount method");

		if (!System.getProperty("os.name").contains("Mac")) {
			this.txtDiscountAmount.sendKeys(Keys.CONTROL + "a");
			this.txtDiscountAmount.sendKeys(Keys.DELETE);
		} else {
			this.txtDiscountAmount.sendKeys(Keys.COMMAND + "a");
			this.txtDiscountAmount.sendKeys(Keys.DELETE);

		}
		this.txtDiscountAmount.sendKeys(strDiscount);

		logger.info("Ending of setFlatDiscount  method");
	}

	public void clickOnLifetimeValidityCheckbox() {
		logger.info("starting of clickOnLifetimeValidityCheckbox method");

		this.clickOnWebElement(chkCouponLifetimeValidity);

		logger.info("Ending of clickOnLifetimeValidityCheckbox method");
	}

	public void setMinimumOrderValue(String strMinValue) {
		logger.info("Starting of setMinimumOrderValue method");

		this.scrollDown(600);

		if (!System.getProperty("os.name").contains("Mac")) {
			this.txtMinOrderValue.sendKeys(Keys.CONTROL + "a");
			this.txtMinOrderValue.sendKeys(Keys.DELETE);
		} else {
			this.txtMinOrderValue.sendKeys(Keys.COMMAND + "a");
			this.txtMinOrderValue.sendKeys(Keys.DELETE);

		}

		this.txtMinOrderValue.sendKeys(strMinValue);

		logger.info("Ending of setMinimumOrderValue  method");
	}

	public void clickOnNextButton() {
		logger.info("starting of clickOnNextButton method");

		this.explicitWait(btnNext);
		this.btnNext.click();

		logger.info("Ending of clickOnNextButton method");
	}

	public void setOfferName(String strOfferName) {
		logger.info("Starting of setOfferName method");
		if (!System.getProperty("os.name").contains("Mac")) {
			this.txtEnterOfferName.sendKeys(Keys.CONTROL + "a");
			this.txtEnterOfferName.sendKeys(Keys.DELETE);
		} else {
			this.txtEnterOfferName.sendKeys(Keys.COMMAND + "a");
			this.txtEnterOfferName.sendKeys(Keys.DELETE);

		}

		this.txtEnterOfferName.sendKeys(strOfferName);

		logger.info("Ending of setOfferName  method");
	}

	public void setCouponCode(String strCouponCode) {
		logger.info("Starting of setCouponCode method");

		if (!System.getProperty("os.name").contains("Mac")) {
			this.txtEnterCouponCode.sendKeys(Keys.CONTROL + "a");
			this.txtEnterCouponCode.sendKeys(Keys.DELETE);
		} else {
			this.txtEnterCouponCode.sendKeys(Keys.COMMAND + "a");
			this.txtEnterCouponCode.sendKeys(Keys.DELETE);

		}

		this.txtEnterCouponCode.sendKeys(strCouponCode);
		// this.txtEnterCouponCode.click();
		logger.info("Ending of setCouponCode  method");
	}

	public void setTotalLimit(String strTotalLimit) {
		logger.info("Starting of setTotalLimit method");
		if (!System.getProperty("os.name").contains("Mac")) {
			this.txtEnterTotalLimit.sendKeys(Keys.CONTROL + "a");
			this.txtEnterTotalLimit.sendKeys(Keys.DELETE);
		} else {
			this.txtEnterTotalLimit.sendKeys(Keys.COMMAND + "a");
			this.txtEnterTotalLimit.sendKeys(Keys.DELETE);

		}

		this.txtEnterTotalLimit.sendKeys(strTotalLimit);

		logger.info("Ending of setTotalLimit  method");
	}

	public void setUserLimit(String strUserLimit) {
		logger.info("Starting of setUserLimit method");
		if (!System.getProperty("os.name").contains("Mac")) {
			this.txtEnterUsageLimit.sendKeys(Keys.CONTROL + "a");
			this.txtEnterUsageLimit.sendKeys(Keys.DELETE);
		} else {
			this.txtEnterUsageLimit.sendKeys(Keys.COMMAND + "a");
			this.txtEnterUsageLimit.sendKeys(Keys.DELETE);

		}

		this.txtEnterUsageLimit.sendKeys(strUserLimit);

		logger.info("Ending of setUserLimit  method");
	}

	public void clickOnCodeNextButton() {
		logger.info("starting of clickOnCodeNextButton method");

		try {
			this.explicitWait(btnNext1);
			this.btnNext1.click();
		} catch (Exception e) {
			this.clickOnWebElement(btnNext1);
		}

		logger.info("Ending of clickOnCodeNextButton method");
	}

	public void clickOnPercentageCodeNextButton() {
		logger.info("starting of clickOnPercentageCodeNextButton method");

		try {
			this.explicitWait(btnNextPercentage1);
			this.btnNextPercentage1.click();
		} catch (Exception e) {
			this.clickOnWebElement(btnNextPercentage1);
		}

		logger.info("Ending of clickOnPercentageCodeNextButton method");
	}

	public void clickOnFinishButton() {
		logger.info("starting of clickOnFinishButton method");

		try {
			this.btnFinish.click();
		} catch (Exception e) {
			this.clickOnWebElement(btnFinish);
		}

		logger.info("Ending of clickOnFinishButton method");
	}

	public String getCouponCreatedMessage() {
		logger.info("Starting of getCouponCreatedMessage method");

		this.explicitWait(msgCouponCreated);
		logger.info("Ending of getCouponCreatedMessage method");

		return msgCouponCreated.getText();
	}

	public void clickOnThreeDottedMenu(String couponeCode) {
		logger.info("starting of clickOnThreeDottedMenu method");

		System.out.println(menuVerticalCouponIcon.replace("${text}", couponeCode.toUpperCase()));
		driver.findElement(By.xpath(menuVerticalCouponIcon.replace("${text}", couponeCode.toUpperCase()))).click();

		logger.info("Ending of clickOnThreeDottedMenu method");
	}

	public void clickOnEditCouponLink(String couponeCode) {
		logger.info("starting of clickOnEditCoupon method");
		try {
			Thread.sleep(1000);

			// this.editCouponIcon.click();
			// System.out.println(btnDetails.replace("${text}", couponeCode.toUpperCase()));

			driver.findElement(By.xpath(btnDetails.replace("${text}", couponeCode.toUpperCase()))).click();

		} catch (Exception e) {
			this.clickOnWebElement(editCouponIcon);
		}
		logger.info("Ending of clickOnEditCoupon method");
	}

	public String getPercentageDiscountLabel() {
		logger.info("Starting of getPercentageDiscountLabel method");
		logger.info("Ending of getPercentageDiscountLabel method");

		return lblPercentageDiscount.getText();
	}

	public void clickOnPercentageDiscountRadioButton() {
		logger.info("starting of clickOnPercentageDiscountRadioButton method");
		try {
			this.rdoPercentageDiscount.click();
		} catch (Exception e) {
			this.clickOnWebElement(rdoPercentageDiscount);
		}

		logger.info("Ending of clickOnPercentageDiscountRadioButton method");
	}

	public String getPercentageDiscount1Label() {
		logger.info("Starting of getPercentageDiscount1Label method");
		logger.info("Ending of getPercentageDiscount1Label method");

		return lblPercentageDiscount1.getText();
	}

	public void setPercentageDiscount(String StrPercentageDiscount) {
		logger.info("starting of setPercentageDiscount method");

		this.txtPercentageDiscount.sendKeys(StrPercentageDiscount);

		logger.info("Ending of setPercentageDiscount method");
	}

	public String getMaxPercentageDiscountLabel() {
		logger.info("Starting of getMaxPercentageDiscountLabel method");
		logger.info("Ending of getMaxPercentageDiscountLabel method");

		return lblMaxPercentageDiscount.getText();
	}

	public void setMaxPercentageDiscount(String StrMaxPercentageDiscount) {
		logger.info("starting of setMaxPercentageDiscount method");

		if (!System.getProperty("os.name").contains("Mac")) {
			this.txtMaxPercentageDiscount.sendKeys(Keys.CONTROL + "a");
			this.txtMaxPercentageDiscount.sendKeys(Keys.DELETE);
		} else {
			this.txtMaxPercentageDiscount.sendKeys(Keys.COMMAND + "a");
			this.txtMaxPercentageDiscount.sendKeys(Keys.DELETE);

		}

		this.txtMaxPercentageDiscount.sendKeys(StrMaxPercentageDiscount);

		logger.info("Ending of setMaxPercentageDiscount method");
	}

	public void clickOnPrivateCouponRadioButton() {
		logger.info("starting of clickOnPrivateCouponRadioButton method");
		try {
			this.rdoPrivateCoupon.click();
		} catch (Exception e) {
			this.clickOnWebElement(rdoPrivateCoupon);
		}

		logger.info("Ending of clickOnPrivateCouponRadioButton method");
	}

	public void clickOnSpecificCoursesRadioButton() {
		logger.info("starting of clickOnPrivateCouponRadioButton method");
		try {
			this.rdoSpecificCourses.click();
		} catch (Exception e) {
			this.clickOnWebElement(rdoSpecificCourses);
		}

		logger.info("Ending of clickOnPrivateCouponRadioButton method");
	}

	public String getPrivateCouponLabel() {
		logger.info("Starting of getPrivateCouponLabel method");
		logger.info("Ending of getPrivateCouponLabel method");

		return lblPrivateCoupon.getText();
	}

	public void setMinimumValueEdit(String strEditMinValue) {
		logger.info("Starting of setMinimumValueEdit method");

		this.scrollDown(600);
		if (!System.getProperty("os.name").contains("Mac")) {
			this.txtEditMinOrderValue.sendKeys(Keys.CONTROL + "a");
			this.txtEditMinOrderValue.sendKeys(Keys.DELETE);
		} else {
			this.txtEditMinOrderValue.sendKeys(Keys.COMMAND + "a");
			this.txtEditMinOrderValue.sendKeys(Keys.DELETE);
		}
		this.txtEditMinOrderValue.sendKeys(strEditMinValue);

		logger.info("Ending of setMinimumValueEdit  method");
	}

	public void clickOnEditNextButton() {
		logger.info("starting of clickOnEditNextButton method");

		this.explicitWait(btnNextEdit);
		this.clickOnWebElement(btnNextEdit);

		logger.info("Ending of clickOnEditNextButton method");
	}

	public void setEditOfferName(String editOffer) {
		logger.info("Starting of setEditOfferName method");
		if (!System.getProperty("os.name").contains("Mac")) {
			this.txtEditOfferName.sendKeys(Keys.CONTROL + "a");
			this.txtEditOfferName.sendKeys(Keys.DELETE);
		} else {
			this.txtEditOfferName.sendKeys(Keys.COMMAND + "a");
			this.txtEditOfferName.sendKeys(Keys.DELETE);
		}

		this.txtEditOfferName.sendKeys(editOffer);

		logger.info("Ending of setEditOfferName  method");
	}

	public void setEditTotalLimit(String editedTotalLimit) {
		logger.info("Starting of setEditTotalLimit method");
		if (!System.getProperty("os.name").contains("Mac")) {
			this.txtEditTotalLimit.sendKeys(Keys.CONTROL + "a");
			this.txtEditTotalLimit.sendKeys(Keys.DELETE);
		} else {
			this.txtEditTotalLimit.sendKeys(Keys.COMMAND + "a");
			this.txtEditTotalLimit.sendKeys(Keys.DELETE);
		}

		this.txtEditTotalLimit.sendKeys(editedTotalLimit);

		logger.info("Ending of setEditTotalLimit  method");
	}

	public void clickOnEditCodeNextButton() {
		logger.info("starting of clickOnEditCodeNextButton method");

		this.explicitWait(btnUpdateNext);
		this.btnUpdateNext.click();

		logger.info("Ending of clickOnEditCodeNextButton method");
	}

	public void clickOnEditFinishButton() {
		logger.info("starting of clickOnEditFinishButton method");

		this.btnFinishEdited.click();

		logger.info("Ending of clickOnEditFinishButton method");
	}

	public String getCouponUpdatedMessage() {
		logger.info("Starting of getCouponUpdatedMessage method");

		this.explicitWait(msgCouponUpdated);
		logger.info("Ending of getCouponUpdatedMessage method");
		return msgCouponUpdated.getText();
	}

	public void clickOnThreeDottedButton() {
		logger.info("starting of clickOnThreeDottedButton method");

		this.clickOnWebElement(mnuVerticalIcon);

		logger.info("Ending of clickOnThreeDottedButton method");
	}

	public void clickOnMakeInActiveIcon() {
		logger.info("starting of clickOnMakeActiveIcon method");

		this.hardWait(2);
		this.clickOnWebElement(makeActiveIcon);

		logger.info("Ending of clickOnMakeActiveIcon method");
	}

	public String getCouponDetailsMessage() {
		logger.info("Starting of getCouponDetailsMessage method");

		this.explicitWait(msgCouponUpdatedDetails);

		logger.info("Ending of getCouponDetailsMessage method");

		return msgCouponUpdatedDetails.getText();
	}

	public void clickDeleteIcon() {
		logger.info("starting of clickDeleteIcon method");

		this.clickOnWebElement(deleteIcon);

		logger.info("Ending of clickDeleteIcon method");
	}

	public String getCouponDeleteMessage() {
		logger.info("Starting of getCouponDeleteMessage method");

		this.explicitWait(msgCouponRemoved);

		logger.info("Ending of getCouponDeleteMessage method");

		return msgCouponRemoved.getText();
	}

	public void clickOnSkipButton() {
		logger.info("starting of clickOnSkipButton method");
		try {
			this.btnSkip.click();
		} catch (Exception e) {
			this.clickOnWebElement(btnSkip);
		}

		logger.info("Ending of clickOnSkipButton method");
	}

	public void clickOnEligibleCoursesButton() {
		logger.info("starting of clickOnEligibleCoursesButton method");
		try {
			this.btnSelectEligibleCourses.click();
		} catch (Exception e) {
			this.clickOnWebElement(btnSelectEligibleCourses);
		}

		logger.info("Ending of clickOnEligibleCoursesButton method");
	}

	public void setSearch(String strSelectCourse) {
		logger.info("Starting of setSearch method");

		if (!System.getProperty("os.name").contains("Mac")) {
			this.txtSearch.sendKeys(Keys.CONTROL + "a");
			this.txtSearch.sendKeys(Keys.DELETE);
		} else {
			this.txtSearch.sendKeys(Keys.COMMAND + "a");
			this.txtSearch.sendKeys(Keys.DELETE);
		}

		this.txtSearch.sendKeys(strSelectCourse);

		logger.info("Ending of setSearch  method");
	}

	public void clickOnSelectAllButton() {
		logger.info("starting of clickOnSelectAllButton method");

		try {
			this.btnSelectAll.click();
		} catch (Exception e) {
			this.clickOnWebElement(btnSelectAll);
		}

		logger.info("Ending of clickOnSelectAllButton method");
	}

	public void clickOnSelectCourseCheckBox() {
		logger.info("starting of clickOnSelectCourseCheckBox method");

		try {
			this.chkSelectCourse.click();
		} catch (Exception e) {
			this.clickOnWebElement(chkSelectCourse);
		}

		logger.info("Ending of clickOnSelectCourseCheckBox method");
	}

	public String getEligibleCoursesLabel() {
		logger.info("Starting of getEligibleCoursesLabel method");

		this.explicitWait(lblEligibleCourses);
		logger.info("Ending of getEligibleCoursesLabel method");

		return lblEligibleCourses.getText();
	}

	public void clickOnViewHistoryIcon(String couponCode) {
		logger.info("starting of clickOnViewHistoryIcon method");

		try {
			this.driver.findElement(By.xpath(btnViewHistory.replace("${text}", couponCode.toUpperCase()))).click();

			// this.viewHistoryIcon.click();
		} catch (Exception e) {
			this.clickOnWebElement(viewHistoryIcon);
		}

		logger.info("Ending of clickOnViewHistoryIcon method");
	}

	public String getCouponHistoryLabel() {
		logger.info("Starting of getEligibleCoursesLabel method");

		this.explicitWait(lblCouponHistory);
		logger.info("Ending of getEligibleCoursesLabel method");

		return lblCouponHistory.getText();
	}

	public void setSearchCoupon(String strSearchCoupon) {
		logger.info("Starting of setSearchCoupon method");

		this.explicitWait(txtSearchCoupon);
		if (!System.getProperty("os.name").contains("Mac")) {
			this.txtSearchCoupon.sendKeys(Keys.CONTROL + "a");
			this.txtSearchCoupon.sendKeys(Keys.DELETE);
		} else {
			this.txtSearchCoupon.sendKeys(Keys.COMMAND + "a");
			this.txtSearchCoupon.sendKeys(Keys.DELETE);
		}

		this.txtSearchCoupon.sendKeys(strSearchCoupon.toUpperCase());

		logger.info("Ending of setSearchCoupon  method");
	}

	public String getCouponInformationLabel() {
		logger.info("Starting of getCouponInformationLabel method");

		this.explicitWait(lblCouponInformation);
		logger.info("Ending of getCouponInformationLabel method");

		return lblCouponInformation.getText();
	}

	public String getCouponEligibleStudentsLabel() {
		logger.info("Starting of getCouponEligibleStudentsLabel method");

		this.explicitWait(lblEligibleStudents);
		logger.info("Ending of getCouponEligibleStudentsLabel method");

		return lblEligibleStudents.getText();
	}

	public String getAssignedCoursesLabel() {
		logger.info("Starting of getAssignedCoursesLabel method");

		this.explicitWait(lblAssignedCourses);
		logger.info("Ending of getAssignedCoursesLabel method");

		return lblAssignedCourses.getText();
	}

	public String getUsageLimitLabel() {
		logger.info("Starting of getUsageLimitLabel method");

		this.explicitWait(lblUsageLimit);
		logger.info("Ending of getUsageLimitLabel method");

		return lblUsageLimit.getText();
	}

	public String getUsageLabel() {
		logger.info("Starting of getUsageLabel method");

		this.explicitWait(lblUsage);
		logger.info("Ending of getUsageLabel method");

		return lblUsage.getText();
	}

	public String getMinimumOrderValueLabel() {
		logger.info("Starting of getMinimumOrderValueLabel method");

		this.explicitWait(lblMinOrderValue);
		logger.info("Ending of getMinimumOrderValueLabel method");

		return lblMinOrderValue.getText();
	}

	public void clickOnEditUsageLimitButton() {
		logger.info("Starting of getEditUsageLimitLabel method");

		try {
			this.mouseHover(lblOverallUsageLimit);
			this.btnEditUsageLimit.click();
		} catch (Exception e) {
			this.clickOnWebElement(btnEditUsageLimit);
		}

		logger.info("Ending of getEditUsageLimitLabel method");

		// return btnEditUsageLimit.getText();
	}

	public String getEditCouponDetailsLabel() {
		logger.info("Starting of getEditCouponDetailsLabel method");

		this.explicitWait(lblEditCouponDetails);
		logger.info("Ending of getEditCouponDetailsLabel method");

		return lblEditCouponDetails.getText();
	}

	public void setEditUsageLimitValue(String strEditUsageLimitValue) {
		logger.info("Starting of setEditUsageLimitValue method");
		if (!System.getProperty("os.name").contains("Mac")) {
			this.txtEditUsageLimitValue.sendKeys(Keys.CONTROL + "a");
			this.txtEditUsageLimitValue.sendKeys(Keys.DELETE);
		} else {
			this.txtEditUsageLimitValue.sendKeys(Keys.COMMAND + "a");
			this.txtEditUsageLimitValue.sendKeys(Keys.DELETE);
		}

		this.txtEditUsageLimitValue.sendKeys(strEditUsageLimitValue);

		logger.info("Ending of setEditUsageLimitValue  method");
	}

	public void clickOnSaveChangesButton() {
		logger.info("starting of clickOnSaveChangesButton method");

		try {
			this.btnSaveChanges.click();
		} catch (Exception e) {
			this.clickOnWebElement(btnSaveChanges);
		}

		logger.info("Ending of clickOnSaveChangesButton method");
	}

	public void clickOnShowDetailsButton(String couponCode) {
		logger.info("starting of clickOnSelectCourseCheckBox method");

		try {
			this.explicitWait(
					driver.findElement(By.xpath(btnShowDetails.replace("${text}", couponCode.toUpperCase()))));
			this.driver.findElement(By.xpath(btnShowDetails.replace("${text}", couponCode.toUpperCase()))).click();
		} catch (Exception e) {
			this.clickOnWebElement(
					driver.findElement(By.xpath(btnShowDetails.replace("${text}", couponCode.toUpperCase()))));
		}

		logger.info("Ending of clickOnSelectCourseCheckBox method");
	}

	public String getCouponNameLabel() {
		logger.info("Starting of getCouponNameLabel method");

		this.explicitWait(lblCouponName);
		logger.info("Ending of getCouponNameLabel method");

		return lblCouponName.getText();
	}

	public void setEditUsageStudent(String strEditUsagePerStudent) {
		logger.info("Starting of setEditUsageLimitValue method");
		if (!System.getProperty("os.name").contains("Mac")) {
			this.txtEditUsagePerStudent.sendKeys(Keys.CONTROL + "a");
			this.txtEditUsagePerStudent.sendKeys(Keys.DELETE);
		} else {
			this.txtEditUsagePerStudent.sendKeys(Keys.COMMAND + "a");
			this.txtEditUsagePerStudent.sendKeys(Keys.DELETE);
		}

		this.txtEditUsagePerStudent.sendKeys(strEditUsagePerStudent);

		logger.info("Ending of setEditUsageLimitValue  method");
	}

	public void clickOnEditUsagePerStudentButton() {
		logger.info("Starting of clickOnEditUsagePerStudentButton method");

		try {
			this.mouseHover(lblUsagePerStudent);
			this.btnEditUsagePerStudent.click();
		} catch (Exception e) {
			this.clickOnWebElement(btnEditUsagePerStudent);
		}

		logger.info("Ending of clickOnEditUsagePerStudentButton method");

		return;
	}

	/*
	 * //public void setEditUsageStudent() {
	 * logger.info("Starting of setEditUsagePerStudent method");
	 * 
	 * this.txtEditUsagePerStudent.sendKeys(Keys.CONTROL + "a");
	 * this.txtEditUsagePerStudent.sendKeys(Keys.DELETE);
	 * //this.txtEditUsagePerStudent.sendKeys(strEditUsagePerStudent);
	 * 
	 * logger.info("Ending of setEditUsagePerStudent  method"); }
	 */
	public void setEditUsagePerStudent(String strEditUsagePerStudent) {
		logger.info("Starting of setEditUsagePerStudent method");
		if (!System.getProperty("os.name").contains("Mac")) {
			this.txtEditUsagePerStudent.sendKeys(Keys.CONTROL + "a");
			this.txtEditUsagePerStudent.sendKeys(Keys.DELETE);
		} else {
			this.txtEditUsagePerStudent.sendKeys(Keys.COMMAND + "a");
			this.txtEditUsagePerStudent.sendKeys(Keys.DELETE);
		}

		this.txtEditUsagePerStudent.sendKeys(strEditUsagePerStudent);

		logger.info("Ending of setEditUsagePerStudent  method");
	}

	public void clickOnEditMinimumOrderValueButton() {
		logger.info("Starting of clickOnEditUsagePerStudentButton method");

		try {
			this.mouseHover(lblMinimumOrderValue);
			this.btnEditMinimumOrderValue.click();
		} catch (Exception e) {
			this.clickOnWebElement(btnEditMinimumOrderValue);
		}

		logger.info("Ending of clickOnEditUsagePerStudentButton method");

		// return btnEditUsageLimit.getText();
	}

	public void setEditMinimumOrderValue(String strMinimumOrderValue) {
		logger.info("Starting of setEditUsagePerStudent method");

		if (!System.getProperty("os.name").contains("Mac")) {
			this.txtMinimumOrderValue.sendKeys(Keys.CONTROL + "a");
			this.txtMinimumOrderValue.sendKeys(Keys.DELETE);
		} else {
			this.txtMinimumOrderValue.sendKeys(Keys.COMMAND + "a");
			this.txtMinimumOrderValue.sendKeys(Keys.DELETE);
		}

		this.txtMinimumOrderValue.sendKeys(strMinimumOrderValue);

		logger.info("Ending of setEditUsagePerStudent  method");
	}

	public String getNoCouponFoundLabel() {
		logger.info("Starting of getNoCouponFoundLabel method");

		this.explicitWait(lblNoCouponFound);
		logger.info("Ending of getNoCouponFoundLabel method");

		return lblNoCouponFound.getText();
	}

	public String getCouponCodeLabel() {
		logger.info("Starting of getCouponCodeLabel method");
		logger.info("Ending of getCouponCodeLabel method");

		return lblCouponCode1.getText();
	}

	public String getDurationLabel() {
		logger.info("Starting of getDurationLabel method");
		logger.info("Ending of getDurationLabel method");

		return lblDuration.getText();
	}

	public String getPublicCouponLabel() {
		logger.info("Starting of getPublicCouponLabel method");
		logger.info("Ending of getPublicCouponLabel method");

		return lblPublicCoupon.getText();
	}

	public String getProTutorLabel() {
		logger.info("Starting of getProTutorLabel method");
		logger.info("Ending of getProTutorLabel method");

		return lblProTutor.getText();
	}

	public String getExpiredLabel() {
		logger.info("Starting of getExpiredLabel method");
		logger.info("Ending of getExpiredLabel method");

		return lblExpired.getText();
	}

	public void setInvalidFlatDiscount(String strDiscount) {
		logger.info("Starting of setFlatDiscount method");

		if (!System.getProperty("os.name").contains("Mac")) {
			this.txtDiscountAmount.sendKeys(Keys.CONTROL + "a");
			this.txtDiscountAmount.sendKeys(Keys.DELETE);
			this.txtDiscountAmount.sendKeys(strDiscount);
			this.txtDiscountAmount.sendKeys(Keys.CONTROL + "a");
			this.txtDiscountAmount.sendKeys(Keys.DELETE);
		} else {
			this.txtDiscountAmount.sendKeys(Keys.COMMAND + "a");
			this.txtDiscountAmount.sendKeys(Keys.DELETE);
			this.txtDiscountAmount.sendKeys(strDiscount);
			this.txtDiscountAmount.sendKeys(Keys.COMMAND + "a");
			this.txtDiscountAmount.sendKeys(Keys.DELETE);

		}
		this.txtStartDate.click();

		logger.info("Ending of setFlatDiscount  method");
	}

	public void setInvalidDiscount(String strDiscount) {
		logger.info("Starting of setFlatDiscount method");

		if (!System.getProperty("os.name").contains("Mac")) {
			this.txtDiscountAmount.sendKeys(Keys.CONTROL + "a");
			this.txtDiscountAmount.sendKeys(Keys.DELETE);
		} else {
			this.txtDiscountAmount.sendKeys(Keys.COMMAND + "a");
			this.txtDiscountAmount.sendKeys(Keys.DELETE);
		}

		this.txtDiscountAmount.sendKeys(strDiscount);
		/*
		 * this.txtDiscountAmount.sendKeys(Keys.CONTROL + "a");
		 * this.txtDiscountAmount.sendKeys(Keys.DELETE);
		 */this.txtStartDate.click();

		logger.info("Ending of setFlatDiscount  method");
	}

	public String getDiscountRequiredLabel() {
		logger.info("Starting of getDiscountRequiredLabel method");

		this.explicitWait(lblDiscountRequired);
		logger.info("Ending of getDiscountRequiredLabel method");

		return lblDiscountRequired.getText();
	}

	public void setInvalidStartDate(String strInvalidStartDate) {
		logger.info("Starting of setInvalidStartDate method");

		if (!System.getProperty("os.name").contains("Mac")) {
			this.txtStartDate.sendKeys(Keys.CONTROL + "a");
			this.txtStartDate.sendKeys(Keys.DELETE);
		} else {
			this.txtStartDate.sendKeys(Keys.COMMAND + "a");
			this.txtStartDate.sendKeys(Keys.DELETE);
		}

		this.txtStartDate.sendKeys(strInvalidStartDate);
		// this.clickOutside();
		this.txtStartTime.click();

		logger.info("Ending of setInvalidStartDate  method");
	}

	public void setBlankStartDate() {
		logger.info("Starting of setBlankStartDate method");

		try {
			if (!System.getProperty("os.name").contains("Mac")) {
				this.txtStartDate.sendKeys(Keys.CONTROL + "a");
				this.txtStartDate.sendKeys(Keys.DELETE);
			} else {
				this.txtStartDate.sendKeys(Keys.COMMAND + "a");
				this.txtStartDate.sendKeys(Keys.DELETE);
			}

			Thread.sleep(2000);
			// this.clickOutside();
			this.txtStartTime.click();
		} catch (Exception e) {
		}
		logger.info("Ending of setBlankStartDate  method");
	}

	public void setInValidStartTime(String strvalidStartDate) {
		logger.info("Starting of setInvalidStartDate method");

		if (!System.getProperty("os.name").contains("Mac")) {
			this.txtStartTime.sendKeys(Keys.CONTROL + "a");
			this.txtStartTime.sendKeys(Keys.DELETE);
		} else {
			this.txtStartTime.sendKeys(Keys.COMMAND + "a");
			this.txtStartTime.sendKeys(Keys.DELETE);
		}

		this.txtStartTime.sendKeys(strvalidStartDate);
		this.txtStartDate.click();

		logger.info("Ending of setInvalidStartDate  method");
	}

	public void setValidStartTime(String strvalidStartDate) {
		logger.info("Starting of setInvalidStartDate method");

		if (!System.getProperty("os.name").contains("Mac")) {
			this.txtStartTime.sendKeys(Keys.CONTROL + "a");
			this.txtStartTime.sendKeys(Keys.DELETE);
		} else {
			this.txtStartTime.sendKeys(Keys.COMMAND + "a");
			this.txtStartTime.sendKeys(Keys.DELETE);
		}

		this.txtStartTime.sendKeys(strvalidStartDate);
		this.txtEndDate.click();

		logger.info("Ending of setInvalidStartDate  method");
	}
//Negative time 

	public String getInvalidStartDateLabel() {
		logger.info("Starting of getInvalidStartDateLabel method");

		this.explicitWait(lblInvalidStartDate);
		try {
			Thread.sleep(2000);
		} catch (Exception e) {

			e.printStackTrace();
		}
		logger.info("Ending of getInvalidStartDateLabel method");

		return lblInvalidStartDate.getText();
	}

	public void setBlankStartTime() {
		logger.info("Starting of setBlankStartTime method");

		try {

			if (!System.getProperty("os.name").contains("Mac")) {
				this.txtStartTime.sendKeys(Keys.CONTROL + "a");
				this.txtStartTime.sendKeys(Keys.DELETE);
			} else {
				this.txtStartTime.sendKeys(Keys.COMMAND + "a");
				this.txtStartTime.sendKeys(Keys.DELETE);
			}

			this.txtStartDate.click();
			// this.txtStartTime.sendKeys(strInvalidStartTime);
			// this.clickOutside();
			Thread.sleep(3000);
		} catch (Exception e) {

			e.printStackTrace();
		}

		logger.info("Ending of setBlankStartTime  method");
	}

	public String getInvalidStartTimeLabel() {
		logger.info("Starting of getInvalidStartTimeLabel method");

		this.explicitWait(lblInvalidStartDate);
		logger.info("Ending of getInvalidStartTimeLabel method");

		return lblInvalidStartDate.getText();
	}

	public void setInvalidEndDate(String strInvalidEndDate) {
		logger.info("Starting of setInvalidStartDate method");

		if (!System.getProperty("os.name").contains("Mac")) {
			this.txtEndDate.sendKeys(Keys.CONTROL + "a");
			this.txtEndDate.sendKeys(Keys.DELETE);
		} else {
			this.txtEndDate.sendKeys(Keys.COMMAND + "a");
			this.txtEndDate.sendKeys(Keys.DELETE);
		}

		this.txtEndDate.sendKeys(strInvalidEndDate);
		// this.clickOutside();
		this.txtStartTime.click();

		logger.info("Ending of setInvalidStartDate  method");
	}

	public void setBlankEndDate() {
		logger.info("Starting of setBlankStartDate method");

		try {
			if (!System.getProperty("os.name").contains("Mac")) {
				this.txtEndDate.sendKeys(Keys.CONTROL + "a");
				this.txtEndDate.sendKeys(Keys.DELETE);
			} else {
				this.txtEndDate.sendKeys(Keys.COMMAND + "a");
				this.txtEndDate.sendKeys(Keys.DELETE);
			}

			Thread.sleep(2000);
			this.txtStartTime.click();
		} catch (Exception e) {
		}
		logger.info("Ending of setBlankStartDate  method");
	}

	public void setInValidEndTime(String strvalidStartDate) {
		logger.info("Starting of setInValidEndTime method");

		if (!System.getProperty("os.name").contains("Mac")) {
			this.txtEndTime.sendKeys(Keys.CONTROL + "a");
			this.txtEndTime.sendKeys(Keys.DELETE);
		} else {
			this.txtEndTime.sendKeys(Keys.COMMAND + "a");
			this.txtEndTime.sendKeys(Keys.DELETE);
		}

		this.txtEndTime.sendKeys(strvalidStartDate);
		this.txtEndDate.click();

		logger.info("Ending of setInValidEndTime  method");
	}

	public void setBlankEndTime() {
		logger.info("Starting of setBlankStartTime method");

		try {
			if (!System.getProperty("os.name").contains("Mac")) {
				this.txtEndTime.sendKeys(Keys.CONTROL + "a");
				this.txtEndTime.sendKeys(Keys.DELETE);
			} else {
				this.txtEndTime.sendKeys(Keys.COMMAND + "a");
				this.txtEndTime.sendKeys(Keys.DELETE);
			}
			this.txtStartDate.click();
			// this.txtStartTime.sendKeys(strInvalidStartTime);
			// this.clickOutside();
			Thread.sleep(3000);
		} catch (Exception e) {

			e.printStackTrace();
		}

		logger.info("Ending of setBlankStartTime  method");
	}

	public void setBlankMinimumValue(String strEditMinValue) {
		logger.info("Starting of setBlankMinimumValue method");
		if (!System.getProperty("os.name").contains("Mac")) {
			this.txtEditMinOrderValue.sendKeys(Keys.CONTROL + "a");
			this.txtEditMinOrderValue.sendKeys(Keys.DELETE);
		} else {
			this.txtEditMinOrderValue.sendKeys(Keys.COMMAND + "a");
			this.txtEditMinOrderValue.sendKeys(Keys.DELETE);
		}

		this.txtEditMinOrderValue.sendKeys(strEditMinValue);
		this.txtStartDate.click();

		logger.info("Ending of setBlankMinimumValue  method");
	}

	public void setInValidOfferName(String strOfferName) {
		logger.info("Starting of setInValidOfferName method");

		if (!System.getProperty("os.name").contains("Mac")) {
			this.txtEnterOfferName.sendKeys(Keys.CONTROL + "a");
			this.txtEnterOfferName.sendKeys(Keys.DELETE);
		} else {
			this.txtEnterOfferName.sendKeys(Keys.COMMAND + "a");
			this.txtEnterOfferName.sendKeys(Keys.DELETE);
		}

		this.txtEnterOfferName.sendKeys(strOfferName);
		this.txtEditTotalLimit.click();

		logger.info("Ending of setInValidOfferName  method");
	}

	public String getInvalidOfferNameLabel() {
		logger.info("Starting of getInvalidOfferNameLabel method");

		this.explicitWait(lblInvalidStartDate);
		logger.info("Ending of getInvalidOfferNameLabel method");

		return lblInvalidStartDate.getText();
	}

	public void setBlankOfferName() {
		logger.info("Starting of setBlankOfferName method");

		if (!System.getProperty("os.name").contains("Mac")) {
			this.txtEnterOfferName.sendKeys(Keys.CONTROL + "a");
			this.txtEnterOfferName.sendKeys(Keys.DELETE);
		} else {
			this.txtEnterOfferName.sendKeys(Keys.COMMAND + "a");
			this.txtEnterOfferName.sendKeys(Keys.DELETE);
		}

		// this.txtEnterOfferName.sendKeys(strOfferName);
		try {
			this.txtEnterCouponCode.click();
		} catch (Exception e) {
			// TODO: handle exception
		}
		logger.info("Ending of setBlankOfferName  method");
	}

	public void setInvalidCouponCode(String strCouponCode) {
		logger.info("Starting of setInvalidCouponCode method");

		if (!System.getProperty("os.name").contains("Mac")) {
			this.txtEnterCouponCode.sendKeys(Keys.CONTROL + "a");
			this.txtEnterCouponCode.sendKeys(Keys.DELETE);
		} else {
			this.txtEnterCouponCode.sendKeys(Keys.COMMAND + "a");
			this.txtEnterCouponCode.sendKeys(Keys.DELETE);
		}

		this.txtEnterCouponCode.sendKeys(strCouponCode);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.txtEditTotalLimit.click();

		logger.info("Ending of setInvalidCouponCode  method");
	}

	public void setBlankCouponCode() {
		logger.info("Starting of setBlankCouponCode method");

		if (!System.getProperty("os.name").contains("Mac")) {
			this.txtEnterOfferName.sendKeys(Keys.CONTROL + "a");
			this.txtEnterOfferName.sendKeys(Keys.DELETE);
		} else {
			this.txtEnterOfferName.sendKeys(Keys.COMMAND + "a");
			this.txtEnterOfferName.sendKeys(Keys.DELETE);
		}

		// this.txtEnterOfferName.sendKeys(strOfferName);
		this.rdoPrivateCoupon.click();

		logger.info("Ending of setBlankCouponCode  method");
	}

	public void setInvalidTotalLimit(String strTotalLimit) {
		logger.info("Starting of setTotalLimit method");

		if (!System.getProperty("os.name").contains("Mac")) {
			this.txtEnterTotalLimit.sendKeys(Keys.CONTROL + "a");
			this.txtEnterTotalLimit.sendKeys(Keys.DELETE);
		} else {
			this.txtEnterTotalLimit.sendKeys(Keys.COMMAND + "a");
			this.txtEnterTotalLimit.sendKeys(Keys.DELETE);
		}

		this.txtEnterTotalLimit.sendKeys(strTotalLimit);
		this.hardWait(2);
		this.txtEnterUsageLimit.click();

		logger.info("Ending of setTotalLimit  method");
	}

	public void setBlankTotalLimit() {
		logger.info("Starting of setTotalLimit method");

		if (!System.getProperty("os.name").contains("Mac")) {
			this.txtEnterTotalLimit.sendKeys(Keys.CONTROL + "a");
			this.txtEnterTotalLimit.sendKeys(Keys.DELETE);
		} else {
			this.txtEnterTotalLimit.sendKeys(Keys.COMMAND + "a");
			this.txtEnterTotalLimit.sendKeys(Keys.DELETE);
		}

		// this.txtEnterTotalLimit.sendKeys(strTotalLimit);
		this.txtEnterUsageLimit.click();

		logger.info("Ending of setTotalLimit  method");
	}

	public void setInvalidUserLimit(String strUserLimit) {
		logger.info("Starting of setUserLimit method");

		if (!System.getProperty("os.name").contains("Mac")) {
			this.txtEnterUsageLimit.sendKeys(Keys.CONTROL + "a");
			this.txtEnterUsageLimit.sendKeys(Keys.DELETE);
		} else {
			this.txtEnterUsageLimit.sendKeys(Keys.COMMAND + "a");
			this.txtEnterUsageLimit.sendKeys(Keys.DELETE);
		}

		this.txtEnterUsageLimit.sendKeys(strUserLimit);
		this.txtEnterTotalLimit.click();

		logger.info("Ending of setUserLimit  method");
	}

	public void setBlankUserLimit() {
		logger.info("Starting of setUserLimit method");

		if (!System.getProperty("os.name").contains("Mac")) {
			this.txtEnterUsageLimit.sendKeys(Keys.CONTROL + "a");
			this.txtEnterUsageLimit.sendKeys(Keys.DELETE);
		} else {
			this.txtEnterUsageLimit.sendKeys(Keys.COMMAND + "a");
			this.txtEnterUsageLimit.sendKeys(Keys.DELETE);
		}

		// this.txtEnterUsageLimit.sendKeys(strUserLimit);
		this.txtEnterTotalLimit.click();

		logger.info("Ending of setUserLimit  method");
	}

	public void setBlankPercentageDiscount() {
		logger.info("starting of setBlankPercentageDiscount method");
		if (!System.getProperty("os.name").contains("Mac")) {
			this.txtPercentageDiscount.sendKeys(Keys.CONTROL + "a");
			this.txtPercentageDiscount.sendKeys(Keys.DELETE);
		} else {
			this.txtPercentageDiscount.sendKeys(Keys.COMMAND + "a");
			this.txtPercentageDiscount.sendKeys(Keys.DELETE);
		}

		this.txtMaxPercentageDiscount.click();

		logger.info("Ending of setBlankPercentageDiscount method");
	}

	public void setInvalidPercentageDiscount(String StrPercentageDiscount) {
		logger.info("starting of setInvalidPercentageDiscount method");

		if (!System.getProperty("os.name").contains("Mac")) {
			this.txtPercentageDiscount.sendKeys(Keys.CONTROL + "a");
			this.txtPercentageDiscount.sendKeys(Keys.DELETE);
		} else {
			this.txtPercentageDiscount.sendKeys(Keys.COMMAND + "a");
			this.txtPercentageDiscount.sendKeys(Keys.DELETE);
		}

		this.txtPercentageDiscount.sendKeys(StrPercentageDiscount);
		this.txtMaxPercentageDiscount.click();

		logger.info("Ending of setInvalidPercentageDiscount method");
	}

	public void setInvalidMaxPercentageDiscount(String StrMaxPercentageDiscount) {
		logger.info("starting of setMaxPercentageDiscount method");

		if (!System.getProperty("os.name").contains("Mac")) {
			this.txtPercentageDiscount.sendKeys(Keys.CONTROL + "a");
			this.txtPercentageDiscount.sendKeys(Keys.DELETE);
		} else {
			this.txtPercentageDiscount.sendKeys(Keys.COMMAND + "a");
			this.txtPercentageDiscount.sendKeys(Keys.DELETE);
		}

		this.txtMaxPercentageDiscount.sendKeys(StrMaxPercentageDiscount);
		this.txtPercentageDiscount.click();
		logger.info("Ending of setMaxPercentageDiscount method");
	}

	public void setBlankMaxPercentageDiscount() {
		logger.info("starting of setMaxPercentageDiscount method");

		if (!System.getProperty("os.name").contains("Mac")) {
			this.txtMaxPercentageDiscount.sendKeys(Keys.CONTROL + "a");
			this.txtMaxPercentageDiscount.sendKeys(Keys.DELETE);
		} else {
			this.txtMaxPercentageDiscount.sendKeys(Keys.COMMAND + "a");
			this.txtMaxPercentageDiscount.sendKeys(Keys.DELETE);
		}

		this.txtPercentageDiscount.click();

		logger.info("Ending of setMaxPercentageDiscount method");
	}

	public String getNumberOfTimesCodeUsageLabel() {
		logger.info("Starting of getInvalidOfferNameLabel method");

		this.explicitWait(lblNumberOfTimesCodeUsage);
		this.hardWait(2);
		logger.info("Ending of getInvalidOfferNameLabel method");
		return lblNumberOfTimesCodeUsage.getText();
	}

	public void clickOnInvalidThreeDottedButton() {
		logger.info("starting of clickOnInvalidThreeDottedButton method");

		try {
			this.btnThreedotted.click();
		} catch (Exception e) {
			this.clickOnWebElement(btnThreedotted);
		}

		logger.info("Ending of clickOnInvalidThreeDottedButton method");
	}

	public void clickOnInvalidMakeInactiveButton() {
		logger.info("starting of clickOnSkipButton method");
		try {
			this.btnMakeInactive.click();
		} catch (Exception e) {
			this.clickOnWebElement(btnMakeInactive);
		}

		logger.info("Ending of clickOnSkipButton method");
	}

	public void clickOnInvalidDeleteButton() {
		logger.info("starting of clickOnSkipButton method");

		try {
			this.btnDeleteInvalidCoupon.click();
		} catch (Exception e) {
			this.clickOnWebElement(btnDeleteInvalidCoupon);
		}

		logger.info("Ending of clickOnSkipButton method");
	}

	public String getCouponUnavailableText() {
		logger.info("Starting of getCouponUnavailableText method");

		this.explicitWait(lblCouponUnavailableText);

		logger.info("Ending of getInvalidOfferNameLabel method");
		return lblCouponUnavailableText.getText();
	}
}