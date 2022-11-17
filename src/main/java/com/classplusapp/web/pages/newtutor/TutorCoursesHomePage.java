package com.classplusapp.web.pages.newtutor;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.classplusapp.web.pages.BaseClassplusAutomationPage;

public class TutorCoursesHomePage extends BaseClassplusAutomationPage {

	private static final Logger logger = Logger.getLogger(TutorCoursesHomePage.class.getName());

	@FindBy(xpath = "//button[@class='CourseShareButton']")
	private WebElement btnShare;

	@FindBy(xpath = "//div[@class='ShareModal__Content__Body--CopySection--Copy']")
	private WebElement btnCopy;

	@FindBy(xpath = "//div[@class='ShareModal__Content__Body--CopySection--Link']")
	private WebElement lblLink;

	@FindBy(xpath = "//div[contains(text(),'Link Copied')]")
	private WebElement msgLinkCopied;

	@FindBy(xpath = "//div[@class='ShareModal__Content__Top--Close']")
	private WebElement closeShareModal;

	@FindBy(xpath = "//img[contains(@src,'88UhVlDKfWIk.png')]")
	private WebElement learningLightIcon;

	@FindBy(xpath = "//p[contains(@class,'appNameClass')]")
	private WebElement lblLearningLight;

	@FindBy(xpath = "//div[@class='courseCardSection__header__heading']//following-sibling::div")
	private WebElement btnPopularCourseSeeAll;

	@FindBy(xpath = "//button[contains(text(),'View All')]")
	private WebElement btnViewAll;

	@FindBy(xpath = "//div[@class='subCategoriesFilter__dropdown__content__item subCategoriesFilter__dropdown__content__item--selected']")
	private WebElement drpRBI;

	@FindBy(xpath = "//input[@id='Newest']")
	private WebElement rdoNewest;

	@FindBy(xpath = "//input[@id='Price Low To High']")
	private WebElement rdoLowToHigh;

	@FindBy(xpath = "//div[@class='courseListingSort__button']")
	private WebElement btnSort;

	@FindBy(xpath = "//div[@class='OverView__Heading__Left CourseName']")
	private WebElement lblCourseName;

	@FindBy(xpath = "//div[@class='OverviewSectionContainer__Head']/h2")
	private WebElement lblAvailableOffers;

	@FindBy(xpath = "//div[@class='StickyPay_StickyPay__Price__Coupons__Text__H0rjN']")
	private WebElement lblCouponAvailable;

	@FindBy(xpath = "//button[@class='OverviewSectionContainer__Head__Button']")
	private WebElement lblViewAllAvailbleOffers;

	@FindBy(xpath = "//button[@class='Button_button__fIRig undefined undefined undefined undefined undefined undefined  ']")
	private WebElement lblGetThisCourse;

	@FindBy(xpath = "//div[@class='DesktopAboutCourse__Tabs__Item']")
	private List<WebElement> lblOverViewAndContent;

	@FindBy(xpath = "//div[@class='CouponListItem']")
	private List<WebElement> lstCoupons;

	@FindBy(xpath = "//div[@class='webFooter__contactUs__button']")
	private WebElement lblContactUs;

	@FindBy(xpath = "//div[@class='webFooter__queryTitle']")
	private WebElement lblQuery;

	@FindBy(xpath = "//span[@class='couponModalHeader--title']")
	private WebElement lblApplyCouponHeader;

	@FindBy(xpath = "//div[@class='enterCoupon']/input")
	private WebElement txtSearchCoupon;

	@FindBy(xpath = "//button[@class='enterCouponButton']")
	private WebElement btnApply;

	@FindBy(xpath = "//span[contains(text(),'VSHREE')]")
	private WebElement lblCouponName;

	@FindBy(xpath = "//div[@class='couponSuccessApplied']")
	private WebElement lblAppliedSuccesfully;

	@FindBy(xpath = "//button[@class='viewALLBtnMobile']")
	private WebElement btnDone;

	@FindBy(xpath = "//div[@class='StickyPay_StickyPay__Price__Coupons__Remove__D5ccg']")
	private WebElement btnRemove;

	@FindBy(xpath = "//input[@type='text']")
	private WebElement txtName;

	@FindBy(xpath = "//input[@type='number']")
	private WebElement txtMobileNumber;

	@FindBy(xpath = "//textarea[@placeholder='Type your Message']")
	private WebElement txtMessage;

	@FindBy(xpath = "//button[@class='Button_button__fIRig undefined undefined undefined false undefined undefined  ']")
	private WebElement btnSubmit;

	@FindBy(xpath = "//div[contains(text(),'Your query has been successfully submitted')]")
	private WebElement msgQuerySubmitted;

	@FindBy(xpath = "//div[@class='Modal__Head--Details']")
	private WebElement lblFillDetails;

	@FindBy(xpath = "//div[@class='AddressField__Label']/following-sibling::div/div/input[@type='text']")
	private WebElement txtAddressName;

	@FindBy(xpath = "//input[@type='email']")
	private WebElement txtEmail;

	@FindBy(xpath = "//span[@class='Dropdown__Main__heading']/div/input")
	private WebElement drpState;

	@FindBy(xpath = "//div[@class='AddressField__Input__List--Item']")
	private List<WebElement> drpSelectState;

	@FindBy(xpath = "//button[@class='Button_button__fIRig undefined undefined undefined false undefined undefined  ']")
	private WebElement btnBuyNow;

	@FindBy(xpath = "//div[@class='StickyPay_StickyPay__Price__Coupons__Apply__1d_Ox']")
	private WebElement btnApplyHere;

	@FindBy(xpath = "//div[@class='DesktopAboutCourse__Tabs__Item']/following-sibling::div")
	private WebElement btnContent;

	@FindBy(xpath = "//div[@class='ContentList_contentList__item__content__Z0UHc']")
	private WebElement contentList;

	@FindBy(xpath = "//span[@class='style_Pricing__Heading__Pricing__DiscountPrice__Gq3vn']")
	private WebElement lblTotalPrice;

	@FindBy(xpath = "//div[@class='style_PricingDetails__CoursePrice__Price__mkJfq']/../preceding-sibling::div/div/following-sibling::div")
	private WebElement lblCoursePrice;

	@FindBy(xpath = "//div[@class='style_PricingDetails__CoursePrice__Price__mkJfq']/../following-sibling::div/div/following-sibling::div")
	private WebElement lblGSTPrice;

	@FindBy(xpath = "//h1[contains(text(),'Popular courses')]/../following-sibling::div[@class='courseCardSection__header__seeAll']")
	private WebElement btnPopularCoursesSeeAll;

	@FindBy(xpath = "//h1[contains(text(),'Popular courses')]/../../following-sibling::div/div/div/div/following-sibling::div")
	private List<WebElement> lstPopularCourses;

	@FindBy(xpath = "//h1[contains(text(),'Recent courses')]/../../following-sibling::div/div/div/div/following-sibling::div")
	private List<WebElement> lstRecentCourses;

	@FindBy(xpath = "//h1[contains(text(),'Recent courses')]/../following-sibling::div[@class='courseCardSection__header__seeAll']")
	private WebElement btnRecentCoursesSeeAll;

	@FindBy(xpath = "//h1[contains(text(),'Featured courses')]/../following-sibling::div[@class='courseCardSection__header__seeAll']")
	private WebElement btnFeaturedCoursesSeeAll;

	@FindBy(xpath = "//h1[contains(text(),'Featured courses')]/../../following-sibling::div/div/div/div/following-sibling::div")
	private List<WebElement> lstFeaturedCourses;

	@FindBy(xpath = "//h1[contains(text(),'All courses')]/../../following-sibling::div/div/div/div/following-sibling::div")
	private List<WebElement> lstAllCourses;

	@FindBy(xpath = "//h1[contains(text(),'All courses')]/../following-sibling::div[@class='courseCardSection__header__seeAll']")
	private WebElement btnAllCoursesSeeAll;

	@FindBy(xpath = "//div[@class='courseCard courseCard--vertical courseCard--listing']/div")
	private List<WebElement> lstAllCoursesCount;

	@FindBy(xpath = "//div[@class='subCategoriesFilter__list__item subCategoriesFilter__list__item--viewAll']")
	private WebElement btnviewAll;

	@FindBy(xpath = "//div[@class='subCategoriesFilter__dropdown__content__item false']")
	private List<WebElement> lstAllCategories;

	@FindBy(xpath = "//div[@class='subCategoriesFilter__dropdown__footer']/button[contains(text(),'Save & continue')]")
	private WebElement btnSaveAndContinue;

	@FindBy(xpath = "//div[@class='subCategoriesFilter__list__item subCategoriesFilter__list__item--selected']")
	private WebElement selectedCategory;

	@FindBy(xpath = "//div[@class='Input_inputContainer__icon__eCusP']/../input")
	private WebElement txtSearch;

	@FindBy(xpath = "//div[@class='courseCard__content__tags']/following-sibling::p")
	private WebElement lblCourse;

	@FindBy(xpath = "//div[@class='courseCardSection__header__backIcon']/span/span")
	private WebElement btnBack;

	@FindBy(xpath = "//p[contains(text(),'Mark featured Course@#$$')]")
	private WebElement getCourse;

	@FindBy(xpath = "//div[@class='OverView__Content__freeContent__VideoPreview__play']/../../preceding-sibling::div//div[@class='OverView__Content__freeContent__VideoPreview__play']/div/span/img")
	private WebElement icnPlayVideo;

	@FindBy(xpath = "//div[@class='Overview__iframeContent__videoWrapper']/span/span")
	private WebElement btnCloseVideo;

	@FindBy(xpath = "//div[@class='Overview__iframeContent__videoWrapper']")
	private WebElement videoPopUp;

	@FindBy(xpath = "//div[@class='Toastify__toast-body']/div/following-sibling::div")
	private WebElement msgInvalidCoupon;

	@FindBy(xpath = "//div[@class='Modal--Close']/span")
	private WebElement icnCloseApplyCoupon;

	@FindBy(xpath = "//div[@class='courseCardSection__empty']/span/following-sibling::h3")
	private WebElement msgNoContent;

	@FindBy(xpath = "//div[@class='courseCardSection__empty']/span/following-sibling::h3/following-sibling::p")
	private WebElement msgNoResultsFound;

	@FindBy(xpath = "//div[@class='Input_inputContainer__gOhoh courseListing__searchBar--field']")
	private WebElement lblSearch;

	@FindBy(xpath = "//div[@class='Input_inputContainer__gOhoh courseListing__searchBar--field']/div/following-sibling::input")
	private WebElement lblSearchField;

	@FindBy(xpath = "//div[@class='courseCardSection__header__seeAll']")
	private List<WebElement> lstSeeAll;

	@FindBy(xpath = "//span[contains(text(),'Terms & Conditions')]")
	private WebElement btnTermsCondition;

	@FindBy(xpath = "//div[@class='tnc__heading']")
	private WebElement lblTermsCondition;

	@FindBy(xpath = "//div[contains(text(),'Live Courses')]")
	private WebElement btnLiveCourse;

	@FindBy(xpath = "//div[contains(text(),'Notes & Books')]")
	private WebElement btnNotesAndBooks;

	@FindBy(xpath = "//div[contains(text(),'Test Series')]")
	private WebElement btnTestSeries;

	@FindBy(xpath = "//div[contains(text(),'Recorded Courses')]")
	private WebElement btnRecordedCourses;

	@FindBy(xpath = "//div[@class='Categories_Categories__list__XSKMb']")
	private List<WebElement> lstCategory;

	@FindBy(xpath = "//span[@class='Dropdown__Main__heading']")
	private WebElement tabIIT;

	@FindBy(xpath = "//div[@class='courseCard courseCard--vertical courseCard--listing']")
	private List<WebElement> lblCourses;

	@FindBy(xpath = "//div[@class='subCategoriesFilter']/h1")
	private WebElement lblSubCategories;

	@FindBy(xpath = "//div[@class='socialBtn-0-2-5']//a/preceding-sibling::a")
	private WebElement btnGooglePlay;

	@FindBy(xpath = "//div[@class='socialBtn-0-2-5']//a/following-sibling::a")
	private WebElement btnAppStore;

	@FindBy(xpath = "//header[@class='S3WLMd']//nav/a/span")
	private WebElement lblGooglePlay;

	@FindBy(xpath = "//h1[@class='Fd93Bb ynrBgc xwcR9d']/span")
	private WebElement lblLearningLightApp;

	@FindBy(xpath = "//span[@class='we-localnav__title__product']")
	private WebElement lblAppStore;

	@FindBy(xpath = "//p[@class='we-banner__copy']")
	private WebElement lblAvailableForIphoneAndIpad;

	@FindBy(xpath = "//div[@class='courseCard__content__pricing__sellingPrice']")
	private List<WebElement> lblPrice;

	@FindBy(xpath = "//input[@id='Price Low To High']")
	private WebElement rdoPriceLowToHigh;

	@FindBy(xpath = "//input[@id='Price High To Low']")
	private WebElement rdoPriceHighToLow;

	@FindBy(xpath = "(//img[@alt='lockIcon'])[1]")
	private WebElement btnLockContent;

	@FindBy(xpath = "//h1[contains(@class,'CourseLockedBottomSheet_CourseLocked__heading')]")
	private WebElement lblBuyLockContent;

	@FindBy(xpath = "// p[contains(@class,'CourseLockedBottomSheet_CourseLocked__subtext')]")
	private WebElement lblAccessLockContent;

	@FindBy(xpath = "//div[contains(@class,'CourseLockedBottomSheet_CourseLocked')]/button[@class='Button_button__fIRig undefined undefined undefined undefined undefined undefined  ']")
	private WebElement btnLockedContentBuyNow;

	@FindBy(xpath = "//div[@class='Modal--Close']/span/img")
	private WebElement btnCloseLockedContent;

	@FindBy(xpath = "//span[@class='style_accordion-item__icon__9ZBg4']")
	private WebElement downCarouselPrice;

	@FindBy(xpath = "//div[@class='StickyPay_StickyPay__Price__FinalPrice__Tbb6o']")
	private WebElement coursePrice;

	@FindBy(xpath = "//div[@class='StickyPay_StickyPay__Discount__Text__sQrSw']")
	private WebElement lblDiscountPrice;

	@FindBy(xpath = "//div[@class='coupon']/preceding-sibling::div/preceding-sibling::div/preceding-sibling::div/preceding-sibling::div/preceding-sibling::div")
	private WebElement lblCoupon;

	public TutorCoursesHomePage(WebDriver driver) {
		super(driver);
		logger.info("Starting of TutorCoursesHomePage method");

		PageFactory.initElements(driver, this);

		logger.info("Ending of TutorCoursesHomePage method");
	}

	public void clickOnCopy() {
		logger.info("Starting of clickOnCopy method");

		try {
			this.btnCopy.click();
		} catch (Exception e) {
			this.clickOnWebElement(btnCopy);
		}

		logger.info("Ending of clickOnCopy method");
	}

	public void clickOnApplyHereButton() {
		logger.info("Starting of clickOnCopy method");

		try {
			this.btnApplyHere.click();
		} catch (Exception e) {
			this.clickOnWebElement(btnApplyHere);

		}
		logger.info("Ending of clickOnCopy method");

	}

	public void clickOnViewAllAvailbleOffersButton() {
		logger.info("Starting of clickOnShare method");

		try {
			this.lblViewAllAvailbleOffers.click();
		} catch (Exception e) {
			this.clickOnWebElement(lblViewAllAvailbleOffers);

		}

		logger.info("Ending of clickOnShare method");

	}

	// public void clickOnCopy() {
	/*
	 * logger.info("Starting of clickOnCopy method");
	 * 
	 * 
	 * this.lblLink.click(); this.lblLink.sendKeys(Keys.CONTROL+"A" +
	 * Keys.CONTROL+"C" );
	 * 
	 * 
	 * 
	 * 
	 * 
	 * logger.info("Starting of clickOnCopy method"); }
	 */ public void clickOnShare() {
		logger.info("Starting of clickOnShare method");

		try {
			this.btnShare.click();
		} catch (Exception e) {
			this.clickOnWebElement(btnShare);

		}
		logger.info("Ending of clickOnShare method");

	}

	public String getLinkCopiedMessage() {
		logger.info("Starting of getLinkCopiedMessage method");
		logger.info("Ending of getLinkCopiedMessage method");

		return msgLinkCopied.getText();
	}

	public String getCopiedCourseLink() {
		logger.info("Starting of getLinkCopiedMessage method");
		logger.info("Ending of getLinkCopiedMessage method");

		return lblLink.getText();
	}

	public void clickOnLearningLightIcon() {
		logger.info("Starting of clickOnLearningLightIcon method");

		try {
			this.learningLightIcon.click();
		} catch (Exception e) {
			this.clickOnWebElement(learningLightIcon);

		}
		this.scrollDown(1000);
		this.scrollDown(-1000);

		logger.info("Ending of clickOnLearningLightIcon method");
	}

	public String getLearningLightLabel() {
		logger.info("Starting of getLearningLightLabel method");
		logger.info("Ending of getLearningLightLabel method");

		return lblLearningLight.getText();
	}

	public void clickOnPopularCourseSeeAllButton() {
		logger.info("Starting of clickOnPopularCourseSeeAllButton method");

		try {
			this.btnPopularCourseSeeAll.click();
		} catch (Exception e) {
			this.clickOnWebElement(btnPopularCourseSeeAll);

		}

		logger.info("Ending of clickOnPopularCourseSeeAllButton method");
	}

	public void clickOnViewAllButton() {
		logger.info("Starting of clickOnViewAllButton method");

		try {
			this.btnViewAll.click();
		} catch (Exception e) {
			this.clickOnWebElement(btnViewAll);

		}

		logger.info("Ending of clickOnViewAllButton method");
	}

	public void clickOnCloseModal() {
		logger.info("Starting of clickOnCloseModal method");

		try {
			this.closeShareModal.click();
		} catch (Exception e) {
			this.clickOnWebElement(closeShareModal);

		}

		logger.info("Ending of clickOnCloseModal method");
	}

	public void clickOnSortButton() {
		logger.info("Starting of clickOnSortButton method");

		try {
			this.btnSort.click();
		} catch (Exception e) {
			this.clickOnWebElement(btnSort);

		}

		logger.info("Ending of clickOnSortButton method");
	}

	public boolean isSelectedNewestRadioButton() {
		logger.info("Starting of isSelectedNewestRadioButton method");
		logger.info("Ending of isSelectedNewestRadioButton method");

		return rdoNewest.isSelected();
	}

	public void clickOnLowToHighButton() {
		logger.info("Starting of clickOnLowToHighButton method");

		try {
			this.rdoLowToHigh.click();
		} catch (Exception e) {
			this.clickOnWebElement(rdoLowToHigh);

		}
		logger.info("Ending of clickOnLowToHighButton method");

	}

	public boolean isSelectedLowToHighRadioButton() {
		logger.info("Starting of isSelectedLowToHighRadioButton method");
		logger.info("Ending of isSelectedLowToHighRadioButton method");

		return rdoLowToHigh.isSelected();
	}

	public String getCourseName() {
		logger.info("Starting of getCourseName method");
		logger.info("Ending of getCourseName method");

		return lblCourseName.getText();
	}

	public String getAvailableOfferslabel() {
		logger.info("Starting of getAvailableOfferslabel method");
		logger.info("Ending of getAvailableOfferslabel method");

		return lblAvailableOffers.getText();
	}

	public String getCouponAvailable() {
		logger.info("Starting of getCouponAvailable method");
		logger.info("Ending of getCouponAvailable method");

		String[] s = lblCouponAvailable.getText().split(" ");
		String actualCouponName = s[1] + " " + s[2];
		return actualCouponName;
	}

	public int getCouponAvailableCount() {
		logger.info("Starting of getCouponAvailableCount method");
		logger.info("Ending of getCouponAvailableCount method");

		String[] s = lblCouponAvailable.getText().split(" ");
		return Integer.parseInt(s[0]);
	}

	public int getCouponCount() {
		logger.info("Starting of getCouponAvailableCount method");
		logger.info("Ending of getCouponAvailableCount method");

		int s = lstCoupons.size();
		return s;
	}

	public String getViewAllAvailbleOffersLabel() {
		logger.info("Starting of getViewAllAvailbleOffersLabel method");
		logger.info("Ending of getViewAllAvailbleOffersLabel method");

		return lblViewAllAvailbleOffers.getText();
	}

	public String getGetThisCourseLabel() {
		logger.info("Starting of getGetThisCourseLabel method");
		logger.info("Ending of getGetThisCourseLabel method");

		return lblGetThisCourse.getText();
	}

	public List<String> getOverviewAndContentLabels() {
		logger.info("Starting of getOverviewAndContentLabels method");
		logger.info("Ending of getOverviewAndContentLabels method");

		List<String> courseList = new ArrayList<String>();
		for (WebElement e : lblOverViewAndContent) {
			courseList.add(e.getText());
		}
		return courseList;
	}

	public String getContactUsLabel() {
		logger.info("Starting of getContactUsLabel method");
		logger.info("Ending of getContactUsLabel method");

		return lblContactUs.getText();
	}

	public String getQueryLabel() {
		logger.info("Starting of getQueryLabel method");
		logger.info("Ending of getQueryLabel method");

		return lblQuery.getText();
	}

	public String getApplyCouponHeader() {
		logger.info("Starting of getApplyCouponHeader method");
		logger.info("Ending of getApplyCouponHeader method");

		return lblApplyCouponHeader.getText();
	}

	public void setSearchCoupon(String search) {
		logger.info("Starting of setSearchCoupon method");

		this.txtSearchCoupon.sendKeys(search);

		logger.info("Ending of setSearchCoupon method");

	}

	public void clickOnApplyButton() {
		logger.info("Starting of clickOnApplyButton method");

		try {
			this.btnApply.click();
		} catch (Exception e) {
			this.clickOnWebElement(btnApply);

		}
		logger.info("Ending of clickOnApplyButton method");

	}

	public String getAppliedCouponName() {
		logger.info("Starting of getAppliedCouponName method");
		logger.info("Ending of getAppliedCouponName method");

		return lblCouponName.getText();
	}

	public void clickOnRemoveButton() {
		logger.info("Starting of clickOnRemoveButton method");

		try {
			this.btnRemove.click();
		} catch (Exception e) {
			this.clickOnWebElement(btnRemove);

		}
		logger.info("Ending of clickOnRemoveButton method");

	}

	public String getAppliedSuccesfully() {
		logger.info("Starting of getAppliedSuccesfully method");
		logger.info("Ending of getAppliedSuccesfully method");

		return lblAppliedSuccesfully.getText();
	}

	public void clickOnDoneButton() {
		logger.info("Starting of clickOnDoneButton method");

		try {
			this.btnDone.click();
		} catch (Exception e) {
			this.clickOnWebElement(btnDone);

		}
		logger.info("Ending of clickOnDoneButton method");

	}

	public boolean isDisplayedAppliedCoupon() {
		logger.info("Starting of isDisplayedAppliedCoupon method");
		logger.info("Ending of isDisplayedAppliedCoupon method");
		try {
			lblCouponName.isDisplayed();
			return false;

		} catch (Exception e) {
			return true;
		}
	}

	public void setName(String name) {
		logger.info("Starting of setName method");

		this.txtName.sendKeys(name);

		logger.info("Ending of setName method");

	}

	public void setMobileNumber(String mobileNumber) {
		logger.info("Starting of setMobileNumber method");

		this.txtMobileNumber.sendKeys(mobileNumber);

		logger.info("Ending of setMobileNumber method");

	}

	public void setMessage(String message) {
		logger.info("Starting of setMessage method");

		this.txtMessage.sendKeys(message);

		logger.info("Ending of setMessage method");

	}

	public void clickOnSubmitButton() {
		logger.info("Starting of clickOnSubmitButton method");

		try {
			this.btnSubmit.click();
		} catch (Exception e) {
			this.clickOnWebElement(btnSubmit);

		}
		logger.info("Ending of clickOnSubmitButton method");

	}

	public void clickOnContactUsButton() {
		logger.info("Starting of clickOnContactUsButton method");

		try {
			this.lblContactUs.click();
		} catch (Exception e) {
			this.clickOnWebElement(lblContactUs);

		}
		logger.info("Ending of clickOnContactUsButton method");
	}

	public String getQuerySubmittedMessage() {
		logger.info("Starting of getQuerySubmittedMessage method");
		logger.info("Ending of getQuerySubmittedMessage method");

		return msgQuerySubmitted.getText();
	}

	public String getFillDetailsHeader() {
		logger.info("Starting of getFillDetailsHeader method");
		logger.info("Ending of getFillDetailsHeader method");

		return lblFillDetails.getText();
	}

	public void setAddressName(String addressName) {
		logger.info("Starting of setAddressName method");

		this.txtAddressName.sendKeys(addressName);

		logger.info("Ending of setAddressName method");

		logger.info("Starting of setAddressName method");

	}

	public void setEmail(String email) {
		logger.info("Starting of setEmail method");

		this.txtEmail.sendKeys(email);

		logger.info("Ending of setEmail method");

		logger.info("Starting of setEmail method");

	}

	public void clickOnStateDropDown() {
		logger.info("Starting of clickOnStateDropDown method");

		this.drpState.click();

		logger.info("Ending of clickOnStateDropDown method");

	}

	public void clickOnGetThisCourseButton() {
		logger.info("Starting of clickOnGetThisCourseButton method");
		try {
			this.lblGetThisCourse.click();
		} catch (Exception e) {
			this.clickOnWebElement(lblGetThisCourse);
		}
		logger.info("Ending of clickOnGetThisCourseButton method");

	}

	public void clickOnSelectStateDropDown(String state) {
		logger.info("Starting of clickOnSelectStateDropDown method");

		for (WebElement e : drpSelectState) {
			if (e.getText().equals(state)) {
				e.click();
				break;
			}
		}

		logger.info("Ending of clickOnSelectStateDropDown method");
	}

	public void clickOnSelectEmailDropDown(String email) {
		logger.info("Starting of clickOnSelectStateDropDown method");

		for (WebElement e : drpSelectState) {
			if (e.equals(email)) {
				e.click();
			}
		}
		logger.info("Starting of clickOnSelectStateDropDown method");

	}

	public void clickOnBuyNowButton() {
		logger.info("Starting of clickOnBuyNowButton method");

		try {
			this.btnBuyNow.click();
		} catch (Exception e) {
			this.clickOnWebElement(btnBuyNow);

		}
		logger.info("Ending of clickOnBuyNowButton method");

	}

	public void clickOnContentButton() {
		logger.info("Starting of clickOnContentButton method");

		try {
			this.btnContent.click();
		} catch (Exception e) {
			this.clickOnWebElement(btnContent);
		}

		logger.info("Ending of clickOnContentButton method");

	}

	public boolean isSelectedcontent() {
		logger.info("Starting of isDisplayedcontent method");
		logger.info("Ending of isDisplayedcontent method");

		try {
			this.contentList.isSelected();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public int totalPrice() {
		logger.info("Starting of totalPrice method");
		logger.info("Ending of totalPrice method");

		return Integer.parseInt(Price(lblTotalPrice));
	}

	public int getDiscountPrice() {
		logger.info("Starting of totalPrice method");
		logger.info("Ending of totalPrice method");

		String[] lblPrice = lblDiscountPrice.getText().split("₹");
		String[] price = lblPrice[1].split(" ");
		String actualdiscountPrice = price[0];
		int DiscountPrice = Integer.parseInt(actualdiscountPrice);

		return DiscountPrice;
	}

	public int totalCoursePrice() {
		logger.info("Starting of totalCoursePrice method");
		logger.info("Ending of totalCoursePrice method");

		return Integer.parseInt(Price(coursePrice));
	}

	public int CourseAndGSTprice() {
		logger.info("Starting of CourseAndGSTprice method");
		logger.info("Ending of CourseAndGSTprice method");

		Integer i = Integer.parseInt(Price(lblCoursePrice));
		Integer j = Integer.parseInt(Price(lblGSTPrice));

		return i + j;
	}

	public boolean getPopularCourses() {
		logger.info("Starting of getPopularCourses method");
		logger.info("Ending of getPopularCourses method");

		return this.countOfCourses(lstPopularCourses, lstAllCoursesCount, btnPopularCoursesSeeAll);
	}

	public boolean getSearchField() {
		logger.info("Starting of getSearchField method");
		logger.info("Ending of getSearchField method");

		if (!(lblSearch.isDisplayed())) {
			return false;
		}
		return true;
	}

	public boolean getFeaturedCourses() {
		logger.info("Starting of getFeaturedCourses method");
		logger.info("Ending of getFeaturedCourses method");

		return this.countOfCourses(lstFeaturedCourses, lstAllCoursesCount, btnFeaturedCoursesSeeAll);
	}

	public boolean getRecentCourses() {
		logger.info("Starting of getRecentCourses method");
		logger.info("Ending of getRecentCourses method");

		return this.countOfCourses(lstRecentCourses, lstAllCoursesCount, btnRecentCoursesSeeAll);
	}

	public boolean getAllCourses() {
		logger.info("Starting of getAllCourses method");
		logger.info("Ending of getAllCourses method");

		return this.countOfCourses(lstAllCourses, lstAllCoursesCount, btnAllCoursesSeeAll);
	}

	public void clickOnPopularCoursesSeeAllButton() {
		logger.info("Starting of clickOnPopularCoursesSeeAllButton method");

		try {
			this.scrollDown(500);
			this.btnPopularCoursesSeeAll.click();
		} catch (Exception e) {
			this.clickOnWebElement(btnPopularCoursesSeeAll);
		}

		logger.info("Ending of clickOnPopularCoursesSeeAllButton method");
	}

	public void clickOnAllCoursesSeeAllButton() {
		logger.info("Starting of clickOnAllCoursesSeeAllButton method");

		try {
			this.scrollDown(500);
			this.btnAllCoursesSeeAll.click();
		} catch (Exception e) {
			this.clickOnWebElement(btnAllCoursesSeeAll);
		}

		logger.info("Ending of clickOnAllCoursesSeeAllButton method");
	}

	public void clickOnRecentCoursesSeeAllButton() {
		logger.info("Starting of clickOnRecentCoursesSeeAllButton method");

		try {
			this.scrollDown(500);
			this.btnRecentCoursesSeeAll.click();
		} catch (Exception e) {
			this.clickOnWebElement(btnRecentCoursesSeeAll);
		}

		logger.info("Ending of clickOnRecentCoursesSeeAllButton method");
	}

	public void clickOnFeaturedCoursesSeeAllButton() {
		logger.info("Starting of clickOnFeaturedCoursesSeeAllButton method");

		try {
			this.scrollDown(500);
			this.btnFeaturedCoursesSeeAll.click();
		} catch (Exception e) {
			this.clickOnWebElement(btnFeaturedCoursesSeeAll);
		}

		logger.info("Ending of clickOnFeaturedCoursesSeeAllButton method");
	}

	public void clickOnViewAllCategoriesButton() {
		logger.info("Starting of clickOnviewAllButton method");

		try {
			this.scrollDown(500);
			this.btnviewAll.click();
		} catch (Exception e) {
			this.clickOnWebElement(btnviewAll);
		}

		logger.info("Ending of clickOnviewAllButton method");
	}

	public void clickOnSubCategoryOption() {
		logger.info("Starting of clickOnCategoryOption method");

		for (WebElement e : lstAllCategories) {
			if (e.getText().contains("ias")) {
				clickOnWebElement(e);
				break;
			}
		}

		logger.info("Ending of clickOnCategoryOption method");
	}

	public void clickOnSaveAndContinueButton() {
		logger.info("Starting of clickOnSaveAndContinueButton method");

		try {
			this.btnSaveAndContinue.click();
		} catch (Exception e) {
			this.clickOnWebElement(btnSaveAndContinue);
		}

		logger.info("Ending of clickOnSaveAndContinueButton method");
	}

	public boolean isSelectedCategoryOption() {
		logger.info("Starting of isSelectedCategoryOption method");
		logger.info("Ending of isSelectedCategoryOption method");

		if (selectedCategory.isSelected()) {
			return true;
		}
		return false;
	}

	public boolean isNotSelectedCategoryOption() {
		logger.info("Starting of isNotSelectedCategoryOption method");
		logger.info("Ending of isNotSelectedCategoryOption method");

		if (!(selectedCategory.isSelected())) {
			return true;
		}
		return false;
	}

	public void searchCourse(String searchCourse) {
		logger.info("Starting of searchCourse method");
		
		this.txtSearch.clear();
		this.txtSearch.sendKeys(searchCourse);

		logger.info("Ending of searchCourse method");
	}

	public String getCourseNameLabel() {
		logger.info("Starting of getCourseNameLabel method");
		logger.info("Ending of getCourseNameLabel method");

		return lblCourse.getText();
	}

	public void clickOnBackButton() {
		logger.info("Starting of clickOnBackButton method");

		try {
			this.btnBack.click();
		} catch (Exception e) {
			this.clickOnWebElement(btnBack);
		}

		logger.info("Ending of clickOnBackButton method");
	}

	public void clickOnGetCourse() {
		logger.info("Starting of clickOnGetCourse method");

		try {
			this.getCourse.click();
		} catch (Exception e) {
			this.clickOnWebElement(getCourse);
		}

		logger.info("Ending of clickOnGetCourse method");
	}

	public void clickOnPlayVideoIcon() {
		logger.info("Starting of clickOnPlayVideoIcon method");

		try {
			this.icnPlayVideo.click();
		} catch (Exception e) {
			this.clickOnWebElement(icnPlayVideo);
		}

		logger.info("Ending of clickOnPlayVideoIcon method");
	}

	public void clickOnCloseVideoButton() {
		logger.info("Starting of clickOnCloseVideoButton method");

		try {
			this.clickOnWebElement(btnCloseVideo);

		} catch (Exception e) {
			this.btnCloseVideo.click();
		}

		logger.info("Ending of clickOnCloseVideoButton method");
	}

	public boolean getVideoPopup() {
		logger.info("Starting of getQuerySubmittedMessage method");
		logger.info("Ending of getQuerySubmittedMessage method");

		try {
			videoPopUp.isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public String getInvalidCouponMessage() {
		logger.info("Starting of getInvalidCouponMessage method");
		logger.info("Ending of getInvalidCouponMessage method");
		this.explicitWait(msgInvalidCoupon);
		return msgInvalidCoupon.getText();
	}

	public void clickOnApplyCouponCloseIcon() {
		logger.info("Starting of clickOnApplyCouponCloseIcon method");

		try {
			this.icnCloseApplyCoupon.click();
		} catch (Exception e) {
			this.clickOnWebElement(icnCloseApplyCoupon);
		}

		logger.info("Ending of clickOnApplyCouponCloseIcon method");
	}

	public String getNoContentMessage() {
		logger.info("Starting of getNoContentMessage method");
		logger.info("Ending of getNoContentMessage method");

		return msgNoContent.getText();
	}

	public String getNoResultsMessage() {
		logger.info("Starting of getNoResultsMessage method");
		logger.info("Ending of getNoResultsMessage method");

		return msgNoResultsFound.getText();
	}

	public boolean getVidesoPopup() {
		logger.info("Starting of getQuerySubmittedMessage method");
		logger.info("Ending of getQuerySubmittedMessage method");

		int i = lblOverViewAndContent.size();
		String ss = msgNoContent.getText();
		int sss = Integer.parseInt(ss);
		if (i == sss) {
			return true;
		}

		return false;
	}

	public void clickOnTermsConditionLabel() {
		logger.info("Starting of clickOnTermsConditionLabel method");

		try {
			if (btnTermsCondition.isDisplayed()) {
				this.btnTermsCondition.click();
			}
		} catch (Exception e) {
			this.clickOnWebElement(btnTermsCondition);
		}

		logger.info("Ending of clickOnTermsConditionLabel method");
	}

	public String getTermsAndConditions() {
		logger.info("Starting of getTermsAndConditions method");
		logger.info("Ending of getTermsAndConditions method");
		this.switchToNewwindow();

		return lblTermsCondition.getText().trim();

	}

	public String getSearchedData() {
		logger.info("Starting of getSearchedData method");
		logger.info("Ending of getSearchedData method");

		return lblTermsCondition.getAttribute("placeholder");
	}

	public void clickOnLiveCourseButton() {
		logger.info("Starting of clickOnLiveCourseButton method");

		try {
			this.btnLiveCourse.click();
		} catch (Exception e) {
			this.clickOnWebElement(btnLiveCourse);

		}

		logger.info("Ending of clickOnLiveCourseButton method");
	}

	public void clickOnNotesAndBooksButton() {
		logger.info("Starting of clickOnNotesAndBooksButton method");

		try {
			this.btnNotesAndBooks.click();
		} catch (Exception e) {
			this.clickOnWebElement(btnNotesAndBooks);
		}

		logger.info("Ending of clickOnNotesAndBooksButton method");
	}

	public void clickOnTestSeriesButton() {
		logger.info("Starting of clickOnTestSeriesButton method");

		try {
			this.btnTestSeries.click();
		} catch (Exception e) {
			this.clickOnWebElement(btnTestSeries);

		}

		logger.info("Ending of clickOnTestSeriesButton method");
	}

	public void clickOnRecordedCourseButton() {
		logger.info("Starting of clickOnRecordedCourseButton method");

		try {
			this.btnRecordedCourses.click();
		} catch (Exception e) {
			this.clickOnWebElement(btnRecordedCourses);

		}

		logger.info("Ending of clickOnRecordedCourseButton method");
	}

	public void clickOnCategorysOption() {
		logger.info("Starting of clickOnCategoryOption method");

		for (WebElement e : lstCategory) {
			if (e.getText().contains("State govt exams- SSC")) {
				clickOnWebElement(e);
				break;
			}
		}

		logger.info("Ending of clickOnCategoryOption method");
	}

	public boolean getSizeOfCourses() {
		logger.info("Starting of getSizeOfCourses method");
		logger.info("Ending of getSizeOfCourses method");

		for (int i = 0; i <= lstCategory.size(); i++)

			if (lstCategory.get(i).getText().contains("State govt exams- SSC")) {
				String s = lstCategory.get(i).getText();
				String ss = s.substring(22, 25);
				int in = Integer.parseInt(ss);

				this.btnAllCoursesSeeAll.click();

				int courses = this.lblCourses.size();
				if (in == courses) {
					return true;
				}
			}
		return false;
	}

	public boolean isSelectedIITTab() {
		logger.info("Starting of isSelectedIITTab method");
		logger.info("Ending of isSelectedIITTab method");

		return tabIIT.isSelected();
	}

	public Integer getCountText() {
		logger.info("Starting of getCountText method");

		String batchCount = lblSubCategories.getText();
		logger.info(batchCount);
		String returnCount = "";
		String str[] = batchCount.split("\\D");
		for (String s : str)
			if (s != "")
				returnCount = s;
		int countValue = 0;
		if (!returnCount.equals(""))
			countValue = Integer.parseInt(returnCount);
		System.out.println("Count=" + countValue);

		logger.info("Ending of getCountText method");

		return countValue;
	}

	public String getSubCategoriesCount() {
		logger.info("Starting of getSubCategoriesCount method");
		logger.info("Ending of getSubCategoriesCount method");

		String s[] = lblSubCategories.getText().split("(");
		String ss = s[1];
		return ss;
	}

	public int getListSubCategoriesCount() {
		logger.info("Starting of getSubCategoriesCount method");
		logger.info("Ending of getSubCategoriesCount method");

		return lstAllCategories.size();
	}

	public void clickOnGooglePlayButton() {
		logger.info("Starting of clickOnGooglePlayButton method");

		try {
			this.btnGooglePlay.click();
		} catch (Exception e) {
			this.clickOnWebElement(btnGooglePlay);
		}

		logger.info("Ending of clickOnGooglePlayButton method");
	}

	public void clickOnAppStoreButton() {
		logger.info("Starting of clickOnAppStoreButton method");

		try {
			this.btnAppStore.click();
		} catch (Exception e) {
			this.clickOnWebElement(btnAppStore);
		}

		logger.info("Ending of clickOnAppStoreButton method");
	}

	public void switchToNewwindow() {
		logger.info("Starting of switchToNewWindow method");

		switchToNewWindow();

		logger.info("Ending of switchToNewWindow method");

	}

	public String getGooglePlayLabel() {
		logger.info("Starting of getGooglePlayLabel method");
		logger.info("Ending of getGooglePlayLabel method");

		return lblGooglePlay.getText();
	}

	public String getLearningLightApplabel() {
		logger.info("Starting of getLearningLightApplabel method");
		logger.info("Ending of getLearningLightApplabel method");

		return lblLearningLightApp.getText();
	}

	public String getAvailableForIphoneAndIpadLabel() {
		logger.info("Starting of getAvailableForIphoneAndIpadLabel method");
		logger.info("Ending of getAvailableForIphoneAndIpadLabel method");

		return lblAvailableForIphoneAndIpad.getText();
	}

	public String getAppStorelabel() {
		logger.info("Starting of getAppStorelabel method");
		logger.info("Ending of getAppStorelabel method");

		return lblAppStore.getText();
	}

	public void clickOnPriceLowToHighRadioButton() {
		logger.info("Starting of clickOnPriceLowToHighRadioButton method");

		try {
			this.rdoPriceLowToHigh.click();
		} catch (Exception e) {
			this.clickOnWebElement(rdoPriceLowToHigh);

		}
		logger.info("Ending of clickOnPriceLowToHighRadioButton method");
	}

	public void clickOnPriceHighToLowRadioButton() {
		logger.info("Starting of clickOnPriceHighToLowRadioButton method");

		try {
			this.rdoPriceHighToLow.click();
		} catch (Exception e) {
			this.clickOnWebElement(rdoPriceHighToLow);

		}

		logger.info("Ending of clickOnPriceHighToLowRadioButton method");

	}

	public void clickOnContentLockedButton() {
		logger.info("Starting of clickOnContentLockedButton method");

		try {
			this.scrollIntoView(btnLockContent);
			this.clickOnWebElement(btnLockContent);
		} catch (Exception e) {
			this.btnLockContent.click();
		}

		logger.info("Ending of clickOnContentLockedButton method");
	}

	public String getBuyLocklabel() {
		logger.info("Starting of getBuyLocklabel method");
		logger.info("Ending of getBuyLocklabel method");

		return lblBuyLockContent.getText();
	}

	public String getBuyAccessLockedContentlabel() {
		logger.info("Starting of getBuyAccessLockedContentlabel method");
		logger.info("Ending of getBuyAccessLockedContentlabel method");

		return lblAccessLockContent.getText();
	}

	public void clickOnLockedContentBuyNowButton() {
		logger.info("Starting of clickOnLockedContentBuyNowButton method");

		try {
			this.btnLockedContentBuyNow.click();
		} catch (Exception e) {
			this.clickOnWebElement(btnLockedContentBuyNow);
		}

		logger.info("Ending of clickOnLockedContentBuyNowButton method");
	}

	public void clickOnCloseLockedContentButton() {
		logger.info("Starting of clickOnCloseLockedContentButton method");

		try {
			this.btnCloseLockedContent.click();
		} catch (Exception e) {
			this.clickOnWebElement(btnCloseLockedContent);
		}

		logger.info("Ending of clickOnCloseLockedContentButton method");
	}

	public void clickOndownCarouselPrice() {
		logger.info("Starting of clickOndownCarouselPrice method");

		try {
			this.downCarouselPrice.click();
		} catch (Exception e) {
			this.clickOnWebElement(downCarouselPrice);
		}

		logger.info("Ending of clickOndownCarouselPrice method");
	}

	public void clickOnCouponLabel() {
		logger.info("Starting of clickOnCouponLabel method");

		try {
			this.lblCoupon.click();
		} catch (Exception e) {
			this.clickOnWebElement(lblCoupon);
		}

		logger.info("Ending of clickOnCouponLabel method");
	}
}