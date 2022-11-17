package com.classplusapp.web.pages.parent;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.classplusapp.web.pages.BaseClassplusAutomationPage;

public class ParentBuyCoursePage extends BaseClassplusAutomationPage {

	@FindBy(xpath = "//p[text()='Store']")
	private WebElement btnStore;

	@FindBy(xpath = "//input[@placeholder=\"Search for a course\"]")
	private WebElement txtSearch;

	@FindBy(xpath = "//div[contains(text(),'FILTER BY TOPICS')]")
	private WebElement lblFilterByTopics;

	@FindBy(xpath = "//div[contains(text(),'Sample automation programs')]")
	private WebElement getCourse;

	@FindBy(xpath = "//span[contains(text(),' Overview ')]")
	private WebElement lblOverView;

	@FindBy(xpath = "//div[@class=\"publishPopupTitle\"]")
	private WebElement lblTitle;

	@FindBy(xpath = "//span[@class=\"Dropdown_Caret__1gRfD\"]")
	private WebElement SelectStateDropDown;

	@FindBy(xpath = "//li[contains(text(),'Telangana')]")
	private WebElement btnState;

	@FindBy(xpath = "//button[@class=\"storeBuy__cta--button cursorPointer\"]")
	private WebElement btnBuyNow;

	private static final Logger logger = Logger.getLogger(ParentBuyCoursePage.class.getName());

	public ParentBuyCoursePage(WebDriver driver) {
		super(driver);
		logger.info("Starting of ParentBuyCoursePage method");
		PageFactory.initElements(driver, this);
		logger.info("Ending of ParentBuyCoursePage method");

	}

	public void clickOnStoreButton() {
		logger.info("starting of clickOnStoreButton method");

		this.btnStore.click();

		logger.info("Ending of clickOnStoreButton method");
	}

	public void setSearch(String strSearch) {
		logger.info("Starting of setSearch method");

		this.explicitWait(txtSearch);
		this.txtSearch.sendKeys(strSearch);

		logger.info("Ending of setSearchArea method");
	}

	public String getFilterByTopicsLabel() {
		logger.info("Starting of getFilterByTopicsLabel method");

		logger.info(" Ending of getFilterByTopicsLabel method");
		return this.lblFilterByTopics.getText();
	}

	public void clickOnGetCourse() {
		logger.info("starting of clickOnGetCourse method");

		this.clickOnWebElement(getCourse);

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
		return this.lblTitle.getText();
	}

	public void clickonSelectStateDropDown() {
		logger.info("Starting of clickonSelectStateButton method");

		this.clickOnWebElement(SelectStateDropDown);

		logger.info("Ending of clickonSelectStateButton method");
	}

	public void clickonStateButton() {
		logger.info("Starting of clickonStateButton nethod");

		this.clickOnWebElement(btnState);

		logger.info("Starting of clickonStateButton method");
	}

	public void clickOnBuyNowButton() {
		logger.info("starting of clickOnBuyNowButton method");

		this.scrollDown(200);
		this.btnBuyNow.click();

		logger.info("Ending of clickOnBuyNowButton method");
	}

}
