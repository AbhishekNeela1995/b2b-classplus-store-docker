package com.classplusapp.web.tests.tutor;


import org.testng.Assert;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.classplusapp.web.pages.tutor.TutorDashboardPage;
import com.classplusapp.web.tests.BaseClassplusAutomationTest;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import static  com.classplusapp.store.util.Constants.*;

@Test
public class TutorDashboardTest extends BaseClassplusAutomationTest {
	
	private WebDriver driver = null;
	private TutorDashboardPage tutorDashBoardPage = null;
	private static final Logger logger = Logger.getLogger(TutorDashboardPage.class.getName());

	@BeforeClass
	@Parameters({ "browser", "orgCode" })
	public void initClassplusSiteLogin(@Optional("Chrome")String browser,@Optional("learn") String orgCode)
			throws Exception {
		logger.info("Starting of initClassplusSiteLogin methond");
		this.driver = super.loginClassPlusSite(browser, orgCode, tutorMobileNumber, emailAddress,
				WEB_DRIVER.TUTOR_DASHBOARD);
		this.tutorDashBoardPage = new TutorDashboardPage(driver);

		logger.info("Ending of initClassplusSiteLogin method");
	}

	
	
	@Test(priority = 1, description = "Verify Address Data Report")
	@Description("Test Description:Verify Address Data Report")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verify Address Data Report")
	public void addressDataReport() {
		logger.info("Starting of addressDataReport method");

		try {
			this.tutorDashBoardPage.clickOnProfileThumbnailBtn();
			this.tutorDashBoardPage.clickOnDashboardBtn();
			this.tutorDashBoardPage.selectReport();
			this.tutorDashBoardPage.selectAddressDataCourse();
			this.tutorDashBoardPage.selectDate();
			this.tutorDashBoardPage.exportData();
			
			String exportDataText = this.tutorDashBoardPage.exportDataText();
//			System.out.println(expectedAssertionsProp.getProperty(TUTOR_DASHBOARD_TEST_EXPORT_POPUP));
//			System.out.println(exportDataText);
			Assert.assertEquals(exportDataText,expectedAssertionsProp.getProperty(TUTOR_DASHBOARD_TEST_EXPORT_POPUP));
		} catch (Exception e) {
			Assert.fail("Exception occured while testing address Data Report : " + e.getMessage());
			logger.error("Error occured while testing address Data Report ", e);
		}
		
		logger.info("Ending of addressDataReport method");
	}
		
	@Test(priority = 2, description = "Verify AI Powered Leads Report")
	@Description("Test Description:Verify AI Powered Leads Report")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verify Address Data Report")
	public void AiPoweredLeadsReport() {
		logger.info("Starting of AiPoweredLeadsReport method");

		try {
			this.tutorDashBoardPage.selectReport();
			this.tutorDashBoardPage.selectAiPoweredLeadsCourse();
			this.tutorDashBoardPage.selectDate();
			this.tutorDashBoardPage.exportData();
			String exportDataText = this.tutorDashBoardPage.exportDataText();
//			System.out.println(exportDataText);
			Assert.assertEquals(exportDataText,expectedAssertionsProp.getProperty(TUTOR_DASHBOARD_TEST_EXPORT_POPUP));
		} catch (Exception e) {
			Assert.fail("Exception occured while testing AI Powered Leads Report : " + e.getMessage());
			logger.error("Error occured while testing AI Powered Leads Report ", e);
		}
		logger.info("Ending of AiPoweredLeadsReport method");

	}
	
	@Test(priority = 3, description = "Verify Course Installment Report")
	@Description("Test Description:Verify Course Installment Report")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verify Course Installment Report")
	public void courseInstallmentReport() {
		logger.info("Starting of courseInstallmentReport method");

		try {
			this.tutorDashBoardPage.selectReport();
			this.tutorDashBoardPage.selectCourseInstallmentReport();
			this.tutorDashBoardPage.selectDate();
			this.tutorDashBoardPage.exportData();
			
			String exportDataText = this.tutorDashBoardPage.exportDataText();
//			System.out.println(exportDataText);
			Assert.assertEquals(exportDataText,expectedAssertionsProp.getProperty(TUTOR_DASHBOARD_TEST_EXPORT_POPUP_2));
		} catch (Exception e) {
			Assert.fail("Exception occured while testing Course Installment Report : " + e.getMessage());
			logger.error("Error occured while testing Course Installment Report ", e);
		}
		logger.info("Ending of courseInstallmentReport method");

	}
	
	@Test(priority = 4, description = "Verify Course Purchases Transaction Reports")
	@Description("Test Description:Verify Course Purchases Transaction Reports")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verify Course Purchases Transaction Reports")
	public void coursePurchasesTransactionReports() {
		logger.info("Starting of coursePurchasesTransactionReports method");

		try {
			this.tutorDashBoardPage.selectReport();
			this.tutorDashBoardPage.selectCoursePurchasesTransactionReports();
			this.tutorDashBoardPage.selectDate();
			this.tutorDashBoardPage.exportData();
			String exportDataText = this.tutorDashBoardPage.exportDataText();
//			System.out.println(exportDataText);
			Assert.assertEquals(exportDataText,expectedAssertionsProp.getProperty(TUTOR_DASHBOARD_TEST_EXPORT_POPUP));
		} catch (Exception e) {
			Assert.fail("Exception occured while testing Course Purchases Transaction Reports : " + e.getMessage());
			logger.error("Error occured while testing Course Purchases Transaction Reports ", e);
		}

		logger.info("Ending of coursePurchasesTransactionReports method");
	}
	
	

	@AfterMethod
	public void getConsoleLoggers() {
		logger.info("Starting of getConsoleLogger method");

		this.logBrowserConsoleErrors(this.driver);

		logger.info("Ending of getConsoleLogger method");
	}

	@AfterClass
	public void quitDriver() {
		try {
			if (driver != null) {
				Thread.sleep(5000);
				this.loginPage.clickOnLogOut();
				this.quitDriver(this.driver, WEB_DRIVER.TUTOR_DASHBOARD);
				logger.info("Driver quit successfully");
			}
		} catch (Exception ex) {
			logger.error(ex.getMessage());
		}
	}
}
