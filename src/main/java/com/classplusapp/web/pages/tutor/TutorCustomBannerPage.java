package com.classplusapp.web.pages.tutor;

import java.io.File;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import com.classplusapp.web.pages.BaseClassplusAutomationPage;

public class TutorCustomBannerPage extends BaseClassplusAutomationPage {

	@FindBy(xpath = "//span[@style='position: relative; height: 12px; line-height: 12px; border-radius: 2px; cursor: pointer; margin-bottom: 8px; top: 2px; font-size: 9px; color: rgb(250, 251, 233); background: rgb(255, 64, 88); padding: 0px 5px;']")
	private WebElement newIcon;

	@FindBy(xpath = "//div[contains(text(),'Show banners to students on your app')]")
	private WebElement lblShowBanners;

	@FindBy(xpath = "//input[@type='file']")
	private WebElement btnUploadBannerImage;

	@FindBy(xpath = "//button[text()='Publish']")
	private WebElement btnPublish;

	@FindBy(xpath = "//div[contains(text(),'Publish Confirmation')]")
	private WebElement lblPublishConfirmation;

	@FindBy(xpath = "//button[contains(text(),'Yes, Publish')]")
	private WebElement btnYesPublish;

	@FindBy(xpath = "//div[contains(text(),'Banners updated successfully on your app')]")
	private WebElement msgBannerUpdated;

	@FindBy(xpath = "(//div[@class='Banner__Main__Left__Content__ImageSection--Select--Action--Change'])[1]")
	private WebElement btnChange;

	@FindBy(xpath = "//div[contains(text(),'Select Landing Screen')]")
	private WebElement lblSelectLandingScreen;

	@FindBy(xpath = "(//div[@class=\"Banner__Main__Left__Content__ImageSection--Select__SelectModal--Body--OptionArea--Option\"]//div)[2]")
	private WebElement rdoStoreTab;

	@FindBy(xpath = "//div[contains(text(),'Done')]")
	private WebElement btnDoneForStoreTab;

	@FindBy(xpath = "(//div[@class=\"Banner__Main__Left__Content__ImageSection--Select__SelectModal--Body--OptionArea--Option\"]//div)[3]")
	private WebElement rdoSpecificCourses;

	@FindBy(xpath = "//div[contains(text(),'Select Course(s)')]")
	private WebElement SelectCourseDropDown;

	@FindBy(xpath = "//div[contains(text(),'Selected Course(s)- ')]")
	private WebElement lblSelectedCourses;

	@FindBy(xpath = "//input[@placeholder=\"Search for a course\"]")
	private WebElement txtSearchCourseField;

	@FindBy(xpath = "//div[contains(text(),\"Sampling 1\")]")
	private WebElement chkSampling6;

	@FindBy(xpath = "//div[@class=\"CourseTab__Bottom--Done\"]")
	private WebElement btnDoneForSpecificCourse;

	@FindBy(xpath = "//div[@class=\"Banner_MainLeftContentImageSection--Select_SelectModal--Bottom--Done\"]")
	private WebElement btnDone;

	@FindBy(xpath = "//div[contains(text(),'Category of Courses')]")
	private WebElement rdoCategoryOfCourses;

	/*
	 * @FindBys(@FindBy(xpath = "(//div[@class='item'])[13]")) private
	 * List<WebElement> categoryOption;
	 */

	@FindBys(@FindBy(xpath = "//div[@class=\"ui fluid search selection dropdown\"]/input"))
	private List<WebElement> categoryOption;

	@FindBys(@FindBy(xpath = "//span[contains(text(),'NCERT(1)')]"))
	private List<WebElement> pickCategoryDropdown;

	@FindBy(xpath = "//div[contains(text(),\"Done\")]")
	private WebElement btnDoneForCategoryOfCourse;

	@FindBy(xpath = " //div[contains(text(),'External Link')]")
	private WebElement rdoExternalLink;

	@FindBy(xpath = "//input[@class=\"InputField\"]")
	private WebElement txtExernalLink;

	@FindBy(xpath = "//div[contains(text(),'Done')]")
	private WebElement btnDoneForExternalLink;

	@FindBy(xpath = "//div[contains(text(),'Youtube Video')]")
	private WebElement rdoYoutubeVideo;

	@FindBy(xpath = "//input[@class='InputField']")
	private WebElement txtYouTubeLink;

	@FindBy(xpath = "//div[contains(text(),'Done')]")
	private WebElement btnDoneforYoutubeVideo;

	@FindBy(xpath = "(//div[@class=\"Banner__Main__Left__Content__ImageSection--Select__SelectModal--Body--OptionArea--Option\"]//div)[7]")
	private WebElement rdoFreeCourseMaterial;

	@FindBy(xpath = "//div[contains(text(),'Done')]")
	private WebElement btnDoneForFreeCourseMaterial;

	// reordered images

	@FindBy(xpath = "//div[@class='Banner__Main__Left__Top--Reorder']")
	private WebElement btnReorderBanners;

	@FindBy(xpath = "/div[contains(text(),'Reorder banners')]")
	private WebElement lblReorderBanners;

	@FindBys({ @FindBy(xpath = "//div[@aria-roledescription='Draggable item. Press space bar to lift']") })
	private List<WebElement> draggableImages;

	@FindBy(xpath = "//button[contains(text(),'Save')]")
	private WebElement btnSave;

	@FindBys({ @FindBy(xpath = "//button[@class='Banner__Main__Left__Content__ImageSection--Top--Remove']")})
	private List<WebElement> btnRemove;

	@FindBy(xpath = "//div[contains(text(),'Remove Confirmation')]")
	private WebElement lblRemoveConfirmation;

	@FindBy(xpath = "//button[@class='Confirmation__Modal__Bottom--Accept']")
	private WebElement btnRemoveConfirmation;

	@FindBy(xpath = "//div[contains(text(),'Removed banner image, please publish your changes')]")
	private WebElement msgRemoveImageSuccess;

	@FindBy(xpath = "(//button[@class=\"Banner_MainLeftContent_ImageSection--Top--Remove\"])[1]")
	private WebElement btnRemove2;

	@FindBy(xpath = "//button[@class='Confirmation_Modal_Bottom--Accept']")
	private WebElement btnRemoveConfirmation2;

	@FindBy(xpath = "//div[contains(text(),'Removed banner image, please publish your changes')]")
	private WebElement msgRemoveImageSuccess2;

	@FindBy(xpath = "(//button[@class=\"Banner_MainLeftContent_ImageSection--Top--Remove\"])[1]")
	private WebElement btnRemove3;

	@FindBy(xpath = "//button[@class='Confirmation_Modal_Bottom--Accept']")
	private WebElement btnRemoveConfirmation3;

	@FindBy(xpath = "//div[contains(text(),'Removed banner image, please publish your changes')]")
	private WebElement msgRemoveImageSuccess3;

	@FindBy(xpath = "(//button[@class=\"Banner_MainLeftContent_ImageSection--Top--Remove\"])[1]")
	private WebElement btnRemove4;

	@FindBy(xpath = "//button[@class='Confirmation_Modal_Bottom--Accept']")
	private WebElement btnRemoveConfirmation4;

	@FindBy(xpath = "//div[contains(text(),'Removed banner image, please publish your changes')]")
	private WebElement msgRemoveImageSuccess4;

	@FindBy(xpath = "(//button[@class=\"Banner_MainLeftContent_ImageSection--Top--Remove\"])[1]")
	private WebElement btnRemove5;

	@FindBy(xpath = "//button[@class='Confirmation_Modal_Bottom--Accept']")
	private WebElement btnRemoveConfirmation5;

	@FindBy(xpath = "//div[contains(text(),'Removed banner image, please publish your changes')]")
	private WebElement msgRemoveImageSuccess5;

	@FindBy(xpath = "(//button[@class=\"Banner_MainLeftContent_ImageSection--Top--Remove\"])[1]")
	private WebElement btnRemove6;

	@FindBy(xpath = "//button[@class='Confirmation_Modal_Bottom--Accept']")
	private WebElement btnRemoveConfirmation6;

	@FindBy(xpath = "//div[contains(text(),'Removed banner image, please publish your changes')]")
	private WebElement msgRemoveImageSuccess6;

	@FindBy(xpath = "//button[contains(text(),'Publish')]")
	private WebElement btnPublish1;

	@FindBy(xpath = "//button[contains(text(),'Yes, Publish')]")
	private WebElement btnYesPublish1;

	
	@FindBy(xpath = "(//div[contains(@class,'toastr')]//div[@class='rrt-title'])[last()]")
	private WebElement msgBannersRemoved;
	
	
	@FindBy(xpath = "//div[@class=\"Banner__Main__Left__Top--Reorder\"]")
	private WebElement reorderBanner;
	
	@FindBy(xpath = "//div[@class=\"Reorder__Modal\"]//img[2]")
	private List<WebElement> imgList;
	
	@FindBy(id ="ChangeIcon")
	private WebElement hoverImage;
	
	@FindBy(css ="#ChangeIcon div")
	private WebElement icon_change;
	
	@FindBy(xpath ="//div[contains(@class,'ToggleSection--Switch')]")
	private WebElement toggle;
	
	private static final Logger logger = Logger.getLogger(TutorCustomBannerPage.class.getName());

	public TutorCustomBannerPage(WebDriver driver) {
		super(driver);
		logger.info("Starting of CustomBannerPage method");
		PageFactory.initElements(driver, this);
		logger.info("Ending of CustomBannerPage method");

	}

	public void clickOnNewIcon() {
		logger.info("Starting of clickOnNewIcon method");
		try {
			Thread.sleep(1000);
			this.newIcon.click();
		} catch (Exception e) {
			this.clickOnWebElement(newIcon);
		}
		logger.info("Ending of clickOnNewIcon method");

	}

	public String getYourBannersLabel() {
		logger.info("Starting of getYourBannersLabel method");
		logger.info("Ending of getYourBannersLabel method");
		return lblShowBanners.getText();
	}

	public void clickOnUploadBannerImage(String filepath) {
		logger.info("starting of clickOnUploadBannerImage method");

		for (int i = 0; i < 3; i++) {
			String s=String.valueOf(i);  
			btnUploadBannerImage.sendKeys(filepath + "bannerImg_"+s + ".jpg" );
//			
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		logger.info("Ending of clickOnUploadBannerImage method");
	}

	public void clickOnPublish() {
		logger.info("starting of clickOnPublish method");

		try {
			Thread.sleep(1000);
			this.btnPublish.click();
		} catch (Exception e) {
			this.clickOnWebElement(btnPublish);
		}
		logger.info("Ending of clickOnPublish method");
	}

	public String getPublishConfirmationLabel() {
		logger.info("Starting of getYourBannersLabel method");
		logger.info("Ending of getYourBannersLabel method");

		return lblPublishConfirmation.getText();
	}

	public void clickOnYesPublish() {
		logger.info("starting of clickOnPublish method");

		try {
//			Thread.sleep(1000);
			explicitWait(btnYesPublish);
			this.btnYesPublish.click();

		} catch (Exception e) {
			this.clickOnWebElement(btnYesPublish);
		}

		logger.info("Ending of clickOnPublish method");
	}

	public String getUpdatedBannersMessage() {
		logger.info("Starting of getUpdatedBannersMessage method");
		
		this.explicitWait(msgBannerUpdated);
		
		logger.info("Ending of getUpdatedBannersMessage method");
		return msgBannerUpdated.getText();
	}

	public void clickOnChangeButton() {
		logger.info("starting of clickOnChangeButton method");

		this.btnChange.click();

		logger.info("Ending of clickOnChangeButton method");
	}
	
	

	public String getSelectLandingScreenLabel() {
		logger.info("Starting of getSelectLandingScreenLabel method");
		logger.info("Ending of getSelectLandingScreenLabel method");
		return lblSelectLandingScreen.getText();
	}

	public void clickOnStoreTab() {
		logger.info("starting of clickOnStoreTab method");

		this.rdoStoreTab.click();

		logger.info("Ending of clickOnStoreTab method");
	}

	public void clickDoneForStoreTab() {
		logger.info("Starting of clickDoneForStoreTab method");

		this.clickOnWebElement(btnDoneForStoreTab);

		logger.info("Ending of clickDoneForStoreTab method");
	}

	public void clickOnSpecificCourses() {
		logger.info("starting of clickOnSpecificCourses method");

		this.rdoSpecificCourses.click();

		logger.info("Ending of clickOnSpecificCourses method");
	}

	public void clickSelectCourse() {
		logger.info("Starting of selectCourse method");

		this.SelectCourseDropDown.click();

		logger.info("Ending of selectCourse method");
	}

	public String getSelectedCoursesLabel() {
		logger.info("Starting of getSelectedCoursesLabel method");
		logger.info("Ending of getSelectedCoursesLabel method");
		return lblSelectedCourses.getText();
	}

	public void validateSearchCourse(String strCourse) {
		logger.info("Starting of validateSearchCourse method");

		this.txtSearchCourseField.sendKeys(strCourse);

		logger.info("Ending of validateSearchCourse method");
	}

	public void clickOnCheckBoxOfSampling6() {
		logger.info("Starting of clickOnCheckBoxOfSampling6 method");

		try {
			this.chkSampling6.click();
		} catch (Exception e) {
			clickOnWebElement(chkSampling6);
		}

		logger.info("Ending of clickOnCheckBoxOfSampling6 method");
	}

	public void clickOnDoneButton() {
		logger.info("Starting of clickDoneButton method");

		this.clickOnWebElement(btnDoneForSpecificCourse);

		logger.info("Ending of clickDoneButton method");
	}

	public void clickDone() {
		logger.info("Starting of clickDone method");

		this.clickOnWebElement(btnDone);

		logger.info("Ending of clickDone method");
	}

	public void clickOnCategoryOfCourses() {
		logger.info("starting of clickOnCategoryOfCourses method");

		this.rdoCategoryOfCourses.click();

		logger.info("Ending of clickOnCategoryOfCourses method");
	}

	public void clickOnPickCategoryDropDown() {
		logger.info("starting of clickOnPickCategoryDropDown method");

		this.explicitWait(categoryOption);
		this.explicitWait(pickCategoryDropdown);
		this.pickFromWebElemetList(categoryOption, pickCategoryDropdown, "NCERT(1)");

		logger.info("Ending of clickOnPickCategoryDropDown method");
	}

	public void clickOnDone() {
		logger.info("starting of clickOnDone method");

		this.clickOnWebElement(btnDoneForCategoryOfCourse);

		logger.info("Ending of clickOnDone method");
	}

	public void clickOnExternalLink() {
		logger.info("Starting of clickOnExternalLink method");

		this.rdoExternalLink.click();

		logger.info("Ending of clickOnExternalLink method");
	}

	public void enterLinkInField(String strLink) {
		logger.info("Starting of enterLinkInField method");

		this.txtExernalLink.sendKeys(strLink);

		logger.info("Ending of enterLinkInField method");
	}

	public void clickOnDoneForExternalLink() {
		logger.info("starting of clickOnDoneForExternalLink method");

		this.clickOnWebElement(btnDoneForExternalLink);
		logger.info("Ending of clickOnDoneForExternalLink method");
	}

	public void clickOnYoutubeVideo() {
		logger.info("Starting of clickOnYoutubeVideo method");

		this.rdoYoutubeVideo.click();

		logger.info("Ending of clickOnYoutubeVideo method");
	}

	public void setYoutubeLink(String strYoutubeLink) {
		logger.info("Starting of setYoutubeLink method");

		this.txtYouTubeLink.sendKeys(strYoutubeLink);

		logger.info("Ending of setYoutubeLink method");
	}

	public void clickOnDoneForYoutubeVideo() {
		logger.info("starting of clickOnDoneForYoutubeVideo method");

		this.clickOnWebElement(btnDoneforYoutubeVideo);

		logger.info("Ending of clickOnDoneForYoutubeVideo method");
	}

	public void clickOnFreeMaterial() {
		logger.info("Starting of clickOnFreeMaterial method");

		this.rdoFreeCourseMaterial.click();

		logger.info("Ending of clickOnFreeMaterial method");
	}

	public void clickOnDoneForFreeCourseMaterial() {
		logger.info("starting of clickOnMaterialDone method");

		this.clickOnWebElement(btnDoneForFreeCourseMaterial);

		logger.info("Ending of clickOnMaterialDone method");
	}
	
	public void clickOnReorderMethod() {
		logger.info("starting of clickOnTestReorderMethod method");

		this.reorderBanner.click();
		List<WebElement> imagesList = this.imgList;
//		System.out.println(imagesList[0]);
		for(WebElement item : imagesList) {
			String name = item.getText();
			System.out.println(name);
			System.out.println("------------------------------------------------------------------>");
		}
		this.dragAndSort(imagesList,0,2);
		logger.info("Ending of clickOnTestReorderMethod method");
	}

	public void clickOnReorderBanners() {
		logger.info("strating of clickOnReorderBanners method");

		this.btnReorderBanners.click();
//		List<WebElement> elements = imgList;

		logger.info("Ending of clickOnReorderBanners method");
	}

	public String getReorderBannersLabel() {
		logger.info("Starting of getSelectedCoursesLabel method");
		logger.info("Ending of getSelectedCoursesLabel method");

		return lblReorderBanners.getText();
	}

	public void reorderImages(String secondIndex, String firstIndex) {
		logger.info("Starting of draggableElements method");
		
		try {
			this.dragAndSort(draggableImages, Integer.parseInt(secondIndex), Integer.parseInt(firstIndex));
		} catch (Exception e) {
		}
		
		logger.info("Ending of draggableElements method");
	}

	public void clickOnSaveButton() {
		logger.info("Starting of clickOnSaveButton method");
	
		try {
			this.btnSave.click();
		} catch (Exception e) {
			this.clickOnWebElement(btnSave);
		}

		logger.info("Ending of clickOnSaveButton method");
	}

	public void clickOnRemoveButton() {
		logger.info("Starting of clickOnRemoveButton1 method");
		
		try {
			this.btnRemove.get(0).click();
		} catch (Exception e) {
			this.clickOnWebElement(btnRemove.get(0));
		}

		logger.info("Ending of clickOnRemoveButton1 method");
	}

	
	public int getListOfRemoveBanners()
	{
		return btnRemove.size();
	}
	public String getRemoveConfirmationLabel() {
		logger.info("Starting of getRemoveConfirmationLabel method");
		logger.info("Ending of getRemoveConfirmationLabel method");

		return lblRemoveConfirmation.getText();
	}

	public void clickOnRemoveConfirmationButton() {
		logger.info("Starting of clickOnRemoveConfirmationButton method");
		try {
			Thread.sleep(1000);
			this.btnRemoveConfirmation.click();
		} catch (Exception e) {
			this.clickOnWebElement(btnRemoveConfirmation);
		}

		logger.info("Ending of clickOnRemoveConfirmationButton method");
	}

	public String getImageRemovedSuccessMessage() {
		logger.info("Starting of getImageRemovedSuccessMessage method");
		logger.info("Ending of getImageRemovedSuccessMessage method");

		return msgRemoveImageSuccess.getText();
	}

	public void clickOnRemoveButton2() {
		logger.info("Starting of clickOnRemoveButton2 method");

		this.btnRemove2.click();

		logger.info("Ending of clickOnRemoveButton2 method");
	}

	public void clickOnRemoveConfirmationButton2() {
		logger.info("Starting of clickOnRemoveConfirmationButton2 method");

		this.btnRemoveConfirmation2.click();

		logger.info("Ending of clickOnRemoveConfirmationButton2 method");
	}

	public String getImageRemovedSuccessMessage2() {
		logger.info("Starting of getImageRemovedSuccessMessage2 method");
		logger.info("Ending of getImageRemovedSuccessMessage2 method");
		return msgRemoveImageSuccess2.getText();
	}

	public void clickOnRemoveButton3() {
		logger.info("Starting of clickOnRemoveButton3 method");

		this.btnRemove3.click();

		logger.info("Ending of clickOnRemoveButton3 method");
	}

	public void clickOnRemoveConfirmationButton3() {
		logger.info("Starting of clickOnRemoveConfirmationButton3 method");

		this.btnRemoveConfirmation3.click();

		logger.info("Ending of clickOnRemoveConfirmationButton3 method");
	}

	public String getImageRemovedSuccessMessage3() {
		logger.info("Starting of getImageRemovedSuccessMessage3 method");

		this.explicitWait(msgRemoveImageSuccess3);
		logger.info("Ending of getImageRemovedSuccessMessage3 method");
		return msgRemoveImageSuccess3.getText();
	}

	public void clickOnRemoveButton4() {
		logger.info("Starting of clickOnRemoveButton4 method");

		this.btnRemove4.click();

		logger.info("Ending of clickOnRemoveButton4 method");
	}

	public void clickOnRemoveConfirmationButton4() {
		logger.info("Starting of clickOnRemoveConfirmationButton4 method");

		this.btnRemoveConfirmation4.click();

		logger.info("Ending of clickOnRemoveConfirmationButton4 method");
	}

	public String getImageRemovedSuccessMessage4() {
		logger.info("Starting of getImageRemovedSuccessMessage4 method");

		this.explicitWait(msgRemoveImageSuccess4);
		logger.info("Ending of getImageRemovedSuccessMessage4 method");
		return msgRemoveImageSuccess4.getText();
	}

	public void clickOnRemoveButton5() {
		logger.info("Starting of clickOnRemoveButton5 method");

		this.btnRemove5.click();

		logger.info("Ending of clickOnRemoveButton5 method");
	}

	public void clickOnRemoveConfirmationButton5() {
		logger.info("Starting of clickOnRemoveConfirmationButton5 method");

		this.btnRemoveConfirmation5.click();

		logger.info("Ending of clickOnRemoveConfirmationButton5 method");
	}

	public String getImageRemovedSuccessMessage5() {
		logger.info("Starting of getImageRemovedSuccessMessage5 method");

		this.explicitWait(msgRemoveImageSuccess5);
		logger.info("Ending of getImageRemovedSuccessMessage5 method");
		return msgRemoveImageSuccess5.getText();
	}

	public void clickOnRemoveButton6() {
		logger.info("Starting of clickOnRemoveButton6 method");

		this.btnRemove6.click();

		logger.info("Ending of clickOnRemoveButton6 method");
	}

	public void clickOnRemoveConfirmationButton6() {
		logger.info("Starting of clickOnRemoveConfirmationButton6 method");

		this.btnRemoveConfirmation6.click();

		logger.info("Ending of clickOnRemoveConfirmationButton6 method");
	}

	public String getImageRemovedSuccessMessage6() {
		logger.info("Starting of getImageRemovedSuccessMessage6 method");

		this.explicitWait(msgRemoveImageSuccess6);
		logger.info("Ending of getImageRemovedSuccessMessage6 method");
		return msgRemoveImageSuccess6.getText();
	}

	public void clickOnPublishButton() {
		logger.info("starting of clickOnPublishButton method");

		this.clickOnWebElement(btnPublish1);

		logger.info("Ending of clickOnPublishButton method");
	}

	public void clickOnYesPublishButton() {
		logger.info("starting of clickOnYesPublishButton method");

		this.btnYesPublish1.click();

		logger.info("Ending of clickOnYesPublishButton method");
	}

	public String getPublishConformationRemoveMessage() {
		logger.info("Starting of getPublishConformationMessage method");
		logger.info("Ending of getPublishConformationMessage method");
		return msgBannersRemoved.getText();
	}
	
	
	public void changeBannerImage()
	{
		logger.info("Starting of changeBannerImage method");
		
		Actions action= new Actions(driver);
		action.moveToElement(hoverImage).perform();
		this.icon_change.click();
		this.uploadFile(TEST_FILE_PATH + "\\testdata\\annonceimage.jpg");	
		
		logger.info("Ending of changeBannerImage method");
	}
	
//	public void clickScheduleToogle()
//	{
//		if(this.toggle.isSelected())
//	}
//	
	
}