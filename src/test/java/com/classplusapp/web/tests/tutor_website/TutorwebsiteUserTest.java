//package com.classplusapp.web.tests.tutor_website;
//
//import org.apache.log4j.Logger;
//import org.openqa.selenium.WebDriver;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Parameters;
//import org.testng.annotations.Test;
//
//import com.classplusapp.web.tests.BaseClassplusAutomationTest;
//
//import io.qameta.allure.Description;
//import io.qameta.allure.Severity;
//import io.qameta.allure.SeverityLevel;
//import io.qameta.allure.Story;
//import com.classplusapp.web.pages.tutor_website.TutorwebsiteUserPage;
//public class TutorwebsiteUserTest extends BaseClassplusAutomationTest{
//
//	private WebDriver driver = null;
//	private TutorwebsiteUserPage tutorWebsite = null;
//	
//	private static final Logger logger = Logger.getLogger(TutorwebsiteUserTest.class.getName());
//
//	@BeforeClass
//	@Parameters({ "browser"})
//	public void initClassplusTutorWebsite(String browser)
//		throws Exception { logger.info("Starting of initClassplusSiteLogin method");
//
//		this.driver = super.ClassplusTutorWebsite(browser,
//				WEB_DRIVER.TUTOR_WEBSITE);
//		driver.get("https://learn.courses.store");
//		this.tutorWebsite = new TutorwebsiteUserPage(driver);
//		logger.info("Ending of initClassplusSiteLogin method");
//	}
//	
//	@Test(priority = 1, description = "Verify Play Store on Tutor Website")
//	@Description("Test Description: Verify Play Store on Tutor Website")
//	@Severity(SeverityLevel.CRITICAL)
//	@Story("Verify Play Store on Tutor Website")
//     
//	public void clickOnPlaystoreButton() {	
//		logger.info("Starting of clickOnPlaystoreButton method");
//		
//		this.tutorWebsite.clickOnPlaystoreButton();
//		
//		logger.info("Ending of clickOnPlaystoreButton method");
//    }
//	
//	
//	
//	@Test(priority = 2, description = "Verify App Store on Tutor Website")
//	@Description("Test Description: Verify App Store on Tutor Website")
//	@Severity(SeverityLevel.CRITICAL)
//	@Story("Verify App Store on Tutor Website")
//	
//	public void clickOnAppstoreButton() {	
//		logger.info("Starting of clickOnAppstoreButton method");
//		this.tutorWebsite.clickOnAppstoreButton();
//		logger.info("Ending of clickOnAppstoreButton method");
//	}
//
//	
//	
//	@Test(priority = 3, description = "Verify FB Link on Tutor Website")
//	@Description("Test Description: Verify FB Link on Tutor Website")
//	@Severity(SeverityLevel.CRITICAL)
//	@Story("Verify FB Link on Tutor Website")
//	
//	public void clickOnFbLinkButton() {	
//		logger.info("Starting of clickOnFbLinkButton method");
//		this.tutorWebsite.clickOnFbLinkButton();
//		logger.info("Ending of clickOnFbLinkButton method");
//	}
//	
//	@Test(priority = 4, description = "Verify Insta Link on Tutor Website")
//	@Description("Test Description: Verify Insta Link on Tutor Website")
//	@Severity(SeverityLevel.CRITICAL)
//	@Story("Verify Insta Link on Tutor Website")
//	
//	public void clickOnInstaLinkButton() {	
//		logger.info("Starting of clickOnAppstoreButton method");
//		this.tutorWebsite.clickOnInstaLinkButton();
//		logger.info("Ending of clickOnAppstoreButton method");
//	}
//	
//	@Test(priority = 5, description = "Verify Telegram Link on Tutor Website")
//	@Description("Test Description: Verify Telegram Link on Tutor Website")
//	@Severity(SeverityLevel.CRITICAL)
//	@Story("Verify Telegram Link on Tutor Website")
//	
//	public void clickOnTelegramLinkButton() {	
//		logger.info("Starting of clickOnTelegramLinkButton method");
//		this.tutorWebsite.clickOnTelegramLinkButton();
//		logger.info("Ending of clickOnTelegramLinkButton method");
//	}
//
//}