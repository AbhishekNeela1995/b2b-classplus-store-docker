package com.classplusapp.web.pages.tutor;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import com.classplusapp.web.pages.BaseClassplusAutomationPage;

public class TutorMerchantDashboardPage extends BaseClassplusAutomationPage {

	@FindBy(xpath = "//i[@class='dropdown icon']/parent::div")
	private WebElement drpTutor;

	@FindBy(xpath = "//p[contains(text(),'Merchant Dashboard')]/parent::div")
	private WebElement lblMerchantdashboard;

	// Assertion
	@FindBy(xpath = "//div[contains(text(),\"Filters\")]")
	private WebElement lblFilters;

	// Assertion
	@FindBy(xpath = "//div[text() = 'Filter']")
	private WebElement btnFilter;

	// Assertion
	@FindBy(xpath = "//div[contains(text(),\"EARNINGS\")]")
	private WebElement lblEarnings;

	// Assertion
	@FindBy(xpath = "//div[contains(text(),\"TRANSACTIONS\")]")
	private WebElement lblTransactions;

	@FindBy(xpath = "//div[contains(text(),'Owning')]")
	private WebElement chkOwning;

	@FindBy(xpath = "//div[contains(text(),'Reselling')]")
	private WebElement chkReselling;

	@FindBy(xpath = "//input[@data-cy=\'courseList0\']")
	private WebElement chkCourse;

	@FindBy(xpath = "//div[@class='content active']//div[@class='limitText3']")
	private WebElement chkReseller;
	//

	@FindBy(xpath = "(//div[contains(text(),'See More')])[1]")
	private WebElement btnSeeMore;

	// Assertion
	@FindBy(xpath = "//div[contains(text(),\"Select Course\")]")
	private WebElement lblSelectCourse;

	@FindBy(xpath = "//span[contains(text(),\"Course\")]")
	private WebElement lblCourse;

	@FindBy(xpath = "//button[contains(text(),'Apply Filters')]")
	private WebElement btnApplyFilters;

	@FindBy(xpath = "//span[contains(text(),'Reseller/Owner')]")
	private WebElement lstResellerOrOwner;

	@FindBy(xpath = "//span[contains(text(),' Bio-Logic Studies')]")
	private WebElement chkBioLogicStudies;

	@FindBy(xpath = "//span[contains(text(),'Time')]")
	private WebElement time;

	@FindBy(xpath = "//span[contains(text(),'Last 1 month')]")
	private WebElement duration;

	@FindBy(xpath = "//a[@href='/newApp/merchantDashboard/partnerProgram']")
	private WebElement txtShowEarningsFromPartnerProgram;

	// Assertion
	@FindBy(xpath = "//div[contains(text(),\"EARNINGS FROM PARTNER PROGRAM\")]")
	private WebElement lblEarningsFromPartnerProgram;

	@FindBy(xpath = "//img[@src='/newApp/static/media/backArrow.dd0baef1.svg']")
	private WebElement btnBackArrow;

	// Assertion
	@FindBy(xpath = "//div[contains(text(),'TOTAL REVENUE')]")
	private WebElement lblTotalRevenue;

	@FindBy(xpath = "//div[contains(text(),'NUMBER OF PURCHASES')]")
	private WebElement lblNumberPurchase;

	@FindBy(xpath = "//div[contains(text(),'NUMBER OF PURCHASES')]/following-sibling::div")
	private WebElement lblPurchase;

	@FindBy(xpath = "//input[@placeholder='Search...']")
	private WebElement lblSearch;
	@FindBy(xpath = "//div[@data-cy='courseSeeMore-search']//input")
	private WebElement lblSeeMoreSearch;
	@FindBy(xpath = "//div[@data-cy='seeMoreModalGrid']//input")
	private WebElement chbCourse;

	// Again click on tutors Dropdown
	@FindBy(xpath = "//i[@class='dropdown icon']/parent::div")
	private WebElement drpTutor1;

	@FindBy(xpath = "//div[@class=\"item\"]/child::p[contains(text(),'Settings')]")
	private WebElement btnSettings;

	// Assertion
	@FindBy(xpath = "//div[contains(text(),'Allow students to create groups amongst themselves. You can get into a detective mode and see how they interact')]")
	private WebElement lblGroupStudy;

	// Assertion
	@FindBy(xpath = "//div[contains(text(),'Web notifications')]")
	private WebElement lblWebNotifications;

	// Assertion
	@FindBy(xpath = "//div[contains(text(),'Watermark')]")
	private WebElement lblWatermark;
	@FindBy(xpath = "//div[@class='storeStudents__content__installmentBadgeContainer__installmentBadge']")
	private WebElement lblInstallment;

	@FindBy(xpath = "//div[@data-cy='radio_groupStudy']")
	private WebElement btnGroupstudy;

	// again click on tutors dropdown
	@FindBy(xpath = "(//p[contains(text(),'Dashboard')])[1]")
	private WebElement lblDashboard;

	// Assertion
	@FindBy(xpath = "//p[contains(text(),\"BATCH STATUS\")]")
	private WebElement lblBatchStatus;

	// Assertion
	@FindBy(xpath = "//p[contains(text(),\"COIN STATUS\")]")
	private WebElement lblCoinStatus;

	// Assertion
	@FindBy(xpath = "//div[contains(text(),\"RECHARGE\")]")
	private WebElement lblRecharge;

	// Assertion
	@FindBy(xpath = "//p[contains(text(),\"DOWNLOAD REPORTS\")]")
	private WebElement lblDownloadReports;

	@FindBy(xpath = "//div[contains(text(),'Select Report')]")
	private WebElement selectReportField;

	@FindBy(xpath = "//span[contains(text(),'Enquiries')]")
	private WebElement txtEnquiries;

	@FindBy(xpath = "//div[contains(text(),'Select Date')]")
	private WebElement selectDateField;

	@FindBy(xpath = "//span[contains(text(),'Last 7 Days')]")
	private WebElement txtDate;

	@FindBy(xpath = "//button[contains(text(),'Export Data')]")
	private WebElement btnExportData;

	@FindBy(xpath = "//div[contains(text(),'Your reports will be sent on your email.')]")
	private WebElement msgExportSuccess;

	@FindBy(xpath = "//button[@class='analytics-button']")
	private WebElement btnAnalytics;

	@FindBy(xpath = "//div[text()= 'Customize Class Test GradingCustomize Class Test Grading']")
	private WebElement lblCustomizeClassTestGradingHeading;

	@FindBy(xpath = "(//div[@class='Dropdown Dropdown ']//div/div)[1]")
	private WebElement drpGradeA;

	@FindBy(xpath = "//span[contains(text(),'A')]/parent::span/following-sibling::div/child::div[@style='background: rgb(255, 255, 255); border: 1px solid rgb(217, 217, 217); box-sizing: border-box; border-radius: 4px; width: 17rem; height: 3rem; justify-content: space-between; cursor: pointer;']/following-sibling::div/child::ul/child::li[@value='90']")
	private WebElement drpSelectGradeA;

	@FindBy(xpath = "//div[contains(text(),'>= 90 %')]")
	private WebElement lblGradeAValue;

	@FindBy(xpath = "(//div[@class='Dropdown Dropdown ']//div/div)[3]")
	private WebElement drpGradeB;

	@FindBy(xpath = "//span[contains(text(),'B')]/parent::span/following-sibling::div/child::div[@style='background: rgb(255, 255, 255); border: 1px solid rgb(217, 217, 217); box-sizing: border-box; border-radius: 4px; width: 17rem; height: 3rem; justify-content: space-between; cursor: pointer;']/following-sibling::div/child::ul/child::li[@value='85']")
	private WebElement drpSelectGradeB;

	@FindBy(xpath = "//div[contains(text(),'>= 85 %')]")
	private WebElement lblGradeBValue;

	@FindBy(xpath = "(//div[@class='Dropdown Dropdown ']//div/div)[5]")
	private WebElement drpGradeC;

	@FindBy(xpath = "//span[contains(text(),'C')]/parent::span/following-sibling::div/child::div[@style='background: rgb(255, 255, 255); border: 1px solid rgb(217, 217, 217); box-sizing: border-box; border-radius: 4px; width: 17rem; height: 3rem; justify-content: space-between; cursor: pointer;']/following-sibling::div/child::ul/child::li[@value='75']")
	private WebElement drpSelectGradeC;

	@FindBy(xpath = "//div[contains(text(),'>= 75 %')]")
	private WebElement lblGradeCValue;

	@FindBy(xpath = "(//div[@class='Dropdown Dropdown ']//div/div)[7]")
	private WebElement drpGradeD;

	@FindBy(xpath = "//span[contains(text(),'D')]/parent::span/following-sibling::div/child::div[@style='background: rgb(255, 255, 255); border: 1px solid rgb(217, 217, 217); box-sizing: border-box; border-radius: 4px; width: 17rem; height: 3rem; justify-content: space-between; cursor: pointer;']/following-sibling::div/child::ul/child::li[@value='65']")
	private WebElement drpSelectGradeD;

	@FindBy(xpath = "//div[contains(text(),'>= 65 %')]")
	private WebElement lblGradeDValue;

	@FindBy(xpath = "(//div[@class='Dropdown Dropdown ']//div/div)[9]")
	private WebElement drpGradeE;

	@FindBy(xpath = "//span[contains(text(),'E')]/parent::span/following-sibling::div/child::div[@style='background: rgb(255, 255, 255); border: 1px solid rgb(217, 217, 217); box-sizing: border-box; border-radius: 4px; width: 17rem; height: 3rem; justify-content: space-between; cursor: pointer;']/following-sibling::div/child::ul/child::li[@value='40']")
	private WebElement drpSelectGradeE;

	@FindBy(xpath = "//div[contains(text(),'>= 40 %')]")
	private WebElement lblGradeEValue;

	@FindBy(xpath = "//button[@class='gradeModal-button-save']")
	private WebElement btnSave;

	@FindBy(xpath = "//div[@class='analytics-header']/child::div/child::div[@class='cp-settings-header']")
	private WebElement lblCustomizeClassGrading;

	@FindBy(xpath = "//input[@type='file']")
	private WebElement btnUploadWaterMark;

	@FindBy(xpath = "//img[@alt='cross']")
	private WebElement btnCrossIcon;

	@FindBy(xpath = "//div[contains(text(),'successfully deleted water mark')]")
	private WebElement lblDeleteWaterMark;

	@FindBy(xpath = "//div[@class='rrt-text']")
	private WebElement lblUploadWaterMark;

	@FindBy(xpath = "//div[@class='two wide computer column']//div//img/following-sibling::img")
	private WebElement lblImage;

	@FindBy(xpath = "//div[@class='GradeSetter']/preceding-sibling::div")
	private WebElement lblCustomizeClassTestGrading;

	@FindBy(xpath = "//div[contains(@class, 'merchantDashboardSegment--value')]")
	private WebElement lblRevenue;

	@FindBy(xpath = "//label[normalize-space()='My students']")
	private WebElement lblMyStudents;
	@FindBy(xpath = "//label[contains(text(),'Reseller’s students')]")
	private WebElement lblResellerStudents;

	@FindBys({ @FindBy(xpath = "//div[@class = 'storeStudents__content__installmentBadgeContainer']") })
	private List<WebElement> lblTransactionAmount;

	@FindBys({ @FindBy(xpath = "//div[@class = 'storeStudents__content--list--item storeStudents__grid--2']//div") })
	private WebElement lblStudentName;

	private static final Logger logger = Logger.getLogger(TutorMerchantDashboardPage.class.getName());

	public TutorMerchantDashboardPage(WebDriver driver) {
		super(driver);
		logger.info("Starting of MerchantDashboardPage method");

		PageFactory.initElements(driver, this);

		logger.info("Ending of MerchantDashboardPage method");
	}

	public void clickOnTutorDropdown() {
		logger.info("starting of clickOnTutorDropdown method");

		try {
			this.hardWait(3);
			this.clickOnWebElement(drpTutor);
		} catch (Exception e) {
			this.drpTutor.click();
		}

		logger.info("Ending of clickOnTutorDropdown method");
	}

	public void switchToDefault() {
		logger.info("starting of clickOnTutorDropdown method");

		ArrayList<String> tab = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tab.get(0));

		logger.info("Ending of clickOnTutorDropdown method");
	}

	public void searchTransactions(String input) {
		logger.info("starting of searchTransactions method");
		logger.info("Ending of searchTransactions method");
		this.lblSearch.sendKeys(input);
	}

	public void searchTransactionsSeeMore(String input) throws InterruptedException {
		logger.info("starting of searchTransactionsSeeMore method");
		logger.info("Ending of searchTransactionsSeeMore method");
		Thread.sleep(5000);
		this.lblSeeMoreSearch.sendKeys(input);
	}

	public void clickOnMerchantDashboardLabel() {
		logger.info("starting of clickOnMerchantDashboard method");

		try {
			this.lblMerchantdashboard.click();
		} catch (Exception e) {
			this.clickOnWebElement(lblMerchantdashboard);
			e.printStackTrace();
		}

		logger.info("Ending of clickOnMerchantDashboard method");
	}

	public String getFiltersLabelText() {
		logger.info("Starting of getFiltersLabel method");
		logger.info("Ending of getFiltersLabel method");

		return this.lblFilters.getText();
	}

	public String getEarningsLabelText() {
		logger.info("Starting of getEarningsLabel method");
		logger.info("Ending of getEarningsLabel method");

		return this.lblEarnings.getText();
	}

	public String getRevenue() throws InterruptedException {
		logger.info("Starting of getRevenue");
		logger.info("Ending of getRevenue");
		Thread.sleep(10000);
		return this.lblRevenue.getText().replace("₹", "").replace(".00", "");

	}

	public String getTransactionsLabelText() {
		logger.info("Starting of getTransactionsLabel method");
		logger.info("Ending of getTransactionsLabel method");
		return this.lblTransactions.getText();
	}

	public void clickOnOwningCheckBox() {
		logger.info("starting of clickOnOwning method");

		this.chkOwning.click();

		logger.info("Ending of clickOnOwning method");
	}

	public void clickOnResellingCheckBox() {
		logger.info("starting of clickOnReselling method");

		this.chkReselling.click();

		logger.info("Ending of clickOnReselling method");
	}

	public void clickOnCourseCheckBox() {
		logger.info("starting of clickOnCourse method");
		if (this.chkCourse.isDisplayed() == false) {
			this.lblCourse.click();
		}
		this.chkCourse.click();

		logger.info("Ending of clickOnCourse method");
	}

	public void clickOnResellerOwnerCheckBox() {
		logger.info("starting of clickOnResellerOwnerCheckBox method");
		if (this.chkReseller.isDisplayed() == false) {
			this.lstResellerOrOwner.click();
		}
		this.chkReseller.click();

		logger.info("Ending of clickOnResellerOwnerCheckBox method");
	}

	public void clickOnSeeMoreButton() throws InterruptedException {
		logger.info("starting of clickOnSeeMore method");
		Thread.sleep(5000);

		this.btnSeeMore.click();

		logger.info("Ending of clickOnSeeMore method");
	}

	public void clickOnCheckBoxCourse() {
		logger.info("starting of clickOnCheckBoxCourse method");

		this.chbCourse.click();

		logger.info("Ending of clickOnCheckBoxCourse method");
	}

	public String getSelectCourseLabelText() {
		logger.info("Starting of getSelectCourseLabel method");
		logger.info("Ending of getSelectCourseLabel method");

		return this.lblSelectCourse.getText();
	}

	public void clickOnCourse() {
		logger.info("starting of clickOnCourse method");

		this.lblCourse.click();

		logger.info("Ending of clickOnCourse method");
	}

	public void clickOnApplyFiltersButton() {
		logger.info("starting of clickOnApplyFilters method");

		this.clickOnWebElement(btnApplyFilters);

		logger.info("Ending of clickOnApplyFilters method");
	}

	public void clickOnFilterButton() {
		logger.info("starting of clickOnFilter method");

		this.clickOnWebElement(btnFilter);

		logger.info("Ending of clickOnFilter method");
	}

	public void clickOnMyStudents() {
		logger.info("starting of clickOnMyStudents method");

		this.clickOnWebElement(lblMyStudents);

		logger.info("Ending of clickOnMyStudents method");
	}

	public void clickOnResellerStudents() {
		logger.info("starting of clickOnResellerStudents method");

		this.clickOnWebElement(lblResellerStudents);

		logger.info("Ending of clickOnResellerStudents method");
	}

	public void clickOnResellerOrOwner() {
		logger.info("starting of clickOnResellerOrOwner method");

		this.clickOnWebElement(lstResellerOrOwner);

		logger.info("Ending of clickOnResellerOrOwner method");
	}

	public void clickBioLogicStudiesCourseCheckBox() {
		logger.info("starting of clickBioLogicStudiesCourse method");

		this.chkBioLogicStudies.click();

		logger.info("Ending of clickBioLogicStudiesCourse method");
	}

	public void selectTime() {
		logger.info("starting of selectTime method");
		this.scrollIntoView(time);
		this.time.click();

		logger.info("Ending of selectTime method");
	}

	public void selectDuration() {
		logger.info("starting of clickOnDuration method");
		for (int i = 0; i <= 4; i++) {

			try {
				if (this.duration.isDisplayed() == true) {
					this.duration.click();
					break;
				}
			} catch (NoSuchElementException e) {
				this.scrollIntoView(time);
				this.time.click();
				selectTime();
				if (i == 4) {
					throw e;
				}
			}
		}

		logger.info("Ending of clickOnDuration method");
	}

	public void clickOnShowEarningsText() {
		logger.info("starting of clickOnShowEarnings method");

		this.txtShowEarningsFromPartnerProgram.click();

		logger.info("Ending of clickOnShowEarnings method");
	}

	public String getEarningsFromPartnerProgramLabelText() {
		logger.info("Starting of getEarningsFromPartnerProgramLabel method");
		logger.info("Ending of getEarningsFromPartnerProgramLabel method");

		return this.lblEarningsFromPartnerProgram.getText();
	}

	public String getStudentName() {
		logger.info("Starting of getStudentName method");
		logger.info("Ending of getStudentName method");
		return this.lblStudentName.getText();
	}

	public void clickOnBackButton() {
		logger.info("starting of clickOnBack method");

		this.btnBackArrow.click();

		logger.info("Ending of clickOnBack method");

	}

	public String getTotalRevenueLabelText() {
		logger.info("Starting of getTotalRevenueLabel method");
		logger.info("Ending of getTotalRevenueLabel method");
		return this.lblTotalRevenue.getText();
	}

	public String getNumberPurchaseLabelText() {
		logger.info("Starting of getNumberPurchaseLabelText method");
		logger.info("Ending of getNumberPurchaseLabelText method");
		return this.lblNumberPurchase.getText();
	}

	public String getPurchase() {
		logger.info("Starting of getPurchase method");
		logger.info("Ending of getPurchase method");
		return this.lblPurchase.getText();
	}

	public void clickOnSettings() {
		logger.info("starting of clickOnSettings method");
		try {
			Thread.sleep(1000);
			this.btnSettings.click();
		} catch (Exception e) {
			this.clickOnWebElement(btnSettings);

		}

		logger.info("Ending of clickOnSettings method");
	}

	public String getGroupStudyLabel() {
		logger.info("Starting of getGroupStudyLabel method");
		logger.info("Ending of getGroupStudyLabel method");

		return this.lblGroupStudy.getText();
	}

	public String getWebNotifications() {
		logger.info("Starting of getWebNotifications method");
		logger.info("Ending of getWebNotifications method");

		return this.lblWebNotifications.getText();
	}

	public String getWatermark() {
		logger.info("Starting of getWatermark method");
		logger.info("Ending of getWatermark method");

		return this.getWatermark();
	}

	public void clickOnGroupStudyToggle() {
		logger.info("starting of clickOnGroupStudyToggle method");

		this.btnGroupstudy.click();

		logger.info("Ending of clickOnGroupStudyToggle method");
	}

	public void clickOnDashboard() {
		logger.info("starting of clickOnDashboard method");

		try {
			this.lblDashboard.click();
		} catch (Exception e) {
			this.clickOnWebElement(lblDashboard);
			e.printStackTrace();
		}

		logger.info("Ending of clickOnDashboard method");

	}

	public String getBatchStatus() {
		logger.info("Starting of getBatchStatus method");
		logger.info("Ending of getBatchStatus method");

		return this.lblBatchStatus.getText();
	}

	public String getCoinStatus() {
		logger.info("Starting of getCoinStatus method");
		logger.info("Ending of getCoinStatus method");

		return this.lblCoinStatus.getText();
	}

	public String getRecharge() {
		logger.info("Starting of getRecharge method");
		logger.info("Ending of getRecharge method");

		return this.lblRecharge.getText();
	}

	public String getAmount() {
		logger.info("Starting of getAmount method");
		int sum = 0;
		for (WebElement li1 : lblTransactionAmount) {
			System.out.println(li1.getText());
			String s = li1.getText();
			sum = sum + Integer.parseInt(s);
		}
		System.out.println(sum);
		System.out.println(lblTransactionAmount.size());
		String number = String.valueOf(sum);
		logger.info("Ending of getAmount method");
		return number;

	}

	public String getNumberPurchase() {
		logger.info("Starting of getAmount method");
		List<WebElement> li1 = lblTransactionAmount;
		String purchase = String.valueOf(li1.size());
		System.out.println(purchase);
		return purchase;
	}

	public String getDownloadReports() {
		logger.info("Starting of getDownloadReports method");
		logger.info("Ending of getDownloadReports method");

		return this.lblDownloadReports.getText();
	}

	public void clickOnSelectReportField() {
		logger.info("starting of clickOnSelectReportField method");

		this.selectReportField.click();

		logger.info("Ending of clickOnSelectReportField method");
	}

	public void clickOnEnquiries() {
		logger.info("starting of clickOnEnquiries method");

		this.txtEnquiries.click();

		logger.info("Ending of clickOnEnquiries method");
	}

	public void clickOnSelectDateField() {
		logger.info("starting of clickOnSelectDateField method");

		this.selectDateField.click();

		logger.info("Ending of clickOnSelectDateField method");
	}

	public void clickOnSelectedDate() {
		logger.info("starting of clickOnSelectedDate method");

		this.txtDate.click();

		logger.info("Ending of clickOnSelectedDate method");
	}

	public void clickOnExportData() {
		logger.info("starting of clickOnExportData method");

		this.btnExportData.click();

		logger.info("Ending of clickOnExportData method");
	}

	public boolean getInstallmentLabel() {
		logger.info("starting of getInstallmentLabel method");
		boolean flag = false;
		logger.info("Ending of getInstallmentLabel method");
		try {
			if (lblInstallment.isDisplayed())
				flag = true;
		} catch (NoSuchElementException e) {
			flag = false;
		}
		return flag;

	}

	public String getExportSuccessMessage() {
		logger.info("Starting of exportMessage method");

		this.explicitWait(msgExportSuccess);

		try {
			Thread.sleep(3000);
		} catch (Exception e) {
		}

		logger.info("Ending of exportMessage method");

		return msgExportSuccess.getText();
	}

	public void clickOnAnalyticsButton() {
		logger.info("Strting of AnalyticSButton Method");

		this.explicitWait(btnAnalytics);
		this.btnAnalytics.click();

		logger.info("Ending of Analytics  Method");

	}

	public String getCustomizeClassTestGradingLabelHeading() {
		logger.info("Starting of getCustomizeClassTestGradingLabelHeading Method");

		this.explicitWait(lblCustomizeClassTestGradingHeading);

		logger.info("Ending of getCustomizeClassTestGradingLabelHeading Method ");

		return lblCustomizeClassTestGradingHeading.getText();
	}

	public String getCustomizeClassTestGradingLabel() {
		logger.info("Starting of CustomizeClassTestGradingLabel Method");

		this.explicitWait(lblCustomizeClassGrading);

		logger.info("Ending of CustomizeClassTestGrading Method ");

		return lblCustomizeClassGrading.getText();
	}

	public void clickOnGradeADropDown() {
		logger.info("starting of clickOnGradeADropDown method");

		this.drpGradeA.click();

		logger.info("Ending of clickOnGradeADropDown method");
	}

	public void clickOnSelectGradeADropDown() {
		logger.info("starting of clickOnSelectGradeADropDown method");

		this.drpSelectGradeA.click();

		logger.info("Ending of clickOnSelectGradeADropDown method");
	}

	public void clickOnGradeBDropDown() {
		logger.info("starting of clickOnGradeBDropDown method");

		this.clickOnWebElement(drpGradeB);

		logger.info("Ending of clickOnGradeBDropDown method");
	}

	public void clickOnSelectGradeBDropDown() {
		logger.info("starting of clickOnSelectGradeBDropDown method");

		this.clickOnWebElement(drpSelectGradeB);
		// this.drpSelectGradeB.click();

		logger.info("Ending of clickOnSelectGradeBDropDown method");
	}

	public void clickOnGradeCDropDown() {
		logger.info("starting of clickOnGradeCDropDown method");

		this.drpGradeC.click();

		logger.info("Ending of clickOnGradeCDropDown method");
	}

	public void clickOnSelectGradeCDropDown() {
		logger.info("starting of clickOnSelectGradeCDropDown method");

		this.drpSelectGradeC.click();

		logger.info("Ending of clickOnSelectGradeCDropDown method");
	}

	public void clickOnGradeDDropDown() {
		logger.info("starting of clickOnGradeDDropDown method");

		this.drpGradeD.click();

		logger.info("Ending of clickOnGradeDDropDown method");
	}

	public void clickOnSelectGradeDDropDown() {
		logger.info("starting of clickOnSelectGradeDDropDown method");

		this.drpSelectGradeD.click();

		logger.info("Ending of clickOnSelectGradeDDropDown method");
	}

	public void clickOnGradeEDropDown() {
		logger.info("starting of clickOnGradeEDropDown method");

		this.drpGradeE.click();

		logger.info("Ending of clickOnGradeEDropDown method");
	}

	public void clickOnSelectGradeEFromDropDown() {
		logger.info("starting of clickOnSelectGradeEFromDropDown method");

		this.drpSelectGradeE.click();

		logger.info("Ending of clickOnSelectGradeEFromDropDown method");
	}

	public void clickOnSaveButton() {
		logger.info("starting of clickOnButtonSave method");

		this.btnSave.click();

		logger.info("Ending of clickOnButtonSave method");
	}

	public void clickOnUploadButton() {
		logger.info("starting of clickOnUploadButton method");
		this.scrollIntoView(btnUploadWaterMark);
		String osPath = System.getProperty("os.name");
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
		}
		if (osPath.contains("Linux")) {
			btnUploadWaterMark.sendKeys(TEST_FILE_PATH + "/testdata/0.jpg");
		} else {
			btnUploadWaterMark.sendKeys(TEST_FILE_PATH + File.separator + "testdata" + File.separator + "0.jpg");
		}

		logger.info("Ending of clickOnUploadButton method");
	}

	public void clickOnCrossButton() {
		logger.info("starting of clickOnCrossButton method");

		this.hardWait(3);
		try {
			this.clickOnWebElement(btnCrossIcon);
		} catch (Exception e) {
			this.btnCrossIcon.click();
		}

		logger.info("Ending of clickOnCrossButton method");
	}

	public boolean getImageLabel() {
		logger.info("starting of getImageLabel method");
		logger.info("Ending of getImageLabel method");
		boolean flag = false;
		try {
			if (lblImage.isDisplayed())
				flag = true;
		} catch (NoSuchElementException e) {
			flag = false;
		}
		return flag;

	}

	public String getSrcOfWatermark() {
		logger.info("starting of getSrcOfWatermark method");

		String srcWatermark = lblImage.getAttribute("src");
		logger.info("Ending of getSrcOfWatermark method " + srcWatermark);
		return srcWatermark;
	}

	public String getCustomizeClassGradingLabel() {
		logger.info("Starting of getCustomizeClassGradingLabel Method");

		this.explicitWait(lblCustomizeClassTestGrading);

		logger.info("Ending of getCustomizeClassGradingLabel Method ");
		return lblCustomizeClassTestGrading.getText();
	}

	public String getGradeAValue() {
		logger.info("Starting of getGradeAValue Method");

		this.explicitWait(lblGradeAValue);

		logger.info("Ending of getGradeAValue Method ");
		return lblGradeAValue.getText();
	}

	public String getGradeBValue() {
		logger.info("Starting of getGradeBValue Method");

		this.explicitWait(lblGradeBValue);

		logger.info("Ending of getGradeBValue Method ");
		return lblGradeBValue.getText();
	}

	public String getGradeCValue() {
		logger.info("Starting of getGradeCValue Method");

		this.explicitWait(lblGradeCValue);

		logger.info("Ending of getGradeCValue Method ");
		return lblGradeCValue.getText();
	}

	public String getGradeDValue() {
		logger.info("Starting of getGradeDValue Method");

		this.explicitWait(lblGradeDValue);

		logger.info("Ending of getGradeDValue Method ");
		return lblGradeDValue.getText();
	}

	public String getGradeEValue() {
		logger.info("Starting of getGradeEValue Method");

		this.explicitWait(lblGradeEValue);

		logger.info("Ending of getGradeEValue Method ");
		return lblGradeEValue.getText();
	}

	public String getDeleteWaterMark() {
		logger.info("Starting of getDeleteWaterMark Method");
		logger.info("Ending of getDeleteWaterMark Method ");
		this.explicitWait(lblDeleteWaterMark);

		return lblDeleteWaterMark.getText();
	}

	public String getUploadWaterMark() {
		logger.info("Starting of getUploadWaterMark Method");
		logger.info("Ending of getUploadWaterMark Method ");
		this.explicitWait(lblUploadWaterMark);

		return lblUploadWaterMark.getText();
	}

	public WebElement getShadowRootElement(WebElement element) {
		WebElement ele = (WebElement) ((JavascriptExecutor) driver).executeScript("return arguments[0].shadowRoot",
				element);
		return ele;
	}

	public void shadowroot() {
		WebElement root1 = driver.findElement(By.id("example"));

		WebElement shadowRoot1 = getShadowRootElement(root1);
		WebElement shadowElement = shadowRoot1.findElement(By.cssSelector("div[id=label]"));

	}

}