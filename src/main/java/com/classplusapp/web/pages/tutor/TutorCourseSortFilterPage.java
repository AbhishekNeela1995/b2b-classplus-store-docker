package com.classplusapp.web.pages.tutor;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.classplusapp.web.pages.BaseClassplusAutomationPage;

public class TutorCourseSortFilterPage extends BaseClassplusAutomationPage {

	@FindBy(xpath = "//button[contains(@class,'Header_FilterButton')]")
	private WebElement btnSortFilter;

	@FindBy(xpath = "//div[@class='selectRecepientModal_left_element selectRecepientModal_selected_left_element']")
	private WebElement lblCourses;

	@FindBy(xpath = "//label[@class='notificationCheckboxlabel cursorPointer']/../../preceding-sibling::div/preceding-sibling::div/preceding-sibling::div/descendant::label")
	private WebElement chkCreatedByMe;

	@FindBy(xpath = "//label[@class='notificationCheckboxlabel cursorPointer']/../../preceding-sibling::div/preceding-sibling::div//following-sibling::div/descendant::span/input/following-sibling::label[@for='COURSES1']")
	private WebElement chkCreatedByMyOrg;

	@FindBy(xpath = "//label[@class='notificationCheckboxlabel cursorPointer']/../../preceding-sibling::div/preceding-sibling::div//following-sibling::div/descendant::span/input/following-sibling::label[@for='COURSES2']")
	private WebElement chkPublic;

	@FindBy(xpath = "//label[@class='notificationCheckboxlabel cursorPointer']/../../following-sibling::div/following-sibling::div/following-sibling::div/descendant::label")
	private WebElement chkImportedCourse;

	@FindBy(xpath = "//div[@class='cursorPointer Card_FeaturedCourse__3o0XN Card_CarouselAllCourses__1EQX_ CourseList_responsiveCourseListCard__VLCdP ']//div/following-sibling::div/div/div/following-sibling::div[contains(@class,'Card_createdBy__1DNmK')]")
	private List<WebElement> lblCreatedByMeCourses;

	@FindBy(xpath = "//div[contains(@class,'Filter_ApplyContainer')]/div/preceding-sibling::div")
	private WebElement btnApply;

	@FindBy(xpath = "//div[contains(@class,'Filter_ApplyContainer')]//following-sibling::div")
	private WebElement btnClearAll;

	@FindBy(xpath = "//div[@class='selectRecepientModal-leftContainer']/div")
	private List<WebElement> lblSortFilters;

	@FindBy(xpath = "//div[@class='infinite-scroll-component']/div[@class='selectRecepientModal-right-element']")
	private List<WebElement> lblCoursesFilters;

	@FindBy(xpath = "//div[@class='selectRecepientModal-leftContainer']//following-sibling::div[contains(text(),'COURSE STATUS')]")
	private WebElement lblCourseStatus;

	@FindBy(xpath = "//div[@class='selectRecepientModal-leftContainer']//following-sibling::div[contains(text(),'PRICE RANGE')]")
	private WebElement lblPriceRange;

	@FindBy(xpath = "//div[@class='selectRecepientModal-leftContainer']//following-sibling::div[contains(text(),'SORT AND ORDER')]")
	private WebElement lblSortAndOrder;

	@FindBy(xpath = "//div[contains(@class,'Filter_filterListHolder')]/div/div")
	private List<WebElement> lblCourseSortAndOrder;

	@FindBy(xpath = "//div[@class='slider-tracks']/div")
	private WebElement lblSetPriceRange;

	@FindBy(xpath = "//div[@class='cursorPointer Card_FeaturedCourse__3o0XN Card_CarouselAllCourses__1EQX_ CourseList_responsiveCourseListCard__VLCdP ']/div/following-sibling::div/div/following-sibling::div/span//preceding-sibling::span/preceding-sibling::span")
	private List<WebElement> priceRangeCourses;

	@FindBy(xpath = "(//div[@class='cursorPointer Card_FeaturedCourse__3o0XN Card_CarouselAllCourses__1EQX_ CourseList_responsiveCourseListCard__VLCdP ']/div/following-sibling::div/div/following-sibling::div/span//preceding-sibling::span/preceding-sibling::span)[1]")
	private WebElement highPriceCourse;

	@FindBy(xpath = "//div[@class='cursorPointer Card_FeaturedCourse__3o0XN Card_CarouselAllCourses__1EQX_ CourseList_responsiveCourseListCard__VLCdP ']/div/following-sibling::div/div/following-sibling::div/span//preceding-sibling::span/preceding-sibling::span/../../../../following-sibling::div/div/a/following-sibling::div/following-sibling::div/div/following-sibling::div/span/preceding-sibling::span/preceding-sibling::span")
	private List<WebElement> highPriceCourses;

	@FindBy(xpath = "//div[contains(@class,'Filter_filterListHolder')]/div/span/preceding-sibling::span")
	private WebElement lblDefaultMinPriceRange;

	@FindBy(xpath = "//div[contains(@class,'Filter_filterListHolder')]/div/span/following-sibling::span")
	private WebElement lblDefaultMaxPriceRange;

	@FindBy(xpath = "//input[@id='SORT AND ORDER2']")
	private WebElement rdoLowToHighPrice;

	@FindBy(xpath = "//input[@id='SORT AND ORDER3']")
	private WebElement rdoHighToLowPrice;

	@FindBy(xpath = "//div[contains(@class,'Filter_filterListHolder')]/div/following-sibling::div/div/div/div/following-sibling::div/div")
	private WebElement lblMaxRangeSlider;

	// div[@class='cursorPointer Card_FeaturedCourse__3o0XN
	// Card_CarouselAllCourses__1EQX_ CourseList_responsiveCourseListCard__VLCdP
	// ']/div/following-sibling::div/div/div/following-sibling::div/descendant::span

	private static final Logger logger = Logger.getLogger(TutorCourseSortFilterPage.class.getName());

	public TutorCourseSortFilterPage(WebDriver driver) {
		super(driver);
		logger.info("Starting of TutorCourseSortFilterPage method");

		PageFactory.initElements(driver, this);

		logger.info("Ending of TutorCourseSortFilterPage method");

	}

	public void clickOnSortAndFilterButton() {
		logger.info("starting of clickOnSortAndFilterButton method");

		try {
			if (btnSortFilter.isDisplayed()) {
				this.btnSortFilter.click();
			}
		} catch (Exception e) {
			this.clickOnWebElement(btnSortFilter);
		}

		logger.info("Ending of clickOnSortAndFilterButton method");
	}

	public boolean isSelectedCoursesLabel() {
		logger.info("Starting of isSelectedCoursesLabel method");
		logger.info("Ending of isSelectedCoursesLabel method");
		this.hardWait(2);
		try {
			if (lblCourses.isSelected())
				;
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean isSelectedCreatedByMeCheckbox() {
		logger.info("Starting of isSelectedCreatedByMeCheckbox method");
		logger.info("Ending of isSelectedCreatedByMeCheckbox method");

		return chkCreatedByMe.isSelected();
	}

	public boolean isSelectedImportedCheckbox() {
		logger.info("Starting of isSelectedCreatedByMeCheckbox method");
		logger.info("Ending of isSelectedCreatedByMeCheckbox method");

		return chkImportedCourse.isSelected();
	}

	public void clickOnCreatedByMeCheckbox() {
		logger.info("starting of clickOnCreatedByMeCheckbox method");

		try {
			this.clickOnWebElement(chkCreatedByMe);
		} catch (Exception e) {
			this.chkCreatedByMe.click();
		}

		logger.info("Ending of clickOnCreatedByMeCheckbox method");
	}

	public void clickOnCreatedByMyOrgCheckbox() {
		logger.info("starting of clickOnCreatedByMyOrgCheckbox method");

		try {
			this.clickOnWebElement(chkCreatedByMyOrg);
		} catch (Exception e) {
			this.chkCreatedByMyOrg.click();
		}

		logger.info("Ending of clickOnCreatedByMyOrgCheckbox method");
	}

	public void clickOnPublicCheckbox() {
		logger.info("starting of clickOnPublicCheckbox method");

		try {
			this.clickOnWebElement(chkPublic);
		} catch (Exception e) {
			this.chkPublic.click();
		}

		logger.info("Ending of clickOnPublicCheckbox method");
	}

	public void clickOnImportedCourseCheckbox() {
		logger.info("starting of clickOnImportedCourseCheckbox method");

		try {
			this.clickOnWebElement(chkImportedCourse);
		} catch (Exception e) {
			this.chkImportedCourse.click();
		}

		logger.info("Ending of clickOnImportedCourseCheckbox method");
	}

	public void clickOnApplyButton() {
		logger.info("starting of clickOnApplyButton method");

		try {
			this.hardWait(2);
			this.clickOnWebElement(btnApply);
			driver.navigate().refresh();
		} catch (Exception e) {
			this.btnApply.click();
		}
		logger.info("Ending of clickOnApplyButton method");
	}

	public void clickOnClearAllButton() {
		logger.info("starting of clickOnClearAllButton method");

		try {
			this.clickOnWebElement(btnClearAll);
		} catch (Exception e) {
			this.btnClearAll.click();
		}

		logger.info("Ending of clickOnClearAllButton method");
	}

	public boolean getCreatedByMeCourses() {
		logger.info("starting of getCreatedByMeCourses method");

		for (WebElement e : lblCreatedByMeCourses) {
			String createdByMeText = e.getText();
			System.out.println(createdByMeText);
			if (!(createdByMeText.equalsIgnoreCase("Created by: You(Owner)"))) {
				return false;
			}
		}
		logger.info("Ending of getCreatedByMeCourses method");

		return true;
	}

	public boolean getImportedCourses() {
		logger.info("starting of getImportedCourses method");

		for (WebElement e : lblCreatedByMeCourses) {
			String createdByMeText = e.getText();
			logger.info(createdByMeText);
			if (createdByMeText.equalsIgnoreCase("Created by: You(Owner)")) {
				return false;
			}
		}
		logger.info("Ending of getImportedCourses method");

		return true;
	}

	public List<String> getSortFilterList() {
		logger.info("Starting of getSortFilterList method");

		List<String> sortFilterList = new ArrayList<String>();
		for (WebElement e : lblSortFilters) {
			sortFilterList.add(e.getText());
		}
		logger.info("Ending of getSortFilterList method");
		return sortFilterList;
	}

	public List<String> getCoursesSortFilterList() {
		logger.info("Starting of getCoursesSortFilterList method");
		logger.info("Ending of getCoursesSortFilterList method");

		List<String> sortFilterCoursesList = new ArrayList<String>();
		for (WebElement e : lblCoursesFilters) {
			sortFilterCoursesList.add(e.getText());
		}
		return sortFilterCoursesList;
	}

	public void clickOnCourseStatus() {
		logger.info("starting of clickOnCourseStatus method");

		try {
			this.clickOnWebElement(lblCourseStatus);
		} catch (Exception e) {
			this.lblCourseStatus.click();
		}

		logger.info("Ending of clickOnCourseStatus method");
	}

	public void clickOnPriceRange() {
		logger.info("starting of clickOnPriceRange method");

		try {
			this.clickOnWebElement(lblPriceRange);
		} catch (Exception e) {
			this.lblPriceRange.click();
		}

		logger.info("Ending of clickOnPriceRange method");
	}

	public void clickOnSortAndOrder() {
		logger.info("starting of clickOnSortAndOrder method");

		try {
			this.clickOnWebElement(lblSortAndOrder);
		} catch (Exception e) {
			this.lblSortAndOrder.click();
		}

		logger.info("Ending of clickOnSortAndOrder method");
	}

	public List<String> getCourseSortAndOrderList() {
		logger.info("Starting of getCourseSortAndOrderList method");
		logger.info("Ending of getCourseSortAndOrderList method");

		List<String> sortOrderCoursesList = new ArrayList<String>();
		for (WebElement e : lblCourseSortAndOrder) {
			sortOrderCoursesList.add(e.getText());
		}
		return sortOrderCoursesList;
	}

	public void clickOnSetCoursePriceRange() {
		logger.info("Starting of clickOnSetCoursePriceRange method");

		this.explicitWait(lblSetPriceRange);
		this.slider(lblSetPriceRange, 50);
		this.hardWait(3);

		logger.info("Ending of clickOnSetCoursePriceRange method");
	}

	public void clickOnMaxToMinSetCoursePriceRange() {
		logger.info("Starting of clickOnMaxToMinSetCoursePriceRange method");

		this.explicitWait(lblMaxRangeSlider);
		this.slider(lblMaxRangeSlider, -100);
		this.hardWait(3);

		logger.info("Ending of clickOnMaxToMinSetCoursePriceRange method");
	}

	public boolean getDefaultPriceRangeCourses() {
		logger.info("Starting of getDefaultPriceRangeCourses method");

		String s[] = lblDefaultMinPriceRange.getText().split(" ");
		String minPrice = s[1];
		int actualBelowPrice = Integer.parseInt(minPrice);

		String ss[] = lblDefaultMaxPriceRange.getText().split(" ");
		String maxPrice = ss[1];
		int actualAbovePrice = Integer.parseInt(maxPrice);
		this.clickOnApplyButton();
		for (WebElement e : priceRangeCourses) {
			String coursePrice = e.getText().substring(1);
			int actualCoursePrice = Integer.parseInt(coursePrice);

			if (!(actualCoursePrice <= actualAbovePrice && actualCoursePrice >= actualBelowPrice)) {
				return false;
			}
		}
		logger.info("Ending of getDefaultPriceRangeCourses method");

		return true;

	}

	public boolean getHighToLowPriceRangeCourses() {
		logger.info("Starting of getHighToLowPriceRangeCourses method");

		String highCoursePrice = highPriceCourse.getText().substring(1);
		long actualHighCoursePrice = Long.parseLong(highCoursePrice);

		for (WebElement e : priceRangeCourses) {
			String coursePrice = e.getText().substring(1);
			long actualCoursePrice = Long.parseLong(coursePrice);

			if (!(actualCoursePrice <= actualHighCoursePrice)) {
				return false;
			}
		}
		logger.info("Ending of getDefaultPriceRangeCourses method");

		return true;

	}

	public boolean getLowToHighPriceRangeCourses() {
		logger.info("Starting of getLowToHighPriceRangeCourses method");

		String highCoursePrice = highPriceCourse.getText().substring(1);
		long actualHighCoursePrice = Long.parseLong(highCoursePrice);

		for (WebElement e : priceRangeCourses) {
			String coursePrice = e.getText().substring(1);
			long actualCoursePrice = Long.parseLong(coursePrice);
			if (!(actualCoursePrice >= actualHighCoursePrice)) {
				return false;
			}
		}

		logger.info("Ending of getLowToHighPriceRangeCourses method");
		return true;
	}

	public void clickOnHighToLowRadioButton() {
		logger.info("starting of clickOnHighToLowRadioButton method");

		try {
			this.clickOnWebElement(rdoHighToLowPrice);
		} catch (Exception e) {
			this.rdoHighToLowPrice.click();
		}

		logger.info("Ending of clickOnHighToLowRadioButton method");
	}

	public void clickOnLowToHighRadioButton() {
		logger.info("starting of clickOnLowToHighRadioButton method");

		try {
			this.clickOnWebElement(rdoLowToHighPrice);
		} catch (Exception e) {
			this.rdoLowToHighPrice.click();
		}

		logger.info("Ending of clickOnLowToHighRadioButton method");
	}

	public boolean getCreatedByMeDefaultPriceRangeCourse() {
		logger.info("Starting of getCreatedByMeDefaultPriceRangeCourse method");

		boolean flag = true;
		boolean a = this.getDefaultPriceRangeCourses();
		boolean b = this.getCreatedByMeCourses();
		if (a == flag && b == flag) {
			return flag;
		}
		logger.info("Ending of getCreatedByMeDefaultPriceRangeCourse method");

		return false;
	}

	public boolean getDefaultPriceRangeImportedCourses() {
		logger.info("Starting of getDefaultPriceRangeImportedCourses method");

		boolean flag = true;
		boolean a = this.getDefaultPriceRangeCourses();
		boolean b = this.getImportedCourses();
		if (a == flag && b == flag) {
			return flag;
		}
		logger.info("Ending of getDefaultPriceRangeImportedCourses method");

		return false;
	}

	public boolean getCreatedByMePriceRangeCourse() {
		logger.info("Starting of getCreatedByMeDefaultPriceRangeCourse method");

		boolean flag = true;
		boolean a = this.getDefaultPriceRangeCourses();
		boolean b = this.getCreatedByMeCourses();
		if (a == flag && b == flag) {
			return flag;
		}
		logger.info("Starting of getCreatedByMeDefaultPriceRangeCourse method");

		return false;
	}

	public boolean getImportedPriceRangeCourse() {
		logger.info("Starting of getImportedPriceRangeCourse method");

		boolean flag = true;
		boolean a = this.getDefaultPriceRangeCourses();
		boolean b = this.getImportedCourses();
		if (a == flag && b == flag) {
			return true;
		}
		logger.info("Starting of getImportedPriceRangeCourse method");

		return false;
	}

	public boolean getLowToHighCreatedByMeCourses() {
		logger.info("Starting of getLowToHighCreatedByMeCourses method");

		boolean flag = true;
		boolean a = this.getDefaultPriceRangeCourses();
		boolean b = this.getCreatedByMeCourses();
		boolean c = this.getLowToHighPriceRangeCourses();
		if (a == flag && b == flag && c == flag) {
			return true;
		}
		logger.info("Starting of getLowToHighCreatedByMeCourses method");
		return false;
	}

	public boolean getHighToLowCreatedByMeCourses() {
		logger.info("Starting of getHighToLowCreatedByMeCourses method");

		boolean flag = true;
		boolean a = this.getDefaultPriceRangeCourses();
		boolean b = this.getCreatedByMeCourses();
		boolean c = this.getHighToLowPriceRangeCourses();
		if (a == flag && b == flag && c == flag) {
			return true;
		}
		logger.info("Starting of getHighToLowCreatedByMeCourses method");
		return false;
	}

	public boolean getLowToHighImportedCourses() {
		logger.info("Starting of getLowToHighImportedCourses method");

		boolean flag = true;
		boolean a = this.getDefaultPriceRangeCourses();
		boolean b = this.getImportedCourses();
		boolean c = this.getLowToHighPriceRangeCourses();
		if (a == flag && b == flag && c == flag) {
			return true;
		}
		logger.info("Starting of getLowToHighImportedCourses method");
		return false;
	}

	public boolean getHighToLowImportedCourses() {
		logger.info("Starting of getHighToLowImportedCourses method");

		boolean flag = true;
		boolean a = this.getDefaultPriceRangeCourses();
		boolean b = this.getImportedCourses();
		boolean c = this.getHighToLowPriceRangeCourses();
		if (a == flag && b == flag && c == flag) {
			return true;
		}
		logger.info("Starting of getHighToLowImportedCourses method");
		return false;
	}
}
