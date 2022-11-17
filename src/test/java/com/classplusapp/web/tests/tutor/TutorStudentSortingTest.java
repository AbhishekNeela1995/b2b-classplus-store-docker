package com.classplusapp.web.tests.tutor;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static com.classplusapp.store.util.Constants.*;
import com.classplusapp.web.pages.tutor.TutorStudentSortingPage;
import com.classplusapp.web.tests.BaseClassplusAutomationTest;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Epic("Store Overview")
@Feature("Student Sorting Test")
public class TutorStudentSortingTest extends BaseClassplusAutomationTest {

	private WebDriver driver = null;
	private TutorStudentSortingPage tutorStudentSortingPage = null;

	private static final Logger logger = Logger.getLogger(TutorStudentSortingTest.class.getName());

	@BeforeClass
	@Parameters({ "browser", "orgCode"})
	public void initClassplusSiteLogin(@Optional("Chrome")String browser, @Optional("learn")String orgCode)
			throws Exception {
		logger.info("Starting of initClassplusSiteLogin methond");

		String searchCourse = testDataProp.getProperty(STUDENT_SORTING_SEARCH_COURSE);
		this.driver = super.loginClassPlusSite(browser, orgCode, tutorMobileNumber, emailAddress,
				WEB_DRIVER.STUDENT_SORTING_TEST);
		this.driver = super.clickOnStoreButton(driver, searchCourse);
		this.tutorStudentSortingPage = new TutorStudentSortingPage(driver);

		logger.info("Ending of initClassplusSiteLogin method");
	}

	@Test(priority = 1, description = "Verify Student Sort Overview Page")
	@Description("Test Description: Verify Student Sort Overview Page")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Verify Student Sort Overview Page")
	public void testStudentSortOverviewPage() {
		logger.info("Starting of testStudentSortOverviewPage method");

		try {
			this.tutorStudentSortingPage.clickOnCourseFolder();

			String lblOverView = this.tutorStudentSortingPage.getOverViewLabelText();
			Assert.assertEquals(lblOverView, expectedAssertionsProp.getProperty(LABEL_STORE_OVERVIEW));

		} catch (Exception e) {
			Assert.fail("Exception occured while testing Student Sort Overview Page: " + e.getMessage());
			logger.error("Error occured while testing Student Sort Overview Page ", e);
		}

		logger.info("Ending of testStudentSortOverviewPage method");
	}

	@Test(priority = 2, description = "Verify Student Sorting Page")
	@Description("Test Description: Verify Student Sorting Page")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Verify Student Sorting Page")
	public void testStudentSortingPage() {
		logger.info("Starting of testStudentSortingPage method");

		try {
			//this.driver.navigate().refresh();
			this.tutorStudentSortingPage.clickOnStudentsButton();

			// Assertion for checking the student status Label
			String lblStudentStatus = this.tutorStudentSortingPage.getStudentStatusLabelText();
			Assert.assertEquals(lblStudentStatus, expectedAssertionsProp.getProperty(LABEL_STUDENT_STATUS));

			this.tutorStudentSortingPage.clickOnStudentsIcon();
			this.tutorStudentSortingPage.clickOnEnrollDateIcon();
			this.tutorStudentSortingPage.clickOnExpiryDateIcon();
			this.tutorStudentSortingPage.clickOnPricePaidIcon();
			this.tutorStudentSortingPage.clickOnPaymentDetailIcon();
			this.tutorStudentSortingPage.clickOnStatusIcon();
			//this.tutorStudentSortingPage.clickOnMenuButton();
			
		} catch (Exception e) {
			Assert.fail("Exception occured while testing Student Sorting Page: " + e.getMessage());
			logger.error("Error occured while testing Student Sorting Page ", e);
		}

		logger.info("Ending of testStudentSortingPage method");
	}
	@Test(priority = 3, description = "Verify Search Student")
	@Description("Test Description: Verify Search Student")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Verify Search Student")
	public void testSearchStudent() {
		logger.info("Starting of testSearchStudent method");

		try {
			this.tutorStudentSortingPage.setSearch(testDataProp.getProperty(STUDENT_SORTING_SEARCH_STUDENT));
			
			String lblStudentStatus = this.tutorStudentSortingPage.getStudentNameLabel();
			Assert.assertEquals(lblStudentStatus, expectedAssertionsProp.getProperty(LABEL_STUDENT_NAME));

			String lblStudentMobileNumber = this.tutorStudentSortingPage.getStudentMobileNumberLabel();
			Assert.assertEquals(lblStudentMobileNumber,
					expectedAssertionsProp.getProperty(LABEL_STUDENT_MOBILE_NUMBER));
			
		} catch (Exception e) {
			Assert.fail("Exception occured while testing Search Student: " + e.getMessage());
			logger.error("Error occured while testing Search Student ", e);
		}
		
		logger.info("Ending of testSearchStudent method");
	}
	
	@Test(priority = 4, description = "Verify Message to Student")
	@Description("Test Description:Verify Message to Student")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Verify Message to Student")
	public void testMessageToStudent() {
		logger.info("Starting of testMessageToStudent method");

		try {
			this.tutorStudentSortingPage.clickOnKebabButton();
			this.tutorStudentSortingPage.clickOnMessageButton();

			String lblStudentNameheading = this.tutorStudentSortingPage.getStudentNameHeading();
			Assert.assertEquals(lblStudentNameheading, expectedAssertionsProp.getProperty(LABEL_STUDENT_NAME_HEADING));

			this.tutorStudentSortingPage.setMessage(testDataProp.getProperty(LABEL_MESSAGE_TO_STUDENT));
			this.tutorStudentSortingPage.clickOnSendButton();

			String lblMessage = this.tutorStudentSortingPage.getMessagelabel();
			Assert.assertEquals(lblMessage, expectedAssertionsProp.getProperty(LABEL_MESSAGE));

			
		} catch (Exception e) {
			Assert.fail("Exception occured while testing  Message to Student: " + e.getMessage());
			logger.error("Error occured while testing  Message to Student ", e);
		}
	

		logger.info("Ending of testMessageToStudent method");
	}
		
	
	@AfterClass
	public void quitDriver() {
		logger.info("Starting of quitDriver method");

		try {
			if (this.driver != null) {
				Thread.sleep(5000);
				this.loginPage.clickOnLogOut();
				this.quitDriver(this.driver, WEB_DRIVER.STUDENT_SORTING_TEST);
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