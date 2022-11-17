package com.classplusapp.web.tests.parent;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static com.classplusapp.store.util.Constants.*;
import com.classplusapp.web.pages.parent.ParentBuyCoursePage;
import com.classplusapp.web.tests.BaseClassplusAutomationTest;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Epic("Store Overview")
@Feature("Parent Buy Course Test")
public class ParentBuyCourseTest extends BaseClassplusAutomationTest {

	private WebDriver driver = null;
	private ParentBuyCoursePage parentBuyCoursePage = null;

	private static final Logger logger = Logger.getLogger(ParentBuyCourseTest.class.getName());

	@BeforeClass
	@Parameters({ "browser", "orgCode4" })
	public void initClassplusSiteLogin(@Optional("Chrome") String browser, @Optional("learn") String orgCode)
			throws Exception {
		logger.info("Starting of initClassplusSiteLogin methond");
		this.driver = super.loginClassPlusSite(browser, orgCode, parentMobileNumber, emailAddress,
				WEB_DRIVER.PARENT_BUY_COURSE_TEST);
		this.parentBuyCoursePage = new ParentBuyCoursePage(this.driver);

		logger.info("Ending of initClassplusSiteLogin method");
	}

	@Test(priority = 1, description = "Verify Select Course Page")
	@Description("Test Description:Verify Select Course Page")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verify Select Course Page")
	public void testSelectCourse() {
		logger.info("Starting of testSelectCourse method");

		try {
			this.parentBuyCoursePage.clickOnStoreButton();
			Thread.sleep(5000);

			String lblFilterByTopics = this.parentBuyCoursePage.getFilterByTopicsLabel();
			Assert.assertEquals(lblFilterByTopics,
					expectedAssertionsProp.getProperty(LABEL_PARENT_PURCHASE_COURSE_FILTER));

			this.parentBuyCoursePage.setSearch(testDataProp.getProperty(PARENT_PURCHASE_SEARCH_COURSE));
			this.parentBuyCoursePage.clickOnGetCourse();
			Thread.sleep(3000);
		} catch (Exception e) {
			Assert.fail("Exception occured while Select Course Page: " + e.getMessage());
			logger.error("Error occured while testing Select Course Page", e);
		}

		logger.info("Ending of testSelectCourse method");
	}

	@Test(priority = 2, description = "Verify Buy Course Page")
	@Description("Test Description:Verify Buy Course Page")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Verify Buy Course Page")
	public void testBuyNowCourse() {
		logger.info("Starting of testBuyNowCourse method");

		try {
			String lblTitle = this.parentBuyCoursePage.getTitleLabelText();
			Assert.assertEquals(lblTitle, expectedAssertionsProp.getProperty(LABEL_PARENT_PURCHASE_COURSE_TITLE));

			Thread.sleep(3000);
			this.parentBuyCoursePage.clickonSelectStateDropDown();
			this.parentBuyCoursePage.clickonStateButton();
			this.parentBuyCoursePage.clickOnBuyNowButton();
		} catch (Exception e) {
			Assert.fail("Exception occured while Buy Course Page: " + e.getMessage());
			logger.error("Error occured while testing Buy Course Page", e);
		}

		logger.info("Ending of testBuyNowCourse method");
	}

	@AfterClass
	public void quitDriver() {
		logger.info("Starting of quitDriver method");

		try {
			if (driver != null) {
				Thread.sleep(5000);
				this.loginPage.clickOnLogOut();
				this.quitDriver(this.driver, WEB_DRIVER.PARENT_BUY_COURSE_TEST);
				logger.info("Driver quit successfully");
			}
		} catch (Exception ex) {
			logger.error(ex.getMessage());
		}

		logger.info("Ending of quitDriver method");
	}

	@AfterMethod
	public void getConsoleLoggers() {
		logger.info("Starting of getConsoleLogger method");

		this.logBrowserConsoleErrors(this.driver);

		logger.info("Ending of getConsoleLogger method");
	}

}
