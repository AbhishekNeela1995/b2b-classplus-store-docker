package com.classplusapp.web.pages.tutor;


import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.classplusapp.web.pages.BaseClassplusAutomationPage;

public class TutorDashboardPage extends BaseClassplusAutomationPage{

	
	@FindBy(xpath = "//span[@class=\"profile-thumbnail\"]//img")
	private WebElement profileThumbnailBtn;
	
	@FindBy(xpath = "(//div[@role=\"option\"][4])[1]")
	private WebElement dashboardBtn;
	
	@FindBy(xpath = "(//i[@class=\"dropdown icon\"])[2]")
	private WebElement reportDropdownBtn;

	@FindBy(xpath = "//div[@class=\"menu transition visible\"]//div[contains(string(), \"Address Data\")]")
	private WebElement addressReport;
	
	@FindBy(xpath = "//div[@class=\"menu transition visible\"]//div[contains(string(), \"AI Powered Leads\")]")
	private WebElement aiPoweredLeadsReport;
	
	@FindBy(xpath = "//div[@class=\"menu transition visible\"]//div[contains(string(), \"Course Installment Report\")]")
	private WebElement courseInstallmentReport;
	
	@FindBy(xpath = "//div[@class=\"menu transition visible\"]//div[contains(string(), \"Course Purchases Transaction Reports\")]")
	private WebElement coursePurchasesTransactionReports;
	
	@FindBy(xpath = "//div[@class=\"menu transition visible\"]//div[contains(string(), \"Students Profile Data\")]")
	private WebElement studentsProfileDataReport;
	
	@FindBy(xpath = "//input[@class=\"InfiniteDropdown__Body--Input\"]")
	private WebElement courseBtn;
		
	@FindBy(xpath = "//div[@class=\"InfiniteDropdown__Body--Dropdown--Item\"]")
	private WebElement addressDataReport;
	
	@FindBy(xpath = "(//div[@class=\"ui fluid search selection dropdown\"])[2]")
	private WebElement dateBtn;
	
	@FindBy(xpath = "//div[@class=\"menu transition visible\"]//div[@role=\"option\"][1]")
	private WebElement date;
	
	@FindBy(xpath = "//span[@class=\"text\"][contains(string(), \"Custom Date\")]")
	private WebElement customDate;
	
	@FindBy(xpath = "//input[@class=\"DateInput_input DateInput_input_1 DateInput_input__focused DateInput_input__focused_2\"]")
	private WebElement startDate;
	
	@FindBy(xpath = "//input [@class=\"DateInput_input DateInput_input_1 DateInput_input__focused DateInput_input__focused_2\"]")
	private WebElement endDate;
	
	@FindBy(xpath = "//button[text()='Export Data']")
	private WebElement exportDataBtn;
	
	@FindBy(xpath = "//div[@class=\"rrt-title\"]")
	private WebElement exportPopUp;
	
	@FindBy(xpath = "//button[@class=\"close-toastr\"]")
	private WebElement closePopUp;
	

	private static final Logger logger = Logger.getLogger(TutorDashboardPage.class.getName());
	
	public TutorDashboardPage(WebDriver driver) {
		super(driver);
		logger.info("Starting of TutorDashboardPage method");
		PageFactory.initElements(driver, this);
		logger.info("Ending of TutorDashboardPage method");
	}
	
	public void clickOnProfileThumbnailBtn() {
		logger.info("Starting of clickONProfileThumbnailBtn method");
		try {
			Thread.sleep(1000);
			this.profileThumbnailBtn.click();
		} catch (Exception e) {
			this.clickOnWebElement(profileThumbnailBtn);
		}
		logger.info("Ending of clickONProfileThumbnailBtn method");
	}
	
	public void clickOnDashboardBtn() {
		logger.info("Starting of clickOnDashboardBtn method");
		try {
			Thread.sleep(1000);
			this.dashboardBtn.click();
		} catch (Exception e) {
			this.clickOnWebElement(dashboardBtn);
		}
		logger.info("Ending of clickOnDashboardBtn method");
	}
	
	public void selectReport() {
		logger.info("Starting of selectReport method");
		try {
			Thread.sleep(1000);
			this.reportDropdownBtn.click();
		} catch (Exception e) {
			this.clickOnWebElement(reportDropdownBtn);
		}
		logger.info("Ending of selectReport method");
	}
	
	public void selectAddressDataCourse () {
		logger.info("Starting of selectAddressDataCourse method");
		try {
			Thread.sleep(1000);
			this.addressReport.click();
			this.courseBtn.click();
			this.addressDataReport.click();
		} catch (Exception e) {
			logger.info("selectAddressDataCourse method failed ");
		}
		logger.info("Ending of selectAddressDataCourse method");
	}
	
	public void selectAiPoweredLeadsCourse () {
		logger.info("Starting of selecAiPoweredLeadsCourse method");
		try {
			Thread.sleep(1000);
			this.aiPoweredLeadsReport.click();
		} catch (Exception e) {
			logger.info("selectAddressDataCourse method failed ");
		}
		logger.info("Ending of selecAiPoweredLeadsCourse method");
	}
	
	public void selectCoursePurchasesTransactionReports () {
		logger.info("Starting of selectCoursePurchasesTransactionReports method");
		try {
			Thread.sleep(1000);
			this.coursePurchasesTransactionReports.click();
		} catch (Exception e) {
			logger.info("selectCoursePurchasesTransactionReports method failed ");
		}
		logger.info("Ending of selectCoursePurchasesTransactionReports method");
	}
	
	
	public void selectCourseInstallmentReport () {
		logger.info("Starting of selectCourseInstallmentReport method");
		try {
			Thread.sleep(1000);
			this.courseInstallmentReport.click();
		} catch (Exception e) {
			logger.info("selectCourseInstallmentReport method failed ");
		}
		logger.info("Ending of selectCourseInstallmentReport method");
	}
	
	public void selectcourseStudentsProfileData () {
		logger.info("Starting of selectcourseStudentsProfileData method");
		try {
			Thread.sleep(1000);
			this.studentsProfileDataReport.click();
		} catch (Exception e) {
			logger.info("selectcourseStudentsProfileData method failed ");
		}
		logger.info("Ending of selectcourseStudentsProfileData method");
	}
	
	public void selectDate () {
		logger.info("Starting of selectDate method");
		try {
			Thread.sleep(1000);
			this.dateBtn.click();
			this.date.click();
		} catch (Exception e) {
			logger.info("selectDate method failed ");
		}
		logger.info("Ending of selectDate method");
	}
	
	public void selectCustomDate () {
		logger.info("Starting of selectCustomDate method");
		try {
			Thread.sleep(1000);
			this.dateBtn.click();
			this.customDate.click();
			this.startDate.clear();
			this.startDate.sendKeys("19/03/2034");
			this.endDate.clear();
			this.endDate.sendKeys("19/04/2034");
		} catch (Exception e) {
			logger.info("selectCustomDate method failed ");
		}
		logger.info("Ending of selectCustomDate method");
	}
	
	public void exportData () {
		logger.info("Starting of exportData method");
		try {
			Thread.sleep(1000);
			this.exportDataBtn.click();
		} catch (Exception e) {
			logger.info("exportData method failed ");
		}
		logger.info("Ending of exportData method");
	}
	
	public String exportDataText () {
		logger.info("Starting of exportDataText method");
		this.explicitWait(exportPopUp);
		String text = this.exportPopUp.getText();
		this.closePopUp.click();
		return text;
	}
	
	
	
	
	
	
	
	
	
	
}
