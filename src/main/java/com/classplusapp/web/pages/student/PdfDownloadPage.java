package com.classplusapp.web.pages.student;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.classplusapp.web.pages.BaseClassplusAutomationPage;

public class PdfDownloadPage extends BaseClassplusAutomationPage {

	@FindBy(xpath = "//div[contains(@class,'Card_createdBy')]")
	private WebElement getCourse;

	@FindBy(xpath = "//p[@class='addContent__content--details--heading']")
	private WebElement btnPdfContent;
	
	@FindBy(xpath = "(//p[@class='addContent__content--details--heading'])[2]")
	private WebElement btnPdfCOntent;

	private static final Logger logger = Logger.getLogger(PdfDownloadPage.class.getName());

	public PdfDownloadPage(WebDriver driver) {
		super(driver);
		logger.info("Starting of StudentBuyCoursePage method");

		PageFactory.initElements(driver, this);

		logger.info("Ending of StudentBuyCoursePage method");
	}

	public void clickOnGetCourse() {
		logger.info("Starting of clickOnGetCourse method");

		this.getCourse.click();

		logger.info("Ending of clickOnGetCourse method");

	}

	public void clickOnPdf() {
		logger.info("Starting of clickOnPdf method");

		try {
			this.clickOnWebElement(btnPdfContent);
		} catch (Exception e) {
			this.btnPdfContent.click();

		}
//		this.switchToNewWindow();
//		this.closeWindow();

		logger.info("Ending of clickOnPdf method");

	}
}
