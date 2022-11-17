package com.classplusapp.store.util;

public class Constants {
	/* TEST DATA PROPERTIES */
	/* Site Login */
	public static final String LOGIN_OTP = "login.otp";
	public static final String LOGIN_OTP_SUCCESS_MESSAGE = "otp.verified.successfully.text";
	/* Create Course */
	public static final String TUTOR_COURSE_NAME = "tutor.course.name";
	public static final String COURSE_DESCRIPTION = "course.description";
	public static final String CREATE_COURSE_PRICE = "create.course.price";
	public static final String CREATE_COURSE_DISCOUNT = "create.course.discount";
	public static final String COURSE_VIDEO_MAXVIEWS = "coures.video.maxviews";
	public static final String LABEL_STORE = "lbl.store";
	public static final String LABEL_SEARCH = "lbl.search";
	/* Edit Course */
	public static final String EDIT_SEARCH_COURSE = "edit.search.course";
	public static final String EDIT_COURSE_DISCRIPTION = "edit.course.description";
	public static final String EDIT_COURSE_PRICE = "edit.course.price";
	public static final String EDIT_COURSE_DISCOUNT = "edit.course.discount";
	public static final String LABEL_COURSE_REMOVE = "label.course.remove";
	public static final String LABEL_COURSE_REMOVE_CONFIRMATION_TEXT = "label.course.remove.confirmation.text";
	/* Course Add content */
	public static final String ADDCONTENT_SEARCH_COURSE = "addcontent.search.course";
	public static final String LABEL_INSTALLMENT_COURSE = "label.installment.course";
	public static final String ADDCONTENT_FOLDER_NAME = "addcontent.folder.name";
	public static final String ADDCONTENT_EDIT_FOLDER_NAME = "addcontent.edit.folder.name";
	public static final String ADDCONTENT_SUBJECTIVETEST_TESTNAME = "addcontent.subjectiveTest.testName";
	public static final String ADDCONTENT_SUBJECTIVETEST_TOTALMARKS = "addcontent.subjectiveTest.totalMarks";
	public static final String ADDCONTENT_DOCUMENT_NAME = "addcontent.document.name";
	public static final String ADDCONTENT_DOCUMENT_DESCRIPTION = "addcontent.document.description";
	public static final String ADDCONTENT_EDIT_DOCUMENT_NAME = "addcontent.edit.document.name";
	public static final String ADDCONTENT_IMAGE_NAME = "addcontent.image.name";
	public static final String ADDCONTENT_IMAGE_DESCRIPTION = "addcontent.image.description";
	public static final String ADDCONTENT_ZIPFILE_NAME = "addcontent.zipfile.name";
	public static final String ADDCONTENT_ZIPFILE_DESCRIPTION = "addcontent.zipfile.Description";
	public static final String ADDCONTENT_UPLOAD_LINUX_VIDEO = "addcontent.upload.linux.video";
	public static final String SUBJECTIVETEST_TESTSTATS_HEADER_TEXT = "addcontent.teststats.header";
	public static final String ADDCONTENT_HEADER = "addcontent.header";
	public static final String SUBJECTIVETEST_HEADER = "subjective.test.header";
	public static final String SUBJECTIVE_TEST_UNLOCKED_TEXT = "subjective.test.unlocked.text";
	public static final String SUBJECTIVE_TEST_LOCKED_TEXT = "subjective.test.locked.text";
	public static final String SEARCH_SUBJECTIVE_TEST = "search.subjective.test";
	public static final String SEARCH_INVALID_SUBJECTIVE_TEST = "search.invalid.subjective.test";
	public static final String SUBJECTIVETEST_ADDED_SUCCESSFULLY_TEXT = "message.subjective.test.added.successfully";
	public static final String DOWNLOAD_QUESTION_PAPER_MESSAGE = "message.download.question.paper";
	public static final String SUBJECTIVETEST_NO_TEST_FOUND = "subjective.test.no.tests.found";
	public static final String SUBJECTIVETEST_TESTNAME = "subjective.testname";
	public static final String SUBJECTIVETEST_INVALID_TEXT = "subjectivetest.invalid.file.message";
	public static final String MESSAGE_TRY_UPLOAD_PDF = "message.try.and.upload.pdf.files";
	public static final String NO_TESTSTATS__TEXT = "no.tests.stats.text";
	public static final String NO_STUDENT_ATTEMPTED_TEXT = "no.student.attempted.text";
	public static final String ADDCONTENT_UPLOAD_WINDOWS_VIDEO = "addcontent.upload.windows.video";

	/* Post announcements */
	public static final String ANNOUNCEMENT_SEARCH_COURSE = "announcement.search.course";
	public static final String ANNOUNCEMENT_MAKEANNOUNCE_TEXT = "announcement.makeannounce.text";
	public static final String ANNOUNCEMENT_MAKEANNOUNCE_DOCUMENT = "announcement.makeannounce.document";
	public static final String ANNONCEMENT_MAKEANNOUNCE_EXCEL = "announcement.makeannounce.excel";
	public static final String ANNOUNCEMENT_EDIT_MAKEANNOUNCEMENT_TEXT = "announcement.edit.makeannounce.text";
	public static final String LABEL_SEARCH_EXCEL_ANNOUNCEMENT = "label.search.excel.announcement";
	public static final String SEARCH_PDF_ANNOUNCEMENT = "search.pdf.announcement";
	/* Coupon code Course */
	/*
	 * public static final String COUPONCODE_FLATDISCOUNT_AMOUNT =
	 * "couponcode.flat.discount.amount"; public static final String
	 * COUPONCODE_MIN_ORDER_VALUE = "couponcode.min.order.value"; public static
	 * final String COUPONCODE_OFFER_NAME = "couponcode.offer.name"; public static
	 * final String COUPONCODE_SET_COUPONCODE = "couponcode.set.couponcode"; public
	 * static final String COUPONCODE_TOTAL_LIMIT = "couponcode.total.limit"; public
	 * static final String COUPONCODE_USER_LIMIT = "couponcode.user.limit"; public
	 * static final String COUPONCODE_EDIT_MIN_ORDER_VALUE =
	 * "couponcode.edit.min.order.value"; public static final String
	 * COUPONCODE_EDIT_OFFER_NAME = "couponcode.edit.offer.name"; public static
	 * final String COUPONCODE_EDIT_TOTAL_LIMIT = "couponcode.edit.total.limit";
	 * public static final String COUPONCODE_PERCENTAGE_DISCOUNT =
	 * "couponcode.percentage.discount"; public static final String
	 * COUPONCODE_MAXIMUM_PERCENTAGE_DISCOUNT =
	 * "couponcode.maximum.percentage.discount"; public static final String
	 * COUPONCODE_SEARCH_COURSE = "couponcode.search.course"; public static final
	 * String COUPONCODE_SEARCH_STUDENT = "couponcode.search.student"; public static
	 * final String COUPONCODE_SEARCH_COUPON = "couponcode.search.coupon"; public
	 * static final String COUPONCODE_SEARCH_DELETED_COUPON =
	 * "couponcode.search.deleted.coupon"; public static final String
	 * COUPONCODE_EDIT_USAGE_PER_STUDENT = "couponcode.edit.usage.perstudent";
	 * public static final String COUPONCODE_EDIT_MINIMUM_ORDER_VALUE =
	 * "couponcode.edit.minimum.order.value"; public static final String
	 * COUPONCODE_SPECIAL_CHARACTERS_MIN_ORDER_VALUE =
	 * "couponcode.special.characters.min.order.value"; public static final String
	 * COUPONCODE_OFFER_NAME1 = "couponcode.offer.name1"; // NEGATIVE public static
	 * final String COUPONCODE_FLATDISCOUNT_INVALID_AMOUNT =
	 * "couponcode.flat.discount.invalid.amount"; public static final String
	 * COUPONCODE_INVALID_START_DATE = "couponcode.invalid.start.date"; public
	 * static final String COUPONCODE_VALID_START_DATE =
	 * "couponcode.valid.start.date"; public static final String
	 * LABEL_CREATE_COUPON_CODE_INVALID_START_TIME =
	 * "label.couponcode.invalid.start.time"; public static final String
	 * COUPONCODE_INVALID_OFFER_NAME_2LETTER =
	 * "label.couponcode.invalid.offer.name.2letters"; public static final String
	 * COUPONCODE_INVALID_OFFER_NAME_21LETTERS =
	 * "label.couponcode.invalid.offer.name.21letters"; public static final String
	 * COUPONCODE_BLANK_OFFER_NAME_ = "label.couponcode.blank.offer.name"; public
	 * static final String LABEL_COUPONCODE_SET_INVALID_COUPON_4CHARACTERS =
	 * "label.couponcode.set.invalid.coupon.4characters"; public static final String
	 * COUPONCODE_SET_INVALID_COUPON_21CHARACTERS =
	 * "label.couponcode.set.invalid.coupon.21characters"; public static final
	 * String COUPONCODE_EXISTING_COUPON = "label.couponcode.set.existing.coupon";
	 * public static final String COUPONCODE_ALPHABETS_TOTAL_LIMIT =
	 * "couponcode.alphabets.total.limit"; public static final String
	 * COUPONCODE_INVALID_USER_LIMIT = "couponcode.invalid.user.limit"; public
	 * static final String COUPONCODE_INVALID_PERCENTAGE_DISCOUNT =
	 * "couponcode.invalid.percentage.discount"; public static final String
	 * COUPONCODE_INVALID_ALPHABET_PERCENTAGE_DISCOUNT =
	 * "couponcode.invalid.alphabet.percentage.discount"; public static final String
	 * COUPONCODE_INVALID_MAXIMUM_PERCENTAGE_DISCOUNT =
	 * "couponcode.invalid.maximum.percentage.discount"; public static final String
	 * COUPONCODE_SEARCH_INVALID_DELETED_COUPON =
	 * "couponcode.search.invalid.deleted.coupon"; public static final String
	 * COUPONCODE_INVALID_PERCENTAGE_DISCOUNT_ALPHA =
	 * "couponcode.invalid.percentage.discount.alpha";
	 */

	public static final String NO_ANNOUNCEMENT_TEXT = "no.announcement.text";

	/* Content market Course */
	public static final String CONTENTMARKET_SEARCH_COURSE = "contentmarket.search.course";
	public static final String MYCOURSE_SEARCH_COURSE = "mycourses.search.course";
	public static final String CONTENTMARKET_ANNOUNCEMENT_MAKEANNOUNCE_TEXT = "announcement.makeannounce.text";
	public static final String CONTENTMARKET_ANNOUNCEMENT_MAKEANNOUNCE_DOCUMENT = "announcement.makeannounce.document";
	public static final String CONTENTMARKET_ANNOUNCEMENT_MAKEANNOUNCE_EXCEL = "announcement.makeannounce.excel";
	public static final String CONTENTMARKET_ANNOUNCEMENT_EDIT_MAKEANNOUNCE_TEXT = "announcement.edit.makeannounce.text";

	/* Create installment for Course */
	public static final String CREATE_INSTALLMENT_SEARCH_COURSE = "create.installment.search.course";
	public static final String NUMBER_OF_INSTALLMENTS = "number.of.installments";
	public static final String CREATE_INSTALLMENT_EDIT_PRICE = "create.installment.edit.price";
	public static final String CRAETE_INSTALLMENT_EDIT_TOTALINSTALLMENT = "create.installment.edit.totalinstallment";
	/* Custom bannners */
	public static final String CUSTOM_BANNER_SEARCH_COURSE = "custom.banner.search.course";
	public static final String CUSTOM_BANNER_EXTERNAL_LINK = "custom.banner.external.link";
	public static final String CUSTOM_BANNER_YOUTUBE_LINK = "custom.banner.youtube.link";
	/* Mark featured course */
	public static final String MARKFEATURED_SEARCH_COURSE = "markfeatured.search.course";
	public static final String MARKFEATURED_DRAGGABLE_ELEMENT_INDEX1 = "draggableElementsIndex1";
	public static final String MARKFEATURED_DRAGGABLE_ELEMENT_INDEX2 = "draggableElementsIndex2";
	/* Student settings sorting */

	public static final String STUDENT_SORTING_SEARCH_COURSE = "student.sorting.search.course";
	public static final String STUDENT_SORTING_SEARCH_STUDENT = "student.sorting.search.student";

	/* Reseller settings */
	public static final String RESELLERS_SEARCH_COURSE = "resellers.search.course";
	/* Student side_Buy course_View course */
	public static final String STUDENT_SEARCH_COURSE = "student.search.course";
	public static final String STUDENT_VIEW_CONTENT_SEARCH_COURSE = "student.view.content.search.course";
	public static final String STUDENT_SEARCH_PURCHASE_COURSE = "student.search.purchase.course";
	public static final String STUDENT_MESSAGE_TO_TUTOR = "student.message.to.tutor";
	/* Faculty side _Add Content */
	public static final String FACULTY_SEARCH_COURSE = "faculty.search.course";
	public static final String TXT_FACULTY_NAME = "txt.faculty.name";
	public static final String TXT_FACULTY_MOBILE_NUMBER = "txt.faculty.mobile.number";
	public static final String TXT_FACULTY_EMAIL = "txt.faculty.email";
	public static final String TXT_ADD_FACULTY_NAME = "txt.add.faculty.name";
	public static final String TXT_ADD_FACULTY_MOBILE_NUMBER = "txt.add.faculty.mobile.number";

	

	public static final String FACULTY_SEARCH_WITH_VALID_COURSE = "faculty.search.with.valid.course";
	public static final String REMOVE_CONFIRMATION_HEADER = "remove.confirmation.header";
	public static final String FACULTY_NAME_LABEL = "faculty.name.label";
	public static final String FACULTY_SEARCH_WITH_INVALID_COURSE = "faculty.search.with.invalid.course";
	public static final String FACULTY_NOTHING_FOUND_MESSAGE = "faculty.nothing.found.message";
	public static final String FACULTY_NO_RESULTS_MESSAGE = "faculty.no.results.message";
	public static final String CREATECOURSE_FACULTY_TITLE = "createcourse.faculty.title";
	public static final String CREATED_FACULTY_NAME_LABEL = "created.faculty.name.label";
	public static final String FACULTY_LIVE_CLASSES_COURSE = "create.faculty.live.classes.course";
	public static final String FACULTY_FREE_CONTENT_COURSE = "faculty.free.content.course";
	public static final String VIEW_STATS_LABEL_TEXT = "view.stats.label.text";
	public static final String YOUR_SCORE_NAME_LABEL_TEXT = "your.score.name.label.text";
	public static final String HIGH_SCORE_NAME_LABEL_TEXT = "high.score.name.label.text";
	public static final String VIEW_ANSWER_SHEET_BUTTON_TEXT = "view.answers.sheet.button.text";
	public static final String DOWNLOAD_BUTTON_TEXT = "download.button.text";
	public static final String FACULTY_SEARCH_SUBJECTIVETEST_COURSE = "faculty.search.subjectivetest.course";
	public static final String SUBJECTIVE_TEST_HEADER = "subjective.test.header";
	public static final String WHATSAPP_HEADER_LABEL = "whatsapp.header.label";
	public static final String FACEBOOK_HEADER_LABEL = "facebook.header.label";
	public static final String LINKEDIN_HEADER_LABEL = "linkedin.header.label";
	public static final String TELEGRAM_HEADER_LABEL = "telegram.header.label";
	public static final String LEFT_MENU_LABELS = "left.menu.labels";
	/* Parent side _Buy course_View course */
	public static final String PARENT_PURCHASE_SEARCH_COURSE = "parent.purchase.search.course";
	public static final String PARENT_SEARCH_COURSE = "parent.search.course";
	public static final String PARENT_MESSAGE_TO_TUTOR = "parent.message.to.tutor";
	/* EXPECTED ASSERTIONS PROPERTIES */
	/* Site Login */
	public static final String LABEL_LOGIN_HEADING = "login.heading.text";
	public static final String LABEL_OTP_HEADING = "otp.heading.text";
	/* Create Course */
	public static final String LABEL_STORE_MYCOURSES = "label.store.mycourses";
	public static final String LABEL_CREATECOURSE = "label.createcourse";
	public static final String LABEL_STATS = "label.stats";
	public static final String LABEL_COUPONS = "label.coupons";
	public static final String LABEL_COURSES_SUBCATEGORIES = "label.courses.subcategories";
	public static final String LABEL_HOMEPAGE_COURSES = "label.homepage.courses";
	public static final String LABEL_VIEWALL_COURSES = "label.viewall.courses";
	public static final String LABEL_SORT_FILTER = "label.sort.filter";

	public static final String LABEL_STORE_CREATECOURSE = "label.store.createcourse";
	public static final String LABEL_COURSE_TAX_DETAILS_HEADING_TEXT = "label.course.taxdetails.heading.text";
	public static final String COURSE_CREATED_SUCCESSFULLY_TEXT = "course.created.successfully.text";
	public static final String LABEL_COURSE_CONTENT = "label.course.content";
	public static final String LABEL_STORE_CREATECOURSE_COURSE_NAME = "label.store.createcourse.course.name";
	public static final String LABEL_STORE_CREATECOURSE_DESCRIPTION = "label.store.createcourse.description";
	public static final String LABEL_STORE_CREATECOURSE_CATEGORIES = "label.store.createcourse.categories";
	public static final String LABEL_STORE_CREATECOURSE_SUB_CATEGORIES = "label.store.createcourse.subcategories";
	public static final String LABEL_STORE_CREATECOURSE_INTERNET_HANDLING_CHARGES = "label.store.createcourse.internet.handling.charges";
	public static final String LABEL_STORE_CREATECOURSE_TAX_DETAILS = "label.store.createcourse.tax.details";
	public static final String LABEL_STORE_CREATECOURSE_COURSE_DURATION = "label.store.createcourse.course.duration";
	public static final String LABEL_STORE_CREATECOURSE_OFFLINE_ACCESS_PERMISSIONS = "label.store.createcourse.offline.access.permissions";
	public static final String LABEL_STORE_CREATECOURSE_PDF_DOWNLOAD_PERMISSION = "label.store.createcourse.pdf.download.permissions";
	public static final String LABEL_STORE_CREATECOURSE_LIVE_CLASSES = "label.store.createcourse.live.classes";
	public static final String LABEL_STORE_CREATECOURSE_VIDEO_RESTRICTIONS = "label.store.createcourse.video.restrictions";
	public static final String LABEL_STORE_CREATECOURSE_PREVIEW_COURSE_FEATURE = "label.store.createcourse.preview.course.feature";
	public static final String LABEL_STORE_CREATECOURSE_ENTER_PRICE = "label.store.createcourse.enter.price";
	public static final String LABEL_STORE_CREATECOURSE_DISCOUNT = "label.store.createcourse.discount";
	public static final String LABEL_STORE_CREATECOURSE_EFFECTIVE_PRICE = "label.store.createcourse.effective.price";
	public static final String LABEL_STORE_CREATECOURSE_COURSE_SHARING = "label.store.createcourse.course.sharing";
	public static final String LABEL_STORE_CREATECOURSE_OFFLINE_SHIPMENT = "label.store.createcourse.offline.shipment";
	public static final String LABEL_STORE_CREATECOURSE_STUDENT_CERTIFICATE = "label.store.createcourse.student.certificate";

	public static final String LABEL_CREATECOURSE_PRE_TITLE_FOR_AUTOMATION_TESTING = "label.createcourse.pre.title.for.automation.testing";
	public static final String LABEL_CREATECOURSE_DESCRIPTION_FOR_AUTOMATION_TESTING = "label.createcourse.description.for.automation.testing";
	public static final String CREATECOURSE_PRICE_FOR_AUTOMATION_TESTING = "course.price.for.automation.testing";

	public static final String INSTALLMENT_CREATECOURSE_PRICE_FOR_AUTOMATION_TESTING = "installment.course.price.for.automation.testing";
	public static final String LABEL_SAVE_PDF_TOOGLE = "lbl.save.pdf.toogle";
	public static final String HELP_TEXT_SAVE_PDF_TOOGLE = "help.text.save.pdf";
	public static final String TEXT_CREATECOURSE_SHIPMENT = "txt.createcourse.shipment";
	public static final String HELP_TEXT_CREATECOURSE_SHIPMENT_TOOGLE = "help.text.createcourse.shipment";
	public static final String NOTE_COURSE_OFFLINE_SHIPMENT = "note.course.offline.shipment";
	public static final String TENTATIVE_DAYS = "set.tentative.days";
	public static final String TENTATIVEDAYS_TEXT_COURSEOVERVIEW = "tentative.days.text";
	public static final String COURSE_EDIT_SICCESSFULLY = "course.edit";
	public static final String SHIPMENT_HELPTEXT_COURSEOVERVIEW_PAGE = "help.text.shipment.course.overview";
	public static final String NOTE_COURSE_OFFLINE_SHIPMENT2 = "note.course.offline.shipment2";

	/* Edit Course */
	public static final String LABEL_EDIT_COURSE = "label.edit.course";
	public static final String FREE_CONTENT_TEXT = "free.content.text";
	public static final String LABEL_CHANGE_COURSE_DURATION = "label.change.course.duration";

	/* Add content Course */
	public static final String LABEL_ADDCONTENT_MYCOURSES = "addcontent.mycourses";
	public static final String LABEL_ADDCONTENT = "add.content.label";
	public static final String LABEL_REMOVE_SUBJECTIVETEST = "remove.subjectivetest.label";
	public static final String REMOVED_SUBJECTIVETEST_SUCCESSFULLY_TEXT = "subjectiveTest.deleted.successfully.text";
	public static final String LABEL_IMPORT_CONTENT = "import.content.label";
	public static final String CONTENT_IMPORTED_SUCCESSFULLY_TEXT = "content.imported.successfully.text";
	public static final String LABEL_IMPORT_LIVE_CLASSES = "import.live.classes.label";
	public static final String LABEL_PUBLISH_COURSE = "publish.course.label";
	public static final String COURSE_PUBLISHED_TEXT = "course.published.text";
	public static final String MSG_COURSE_CREATED_INSTALLMENTS="msg.course.created.installments";
	public static final String LABEL_UNPUBLISH_COURSE = "unpublish.course.label";
	public static final String UNPUBLISH_COURSE_TEXT = "unpublish.course.text";
	public static final String LABEL_COURSE_REMOVE_CONFIRMATION = "course.remove.confirmation.text";
	public static final String LABEL_FOR_UPLOADING_IMAGE = "label.upload.image";
	public static final String LABEL_FOR_UPLOADING_PDF = "label.upload.pdf";
	public static final String LABEL_FOR_UPLOADING_EXCEL = "label.upload.excel";
	public static final String LABEL_FOR_UPLOADING_VIDEO = "label.upload.video";
	public static final String LABEL_FOR_UPLOADING_ZIP = "label.upload.zip";
	/* Student sorting */
	public static final String LABEL_STORE_OVERVIEW = "label.store.overview";
	public static final String LABEL_STUDENT_STATUS = "label.students.status";
	public static final String LABEL_STUDENT_NAME = "label.students.name";
	public static final String LABEL_STUDENT_MOBILE_NUMBER = "label.students.mobile.number";
	public static final String LABEL_STUDENT_NAME_HEADING = "label.student.name.heading";
	public static final String LABEL_MESSAGE_TO_STUDENT = "label.message.to.student";
	public static final String LABEL_MESSAGE = "label.message";

	/* Resellers settings */
	public static final String LABEL_RESALE_SETTINGS = "label.resale.settings";
	public static final String LABEL_EDIT_PERMISSIONS = "label.edit.permissions";
	public static final String PERMISSION_SUCCESS_MESSAGE_TEXT = "text.permission.success.message";
	public static final String RESELLERS_REVOKED_SUCCESSFULLY_TEXT = "resellers.revoked.successfully";
	public static final String ENABLED_SUCCESSFULLY_TEXT = "text.enabled.successfully";
	/* Merchant dash board */
	public static final String LABEL_FILTERS = "label.filters";
	public static final String LABEL_EARNINGS = "label.earnings";
	public static final String LABEL_TOTAL_REVENUE = "label.revenue";
	public static final String LABEL_NUMBER_PURCHASE = "label.purchase";
	public static final String LABEL_DOWNLOAD_REPORTS = "label.download.reports";
	public static final String EXPORT_SUCCESS_MESSAGE_TEXT = "your.reports.have.been.sent.on.email";
	public static final String LABEL_GROUP_STUDY = "label.group.study";
	public static final String MSG_DELETE_WATER_MARK = "message.delete.water.mark";
	public static final String MSG_UPLOAD_WATER_MARK = "message.upload.water.mark";

	public static final String LABEL_CUSTOMIZE_CLASS_TEST_GRADING = "label.customize.class.test.grading";
	public static final String LABEL_CUSTOMIZE_CLASS_TEST_GRADING_HEADING = "label.customize.class.test.grading.heading";
	public static final String LABEL_CUSTOMIZE_CLASS_TEST_GRADING_TEXT = "label.customize.class.test.grading.text";
	public static final String LABEL_GRADE_A_VALUE = "label.grade.a.value";
	public static final String LABEL_GRADE_B_VALUE = "label.grade.b.value";
	public static final String LABEL_GRADE_C_VALUE = "label.grade.c.value";
	public static final String LABEL_GRADE_D_VALUE = "label.grade.d.value";
	public static final String LABEL_GRADE_E_VALUE = "label.grade.e.value";
	/* Coupon code Course */
	public static final String COUPONCODE_FLATDISCOUNT_AMOUNT = "couponcode.flat.discount.amount";
	public static final String COUPONCODE_MIN_ORDER_VALUE = "couponcode.min.order.value";
	public static final String COUPONCODE_OFFER_NAME = "couponcode.set.offer.name";
	public static final String COUPONCODE_SET_COUPONCODE = "couponcode.set.couponcode";
	public static final String COUPONCODE_TOTAL_LIMIT = "couponcode.total.limit";
	public static final String COUPONCODE_USER_LIMIT = "couponcode.user.limit";
	public static final String COUPONCODE_EDIT_MIN_ORDER_VALUE = "couponcode.edit.min.order.value";
	public static final String COUPONCODE_EDIT_OFFER_NAME = "couponcode.edit.offer.name";
	public static final String COUPONCODE_EDIT_TOTAL_LIMIT = "couponcode.edit.total.limit";
	public static final String COUPONCODE_PERCENTAGE_DISCOUNT = "couponcode.percentage.discount";
	public static final String COUPONCODE_MAXIMUM_PERCENTAGE_DISCOUNT = "couponcode.maximum.percentage.discount";
	public static final String COUPONCODE_SEARCH_COURSE = "couponcode.search.course";
	public static final String COUPONCODE_SEARCH_STUDENT = "couponcode.search.student";
	public static final String COUPONCODE_SEARCH_COUPON = "couponcode.search.coupon";
	public static final String COUPONCODE_SEARCH_DELETED_COUPON = "couponcode.search.deleted.coupon";
	public static final String COUPONCODE_EDIT_USAGE_PER_STUDENT = "couponcode.edit.usage.perstudent";
	public static final String COUPONCODE_EDIT_MINIMUM_ORDER_VALUE = "couponcode.edit.minimum.order.value";
	public static final String COUPONCODE_SPECIAL_CHARACTERS_MIN_ORDER_VALUE = "couponcode.special.characters.min.order.value";
	public static final String COUPONCODE_OFFER_NAME1 = "couponcode.offer.name1";
	/* Create Coupon code */
	public static final String LABEL_COUPONCODE = "couponcode.couponcodes.label";
	public static final String LABEL_CREATE_COUPONCODE = "couponcode.createcouponcode";
	public static final String COUPONCODE_CREATED_SUCCESSFULLY_TEXT = "coupon.created.successfully.text";
	public static final String COUPONCODE_UPDATED_SUCCESSFULLY_TEXT = "coupon.updated.successfully.text";
	public static final String COUPONCODE_DETAILS_SUCCESSFULLY_TEXT = "coupon.details.successfully.text";
	public static final String COUPONCODE_DELETED_SUCCESSFULLY_TEXT = "coupon.deleted.successfully.text";
	public static final String LABEL_CREATE_COUPON_CODE_DISCOUNT_TYPE = "label.create.coupon.code.discount.type";
	public static final String LABEL_CREATE_COUPON_CODE_DISCOUNT_AMOUNT = "label.create.coupon.code.discount.amount";
	public static final String LABEL_CREATE_COUPON_CODE_START_DATE = "label.create.coupon.code.start.date";
	public static final String LABEL_CREATE_COUPON_CODE_START_TIME = "label.create.coupon.code.start.time";
	public static final String LABEL_CREATE_COUPON_PERCENTAGE_DISCOUNT = "label.createcoupon.percentage.discount";
	public static final String LABEL_CREATE_COUPON_PERCENTAGE_DISCOUNT1 = "label.createcoupon.percentage.discount1";
	public static final String LABEL_CREATE_COUPON_MAXIMUM_PERCENTAGE_DISCOUNT = "label.createcoupon.maxiumum.percentage.discount";
	public static final String LABEL_CREATE_COUPONCODE_PRIVATE_COUPON = "label.create.couponcode.private.coupon";
	public static final String LABEL_CREATE_COUPONCODE_ELIGIBLE_COURSES = "label.create.couponcode.eligible.courses";
	public static final String LABEL_COUPONCODE_VIEW_HISTORY = "label.couponcode.view.history";
	public static final String LABEL_COUPONCODE_COUPON_INFORMATION = "label.couponcode.coupon.information";
	public static final String LABEL_COUPONCODE_ELIGIBLE_STUDENTS = "label.couponcode.eligible.students";
	public static final String LABEL_COUPONCODE_ASSIGNED_COURSES = "label.couponcode.assigned.courses";
	public static final String LABEL_COUPONCODE_USAGE_LIMIT = "label.couponcode.usage.limit";
	public static final String LABEL_COUPONCODE_USAGE_LABEL = "label.couponcode.usage.per.student";
	public static final String LABEL_COUPONCODE_MINIMUM_ORDER_VALUE = "label.couponcode.minimum.order.value";
	public static final String COUPONCODE_EDIT_USAGE_LIMIT_VALUE = "couponcode.edit.usage.limit.value";
	public static final String LABEL_EDIT_COUPON_DETAILS = "label.edit.coupon.details";
	public static final String LABEL_COUPONCODE_COUPON_NAME = "label.couponcode.name";
	public static final String COUPONCODE_NOT_FOUND_TEXT = "couponcode.not.found.text";
	public static final String LABEL_COUPON_CODE = "label.coupon.code";
	public static final String LABEL_PRO_TUTOR = "label.pro.tutor";
	public static final String LABEL_PUBLIC_COUPON = "label.public.coupon";
	public static final String LABEL_COUPON_CODE_DURATION = "label.coupon.code.duration";
	public static final String LABEL_EXPIRED = "label.expired";
	public static final String LABEL_COUPONCODE_DISCOUNT_REQUIRED = "label.couponcode.discount.required";
	public static final String LABEL_COUPONCODE_INVALID_START_DATE = "label.couponcode.invalid.start.date";
	public static final String LABEL_COUPONCODE_START_DATE_REQUIRED = "label.couponcode.start.date.required";
	public static final String LABEL_CREATE_COUPON_CODE_START_TIME_REQUIRED = "label.couponcode.start.time.required";
	public static final String LABEL_CREATE_COUPON_CODE_IN_VALID_START_TIME = "label.couponcode.in.valid.start.time";
	public static final String LABEL_CREATE_COUPON_CODE_IN_VALID_END_TIME = "label.couponcode.in.valid.end.time";
	public static final String CREATE_COUPON_CODE_VALID_START_TIME = "create.couponcode.valid.start.time";
	public static final String LABEL_CREATE_COUPON_CODE_END_TIME_NOT_VALID = "label.couponcode.end.time.not.valid";
	public static final String COUPONCODE_FLATDISCOUNT_INVALID_AMOUNT_ALPHA = "couponcode.flatdiscount.invalid.amount.alpha";
	public static final String COUPONCODE_BLANK_MIN_ORDER_VALUE = "couponcode.blank.min.order.value";
	public static final String COUPONCODE_ALPHABETS_MIN_ORDER_VALUE = "couponcode.alphabet.min.order.value";
	public static final String LABEL_CREATE_COUPON_CODE_BLANK_MIN_ORDER_VALUE = "label.couponcode.blank.min.order.value";
	public static final String LABEL_CREATE_COUPON_CODE_OFFER_NAME_2CHARACTERS = "label.couponcode.offer.name.2characters";
	public static final String LABEL_CREATE_COUPON_CODE_OFFER_NAME_21CHARACTERS = "label.couponcode.offer.name.21characters";
	public static final String LABEL_CREATE_COUPON_CODE_BLANK_OFFER_NAME = "label.couponcode.blank.offer.name";
	public static final String LABEL_INVALID_COUPON_CODE_4CHARACTERS = "label.invalid.coupon.code.4characters";
	public static final String LABEL_INVALID_COUPON_CODE_21CHARACTERS = "label.invalid.coupon.code.21characters";
	public static final String LABEL_CREATECOUPON_EXISTING_COUPON_CODE = "label.createcoupon.existing.coupon.code";
	public static final String LABEL_CREATECOUPON_BLANK_TOTAL_LIMIT = "label.createcoupon.blank.total.limit";
	public static final String LABEL_CREATECOUPON_ALPHABETS_TOTAL_LIMIT = "label.createcoupon.alphabets.total.limit";
	public static final String LABEL_CREATECOUPON_BLANK_USAGE_LIMIT = "label.createcoupon.blank.usage.limit";
	public static final String LABEL_CREATECOUPON_ALPHABETS_USAGE_LIMIT = "label.createcoupon.alphabet.usage.limit";
	public static final String LABEL_COUPONCODE_INVALID_PERCENTAGE_DISCOUNT = "label.couponcode.invalid.percentage.discount";
	public static final String LABEL_COUPONCODE_BLANK_PERCENTAGE_DISCOUNT = "label.couponcode.blank.percentage.discount";
	// NEGATIVE
	public static final String COUPONCODE_FLATDISCOUNT_INVALID_AMOUNT = "couponcode.flat.discount.invalid.amount";
	public static final String COUPONCODE_INVALID_START_DATE = "couponcode.invalid.start.date";
	public static final String COUPONCODE_VALID_START_DATE = "couponcode.valid.start.date";
	public static final String LABEL_CREATE_COUPON_CODE_INVALID_START_TIME = "label.couponcode.invalid.start.time";
	public static final String COUPONCODE_INVALID_OFFER_NAME_2LETTER = "label.couponcode.invalid.offer.name.2letters";
	public static final String COUPONCODE_INVALID_OFFER_NAME_21LETTERS = "label.couponcode.invalid.offer.name.21letters";
	public static final String COUPONCODE_BLANK_OFFER_NAME_ = "label.couponcode.blank.offer.name";
	public static final String LABEL_COUPONCODE_SET_INVALID_COUPON_4CHARACTERS = "label.couponcode.set.invalid.coupon.4characters";
	public static final String COUPONCODE_SET_INVALID_COUPON_21CHARACTERS = "label.couponcode.set.invalid.coupon.21characters";
	public static final String COUPONCODE_EXISTING_COUPON = "label.couponcode.set.existing.coupon";
	public static final String COUPONCODE_ALPHABETS_TOTAL_LIMIT = "couponcode.alphabets.total.limit";
	public static final String COUPONCODE_INVALID_USER_LIMIT = "couponcode.invalid.user.limit";
	public static final String COUPONCODE_INVALID_PERCENTAGE_DISCOUNT = "couponcode.invalid.percentage.discount";
	public static final String COUPONCODE_INVALID_ALPHABET_PERCENTAGE_DISCOUNT = "couponcode.invalid.alphabet.percentage.discount";
	public static final String COUPONCODE_INVALID_MAXIMUM_PERCENTAGE_DISCOUNT = "couponcode.invalid.maximum.percentage.discount";
	public static final String COUPONCODE_SEARCH_INVALID_DELETED_COUPON = "couponcode.search.invalid.deleted.coupon";
	public static final String COUPONCODE_INVALID_PERCENTAGE_DISCOUNT_ALPHA = "couponcode.invalid.percentage.discount.alpha";
	/* Create installment */
	public static final String LABEL_NUMBER_OF_INSTALLMENTS_IN_TESTING_COURSE = "number.of.installments.in.testing.course";
	public static final String LABEL_CREATEINSTALLMENT = "label.createinstallment";
	public static final String LABEL_INSTALLMENT = "label.installment";
	public static final String LABEL__INSTALMENT_DELETE = "delete.label";
	public static final String LABEL_CREATEINSTALLMENT_COURSE_PRICE = "label.createinstallment.course.price";
	public static final String LABEL_CREATEINSTALLMENT_TOTAL_INSTALLMENTS = "label.createinstallment.total.installments";
	public static final String LABEL_CREATEINSTALLMENT_EFFECTIVE_COURSE_PRICE = "label.createinstallment.effective.course.price";
	public static final String LABEL_CREATEINSTALLMENT_INSTALLMENT_PERIOD = "label.createinstallment.installment.period";
	public static final String LABEL_CREATEINSTALLMENT_INSTALLMENTS_DETAILS = "label.createinstallment.installment.details";
	public static final String LABEL_CREATEINSTALLMENT_EFFECTIVE_PRICE = "label.createinstallment.effective.price";
	public static final String LABEL_CREATEINSTALLMENT_1ST_INSTALLMENT = "label.createinstallment.1st.installment";
	public static final String LABEL_CREATEINSTALLMENT_DATE_OF_PURCHASE = "label.createinstallment.date.of.purchase";
	public static final String LABEL_CREATEINSTALLMENT_2ND_INSTALLMENT = "label.createinstallment.2nd.installment";
	public static final String LABEL_CREATEINSTALLMENT_2ND_WEEK_LABEL = "label.createinstallment.2nd.week";
	public static final String LABEL_CREATEINSTALLMENT_3RD_INSTALLMENT = "label.createinstallment.3rd.installment";
	public static final String LABEL_CREATEINSTALLMENT_4RTH_WEEK_LABEL = "label.createinstallment.4rth.week";
	public static final String LABEL_CREATEINSTALLMENT_4RTH_INSTALLMENT = "label.createinstallment.4rth.installment";
	public static final String LABEL_CREATEINSTALLMENT_6TH_WEEK_LABEL = "label.createinstallment.6th.week";
	public static final String LABEL_CREATEINSTALLMENT_IMPORTANT_INFORMATION = "label.createinstallment.important.information";
	public static final String LABEL_CREATEINSTALLMENT_MISSED_INSTALLMENTS = "label.createinstallment.missed.installments";
	public static final String LABEL_CREATEINSTALLMENT_LOSE_COURSE = "label.createinstallment.lose.course";
	public static final String LABEL_CREATEINSTALLMENT_COUPONS_CANT_ASSIGNED = "label.createinstallment.coupons.not.assigned";
	public static final String LABEL_CREATEINSTALLMENT_INSTALLMENTS_CREATED = "label.createinstallment.installments.created";
	public static final String LABEL_CREATEINSTALLMENT_MULTIPLE_INSTALLMENTS = "label.createinstallment.multiple.installments";
	public static final String LABEL_INSTALLMENT_STUDENT_PAY_AMOUNT_INSTALLMENT = "label.createinstallment.student.pay.installments";
	public static final String LABEL_INSTALLMENT_EDIT_INSTALLMENT_TEXT = "label.createinstallment.edit.installment.text";
	public static final String LABEL_CREATE_INSTALMENT = "label.create.installment";
	public static final String LABEL_CREATEINSTALLMENT_1ST_MONTH_LABEL = "label.createinstallments.1st.month";
	public static final String LABEL_CREATEINSTALLMENT_2ND_MONTH_LABEL = "label.createinstallments.2nd.month";
	public static final String LABEL_CREATEINSTALLMENT_3RD_MONTH_LABEL = "label.createinstallments.3rd.month";
	public static final String LABEL_CREATEINSTALLMENT_INSTALLMENT_PRICE = "label.createinstallment.installment.price";
	public static final String CREATE_INSTALLMENT_COURSE_PRICE = "course.price";
	public static final String LABEL_CREATEINSTALLMENT_5TH_INSTALLMENT = "label.createinstallment.5th.installment";
	public static final String LABEL_CREATEINSTALLMENT_4TH_MONTH_LABEL = "label.createinstallment.4th.month";
	public static final String LABEL_CREATEINSTALLMENT_6TH_INSTALLMENT = "label.createinstallment.6th.installment";
	public static final String LABEL_CREATEINSTALLMENT_5TH_MONTH_LABEL = "label.createinstallment.5th.month";
	public static final String LABEL_CREATEINSTALLMENT_7TH_INSTALLMENT = "label.createinstallment.7th.installment";
	public static final String LABEL_CREATEINSTALLMENT_6TH_MONTH_LABEL = "label.createinstallment.6th.month";
	public static final String LABEL_CREATEINSTALLMENT_8TH_INSTALLMENT = "label.createinstallment.8th.installment";
	public static final String LABEL_CREATEINSTALLMENT_7TH_MONTH_LABEL = "label.createinstallment.7th.month";
	public static final String LABEL_CREATEINSTALLMENT_9TH_INSTALLMENT = "label.createinstallment.9th.installment";
	public static final String LABEL_CREATEINSTALLMENT_8TH_MONTH_LABEL = "label.createinstallment.8th.month";
	public static final String LABEL_CREATEINSTALLMENT_10TH_INSTALLMENT = "label.createinstallment.10th.installment";
	public static final String LABEL_CREATEINSTALLMENT_9TH_MONTH_LABEL = "label.createinstallment.9th.month";
	public static final String LABEL_CREATEINSTALLMENT_11TH_INSTALLMENT = "label.createinstallment.11th.installment";
	public static final String LABEL_CREATEINSTALLMENT_10TH_MONTH_LABEL = "label.createinstallment.10th.month";
	public static final String LABEL_CREATEINSTALLMENT_12TH_INSTALLMENT = "label.createinstallment.12th.installment";
	public static final String LABEL_CREATEINSTALLMENT_11TH_MONTH_LABEL = "label.createinstallment.11th.month";
	public static final String LABEL_CREATEINSTALLMENT_12TH_MONTH_LABEL = "label.createinstallment.12th.month";
	public static final String LABEL_CREATEINSTALLMENT_14TH_MONTH_LABEL = "label.createinstallment.14th.month";
	public static final String LABEL_CREATEINSTALLMENT_16TH_MONTH_LABEL = "label.createinstallment.16th.month";
	public static final String LABEL_CREATEINSTALLMENT_18TH_MONTH_LABEL = "label.createinstallment.18th.month";
	public static final String LABEL_CREATEINSTALLMENT_20TH_MONTH_LABEL = "label.createinstallment.20th.month";
	public static final String LABEL_CREATEINSTALLMENT_22TH_MONTH_LABEL = "label.createinstallment.22th.month";
	public static final String LABEL_CREATEINSTALLMENT_15TH_MONTH_LABEL = "label.createinstallment.15th.month";
	public static final String LABEL_CREATEINSTALLMENT_21TH_MONTH_LABEL = "label.createinstallment.21th.month";
	public static final String LABEL_CREATEINSTALLMENT_24TH_MONTH_LABEL = "label.createinstallment.24th.month";
	public static final String LABEL_CREATEINSTALLMENT_27TH_MONTH_LABEL = "label.createinstallment.27th.month";
	public static final String LABEL_CREATEINSTALLMENT_30TH_MONTH_LABEL = "label.createinstallment.30th.month";
	public static final String LABEL_CREATEINSTALLMENT_33TH_MONTH_LABEL = "label.createinstallment.33th.month";
	public static final String LABEL_CREATEINSTALLMENT_36TH_MONTH_LABEL = "label.createinstallment.36th.month";
	public static final String LABEL_CREATEINSTALLMENT_42ND_MONTH_LABEL = "label.createinstallment.42nd.month";
	public static final String LABEL_CREATEINSTALLMENT_48TH_MONTH_LABEL = "label.createinstallment.48th.month";
	public static final String LABEL_CREATEINSTALLMENT_54TH_MONTH_LABEL = "label.createinstallment.54th.month";
	public static final String LABEL_CREATEINSTALLMENT_60TH_MONTH_LABEL = "label.createinstallment.60th.month";
	public static final String LABEL_CREATEINSTALLMENT_66TH_MONTH_LABEL = "label.createinstallment.66th.month";
	public static final String CREATECOURSE_PRICE_FOR_TUTOR_AUTOMATION_TESTING = "tutor.course.price.for.automation.testing";
	/* Custom banner */
	public static final String LABEL_UPLOADBANNER_YOUR_BANNERS = "label.uploadBanner.your.banners";
	public static final String LABEL_PUBLISH_CONFIRMATION_BANNERS = "label.publish.confirmation.banners";
	public static final String BANNERS_UPDATED_SUCCESSFULLY_TEXT = "banners.updated.successfully.text";
	public static final String LABEL_BANNERS_REORDER = "label.banners.reorder";
	public static final String CUSTOM_BANNER_REMOVE_BANNERS_TEXT = "custom.banner.remove.banners.text";
	public static final String BANNERS_PUBLISH_REMOVED_SUCCESSFULLY_TEXT = "custom.banner.all.removed.message";
	public static final String LABEL_BANNERS_COURSE_SELECTSCREEN = "label.landing.selectscreen.courses";
	/* Content Market */
	public static final String LABEL_CONTENT_MARKET = "label.content.market";
	public static final String CONTENT_MARKET_SAVE_COURSE_TEXT = "content.market.save.course.txt";
	public static final String LABEL_MYCOURSE_UPDATE = "label.mycourse.update";
	public static final String LABEL_MYCOURSE_STUDENT = "label.mycourse.student";
	public static final String LABEL_MAKE_ANNOUNCEMENT = "label.make.announcement";
	public static final String LABEL_POSTSMS_ANNOUNCEMENT = "label.postsms.announcement";
	public static final String ANNOUNCE_ADDED_SUCCESSFULLY_TEXT = "announce.added.successfully.text";
	public static final String ANNOUNCE_PDF_ADDED_SUCCESSFULLY_TEXT = "announce.pdf.added.successfully.text";
	public static final String ANNOUNCE_EXCEL_ADDED_SUCCESSFULLY_TEXT = "announce.excel.added.successfully.text";
	public static final String ANNOUNCE_EDIT_SUCCESSFULLY_TEXT = "announce.edit.successfully.text";
	public static final String LABEL_COURSE_NAME_TITLE = "label.course.name.title";
	public static final String LABEL_ANNOUNCEMENT_DELETE_CONFIRM_TEXT = "label.announccement.delete.confirm.text";
	public static final String SEARCH_EXCEL_ANNOUNCEMENT = "search.excel.announcement";
	public static final String LABEL_SEARCH_PDF_ANNOUNCEMENT = "label.search.pdf.announcement";
	public static final String LABEL_ANNOUNCEMENT__DELETE_TEXT = "label.delete.confirmation.announcement";
	public static final String LABEL_CONTENT_PUBLISH_COURSE = "label.publish.course";
	public static final String COURSE_PUBLISHED_SUCCESSFULLY_TEXT = "course.published.successfully.text";
	public static final String LABEL_CONTENT_UNPUBLISH_COURSE = "label.unpublish.course";
	public static final String UNPUBLISH_COURSE_SAVE_TEXT = "unpublish.course.save.text";
	public static final String LABEL_REMOVE_CONFIRMATION = "label.remove.confirmation";
	/* Mark Featured Course */
	public static final String LABEL_MARK_FEATURED_COURSE = "mark.featured.course.label";
	public static final String COURSE_MARK_AS_FEATURED_TEXT = "course.marked.as.featured.text";
	public static final String LABEL_FEATURED_COURSELIST = "featured.courseslist.label";
	public static final String COURSE_REMOVED_FROM_LIST_TEXT = "course.removed.from.list.text";
	public static final String COURSE_ADDED_TO_LIST_TEXT = "Course.added.to.list.text";
	public static final String REORDER_LIST_SUCCESS_TEXT = "markfeature.reorder.list.success.text";
	public static final String REORDER_LIST_SAVE_SUCCESSFULL_TEXT = "markfeature.reorder.save.successful.text";
	public static final String LABEL_MARKFEATURE_APP_DOWNLOADS = "markfeature.appdownloads.label";
	public static final String MARKFEATURE_LINK_COPIED_TEXT = "markfeature.link.copied.successful.text";
	public static final String COURSE_REMOVED_FROM_FEATURED_COURSES_TEXT = "Course.removed.from.featured.courses.list.text";
	/* Parent side BuyCourse */
	public static final String LABEL_PARENT_PURCHASE_COURSE_FILTER = "parent.purchase.course.Filter";
	/* Parent side view Course */
	public static final String LABEL_PARENT_PURCHASE_COURSE_TITLE = "Parent.purchase.course.title";
	public static final String LABEL_PARENT_VIEW_COURSE_FILTER = "parent.view.course.Filter";
	public static final String LABEL_PARENT_CONTENT_CANNOT_VIEWED = "parent.content.cannot.viewed";
	public static final String PARENT_LINK_COPIED_TEXT = "parent.link.copied.successful.text";
	public static final String PARENT_VIEW_CONTENT_TALK_TO_TUTOR = "parent.viewcontent.talk.to.tutor.chats";
	/* Student side Buy course */
	public static final String LABEL_STUDENT_PURCHASE_COURSE_FILTER = "student.purchase.course.Filter";
	public static final String LABEL_STUDENT_PURCHASE_COURSE_TITLE = "student.purchase.course.title";
	public static final String LABEL_STUDENT_PURCHASE_COURSE_WITH_SHIPMENT_TITLE = "student.purchase.course.shipment.title";
	public static final String LABEL_STUDENT_PURCHASE_COURSE_WITH_COUPON_TITLE = "student.purchase.course.coupon.title";
	public static final String LABEL_STUDENT_PURCHASE_COURSE_WITH_INSTALLMENT_TITLE = "student.purchase.course.installment.title";
	public static final String LABEL_STUDENT_PURCHASE_COURSE_WITH_FIRST_INSTALLMENT_TITLE = "CouponTesting Course";
	public static final String LABEL_COURSE_WITH_INSTALLMENT_TITLE = "student.course.installment.title";
	public static final String LABEL_COURSE_WITHOUT_INSTALLMENT_TITLE = "student.course.without.installment.title";
	public static final String LABEL_TESTING_COURSE_TITLE = "student.testing.course.title";
//	public static final String LABEL_COURSE_WITH_PAID_FIRST_INSTALLMENT_TITLE="student.course.paid.first.installment.title";
	public static final String LABEL_PRICE_SUMMARY_HEADING = "course.price.summary.heading";
	public static final String PAYMENT_STATUS_SUCCESS_TEXT = "student.purchase.course.payment.success.status";
	public static final String STUDENT_FULL_NAME_FOR_SHIPMENT_COURSE = "student.full.name.shipment.course";
	public static final String STUDENT_ADDRESS_FOR_SHIPMENT_COURSE = "student.address.shipment.course";
	public static final String STUDENT_ADDRESS2_FOR_SHIPMENT_COURSE = "student.address2.shipment.course";
	public static final String STUDENT_LANDMARK_FOR_SHIPMENT_COURSE = "student.landmark.shipment.course";
	public static final String STUDENT_CITY_FOR_SHIPMENT_COURSE = "student.city.shipment.course";
	public static final String STUDENT_STATE_FOR_SHIPMENT_COURSE = "student.state.shipment.course";
	public static final String STUDENT_PINCODE_FOR_SHIPMENT_COURSE = "student.pincode.shipment.course";
	public static final String STUDENT_MOBILE_NUMBER_FOR_SHIPMENT_COURSE = "student.mobile.number.shipment.course";
	public static final String LABEL_STUDENT_AlREADY_PURCHASED_COURSE_TITLE = "student.already.purchased.course.title";
	public static final String LABEL_STUDENT_PURCHASE_SECOND_COURSE_TITLE = "student.purchase.second.course.title";
	public static final String LABEL_COURSE_PAY_ALL_INSTALLMENT_TITLE = "student.course.pay.all.installment.title";
	public static final String LABEL_STUDENT_PURCHASED_COURSE_TEXT = "label.student.purchased.course.text";
	/* Student side View course */
	public static final String LABEL_STUDENT_VIEW_COURSE_FILTER = "student.view.course.Filter";
	public static final String LABEL_STUDENT_CONTENT_CANNOT_VIEWED = "student.content.cannot.viewed";
	public static final String LABEL_STUDENT_CONTENT_CANNOT_VIEWED_ON_THE_WEB = "student.content.cannot.viewed.on.the.web";
	public static final String STUDENT_LINK_COPIED_TEXT = "student.link.copied.successful.text";
	public static final String STUDENT_VIEW_CONTENT_TALK_TO_TUTOR = "student.viewcontent.talk.to.tutor.chats";
	public static final String STUDENT_VIEW_CONTENT_SUMMARY = "student.view.content.summary";
	/* Faculty side Add content */
	public static final String LABEL_FACULTY_MYCOURSES = "faculty.mycourses.label";
	public static final String LABEL_ADD_FOLDER = "add.folder.text";
	public static final String LABEL_FACULTY_ADD_CONTENT = "facultyadd.content.label";
	public static final String SAVE_FOLDER_SUCCESSFULLY_TEXT = "content.added.successfully.text";
	public static final String LABEL_EDIT_FOLDER = "edit.folder.text";
	public static final String FOLDER_EDITED_SUCCESSFULLY_TEXT = "Content.edited.Successfully.text";
	public static final String DELETE_FOLDER_TEXT = "delete.folder.text";
	public static final String LABEL_ADD_VIDEO_HEADING = "add.video.heading.text";
	public static final String CONTENT_DELETED_SUCCESSFULLY_TEXT = "Content.deleted.Successfully.text";
	public static final String LABEL_ADD_SUBJECTIVETEST = "add.subjectivetest.text";
	public static final String LABEL_CREATE_SUBJECTIVETEST = "create.subjectivetest.label";
	public static final String SUBJECTIVETEST_UPLOADED_SUCCESSFULLY_TEXT = "subjectivetest.uploaded.Successfully";
	public static final String LABEL_ADD_DOCUMENT = "add.document.label";
	public static final String ADD_DOCUMENT_SUCCESSFULLY_TEXT = "content.added.successfully.text";
	public static final String LABEL_ADD_IMAGE = "add.Image.label";
	public static final String IMAGE_ADDED_SUCCESSFULLY_TEXT = "content.added.successfully.text";
	public static final String EDIT_SUCCESSFUL_TEXT = "edit.Successfully.text";
	public static final String LABEL_EDIT_HEADING = "edit.folder.text";
	public static final String LABEL_ADD_ZIPFILE = "add.zipfile.label";
	public static final String ZIPFILE_SAVE_SUCCESSFULLY_TEXT = "zipfile.saved.Successfully.text";
	public static final String LANG_RESOURCES_FILE_PATH = "src/main/resources/lang";
	public static final String TEST_DATA_PROPERTIES = "testdata_en.properties";
	public static final String EXPECTED_ASSERTIONS_PROPERTIES = "expectedassertions_en.properties";
	public static final String LANG_XPATHS_PROPERTIES = "xpaths_en.properties";
	// Language xPaths constants
	public static final String LOGIN_PAGE_BTN_PROCEED_XPATH = "loginpage.btn.proceed.secure.xpath";
	// DashBoard constants
	public static final String TUTOR_DASHBOARD_TEST_EXPORT_POPUP = "tutor.dashboard.test.export.popup";
	public static final String TUTOR_DASHBOARD_TEST_EXPORT_POPUP_2 = "tutor.dashboard.test.export.popup.2";
	/* Student Overview */
	public static final String STUDENT_OVERVIEW_TEST_CONTAINS_OFFLINE_STUDY_MATERIAL = "student.overview.test.contains.offline.study.material";
	public static final String STUDENT_OVERVIEW_TEST_TENATIVE_DELIVERY = "student.overview.test.tenative.delivery";
	// Course Overview Constants
	public static final String LABEL_COURSE_OVERVIEW_TESTING_COURSE_TITLE = "course.overview.testing.course.title";
	public static final String LABEL_COURSE_PRICE_IN_PRICE_DETAILS = "label.course.price.in.price.details";
	public static final String LABEL_COURSE_PRICE_GST = "label.course.price.gst";
	public static final String LABEL_INTERNET_FEES_IN_PRICE_DETAILS = "label.internet.fees.in.price.details";
	public static final String LABEL_AMOUNT_PAYABLE_IN_PRICE_DETAILS = "label.amount.payable.in.price.details";

	// Faculty notAdded in any course
	public static final String NOT_YET_ADDED_IN_ANY_COURSE_MESSAGE = "not.yet.added.in.any.course.message";
	public static final String FACULTY_HEADER_LABEL = "faculty.header.label";
	public static final String LIVE_CLASS_DETAILS_HEADER = "live.class.details.header";
	public static final String WHATSAP_URL = "whatsap.url";
	public static final String FACEBOOK_URL = "facebook.url";
	public static final String TELEGRAM_URL = "telegram.url";
	public static final String LINKDIN_URL = "linkden.url";
	/* Physical Material for shipment */
	public static final String TUTOR_DUMMY_CREATE_COURSE_NAME = "tutor.dummy.create.course.name";
	public static final String TUTOR_DUMMY_COURSE_PRICE = "tutor.dummy.course.price";
	public static final String STUDENT_ADDRESS_COURSE = "student.address.course";
	public static final String STUDENT_ADDRESS_DESCRIPTION = "student.address.dscription";
	public static final String STUDENT_FULL_NAME_SHIPMENT_COURSE = "student.full.name.shipment.course";
	public static final String STUDENT_ADDRESS_SHIPMENT_COURSE = "student.address.shipment.course";
	public static final String STUDENT_ADDRESS2_SHIPMENT_COURSE = "student.address2.shipment.course";
	public static final String STUDENT_LANDMARK_SHIPMENT_COURSE = "student.landmark.shipment.course";
//	public static final Stringstudent.city.shipment.course=Jaipur
//	public static final Stringstudent.state.shipment.course=Rajasthan 
//	public static final Stringstudent.mobile.number.shipment.course=9999888877 
//	public static final Stringstudent.pincode.shipment.course=111222 
	public static final String STUDENT_FULL_ADDRESS_PHYSICAL_SHIPMENT_COURSE = "student.full.address.physical.shipment.course";
	/* Notification */
	public static final String URL_WHATSAPP = "url.whatsapp";
	public static final String NOTIFICATION_SENT = "success.message.notification.sent";
	public static final String NOTIFICATION_DELETE = "success.message.notification.delete";
	public static final String NOTIFICATION_EDIT = "success.message.notification.edit";
	public static final String LABEL_CREATENOTIFICATION_PRE_TITLE_FOR_AUTOMATION_TESTING = "label.createnotification.pre.title.for.automation.testing";
	public static final String LABEL_CREATENOTIFICATION_PRE_DESCRIPTION_FOR_AUTOMATION_TESTING = "label.createnotification.pre.desciption.for.automation.testing";
	public static final String LABEL_EDITNOTIFICATION_PRE_TITLE_FOR_AUTOMATION_TESTING = "label.editnotification.pre.title.for.automation.testing";
	public static final String LABEL_EDITNOTIFICATION_PRE_DESCRIPTION_FOR_AUTOMATION_TESTING = "label.editnotification.pre.desciption.for.automation.testing";

	/* TUTOR SIDE NEW WEBSITE ASSERTIONS */
	/* Student pdf course */
	public static final String STUDENT_SEARCH_PDF_COURSE = "student.search.pdf.course";
	public static final String LABEL_TALK_TO_TUTOR = "label.talk.to.tutor";
	public static final String STUDENT_PAY_GET_COURSE = "student.pay.get.course";
	public static final String LABEL_STUDENT_PAY_GET_COURSE = "label.student.get.course";

	public static final String STUDENT_INSTALL_COURSE = "student.install.course";
	public static final String LABEL_STUDENT_INSTALL_COURSE = "label.studdent.install.course";
	public static final String LABEL_PAYMENT_FAILED_HEADING = "label.payment.failed";
	public static final String INPUT_CARD_NUMBER = "input.card.number";
	public static final String INPUT_CARD_EXPIRY = "input.card.expiry";
	public static final String INPUT_CARD_CVV = "input.card.cvv";
	public static final String LABEL_LOCKED_COURSE = "label.locked.course.header";
	public static final String LABEL_CREATECOURSE_WITH_PHYSICAL_SHIPMENT = "label.physical.shipment.course";
	public static final String LABEL_STUDENT_SHIPMENT_COURSE = "txt.shipment.course";
	public static final String LABEL_CREATECOURSE_WITH_COUPON_TESTING = "txt.coupon.course";
	public static final String LABEL_STUDENT_COUPON_COURSE = "txt.student.coupon.course";
	public static final String TXT_SEARCH_COUPON = "txt.search.coupon.apply";
	public static final String LABEL_COUPON_APPLIED_MESSAGE = "message.copon.applied";
	public static final String TXT_FULL_NAME = "txt.full.name";
	public static final String TXT_ADDRESS = "txt.address";
	public static final String TXT_ALTERNATIVE_ADDRESS = "txt.alternative.address";
	public static final String TXT_CITY = "txt.city";
	public static final String TXT_PIN = "txt.pin";
	public static final String TXT_MOBILE = "txt.mobile";
	public static final String COUPONCODE_STUDENT_SEARCH_COURSE = "student.couponcode.search.course";

	public static final String CREATE_INSTALLMENT_EDIT_MAX_TOTALINSTALLMENT = "create.installment.edit.max.totalinstallment";
	public static final String MESSAGE_MAX12_INSTALMENT = "message_max12_instalment";
	public static final String SET_EDIT_INSTALLMENT = "set_edit_installment";
	public static final String CREATE_INSTALLMENT_EDIT_LAST_TOTALINSTALLMENT = "create.installment.edit.lastinstallment";
	public static final String SET_EDIT_FIRST_INSTALLMENT = "set_edit_first_installment";
	public static final String NUMBER_OF_ZERO_INSTALLMENTS = "number.of.zero.installments";
	public static final String NUMBER_OF_TOTAL_INSTALLMENTS = "number.of.maximum.installments";
	public static final String MESSAGE_ZERO_INSTALMENT = "message.zero.instalment";
	public static final String TUTOR_PAYMENT_AUTOMATION_TESTING = "tutor.payment.course";
	public static final String TUTOR_PHYSICAL_AUTOMATION_TESTING = "tutor.physical.automation.testing";
	public static final String TUTOR_DELETE_COURSE = "course.deleted.successfully";
	public static final String GET_COURSE = "get.pending.course";
	public static final String LABEL_PAYMENT_DETAILS = "label.payment.details";
	public static final String LABEL_COLOR = "label.green.color";
	public static final String MESSAGE_MONTHLY_PERIOD = "message.monthly.period";
	public static final String INSTALLMENT_PERIOD_LIST = "installment.period.list";
	public static final String MESSAGE_INTRODUCING_INSTALLMENT = "message.introducing.installment";
	public static final String MESSAGE_EDIT_SUCCESSFULL = "message.edit.successfull";
	public static final String TUTOR_EFFECTIVEPRICE_AUTOMATION_TESTING = "tutor.effectiveprice.automation.testing";
	public static final String MESSAGE_EFFECTIVEPRICE_INFORMATION = "message.effectiveprice.information";
	/* TUTOR SIDE TRIAL CLASS */
	public static final String TRIAL_CLASSES_TITLE = "trial.classes.title";
	public static final String LABEL_HOW_IT_WORKS = "label.how.it.works";
	public static final String LABEL_NOT_PURCHASED = "label.not.purchased";
	public static final String LABEL_NEWAPP_DOWNLOADS = "label.newapp.downloads";
	public static final String LABEL_DESKTOP_VIEW = "label.desktop.view";
	public static final String TXT_SEARCH_TRIAL_COURSE = "search.trial.course";
	public static final String TXT_SEARCH_COURSE = "txt.search.course";
	public static final String MSG_ERROR_TOPIC_TOAST = "msg.error.topic.toast";
	public static final String TRIAL_CLASS_TOPIC_TEXT = "trial.class.topic.text";
	public static final String LABEL_UPTO_TEN_DAYS_DOWNLOAD = "label.upto.ten.days.download";
	public static final String LABEL_SCHEDULE_SUCCESS_TEXT = "label.schedule.success.text";
	public static final String LABEL_COMPOSE_NOTIFICATION_TEXT = "label.compose.notification.text";
	public static final String LABEL_LANDING_COURSE_TEXT = "label.landing.course.text";
	public static final String TXT_OVERVIEW_TRIAL_TOPIC = "txt.overview.trial.topic";
	public static final String TXT_OVERVIEW_TRIAL = "txt.overview.trial";
	public static final String TXT_OVERVIEW_SCHEDULED = "txt.overview.scheduled";
	public static final String MSG_DELETE_TRIAL_TOPIC = "msg.delete.trial.topic";
	public static final String TRIAL_CLASS_EDIT_TOPIC_TEXT = "trial.class.edit.topic.text";
	public static final String MSG_UPDATE_TRIAL_TOPIC = "msg.update.trial.topic";
	public static final String LABEL_SELECT_STUDENTS = "label.select.students";
	public static final String TXT_VIEWALL_CLASSES = "txt.viewall.classes";
	public static final String TXT_TAKE_CLASSES = "txt.take.classes";
	public static final String TXT_START_LIVE_CLASSES = "txt.start.live.classes";
	public static final String LBL_FACULTY_CLASSES = "lbl.faculty.classes";
	public static final String LBL_GET_COURSE = "lbl.get.course";
	public static final String LBL_TAKE_TRIAL = "lbl.take.trial.class";
	public static final String LBL_SCHEDULED_TRIAL = "lbl.scheduled.trial";
	/* TUTOR SIDE NEW WEBSITE */
	public static final String TUTOR_NEWWEBSITE_AUTOMATION_TESTING = "tutor.newwebsite.automation.testing";
	public static final String LEARNING_LIGHT_LABEL = "learning.light.label";
	public static final String NEW_TUTOR_COURSE_NAME_LABEL = "new.tutor.course.name.label";
	public static final String AVAILABLE_OFFERS_LABEL = "available.offers.label";
	public static final String COUPON_AVAILABLE_LABEL = "coupon.available.label";
	public static final String VIEW_ALL_AVAILABLE_OFFERS_LABEL = "view.all.available.offers.label";
	public static final String GET_THIS_COURSE_LABEL = "get.this.course.label";
	public static final String CONTACT_US_LABEL = "contact.us.label";
	public static final String QUERY_LABEL = "query.label";
	public static final String CONTENT_AND_OVERVIEW_LABEL = "content.and.overview.label";
	public static final String APPLY_COUPON_HEADER = "apply.coupon.header";
	public static final String APPLIED_SUCCESSFULLY_TEXT = "applied.successfully.text";
	public static final String QUERY_SUBMITTED_SUCCESSFULLY_MESSAGE = "query.submitted.successfully.message";
	public static final String NEW_TUTOR_FILL_DETAILS_HEADER = "new.tutor.fill.details.header";
	public static final String COURSE_NAME_lABEL = "course.name.label";
	public static final String NEW_TUTOR_FREE_CONTENT_COURSE = "new.tutor.free.content.course";
	public static final String NEW_TUTOR_INVALID_COUPON_MESSAGE = "new.tutor.invalid.coupon.message";
	public static final String NEW_TUTOR_NO_CONTENT_MESSAGE = "new.tutor.no.content.message";
	public static final String NEW_TUTOR_NO_RESULTS_MESSAGE = "new.tutor.no.results.message";
	public static final String NEW_TUTOR_GOOGLE_PLAY_LABEL = "new_tutor.google.play.label";
	public static final String NEW_TUTOR_LEARNING_LIGHT_APP_LABEL = "new.tutor.learning.light.app.label";
	public static final String NEW_TUTOR_AVAILABLE_FOR_IPHONE_AND_IPAD_LABEL = "new.tutor.available.for.iphone.and.ipad.label";
	public static final String NEW_TUTOR_APP_STORE_LABEL = "new.tutor.app.store.label";

	/* TUTOR SIDE NEW WEBSITE TEST DATA */
	public static final String NEW_TUTOR_SEARCH_IN_VALID_COUPON = "new.tutor.search.in.valid.coupon";
	public static final String NEW_TUTOR_SEARCH_COUPON = "new.tutor.search.coupon";
	public static final String SET_NAME_IN_ADDRESS = "set.name.in.address";
	public static final String SET_STATE_NAME_IN_ADDRESS = "set.state.name.in.address";
	public static final String SET_EMAIL_IN_ADDRESS = "set.email.in.address";
	public static final String NEW_TUTOR_SEARCH_COURSE = "new.tutor.search.course";
	public static final String NEW_TUTOR_SEARCH_VALID_COURSE = "new.tutor.search.valid.course";
	public static final String NEW_TUTOR_SEARCH_VALID_COURSES = "new.tutor.search.valid.courses";	
	public static final String NEW_TUTOR_SEARCH_COURSE_WITH_INVALID_COURSE = "new.tutor.search.course.with.invalid.course";
	public static final String NAME_IN_CONTACTUS = "name.in.contactus";
	public static final String MOBILE_NUMBER_IN_CONTACTUS = "mobile.number.in.contactus";
	public static final String MESSAGE_IN_CONTACTUS = "message.in.contactus";
	public static final String NEW_TUTOR_TERMS_CONDITIONS = "new.tutor.terms.conditions";
	public static final String NEW_TUTOR_BUY_LOCK_LABEL = "new.tutor.buy.lock.label";
	public static final String NEW_TUTOR_LOCKED_CONTENT_ACCESS_LABEL = "new.tutor.locked.content.access.label";

	/* TUTOR ADDING STUDENTS */
	public static final String TUTOR_STUDENT_ADDING_COURSE_TESTING = "tutor.student.adding.course.testing";
	public static final String LABEL_STUDENT_ADDED_MANUALLY = "label.student.added.manually";
	public static final String LABEL_STUDENT_ADDED_REGISTERED = "label.student.added.registered";
	public static final String LABEL_STUDENT_ADDED_CSV = "label.student.added.csv";
	public static final String TXT_ADD_STUDENT_NAME = "txt.add.student";
	public static final String TXT_ADD_STUDENT_NUMBER = "txt.add.student.number";
	public static final String TXT_ADD_STUDENT_EMAIL = "txt.add.student.email";
	public static final String TXT_ADD_SECOND_STUDENT_NAME = "txt.add.second.student";
	public static final String TXT_ADD_SECOND_STUDENT_NUMBER = "txt.add.second.student.number";
	public static final String TXT_ADD_SECOND_STUDENT_EMAIL = "txt.add.student.second.email";
	public static final String LABEL_COURSE = "label.course";
	public static final String LABEL_STUDENT_ADDED_HEADER = "label.student.added.header";
	public static final String MSG_EMAIL_ERROR = "msg.email.error";
	public static final String LABEL_ADD_STUDENT = "label.add.student";
	public static final String LBL_UPLOAD_CSV = "lbl.upload.csv";
	public static final String LBL_UPLOADED_CSV = "lbl.uploaded.csv";
	public static final String LABEL_PAY_WALLET = "lbl.pay.wallet";
	public static final String LBL_EFFECTIVE_PRICE = "lbl.effective.price";
	public static final String LBL_DUPLICATE_EMAIL = "lbl.duplicate.email";
	public static final String LBL_THIRDROW_DUPLICATE = "lbl.thirdrow.duplicate";
	public static final String LBL_DUPLICATE_CONTACT = "lbl.duplicate.contact";
	public static final String LBL_INVALID_CONTACT = "lbl.invalid.contact";
	public static final String LBL_INVALID_FAIL_STUDENT = "lbl.invalid.fail.student";
	public static final String LBL_REUPLOAD_CSV = "lbl.reupload.csv";
	public static final String LBL_PROCEED_PAYMENT = "lbl.proceed.payment";
	public static final String LBL_UPLOAD_CSV_FORMAT = "lbl.upload.csv.format";
	public static final String LBL_FAIL_ADD_STUDENT = "lbl.fail.add.student";
	public static final String MSG_SUUCCESS_UPLOADED_STUDENT = "msg.suuccess.uploaded.student";
	public static final String LABEL_EFFECTIVE_PRICE = "label.effective.price";
	public static final String LBL_SUBSCRIBED_STUDENT = "lbl.subscribed.student";
	public static final String LBL_TRANSACTIONS = "label.transactions";
	public static final String LBL_TAX_INVOICE = "lbl.tax.invoice";
	public static final String LBL_CHATS = "lbl.chats";
	public static final String LBL_INVOICE = "lbl.invoice";
	/* TUTOR SORT/FILTER COURSES */
	public static final String LABEL_SORT_FILTER_LIST = "label.sort.filter.list";
	public static final String LABEL_COURSES_SORT_FILTER_LIST = "label.courses.sort.filter.list";
	public static final String LABEL_COURSE_STATUS_SORT_FILTER_LIST = "label.course.status.sort.filter.list";
	public static final String LABEL_COURSE_SORT_AND_ORDER_LIST = "label.course.sort.and.order.list";
	public static final String SEARCH_SPECIAL_CHARACTERS = "search.special.characters";
	public static final String SEARCH_MAX_CHARACTERS = "search.max.characters";
	public static final String SEARCH_INVALID_DATA = "search.invalid.data";

}
