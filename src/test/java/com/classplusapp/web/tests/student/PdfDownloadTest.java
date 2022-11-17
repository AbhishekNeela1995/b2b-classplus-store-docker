package com.classplusapp.web.tests.student;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.classplusapp.web.pages.student.PdfDownloadPage;
import com.classplusapp.web.pages.student.StudentBuyCoursePage;
import com.classplusapp.web.pages.student.StudentViewContentPage;
import com.classplusapp.web.tests.BaseClassplusAutomationTest;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import static com.classplusapp.store.util.Constants.*;

public class PdfDownloadTest extends BaseClassplusAutomationTest {
	private WebDriver driver = null;
	private PdfDownloadPage pdfDownload = null;
	private StudentViewContentPage contentPage = null;
	private StudentBuyCoursePage buyCoursePage = null;
	private static final Logger logger = Logger.getLogger(PdfDownloadTest.class.getName());

	@BeforeClass
	@Parameters({ "browser", "orgCode2" })
	public void initClassplusSiteLogin(@Optional("Chrome") String browser, @Optional("learn") String orgCode)
			throws Exception {
		logger.info("Starting of initClassplusSiteLogin methond");

		this.driver = super.loginClassPlusSite(browser, orgCode, studentMobileNumber, emailAddress,
				WEB_DRIVER.STUDENT_BUY_COURSE_TEST);
		this.buyCoursePage = new StudentBuyCoursePage(this.driver);
		this.pdfDownload = new PdfDownloadPage(this.driver);
		this.contentPage = new StudentViewContentPage(this.driver);
		logger.info("Ending of initClassplusSiteLogin method");
	}

	@Test(priority = 1, description = "Verify student can download the pdf file")
	@Description("Test Description:Verify student can download pdf")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verify student can download pdf")
	public void testDownloadPdf() {
		logger.info("Starting of testDownloadPdf method");

		try {
			this.buyCoursePage.clickOnStoreButton();
			this.buyCoursePage.clickOnViewAllPurchased();
			this.buyCoursePage.setSearch(testDataProp.getProperty(STUDENT_SEARCH_PDF_COURSE));
			this.pdfDownload.clickOnGetCourse();
			this.contentPage.clickOnContentButton();
			this.pdfDownload.clickOnPdf();

		} catch (Exception e) {
			Assert.fail("Exception occured while testing Select Course Page and download pdf: " + e.getMessage());
			logger.error("Error occured while testing Select Course Page and download pdf", e);
		}

		logger.info("Ending of testDownloadPdf method");
	}

	@AfterClass
	public void quitDriver() {
		logger.info("Starting of quitDriver method");

		try {
			if (this.driver != null) {
				Thread.sleep(5000);
				this.loginPage.clickOnLogOut();
				this.quitDriver(this.driver, WEB_DRIVER.STUDENT_BUY_COURSE_TEST);
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
