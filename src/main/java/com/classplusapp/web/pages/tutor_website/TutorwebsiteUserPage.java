package com.classplusapp.web.pages.tutor_website;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.classplusapp.web.pages.BaseClassplusAutomationPage;

public class TutorwebsiteUserPage extends BaseClassplusAutomationPage{
	
	public TutorwebsiteUserPage(WebDriver driver) {
		super(driver);
		logger.info("Starting of TutorwebsiteUserPage method");

		PageFactory.initElements(driver, this);

		logger.info("Ending of TutorwebsiteUserPage method");
}

	//xpaths
	
	@FindBy(xpath = "(//div[@class=\"socialBtn-0-2-5\"]//img)[1]")
	private WebElement btnPlaystore;
	
	@FindBy(xpath = "(//div[@class=\"socialBtn-0-2-5\"]//img)[2]")
	private WebElement btnAppstore;
	
	@FindBy(xpath = "(//div[@class=\"webFooter__socialMediaIconContainer\"]//img)[2]")
	private WebElement btnFbLink;
	
	@FindBy(xpath = "(//div[@class=\"webFooter__socialMediaIconContainer\"]//img)[4]")
	private WebElement btnInstaLink;
	
	@FindBy(xpath = "(//div[@class=\"webFooter__socialMediaIconContainer\"]//img)[6]")
	private WebElement btnTelegramLink;
	
	// Functions
	
	public void clickOnPlaystoreButton() {
		logger.info("starting of clickOnPlaystoreButton  method");

		this.clickOnWebElement(btnPlaystore);

		logger.info("Ending of clickOnPlaystoreButton method");
	}
	
	public void clickOnAppstoreButton() {
		logger.info("starting of clickOnAppstoreButton  method");

		this.clickOnWebElement(btnAppstore);

		logger.info("Ending of clickOnAppstoreButton method");
	    	
	}
	
	public void clickOnFbLinkButton() {
		logger.info("starting of clickOnFbLinkButton  method");

		this.clickOnWebElement(btnFbLink);

		logger.info("Ending of clickOnFbLinkButton method");
	    	
	}
	
	public void clickOnInstaLinkButton() {
		logger.info("starting of clickOnInstaLinkButton  method");

		this.clickOnWebElement(btnInstaLink);

		logger.info("Ending of clickOnInstaLinkButton method");
	    	
	}
	
	public void clickOnTelegramLinkButton() {
		logger.info("starting of clickOnTelegramLinkButton  method");

		this.clickOnWebElement(btnTelegramLink);

		logger.info("Ending of clickOnTelegramLinkButton method");
	    	
	}
}
