package com.classplusapp.web.pages.tutor;

import java.util.regex.Pattern;

import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.classplusapp.web.pages.BaseClassplusAutomationPage;

public class TutorAnnouncementPage extends BaseClassplusAutomationPage {

	@FindBy(xpath = "//span[contains(text(),'B2B SHIPMENT')]")
	private WebElement getCourse;

	@FindBy(xpath = "//div[contains(text(),'SUB-CATEGORIES')]")
	private WebElement lblSubCategories;

	@FindBy(xpath = "//span[contains(text(),'Content')]//parent::div")
	private WebElement mnuContentIcon;

	@FindBy(xpath = "//p[contains(text(),'B2B SHIPMENT')]")
	private WebElement lblB2BShipmentCourse;

	@FindBy(xpath = "//div[contains(text(),'Add Content')]")
	private WebElement lblAddContent;

	@FindBy(xpath = "//span[contains(text(),' Announcements')]")
	private WebElement lblAnnouncements;

	@FindBy(xpath = "//span[contains(text(),'Make an announcement')]")
	private WebElement btnMakeAnAnnouncement;

	@FindBy(xpath = "//span[contains(text(),'Announcements')]")
	private WebElement mnuAnnouncementsIcon;

	@FindBy(xpath = "//h3[contains(text(),'Gunjan Gupta tutor')]")
	private WebElement lblGunjanGuptaTutor;

	@FindBy(xpath = "//span[contains(text(),'Make an announcement')]")
	private WebElement makeAnnounce;

	@FindBy(xpath = "//div[contains(text(),'Make an announcement')]")
	private WebElement lblMakeAnAnnouncement;

	@FindBy(xpath = "//textarea[@placeholder='Make an announcement']")
	private WebElement txtMakeAnnouncement;

	@FindBy(xpath = "//button[@class='ui grey tiny basic button customButtonStyle']/ preceding-sibling::input")
	private WebElement btnAttachFiles;

	@FindBy(xpath = "//label[contains(text(),'Send SMS')]")
	private WebElement lblSendSMS;

	@FindBy(xpath = "//button[@class='ui mini primary button']")
	private WebElement btnAddPost;

	@FindBy(xpath = "//div[contains(text(),'Announcement added successfully')]")
	private WebElement msgAddedAnnouncement;

	@FindBy(xpath = "//span[contains(text(),'Make an announcement')]")
	private WebElement makeAnnounce1;

	@FindBy(xpath = "//textarea[@placeholder='Make an announcement']")
	private WebElement makePdfAnnounceText;

	@FindBy(xpath = "//button[@class='ui grey tiny basic button customButtonStyle']/ preceding-sibling::input")
	private WebElement attachFile1;

	@FindBy(xpath = "//button[@class='ui mini primary button']")
	private WebElement postButton1;

	@FindBy(xpath = "//div[contains(text(),'Announcement added successfully')]")
	private WebElement announceMessage1;

	@FindBy(xpath = "//span[contains(text(),'Make an announcement')]")
	private WebElement makeExcelAnnouncement;

	@FindBy(xpath = "//textarea[@placeholder='Make an announcement']")
	private WebElement makeExcelAnnounceText;

	@FindBy(xpath = "//button[@class='ui grey tiny basic button customButtonStyle']/ preceding-sibling::input")
	private WebElement attachFile2;

	@FindBy(xpath = "//button[@class='ui mini primary button']")
	private WebElement postButton2;

	@FindBy(xpath = "//div[contains(text(),'Announcement added successfully')]")
	private WebElement announceMessage2;

	@FindBy(xpath = "//span[contains(text(),'sample automation excel')]/parent::h3/parent::div/parent::div/parent::div/parent::div/parent::div/following-sibling::div/child::div")
	private WebElement mnuHorizontalIcon;

	@FindBy(xpath = "(//div[@class='item an-dr-menu'])[1]")
	private WebElement mnuEditIcon;

	@FindBy(xpath = "//textarea[@placeholder='Make an announcement']")
	private WebElement txtEditAnnouncement;

	@FindBy(xpath = "//button[@class='ui mini primary button']")
	private WebElement btnEditPost;

	@FindBy(xpath = "//div[contains(text(),'Announcement edited successfully')]")
	private WebElement msgEditedAnnouncement;

	@FindBy(xpath = "//span[contains(text(),'sample automation pdf')]/parent::h3/parent::div/parent::div/parent::div/parent::div/parent::div/following-sibling::div/child::div")
	private WebElement mnuPdfHorizontalIcon;

	@FindBy(xpath = "//span[contains(text(),'sample automation image')]/parent::h3/parent::div/parent::div/parent::div/parent::div/parent::div/following-sibling::div/child::div")
	private WebElement mnuImageHorizontalIcon;

	@FindBy(xpath = "(//div[@class='item an-dr-menu'])[2]")
	private WebElement mnuRemoveIcon;

	@FindBy(xpath = "//div[contains(text(),'Delete Announcement?')]")
	private WebElement lblDeleteAnnouncement;

	@FindBy(xpath = "//p[contains(text(),'Are you sure you want to delete the announcement?')]")
	private WebElement lblAreYouSureYouWantToDeleteTheAnnouncement;

	@FindBy(xpath = "//button[contains(text(),'Delete')]")
	private WebElement btnDelete;

	@FindBy(xpath = "//div[@class='publishPopupTitle']")
	private WebElement lblCourseNameTitle;

	@FindBy(xpath = "//div[@class='ui header']/child::div[@class='content']")
	private WebElement lblDeleteAnnouncementHeading;

	@FindBy(xpath = "//div[@class='ui header']/following-sibling::div[@class='content']")
	private WebElement lblDeleteAnnouncementText;

	@FindBy(xpath = "//input[@type='text']")
	private WebElement txtSearch;

	@FindBy(xpath = "//span[contains(text(),'sample automation excel sheet')]")
	private WebElement lblExcelAnnouncement;

	@FindBy(xpath = "//span[contains(text(),'sample automation pdf')]")
	private WebElement lblPdfAnnouncement;

	@FindBy(xpath = "//div[@class='row']/h1")
	private WebElement lblNoAnnouncement;

	private static final Logger logger = Logger.getLogger(TutorAnnouncementPage.class.getName());

	public TutorAnnouncementPage(WebDriver driver) {
		super(driver);
		logger.info("Starting of AnnouncementPage method");

		PageFactory.initElements(driver, this);

		logger.info("Ending of AnnouncementPage method");
	}

	public void clickOnCourseFolder() {
		logger.info("Starting of clickOnCourseFolder method");

		this.clickOnWebElement(getCourse);

		logger.info("Ending of clickOnCourseFolder method");
	}

	public String getSubCategoriesLabel() {
		logger.info("Starting of getSubCategoriesLabel method");
		logger.info("Ending of getSubCategoriesLabel method");
		return lblSubCategories.getText();
	}

	public void clickOnContentIcon() {
		logger.info("Starting of clickOnContentIcon method");

		this.clickOnWebElement(mnuContentIcon);

		logger.info("Ending of clickOnContentIcon method");
	}

	public String getB2BShipmentCourseLabel() {
		logger.info("Starting of getB2BShipmentCourseLabel method");
		logger.info("Ending of getB2BShipmentCourseLabel method");
		return lblB2BShipmentCourse.getText();
	}

	public String getAddContentLabel() {
		logger.info("Starting of getAddContentLabel method");
		logger.info("Ending of getAddContentLabel method");
		return lblAddContent.getText();
	}

	public void clickOnAnnouncement() {
		logger.info("Starting of clickOnAnnouncement method");

		this.clickOnWebElement(lblAnnouncements);

		logger.info("Ending of clickOnAnnouncement method");
	}

	public void clickOnMakeAnAnnouncement() {
		logger.info("Starting of clickOnMakeAnAnnouncement method");

		try {
			this.btnMakeAnAnnouncement.click();
		} catch (Exception e) {
			this.clickOnWebElement(btnMakeAnAnnouncement);
		}

		logger.info("Ending of clickOnMakeAnAnnouncement method");
	}

	public void clickOnAnnouncementIcon() {
		logger.info("Starting of clickOnAnnouncementIcon method");

		try {
			Thread.sleep(1000);
			this.mnuAnnouncementsIcon.click();
		} catch (Exception e) {
			this.clickOnWebElement(mnuAnnouncementsIcon);
		}

		logger.info("Ending of clickOnAnnouncementIcon method");
	}

	public String getGunjanGuptaTutorLabel() {
		logger.info("Starting of getGunjanGuptaTutorLabel method");
		logger.info("Ending of getGunjanGuptaTutorLabel method");
		return lblGunjanGuptaTutor.getText();
	}

	public void clickOnMakeAnnouncement() {
		logger.info("Starting of clickOnMakeAnnouncement method");

		try {
			this.makeAnnounce.click();
		} catch (Exception e) {
			this.clickOnWebElement(makeAnnounce);
		}

		logger.info("Ending of clickOnMakeAnnouncement method");
	}

	public String getMakeAnAnnouncementLabel() {
		logger.info("Starting of getMakeAnAnnouncementLabel method");
		logger.info("Ending of getMakeAnAnnouncementLabel method");
		return lblMakeAnAnnouncement.getText();
	}

	public void clickOnMakeAnnonceText(String strText) {
		logger.info("Starting of clickOnMakeAnnonceText method");

		this.txtMakeAnnouncement.sendKeys(strText);

		logger.info("Ending of clickOnMakeAnnonceText method");
	}

	public void clickOnAttachFile() {
		logger.info("Starting of clickOnAttachFile method");
		String osPath = System.getProperty("os.name");
		if (osPath.contains("Linux")) {
			btnAttachFiles.sendKeys(TEST_FILE_PATH + "/testdata/annonceimage.jpg");
		} else {
			btnAttachFiles.sendKeys(TEST_FILE_PATH + "/testdata/annonceimage.jpg");
		}
		logger.info("Ending of clickOnAttachFile method");
	}

	public String getSendSMSLabel() {
		logger.info("Starting of clickOnSendSMSLabel method");
		logger.info("Ending of clickOnSendSMSLabel method");
		return lblSendSMS.getText();
	}

	public void clickOnAddPostButton() {
		logger.info("Starting of clickOnAddPostButton method");

		this.btnAddPost.click();

		logger.info("Ending of clickOnAddPostButton method");
	}

	public String getAnnounceAddedMessage() {
		logger.info("Starting of getAnnounceAddedMessage method");

		this.explicitWait(msgAddedAnnouncement);

		logger.info("Ending of getAnnounceAddedMessage method");
		return msgAddedAnnouncement.getText();
	}

	public void clickOnMakeAnnouncement1() {
		logger.info("Starting of clickOnMakeAnnouncement1 method");

		this.clickOnWebElement(makeAnnounce1);

		logger.info("Ending of clickOnMakeAnnouncement1 method");
	}

	public void clickOnMakePdfAnnonceText(String strText) {
		logger.info("Starting of clickOnMakePdfAnnonceText method");

		this.makePdfAnnounceText.sendKeys(strText);

		logger.info("Ending of clickOnMakePdfAnnonceText method");
	}

	public void clickOnAttachFileDoc() {
		logger.info("Starting of clickOnAttachFileDoc method");
		String osPath = System.getProperty("os.name");
		if (osPath.contains("Linux")) {
			attachFile1.sendKeys(TEST_FILE_PATH + "/testdata/annoncePdf.pdf");
		} else {
			attachFile1.sendKeys(TEST_FILE_PATH + "/testdata/annoncePdf.pdf");
		}
		logger.info("Ending of clickOnAttachFileDoc method");
	}

	public void clickOnPost1() {
		logger.info("Starting of clickOnPost1 method");

		this.postButton1.click();

		logger.info("Ending of clickOnPost1 method");
	}

	public String announceAddedMessage1() {
		logger.info("Starting of announceAddedMessage1 method");

		this.explicitWait(announceMessage1);

		logger.info("Ending of announceAddedMessage1 method");
		return this.announceMessage1.getText();
	}

	public void clickOnMakeExcelAnnouncement() {
		logger.info("Starting of clickOnMakeExcelAnnouncement method");

		try {
			this.makeExcelAnnouncement.click();
		} catch (Exception e) {
			this.clickOnWebElement(makeExcelAnnouncement);
		}

		logger.info("Ending of clickOnMakeExcelAnnouncement method");
	}

	public void clickOnMakeExcelAnnonceText(String strText) {
		logger.info("Starting of clickOnMakeAnnonceText2 method");

		this.makeExcelAnnounceText.sendKeys(strText);

		logger.info("Ending of clickOnMakeAnnonceText2 method");
	}

	public void clickOnAttachFileExcel() {
		logger.info("Starting of clickOnAttachFileExcel method");
		String osPath = System.getProperty("os.name");
		if (osPath.contains("Linux")) {
			attachFile1.sendKeys(TEST_FILE_PATH + "/testdata/announceExcel(naukri TC).xlsx");
		} else {
			attachFile1.sendKeys(TEST_FILE_PATH + "/testdata/announceExcel(naukri TC).xlsx");
		}
		logger.info("Ending of clickOnAttachFileExcel method");
	}

	public void clickOnPost2() {
		logger.info("Starting of clickOnPost2 method");

		this.postButton2.click();

		logger.info("Ending of clickOnPost2 method");
	}

	public String announceAddedMessage2() {
		logger.info("Starting of announceAddedMessage2 method");

		this.explicitWait(announceMessage2);

		logger.info("Ending of announceAddedMessage2 method");
		return this.announceMessage2.getText();
	}

	public void clickOnThreeDottedMenu() {
		logger.info("Starting of clickOnThreeDottedMenu method");

		this.clickOnWebElement(mnuHorizontalIcon);

		logger.info("Ending of clickOnThreeDottedMenu method");
	}

	public void clickOnEditIcon() {
		logger.info("Starting of clickOnEditIcon method");

		this.clickOnWebElement(mnuEditIcon);

		logger.info("Ending of clickOnEditIcon method");
	}

	public void clickOnEditMakeAnnonceText(String strText) {
		logger.info("Starting of clickOnEditMakeAnnonceText method");

		this.txtEditAnnouncement.clear();
		this.txtEditAnnouncement.sendKeys(strText);

		logger.info("Ending of clickOnEditMakeAnnonceText method");
	}

	public void clickOnEditPostButton() {
		logger.info("Starting of clickOnEditPostButton method");

		this.btnEditPost.click();

		logger.info("Ending of clickOnEditPostButton method");
	}

	public String getAnnouncementEditedMessage() {
		logger.info("Starting of getAnnouncementEditedMessage method");

		this.explicitWait(msgEditedAnnouncement);

		logger.info("Ending of getAnnouncementEditedMessage method");
		return msgEditedAnnouncement.getText();
	}

	public void clickOnPdfThreeHorizontalDottedMenu() {
		logger.info("Starting of clickOnThreeHorizontalDottedMenu method");

		this.hardWait(5);
		this.mnuPdfHorizontalIcon.click();

		logger.info("Ending of clickOnThreeHorizontalDottedMenu method");
	}

	public void clickOnImageThreeHorizontalDottedMenu() {
		logger.info("Starting of clickOnThreeHorizontalDottedMenu method");

		this.explicitWait(mnuImageHorizontalIcon);
		this.mnuImageHorizontalIcon.click();

		logger.info("Ending of clickOnThreeHorizontalDottedMenu method");
	}

	public void clickOnRemoveIcon() {
		logger.info("Starting of clickOnRemoveIcon method");

		try {
			Thread.sleep(1000);
			this.mnuRemoveIcon.click();
		} catch (Exception e) {
			this.clickOnWebElement(mnuRemoveIcon);
		}

		logger.info("Ending of clickOnRemoveIcon method");
	}

	public String getDeleteAnnouncementLabel() {
		logger.info("Starting of getDeleteAnnouncementLabel method");
		logger.info("Ending of getDeleteAnnouncementLabel method");
		return lblDeleteAnnouncement.getText();
	}

	public void clickOnDeleteButton() {
		logger.info("Starting of clickOnDeleteButton method");

		try {
			this.btnDelete.click();
		} catch (Exception e) {
			this.clickOnWebElement(btnDelete);
		}

		logger.info("Ending of clickOnDeleteButton method");
	}

	public String getCourseNameLabel() {
		logger.info("Starting of getAnnounceAddedMessage method");

		this.explicitWait(lblCourseNameTitle);

		logger.info("Ending of getAnnounceAddedMessage method");
		return lblCourseNameTitle.getText();
	}

	public String getDeleteAnnouncementHeadingLabel() {
		logger.info("Starting of getAnnounceAddedMessage method");

		this.explicitWait(lblDeleteAnnouncementHeading);

		logger.info("Ending of getAnnounceAddedMessage method");
		return lblDeleteAnnouncementHeading.getText();
	}

	public String getDeleteAnnouncementText() {
		logger.info("Starting of getAnnounceAddedMessage method");

		this.explicitWait(lblDeleteAnnouncementText);

		logger.info("Ending of getAnnounceAddedMessage method");
		return lblDeleteAnnouncementText.getText();
	}

	public void setSearch(String strSearch) {
		logger.info("Starting of setSearch method");

		this.explicitWait(txtSearch);
		this.txtSearch.sendKeys(Keys.CONTROL + "a");
		this.txtSearch.sendKeys(Keys.DELETE);

		this.txtSearch.sendKeys(strSearch);

		logger.info("Ending of setSearch method");
	}

	public String getExcelAnnouncementLabel() {
		logger.info("Starting of getExcelAnnouncementLabel method");

		this.explicitWait(lblExcelAnnouncement);

		logger.info("Ending of getExcelAnnouncementLabel method");
		return lblExcelAnnouncement.getText();
	}

	public void clearSearch() {
		logger.info("Starting of clearSearch method");

		this.txtSearch.click();
		this.txtSearch.sendKeys(Keys.CONTROL + "a");
		this.txtSearch.sendKeys(Keys.DELETE);

		logger.info("Ending of clearSearch method");
	}

	public String getPdfAnnouncementLabel() {
		logger.info("Starting of getPdfAnnouncementLabel method");

		this.explicitWait(lblPdfAnnouncement);

		logger.info("Ending of getPdfAnnouncementLabel method");
		return lblExcelAnnouncement.getText();
	}

	public String getNoAnnouncementText() {
		logger.info("Starting of getPdfAnnouncementLabel method");

		this.explicitWait(lblNoAnnouncement);

		logger.info("Ending of getPdfAnnouncementLabel method");
		/*
		 * String span = "some text, param1:'1123',some text, param2:'3444';"; Pattern p
		 * = Pattern.compile(Pattern.quote("'") + "(.*?)" + Pattern.quote("'")); Matcher
		 * m = p.matcher(span); while (m.find()) { System.out.println(m.group(1)); }
		 */
		String s = lblNoAnnouncement.getText().substring(0, 7);

		String ss = lblNoAnnouncement.getText().substring(8);

		return s+ss;
	}

}