package com.classplusapp.web.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class ClassplusLoginPage extends BaseClassplusAutomationPage {

	@FindBy(xpath = "//p[@class=\"accountLogin-heading\"]")
	private WebElement lblLoginHeading;

	@FindBy(xpath = "//input[@class='accountLogin-input']")
	private WebElement orgCode;

	@FindBy(xpath = "//input[@class='accountLogin-input accountLogin-input-mobile']")
	private WebElement loginInput;
	

	@FindBy(xpath = "//button[contains(text(),'Proceed Securely')]")
	private WebElement proceedSecurely;

	@FindBy(xpath = "//p[@class=\"accountLogin-type-text\"]")
	private WebElement alternativeLogin;

	@FindBy(xpath = "//input[@data-cy=\"login_email\"]")
	private WebElement emailInput;

	@FindBy(xpath = "//div[@class='accountLogin-org-error-text']")
	private WebElement invalidOrgCode;

	@FindBy(xpath = "//label[@class='accountLogin-error-message']")
	private WebElement loginErrorMessage;

	@FindBy(xpath = "//button[@class=\"otp-back-button\"]")
	private WebElement backToLogin;

	@FindBy(xpath = "//div[@class=\"otp-container\"]/input")
	private WebElement otpInput;

	@FindBy(xpath = "//div[contains(text(), 'Send OTP again')]")
	private WebElement resendOTP;

	@FindBy(xpath = "//button[@data-cy='login_verify']")
	private WebElement verifyOTP;

	@FindBy(xpath = "//button[contains(text(),'Ok')]")
	private WebElement ok;

	@FindBy(xpath = "//i[@class=\"dropdown icon\"]")
	private WebElement listBox;

	@FindBy(xpath = "//p[contains(text(),'Logout')]")
	private WebElement logOut;

	@FindBy(xpath = "//div[contains(text(),'OTP Sent Successfully')]")
	private WebElement otpSentMessage;

	@FindBy(xpath = "//div[contains(text(),'OTP Verified Successfully')]")
	private WebElement otpVerifiedMessage;

	@FindBy(xpath = "//p[contains(text(),'Enter OTP here')]")
	private WebElement otpHeading;

	@FindBy(xpath = "//div[contains(text(),'Something went wrong')]")
	private WebElement errorMessage;

	@FindBy(xpath = "//p[contains(text(),'Login to your account')]")
	private WebElement loginToAccount;

	@FindBy(xpath = "//p[contains(text(),'Batches')]")
	private WebElement dashBoard;

	@FindBy(xpath = "//div[contains(text(),'Are you sure about logout?')]")
	private WebElement logoutConfirmMessage;

	@FindBy(xpath = "//i[@class='dropdown icon']")
	private WebElement userProfileIcon;

	private static final Logger logger = Logger.getLogger(ClassplusLoginPage.class.getName());

	public ClassplusLoginPage(WebDriver driver) {
		super(driver);
		logger.info("Starting of ClassplusLogin method");
		PageFactory.initElements(driver, this);
		logger.info("Ending of ClassplusLogin method");
	}

	public String getLoginHeadingText() {
		logger.info("Starting of getLoginHeadingText method");
		logger.info("Ending of getLoginHeadingText method");
		return lblLoginHeading.getText();
	}

	public void setOrgCode(String strOrgCode) {
		logger.info("Starting of setOrgCode method");

		this.orgCode.clear();
		this.orgCode.sendKeys(strOrgCode);

		logger.info("Ending of strOrgCode method");
	}

	public void setMobileNumber(String strMobileNumber) throws Exception {
		logger.info("Starting of setMobileNumber method");

		this.explicitWait(loginInput);

		this.loginInput.clear();
		this.loginInput.sendKeys(strMobileNumber);

		logger.info("Ending of setMobileNumber method");
	}

	public void setEmailAddress(String strEmailAddress) {
		logger.info("Starting of setEmailAddress method");

		this.explicitWait(emailInput);
		this.emailInput.clear();
		this.emailInput.sendKeys(strEmailAddress);

		logger.info("Ending of strEmailAddress method");
	}

	public void clickProceedSecurely() {
		logger.info("Starting of clickProceedSecurely method");

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		String xpath = langXPathsProperties.getProperty("loginpage.btn.proceed.secure.xpath");
		
		logger.debug("******** xPath from properties file ************ : "+xpath);
		
		this.proceedSecurely = driver.findElement(By.xpath(xpath));
		this.proceedSecurely.click();

		logger.info("Ending of clickProceedSecurely method");
	}

	public void clickForAlterantiveLogin() {
		logger.info("Starting of clickEmailInstead method");

		this.explicitWait(alternativeLogin);

		this.clickOnWebElement(alternativeLogin);

		logger.info("Ending of clickEmailInsted method");
	}

	public void loginToClassplusUsingMobileNumber(String strOrgCode, String strMobileNumber, String strEmailAddress) {
		logger.info("Starting of LoginToClassplusUsingMobileNumber method");
		try {
			this.setOrgCode(strOrgCode);
			this.setMobileNumber(strMobileNumber);
		} catch (Exception e) {
			this.setEmailAddress(strEmailAddress);
			this.clickForAlterantiveLogin();
			try {
				this.setMobileNumber(strMobileNumber);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		this.clickProceedSecurely();

		logger.info("Ending of LoginToClassplusUsingMobileNumber method");
	}

	public void loginToClassplusUsingEmailAddress(String strOrgCode, String strEmailAddress) {
		logger.info("Starting of loginToClassPlusUsingEmailAddress method");

		this.setOrgCode(strOrgCode);
		this.clickForAlterantiveLogin();
		this.setEmailAddress(strEmailAddress);
		this.clickProceedSecurely();

		logger.info("Ending of loginToClassPlusUsingEmailAddress method");
	}

	public void clickBackToLogin() {
		logger.info("Starting of clickBackToLoginPage method");

		this.backToLogin.click();

		logger.info("Ending of clickBackToLoginPage method");
	}

	public void setOTP(String strOTP) {
		logger.info("Starting of setOTP  method");

		this.explicitWait(otpInput);
		this.otpInput.sendKeys(strOTP);

		logger.info("Ending of setOTP method");
	}

	public void clickResendOTP() {
		logger.info("Starting of clickResendOTP methond");

		this.resendOTP.click();

		logger.info("Ending of clickResendOTP methond");
	}

	public void clickVerifyOTP() {
		logger.info("Starting of clickVerifyOTP method");

		this.explicitWait(verifyOTP);
		this.verifyOTP.click();

		logger.info("Ending of clickVerifyOTP method");
	}

	public void clickOnListBox() {
		logger.info("Starting of clickOnListBox method");

		this.clickOnWebElement(listBox);

		logger.info("Ending of clickOnListBox method");
	}

	public void clickOnLogOut() {			
		logger.info("Starting of clickOnLogOut method ");

		this.clickOnWebElement(userProfileIcon);
		this.explicitWait(logOut);
		this.clickOnWebElement(logOut);
		this.clickOnOk();

		logger.info("Ending of clickOnLogOut method");
	}

	public void clickOnOk() {
		logger.info("Starting of clickOnOK method");
		try {
			this.explicitWait(ok);
			this.ok.click();
		} catch (Exception e) {
			this.clickOnWebElement(ok);
		}
		logger.info("Ending of clickOnOk method");
	}

	public String getInvalidOrgCodeErrorMessage() {
		logger.info("Starting of getInvalidOrgCode method");
		logger.info("Ending of getInvalidOrgCode method");
		return invalidOrgCode.getText();
	}

	public String getInvalidMobileNumberErrorMessage() {
		logger.info("Starting of getInvalidMobileNumber method");
		logger.info("Ending of getInvalidMobileNumber method");
		return loginErrorMessage.getText();
	}

	public String getInvalidEmailAddressErrorMessage() {
		logger.info("Starting of getInvalidEmailAddressErrorMessage method");
		logger.info("Ending of getInvalidEmailAddressErrorMessage method");
		return loginErrorMessage.getText();
	}

	public String getPageTitle(WebDriver driver) {
		logger.info("Starting of getPageTitle method");
		logger.info("Ending of getPageTitle method");
		return driver.getTitle();
	}

	public String getOTPSentMessageText() {
		logger.info("Starting of getOTPSentMessageText method");

		String otpMessageText = this.otpSentMessage.getText();
		logger.info("Ending of getOTPSentMessageText method");
		return otpMessageText;
	}

	public String getOTPVerifiedMessageText() {
		logger.info("Starting of getOTPVerifiedMessageText method");

		// this.explicitWait(otpVerifiedMessage);

		String otpVerifiedMessageText = this.otpVerifiedMessage.getText();
		logger.info("Ending of getOTPVerifiedMessageText method");
		return otpVerifiedMessageText;
	}

	public String getOTPHeadingText() {
		logger.info("Starting of getOTPHeadingText method");

		this.explicitWait(otpHeading);
		String otpHeadingText = this.otpHeading.getText();
		logger.info("Ending of getOTPHeadingText method");
		return otpHeadingText;
	}

	public String getErrorMessageText() {
		logger.info("Starting of getErrorMessageText method");

		this.explicitWait(errorMessage);

		String errorMessageText = this.errorMessage.getText();
		logger.info("Ending of getErrorMessageText method");
		return errorMessageText;
	}

	public String getLoginToAccountText() {
		logger.info("Starting of getLoginToAccountText method");

		this.explicitWait(loginToAccount);
		// remove variable and put this.loginToAccount.getText(); directly in return
		// statement

		String loginToAccountText = this.loginToAccount.getText();

		logger.info("Ending of getLoginToAccountText method");
		return loginToAccountText;
	}

	public String getDashBoardText() {
		logger.info("Starting of getDashBoardText method");

		this.explicitWait(dashBoard);
		// remove variable and put this.dashBoard.getText(); directly in return
		// statement
		String dashBoardText = this.dashBoard.getText();

		logger.info("Ending of getDashBoardText method");
		return dashBoardText;
	}

	public String getLogoutConfirmMessageText() {
		logger.info("Starting of getLogoutConfirmMessageText method");

		this.explicitWait(logoutConfirmMessage);

		// remove variable and put this.logoutConfirmMessage.getText(); directly in
		// return statement
		String logoutConfirmMessageText = this.logoutConfirmMessage.getText();
		logger.info("Ending of getLogoutConfirmMessageText method");
		return logoutConfirmMessageText;
	}
}
