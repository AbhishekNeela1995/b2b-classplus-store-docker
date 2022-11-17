package com.classplusapp.web.pages.faculty;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.classplusapp.web.pages.BaseClassplusAutomationPage;
import com.classplusapp.web.pages.tutor.TutorContentMarketPage;

public class FacultySearchCoursePage extends TutorContentMarketPage {

	@FindBy(xpath = "//span[contains(text(),'faculty course')]")
	private WebElement getCourse;

	@FindBy(xpath = "//div[contains(@class,'EmptyScreen_nothingFoundSubHeading')]//preceding-sibling::div")
	private WebElement msgNothingFound;

	@FindBy(xpath = "//div[contains(@class,'EmptyScreen_nothingFoundSubHeading')]")
	private WebElement msgNoResults;

	@FindBy(xpath = "//div[@class='StoreCarousels_notCarousel__1866g']/following-sibling::div/span")
	private WebElement btnViewAll;

	@FindBy(xpath = "//div[@class='cursorPointer Card_FeaturedCourse__3o0XN Card_CarouselAllCourses__1EQX_ CourseList_responsiveCourseListCard__VLCdP ']")
	private List<WebElement> courses;

	@FindBy(xpath = "//div[@class='courseContent']/div")
	private List<WebElement> leftMenuTabs;
	
	@FindBy(xpath = "//span[@class='SelectorSection__Right__Menu__Label--Courses']")
	private WebElement lblTotalCourses;

	@FindBy(xpath = "//div[@class='SelectorSection__Right__Menu__List--Item']/input")
	private List<WebElement> chkSelectedCourse;

	private static final Logger logger = Logger.getLogger(FacultySearchCoursePage.class.getName());

	public FacultySearchCoursePage(WebDriver driver) {
		super(driver);
		logger.info("Starting of SearchCoursesPage method");

		PageFactory.initElements(driver, this);

		logger.info("Ending of SearchCoursesPage method");
	}

	public void clickOnGetCourseFolder() {
		logger.info("Starting of clickOnGetCourseFolder method");

		try {
			Thread.sleep(2000);
			// this.explicitWait(getCourse);
			this.getCourse.click();
		} catch (Exception e) {
			this.clickOnWebElement(getCourse);
		}

		logger.info("Ending of clickOnGetCourseFolder method");
	}

	public String getNothingFoundMessage() {
		logger.info("Starting of getNothingFoundMessage method");

		this.explicitWait(msgNothingFound);

		logger.info("Ending of getNothingFoundMessage method");
		return msgNothingFound.getText();
	}

	public String getNoResultsMessage() {
		logger.info("Starting of getNoResultsMessage method");

		this.explicitWait(msgNoResults);

		logger.info("Ending of getNoResultsMessage method");
		return msgNoResults.getText();
	}

	public void clickOnViewAllButton() {
		logger.info("starting of clickOnViewAllButton  method");

		this.clickOnWebElement(btnViewAll);

		logger.info("Ending of clickOnViewAllButton method");
	}

	public boolean getCoursesCount() {
		logger.info("starting of getCoursesCount  method");
		logger.info("Ending of getCoursesCount method");
		
		int courseList = courses.size();
		
		this.clickOnViewAllButton();

		if (courses.size() > courseList) {
			return true;
		} else {
			return false;
		}
	}
	
	public List<String> getLeftMenuLabels(String menuTabs) {
		logger.info("Starting of getLeftMenuLabels method");
		logger.info("Ending of getLeftMenuLabels method");

		List<String> courseList = new ArrayList<String>();
		for (WebElement e : leftMenuTabs) {
			courseList.add(e.getText());
		}
		return courseList;
	}

	public boolean getViewAllText() {
		logger.info("Starting of getViewAllText method");
		logger.info("Ending of getViewAllText method");

		this.explicitWait(btnViewAll);
		try {
			return btnViewAll.isDisplayed();

		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean getViewAllText1() {
		logger.info("Starting of getViewAllText method");
		logger.info("Ending of getViewAllText method");

		String ss = lblTotalCourses.getText().substring(9);
		String[] s = ss.split("/");
		String actualSelectedCheckBox = s[0];
		int i = 0;
		for (WebElement e : chkSelectedCourse) {
			if (e.isSelected()) {
				i++;
			} else {
				break;
			}
		}
		int actalSelectedcheckBoxOne = Integer.parseInt(actualSelectedCheckBox);
		if (i == actalSelectedcheckBoxOne) {
			return true;
		}
		return false;
	}
}
