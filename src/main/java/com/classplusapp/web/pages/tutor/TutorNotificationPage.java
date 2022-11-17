
package com.classplusapp.web.pages.tutor;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import com.classplusapp.web.pages.BaseClassplusAutomationPage;

public class TutorNotificationPage extends BaseClassplusAutomationPage{

	@FindBy(xpath = "//*[@id=\"NotificationBellIcon\"]")
	private WebElement notificationIcon;
	
	@FindBy(xpath = "//span[@class=\"ml-3 notificationText-right\"]")
	private WebElement createOption;
	
	@FindBy(xpath = "//div[@class=\"cursorPointer pt-1\"]")
	private WebElement toPlusBtn;
	
	@FindBy(xpath = "(//div[@class=\"radioButtonContainer\"])[2]")
	private WebElement allNewAppDownloadBtn;
	
	@FindBy(xpath = "(//button[@class=\"panelFooter-send\"])[2]")
	private WebElement doneBtn;
			
	@FindBy(xpath = "//input[@placeholder=\"Enter notification title here\"]")
	private WebElement titleArea;
	
	@FindBy(xpath = "//textarea[@placeholder=\"Enter notification text here\"]")
	private WebElement textArea;
	
	@FindBy(xpath = "(//div[@class=\"panel-body-addImageBox mt-3 image-button-width\"])[1]")
	private WebElement selectFromLibraryBtn;
	
	@FindBy(xpath = "(//div[@class=\"ImageCard_CardItem__OGOZJ\"])[1]")
	private WebElement img1;
	
	@FindBy(xpath = "//button[@class=\"List_SelectButton__30oKG\"]")
	private WebElement selectImageBtn;
	
	
	@FindBy(xpath = "(//input[@id=\"uploadNotificationImage\"]")
	private WebElement addImageBtn;
	
	@FindBy(xpath = "//div[@class=\"panel-body-landing-screen-text\"]")
	private WebElement landingScreenBtn;
	
	@FindBy(xpath = "//input[@id=\"SCREEN_HOME\"]")
	private WebElement homeScreenBtn;
	
	
	@FindBy(xpath = "(//button[@class=\"panelFooter-send\"])[2]")
	private WebElement doneBtnForlanding;
	
	@FindBy(xpath = "//label[@for=\"notificationSchedule\"]")
	private WebElement ScheduleForLaterBtn;
	
	@FindBy(xpath = "//input[@placeholder=\"Select date\"]")
	private WebElement dateBtn;
	
	@FindBy(xpath = "//input[@placeholder=\"Select time\"]")
	private WebElement timeBtn;
	
	@FindBy(xpath = "//button[@class=\"panelFooter-send\"]")
	private WebElement scheduleBtn;
	
	//span[@class="notificationTypePanel_SeeAllText"]
	@FindBy(xpath = "//span[@class=\"notificationTypePanel_SeeAllText\"]")
	private WebElement seeAll;
	
	@FindBy(xpath = "(//span[contains(text(),'Scheduled')])[2]")
	private WebElement scheduledBtn;
	
	@FindBy(xpath = "(//span[@class=\"notificationTypePanel_Element selectedPanel\"])[2]")
	private WebElement sentBtn;
	
	@FindBy(xpath = "//i[@class=\"ellipsis vertical icon float-right cursorPointer\"]")
	private List<WebElement> Notifications;
	
	@FindBy(xpath = "//div[@class=\"ellipseDownElement\"][1]")
	private WebElement shareOnWhatasappBtn ;
	
	@FindBy(xpath = "//div[@class=\"ellipseDownElement\"][2]")
	private WebElement deleteBtn ;
	
	@FindBy(xpath = "//div[@class=\"ellipseDownElement\"][3]")
	private WebElement editBtn ;
	
	@FindBy(xpath = "(//div[contains(@class,'toastr')]//div[@class='rrt-title'])[last()]")
	private WebElement successMessage;
	
	@FindBy(xpath = "(//div[contains(@class,'toastr')]//div[@class='rrt-text'])[last()]")
	private WebElement textSuccessMessage;
	
	
	@FindBy(xpath = "(//div[@class='notificationScreen-Panel']//div//span)[last()]")
	private WebElement scheduledLabel;
	
	@FindBy(xpath = "(//div[@class=\"notificationCard-component notificationCard-text notificationCard-option\"]//span)[1]")
	private WebElement sentNotificationTitle;
	
	@FindBy(xpath = "(//div[@class=\"notificationCard-component notificationCard-text notificationCard-option\"]//span)[2]")
	private WebElement sentNotificationDescription;
	
	@FindBys({@FindBy(xpath = "//div[@class='notificationCard-component notificationCard-text notificationCard-option']//span[@class='notificationCard-title']")})
	private List<WebElement> scheduledTitle;
	
	@FindBys({@FindBy(xpath = "//div[@class='notificationCard-component notificationCard-text notificationCard-option']//span[2]")})
	private List<WebElement> scheduledDescription;
	

	private static final Logger logger = Logger.getLogger(TutorNotificationPage.class.getName());
	
	public TutorNotificationPage(WebDriver driver) {
		super(driver);
		logger.info("Starting of TutorNotificationPage method");
		PageFactory.initElements(driver, this);
		logger.info("Ending of TutorNotificationPage method");
	}
	
	public String getSuccessMessage() {
		logger.info("Starting of getSuccessMessage method");
		logger.info("Ending of getSuccessMessage method");
		try {
			Thread.sleep(2000);}catch(Exception e) {}
		System.out.println(successMessage.getText());
		return successMessage.getText();
	}
	
	public String getTextSuccessMessage() {
		logger.info("Starting of getTextSuccessMessage method");
		logger.info("Ending of getTextSuccessMessage method");
		try {
			Thread.sleep(2000);}catch(Exception e) {}
		return textSuccessMessage.getText();
	}
	
	public void clickOnNotifiacitonIcon() {
		logger.info("Starting of clickOnNotifiacitonIcon method");
		try {
			Thread.sleep(2000);
			this.explicitWait(notificationIcon);
			this.notificationIcon.click();
		} catch (Exception e) {
			this.clickOnWebElement(notificationIcon);
		}
		logger.info("Ending of clickOnNotifiacitonIcon method");
	}
	
	public void clickOnCreateOption() {
		logger.info("Starting of clickOnCreateOption method");
		try {
			Thread.sleep(1000);
			this.createOption.click();
		} catch (Exception e) {
			this.clickOnWebElement(createOption);
		}
		logger.info("Ending of clickOnCreateOption method");
	}
	
	public void clickOnToPlusBtn() {
		logger.info("Starting of clickOnToPlusBtn method");
		try {
			Thread.sleep(1000);
			this.toPlusBtn.click();
			this.allNewAppDownloadBtn.click();
			this.doneBtn.click();
		} catch (Exception e) {
			this.clickOnWebElement(toPlusBtn);
			this.clickOnWebElement(allNewAppDownloadBtn);
			this.clickOnWebElement(doneBtn);
		}
		logger.info("Ending of clickOnToPlusBtn method");
	}
	
	public void sendTitle(String title) {
		logger.info("Starting of sendTitle method");
		this.titleArea.sendKeys(title);
		logger.info("Ending of sendTitle method");
	}
	
	public void sendText(String text) {
		logger.info("Starting of sendText method");
		this.textArea.sendKeys(text);
		logger.info("Ending of sendText method");
	}
	
	public void selectFromLibray() {
		logger.info("Starting of selectFromLibray method");
		try {
			Thread.sleep(1000);
			this.selectFromLibraryBtn.click();
			explicitWait(img1);
			this.img1.click();
			scrollIntoView(selectImageBtn);
			this.selectImageBtn.click();
		} catch (Exception e) {
			this.clickOnWebElement(selectFromLibraryBtn);
			this.clickOnWebElement(img1);
			this.clickOnWebElement(selectImageBtn);
		}
		logger.info("Ending of selectFromLibray method");
	}
	
	
	public void addImage(String path) {
		logger.info("Starting of addImage method");
		this.addImageBtn.sendKeys(path);
		logger.info("Ending of addImage method");
	}
	
	public void selectDate() {
		logger.info("Starting of selectDate method");
		this.ScheduleForLaterBtn.click();
//		this.dateBtn.clear();
		if(System.getProperty("os.name").contains("Mac")) {
			this.dateBtn.sendKeys(Keys.COMMAND+"A");
			this.dateBtn.sendKeys(Keys.DELETE);
		}else {
		this.dateBtn.sendKeys(Keys.CONTROL+"A");
		this.dateBtn.sendKeys(Keys.DELETE);}
		this.dateBtn.sendKeys("16-03-2023");
		logger.info("Ending of selectDate method");
	}
	
	public void selectTime() {
		logger.info("Starting of selectTime method");
		if(System.getProperty("os.name").contains("Mac")) {
			this.timeBtn.sendKeys(Keys.COMMAND+"A");
			this.timeBtn.sendKeys(Keys.DELETE);
		}else {
		this.timeBtn.sendKeys(Keys.CONTROL+"A");
		this.timeBtn.sendKeys(Keys.DELETE);}
		this.timeBtn.sendKeys("2:17 A");
		logger.info("Ending of selectTime method");
	}
	
	public void landingScreen() {
		logger.info("Starting of landingScreen method");
		try {
			Thread.sleep(1000);
			this.landingScreenBtn.click();
			this.homeScreenBtn.click();
			this.doneBtnForlanding.click();
		} catch (Exception e) {
			this.clickOnWebElement(landingScreenBtn);
			this.clickOnWebElement(homeScreenBtn);
			this.clickOnWebElement(doneBtnForlanding);
		}
		logger.info("Ending of landingScreen method");
	}
	
	public void send() {
		logger.info("Starting of send method");
		try {
			Thread.sleep(1000);
			this.scheduleBtn.click();
		} catch (Exception e) {
			this.clickOnWebElement(scheduleBtn);
		}
		logger.info("Ending of send method");
	}
	public void clickOnSeeAllBtn() {
		logger.info("Starting of clickOnSeeAllBtn method");
		try {
			Thread.sleep(1000);
			this.seeAll.click();
		} catch (Exception e) {
			this.clickOnWebElement(seeAll);
		}
		logger.info("Ending of clickOnSeeAllBtn method");
	}
	
	public void clickOnscheduledNOtification() {
		logger.info("Starting of clickOnscheduledNOtification method");
		try {
			Thread.sleep(1000);
			this.scheduledBtn.click();
		} catch (Exception e) {
			this.clickOnWebElement(scheduleBtn);
		}
		logger.info("Ending of clickOnscheduledNOtification method");
	}
	
	public void deleteNotification(int i) {
		logger.info("Starting of deleteNotification method");
		try {
			Thread.sleep(1000);
			WebElement notification = this.Notifications.get(i);
			this.Notifications.remove(i);
			notification.click();
			this.deleteBtn.click();
//			this.scheduledBtn.click();
		} catch (Exception e) {
			logger.info("exception occer" + e);
		}
		logger.info("Ending of deleteNotification method");
	}
	
	public void editNotification(int i,String title,String text) {
		logger.info("Starting of editNotification method");
		try {
			Thread.sleep(1000);
			WebElement notification = this.Notifications.get(i);
			this.Notifications.remove(i);
			notification.click();
			this.editBtn.click();
			explicitWait(titleArea);
			this.titleArea.clear();
			this.titleArea.sendKeys(title);
			this.textArea.clear();
			this.textArea.sendKeys(text);
			
		}
		catch(Exception e){
			logger.info("exception occer" + e);
		}
			
		logger.info("Ending of editNotification method");
	}
	
	public void sentNOtification() {
		logger.info("Starting of sentNOtification method");
		try {
			Thread.sleep(1000);
			this.seeAll.click();
			this.sentBtn.click();
		} catch (Exception e) {
			this.clickOnWebElement(scheduleBtn);
		}
		logger.info("Ending of sentNOtification method");
	}
	
	public void shareOnWhatsAppNotification(int i) {
		logger.info("Starting of shareOnWhatsAppNotification method");
		try {
			Thread.sleep(1000);
			WebElement notification = this.Notifications.get(i);
			notification.click();
			this.shareOnWhatasappBtn.click();
			this.switchToNewWindow();
//			driver.close();
		}
		catch(Exception e){
			logger.info("exception occer" + e);
		}
			
		logger.info("Ending of shareOnWhatsAppNotification method");
	}
	
	public int getScheduledCount() {
		logger.info("Starting of getScheduledCount method");
		logger.info("Ending of getScheduledCount method");
		try {
			Thread.sleep(2000);
		}
			catch (Exception e) {
				logger.info("exception occur" + e);
			}
			if (this.scheduledLabel.getText().equals("Scheduled"))
				return 0;
			else {
				return Integer.parseInt(this.scheduledLabel.getText().split("\\(")[1].split("\\)")[0]);
			}
		} 
	
	public String getSentNotificationTitle() {
		logger.info("Starting of getSentNotificationTitle method");
		logger.info("Ending of getSentNotificationTitle method");
		try {
			Thread.sleep(2000);
		}
			catch (Exception e) {
				logger.info("exception occur" + e);
			}
		return sentNotificationTitle.getText();
//		String text = sentNotificationTitle.getText();
//		String[] element = text.split("-");
//		return element[0];
	}
	
	public String getSentNotificationDescription() {
		logger.info("Starting of getSentNotificationDescription method");
		logger.info("Ending of getSentNotificationDescription method");
		try {
			Thread.sleep(2000);
		}
			catch (Exception e) {
				logger.info("exception occur" + e);
			}
			return sentNotificationDescription.getText();
	}
	
	public boolean getScheduledNotificationTitle(String title) {
		boolean flag = false;
		for (WebElement e : scheduledTitle) {
			if (e.getText().equals(title)) {
				flag = true;
				break;
			}
		}
		return flag;

	}
	
	public boolean getScheduledNotificationDescription(String description) {
		boolean flag = false;
		for (WebElement e : scheduledDescription) {
			if (e.getText().equals(description)) {
				flag = true;
				break;
			}
		}
		return flag;

	}
	
}
