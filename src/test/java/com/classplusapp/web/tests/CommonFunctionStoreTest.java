package com.classplusapp.web.tests;
import static com.classplusapp.store.util.Constants.*;

import static com.classplusapp.store.util.Constants.ADDCONTENT_IMAGE_DESCRIPTION;
import static com.classplusapp.store.util.Constants.ADDCONTENT_IMAGE_NAME;
import static com.classplusapp.store.util.Constants.ADDCONTENT_SUBJECTIVETEST_TESTNAME;
import static com.classplusapp.store.util.Constants.ADDCONTENT_SUBJECTIVETEST_TOTALMARKS;
import static com.classplusapp.store.util.Constants.ADDCONTENT_ZIPFILE_DESCRIPTION;
import static com.classplusapp.store.util.Constants.ADDCONTENT_ZIPFILE_NAME;
import static com.classplusapp.store.util.Constants.APPLIED_SUCCESSFULLY_TEXT;
import static com.classplusapp.store.util.Constants.APPLY_COUPON_HEADER;
import static com.classplusapp.store.util.Constants.CONTENTMARKET_ANNOUNCEMENT_EDIT_MAKEANNOUNCE_TEXT;
import static com.classplusapp.store.util.Constants.CONTENTMARKET_ANNOUNCEMENT_MAKEANNOUNCE_EXCEL;
import static com.classplusapp.store.util.Constants.CONTENTMARKET_SEARCH_COURSE;
import static com.classplusapp.store.util.Constants.COUPONCODE_MAXIMUM_PERCENTAGE_DISCOUNT;
import static com.classplusapp.store.util.Constants.COUPONCODE_MIN_ORDER_VALUE;
import static com.classplusapp.store.util.Constants.COUPONCODE_OFFER_NAME;
import static com.classplusapp.store.util.Constants.COUPONCODE_PERCENTAGE_DISCOUNT;
import static com.classplusapp.store.util.Constants.COUPONCODE_SEARCH_STUDENT;
import static com.classplusapp.store.util.Constants.COUPONCODE_SET_COUPONCODE;
import static com.classplusapp.store.util.Constants.COUPONCODE_STUDENT_SEARCH_COURSE;
import static com.classplusapp.store.util.Constants.COUPONCODE_TOTAL_LIMIT;
import static com.classplusapp.store.util.Constants.COUPONCODE_USER_LIMIT;
import static com.classplusapp.store.util.Constants.CRAETE_INSTALLMENT_EDIT_TOTALINSTALLMENT;
import static com.classplusapp.store.util.Constants.CREATECOURSE_FACULTY_TITLE;
import static com.classplusapp.store.util.Constants.CREATECOURSE_PRICE_FOR_AUTOMATION_TESTING;
import static com.classplusapp.store.util.Constants.CREATECOURSE_PRICE_FOR_TUTOR_AUTOMATION_TESTING;
import static com.classplusapp.store.util.Constants.CREATE_INSTALLMENT_EDIT_LAST_TOTALINSTALLMENT;
import static com.classplusapp.store.util.Constants.CREATE_INSTALLMENT_EDIT_MAX_TOTALINSTALLMENT;
import static com.classplusapp.store.util.Constants.FACULTY_HEADER_LABEL;
import static com.classplusapp.store.util.Constants.IMAGE_ADDED_SUCCESSFULLY_TEXT;
import static com.classplusapp.store.util.Constants.LABEL_ANNOUNCEMENT__DELETE_TEXT;
import static com.classplusapp.store.util.Constants.LABEL_CREATECOURSE_DESCRIPTION_FOR_AUTOMATION_TESTING;
import static com.classplusapp.store.util.Constants.LABEL_CREATECOURSE_PRE_TITLE_FOR_AUTOMATION_TESTING;
import static com.classplusapp.store.util.Constants.LABEL_CREATECOURSE_WITH_COUPON_TESTING;
import static com.classplusapp.store.util.Constants.LABEL_CREATECOURSE_WITH_PHYSICAL_SHIPMENT;
import static com.classplusapp.store.util.Constants.LABEL_FOR_UPLOADING_IMAGE;
import static com.classplusapp.store.util.Constants.LABEL_FOR_UPLOADING_PDF;
import static com.classplusapp.store.util.Constants.LABEL_FOR_UPLOADING_VIDEO;
import static com.classplusapp.store.util.Constants.LABEL_FOR_UPLOADING_ZIP;
import static com.classplusapp.store.util.Constants.LABEL_GROUP_STUDY;
import static com.classplusapp.store.util.Constants.LABEL_MAKE_ANNOUNCEMENT;
import static com.classplusapp.store.util.Constants.LABEL_NUMBER_OF_INSTALLMENTS_IN_TESTING_COURSE;
import static com.classplusapp.store.util.Constants.NEW_TUTOR_SEARCH_COUPON;
import static com.classplusapp.store.util.Constants.REMOVE_CONFIRMATION_HEADER;
import static com.classplusapp.store.util.Constants.STUDENT_VIEW_CONTENT_SEARCH_COURSE;
import static com.classplusapp.store.util.Constants.SUBJECTIVETEST_TESTNAME;
import static com.classplusapp.store.util.Constants.TRIAL_CLASS_EDIT_TOPIC_TEXT;
import static com.classplusapp.store.util.Constants.TRIAL_CLASS_TOPIC_TEXT;
import static com.classplusapp.store.util.Constants.TUTOR_EFFECTIVEPRICE_AUTOMATION_TESTING;
import static com.classplusapp.store.util.Constants.TUTOR_NEWWEBSITE_AUTOMATION_TESTING;
import static com.classplusapp.store.util.Constants.TUTOR_PAYMENT_AUTOMATION_TESTING;
import static com.classplusapp.store.util.Constants.TUTOR_PHYSICAL_AUTOMATION_TESTING;
import static com.classplusapp.store.util.Constants.TUTOR_STUDENT_ADDING_COURSE_TESTING;
import static com.classplusapp.store.util.Constants.TXT_FACULTY_MOBILE_NUMBER;
import static com.classplusapp.store.util.Constants.TXT_FACULTY_NAME;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Optional;

import com.classplusapp.web.pages.faculty.TutorAddingFacultyToCoursePage;
import com.classplusapp.web.pages.newtutor.TutorCoursesHomePage;
import com.classplusapp.web.pages.student.StudentBuyCoursePage;
import com.classplusapp.web.pages.student.StudentPhysicalShipmentPage;
import com.classplusapp.web.pages.student.StudentViewContentPage;
import com.classplusapp.web.pages.tutor.TutorAddContentPage;
import com.classplusapp.web.pages.tutor.TutorAnnouncementPage;
import com.classplusapp.web.pages.tutor.TutorContentMarketPage;
import com.classplusapp.web.pages.tutor.TutorCouponCodePage;
import com.classplusapp.web.pages.tutor.TutorCourseSortFilterPage;
import com.classplusapp.web.pages.tutor.TutorCreateCoursePage;
import com.classplusapp.web.pages.tutor.TutorCreateInstallmentPage;
import com.classplusapp.web.pages.tutor.TutorEditCoursePage;
import com.classplusapp.web.pages.tutor.TutorMarkFeaturedPage;
import com.classplusapp.web.pages.tutor.TutorMerchantDashboardPage;
import com.classplusapp.web.pages.tutor.TutorStudentAddingPage;
import com.classplusapp.web.pages.tutor.TutorStudentSortingPage;
import com.classplusapp.web.pages.tutor.TutorTrialClassPage;

public class CommonFunctionStoreTest extends BaseClassplusAutomationTest {

	private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yy/MM/dd-HH:mm:ss");
	private static final Logger logger = Logger.getLogger(CommonFunctionStoreTest.class.getName());

	public String createSimpleCourse(TutorCreateCoursePage createCoursePage) {
		String currentDateTime = dtf.format(LocalDateTime.now());
		String courseName = testDataProp.getProperty(LABEL_CREATECOURSE_PRE_TITLE_FOR_AUTOMATION_TESTING)
				+ currentDateTime;
		createCoursePage.clickOnStoreButton();
		this.hardWait(2);
		createCoursePage.clickOnCreateCourseButton();
		createCoursePage.getCreateCourseLabel();
		this.hardWait(2);

		// createCoursePage.setCourseName(courseName);//
		// String currentDateTime=dtf.format(LocalDateTime.now());
		createCoursePage.setCourseName(testDataProp.getProperty(CREATECOURSE_FACULTY_TITLE) + currentDateTime);
		createCoursePage
				.setDescription(testDataProp.getProperty(LABEL_CREATECOURSE_DESCRIPTION_FOR_AUTOMATION_TESTING));
		createCoursePage.clickOnCategoryDropdown();
		createCoursePage.setCategory();
		createCoursePage.setPrice(testDataProp.getProperty(CREATECOURSE_PRICE_FOR_AUTOMATION_TESTING));
		createCoursePage.clickOnTermsAndConditionCheckBox();
		createCoursePage.clickOnAddContentButton();
		return testDataProp.getProperty(CREATECOURSE_FACULTY_TITLE) + currentDateTime;
	}

	public String createSimpleCourseWithoutInternetCharges(TutorCreateCoursePage createCoursePage) {
		createCoursePage.clickOnStoreButton();
		createCoursePage.clickOnCreateCourseButton();
		String currentDateTime = dtf.format(LocalDateTime.now());
		createCoursePage.setCourseName(
				testDataProp.getProperty(LABEL_CREATECOURSE_PRE_TITLE_FOR_AUTOMATION_TESTING) + currentDateTime);
		createCoursePage
				.setDescription(testDataProp.getProperty(LABEL_CREATECOURSE_DESCRIPTION_FOR_AUTOMATION_TESTING));
		createCoursePage.clickOnCategoryDropdown();
		createCoursePage.setCategory();
		createCoursePage.setPrice(testDataProp.getProperty(CREATECOURSE_PRICE_FOR_TUTOR_AUTOMATION_TESTING));
		createCoursePage.clickOnLifeTimeDurationRadioButton();

		createCoursePage.clickOnInternetChargesToggle();
		createCoursePage.clickOnTermsAndConditionCheckBox();
		createCoursePage.clickOnAddContentButton();
		return testDataProp.getProperty(LABEL_CREATECOURSE_PRE_TITLE_FOR_AUTOMATION_TESTING) + currentDateTime;
	}

	public void addContentImage(TutorCreateCoursePage createCoursePage) throws InterruptedException {
		Thread.sleep(2000);
		createCoursePage.uploadImageOnContent();
	}

	public void addCourseContent(TutorAddContentPage addContentPage, String contentType) throws InterruptedException {

		if (contentType.equals(testDataProp.getProperty(LABEL_FOR_UPLOADING_IMAGE))) {
			addContentPage.clickOnMenuImageIcon();
			addContentPage.setTextImageName(testDataProp.getProperty(ADDCONTENT_IMAGE_NAME));
			addContentPage.setTextImageDescription(testDataProp.getProperty(ADDCONTENT_IMAGE_DESCRIPTION));
			addContentPage.setUploadImageButton();
			addContentPage.clickOnUploadImgButton();
		} else if (contentType.equals(testDataProp.getProperty(LABEL_FOR_UPLOADING_PDF))) {
			addContentPage.clickOnMenuDocumentIcon();
			addContentPage.clickOnSelectDocumentButton();
			addContentPage.clickOnUploadDocumentButton();
		} else if (contentType.equals(testDataProp.getProperty(LABEL_FOR_UPLOADING_VIDEO))) {

			addContentPage.clickOnMenuAddVideoIcon();
			Thread.sleep(4000);
			String path = addContentPage.TEST_FILE_PATH + File.separator + "testdata" + File.separator
					+ "contentvideo.mp4";
			System.out.println(path);
			addContentPage.uploadVideoButton(path);
			Thread.sleep(4000);
			addContentPage.clickOnDoneButton();
			addContentPage.clickOnYesEnablePreview();

		} else if (contentType.equals(testDataProp.getProperty(LABEL_FOR_UPLOADING_ZIP))) {
			addContentPage.clickOnMenuZipIcon();
			addContentPage.setTextFileName(testDataProp.getProperty(ADDCONTENT_ZIPFILE_NAME));
			addContentPage.setTextDescription(testDataProp.getProperty(ADDCONTENT_ZIPFILE_DESCRIPTION));
			addContentPage.clickOnChooseFileButton();
			addContentPage.clickOnUploadZipButton();
		}

	}

	public void publishCourse(TutorCreateCoursePage createCoursePage) {
		createCoursePage.clickOnPublishButton();
		createCoursePage.clickOnCnfrmPublishButton();
		createCoursePage.closeCoursePublishedSuccessPopup();
	}

	public String createPhysicalShipmentCourses(TutorCreateCoursePage createCoursePage) {
		createCoursePage.clickOnStoreButton();
		createCoursePage.clickOnCreateCourseButton();
		String currentDateTime = dtf.format(LocalDateTime.now());
		createCoursePage.setCourseName(
				testDataProp.getProperty(LABEL_CREATECOURSE_PRE_TITLE_FOR_AUTOMATION_TESTING) + currentDateTime);
		createCoursePage
				.setDescription(testDataProp.getProperty(LABEL_CREATECOURSE_DESCRIPTION_FOR_AUTOMATION_TESTING));
		createCoursePage.clickOnCategoryDropdown();
		createCoursePage.setCategory();
		createCoursePage.setPrice(testDataProp.getProperty(CREATECOURSE_PRICE_FOR_AUTOMATION_TESTING));
		createCoursePage.clickOnOfflineMaterial();
		createCoursePage.clickOnTermsAndConditionCheckBox();
		createCoursePage.clickOnAddContentButton();
		return testDataProp.getProperty(LABEL_CREATECOURSE_PRE_TITLE_FOR_AUTOMATION_TESTING) + currentDateTime;
	}

	public String offlineMaterialForShipmentOn(TutorCreateCoursePage createCoursePage) {
		String currentDateTime = dtf.format(LocalDateTime.now());
		logger.info("starting of offlineMaterialForShipmentOn method");

		createCoursePage.clickOnStoreButton();
		createCoursePage.clickOnCreateCourseButton();
		createCoursePage.getCreateCourseLabel();
		createCoursePage.setCourseName(
				testDataProp.getProperty(LABEL_CREATECOURSE_PRE_TITLE_FOR_AUTOMATION_TESTING) + currentDateTime);
		createCoursePage.setDescription(
				testDataProp.getProperty(LABEL_CREATECOURSE_PRE_TITLE_FOR_AUTOMATION_TESTING) + currentDateTime);
		createCoursePage.clickOnUploadImageButton();
		createCoursePage.clickOnCategoryDropdown();
		createCoursePage.setCategory();
		createCoursePage.clickOnSubCategoryDropdown();
		createCoursePage.setSubCategory();
		createCoursePage.setPrice(testDataProp.getProperty(CREATECOURSE_PRICE_FOR_AUTOMATION_TESTING));
		createCoursePage.clickOnOfflineMaterial();
		createCoursePage.clickOnTermsAndConditionCheckBox();
		createCoursePage.clickOnAddContentButton();
		logger.info("ending of offlineMaterialForShipmentOn method");
		return testDataProp.getProperty(LABEL_CREATECOURSE_PRE_TITLE_FOR_AUTOMATION_TESTING) + currentDateTime;

	}

	public String offlineMaterialForShipmentOff(TutorCreateCoursePage createCoursePage) {
		logger.info("starting of offlineMaterialForShipmentOff method");
		String currentDateTime = dtf.format(LocalDateTime.now());
		createCoursePage.clickOnStoreButton();
		createCoursePage.getMyCourses();
		createCoursePage.clickOnCreateCourseButton();
		createCoursePage.getCreateCourseLabel();
		createCoursePage.setCourseName(
				testDataProp.getProperty(LABEL_CREATECOURSE_PRE_TITLE_FOR_AUTOMATION_TESTING) + currentDateTime);
		createCoursePage.setDescription(
				testDataProp.getProperty(LABEL_CREATECOURSE_PRE_TITLE_FOR_AUTOMATION_TESTING) + currentDateTime);
		createCoursePage.clickOnUploadImageButton();
		createCoursePage.clickOnCategoryDropdown();
		createCoursePage.setCategory();
		createCoursePage.clickOnSubCategoryDropdown();
		createCoursePage.setSubCategory();
		createCoursePage.setPrice(testDataProp.getProperty(CREATECOURSE_PRICE_FOR_AUTOMATION_TESTING));
		createCoursePage.clickOnTermsAndConditionCheckBox();
		createCoursePage.clickOnAddContentButton();

		logger.info("Ending of offlineMaterialForShipmentOff method");

		return testDataProp.getProperty(LABEL_CREATECOURSE_PRE_TITLE_FOR_AUTOMATION_TESTING) + currentDateTime;
	}

	public String tentativeDeliveryAvailable(TutorCreateCoursePage createCoursePage) throws InterruptedException {
		logger.info("Starting of tentativeDeliveryAvailable method");
		String currentDateTime = dtf.format(LocalDateTime.now());
		createCoursePage.clickOnStoreButton();
		createCoursePage.getMyCourses();
		createCoursePage.clickOnCreateCourseButton();
		createCoursePage.getCreateCourseLabel();
		createCoursePage.setCourseName(
				testDataProp.getProperty(LABEL_CREATECOURSE_PRE_TITLE_FOR_AUTOMATION_TESTING) + currentDateTime);
		createCoursePage.setDescription(
				testDataProp.getProperty(LABEL_CREATECOURSE_PRE_TITLE_FOR_AUTOMATION_TESTING) + currentDateTime);
		createCoursePage.clickOnUploadImageButton();
		createCoursePage.clickOnCategoryDropdown();
		createCoursePage.setCategory();
		createCoursePage.clickOnSubCategoryDropdown();
		createCoursePage.setSubCategory();
		createCoursePage.setPrice(testDataProp.getProperty(CREATECOURSE_PRICE_FOR_AUTOMATION_TESTING));
		createCoursePage.clickOnOfflineMaterial();
		createCoursePage.clickOnSetTentaiveDelivery();
		createCoursePage.clickOnTermsAndConditionCheckBox();
		createCoursePage.clickOnAddContentButton();
		logger.info("Ending of tentativeDeliveryAvailable method");
		Thread.sleep(2000);
		return testDataProp.getProperty(LABEL_CREATECOURSE_PRE_TITLE_FOR_AUTOMATION_TESTING) + currentDateTime;

	}

	public String createCourseWithShipmentAndCertification(TutorCreateCoursePage createCoursePage) {

		logger.info("starting of createPhysicalShipmentCourse method");

		createCoursePage.clickOnStoreButton();
		createCoursePage.clickOnCreateCourseButton();
		String currentDateTime = dtf.format(LocalDateTime.now());
		createCoursePage.setCourseName(
				testDataProp.getProperty(LABEL_CREATECOURSE_PRE_TITLE_FOR_AUTOMATION_TESTING) + currentDateTime);
		createCoursePage
				.setDescription(testDataProp.getProperty(LABEL_CREATECOURSE_DESCRIPTION_FOR_AUTOMATION_TESTING));
		createCoursePage.clickOnCategoryDropdown();
		createCoursePage.setCategory();
		createCoursePage.setPrice(testDataProp.getProperty(CREATECOURSE_PRICE_FOR_AUTOMATION_TESTING));
		createCoursePage.clickOnOfflineMaterial();
		createCoursePage.clickOnTglStudentCertificate();
		createCoursePage.clickOnTermsAndConditionCheckBox();
		createCoursePage.clickOnAddContentButton();

		logger.info("ending of createPhysicalShipmentCourse method");
		return testDataProp.getProperty(LABEL_CREATECOURSE_PRE_TITLE_FOR_AUTOMATION_TESTING) + currentDateTime;

	}

	public void createCourseInstallments(TutorCreateInstallmentPage createInstallmentPage) throws InterruptedException {
		logger.info("starting of createCourseInstallments method");

		createInstallmentPage.closeInstallmentGotItPopup();
		createInstallmentPage.clickOnCreateInstallment();
		this.hardWait(3);
		createInstallmentPage
				.giveInstallments(testDataProp.getProperty(LABEL_NUMBER_OF_INSTALLMENTS_IN_TESTING_COURSE));
		this.hardWait(2);
		createInstallmentPage.clickOnCreateInstallmentButton();
		createInstallmentPage.clickOnSetInstallmentButton();
		createInstallmentPage.clickOnDoneButton();

		logger.info("ending of createCourseInstallments method");

	}

	public String tentativeDeliveryNotAvailable(TutorCreateCoursePage createCoursePage) {
		logger.info("Starting of tentativeDeliveryNotAvailable method");
		String currentDateTime = dtf.format(LocalDateTime.now());
		createCoursePage.clickOnStoreButton();
		createCoursePage.getMyCourses();
		createCoursePage.clickOnCreateCourseButton();
		createCoursePage.getCreateCourseLabel();
		createCoursePage.setCourseName(
				testDataProp.getProperty(LABEL_CREATECOURSE_PRE_TITLE_FOR_AUTOMATION_TESTING) + currentDateTime);
		createCoursePage.setDescription(
				testDataProp.getProperty(LABEL_CREATECOURSE_PRE_TITLE_FOR_AUTOMATION_TESTING) + currentDateTime);
		createCoursePage.clickOnUploadImageButton();
		createCoursePage.clickOnCategoryDropdown();
		createCoursePage.setCategory();
		createCoursePage.clickOnSubCategoryDropdown();
		createCoursePage.setSubCategory();
		createCoursePage.setPrice(testDataProp.getProperty(CREATECOURSE_PRICE_FOR_AUTOMATION_TESTING));
		createCoursePage.clickOnOfflineMaterial();
		createCoursePage.clickOnSetTentaiveDelivery();
		createCoursePage.clickOnTermsAndConditionCheckBox();
		createCoursePage.clickOnAddContentButton();
		logger.info("ending of tentativeDeliveryNotAvailable method");

		return testDataProp.getProperty(LABEL_CREATECOURSE_PRE_TITLE_FOR_AUTOMATION_TESTING) + currentDateTime;
	}

	public void tutorAddFaculty(TutorAddingFacultyToCoursePage tutorAddFacultyToCoursePage) {

		tutorAddFacultyToCoursePage.clickOnAddButton();

		Assert.assertEquals(tutorAddFacultyToCoursePage.getAddFacultyHeader(),
				expectedAssertionsProp.getProperty(FACULTY_HEADER_LABEL));

		tutorAddFacultyToCoursePage.setfacultyName(testDataProp.getProperty(TXT_FACULTY_NAME));
		tutorAddFacultyToCoursePage.setFacultyMobileNumber(testDataProp.getProperty(TXT_FACULTY_MOBILE_NUMBER));
		tutorAddFacultyToCoursePage.clickOnAddFacultyButton();
		tutorAddFacultyToCoursePage.clickOnCloseButton();

	}

	public void tutorRemoveFaculty(TutorAddingFacultyToCoursePage tutorAddFacultyToCoursePage1,
			TutorAddContentPage tutorAddContentPage) {

		tutorAddContentPage.clickOnStoreButton();

		tutorAddContentPage.clickOnTxtSearchCourse(testDataProp.getProperty(CREATECOURSE_FACULTY_TITLE));
		tutorAddFacultyToCoursePage1.clickOnGetCourseFolder();
		tutorAddFacultyToCoursePage1.clickOnViewAllButton();
		tutorAddFacultyToCoursePage1.clickOnRemoveButton();
		Assert.assertEquals(tutorAddFacultyToCoursePage1.getRemoveConfirmationheader(),
				expectedAssertionsProp.getProperty(REMOVE_CONFIRMATION_HEADER));

		tutorAddFacultyToCoursePage1.clickOnYesRemoveButton();

	}

	public void testCopyCourseLink(TutorMarkFeaturedPage tutorMarkfeaturedPage) {
		logger.info("Starting of clickOnCopyCourseLinkButtton method");

		tutorMarkfeaturedPage.clickOnVerticalMenuButton();
		tutorMarkfeaturedPage.clickOnCopyCourseLink();

		logger.info("Ending of clickOnCopyCourseLinkButtton method");
	}

	public void testPostAnnouncement(TutorAnnouncementPage tutorAnnouncementPage) {
		logger.info("Starting of testPostAnnouncement method");

		tutorAnnouncementPage.clickOnAnnouncementIcon();
		tutorAnnouncementPage.clickOnMakeExcelAnnouncement();

		// Assertion of for checking Make Announcement page label
		String makeAnnounceMessageText = tutorAnnouncementPage.getMakeAnAnnouncementLabel();
		Assert.assertEquals(makeAnnounceMessageText, expectedAssertionsProp.getProperty(LABEL_MAKE_ANNOUNCEMENT));

		tutorAnnouncementPage
				.clickOnMakeExcelAnnonceText(testDataProp.getProperty(CONTENTMARKET_ANNOUNCEMENT_MAKEANNOUNCE_EXCEL));
		tutorAnnouncementPage.clickOnAttachFileExcel();
		tutorAnnouncementPage.clickOnPost2();

		logger.info("Ending of testPostAnnouncement method");
	}

	public void testEditAnnouncement(TutorAnnouncementPage tutorAnnouncementPage) {
		logger.info("Starting of testEditAnnouncement method");

		tutorAnnouncementPage.clickOnThreeDottedMenu();
		tutorAnnouncementPage.clickOnEditIcon();

		// Assertion of for checking Make Announcement page label
		String makeAnnounceMessageText = tutorAnnouncementPage.getMakeAnAnnouncementLabel();
		Assert.assertEquals(makeAnnounceMessageText, expectedAssertionsProp.getProperty(LABEL_MAKE_ANNOUNCEMENT));

		tutorAnnouncementPage.clickOnEditMakeAnnonceText(
				testDataProp.getProperty(CONTENTMARKET_ANNOUNCEMENT_EDIT_MAKEANNOUNCE_TEXT));
		tutorAnnouncementPage.clickOnEditPostButton();

		logger.info("Ending of testEditAnnouncement method");
	}

	public void testDeleteAnnouncements(TutorAnnouncementPage tutorAnnouncementPage) {
		logger.info("Starting of testDeleteAnnouncements method");

		tutorAnnouncementPage.clickOnThreeDottedMenu();
		tutorAnnouncementPage.clickOnRemoveIcon();

		// Assertion for checking removed announcements text
		String deleteAnnounceLabel = tutorAnnouncementPage.getDeleteAnnouncementLabel();
		Assert.assertEquals(deleteAnnounceLabel, expectedAssertionsProp.getProperty(LABEL_ANNOUNCEMENT__DELETE_TEXT));

		// this.tutorAnnouncementPage.setSearch(testDataProp.getProperty(SEARCH_EXCEL_ANNOUNCEMENT));
		// this.tutorAnnouncementPage.clearSearch();

		logger.info("Ending of testDeleteAnnouncements method");
	}

	public void testAddContent(TutorAddContentPage tutorAddContentPage) {
		logger.info("Starting of testAddContent method");

		tutorAddContentPage.clickOnContentButton();
		/*
		 * tutorAddContentPage.clickOnMenuAddVideoIcon();
		 * System.out.println(testDataProp.getProperty(ADDCONTENT_UPLOAD_LINUX_VIDEO));
		 * tutorAddContentPage.uploadVideoButton(tutorAddContentPage.TEST_FILE_PATH +
		 * File.separator + testDataProp.getProperty(ADDCONTENT_UPLOAD_LINUX_VIDEO));
		 * tutorAddContentPage.clickOnDoneButton();
		 */
		tutorAddContentPage.clickOnMenuSubjectiveTestIcon();
		tutorAddContentPage.clickOnCreateNewTestButton();
		tutorAddContentPage.setTextTestName(testDataProp.getProperty(ADDCONTENT_SUBJECTIVETEST_TESTNAME));
		tutorAddContentPage.clickOnTextTotalMarks(testDataProp.getProperty(ADDCONTENT_SUBJECTIVETEST_TOTALMARKS));
		tutorAddContentPage.clickOnAddFilesButton();
		tutorAddContentPage.clickOnCreateAndAddTestButton();
		tutorAddContentPage.clickOnMenuImageIcon();
		tutorAddContentPage.setTextImageName(testDataProp.getProperty(ADDCONTENT_IMAGE_NAME));
		tutorAddContentPage.setTextImageDescription(testDataProp.getProperty(ADDCONTENT_IMAGE_DESCRIPTION));
		tutorAddContentPage.setUploadImageButton();
		tutorAddContentPage.clickOnUploadImgButton();

		// Assertion for checking the add image text
		String imgSuccess = tutorAddContentPage.getSuccessImageMessageText();
		Assert.assertEquals(imgSuccess, expectedAssertionsProp.getProperty(IMAGE_ADDED_SUCCESSFULLY_TEXT));

		logger.info("Ending of testAddContent method");

	}

	public void testAddModalSubjectiveTest(TutorAddContentPage tutorAddContentPage) {
		logger.info("Starting of testAddModalSubjectiveTest method");

		try {
			tutorAddContentPage.clickOnMenuSubjectiveTestIcon();
			tutorAddContentPage.clickOnAddCourseButton();

		} catch (Exception e) {
			Assert.fail("Exception occured while testing  Subjective test through add modal: " + e.getMessage());
			logger.error("Error occured while testing  Subjective Test through add modal ", e);
		}

		logger.info("Ending of testAddModalSubjectiveTest method");
	}

	public void testPublishCourse(TutorAddContentPage tutorAddContentPage) {
		logger.info("Starting of testPublishCourse method");

		try {
			tutorAddContentPage.clickOnPublishCourseButton();
			tutorAddContentPage.clickOnPublishCourse1();
			tutorAddContentPage.clickOnCrossButton();

		} catch (Exception e) {
			Assert.fail("Exception occured while testing  Publish course " + e.getMessage());
			logger.error("Error occured while testing Publish course ", e);
		}

		logger.info("Ending of testPublishCourse method");
	}

	public void testApplyCoupon(TutorCoursesHomePage tutorCourseHomePage) {
		logger.info("Starting of testApplyCoupon method");

		try {

			Assert.assertEquals(tutorCourseHomePage.getApplyCouponHeader(),
					expectedAssertionsProp.getProperty(APPLY_COUPON_HEADER));

			tutorCourseHomePage.setSearchCoupon(testDataProp.getProperty(NEW_TUTOR_SEARCH_COUPON));
			tutorCourseHomePage.clickOnApplyButton();

			Assert.assertEquals(tutorCourseHomePage.getAppliedSuccesfully(),
					expectedAssertionsProp.getProperty(APPLIED_SUCCESSFULLY_TEXT));

			tutorCourseHomePage.clickOnDoneButton();
		} catch (Exception e) {
			Assert.fail("Exception occured while testing Course Apply coupon: " + e.getMessage());
			logger.error("Error occured while testing Apply coupon", e);
		}

		logger.info("Ending of testApplyCoupon method");
	}

	public void testGetStudentCourse(StudentBuyCoursePage buyCoursePage, @Optional String courseName) {
		logger.info("Starting of testGetStudentCourse method");

		try {
			buyCoursePage.clickOnStoreButton();
			buyCoursePage.setSearch(courseName);
			buyCoursePage.clickOnGetCourse(courseName);

		} catch (Exception e) {
			Assert.fail("Exception occured while testing Select Course Page: " + e.getMessage());
			logger.error("Error occured while testing Select Course Page", e);
		}

		logger.info("Ending of testGetStudentCourse method");
	}

	public void testBuyNowCourse(StudentBuyCoursePage buyCoursePage) {
		logger.info("Starting of testBuyNowCourse method");

		if (buyCoursePage.checkVisibilityOfChangeAddress() == true) {
			buyCoursePage.clickOnBuyNowButton();
		} else
			buyCoursePage.clickonSelectStateDropDown();
		buyCoursePage.clickonStateButton();
		buyCoursePage.clickOnBuyNowButton();
		/*
		 * buyCoursePage.closeBuyNowPage(); buyCoursePage.clickOnCard();
		 * buyCoursePage.inputCardNumber(testDataProp.getProperty(INPUT_CARD_NUMBER));
		 * buyCoursePage.inputCardExpiry(testDataProp.getProperty(INPUT_CARD_EXPIRY));
		 * buyCoursePage.inputCardCvv(testDataProp.getProperty(INPUT_CARD_CVV));
		 * buyCoursePage.clickOnPay();
		 */

		logger.info("Ending of testBuyNowCourse method");

	}

	public void testInstallStudentCourse(StudentBuyCoursePage buyCoursePage) {
		logger.info("Starting of testInstallStudentCourse method");

		try {
			buyCoursePage.clickOnStoreButton();

		} catch (Exception e) {
			Assert.fail("Exception occured while testing Select Course Page: " + e.getMessage());
			logger.error("Error occured while testing Select Course Page", e);
		}

		logger.info("Ending of testInstallStudentCourse method");
	}

	public String createPhysicalShipmentCourse(TutorCreateCoursePage createCoursePage) {
		logger.info("Starting of createPhysicalShipmentCourse method");

		String currentDateTime = dtf.format(LocalDateTime.now());
		String physicalCourseName = testDataProp.getProperty(LABEL_CREATECOURSE_WITH_PHYSICAL_SHIPMENT)
				+ currentDateTime;
		createCoursePage.clickOnStoreButton();
		createCoursePage.clickOnCreateCourseButton();
		createCoursePage.setCourseName(physicalCourseName);
		createCoursePage
				.setCourseName(testDataProp.getProperty(LABEL_CREATECOURSE_WITH_PHYSICAL_SHIPMENT) + currentDateTime);
		createCoursePage.setDescription(
				testDataProp.getProperty(LABEL_CREATECOURSE_DESCRIPTION_FOR_AUTOMATION_TESTING) + currentDateTime);
		createCoursePage.clickOnCategoryDropdown();
		createCoursePage.setCategory();
		createCoursePage.setPrice(testDataProp.getProperty(CREATECOURSE_PRICE_FOR_AUTOMATION_TESTING));
		createCoursePage.clickOnOfflineMaterial();
		createCoursePage.clickOnSetTentaiveDelivery();
		createCoursePage.clickOnTermsAndConditionCheckBox();
		createCoursePage.clickOnAddContentButton();

		logger.info("Starting of createPhysicalShipmentCourse method");
		return physicalCourseName;

	}

	public void createCouponCourse(TutorCreateCoursePage createCoursePage) {
		logger.info("Starting of createCouponCourse method");

		createCoursePage.clickOnStoreButton();
		createCoursePage.clickOnCreateCourseButton();
		String currentDateTime = dtf.format(LocalDateTime.now());
		createCoursePage.setCourseName(testDataProp.getProperty(LABEL_CREATECOURSE_WITH_COUPON_TESTING));
		createCoursePage
				.setDescription(testDataProp.getProperty(LABEL_CREATECOURSE_DESCRIPTION_FOR_AUTOMATION_TESTING));
		createCoursePage.clickOnCategoryDropdown();
		createCoursePage.setCategory();
		createCoursePage.setPrice(testDataProp.getProperty(CREATECOURSE_PRICE_FOR_AUTOMATION_TESTING));
		createCoursePage.clickOnTermsAndConditionCheckBox();
		createCoursePage.clickOnAddContentButton();

		logger.info("Starting of createCouponCourse method");
	}

	public void createCourseWithTaxDetails(TutorCreateCoursePage createCoursePage) {
		logger.info("Starting of createCourseWithTaxDetails method");

		createCoursePage.clickOnStoreButton();
		createCoursePage.clickOnCreateCourseButton();
		String currentDateTime = dtf.format(LocalDateTime.now());
		createCoursePage.setCourseName(testDataProp.getProperty(LABEL_CREATECOURSE_WITH_COUPON_TESTING));
		createCoursePage
				.setDescription(testDataProp.getProperty(LABEL_CREATECOURSE_DESCRIPTION_FOR_AUTOMATION_TESTING));
		createCoursePage.clickOnCategoryDropdown();
		createCoursePage.setCategory();
		createCoursePage.setPrice(testDataProp.getProperty(CREATECOURSE_PRICE_FOR_AUTOMATION_TESTING));
		this.hardWait(3);
		createCoursePage.clickOnInternetChargesToggle();
		// createCoursePage.clickOnTaxDetailsToggle();
		createCoursePage.clickOnTermsAndConditionCheckBox();
		createCoursePage.clickOnAddContentButton();

		logger.info("Starting of createCourseWithTaxDetails method");
	}

	public void studentAccessContentCourse(StudentViewContentPage studentViewContentPage) {
		logger.info("Starting of studentAccessContentCourse method");

		studentViewContentPage.clickOnStoreButton();
		studentViewContentPage.setSearchArea(testDataProp.getProperty(STUDENT_VIEW_CONTENT_SEARCH_COURSE));
		studentViewContentPage.clickOnGetCourse(testDataProp.getProperty(STUDENT_VIEW_CONTENT_SEARCH_COURSE));
		studentViewContentPage.clickOnContentButton();
		studentViewContentPage.clickOnFilesMenu();
		studentViewContentPage.clickOnImagesB2b();
		studentViewContentPage.clickOnCancelImage();
		studentViewContentPage.clickOnPreviousIcon();

		logger.info("Starting of studentAccessContentCourse method");

	}

	public void testSettingsPage(TutorMerchantDashboardPage tutorMerchantDashboardPage) {
		logger.info("Starting of testSettingsPage method");

		tutorMerchantDashboardPage.clickOnTutorDropdown();
		tutorMerchantDashboardPage.clickOnSettings();

		// Assertion for checking the group study label
		String lblGroupStudy = tutorMerchantDashboardPage.getGroupStudyLabel();
		Assert.assertEquals(lblGroupStudy, expectedAssertionsProp.getProperty(LABEL_GROUP_STUDY));

		tutorMerchantDashboardPage.clickOnUploadButton();

		logger.info("Ending of testSettingsPage method");

	}

	public void testDeleteWaterMark(TutorMerchantDashboardPage tutorMerchantDashboardPage) {
		logger.info("Starting of testDeleteWaterMark method");

		tutorMerchantDashboardPage.clickOnCrossButton();

		logger.info("Ending of testDeleteWaterMark method");
	}

	public void testGetVideo(StudentViewContentPage studentViewContentPage) {
		logger.info("Starting of testGetVideo method");

		studentViewContentPage.clickOnContentButton();
		studentViewContentPage.clickOnVideoTest();

		logger.info("Ending of testGetVideo method");
	}

	public void testCreateCouponPercentageDiscountType(TutorCouponCodePage tutorCouponCodePage) {
		logger.info("Starting of testCreateCouponPercentageDiscountType method");

		try {
			tutorCouponCodePage.clickOnCouponCodeButton();
			tutorCouponCodePage.clickOnCreateCouponButton();
			tutorCouponCodePage.clickOnPercentageDiscountRadioButton();
			tutorCouponCodePage.setPercentageDiscount(testDataProp.getProperty(COUPONCODE_PERCENTAGE_DISCOUNT));
			tutorCouponCodePage
					.setMaxPercentageDiscount(testDataProp.getProperty(COUPONCODE_MAXIMUM_PERCENTAGE_DISCOUNT));
			tutorCouponCodePage.clickOnLifetimeValidityCheckbox();
			tutorCouponCodePage.setMinimumValueEdit(testDataProp.getProperty(COUPONCODE_MIN_ORDER_VALUE));
			tutorCouponCodePage.clickOnPercentageCodeNextButton();
			tutorCouponCodePage.setOfferName(testDataProp.getProperty(COUPONCODE_OFFER_NAME));
			tutorCouponCodePage.setCouponCode(testDataProp.getProperty(COUPONCODE_SET_COUPONCODE));
			tutorCouponCodePage.clickOnPrivateCouponRadioButton();
			tutorCouponCodePage.clickOnSpecificCoursesRadioButton();
			tutorCouponCodePage.setTotalLimit(testDataProp.getProperty(COUPONCODE_TOTAL_LIMIT));
			tutorCouponCodePage.setUserLimit(testDataProp.getProperty(COUPONCODE_USER_LIMIT));
			tutorCouponCodePage.clickOnCodeNextButton();
			this.hardWait(1);
			tutorCouponCodePage.setSearch(testDataProp.getProperty(COUPONCODE_STUDENT_SEARCH_COURSE));
			tutorCouponCodePage.clickOnSelectCourseCheckBox();
			tutorCouponCodePage.clickOnNextButton();
			tutorCouponCodePage.setSearch(testDataProp.getProperty(COUPONCODE_SEARCH_STUDENT));
			tutorCouponCodePage.clickOnSelectCourseCheckBox();
			tutorCouponCodePage.clickOnFinishButton();

		} catch (Exception e) {
			Assert.fail("Exception occured while testing  Create Percentage Discount coupon: " + e.getMessage());
			logger.error("Error occured while testing Create Percentage Discount coupon", e);
		}

		logger.info("Ending of testCreateCouponPercentageDiscountType method");
	}

	public void testDeletePercentageDiscountCoupon(TutorCouponCodePage tutorCouponCodePage) {
		logger.info("Starting of testDeletePercentageDiscountCoupon method");

		try {
			tutorCouponCodePage.clickOnThreeDottedMenu(testDataProp.getProperty(COUPONCODE_OFFER_NAME));
			tutorCouponCodePage.clickOnMakeInActiveIcon();
			tutorCouponCodePage.clickOnThreeDottedMenu(testDataProp.getProperty(COUPONCODE_OFFER_NAME));
			tutorCouponCodePage.clickDeleteIcon();

		} catch (Exception e) {
			Assert.fail("Exception occured while testing  Delete Percentage Discount Coupon: " + e.getMessage());
			logger.error("Error occured while testing  Delete Percentage Discount Coupon ", e);
		}

		logger.info("Ending of testDeletePercentageDiscountCoupon method");
	}

	public void editCourseInstallments(TutorCreateInstallmentPage tutorCreateInstallmentPage)
			throws InterruptedException {
		logger.info("starting of editCourseInstallments method");

		tutorCreateInstallmentPage.clickViewInstallmentsButton();
		tutorCreateInstallmentPage.clickEditInstallment();
		tutorCreateInstallmentPage.giveInstallment(testDataProp.getProperty(CRAETE_INSTALLMENT_EDIT_TOTALINSTALLMENT));
		tutorCreateInstallmentPage.selectInstallmentType();
		tutorCreateInstallmentPage.selectAsWeekly();
		tutorCreateInstallmentPage.clickOnSaveInstallmentButton();
		tutorCreateInstallmentPage.clickOnSaveInstallmentButton2();
		logger.info("Ending of editCourseInstallments method");

	}

	public void subjectiveDetails(TutorAddContentPage tutorAddContentPage) {

		tutorAddContentPage.clickOnMenuSubjectiveTestIcon();
		this.hardWait(3);
		tutorAddContentPage.clickOnCreateNewTestButton();
		this.hardWait(3);
		tutorAddContentPage.setTestName(testDataProp.getProperty(SUBJECTIVETEST_TESTNAME));
		this.hardWait(3);
		tutorAddContentPage.clickOnTextTotalMarks(testDataProp.getProperty(ADDCONTENT_SUBJECTIVETEST_TOTALMARKS));

	}

	public void clickOnCreateAndAdd(TutorAddContentPage tutorAddContentPage) {

		tutorAddContentPage.clickOnCreateAndAddTestButton();
	}

	public void editCourseWithMaxInstallments(TutorCreateInstallmentPage tutorCreateInstallmentPage)
			throws InterruptedException {
		logger.info("starting of editCourseWithMaxInstallments method");

		tutorCreateInstallmentPage.clickViewInstallmentsButton();
		tutorCreateInstallmentPage.clickEditInstallment();
		tutorCreateInstallmentPage
				.giveInstallment(testDataProp.getProperty(CREATE_INSTALLMENT_EDIT_MAX_TOTALINSTALLMENT));
		// tutorCreateInstallmentPage.selectInstallmentType();

		logger.info("Ending of editCourseWithMaxInstallments method");
	}

	public void testInstallmentsPeriod(TutorCreateInstallmentPage tutorCreateInstallmentPage)
			throws InterruptedException {
		logger.info("starting of testInstallmentsPeriod method");

		tutorCreateInstallmentPage.clickViewInstallmentsButton();
		tutorCreateInstallmentPage.clickEditInstallment();
		this.hardWait(2);
		tutorCreateInstallmentPage
				.giveInstallment(testDataProp.getProperty(CREATE_INSTALLMENT_EDIT_LAST_TOTALINSTALLMENT));
		this.hardWait(2);
		tutorCreateInstallmentPage.selectInstallmentType();

		logger.info("Ending of testInstallmentsPeriod method");
	}

	public void testDeleteInstallment(TutorCreateInstallmentPage tutorCreateInstallmentPage)
			throws InterruptedException {
		logger.info("Starting of testDeleteInstallment method");

		tutorCreateInstallmentPage.clickViewInstallmentsButton();
		tutorCreateInstallmentPage.clickOnDeleteIcon();
		tutorCreateInstallmentPage.clickonYesDelete();

		logger.info("Ending of testDeleteInstallment method");
	}

	public String createTutorPaymentCourse(TutorCreateCoursePage createCoursePage) {
		logger.info("Starting of createTutorPaymentCourse method");
		logger.info("Ending of createTutorPaymentCourse method");

		createCoursePage.clickOnStoreButton();
		createCoursePage.clickOnCreateCourseButton();
		String currentDateTime = dtf.format(LocalDateTime.now());
		createCoursePage.setCourseName(testDataProp.getProperty(TUTOR_PAYMENT_AUTOMATION_TESTING) + currentDateTime);
		createCoursePage.setDescription(
				testDataProp.getProperty(LABEL_CREATECOURSE_DESCRIPTION_FOR_AUTOMATION_TESTING) + currentDateTime);
		createCoursePage.clickOnCategoryDropdown();
		createCoursePage.setCategory();
		createCoursePage.setPrice(testDataProp.getProperty(CREATECOURSE_PRICE_FOR_AUTOMATION_TESTING));
		createCoursePage.clickOnTermsAndConditionCheckBox();
		createCoursePage.clickOnAddContentButton();
		return testDataProp.getProperty(LABEL_CREATECOURSE_PRE_TITLE_FOR_AUTOMATION_TESTING);
	}

	public String createTutorPhysicalShipmentCourse(TutorCreateCoursePage createCoursePage) {
		logger.info("Starting of createTutorPaymentCourse method");
		logger.info("Edning of createTutorPaymentCourse method");

		createCoursePage.clickOnStoreButton();
		createCoursePage.clickOnCreateCourseButton();
		String currentDateTime = dtf.format(LocalDateTime.now());
		createCoursePage.setCourseName(testDataProp.getProperty(TUTOR_PHYSICAL_AUTOMATION_TESTING));
		createCoursePage
				.setDescription(testDataProp.getProperty(LABEL_CREATECOURSE_DESCRIPTION_FOR_AUTOMATION_TESTING));
		createCoursePage.clickOnCategoryDropdown();
		createCoursePage.setCategory();
		createCoursePage.setPrice(testDataProp.getProperty(CREATECOURSE_PRICE_FOR_AUTOMATION_TESTING));
		createCoursePage.clickOnTermsAndConditionCheckBox();
		createCoursePage.clickOnAddContentButton();
		return testDataProp.getProperty(LABEL_CREATECOURSE_PRE_TITLE_FOR_AUTOMATION_TESTING);
	}

	public void editPhysicalShipmentCourse(TutorEditCoursePage tutorEditCoursePage) {
		logger.info("Starting of editPhysicalShipmentCourse method");

		tutorEditCoursePage.clickOnThreeDottedMenu();
		tutorEditCoursePage.clickOnEditIcon();

		logger.info("Ending of editPhysicalShipmentCourse method");

	}

	public void testRemoveCourse(TutorEditCoursePage tutorEditCoursePage) {
		logger.info("Starting of testRemoveCourse method");

		tutorEditCoursePage.clickOnMenuVerticalIcon();
		tutorEditCoursePage.clickOnRemoveCourseButton();
		tutorEditCoursePage.removeCourseButton();

		logger.info("Ending of testRemoveCourse method");
	}

	public void testImportContentCourse(TutorContentMarketPage tutorContentMarketPage,
			TutorCreateCoursePage tutorCreateCoursePage) {
		logger.info("Starting of testImportContentCourse method");

		tutorCreateCoursePage.clickOnStoreButton();
		tutorContentMarketPage.clickOnContentMarketButton();
		tutorContentMarketPage.searchCourse(testDataProp.getProperty(CONTENTMARKET_SEARCH_COURSE));
		tutorContentMarketPage.clickOnCourse();
		tutorContentMarketPage.clickOnContentcourses();
		tutorContentMarketPage.clickOnAddToMyCourses();
		tutorContentMarketPage.clickOnCheckBox();
		tutorContentMarketPage.clickOnSaveCourseButton();
		tutorCreateCoursePage.clickOnStoreButton();
		tutorContentMarketPage.searchCourse(testDataProp.getProperty(CONTENTMARKET_SEARCH_COURSE));
		tutorContentMarketPage.clickOnCourse();

		logger.info("Endin of testImportContentCourse method");

	}

	public void selectStudentSortingCourse(TutorStudentSortingPage tutorStudentSortingPage) {
		logger.info("Starting of selectStudentSortingCourse method");

		tutorStudentSortingPage.clickOnStudentsButton();
		for (int i = 1; i <= 2; i++) {
			tutorStudentSortingPage.clickOnPricePaidIcon();
		}
		logger.info("Ending of selectStudentSortingCourse method");
	}

	public String createEffectivePriceCourse(TutorCreateCoursePage createCoursePage) {
		logger.info("Starting of createEffectivePriceCourse method");
		logger.info("Ending of createEffectivePriceCourse method");

		createCoursePage.clickOnStoreButton();
		createCoursePage.clickOnCreateCourseButton();
		String currentDateTime = dtf.format(LocalDateTime.now());
		createCoursePage
				.setCourseName(testDataProp.getProperty(TUTOR_EFFECTIVEPRICE_AUTOMATION_TESTING) + currentDateTime);
		createCoursePage
				.setDescription(testDataProp.getProperty(LABEL_CREATECOURSE_DESCRIPTION_FOR_AUTOMATION_TESTING));
		createCoursePage.clickOnCategoryDropdown();
		createCoursePage.setCategory();
		createCoursePage.setPrice(testDataProp.getProperty(CREATECOURSE_PRICE_FOR_AUTOMATION_TESTING));
		createCoursePage.clickOnInternetChargesToggle();
		createCoursePage.clickOnTermsAndConditionCheckBox();
		createCoursePage.clickOnAddContentButton();
		return testDataProp.getProperty(LABEL_CREATECOURSE_PRE_TITLE_FOR_AUTOMATION_TESTING);
	}

	public String createNewTutorCourse(TutorCreateCoursePage createCoursePage) {
		logger.info("Starting of createNewTutorCourse method");
		logger.info("Ending of createNewTutorCourse method");
		String currentDateTime = dtf.format(LocalDateTime.now());
		// String courseName =
		// testDataProp.getProperty(TUTOR_NEWWEBSITE_AUTOMATION_TESTING+currentDateTime);
		createCoursePage.clickOnStoreButton();
		createCoursePage.clickOnCreateCourseButton();
		createCoursePage
				.setCourseName(testDataProp.getProperty(TUTOR_NEWWEBSITE_AUTOMATION_TESTING) + (currentDateTime));
		// String courseName =
		// testDataProp.getProperty(TUTOR_NEWWEBSITE_AUTOMATION_TESTING+currentDateTime);
		createCoursePage.clickOnStoreButton();
		createCoursePage.clickOnCreateCourseButton();
		createCoursePage
				.setCourseName(testDataProp.getProperty(TUTOR_NEWWEBSITE_AUTOMATION_TESTING) + (currentDateTime));
		createCoursePage
				.setDescription(testDataProp.getProperty(LABEL_CREATECOURSE_DESCRIPTION_FOR_AUTOMATION_TESTING));
		createCoursePage.clickOnCategoryDropdown();
		createCoursePage.setCategory();
		createCoursePage.setPrice(testDataProp.getProperty(CREATECOURSE_PRICE_FOR_AUTOMATION_TESTING));
		createCoursePage.clickOnInternetChargesToggle();
		createCoursePage.clickOnTermsAndConditionCheckBox();
		createCoursePage.clickOnAddContentButton();
		return testDataProp.getProperty(TUTOR_NEWWEBSITE_AUTOMATION_TESTING) + (currentDateTime);

	}

	public void createScheduledClass(TutorTrialClassPage tutorTrialClassPage) {

		tutorTrialClassPage.clickOnTrialClasses();
		tutorTrialClassPage.setTopic(testDataProp.getProperty(TRIAL_CLASS_TOPIC_TEXT));
		tutorTrialClassPage.clickOnAddButton();
		tutorTrialClassPage.clickOnSelectStudents();
		tutorTrialClassPage.clickOnDone();
		tutorTrialClassPage.clickOnSelectDate();
		tutorTrialClassPage.setDate();
		tutorTrialClassPage.clickOnSelectTime();
		tutorTrialClassPage.setTime();
		tutorTrialClassPage.clickOnScheduleForLater();

		// Assertion for checking scheduled success text
		Assert.assertEquals(tutorTrialClassPage.getScheduledSuccessText(),
				expectedAssertionsProp.getProperty(LABEL_SCHEDULE_SUCCESS_TEXT));

		tutorTrialClassPage.clickOnNotifyCloseModal();
	}

	public void editScheduledClass(TutorTrialClassPage tutorTrialClassPage) {

		tutorTrialClassPage.setTopic(testDataProp.getProperty(TRIAL_CLASS_EDIT_TOPIC_TEXT));
		tutorTrialClassPage.clickOnUpdateTrialButton();
	}

	public void deleteScheduledClass(TutorTrialClassPage tutorTrialClassPage) {

		tutorTrialClassPage.clickOnScheduledButton();
		tutorTrialClassPage.clickOnDeleteLiveClass();

	}

	public void addFacultyToCourse(TutorAddingFacultyToCoursePage tutorAddFacultyToCoursePageTutor) {

		tutorAddFacultyToCoursePageTutor.clickOnAddButton();
		tutorAddFacultyToCoursePageTutor.setfacultyName(testDataProp.getProperty(TXT_ADD_FACULTY_NAME));
		tutorAddFacultyToCoursePageTutor.setFacultyMobileNumber(testDataProp.getProperty(TXT_FACULTY_MOBILE_NUMBER));
		tutorAddFacultyToCoursePageTutor.clickOnAddFacultyButton();
		tutorAddFacultyToCoursePageTutor.clickOnCloseButton();

		Assert.assertTrue(tutorAddFacultyToCoursePageTutor.getAddedFacultyLabel());

	}

	public void deleteFacultyToCourse(TutorAddingFacultyToCoursePage tutorAddFacultyToCoursePageTutor) {

		tutorAddFacultyToCoursePageTutor.clickOnViewAllButton();
		tutorAddFacultyToCoursePageTutor.clickOnRemoveButton();
		tutorAddFacultyToCoursePageTutor.clickOnYesRemoveButton();
	}

	public String createTutorStudentCourse(TutorCreateCoursePage createCoursePage) {
		logger.info("Starting of createTutorStudentCourse method");
		logger.info("Ending of createTutorStudentCourse method");

		createCoursePage.clickOnStoreButton();
		createCoursePage.clickOnCreateCourseButton();
		String currentDateTime = dtf.format(LocalDateTime.now());
		createCoursePage.setCourseName(testDataProp.getProperty(TUTOR_STUDENT_ADDING_COURSE_TESTING));
		createCoursePage
				.setDescription(testDataProp.getProperty(LABEL_CREATECOURSE_DESCRIPTION_FOR_AUTOMATION_TESTING));
		createCoursePage.clickOnCategoryDropdown();
		createCoursePage.setCategory();
		createCoursePage.setPrice(testDataProp.getProperty(CREATECOURSE_PRICE_FOR_AUTOMATION_TESTING));
		createCoursePage.clickOnInternetChargesToggle();
		createCoursePage.clickOnTermsAndConditionCheckBox();
		createCoursePage.clickOnAddContentButton();
		return testDataProp.getProperty(LABEL_CREATECOURSE_PRE_TITLE_FOR_AUTOMATION_TESTING);
	}

	/*
	 * super.createNewTutorCourse(createCoursePage);
	 * super.testAddModalSubjectiveTest(tutorAddContentPage); this.hardWait(3);
	 * super.testPublishCourse(tutorAddContentPage); this.hardWait(3);
	 * super.createNewTutorCourse(tutorCreateCoursePage);
	 * super.testAddModalSubjectiveTest(tutorAddContentPage); this.hardWait(3);
	 * super.testPublishCourse(tutorAddContentPage);
	 */
	/*
	 * this.createCoursePage.clickOnStoreButton();
	 * this.tutorStudentAddingPage.setSearchCourse("certi");
	 */
	public void uploadInvalidCSVFile(TutorStudentAddingPage tutorStudentAddingPage) {
		logger.info("Starting of uploadInvalidCSVFile method");

		tutorStudentAddingPage.clickOnAddStudentsButton();
		tutorStudentAddingPage.clickOnAddCSVStudentsButton();
		tutorStudentAddingPage.clickOnFailedStudentFileButton();
		tutorStudentAddingPage.clickOnUploadFile();

		logger.info("Ending of uploadInvalidCSVFile method");
	}

	public void clickOnCourseSearchbar(TutorCreateCoursePage createCoursePage) {
		logger.info("Starting of clickOnCourseSearchbar method");

		createCoursePage.clickOnStoreButton();
		createCoursePage.clickOnSearchBar();

		logger.info("Ending of clickOnCourseSearchbar method");
	}

	public void clickOnCreatedByMePriceRange(TutorCourseSortFilterPage tutorCourseSortFilterPage) {
		logger.info("Starting of clickOnCreatedByMePriceRange method");

		tutorCourseSortFilterPage.clickOnSortAndFilterButton();
		tutorCourseSortFilterPage.clickOnCreatedByMeCheckbox();
		tutorCourseSortFilterPage.clickOnPriceRange();

		logger.info("Ending of clickOnCreatedByMePriceRange method");
	}

	public void clickOnImportedPriceRange(TutorCourseSortFilterPage tutorCourseSortFilterPage) {
		logger.info("Starting of clickOnImportedPriceRange method");

		tutorCourseSortFilterPage.clickOnSortAndFilterButton();
		tutorCourseSortFilterPage.clickOnImportedCourseCheckbox();
		tutorCourseSortFilterPage.clickOnPriceRange();

		logger.info("Ending of clickOnImportedPriceRange method");
	}

	public void clickOnClearAllFilter(TutorCourseSortFilterPage tutorCourseSortFilterPage) {
		logger.info("Starting of clickOnClearAllFilter method");

		tutorCourseSortFilterPage.clickOnSortAndFilterButton();
		tutorCourseSortFilterPage.clickOnClearAllButton();

		logger.info("Ending of clickOnClearAllFilter method");
	}

	public void selectCombinationFilter(TutorCourseSortFilterPage tutorCourseSortFilterPage) {
		logger.info("Starting of selectCombinationFilter method");

		tutorCourseSortFilterPage.clickOnSortAndFilterButton();
		tutorCourseSortFilterPage.clickOnCreatedByMeCheckbox();
		tutorCourseSortFilterPage.clickOnSortAndOrder();
		tutorCourseSortFilterPage.clickOnLowToHighRadioButton();
		tutorCourseSortFilterPage.clickOnPriceRange();

		logger.info("Ending of selectCombinationFilter method");
	}

	public void selectCombinationFilters(TutorCourseSortFilterPage tutorCourseSortFilterPage) {
		logger.info("Starting of selectCombinationFilters method");

		tutorCourseSortFilterPage.clickOnSortAndFilterButton();
		tutorCourseSortFilterPage.clickOnCreatedByMeCheckbox();
		tutorCourseSortFilterPage.clickOnSortAndOrder();
		tutorCourseSortFilterPage.clickOnHighToLowRadioButton();
		tutorCourseSortFilterPage.clickOnPriceRange();

		logger.info("Ending of selectCombinationFilters method");
	}

	public void selectCombinationImportFilter(TutorCourseSortFilterPage tutorCourseSortFilterPage) {
		logger.info("Starting of selectCombinationImportFilter method");

		tutorCourseSortFilterPage.clickOnSortAndFilterButton();
		tutorCourseSortFilterPage.clickOnImportedCourseCheckbox();
		tutorCourseSortFilterPage.clickOnSortAndOrder();
		tutorCourseSortFilterPage.clickOnLowToHighRadioButton();
		tutorCourseSortFilterPage.clickOnPriceRange();

		logger.info("Ending of selectCombinationImportFilter method");
	}

	public void selectCombinationImportFilters(TutorCourseSortFilterPage tutorCourseSortFilterPage) {
		logger.info("Starting of selectCombinationImportFilters method");

		tutorCourseSortFilterPage.clickOnSortAndFilterButton();
		tutorCourseSortFilterPage.clickOnImportedCourseCheckbox();
		tutorCourseSortFilterPage.clickOnSortAndOrder();
		tutorCourseSortFilterPage.clickOnLowToHighRadioButton();
		tutorCourseSortFilterPage.clickOnPriceRange();

		logger.info("Ending of selectCombinationImportFilters method");
	}

	public void fillAddressFromBuyCourse(StudentPhysicalShipmentPage studentPhysicalShipmentPage) {
		studentPhysicalShipmentPage.clickOnSelectAddress();
		studentPhysicalShipmentPage.setFullName(testDataProp.getProperty(STUDENT_FULL_NAME_FOR_SHIPMENT_COURSE));
		studentPhysicalShipmentPage.setAddress1(testDataProp.getProperty(STUDENT_ADDRESS_FOR_SHIPMENT_COURSE));
		studentPhysicalShipmentPage.setAddress2(testDataProp.getProperty(STUDENT_ADDRESS2_FOR_SHIPMENT_COURSE));
		studentPhysicalShipmentPage.setLandmark(testDataProp.getProperty(STUDENT_LANDMARK_FOR_SHIPMENT_COURSE));
		studentPhysicalShipmentPage.setCity(testDataProp.getProperty(STUDENT_CITY_FOR_SHIPMENT_COURSE));
		studentPhysicalShipmentPage.setState(testDataProp.getProperty(STUDENT_STATE_FOR_SHIPMENT_COURSE));
		studentPhysicalShipmentPage.setPinCode(testDataProp.getProperty(STUDENT_PINCODE_FOR_SHIPMENT_COURSE));
		studentPhysicalShipmentPage
				.setMobileNumber(testDataProp.getProperty(STUDENT_MOBILE_NUMBER_FOR_SHIPMENT_COURSE));
		studentPhysicalShipmentPage.clickOnsetAsDefault();
		studentPhysicalShipmentPage.clickOnButtonSaveAddress();
		this.hardWait(2);
		studentPhysicalShipmentPage.clickOnCloseAddressPage();
	}

	public void deleteAddressFromBuyCourse(StudentPhysicalShipmentPage studentPhysicalShipmentPage) {

		this.hardWait(2);
		studentPhysicalShipmentPage.clickOnChangeAddressButton();
		studentPhysicalShipmentPage.deleteSavedAddress();
		studentPhysicalShipmentPage.clickOnCloseAddressPage();
	}

	public void deleteLiveClass(TutorTrialClassPage tutorTrialClassPage) {
		logger.info("Starting of deleteLiveClass method");

		tutorTrialClassPage.clickOnLiveNow();

		// Assertion for checking live class text
		Assert.assertEquals(tutorTrialClassPage.getStartLiveClassLabel(),
				expectedAssertionsProp.getProperty(TXT_START_LIVE_CLASSES));

		tutorTrialClassPage.clickOnEndLiveClass();

		logger.info("Ending of deleteLiveClass method");
	}
}
