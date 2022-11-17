package com.classplusapp.web.pages.tutor;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.lang.model.element.Element;

import org.apache.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.classplusapp.web.pages.BaseClassplusAutomationPage;

public class TutorCreateCoursePage extends BaseClassplusAutomationPage {

	@FindBy(xpath = "//p[text()='Store']")
	private WebElement btnStore;

	@FindBy(xpath = "//div[@class='Header_TabActive__rBN0q']")
	private WebElement lblMyCourses;

	@FindBy(xpath = "//div[contains(@class,'Header_Tab')]//following-sibling::div")
	private WebElement lblContentMarket;

	@FindBy(xpath = "//input[@placeholder='Search for a course']")
	private WebElement lblSearchBar;

	@FindBy(xpath = "//button[contains(@class,'Header_FilterButton')]")
	private WebElement lblSortFilter;

	@FindBy(xpath = "//div[contains(@class,'EmptyScreen_nothingFound')]//preceding-sibling::div")
	private WebElement msgNothingFound;

	@FindBy(xpath = "//input[@placeholder='Search for a course']//following-sibling::img")
	private WebElement btnSearchBarBack;

	@FindBy(xpath = "//div[contains(@class,'Header_FilteringHeader')]/img")
	private WebElement btnAllCoursesBack;

	@FindBy(xpath = "//div[@class='Header_createCourse__MIfFo']")
	private WebElement btnCreateCourse;

//	@FindBy(xpath = "//div[contains(@class,'StoreCarousels_cardHeader__141K1 StoreCarousels_statsHeader')]/../../../../preceding-sibling::div/div/div/div/div[contains(@class,'StoreCarousels_cardHeader__141K1 StoreCarousels_statsHeader')]")
	@FindBy(xpath = "//div[contains(text(),'Stats')]")
	private WebElement lblStats;

	@FindBy(xpath = "//div[@class='Card_bannerCard__3R2tv cursorPointer ']")
	private WebElement lblCourseBanner;

	// @FindBy(xpath = "//div[contains(@class,'StoreCarousels_cardHeader__141K1
	// StoreCarousels_statsHeader')]/../../../../following-sibling::div/div/div/div/div[contains(@class,'StoreCarousels_cardHeader__141K1
	// StoreCarousels_statsHeader')]")
	@FindBy(xpath = "//div[contains(text(),'Coupon Codes')]")
	private WebElement lblCouponCodes;

	@FindBy(xpath = "//div[contains(@class,'Carousel_carouselHeader')]/div[contains(@class,'StoreCarousels_cardHeader')]/../../../../following-sibling::div/following-sibling::div/div/div/div/div/div[contains(@class,'StoreCarousels_cardHeader')]")
	private WebElement lblCategorySubcategory;

	@FindBy(xpath = "//button[@class='InfobipBtnOpen InfobipBtnOpen-border']")
	private WebElement lblHelpIcon;

	@FindBy(xpath = "//button[@class='InfobipBtnOpen InfobipBtnOpen-borderScroll']")
	private WebElement lblWhatsAppIcon;

	@FindBy(xpath = "//div[contains(@class,'StoreCarousels_notCarousel')]/preceding-sibling::div")
	private WebElement lblCourses;

	@FindBy(xpath = "//div[contains(@class,'StoreCarousels_cardHeader__141K1 StoreCarousels_statsHeader')]/../../../../preceding-sibling::div/div/div/div/div[contains(@class,'StoreCarousels_cardHeader__141K1 StoreCarousels_statsHeader')]/../following-sibling::div/ul/li/div")
	private List<WebElement> lblStatsCard;

	@FindBy(xpath = "//div[contains(@class,'StoreCarousels_cardHeader__141K1 StoreCarousels_statsHeader')]/../../../../following-sibling::div/div/div/div/div[contains(@class,'StoreCarousels_cardHeader__141K1 StoreCarousels_statsHeader')]/../following-sibling::div/ul/li/div")
	private List<WebElement> lblCouponsCard;

	@FindBy(xpath = "//div[contains(@class,'cursorPointer Card_FeaturedCourse__3o0XN Card_CarouselAllCourses__1EQX_ StoreCarousels_responsiveCourseListCard')]")
	private List<WebElement> lblCourseCards;

	@FindBy(xpath = "//div[@class='StoreCarousels_paddingClass__sLnyM']//button[@class='Carousel_Right__33zBq']//span[contains(@class,'Carousel_roundButton__3P_Hl')]")
	private WebElement btnCouponRightCarousel;

	@FindBy(xpath = "//img[@src='/static/media/next.e3538852.svg']")
	private WebElement btnCourseBack;

	@FindBy(xpath = "//span[contains(text(),'View All')]")
	private WebElement lblViewAll;

	@FindBy(xpath = "//h1[contains(text(),'Create Course')]")
	private WebElement lblCreateCourse;

	@FindBy(xpath = "//input[@placeholder='Enter Course Name']")
	private WebElement txtCourseName;

	@FindBy(xpath = "//textarea[@placeholder='Description goes here']")
	private WebElement txtDescription;

	@FindBy(xpath = "//input[@type=\"file\"]")
	private WebElement imgUploadPhoto;

	@FindBy(xpath = "//div[@class='ui fluid search selection dropdown']/input")
	private WebElement categoryDropdown;

	@FindBy(xpath = "//div[@class=\"menu transition visible\"] //div[@id='2']")
	private WebElement categoryOption;

	@FindBy(xpath = "//div[@class='ui fluid multiple search selection dropdown']/input")
	private WebElement subCategoryDropdown;

	@FindBy(xpath = "//div[@class=\"menu transition visible\"]//div[@id = '127']")
	private WebElement subCategoryOption;

	@FindBy(xpath = "//input[@style=\"width: 100%;\"]")
	private WebElement txtPrice;

	@FindBy(xpath = "//input[@style=\"width: 100%; margin-left: 4px;\"]")
	private WebElement txtDiscount;

	@FindBy(xpath = "//div[contains(text(),'Internet Handling Charges')] / parent :: div /following-sibling::div/div/div/input")
	private WebElement tglInternetCharges;

	@FindBy(xpath = "//div[contains(text(),'Tax Details')] / parent :: div /following-sibling::div//div[@class='ui checked fitted toggle checkbox']/input")
	private WebElement tglTaxDetails;

	@FindBy(xpath = "//div[contains(text(),'Are you sure you want to exclude Tax Details?')]")
	private WebElement lblAreYouSureYouWantToExcludeTaxDetails;

	@FindBy(xpath = "//button[@class='ui blue basic button']")
	private WebElement btnTaxDetailsCancel;

	@FindBy(xpath = "//*[contains(@id,'expiryType3')]")
	private WebElement rdoLifeTimeDuration;

	@FindBy(xpath = "//b[text()='Course Sharing']/../..//following-sibling::div")
	private WebElement chkCourseSharing;

	@FindBy(xpath = "//div[@class='Shipment__CreateCourse__Option--Label']//following-sibling::div[2]//label")
	private WebElement lbl_tentativeDays;

	@FindBy(className = "Shipment__CreateCourse__Option--Description--Note")
	private WebElement shipmentNote;

	@FindBy(xpath = "//button[contains(text(),'View Permissions')]")
	private WebElement viewPermissions;

	@FindBy(xpath = "(//div[@class='ui fitted toggle checkbox'])[8]")
	private WebElement editPrice;

	@FindBy(xpath = "//button[contains(text(),'Save')]")
	private WebElement saveEdited;

	@FindBy(xpath = "//div[@class=\"ui checkbox\"]")
	private WebElement checkbox;

	@FindBy(xpath = "//input[@placeholder='Enter Minimum Course Value']")
	private WebElement txtMinCourseValue;

	@FindBy(xpath = "//input[@placeholder='Enter percentage share']")
	private WebElement txtSharePercentage;

	@FindBy(xpath = "//div[contains(text(),'Offline access permissions')] / parent :: div /following-sibling::div//div[@class='ui fitted toggle checkbox']/input")
	private WebElement tglOfflineAccess;

	@FindBy(xpath = "//div[@class='Shipment__CreateCourse__Option--Label']//following-sibling::div[2]//div")
	private WebElement tglSetTentativeDeliveryDays;

	@FindBy(xpath = "//div[contains(text(),'Pdf download permissions')] / parent :: div /following-sibling::div//div[@class='ui fitted toggle checkbox']/input")
	private WebElement tglPdfDownload;

	@FindBy(xpath = "//div[contains(text(),'Live Classes')] / parent :: div /following-sibling::div//div[@class='ui fitted toggle checkbox']/input")
	private WebElement tglLiveClasses;

	@FindBy(xpath = "(//b[contains(text(),'Video Restrictions')]/parent::div /following-sibling::div//div[contains(@class,'videoPermissions')]//div)[1]")
	private WebElement tglVideoRestrictionsaOnWeb;

	@FindBy(xpath = "(//b[contains(text(),'Video Restrictions')]/parent::div /following-sibling::div//div[contains(@class,'videoPermissions')]//div)[2]")
	private WebElement tglVideoRestrictionsOnVideo;

	@FindBy(xpath = "//label[text()='Set maximum number of views']/..")
	private WebElement chkMaxViews;

	@FindBy(xpath = "//input[@placeholder=\"Set max number of views\"]")
	private WebElement txtMaxViews;

	@FindBy(xpath = "//label[text()='Set maximum view duration in HRS']/..")
	private WebElement chkViewDuration;

	@FindBy(xpath = "//label[normalize-space()='Update Existing Videos']/..")
	private WebElement chkUpdateExistingVideos;

	@FindBy(xpath = "//input[@class='rc-time-picker-input']//parent::span")
	private WebElement dtpViewDuration;

	@FindBy(xpath = "//i[@class='rc-time-picker-clear-icon']")
	private WebElement btnClearDuration;

	@FindBy(xpath = "//div[@class='rc-time-picker-panel-select'][2]//ul//li[text()='${text}']")
	private WebElement btnDurationMinutes;

	@FindBy(xpath = "//input[@class='rc-time-picker-input']")
	private WebElement inputViewDuration;

	@FindBy(xpath = "//div[@class=\"rc-time-picker-panel-select\"] //li[contains(text(),\"02\")]")
	private WebElement dtpShowView;

	@FindBy(xpath = "//div[contains(text(),'Preview Course Feature')]/parent::div /following-sibling::div //div[@class=\"ui fitted toggle checkbox\"]/input")
	private WebElement tglPreviewCourse;

	@FindBy(xpath = "//div[@class=\"ui fitted checkbox\"]/input")
	private WebElement chkTermsAndConditions;

	@FindBy(xpath = "//button[contains(text(),'Add Content')]")
	private WebElement btnAddContent;

	@FindBy(xpath = "//div[contains(text(),'Course Created Successfully')]")
	private WebElement msgCourseCreated;

	@FindBy(xpath = "//span[contains(text(),'Content')]//parent::div")
	private WebElement lblContent;

	@FindBy(xpath = "//div[@class='courseContentCurrent']")
	private WebElement btnOverView;

	@FindBy(xpath = "//span[text()=\"Overview\"]")
	private WebElement sideLabelOverview;

	@FindBy(xpath = "//div[contains(text(),'Course Name')]")
	private WebElement lblCourseName;

	@FindBy(xpath = "(//div[contains(text(),'Description')])[2]")
	private WebElement lblDescription;

	@FindBy(xpath = "//div[contains(text(),'Category')]")
	private WebElement lblCategory;

	@FindBy(xpath = "//div[contains(text(),'Sub-Categories')]")
	private WebElement lblSubCategories;

	@FindBy(xpath = "//div[contains(text(),'Internet Handling Charges')]")
	private WebElement lblInternetHandlingCharges;

	@FindBy(xpath = "//div[contains(text(),'Tax Details')]")
	private WebElement lblTaxDetails;

	@FindBy(xpath = "//div[contains(text(),'Course Duration')]")
	private WebElement lblCourseDuration;

	@FindBy(xpath = "//div[contains(text(),'Offline access permissions')]")
	private WebElement lblOfflineAccessPermissions;

	@FindBy(xpath = "//div[contains(text(),'Pdf download permissions')]")
	private WebElement lblPdfdownloadPermissions;

	@FindBy(xpath = "//div[contains(text(),'Live Classes')]")
	private WebElement lblLiveClasses;

	@FindBy(xpath = "//b[contains(text(),'Video Restrictions')]")
	private WebElement lblVideoRestrictions;

	@FindBy(xpath = "//div[contains(text(),'Preview Course Feature')]")
	private WebElement lblPreviewCourseFeature;

	@FindBy(xpath = "//input[@type='text']/parent::div[@class='five wide column borderNone paddingmin']/div")
	private WebElement lblEnterPrice;

	@FindBy(xpath = "//div[@class='ui celled grid borderNone']//div[3]//div[1]")
	private WebElement lblDiscount;

	@FindBy(xpath = "//div[@class=\"ui label addDetails__content--label addDetails__content--label--effective\"]")
	private WebElement lblEffectivePrice;

	@FindBy(xpath = "//b[contains(text(),'Course Sharing')]")
	private WebElement lblCourseSharing;

	@FindBy(xpath = "//b[contains(text(),'Course has offline material for shipment')]")
	private WebElement lblOfflineShipment;

	@FindBy(xpath = "//div[@class='Shipment__CreateCourse__Option--Label']/following-sibling::div/descendant::div[@class='ui fitted toggle checkbox']")
	private WebElement tglPhysicalShipment;

	@FindBy(xpath = "//div[@class='Shipment__CreateCourse__Option--Description']/parent::div/following-sibling::div//input")
	private WebElement chkSetDeliveryDate;

	@FindBy(xpath = "//div[contains(text(),'Student Certificate')]")
	private WebElement lblStudentCertificate;

	@FindBy(xpath = "//div[text()='Student Certificate']/parent::div/following-sibling::div//input")
	private WebElement tglStudentCertificate;

	@FindBy(xpath = "//div[@class='actions']/input")
	private WebElement contentUploadImage;

	@FindBy(xpath = "//button[text() = 'Image']")
	private WebElement imageBtn;

	@FindBy(xpath = "//button[text() = 'Upload Image']")
	private WebElement uploadImageBtn;

	@FindBy(xpath = "//span[text() = 'Publish Course']")
	private WebElement publishCourseBtn;

	@FindBy(xpath = "//button[text()='Publish Course']")
	private WebElement cnfrmPublishCourseBtn;

	@FindBy(xpath = "//div[@class='introducingInstallmentOverlay__prompt__bottom']/button")
	private WebElement btnInstallmentGotItPopup;

	@FindBy(xpath = "//div[@class='ShareModal__Content__Top--Close']/img")
	private WebElement closePublishedSuccessPopupBtn;

	@FindBy(xpath = "(//div[@class='ui fitted toggle checkbox']//input)[2]")
	private WebElement tglOfflineMaterialForShipment;

	@FindBy(xpath = "//div[text()='Pdf download permissions']/..//following-sibling::div//p")
	private WebElement tglSwitchOnToSavePdfs;

	@FindBy(className = "Shipment__CreateCourse__Option--Description")
	private WebElement switchOnCourseShipmentText;

	@FindBy(css = ".Shipment__CreateCourse__Option--Toggle div")
	private WebElement tglCourseShipment;

	@FindBy(xpath = "//div[text()='Pdf download permissions']/..//following-sibling::div//img")
	private WebElement infoSwitchOnToSavePdfs;

	@FindBy(xpath = "//div[contains(@class,'popup transition visible')]//p")
	private WebElement helpTextSwitchOnToSavePdfs;

	@FindBy(className = "Shipment__CreateCourse__Option--DaySelector--Input")
	private WebElement inpDaySelector;

	@FindBy(css = ".Shipment__CreateCourse__Option--DaySelector .DropdownHolder div:nth-child(1)")
	private WebElement selectTentativeDay;

	@FindBy(xpath = "//img[@alt='Course Image']/..//a[text()='Physical material']")
	private WebElement lnkPhysicalMaterialTag;

	@FindBy(xpath = "//div[text()='Offline Material for Shipment']//following-sibling::div")
	private WebElement txtTentativeDays;

	@FindBy(xpath = "//div[text()='Offline Material for Shipment']")
	private WebElement txtOfflineMaterial;

	@FindBy(xpath = "(//div[contains(@class,'toastr')]//div[@class='rrt-title'])[last()]")
	private WebElement toasterMsg;

	@FindBy(css = ".AIPricePopover__Close img")
	private WebElement imgCloseEditCoursePrice;

	@FindBy(xpath = "//div[text()='Offline Material for Shipment']//img")
	private WebElement infoOfflineMaterial;

	@FindBy(xpath = "//div[contains(@class,'popup transition visible')]//div//div")
	private WebElement helpTxtOfflineShipmentMaterial;
	private static final String btnDurationHours = "//div[@class='rc-time-picker-panel-select'][1]//ul//li[text()='${text}']";

	private static final Logger logger = Logger.getLogger(TutorCreateCoursePage.class.getName());

	public TutorCreateCoursePage(WebDriver driver) {
		super(driver);
		logger.info("Starting of CreateCoursePage method");

		PageFactory.initElements(driver, this);

		logger.info("Ending of CreateCoursePage method");

	}

	public void clickOnStoreButton() {
		logger.info("starting of clickOnStoreButton method");

		try {
			this.explicitWait(btnStore);
			if (btnStore.isDisplayed()) {
				this.btnStore.click();
			}
		} catch (Exception e) {
			this.clickOnWebElement(btnStore);
		}

		logger.info("Ending of clickOnStoreButton method");
	}

	public String getStoreLabel() {
		logger.info("starting of getStoreLabel method");
		logger.info("Ending of getStoreLabel method");

		return btnStore.getText();
	}

	public void clickOnBackToCourse() {
		logger.info("starting of clickOnBackToCourse method");

		try {
			this.clickOnWebElement(btnCourseBack);
		} catch (Exception e) {
			this.btnCourseBack.click();
		}

		logger.info("Ending of clickOnBackToCourse method");
	}

	public void clickOnCourseBanner() {
		logger.info("starting of clickOnCourseBanner method");

		try {
			if (lblCourseBanner.isDisplayed()) {
				this.clickOnWebElement(lblCourseBanner);
			}
		} catch (Exception e) {
			this.lblCourseBanner.click();
		}

		logger.info("Ending of clickOnCourseBanner method");
	}

	public String getMyCourses() {
		logger.info("Starting of getMyCoursesLabel method");

		this.explicitWait(lblMyCourses);

		logger.info("Ending of getMyCoursesLabel method");
		return lblMyCourses.getText();
	}

	public String getContentMarket() {
		logger.info("Starting of getContentMarket method");
		logger.info("Ending of getContentMarket method");

		return lblContentMarket.getText();
	}

	public String getSearchBar() {
		logger.info("Starting of getContentMarket method");
		logger.info("Ending of getContentMarket method");

		return lblSearchBar.getAttribute("placeholder");
	}

	public void clickOnSearchBar() {
		logger.info("starting of clickOnSearchBar method");

		this.hardWait(5);
		this.explicitWait(lblSearchBar);
		Actions action = new Actions(driver);
		action.click(lblSearchBar).perform();

		logger.info("Ending of clickOnSearchBar method");
	}

	public void clickOnBackFromSearchBar() {
		logger.info("starting of clickOnBackFromSearchBar method");

		this.clickOnWebElement(btnSearchBarBack);
		this.btnAllCoursesBack.click();

		logger.info("Ending of clickOnBackFromSearchBar method");
	}

	public void clickOnCreateCourseButton() {
		logger.info("starting of clickOnCreateCourseButton method");

		this.explicitWait(btnCreateCourse);
		if (btnCreateCourse.isDisplayed()) {
			this.clickOnWebElement(btnCreateCourse);
		}

		logger.info("Ending of clickOnCreateCourseButton method");
	}

	public String getStoreCreateCourseLabel() {
		logger.info("Starting of getStoreCreateCourseLabel method");
		logger.info("Ending of getStoreCreateCourseLabel method");

		return btnCreateCourse.getText();
	}

	public String getCreateCourseLabel() {
		logger.info("Starting of getCreateCourseLabel method");
		logger.info("Ending of getCreateCourseLabel method");

		return lblCreateCourse.getText();
	}

	public String getStatsLabel() {
		logger.info("Starting of getStatsLabel method");
		logger.info("Ending of getStatsLabel method");
		this.explicitWait(lblStats);

		return lblStats.getText();
	}

	public String getCoursesLabel() {
		logger.info("Starting of getCoursesLabel method");
		logger.info("Ending of getCoursesLabel method");

		this.scrollDown(800);
		String[] lblCourse = lblCourses.getText().split(" ");
		return lblCourse[0];
	}

	public boolean getStatsCard() {
		logger.info("Starting of getStatsCard method");
		logger.info("Ending of getStatsCard method");

		for (WebElement e : lblStatsCard) {
			if (!(e.isDisplayed())) {
				return false;
			}
		}
		return true;

	}

	public boolean getCouponsCard() {
		logger.info("Starting of getCouponsCard method");
		logger.info("Ending of getCouponsCard method");
		for (int i = 0; i < lblCouponsCard.size(); i++) {
			if (!(lblCouponsCard.get(i).isDisplayed())) {
				try {
					this.clickOnWebElement(btnCouponRightCarousel);
				} catch (Exception e) {
					return true;
				}
			}
		}

		return false;

	}

	public boolean getCourseCard() {
		logger.info("Starting of getCourseCard method");
		logger.info("Ending of getCourseCard method");
		for (WebElement e : lblCourseCards) {
			if (!(e.isDisplayed())) {
				return false;
			}
		}
		return true;

	}

	public String getCouponsLabel() {
		logger.info("Starting of getCouponsLabel method");
		logger.info("Ending of getCouponsLabel method");
		this.scrollIntoView(lblCouponCodes);

		return lblCouponCodes.getText();
	}

	public String getCategorySubcategoryLabel() {
		logger.info("Starting of getCategorySubcategoryLabel method");
		logger.info("Ending of getCategorySubcategoryLabel method");
		this.scrollIntoView(lblCategorySubcategory);

		return lblCategorySubcategory.getText();
	}

	public void setCourseName(String strCourseName) {
		logger.info("Starting of setCourseName method");

		this.txtCourseName.clear();
		this.txtCourseName.sendKeys(strCourseName);

		logger.info("Ending of setCourseName method");
	}

	public void setDescription(String strDiscription) {
		logger.info("Starting of setDescription method");

		this.explicitWait(txtDescription);

		if (!System.getProperty("os.name").contains("Mac")) {
			this.txtDescription.sendKeys(Keys.CONTROL + "a");
			this.txtDescription.sendKeys(Keys.DELETE);
		} else {
			this.txtDescription.sendKeys(Keys.COMMAND + "a");
			this.txtDescription.sendKeys(Keys.DELETE);

		}
		this.txtDescription.sendKeys(strDiscription);

		logger.info("Ending of setDescription method");
	}

	public void clickOnUploadImageButton() {
		logger.info("starting of clickOnUploadImageButton method");

		String osPath = System.getProperty("os.name");
		if (osPath.contains("Linux")) {
			imgUploadPhoto.sendKeys(TEST_FILE_PATH + "/testdata/coverpageimage.jpg");
		} else {
			imgUploadPhoto
					.sendKeys(TEST_FILE_PATH + File.separator + "testdata" + File.separator + "coverpageimage.jpg");
		}

		logger.info("Ending of clickOnUploadImageButton method");
	}

	public void clickOnCategoryDropdown() {
		logger.info("Starting of clickOnCategoryDropdown method");

		this.explicitWait(categoryDropdown);
		this.clickOnWebElement(categoryDropdown);

		logger.info("Ending of clickOnCategoryDropdown method");
	}

	public void setCategory() {
		logger.info("Starting of setCategory method");

		this.explicitWait(categoryOption);
		this.clickOnWebElement(categoryOption);

		logger.info("Ending of setCategory method");
	}

	public void clickOnSubCategoryDropdown() {
		logger.info("Starting of clickOnSubCategoryDropdown method");

		this.explicitWait(subCategoryDropdown);
		this.clickOnWebElement(subCategoryDropdown);

		logger.info("Ending of clickOnSubCategoryDropdown method");
	}

	public void setSubCategory() {
		logger.info("Starting of setSubCategory method");

		this.explicitWait(subCategoryOption);
		this.clickOnWebElement(subCategoryOption);

		logger.info("Ending of setSubCategory method");
	}

	public void setPrice(String strPrice) {
		logger.info("Starting of setPrice method");

		this.scrollDown(300);
		this.txtPrice.clear();
		this.txtPrice.sendKeys(strPrice);

		logger.info("Ending of setPrice method");
	}

	public void setDiscount(String strDiscount) {
		logger.info("Starting of setDiscount method");

		this.txtDiscount.clear();
		this.txtDiscount.sendKeys(strDiscount);

		logger.info("Ending of setDiscount method");
	}

	public void clickOnInternetChargesToggle() {
		logger.info("Starting of clickOnInternetChargesToggle method");

		this.clickOnWebElement(tglInternetCharges);

		logger.info("Ending of clickOnInternetChargesToggle method");
	}

	public void clickOnTaxDetailsToggle() {
		logger.info("Starting of clickOnTaxDetailsToggle method");

		this.clickOnWebElement(tglTaxDetails);

		logger.info("Ending of clickOnTaxDetailsToggle method");
	}

	public String getExcludeTaxDetailsLabel() {
		logger.info("Starting of getExcludeTaxDetailsLabel method");
		logger.info("Ending of getExcludeTaxDetailsLabel method");
		return this.lblAreYouSureYouWantToExcludeTaxDetails.getText();
	}

	public void clickOnTaxDetailsCancelButton() {
		logger.info("starting of clickOnTaxDetailsCancelButton button");

		this.explicitWait(btnTaxDetailsCancel);
		this.btnTaxDetailsCancel.click();

		logger.info("Ending of clickOnTaxDetailsCancelButton button");
	}

	public void clickOnLifeTimeDurationRadioButton() {
		logger.info("Starting of clickOnLifeTimeDurationRadioButton method");

		this.scrollDown(500);
		this.clickOnWebElement(rdoLifeTimeDuration);

		logger.info("Ending of clickOnLifeTimeDurationRadioButton method");
	}

	public void clickOnCourseShareCheckBox() {
		logger.info("Starting of clickOnCourseShareCheckBox method");
		if (!chkCourseSharing.getAttribute("class").contains("checked")) {
			this.clickOnWebElement(chkCourseSharing);
		}
		logger.info("Ending of clickOnCourseShareCheckBox method");
	}

	public void uncheckCourseShareCheckBox() {
		logger.info("Starting of uncheckCourseShareCheckBox method");
		if (chkCourseSharing.getAttribute("class").contains("checked")) {
			this.clickOnWebElement(chkCourseSharing);
		}
		logger.info("Ending of uncheckCourseShareCheckBox method");
	}

	public void clickOnView() {
		logger.info("Starting of clickOnView method");

		this.explicitWait(viewPermissions);
		this.viewPermissions.click();

		logger.info("Ending of clickOnView method");
	}

	public void clickOnSave() {
		logger.info("Starting of clickOnSave method");

		this.clickOnWebElement(saveEdited);

		logger.info("Ending of clickOnSave method");
	}

	public void clickOnCheckbox() {
		logger.info("starting of clickOnCheckbox method");

		this.clickOnWebElement(checkbox);

		logger.info("ending of clickOnCheckbox method");
	}

	public void setMinVal(String strVal) {
		logger.info("Starting of setMinVal method");

		this.txtMinCourseValue.clear();
		this.txtMinCourseValue.sendKeys(strVal);

		logger.info("Ending of setMinVal  method");
	}

	public void setShare(String strShare) {
		logger.info("Starting of setShare method");

		this.explicitWait(txtSharePercentage);
		this.txtSharePercentage.clear();
		this.txtSharePercentage.sendKeys(strShare);

		logger.info("Ending of setShare method");
	}

	public void clickOnOfflineToggle() {
		logger.info("Starting of clickOnOfflineToggle method");

		this.scrollDown(300);
		this.clickOnWebElement(tglOfflineAccess);

		logger.info("Ending of clickOnOfflineToggle method");
	}

	public void clickOnOfflineMaterial() {
		logger.info("Starting of clickOnOfflineMaterial method");

		try {
			this.scrollDown(300);
			this.tglOfflineMaterialForShipment.click();
		} catch (Exception e) {
			this.clickOnWebElement(tglOfflineMaterialForShipment);
		}

		logger.info("Ending of clickOnOfflineMaterial method");
	}

	public void clickOnSetTentaiveDelivery() {
		logger.info("Starting of clickOnSetTentaiveDelivery method");

		if (!tglSetTentativeDeliveryDays.isSelected()) {
			this.clickOnWebElement(tglSetTentativeDeliveryDays);
		}

		logger.info("Ending of clickOnSetTentaiveDelivery method");
	}

	public void uncheckSetTentaiveDelivery() {
		logger.info("Starting of uncheckSetTentaiveDelivery method");

		if (tglSetTentativeDeliveryDays.getAttribute("class").contains("checked")) {

			this.clickOnWebElement(tglSetTentativeDeliveryDays);
		}

		logger.info("Ending of uncheckSetTentaiveDelivery method");
	}

	public void clickOnPdfToggle() {
		logger.info("Starting of clickOnPdfToggle method");

		this.clickOnWebElement(tglPdfDownload);

		logger.info("Ending of clickOnPdfToggle method");
	}

	public void clickOnLiveClassesToggle() {
		logger.info("Starting of clickOnLiveClassesToggle method");

		this.clickOnWebElement(tglLiveClasses);

		logger.info("Ending of clickOnLiveClassesToggle method");
	}

	public void clickOnVideoRestrictionToggle() {
		logger.info("Starting of clickOnVideoRestrictionToggle  method");

		if (!tglVideoRestrictionsaOnWeb.getAttribute("class").contains("checked")) {

			this.clickOnWebElement(tglVideoRestrictionsaOnWeb);
		}
		logger.info("Ending of clickOnVideoRestrictionToggle method");
	}

	public void clickOnVideoRestrictionsOnVideo() {
		logger.info("Starting of clickOnVideoRestrictionsOnVideo method");
		if (!tglVideoRestrictionsOnVideo.getAttribute("class").contains("checked")) {

			this.clickOnWebElement(tglVideoRestrictionsOnVideo);
		}
		logger.info("Ending of clickOnVideoRestrictionsOnVideo method");
	}

	public void clickOnMaxViews() {
		logger.info("starting of clickOnMaxViews method");
		if (!chkMaxViews.getAttribute("class").contains("checked")) {

			this.clickOnWebElement(chkMaxViews);
		}
		logger.info("Ending of clickOnMaxViews method");
	}

	public void setMaxViews(String strAddViews) {
		logger.info("starting of setMaxViews method");

		this.txtMaxViews.clear();
		this.txtMaxViews.sendKeys(strAddViews);

		logger.info("Ending of setMaxViews method");
	}

	public void clickOnViewDurations() {
		logger.info("starting of clickOnViewDur  method");
		if (!chkViewDuration.getAttribute("class").contains("checked")) {

			this.clickOnWebElement(chkViewDuration);
		}
		logger.info("Ending of clickOnViewDur method");
	}

	public void clickOnUpdateRestriction() {
		logger.info("starting of clickOnUpdateRestriction  method");
		if (!chkUpdateExistingVideos.getAttribute("class").contains("checked")) {

			this.clickOnWebElement(chkUpdateExistingVideos);
		}
		logger.info("Ending of clickOnUpdateRestriction method");
	}

	public void setViewDur() {
		logger.info("starting of setViewDur method");

		this.explicitWait(dtpViewDuration);
		this.clickOnWebElement(dtpViewDuration);
		this.btnClearDuration.click();
		driver.findElement(By.xpath(btnDurationHours.replace("${text}", "00"))).click();
		logger.info("Ending of setViewDur method");
	}

	public void showView() {
		logger.info("Starting of showView method");

		this.explicitWait(dtpShowView);
		this.clickOnWebElement(dtpShowView);

		logger.info("Ending of showView method");
	}

	public void clickOnPreviewCourse() {
		logger.info("starting of clickOnPreviewCourse method");
		this.scrollDown(300);
		this.clickOnWebElement(tglPreviewCourse);

		logger.info("Ending of clickOnPreviewCourse method");
	}

	public void clickOnTermsAndConditionCheckBox() {
		logger.info("Starting of clickOnTermsAndConditionCheckBox method ");

		this.clickOnWebElement(chkTermsAndConditions);

		logger.info("Ending of clickOnTermsAndConditionCheckBox method");
	}

	public void clickOnAddContentButton() {
		logger.info("Starting of clickOnAddContentButton method");

		this.clickOnWebElement(btnAddContent);

		logger.info("Ending of clickOnAddContentButton method");
	}

	public String getCourseCreatedMessage() {
		logger.info("Starting of getCourseCreatedMessage method");

		this.explicitWait(msgCourseCreated);

		logger.info("Ending of getCourseCreatedMessage method");
		return this.msgCourseCreated.getText();
	}

	public String getContentLabel() {
		logger.info("Starting of getContentLabel method");
		logger.info("Ending of getContentLabel method");
		return this.lblContent.getText();
	}

	public void clickOnOverviewButton() {
		logger.info("Starting of clickOnOverviewButton method");

		this.hardWait(2);
		try {
			this.clickOnWebElement(btnOverView);
		} catch (Exception e) {
			Actions action = new Actions(driver);
			action.click(btnOverView).build().perform();
		}

		logger.info("Ending of clickOnOverviewButton method");
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

	public String getSubCategoriesLabel() {
		logger.info("Starting of getSubCategoriesLabel method");

		// this.explicitWait(lblSubCategories);

		logger.info("Ending of getSubCategoriesLabel method");
		return lblSubCategories.getText();
	}

	public String getInternetHandlingChargesLabel() {
		logger.info("Starting of getInternetHandlingChargesLabel method");

		this.explicitWait(lblInternetHandlingCharges);

		logger.info("Ending of getInternetHandlingChargesLabel method");
		return lblInternetHandlingCharges.getText();
	}

	public String getTaxDetailsLabel() {
		logger.info("Starting of getTaxDetailsLabel method");

		this.explicitWait(lblTaxDetails);

		logger.info("Ending of getTaxDetailsLabel method");
		return lblTaxDetails.getText();
	}

	public String getCourseDurationLabel() {
		logger.info("Starting of getCourseDurationLabel method");

		this.explicitWait(lblCourseDuration);

		logger.info("Ending of getCourseDurationLabel method");
		return lblCourseDuration.getText();
	}

	public String getOfflineAccessPermissionsLabel() {
		logger.info("Starting of getOfflineAccessPermissionsLabel method");

		this.explicitWait(lblOfflineAccessPermissions);

		logger.info("Ending of getOfflineAccessPermissionsLabel method");
		return lblOfflineAccessPermissions.getText();
	}

	public String getPdfdownloadPermissionsLabel() {
		logger.info("Starting of getPdfdownloadPermissionsLabel method");

		this.explicitWait(lblPdfdownloadPermissions);

		logger.info("Ending of getPdfdownloadPermissionsLabel method");
		return lblPdfdownloadPermissions.getText();
	}

	public String getLiveClassesLabel() {
		logger.info("Starting of getLiveClassesLabel method");

		this.explicitWait(lblLiveClasses);

		logger.info("Ending of getLiveClassesLabel method");
		return lblLiveClasses.getText();
	}

	public String getVideoRestrictionsLabel() {
		logger.info("Starting of getVideoRestrictionsLabel method");

		this.scrollIntoView(lblVideoRestrictions);

		this.explicitWait(lblVideoRestrictions);

		logger.info("Ending of getVideoRestrictionsLabel method");
		return lblVideoRestrictions.getText();
	}

	public String getPreviewCourseFeatureLabel() {
		logger.info("Starting of getVideoRestrictionsLabel method");

		this.explicitWait(lblPreviewCourseFeature);

		logger.info("Ending of getVideoRestrictionsLabel method");
		return lblPreviewCourseFeature.getText();
	}

	public String getEnterPriceLabel() {
		logger.info("Starting of getEnterPriceLabel method");

		// this.explicitWait(lblEnterPrice);

		logger.info("Ending of getEnterPriceLabel method");
		return lblEnterPrice.getText();
	}

	public String getDiscountLabel() {
		logger.info("Starting of getDiscountLabel method");

		this.explicitWait(lblDiscount);

		logger.info("Ending of getDiscountLabel method");
		return lblDiscount.getText();
	}

	public String getEffectivePriceLabel() {
		logger.info("Starting of getEffectivePriceLabel method");

		this.explicitWait(lblEffectivePrice);

		logger.info("Ending of getEffectivePriceLabel method");
		return lblEffectivePrice.getText();
	}

	public String getCourseSharingLabel() {
		logger.info("Starting of getCourseSharingLabel method");

		this.explicitWait(lblCourseSharing);

		logger.info("Ending of getCourseSharingLabel method");
		return lblCourseSharing.getText();
	}

	public String getOfflineShipmentLabel() {
		logger.info("Starting of getOfflineShipmentLabel method");

		this.explicitWait(lblOfflineShipment);

		logger.info("Ending of getOfflineShipmentLabel method");
		return lblOfflineShipment.getText();
	}

	public String getStudentCertificateLabel() {
		logger.info("Starting of getStudentCertificateLabel method");

		this.explicitWait(lblStudentCertificate);

		logger.info("Ending of getStudentCertificateLabel method");
		return lblStudentCertificate.getText();
	}

	public void uploadImageOnContent() throws InterruptedException {
		logger.info("starting of uploadImageOnContent method");
		try {
			explicitWait(imageBtn);
			imageBtn.click();
		} catch (Exception e) {
			this.clickOnWebElement(imageBtn);
		}

		String osPath = System.getProperty("os.name");
		if (osPath.contains("Linux")) {
			contentUploadImage.sendKeys(TEST_FILE_PATH + File.separator + "/testdata/coverpageimage.jpg");
		} else {
			contentUploadImage
					.sendKeys(TEST_FILE_PATH + File.separator + "testdata" + File.separator + "coverpageimage.jpg");
		}
		try {
			explicitWait(uploadImageBtn);
			Thread.sleep(2000);
			uploadImageBtn.click();
		} catch (Exception e) {
			this.clickOnWebElement(uploadImageBtn);
		}

		logger.info("Ending of uploadImageOnContent method");
	}

	public void clickOnCnfrmPublishButton() {
		logger.info("starting of clickOnCnfrmPublishButton method");
		try {
			this.explicitWait(this.cnfrmPublishCourseBtn);
			this.cnfrmPublishCourseBtn.click();
		} catch (Exception e) {
			this.clickOnWebElement(cnfrmPublishCourseBtn);
		}
		logger.info("starting of clickOnCnfrmPublishButton method");
	}

	public void closeCoursePublishedSuccessPopup() {
		logger.info("starting of closeCoursePublishedSuccessPopup method");
		try {
			this.explicitWait(this.closePublishedSuccessPopupBtn);
			this.closePublishedSuccessPopupBtn.click();
		} catch (Exception e) {
			this.clickOnWebElement(closePublishedSuccessPopupBtn);
		}
		logger.info("starting of closeCoursePublishedSuccessPopup method");
	}

	public void clickOnPublishButton() {
		logger.info("starting of clickOnPublishButton method");
		try {
			Thread.sleep(5000);
			this.publishCourseBtn.click();
		} catch (Exception e) {
			this.clickOnWebElement(publishCourseBtn);
		}
		logger.info("starting of clickOnPublishButton method");
	}

	public void clickOnTglStudentCertificate() {
		logger.info("starting of clickOnTglStudentCertificate method");
		try {
			this.scrollIntoView(this.tglStudentCertificate);
			this.tglStudentCertificate.click();
		} catch (Exception e) {
			this.clickOnWebElement(tglStudentCertificate);
		}
		logger.info("starting of clickOnTglStudentCertificate method");
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

	public String getPdfDownloadedPermissionsSwitchOnToggle() {
		logger.info("Starting of getPdfDownloadedPermissionsSwitchOnToggle method");
		logger.info("Ending of getPdfDownloadedPermissionsSwitchOnToggle method");

		return tglSwitchOnToSavePdfs.getText();

	}

	public String getHelpTextToSavePDF() {
		logger.info("Starting of getHelpTextToSavePDF method");
		Actions action = new Actions(driver);
		action.moveToElement(infoSwitchOnToSavePdfs).perform();
		System.out.println(helpTextSwitchOnToSavePdfs.getText().replace("\n", ""));
		logger.info("Ending of getHelpTextToSavePDF method");
		return helpTextSwitchOnToSavePdfs.getText().replace("\n", "");

	}

	public String getCourseShipmentSwitchOnToggleText() {
		logger.info("Starting of getCourseShipmentSwitchOnToggleText method");
		logger.info("Ending of getCourseShipmentSwitchOnToggleText method");

		return switchOnCourseShipmentText.getText();
	}

	public boolean checkCourseShipmentToggle() {
		logger.info("Starting of getHelpTextToCourseOfflineShipment method");
		boolean flag = false;
		if (tglCourseShipment.getAttribute("class").contains("checked")) {
			flag = true;
		}
		logger.info("Ending of getHelpTextToCourseOfflineShipment method");
		return flag;

	}

	public void enableCourseShipmentToggle() {
		logger.info("Starting of enableCourseShipmentToggle method");
		if (!tglCourseShipment.isSelected()) {
			tglCourseShipment.click();
		}
		logger.info("Ending of enableCourseShipmentToggle method");
	}

	public boolean verifyCourseShipmentToggle() {
		logger.info("Starting of verifyCourseShipmentToggle method");
		logger.info("Ending of verifyCourseShipmentToggle method");
		return tglCourseShipment.isSelected();

	}

	public void switchOffCourseShipmentToggle() {
		logger.info("Starting of switchOffCourseShipmentToggle method");
		if (tglCourseShipment.getAttribute("class").contains("checked")) {
			tglCourseShipment.click();
		}
		logger.info("Ending of switchOffCourseShipmentToggle method");
	}

	public String errorMessageOnCourseShipment() {
		logger.info("Starting of errorMessageOnCourseShipment method");
		System.out.println(shipmentNote.getText().replace("\n", " "));
		logger.info("Ending of errorMessageOnCourseShipment method");
		return shipmentNote.getText().replace("\n", " ");

	}

	public boolean verifyCourseSharingCheckboxDisabled() {
		logger.info("Starting of verifyCourseSharingCheckboxDisabled method");
		boolean flag = false;
		if (chkCourseSharing.getAttribute("class").contains("disabled")) {
			flag = true;
		}
		logger.info("Ending of verifyCourseSharingCheckboxDisabled method");
		return flag;
	}

	public boolean verifyOfflineShipmentToggleBtn() {
		logger.info("Starting of verifyOfflineShipmentToggleDisabled method");
		boolean flag = false;
		if (tglCourseShipment.getAttribute("class").contains("disabled")) {
			flag = true;
		}
		logger.info("Ending of verifyOfflineShipmentToggleDisabled method");
		return flag;
	}

	public String getTentativeDaysLabelWhenCourseShipmentToggleisON() {
		logger.info("Starting of getTentativeDaysLabelWhenCourseShipmentToggleisON method");
		logger.info("Ending of getTentativeDaysLabelWhenCourseShipmentToggleisON method");

		return lbl_tentativeDays.getText();
	}

	public void selectTentativeDays() {
		logger.info("Starting of selectTentativeDays method");

		inpDaySelector.click();
		selectTentativeDay.click();
		logger.info("Ending of selectTentativeDays method");
	}

	public boolean verifyPhysicalMaterialTag() {
		boolean flag = false;
		try {
			if (lnkPhysicalMaterialTag.isDisplayed())
				flag = true;
		} catch (NoSuchElementException e) {
			flag = false;
		}
		return flag;
	}

	public String getTentativeDaysOnCourseOverview() {
		logger.info("Starting of getTentativeDaysOnCourseOverview method");
		logger.info("Ending of getTentativeDaysOnCourseOverview method");

		return txtTentativeDays.getText().replace("\n", " ");
	}

	public String verifyToasterMessage() {
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
		}
		return toasterMsg.getText();
	}

	public boolean verifyTentativeDaysTextPresentWhenTutorNotSelected() {
		boolean flag = false;
		try {
			if (txtTentativeDays.isDisplayed())
				flag = true;
		} catch (NoSuchElementException e) {
			flag = false;
		}
		return flag;
	}

	public boolean verifyCourseOfflineShipmentVisibilityOnCourseOverview() {
		boolean flag = false;
		try {
			if (txtOfflineMaterial.isDisplayed())
				flag = true;
		} catch (NoSuchElementException e) {
			flag = false;
		}
		return flag;
	}

	public void clickOnOverviewLeftSide() {
		try {
			Thread.sleep(5000);
		} catch (Exception e) {
		}
		sideLabelOverview.click();
	}

	public void closeEditCoursePricePopup() {
		logger.info("Starting of closeEditCoursepricePopup method");
		imgCloseEditCoursePrice.click();
		logger.info("Ending of closeEditCoursepricePopup method");

	}

	public String hoverOnShipmentHelpTextOnOverviewPage() {
		logger.info("Starting of hoverOnShipmentHelpTextOnOverviewPage method");
		Actions action = new Actions(driver);
		action.moveToElement(infoOfflineMaterial).perform();
		System.out.println(helpTxtOfflineShipmentMaterial.getText());
		logger.info("Ending of hoverOnShipmentHelpTextOnOverviewPage method");
		return helpTxtOfflineShipmentMaterial.getText();
	}

	public void clickOnPhysicalShipmentToggle() {
		logger.info("starting of clickOnPhysicalShipmentToggle method");

		try {
			/*
			 * Actions actions=new Actions(driver);
			 * actions.click(tglPhysicalShipment).perform();
			 */
			this.tglPhysicalShipment.click();
		} catch (Exception e) {

			this.clickOnWebElement(tglPhysicalShipment);

		}

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

	public void switchToDefault() {
		logger.info("starting of clickOnTutorDropdown method");

		ArrayList<String> tab = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tab.get(0));

		logger.info("Ending of clickOnTutorDropdown method");
	}

	public boolean isdisplayedHelpIcon() {
		logger.info("Starting of isdisplayedHelpIcon method");
		logger.info("Ending of isdisplayedHelpIcon method");

		return lblHelpIcon.isDisplayed();
	}

	public boolean isdisplayedWhatsAppIcon() {
		logger.info("Starting of isdisplayedWhatsAppIcon method");
		logger.info("Ending of isdisplayedWhatsAppIcon method");

		return lblWhatsAppIcon.isDisplayed();
	}

	public String getViewAll() {
		logger.info("Starting of getViewAll method");
		logger.info("Ending of getViewAll method");

		return lblViewAll.getText();
	}

	public String getSortFiltersLabel() {
		logger.info("Starting of getSortFiltersLabel method");
		logger.info("Ending of getSortFiltersLabel method");
		this.hardWait(3);
		this.explicitWait(lblSortFilter);

		return lblSortFilter.getText();
	}

	public String getNothingFoundMessage() {
		logger.info("Starting of getNothingFoundMessage method");
		logger.info("Ending of getNothingFoundMessage method");
		this.hardWait(2);

		return msgNothingFound.getText();
	}

	public void clickOnTxtSearchCourse(String strSearch) {
		logger.info("Starting of clickOnTxtSearchCourse method");

		try {
			this.hardWait(2);
			this.lblSearchBar.sendKeys(strSearch);
			this.lblSearchBar.clear();
		} catch (Exception e) {
			this.lblSearchBar.sendKeys(strSearch);
		}

		logger.info("Ending of clickOnTxtSearchCourse method");
	}

}