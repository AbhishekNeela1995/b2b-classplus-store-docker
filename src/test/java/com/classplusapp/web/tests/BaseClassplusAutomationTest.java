package com.classplusapp.web.tests;

import static com.classplusapp.store.util.Constants.LABEL_LOGIN_HEADING;
import static com.classplusapp.store.util.Constants.LABEL_OTP_HEADING;
import static com.classplusapp.store.util.Constants.LABEL_STORE_MYCOURSES;
import static com.classplusapp.store.util.Constants.LOGIN_OTP;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.function.Function;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.classplusapp.store.util.AutomationUtil;
import com.classplusapp.store.util.Constants;
import com.classplusapp.store.util.ExecutionMode;
import com.classplusapp.store.util.TestListener;
import com.classplusapp.web.pages.ClassplusLoginPage;
import com.classplusapp.web.pages.tutor.TutorCreateCoursePage;
import com.classplusapp.web.pages.tutor.TutorEditCoursePage;

import io.github.bonigarcia.wdm.WebDriverManager;

@Listeners(TestListener.class)
public class BaseClassplusAutomationTest {

	protected static final String BASE_DIR = System.getProperty("user.dir");
	protected static final String FILE_SEPARATOR = System.getProperty("file.separator");

	protected static String browserDriverPath = null;
	private static String loginURL = "http://wl-ui-5.staging.classplus.co/login";
	protected ClassplusLoginPage loginPage = null;
	protected TutorCreateCoursePage tutorCreateCoursePage = null;
	protected TutorCreateCoursePage tutorCreateCoursePageFaculty;

	protected TutorEditCoursePage tutorEditCoursePage = null;
	protected static Map<String, String> chromeDriverMap = new HashMap<String, String>();
	private static final Logger logger = Logger.getLogger(BaseClassplusAutomationTest.class.getName());
	protected static Properties testDataProp = null;
	protected static Properties expectedAssertionsProp = null;
	protected static Properties langXPathsProp = null;

	private static Map<WEB_DRIVER, WebDriver> webDriverPool = new Hashtable<WEB_DRIVER, WebDriver>();
	protected WebDriver childWebDriver = null;

	// protected static final String orgCode = System.getProperty("org_code")!=null
	// ? System.getProperty("org_code") : "learn";
	protected static final String emailAddress = System.getProperty("store_email_address") != null
			? System.getProperty("store_email_address")
			: "gunjan@classplusapp.com";
	protected static final String tutorMobileNumber = System.getProperty("store_tutor_mobile_number") != null
			? System.getProperty("store_tutor_mobile_number")
			: "9711153079";
	protected static final String studentMobileNumber = System.getProperty("store_student_mobile_number") != null
			? System.getProperty("store_student_mobile_number")
			: "7290085267";
	protected static final String facultyOneMobileNumber = System.getProperty("store_faculty_mobile_number") != null
			? System.getProperty("store_faculty_mobile_number")
			: "9966119838";
	protected static final String parentMobileNumber = System.getProperty("store_parent_mobile_number") != null
			? System.getProperty("store_parent_mobile_number")
			: "9899805993";
	protected static final String facultyTwoMobileNumber = System.getProperty("store_faculty_two_mobile_number") != null
			? System.getProperty("store_faculty_two_mobile_number")
			: "9885672403";

	protected static final String tutorTwoMobileNumber = System.getProperty("store_tutor_two_mobile_number") != null
			? System.getProperty("store_tutor_two_mobile_number")
			: "6868594886";

	protected enum WEB_DRIVER {
		LOGIN_DRIVER_TEST, CREATE_BATCH_DRIVER_TEST, FACULTY_ADD_CONTENT_TEST, CONTENT_MARKET_TEST, COUPON_CODE_TEST,
		CREATE_COURSE_TEST, STUDENT_BUY_COURSE_TEST, STUDENT_VIEW_CONTENT_TEST, CUSTOM_BANNER_TEST,
		PARENT_BUY_COURSE_TEST, PARENT_VIEW_CONTENT_TEST, ADD_CONTENT_TEST, EDIT_COURSE_TEST, MARK_FEATURED_TEST,
		NOTIFICATION_TEST, TUTOR_DASHBOARD, COURSE_OVERVIEW_TEST_STUDENT, COURSE_OVERVIEW_TEST_TUTOR,
		RESELLER_SETTINGS_TEST, ANNOUNCEMENT_TEST, STUDENT_SORTING_TEST, CREATE_INSTALLMENT_TEST,
		MERCHANT_DASHBOARD_TEST, STUDENT_BUY_INSTALLMENT_COURSE_TEST, PHYSICAL_SHIPMENT_COURSE_TEST,
		TUTOR_CREATE_COURSE_AUTOMATION_TESTING, STUDENT_COURSE_OVERVIEW_TEST, TUTOR_WEBSITE,
		STUDENT_PAYMENT_IN_INSTALLMENT_TEST, PAYIN_INSTALLMENT_TEST, CREATE_NEWCOURSE_TEST, TUTOR_TRIAL_CLASS,
		FACULTY_ANNOUNCEMENT_TEST, TUTOR_DRIVER, SEARCH_COURSE_DRIVER, FACULTY_TRIAL_CLASS, TUTOR_STUDENT_ADDING_TEST,
		COURSE_SORT_FILTER_TEST
	}

	@BeforeSuite
	@Parameters({ "siteURL", "language" })
	public void initTestData1(@Optional("https://webp-gcp.classplusapp.com") String siteURL,
			@Optional("en") String lang) {

		if (siteURL != null) {
			loginURL = siteURL;
		}

		if (testDataProp == null) {
			FileReader testDataReader = null;
			FileReader assertionsReader = null;
			FileReader langxPathReader = null;

			try {

				String testDataFile = AutomationUtil.getLanguageFilePath(Constants.TEST_DATA_PROPERTIES, lang);
				logger.debug("Test data properties file " + testDataFile);
				testDataReader = new FileReader(testDataFile);
				testDataProp = new Properties();
				testDataProp.load(testDataReader);

				String expectedAssertionFile = AutomationUtil
						.getLanguageFilePath(Constants.EXPECTED_ASSERTIONS_PROPERTIES, lang);
				logger.debug("Expected assertions properties file " + expectedAssertionFile);
				assertionsReader = new FileReader(expectedAssertionFile);
				expectedAssertionsProp = new Properties();
				expectedAssertionsProp.load(assertionsReader);

				String langxPathFile = AutomationUtil.getLanguageFilePath(Constants.LANG_XPATHS_PROPERTIES, lang);
				logger.debug("Expected assertions properties file " + langxPathFile);
				langxPathReader = new FileReader(langxPathFile);
				langXPathsProp = new Properties();
				langXPathsProp.load(langxPathReader);

			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					testDataReader.close();
					assertionsReader.close();
					langxPathReader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		logger.debug("Site URL : " + loginURL);
	}

	protected synchronized void quitDriver(WebDriver driver, WEB_DRIVER webDriver) {
		logger.info("Starting of method quitDriver in BaseClassplusAutomationTest ");

		try {
			if (driver != null) {
				// driver.close();
				driver.quit();
				driver = null;
				webDriverPool.remove(webDriver);
				logger.debug(webDriver + " Web driver quit successfully in BaseClassplusAutomationTest ");
			}
		} catch (Exception ex) {
			logger.error(ex.getMessage());
			driver = null;
		}
		logger.info("Ending of method quitDriver in BaseClassplusAutomationTest");
	}

	/**
	 * This method is used for get driver
	 * 
	 * @param webDriver
	 * @return
	 * @throws MalformedURLException 
	 */

	protected synchronized WebDriver getWebDriver(String browser, WEB_DRIVER webDriver) throws MalformedURLException {
		logger.info("Starting of method getWebDriver");

		WebDriver driver = webDriverPool.get(webDriver);
		
		ITestContext ctx = null;

		if (System.getProperty("REMOTE_DRIVER") != null && System.getProperty("REMOTE_DRIVER").equalsIgnoreCase("true")) {

			String host = "localhost";
			MutableCapabilities dc;

			if (System.getProperty("BROWSER") != null && System.getProperty("BROWSER").equalsIgnoreCase("firefox")) {
				dc = new FirefoxOptions();
			} else {
				dc = new ChromeOptions();
			}

			if (System.getProperty("HUB_HOST") != null) {
				host = System.getProperty("HUB_HOST");
			}

			String testName = ctx.getCurrentXmlTest().getName();

			String completeUrl = "http://" + host + ":4444/wd/hub";
			dc.setCapability("name", testName);
			driver = new RemoteWebDriver(new URL(completeUrl), dc);

		} else {

			String osPath = System.getProperty("os.name");

			// Use existing driver
			if (driver != null) {
				logger.debug("Using existing web driver " + webDriver);
				return driver;

			}

			if (osPath.contains("Linux")) {

				if (browser.equalsIgnoreCase("Firefox")) {
					WebDriverManager.firefoxdriver().setup();
					FirefoxOptions options = new FirefoxOptions();
					options.setHeadless(true);
					options.addArguments("--no-sandbox");
					driver = new FirefoxDriver(options);
				} else if (browser.equalsIgnoreCase("Chrome")) {
					WebDriverManager.chromedriver().setup();

					ChromeOptions options = new ChromeOptions();

					options.addArguments("enable-automation");
					options.addArguments("--headless");
					options.addArguments("--no-sandbox");
					// options.addArguments("--disable-extensions");
					options.addArguments("--dns-prefetch-disable");
					options.addArguments("--disable-gpu");
					options.setPageLoadStrategy(PageLoadStrategy.NORMAL);

					options.setHeadless(true);
					options.addArguments("--headless"); // Bypass OS security model, MUST BE THE VERY FIRST OPTION
					options.addArguments("--window-size=1920,1080");
					options.setPageLoadStrategy(PageLoadStrategy.EAGER);// del
					options.addArguments("--disable-browser-side-navigation"); // del
					options.addArguments("--disable-dev-shm-usage"); // del
					options.addArguments("--disable-gpu");
					options.addArguments("--no-sandbox");

					options.addArguments("load-extension=extension_2_3_164.crx");

					// options.setBinary("/opt/google/chrome/google-chrome");
					Map<String, Object> prefs = new HashMap<String, Object>();
					prefs.put("profile.default_content_settings.popups", 0);
					options.setExperimentalOption("prefs", prefs);

					DesiredCapabilities capabilities = new DesiredCapabilities();
					capabilities.setBrowserName("CHROME");
					capabilities.setCapability(ChromeOptions.CAPABILITY, options);
					capabilities.setCapability(CapabilityType.SUPPORTS_NETWORK_CONNECTION, true);
					capabilities.setCapability("applicationCacheEnabled", "true");

					driver = new ChromeDriver(options);

				}
			}

			else {

				if (browser.equalsIgnoreCase("Chrome")) {
					WebDriverManager.chromedriver().setup();
					ChromeOptions options = new ChromeOptions();
					options.addArguments("enable-automation");
					// options.addArguments("--headless");
					options.addArguments("--no-sandbox");
					// options.addArguments("--disable-extensions");
					options.addArguments("--dns-prefetch-disable");
					options.addArguments("--disable-gpu");
					options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
					options.addExtensions(new File("extension_2_3_164.crx"));

					driver = new ChromeDriver(options);

				} else if (browser.equalsIgnoreCase("Firefox")) {
					WebDriverManager.firefoxdriver().setup();
					driver = new FirefoxDriver();

				} else if (browser.equalsIgnoreCase("Chromium")) {
					WebDriverManager.chromiumdriver().setup();
					driver = new EdgeDriver();

				} else if (browser.equalsIgnoreCase("IEDriverServer")) {
					WebDriverManager.iedriver().setup();
					driver = new InternetExplorerDriver();

				}
			}

			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

			logger.info("****** Driver Successfully Created ******* " + driver.getTitle());

			logger.info("End of method getWebDriver");

		}

		webDriverPool.put(webDriver, driver);
		return driver;
	}

	public void siteLogin(String strOrgCode, String strMobileNumber, String strEmailAddress, WebDriver driver) {
		logger.info("Starting of siteLogin method");

		driver.get(loginURL);
		String lblLoginHeading = this.loginPage.getLoginHeadingText();
		Assert.assertEquals(lblLoginHeading, expectedAssertionsProp.getProperty(LABEL_LOGIN_HEADING));
		this.childWebDriver = driver;
		String xPath = "//input[@class='accountLogin-input accountLogin-input-mobile']";
		this.fluentWaitForElement(driver, xPath);
		this.loginPage.clickOutside();
		this.loginPage.loginToClassplusUsingMobileNumber(strOrgCode, strMobileNumber, strEmailAddress);

		logger.info("Ending of siteLogin method");
	}

	public void goToSite(WebDriver driver) throws Exception {

		logger.debug("Login URL" + loginURL);

		driver.get(loginURL);
	}

	public void logBrowserConsoleErrors(WebDriver driver) {
		LogEntries logentries = driver.manage().logs().get(LogType.BROWSER);
		for (LogEntry logentrey : logentries) {
			logger.error("===========================");
			logger.error(logentrey);
			logger.error("===========================");
		}
	}

	public WebDriver getChildWebDriver() {
		return this.childWebDriver;
	}

	protected WebDriver loginClassPlusSite(String browser, String orgCode, String mobileNumber, String emailAddress,
			WEB_DRIVER driverKey) throws Exception {
		WebDriver childDriver = this.getWebDriver(browser, driverKey);
		this.initClassplusSiteLogin(browser, childDriver);
		this.testLoginSiteUI(orgCode, mobileNumber, emailAddress, childDriver);
		this.testVerifyOTP(childDriver);
		// this.testClickOnStoreButton(childDriver);
		return childDriver;
	}

	public void initClassplusSiteLogin(String browser, WebDriver childDriver) throws Exception {
		logger.info("Starting of initClassplusSiteLogin methond");

		// this.goToSite(childDriver);
		this.loginPage = new ClassplusLoginPage(childDriver);
		this.loginPage.setLanguageXPathProperties(langXPathsProp);

		logger.info("Ending of initClassplusSiteLogin method");
	}

	public void testLoginSiteUI(String orgCode, String mobileNumber, String emailAddress, WebDriver childDriver) {
		logger.info("Starting of LoginToSite method");
		try {
			this.siteLogin(orgCode, mobileNumber, emailAddress, childDriver);

		} catch (Exception e) {
			Assert.fail("Exception occured while testing LoginTosite: " + e.getMessage());
			logger.error("Error occured while testing the LoginTosite   ", e);
		}

		logger.info("Ending of LoginTo Site method");
	}

	public void fluentWaitForElement(WebDriver childDriver, String xPath) {

		try {

			// Reference : https://www.guru99.com/implicit-explicit-waits-selenium.html
			Wait<WebDriver> wait = new FluentWait<WebDriver>(childDriver).withTimeout(Duration.ofSeconds(5))
					.pollingEvery(Duration.ofSeconds(5)).ignoring(Exception.class);

			wait.until(new Function<WebDriver, WebElement>() {
				public WebElement apply(WebDriver driver) {
					return driver.findElement(By.xpath(xPath));
				}
			});

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void testVerifyOTP(WebDriver childDriver) {
		logger.info("Starting of testVerifyOTP method");
		try {

			String xPath = "//p[contains(text(),'Enter OTP here')]";
			this.fluentWaitForElement(childDriver, xPath);

			String getOTPHeadingText = this.loginPage.getOTPHeadingText();
			Assert.assertEquals(getOTPHeadingText, expectedAssertionsProp.getProperty(LABEL_OTP_HEADING));

			this.loginPage.setOTP(testDataProp.getProperty(LOGIN_OTP));
			this.loginPage.clickVerifyOTP();

			/*
			 * String getOTPVerifiedText = this.loginPage.getOTPVerifiedMessageText();
			 * Assert.assertEquals(getOTPVerifiedText,
			 * expectedAssertionsProp.getProperty(LOGIN_OTP_SUCCESS_MESSAGE));
			 */

		} catch (Exception e) {
			Assert.fail("Exception occured while testing VerifyOTP: " + e.getMessage());
			logger.error("Error occured while testing the VerifyOTP  ", e);
		}
		logger.info("Ending of testVerifyOTP method");
	}

	protected WebDriver clickOnStoreButton(WebDriver childDriver, String search) throws Exception {

		this.testClickOnStoreButton(childDriver, search);
		return childDriver;
	}

	public void testClickOnStoreButton(WebDriver childDriver, String search) {
		logger.info("Starting of testStoreButton method");

		try {
			this.tutorCreateCoursePage = new TutorCreateCoursePage(childDriver);
			this.tutorEditCoursePage = new TutorEditCoursePage(childDriver);
			String xPath = "//p[text()='Store']";
			this.fluentWaitForElement(childDriver, xPath);

			this.tutorCreateCoursePage.clickOnStoreButton();

			Thread.sleep(2000);
			String myCoursesLabel = this.tutorCreateCoursePage.getMyCourses();
			Assert.assertEquals(myCoursesLabel, expectedAssertionsProp.getProperty(LABEL_STORE_MYCOURSES));

			this.tutorEditCoursePage.setSearchCourse(search);

		} catch (Exception e) {
			Assert.fail("Exception occured while testing StoreButton: " + e.getMessage());
			logger.error("Error occured while testing the StoreButton  ", e);
		}
		logger.info("Ending of testStoreButton method");
	}

	protected boolean isHeadless() {

		if (ExecutionMode.HEAD.getMode())
			return true;
		else
			return false;

	}

	public List<String> getPropertyList(String name) {
		List<String> list = Arrays.asList(name.toString().split("\\,"));
		System.out.println(list);
		return list;
	}

	public void clickOutside(WebDriver driver) {
		logger.info("Starting of clickOutside method");

		Actions action = new Actions(driver);
		action.moveByOffset(100, 100).click().build().perform();

		logger.info("Ending of clickOutside method");
	}

	public void hardWait(int seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}
	}

}
