package com.classplusapp.web.pages.student;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.classplusapp.web.pages.BaseClassplusAutomationPage;

public class StudentCourseOverviewPage extends BaseClassplusAutomationPage {

	@FindBy(xpath = "//div[@class='courseContentCurrent']/span[text()='Overview']")
	private WebElement lblSelectedOverview;

	@FindBy(xpath = "//span[text()='Overview']")
	private WebElement btnOverview;

	@FindBy(xpath = "//span[@class='overview-likeCount']")
	private WebElement btnLikeCourse;

	@FindBy(xpath = "//span[@class='overview-likeCount']/span[2]")
	private WebElement txtLikeCount;

	@FindBy(xpath = "//button[@class='CourseShareButton']")
	private WebElement btnShareCourse;

	@FindBy(xpath = "(//div[@class='ShareModal__Content__Body--SocialList']//img)[1]")
	private WebElement shareWhatsappLink;

	@FindBy(xpath = "//img[contains(@src, 'icon_fb.png')]")
	private WebElement shareFBLink;

	@FindBy(xpath = "//img[contains(@src, 'icon_telegram.png')]")
	private WebElement shareTelegramLink;

	@FindBy(xpath = "//img[contains(@src, 'icon_linkedIn.png')]")
	private WebElement shareLinkedinLink;

	@FindBy(xpath = "//div[@class='ShareModal__Content__Top--Close']/img")
	private WebElement btnCloseShareCourse;

	@FindBy(xpath = "//div[text()='Content Summary']/parent::div//div[@class='flexColumn']/span")
	private WebElement txtContentCountInContentSummary;

	@FindBy(xpath = "//div[@class='addContent__content--fill']/div")
	private List<WebElement> divAllContents;

	@FindBy(xpath = "//span[text()='Duration']/parent::div")
	private WebElement divContentDuration;

	@FindBy(xpath = "//p[text()='Unlocked']/ancestor::div[@class='addContent__content--video forHover']/div/div[2]/p[1]")
	private List<WebElement> freeContentInContent;

	@FindBy(xpath = "//div[@class='freeContent-text']/following-sibling::div/div/div/div[2]/div/p[1]")
	private List<WebElement> freeContentInContentSummary;

	@FindBy(xpath = "//div[text()='YOU MAY ALSO LIKE']")
	private WebElement lblYouMayLike;

	@FindBy(xpath = "//div[text()='YOU MAY ALSO LIKE']/parent::div/following-sibling::div/ul/li")
	private List<WebElement> youMayLikeCourses;

	@FindBy(xpath = "//div[text()='PRICE DETAILS']//parent::div//div[text()='Course Price']//parent::div/div[2]")
	private WebElement divCoursePrice;

	@FindBy(xpath = "//div[text()='PRICE DETAILS']//parent::div//div[text()='G.S.T. (18%)']//parent::div/div[2]")
	private WebElement divCourseGST;

	@FindBy(xpath = "//div[text()='PRICE DETAILS']//parent::div//div[text()='Internet Handling Charges']//parent::div/div[2]")
	private WebElement divInternetFees;

	@FindBy(xpath = "//div[text()='PRICE DETAILS']//parent::div//div[text()='Amount Payable']//parent::div/div[2]")
	private WebElement divAmountPayable;

	@FindBy(xpath = "//div[text()='PRICE DETAILS']/parent::div/div/div[1]")
	private List<WebElement> sectionsInpriceDetails;

//	@FindBy(xpath="//div[text()='PRICE DETAILS']//parent::div//div[text()='Course Price']//parent::div/div[2]")
//	private List<WebElement> ;

//	@FindBy(xpath = "//button[@class='storeBuy__cta--button cursorPointer']")
//	private WebElement btnBuyNow;

	@FindBy(xpath = "//span[text()='Contains Offline Study material']")
	private WebElement lblContainsOfflineMaterial;

	@FindBy(xpath = "//span[text()='Certification Available']")
	private WebElement lblCertificationAvailable;

	private static final Logger logger = Logger.getLogger(StudentBuyCoursePage.class.getName());

	public StudentCourseOverviewPage(WebDriver driver) {
		super(driver);
		logger.info("Starting of StudentCourseOverviewPage method");

		PageFactory.initElements(driver, this);

		logger.info("Ending of StudentCourseOverviewPage method");

	}

	public boolean checkOverviewLbl() {
		logger.info("starting of checkOverviewLbl method");
		try {
			if (this.lblSelectedOverview.isDisplayed())
				return true;
			else
				return false;
		} catch (Exception e) {
			return false;
		}

	}

	public void clickOnLikeButton() {
		logger.info("starting of clickOnLikeButton method");
		try {
			this.explicitWait(this.btnLikeCourse);
			this.btnLikeCourse.click();
		} catch (Exception e) {
			this.clickOnWebElement(btnLikeCourse);
		}

		logger.info("ending of clickOnLikeButton method");

	}

	public int getCourseLikeCount() throws InterruptedException {
		logger.info("starting of getCouresLikeCount");
		Thread.sleep(2000);
		return Integer.parseInt(this.txtLikeCount.getText().replaceAll("[^0-9]+", ""));
	}

	public void clickOnShareCourseButton() {
		logger.info("starting of clickOnShareCourseButton method");
		try {
			this.explicitWait(this.btnShareCourse);
			this.btnShareCourse.click();
		} catch (Exception e) {
			this.clickOnWebElement(btnShareCourse);
		}

		logger.info("ending of clickOnShareCourseButton method");

	}

	public String verifyPageUrl() {
		switchToNewWindow();
		return driver.getCurrentUrl();
	}

	public void clickOnShareWhatsappLink() {
		logger.info("starting of clickOnShareWhatsappLink method");
		try {
			this.explicitWait(this.shareWhatsappLink);
			this.shareWhatsappLink.click();
		} catch (Exception e) {
			this.clickOnWebElement(shareWhatsappLink);
		}

		logger.info("ending of clickOnShareWhatsappLink method");

	}

	public void clickOnShareFBLink() {
		logger.info("starting of clickOnShareFBLink method");
		try {
			this.explicitWait(this.shareFBLink);
			this.shareFBLink.click();
		} catch (Exception e) {
			this.clickOnWebElement(shareFBLink);
		}
		logger.info("ending of clickOnShareFBLink method");

	}

	public void clickOnShareTelegramLink() {
		logger.info("starting of clickOnShareTelegramLink method");
		try {
			this.explicitWait(this.shareTelegramLink);
			this.shareTelegramLink.click();
		} catch (Exception e) {
			this.clickOnWebElement(shareTelegramLink);
		}
		logger.info("ending of clickOnShareTelegramLink method");

	}

	public void clickOnShareLinkedinLink() {
		logger.info("starting of clickOnShareLinkedinLink method");
		try {
			this.explicitWait(this.shareLinkedinLink);
			this.shareLinkedinLink.click();
		} catch (Exception e) {
			this.clickOnWebElement(shareLinkedinLink);
		}
		logger.info("ending of clickOnShareLinkedinLink method");

	}

	public void closeShareCoursePopup() {
		logger.info("starting of closeShareCoursePopup method");
		try {
			this.explicitWait(this.btnCloseShareCourse);
			this.btnCloseShareCourse.click();
		} catch (Exception e) {
			this.clickOnWebElement(btnCloseShareCourse);
		}

		logger.info("ending of closeShareCoursePopup method");

	}

	public int getContentCountOfContentSummary() {
		logger.info("starting of closeShareCoursePopup method");

		this.explicitWait(this.txtContentCountInContentSummary);
		return Integer.parseInt(this.txtContentCountInContentSummary.getText());

	}

	public int getContentCountFromContentPage() {
		logger.info("starting of getContentCountFromContentPage method");

		this.explicitWait(this.divAllContents);
		return this.divAllContents.size();

	}

	public boolean checkContentDuration() {
		logger.info("starting of checkContentDuration method");
		try {
			if (this.divContentDuration.isDisplayed())
				return true;
			else
				return false;
		} catch (Exception e) {
			return false;
		}

	}

	public void clickOnOverviewButton() {
		logger.info("Starting of clickOnOverviewButton method");

		try {
			this.btnOverview.click();
		} catch (Exception e) {
			this.clickOnWebElement(btnOverview);
		}

		logger.info("Ending of clickOnOverviewButton method");
	}

	public List<String> getFreeContentInContent() {
		logger.info("Starting of getFreeContentInContent method");

		this.hardWait(2);
		List<String> freeContentsName = new ArrayList<String>();
		for (int i = 0; i < this.freeContentInContent.size(); i++) {
			freeContentsName.add(this.freeContentInContent.get(i).getText());
		}

		return freeContentsName;

	}

	public List<String> getFreeContentInContentSummary() {
		logger.info("Starting of getFreeContentInContentSummary method");

		List<String> freeContentsName = new ArrayList<String>();
		for (int i = 0; i < this.freeContentInContentSummary.size(); i++) {
			freeContentsName.add(this.freeContentInContentSummary.get(i).getText());
		}

		return freeContentsName;

	}

	public boolean checkYouMayLikeLbl() {
		logger.info("starting of checkYouMayLikeLbl method");
		try {
			this.scrollDown(500);
			if (this.lblYouMayLike.isDisplayed())
				return true;
			else
				return false;
		} catch (Exception e) {
			return false;
		}

	}

	public int getCountOfYouMayLikeCourses() {
		logger.info("starting of getCountOfYouMayLikeCourses method");
		this.scrollDown(500);
		return this.youMayLikeCourses.size();
	}

	public List<String> getSectionTitlesInPriceDetails() throws InterruptedException {
		logger.info("Starting of getSectionTitleInPriceDetails method");

		Thread.sleep(3000);
		List<String> txtSectionPriceDetails = new ArrayList<String>();

		for (int i = 0; i < this.sectionsInpriceDetails.size(); i++) {
			txtSectionPriceDetails.add(this.sectionsInpriceDetails.get(i).getText());
		}

		logger.info("ending of getSectionTitleInPriceDetails method");
		return txtSectionPriceDetails;

	}

	public boolean checkCoursePriceDiv() {
		logger.info("starting of checkCoursePrice method");

		try {
			divCoursePrice.isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean checkCoursePriceGst() {
		logger.info("starting of checkCoursePriceGst method");

		try {
			divCourseGST.isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean checkInternetFeesDiv() {
		logger.info("starting of checkCourseInternetFees method");
		try {
			if (this.divInternetFees.isDisplayed())
				return true;
			else
				return false;
		} catch (Exception e) {
			return false;
		}

	}

	public boolean checkAmountPayableDiv() {
		logger.info("starting of checkAmountPayable method");
		try {
			if (this.divAmountPayable.isDisplayed())
				return true;
			else
				return false;
		} catch (Exception e) {
			return false;
		}

	}

	public boolean checkLblOfflineMaterial() {
		logger.info("starting of checkLblOfflineMaterial method");
		try {
			if (this.lblContainsOfflineMaterial.isDisplayed())
				return true;
			else
				return false;
		} catch (Exception e) {
			return false;
		}

	}

	public boolean checkLblCertificationAvailable() {
		logger.info("starting of checkLblCertificationAvailable method");
		try {
			if (this.lblCertificationAvailable.isDisplayed())
				return true;
			else
				return false;
		} catch (Exception e) {
			return false;
		}

	}

}
